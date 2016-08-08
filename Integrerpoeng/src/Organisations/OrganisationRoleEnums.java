package Organisations;

public enum OrganisationRoleEnums {
	ROLE1("Leder"), 
	ROLE2("Nestleder"), 
	ROLE3("PR"), 
	ROLE4("HR"), 
	ROLE5("Innkjøp"), 
	ROLE6("Økonomi"), 
	ROLE7("Styremedlem"), 
	ROLE8("Medlem");
	
    private final String name;       

    private OrganisationRoleEnums(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equalsIgnoreCase(otherName);
    }
    
    public OrganisationRoleEnums checkIfStringEqualsAny(String role){
    	if (OrganisationRoleEnums.ROLE1.equalsName(role)) {
			return OrganisationRoleEnums.ROLE1;
		} else if (OrganisationRoleEnums.ROLE2.equalsName(role)) {
			return OrganisationRoleEnums.ROLE2;
		} else if (OrganisationRoleEnums.ROLE3.equalsName(role)) {
			return OrganisationRoleEnums.ROLE3;
		} else if (OrganisationRoleEnums.ROLE3.equalsName(role)) {
			return OrganisationRoleEnums.ROLE3;
		} else if (OrganisationRoleEnums.ROLE4.equalsName(role)) {
			return OrganisationRoleEnums.ROLE4;
		} else if (OrganisationRoleEnums.ROLE5.equalsName(role)) {
			return OrganisationRoleEnums.ROLE5;
		} else if (OrganisationRoleEnums.ROLE6.equalsName(role)) {
			return OrganisationRoleEnums.ROLE6;
		} else if (OrganisationRoleEnums.ROLE7.equalsName(role)) {
			return OrganisationRoleEnums.ROLE7;
		} else if (OrganisationRoleEnums.ROLE8.equalsName(role)) {
			return OrganisationRoleEnums.ROLE8;
		} else {
			return null;
		}
    }

    public String toString() {
       return this.name;
    }
}
