package com.facebook.imageutils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.util.Pair;
import androidx.core.util.Pools;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pools.SynchronizedPool<ByteBuffer> f6766a = null;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6767a = null;

        static {
            int[] r0 = new int[Bitmap.Config.values().length];
            f6767a = r0;
            r0[Bitmap.Config.ARGB_8888.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f6767a[Bitmap.Config.ALPHA_8.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f6767a[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f6767a[Bitmap.Config.RGB_565.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f6767a[Bitmap.Config.RGBA_F16.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        f6766a = new Pools.SynchronizedPool(12);
    }

    public static Pair<Integer, Integer> a(InputStream r5) {
        d.c.c.d.i.g(r5);
        Pools.SynchronizedPool<ByteBuffer> r0 = f6766a;
        ByteBuffer r1 = r0.acquire();
        if (r1 != null) goto L5;
        r1 = ByteBuffer.allocate(16384);
    L5:
        BitmapFactory.Options r2 = new BitmapFactory.Options();
        r2.inJustDecodeBounds = true;
        r2.inTempStorage = r1.array();     // Catch: Throwable -> L14
        Pair<Integer, Integer> r3 = null;
        BitmapFactory.decodeStream(r5, null, r2);     // Catch: Throwable -> L14
        if (r2.outWidth != (-1)) goto L9;
    L12:
        r0.release(r1);
        return r3;
    L9:
        if (r2.outHeight == (-1)) goto L12;
        r3 = new Pair(Integer.valueOf(r2.outWidth), Integer.valueOf(r2.outHeight));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        f6766a.release(r1);
        throw th;
    }

    public static e b(InputStream r5) {
        d.c.c.d.i.g(r5);
        Pools.SynchronizedPool<ByteBuffer> r0 = f6766a;
        ByteBuffer r1 = r0.acquire();
        if (r1 != null) goto L5;
        r1 = ByteBuffer.allocate(16384);
    L5:
        BitmapFactory.Options r2 = new BitmapFactory.Options();
        r2.inJustDecodeBounds = true;
        r2.inTempStorage = r1.array();     // Catch: Throwable -> L12
        ColorSpace r3 = null;
        BitmapFactory.decodeStream(r5, null, r2);     // Catch: Throwable -> L12
        if (Build.VERSION.SDK_INT < 26) goto L9;
        r3 = r2.outColorSpace;     // Catch: Throwable -> L12
    L9:
        e r6 = new e(r2.outWidth, r2.outHeight, r3);     // Catch: Throwable -> L12
        r0.release(r1);
        return r6;
    L12:
        th = move-exception;
        f6766a.release(r1);
        throw th;
    }

    public static int c(Bitmap.Config r3) {
        int r4 = a.f6767a[r3.ordinal()];
        if (r4 != 1) goto L5;
        return 4;
    L5:
        if (r4 != 2) goto L7;
        return 1;
    L7:
        if (r4 == 3) goto L15;
        if (r4 == 4) goto L15;
        if (r4 != 5) goto L14;
        return 8;
    L14:
        throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
    L15:
        return 2;
    }

    public static int d(int r0, int r1, Bitmap.Config r2) {
        return (r0 * r1) * c(r2);
    }

    @SuppressLint({"NewApi"})
    public static int e(Bitmap r2) {
        int r0 = Build.VERSION.SDK_INT;
        if (r2 != null) goto L7;
        return 0;
    L7:
        if (r0 <= 19) goto L11;
        return r2.getAllocationByteCount();
    L11:
        if (r0 < 12) goto L15;
        return r2.getByteCount();
    L15:
        return r2.getRowBytes() * r2.getHeight();
    }
}
