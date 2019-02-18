/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile.Personal1;

import java.sql.Date;

/**
 *
 * @author ^.^
 */
public class Personal {

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    
    private String fname;
    private String lName;
    private String sex;
    private String address;
    private String state;
    private String city;
    private String zipCode;
    private String email;
    private Date birthday;

    public Personal(String fname, String lName, String sex, 
            String address, String state, String city, String email) {
        this.fname = fname;
        this.lName = lName;
        this.sex = sex;
        this.address = address;
        this.state = state;
        this.city = city;
        this.email = email;
    }

    public Personal() {
        this.fname = "No input";
        this.lName = "No input";
        this.sex = "No input";
        this.address = "No input";
        this.state = "No input";
        this.city = "No input";
        this.email = "No input";
    }
    
    
    
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    @Override
    public String toString(){
        
        return "\nPersonal Information:"+
               "\n\tFirst Name: "+getFname()+
               "\n\tLast Neme: "+getlName()+
               "\n\tAddress: "+getAddress()+
               "\n\tnCity: "+getCity()+
               "\n\tState: "+getState()+              
               "\n\tSex: "+getSex()+
               "\n\tEmail: "+getEmail();
               //"\n\tBirthday: "+ getBirthday().toString();
    }
    
}
