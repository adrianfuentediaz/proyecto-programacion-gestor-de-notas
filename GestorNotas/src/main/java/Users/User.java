/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import Notes.Note;
import java.util.HashSet;

public class User {
    private String nomUser;
    private String passwordUser;
    private HashSet<Note> notasUser;

    public User(String nomUser, String passwordUser, HashSet<Note> notasUser) {
        this.nomUser = nomUser;
        this.passwordUser = passwordUser;
        this.notasUser = notasUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public HashSet<Note> getNotasUser() {
        return notasUser;
    }

    public void setNotasUser(HashSet<Note> notasUser) {
        this.notasUser = notasUser;
    }

    @Override
    public String toString() {
        return "User{" + "nomUser=" + nomUser + ", passwordUser=" + passwordUser + ", notasUser=" + notasUser + '}';
    }
}
