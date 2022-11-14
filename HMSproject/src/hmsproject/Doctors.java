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
public class Doctors {
    private String doc_name;
    private String doc_surname;
    private String doc_spec;
    private String doc_status;
    

    public Doctors(String doc_name, String doc_surname, String doc_spec, String doc_status) {
        this.doc_name = doc_name;
        this.doc_surname = doc_surname;
        this.doc_spec = doc_spec;
        this.doc_status = doc_status;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public String getDoc_surname() {
        return doc_surname;
    }

    public String getDoc_spec() {
        return doc_spec;
    }

    public String getDoc_status() {
        return doc_status;
    }
    
}
