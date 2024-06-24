/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Notes;

import java.time.LocalDate;

public class Note implements Comparable<Note> {
    private String idNote;
    private String title;
    private LocalDate date;
    private String text;
    private tipoNote tipo;
    
    public enum tipoNote{
        TEXT, 
        TODO
    }

    public Note(String idNote, String title, LocalDate date, String text, tipoNote tipo) {
        this.idNote = idNote;
        this.title = title;
        this.date = date;
        this.text = text;
        this.tipo = tipo;
    }

    public String getIdNote() {
        return idNote;
    }

    public void setIdNote(String idNote) {
        this.idNote = idNote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public tipoNote getTipo() {
        return tipo;
    }

    public void setTipo(tipoNote tipo) {
        this.tipo = tipo;
    }
    
     @Override
    public int compareTo(Note o) {
        return this.date.compareTo(o.date);
    }
    
}
