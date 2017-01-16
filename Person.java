/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleregister;
/**
 *
 * @author sean
 */
public class Person {
    private String name;
    private String phoneNumber;
    private Address personAddess;
    
    public Person(){
        
    }
    public Person(String pName,String pNumber){
        this.name = pName;
        this.phoneNumber = pNumber;
    }
    public Person(String pName, Address pAddress){
        this.name = pName;
        this.personAddess = pAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        if(phoneNumber == null){
            return "number not found";
        }
        return phoneNumber;
    }
    
    public Address getPersonAddress() {
        if(personAddess == null){
            return null;
        }
        return personAddess;
    }
    
    public String getPersonAddressString() {
        if(personAddess == null){
            return "not found";
        }
        return personAddess.toString();
    }
    
    public String personInfo(){
        return this.getPersonAddressString()+"\n"+this.getPhoneNumber();
    }
    
    
}
