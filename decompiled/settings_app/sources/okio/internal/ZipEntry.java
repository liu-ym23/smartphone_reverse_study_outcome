package okio.internal;

import com.bytedance.apm.constant.PerfConsts;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;

/* JADX INFO: compiled from: ZipEntry.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u001eR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001a¨\u0006$"}, d2 = {"Lokio/internal/ZipEntry;", "", "canonicalPath", "Lokio/Path;", "isDirectory", "", ClientCookie.COMMENT_ATTR, "", "crc", "", "compressedSize", PerfConsts.PERF_DISK_FILE_SIZE, "compressionMethod", "", "lastModifiedAtMillis", "offset", "(Lokio/Path;ZLjava/lang/String;JJJILjava/lang/Long;J)V", "getCanonicalPath", "()Lokio/Path;", "children", "", "getChildren", "()Ljava/util/List;", "getComment", "()Ljava/lang/String;", "getCompressedSize", "()J", "getCompressionMethod", "()I", "getCrc", "()Z", "getLastModifiedAtMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOffset", "getSize", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ZipEntry {
    private final Path canonicalPath;
    private final List<Path> children;
    private final String comment;
    private final long compressedSize;
    private final int compressionMethod;
    private final long crc;
    private final boolean isDirectory;
    private final Long lastModifiedAtMillis;
    private final long offset;
    private final long size;

    public ZipEntry(Path r2, boolean r3, String r4, long r5, long r7, long r9, int r11, Long r12, long r13) {
        Intrinsics.checkNotNullParameter(r2, "canonicalPath");
        Intrinsics.checkNotNullParameter(r4, ClientCookie.COMMENT_ATTR);
        this.canonicalPath = r2;
        this.isDirectory = r3;
        this.comment = r4;
        this.crc = r5;
        this.compressedSize = r7;
        this.size = r9;
        this.compressionMethod = r11;
        this.lastModifiedAtMillis = r12;
        this.offset = r13;
        this.children = new ArrayList();
    }

    public /* synthetic */ ZipEntry(Path r14, boolean r15, String r16, long r17, long r19, long r21, int r23, Long r24, long r25, int r27, DefaultConstructorMarker r28) {
        if ((r27 & 2) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r27 & 4) == 0) goto L9;
        String r2 = "";
    L10:
        long r4 = -1;
        if ((r27 & 8) == 0) goto L13;
        long r6 = -1;
    L15:
        if ((r27 & 16) == 0) goto L17;
        long r8 = -1;
    L19:
        if ((r27 & 32) == 0) goto L21;
        long r10 = -1;
    L23:
        if ((r27 & 64) == 0) goto L25;
        int r3 = -1;
    L27:
        if ((r27 & 128) == 0) goto L29;
        Long r12 = null;
    L31:
        if ((r27 & 256) != 0) goto L34;
        r4 = r25;
    L34:
        this(r14, r1, r2, r6, r8, r10, r3, r12, r4);
        return;
    L29:
        r12 = r24;
        goto L31
    L25:
        r3 = r23;
        goto L27
    L21:
        r10 = r21;
        goto L23
    L17:
        r8 = r19;
        goto L19
    L13:
        r6 = r17;
        goto L15
    L9:
        r2 = r16;
        goto L10
    L5:
        r1 = r15;
        goto L7
    }

    public final Path getCanonicalPath() {
        return this.canonicalPath;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final String getComment() {
        return this.comment;
    }

    public final long getCrc() {
        return this.crc;
    }

    public final long getCompressedSize() {
        return this.compressedSize;
    }

    public final long getSize() {
        return this.size;
    }

    public final int getCompressionMethod() {
        return this.compressionMethod;
    }

    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    public final long getOffset() {
        return this.offset;
    }

    public final List<Path> getChildren() {
        return this.children;
    }
}
