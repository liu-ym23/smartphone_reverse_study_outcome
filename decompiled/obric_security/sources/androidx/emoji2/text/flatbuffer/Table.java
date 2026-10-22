package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Table {
    protected ByteBuffer bb;
    protected int bb_pos;
    Utf8 utf8;
    private int vtable_size;
    private int vtable_start;

    protected int keysCompare(Integer r1, Integer r2, ByteBuffer r3) {
        return 0;
    }

    public Table() {
        this.utf8 = Utf8.getDefault();
    }

    public ByteBuffer getByteBuffer() {
        return this.bb;
    }

    protected int __offset(int r2) {
        if (r2 < this.vtable_size) goto L7;
        return 0;
    L7:
        return this.bb.getShort(this.vtable_start + r2);
    }

    protected static int __offset(int r1, int r2, ByteBuffer r3) {
        int r0 = r3.capacity() - r2;
        return r3.getShort((r1 + r0) - r3.getInt(r0)) + r0;
    }

    protected int __indirect(int r1) {
        return r1 + this.bb.getInt(r1);
    }

    protected static int __indirect(int r0, ByteBuffer r1) {
        return r0 + r1.getInt(r0);
    }

    protected String __string(int r2) {
        return __string(r2, this.bb, this.utf8);
    }

    protected static String __string(int r1, ByteBuffer r2, Utf8 r3) {
        int r4 = r1 + r2.getInt(r1);
        int r0 = r2.getInt(r4);
        return r3.decodeUtf8(r2, r4 + 4, r0);
    }

    protected int __vector_len(int r2) {
        int r3 = r2 + this.bb_pos;
        int r4 = r3 + this.bb.getInt(r3);
        return this.bb.getInt(r4);
    }

    protected int __vector(int r2) {
        int r3 = r2 + this.bb_pos;
        return (r3 + this.bb.getInt(r3)) + 4;
    }

    protected ByteBuffer __vector_as_bytebuffer(int r3, int r4) {
        int r5 = __offset(r3);
        if (r5 != 0) goto L6;
        return null;
    L6:
        ByteBuffer r0 = this.bb.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int r1 = __vector(r5);
        r0.position(r1);
        r0.limit(r1 + (__vector_len(r5) * r4));
        return r0;
    }

    protected ByteBuffer __vector_in_bytebuffer(ByteBuffer r2, int r3, int r4) {
        int r5 = __offset(r3);
        if (r5 != 0) goto L6;
        return null;
    L6:
        int r0 = __vector(r5);
        r2.rewind();
        r2.limit((__vector_len(r5) * r4) + r0);
        r2.position(r0);
        return r2;
    }

    protected Table __union(Table r1, int r2) {
        return __union(r1, r2, this.bb);
    }

    protected static Table __union(Table r0, int r1, ByteBuffer r2) {
        r0.__reset(__indirect(r1, r2), r2);
        return r0;
    }

    protected static boolean __has_identifier(ByteBuffer r5, String r6) {
        if (r6.length() != 4) goto L13;
        int r2 = 0;
    L5:
        if (r2 >= 4) goto L10;
        if (r6.charAt(r2) != ((char) r5.get((r5.position() + 4) + r2))) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        return false;
    L10:
        return true;
    L13:
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    protected void sortTables(int[] r5, final ByteBuffer r6) {
        Integer[] r0 = new Integer[r5.length];
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r5.length) goto L6;
        r0[r2] = Integer.valueOf(r5[r2]);
        r2 = r2 + 1;
        goto L4
    L6:
        Arrays.sort(r0, new AnonymousClass1(this, r6));
    L8:
        if (r1 >= r5.length) goto L10;
        r5[r1] = r0[r1].intValue();
        r1 = r1 + 1;
        goto L8
    }

    protected static int compareStrings(int r8, int r9, ByteBuffer r10) {
        int r11 = r8 + r10.getInt(r8);
        int r12 = r9 + r10.getInt(r9);
        int r0 = r10.getInt(r11);
        int r1 = r10.getInt(r12);
        int r13 = r11 + 4;
        int r14 = r12 + 4;
        int r2 = Math.min(r0, r1);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L10;
        int r4 = r3 + r13;
        int r6 = r3 + r14;
        if (r10.get(r4) != r10.get(r6)) goto L7;
        r3 = r3 + 1;
        goto L3
    L7:
        return r10.get(r4) - r10.get(r6);
    L10:
        return r0 - r1;
    }

    protected static int compareStrings(int r7, byte[] r8, ByteBuffer r9) {
        int r10 = r7 + r9.getInt(r7);
        int r0 = r9.getInt(r10);
        int r1 = r8.length;
        int r11 = r10 + 4;
        int r2 = Math.min(r0, r1);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L10;
        int r4 = r3 + r11;
        if (r9.get(r4) != r8[r3]) goto L7;
        r3 = r3 + 1;
        goto L3
    L7:
        return r9.get(r4) - r8[r3];
    L10:
        return r0 - r1;
    }

    protected void __reset(int r1, ByteBuffer r2) {
        this.bb = r2;
        if (r2 == null) goto L5;
        this.bb_pos = r1;
        int r3 = r1 - r2.getInt(r1);
        this.vtable_start = r3;
        this.vtable_size = this.bb.getShort(r3);
        return;
    L5:
        this.bb_pos = 0;
        this.vtable_start = 0;
        this.vtable_size = 0;
    }

    public void __reset() {
        __reset(0, null);
    }
}
