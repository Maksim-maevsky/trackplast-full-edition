package com.truckplast.analyzer.entity.part;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "position_id")
    private Long positionId;
}
