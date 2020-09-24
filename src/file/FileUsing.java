package file;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Author: mf015
 * Date: 2020/8/17 0017
 */
public class FileUsing {
    public static void main(String[] args) {
        readBin();
//        readText();

    }

    private static void readText() {
        //字节流读写文件
        File file = new File("src\\config\\ex1.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] by = new byte[1];
            int n = -1;
            while (-1 != (n = fis.read(by))){
                String content = new String(by);
                System.out.println("***"+content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readBin() {
        //java处理bin文件
        File file = new File("src\\config\\TBox_App.bin");
        if (file.canRead()) {
            try {
                DataInputStream dis = new DataInputStream(new FileInputStream(file));
                byte[] by = new byte[(int) file.length()];

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static int[] convertBytesToInts(byte[] inputData) {
        int[] rawData = new int[inputData.length / 2];
        int rawIndex = 0;
        for (int i = 0; i < inputData.length; i += 2) {
            int raw = (0xff & inputData[i + 1]) * 256 + (0xff & inputData[i]);
            if (raw >= 32768) {
                raw -= 65536;
            }
            rawData[rawIndex] = raw;
            rawIndex++;
        }
        return rawData;
    }
}
