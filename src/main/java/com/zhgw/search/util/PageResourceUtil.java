package com.zhgw.search.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PageResourceUtil {

	private String fileName;

	public PageResourceUtil(String fileName) {

		this.fileName = fileName;
	}

	public String getResource() throws IOException {

		StringBuffer sb = new StringBuffer();

		InputStream in = this.getClass().getResourceAsStream("/pages/" + fileName);

		InputStreamReader isr = new InputStreamReader(in, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.trim().startsWith("#"))
					continue;
				sb.append(line);
				line = null;
			}

		} finally {
			br.close();
			isr.close();
			in.close();
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		PageResourceUtil pru = new PageResourceUtil("user.handle.page");
		System.out.println(pru.getResource());
	}
}
