/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import Notes.Note;
import Notes.Note.tipoNote;
import Notes.TextNote;
import Notes.TodoNote;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

public class Builder {
    
    public static HashMap<String, User> iniciarUsuarios(){
        HashMap<String, User> users = new HashMap<>();
        
        HashSet<Note> notasUser1 = new HashSet<>();
        notasUser1.add(new TextNote("1", "Meeting Notes", LocalDate.of(2024, 5, 1), "Meeting with the team", tipoNote.TEXT));
        notasUser1.add(new TodoNote("2", "Shopping List", LocalDate.of(2024, 5, 3), "Buy milk, bread, and eggs", tipoNote.TODO));
        
        HashSet<Note> notasUser2 = new HashSet<>();
        notasUser2.add(new TextNote("1", "Project Plan", LocalDate.of(2024, 5, 2), "Plan for the new project", tipoNote.TEXT));
        notasUser2.add(new TodoNote("2", "Gym Routine", LocalDate.of(2024, 5, 4), "Do push-ups, squats, and planks", tipoNote.TODO));
        notasUser2.add(new TextNote("3", "Book Ideas", LocalDate.of(2024, 5, 5), "Ideas for the new book", tipoNote.TEXT));

        HashSet<Note> notasUser3 = new HashSet<>();
        notasUser3.add(new TodoNote("1", "Daily Tasks", LocalDate.of(2024, 5, 6), "Check emails, write reports, make calls", tipoNote.TODO));

        HashSet<Note> notasUser4 = new HashSet<>();
        notasUser4.add(new TextNote("1", "Travel Plans", LocalDate.of(2024, 5, 7), "Plan for the trip to Europe", tipoNote.TEXT));

        HashSet<Note> notasUser5 = new HashSet<>();
        notasUser5.add(new TodoNote("1", "Weekend Activities", LocalDate.of(2024, 5, 8), "Go hiking, cook a new recipe, read a book", tipoNote.TODO));
        notasUser5.add(new TextNote("2", "Work Notes", LocalDate.of(2024, 5, 9), "Notes from the last work meeting", tipoNote.TEXT));

        users.put("User1", new User("User1", "password1", notasUser1));
        users.put("User2", new User("User2", "password2", notasUser2));
        users.put("User3", new User("User3", "password3", notasUser3));
        users.put("User4", new User("User4", "password4", notasUser4));
        users.put("User5", new User("User5", "password5", notasUser5));
        
        return users;
    }
    
    public User buscarUser(String nombreUser, HashMap<String, User> users){
        for(User user : users.values()) {
            if(user.getNomUser().equals(nombreUser)) {
                return user;
            }
        }
        
        return null;
    }
    
    public void registerUser(User user, HashMap<String, User> users) {
        users.put(user.getNomUser(), user);
        System.out.println("Usuario registrado");
    }
    
    public int loginUser(String nomUser, String passwordUser, HashMap<String, User> users) {
        for(User user : users.values()) {
            if(user.getNomUser().equals(nomUser) && user.getPasswordUser().equals(passwordUser)) {
                System.out.println("Usuario logeado");
                return 1;
            }
        }
        
        return 0;
    }
}
