package by.training.bean;

import java.util.Date;

/**
 * Created by Alexander Nesterovich on 20.05.2016.
 */
public class CreditCard {

    private int id;
    private long number;
    private Date expire;
    private int userId;
    private CreditCardType type;

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public CreditCardType getType() {
        return type;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }

}
