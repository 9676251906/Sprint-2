package com.cg.pecunia.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ConvertDate 
{
	public static Date utildate=null;
	public static Date convertDate(String date)
	{
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			utildate=sdf.parse(date);
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		return utildate;
	}
}
