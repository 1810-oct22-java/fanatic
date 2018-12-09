/**
 * 
 */
package com.fanatics.util;

/**
 * a set of utilities and static final members 
 * @author Phil
 *
 */
public class Tool {
	   
	public static final String CONTENT_TYPE = "application/json";
	public static final String CHARACTER_ENCODING = "UTF-8";
	public static final String DATE_FORMAT = "MM-dd-yyyy";	

	/**
	 * converts a sql.Date object to a util.Date
	 * @param sqlDate
	 * @return
	 */
	public static java.util.Date convertDate(java.sql.Date sqlDate) {
		if (sqlDate != null) {
			return new java.util.Date(sqlDate.getTime());
		}
		return null;
	}
	
	/**
	 * converts a util.Date object to a sql.Date
	 * @param utilDate
	 * @return
	 */
	public static java.sql.Date convertDate(java.util.Date utilDate) {
		if (utilDate != null) {
			return new java.sql.Date(utilDate.getTime());
		}
		return null;
	}
	
}
