package com.bytedance.feedbackerlib.k.f.a;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.bytedance.feedbackerlib.matisse.internal.entity.Item;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    static {
    }

    public static Point a(ContentResolver r3, Uri r4) {
        InputStream r0 = null;
        BitmapFactory.Options r1 = new BitmapFactory.Options();     // Catch: Throwable -> L14 FileNotFoundException -> L29
        r1.inJustDecodeBounds = true;     // Catch: Throwable -> L14 FileNotFoundException -> L29
        InputStream r5 = r3.openInputStream(r4);     // Catch: Throwable -> L14 FileNotFoundException -> L29
        BitmapFactory.decodeStream(r5, null, r1);     // Catch: Throwable -> L11 FileNotFoundException -> L13
        Point r2 = new Point(r1.outWidth, r1.outHeight);     // Catch: Throwable -> L11 FileNotFoundException -> L13
        if (r5 != null) goto L36;
    L10:
        return r2;
    L36:
        r5.close();     // Catch: IOException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L13:
        r0 = r5;
    L11:
        th = th;
        r0 = r5;
    L23:
        if (r0 != null) goto L32;
    L28:
        throw th;
    L32:
        r0.close();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
    L14:
        th = th;
    L16:
        Point r6 = new Point(0, 0);     // Catch: Throwable -> L14
        if (r0 != null) goto L30;
    L22:
        return r6;
    L30:
        r0.close();     // Catch: IOException -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    public static Point b(Uri r4, Activity r5) {
        ContentResolver r0 = r5.getContentResolver();
        Point r1 = a(r0, r4);
        int r2 = r1.x;
        int r3 = r1.y;
        if (g(r0, r4) == false) goto L5;
        r2 = r1.y;
        r3 = r1.x;
    L5:
        if (r3 == 0) goto L7;
        DisplayMetrics r6 = new DisplayMetrics();
        r5.getWindowManager().getDefaultDisplay().getMetrics(r6);
        float r7 = r2;
        float r8 = r6.widthPixels / r7;
        float r9 = r3;
        float r10 = r6.heightPixels / r9;
        if (r8 <= r10) goto L13;
        return new Point((int) (r7 * r8), (int) (r9 * r10));
    L13:
        return new Point((int) (r7 * r8), (int) (r9 * r10));
    L7:
        return new Point(1600, 1600);
    }

    public static String c(ContentResolver r9, Uri r10) {
        Cursor r1 = null;
        if (r10 != null) goto L6;
        return null;
    L6:
        if ("content".equals(r10.getScheme()) == false) goto L26;
        Cursor r11 = r9.query(r10, new String[]{"_data"}, null, null, null);     // Catch: Throwable -> L21
        if (r11 != null) goto L27;
    L18:
        if (r11 == null) goto L20;
        r11.close();
    L20:
        return null;
    L27:
    L16:
        th = th;
        r1 = r11;
    L22:
        if (r1 == null) goto L24;
        r1.close();
    L24:
        throw th;
    L10:
        if (r11.moveToFirst() == false) goto L18;
        String r12 = r11.getString(r11.getColumnIndex("_data"));     // Catch: Throwable -> L16
        if (r11 == null) goto L15;
        r11.close();
    L15:
        return r12;
    L21:
        th = th;
        goto L22
    L26:
        return r10.getPath();
    }

    public static float d(long r2) {
        DecimalFormat r0 = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
        r0.applyPattern("0.0");
        return Float.valueOf(r0.format((r2 / 1024.0f) / 1024.0f).replaceAll(",", ".")).floatValue();
    }

    public static com.bytedance.feedbackerlib.matisse.internal.entity.b e(Context r2, Item r3) {
        if (f(r2, r3) == true) goto L7;
        return new com.bytedance.feedbackerlib.matisse.internal.entity.b(r2.getString(com.bytedance.feedbackerlib.g.f4036a));
    L7:
        if (com.bytedance.feedbackerlib.matisse.internal.entity.c.b().f4354j == null) goto L14;
        Iterator<com.bytedance.feedbackerlib.k.e.a> r0 = com.bytedance.feedbackerlib.matisse.internal.entity.c.b().f4354j.iterator();
    L10:
        if (r0.hasNext() == false) goto L19;
        com.bytedance.feedbackerlib.matisse.internal.entity.b r1 = r0.next().a(r2, r3);
        if (r1 == null) goto L10;
        return r1;
    L19:
        return null;
    L14:
        return null;
    }

    private static boolean f(Context r4, Item r5) {
        if (r4 != null) goto L5;
        return false;
    L5:
        ContentResolver r6 = r4.getContentResolver();
        Iterator<com.bytedance.feedbackerlib.k.b> r1 = com.bytedance.feedbackerlib.matisse.internal.entity.c.b().f4345a.iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        if (r1.next().b(r6, r5.b()) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private static boolean g(ContentResolver r2, Uri r3) {
        int r4 = a.a(c(r2, r3)).getAttributeInt("Orientation", -1);
        if (r4 != 6) goto L7;
    L8:
        return true;
    L7:
        if (r4 == 8) goto L8;
        return false;
    L14:
        return false;
    }
}
