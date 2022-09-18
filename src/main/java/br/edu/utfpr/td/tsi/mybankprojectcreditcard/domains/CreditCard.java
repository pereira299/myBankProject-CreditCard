package br.edu.utfpr.td.tsi.mybankprojectcreditcard.domains;


import java.util.Calendar;

public class CreditCard {
    private int id;
    private String number;
    private String name;
    private final Calendar expirationDate;
    private final String cvv;
    private int cardLevel;
    private int userId;
    private double limit;
    private double balance;

    public CreditCard(String number, String name, Calendar expirationDate, String cvv, int cardLevel) {
        this.number = number;
        this.name = name;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.cardLevel = cardLevel;
        this.balance = 0;
        switch (cardLevel) {
            case 1:
                this.limit = 900;
                break;
            case 2:
                this.limit = 1500;
                break;
            case 3:
                this.limit = 3000;
                break;
            case 4:
                this.limit = 5000;
                break;
            case 5:
                this.limit = 10000;
                break;
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public String getCvv() {
        return cvv;
    }


    public int getCardLevel() {
        return cardLevel;
    }

    public void setCardLevel(int cardLevel) {
        this.cardLevel = cardLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
