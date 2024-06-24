/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestornotas;

import Notes.Note;
import Users.Builder;
import Users.Gestor;
import Users.User;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class GestorNotas {

    public static void main(String[] args) {
        Gestor g = new Gestor();
        Builder b = new Builder();
        Scanner sc = new Scanner(System.in);
        String c, nombreUser = "", passwordUser;
        boolean valido;
        HashMap<String, User> users = Builder.iniciarUsuarios();
        
        do {
            System.out.println("Registrarte(R) o Logearte(L)");
            c = sc.next();
            valido = false;
            switch(c) {
                case "R":
                    while(valido == false) {
                        System.out.println("REGISTRO DE NUEVO USER:");
                        System.out.println("Nombre:");
                        nombreUser = sc.next();
                        if(g.buscarUser(nombreUser, users) != null){
                            System.out.println("Nombre ya en uso");
                            break;
                        }
                        System.out.println("Contrasenha: ");
                        passwordUser = sc.next();
                        HashSet<Note> notasUser = new HashSet<>();
                        User userRegister = new User(nombreUser, passwordUser, notasUser);
                        b.registerUser(userRegister, users);
                        valido = true;
                    }
                    break;
                case "L":
                    while(valido == false){
                        System.out.println("LOGEO DE UN USER");
                        System.out.println("Nombre");
                        nombreUser = sc.next();
                        if(g.buscarUser(nombreUser, users) == null){
                            System.out.println("User no encontrado");
                            break;
                        }
                        System.out.println("Contrasenha: ");
                        passwordUser = sc.next();
                        if(b.loginUser(nombreUser, passwordUser, users) == 0){
                            System.out.println("Contrasenha incorrecta");
                            break;
                        }
                        valido = true;
                    }
                    break;
                default:
                    System.out.println("Opción no reconocida");
                    break;
            }
        }while(valido == false);
        Menu menu = new Menu();
        menu.mostrar(nombreUser, users);
    }
}
