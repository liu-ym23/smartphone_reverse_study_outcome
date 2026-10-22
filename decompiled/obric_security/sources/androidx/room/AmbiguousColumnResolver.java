package androidx.room;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.preventdisturb.Contact;
import com.bytedanceos.security.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: AmbiguousColumnResolver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002JV\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00070\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0007\u0012\u0004\u0012\u00020\u00040\rH\u0002JO\u0010\u000e\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112$\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0007\u0012\u0004\u0012\u00020\u00040\u0014H\u0002¢\u0006\u0002\u0010\u0015J5\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0011H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001e"}, d2 = {"Landroidx/room/AmbiguousColumnResolver;", "", "()V", "dfs", "", ExifInterface.GPS_DIRECTION_TRUE, Contact.CONTENT_SCHEME, "", PerfConsts.KEY_CURRENT_GALVANIC, "", "depth", "", "block", "Lkotlin/Function1;", "rabinKarpSearch", "Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "pattern", "", "", "onHashMatch", "Lkotlin/Function3;", "(Ljava/util/List;[Ljava/lang/String;Lkotlin/jvm/functions/Function3;)V", "resolve", "", "resultColumns", "mappings", "([Ljava/lang/String;[[Ljava/lang/String;)[[I", "Match", "ResultColumn", "Solution", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AmbiguousColumnResolver {
    public static final AmbiguousColumnResolver INSTANCE = null;

    /* JADX INFO: compiled from: AmbiguousColumnResolver.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Match;", "", "resultRange", "Lkotlin/ranges/IntRange;", "resultIndices", "", "", "(Lkotlin/ranges/IntRange;Ljava/util/List;)V", "getResultIndices", "()Ljava/util/List;", "getResultRange", "()Lkotlin/ranges/IntRange;", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class Match {
        private final List<Integer> resultIndices;
        private final IntRange resultRange;

        public Match(IntRange r2, List<Integer> r3) {
            Intrinsics.checkNotNullParameter(r2, "resultRange");
            Intrinsics.checkNotNullParameter(r3, "resultIndices");
            this.resultRange = r2;
            this.resultIndices = r3;
        }

        public final IntRange getResultRange() {
            return this.resultRange;
        }

        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }
    }

    /* JADX INFO: compiled from: AmbiguousColumnResolver.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "", "name", "", Utils.INTENT_KEY_INDEX, "", "(Ljava/lang/String;I)V", "getIndex", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class ResultColumn {
        private final int index;
        private final String name;

        public static /* synthetic */ ResultColumn copy$default(ResultColumn r0, String r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.name;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.index;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.index;
        }

        public final ResultColumn copy(String r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "name");
            return new ResultColumn(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ResultColumn) == true) goto L8;
            return false;
        L8:
            ResultColumn r6 = (ResultColumn) r5;
            if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
            return false;
        L12:
            if (this.index == r6.index) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + Integer.hashCode(this.index);
        }

        public String toString() {
            return "ResultColumn(name=" + this.name + ", index=" + this.index + ')';
        }

        public ResultColumn(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            this.name = r2;
            this.index = r3;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: AmbiguousColumnResolver.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Solution;", "", "matches", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "coverageOffset", "", "overlaps", "(Ljava/util/List;II)V", "getCoverageOffset", "()I", "getMatches", "()Ljava/util/List;", "getOverlaps", "compareTo", "other", "Companion", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class Solution implements Comparable<Solution> {
        public static final Companion Companion = null;
        private static final Solution NO_SOLUTION = null;
        private final int coverageOffset;
        private final List<Match> matches;
        private final int overlaps;

        /* JADX INFO: compiled from: AmbiguousColumnResolver.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Solution$Companion;", "", "()V", "NO_SOLUTION", "Landroidx/room/AmbiguousColumnResolver$Solution;", "getNO_SOLUTION", "()Landroidx/room/AmbiguousColumnResolver$Solution;", "build", "matches", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            public final Solution getNO_SOLUTION() {
                return Solution.access$getNO_SOLUTION$cp();
            }

            public final Solution build(List<Match> r10) {
                Intrinsics.checkNotNullParameter(r10, "matches");
                List<Match> r9 = r10;
                Iterator<T> r0 = r9.iterator();
                int r1 = 0;
                int r2 = 0;
            L4:
                if (r0.hasNext() == false) goto L6;
                Match r3 = (Match) r0.next();
                r2 = r2 + (((r3.getResultRange().getLast() - r3.getResultRange().getFirst()) + 1) - r3.getResultIndices().size());
                goto L4
            L6:
                Iterator<T> r4 = r9.iterator();
                if (r4.hasNext() == false) goto L49;
                int r5 = ((Match) r4.next()).getResultRange().getFirst();
            L10:
                if (r4.hasNext() == false) goto L14;
                int r6 = ((Match) r4.next()).getResultRange().getFirst();
                if (r5 <= r6) goto L10;
                r5 = r6;
                goto L10
            L14:
                Iterator<T> r7 = r9.iterator();
                if (r7.hasNext() == false) goto L47;
                int r8 = ((Match) r7.next()).getResultRange().getLast();
            L18:
                if (r7.hasNext() == false) goto L22;
                int r11 = ((Match) r7.next()).getResultRange().getLast();
                if (r8 >= r11) goto L18;
                r8 = r11;
                goto L18
            L22:
                Iterable r12 = new IntRange(r5, r8);
                if ((r12 instanceof Collection) == true) goto L25;
            L27:
                Iterator r13 = r12.iterator();
                int r14 = 0;
            L29:
                if (r13.hasNext() == false) goto L43;
                int r15 = ((IntIterator) r13).nextInt();
                Iterator<T> r16 = r9.iterator();
                int r17 = 0;
            L32:
                if (r16.hasNext() == false) goto L38;
                if (((Match) r16.next()).getResultRange().contains(r15) == false) goto L36;
                r17 = r17 + 1;
            L36:
                if (r17 <= 1) goto L32;
                boolean r18 = true;
            L39:
                if (r18 == false) goto L29;
                r14 = r14 + 1;
                if (r14 >= 0) goto L29;
                CollectionsKt.throwCountOverflow();
                goto L29
            L38:
                r18 = false;
                goto L39
            L43:
                r1 = r14;
            L45:
                return new Solution(r10, r2, r1);
            L25:
                if (((Collection) r12).isEmpty() == false) goto L27;
            L47:
                throw new NoSuchElementException();
            L49:
                throw new NoSuchElementException();
            }
        }

        public Solution(List<Match> r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "matches");
            this.matches = r2;
            this.coverageOffset = r3;
            this.overlaps = r4;
        }

        public static final /* synthetic */ Solution access$getNO_SOLUTION$cp() {
            return NO_SOLUTION;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Solution r1) {
            return compareTo2(r1);
        }

        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(Solution r3) {
            Intrinsics.checkNotNullParameter(r3, "other");
            int r0 = Intrinsics.compare(this.overlaps, r3.overlaps);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return Intrinsics.compare(this.coverageOffset, r3.coverageOffset);
        }

        static {
            Companion = new Companion(null);
            NO_SOLUTION = new Solution(CollectionsKt.emptyList(), Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
    }

    static {
        INSTANCE = new AmbiguousColumnResolver();
    }

    private AmbiguousColumnResolver() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15, types: [T, androidx.room.AmbiguousColumnResolver$Solution] */
    @JvmStatic
    public static final int[][] resolve(String[] r17, String[][] r18) {
        Intrinsics.checkNotNullParameter(r17, "resultColumns");
        Intrinsics.checkNotNullParameter(r18, "mappings");
        int r2 = r17.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        boolean r7 = true;
        if (r4 >= r2) goto L11;
        String r8 = r17[r4];
        if (r8.charAt(0) != '`') goto L10;
        if (r8.charAt(r8.length() - 1) != '`') goto L10;
        r8 = r8.substring(1, r8.length() - 1);
        Intrinsics.checkNotNullExpressionValue(r8, "this as java.lang.String…ing(startIndex, endIndex)");
    L10:
        Locale r9 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r9, "US");
        String r6 = r8.toLowerCase(r9);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).toLowerCase(locale)");
        r17[r4] = r6;
        r4 = r4 + 1;
        goto L3
    L11:
        String[][] r5 = r18;
        int r10 = r5.length;
        int r11 = 0;
    L12:
        if (r11 >= r10) goto L17;
        int r12 = r18[r11].length;
        int r13 = 0;
    L14:
        if (r13 >= r12) goto L16;
        String[] r14 = r18[r11];
        String r15 = r14[r13];
        Locale r16 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r16, "US");
        String r19 = r15.toLowerCase(r16);
        Intrinsics.checkNotNullExpressionValue(r19, "this as java.lang.String).toLowerCase(locale)");
        r14[r13] = r19;
        r13 = r13 + 1;
        goto L14
    L16:
        r11 = r11 + 1;
        goto L12
    L17:
        Set r1 = SetsKt.createSetBuilder();
        int r20 = r5.length;
        int r21 = 0;
    L18:
        if (r21 >= r20) goto L20;
        CollectionsKt.addAll(r1, r5[r21]);
        r21 = r21 + 1;
        goto L18
    L20:
        Set r22 = SetsKt.build(r1);
        List r23 = CollectionsKt.createListBuilder();
        int r24 = r17.length;
        int r25 = 0;
        int r26 = 0;
    L21:
        if (r25 >= r24) goto L26;
        String r27 = r17[r25];
        int r110 = r26 + 1;
        if (r22.contains(r27) == false) goto L25;
        r23.add(new ResultColumn(r27, r26));
    L25:
        r25 = r25 + 1;
        r26 = r110;
        goto L21
    L26:
        List<ResultColumn> r0 = CollectionsKt.build(r23);
        int r28 = r5.length;
        ArrayList r29 = new ArrayList(r28);
        int r30 = 0;
    L27:
        if (r30 >= r28) goto L29;
        r29.add(new ArrayList());
        r30 = r30 + 1;
        goto L27
    L29:
        final ArrayList r31 = r29;
        int r32 = r5.length;
        int r33 = 0;
        final int r34 = 0;
    L30:
        if (r33 >= r32) goto L49;
        int r35 = r34 + 1;
        final String[] r36 = r5[r33];
        INSTANCE.rabinKarpSearch(r0, r36, new AmbiguousColumnResolver$resolve$1$1(r36, r31, r34));
        if (((List) r31.get(r34)).isEmpty() == false) goto L48;
        ArrayList r111 = new ArrayList(r36.length);
        int r112 = r36.length;
        int r113 = r3;
    L34:
        if (r113 >= r112) goto L47;
        String r114 = r36[r113];
        List r115 = CollectionsKt.createListBuilder();
        Iterator<T> r116 = r0.iterator();
    L37:
        if (r116.hasNext() == false) goto L42;
        ResultColumn r117 = (ResultColumn) r116.next();
        if (Intrinsics.areEqual(r114, r117.getName()) == false) goto L37;
        r115.add(Integer.valueOf(r117.getIndex()));
        goto L37
    L42:
        List r37 = CollectionsKt.build(r115);
        if ((!r37.isEmpty()) == false) goto L46;
        r111.add(r37);
        r113 = r113 + 1;
        goto L34
    L46:
        throw new IllegalStateException(("Column " + r114 + " not found in result").toString());
    L47:
        dfs$default(INSTANCE, r111, null, 0, new AmbiguousColumnResolver$resolve$1$2(r31, r34), 6, null);
    L48:
        r33 = r33 + 1;
        r34 = r35;
        r3 = 0;
        goto L30
    L49:
        ArrayList r38 = r31;
        if ((r38 instanceof Collection) == true) goto L52;
    L54:
        Iterator r39 = r38.iterator();
    L56:
        if (r39.hasNext() == false) goto L60;
        if ((!((List) r39.next()).isEmpty()) == true) goto L56;
        r7 = false;
    L60:
        if (r7 == false) goto L68;
        final Ref.ObjectRef r40 = new Ref.ObjectRef();
        r40.element = Solution.Companion.getNO_SOLUTION();
        dfs$default(INSTANCE, r31, null, 0, new AnonymousClass4(r40), 6, null);
        List<Match> r41 = ((Solution) r40.element).getMatches();
        ArrayList r42 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r41, 10));
        Iterator<T> r43 = r41.iterator();
    L63:
        if (r43.hasNext() == false) goto L65;
        r42.add(CollectionsKt.toIntArray(((Match) r43.next()).getResultIndices()));
        goto L63
    L65:
        Object[] r44 = r42.toArray(new int[0][]);
        Intrinsics.checkNotNull(r44, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (int[][]) r44;
    L68:
        throw new IllegalStateException("Failed to find matches for all mappings".toString());
    L52:
        if (r38.isEmpty() == false) goto L54;
        goto L54
    }

    private final void rabinKarpSearch(List<ResultColumn> r6, String[] r7, Function3<? super Integer, ? super Integer, ? super List<ResultColumn>, Unit> r8) {
        int r5 = r7.length;
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r5) goto L5;
        r2 = r2 + r7[r1].hashCode();
        r1 = r1 + 1;
        goto L3
    L5:
        int r9 = r7.length;
        Iterator<T> r10 = r6.subList(0, r9).iterator();
        int r3 = 0;
    L7:
        if (r10.hasNext() == false) goto L9;
        r3 = r3 + ((ResultColumn) r10.next()).getName().hashCode();
    L9:
        if (r2 != r3) goto L11;
        r8.invoke(Integer.valueOf(r0), Integer.valueOf(r9), r6.subList(r0, r9));
    L11:
        r0 = r0 + 1;
        r9 = r9 + 1;
        if (r9 > r6.size()) goto L13;
        r3 = (r3 - r6.get(r0 - 1).getName().hashCode()) + r6.get(r9 - 1).getName().hashCode();
        goto L9
    }

    static /* synthetic */ void dfs$default(AmbiguousColumnResolver r0, List r1, ArrayList r2, int r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = new ArrayList();
    L6:
        if ((r5 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        r0.dfs(r1, r2, r3, r4);
    }

    private final <T> void dfs(List<? extends List<? extends T>> r3, List<T> r4, int r5, Function1<? super List<? extends T>, Unit> r6) {
        if (r5 != r3.size()) goto L6;
        r6.invoke(CollectionsKt.toList(r4));
        return;
    L6:
        Iterator<T> r2 = r3.get(r5).iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r4.add(r2.next());
        INSTANCE.dfs(r3, r4, r5 + 1, r6);
        CollectionsKt.removeLast(r4);
        goto L8
    }
}
