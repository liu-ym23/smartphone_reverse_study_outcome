package com.facebook.webpsupport;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.TypedValue;
import d.c.c.d.d;
import d.c.c.l.a;
import d.c.c.l.b;
import d.c.c.l.c;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@d
public class WebpBitmapFactoryImpl implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f6841a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b.a f6842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f6843c;

    static {
        if (Build.VERSION.SDK_INT < 11) goto L5;
        boolean r0 = true;
    L6:
        f6841a = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public WebpBitmapFactoryImpl() {
    }

    @d
    private static Bitmap createBitmap(int r1, int r2, BitmapFactory.Options r3) {
        if (f6841a == false) goto L12;
        if (r3 == null) goto L12;
        Bitmap r0 = r3.inBitmap;
        if (r0 == null) goto L12;
        if (r0.isMutable() == false) goto L12;
        return r3.inBitmap;
    L12:
        return f6843c.a(r1, r2, Bitmap.Config.ARGB_8888);
    }

    private static byte[] e(InputStream r2, BitmapFactory.Options r3) {
        r2.mark(20);
        if (r3 == null) goto L9;
        byte[] r4 = r3.inTempStorage;
        if (r4 == null) goto L9;
        if (r4.length < 20) goto L9;
    L15:
        r2.read(r4, 0, 20);     // Catch: IOException -> L13
        r2.reset();     // Catch: IOException -> L13
        return r4;
    L13:
        return null;
    L9:
        r4 = new byte[20];
        goto L15
    }

    private static void f(String r2) {
        b.a r0 = f6842b;
        if (r0 == null) goto L6;
        r0.a(r2, "decoding_failure");
        return;
    }

    private static void g(Bitmap r3, BitmapFactory.Options r4) {
        if (r3 == null) goto L29;
        if (r4 == null) goto L34;
        int r0 = r4.inDensity;
        if (r0 == 0) goto L18;
        r3.setDensity(r0);
        int r1 = r4.inTargetDensity;
        if (r1 == 0) goto L16;
        if (r0 != r1) goto L11;
        return;
    L11:
        if (r0 != r4.inScreenDensity) goto L14;
        return;
    L14:
        if (r4.inScaled == false) goto L30;
        r3.setDensity(r1);
        return;
    L30:
        return;
    L16:
        return;
    L18:
        if (f6841a == true) goto L20;
        return;
    L20:
        if (r4.inBitmap == null) goto L33;
        int r5 = Resources.getSystem().getDisplayMetrics().densityDpi;
        if (r5 != 0) goto L25;
        r5 = 160;
    L25:
        r3.setDensity(r5);
        return;
    L33:
        return;
    L34:
        return;
    }

    @d
    private static byte[] getInTempStorageFromOptions(BitmapFactory.Options r0) {
        if (r0 == null) goto L7;
        byte[] r1 = r0.inTempStorage;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new byte[8192];
    }

    @d
    private static float getScaleFromOptions(BitmapFactory.Options r3) {
        float r0 = 1.0f;
        if (r3 == null) goto L15;
        int r1 = r3.inSampleSize;
        if (r1 <= 1) goto L8;
        r0 = 1.0f / r1;
    L8:
        if (r3.inScaled == false) goto L16;
        int r2 = r3.inDensity;
        int r4 = r3.inTargetDensity;
        int r5 = r3.inScreenDensity;
        if (r2 == 0) goto L17;
        if (r4 == 0) goto L18;
        if (r2 != r5) goto L14;
        return r0;
    L14:
        return r4 / r2;
    L18:
        return r0;
    L17:
        return r0;
    L16:
        return r0;
    L15:
        return 1.0f;
    }

    private static void h(Bitmap r0, BitmapFactory.Options r1) {
        g(r0, r1);
        if (r1 == null) goto L6;
        r1.outMimeType = "image/webp";
        return;
    }

    @d
    public static Bitmap hookDecodeByteArray(byte[] r1, int r2, int r3) {
        return hookDecodeByteArray(r1, r2, r3, null);
    }

    @d
    public static Bitmap hookDecodeByteArray(byte[] r7, int r8, int r9, BitmapFactory.Options r10) {
        com.facebook.imagepipeline.nativecode.d.a();
        if (c.f15447a == true) goto L5;
    L10:
        Bitmap r11 = originalDecodeByteArray(r7, r8, r9, r10);
        if (r11 != null) goto L13;
        f("webp_direct_decode_array_failed_on_no_webp");
    L13:
        return r11;
    L5:
        if (c.h(r7, r8, r9) == false) goto L10;
        r11 = nativeDecodeByteArray(r7, r8, r9, r10, getScaleFromOptions(r10), getInTempStorageFromOptions(r10));
        if (r11 != null) goto L9;
        f("webp_direct_decode_array");
    L9:
        h(r11, r10);
        goto L13
    }

    @d
    public static Bitmap hookDecodeFile(String r1) {
        return hookDecodeFile(r1, null);
    }

    @d
    public static Bitmap hookDecodeFile(String r2, BitmapFactory.Options r3) {
        Bitmap r0 = null;
        FileInputStream r1 = new FileInputStream(r2);     // Catch: Exception -> L16
        r0 = hookDecodeStream(r1, null, r3);     // Catch: Throwable -> L7
        r1.close();     // Catch: Exception -> L16
        goto L15
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L12
    L14:
        throw th;     // Catch: Exception -> L16
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L16
    L15:
        return r0;
    }

    @d
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor r1) {
        return hookDecodeFileDescriptor(r1, null, null);
    }

    @d
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor r6, Rect r7, BitmapFactory.Options r8) {
        com.facebook.imagepipeline.nativecode.d.a();
        long r0 = nativeSeek(r6, 0, false);
        if (r0 == (-1)) goto L21;
        InputStream r3 = i(new FileInputStream(r6));
        byte[] r4 = e(r3, r8);     // Catch: Throwable -> L18
        if (c.f15447a == true) goto L8;
    L13:
        nativeSeek(r6, r0, true);     // Catch: Throwable -> L18
        Bitmap r9 = originalDecodeFileDescriptor(r6, r7, r8);     // Catch: Throwable -> L18
        if (r9 != null) goto L26;
        f("webp_direct_decode_fd_failed_on_no_webp");     // Catch: Throwable -> L18
    L26:
        r3.close();     // Catch: Throwable -> L23
        return r9;
    L31:
        return r9;
    L8:
        if (c.h(r4, 0, 20) == false) goto L13;
        r9 = nativeDecodeStream(r3, r8, getScaleFromOptions(r8), getInTempStorageFromOptions(r8));     // Catch: Throwable -> L18
        if (r9 != null) goto L12;
        f("webp_direct_decode_fd");     // Catch: Throwable -> L18
    L12:
        setPaddingDefaultValues(r7);     // Catch: Throwable -> L18
        h(r9, r8);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L24
    L20:
        throw th;
    L21:
        Bitmap r10 = hookDecodeStream(new FileInputStream(r6), r7, r8);
        setPaddingDefaultValues(r7);
        return r10;
    }

    @d
    public static Bitmap hookDecodeResource(Resources r1, int r2) {
        return hookDecodeResource(r1, r2, null);
    }

    @d
    public static Bitmap hookDecodeResource(Resources r2, int r3, BitmapFactory.Options r4) {
        TypedValue r0 = new TypedValue();
        Bitmap r1 = null;
        InputStream r5 = r2.openRawResource(r3, r0);     // Catch: Exception -> L27
        r1 = hookDecodeResourceStream(r2, r0, r5, null, r4);     // Catch: Throwable -> L8
        if (r5 == null) goto L18;
        r5.close();     // Catch: Exception -> L27
        goto L18
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r5 != null) goto L32;
    L16:
        throw th;     // Catch: Exception -> L27
    L32:
        r5.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L27
    L18:
        if (f6841a == false) goto L26;
        if (r1 != null) goto L26;
        if (r4 == null) goto L26;
        if (r4.inBitmap == null) goto L26;
        throw new IllegalArgumentException("Problem decoding into existing bitmap");
    L26:
        return r1;
    }

    @d
    public static Bitmap hookDecodeResourceStream(Resources r1, TypedValue r2, InputStream r3, Rect r4, BitmapFactory.Options r5) {
        if (r5 != null) goto L5;
        r5 = new BitmapFactory.Options();
    L5:
        if (r5.inDensity != 0) goto L15;
        if (r2 == null) goto L15;
        int r6 = r2.density;
        if (r6 != 0) goto L12;
        r6 = 160;
    L10:
        r5.inDensity = r6;
        goto L15
    L12:
        if (r6 != 65535) goto L10;
    L15:
        if (r5.inTargetDensity != 0) goto L19;
        if (r1 == null) goto L19;
        r5.inTargetDensity = r1.getDisplayMetrics().densityDpi;
    L19:
        return hookDecodeStream(r3, r4, r5);
    }

    @d
    public static Bitmap hookDecodeStream(InputStream r1) {
        return hookDecodeStream(r1, null, null);
    }

    @d
    public static Bitmap hookDecodeStream(InputStream r3, Rect r4, BitmapFactory.Options r5) {
        com.facebook.imagepipeline.nativecode.d.a();
        InputStream r6 = i(r3);
        byte[] r0 = e(r6, r5);
        if (c.f15447a == true) goto L7;
        if (Build.VERSION.SDK_INT == 28) goto L7;
    L14:
        Bitmap r7 = originalDecodeStream(r6, r4, r5);
        if (r7 != null) goto L17;
        f("webp_direct_decode_stream_failed_on_no_webp");
    L17:
        return r7;
    L7:
        if (c.h(r0, 0, 20) == false) goto L14;
        if (r5.inPreferredConfig != Bitmap.Config.ARGB_8888) goto L14;
        r7 = nativeDecodeStream(r6, r5, getScaleFromOptions(r5), getInTempStorageFromOptions(r5));
        if (r7 != null) goto L13;
        f("webp_direct_decode_stream");
    L13:
        h(r7, r5);
        setPaddingDefaultValues(r4);
        goto L17
    }

    private static InputStream i(InputStream r2) {
        if (r2.markSupported() == false) goto L5;
        return r2;
    L5:
        return new BufferedInputStream(r2, 20);
    }

    @d
    private static native Bitmap nativeDecodeByteArray(byte[] r0, int r1, int r2, BitmapFactory.Options r3, float r4, byte[] r5);

    @d
    private static native Bitmap nativeDecodeStream(InputStream r0, BitmapFactory.Options r1, float r2, byte[] r3);

    @d
    private static native long nativeSeek(FileDescriptor r0, long r1, boolean r3);

    @d
    private static Bitmap originalDecodeByteArray(byte[] r0, int r1, int r2) {
        return BitmapFactory.decodeByteArray(r0, r1, r2);
    }

    @d
    private static Bitmap originalDecodeByteArray(byte[] r0, int r1, int r2, BitmapFactory.Options r3) {
        return BitmapFactory.decodeByteArray(r0, r1, r2, r3);
    }

    @d
    private static Bitmap originalDecodeFile(String r0) {
        return BitmapFactory.decodeFile(r0);
    }

    @d
    private static Bitmap originalDecodeFile(String r0, BitmapFactory.Options r1) {
        return BitmapFactory.decodeFile(r0, r1);
    }

    @d
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor r0) {
        return BitmapFactory.decodeFileDescriptor(r0);
    }

    @d
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor r0, Rect r1, BitmapFactory.Options r2) {
        return BitmapFactory.decodeFileDescriptor(r0, r1, r2);
    }

    @d
    private static Bitmap originalDecodeResource(Resources r0, int r1) {
        return BitmapFactory.decodeResource(r0, r1);
    }

    @d
    private static Bitmap originalDecodeResource(Resources r0, int r1, BitmapFactory.Options r2) {
        return BitmapFactory.decodeResource(r0, r1, r2);
    }

    @d
    private static Bitmap originalDecodeResourceStream(Resources r0, TypedValue r1, InputStream r2, Rect r3, BitmapFactory.Options r4) {
        return BitmapFactory.decodeResourceStream(r0, r1, r2, r3, r4);
    }

    @d
    private static Bitmap originalDecodeStream(InputStream r0) {
        return BitmapFactory.decodeStream(r0);
    }

    @d
    private static Bitmap originalDecodeStream(InputStream r0, Rect r1, BitmapFactory.Options r2) {
        return BitmapFactory.decodeStream(r0, r1, r2);
    }

    @d
    private static void setBitmapSize(BitmapFactory.Options r0, int r1, int r2) {
        if (r0 == null) goto L5;
        r0.outWidth = r1;
        r0.outHeight = r2;
        return;
    }

    @d
    private static boolean setOutDimensions(BitmapFactory.Options r1, int r2, int r3) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.inJustDecodeBounds == false) goto L9;
        r1.outWidth = r2;
        r1.outHeight = r3;
        return true;
    L9:
        return false;
    }

    @d
    private static void setPaddingDefaultValues(Rect r1) {
        if (r1 == null) goto L5;
        r1.top = -1;
        r1.left = -1;
        r1.bottom = -1;
        r1.right = -1;
        return;
    }

    @d
    @SuppressLint({"NewApi"})
    private static boolean shouldPremultiply(BitmapFactory.Options r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        if (r2 != null) goto L6;
        return true;
    L6:
        return r2.inPremultiplied;
    L7:
        return true;
    }

    @Override // d.c.c.l.b
    public void a(a r1) {
        f6843c = r1;
    }

    @Override // d.c.c.l.b
    public Bitmap b(InputStream r1, Rect r2, BitmapFactory.Options r3) {
        return hookDecodeStream(r1, r2, r3);
    }

    @Override // d.c.c.l.b
    public void c(b.a r1) {
        f6842b = r1;
    }

    @Override // d.c.c.l.b
    public Bitmap d(FileDescriptor r1, Rect r2, BitmapFactory.Options r3) {
        return hookDecodeFileDescriptor(r1, r2, r3);
    }
}
