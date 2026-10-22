package com.facebook.imageutils;

import android.util.Pair;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    private static boolean a(byte[] r4, String r5) {
        if (r4.length == r5.length()) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r4.length) goto L12;
        if (r5.charAt(r0) != r4[r0]) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static int b(InputStream r2) {
        byte r0 = (byte) r2.read();
        return ((((byte) r2.read()) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (r0 & 255);
    }

    private static byte c(InputStream r0) {
        return (byte) (r0.read() & 255);
    }

    private static String d(byte[] r3) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L7;
        r0.append((char) r3[r1]);
        r1 = r1 + 1;
        goto L4
    L7:
        return r0.toString();
    }

    private static int e(InputStream r4) {
        byte r0 = (byte) r4.read();
        byte r1 = (byte) r4.read();
        byte r2 = (byte) r4.read();
        return ((((((byte) r4.read()) << 24) & ViewCompat.MEASURED_STATE_MASK) | ((r2 << 16) & 16711680)) | ((r1 << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) | (r0 & 255);
    }

    private static short f(InputStream r0) {
        return (short) (r0.read() & 255);
    }

    public static Pair<Integer, Integer> g(InputStream r3) {
        byte[] r0 = new byte[4];
        r3.read(r0);     // Catch: Throwable -> L49 IOException -> L51
        if (a(r0, "RIFF") == true) goto L11;
        if (r3 != null) goto L68;
    L10:
        return null;
    L68:
        r3.close();     // Catch: IOException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L11:
        e(r3);     // Catch: Throwable -> L49 IOException -> L51
        r3.read(r0);     // Catch: Throwable -> L49 IOException -> L51
        if (a(r0, "WEBP") == true) goto L19;
        if (r3 != null) goto L75;
    L18:
        return null;
    L75:
        r3.close();     // Catch: IOException -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L19:
        r3.read(r0);     // Catch: Throwable -> L49 IOException -> L51
        String r1 = d(r0);     // Catch: Throwable -> L49 IOException -> L51
        if ("VP8 ".equals(r1) == false) goto L29;
        Pair<Integer, Integer> r2 = h(r3);     // Catch: Throwable -> L49 IOException -> L51
        if (r3 != null) goto L79;
    L27:
        return r2;
    L79:
        r3.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L27
    L29:
        if ("VP8L".equals(r1) == false) goto L38;
        Pair<Integer, Integer> r4 = i(r3);     // Catch: Throwable -> L49 IOException -> L51
        if (r3 != null) goto L71;
    L36:
        return r4;
    L71:
        r3.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L36
    L38:
        if ("VP8X".equals(r1) == false) goto L46;
        Pair<Integer, Integer> r5 = j(r3);     // Catch: Throwable -> L49 IOException -> L51
        if (r3 != null) goto L65;
    L45:
        return r5;
    L65:
        r3.close();     // Catch: IOException -> L43
    L43:
        e = move-exception;
        e.printStackTrace();
        goto L45
    L46:
        if (r3 == null) goto L58;
        r3.close();     // Catch: IOException -> L56
    L73:
    L58:
        return null;
    L51:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L49
        if (r3 == null) goto L58;
        r3.close();     // Catch: IOException -> L56
    L56:
        e = move-exception;
        e.printStackTrace();
    L49:
        th = move-exception;
        if (r3 != null) goto L77;
    L64:
        throw th;
    L77:
        r3.close();     // Catch: IOException -> L62
    L62:
        e = move-exception;
        e.printStackTrace();
        goto L64
    }

    private static Pair<Integer, Integer> h(InputStream r4) {
        r4.skip(7);
        short r0 = f(r4);
        short r1 = f(r4);
        short r2 = f(r4);
        if (r0 == 157) goto L5;
        return null;
    L5:
        if (r1 == 1) goto L7;
        return null;
    L7:
        if (r2 == 42) goto L10;
        return null;
    L10:
        return new Pair(Integer.valueOf(b(r4)), Integer.valueOf(b(r4)));
    }

    private static Pair<Integer, Integer> i(InputStream r4) {
        e(r4);
        if (c(r4) == 47) goto L6;
        return null;
    L6:
        int r0 = ((byte) r4.read()) & 255;
        int r1 = ((byte) r4.read()) & 255;
        int r2 = ((byte) r4.read()) & 255;
        int r3 = (r0 | ((r1 & 63) << 8)) + 1;
        int r5 = (((((((byte) r4.read()) & 255) & 15) << 10) | (r2 << 2)) | ((r1 & 192) >> 6)) + 1;
        return new Pair(Integer.valueOf(r3), Integer.valueOf(r5));
    }

    private static Pair<Integer, Integer> j(InputStream r2) {
        r2.skip(8);
        return new Pair(Integer.valueOf(k(r2) + 1), Integer.valueOf(k(r2) + 1));
    }

    private static int k(InputStream r3) {
        byte r0 = c(r3);
        byte r1 = c(r3);
        return (((c(r3) << 16) & 16711680) | ((r1 << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) | (r0 & 255);
    }
}
