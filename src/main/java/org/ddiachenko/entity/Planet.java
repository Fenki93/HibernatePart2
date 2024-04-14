package org.ddiachenko.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "planet")
public class Planet {

    @Id
    @Size(min = 1, max = 10)
    @Pattern(regexp = "^[0-9A-Z]+$")
    private String id;

    @Column(name = "name")
    @NotNull
    private String name;
}