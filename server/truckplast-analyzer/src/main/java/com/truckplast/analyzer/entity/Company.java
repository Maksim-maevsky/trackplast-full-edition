package com.truckplast.analyzer.entity;

import com.truckplast.analyzer.entity.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"users"})
@EqualsAndHashCode(exclude = {"users"})
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "company_id")
    private Set<User> users;

}
