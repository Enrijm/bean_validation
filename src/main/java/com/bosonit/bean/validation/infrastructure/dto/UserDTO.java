package com.bosonit.bean.validation.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Getter
@Setter
@ToString
public class UserDTO {
    
    private long id;

    @NotBlank(message = "Nombre es obligatorio")
    private String name;

    @NotBlank(message = "Email es obligatorio")
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserDTO userDTO = (UserDTO) o;
        return id != 0 && Objects.equals(id, userDTO.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}