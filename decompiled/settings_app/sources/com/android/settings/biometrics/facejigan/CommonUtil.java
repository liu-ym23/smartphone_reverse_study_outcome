package com.android.settings.biometrics.facejigan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.bytedance.platform.godzilla.common.Constant;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CommonUtil {
    public static final String DSP_LIB_PATH = "dsp_lib";
    public static String Memory_flag = null;
    public static final String PREFERENCE_FILE_NAME = "Faceunlock";
    public static final String UNLOCK_FACE_FEATURE_NAME = "face_";
    public static final String UNLOCK_FACE_FEATURE_NAME_SUFFIX = "png";
    public static final String UNLOCK_FACE_FEATURE_PATH = "faces";
    public static final String UNLOCK_FACE_FOLDER_PATH = "anc";

    public CommonUtil() {
    }

    static {
        Memory_flag = new String("unavaliable memory");
    }

    public static List<String> readModelInfo(Context r4, int r5) {
        ArrayList r0 = new ArrayList();
        InputStream r1 = null;
        InputStream r6 = r4.getResources().openRawResource(r5);     // Catch: Throwable -> L26 Exception -> L39
    L68:
        BufferedReader r7 = new BufferedReader(new InputStreamReader(r6, Constant.CHARSET_UTF_8));     // Catch: Throwable -> L21 Exception -> L24
    L64:
        String r2 = r7.readLine();     // Catch: Throwable -> L19 Exception -> L51
        if (r2 == null) goto L9;
        r0.add(r2);     // Catch: Throwable -> L19 Exception -> L51
        goto L25
    L9:
        if (r6 != null) goto L62;
    L58:
        r7.close();     // Catch: IOException -> L16
    L18:
        return r0;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L62:
        r6.close();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
    L23:
        r1 = r6;
    L28:
        if (r1 != null) goto L54;
    L33:
        if (r7 == null) goto L72;
        r7.close();     // Catch: IOException -> L36
        throw th;
    L36:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L72:
        throw th;
    L54:
        r1.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L25:
        r1 = r6;
    L40:
        if (r1 != null) goto L60;
    L45:
        if (r7 != null) goto L52;
    L50:
        return r0;
    L52:
        r7.close();     // Catch: IOException -> L48
    L48:
        e = move-exception;
        e.printStackTrace();
        goto L50
    L60:
        r1.close();     // Catch: IOException -> L43
    L43:
        e = move-exception;
        e.printStackTrace();
        goto L45
    L24:
        r7 = null;
    L21:
        th = th;
        r7 = null;
    L39:
        r7 = null;
    L26:
        th = th;
        r7 = null;
        goto L28
    }

    public static Bitmap getBitMap(byte[] r11, Rect r12, int r13, boolean r14) {
        YuvImage r6 = new YuvImage(r11, 17, 640, 480, null);
        ByteArrayOutputStream r15 = new ByteArrayOutputStream();
        r6.compressToJpeg(new Rect(0, 0, 640, 480), 80, r15);
        byte[] r16 = r15.toByteArray();
        Bitmap r4 = BitmapFactory.decodeByteArray(r16, 0, r16.length);
        Matrix r9 = new Matrix();
        r9.reset();
        r9.preRotate(r13);
        if (r14 == true) goto L6;
        r9.preScale(-1.0f, 1.0f);
    L6:
        return Bitmap.createBitmap(r4, r12.left, r12.top, r12.width(), r12.height(), r9, true).copy(Bitmap.Config.ARGB_8888, true);
    }
}
