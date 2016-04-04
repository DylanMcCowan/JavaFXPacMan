package pacman;

import java.io.File;

/**
 * Created by dylan on 2016-04-03.
 */
public class FileLoader {

//    //Files representing the different paths
//    File path1, path2, path3, spawnPath;

    //TODO Perhaps look into making this a Static class for untility sake
    public FileLoader()
    {

    }

    public File loadPathFile(String pathName)
    {
        File tmpLoad = new File(pathName);

          //TODO Check and switch between the different types of paths, perhaps using a constant string?
//        //Completly pointless at this time, for debugging purposese only currently
//        System.out.println(pathName);
//        this.path1 = new File("./assets/pathData/path1.txt");
//        this.path2 = new File("./assets/pathData/path2.txt");
//        this.path3 = new File("./assets/pathData/path3.txt");
//        this.spawnPath = new File("./assets/pathData/spawnPath.txt");

        return tmpLoad;

    }

    public File loadImageFile(String imagePathName)
    {
        File tmpImage = new File(imagePathName);

        return tmpImage;
    }

}
