package com.zhgw.search.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * FileUtils source SpringSimple.
 * @author yunjume
 *
 */
public class FileUtils {

	private static List<String> lists = new ArrayList<String>();

	public static List<String> listFile(String dir) {

		File fs[] = new File(dir).listFiles();

		for (File f : fs) {
			if (f.isDirectory()) {
				listFile(f.getAbsolutePath());
			} else {
				lists.add(f.getAbsolutePath());
			}
		}
		return lists;
	}

	public static void clear() {
		lists.clear();
	}
}
