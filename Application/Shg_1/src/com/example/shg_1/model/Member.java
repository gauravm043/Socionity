package com.example.shg_1.model;



public class Member {
	private String phone_number;
	private int id;
    private String name;
    private String address;
 
    public Member(){}
 
    public Member(String phone_number,String name, String address) 
    {
        super();
        this.phone_number=phone_number;
        this.name = name;
        this.address = address;
    }
 
    //getters & setters
    public String getPhone_number()
    {
    	return this.phone_number;
    }
    public String getName()
    {
    	return this.name;
    }
    public String getAddress()
    {
    	return this.address;
    }
    public int getId()
    {
    	return this.id;
    }
 
    
    // Defining Setters
    
    public void setPhone_number(String x)
    {
    	this.phone_number=x;
    }
    public void setName(String n)
    {
    	this.name=n;
    }
    public void setAddress(String a)
    {
    	this.address=a;
    }
    public void setId(int i)
    {
    	this.id=i;
    }
    
    
    
    
    
    @Override
    public String toString() {
        return "Member [id="+id+",phone_number=" + phone_number + ", name=" + name + ", address=" + address
                + "]";
    }

}
