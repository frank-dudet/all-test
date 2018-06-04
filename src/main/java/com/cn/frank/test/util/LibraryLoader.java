package com.cn.frank.test.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

public final class LibraryLoader {
	public static final String JACOB_DLL_PATH = "jacob.dll.path";
	public static final String JACOB_DLL_NAME = "jacob.dll.name";
	public static final String JACOB_DLL_NAME_X86 = "jacob.dll.name.x86";
	public static final String JACOB_DLL_NAME_X64 = "jacob.dll.name.x64";
	public static final String DLL_NAME_MODIFIER_32_BIT = "x86";
	public static final String DLL_NAME_MODIFIER_64_BIT = "x64";
	
	public static final String USER_HOME = System.getProperty("user.home");
	public static final String DLL_X86_NAME = "jacob-1.17-x86.dll";

	public static void loadJacobLibrary() {
		//---- Added By Huan === begin ------
		String unzipPath = USER_HOME+"/.dp/erpDBInspector/lib";
		String dllPath = LibraryLoader.unzipLib(unzipPath, "", DLL_X86_NAME);
		
		if(dllPath != null) {
//			JacobObject.debug("Loading library " + dllPath);
			System.load(dllPath);
			return;
		}
		//---- Added By Huan === end ------
		
		ResourceBundle resources = null;
		Set keys = new HashSet();
		try {
			resources = ResourceBundle.getBundle(LibraryLoader.class.getName(), Locale.getDefault(),
					LibraryLoader.class.getClassLoader());

			Enumeration i = resources.getKeys();
			while (i.hasMoreElements()) {
				String key = (String) i.nextElement();
				keys.add(key);
			}

		} catch (MissingResourceException e) {
		}

		String path = System.getProperty("jacob.dll.path");
		if ((path == null) && (resources != null) && (keys.contains("jacob.dll.path"))) {
			path = (String) resources.getObject("jacob.dll.path");
		}

		if (path != null) {
//			JacobObject.debug("Loading library " + path + " using System.loadLibrary ");

			System.load(path);
		} else {
			String name = null;

			if (System.getProperty("jacob.dll.name") != null)
				name = System.getProperty("jacob.dll.name");
			else if ((System.getProperty("jacob.dll.name.x86") != null) && (shouldLoad32Bit())) {
				name = System.getProperty("jacob.dll.name.x86");
			} else if ((System.getProperty("jacob.dll.name.x64") != null) && (!shouldLoad32Bit())) {
				name = System.getProperty("jacob.dll.name.x64");
			} else if ((resources != null) && (keys.contains("jacob.dll.name")))
				name = resources.getString("jacob.dll.name");
			else if ((resources != null) && (keys.contains("jacob.dll.name.x86")) && (shouldLoad32Bit())) {
				name = resources.getString("jacob.dll.name.x86");
			} else if ((resources != null) && (keys.contains("jacob.dll.name.x64")) && (!shouldLoad32Bit())) {
				name = resources.getString("jacob.dll.name.x64");
			} else {
				name = getPreferredDLLName();
			}

//			JacobObject.debug("Loading library " + name + " using System.loadLibrary ");

			System.loadLibrary(name);
		}
	}

	public static String getPreferredDLLName() {
		if (shouldLoad32Bit()) {
//			return "jacob-" + JacobReleaseInfo.getBuildVersion() + "-" + "x86";
		}

//		return "jacob-" + JacobReleaseInfo.getBuildVersion() + "-" + "x64";
		return "";
	}

	protected static boolean shouldLoad32Bit() {
		String bits = System.getProperty("sun.arch.data.model", "?");
		if (bits.equals("32"))
			return true;
		if (bits.equals("64")) {
			return false;
		}

		String arch = System.getProperty("java.vm.name", "?");

		return arch.toLowerCase().indexOf("64-bit") < 0;
	}

	private static synchronized String unzipLib(String unzipPath, String dllPathInJar, String dllName) {
		InputStream in = null;
		OutputStream out = null;
		try {
			// have to use a stream
			in = LibraryLoader.class.getClassLoader().getResourceAsStream(dllPathInJar+dllName);
			// always write to different location
			File fileOut = new File(unzipPath + "/" + dllName);
			if(fileOut.exists()) {
				return fileOut.toString();
			}
			fileOut.getParentFile().mkdirs();
			out = new FileOutputStream(fileOut);
			byte[] buffer = new byte[1024];
			int byteread = 0;
			while ((byteread = in.read(buffer)) != -1) {
				out.write(buffer, 0, byteread);
			}
			
			return fileOut.toString();
		} catch (Exception e) {
			System.err.println("Failed to load required DLL, msg="+e.getMessage());
			return null;
		}finally {
			try {
				if(in != null)
					in.close();
				if(out != null)
					out.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}