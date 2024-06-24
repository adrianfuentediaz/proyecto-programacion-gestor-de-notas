/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Notes;

import java.time.LocalDate;

public class TodoNote extends Note {
    private String idNote;
    private String title;
    private LocalDate date;
    private String text;
    private tipoNote tipo;
    
    public TodoNote(String idNote, String title, LocalDate date, String text, tipoNote tipo) {
        super(idNote, title, date, text, tipo);
        this.idNote = idNote;
        this.title = title;
        this.date = date;
        this.text = text;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TodoNote{" + "title=" + title + ", date=" + date + ", text=" + text + ", tipo=" + tipo + '}';
    }
}
