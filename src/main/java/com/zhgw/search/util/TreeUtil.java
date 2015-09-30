package com.zhgw.search.util;

import java.util.List;

public class TreeUtil {

	public static String toJson(List<? extends Tree> trees) {
		StringBuffer sb = new StringBuffer();

		
		if(trees==null || trees.size()==0)
			return "";
		for (Tree tree : trees) {

			sb.append("{");
			sb.append("\"id\":");
			sb.append(tree.getId());
			sb.append(",");

			sb.append("\"");
			sb.append("text");
			sb.append("\"");
			sb.append(":");
			sb.append("\"");
			sb.append(tree.getText());
			sb.append("\",");

			sb.append("\"");
			sb.append("state");
			sb.append("\"");
			sb.append(":");
			sb.append("\"");
			sb.append("closed");
			sb.append("\"");

			sb.append("}");

			sb.append(",");
		}

		if (!sb.toString().isEmpty())
			sb = sb.deleteCharAt(sb.length()-1);
		
		
		return "["+sb.toString()+"]";
	}
}
