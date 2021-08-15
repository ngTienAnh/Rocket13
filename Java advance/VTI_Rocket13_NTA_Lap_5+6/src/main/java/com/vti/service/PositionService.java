package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Position;
import com.vti.repository.IPositionReponsitory;

@Service
public class PositionService implements IPositionService {

	@Autowired
	private IPositionReponsitory positionReponsitory;

	@Override
	public List<Position> getAllPositions() {
		return positionReponsitory.findAll();
	}

}
