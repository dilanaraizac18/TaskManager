/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskManager.YaGanaste.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtask")
    private int IdTask;

    @NotBlank(message = "El título es obligatorio")
    @Size(min = 0, max = 100, message = "El titulo no debe tener más de 100 caracteres")
    @Column(name = "tittle")
    private String Tittle;

    @Size(min = 0, max = 200, message = "La descripción no debe tener más de 200 caracteres")
    @Column(name = "description")
    private String Description;

    @OneToOne
    @JoinColumn(name = "idstatus")
    public Status Status;

    @Column(name = "creationdate")
    private Date CreationDate;

    public Task() {
    }

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

    @PrePersist
    protected void onCreate() {
        if (this.CreationDate == null) {
            this.CreationDate = new Date(); 
        }
    }

}
