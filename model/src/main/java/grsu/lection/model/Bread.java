package grsu.lection.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BREAD")
public class Bread extends AbstractEntity {

    @Column(name="FLOUR_TYPE")
    @Enumerated(EnumType.STRING)
    private FlourType flour;

    @Column(name = "CREATION_DATE")
    private LocalDate creationDate;

    @Column(name = "ALIVE_DAYS")
    private Integer aliveDays;

    @Column(name = "IS_SLICED")
    private Boolean sliced;

    @ManyToOne
    @JoinColumn(name = "BAKERY_ID")
    private Bakery bakery;

    public Bread(FlourType flour, LocalDate creationDate, Integer aliveDays, Boolean sliced) {
        this.flour = flour;
        this.creationDate = creationDate;
        this.aliveDays = aliveDays;
        this.sliced = sliced;
    }

    public Boolean isSliced() {
        return sliced;
    }

}
