package User;

import java.time.LocalDate;
import java.util.ArrayList;

import InputValidation.StringToLocalDate;

public class ListOfPartOfOrganisations {
	private final ArrayList<PartOfOrganisation> partOfOgransiations;

	ListOfPartOfOrganisations() {
		this.partOfOgransiations = new ArrayList<PartOfOrganisation>();
	}

	public boolean SetOrgByNameRoleStartEnd(String name, OrganisationRoleEnums role, String start, String end) {
			//use helper class to validate and convert string to LocalDate
			LocalDate date1 = StringToLocalDate.createNewLocalDate(start);
			LocalDate date2 = StringToLocalDate.createNewLocalDate(end);
			
			return setPartOfOrganisation(new PartOfOrganisation(name, role, date1, date2));
		
	}

	public boolean setPartOfOrganisation(PartOfOrganisation org) {

		if (!checkIfExist(org)) {
			this.partOfOgransiations.add(org);
			return true;
		}
		return false;

	}

	private boolean checkIfExist(PartOfOrganisation org) {

		for (PartOfOrganisation po : partOfOgransiations) {
			if (po.getNameOfOrganiasation().equals(org.getNameOfOrganiasation())) {
				return true;
			}
		}

		return false;
	}
}
