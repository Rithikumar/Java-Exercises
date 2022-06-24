package com.learn.ch17.legacy;

import java.io.*;
import java.util.*;

public class PhoneBook {
	public static void main(String[] args) throws IOException {
		Properties ht = new Properties();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name, number;
		FileInputStream fin = null;
		boolean changed = false;

		try {
			fin = new FileInputStream("phonebook.dat");
		} catch (FileNotFoundException e) {
			// ignore missing file
		}

		/*
		 * if phoneBook file alread exits load existing telephone numbers.
		 */
		try {
			if(fin != null) {
				ht.load(fin);
				fin.close();
			}
		}catch(IOException e) {
			System.out.println("Error reading file");
		}
		
		// Let user enter new names and numbers
		do {
			System.out.println("Enter new name" + " ('quit' to stop): ");
			name = br.readLine();
			if(name.equals("quit")) {continue;}
			System.out.println("Enter number: ");
			number = br.readLine();
			ht.put(name, number);
			changed = true;
		} while(!name.equals("quit"));
		
		//if phone book data has changed, save it.
		if(changed) {
			FileOutputStream fout = new FileOutputStream("phonebook.dat");
			
			ht.store(fout, "TelePhone book");
			fout.close();
		}
		
		//Look up numbers give a name.
		do {
			System.out.println("Enter name to find" + " ('quit' to quit): ");
			name = br.readLine();
			if(name.equals("quit")) {continue;}
			
			number = (String) ht.get(name);
			System.out.println(number);
		}while(!name.equals("quit"));
		
	}
}
