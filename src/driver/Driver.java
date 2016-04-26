package driver;

import control.controller1;
import model.AplikasiKonsol;

public class Driver {
    public static void main(String[] args) {
        
        AplikasiKonsol ap = new AplikasiKonsol();
        new controller1(ap);
        
    }   
}
