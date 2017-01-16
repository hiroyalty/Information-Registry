package simpleregister;


import simpleregister.Information;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sean
 */
public class UserInterface {

    private Scanner reader;
    private Information allInfo;

    public UserInterface(Scanner reader, Information allInfo) {
        this.reader = reader;
        this.allInfo = allInfo;
    }

    public void start() {
        this.prepare();

        while (true) {
            System.out.print("command: ");
            String command = reader.nextLine();
            //System.out.println(command);
            //break;
            if (command.equals("1")) {
                System.out.print("whose number: ");
                String pName = reader.nextLine();
                System.out.print("number: ");
                String pNumber = reader.nextLine();
                //this.allInfo.addPersonPhone(new Person(pName, pNumber));
                this.allInfo.addPersonPhone(pName, pNumber);
                System.out.println("");
            } else if (command.equals("2")) {
                System.out.print("whose number: ");
                String pName = reader.nextLine();
                try {
                    String phoneNum = this.allInfo.searchForAPhoneNumber(pName);
                    System.out.println(phoneNum+"\n");
                } catch (NullPointerException e) {
                    System.out.println("not found"+"\n");
                }
            } else if (command.equals("3")) {
                System.out.print("number: ");
                String pNumber = reader.nextLine();               
                try {
                    String pName = this.allInfo.searchPersonByPhoneNumber(pNumber);
                    if(pName.isEmpty()){
                        System.out.println("not found"+"\n");
                    }
                    System.out.println(pName+"\n");
                } catch (NullPointerException e) {
                    System.out.println("not found"+"\n");
                }               
            } else if (command.equals("4")) {
                System.out.print("whose address: ");
                String pName = reader.nextLine();
                System.out.print("street: ");
                String pStreet = reader.nextLine();
                System.out.print("city: ");
                String pCity = reader.nextLine();
                this.allInfo.addPersonAddress(new Person(pName, new Address(pStreet, pCity)));
                System.out.println("");
            } else if (command.equals("5")) {
                System.out.print("whose information: ");
                String pName = reader.nextLine();
                try {
                    String fullInfo = this.allInfo.searchForPersonalInformation(pName);
                    System.out.println(fullInfo+"\n");
                } catch(NullPointerException e) {
                    System.out.println("not found"+"\n");
                }
            } else if (command.equals("6")) {
                System.out.print("whose information: ");
                String pName = reader.nextLine();
                this.allInfo.deletePersonalInformation(pName);
                System.out.println("");
            } else if (command.equals("7")) {
                System.out.print("keyword (if empty, all listed): ");
                String keyword = reader.nextLine();
                String res = this.allInfo.fileteredListing(keyword);
                if(res.isEmpty() || res==null){
                    res = "keyword not found";
                }
                System.out.println(res);
                System.out.println("");
            } else if (command.equals("x")) {
                break;
            } else {
                System.out.println("wrong entry, try again"+"\n");
            }
        }
    }

    public void prepare() {
        System.out.println("phone search");
        System.out.println("available operations");
        System.out.println("1 add a number");
        System.out.println("2 search for a number");
        System.out.println("3 search for a person by phone number");
        System.out.println("4 add an address");
        System.out.println("5 search for personal information");
        System.out.println("6 delete personal information");
        System.out.println("7 filtered listing");
        System.out.println("x quit");
    }
}
