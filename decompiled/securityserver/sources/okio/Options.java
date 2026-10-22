package okio;

import a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public static final Companion Companion = null;

    @NotNull
    private final ByteString[] byteStrings;

    @NotNull
    private final int[] trie;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final void buildTrieRecursive(long r20, Buffer r22, int r23, List<? extends ByteString> r24, int r25, int r26, List<Integer> r27) {
            int r11 = r23;
            if (r25 >= r26) goto L5;
            boolean r3 = true;
        L7:
            if (r3 == false) goto L75;
            int r4 = r25;
        L9:
            if (r4 >= r26) goto L18;
            if (r24.get(r4).size() < r11) goto L13;
            boolean r5 = true;
        L14:
            if (r5 == false) goto L17;
            r4 = r4 + 1;
            goto L9
        L17:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L13:
            r5 = false;
            goto L14
        L18:
            ByteString r6 = r24.get(r25);
            ByteString r7 = r24.get(r26 - 1);
            int r15 = -1;
            if (r11 != r6.size()) goto L21;
            int r8 = r27.get(r25).intValue();
            int r0 = r25 + 1;
            ByteString r9 = r24.get(r0);
            int r10 = r0;
            int r1 = r8;
            r6 = r9;
        L23:
            if (r6.getByte(r11) == r7.getByte(r11)) goto L54;
            int r2 = r10 + 1;
            int r12 = 1;
        L25:
            if (r2 >= r26) goto L30;
            if (r24.get(r2 - 1).getByte(r11) == r24.get(r2).getByte(r11)) goto L29;
            r12 = r12 + 1;
        L29:
            r2 = r2 + 1;
            goto L25
        L30:
            long r16 = ((r20 + getIntCount(r22)) + ((long) 2)) + ((long) (r12 * 2));
            r22.writeInt(r12);
            r22.writeInt(r1);
            int r13 = r10;
        L31:
            if (r13 >= r26) goto L38;
            byte r14 = r24.get(r13).getByte(r11);
            if (r13 != r10) goto L35;
        L36:
            r22.writeInt(r14 & 255);
        L37:
            r13 = r13 + 1;
            goto L31
        L35:
            if (r14 == r24.get(r13 - 1).getByte(r11)) goto L37;
        L38:
            Buffer r17 = new Buffer();
        L39:
            if (r10 >= r26) goto L53;
            byte r18 = r24.get(r10).getByte(r11);
            int r19 = r10 + 1;
            int r21 = r19;
        L41:
            if (r21 >= r26) goto L46;
            if (r18 != r24.get(r21).getByte(r11)) goto L44;
            r21 = r21 + 1;
            goto L41
        L44:
            int r28 = r21;
        L47:
            if (r19 == r28) goto L49;
        L51:
            r22.writeInt(((int) (r16 + getIntCount(r17))) * r15);
            buildTrieRecursive(r16, r17, r11 + 1, r24, r10, r28, r27);
        L52:
            r17 = r17;
            r10 = r28;
            r15 = -1;
            goto L39
        L49:
            if ((r11 + 1) != r24.get(r10).size()) goto L51;
            r22.writeInt(r27.get(r10).intValue());
            goto L52
        L46:
            r28 = r26;
            goto L47
        L53:
            r22.writeAll(r17);
            return;
        L54:
            int r29 = Math.min(r6.size(), r7.size());
            int r30 = r11;
            int r110 = 0;
        L55:
            if (r30 >= r29) goto L59;
            if (r6.getByte(r30) != r7.getByte(r30)) goto L59;
            r110 = r110 + 1;
            r30 = r30 + 1;
        L59:
            long r31 = (((r20 + getIntCount(r22)) + ((long) 2)) + ((long) r110)) + 1;
            r22.writeInt(-r110);
            r22.writeInt(r1);
            int r32 = r11 + r110;
        L60:
            if (r11 >= r32) goto L63;
            r22.writeInt(r6.getByte(r11) & 255);
            r11 = r11 + 1;
            goto L60
        L63:
            if ((r10 + 1) == r26) goto L65;
            Buffer r111 = new Buffer();
            r22.writeInt(((int) (getIntCount(r111) + r31)) * (-1));
            buildTrieRecursive(r31, r111, r32, r24, r10, r26, r27);
            r22.writeAll(r111);
            return;
        L65:
            if (r32 != r24.get(r10).size()) goto L67;
            boolean r33 = true;
        L68:
            if (r33 == false) goto L71;
            r22.writeInt(r27.get(r10).intValue());
            return;
        L71:
            throw new IllegalStateException("Check failed.".toString());
        L67:
            r33 = false;
            goto L68
        L21:
            r10 = r25;
            r1 = -1;
            goto L23
        L75:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r3 = false;
            goto L7
        }

        public static /* synthetic */ void buildTrieRecursive$default(Companion r11, long r12, Buffer r14, int r15, List r16, int r17, int r18, List r19, int r20, Object r21) {
            if ((r20 & 1) == 0) goto L5;
            long r3 = 0;
        L7:
            if ((r20 & 4) == 0) goto L9;
            int r6 = 0;
        L11:
            if ((r20 & 16) == 0) goto L13;
            int r8 = 0;
        L15:
            if ((r20 & 32) == 0) goto L17;
            int r9 = r16.size();
        L18:
            r11.buildTrieRecursive(r3, r14, r6, r16, r8, r9, r19);
            return;
        L17:
            r9 = r18;
            goto L18
        L13:
            r8 = r17;
            goto L15
        L9:
            r6 = r15;
            goto L11
        L5:
            r3 = r12;
            goto L7
        }

        private final long getIntCount(Buffer r3) {
            return r3.size() / ((long) 4);
        }

        @JvmStatic
        @NotNull
        public final Options of(@NotNull ByteString... r17) {
            Intrinsics.f(r17, "byteStrings");
            DefaultConstructorMarker r2 = null;
            int r4 = 0;
            if (r17.length == 0) goto L5;
            ArrayList r10 = ArraysKt.v(r17);
            if (r10.size() <= 1) goto L9;
            Collections.sort(r10);
        L9:
            ArrayList r1 = new ArrayList(r17.length);
            int r6 = r17.length;
            int r7 = 0;
        L10:
            if (r7 >= r6) goto L12;
            ByteString r8 = r17[r7];
            r1.add(-1);
            r7 = r7 + 1;
            goto L10
        L12:
            Object[] r3 = r1.toArray(new Integer[0]);
            if (r3 == null) goto L68;
            Integer[] r5 = (Integer[]) r3;
            ArrayList r13 = CollectionsKt.l((Integer[]) Arrays.copyOf(r5, r5.length));
            int r9 = r17.length;
            int r11 = 0;
            int r12 = 0;
        L15:
            if (r11 >= r9) goto L40;
            ByteString r14 = r17[r11];
            int r15 = r12 + 1;
            int r16 = r10.size();
            int r18 = r10.size();
            if (r16 < 0) goto L38;
            if (r16 > r18) goto L36;
            int r19 = r16 - 1;
            int r110 = 0;
        L20:
            if (r110 > r19) goto L33;
            int r111 = (r110 + r19) >>> 1;
            Comparable r112 = (Comparable) r10.get(r111);
            if (r112 != r14) goto L24;
            int r113 = 0;
        L29:
            if (r113 < 0) goto L30;
            if (r113 <= 0) goto L34;
            r19 = r111 - 1;
        L34:
            r13.set(r111, Integer.valueOf(r12));
            r11 = r11 + 1;
            r12 = r15;
            goto L15
        L30:
            r110 = r111 + 1;
            goto L20
        L24:
            if (r112 != null) goto L26;
            r113 = -1;
            goto L29
        L26:
            if (r14 != null) goto L28;
            r113 = 1;
            goto L29
        L28:
            r113 = r112.compareTo(r14);
            goto L29
        L33:
            r111 = -(r110 + 1);
            goto L34
        L36:
            throw new IndexOutOfBoundsException("toIndex (" + r16 + ") is greater than size (" + r18 + ").");
        L38:
            throw new IllegalArgumentException(a.f(r16, "fromIndex (0) is greater than toIndex (", ")."));
        L40:
            if (((ByteString) r10.get(0)).size() <= 0) goto L66;
            int r20 = 0;
        L43:
            if (r20 >= r10.size()) goto L59;
            ByteString r21 = (ByteString) r10.get(r20);
            int r22 = r20 + 1;
            int r23 = r22;
        L46:
            if (r23 >= r10.size()) goto L58;
            ByteString r24 = (ByteString) r10.get(r23);
            if (r24.startsWith(r21) == false) goto L58;
            if (r24.size() == r21.size()) goto L57;
            if (((Number) r13.get(r23)).intValue() > ((Number) r13.get(r20)).intValue()) goto L54;
            r23 = r23 + 1;
            goto L46
        L54:
            r10.remove(r23);
            r13.remove(r23);
            goto L46
        L57:
            throw new IllegalArgumentException(("duplicate option: " + r24).toString());
        L58:
            r20 = r22;
            goto L43
        L59:
            Buffer r25 = new Buffer();
            buildTrieRecursive$default(this, 0, r25, 0, r10, 0, 0, r13, 53, null);
            int[] r26 = new int[(int) getIntCount(r25)];
        L61:
            if (r25.exhausted() == true) goto L63;
            r26[r4] = r25.readInt();
            r4 = r4 + 1;
            goto L61
        L63:
            Object[] r0 = Arrays.copyOf(r17, r17.length);
            Intrinsics.e(r0, "java.util.Arrays.copyOf(this, size)");
            return new Options((ByteString[]) r0, r26, r2);
        L66:
            throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
        L68:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L5:
            return new Options(new ByteString[0], new int[]{0, -1}, r2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private Options(ByteString[] r1, int[] r2) {
        this.byteStrings = r1;
        this.trie = r2;
    }

    @JvmStatic
    @NotNull
    public static final Options of(@NotNull ByteString... r1) {
        return Companion.of(r1);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object r2) {
        if ((r2 instanceof ByteString) == true) goto L5;
        return false;
    L5:
        return contains((ByteString) r2);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return get(r1);
    }

    @NotNull
    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.byteStrings.length;
    }

    @NotNull
    public final int[] getTrie$okio() {
        return this.trie;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r2) {
        if ((r2 instanceof ByteString) == true) goto L5;
        return -1;
    L5:
        return indexOf((ByteString) r2);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r2) {
        if ((r2 instanceof ByteString) == true) goto L5;
        return -1;
    L5:
        return lastIndexOf((ByteString) r2);
    }

    public /* bridge */ boolean contains(ByteString r1) {
        return super.contains(r1);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    @NotNull
    public ByteString get(int r1) {
        return this.byteStrings[r1];
    }

    public /* bridge */ int indexOf(ByteString r1) {
        return super.indexOf(r1);
    }

    public /* bridge */ int lastIndexOf(ByteString r1) {
        return super.lastIndexOf(r1);
    }

    public /* synthetic */ Options(ByteString[] r1, int[] r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }
}
