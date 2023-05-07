package com.masai.utility;
import java.util.Map;
import java.util.LinkedHashMap;
import java.io.*;
import java.util.*;
import com.masai.*;
import com.masai.entities.Crime;
public class FileExists {
	public static  Map<Integer,Crime> crimeflie(){
		Map<Integer,Crime> crimeFile= new TreeMap<>();
		File f = new File("crime.ser");
		boolean flag = false;
		try {
			if(!f.exists()) {
				f.createNewFile();
				flag = true;
			}
			if(flag) {
				crimeFile = new LinkedHashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(crimeFile);
				return crimeFile;
			}else {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				crimeFile = (Map<Integer,Crime>) ois.readObject();
				return crimeFile;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return crimeFile;
	}
}
