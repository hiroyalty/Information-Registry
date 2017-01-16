package simpleregister;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sean
 */
public class Information {

    private Map<String, List<String>> personPhones;
    private Map<String, List<Address>> personAddress;

    public Information() {
        this.personPhones = new HashMap<String, List<String>>();
        this.personAddress = new HashMap<String, List<Address>>();
    }

    public void addPersonPhone(String newPerson, String personPhoneNumb) {
        if (!(this.personPhones.containsKey(newPerson))) {
            this.personPhones.put(newPerson, new ArrayList<String>());
            //this.personPhones.get(newPerson).add(personPhoneNumb);
        }
//        if (!this.personPhones.containsKey(newPerson.getName())) {
//            this.personPhones.put(newPerson.getName(), new ArrayList<String>());
//        }
        personPhones.get(newPerson).add(personPhoneNumb);
    }

    public void addPersonAddress(Person newPerson) {
        if (!this.personAddress.containsKey(newPerson.getName())) {
            this.personAddress.put(newPerson.getName(), new ArrayList<Address>());
        }
        personAddress.get(newPerson.getName()).add(newPerson.getPersonAddress());
    }

    public String searchForAPhoneNumber(String personName) {
        List<String> phoneList = new ArrayList<String>();
        phoneList = this.personPhones.get(personName);
        //return phoneList.toString();
        String dPhone = "";
        for (String onePhone : phoneList) {
            dPhone += onePhone + "\n";
        }
        return dPhone;
    }

    public String searchPersonByPhoneNumber(String phone) {
        String dPersonName = "";
        for (String aPersonName : personPhones.keySet()) {
            if (personPhones.get(aPersonName).contains(phone)) {
                //return aPersonName;
                dPersonName = aPersonName;
            }
        }
        return dPersonName;
    }

    public String searchForPersonalInformation(String personName) {
        String dAddress = "";
        String prePhone = "";
        try {
            List<Address> addressList = new ArrayList<Address>();
            addressList = this.personAddress.get(personName);

            if (!(addressList.isEmpty())) {
                dAddress = "address: ";
            }
            for (Address oneAddress : addressList) {
                dAddress = dAddress + oneAddress.toString() + "\n";
            }
        } catch (NullPointerException e) {
            dAddress = "address unknown";
        }
        
        try {
            List<String> phoneList = new ArrayList<String>();
            phoneList = this.personPhones.get(personName);
            //return phoneList.toString();
            prePhone = "phone numbers: " + "\n";
            //if (!(phoneList.isEmpty())) {
                for (String onePhone : phoneList) {
                    prePhone += onePhone + "\n";
                //}
            //} else {
                //prePhone = "phone number not found";
            }
        } catch (NullPointerException e) {
            prePhone = "phone number not found";
            //System.out.println("null pointer");
        }
        if (dAddress.equals("address unknown") && prePhone.equals("phone number not found")) {
            dAddress = "not found";
        } else {
            dAddress = dAddress + "\n" + prePhone;
        }

        return dAddress;
    }

    public void deletePersonalInformation(String personName) {
        this.personPhones.remove(personName);
        this.personAddress.remove(personName);
    }

    public String fileteredListing(String keyWord) {
        //List<Address> search = new ArrayList<Address>();
        String aPerson = "";
        String addy = "";
        boolean addys = false;
        try {
            for (String aPersonName : personPhones.keySet()) {
                if (aPersonName.contains(keyWord)) {
                    //get the person and then its values
                    //aPerson += this.printPersonPhoneInfo(aPersonName);
                    aPerson += aPersonName + "\n" + this.searchForPersonalInformation(aPersonName);
                } else {
                    //get the person and its values
                    for (String keyPhone : personPhones.get(aPersonName)) {
                        if (keyPhone.contains(keyWord)) {
                            aPerson += aPersonName + "\n" + this.searchForPersonalInformation(aPersonName);
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            aPerson = "not found";
        }
        //get person address details and add it to the string. Map<String, List<Address>>
        try {
            for (Map.Entry<String, List<Address>> e : personAddress.entrySet()) {
                String key = e.getKey();
                List<Address> valueListAddress = e.getValue();
                addys = gtPersonAddressInfo(valueListAddress, keyWord);
                if(addys || key.contains(keyWord)){
                    addy += key + "\n" + this.searchForPersonalInformation(key);
                }
            }
        } catch (NullPointerException r) {
            addy = "address unknown";
        }
        if ((aPerson.equals("not found") || aPerson == null || aPerson.isEmpty()) && (addy.equals("address unknown") || addy == null  || addy.isEmpty())) {
            aPerson = "not found";
            addy = "";
        }
        return aPerson + "\n" + addy;
    }

    public String printPersonPhoneInfo(String personName) {
        String namePhone = personName;
        String prePhone = "";
        try {
            List<String> phoneList = new ArrayList<String>();
            phoneList = this.personPhones.get(personName);
            prePhone = "phone numbers: " + "\n";
            if (!(phoneList.isEmpty())) {
                for (String onePhone : phoneList) {
                    prePhone = onePhone + "\n";
                }
            } else {
                prePhone = "phone number not found";
            }
        } catch (NullPointerException e) {
            prePhone = "phone number not found";
        }
        namePhone = namePhone + "\n" + prePhone;
        return namePhone;
    }

    //return all the address inside the address list belonging to keyword(person name or address)
    public boolean gtPersonAddressInfo(List<Address> aPersonAddressesList, String keyw) {
        boolean preAddress = false;
        try {
            for (Address oneAddress : aPersonAddressesList) {
                if (oneAddress.toString().contains(keyw)) {
                    //preAddress = preAddress + oneAddress.toString() + "\n";
                    preAddress = true;
                    break;
                }
            }
        } catch (NullPointerException e) {
            preAddress = false;
        }
        return preAddress;
    }
}
