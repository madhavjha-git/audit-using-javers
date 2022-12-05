package site.madhavjha.audit.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private TypeValue<Value<String>> attributes;
}