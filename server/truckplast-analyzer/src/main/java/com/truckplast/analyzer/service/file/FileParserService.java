package com.truckplast.analyzer.service.file;


import com.truckplast.analyzer.entity.FileInfo;

import java.util.List;
import java.util.UUID;

public interface FileParserService {

    void parsAndSave(FileInfo fileInfo, UUID mailInfoId);

}
