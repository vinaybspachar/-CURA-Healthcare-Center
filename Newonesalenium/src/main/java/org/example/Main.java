package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Step 1: Booking Appointment ===");
        Seleniumone opt = new Seleniumone();
        opt.bookAppointment();

        System.out.println("\n=== Step 2: Viewing Appointment ===");
        ViewAppointment view = new ViewAppointment();
        view.checkAppointment();
    }

}