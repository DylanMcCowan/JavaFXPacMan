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


    public File loadPathFile(String pathName)
    {
        File tmpLoad = new File(pathName);
        return tmpLoad;

    }


    public File loadImageFile(String imagePathName)
    {
        File tmpImage = new File(imagePathName);
        return tmpImage;
    }

}
