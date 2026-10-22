package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
final class SegmentedByteString extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    SegmentedByteString(Buffer r8, int r9) {
        super(null);
        Util.checkOffsetAndCount(r8.size, 0, r9);
        Segment r0 = r8.head;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r9) goto L9;
        if (r0.limit == r0.pos) goto L8;
        r2 = r2 + (r0.limit - r0.pos);
        r3 = r3 + 1;
        r0 = r0.next;
        goto L3
    L8:
        throw new AssertionError("s.limit == s.pos");
    L9:
        this.segments = new byte[r3][];
        this.directory = new int[r3 * 2];
        Segment r10 = r8.head;
        int r4 = 0;
    L10:
        if (r1 >= r9) goto L15;
        this.segments[r4] = r10.data;
        r1 = r1 + (r10.limit - r10.pos);
        if (r1 <= r9) goto L14;
        r1 = r9;
    L14:
        int[] r5 = this.directory;
        r5[r4] = r1;
        r5[this.segments.length + r4] = r10.pos;
        r10.shared = true;
        r4 = r4 + 1;
        r10 = r10.next;
        goto L10
    }

    @Override // okio.ByteString
    public String utf8() {
        return toByteString().utf8();
    }

    @Override // okio.ByteString
    public String string(Charset r1) {
        return toByteString().string(r1);
    }

    @Override // okio.ByteString
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public ByteString md5() {
        return toByteString().md5();
    }

    @Override // okio.ByteString
    public ByteString sha1() {
        return toByteString().sha1();
    }

    @Override // okio.ByteString
    public ByteString sha256() {
        return toByteString().sha256();
    }

    @Override // okio.ByteString
    public ByteString hmacSha1(ByteString r1) {
        return toByteString().hmacSha1(r1);
    }

    @Override // okio.ByteString
    public ByteString hmacSha256(ByteString r1) {
        return toByteString().hmacSha256(r1);
    }

    @Override // okio.ByteString
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    public ByteString substring(int r1) {
        return toByteString().substring(r1);
    }

    @Override // okio.ByteString
    public ByteString substring(int r1, int r2) {
        return toByteString().substring(r1, r2);
    }

    @Override // okio.ByteString
    public byte getByte(int r8) {
        Util.checkOffsetAndCount(this.directory[this.segments.length - 1], r8, 1);
        int r0 = segment(r8);
        if (r0 != 0) goto L5;
        int r1 = 0;
    L6:
        int[] r2 = this.directory;
        byte[][] r7 = this.segments;
        return r7[r0][(r8 - r1) + r2[r7.length + r0]];
    L5:
        r1 = this.directory[r0 - 1];
        goto L6
    }

    private int segment(int r3) {
        int r2 = Arrays.binarySearch(this.directory, 0, this.segments.length, r3 + 1);
        if (r2 < 0) goto L6;
        return r2;
    L6:
        return ~r2;
    }

    @Override // okio.ByteString
    public int size() {
        return this.directory[this.segments.length - 1];
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        int[] r0 = this.directory;
        byte[][] r1 = this.segments;
        byte[] r2 = new byte[r0[r1.length - 1]];
        int r3 = r1.length;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r3) goto L5;
        int[] r6 = this.directory;
        int r7 = r6[r3 + r4];
        int r8 = r6[r4];
        System.arraycopy(this.segments[r4], r7, r2, r5, r8 - r5);
        r4 = r4 + 1;
        r5 = r8;
        goto L3
    L5:
        return r2;
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // okio.ByteString
    public void write(OutputStream r7) throws IOException {
        if (r7 == null) goto L8;
        int r0 = this.segments.length;
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r0) goto L6;
        int[] r3 = this.directory;
        int r4 = r3[r0 + r1];
        int r5 = r3[r1];
        r7.write(this.segments[r1], r4, r5 - r2);
        r1 = r1 + 1;
        r2 = r5;
        goto L4
    L6:
        return;
    L8:
        throw new IllegalArgumentException("out == null");
    }

    @Override // okio.ByteString
    void write(Buffer r12) {
        int r0 = this.segments.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L9;
        int[] r3 = this.directory;
        int r7 = r3[r0 + r1];
        int r4 = r3[r1];
        Segment r5 = new Segment(this.segments[r1], r7, (r7 + r4) - r2, true, false);
        if (r12.head != null) goto L7;
        r5.prev = r5;
        r5.next = r5;
        r12.head = r5;
    L8:
        r1 = r1 + 1;
        r2 = r4;
        goto L3
    L7:
        r12.head.prev.push(r5);
        goto L8
    L9:
        r12.size += (long) r2;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int r8, ByteString r9, int r10, int r11) {
        if (r8 >= 0) goto L5;
    L18:
        return false;
    L5:
        if (r8 > (size() - r11)) goto L18;
        int r1 = segment(r8);
    L8:
        if (r11 <= 0) goto L16;
        if (r1 != 0) goto L11;
        int r2 = 0;
    L12:
        int r3 = Math.min(r11, ((this.directory[r1] - r2) + r2) - r8);
        int[] r4 = this.directory;
        byte[][] r5 = this.segments;
        if (r9.rangeEquals(r10, r5[r1], (r8 - r2) + r4[r5.length + r1], r3) == false) goto L14;
        r8 = r8 + r3;
        r10 = r10 + r3;
        r11 = r11 - r3;
        r1 = r1 + 1;
        goto L8
    L14:
        return false;
    L11:
        r2 = this.directory[r1 - 1];
        goto L12
    L16:
        return true;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int r8, byte[] r9, int r10, int r11) {
        if (r8 >= 0) goto L5;
    L21:
        return false;
    L5:
        if (r8 > (size() - r11)) goto L21;
        if (r10 < 0) goto L21;
        if (r10 > (r9.length - r11)) goto L21;
        int r1 = segment(r8);
    L11:
        if (r11 <= 0) goto L19;
        if (r1 != 0) goto L14;
        int r2 = 0;
    L15:
        int r3 = Math.min(r11, ((this.directory[r1] - r2) + r2) - r8);
        int[] r4 = this.directory;
        byte[][] r5 = this.segments;
        if (Util.arrayRangeEquals(r5[r1], (r8 - r2) + r4[r5.length + r1], r9, r10, r3) == false) goto L17;
        r8 = r8 + r3;
        r10 = r10 + r3;
        r11 = r11 - r3;
        r1 = r1 + 1;
        goto L11
    L17:
        return false;
    L14:
        r2 = this.directory[r1 - 1];
        goto L15
    L19:
        return true;
    }

    @Override // okio.ByteString
    public int indexOf(byte[] r1, int r2) {
        return toByteString().indexOf(r1, r2);
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] r1, int r2) {
        return toByteString().lastIndexOf(r1, r2);
    }

    private ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    byte[] internalArray() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ByteString) == false) goto L13;
        ByteString r6 = (ByteString) r5;
        if (r6.size() != size()) goto L13;
        if (rangeEquals(0, r6, 0, size()) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // okio.ByteString
    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = this.segments.length;
        int r2 = 0;
        int r3 = 1;
        int r4 = 0;
    L6:
        if (r2 >= r1) goto L11;
        byte[] r5 = this.segments[r2];
        int[] r6 = this.directory;
        int r7 = r6[r1 + r2];
        int r8 = r6[r2];
        int r9 = (r8 - r4) + r7;
    L8:
        if (r7 >= r9) goto L10;
        r3 = (r3 * 31) + r5[r7];
        r7 = r7 + 1;
        goto L8
    L10:
        r2 = r2 + 1;
        r4 = r8;
        goto L6
    L11:
        this.hashCode = r3;
        return r3;
    }

    @Override // okio.ByteString
    public String toString() {
        return toByteString().toString();
    }

    private Object writeReplace() {
        return toByteString();
    }
}
