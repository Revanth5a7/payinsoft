package com.payin.payinsoft.entitylayer;
import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Builder
@Setter
@NoArgsConstructor 
@AllArgsConstructor 
public class Todaypunch {

    @Id  // Make a new id field the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generate the primary key
    private Long recid;

    @ManyToOne()
    @JoinColumn(
        name = "employee_code",
        referencedColumnName = "employee_code"
    )
    private Employeeinfo empinfo;

    private LocalTime intime;
    private LocalTime outtime;
    private Long numberOfHours;
    private LocalDate date;

    @PrePersist
    public void prePersist() {
        if (this.date == null) {
            this.date = LocalDate.now();  // Set to current date if it's null
        }
    }
}
