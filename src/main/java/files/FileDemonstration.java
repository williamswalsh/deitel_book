package files;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileDemonstration extends JFrame{

    private JTextArea textArea;
    private JScrollPane scrollPane;
//    private JFileChooser fileChooser;
    public FileDemonstration(){
        super("File Demonstration");
        System.out.println("1");
        setSize(500,500);
        System.out.println("1");
        setVisible(true);
        System.out.println("1");
        getFileOrDir();
        System.out.println("1");
//        textArea = new JTextArea();
//        scrollPane = new JScrollPane(textArea);
//        add(scrollPane, BorderLayout.CENTER);
    }



    private File getFileOrDir(){
        System.out.println("1");
        JFileChooser fileChooser = new JFileChooser();
        System.out.println("1");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        System.out.println("1");
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.CANCEL_OPTION){
            System.exit(1);
        }

        File fileName = fileChooser.getSelectedFile();

        if ( fileName == null || fileName.getName().equals("")){
            JOptionPane.showMessageDialog(this,  "Invalid name", "Invalid name", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        return fileName;
    }

    public void analyzePath(){
        File fileName = getFileOrDir();

        if (fileName.exists()) {
            textArea.setText("Hello ");
            System.out.printf("%s exists\n" +
                            "%s\n" +
                            "%s\n" +
                            "%s\n" +
                            "Last Modified: %s\n" +
                            "File Size: %s\n" +
                            "Parent Dir: %s\n" +
                            "Path: %s\n" +
                            "Abs. Path: %s\n",
                    fileName.getName(),
                    fileName.isFile() ? "Is a file" : "Is not a file",
                    fileName.isDirectory()? "Is a dir" : "Is not a dir",
                    fileName.isAbsolute() ? "Input Is absolute path" : "Input isn't absolute path",
                    fileName.lastModified(),
                    fileName.length(),
                    fileName.getParent(),
                    fileName.getPath(),
                    fileName.getAbsolutePath()
            );
            if(fileName.isDirectory()){
                String[] dirContents = fileName.list();

                for (String item: dirContents ) {
                    System.out.print(item + " ");
                }
            }
        }else{
            System.out.println("No file exists with this name.");
        }
    }
}








