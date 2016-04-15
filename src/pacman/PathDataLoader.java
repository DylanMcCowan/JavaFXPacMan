package pacman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by dylan on 2016-04-03.
 */
public class PathDataLoader {

    public PathDataLoader()
    {
    }

    //TODO Find ways to to optimise this and add more checks
    public String getPathData(File pFile)
    {
        String pData = "";
        if(pFile.isFile()) {
            try (Scanner scan = new Scanner(pFile.getAbsoluteFile())) {
                while(scan.hasNext()){
                    pData += scan.nextLine();
                }
                scan.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error, File not Found. Please Restart... - " + e.getLocalizedMessage());
            }
        }else{
        }
        return pData;
    }



}
