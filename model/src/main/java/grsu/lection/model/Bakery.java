package grsu.lection.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BAKERY")
public class Bakery extends AbstractEntity {

    @Column(name = "NAME")
    private String name;

//    @OneToMany(mappedBy = "bakery")
//    private List<Bread> breads;
//
//    @ManyToMany(mappedBy = "bakeries")
//    private List<Frenchman> frenchmen;

    @ToString.Exclude
    @OneToOne(mappedBy = "bakery")
    private Beetle beetle;

}
