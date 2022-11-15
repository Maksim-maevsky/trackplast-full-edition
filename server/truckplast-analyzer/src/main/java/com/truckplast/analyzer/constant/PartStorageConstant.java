package com.truckplast.analyzer.constant;


import com.truckplast.analyzer.entity.part.PartWarehouse;

import java.util.Map;
import java.util.Set;

public final class PartStorageConstant {

    private PartStorageConstant() {
    }

    public static final short TANGDE_STORAGE_ID = 1;
    public static final short PLASTIC_STORAGE_ID = 2;
    public static final short MIKHNEVO_STORAGE_ID = 3;

    public static final String TANGDE_STORAGE_NAME = "TANGDE";
    public static final String PLASTIC_STORAGE_NAME = "PLASTIC";
    public static final String MIKHNEVO_STORAGE_NAME = "MIKHNEVO";

    public static final PartWarehouse TANGDE_STORAGE = new PartWarehouse(TANGDE_STORAGE_ID, TANGDE_STORAGE_NAME);
    public static final PartWarehouse PLASTIC_STORAGE = new PartWarehouse(PLASTIC_STORAGE_ID, PLASTIC_STORAGE_NAME);
    public static final PartWarehouse MIKHNEVO_STORAGE = new PartWarehouse(MIKHNEVO_STORAGE_ID, MIKHNEVO_STORAGE_NAME);

    public static final Set<String> PART_STORAGE_NAME_SET = Set.of(TANGDE_STORAGE_NAME, PLASTIC_STORAGE_NAME, MIKHNEVO_STORAGE_NAME);

    public static final Map<String, PartWarehouse> PART_STORAGE_MAP = Map.of("mikhnevo", MIKHNEVO_STORAGE,
            "tangde", TANGDE_STORAGE,
            "plastic", PLASTIC_STORAGE);

}
