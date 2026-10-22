package okio;

import android.icu.text.PluralRules;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._PathKt;

/* JADX INFO: compiled from: Path.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001.B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0000H\u0096\u0002J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\rH\u0087\u0002¢\u0006\u0002\b\"J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0003H\u0087\u0002¢\u0006\u0002\b\"J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0002\b\"J\u0013\u0010#\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020\u001eH\u0016J\u0006\u0010&\u001a\u00020\u0000J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000J\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\bJ\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\bJ\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\bJ\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020,H\u0007J\b\u0010-\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00008G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001c¨\u0006/"}, d2 = {"Lokio/Path;", "", "bytes", "Lokio/ByteString;", "(Lokio/ByteString;)V", "getBytes$okio", "()Lokio/ByteString;", "isAbsolute", "", "()Z", "isRelative", "isRoot", "name", "", "()Ljava/lang/String;", "nameBytes", "parent", "()Lokio/Path;", "root", "getRoot", "segments", "", "getSegments", "()Ljava/util/List;", "segmentsBytes", "getSegmentsBytes", "volumeLetter", "", "()Ljava/lang/Character;", "compareTo", "", PluralRules.KEYWORD_OTHER, "div", "child", "resolve", "equals", "", "hashCode", "normalized", "relativeTo", "normalize", "toFile", "Ljava/io/File;", "toNioPath", "Ljava/nio/file/Path;", "toString", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Path implements Comparable<Path> {
    public static final Companion Companion = null;
    public static final String DIRECTORY_SEPARATOR = null;
    private final ByteString bytes;

    /* JADX INFO: compiled from: Path.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001b\u0010\f\u001a\u00020\u0006*\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokio/Path$Companion;", "", "()V", "DIRECTORY_SEPARATOR", "", "toOkioPath", "Lokio/Path;", "Ljava/io/File;", "normalize", "", "get", "Ljava/nio/file/Path;", "toPath", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final Path get(File r4) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            return get$default(this, r4, false, 1, null);
        }

        @JvmStatic
        public final Path get(String r4) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            return get$default(this, r4, false, 1, null);
        }

        @JvmStatic
        public final Path get(java.nio.file.Path r4) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            return get$default(this, r4, false, 1, null);
        }

        private Companion() {
        }

        public static /* synthetic */ Path get$default(Companion r0, String r1, boolean r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = false;
        L6:
            return r0.get(r1, r2);
        }

        @JvmStatic
        public final Path get(String r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            return _PathKt.commonToPath(r1, r2);
        }

        public static /* synthetic */ Path get$default(Companion r0, File r1, boolean r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = false;
        L6:
            return r0.get(r1, r2);
        }

        @JvmStatic
        public final Path get(File r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            String r4 = r2.toString();
            Intrinsics.checkNotNullExpressionValue(r4, "toString()");
            return get(r4, r3);
        }

        public static /* synthetic */ Path get$default(Companion r0, java.nio.file.Path r1, boolean r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = false;
        L6:
            return r0.get(r1, r2);
        }

        @JvmStatic
        public final Path get(java.nio.file.Path r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            return get(r2.toString(), r3);
        }
    }

    @JvmStatic
    public static final Path get(File r1) {
        return Companion.get(r1);
    }

    @JvmStatic
    public static final Path get(File r1, boolean r2) {
        return Companion.get(r1, r2);
    }

    @JvmStatic
    public static final Path get(String r1) {
        return Companion.get(r1);
    }

    @JvmStatic
    public static final Path get(String r1, boolean r2) {
        return Companion.get(r1, r2);
    }

    @JvmStatic
    public static final Path get(java.nio.file.Path r1) {
        return Companion.get(r1);
    }

    @JvmStatic
    public static final Path get(java.nio.file.Path r1, boolean r2) {
        return Companion.get(r1, r2);
    }

    public Path(ByteString r2) {
        Intrinsics.checkNotNullParameter(r2, "bytes");
        this.bytes = r2;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Path r1) {
        return compareTo2(r1);
    }

    public final ByteString getBytes$okio() {
        return this.bytes;
    }

    public final Path resolve(Path r2) {
        Intrinsics.checkNotNullParameter(r2, "child");
        return _PathKt.commonResolve(this, r2, false);
    }

    public static /* synthetic */ Path resolve$default(Path r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.resolve(r1, r2);
    }

    public static /* synthetic */ Path resolve$default(Path r0, ByteString r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.resolve(r1, r2);
    }

    public static /* synthetic */ Path resolve$default(Path r0, Path r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.resolve(r1, r2);
    }

    public final Path resolve(Path r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "child");
        return _PathKt.commonResolve(this, r2, r3);
    }

    public final File toFile() {
        return new File(toString());
    }

    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path r1 = Paths.get(toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(r1, "get(toString())");
        return r1;
    }

    static {
        Companion = new Companion(null);
        String r0 = File.separator;
        Intrinsics.checkNotNullExpressionValue(r0, "separator");
        DIRECTORY_SEPARATOR = r0;
    }

    public final Path getRoot() {
        int r0 = _PathKt.access$rootLength(this);
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        return new Path(getBytes$okio().substring(0, r0));
    }

    public final List<String> getSegments() {
        ArrayList r0 = new ArrayList();
        int r1 = _PathKt.access$rootLength(this);
        if (r1 != (-1)) goto L6;
        r1 = 0;
    L10:
        int r2 = getBytes$okio().size();
        int r4 = r1;
    L11:
        if (r1 >= r2) goto L19;
        if (getBytes$okio().getByte(r1) != 47) goto L15;
    L16:
        r0.add(getBytes$okio().substring(r4, r1));
        r4 = r1 + 1;
    L17:
        r1 = r1 + 1;
        goto L11
    L15:
        if (getBytes$okio().getByte(r1) != 92) goto L17;
    L19:
        if (r4 >= getBytes$okio().size()) goto L21;
        r0.add(getBytes$okio().substring(r4, getBytes$okio().size()));
    L21:
        ArrayList r3 = r0;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L23:
        if (r5.hasNext() == false) goto L26;
        r7.add(((ByteString) r5.next()).utf8());
        goto L23
    L26:
        return r7;
    L6:
        if (r1 >= getBytes$okio().size()) goto L10;
        if (getBytes$okio().getByte(r1) != 92) goto L10;
        r1 = r1 + 1;
        goto L10
    }

    public final List<ByteString> getSegmentsBytes() {
        ArrayList r0 = new ArrayList();
        int r1 = _PathKt.access$rootLength(this);
        if (r1 != (-1)) goto L6;
        r1 = 0;
    L10:
        int r2 = getBytes$okio().size();
        int r4 = r1;
    L11:
        if (r1 >= r2) goto L19;
        if (getBytes$okio().getByte(r1) != 47) goto L15;
    L16:
        r0.add(getBytes$okio().substring(r4, r1));
        r4 = r1 + 1;
    L17:
        r1 = r1 + 1;
        goto L11
    L15:
        if (getBytes$okio().getByte(r1) != 92) goto L17;
    L19:
        if (r4 >= getBytes$okio().size()) goto L21;
        r0.add(getBytes$okio().substring(r4, getBytes$okio().size()));
    L21:
        return r0;
    L6:
        if (r1 >= getBytes$okio().size()) goto L10;
        if (getBytes$okio().getByte(r1) != 92) goto L10;
        r1 = r1 + 1;
        goto L10
    }

    public final boolean isAbsolute() {
        if (_PathKt.access$rootLength(this) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isRelative() {
        if (_PathKt.access$rootLength(this) != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public final Character volumeLetter() {
        boolean r2 = false;
        if (ByteString.indexOf$default(getBytes$okio(), _PathKt.access$getSLASH$p(), 0, 2, null) == (-1)) goto L6;
        return null;
    L6:
        if (getBytes$okio().size() >= 2) goto L9;
        return null;
    L9:
        if (getBytes$okio().getByte(1) != 58) goto L29;
        char r5 = (char) getBytes$okio().getByte(0);
        if ('a' <= r5) goto L14;
    L16:
        boolean r0 = false;
    L17:
        if (r0 == true) goto L26;
        if ('A' <= r5) goto L21;
    L23:
        if (r2 == true) goto L26;
        return null;
    L21:
        if (r5 >= '[') goto L23;
        r2 = true;
    L26:
        return Character.valueOf(r5);
    L14:
        if (r5 >= '{') goto L16;
        r0 = true;
        goto L17
    L29:
        return null;
    }

    public final ByteString nameBytes() {
        int r0 = _PathKt.access$getIndexOfLastSlash(this);
        if (r0 == (-1)) goto L6;
        return ByteString.substring$default(getBytes$okio(), r0 + 1, 0, 2, null);
    L6:
        if (volumeLetter() == null) goto L11;
        if (getBytes$okio().size() != 2) goto L11;
        return ByteString.EMPTY;
    L11:
        return getBytes$okio();
    }

    public final String name() {
        return nameBytes().utf8();
    }

    public final Path parent() {
        if (Intrinsics.areEqual(getBytes$okio(), _PathKt.access$getDOT$p()) == false) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(getBytes$okio(), _PathKt.access$getSLASH$p()) == false) goto L7;
        return null;
    L7:
        if (Intrinsics.areEqual(getBytes$okio(), _PathKt.access$getBACKSLASH$p()) == false) goto L9;
        return null;
    L9:
        if (_PathKt.access$lastSegmentIsDotDot(this) == true) goto L43;
        int r0 = _PathKt.access$getIndexOfLastSlash(this);
        if (r0 == 2) goto L14;
    L20:
        if (r0 != 1) goto L25;
        if (getBytes$okio().startsWith(_PathKt.access$getBACKSLASH$p()) == false) goto L25;
        return null;
    L25:
        if (r0 == (-1)) goto L27;
    L32:
        if (r0 == (-1)) goto L42;
        if (r0 != 0) goto L37;
        Path r1 = new Path(ByteString.substring$default(getBytes$okio(), 0, 1, 1, null));
    L41:
        return r1;
    L37:
        return new Path(ByteString.substring$default(getBytes$okio(), 0, r0, 1, null));
    L42:
        return new Path(_PathKt.access$getDOT$p());
    L27:
        if (volumeLetter() == null) goto L32;
        if (getBytes$okio().size() == 2) goto L46;
        r1 = new Path(ByteString.substring$default(getBytes$okio(), 0, 2, 1, null));
        goto L41
    L46:
        return null;
    L14:
        if (volumeLetter() == null) goto L20;
        if (getBytes$okio().size() == 3) goto L44;
        r1 = new Path(ByteString.substring$default(getBytes$okio(), 0, 3, 1, null));
        goto L41
    L44:
        return null;
    L43:
        return null;
    }

    public final boolean isRoot() {
        if (_PathKt.access$rootLength(this) != getBytes$okio().size()) goto L5;
        return true;
    L5:
        return false;
    }

    public final Path resolve(String r2) {
        Intrinsics.checkNotNullParameter(r2, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().writeUtf8(r2), false), false);
    }

    public final Path resolve(ByteString r2) {
        Intrinsics.checkNotNullParameter(r2, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().write(r2), false), false);
    }

    public final Path resolve(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().writeUtf8(r2), false), r3);
    }

    public final Path resolve(ByteString r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().write(r2), false), r3);
    }

    public final Path relativeTo(Path r9) {
        Intrinsics.checkNotNullParameter(r9, PluralRules.KEYWORD_OTHER);
        if (Intrinsics.areEqual(getRoot(), r9.getRoot()) == false) goto L35;
        List<ByteString> r0 = getSegmentsBytes();
        List<ByteString> r2 = r9.getSegmentsBytes();
        int r3 = Math.min(r0.size(), r2.size());
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L9;
        if (Intrinsics.areEqual(r0.get(r5), r2.get(r5)) == false) goto L9;
        r5 = r5 + 1;
    L9:
        boolean r6 = true;
        if (r5 != r3) goto L15;
        if (getBytes$okio().size() != r9.getBytes$okio().size()) goto L15;
        return Companion.get$default(Companion, ".", false, 1, null);
    L15:
        if (r2.subList(r5, r2.size()).indexOf(_PathKt.access$getDOT_DOT$p()) == (-1)) goto L18;
        r6 = false;
    L18:
        if (r6 == false) goto L33;
        Buffer r1 = new Buffer();
        ByteString r10 = _PathKt.access$getSlash(r9);
        if (r10 != null) goto L24;
        r10 = _PathKt.access$getSlash(this);
        if (r10 != null) goto L24;
        r10 = _PathKt.access$toSlash(DIRECTORY_SEPARATOR);
    L24:
        int r8 = r2.size();
        int r4 = r5;
    L25:
        if (r4 >= r8) goto L27;
        r1.write(_PathKt.access$getDOT_DOT$p());
        r1.write(r10);
        r4 = r4 + 1;
        goto L25
    L27:
        int r11 = r0.size();
    L28:
        if (r5 >= r11) goto L31;
        r1.write(r0.get(r5));
        r1.write(r10);
        r5 = r5 + 1;
        goto L28
    L31:
        return _PathKt.toPath(r1, false);
    L33:
        throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + r9).toString());
    L35:
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + r9).toString());
    }

    public final Path normalized() {
        return Companion.get(toString(), true);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Path r2) {
        Intrinsics.checkNotNullParameter(r2, PluralRules.KEYWORD_OTHER);
        return getBytes$okio().compareTo2(r2.getBytes$okio());
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof Path) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((Path) r2).getBytes$okio(), getBytes$okio()) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return getBytes$okio().hashCode();
    }

    public String toString() {
        return getBytes$okio().utf8();
    }
}
