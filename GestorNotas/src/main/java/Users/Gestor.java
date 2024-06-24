/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import Notes.TodoNote;
import Notes.TextNote;
import Notes.MetodosNotes;
import Notes.Note;
import Notes.Note.tipoNote;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Gestor implements MetodosNotes {
    Scanner sc = new Scanner(System.in);
    public User buscarUser(String nomUser, HashMap<String, User> users){
        for(User user : users.values()) {
            if(user.getNomUser().equals(nomUser)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void añadirNote(User user) {
        Note newNote;
        String idNote = String.valueOf(user.getNotasUser().size());
        String title;
        LocalDate date = LocalDate.now();
        String text;
        System.out.println("AÑADIR NUEVA NOTA:");
        System.out.println("Titulo: ");
        title = sc.nextLine();
        if(buscarNote(title, user.getNotasUser()) != null){
            System.out.println("Ya se encuentra una nota con ese titulo");
            return;
        }
        System.out.println("Texto: ");
        text = sc.nextLine();
        int o = 0;
        do{
            System.out.println("1. Tipo texto");
            System.out.println("2. Tipo tarea");
            o = sc.nextInt();
        }while(o < 1 || o > 2);
        if(o == 1){
            newNote = new TextNote(idNote, title, date, text, tipoNote.TEXT);
        } else {
            newNote = new TodoNote(idNote, title, date, text, tipoNote.TODO);
        }
        user.getNotasUser().add(newNote);
    }

    @Override
    public void editarNote(User user) {
        String titleNote;
        String newTextNote;
        System.out.println("Titulo de la nota: ");
        titleNote = sc.nextLine();
        Note noteFind = buscarNote(titleNote, user.getNotasUser());
        if( noteFind == null){
            System.out.println("No se ha encontrado ninguna nota con este titulo");
            return;
        }
        System.out.println("Nuevo texto de la nota: ");
        newTextNote = sc.nextLine();
        noteFind.setText(newTextNote);
        System.out.println("Texto cambiado con exito!");
    }

    @Override
    public void eliminarNote(User user) {
        String titleNote;
        System.out.println("Titulo de la nota:");
        titleNote = sc.nextLine();
        Note noteFind = buscarNote(titleNote, user.getNotasUser());
        if( noteFind == null){
            System.out.println("No se ha encontrado ninguna nota con este titulo");
            return;
        }
        user.getNotasUser().remove(noteFind);
        System.out.println("Nota eliminada con exito!");
    }
    
    @Override
    public Note buscarNote(String titleNote, HashSet<Note> notasUser){
        for(Note note : notasUser){
            if(note.getTitle().equals(titleNote)) {
                return note;
            }
        }
        
        return null;
    }
    
    public void mostrarUsuarios(HashMap<String, User> users){
        for(User u : users.values()){
            System.out.println("Nombre usuario: " + u.getNomUser());
            System.out.println("Notas usuario: " + u.getNotasUser());
        }
    }
    
    public void mostrarUsuario(HashMap<String, User> users){
        String nombreUsuario;
        System.out.println("Nombre del usuario a mostrar: ");
        nombreUsuario = sc.next();
        User u = buscarUser(nombreUsuario, users);
        if(u == null){
            System.out.println("Usuario no encontrado");
            return;
        }
        System.out.println(u);
    }
    
    public void eliminarUsuario(HashMap<String, User> users){
        String nombreUsuario;
        System.out.println("Nombre del usuario a eliminar: ");
        nombreUsuario = sc.next();
        User u = buscarUser(nombreUsuario, users);
        if(u == null){
            System.out.println("Usuario no encontrado");
            return;
        }
        users.remove(u.getNomUser());
        System.out.println("Usuario eliminado correctamente");
    }
    
    public void editarNombreUsuario(HashMap<String, User> users){
        String nombreUsuario, nuevoNombre;
        System.out.println("Nombre del usuario a eliminar: ");
        nombreUsuario = sc.next();
        User u = buscarUser(nombreUsuario, users);
        if(u == null){
            System.out.println("Usuario no encontrado");
            return;
        }
        System.out.println("Nuevo nombre del usuario: ");
        nuevoNombre = sc.next();
        u.setNomUser(nuevoNombre);
        System.out.println("Nombre actualizado correctamente");
    }
    
    public void editarPasswordUsuario(HashMap<String, User> users){
        String nombreUsuario, nuevoPassword;
        System.out.println("Nombre del usuario a eliminar: ");
        nombreUsuario = sc.next();
        User u = buscarUser(nombreUsuario, users);
        if(u == null){
            System.out.println("Usuario no encontrado");
            return;
        }
        System.out.println("Nuevo password del usuario: ");
        nuevoPassword = sc.next();
        u.setPasswordUser(nuevoPassword);
        System.out.println("Password actualizado correctamente");
    }

    @Override
    public void mostrarTextNote(HashMap<String, User> users) {
        ArrayList<Note> notesText = new ArrayList();
        System.out.println("Text notes: ");
        for(User u : users.values()){
            for(Note note : u.getNotasUser()){
                if(note.getTipo() == tipoNote.TEXT){
                    notesText.add(note);
                }
            }
        }
        Collections.sort(notesText);
        for(Note n : notesText){
            System.out.println(n);
        }
    }

    @Override
    public void mostrarTodoNote(HashMap<String, User> users) {
        ArrayList<Note> notesTodo = new ArrayList();
        System.out.println("Todo notes: ");
        for(User u : users.values()){
            for(Note note : u.getNotasUser()){
                if(note.getTipo() == tipoNote.TODO){
                    notesTodo.add(note);
                }
            }
        }
        Collections.sort(notesTodo);
        for(Note n : notesTodo){
            System.out.println(n);
        }
    }
    
}
