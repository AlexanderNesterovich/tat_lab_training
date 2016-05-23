package by.training.bean;

import java.util.Date;

/**
 * Created by Alexander Nesterovich on 20.05.2016.
 */
public class CreditCard {

    private int id;
    private long number;
    private Date expire;
    private User user;
    private CreditCardType type;

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

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CreditCardType getType() {
        return type;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }

}
