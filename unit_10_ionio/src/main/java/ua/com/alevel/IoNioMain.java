package ua.com.alevel;

import static ua.com.alevel.AppUtil.*;

public class IoNioMain {
    public static void main(String[] args) {
        //1
        IoTest ioTest = new IoTest();
//        ioTest.createFile(FILE_PATH);
//        ioTest.updateFile(FILE_PATH, FILE_UPDATE_PATH);
//        ioTest.deleteFile(FILE_UPDATE_PATH);
//        ioTest.createDir(DIR_PATH);
//        ioTest.createDirs(DIRS_PATH);
//        ioTest.readDir(DIR_PATH);
        ioTest.removeDir(DIR_PATH);
    }
}
