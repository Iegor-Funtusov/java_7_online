package ua.com.alevel;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.IOException;

public class IoTest {

    public void createFile(String path) {
        File file = new File(path);
        System.out.println("getAbsolutePath = " + file.getAbsolutePath());
        System.out.println("isFile = " + file.isFile());
        try {
            file.createNewFile();
            System.out.println("isFile = " + file.isFile());
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    public void updateFile(String oldPath, String newPath) {
        File file = new File(oldPath);
        System.out.println("getAbsolutePath = " + file.getAbsolutePath());
        System.out.println("isFile = " + file.isFile());
        file.renameTo(new File(newPath));
        System.out.println("isFile = " + file.isFile());
    }

    public void deleteFile(String path) {
        File file = new File(path);
        System.out.println("getAbsolutePath = " + file.getAbsolutePath());
        file.delete();
    }

    public void createDir(String path) {
        File file = new File(path);
        System.out.println("getAbsolutePath = " + file.getAbsolutePath());
        System.out.println("isDirectory = " + file.isDirectory());
        file.mkdir();
        System.out.println("isDirectory = " + file.isDirectory());
    }

    public void createDirs(String path) {
        File file = new File(path);
        System.out.println("getAbsolutePath = " + file.getAbsolutePath());
        System.out.println("isDirectory = " + file.isDirectory());
        file.mkdirs();
        System.out.println("isDirectory = " + file.isDirectory());
    }

    public void readDir(String path) {
        File file = new File(path);
        read(file);
    }

    private void read(File dir) {
        System.out.println("dir = " + dir.getAbsolutePath());
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (ArrayUtils.isNotEmpty(files)) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        read(file);
                    } else {
                        System.out.println("file = " + file.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void removeDir(String path) {
        File file = new File(path);
        System.out.println("file = " + file.getAbsolutePath());
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
