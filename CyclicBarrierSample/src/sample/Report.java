package sample;

import config.ConfigKey;

public enum Report {

	COUPON(ConfigKey.REPORT_COUPON),
	SALES(ConfigKey.REPORT_SALES),
	STOCK(ConfigKey.REPORT_STOCK);

	private ConfigKey configKey;

	private Report(ConfigKey key){
		this.configKey = key;
	}

	public ConfigKey getConfigKey(){
		return this.configKey;
	}
}
