package com.bytedance.common.utility;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class BitmapUtils {
    private static final int COMPRESS_QUALITY = 100;
    private static final int LOAD_QUALITY = 80;
    private static final int MAX_BYTE = 8192;
    private static final int MAX_OUT_HEIGHT = 4000;
    private static final int MAX_RATIO = 4;
    private static final int ROTATE_180 = 180;
    private static final int ROTATE_270 = 270;
    private static final int ROTATE_90 = 90;
    private static final int ROTATE_QUALITY = 50;
    private static final int SD_QUALITY = 100;
    private static final String TAG = "BitmapUtils";
    private static final int WIDTH_RANGE = 150;

    private BitmapUtils() {
    }

    public static Bitmap compressBitmap(Bitmap r0, long r1) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.compressBitmap(r0, r1);
    }

    public static Bitmap decodeBitmap(byte[] r0, int r1, int r2) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.decodeBitmap(r0, r1, r2);
    }

    public static Bitmap getBitmapFromSD(String r0, int r1, int r2, int r3) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.getBitmapFromSD(r0, r1, r2, r3);
    }

    public static Bitmap loadBitmap(int r0, String r1) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.loadBitmap(r0, r1);
    }

    public static int readPictureDegree(String r0) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.readPictureDegree(r0);
    }

    public static Bitmap resizeBitmap(Bitmap r0, int r1, int r2) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.resizeBitmap(r0, r1, r2);
    }

    public static Bitmap rotateBitmap(Bitmap r0, int r1) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.rotateBitmap(r0, r1);
    }

    @Deprecated
    public static void rotateImage(String r0) {
        com.bytedance.android.standard.tools.file.BitmapUtils.rotateImage(r0);
    }

    public static boolean saveBitmapToSD(Bitmap r0, String r1, String r2) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.saveBitmapToSD(r0, r1, r2);
    }

    public static boolean saveImageData(byte[] r0, String r1, String r2) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.saveImageData(r0, r1, r2);
    }

    public static Bitmap decodeBitmap(File r0, int r1, int r2, Bitmap.Config r3) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.decodeBitmap(r0, r1, r2, r3);
    }

    public static Bitmap getBitmapFromSD(String r0, int r1, int r2, int r3, Bitmap.Config r4) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.getBitmapFromSD(r0, r1, r2, r3, r4);
    }

    public static Bitmap loadBitmap(int r0, String r1, boolean r2) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.loadBitmap(r0, r1, r2);
    }

    public static Bitmap decodeBitmap(File r0, int r1) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.decodeBitmap(r0, r1);
    }

    public static Bitmap getBitmapFromSD(String r0, int r1, int r2) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.getBitmapFromSD(r0, r1, r2);
    }

    public static Bitmap decodeBitmap(File r0, int r1, boolean r2) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.decodeBitmap(r0, r1, r2);
    }

    public static Bitmap getBitmapFromSD(String r0, int r1, int r2, Bitmap.Config r3) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.getBitmapFromSD(r0, r1, r2, r3);
    }

    public static Bitmap decodeBitmap(File r0) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.decodeBitmap(r0);
    }

    public static Bitmap getBitmapFromSD(String r0, int r1) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.getBitmapFromSD(r0, r1);
    }

    public static Bitmap decodeBitmap(ContentResolver r0, Uri r1, int r2, int r3) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.decodeBitmap(r0, r1, r2, r3);
    }

    public static Bitmap getBitmapFromSD(String r0, int r1, boolean r2) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.getBitmapFromSD(r0, r1, r2);
    }

    public static Bitmap decodeBitmap(Context r0, int r1, int r2, int r3) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.decodeBitmap(r0, r1, r2, r3);
    }

    public static Bitmap getBitmapFromSD(String r0) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.getBitmapFromSD(r0);
    }
}
