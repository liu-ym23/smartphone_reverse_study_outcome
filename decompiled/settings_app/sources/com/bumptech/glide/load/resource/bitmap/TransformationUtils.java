package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes3.dex */
public final class TransformationUtils {
    private static final Lock BITMAP_DRAWABLE_LOCK = null;
    private static final Paint CIRCLE_CROP_BITMAP_PAINT = null;
    private static final int CIRCLE_CROP_PAINT_FLAGS = 7;
    private static final Paint CIRCLE_CROP_SHAPE_PAINT = null;
    private static final Paint DEFAULT_PAINT = null;
    private static final Set<String> MODELS_REQUIRING_BITMAP_LOCK = null;
    public static final int PAINT_FLAGS = 6;
    private static final String TAG = "TransformationUtils";

    private interface DrawRoundedCornerFn {
        void drawRoundedCorners(Canvas r1, Paint r2, RectF r3);
    }

    private static final class NoLock implements Lock {
        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long r1, TimeUnit r3) throws InterruptedException {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }

        NoLock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }
    }

    public static int getExifOrientationDegrees(int r0) {
        switch(r0) {
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L4;
            case 8: goto L4;
            default: goto L3;
        };
    L3:
        return 0;
    L4:
        return 270;
    L5:
        return 90;
    L6:
        return 180;
    }

    public static boolean isExifOrientationRequired(int r0) {
        switch(r0) {
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    static {
        DEFAULT_PAINT = new Paint(6);
        CIRCLE_CROP_SHAPE_PAINT = new Paint(7);
        HashSet r0 = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        MODELS_REQUIRING_BITMAP_LOCK = r0;
        if (r0.contains(Build.MODEL) == false) goto L5;
        Lock r1 = new ReentrantLock();
    L6:
        BITMAP_DRAWABLE_LOCK = r1;
        Paint r2 = new Paint(7);
        CIRCLE_CROP_BITMAP_PAINT = r2;
        r2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        return;
    L5:
        r1 = new NoLock();
        goto L6
    }

    private TransformationUtils() {
    }

    public static Lock getBitmapDrawableLock() {
        return BITMAP_DRAWABLE_LOCK;
    }

    public static Bitmap centerCrop(BitmapPool r7, Bitmap r8, int r9, int r10) {
        if (r8.getWidth() == r9) goto L5;
    L7:
        Matrix r0 = new Matrix();
        float r3 = 0.0f;
        if ((r8.getWidth() * r10) <= (r8.getHeight() * r9)) goto L10;
        float r1 = r10 / r8.getHeight();
        r3 = (r9 - (r8.getWidth() * r1)) * 0.5f;
        float r2 = 0.0f;
    L11:
        r0.setScale(r1, r1);
        r0.postTranslate((int) (r3 + 0.5f), (int) (r2 + 0.5f));
        Bitmap r11 = r7.get(r9, r10, getNonNullConfig(r8));
        setAlpha(r8, r11);
        applyMatrix(r8, r11, r0);
        return r11;
    L10:
        r1 = r9 / r8.getWidth();
        r2 = (r10 - (r8.getHeight() * r1)) * 0.5f;
        goto L11
    L5:
        if (r8.getHeight() != r10) goto L7;
        return r8;
    }

    public static Bitmap fitCenter(BitmapPool r6, Bitmap r7, int r8, int r9) {
        if (r7.getWidth() == r8) goto L5;
    L10:
        float r0 = Math.min(r8 / r7.getWidth(), r9 / r7.getHeight());
        int r3 = Math.round(r7.getWidth() * r0);
        int r4 = Math.round(r7.getHeight() * r0);
        if (r7.getWidth() == r3) goto L13;
    L18:
        Bitmap r10 = r6.get((int) (r7.getWidth() * r0), (int) (r7.getHeight() * r0), getNonNullConfig(r7));
        setAlpha(r7, r10);
        if (Log.isLoggable(TAG, 2) == false) goto L21;
        Log.v(TAG, "request: " + r8 + MaterialConfigFormatNames.X + r9);
        Log.v(TAG, "toFit:   " + r7.getWidth() + MaterialConfigFormatNames.X + r7.getHeight());
        Log.v(TAG, "toReuse: " + r10.getWidth() + MaterialConfigFormatNames.X + r10.getHeight());
        Log.v(TAG, "minPct:   " + r0);
    L21:
        Matrix r11 = new Matrix();
        r11.setScale(r0, r0);
        applyMatrix(r7, r10, r11);
        return r10;
    L13:
        if (r7.getHeight() != r4) goto L18;
        if (Log.isLoggable(TAG, 2) == false) goto L17;
        Log.v(TAG, "adjusted target size matches input, returning input");
    L17:
        return r7;
    L5:
        if (r7.getHeight() != r9) goto L10;
        if (Log.isLoggable(TAG, 2) == false) goto L9;
        Log.v(TAG, "requested target size matches input, returning input");
    L9:
        return r7;
    }

    public static Bitmap centerInside(BitmapPool r3, Bitmap r4, int r5, int r6) {
        if (r4.getWidth() > r5) goto L11;
        if (r4.getHeight() > r6) goto L11;
        if (Log.isLoggable(TAG, 2) == false) goto L9;
        Log.v(TAG, "requested target size larger or equal to input, returning input");
    L9:
        return r4;
    L11:
        if (Log.isLoggable(TAG, 2) == false) goto L14;
        Log.v(TAG, "requested target size too big for input, fit centering instead");
    L14:
        return fitCenter(r3, r4, r5, r6);
    }

    public static void setAlpha(Bitmap r0, Bitmap r1) {
        r1.setHasAlpha(r0.hasAlpha());
    }

    public static Bitmap rotateImage(Bitmap r7, int r8) {
        if (r8 == 0) goto L12;
        Matrix r5 = new Matrix();     // Catch: Exception -> L5
        r5.setRotate(r8);     // Catch: Exception -> L5
        return Bitmap.createBitmap(r7, 0, 0, r7.getWidth(), r7.getHeight(), r5, true);
    L5:
        e = move-exception;
        if (Log.isLoggable(TAG, 6) == false) goto L13;
        Log.e(TAG, "Exception when trying to orient image", e);
        return r7;
    L13:
        return r7;
    L12:
        return r7;
    }

    public static Bitmap rotateImageExif(BitmapPool r4, Bitmap r5, int r6) {
        if (isExifOrientationRequired(r6) == true) goto L5;
        return r5;
    L5:
        Matrix r0 = new Matrix();
        initializeMatrixForRotation(r6, r0);
        RectF r7 = new RectF(0.0f, 0.0f, r5.getWidth(), r5.getHeight());
        r0.mapRect(r7);
        Bitmap r8 = r4.get(Math.round(r7.width()), Math.round(r7.height()), getNonNullConfig(r5));
        r0.postTranslate(-r7.left, -r7.top);
        r8.setHasAlpha(r5.hasAlpha());
        applyMatrix(r5, r8, r0);
        return r8;
    }

    public static Bitmap circleCrop(BitmapPool r6, Bitmap r7, int r8, int r9) {
        int r10 = Math.min(r8, r9);
        float r11 = r10;
        float r1 = r11 / 2.0f;
        float r2 = r7.getWidth();
        float r3 = r7.getHeight();
        float r4 = Math.max(r11 / r2, r11 / r3);
        float r5 = r2 * r4;
        float r12 = r4 * r3;
        float r13 = (r11 - r5) / 2.0f;
        float r14 = (r11 - r12) / 2.0f;
        RectF r0 = new RectF(r13, r14, r5 + r13, r12 + r14);
        Bitmap r15 = getAlphaSafeBitmap(r6, r7);
        Bitmap r16 = r6.get(r10, r10, getAlphaSafeConfig(r7));
        r16.setHasAlpha(true);
        Lock r17 = BITMAP_DRAWABLE_LOCK;
        r17.lock();
        Canvas r18 = new Canvas(r16);     // Catch: Throwable -> L8
        r18.drawCircle(r1, r1, r1, CIRCLE_CROP_SHAPE_PAINT);     // Catch: Throwable -> L8
        r18.drawBitmap(r15, null, r0, CIRCLE_CROP_BITMAP_PAINT);     // Catch: Throwable -> L8
        clear(r18);     // Catch: Throwable -> L8
        r17.unlock();
        if (r15.equals(r7) == true) goto L7;
        r6.put(r15);
    L7:
        return r16;
    L8:
        th = move-exception;
        BITMAP_DRAWABLE_LOCK.unlock();
        throw th;
    }

    private static Bitmap getAlphaSafeBitmap(BitmapPool r3, Bitmap r4) {
        Bitmap.Config r0 = getAlphaSafeConfig(r4);
        if (r0.equals(r4.getConfig()) == false) goto L5;
        return r4;
    L5:
        Bitmap r5 = r3.get(r4.getWidth(), r4.getHeight(), r0);
        new Canvas(r5).drawBitmap(r4, 0.0f, 0.0f, null);
        return r5;
    }

    private static Bitmap.Config getAlphaSafeConfig(Bitmap r1) {
        if (Bitmap.Config.RGBA_F16.equals(r1.getConfig()) == false) goto L7;
        return Bitmap.Config.RGBA_F16;
    L7:
        return Bitmap.Config.ARGB_8888;
    }

    @Deprecated
    public static Bitmap roundedCorners(BitmapPool r0, Bitmap r1, int r2, int r3, int r4) {
        return roundedCorners(r0, r1, r4);
    }

    public static Bitmap roundedCorners(BitmapPool r2, Bitmap r3, final int r4) {
        if (r4 <= 0) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0, "roundingRadius must be greater than 0.");
        return roundedCorners(r2, r3, new AnonymousClass1(r4));
    L4:
        r0 = false;
        goto L5
    }

    public static Bitmap roundedCorners(BitmapPool r1, Bitmap r2, final float r3, final float r4, final float r5, final float r6) {
        return roundedCorners(r1, r2, new AnonymousClass2(r3, r4, r5, r6));
    }

    private static Bitmap roundedCorners(BitmapPool r8, Bitmap r9, DrawRoundedCornerFn r10) {
        Bitmap.Config r0 = getAlphaSafeConfig(r9);
        Bitmap r1 = getAlphaSafeBitmap(r8, r9);
        Bitmap r2 = r8.get(r1.getWidth(), r1.getHeight(), r0);
        r2.setHasAlpha(true);
        BitmapShader r3 = new BitmapShader(r1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint r4 = new Paint();
        r4.setAntiAlias(true);
        r4.setShader(r3);
        RectF r5 = new RectF(0.0f, 0.0f, r2.getWidth(), r2.getHeight());
        Lock r6 = BITMAP_DRAWABLE_LOCK;
        r6.lock();
        Canvas r7 = new Canvas(r2);     // Catch: Throwable -> L8
        r7.drawColor(0, PorterDuff.Mode.CLEAR);     // Catch: Throwable -> L8
        r10.drawRoundedCorners(r7, r4, r5);     // Catch: Throwable -> L8
        clear(r7);     // Catch: Throwable -> L8
        r6.unlock();
        if (r1.equals(r9) == true) goto L7;
        r8.put(r1);
    L7:
        return r2;
    L8:
        th = move-exception;
        BITMAP_DRAWABLE_LOCK.unlock();
        throw th;
    }

    private static void clear(Canvas r1) {
        r1.setBitmap(null);
    }

    private static Bitmap.Config getNonNullConfig(Bitmap r1) {
        if (r1.getConfig() == null) goto L6;
        return r1.getConfig();
    L6:
        return Bitmap.Config.ARGB_8888;
    }

    private static void applyMatrix(Bitmap r2, Bitmap r3, Matrix r4) {
        Lock r0 = BITMAP_DRAWABLE_LOCK;
        r0.lock();
        Canvas r1 = new Canvas(r3);     // Catch: Throwable -> L6
        r1.drawBitmap(r2, r4, DEFAULT_PAINT);     // Catch: Throwable -> L6
        clear(r1);     // Catch: Throwable -> L6
        r0.unlock();
        return;
    L6:
        th = move-exception;
        BITMAP_DRAWABLE_LOCK.unlock();
        throw th;
    }

    static void initializeMatrixForRotation(int r5, Matrix r6) {
        switch(r5) {
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L19;
        };
    L5:
        r6.setRotate(-90.0f);
        return;
    L6:
        r6.setRotate(-90.0f);
        r6.postScale(-1.0f, 1.0f);
        return;
    L7:
        r6.setRotate(90.0f);
        return;
    L8:
        r6.setRotate(90.0f);
        r6.postScale(-1.0f, 1.0f);
        return;
    L9:
        r6.setRotate(180.0f);
        r6.postScale(-1.0f, 1.0f);
        return;
    L10:
        r6.setRotate(180.0f);
        return;
    L11:
        r6.setScale(-1.0f, 1.0f);
        return;
    }
}
