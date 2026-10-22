package com.bumptech.glide.util;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.model.Model;
import com.bumptech.glide.request.BaseRequestOptions;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class Util {
    private static final int HASH_ACCUMULATOR = 17;
    private static final int HASH_MULTIPLIER = 31;
    private static final char[] HEX_CHAR_ARRAY = null;
    private static final char[] SHA_256_CHARS = null;
    private static volatile Handler mainThreadHandler;

    /* JADX INFO: renamed from: com.bumptech.glide.util.Util$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = null;

        static {
            int[] r0 = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = r0;
            r0[Bitmap.Config.ALPHA_8.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGBA_F16.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static int hashCode(int r0, int r1) {
        return (r1 * 31) + r0;
    }

    public static boolean isValidDimension(int r1) {
        if (r1 <= 0) goto L4;
    L7:
        return true;
    L4:
        if (r1 == Integer.MIN_VALUE) goto L7;
        return false;
    }

    static {
        HEX_CHAR_ARRAY = "0123456789abcdef".toCharArray();
        SHA_256_CHARS = new char[64];
    }

    private Util() {
    }

    public static String sha256BytesToHex(byte[] r1) {
        char[] r0 = SHA_256_CHARS;
        monitor-enter(r0);
        String r2 = bytesToHex(r1, r0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    private static String bytesToHex(byte[] r5, char[] r6) {
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L7;
        int r1 = r5[r0] & UByte.MAX_VALUE;
        int r2 = r0 * 2;
        char[] r3 = HEX_CHAR_ARRAY;
        r6[r2] = r3[r1 >>> 4];
        r6[r2 + 1] = r3[r1 & 15];
        r0 = r0 + 1;
        goto L4
    L7:
        return new String(r6);
    }

    @Deprecated
    public static int getSize(Bitmap r0) {
        return getBitmapByteSize(r0);
    }

    public static int getBitmapByteSize(Bitmap r3) {
        if (r3.isRecycled() == true) goto L9;
        return r3.getAllocationByteCount();
    L7:
        return r3.getHeight() * r3.getRowBytes();
    L9:
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + r3 + "[" + r3.getWidth() + MaterialConfigFormatNames.X + r3.getHeight() + "] " + r3.getConfig());
    }

    public static int getBitmapByteSize(int r0, int r1, Bitmap.Config r2) {
        return (r0 * r1) * getBytesPerPixel(r2);
    }

    public static int getBytesPerPixel(Bitmap.Config r2) {
        if (r2 != null) goto L4;
        r2 = Bitmap.Config.ARGB_8888;
    L4:
        int r3 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[r2.ordinal()];
        if (r3 != 1) goto L7;
        return 1;
    L7:
        if (r3 != 2) goto L9;
        return 2;
    L9:
        if (r3 != 3) goto L11;
        return 2;
    L11:
        if (r3 != 4) goto L18;
        return 8;
    L18:
        return 4;
    }

    public static boolean isValidDimensions(int r0, int r1) {
        if (isValidDimension(r0) == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidDimension(r1) == false) goto L7;
        return true;
    }

    public static void postOnUiThread(Runnable r1) {
        getUiThreadHandler().post(r1);
    }

    public static void removeCallbacksOnUiThread(Runnable r1) {
        getUiThreadHandler().removeCallbacks(r1);
    }

    private static Handler getUiThreadHandler() {
        if (mainThreadHandler != null) goto L15;
        monitor-enter(Util.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mainThreadHandler != null) goto L9;
        mainThreadHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(Util.class);     // Catch: Throwable -> L11
    L15:
        return mainThreadHandler;
    }

    public static void assertMainThread() {
        if (isOnMainThread() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("You must call this method on the main thread");
    }

    public static void assertBackgroundThread() {
        if (isOnBackgroundThread() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("You must call this method on a background thread");
    }

    public static boolean isOnMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isOnBackgroundThread() {
        return !isOnMainThread();
    }

    public static <T> Queue<T> createQueue(int r1) {
        return new ArrayDeque(r1);
    }

    public static <T> List<T> getSnapshot(Collection<T> r2) {
        ArrayList r0 = new ArrayList(r2.size());
        Iterator<T> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        T r1 = r3.next();
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    public static boolean bothNullOrEqual(Object r0, Object r1) {
        if (r0 != null) goto L7;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r0.equals(r1);
    }

    public static boolean bothModelsNullEquivalentOrEquals(Object r1, Object r2) {
        if (r1 != null) goto L8;
        if (r2 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        if ((r1 instanceof Model) == false) goto L12;
        return ((Model) r1).isEquivalentTo(r2);
    L12:
        return r1.equals(r2);
    }

    public static boolean bothBaseRequestOptionsNullEquivalentOrEquals(BaseRequestOptions<?> r0, BaseRequestOptions<?> r1) {
        if (r0 != null) goto L8;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r0.isEquivalentTo(r1);
    }

    public static int hashCode(int r1) {
        return hashCode(r1, 17);
    }

    public static int hashCode(float r1) {
        return hashCode(r1, 17);
    }

    public static int hashCode(float r0, int r1) {
        return hashCode(Float.floatToIntBits(r0), r1);
    }

    public static int hashCode(Object r0, int r1) {
        if (r0 != null) goto L4;
        int r2 = 0;
    L6:
        return hashCode(r2, r1);
    L4:
        r2 = r0.hashCode();
        goto L6
    }

    public static int hashCode(boolean r0, int r1) {
        return hashCode(r0 ? 1 : 0, r1);
    }

    public static int hashCode(boolean r1) {
        return hashCode(r1, 17);
    }
}
