package TaskManager.YaGanaste.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Status {
    @NotNull(message = "Debe introducir un status")
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
