package test;

import static java.lang.System.*;

import java.util.Properties;

import config.ConfigKey;
import config.ConfigUtil;

public class TestConfig {

	public static void main(String[] args) {
		Properties config = ConfigUtil.getConfigFile();

		out.println(config.getProperty(ConfigKey.ARCHIVE_FILE.getText()));
		out.println(config.getProperty(ConfigKey.REPORT_COUPON.getText()));
		out.println(config.getProperty(ConfigKey.REPORT_SALES.getText()));
		out.println(config.getProperty(ConfigKey.REPORT_STOCK.getText()));
		out.println(config.getProperty(ConfigKey.WORK_DIR.getText()));
	}
}
