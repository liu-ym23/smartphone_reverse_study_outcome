package com.bytedance.android.standard.tools.file;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.util.Base64;
import com.bytedance.android.standard.tools.logging.Logger;
import com.bytedance.librarian.LibrarianImpl;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
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

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0022: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:8:0x0022 */
    public static String bitmapToBase64(Bitmap r4) {
        ByteArrayOutputStream r0 = null;
        if (r4 != null) goto L44;
        String r5 = null;
    L28:
        if (r0 == null) goto L34;
        r0.flush();     // Catch: IOException -> L31
        r0.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L34:
        return r5;
    L44:
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L11 IOException -> L13
        r4.compress(Bitmap.CompressFormat.JPEG, 40, r1);     // Catch: Throwable -> L7 IOException -> L9
        r1.flush();     // Catch: Throwable -> L7 IOException -> L9
        r1.close();     // Catch: Throwable -> L7 IOException -> L9
        r5 = Base64.encodeToString(r1.toByteArray(), 0);     // Catch: Throwable -> L7 IOException -> L9
        r0 = r1;
    L9:
        e = e;
    L15:
        e.printStackTrace();     // Catch: Throwable -> L7
        if (r1 == null) goto L46;
        r1.flush();     // Catch: IOException -> L19
        r1.close();     // Catch: IOException -> L19
        return null;
    L19:
        e = move-exception;
        e.printStackTrace();
        return null;
    L46:
        return null;
    L13:
        e = e;
        r1 = null;
    L11:
        th = th;
    L21:
        if (r0 != null) goto L40;
    L26:
        throw th;
    L40:
        r0.flush();     // Catch: IOException -> L24
        r0.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
    L7:
        th = th;
        r0 = r1;
        goto L21
    }

    public static Bitmap compressBitmap(Bitmap r6, long r7) {
        if (r6 != null) goto L6;
        return null;
    L6:
        if (r7 > 0) goto L8;
        return r6;
    L8:
        Bitmap.Config r0 = Bitmap.Config.ARGB_8888;
        int r2 = r6.getHeight() * r6.getRowBytes();
        Logger.d(TAG, "bitmap size is " + r2);
        double r8 = (double) Math.round((double) (((long) r2) / r7));
        if (r8 >= 2.0d) goto L11;
    L13:
        int r9 = (int) Math.sqrt(r8);
        if (r9 != 0) goto L16;
        r9 = 1;
    L16:
        Bitmap.Config r10 = r0;
    L17:
        if (r9 != 1) goto L20;
        if (r10 != r0) goto L20;
        return r6;
    L20:
        Logger.d(TAG, "compress sample size is " + r9);
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        r6.compress(Bitmap.CompressFormat.JPEG, 100, r1);
        byte[] r11 = r1.toByteArray();
        BitmapFactory.Options r3 = new BitmapFactory.Options();
        r3.inSampleSize = r9;
        r3.inPurgeable = true;
        r3.inPreferredConfig = r10;
        return BitmapFactory.decodeByteArray(r11, 0, r11.length, r3);
    L11:
        if (r8 >= 4.0d) goto L13;
        r10 = Bitmap.Config.RGB_565;
        r9 = 1;
        goto L17
    }

    public static Bitmap decodeBitmap(byte[] r7, int r8, int r9) {
        if (r7 != null) goto L5;
    L21:
        return null;
    L5:
        if (r8 < 1) goto L21;
        if (r9 < 1) goto L21;
        BitmapFactory.Options r2 = new BitmapFactory.Options();     // Catch: Exception -> L16
        r2.inJustDecodeBounds = true;     // Catch: Exception -> L16
        BitmapFactory.decodeByteArray(r7, 0, r7.length, r2);     // Catch: Exception -> L16
        int r3 = r2.outWidth;     // Catch: Exception -> L16
        int r4 = r2.outHeight;     // Catch: Exception -> L16
        int r5 = 1;
    L10:
        if ((r3 / 2) < r8) goto L12;
    L18:
        r3 = r3 / 2;     // Catch: Exception -> L16
        r4 = r4 / 2;     // Catch: Exception -> L16
        r5 = r5 * 2;
        goto L10
    L12:
        if ((r4 / 2) >= r9) goto L18;
        BitmapFactory.Options r10 = new BitmapFactory.Options();     // Catch: Exception -> L16
        r10.inSampleSize = r5;     // Catch: Exception -> L16
        r10.inPurgeable = true;     // Catch: Exception -> L16
        r10.inPreferredConfig = Bitmap.Config.RGB_565;     // Catch: Exception -> L16
        return BitmapFactory.decodeByteArray(r7, 0, r7.length, r10);
    L16:
        e = move-exception;
        Logger.d(TAG, "decode image error: " + e);
        goto L21
    }

    public static Bitmap getBitmapFromSD(String r1, int r2, int r3, int r4) {
        return getBitmapFromSD(r1, r2, r3, r4, null);
    }

    public static Bitmap loadBitmap(int r1, String r2) {
        return loadBitmap(r1, r2, false);
    }

    public static int readPictureDegree(String r3) {
        int r4 = new ExifInterface(r3).getAttributeInt("Orientation", 1);     // Catch: IOException -> L14
        if (r4 != 3) goto L7;
        return ROTATE_180;
    L7:
        if (r4 != 6) goto L9;
        return ROTATE_90;
    L9:
        if (r4 != 8) goto L22;
        return ROTATE_270;
    L22:
        return 0;
    L14:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static Bitmap resizeBitmap(Bitmap r3, int r4, int r5) {
        int r0 = r3.getWidth();
        int r1 = r3.getHeight();
        if (r0 > r4) goto L7;
        if (r1 > r5) goto L7;
        boolean r6 = false;
        r5 = r1;
    L12:
        if (r6 == true) goto L14;
        return r3;
    L14:
        return Bitmap.createScaledBitmap(r3, r0, r5, true);
    L7:
        if (r0 <= r1) goto L11;
        if (r0 <= r4) goto L11;
        r5 = (int) (r1 * (r4 / r0));
    L10:
        r0 = r4;
        r6 = true;
    L11:
        r4 = (int) (r0 * (r5 / r1));
        goto L10
    }

    public static Bitmap rotateBitmap(Bitmap r7, int r8) {
        if (r7 == null) goto L5;
        Matrix r5 = new Matrix();
        r5.postRotate(r8);
        return Bitmap.createBitmap(r7, 0, 0, r7.getWidth(), r7.getHeight(), r5, true);
    L5:
        return r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Deprecated
    public static void rotateImage(String r9) {
        int r0 = -1;
        int r1 = new ExifInterface(r9).getAttributeInt("Orientation", 1);     // Catch: IOException -> L14
        if (r1 != 3) goto L7;
        r0 = ROTATE_180;
    L16:
        if (r0 <= 0) goto L73;
        Bitmap r8 = BitmapFactory.decodeFile(r9);
        Matrix r6 = new Matrix();
        r6.postRotate(r0);
        Bitmap r2 = Bitmap.createBitmap(r8, 0, 0, r8.getWidth(), r8.getHeight(), r6, true);
        r8.recycle();
        ?? r3 = 0;
        ?? r4 = 0;
        r4 = 0;
        FileOutputStream r5 = new FileOutputStream(r9);     // Catch: Throwable -> L31 IOException -> L33 FileNotFoundException -> L35
    L71:
        r4 = 50;
        r3 = 50;
        r2.compress(Bitmap.CompressFormat.JPEG, 50, r5);     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L29
        r5.flush();     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L29
        r5.close();     // Catch: IOException -> L22
    L24:
        r2.recycle();
        return;
    L22:
        e = e;
    L23:
        e.printStackTrace();
        r3 = r4;
        goto L24
    L29:
        e = e;
        r4 = r5;
    L43:
        e.printStackTrace();     // Catch: Throwable -> L31
        r3 = r4;
        if (r4 == 0) goto L24;
        r4.close();     // Catch: IOException -> L47
        r3 = r4;
    L47:
        e = e;
    L27:
        e = e;
        r4 = r5;
    L37:
        e.printStackTrace();     // Catch: Throwable -> L31
        r3 = r4;
        if (r4 == 0) goto L24;
        r4.close();     // Catch: IOException -> L41
        r3 = r4;
    L41:
        e = e;
    L25:
        th = th;
        r3 = r5;
    L49:
        if (r3 != 0) goto L64;
    L54:
        r2.recycle();
        throw th;
    L64:
        r3.close();     // Catch: IOException -> L52
    L52:
        e = move-exception;
        e.printStackTrace();
    L31:
        th = th;
    L35:
        e = e;
    L33:
        e = e;
        goto L37
    L73:
        return;
    L7:
        if (r1 != 6) goto L9;
        r0 = ROTATE_90;
        goto L16
    L9:
        if (r1 != 8) goto L16;
        r0 = ROTATE_270;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public static boolean saveBitmap2cache(Bitmap r2, String r3, String r4) {
        File r0 = new File(r3);
        if (r0.exists() == true) goto L5;
        r0.mkdirs();
    L5:
        File r5 = new File(r0 + LibrarianImpl.Constants.SEPARATOR + r4);
        if (r5.exists() == false) goto L46;
    L12:
        FileOutputStream r6 = null;
        FileOutputStream r1 = new FileOutputStream(r5);     // Catch: Throwable -> L25 Exception -> L27
        r2.compress(Bitmap.CompressFormat.PNG, 100, r1);     // Catch: Throwable -> L21 Exception -> L23
        r1.flush();     // Catch: Throwable -> L21 Exception -> L23
        r1.close();     // Catch: Exception -> L17
        return true;
    L17:
        e = move-exception;
        e.printStackTrace();
        return true;
    L23:
        e = e;
        r6 = r1;
    L28:
        e.printStackTrace();     // Catch: Throwable -> L25
        r6.close();     // Catch: Exception -> L31
    L33:
        return false;
    L31:
        e = move-exception;
        e.printStackTrace();
    L21:
        th = th;
        r6 = r1;
    L41:
        r6.close();     // Catch: Exception -> L36
    L38:
        throw th;
    L36:
        e = move-exception;
        e.printStackTrace();
    L27:
        e = e;
    L25:
        th = th;
        goto L41
    L46:
        r5.createNewFile();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean saveBitmapToSD(Bitmap r3, String r4, String r5) {
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L41;
        File r0 = new File(r4);
        if (r0.exists() == true) goto L7;
        r0.mkdirs();
    L7:
        File r6 = new File(r0 + LibrarianImpl.Constants.SEPARATOR + r5);
        if (r6.exists() == false) goto L42;
    L14:
        FileOutputStream r7 = null;
        FileOutputStream r1 = new FileOutputStream(r6);     // Catch: Throwable -> L27 Exception -> L29
        r3.compress(Bitmap.CompressFormat.PNG, 100, r1);     // Catch: Throwable -> L23 Exception -> L25
        r1.flush();     // Catch: Throwable -> L23 Exception -> L25
        r1.close();     // Catch: Exception -> L19
        return true;
    L19:
        e = move-exception;
        e.printStackTrace();
        return true;
    L25:
        e = e;
        r7 = r1;
    L30:
        e.printStackTrace();     // Catch: Throwable -> L27
        r7.close();     // Catch: Exception -> L33
    L35:
        return false;
    L33:
        e = move-exception;
        e.printStackTrace();
    L23:
        th = th;
        r7 = r1;
    L50:
        r7.close();     // Catch: Exception -> L38
    L40:
        throw th;
    L38:
        e = move-exception;
        e.printStackTrace();
    L27:
        th = th;
    L29:
        e = e;
        goto L30
    L42:
        r6.createNewFile();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    L41:
        return false;
    }

    public static boolean saveImageData(byte[] r4, String r5, String r6) {
        FileOutputStream r2 = null;
        File r3 = new File(r5);     // Catch: Throwable -> L10 Exception -> L12
        if (r3.exists() == false) goto L6;
    L14:
        FileOutputStream r7 = new FileOutputStream(new File(r3, r6));     // Catch: Throwable -> L10 Exception -> L12
        r7.write(r4);     // Catch: Throwable -> L18 Exception -> L20
        r7.flush();     // Catch: Throwable -> L18 Exception -> L20
        r7.close();     // Catch: Throwable -> L18 Exception -> L20
        return true;
    L20:
        e = e;
        r2 = r7;
    L22:
        Logger.d(TAG, "save image exception " + e);     // Catch: Throwable -> L10
        if (r2 != null) goto L31;
    L25:
        return false;
    L31:
        r2.close();     // Catch: Exception -> L30
    L18:
        th = th;
        r2 = r7;
    L26:
        if (r2 != null) goto L35;
    L28:
        throw th;
    L35:
        r2.close();     // Catch: Exception -> L29
        goto L28
    L6:
        if (r3.mkdirs() == true) goto L14;
        if (r3.exists() == true) goto L14;
        return false;
    L12:
        e = e;
    L10:
        th = th;
        goto L26
    }

    public static Bitmap getBitmapFromSD(String r6, int r7, int r8, int r9, Bitmap.Config r10) {
        File r1 = new File(r6);     // Catch: Exception -> L14
        if (r1.isFile() == true) goto L6;
        return null;
    L6:
        if (r9 > 0) goto L8;
    L17:
        r1.setLastModified(System.currentTimeMillis());     // Catch: Exception -> L15
    L13:
        return decodeBitmap(r1, r7, r8, r10);
    L8:
        if (r1.length() <= r9) goto L17;
        r1.delete();     // Catch: Exception -> L14
        return null;
    L14:
        return null;
    }

    public static Bitmap loadBitmap(int r6, String r7, boolean r8) {
        Bitmap r9 = getBitmapFromSD(r7, r6, r8);
        if (r9 != null) goto L5;
        return null;
    L5:
        int r1 = r9.getWidth();
        int r2 = r9.getHeight();
        if (r1 > (r6 + WIDTH_RANGE)) goto L10;
        if (r1 > r6) goto L9;
    L14:
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        if (r8 == false) goto L17;
        Bitmap.CompressFormat r0 = Bitmap.CompressFormat.PNG;
    L18:
        r9.compress(r0, 80, r10);
        r9.recycle();
        byte[] r11 = r10.toByteArray();
        r10.close();
        BitmapFactory.Options r12 = new BitmapFactory.Options();
        r12.inPurgeable = true;
        if (r8 == false) goto L21;
        Bitmap.Config r13 = Bitmap.Config.ARGB_8888;
    L22:
        r12.inPreferredConfig = r13;
        return BitmapFactory.decodeByteArray(r11, 0, r11.length, r12);
    L21:
        r13 = Bitmap.Config.RGB_565;
        goto L22
    L17:
        r0 = Bitmap.CompressFormat.JPEG;
        goto L18
    L9:
        if (r2 <= MAX_OUT_HEIGHT) goto L14;
    L10:
        Bitmap r14 = Bitmap.createScaledBitmap(r9, r6, (int) (((r6 * 1.0f) * r2) / r1), true);
        r9.recycle();
        if (r14 != null) goto L13;
        return null;
    L13:
        r9 = r14;
        goto L14
    }

    public static Bitmap getBitmapFromSD(String r2, int r3, int r4) {
        return getBitmapFromSD(r2, r3, r4, -1, null);
    }

    public static Bitmap getBitmapFromSD(String r1, int r2, int r3, Bitmap.Config r4) {
        return getBitmapFromSD(r1, r2, r3, -1, r4);
    }

    public static Bitmap getBitmapFromSD(String r1, int r2) {
        return getBitmapFromSD(r1, r2, false);
    }

    public static Bitmap getBitmapFromSD(String r4, int r5, boolean r6) {
        File r0 = new File(r4);
        if (r0.exists() == true) goto L14;
        return null;
    L14:
        r0.setLastModified(System.currentTimeMillis());     // Catch: Exception -> L11
    L12:
        return decodeBitmap(r0, r5, r6);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Bitmap decodeBitmap(File r7, int r8, int r9, Bitmap.Config r10) {
        FileInputStream r0 = null;
        if (r7 == null) goto L39;
        if (r8 <= 0) goto L39;
        if (r9 <= 0) goto L39;
    L33:
        FileInputStream r3 = null;
    L37:
        if (r3 == null) goto L39;
        r3.close();     // Catch: Exception -> L42
    L31:
        th = th;
    L34:
        if (r0 != null) goto L45;
    L36:
        throw th;
    L45:
        r0.close();     // Catch: Exception -> L40
        goto L36
    L8:
        if (r7.isFile() == true) goto L10;
        return null;
    L10:
        BitmapFactory.Options r1 = new BitmapFactory.Options();     // Catch: Throwable -> L31 Exception -> L33
        r1.inJustDecodeBounds = true;     // Catch: Throwable -> L31 Exception -> L33
        r3 = new FileInputStream(r7);     // Catch: Throwable -> L31 Exception -> L33
        BitmapFactory.decodeStream(r3, null, r1);     // Catch: Throwable -> L20 Exception -> L41
        r3.close();     // Catch: Throwable -> L20 Exception -> L41
        int r4 = r1.outWidth;     // Catch: Throwable -> L20 Exception -> L41
        int r2 = r1.outHeight;     // Catch: Throwable -> L20 Exception -> L41
        int r5 = 1;
    L13:
        if ((r4 / 2) < r8) goto L15;
    L29:
        r4 = r4 / 2;     // Catch: Throwable -> L20 Exception -> L41
        r2 = r2 / 2;     // Catch: Throwable -> L20 Exception -> L41
        r5 = r5 * 2;
        goto L13
    L15:
        if ((r2 / 2) >= r9) goto L29;
        BitmapFactory.Options r11 = new BitmapFactory.Options();     // Catch: Throwable -> L20 Exception -> L41
        r11.inSampleSize = r5;     // Catch: Throwable -> L20 Exception -> L41
        r11.inPurgeable = true;     // Catch: Throwable -> L20 Exception -> L41
        if (r10 == null) goto L22;
        r11.inPreferredConfig = r10;     // Catch: Throwable -> L20 Exception -> L41
    L23:
        FileInputStream r12 = new FileInputStream(r7);     // Catch: Throwable -> L20 Exception -> L41
        Bitmap r13 = BitmapFactory.decodeStream(r12, null, r11);     // Catch: Throwable -> L26 Exception -> L28
        r12.close();     // Catch: Throwable -> L26 Exception -> L28
        return r13;
    L28:
        r3 = r12;
    L26:
        th = th;
        r0 = r12;
        goto L34
        goto L37
    L22:
        r11.inPreferredConfig = Bitmap.Config.RGB_565;     // Catch: Throwable -> L20 Exception -> L41
    L20:
        th = th;
        r0 = r3;
        goto L34
    L39:
        return null;
    }

    public static Bitmap getBitmapFromSD(String r2) {
        File r0 = new File(r2);
        if (r0.exists() == true) goto L10;
        return null;
    L10:
        return decodeBitmap(r0);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Bitmap compressBitmap(String r2, int r3) {
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inJustDecodeBounds = false;
        r0.inSampleSize = r3;
        return BitmapFactory.decodeFile(r2, r0);
    }

    public static Bitmap decodeBitmap(File r1, int r2) {
        return decodeBitmap(r1, r2, false);
    }

    public static Bitmap decodeBitmap(File r7, int r8, boolean r9) {
        Bitmap r0 = null;
        BitmapFactory.Options r1 = new BitmapFactory.Options();     // Catch: Exception -> L15
        r1.inJustDecodeBounds = true;     // Catch: Exception -> L15
        FileInputStream r3 = new FileInputStream(r7);     // Catch: Exception -> L15
        BitmapFactory.decodeStream(r3, null, r1);     // Catch: Exception -> L15
        r3.close();     // Catch: Exception -> L15
        if (r1.outWidth > 0) goto L6;
    L24:
        r7.delete();     // Catch: Exception -> L15
        return null;
    L6:
        if (r1.outHeight <= 0) goto L24;
        int r4 = 1;
    L9:
        int r5 = r1.outWidth;     // Catch: Exception -> L15
        if (r5 < (r8 * 2)) goto L17;
        int r6 = r1.outHeight;     // Catch: Exception -> L15
        if (r6 < MAX_OUT_HEIGHT) goto L17;
        r1.outWidth = r5 / 2;     // Catch: Exception -> L15
        r1.outHeight = r6 / 2;     // Catch: Exception -> L15
        r4 = r4 * 2;     // Catch: Exception -> L15
    L17:
        BitmapFactory.Options r10 = new BitmapFactory.Options();     // Catch: Exception -> L15
        r10.inSampleSize = r4;     // Catch: Exception -> L15
        r10.inPurgeable = true;     // Catch: Exception -> L15
        if (r9 == false) goto L20;
        Bitmap.Config r11 = Bitmap.Config.ARGB_8888;     // Catch: Exception -> L15
    L21:
        r10.inPreferredConfig = r11;     // Catch: Exception -> L15
        FileInputStream r12 = new FileInputStream(r7);     // Catch: Exception -> L15
        r0 = BitmapFactory.decodeStream(r12, null, r10);     // Catch: Exception -> L15
        r12.close();     // Catch: Exception -> L15
        if (r0 != null) goto L27;
        r7.delete();     // Catch: Exception -> L15
    L27:
        return r0;
    L20:
        r11 = Bitmap.Config.RGB_565;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L27
    }

    public static Bitmap decodeBitmap(File r2) {
        FileInputStream r1 = null;
        if (r2.exists() == true) goto L40;
        return null;
    L40:
        FileInputStream r0 = new FileInputStream(r2);     // Catch: Throwable -> L16 Exception -> L18
        Bitmap r3 = BitmapFactory.decodeStream(r0);     // Catch: Throwable -> L12 Exception -> L14
        r0.close();     // Catch: Exception -> L9
    L11:
        return r3;
    L9:
        e = move-exception;
        e.printStackTrace();
    L14:
        e = e;
    L20:
        e.printStackTrace();     // Catch: Throwable -> L12
        r0.close();     // Catch: Exception -> L23
    L25:
        return null;
    L23:
        e = move-exception;
        e.printStackTrace();
    L12:
        th = th;
        r1 = r0;
    L38:
        r1.close();     // Catch: Exception -> L28
    L30:
        throw th;
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L30
    L18:
        e = e;
        r0 = null;
    L16:
        th = th;
        goto L38
    }

    public static Bitmap decodeBitmap(ContentResolver r4, Uri r5, int r6, int r7) {
        byte[] r0 = null;
        if (r4 == null) goto L23;
        if (r5 == null) goto L23;
        if (r6 < 1) goto L23;
        if (r7 < 1) goto L23;
        InputStream r8 = r4.openInputStream(r5);     // Catch: Exception -> L16
        if (r8 != null) goto L12;
        return null;
    L12:
        byte[] r9 = new byte[8192];     // Catch: Exception -> L16
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Exception -> L16
    L13:
        int r2 = r8.read(r9);     // Catch: Exception -> L16
        if (r2 == (-1)) goto L18;
        r1.write(r9, 0, r2);     // Catch: Exception -> L16
        goto L13
    L18:
        r0 = r1.toByteArray();     // Catch: Exception -> L16
    L22:
        return decodeBitmap(r0, r6, r7);
    L16:
        e = move-exception;
        e.printStackTrace();
    L23:
        return null;
    }

    public static Bitmap decodeBitmap(Context r6, int r7, int r8, int r9) {
        if (r6 == null) goto L22;
        if (r7 == 0) goto L22;
        if (r8 <= 0) goto L22;
        if (r9 <= 0) goto L22;
        Resources r10 = r6.getResources();
        BitmapFactory.Options r1 = new BitmapFactory.Options();     // Catch: Throwable -> L17 Exception -> L23
        r1.inJustDecodeBounds = true;     // Catch: Throwable -> L17 Exception -> L23
        BitmapFactory.decodeResource(r10, r7, r1);     // Catch: Throwable -> L17 Exception -> L23
        int r3 = r1.outWidth;     // Catch: Throwable -> L17 Exception -> L23
        int r2 = r1.outHeight;     // Catch: Throwable -> L17 Exception -> L23
        int r4 = 1;
    L11:
        if ((r3 / 2) < r8) goto L13;
    L19:
        r3 = r3 / 2;     // Catch: Throwable -> L17 Exception -> L23
        r2 = r2 / 2;     // Catch: Throwable -> L17 Exception -> L23
        r4 = r4 * 2;
        goto L11
    L13:
        if ((r2 / 2) >= r9) goto L19;
        BitmapFactory.Options r11 = new BitmapFactory.Options();     // Catch: Throwable -> L17 Exception -> L23
        r11.inSampleSize = r4;     // Catch: Throwable -> L17 Exception -> L23
        r11.inPurgeable = true;     // Catch: Throwable -> L17 Exception -> L23
        r11.inPreferredConfig = Bitmap.Config.RGB_565;     // Catch: Throwable -> L17 Exception -> L23
        return BitmapFactory.decodeResource(r10, r7, r11);
    L17:
        th = move-exception;
        throw th;
    L22:
        return null;
    }
}
