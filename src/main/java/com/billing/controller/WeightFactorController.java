package com.billing.controller;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.dto.masterdata.WeightFactorRequest;
import com.billing.model.MetaDataId;
import com.billing.model.masterdata.WeightFactor;
import com.billing.response.Errors;
import com.billing.response.WeightFactorResponse;
import com.billing.service.WeightFactorService;
import com.billing.service.impl.WeightFactorServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/weightFactor")
@Validated
public class WeightFactorController {
	
	@Autowired 
	BeanValidator validator;
	
	@Autowired
	private WeightFactorService weightFactorService;
	
	public WeightFactorController(WeightFactorServiceImpl weightFactorService) {
        this.weightFactorService = weightFactorService;
    }
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> createWeightFactor(@Valid @RequestBody WeightFactorRequest weightFactorRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {                                                                   
			this.weightFactorService.addWeightFactor(weightFactorRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@PutMapping(path="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> updateWeightFactor(@Valid @RequestBody WeightFactorRequest weightFactorRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.weightFactorService.updateWeightFactor(weightFactorRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path="/remove/{shipperId}/{mode}/{modeClass}/{packageType}", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> removeWeightFactor(@PathVariable("shipperId") Long shipperId,
			@PathVariable("mode") String mode, @PathVariable("modeClass") String modeClass,
			@PathVariable("packageType") String packageType) {
		MetaDataId id = new MetaDataId(shipperId, mode, modeClass, packageType);
		this.weightFactorService.removeWeightFactor(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get/{shipperId}/{mode}/{modeClass}/{packageType}", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getWeightFactor(@PathVariable("shipperId") Long shipperId,
			@PathVariable("mode") String mode, @PathVariable("modeClass") String modeClass,
			@PathVariable("packageType") String packageType) {
		MetaDataId id = new MetaDataId(shipperId, mode, modeClass, packageType);
		WeightFactorResponse weightFactor  = getWeightFactorResponse(this.weightFactorService.getWeightFactorById(id));
		return new ResponseEntity<Object>(weightFactor, HttpStatus.OK);
	}
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getWeightFactors() {
		List<WeightFactorResponse> weightFactors  = getWeightFactorResponse(this.weightFactorService.listWeightFactors());
		return new ResponseEntity<Object>(weightFactors, HttpStatus.OK);
	}
	
	private List<WeightFactorResponse> getWeightFactorResponse(List<WeightFactor> listWeightFactors) {
		List<WeightFactorResponse> weightFactors = new LinkedList<WeightFactorResponse>();
		for(WeightFactor weightFactor : listWeightFactors) {
			weightFactors.add(getWeightFactorResponse(weightFactor));
		}
		return weightFactors;
	}
	
	private WeightFactorResponse getWeightFactorResponse(WeightFactor weightFactor) {
		return new WeightFactorResponse(weightFactor.getShipper().getId(), weightFactor.getMode(),
				weightFactor.getModeClass(), weightFactor.getPackageType(), weightFactor.getSlots(),
				weightFactor.getMinWeight(), weightFactor.getWeightSlab(), weightFactor.getVolumetricFactor());
	}
	
}

