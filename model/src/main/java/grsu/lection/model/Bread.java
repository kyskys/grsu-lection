package grsu.lection.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bread extends AbstractEntity<Bread> {
    private FlourType flour;
    private LocalDate creationDate;
    private Integer aliveDays;
    private Boolean sliced;

    public Boolean isSliced() {
        return sliced;
    }

    @Override
    public void update(Bread newEntity) {
        setSliced(newEntity.isSliced());
        setFlour(newEntity.getFlour());
        setCreationDate(newEntity.getCreationDate());
        setAliveDays(newEntity.getAliveDays());
    }
}
