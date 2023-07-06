package ua.com.alevel;

import java.io.*;

import static ua.com.alevel.AppUtil.*;

public class IoNioMain {
    public static void main(String[] args) throws IOException {
        //1
//        IoTest ioTest = new IoTest();
//        ioTest.createFile(FILE_PATH);
//        ioTest.updateFile(FILE_PATH, FILE_UPDATE_PATH);
//        ioTest.deleteFile(FILE_UPDATE_PATH);
//        ioTest.createDir(DIR_PATH);
//        ioTest.createDirs(DIRS_PATH);
//        ioTest.readDir(DIR_PATH);
//        ioTest.removeDir(DIR_PATH);

//        String reverse = ReverseStringUtil.reverse("");
//        System.out.println("reverse = " + reverse);

        Reader reader;
        Writer writer;

        OutputStream outputStream;
        InputStream inputStream;

        FileWR wr = new FileWR();
//        wr.symbolWrite();
//        wr.symbolRead();
//        wr.byteReqd();
//        wr.byteWrite();

        SerialTest serialTest = new SerialTest();
        serialTest.serial();
        serialTest.deserial();

//        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//        int read = inputStreamReader.read();
//        System.out.println("read = " + (char)read);

//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        String s = bufferedReader.readLine();
//        System.out.println("s = " + s);
    }
}
