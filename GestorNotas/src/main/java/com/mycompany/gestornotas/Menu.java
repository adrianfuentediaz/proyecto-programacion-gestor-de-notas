/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestornotas;

import Notes.Note;
import Users.Builder;
import Users.Gestor;
import Users.User;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    Builder b = new Builder();
    Gestor g = new Gestor();
    public void mostrar(String nomUser, HashMap<String, User> users) {
        Scanner sc = new Scanner(System.in);
        int o;
        String titleNote, adminPassword;
        User userActivo = b.buscarUser(nomUser, users);
        do {
            do {
                System.out.println("1. Previsualizar notas");
                System.out.println("2. Ver al detalle una nota");
                System.out.println("3. Anhadir una nueva nota");
                System.out.println("4. Editar una nota");
                System.out.println("5. Eliminar una nota");
                System.out.println("6. Previsualizar todos los usuarios(admin solo)");
                System.out.println("7. Ver la informacion de un usuario(admin solo)");
                System.out.println("8. Eliminar un usuario(admin solo)");
                System.out.println("9. Editar el nombre de usuario de un usuario(admin solo)");
                System.out.println("10. Editar la contrasenha de un usuario(admin solo)");
                System.out.println("11. Mostrar todas las notas de texto(admin solo)");
                System.out.println("12. Mostrar todas las notas de tareas(admin solo)");
                System.out.println("0. Acabar programa");
                System.out.println("");
                o = sc.nextInt();
            }while(o < 0 || o > 12);

            switch(o) {
                case 1:
                    for(Note note : userActivo.getNotasUser()){
                        System.out.println("Titulo: " + note.getTitle());
                        System.out.println("");
                    }
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Titulo de la nota a mostrar: ");
                    titleNote = sc.nextLine();
                    for(Note note : userActivo.getNotasUser()){
                        if(note.getTitle().equals(titleNote)){
                            System.out.println("Titulo: " + note.getTitle());
                            System.out.println("Texto: " + note.getText());
                            System.out.println("Fecha: " + note.getDate());
                            System.out.println("");
                            break;
                        }
                    }
                    break;
                case 3:
                    g.añadirNote(userActivo);
                    break;
                case 4:
                    g.editarNote(userActivo);
                    break;
                case 5:
                    g.eliminarNote(userActivo);
                    break;
                case 6:
                    System.out.println("Contrasenha de admin: ");
                    adminPassword = sc.next();
                    if(adminPassword.equals("adminPassword")){
                        System.out.println("Contrasenha de admin correcta");
                        g.mostrarUsuarios(users);
                    }else {
                        System.out.println("Contrasenha de admin incorrecta");
                    }
                    break;
                case 7:
                    System.out.println("Contrasenha de admin: ");
                    adminPassword = sc.next();
                    if(adminPassword.equals("adminPassword")){
                        System.out.println("Contrasenha de admin correcta");
                        g.mostrarUsuario(users);
                    }else {
                        System.out.println("Contrasenha de admin incorrecta");
                    }
                    break;
                case 8:
                    System.out.println("Contrasenha de admin: ");
                    adminPassword = sc.next();
                    if(adminPassword.equals("adminPassword")){
                        System.out.println("Contrasenha de admin correcta");
                        g.eliminarUsuario(users);
                    }else {
                        System.out.println("Contrasenha de admin incorrecta");
                    }
                    break;
                case 9:
                    System.out.println("Contrasenha de admin: ");
                    adminPassword = sc.next();
                    if(adminPassword.equals("adminPassword")){
                        System.out.println("Contrasenha de admin correcta");
                        g.editarNombreUsuario(users);
                    }else {
                        System.out.println("Contrasenha de admin incorrecta");
                    }
                    break;
                case 10:
                    System.out.println("Contrasenha de admin: ");
                    adminPassword = sc.next();
                    if(adminPassword.equals("adminPassword")){
                        System.out.println("Contrasenha de admin correcta");
                        g.editarPasswordUsuario(users);
                    }else {
                        System.out.println("Contrasenha de admin incorrecta");
                    }
                    break;
                case 11:
                    System.out.println("Contrasenha de admin: ");
                    adminPassword = sc.next();
                    if(adminPassword.equals("adminPassword")){
                        System.out.println("Contrasenha de admin correcta");
                        g.mostrarTextNote(users);
                    }else {
                        System.out.println("Contrasenha de admin incorrecta");
                    }
                    break;
                case 12:
                    System.out.println("Contrasenha de admin: ");
                    adminPassword = sc.next();
                    if(adminPassword.equals("adminPassword")){
                        System.out.println("Contrasenha de admin correcta");
                        g.mostrarTodoNote(users);
                    }else {
                        System.out.println("Contrasenha de admin incorrecta");
                    }
                    break;
                default:
                    System.out.println("Programa acabado");
                    break;

            }
        }while(o != 0);
    }
}
