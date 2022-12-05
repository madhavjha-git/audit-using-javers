package site.madhavjha.audit.domain;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TypeValue<T> {
    private String type;
    private T data;
}
