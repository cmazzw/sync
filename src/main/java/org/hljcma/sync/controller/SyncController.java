package org.hljcma.sync.controller;

import org.hljcma.sync.entity.DataType;
import org.hljcma.sync.service.IRedisService;
import org.hljcma.sync.service.IDataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SyncController {

	@Autowired
	private IDataTypeService dataTypeService;

	@Autowired
	private IRedisService redisService;

    @RequestMapping("/sync")
    public int sync(){
        List<DataType> datatypes = dataTypeService.getAll();
        int suceflag=1;
        for(DataType datatype:datatypes){
            boolean isOk=redisService.set(datatype.getC_data_type()+"_"+datatype.getIiiii(),datatype.getC_data_type_new());
            if(!isOk){
                suceflag=0;
                break;
            }
        }
        return suceflag;
    }
}
