package by.training;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */
public class Utils {

    private static BigDecimal epsilon; // based on desired precision
    private static BigDecimal natural_e;
    private static BigDecimal pi = new BigDecimal(3.14159265358979323846);
    private static BigDecimal twopi;
    private static BigDecimal halfpi;
    private static int prec  = 100; // digits
    private static int nbits = 332; // precision in bits = about 3.32 precision in digits

    public static BigDecimal factorial(BigDecimal n)
    {
        if(n.compareTo(new BigDecimal("1"))<=0) return new BigDecimal("1");
        return n.multiply(factorial(n.subtract(new BigDecimal("1"))));
    }

    public static BigDecimal sin(BigDecimal x) {
        BigDecimal y;
        BigDecimal xc;
        BigDecimal tpi = pi.multiply(new BigDecimal("2"));

        if (x.abs().compareTo(tpi) < 0) return sin_series(x);
        xc = x;
        if (xc.compareTo(new BigDecimal("0")) > 0) // positive
        {
            while (xc.compareTo(tpi) > 0) {
                xc = xc.subtract(tpi);
            }
            y = sin_series(xc);
            y = y.setScale(prec, BigDecimal.ROUND_DOWN);
            return y;
        } else // negative
        {
            while (xc.compareTo(tpi) < 0) {
                xc = xc.add(tpi);
            }
            y = sin_series(xc);
            return y.setScale(prec, BigDecimal.ROUND_DOWN);
        }
    } // end sin

    public static BigDecimal sin_series(BigDecimal x) // abs(x)<=0.5, prec digits
    {                                   // prec digits returned
        BigDecimal fact = new BigDecimal("1"); // factorial
        BigDecimal xp = x; // power of x
        BigDecimal y = x; // sum of series on x
        int n;

        n = (2 * prec) / 3;
        for (int i = 3; i < n; i = i + 2) {
            fact = factorial(new BigDecimal(i));
            fact = fact.setScale(prec, BigDecimal.ROUND_DOWN);
            xp = ((xp.multiply(x)).multiply(x)).negate();
            xp = xp.setScale(prec, BigDecimal.ROUND_DOWN);
            y = y.add(xp.divide(fact, BigDecimal.ROUND_DOWN));
        }
        y = y.setScale(prec, BigDecimal.ROUND_DOWN);
        return y;
    } // end sin_series

    //---------------------------------- custom sqrt bigdecimal algo
    public static BigDecimal bigSqrt(BigDecimal squarD, MathContext rootMC) throws ArithmeticException {
        // Static constants
        BigDecimal TWO = new BigDecimal(2);
        double SQRT_10 = 3.162277660168379332;


        // General number and precision checking
        int sign = squarD.signum();
        if (sign == -1)
            throw new ArithmeticException("\nSquare root of a negative number: " + squarD);
        else if (sign == 0)
            return squarD.round(rootMC);

        int prec = rootMC.getPrecision();           // the requested precision
        if (prec == 0)
            throw new IllegalArgumentException("\nMost roots won't have infinite precision = 0");

        // Initial precision is that of double numbers 2^63/2 ~ 4E18
        int BITS = 62;                              // 63-1 an even number of number bits
        int nInit = 16;                             // precision seems 16 to 18 digits
        MathContext nMC = new MathContext(18, RoundingMode.HALF_DOWN);


        // Iteration variables, for the square root x and the reciprocal v
        BigDecimal x = null, e = null;              // initial x:  x0 ~ sqrt()
        BigDecimal v = null, g = null;              // initial v:  v0 = 1/(2*x)

        // Estimate the square root with the foremost 62 bits of squarD
        BigInteger bi = squarD.unscaledValue();     // bi and scale are a tandem
        int biLen = bi.bitLength();
        int shift = Math.max(0, biLen - BITS + (biLen % 2 == 0 ? 0 : 1));   // even shift..
        bi = bi.shiftRight(shift);                  // ..floors to 62 or 63 bit BigInteger

        double root = Math.sqrt(bi.doubleValue());
        BigDecimal halfBack = new BigDecimal(BigInteger.ONE.shiftLeft(shift / 2));

        int scale = squarD.scale();
        if (scale % 2 == 1)                          // add half scales of the root to odds..
            root *= SQRT_10;                          // 5 -> 2, -5 -> -3 need half a scale more..
        scale = (int) Math.floor(scale / 2.);          // ..where 100 -> 10 shifts the scale

        // Initial x - use double root - multiply by halfBack to unshift - set new scale
        x = new BigDecimal(root, nMC);
        x = x.multiply(halfBack, nMC);                          // x0 ~ sqrt()
        if (scale != 0)
            x = x.movePointLeft(scale);

        if (prec < nInit)                 // for prec 15 root x0 must surely be OK
            return x.round(rootMC);        // return small prec roots without iterations

        // Initial v - the reciprocal
        v = BigDecimal.ONE.divide(TWO.multiply(x), nMC);        // v0 = 1/(2*x)


        // Collect iteration precisions beforehand
        ArrayList<Integer> nPrecs = new ArrayList<Integer>();

        assert nInit > 3 : "Never ending loop!";                // assume nInit = 16 <= prec

        // Let m be the exact digits precision in an earlier! loop
        for (int m = prec + 1; m > nInit; m = m / 2 + (m > 100 ? 1 : 2))
            nPrecs.add(m);


        // The loop of "Square Root by Coupled Newton Iteration" for simpletons
        for (int i = nPrecs.size() - 1; i > -1; i--) {
            // Increase precision - next iteration supplies n exact digits
            nMC = new MathContext(nPrecs.get(i), (i % 2 == 1) ? RoundingMode.HALF_UP :
                    RoundingMode.HALF_DOWN);

            // Next x                                                 // e = d - x^2
            e = squarD.subtract(x.multiply(x, nMC), nMC);
            if (i != 0)
                x = x.add(e.multiply(v, nMC));                          // x += e*v     ~ sqrt()
            else {
                x = x.add(e.multiply(v, rootMC), rootMC);               // root x is ready!
                break;
            }

            // Next v                                                 // g = 1 - 2*x*v
            g = BigDecimal.ONE.subtract(TWO.multiply(x).multiply(v, nMC));

            v = v.add(g.multiply(v, nMC));                            // v += g*v     ~ 1/2/sqrt()
        }

        return x;                        // return sqrt(squarD) with precision of rootMC
    }

