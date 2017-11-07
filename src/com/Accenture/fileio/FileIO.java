package com.Accenture.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
class Account implements Serializable{
	private String accholder;
	transient private double balance;
	private long aacno;
	public Account(String accholder, double balance, long aacno) {
		super();
		this.accholder = accholder;
		this.balance = balance;
		this.aacno = aacno;
	}
	public String getAccholder() {
		return accholder;
	}
	public void setAccholder(String accholder) {
		this.accholder = accholder;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getAacno() {
		return aacno;
	}
	public void setAacno(long aacno) {
		this.aacno = aacno;
	}
	
}

public class FileIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="C:/tempfiles/test.txt";
		seriallize(path);
		deseriallize(path);
		
		
		/*
		String spath="C:/tempfiles/text.txt";
		String dpath="C:/tempfiles/test.txt";
		String input="welcome to Accenture";
		
		readwriteFile(spath,dpath);
		//readFile(path);
	*/}

	private static void deseriallize(String path) {
		// TODO Auto-generated method stub
		File file;
		FileInputStream fis;
		ObjectInputStream ois;
		try{
			file=new File(path);
			fis= new FileInputStream(file);
			ois= new ObjectInputStream(fis);
			
			Object ref=ois.readObject();
			Account aRef=null;
			if(ref instanceof Account)
				aRef=(Account)ref;
			System.out.println(aRef);
			System.out.println("success");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	private static void seriallize(String path) {
		// TODO Auto-generated method stub
		
		String lpath;
		File file;		
		FileOutputStream fos;
		ObjectOutputStream oos;
		
		try{
			file=new File(path);
			fos= new FileOutputStream(file);
			oos= new ObjectOutputStream(fos);
			Account acc=new Account("vaibhav",5123.00, 5454521);
			oos.writeObject(acc);
			System.out.println("success");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	private static void readFile(String path) {
		// TODO Auto-generated method stub
		
	}

	private static void readwriteFile(String spath,String dpath) {
		// TODO Auto-generated method stub
		FileOutputStream fos=null;
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(spath);
			fos=new FileOutputStream(dpath);
			int ch;
			
			while((ch=fis.read())!=-1)
			{
				fos.write(ch);
				
			}
			System.out.println("completed");
			/*for(int i=0;i<input.length();i++)
				fos.write(input.charAt(i));*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally{
			try{
				fos.close();
				fis.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}

}
