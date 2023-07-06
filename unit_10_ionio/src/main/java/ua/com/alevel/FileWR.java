package ua.com.alevel;

import java.io.*;

import static ua.com.alevel.AppUtil.FILE_PATH;

public class FileWR {

    private final File file = new File(FILE_PATH);

    public void symbolWrite() {
        //OLD STYLE

//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(file);
//            fileWriter.write("ffff");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            try {
//                fileWriter.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }


        // NEW STYLE
        try(FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("Hello world!");
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    public void symbolRead() {

        char c = '\n';
        System.out.println("c = " + c);
        System.out.println("c = " + (byte)c);

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try(
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
//            while (bufferedReader.ready()) {
//                String s = bufferedReader.readLine();
//                System.out.println("s = " + s);
//                char[] charArray = s.toCharArray();
//                System.out.println("charArray = " + charArray.length);
//                if (charArray.length == 1) {
//                    System.out.println("charArray = " + (byte)charArray[0]);
//                }
//            }
//            StringBuilder stringBuilder = new StringBuilder();
            while (fileReader.ready()) {
                int read = fileReader.read();
                System.out.println("read = " + (byte)read);
//                stringBuilder.append((char)read);
            }
//            System.out.println("result = " + stringBuilder.toString());
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    public void byteWrite() {
        byte[] bytes = new byte[]{
                72,
                101,
                108,
                108,
                111,
                32,
                119,
                111,
                114,
                108,
                100,
                33,
                10,
                72,
                101,
                108,
                108,
                111,
                32,
                119,
                111,
                114,
                108,
                100,
                33,
                10,
                72,
                101,
                108,
                108,
                111,
                32,
                119,
                111,
                114,
                108,
                100,
                33,
                10
        };
        try(OutputStream outputStream = new FileOutputStream("file.txt", true)) {
            outputStream.write(bytes);
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    public void byteReqd() {
        try(InputStream inputStream = new FileInputStream(file)) {
            byte[] bytes = inputStream.readAllBytes();
            for (byte aByte : bytes) {
                System.out.println("aByte = " + (char)aByte);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
