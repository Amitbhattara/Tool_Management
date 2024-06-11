package com.rentatool.repository;

import java.util.HashMap;
import java.util.Map;

import com.rentatool.exception.InvalidToolException;
import com.rentatool.model.RentalTool;
import com.rentatool.repository.RentalToolRepository;

public class RentalToolRepository {

	private static Map<String, RentalTool> rentalTools = new HashMap<String, RentalTool>() {
		private static final long serialVersionUID = 1L;
		{
			put("JAKD", new RentalTool("JAKD", "Jackhammer", "DeWalt"));
			put("JAKR", new RentalTool("JAKR", "Jackhammer", "Ridgid"));
			put("LADW", new RentalTool("LADW", "Ladder", "Werner"));
			put("CHNS", new RentalTool("CHNS", "Chainsaw", "Stihl"));
		}
	};

	public RentalTool getRentalToolByCode(String toolCode) throws InvalidToolException {
		if (rentalTools.containsKey(toolCode)) {
			return rentalTools.get(toolCode);
		} else {
			throw new InvalidToolException(String.format("No tool found with code: %s", toolCode));
		}
	}

}
