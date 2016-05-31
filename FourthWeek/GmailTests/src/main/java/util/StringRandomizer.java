package util;

import java.time.ZonedDateTime;
import java.util.Random;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/30/2016.
 */
public class StringRandomizer {

    public static String generateString(int length)
    {
        String characters = "ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuwxyz";
        Random rng = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        ZonedDateTime zdt = ZonedDateTime.now();
        return new String(text) + zdt;
    }
}
