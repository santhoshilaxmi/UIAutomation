package utilities;


import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class FileUtilities {


    public String getTheLatestFileName() throws Throwable {
        File downloadsDir = new File("C:/Users/admin/Downloads");
        Thread.sleep(10000);
        File[] downloadDirFiles = downloadsDir.listFiles();
        String path="";

        if (downloadDirFiles.length > 0) {
            Arrays.sort(downloadDirFiles, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
           File theNewestFile = downloadDirFiles[0];
           path = theNewestFile.getPath();
        }

        return path;
    }


    public void readCSVFile(String path) throws IOException {
        CSVReader readcsv = new CSVReader(new FileReader(path));
        String [] nextLine,csvCell;
        System.out.println("Read the colum 1 element from the downlaoded CSV file from the above step");
        for(int i=0;i<5;i++){
            try {
                csvCell = readcsv.readNext();
                System.out.println("First Cell of the Row ["+i+"] is "+csvCell[0]);
            } catch (IOException | CsvValidationException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
