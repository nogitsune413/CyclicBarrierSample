package sample;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import config.ConfigKey;
import config.ConfigUtil;

public class FilePath {

	private static final String CSV_EXTENTION = ".csv";

	private Properties config = ConfigUtil.getConfigFile();

	private Path addDate(Path path, LocalDate date){
		return Paths.get(path + "_" + date.format(DateTimeFormatter.BASIC_ISO_DATE));

	}

	private Path addCsvExtention(Path path){
		return Paths.get(path.toString() + CSV_EXTENTION);
	}

	/**
	 * 帳票ファイルのパスを返す
	 * @param date
	 * @return
	 */
	public Path getReportPath(ConfigKey report,LocalDate date){
		return addCsvExtention(addDate(Paths.get(config.getProperty(report.getText())),date));
	}

	/**

	/**
	 * アーカイブファイルのパスを返す
	 * @param date
	 * @return
	 */
	public Path getArchivePath(LocalDate date){
		return addDate(Paths.get(config.getProperty(ConfigKey.ARCHIVE_FILE.getText())),date);
	}

	/**
	 * WORKフォルダのパスを返す
	 * @return
	 */
	public Path getWorkDirPath(){
		return Paths.get(config.getProperty(ConfigKey.WORK_DIR.getText()));
	}
}
