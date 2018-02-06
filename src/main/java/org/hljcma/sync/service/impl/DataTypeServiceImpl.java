package org.hljcma.sync.service.impl;

import org.hljcma.sync.entity.DataType;
import org.hljcma.sync.mapper.DataTypeMapper;
import org.hljcma.sync.service.IDataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataTypeServiceImpl implements IDataTypeService{

	@Autowired
	private DataTypeMapper datatypemapper;

	@Override
	public List<DataType> getAll() {

		return datatypemapper.getall();
	}
}