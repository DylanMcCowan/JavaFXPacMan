package pacman;

import java.io.File;

/**
 * Created by dylan on 2016-04-03.
 *
 */
public class FileLoader {

    //TODO Perhaps look into making this a Static class for utility sake
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
