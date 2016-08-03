package Print;

/*
 * Builder design pattern to add as many column as needed to the reports and naming them whatever.
 */

public final class CSVStringBuilder {
	
	private String column1;
	private String column2;
	private String column3;
	private String column4;
	private String column5;
	private String column6;
	private String column7;
	private String column8;
	private String column9;
	private String column10;
	
	private CSVStringBuilder(ReporterBuilder builder){
		this.column1 = builder.column1;
		this.column2 = builder.column2;
		this.column3 = builder.column3;
		this.column4 = builder.column4;
		this.column5 = builder.column5;
		this.column6 = builder.column6;
		this.column7 = builder.column7;
		this.column8 = builder.column8;
		this.column9 = builder.column9;
		this.column10 = builder.column10;
	}
	
	public String getColumn1(){
		return column1;
	}
	
	public String getColumn2(){
		return column2;
	}
	
	public String getColumn3(){
		return column3;
	}
	
	public String getColumn4(){
		return column4;
	}
	
	public String getColumn5(){
		return column5;
	}
	
	public String getColumn6(){
		return column6;
	}
	
	public String getColumn7(){
		return column7;
	}
	
	public String getColumn8(){
		return column8;
	}
	
	public String getColumn9(){
		return column9;
	}
	
	public String getColumn10(){
		return column10;
	}
	
	@Override
	public String toString(){
		
		 StringBuilder sb = new StringBuilder();
		 sb.append(column1);
		 
		 if(this.column2 != null){
			 sb.append(","+column2);
		 }
		 if(this.column3 != null){
			 sb.append(","+column3);
		 }
		 if(this.column4 != null){
			 sb.append(","+column4);
		 }
		 if(this.column5 != null){
			 sb.append(","+column5);
		 }
		 if(this.column6 != null){
			 sb.append(","+column6);
		 }
		 if(this.column7 != null){
			 sb.append(","+column7);
		 }
		 if(this.column8 != null){
			 sb.append(","+column8);
		 }
		 if(this.column9 != null){
			 sb.append(","+column9);
		 }
		 if(this.column10 != null){
			 sb.append(","+column10);
		 }
		 return sb.toString();
		 
	}
	/*
	 * Constructor
	 */
	
	public static class ReporterBuilder{
		
		private String column1;
		private String column2;
		private String column3;
		private String column4;
		private String column5;
		private String column6;
		private String column7;
		private String column8;
		private String column9;
		private String column10;
		
		public ReporterBuilder(String column1){
		if (column1 == null) {
	        throw new IllegalArgumentException("can not be null");
	      }
		this.column1 = column1;
		}
		
	    public ReporterBuilder withColumn2(String column2) {
	        this.column2 = column2;
	        return this;
	      }
	    public ReporterBuilder withColumn3(String column3) {
	        this.column2 = column3;
	        return this;
	      }
	    public ReporterBuilder withColumn4(String column4) {
	        this.column2 = column4;
	        return this;
	      }
	    public ReporterBuilder withColumn5(String column5) {
	        this.column2 = column5;
	        return this;
	      }
	    public ReporterBuilder withColumn6(String column6) {
	        this.column2 = column6;
	        return this;
	      }
	    public ReporterBuilder withColumn7(String column7) {
	        this.column2 = column7;
	        return this;
	      }
	    public ReporterBuilder withColumn8(String column8) {
	        this.column2 = column8;
	        return this;
	      }
	    public ReporterBuilder withColumn9(String column9) {
	        this.column2 = column9;
	        return this;
	      }
	    public ReporterBuilder withColumn10(String column10) {
	        this.column2 = column10;
	        return this;
	      }
	    
	    public CSVStringBuilder build(){
	    	return new CSVStringBuilder(this);
	    }
	
	}
}
