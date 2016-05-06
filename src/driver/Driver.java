package driver;

import control.controller;
import model.aplikasi;

public class Driver {
    public static void main(String[] args) {
        
        aplikasi ap = new aplikasi();
        new controller(ap);
        
    }   
}
