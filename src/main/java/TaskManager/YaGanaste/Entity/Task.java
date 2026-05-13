/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskManager.YaGanaste.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;


public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTask")

    private int IdTask;

    @Column(name = "Tittle")
    private String Tittle;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Status")
    private Status Status;

    @Column(name = "CreationDate")
    private Date CreationDate;

    public Task(){}
    
    public Task(int IdTask, String Tittle, String Description, Status Status, Date CreationDate) {
        this.IdTask = IdTask;
        this.Tittle = Tittle;
        this.Description = Description;
        this.Status = Status;
        this.CreationDate = CreationDate;
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

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date CreationDate) {
        this.CreationDate = CreationDate;
    }
    
    
    
    

}
