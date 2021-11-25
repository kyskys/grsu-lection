package grsu.lection.model;

import javafx.scene.paint.Color;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BEETLE")
@Builder
public class Beetle extends AbstractEntity {

    //because every beetle can have its own name
    @Column(name = "NAME")
    private String name;

    @Column(name = "LEGS_COUNT")
    private Integer legsCount;

    @Column(name = "COLOR")
    private String color;

    @OneToOne
    @JoinColumn(name = "BAKERY_ID")
    private Bakery bakery;

    //constructor for cloning beetle
    public Beetle(Beetle beetle) {
        setName(beetle.getName());
        setLegsCount(beetle.getLegsCount());
        setColor(beetle.getColor());
        setBakery(beetle.getBakery());
    }

    public Beetle(String name, Integer legsCount, Color color) {
        this.name = name;
        this.legsCount = legsCount;
    }
}
