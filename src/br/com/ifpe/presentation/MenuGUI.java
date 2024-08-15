package br.com.ifpe.presentation;

import br.com.ifpe.utils.EntitieLoad;

import java.util.Scanner;

public class MenuGUI {

        EntitieLoad load = new EntitieLoad();
        EmployeeGUI Employee = new EmployeeGUI();
        ClientGUI Client = new ClientGUI();
        Scanner scanner = new Scanner(System.in);

        public void menu(){
        boolean system = true;
        load.loadEntities();
        while (system) {
                System.out.println("[1]-Client\n[2]-Employee\n[3]-Exit");
                String option = scanner.nextLine();

                switch (option) {
                    case "1":
                        Client.gui();
                        break;
                    case "2":
                        Employee.gui();
                    case "3":
                        system = false;
                    default:
                        System.out.println("Invalid Option");
                }
        }
    }
}
