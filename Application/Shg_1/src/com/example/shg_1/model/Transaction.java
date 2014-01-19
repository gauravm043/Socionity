package com.example.shg_1.model;



public class Transaction {
	private String from;
	private int id;
    private String to;
    private String money;
    private String why;
 
    public Transaction(){}
 
    public Transaction(String from,String to, String money,String why) 
    {
        super();
        this.from=from;
        this.to =to;
        this.money = money;
        this.why = why;
    }
 
    //getters & setters
    public String getFrom()
    {
    	return this.from;
    }
    public String getTo()
    {
    	return this.to;
    }
    public String getMoney()
    {
    	return this.money;
    }
    public String getWhy()
    {
    	return this.why;
    }
    public int getId()
    {
    	return this.id;
    }
 
    
    // Defining Setters
    
    public void setFrom(String x)
    {
    	this.from=x;
    }
    public void setTo(String n)
    {
    	this.to=n;
    }
    public void setMoney(String a)
    {
    	this.money=a;
    }
    public void setWhy(String a)
    {
    	this.why=a;
    }
    public void setId(int i)
    {
    	this.id=i;
    }
    
    
    
    
    
    @Override
    public String toString() {
        return "Transaction [id="+id+",from=" + from + ", to=" + to + ", money=" + money + ",why=" + why
                + "]";
    }

}
