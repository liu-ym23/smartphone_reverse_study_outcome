package okio.internal;

import android.icu.text.PluralRules;
import com.bytedance.librarian.LibrarianImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Path;

/* JADX INFO: compiled from: -Path.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0000\u001a\u0015\u0010\u0014\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0080\b\u001a\u0017\u0010\u0016\u001a\u00020\u0017*\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0018H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\r*\u00020\u000eH\u0080\b\u001a\r\u0010\u001a\u001a\u00020\u0017*\u00020\u000eH\u0080\b\u001a\r\u0010\u001b\u001a\u00020\u0017*\u00020\u000eH\u0080\b\u001a\r\u0010\u001c\u001a\u00020\u0017*\u00020\u000eH\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u000eH\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u0001*\u00020\u000eH\u0080\b\u001a\r\u0010 \u001a\u00020\u000e*\u00020\u000eH\u0080\b\u001a\u000f\u0010!\u001a\u0004\u0018\u00010\u000e*\u00020\u000eH\u0080\b\u001a\u0015\u0010\"\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0080\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017H\u0080\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020&2\u0006\u0010%\u001a\u00020\u0017H\u0080\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0017H\u0080\b\u001a\u001c\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0017H\u0000\u001a\u000f\u0010'\u001a\u0004\u0018\u00010\u000e*\u00020\u000eH\u0080\b\u001a\u0013\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0)*\u00020\u000eH\u0080\b\u001a\u0013\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010)*\u00020\u000eH\u0080\b\u001a\u0014\u0010+\u001a\u00020\u000e*\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017H\u0000\u001a\r\u0010,\u001a\u00020\u001e*\u00020\u000eH\u0080\b\u001a\u0014\u0010-\u001a\u0004\u0018\u00010.*\u00020\u000eH\u0080\b¢\u0006\u0002\u0010/\u001a\f\u00100\u001a\u00020\u0017*\u00020\u000eH\u0002\u001a\f\u00101\u001a\u00020\r*\u00020\u000eH\u0002\u001a\u0014\u00102\u001a\u00020\u0017*\u00020&2\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0014\u00103\u001a\u00020\u000e*\u00020&2\u0006\u0010%\u001a\u00020\u0017H\u0000\u001a\f\u00104\u001a\u00020\u0001*\u000205H\u0002\u001a\f\u00104\u001a\u00020\u0001*\u00020\u001eH\u0002\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003\"\u0016\u0010\n\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u0018\u0010\f\u001a\u00020\r*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u00066"}, d2 = {"ANY_SLASH", "Lokio/ByteString;", "getANY_SLASH$annotations", "()V", "BACKSLASH", "getBACKSLASH$annotations", "DOT", "getDOT$annotations", "DOT_DOT", "getDOT_DOT$annotations", "SLASH", "getSLASH$annotations", "indexOfLastSlash", "", "Lokio/Path;", "getIndexOfLastSlash", "(Lokio/Path;)I", "slash", "getSlash", "(Lokio/Path;)Lokio/ByteString;", "commonCompareTo", PluralRules.KEYWORD_OTHER, "commonEquals", "", "", "commonHashCode", "commonIsAbsolute", "commonIsRelative", "commonIsRoot", "commonName", "", "commonNameBytes", "commonNormalized", "commonParent", "commonRelativeTo", "commonResolve", "child", "normalize", "Lokio/Buffer;", "commonRoot", "commonSegments", "", "commonSegmentsBytes", "commonToPath", "commonToString", "commonVolumeLetter", "", "(Lokio/Path;)Ljava/lang/Character;", "lastSegmentIsDotDot", "rootLength", "startsWithVolumeLetterAndColon", "toPath", "toSlash", "", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class _PathKt {
    private static final ByteString ANY_SLASH = null;
    private static final ByteString BACKSLASH = null;
    private static final ByteString DOT = null;
    private static final ByteString DOT_DOT = null;
    private static final ByteString SLASH = null;

    public static final /* synthetic */ ByteString access$getBACKSLASH$p() {
        return BACKSLASH;
    }

    public static final /* synthetic */ ByteString access$getDOT$p() {
        return DOT;
    }

    public static final /* synthetic */ ByteString access$getDOT_DOT$p() {
        return DOT_DOT;
    }

    public static final /* synthetic */ int access$getIndexOfLastSlash(Path r0) {
        return getIndexOfLastSlash(r0);
    }

    public static final /* synthetic */ ByteString access$getSLASH$p() {
        return SLASH;
    }

    public static final /* synthetic */ ByteString access$getSlash(Path r0) {
        return getSlash(r0);
    }

    public static final /* synthetic */ boolean access$lastSegmentIsDotDot(Path r0) {
        return lastSegmentIsDotDot(r0);
    }

    public static final /* synthetic */ int access$rootLength(Path r0) {
        return rootLength(r0);
    }

    public static final /* synthetic */ ByteString access$toSlash(String r0) {
        return toSlash(r0);
    }

    private static /* synthetic */ void getANY_SLASH$annotations() {
    }

    private static /* synthetic */ void getBACKSLASH$annotations() {
    }

    private static /* synthetic */ void getDOT$annotations() {
    }

    private static /* synthetic */ void getDOT_DOT$annotations() {
    }

    private static /* synthetic */ void getSLASH$annotations() {
    }

    static {
        SLASH = ByteString.Companion.encodeUtf8(LibrarianImpl.Constants.SEPARATOR);
        BACKSLASH = ByteString.Companion.encodeUtf8("\\");
        ANY_SLASH = ByteString.Companion.encodeUtf8("/\\");
        DOT = ByteString.Companion.encodeUtf8(".");
        DOT_DOT = ByteString.Companion.encodeUtf8("..");
    }

    public static final Path commonRoot(Path r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        int r0 = access$rootLength(r3);
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        return new Path(r3.getBytes$okio().substring(0, r0));
    }

    public static final List<ByteString> commonSegmentsBytes(Path r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        ArrayList r0 = new ArrayList();
        int r1 = access$rootLength(r7);
        if (r1 != (-1)) goto L6;
        r1 = 0;
    L10:
        int r2 = r7.getBytes$okio().size();
        int r4 = r1;
    L11:
        if (r1 >= r2) goto L19;
        if (r7.getBytes$okio().getByte(r1) != 47) goto L15;
    L16:
        r0.add(r7.getBytes$okio().substring(r4, r1));
        r4 = r1 + 1;
    L17:
        r1 = r1 + 1;
        goto L11
    L15:
        if (r7.getBytes$okio().getByte(r1) != 92) goto L17;
    L19:
        if (r4 >= r7.getBytes$okio().size()) goto L21;
        r0.add(r7.getBytes$okio().substring(r4, r7.getBytes$okio().size()));
    L21:
        return r0;
    L6:
        if (r1 >= r7.getBytes$okio().size()) goto L10;
        if (r7.getBytes$okio().getByte(r1) != 92) goto L10;
        r1 = r1 + 1;
        goto L10
    }

    private static final int rootLength(Path r7) {
        if (r7.getBytes$okio().size() != 0) goto L5;
        return -1;
    L5:
        boolean r2 = false;
        if (r7.getBytes$okio().getByte(0) != 47) goto L9;
        return 1;
    L9:
        if (r7.getBytes$okio().getByte(0) != 92) goto L20;
        if (r7.getBytes$okio().size() > 2) goto L13;
    L18:
        return 1;
    L13:
        if (r7.getBytes$okio().getByte(1) != 92) goto L18;
        int r0 = r7.getBytes$okio().indexOf(BACKSLASH, 2);
        if (r0 == (-1)) goto L17;
        return r0;
    L17:
        return r7.getBytes$okio().size();
    L20:
        if (r7.getBytes$okio().size() > 2) goto L22;
    L41:
        return -1;
    L22:
        if (r7.getBytes$okio().getByte(1) != 58) goto L41;
        if (r7.getBytes$okio().getByte(2) != 92) goto L41;
        char r8 = (char) r7.getBytes$okio().getByte(0);
        if ('a' <= r8) goto L28;
    L30:
        boolean r1 = false;
    L31:
        if (r1 == false) goto L33;
        return 3;
    L33:
        if ('A' <= r8) goto L35;
    L37:
        if (r2 == true) goto L43;
        return -1;
    L43:
        return 3;
    L35:
        if (r8 >= '[') goto L37;
        r2 = true;
        goto L37
    L28:
        if (r8 >= '{') goto L30;
        r1 = true;
        goto L31
    }

    public static final boolean commonIsAbsolute(Path r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (access$rootLength(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean commonIsRelative(Path r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (access$rootLength(r1) != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Character commonVolumeLetter(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        boolean r2 = false;
        if (ByteString.indexOf$default(r5.getBytes$okio(), access$getSLASH$p(), 0, 2, null) == (-1)) goto L6;
        return null;
    L6:
        if (r5.getBytes$okio().size() >= 2) goto L9;
        return null;
    L9:
        if (r5.getBytes$okio().getByte(1) == 58) goto L11;
        return null;
    L11:
        char r6 = (char) r5.getBytes$okio().getByte(0);
        if ('a' <= r6) goto L14;
    L16:
        boolean r0 = false;
    L17:
        if (r0 == true) goto L26;
        if ('A' <= r6) goto L21;
    L23:
        if (r2 == true) goto L26;
        return null;
    L21:
        if (r6 >= '[') goto L23;
        r2 = true;
    L26:
        return Character.valueOf(r6);
    L14:
        if (r6 >= '{') goto L16;
        r0 = true;
        goto L17
    }

    private static final int getIndexOfLastSlash(Path r5) {
        int r0 = ByteString.lastIndexOf$default(r5.getBytes$okio(), SLASH, 0, 2, null);
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        return ByteString.lastIndexOf$default(r5.getBytes$okio(), BACKSLASH, 0, 2, null);
    }

    public static final ByteString commonNameBytes(Path r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        int r0 = access$getIndexOfLastSlash(r4);
        if (r0 == (-1)) goto L6;
        return ByteString.substring$default(r4.getBytes$okio(), r0 + 1, 0, 2, null);
    L6:
        if (r4.volumeLetter() == null) goto L11;
        if (r4.getBytes$okio().size() != 2) goto L11;
        return ByteString.EMPTY;
    L11:
        return r4.getBytes$okio();
    }

    public static final String commonName(Path r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.nameBytes().utf8();
    }

    public static final Path commonParent(Path r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (Intrinsics.areEqual(r7.getBytes$okio(), access$getDOT$p()) == false) goto L5;
    L41:
        return null;
    L5:
        if (Intrinsics.areEqual(r7.getBytes$okio(), access$getSLASH$p()) == true) goto L41;
        if (Intrinsics.areEqual(r7.getBytes$okio(), access$getBACKSLASH$p()) == true) goto L41;
        if (access$lastSegmentIsDotDot(r7) == true) goto L41;
        int r0 = access$getIndexOfLastSlash(r7);
        if (r0 == 2) goto L14;
    L20:
        if (r0 != 1) goto L25;
        if (r7.getBytes$okio().startsWith(access$getBACKSLASH$p()) == false) goto L25;
        return null;
    L25:
        if (r0 == (-1)) goto L27;
    L33:
        if (r0 == (-1)) goto L35;
        if (r0 != 0) goto L40;
        return new Path(ByteString.substring$default(r7.getBytes$okio(), 0, 1, 1, null));
    L40:
        return new Path(ByteString.substring$default(r7.getBytes$okio(), 0, r0, 1, null));
    L35:
        return new Path(access$getDOT$p());
    L27:
        if (r7.volumeLetter() == null) goto L33;
        if (r7.getBytes$okio().size() != 2) goto L32;
        return null;
    L32:
        return new Path(ByteString.substring$default(r7.getBytes$okio(), 0, 2, 1, null));
    L14:
        if (r7.volumeLetter() == null) goto L20;
        if (r7.getBytes$okio().size() != 3) goto L19;
        return null;
    L19:
        return new Path(ByteString.substring$default(r7.getBytes$okio(), 0, 3, 1, null));
    }

    private static final boolean lastSegmentIsDotDot(Path r5) {
        if (r5.getBytes$okio().endsWith(DOT_DOT) == true) goto L5;
    L13:
        return false;
    L5:
        if (r5.getBytes$okio().size() != 2) goto L8;
        return true;
    L8:
        if (r5.getBytes$okio().rangeEquals(r5.getBytes$okio().size() - 3, SLASH, 0, 1) == false) goto L11;
        return true;
    L11:
        if (r5.getBytes$okio().rangeEquals(r5.getBytes$okio().size() - 3, BACKSLASH, 0, 1) == false) goto L13;
        return true;
    }

    public static final boolean commonIsRoot(Path r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (access$rootLength(r1) != r1.getBytes$okio().size()) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Path commonResolve(Path r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "child");
        return commonResolve(r1, toPath(new Buffer().writeUtf8(r2), false), r3);
    }

    public static final Path commonResolve(Path r1, ByteString r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "child");
        return commonResolve(r1, toPath(new Buffer().write(r2), false), r3);
    }

    public static final Path commonResolve(Path r1, Buffer r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "child");
        return commonResolve(r1, toPath(r2, false), r3);
    }

    public static final Path commonResolve(Path r6, Path r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "child");
        if (r7.isAbsolute() == false) goto L5;
    L17:
        return r7;
    L5:
        if (r7.volumeLetter() != null) goto L17;
        ByteString r0 = getSlash(r6);
        if (r0 != null) goto L12;
        r0 = getSlash(r7);
        if (r0 != null) goto L12;
        r0 = toSlash(Path.DIRECTORY_SEPARATOR);
    L12:
        Buffer r1 = new Buffer();
        r1.write(r6.getBytes$okio());
        if (r1.size() <= 0) goto L15;
        r1.write(r0);
    L15:
        r1.write(r7.getBytes$okio());
        return toPath(r1, r8);
    }

    public static final Path commonRelativeTo(Path r8, Path r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, PluralRules.KEYWORD_OTHER);
        if (Intrinsics.areEqual(r8.getRoot(), r9.getRoot()) == false) goto L36;
        List<ByteString> r0 = r8.getSegmentsBytes();
        List<ByteString> r2 = r9.getSegmentsBytes();
        int r3 = Math.min(r0.size(), r2.size());
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L9;
        if (Intrinsics.areEqual(r0.get(r5), r2.get(r5)) == false) goto L9;
        r5 = r5 + 1;
    L9:
        boolean r6 = true;
        if (r5 != r3) goto L16;
        if (r8.getBytes$okio().size() != r9.getBytes$okio().size()) goto L16;
        return Path.Companion.get$default(Path.Companion, ".", false, 1, null);
    L16:
        if (r2.subList(r5, r2.size()).indexOf(access$getDOT_DOT$p()) == (-1)) goto L19;
        r6 = false;
    L19:
        if (r6 == false) goto L34;
        Buffer r1 = new Buffer();
        ByteString r10 = access$getSlash(r9);
        if (r10 != null) goto L25;
        r10 = access$getSlash(r8);
        if (r10 != null) goto L25;
        r10 = access$toSlash(Path.DIRECTORY_SEPARATOR);
    L25:
        int r11 = r2.size();
        int r4 = r5;
    L26:
        if (r4 >= r11) goto L28;
        r1.write(access$getDOT_DOT$p());
        r1.write(r10);
        r4 = r4 + 1;
        goto L26
    L28:
        int r12 = r0.size();
    L29:
        if (r5 >= r12) goto L32;
        r1.write(r0.get(r5));
        r1.write(r10);
        r5 = r5 + 1;
        goto L29
    L32:
        return toPath(r1, false);
    L34:
        throw new IllegalArgumentException(("Impossible relative path to resolve: " + r8 + " and " + r9).toString());
    L36:
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + r8 + " and " + r9).toString());
    }

    public static final Path commonNormalized(Path r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return Path.Companion.get(r2.toString(), true);
    }

    private static final ByteString getSlash(Path r6) {
        ByteString r0 = r6.getBytes$okio();
        ByteString r1 = SLASH;
        if (ByteString.indexOf$default(r0, r1, 0, 2, null) != (-1)) goto L10;
        ByteString r7 = r6.getBytes$okio();
        ByteString r2 = BACKSLASH;
        if (ByteString.indexOf$default(r7, r2, 0, 2, null) == (-1)) goto L9;
        return r2;
    L9:
        return null;
    L10:
        return r1;
    }

    public static final int commonCompareTo(Path r1, Path r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, PluralRules.KEYWORD_OTHER);
        return r1.getBytes$okio().compareTo2(r2.getBytes$okio());
    }

    public static final boolean commonEquals(Path r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r2 instanceof Path) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((Path) r2).getBytes$okio(), r1.getBytes$okio()) == false) goto L7;
        return true;
    }

    public static final int commonHashCode(Path r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getBytes$okio().hashCode();
    }

    public static final String commonToString(Path r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getBytes$okio().utf8();
    }

    public static final Path commonToPath(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return toPath(new Buffer().writeUtf8(r1), r2);
    }

    public static final Path toPath(Buffer r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Buffer r1 = new Buffer();
        ByteString r2 = null;
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r16.rangeEquals(0, SLASH) == true) goto L74;
        ByteString r5 = BACKSLASH;
        if (r16.rangeEquals(0, r5) == true) goto L74;
        if (r4 >= 2) goto L11;
    L13:
        boolean r6 = false;
    L15:
        if (r6 == false) goto L17;
        Intrinsics.checkNotNull(r2);
        r1.write(r2);
        r1.write(r2);
    L32:
        if (r1.size() <= 0) goto L34;
        boolean r7 = true;
    L35:
        ArrayList r8 = new ArrayList();
    L37:
        if (r16.exhausted() == true) goto L64;
        long r12 = r16.indexOfElement(ANY_SLASH);
        if (r12 != (-1)) goto L41;
        ByteString r13 = r16.readByteString();
    L42:
        ByteString r14 = DOT_DOT;
        if (Intrinsics.areEqual(r13, r14) == true) goto L44;
        if (Intrinsics.areEqual(r13, DOT) == true) goto L37;
        if (Intrinsics.areEqual(r13, ByteString.EMPTY) == true) goto L37;
        r8.add(r13);
        goto L37
    L44:
        if (r7 == false) goto L47;
        if (r8.isEmpty() == true) goto L37;
    L47:
        if (r17 == false) goto L58;
        if (r7 == true) goto L54;
        if (r8.isEmpty() == true) goto L58;
        if (Intrinsics.areEqual(CollectionsKt.last(r8), r14) == true) goto L58;
    L54:
        if (r6 == false) goto L57;
        if (r8.size() == 1) goto L37;
    L57:
        CollectionsKt.removeLastOrNull(r8);
    L58:
        r8.add(r13);
        goto L37
    L41:
        r13 = r16.readByteString(r12);
        r16.readByte();
        goto L42
    L64:
        int r0 = r8.size();
    L65:
        if (r3 >= r0) goto L70;
        if (r3 <= 0) goto L68;
        r1.write(r2);
    L68:
        r1.write((ByteString) r8.get(r3));
        r3 = r3 + 1;
        goto L65
    L70:
        if (r1.size() != 0) goto L73;
        r1.write(DOT);
    L73:
        return new Path(r1.readByteString());
    L34:
        r7 = false;
        goto L35
    L17:
        if (r4 <= 0) goto L19;
        Intrinsics.checkNotNull(r2);
        r1.write(r2);
        goto L32
    L19:
        long r15 = r16.indexOfElement(ANY_SLASH);
        if (r2 != null) goto L26;
        if (r15 != (-1)) goto L24;
        r2 = toSlash(Path.DIRECTORY_SEPARATOR);
        goto L26
    L24:
        r2 = toSlash(r16.getByte(r15));
    L26:
        if (startsWithVolumeLetterAndColon(r16, r2) == false) goto L32;
        if (r15 != 2) goto L30;
        r1.write(r16, 3);
        goto L32
    L30:
        r1.write(r16, 2);
        goto L32
    L11:
        if (Intrinsics.areEqual(r2, r5) == false) goto L13;
        r6 = true;
    L74:
        byte r9 = r16.readByte();
        if (r2 != null) goto L77;
        r2 = toSlash(r9);
    L77:
        r4 = r4 + 1;
        goto L4
    }

    private static final ByteString toSlash(String r3) {
        if (Intrinsics.areEqual(r3, LibrarianImpl.Constants.SEPARATOR) == false) goto L6;
        return SLASH;
    L6:
        if (Intrinsics.areEqual(r3, "\\") == false) goto L10;
        return BACKSLASH;
    L10:
        throw new IllegalArgumentException("not a directory separator: " + r3);
    }

    private static final ByteString toSlash(byte r3) {
        if (r3 == 47) goto L10;
        if (r3 != 92) goto L8;
        return BACKSLASH;
    L8:
        throw new IllegalArgumentException("not a directory separator: " + r3);
    L10:
        return SLASH;
    }

    private static final boolean startsWithVolumeLetterAndColon(Buffer r5, ByteString r6) {
        if (Intrinsics.areEqual(r6, BACKSLASH) == true) goto L6;
        return false;
    L6:
        if (r5.size() >= 2) goto L9;
        return false;
    L9:
        if (r5.getByte(1) == 58) goto L11;
        return false;
    L11:
        char r7 = (char) r5.getByte(0);
        if ('a' <= r7) goto L14;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == true) goto L26;
        if ('A' <= r7) goto L21;
    L23:
        boolean r9 = false;
    L24:
        if (r9 == true) goto L26;
        return false;
    L21:
        if (r7 >= '[') goto L23;
        r9 = true;
    L26:
        return true;
    L14:
        if (r7 >= '{') goto L16;
        r8 = true;
        goto L17
    }

    public static final List<String> commonSegments(Path r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        ArrayList r0 = new ArrayList();
        int r1 = access$rootLength(r7);
        if (r1 != (-1)) goto L6;
        r1 = 0;
    L10:
        int r2 = r7.getBytes$okio().size();
        int r4 = r1;
    L11:
        if (r1 >= r2) goto L19;
        if (r7.getBytes$okio().getByte(r1) != 47) goto L15;
    L16:
        r0.add(r7.getBytes$okio().substring(r4, r1));
        r4 = r1 + 1;
    L17:
        r1 = r1 + 1;
        goto L11
    L15:
        if (r7.getBytes$okio().getByte(r1) != 92) goto L17;
    L19:
        if (r4 >= r7.getBytes$okio().size()) goto L21;
        r0.add(r7.getBytes$okio().substring(r4, r7.getBytes$okio().size()));
    L21:
        ArrayList r3 = r0;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L23:
        if (r5.hasNext() == false) goto L26;
        r8.add(((ByteString) r5.next()).utf8());
        goto L23
    L26:
        return r8;
    L6:
        if (r1 >= r7.getBytes$okio().size()) goto L10;
        if (r7.getBytes$okio().getByte(r1) != 92) goto L10;
        r1 = r1 + 1;
        goto L10
    }
}
