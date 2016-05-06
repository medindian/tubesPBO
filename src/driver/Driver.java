package driver;

import control.controller1;
import model.aplikasi;

public class Driver {
    public static void main(String[] args) {
        
        aplikasi ap = new aplikasi();
        new controller1(ap);
        
    }   
}
