package d.b.q.f;

import java.io.DataInput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f14318a = null;

    static {
        f14318a = new byte[]{108, 116, 108, 111, 118, 101, 122, 104};
    }

    private static boolean a(byte[] r4) {
        if (r4.length == f14318a.length) goto L5;
        return false;
    L5:
        int r0 = 0;
    L6:
        byte[] r1 = f14318a;
        if (r0 >= r1.length) goto L12;
        if (r4[r0] != r1[r0]) goto L10;
        r0 = r0 + 1;
        goto L6
    L10:
        return false;
    L12:
        return true;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0093: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:56:0x0093 */
    public static String b(File r7) {
        RandomAccessFile r0 = null;
        RandomAccessFile r1 = new RandomAccessFile(r7, "r");     // Catch: Throwable -> L26 Exception -> L28 IOException -> L34 FileNotFoundException -> L40 UnsupportedEncodingException -> L46
        long r2 = r1.length();     // Catch: Exception -> L18 IOException -> L20 FileNotFoundException -> L22 UnsupportedEncodingException -> L24 Throwable -> L55
        byte[] r8 = f14318a;     // Catch: Exception -> L18 IOException -> L20 FileNotFoundException -> L22 UnsupportedEncodingException -> L24 Throwable -> L55
        byte[] r4 = new byte[r8.length];     // Catch: Exception -> L18 IOException -> L20 FileNotFoundException -> L22 UnsupportedEncodingException -> L24 Throwable -> L55
        long r3 = r2 - ((long) r8.length);     // Catch: Exception -> L18 IOException -> L20 FileNotFoundException -> L22 UnsupportedEncodingException -> L24 Throwable -> L55
        r1.seek(r3);     // Catch: Exception -> L18 IOException -> L20 FileNotFoundException -> L22 UnsupportedEncodingException -> L24 Throwable -> L55
        r1.readFully(r4);     // Catch: Exception -> L18 IOException -> L20 FileNotFoundException -> L22 UnsupportedEncodingException -> L24 Throwable -> L55
        if (a(r4) == false) goto L17;
        long r5 = r3 - 2;     // Catch: Exception -> L18 IOException -> L20 FileNotFoundException -> L22 UnsupportedEncodingException -> L24 Throwable -> L55
        r1.seek(r5);     // Catch: Exception -> L18 IOException -> L20 FileNotFoundException -> L22 UnsupportedEncodingException -> L24 Throwable -> L55
        int r9 = c(r1);     // Catch: Exception -> L18 IOException -> L20 FileNotFoundException -> L22 UnsupportedEncodingException -> L24 Throwable -> L55
        if (r9 <= 0) goto L15;
        r1.seek(r5 - ((long) r9));     // Catch: Exception -> L18 IOException -> L20 FileNotFoundException -> L22 UnsupportedEncodingException -> L24 Throwable -> L55
        byte[] r10 = new byte[r9];     // Catch: Exception -> L18 IOException -> L20 FileNotFoundException -> L22 UnsupportedEncodingException -> L24 Throwable -> L55
        r1.readFully(r10);     // Catch: Exception -> L18 IOException -> L20 FileNotFoundException -> L22 UnsupportedEncodingException -> L24 Throwable -> L55
        String r6 = new String(r10, "UTF-8");     // Catch: Exception -> L18 IOException -> L20 FileNotFoundException -> L22 UnsupportedEncodingException -> L24 Throwable -> L55
        r1.close();     // Catch: IOException -> L11
    L74:
        return r6;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L74
    L15:
        throw new Exception("zip channel info not found");     // Catch: Exception -> L18 IOException -> L20 FileNotFoundException -> L22 UnsupportedEncodingException -> L24 Throwable -> L55
    L17:
        throw new Exception("zip v1 magic not found");     // Catch: Exception -> L18 IOException -> L20 FileNotFoundException -> L22 UnsupportedEncodingException -> L24 Throwable -> L55
    L22:
        e = e;
    L42:
        e.printStackTrace();     // Catch: Throwable -> L55
        if (r1 == null) goto L77;
        r1.close();     // Catch: IOException -> L52
    L68:
        return null;
    L77:
        return null;
    L24:
        e = e;
    L48:
        e.printStackTrace();     // Catch: Throwable -> L55
        if (r1 == null) goto L78;
        r1.close();     // Catch: IOException -> L52
        goto L68
    L78:
        return null;
    L20:
        e = e;
    L36:
        e.printStackTrace();     // Catch: Throwable -> L55
        if (r1 == null) goto L76;
        r1.close();     // Catch: IOException -> L52
        goto L68
    L76:
        return null;
    L18:
        e = e;
    L30:
        e.printStackTrace();     // Catch: Throwable -> L55
        if (r1 == null) goto L75;
        r1.close();     // Catch: IOException -> L52
        goto L68
    L75:
        return null;
    L55:
        th = th;
        r0 = r1;
    L57:
        if (r0 != null) goto L63;
    L62:
        throw th;
    L63:
        r0.close();     // Catch: IOException -> L60
    L60:
        e = move-exception;
        e.printStackTrace();
    L40:
        e = e;
        r1 = null;
    L46:
        e = e;
        r1 = null;
    L34:
        e = e;
        r1 = null;
    L28:
        e = e;
        r1 = null;
    L26:
        th = th;
    L52:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static short c(DataInput r1) {
        byte[] r0 = new byte[2];
        r1.readFully(r0);
        return ByteBuffer.wrap(r0).order(ByteOrder.LITTLE_ENDIAN).getShort(0);
    }
}
