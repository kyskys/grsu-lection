package grsu.lection.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FRENCHMAN")
public class Frenchman extends AbstractEntity {

    @Column(name = "IS_MIME")
    private Boolean mime;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @ManyToMany
    @JoinTable(name = "BAKERY_2_FRENCHMAN",
            joinColumns = @JoinColumn(name = "FRENCHMAN_ID"),
            inverseJoinColumns = @JoinColumn(name = "BAKERY_ID"))
    private List<Bakery> bakeries;

    public Frenchman(Boolean mime, String name, Integer age) {
        this.mime = mime;
        this.name = name;
        this.age = age;
    }

    public Boolean isMime() {
        return mime;
    }

}
