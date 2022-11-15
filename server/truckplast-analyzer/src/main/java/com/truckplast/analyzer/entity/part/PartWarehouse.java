package com.truckplast.analyzer.entity.part;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "part_warehouses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartWarehouse {

    @Id
    private short id;

    @Column(name = "name")
    private String name;

}
