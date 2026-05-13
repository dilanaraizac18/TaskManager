/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskManager.YaGanaste.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;


@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdTask")
    private int IdTask;
    
    @Column(name="Tittle")
    private String Tittle;
    
    @Column(name="Description")
    private String Description;
    
    @Column(name="IdStatus")
    private Status Status;
    
    @Column(name="DateCreation")
    private Date DateCreation; 
    
    
    public Task(){ }

    public Task(int IdTask, String Tittle, String Description, Status Status, Date DateCreation) {
        this.IdTask = IdTask;
        this.Tittle = Tittle;
        this.Description = Description;
        this.Status = Status;
        this.DateCreation = DateCreation;
    }

    public int getIdTask() {
        return IdTask;
    }

    public void setIdTask(int IdTask) {
        this.IdTask = IdTask;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String Tittle) {
        this.Tittle = Tittle;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status Status) {
        this.Status = Status;
    }

    public Date getDateCreation() {
        return DateCreation;
    }

    public void setDateCreation(Date DateCreation) {
        this.DateCreation = DateCreation;
    }
    
    
    
}
