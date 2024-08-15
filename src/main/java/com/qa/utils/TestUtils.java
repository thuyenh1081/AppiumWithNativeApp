package com.qa.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class TestUtils {
	public static final long WAIT = 2;
	public static final long LONG_WAIT = 60;
	public static String AndroiPlatform = "Android";
	public static String IosPlatform = "iOS";

	public HashMap<String, String> parseStringXML(InputStream file){
		HashMap<String, String> stringMap = new HashMap<String, String>();
		//Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();

			//Build Document
			Document document = builder.parse(file);

		 
		//Normalize the XML Structure; It's just too important !!
		document.getDocumentElement().normalize();
		 
		//Here comes the root node
		Element root = document.getDocumentElement();

		//Get all elements
		NodeList nList = document.getElementsByTagName("string");

		for (int temp = 0; temp < nList.getLength(); temp++)
		{
		 Node node = nList.item(temp);
		 if (node.getNodeType() == Node.ELEMENT_NODE)
		 {
		    Element eElement = (Element) node;
		    // Store each element key value in map
		    stringMap.put(eElement.getAttribute("name"), eElement.getTextContent());
		 }
		}
		}
		catch (Exception exception ){}

		return stringMap;

	}
	public String transformFormatOfDate(String strDate, String expectedFormat)
	{
		DateFormat dateFormat = new SimpleDateFormat(expectedFormat);
		return dateFormat.format(strDate);
	}
	public String transformFormatOfDate(Date date, String expectedFormat)
	{
		DateFormat dateFormat = new SimpleDateFormat(expectedFormat);
		return dateFormat.format(date);
	}
    public Date convertStringToDate(String stringOfDate)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH);

//		String dateInString = "7-Jun-2013";
		try {
			return formatter.parse(stringOfDate);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public int getYearFromADate(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	public int getMonthFromADate(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH);
	}

	public int getDayFromADate(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	public  String dateTime() {
		return  transformFormatOfDate(getDateAfterToday(0),"yyyy-MM-dd-HH-mm-ss");
	}

	public Date getDateAfterToday(int plusDay)
	{
		Date dt = new Date();
		//LocalDateTime.from(dt.toInstant()).plusDays(plusDay).toLocalDate().toString();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, plusDay);
		return dt = c.getTime();
		}

	public Date getHourAfterToday(int plusHour)
	{
		Date dt = new Date();
		//LocalDateTime.from(dt.toInstant()).plusDays(plusDay).toLocalDate().toString();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.HOUR, plusHour);
		return dt = c.getTime();
	}


	public void sortAscending(List<String> list)
	{
		Collections.sort(list);
	}
	public void sortDescending(List<String> list)
	{
		Collections.sort(list, Collections.reverseOrder());
	}
	public void sortAscendingWithoutSensitive(List<String> list)
	{
		sortAscending(list);
		System.out.println("sortAscending: " + list);
		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
	}
	public void sortDescendingWithoutSensitive(List<String> list)
	{
		Collections.sort(list, new DescendingSortIgnoreCase());
	}
	private class DescendingSortIgnoreCase implements Comparator<Object> {
		public int compare(Object o1, Object o2) {
			String s1 = (String) o1;
			String s2 = (String) o2;
			return s2.toLowerCase().compareTo(s1.toLowerCase());
		}
	}

}
