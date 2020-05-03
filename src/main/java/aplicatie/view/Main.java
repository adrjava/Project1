package aplicatie.view;

import aplicatie.controller.MainController;
import aplicatie.model.Angajat;

public class Main {
    public static void main(String[] args) {
         MainController mainController = MainController.getInstance();

        Boolean bol =  mainController.adaugaDepartament("CONTA");
        System.out.println(bol);
        //mainController.adaugaDepartament("HR");
        mainController.getDepartamente()
                .stream()
                .forEach(System.out::println);
        Angajat angajat = new Angajat(2,"Adrian",40,2);
        mainController.adaugaAngajat(angajat);

        mainController.getAngajati(2)
                .stream()
                .forEach(System.out::println);

     //  mainController.deleteAngajat("Ion");

        mainController.getAngajati(2)
                .stream()
                .forEach(System.out::println);
    }
}
