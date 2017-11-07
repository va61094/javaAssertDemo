package com.Accenture.fileio;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="C:\\TempFiles\\test.txt";
		File file= new File(path);
		try {
			if(file.createNewFile())
				System.out.println("file created");
			else{
				System.out.println("file not created");
				file.isDirectory();
				file.isFile();
				file.exists();
				//file.deleteOnExit();
				//file.delete();
				path="C:/";
				file= new File(path);
				String pList[]=file.list();
				for(String pt:pList)
					System.out.println(pt);
				file.setReadOnly();
			}} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
