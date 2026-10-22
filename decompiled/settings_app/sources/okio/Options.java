package okio;

import com.bytedance.apm.constant.PerfConsts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Options.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0015B\u001f\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0096\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", "", "trie", "", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", PerfConsts.PERF_DISK_FILE_SIZE, "", "getSize", "()I", "getTrie$okio", "()[I", "get", "index", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public static final Companion Companion = null;
    private final ByteString[] byteStrings;
    private final int[] trie;

    /* JADX INFO: compiled from: Options.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J!\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0016\"\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0017R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lokio/Options$Companion;", "", "()V", "intCount", "", "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", "", "nodeOffset", "node", "byteStringOffset", "", "byteStrings", "", "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", "", "([Lokio/ByteString;)Lokio/Options;", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Options of(ByteString... r17) {
            Intrinsics.checkNotNullParameter(r17, "byteStrings");
            int r3 = 0;
            if (r17.length != 0) goto L5;
            boolean r1 = true;
        L6:
            DefaultConstructorMarker r4 = null;
            if (r1 == true) goto L9;
            List r2 = ArraysKt.toMutableList(r17);
            CollectionsKt.sort(r2);
            ArrayList r5 = new ArrayList(r17.length);
            int r6 = r17.length;
            int r7 = 0;
        L11:
            if (r7 >= r6) goto L13;
            ByteString r8 = r17[r7];
            r5.add(-1);
            r7 = r7 + 1;
            goto L11
        L13:
            Integer[] r9 = (Integer[]) r5.toArray(new Integer[0]);
            List r13 = CollectionsKt.mutableListOf(Arrays.copyOf(r9, r9.length));
            int r11 = r17.length;
            int r12 = 0;
            int r14 = 0;
        L14:
            if (r12 >= r11) goto L17;
            r13.set(CollectionsKt.binarySearch$default(r2, r17[r12], 0, 0, 6, null), Integer.valueOf(r14));
            r12 = r12 + 1;
            r14 = r14 + 1;
            goto L14
        L17:
            if (((ByteString) r2.get(0)).size() <= 0) goto L19;
            boolean r10 = true;
        L20:
            if (r10 == false) goto L48;
            int r15 = 0;
        L23:
            if (r15 >= r2.size()) goto L41;
            ByteString r16 = (ByteString) r2.get(r15);
            int r18 = r15 + 1;
            int r19 = r18;
        L26:
            if (r19 >= r2.size()) goto L40;
            ByteString r20 = (ByteString) r2.get(r19);
            if (r20.startsWith(r16) == false) goto L40;
            if (r20.size() == r16.size()) goto L32;
            boolean r110 = true;
        L33:
            if (r110 == false) goto L39;
            if (((Number) r13.get(r19)).intValue() > ((Number) r13.get(r15)).intValue()) goto L36;
            r19 = r19 + 1;
            goto L26
        L36:
            r2.remove(r19);
            r13.remove(r19);
            goto L26
        L39:
            throw new IllegalArgumentException(("duplicate option: " + r20).toString());
        L32:
            r110 = false;
        L40:
            r15 = r18;
            goto L23
        L41:
            Buffer r21 = new Buffer();
            buildTrieRecursive$default(this, 0, r21, 0, r2, 0, 0, r13, 53, null);
            int[] r22 = new int[(int) getIntCount(r21)];
        L43:
            if (r21.exhausted() == true) goto L45;
            r22[r3] = r21.readInt();
            r3 = r3 + 1;
            goto L43
        L45:
            Object[] r0 = Arrays.copyOf(r17, r17.length);
            Intrinsics.checkNotNullExpressionValue(r0, "copyOf(this, size)");
            return new Options((ByteString[]) r0, r22, r4);
        L48:
            throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
        L19:
            r10 = false;
            goto L20
        L9:
            return new Options(new ByteString[0], new int[]{0, -1}, r4);
        L5:
            r1 = false;
            goto L6
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion r11, long r12, Buffer r14, int r15, List r16, int r17, int r18, List r19, int r20, Object r21) {
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

        private final void buildTrieRecursive(long r21, Buffer r23, int r24, List<? extends ByteString> r25, int r26, int r27, List<Integer> r28) {
            int r11 = r24;
            if (r26 >= r27) goto L5;
            boolean r3 = true;
        L7:
            if (r3 == false) goto L75;
            int r4 = r26;
        L9:
            if (r4 >= r27) goto L18;
            if (r25.get(r4).size() < r11) goto L13;
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
            ByteString r6 = r25.get(r26);
            ByteString r7 = r25.get(r27 - 1);
            if (r11 != r6.size()) goto L21;
            int r8 = r28.get(r26).intValue();
            int r0 = r26 + 1;
            ByteString r9 = r25.get(r0);
            int r10 = r0;
            int r1 = r8;
            r6 = r9;
        L23:
            if (r6.getByte(r11) == r7.getByte(r11)) goto L54;
            int r2 = r10 + 1;
            int r12 = 1;
        L25:
            if (r2 >= r27) goto L30;
            if (r25.get(r2 - 1).getByte(r11) == r25.get(r2).getByte(r11)) goto L29;
            r12 = r12 + 1;
        L29:
            r2 = r2 + 1;
            goto L25
        L30:
            long r16 = ((r21 + getIntCount(r23)) + ((long) 2)) + ((long) (r12 * 2));
            r23.writeInt(r12);
            r23.writeInt(r1);
            int r13 = r10;
        L31:
            if (r13 >= r27) goto L38;
            byte r14 = r25.get(r13).getByte(r11);
            if (r13 != r10) goto L35;
        L36:
            r23.writeInt(r14 & 255);
        L37:
            r13 = r13 + 1;
            goto L31
        L35:
            if (r14 == r25.get(r13 - 1).getByte(r11)) goto L37;
        L38:
            Buffer r15 = new Buffer();
        L39:
            if (r10 >= r27) goto L53;
            byte r17 = r25.get(r10).getByte(r11);
            int r18 = r10 + 1;
            int r19 = r18;
        L41:
            if (r19 >= r27) goto L46;
            if (r17 != r25.get(r19).getByte(r11)) goto L44;
            r19 = r19 + 1;
            goto L41
        L44:
            int r20 = r19;
        L47:
            if (r18 == r20) goto L49;
        L51:
            r23.writeInt(((int) (r16 + getIntCount(r15))) * (-1));
            buildTrieRecursive(r16, r15, r11 + 1, r25, r10, r20, r28);
        L52:
            r10 = r20;
            r15 = r15;
            goto L39
        L49:
            if ((r11 + 1) != r25.get(r10).size()) goto L51;
            r23.writeInt(r28.get(r10).intValue());
            goto L52
        L46:
            r20 = r27;
            goto L47
        L53:
            r23.writeAll(r15);
            return;
        L54:
            int r22 = Math.min(r6.size(), r7.size());
            int r29 = r11;
            int r30 = 0;
        L55:
            if (r29 >= r22) goto L59;
            if (r6.getByte(r29) != r7.getByte(r29)) goto L59;
            r30 = r30 + 1;
            r29 = r29 + 1;
        L59:
            long r31 = (((r21 + getIntCount(r23)) + ((long) 2)) + ((long) r30)) + 1;
            r23.writeInt(-r30);
            r23.writeInt(r1);
            int r32 = r11 + r30;
        L60:
            if (r11 >= r32) goto L63;
            r23.writeInt(r6.getByte(r11) & 255);
            r11 = r11 + 1;
            goto L60
        L63:
            if ((r10 + 1) == r27) goto L65;
            Buffer r110 = new Buffer();
            r23.writeInt(((int) (getIntCount(r110) + r31)) * (-1));
            buildTrieRecursive(r31, r110, r32, r25, r10, r27, r28);
            r23.writeAll(r110);
            return;
        L65:
            if (r32 != r25.get(r10).size()) goto L67;
            boolean r33 = true;
        L68:
            if (r33 == false) goto L71;
            r23.writeInt(r28.get(r10).intValue());
            return;
        L71:
            throw new IllegalStateException("Check failed.".toString());
        L67:
            r33 = false;
            goto L68
        L21:
            r10 = r26;
            r1 = -1;
            goto L23
        L75:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r3 = false;
            goto L7
        }

        private final long getIntCount(Buffer r3) {
            return r3.size() / ((long) 4);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ Options(ByteString[] r1, int[] r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @JvmStatic
    public static final Options of(ByteString... r1) {
        return Companion.of(r1);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object r2) {
        if ((r2 instanceof ByteString) == true) goto L7;
        return false;
    L7:
        return contains((ByteString) r2);
    }

    public /* bridge */ boolean contains(ByteString r1) {
        return super.contains(r1);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return get(r1);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r2) {
        if ((r2 instanceof ByteString) == true) goto L7;
        return -1;
    L7:
        return indexOf((ByteString) r2);
    }

    public /* bridge */ int indexOf(ByteString r1) {
        return super.indexOf(r1);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r2) {
        if ((r2 instanceof ByteString) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((ByteString) r2);
    }

    public /* bridge */ int lastIndexOf(ByteString r1) {
        return super.lastIndexOf(r1);
    }

    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    public final int[] getTrie$okio() {
        return this.trie;
    }

    private Options(ByteString[] r1, int[] r2) {
        this.byteStrings = r1;
        this.trie = r2;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.byteStrings.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ByteString get(int r1) {
        return this.byteStrings[r1];
    }
}
