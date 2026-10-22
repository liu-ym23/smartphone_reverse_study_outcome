package okio;

import android.icu.text.PluralRules;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._SegmentedByteStringKt;

/* JADX INFO: compiled from: SegmentedByteString.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\r\u0010 \u001a\u00020\u0015H\u0010¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u001d\u0010$\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0001H\u0010¢\u0006\u0002\b&J\u0018\u0010'\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J\r\u0010)\u001a\u00020\u0004H\u0010¢\u0006\u0002\b*J\u0015\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0015H\u0010¢\u0006\u0002\b.J\u0018\u0010/\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0015H\u0016J\b\u00108\u001a\u00020\u0001H\u0016J\b\u00109\u001a\u00020\u0001H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016J\b\u0010;\u001a\u00020\u0001H\u0002J\b\u0010<\u001a\u00020\u0010H\u0016J\u0010\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020?H\u0016J%\u0010=\u001a\u00020\u00132\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0010¢\u0006\u0002\bBJ\b\u0010C\u001a\u00020DH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006E"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "segments", "", "", "directory", "", "([[B[I)V", "getDirectory$okio", "()[I", "getSegments$okio", "()[[B", "[[B", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "", "base64Url", "copyInto", "", "offset", "", "target", "targetOffset", "byteCount", "digest", "algorithm", "digest$okio", "equals", "", PluralRules.KEYWORD_OTHER, "", "getSize", "getSize$okio", "hashCode", "hex", "hmac", "key", "hmac$okio", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "", "pos", "internalGet$okio", "lastIndexOf", "rangeEquals", "otherOffset", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toByteString", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeReplace", "Ljava/lang/Object;", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SegmentedByteString extends ByteString {
    private final transient int[] directory;
    private final transient byte[][] segments;

    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    public final int[] getDirectory$okio() {
        return this.directory;
    }

    public SegmentedByteString(byte[][] r2, int[] r3) {
        Intrinsics.checkNotNullParameter(r2, "segments");
        Intrinsics.checkNotNullParameter(r3, "directory");
        super(ByteString.EMPTY.getData$okio());
        this.segments = r2;
        this.directory = r3;
    }

    @Override // okio.ByteString
    public String string(Charset r2) {
        Intrinsics.checkNotNullParameter(r2, "charset");
        return toByteString().string(r2);
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
    public ByteString digest$okio(String r7) {
        Intrinsics.checkNotNullParameter(r7, "algorithm");
        MessageDigest r8 = MessageDigest.getInstance(r7);
        int r0 = getSegments$okio().length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r3 = getDirectory$okio()[r0 + r1];
        int r4 = getDirectory$okio()[r1];
        r8.update(getSegments$okio()[r1], r3, r4 - r2);
        r1 = r1 + 1;
        r2 = r4;
        goto L3
    L5:
        byte[] r6 = r8.digest();
        Intrinsics.checkNotNullExpressionValue(r6, "digestBytes");
        return new ByteString(r6);
    }

    @Override // okio.ByteString
    public ByteString hmac$okio(String r6, ByteString r7) {
        Intrinsics.checkNotNullParameter(r6, "algorithm");
        Intrinsics.checkNotNullParameter(r7, "key");
        Mac r0 = Mac.getInstance(r6);     // Catch: InvalidKeyException -> L8
        r0.init(new SecretKeySpec(r7.toByteArray(), r6));     // Catch: InvalidKeyException -> L8
        int r8 = getSegments$okio().length;     // Catch: InvalidKeyException -> L8
        int r9 = 0;
        int r1 = 0;
    L4:
        if (r9 >= r8) goto L6;
        int r2 = getDirectory$okio()[r8 + r9];     // Catch: InvalidKeyException -> L8
        int r3 = getDirectory$okio()[r9];     // Catch: InvalidKeyException -> L8
        r0.update(getSegments$okio()[r9], r2, r3 - r1);     // Catch: InvalidKeyException -> L8
        r9 = r9 + 1;     // Catch: InvalidKeyException -> L8
        r1 = r3;
        goto L4
    L6:
        byte[] r10 = r0.doFinal();     // Catch: InvalidKeyException -> L8
        Intrinsics.checkNotNullExpressionValue(r10, "mac.doFinal()");     // Catch: InvalidKeyException -> L8
        return new ByteString(r10);
    L8:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // okio.ByteString
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        ByteBuffer r1 = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(r1, "wrap(toByteArray()).asReadOnlyBuffer()");
        return r1;
    }

    @Override // okio.ByteString
    public int indexOf(byte[] r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, PluralRules.KEYWORD_OTHER);
        return toByteString().indexOf(r2, r3);
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, PluralRules.KEYWORD_OTHER);
        return toByteString().lastIndexOf(r2, r3);
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public String toString() {
        return toByteString().toString();
    }

    private final Object writeReplace() {
        ByteString r1 = toByteString();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type java.lang.Object");
        return r1;
    }

    @Override // okio.ByteString
    public ByteString substring(int r13, int r14) {
        SegmentedByteString r0 = this;
        int r15 = _UtilKt.resolveDefaultParameter(r0, r14);
        int r1 = 0;
        if (r13 < 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L40;
        if (r15 > size()) goto L10;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L38;
        int r5 = r15 - r13;
        if (r5 < 0) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L36;
        if (r13 == 0) goto L20;
    L22:
        if (r13 == r15) goto L42;
        int r2 = _SegmentedByteStringKt.segment(this, r13);
        int r16 = _SegmentedByteStringKt.segment(this, r15 - 1);
        byte[][] r7 = (byte[][]) ArraysKt.copyOfRange(getSegments$okio(), r2, r16 + 1);
        byte[][] r8 = r7;
        int[] r9 = new int[r8.length * 2];
        if (r2 > r16) goto L30;
        int r10 = r2;
        int r11 = 0;
    L27:
        r9[r11] = Math.min(getDirectory$okio()[r10] - r13, r5);
        int r12 = r11 + 1;
        r9[r11 + r8.length] = getDirectory$okio()[getSegments$okio().length + r10];
        if (r10 == r16) goto L30;
        r10 = r10 + 1;
        r11 = r12;
    L30:
        if (r2 == 0) goto L33;
        r1 = getDirectory$okio()[r2 - 1];
    L33:
        int r17 = r8.length;
        r9[r17] = r9[r17] + (r13 - r1);
        return new SegmentedByteString(r7, r9);
    L42:
        return ByteString.EMPTY;
    L20:
        if (r15 != size()) goto L22;
        return r0;
    L36:
        throw new IllegalArgumentException(("endIndex=" + r15 + " < beginIndex=" + r13).toString());
    L16:
        r6 = false;
        goto L17
    L38:
        throw new IllegalArgumentException(("endIndex=" + r15 + " > length(" + size() + ')').toString());
    L10:
        r4 = false;
        goto L12
    L40:
        throw new IllegalArgumentException(("beginIndex=" + r13 + " < 0").toString());
    L5:
        r3 = false;
        goto L6
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int r8) {
        _UtilKt.checkOffsetAndCount(getDirectory$okio()[getSegments$okio().length - 1], r8, 1);
        int r0 = _SegmentedByteStringKt.segment(this, r8);
        if (r0 != 0) goto L5;
        int r1 = 0;
    L7:
        return getSegments$okio()[r0][(r8 - r1) + getDirectory$okio()[getSegments$okio().length + r0]];
    L5:
        r1 = getDirectory$okio()[r0 - 1];
        goto L7
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        byte[] r0 = new byte[size()];
        int r1 = getSegments$okio().length;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int r5 = getDirectory$okio()[r1 + r2];
        int r6 = getDirectory$okio()[r2];
        int r7 = r6 - r3;
        ArraysKt.copyInto(getSegments$okio()[r2], r0, r4, r5, r5 + r7);
        r4 = r4 + r7;
        r2 = r2 + 1;
        r3 = r6;
        goto L3
    L5:
        return r0;
    }

    @Override // okio.ByteString
    public void write(OutputStream r7) throws IOException {
        Intrinsics.checkNotNullParameter(r7, "out");
        int r0 = getSegments$okio().length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r3 = getDirectory$okio()[r0 + r1];
        int r4 = getDirectory$okio()[r1];
        r7.write(getSegments$okio()[r1], r3, r4 - r2);
        r1 = r1 + 1;
        r2 = r4;
        goto L3
    }

    @Override // okio.ByteString
    public void write$okio(Buffer r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "buffer");
        int r0 = r13 + r14;
        int r1 = _SegmentedByteStringKt.segment(this, r13);
    L3:
        if (r13 >= r0) goto L12;
        if (r1 != 0) goto L6;
        int r2 = 0;
    L7:
        int r3 = getDirectory$okio()[r1] - r2;
        int r4 = getDirectory$okio()[getSegments$okio().length + r1];
        int r5 = Math.min(r0, r3 + r2) - r13;
        int r7 = r4 + (r13 - r2);
        Segment r6 = new Segment(getSegments$okio()[r1], r7, r7 + r5, true, false);
        if (r12.head != null) goto L10;
        r6.prev = r6;
        r6.next = r6.prev;
        r12.head = r6.next;
    L11:
        r13 = r13 + r5;
        r1 = r1 + 1;
        goto L3
    L10:
        Segment r8 = r12.head;
        Intrinsics.checkNotNull(r8);
        Segment r9 = r8.prev;
        Intrinsics.checkNotNull(r9);
        r9.push(r6);
        goto L11
    L6:
        r2 = getDirectory$okio()[r1 - 1];
        goto L7
    L12:
        r12.setSize$okio(r12.size() + ((long) r14));
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int r7, ByteString r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, PluralRules.KEYWORD_OTHER);
        if (r7 >= 0) goto L5;
        return false;
    L5:
        if (r7 > (size() - r10)) goto L21;
        int r11 = r10 + r7;
        int r1 = _SegmentedByteStringKt.segment(this, r7);
    L8:
        if (r7 >= r11) goto L16;
        if (r1 != 0) goto L11;
        int r2 = 0;
    L12:
        int r3 = getDirectory$okio()[r1] - r2;
        int r4 = getDirectory$okio()[getSegments$okio().length + r1];
        int r5 = Math.min(r11, r3 + r2) - r7;
        if (r8.rangeEquals(r9, getSegments$okio()[r1], r4 + (r7 - r2), r5) == false) goto L22;
        r9 = r9 + r5;
        r7 = r7 + r5;
        r1 = r1 + 1;
        goto L8
    L22:
        return false;
    L11:
        r2 = getDirectory$okio()[r1 - 1];
        goto L12
    L16:
        return true;
    L21:
        return false;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int r7, byte[] r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, PluralRules.KEYWORD_OTHER);
        if (r7 >= 0) goto L5;
        return false;
    L5:
        if (r7 > (size() - r10)) goto L24;
        if (r9 >= 0) goto L8;
        return false;
    L8:
        if (r9 > (r8.length - r10)) goto L26;
        int r11 = r10 + r7;
        int r1 = _SegmentedByteStringKt.segment(this, r7);
    L11:
        if (r7 >= r11) goto L19;
        if (r1 != 0) goto L14;
        int r2 = 0;
    L15:
        int r3 = getDirectory$okio()[r1] - r2;
        int r4 = getDirectory$okio()[getSegments$okio().length + r1];
        int r5 = Math.min(r11, r3 + r2) - r7;
        if (_UtilKt.arrayRangeEquals(getSegments$okio()[r1], r4 + (r7 - r2), r8, r9, r5) == false) goto L27;
        r9 = r9 + r5;
        r7 = r7 + r5;
        r1 = r1 + 1;
        goto L11
    L27:
        return false;
    L14:
        r2 = getDirectory$okio()[r1 - 1];
        goto L15
    L19:
        return true;
    L26:
        return false;
    L24:
        return false;
    }

    @Override // okio.ByteString
    public void copyInto(int r12, byte[] r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "target");
        long r9 = r15;
        _UtilKt.checkOffsetAndCount(size(), r12, r9);
        _UtilKt.checkOffsetAndCount(r13.length, r14, r9);
        int r16 = r15 + r12;
        int r0 = _SegmentedByteStringKt.segment(this, r12);
    L3:
        if (r12 >= r16) goto L8;
        if (r0 != 0) goto L6;
        int r1 = 0;
    L7:
        int r2 = getDirectory$okio()[r0] - r1;
        int r3 = getDirectory$okio()[getSegments$okio().length + r0];
        int r4 = Math.min(r16, r2 + r1) - r12;
        int r5 = r3 + (r12 - r1);
        ArraysKt.copyInto(getSegments$okio()[r0], r13, r14, r5, r5 + r4);
        r14 = r14 + r4;
        r12 = r12 + r4;
        r0 = r0 + 1;
        goto L3
    L6:
        r1 = getDirectory$okio()[r0 - 1];
        goto L7
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
        int r0 = getHashCode$okio();
        if (r0 != 0) goto L15;
        int r1 = getSegments$okio().length;
        int r2 = 0;
        int r3 = 1;
        int r4 = 0;
    L6:
        if (r2 >= r1) goto L11;
        int r5 = getDirectory$okio()[r1 + r2];
        int r6 = getDirectory$okio()[r2];
        byte[] r7 = getSegments$okio()[r2];
        int r8 = (r6 - r4) + r5;
    L8:
        if (r5 >= r8) goto L10;
        r3 = (r3 * 31) + r7[r5];
        r5 = r5 + 1;
        goto L8
    L10:
        r2 = r2 + 1;
        r4 = r6;
        goto L6
    L11:
        setHashCode$okio(r3);
        return r3;
    L15:
        return r0;
    }
}
