package pacman;

import java.io.File;

/**
 * Created by dylan on 2016-04-03.
 *
 */
public class FileLoader {

    //TODO Make this a static utility class. Implement proper exceptions & constructors
    public FileLoader()
    {
    }


    public static File loadPathFile(String pathName)
    {
        return new File(pathName);
    }


    public static File loadImageFile(String imagePathName)
    {
        return new File(imagePathName);
    }

}
