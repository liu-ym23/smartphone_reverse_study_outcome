package com.bumptech.glide.load;

import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ImageHeaderParserUtils {
    private static final int MARK_READ_LIMIT = 5242880;

    private interface OrientationReader {
        int getOrientationAndRewind(ImageHeaderParser r1) throws IOException;
    }

    private interface TypeReader {
        ImageHeaderParser.ImageType getTypeAndRewind(ImageHeaderParser r1) throws IOException;
    }

    private ImageHeaderParserUtils() {
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> r1, final InputStream r2, ArrayPool r3) throws IOException {
        if (r2 != null) goto L6;
        return ImageHeaderParser.ImageType.UNKNOWN;
    L6:
        if (r2.markSupported() == true) goto L8;
        r2 = new RecyclableBufferedInputStream(r2, r3);
    L8:
        r2.mark(MARK_READ_LIMIT);
        return getTypeInternal(r1, new AnonymousClass1(r2));
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> r1, final ByteBuffer r2) throws IOException {
        if (r2 != null) goto L6;
        return ImageHeaderParser.ImageType.UNKNOWN;
    L6:
        return getTypeInternal(r1, new AnonymousClass2(r2));
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> r1, final ParcelFileDescriptorRewinder r2, final ArrayPool r3) throws IOException {
        return getTypeInternal(r1, new AnonymousClass3(r2, r3));
    }

    private static ImageHeaderParser.ImageType getTypeInternal(List<ImageHeaderParser> r4, TypeReader r5) throws IOException {
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        ImageHeaderParser.ImageType r2 = r5.getTypeAndRewind(r4.get(r1));
        if (r2 != ImageHeaderParser.ImageType.UNKNOWN) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L9:
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static int getOrientation(List<ImageHeaderParser> r1, final ByteBuffer r2, final ArrayPool r3) throws IOException {
        if (r2 != null) goto L6;
        return -1;
    L6:
        return getOrientationInternal(r1, new AnonymousClass4(r2, r3));
    }

    public static int getOrientation(List<ImageHeaderParser> r1, final InputStream r2, final ArrayPool r3) throws IOException {
        if (r2 != null) goto L6;
        return -1;
    L6:
        if (r2.markSupported() == true) goto L8;
        r2 = new RecyclableBufferedInputStream(r2, r3);
    L8:
        r2.mark(MARK_READ_LIMIT);
        return getOrientationInternal(r1, new AnonymousClass5(r2, r3));
    }

    public static int getOrientation(List<ImageHeaderParser> r1, final ParcelFileDescriptorRewinder r2, final ArrayPool r3) throws IOException {
        return getOrientationInternal(r1, new AnonymousClass6(r2, r3));
    }

    private static int getOrientationInternal(List<ImageHeaderParser> r4, OrientationReader r5) throws IOException {
        int r0 = r4.size();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        int r3 = r5.getOrientationAndRewind(r4.get(r1));
        if (r3 != (-1)) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return r3;
    L9:
        return -1;
    }
}
