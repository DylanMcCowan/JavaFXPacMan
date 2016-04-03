package pacman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by dylan on 2016-04-03.
 */
public class PathDataLoader {

    public PathDataLoader(String pathName)
    {
    }

    //TODO Redevelop this so it doesn't suck
    public String getPathData(File pFile)
    {
        String pData = null;

        if(pFile.isFile()) {
            try (Scanner scan = new Scanner(pFile)) {

                //TODO Verify that this does read the last line of the path data file
                while(scan.hasNext()){
                    pData += scan.next();
                }

                scan.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Not A File!");
        }
        //TODO Modify appropriately
        return pData;
    }



}
