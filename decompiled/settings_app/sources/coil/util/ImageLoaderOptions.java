package coil.util;

import coil.decode.ExifOrientationPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ImageLoaderOptions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ8\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0014"}, d2 = {"Lcoil/util/ImageLoaderOptions;", "", "addLastModifiedToFileCacheKey", "", "networkObserverEnabled", "respectCacheHeaders", "bitmapFactoryMaxParallelism", "", "bitmapFactoryExifOrientationPolicy", "Lcoil/decode/ExifOrientationPolicy;", "(ZZZILcoil/decode/ExifOrientationPolicy;)V", "getAddLastModifiedToFileCacheKey", "()Z", "getBitmapFactoryExifOrientationPolicy", "()Lcoil/decode/ExifOrientationPolicy;", "getBitmapFactoryMaxParallelism", "()I", "getNetworkObserverEnabled", "getRespectCacheHeaders", "copy", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ImageLoaderOptions {
    private final boolean addLastModifiedToFileCacheKey;
    private final ExifOrientationPolicy bitmapFactoryExifOrientationPolicy;
    private final int bitmapFactoryMaxParallelism;
    private final boolean networkObserverEnabled;
    private final boolean respectCacheHeaders;

    public ImageLoaderOptions() {
        this(false, false, false, 0, null, 31, null);
    }

    public ImageLoaderOptions(boolean r1, boolean r2, boolean r3, int r4, ExifOrientationPolicy r5) {
        this.addLastModifiedToFileCacheKey = r1;
        this.networkObserverEnabled = r2;
        this.respectCacheHeaders = r3;
        this.bitmapFactoryMaxParallelism = r4;
        this.bitmapFactoryExifOrientationPolicy = r5;
    }

    public final boolean getAddLastModifiedToFileCacheKey() {
        return this.addLastModifiedToFileCacheKey;
    }

    public final boolean getNetworkObserverEnabled() {
        return this.networkObserverEnabled;
    }

    public final boolean getRespectCacheHeaders() {
        return this.respectCacheHeaders;
    }

    public final int getBitmapFactoryMaxParallelism() {
        return this.bitmapFactoryMaxParallelism;
    }

    public /* synthetic */ ImageLoaderOptions(boolean r2, boolean r3, boolean r4, int r5, ExifOrientationPolicy r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = true;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = true;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = 4;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = ExifOrientationPolicy.RESPECT_PERFORMANCE;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final ExifOrientationPolicy getBitmapFactoryExifOrientationPolicy() {
        return this.bitmapFactoryExifOrientationPolicy;
    }

    public static /* synthetic */ ImageLoaderOptions copy$default(ImageLoaderOptions r3, boolean r4, boolean r5, boolean r6, int r7, ExifOrientationPolicy r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.addLastModifiedToFileCacheKey;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.networkObserverEnabled;
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.respectCacheHeaders;
    L11:
        boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.bitmapFactoryMaxParallelism;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.bitmapFactoryExifOrientationPolicy;
    L17:
        boolean r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final ImageLoaderOptions copy(boolean r7, boolean r8, boolean r9, int r10, ExifOrientationPolicy r11) {
        return new ImageLoaderOptions(r7, r8, r9, r10, r11);
    }
}
