package grsu.lection.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "beetle_sequence")
    @SequenceGenerator(name = "beetle_sequence", sequenceName = "beetle_sequence", allocationSize = 1)
    @Column(name = "ID")
    protected Long id;

}
