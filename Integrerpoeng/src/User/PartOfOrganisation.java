package User;

import java.time.LocalDate;

public class PartOfOrganisation {
	
	private String nameOfOrganiasation;
	private LocalDate startDate;
	private LocalDate endDate;
	private OrganisationRoleEnums organisationRole;
	
	/**
	 * 
	 * @param nameOfOrganiasation - The String name of the organisation
	 * @param organisationRole - Users role in the organisation
	 * @param startDate - When user started in org
	 * @param endDate - when user quit or will quit
	 */
	
	public PartOfOrganisation(String nameOfOrganiasation,OrganisationRoleEnums organisationRole, LocalDate startDate, LocalDate endDate) {
		super();
		this.nameOfOrganiasation = nameOfOrganiasation;
		this.startDate = startDate;
		this.endDate = endDate;
		this.organisationRole = organisationRole;
	}
	
	
	public String getNameOfOrganiasation() {
		return nameOfOrganiasation;
	}
	public void setNameOfOrganiasation(String nameOfOrganiasation) {
		this.nameOfOrganiasation = nameOfOrganiasation;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public OrganisationRoleEnums getOrganisationRole() {
		return organisationRole;
	}
	public void setOrganisationRole(OrganisationRoleEnums organisationRole) {
		this.organisationRole = organisationRole;
	}
	
	public String toString(){
		return this.nameOfOrganiasation+","+this.organisationRole+","+this.startDate+","+this.endDate;
	}

}
