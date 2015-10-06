package com.zhgw.search.util;


/**
 * Jquery dataTable
 * return json
 * @author yunjume
 *
 */
public class DataTableUtils {

	
	
	public static String getDataJsonFragment(String...strings){
		StringBuffer s = new StringBuffer();
		s.append("[");
		int j=1 ;
		int length = strings.length;
        for(String str : strings){
        	s.append("\"").append(str).append("\"");
        	if(j++ !=length)
        		s.append(",");
        	s.append("");
        }
        s.append("]");
        return s.toString();
	}
	
	
	
	public static String setDataJsonHeader(String json_fragment ){
		StringBuffer sb = new StringBuffer();
		
		sb.append("{");
		sb.append("\"data\":[");
		sb.append(json_fragment);
		sb.append("]");
		sb.append("}");
		return sb.toString();
	}
	
	
	
	public static void main(String[] args) {
		String s = getDataJsonFragment("1","2","3","3","4");
		
		System.out.println(setDataJsonHeader(s));
	}
}
