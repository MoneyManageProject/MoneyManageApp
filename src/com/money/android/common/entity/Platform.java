/**
 * 
 */
package com.money.android.common.entity;

/**
 * @author ChenHongLi
 *
 */
public class Platform {
	/**利率范围*/
	private String rateRange;
	/**7日成交交易额*/
	private String  sevenTradingVolume;
	/**上线时间*/
	private String onlineTime;
	/**7日投资人数*/
	private String sevenInvestmentNumber;
	/**口碑评分*/
	private float score;
	/**平台名称*/
	private String platformName;
	/**平台logo地址*/
	private String platformLogoPath;
	
	public Platform(){}
	
	public Platform(String rateRange,String sevenTradingVolume,String onlineTime,String sevenInvestmentNumber,
			float score,String platformName,String platformLogoPath){
		this.rateRange = rateRange;
		this.sevenTradingVolume = sevenTradingVolume;
		this.onlineTime = onlineTime;
		this.sevenInvestmentNumber = sevenInvestmentNumber;
		this.score = score;
		this.platformName = platformName;
		this.platformLogoPath = platformLogoPath;
	}
	
	public String getRateRange() {
		return rateRange;
	}
	public void setRateRange(String rateRange) {
		this.rateRange = rateRange;
	}
	public String getSevenTradingVolume() {
		return sevenTradingVolume;
	}
	public void setSevenTradingVolume(String sevenTradingVolume) {
		this.sevenTradingVolume = sevenTradingVolume;
	}
	public String getOnlineTime() {
		return onlineTime;
	}
	public void setOnlineTime(String onlineTime) {
		this.onlineTime = onlineTime;
	}
	public String getSevenInvestmentNumber() {
		return sevenInvestmentNumber;
	}
	public void setSevenInvestmentNumber(String sevenInvestmentNumber) {
		this.sevenInvestmentNumber = sevenInvestmentNumber;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getPlatformLogoPath() {
		return platformLogoPath;
	}
	public void setPlatformLogoPath(String platformLogoPath) {
		this.platformLogoPath = platformLogoPath;
	}
	
}
