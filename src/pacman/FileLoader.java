package pacman;

import java.io.File;

/**
 * Created by dylan on 2016-04-03.
 *
 */
public class FileLoader {

//    //Files representing the different paths
//    File path1, path2, path3, spawnPath;

    //TODO Perhaps look into making this a Static class for utility sake
    public FileLoader()
    {
    }

    public File loadPathFile(String pathName)
    {
        File tmpLoad = new File(pathName);
          //TODO Check and switch between the different types of paths, perhaps using a constant string?
        return tmpLoad;

    }

    public File loadImageFile(String imagePathName)
    {
        File tmpImage = new File(imagePathName);
        return tmpImage;
    }

}
