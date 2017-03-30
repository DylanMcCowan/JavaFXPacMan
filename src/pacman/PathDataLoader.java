package pacman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Dylan on 2016-04-03.
 *
 * PathDataLoader.java
 *
 * This file is responsible for reading in SVGPath Data content for use in the maze
 */
public class PathDataLoader {


    //TODO Redevelop this so it doesn't suck
    public static String getPathData(File pFile)
    {
        String pData = "";
        if(pFile.isFile()) {
            try (Scanner scan = new Scanner(pFile.getAbsoluteFile())) {
                while(scan.hasNext()){
                    pData += scan.nextLine();
                }
                scan.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error loading the file has occurred: " + e.getLocalizedMessage());
            }catch(Exception ex)
            {
                System.out.println("An runtime error has occurred: " + ex.getLocalizedMessage());
            }
        }else{
            try {
                throw new Exception("Invalid File Exception");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("File selected is not a file!");
            }

        }
        return pData;
    }
}
