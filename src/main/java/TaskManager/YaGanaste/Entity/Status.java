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

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idstatus")
    public int IdStatus;
    
    @Column(name="statusname")
    public String StatusName;

    public Status(){}
    
    public Status(int IdStatus, String StatusName) {
        this.IdStatus = IdStatus;
        this.StatusName = StatusName;
    }

    public int getIdStatus() {
        return IdStatus;
    }

    public void setIdStatus(int IdStatus) {
        this.IdStatus = IdStatus;
    }

    public String getStatusName() {
        return StatusName;
    }

    public void setStatusName(String StatusName) {
        this.StatusName = StatusName;
    }
    
    
    
    
}
