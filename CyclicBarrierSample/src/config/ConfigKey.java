package config;

public enum ConfigKey {

	REPORT_COUPON("report_coupon"),
	REPORT_SALES("report_sales"),
	REPORT_STOCK("report_stock"),
	ARCHIVE_FILE("archive_file"),
	WORK_DIR("work_dir");

	private String text;

	private ConfigKey(String text){
		this.text = text;
	}

	public String getText(){
		return this.text;
	}
}
