package org.hljcma.sync.mapper;

import org.hljcma.sync.entity.DataType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DataTypeMapper {

    @Select("select * from FRONT_DATA_TYPE_NEW")
    public List<DataType> getall();
}