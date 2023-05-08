package com.masai.service;

import java.io.IOException;
import java.util.*;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.exceptions.CrimeNotFoundException;
import com.masai.exceptions.CriminalNotFoundException;
import com.masai.exceptions.InvalidInputSelectionException;

public interface CriminalServices {
	public String addNewCriminal(int id, List<Integer> crimes, Map<Integer, Criminal> criminals, Scanner sc)throws InvalidInputSelectionException, IOException;
	public String updateCriminalDetails(int id,Criminal criminal,Map<Integer,Criminal> criminals)throws CriminalNotFoundException;
}
