package okio;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;

/* JADX INFO: compiled from: FileMetadata.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\u0010\u000fJu\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\u0010\u001cJ'\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\b\b\u0000\u0010\u001e*\u00020\u00012\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u001e0\u000e¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\"H\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R!\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lokio/FileMetadata;", "", "isRegularFile", "", "isDirectory", "symlinkTarget", "Lokio/Path;", PerfConsts.PERF_DISK_FILE_SIZE, "", "createdAtMillis", "lastModifiedAtMillis", "lastAccessedAtMillis", "extras", "", "Lkotlin/reflect/KClass;", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)V", "getCreatedAtMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExtras", "()Ljava/util/Map;", "()Z", "getLastAccessedAtMillis", "getLastModifiedAtMillis", "getSize", "getSymlinkTarget", "()Lokio/Path;", "copy", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)Lokio/FileMetadata;", "extra", ExifInterface.GPS_DIRECTION_TRUE, "type", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toString", "", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FileMetadata {
    private final Long createdAtMillis;
    private final Map<KClass<?>, Object> extras;
    private final boolean isDirectory;
    private final boolean isRegularFile;
    private final Long lastAccessedAtMillis;
    private final Long lastModifiedAtMillis;
    private final Long size;
    private final Path symlinkTarget;

    public FileMetadata() {
        this(false, false, null, null, null, null, null, null, 255, null);
    }

    public FileMetadata(boolean r2, boolean r3, Path r4, Long r5, Long r6, Long r7, Long r8, Map<KClass<?>, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r9, "extras");
        this.isRegularFile = r2;
        this.isDirectory = r3;
        this.symlinkTarget = r4;
        this.size = r5;
        this.createdAtMillis = r6;
        this.lastModifiedAtMillis = r7;
        this.lastAccessedAtMillis = r8;
        this.extras = MapsKt.toMap(r9);
    }

    public final boolean isRegularFile() {
        return this.isRegularFile;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final Path getSymlinkTarget() {
        return this.symlinkTarget;
    }

    public final Long getSize() {
        return this.size;
    }

    public final Long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    public final Long getLastAccessedAtMillis() {
        return this.lastAccessedAtMillis;
    }

    public /* synthetic */ FileMetadata(boolean r2, boolean r3, Path r4, Long r5, Long r6, Long r7, Long r8, Map r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r10 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r10 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r10 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r10 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r10 & 128) == 0) goto L26;
        r9 = MapsKt.emptyMap();
    L26:
        this(r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public final Map<KClass<?>, Object> getExtras() {
        return this.extras;
    }

    public final <T> T extra(KClass<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Object r1 = this.extras.get(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return (T) KClasses.cast(r2, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileMetadata copy$default(FileMetadata r9, boolean r10, boolean r11, Path r12, Long r13, Long r14, Long r15, Long r16, Map r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        boolean r2 = r9.isRegularFile;
    L7:
        if ((r18 & 2) == 0) goto L9;
        boolean r3 = r9.isDirectory;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Path r4 = r9.symlinkTarget;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Long r5 = r9.size;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Long r6 = r9.createdAtMillis;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Long r7 = r9.lastModifiedAtMillis;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Long r8 = r9.lastAccessedAtMillis;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Map r1 = r9.extras;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final FileMetadata copy(boolean r11, boolean r12, Path r13, Long r14, Long r15, Long r16, Long r17, Map<KClass<?>, ? extends Object> r18) {
        Intrinsics.checkNotNullParameter(r18, "extras");
        return new FileMetadata(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public String toString() {
        ArrayList r0 = new ArrayList();
        if (this.isRegularFile == false) goto L6;
        r0.add("isRegularFile");
    L6:
        if (this.isDirectory == false) goto L9;
        r0.add("isDirectory");
    L9:
        if (this.size == null) goto L12;
        r0.add("byteCount=" + this.size);
    L12:
        if (this.createdAtMillis == null) goto L15;
        r0.add("createdAt=" + this.createdAtMillis);
    L15:
        if (this.lastModifiedAtMillis == null) goto L18;
        r0.add("lastModifiedAt=" + this.lastModifiedAtMillis);
    L18:
        if (this.lastAccessedAtMillis == null) goto L21;
        r0.add("lastAccessedAt=" + this.lastAccessedAtMillis);
    L21:
        if ((!this.extras.isEmpty()) == false) goto L24;
        r0.add("extras=" + this.extras);
    L24:
        return CollectionsKt.joinToString$default(r0, ", ", "FileMetadata(", ")", 0, null, null, 56, null);
    }
}
