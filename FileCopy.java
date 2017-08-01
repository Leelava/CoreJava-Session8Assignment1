package Session8_Assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
//This class , main methods calls "fileCopyUsing Streams()", which copies the source file to destination file using File Input and Output Streams.
public class FileCopy
{
    public static void main(String[] args) throws IOException 
    {
       //Calling file copy function .
    	System.out.println("Calling the method fileCopyUsingStreams().");
        fileCopyUsingStreams();
    }
    
    
    
    
    
    
    
private static void printFile(String filePath)
{
	
	try{
	   BufferedReader br = new BufferedReader(new FileReader(filePath));
  	   String line = null;
  	     while ((line = br.readLine()) != null) 
  	     {
  	         System.out.println(line);
  	     }
  	  }catch(IOException e)
		{
			e.printStackTrace();// To print the stack in case of exceptions related to file.
		}
}


//This function reads the contents of source file into a byte buffer using an input stream and writes the 
//same into an output stream of the Destination file. It creates the destination file if it does not exist.


private static void fileCopyUsingStreams() throws IOException
    {
	
	try{
        File fileToCopy = new File("C:/Users/Prabhav/Desktop/SourceFile.txt");
        FileInputStream input = new FileInputStream(fileToCopy);//create input stream for the source file.
        //System.out.println("Contents of destination file");
    	
        
        //Print the cntents of source file before copying
        System.out.println("Contents of source file");
        System.out.println();
        printFile("C:/Users/Prabhav/Desktop/SourceFile.txt");
        System.out.println();
        
        
        File newFile = new File("C:/Users/Prabhav/Desktop/DestinationFile.txt");
        FileOutputStream output = new FileOutputStream(newFile);//Create an OutputStream for the destination file
        
        byte[] buf = new byte[1024];//Array of bytes.
    	
        int bytesRead;//variable to hold the input read from the file and to write into output stream.
        
        
        //read into the buffer and write into output stream until the source file not empty. 
        	while ((bytesRead = input.read(buf)) > 0) 
        		{
        			output.write(buf, 0, bytesRead);
        		}
        	
        
        	// Using buffered reader to read the contents of the destination file on the screen
        	System.out.println("Contents of destination file");
        	System.out.println();
        	printFile("C:/Users/Prabhav/Desktop/DestinationFile.txt");
        	System.out.println();
        	
        input.close();//close the inputstream
        output.close();//close the outputstream
        System.out.println("The copy operation is successfull");
	}catch(IOException e)
		{
			e.printStackTrace();// To print the stack in case of exceptions related to file.
		}
   }
 }
