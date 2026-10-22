package com.obric.common.oea.style.scene.alpha.alphaplayer.utils;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class ShaderUtil {
    public ShaderUtil() {
    }

    public static String loadFromAssetsFile(String r3, Resources r4) {
        String r0 = null;
        InputStream r5 = r4.getAssets().open(r3);     // Catch: Exception -> L12
        ByteArrayOutputStream r6 = new ByteArrayOutputStream();     // Catch: Exception -> L12
    L4:
        int r1 = r5.read();     // Catch: Exception -> L12
        if (r1 == (-1)) goto L7;
        r6.write(r1);     // Catch: Exception -> L12
        goto L4
    L7:
        byte[] r2 = r6.toByteArray();     // Catch: Exception -> L12
        r6.close();     // Catch: Exception -> L12
        r5.close();     // Catch: Exception -> L12
        String r7 = new String(r2, "UTF-8");     // Catch: Exception -> L12
        return r7.replaceAll("\\r\\n", "\n");
    L10:
        e = move-exception;
        r0 = r7;
        e = e;
    L13:
        e.printStackTrace();
        return r0;
    L12:
        e = e;
        goto L13
    }

    public static int createProgram(String r3, String r4) {
        int r5 = loadShader(35633, r3);
        if (r5 != 0) goto L5;
        return 0;
    L5:
        int r6 = loadShader(35632, r4);
        if (r6 != 0) goto L8;
        return 0;
    L8:
        int r1 = GLES20.glCreateProgram();
        if (r1 == 0) goto L14;
        GLES20.glAttachShader(r1, r5);
        checkGlError("glAttachShader");
        GLES20.glAttachShader(r1, r6);
        checkGlError("glAttachShader");
        GLES20.glLinkProgram(r1);
        int[] r7 = new int[1];
        GLES20.glGetProgramiv(r1, 35714, r7, 0);
        if (r7[0] == 1) goto L14;
        Log.e("ES20_ERROR", "Could not link program: ");
        Log.e("ES20_ERROR", GLES20.glGetProgramInfoLog(r1));
        GLES20.glDeleteProgram(r1);
        return 0;
    L14:
        return r1;
    }

    private static int loadShader(int r3, String r4) {
        int r0 = GLES20.glCreateShader(r3);
        if (r0 == 0) goto L8;
        GLES20.glShaderSource(r0, r4);
        GLES20.glCompileShader(r0);
        int[] r5 = new int[1];
        GLES20.glGetShaderiv(r0, 35713, r5, 0);
        if (r5[0] != 0) goto L9;
        Log.e("ES20_ERROR", "Could not compile shader " + r3 + ":");
        Log.e("ES20_ERROR", GLES20.glGetShaderInfoLog(r0));
        GLES20.glDeleteShader(r0);
        return 0;
    L9:
        return r0;
    L8:
        return r0;
    }

    public static void checkGlError(String r4) {
        int r0 = GLES20.glGetError();
        if (r0 != 0) goto L5;
        return;
    L5:
        Log.e("ES20_ERROR", r4 + ": glError " + r0);
        throw new RuntimeException(r4 + ": glError " + r0);
    }
}
