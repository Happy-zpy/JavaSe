package com.zpy.Internet.TCP;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 作者：张鹏烨
 * 2025/9/24
 **/
public class StramUtils {
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len;
        while ((len = is.read(b)) != -1){
            bos.write(b,0,len);
        }
        bos.close();
        byte[] buf = bos.toByteArray();
        is.close();
        return buf;
    }
}
