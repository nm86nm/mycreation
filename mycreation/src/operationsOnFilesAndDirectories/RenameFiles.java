package operationsOnFilesAndDirectories;

import java.io.*;
import java.nio.file.*;

public class RenameFiles {
	
	public static void main(String[] args) {
		/*File file_oldname = new File("C:/Savegame/201905100904_2.age3sav");
		File file_newname = new File("C:/Savegame/201905100904.age3sav");
		
		boolean rename_status = file_oldname.renameTo(file_newname);	
		
		System.out.println("Rename status = " + rename_status);*/		
		
		File directoryFiles = new File("C:\\Savegame");
		String[] listFiles = directoryFiles.list();		
		char[] nameFile = listFiles[1].toCharArray();
		String constName = ".age3sav"; 		
	}	
}