package com.btpn.employee.common;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class util {
	
	public static Date parseStrToDate(String strDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date date = sdf.parse(strDate);

		java.sql.Date sqlDate = new Date(date.getTime());
		return sqlDate;
	}

	public static String jsonToString(final Object obj) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
