package files;

import java.io.File;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileDemo {
    private static final Logger logger = LogManager.getLogger(FileDemo.class);

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter file or directory name: ");
        analyzePath(in.nextLine());
    }

    public static void analyzePath(String path) {
        File name = new File(path);

        if (name.exists()) {
            System.out.printf("%s exists\n" +
                            "%s\n" +
                            "%s\n" +
                            "%s\n" +
                            "Last Modified: %s\n" +
                            "File Size: %s\n" +
                            "Parent Dir: %s\n" +
                            "Path: %s\n" +
                            "Abs. Path: %s\n",
                    name.getName(),
                    name.isFile() ? "Is a file" : "Is not a file",
                    name.isDirectory() ? "Is a dir" : "Is not a dir",
                    name.isAbsolute() ? "Input Is absolute path" : "Input isn't absolute path",
                    name.lastModified(),
                    name.length(),
                    name.getParent(),
                    name.getPath(),
                    name.getAbsolutePath()
            );
            if (name.isDirectory()) {
                String[] dirContents = name.list();

                for (String item : dirContents) {
                    System.out.println("Directory contains - " + item);
                }
            }
        } else {
            logger.warn("No file exists with this name.");
        }

    }
}
