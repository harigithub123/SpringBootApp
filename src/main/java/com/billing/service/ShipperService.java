package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.dto.shipper.ShipperDTO;
import com.billing.model.shipper.Shipper;

@Service
public interface ShipperService {

	public ShipperDTO addShipper(ShipperDTO p);
	public ShipperDTO updateShipper(ShipperDTO p);
	public List<ShipperDTO> listShippers();
	public ShipperDTO getShipperById(Long id);
	public void removeShipper(Long id);
}
