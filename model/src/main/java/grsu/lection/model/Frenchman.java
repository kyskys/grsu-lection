package grsu.lection.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Frenchman extends AbstractEntity<Frenchman> {
    private Boolean mime;
    private String name;
    private Integer age;

    public Boolean isMime() {
        return mime;
    }

    @Override
    public void update(Frenchman newEntity) {
        setName(newEntity.getName());
        setMime(newEntity.isMime());
        setAge(newEntity.getAge());
    }

}
