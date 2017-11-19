package test;

import static java.lang.System.*;

import java.time.LocalDate;

import config.ConfigKey;
import sample.FilePath;

public class TestFilePath {

	public static void main(String[] args){

		FilePath filePath = new FilePath();
		LocalDate date = LocalDate.parse("2017-10-01");
		out.println(filePath.getReportPath(ConfigKey.REPORT_COUPON,date));
		out.println(filePath.getReportPath(ConfigKey.REPORT_SALES,date));
		out.println(filePath.getReportPath(ConfigKey.REPORT_STOCK,date));
		out.println(filePath.getArchivePath(date));
		out.println(filePath.getWorkDirPath());
	}
}
