
package com.billing.service.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.dao.ShipperRepository;
import com.billing.dto.shipper.ShipperDTO;
import com.billing.model.shipper.Shipper;
import com.billing.service.ShipperService;

@Service
public class ShipperServiceImpl implements ShipperService {
	
	private ShipperRepository shipperRespository;
	@Autowired ModelMapper mapper;
	public ShipperServiceImpl(ShipperRepository shipperRepository) {
		this.shipperRespository = shipperRepository;
	}

	@Override
	public ShipperDTO addShipper(ShipperDTO request) {
		return mapper.map(this.shipperRespository.save(mapper.map(request, Shipper.class)), ShipperDTO.class);
	}

	@Override
	public ShipperDTO updateShipper(ShipperDTO request) {
		return mapper.map(this.shipperRespository.save(mapper.map(request, Shipper.class)), ShipperDTO.class);
	}

	@Override
	public List<ShipperDTO> listShippers() {
		List<Shipper> list = this.shipperRespository.findAll();
		return list.stream()
				  .map(object -> mapper.map(object, ShipperDTO.class))
				  .collect(Collectors.toList());
	}

	@Override
	public ShipperDTO getShipperById(Long id) {
		Optional<Shipper> shipper = this.shipperRespository.findById(id);
		if(shipper != null) {
			return mapper.map(shipper.get(), ShipperDTO.class);
		}
		return null;
	}

	@Override
	public void removeShipper(Long id) {
		this.shipperRespository.deleteById(id);
		
	}

}
