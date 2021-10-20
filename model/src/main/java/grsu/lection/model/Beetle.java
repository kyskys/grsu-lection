package grsu.lection.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.awt.Color;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Beetle extends AbstractEntity<Beetle> {
    //because every beetle can have its own name
    private String name;
    private Integer legsCount;
    private Color color;


    public Beetle(Beetle beetle) {
        setName(beetle.getName());
        setLegsCount(beetle.getLegsCount());
        setColor(beetle.getColor());
    }

    @Override
    public void update(Beetle newEntity) {
        setColor(newEntity.getColor());
        setLegsCount(newEntity.getLegsCount());
        setName(newEntity.getName());
    }

}