    BigDecimal sqrt(BigDecimal x)
    {
        BigDecimal y = new BigDecimal("1");
        BigDecimal yn = y;
        BigDecimal xs = x.add(epsilon);
        for(int i=0; i<25; i++)
        {
            yn = (y.add(xs.divide(y,BigDecimal.ROUND_DOWN))).multiply(new BigDecimal("0.5"));
            yn = yn.setScale(nbits,BigDecimal.ROUND_DOWN);
            if(((yn.subtract(y)).abs()).compareTo(epsilon)<=0) return yn;
            y = yn;
        }
        return yn;
    }

    BigDecimal exp_series(BigDecimal x) // abs(x)<=0.5, prec digits
    {                                   // prec digits returned
        BigDecimal fact = new BigDecimal("1"); // factorial
        BigDecimal xp   = new BigDecimal("1"); // power of x
        BigDecimal y    = new BigDecimal("1"); // sum of series on x
        int n;

        n = (2*prec)/3;
        for(int i=1; i<n; i++)
        {
            fact = fact.multiply(new BigDecimal(i));
            fact = fact.setScale(prec,BigDecimal.ROUND_DOWN);
            xp   = xp.multiply(x);
            xp = xp.setScale(prec,BigDecimal.ROUND_DOWN);
            y = y.add(xp.divide(fact, BigDecimal.ROUND_DOWN));
        }
        y = y.setScale(prec,BigDecimal.ROUND_DOWN);
        System.out.println("exp_series x="+x);
        System.out.println("           y="+y);
        return y;
    }

    BigDecimal exp(BigDecimal x)
    {
        BigDecimal y = new BigDecimal("1.0");  // sum of series on xc
        BigDecimal xc;                         // x - j
        BigDecimal ep = natural_e;             // e^j
        BigDecimal j  = new BigDecimal("1");
        BigDecimal one = new BigDecimal("1.0");
        BigDecimal half = new BigDecimal("0.5");
        BigDecimal xp;                         // positive, then invert

        if(x.abs().compareTo(half) <0) return exp_series(x);
        if(x.compareTo(new BigDecimal("0"))>0) // positive
        {
            while(x.compareTo(j.add(one))>0)
            {
                ep = ep.multiply(natural_e);
                j = j.add(one);
            }
            xc = x.subtract(j);
            y = ep.multiply(exp_series(xc));
            y = y.setScale(prec,BigDecimal.ROUND_DOWN);
            return y;
        }
        else // negative
        {
            xp = x.negate();
            while(xp.compareTo(j.add(one))>0)
            {
                ep = ep.multiply(natural_e);
                j = j.add(one);
            }
            xc = xp.subtract(j);
            y = ep.multiply(exp_series(xc));
            y = y.setScale(prec,BigDecimal.ROUND_DOWN);
            return (one.add(epsilon)).divide(y, BigDecimal.ROUND_DOWN);
        }
    } // end exp

