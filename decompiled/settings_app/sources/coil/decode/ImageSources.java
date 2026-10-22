package coil.decode;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: compiled from: ImageSource.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u0006\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\b\u0006\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0006\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\b\u0006\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\b\u0006\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\b\u0006¨\u0006\u0013"}, d2 = {"ImageSource", "Lcoil/decode/ImageSource;", "source", "Lokio/BufferedSource;", "context", "Landroid/content/Context;", "create", "metadata", "Lcoil/decode/ImageSource$Metadata;", "cacheDirectory", "Ljava/io/File;", "file", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "diskCacheKey", "", "closeable", "Ljava/io/Closeable;", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ImageSources {
    public static /* synthetic */ ImageSource create$default(Path r1, FileSystem r2, String r3, Closeable r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = FileSystem.SYSTEM;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 8) == 0) goto L12;
        r4 = null;
    L12:
        return create(r1, r2, r3, r4);
    }

    public static final ImageSource create(Path r7, FileSystem r8, String r9, Closeable r10) {
        return new FileImageSource(r7, r8, r9, r10, null);
    }

    public static /* synthetic */ ImageSource create$default(Path r1, FileSystem r2, String r3, Closeable r4, ImageSource.Metadata r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r2 = FileSystem.SYSTEM;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 16) == 0) goto L15;
        r5 = null;
    L15:
        return create(r1, r2, r3, r4, r5);
    }

    public static final ImageSource create(Path r7, FileSystem r8, String r9, Closeable r10, ImageSource.Metadata r11) {
        return new FileImageSource(r7, r8, r9, r10, r11);
    }

    public static final ImageSource create(BufferedSource r2, final Context r3) {
        return new SourceImageSource(r2, new ImageSources$ImageSource$1(r3), null);
    }

    public static /* synthetic */ ImageSource create$default(BufferedSource r0, Context r1, ImageSource.Metadata r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = null;
    L6:
        return create(r0, r1, r2);
    }

    public static final ImageSource create(BufferedSource r2, final Context r3, ImageSource.Metadata r4) {
        return new SourceImageSource(r2, new ImageSources$ImageSource$2(r3), r4);
    }

    public static final ImageSource create(BufferedSource r2, final File r3) {
        return new SourceImageSource(r2, new ImageSources$ImageSource$3(r3), null);
    }

    public static /* synthetic */ ImageSource create$default(BufferedSource r0, File r1, ImageSource.Metadata r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = null;
    L6:
        return create(r0, r1, r2);
    }

    public static final ImageSource create(BufferedSource r2, final File r3, ImageSource.Metadata r4) {
        return new SourceImageSource(r2, new ImageSources$ImageSource$4(r3), r4);
    }
}
