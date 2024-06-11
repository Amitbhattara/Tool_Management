package com.rentatool.repository;

import java.util.HashMap;
import java.util.Map;

import com.rentatool.exception.InvalidChargeException;
import com.rentatool.model.ToolRentalCharge;
import com.rentatool.repository.ToolRentalChargeRepository;

public class ToolRentalChargeRepository {

	private Map<String, ToolRentalCharge> toolRentalCharges = new HashMap<String, ToolRentalCharge>() {
		private static final long serialVersionUID = -114421572496828538L;
		{
			put("Jackhammer", new ToolRentalCharge("Jackhammer", 2.99, true, false, false));
			put("Chainsaw", new ToolRentalCharge("Chainsaw", 1.49, true, false, true));
			put("Ladder", new ToolRentalCharge("Ladder", 1.99, true, true, false));
		}
	};

	public ToolRentalCharge getToolRentalChargeByToolType(String toolType) throws InvalidChargeException {
		if (toolRentalCharges.containsKey(toolType)) {
			return toolRentalCharges.get(toolType);
		} else {
			throw new InvalidChargeException(String.format("No charge found for the tool type: {}", toolType));
		}
	}

}
