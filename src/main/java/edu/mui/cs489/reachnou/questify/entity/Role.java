package edu.mui.cs489.reachnou.questify.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
