package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface GifDecoder {
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    public static final int TOTAL_ITERATION_COUNT_FOREVER = 0;

    public interface BitmapProvider {
        Bitmap obtain(int r1, int r2, Bitmap.Config r3);

        byte[] obtainByteArray(int r1);

        int[] obtainIntArray(int r1);

        void release(Bitmap r1);

        void release(byte[] r1);

        void release(int[] r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GifDecodeStatus {
    }

    void advance();

    void clear();

    int getByteSize();

    int getCurrentFrameIndex();

    ByteBuffer getData();

    int getDelay(int r1);

    int getFrameCount();

    int getHeight();

    @Deprecated
    int getLoopCount();

    int getNetscapeLoopCount();

    int getNextDelay();

    Bitmap getNextFrame();

    int getStatus();

    int getTotalIterationCount();

    int getWidth();

    int read(InputStream r1, int r2);

    int read(byte[] r1);

    void resetFrameIndex();

    void setData(GifHeader r1, ByteBuffer r2);

    void setData(GifHeader r1, ByteBuffer r2, int r3);

    void setData(GifHeader r1, byte[] r2);

    void setDefaultBitmapConfig(Bitmap.Config r1);
}
