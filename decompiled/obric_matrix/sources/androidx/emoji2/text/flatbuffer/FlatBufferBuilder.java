package androidx.emoji2.text.flatbuffer;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class FlatBufferBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    ByteBuffer bb;
    ByteBufferFactory bb_factory;
    boolean finished;
    boolean force_defaults;
    int minalign;
    boolean nested;
    int num_vtables;
    int object_start;
    int space;
    final Utf8 utf8;
    int vector_num_elems;
    int[] vtable;
    int vtable_in_use;
    int[] vtables;

    static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer r1) {
            this.buf = r1;
        }

        @Override // java.io.InputStream
        public int read() {
            return this.buf.get() & 255;
        L5:
            return -1;
        }
    }

    public static abstract class ByteBufferFactory {
        public ByteBufferFactory() {
        }

        public abstract ByteBuffer newByteBuffer(int r1);

        public void releaseByteBuffer(ByteBuffer r1) {
        }
    }

    public static final class HeapByteBufferFactory extends ByteBufferFactory {
        public static final HeapByteBufferFactory INSTANCE = null;

        static {
            INSTANCE = new HeapByteBufferFactory();
        }

        public HeapByteBufferFactory() {
        }

        @Override // androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory
        public ByteBuffer newByteBuffer(int r1) {
            return ByteBuffer.allocate(r1).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    static {
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    public FlatBufferBuilder(int r4) {
        this(r4, HeapByteBufferFactory.INSTANCE, null, Utf8.getDefault());
    }

    public FlatBufferBuilder(int r3, ByteBufferFactory r4) {
        this(r3, r4, null, Utf8.getDefault());
    }

    public FlatBufferBuilder(int r4, ByteBufferFactory r5, ByteBuffer r6, Utf8 r7) {
        this.minalign = 1;
        this.vtable = null;
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.vtables = new int[16];
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        this.force_defaults = false;
        if (r4 > 0) goto L5;
        r4 = 1;
    L5:
        this.bb_factory = r5;
        if (r6 == null) goto L8;
        this.bb = r6;
        r6.clear();
        this.bb.order(ByteOrder.LITTLE_ENDIAN);
    L9:
        this.utf8 = r7;
        this.space = this.bb.capacity();
        return;
    L8:
        this.bb = r5.newByteBuffer(r4);
        goto L9
    }

    public FlatBufferBuilder(ByteBuffer r2) {
        this(r2, new HeapByteBufferFactory());
    }

    public FlatBufferBuilder(ByteBuffer r3, ByteBufferFactory r4) {
        this(r3.capacity(), r4, r3, Utf8.getDefault());
    }

    @Deprecated
    private int dataStart() {
        finished();
        return this.space;
    }

    static ByteBuffer growByteBuffer(ByteBuffer r3, ByteBufferFactory r4) {
        int r0 = r3.capacity();
        if (((-1073741824) & r0) != 0) goto L10;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        r3.position(0);
        ByteBuffer r5 = r4.newByteBuffer(r1);
        r5.position(r5.clear().capacity() - r0);
        r5.put(r3);
        return r5;
    L6:
        r1 = r0 << 1;
        goto L7
    L10:
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    public static boolean isFieldPresent(Table r0, int r1) {
        if (r0.__offset(r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void Nested(int r1) {
        if (r1 != offset()) goto L6;
        return;
    L6:
        throw new AssertionError("FlatBuffers: struct must be serialized inline.");
    }

    public void addBoolean(int r2, boolean r3, boolean r4) {
        if (this.force_defaults == true) goto L5;
        if (r3 != r4) goto L5;
        return;
    L5:
        addBoolean(r3);
        slot(r2);
    }

    public void addBoolean(boolean r3) {
        prep(1, 0);
        putBoolean(r3);
    }

    public void addByte(byte r3) {
        prep(1, 0);
        putByte(r3);
    }

    public void addByte(int r2, byte r3, int r4) {
        if (this.force_defaults == true) goto L5;
        if (r3 != r4) goto L5;
        return;
    L5:
        addByte(r3);
        slot(r2);
    }

    public void addDouble(double r3) {
        prep(8, 0);
        putDouble(r3);
    }

    public void addDouble(int r2, double r3, double r5) {
        if (this.force_defaults == false) goto L5;
    L6:
        addDouble(r3);
        slot(r2);
        return;
    L5:
        if (r3 != r5) goto L6;
    }

    public void addFloat(float r3) {
        prep(4, 0);
        putFloat(r3);
    }

    public void addFloat(int r3, float r4, double r5) {
        if (this.force_defaults == false) goto L5;
    L6:
        addFloat(r4);
        slot(r3);
        return;
    L5:
        if (r4 != r5) goto L6;
    }

    public void addInt(int r3) {
        prep(4, 0);
        putInt(r3);
    }

    public void addInt(int r2, int r3, int r4) {
        if (this.force_defaults == true) goto L5;
        if (r3 != r4) goto L5;
        return;
    L5:
        addInt(r3);
        slot(r2);
    }

    public void addLong(int r2, long r3, long r5) {
        if (this.force_defaults == false) goto L5;
    L6:
        addLong(r3);
        slot(r2);
        return;
    L5:
        if (r3 != r5) goto L6;
    }

    public void addLong(long r3) {
        prep(8, 0);
        putLong(r3);
    }

    public void addOffset(int r3) {
        prep(4, 0);
        putInt((offset() - r3) + 4);
    }

    public void addOffset(int r2, int r3, int r4) {
        if (this.force_defaults == true) goto L5;
        if (r3 != r4) goto L5;
        return;
    L5:
        addOffset(r3);
        slot(r2);
    }

    public void addShort(int r2, short r3, int r4) {
        if (this.force_defaults == true) goto L5;
        if (r3 != r4) goto L5;
        return;
    L5:
        addShort(r3);
        slot(r2);
    }

    public void addShort(short r3) {
        prep(2, 0);
        putShort(r3);
    }

    public void addStruct(int r1, int r2, int r3) {
        if (r2 == r3) goto L5;
        Nested(r2);
        slot(r1);
        return;
    }

    public void clear() {
        this.space = this.bb.capacity();
        this.bb.clear();
        this.minalign = 1;
    L3:
        int r0 = this.vtable_in_use;
        if (r0 <= 0) goto L6;
        int[] r2 = this.vtable;
        int r1 = r0 - 1;
        this.vtable_in_use = r1;
        r2[r1] = 0;
        goto L3
    L6:
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
    }

    public int createByteVector(ByteBuffer r4) {
        int r0 = r4.remaining();
        startVector(1, r0, 1);
        ByteBuffer r1 = this.bb;
        int r2 = this.space - r0;
        this.space = r2;
        r1.position(r2);
        this.bb.put(r4);
        return endVector();
    }

    public int createByteVector(byte[] r4) {
        int r0 = r4.length;
        startVector(1, r0, 1);
        ByteBuffer r1 = this.bb;
        int r2 = this.space - r0;
        this.space = r2;
        r1.position(r2);
        this.bb.put(r4);
        return endVector();
    }

    public int createByteVector(byte[] r3, int r4, int r5) {
        startVector(1, r5, 1);
        ByteBuffer r0 = this.bb;
        int r1 = this.space - r5;
        this.space = r1;
        r0.position(r1);
        this.bb.put(r3, r4, r5);
        return endVector();
    }

    public <T extends Table> int createSortedVectorOfTables(T r2, int[] r3) {
        r2.sortTables(r3, this.bb);
        return createVectorOfTables(r3);
    }

    public int createString(CharSequence r4) {
        int r0 = this.utf8.encodedLength(r4);
        addByte((byte) 0);
        startVector(1, r0, 1);
        ByteBuffer r1 = this.bb;
        int r2 = this.space - r0;
        this.space = r2;
        r1.position(r2);
        this.utf8.encodeUtf8(r4, this.bb);
        return endVector();
    }

    public int createString(ByteBuffer r4) {
        int r0 = r4.remaining();
        addByte((byte) 0);
        startVector(1, r0, 1);
        ByteBuffer r1 = this.bb;
        int r2 = this.space - r0;
        this.space = r2;
        r1.position(r2);
        this.bb.put(r4);
        return endVector();
    }

    public ByteBuffer createUnintializedVector(int r2, int r3, int r4) {
        int r0 = r2 * r3;
        startVector(r2, r3, r4);
        ByteBuffer r5 = this.bb;
        int r6 = this.space - r0;
        this.space = r6;
        r5.position(r6);
        ByteBuffer r1 = this.bb.slice().order(ByteOrder.LITTLE_ENDIAN);
        r1.limit(r0);
        return r1;
    }

    public int createVectorOfTables(int[] r3) {
        notNested();
        startVector(4, r3.length, 4);
        int r0 = r3.length - 1;
    L3:
        if (r0 < 0) goto L6;
        addOffset(r3[r0]);
        r0 = r0 - 1;
        goto L3
    L6:
        return endVector();
    }

    public ByteBuffer dataBuffer() {
        finished();
        return this.bb;
    }

    public int endTable() {
        if (this.vtable == null) goto L41;
        if (this.nested == false) goto L41;
        addInt(0);
        int r1 = offset();
        int r2 = this.vtable_in_use - 1;
    L7:
        if (r2 < 0) goto L11;
        if (this.vtable[r2] != 0) goto L11;
        r2 = r2 - 1;
    L11:
        int r3 = r2 + 1;
    L12:
        if (r2 < 0) goto L18;
        int[] r4 = this.vtable;
        if (r4[r2] == 0) goto L16;
        int r5 = r1 - r4[r2];
    L17:
        addShort((short) r5);
        r2 = r2 - 1;
        goto L12
    L16:
        r5 = 0;
        goto L17
    L18:
        addShort((short) (r1 - this.object_start));
        addShort((short) ((r3 + 2) * 2));
        int r6 = 0;
    L20:
        if (r6 >= this.num_vtables) goto L31;
        int r7 = this.bb.capacity() - this.vtables[r6];
        int r8 = this.space;
        short r9 = this.bb.getShort(r7);
        if (r9 != this.bb.getShort(r8)) goto L30;
        int r10 = 2;
    L24:
        if (r10 >= r9) goto L29;
        if (this.bb.getShort(r7 + r10) != this.bb.getShort(r8 + r10)) goto L30;
        r10 = r10 + 2;
        goto L24
    L29:
        int r11 = this.vtables[r6];
    L32:
        if (r11 == 0) goto L34;
        int r12 = this.bb.capacity() - r1;
        this.space = r12;
        this.bb.putInt(r12, r11 - r1);
    L38:
        this.nested = false;
        return r1;
    L34:
        int r13 = this.num_vtables;
        int[] r14 = this.vtables;
        if (r13 != r14.length) goto L37;
        this.vtables = Arrays.copyOf(r14, r13 * 2);
    L37:
        int[] r15 = this.vtables;
        int r16 = this.num_vtables;
        this.num_vtables = r16 + 1;
        r15[r16] = offset();
        ByteBuffer r17 = this.bb;
        r17.putInt(r17.capacity() - r1, offset() - r1);
    L30:
        r6 = r6 + 1;
        goto L20
    L31:
        r11 = 0;
    L41:
        throw new AssertionError("FlatBuffers: endTable called without startTable");
    }

    public int endVector() {
        if (this.nested == false) goto L7;
        this.nested = false;
        putInt(this.vector_num_elems);
        return offset();
    L7:
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public void finish(int r2) {
        finish(r2, false);
    }

    public void finish(int r2, String r3) {
        finish(r2, r3, false);
    }

    protected void finish(int r4, String r5, boolean r6) {
        int r0 = this.minalign;
        if (r6 == false) goto L5;
        int r2 = 4;
    L6:
        prep(r0, r2 + 8);
        if (r5.length() != 4) goto L14;
        int r1 = 3;
    L9:
        if (r1 < 0) goto L11;
        addByte((byte) r5.charAt(r1));
        r1 = r1 - 1;
        goto L9
    L11:
        finish(r4, r6);
        return;
    L14:
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    L5:
        r2 = 0;
        goto L6
    }

    protected void finish(int r4, boolean r5) {
        int r0 = this.minalign;
        if (r5 == false) goto L5;
        int r2 = 4;
    L6:
        prep(r0, r2 + 4);
        addOffset(r4);
        if (r5 == false) goto L9;
        addInt(this.bb.capacity() - this.space);
    L9:
        this.bb.position(this.space);
        this.finished = true;
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public void finishSizePrefixed(int r2) {
        finish(r2, true);
    }

    public void finishSizePrefixed(int r2, String r3) {
        finish(r2, r3, true);
    }

    public void finished() {
        if (this.finished == false) goto L6;
        return;
    L6:
        throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
    }

    public FlatBufferBuilder forceDefaults(boolean r1) {
        this.force_defaults = r1;
        return this;
    }

    public FlatBufferBuilder init(ByteBuffer r1, ByteBufferFactory r2) {
        this.bb_factory = r2;
        this.bb = r1;
        r1.clear();
        this.bb.order(ByteOrder.LITTLE_ENDIAN);
        this.minalign = 1;
        this.space = this.bb.capacity();
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        return this;
    }

    public void notNested() {
        if (this.nested == true) goto L6;
        return;
    L6:
        throw new AssertionError("FlatBuffers: object serialization must not be nested.");
    }

    public int offset() {
        return this.bb.capacity() - this.space;
    }

    public void pad(int r5) {
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        ByteBuffer r2 = this.bb;
        int r3 = this.space - 1;
        this.space = r3;
        r2.put(r3, (byte) 0);
        r1 = r1 + 1;
        goto L3
    }

    public void prep(int r5, int r6) {
        if (r5 <= this.minalign) goto L5;
        this.minalign = r5;
    L5:
        int r0 = ((~((this.bb.capacity() - this.space) + r6)) + 1) & (r5 - 1);
    L7:
        if (this.space >= ((r0 + r5) + r6)) goto L12;
        int r1 = this.bb.capacity();
        ByteBuffer r2 = this.bb;
        ByteBuffer r3 = growByteBuffer(r2, this.bb_factory);
        this.bb = r3;
        if (r2 == r3) goto L11;
        this.bb_factory.releaseByteBuffer(r2);
    L11:
        this.space += this.bb.capacity() - r1;
        goto L7
    L12:
        pad(r0);
    }

    public void putBoolean(boolean r3) {
        ByteBuffer r0 = this.bb;
        int r1 = this.space - 1;
        this.space = r1;
        r0.put(r1, r3 ? 1 : 0);
    }

    public void putByte(byte r3) {
        ByteBuffer r0 = this.bb;
        int r1 = this.space - 1;
        this.space = r1;
        r0.put(r1, r3);
    }

    public void putDouble(double r3) {
        ByteBuffer r0 = this.bb;
        int r1 = this.space - 8;
        this.space = r1;
        r0.putDouble(r1, r3);
    }

    public void putFloat(float r3) {
        ByteBuffer r0 = this.bb;
        int r1 = this.space - 4;
        this.space = r1;
        r0.putFloat(r1, r3);
    }

    public void putInt(int r3) {
        ByteBuffer r0 = this.bb;
        int r1 = this.space - 4;
        this.space = r1;
        r0.putInt(r1, r3);
    }

    public void putLong(long r3) {
        ByteBuffer r0 = this.bb;
        int r1 = this.space - 8;
        this.space = r1;
        r0.putLong(r1, r3);
    }

    public void putShort(short r3) {
        ByteBuffer r0 = this.bb;
        int r1 = this.space - 2;
        this.space = r1;
        r0.putShort(r1, r3);
    }

    public void required(int r2, int r3) {
        int r0 = this.bb.capacity() - r2;
        if (this.bb.getShort((r0 - this.bb.getInt(r0)) + r3) == 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return;
    L9:
        throw new AssertionError("FlatBuffers: field " + r3 + " must be set");
    L5:
        r1 = false;
        goto L6
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.space, this.bb.capacity() - this.space);
    }

    public byte[] sizedByteArray(int r2, int r3) {
        finished();
        byte[] r4 = new byte[r3];
        this.bb.position(r2);
        this.bb.get(r4);
        return r4;
    }

    public InputStream sizedInputStream() {
        finished();
        ByteBuffer r0 = this.bb.duplicate();
        r0.position(this.space);
        r0.limit(this.bb.capacity());
        return new ByteBufferBackedInputStream(r0);
    }

    public void slot(int r2) {
        this.vtable[r2] = offset();
    }

    public void startTable(int r3) {
        notNested();
        int[] r0 = this.vtable;
        if (r0 != null) goto L5;
    L6:
        this.vtable = new int[r3];
    L7:
        this.vtable_in_use = r3;
        Arrays.fill(this.vtable, 0, r3, 0);
        this.nested = true;
        this.object_start = offset();
        return;
    L5:
        if (r0.length >= r3) goto L7;
        goto L6
    }

    public void startVector(int r1, int r2, int r3) {
        notNested();
        this.vector_num_elems = r2;
        int r4 = r1 * r2;
        prep(4, r4);
        prep(r3, r4);
        this.nested = true;
    }
}