    BigDecimal atan(BigDecimal x)
    {
        // atan(x)=x - x^3/3 + x^5/5 - x^7/7 + x^9/9 ...
        BigDecimal f = new BigDecimal("1");
        BigDecimal y = x;
        y = y.setScale(prec,BigDecimal.ROUND_DOWN);
        BigDecimal xp = y; // x to power
        xp = xp.setScale(prec,BigDecimal.ROUND_DOWN);

        BigDecimal xs = xp.add(epsilon); // extended precision for divide
        xs = xs.setScale(prec,BigDecimal.ROUND_DOWN);
        BigDecimal t = epsilon;
        t = t.setScale(prec,BigDecimal.ROUND_DOWN);

        System.out.println("atan("+x+")");
        for(int i=3; i<prec; i=i+2)
        {
            xp = ((xp.multiply(x)).multiply(x)).negate();
            xp = xp.setScale(prec,BigDecimal.ROUND_DOWN);
            xs = xp.add(epsilon);
            xs = xs.setScale(prec,BigDecimal.ROUND_DOWN);
            f = new BigDecimal(i);
            t = xs.divide(f, BigDecimal.ROUND_DOWN);
            t = t.setScale(prec,BigDecimal.ROUND_DOWN);
            y = y.add(t);
            y = y.setScale(prec,BigDecimal.ROUND_DOWN);
            // System.out.println("i="+i+", t="+t);
            // System.out.println("i="+i+", y="+y);
            if((t.abs()).compareTo(epsilon)<=0) return y;
        }
        return y;
    }

    BigDecimal Npi()
    {
        BigDecimal sum = new BigDecimal("1");
        BigDecimal one = new BigDecimal("1");
        BigDecimal two = new BigDecimal("2");
        BigDecimal three = new BigDecimal("3");
        BigDecimal threen = new BigDecimal("3");
        BigDecimal denom = new BigDecimal("3");
        BigDecimal frac;
        BigDecimal twoRootThree;

        twoRootThree = two.multiply(sqrt(threen));
        one = one.setScale(prec,BigDecimal.ROUND_DOWN); // for divide

        for(int i=1; i<prec; i++) // prec digits, subtract, add  each iteration
        {
            frac = denom.multiply(threen);
            frac = frac.setScale(prec,BigDecimal.ROUND_DOWN);
            frac = one.divide(frac, BigDecimal.ROUND_DOWN);
            // System.out.println("1/frac="+frac);
            sum  = sum.subtract(frac);
            threen = threen.multiply(three);
            denom = denom.add(two);
            frac = denom.multiply(threen);
            frac = frac.setScale(prec,BigDecimal.ROUND_DOWN);
            frac = one.divide(frac, BigDecimal.ROUND_DOWN);
            sum = sum.add(frac);
            sum = sum.setScale(prec,BigDecimal.ROUND_DOWN);
            threen = threen.multiply(three);
            denom = denom.add(two);
        }
        sum = twoRootThree.multiply(sum);
        sum = sum.setScale(prec,BigDecimal.ROUND_DOWN);
        return sum;
    }

    BigDecimal naturalE(int prec_dig) {
        BigDecimal sum = new BigDecimal("1");
        BigDecimal fact = new BigDecimal("1");
        BigDecimal del = new BigDecimal("1");
        BigDecimal one = new BigDecimal("1");
        BigDecimal ten = new BigDecimal("10");
        int prec_bits = (prec_dig * 332) / 100;

        one = one.setScale(prec_dig, BigDecimal.ROUND_DOWN);
        for (int i = 0; i < prec_dig; i++) del = del.multiply(ten);
        for (int i = 1; i < prec_bits; i++) {
            fact = fact.multiply(new BigDecimal(i));
            fact = fact.setScale(prec_dig, BigDecimal.ROUND_DOWN);
            sum = sum.add(one.divide(fact, BigDecimal.ROUND_DOWN));
            if (del.compareTo(fact) < 0) break;
        }
        return sum.setScale(prec_dig, BigDecimal.ROUND_DOWN);
    }
}
