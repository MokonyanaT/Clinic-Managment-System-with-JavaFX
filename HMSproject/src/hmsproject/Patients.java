/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmsproject;

/**
 *
 * @author Tsiu
 */
public class Patients {
   private int id_num; 
   private String pat_name ;
   private String pat_surname;
   private String dob;
   private int phone;
   private String address;

    public Patients(int id_num, String pat_name, String pat_surname, String dob, int phone, String address) {
        this.id_num = id_num;
        this.pat_name = pat_name;
        this.pat_surname = pat_surname;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        
    }

    public int getId_num() {
        return id_num;
    }

    public String getPat_name() {
        return pat_name;
    }

    public String getPat_surname() {
        return pat_surname;
    }

    public String getDob() {
        return dob;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

   
}
