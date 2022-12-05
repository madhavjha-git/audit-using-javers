package site.madhavjha.audit.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class Value<T> {
    @Field(name="id")
    private Integer id;
    private T value;
}
