package User;

import java.util.ArrayList;

import Print.CSVStringBuilder;

public class UserReportBuilder {

	private String name;
	private String totalPoints;
	private String usedPoints;
	private String Role;

	private UserReportBuilder(ReportBuilder builder) {
		this.name = builder.name;
		this.totalPoints = builder.totalPoints;
		this.usedPoints = builder.usedPoints;
		this.Role = builder.Role;

	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(name);

		if (this.totalPoints != null) {
			sb.append("," + totalPoints);
		}
		if (this.usedPoints != null) {
			sb.append("," + usedPoints);
		}
		if (this.Role != null) {
			sb.append("," + Role);
		}
		return sb.toString();
	}

	// constructor
	public static class ReportBuilder {

		User user;

		private String name;
		private String totalPoints;
		private String usedPoints;
		private String Role;

		public ReportBuilder(User user) {
			this.user = user;
			this.name = user.getName();

		}

		public ReportBuilder withTotalPoints() {
			this.totalPoints = ""+user.getPoints().getTotalPoints();
			return this;
		}

		public ReportBuilder withUsedPoints() {
			this.usedPoints = ""+user.getPoints().getUsedPoints();
			return this;
		}

		public ReportBuilder withRole() {
			this.Role = user.getRole();
			return this;
		}

		public UserReportBuilder build() {
			return new UserReportBuilder(this);
		}
	}

}
