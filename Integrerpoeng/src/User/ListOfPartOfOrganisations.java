package User;

import java.time.LocalDate;
import java.util.ArrayList;

import InputValidation.StringToLocalDate;
import Organisations.OrganisationRoleEnums;

public class ListOfPartOfOrganisations {
	private final ArrayList<PartOfOrganisation> partOfOrg;

	ListOfPartOfOrganisations() {
		this.partOfOrg = new ArrayList<PartOfOrganisation>();
	}
	
	/**
	 * Set the User as a part of an organisation in a time period
	 * @param name Name of the org
	 * @param role Users Role in the org
	 * @param start When the user started
	 * @param end When the user quit
	 * @return
	 */
	
	public boolean SetOrgByNameRoleStartEnd(String name, OrganisationRoleEnums role, String start, String end) {
			//use helper class to validate and convert string to LocalDate
			LocalDate date1 = StringToLocalDate.createNewLocalDate(start);
			LocalDate date2 = StringToLocalDate.createNewLocalDate(end);
			
			return setPartOfOrganisation(new PartOfOrganisation(name, role, date1, date2));
		
	}

	public boolean setPartOfOrganisation(PartOfOrganisation org) {

		if (!checkIfExist(org)) {
			this.partOfOrg.add(org);
			return true;
		}
		return false;

	}

	private boolean checkIfExist(PartOfOrganisation org) {

		for (PartOfOrganisation po : partOfOrg) {
			if (po.getNameOfOrganiasation().equals(org.getNameOfOrganiasation())) {
				return true;
			}
		}

		return false;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(PartOfOrganisation po : partOfOrg ){
			sb.append(po.toString()+",");
		}
		return sb.toString();
	}
}
