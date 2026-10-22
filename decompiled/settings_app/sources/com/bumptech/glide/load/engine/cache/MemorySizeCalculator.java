package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public final class MemorySizeCalculator {
    static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    private static final int LOW_MEMORY_BYTE_ARRAY_POOL_DIVISOR = 2;
    private static final String TAG = "MemorySizeCalculator";
    private final int arrayPoolSize;
    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;

    public static final class Builder {
        static final int ARRAY_POOL_SIZE_BYTES = 4194304;
        static final int BITMAP_POOL_TARGET_SCREENS = 0;
        static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
        static final float MAX_SIZE_MULTIPLIER = 0.4f;
        static final int MEMORY_CACHE_TARGET_SCREENS = 2;
        ActivityManager activityManager;
        int arrayPoolSizeBytes;
        float bitmapPoolScreens;
        final Context context;
        float lowMemoryMaxSizeMultiplier;
        float maxSizeMultiplier;
        float memoryCacheScreens;
        ScreenDimensions screenDimensions;

        static {
            BITMAP_POOL_TARGET_SCREENS = 1;
        }

        public Builder(Context r2) {
            this.memoryCacheScreens = 2.0f;
            this.bitmapPoolScreens = BITMAP_POOL_TARGET_SCREENS;
            this.maxSizeMultiplier = 0.4f;
            this.lowMemoryMaxSizeMultiplier = 0.33f;
            this.arrayPoolSizeBytes = 4194304;
            this.context = r2;
            this.activityManager = (ActivityManager) r2.getSystemService("activity");
            this.screenDimensions = new DisplayMetricsScreenDimensions(r2.getResources().getDisplayMetrics());
            if (MemorySizeCalculator.isLowMemoryDevice(this.activityManager) == false) goto L6;
            this.bitmapPoolScreens = 0.0f;
            return;
        }

        public Builder setMemoryCacheScreens(float r3) {
            if (r3 < 0.0f) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "Memory cache screens must be greater than or equal to 0");
            this.memoryCacheScreens = r3;
            return this;
        L5:
            r0 = false;
            goto L6
        }

        public Builder setBitmapPoolScreens(float r3) {
            if (r3 < 0.0f) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "Bitmap pool screens must be greater than or equal to 0");
            this.bitmapPoolScreens = r3;
            return this;
        L5:
            r0 = false;
            goto L6
        }

        public Builder setMaxSizeMultiplier(float r3) {
            if (r3 >= 0.0f) goto L5;
        L7:
            boolean r0 = false;
        L8:
            Preconditions.checkArgument(r0, "Size multiplier must be between 0 and 1");
            this.maxSizeMultiplier = r3;
            return this;
        L5:
            if (r3 > 1.0f) goto L7;
            r0 = true;
            goto L8
        }

        public Builder setLowMemoryMaxSizeMultiplier(float r3) {
            if (r3 >= 0.0f) goto L5;
        L7:
            boolean r0 = false;
        L8:
            Preconditions.checkArgument(r0, "Low memory max size multiplier must be between 0 and 1");
            this.lowMemoryMaxSizeMultiplier = r3;
            return this;
        L5:
            if (r3 > 1.0f) goto L7;
            r0 = true;
            goto L8
        }

        public Builder setArrayPoolSize(int r1) {
            this.arrayPoolSizeBytes = r1;
            return this;
        }

        Builder setActivityManager(ActivityManager r1) {
            this.activityManager = r1;
            return this;
        }

        Builder setScreenDimensions(ScreenDimensions r1) {
            this.screenDimensions = r1;
            return this;
        }

        public MemorySizeCalculator build() {
            return new MemorySizeCalculator(this);
        }
    }

    private static final class DisplayMetricsScreenDimensions implements ScreenDimensions {
        private final DisplayMetrics displayMetrics;

        DisplayMetricsScreenDimensions(DisplayMetrics r1) {
            this.displayMetrics = r1;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }
    }

    interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    MemorySizeCalculator(Builder r7) {
        this.context = r7.context;
        if (isLowMemoryDevice(r7.activityManager) == false) goto L5;
        int r0 = r7.arrayPoolSizeBytes / 2;
    L6:
        this.arrayPoolSize = r0;
        int r1 = getMaxSize(r7.activityManager, r7.maxSizeMultiplier, r7.lowMemoryMaxSizeMultiplier);
        float r2 = (r7.screenDimensions.getWidthPixels() * r7.screenDimensions.getHeightPixels()) * 4;
        int r3 = Math.round(r7.bitmapPoolScreens * r2);
        int r4 = Math.round(r2 * r7.memoryCacheScreens);
        int r5 = r1 - r0;
        int r6 = r4 + r3;
        if (r6 > r5) goto L9;
        this.memoryCacheSize = r4;
        this.bitmapPoolSize = r3;
    L11:
        if (Log.isLoggable(TAG, 3) == false) goto L18;
        StringBuilder r8 = new StringBuilder("Calculation complete, Calculated memory cache size: ").append(toMb(this.memoryCacheSize)).append(", pool size: ").append(toMb(this.bitmapPoolSize)).append(", byte array size: ").append(toMb(r0)).append(", memory class limited? ");
        if (r6 <= r1) goto L15;
        boolean r9 = true;
    L16:
        Log.d(TAG, r8.append(r9).append(", max size: ").append(toMb(r1)).append(", memoryClass: ").append(r7.activityManager.getMemoryClass()).append(", isLowMemoryDevice: ").append(isLowMemoryDevice(r7.activityManager)).toString());
        return;
    L15:
        r9 = false;
        goto L16
    L18:
        return;
    L9:
        float r10 = r5 / (r7.bitmapPoolScreens + r7.memoryCacheScreens);
        this.memoryCacheSize = Math.round(r7.memoryCacheScreens * r10);
        this.bitmapPoolSize = Math.round(r10 * r7.bitmapPoolScreens);
        goto L11
    L5:
        r0 = r7.arrayPoolSizeBytes;
        goto L6
    }

    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }

    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    public int getArrayPoolSizeInBytes() {
        return this.arrayPoolSize;
    }

    private static int getMaxSize(ActivityManager r1, float r2, float r3) {
        float r0 = (r1.getMemoryClass() * 1024) * 1024;
        if (isLowMemoryDevice(r1) == false) goto L6;
        r2 = r3;
    L6:
        return Math.round(r0 * r2);
    }

    private String toMb(int r3) {
        return Formatter.formatFileSize(this.context, r3);
    }

    static boolean isLowMemoryDevice(ActivityManager r0) {
        return r0.isLowRamDevice();
    }
}
