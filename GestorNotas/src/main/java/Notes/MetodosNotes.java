/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Notes;

import Users.User;
import java.util.HashMap;
import java.util.HashSet;

public interface MetodosNotes {
    public void añadirNote(User user);
    public void editarNote(User user);
    public void eliminarNote(User user);
    public Note buscarNote(String titleNote, HashSet<Note> notasUser);
    public void mostrarTextNote(HashMap<String, User> users);
    public void mostrarTodoNote(HashMap<String, User> users);
}
