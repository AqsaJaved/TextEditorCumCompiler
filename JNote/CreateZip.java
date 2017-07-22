package JNote;
import java.io.File;
import java.util.ArrayList;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import JNote.Frame;
import java.awt.Desktop;
import javax.swing.JOptionPane;
 
public class CreateZip{
    static String password;
    static String destinationZipFilePath="";
    static String FileName="";
    static String FilePath="";
    static String FileDir="";
    public void getFileName(String fileName) {
        FileName=fileName;
    }

    public void getFilePath(String filePath) {
        FilePath=filePath;
        destinationZipFilePath=filePath;
        destinationZipFilePath=destinationZipFilePath+".zip";
    }
    
    public void getFileDir(String fnt) {
        FileDir=fnt;
    }
    public void getPassword(String pass)
    {
       password=pass;
       makeZip();
    }
    
    
    public void makeZip() {
        
           try {
 
                  // --------Encryption zipParameters (for password protection)--------
                  // Create ZipParameters
                  ZipParameters zipParameters = new ZipParameters();
 
                  // Set how you want to encrypt files
                  zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
                  zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
 
                  // Set encryption of files to true
                  zipParameters.setEncryptFiles(true);
 
                  // Set encryption method
                  zipParameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
                  // Set key strength
                  zipParameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
 
                  // Set password
                  zipParameters.setPassword(password);
 
                  
                  
                  
                  // ---------------------------CREATE ZIP file-------------
 
                  // Create ZIP file
                  ZipFile zipFile = new ZipFile(destinationZipFilePath);
 
                  // Create list of files to be added to ZIP file
                  ArrayList<File> list = new ArrayList<File>();
                  //Add SPECIFIC  files to list
                  int index=FilePath.lastIndexOf(".");
                  if(index<0)
                  {
                      FilePath=FilePath+".txt";
                  }
                  list.add(new File(FilePath));
 
                  // pass (list of files to be added to ZIP file) and ZIP parameters
                  //for Zip file to be created
                  zipFile.addFiles(list, zipParameters);
 
                  JOptionPane.showMessageDialog(null,"Password protected Zip file of given text file has been created at "  + destinationZipFilePath);
              try {
                  String temp=FilePath.replace(FileName,"");
                  File theDir = new File( temp);
		if ( theDir.exists()) {

			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().open(theDir);
			} else {
				System.out.println("Awt Desktop is not supported!");
			}

		} else {
			System.out.println("File does not exist!");
		}


	  } catch (Exception ex) {
		ex.printStackTrace();
	  }
           } catch (ZipException e) {
                  e.printStackTrace();
           }
    }

}
