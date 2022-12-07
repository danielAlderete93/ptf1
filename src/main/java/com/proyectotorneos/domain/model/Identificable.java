package com.proyectotorneos.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Identificable {
    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Identificable that)) return false;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
