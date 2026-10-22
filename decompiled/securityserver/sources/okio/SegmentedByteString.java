package okio;

import a.a;
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
import okio.internal.SegmentedByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SegmentedByteString extends ByteString {

    @NotNull
    private final transient int[] directory;

    @NotNull
    private final transient byte[][] segments;

    public SegmentedByteString(@NotNull byte[][] r2, @NotNull int[] r3) {
        Intrinsics.f(r2, "segments");
        Intrinsics.f(r3, "directory");
        super(ByteString.EMPTY.getData$okio());
        this.segments = r2;
        this.directory = r3;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString r1 = toByteString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
    }

    @Override // okio.ByteString
    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer r1 = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        Intrinsics.e(r1, "ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer()");
        return r1;
    }

    @Override // okio.ByteString
    @NotNull
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    @NotNull
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString digest$okio(@NotNull String r7) {
        Intrinsics.f(r7, "algorithm");
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
        byte[] r9 = r8.digest();
        Intrinsics.e(r9, "digest.digest()");
        return new ByteString(r9);
    }

    @Override // okio.ByteString
    public boolean equals(@Nullable Object r5) {
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

    @NotNull
    public final int[] getDirectory$okio() {
        return this.directory;
    }

    @NotNull
    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
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

    @Override // okio.ByteString
    @NotNull
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString hmac$okio(@NotNull String r6, @NotNull ByteString r7) {
        Intrinsics.f(r6, "algorithm");
        Intrinsics.f(r7, "key");
        Mac r0 = Mac.getInstance(r6);     // Catch: InvalidKeyException -> L6
        r0.init(new SecretKeySpec(r7.toByteArray(), r6));     // Catch: InvalidKeyException -> L6
        int r8 = getSegments$okio().length;     // Catch: InvalidKeyException -> L6
        int r9 = 0;
        int r1 = 0;
    L4:
        if (r9 >= r8) goto L8;
        int r2 = getDirectory$okio()[r8 + r9];     // Catch: InvalidKeyException -> L6
        int r3 = getDirectory$okio()[r9];     // Catch: InvalidKeyException -> L6
        r0.update(getSegments$okio()[r9], r2, r3 - r1);     // Catch: InvalidKeyException -> L6
        r9 = r9 + 1;     // Catch: InvalidKeyException -> L6
        r1 = r3;
        goto L4
    L8:
        byte[] r10 = r0.doFinal();     // Catch: InvalidKeyException -> L6
        Intrinsics.e(r10, "mac.doFinal()");     // Catch: InvalidKeyException -> L6
        return new ByteString(r10);
    L6:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // okio.ByteString
    public int indexOf(@NotNull byte[] r2, int r3) {
        Intrinsics.f(r2, "other");
        return toByteString().indexOf(r2, r3);
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int r8) {
        Util.checkOffsetAndCount(getDirectory$okio()[getSegments$okio().length - 1], r8, 1);
        int r0 = SegmentedByteStringKt.segment(this, r8);
        if (r0 != 0) goto L5;
        int r1 = 0;
    L7:
        return getSegments$okio()[r0][(r8 - r1) + getDirectory$okio()[getSegments$okio().length + r0]];
    L5:
        r1 = getDirectory$okio()[r0 - 1];
        goto L7
    }

    @Override // okio.ByteString
    public int lastIndexOf(@NotNull byte[] r2, int r3) {
        Intrinsics.f(r2, "other");
        return toByteString().lastIndexOf(r2, r3);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int r7, @NotNull ByteString r8, int r9, int r10) {
        Intrinsics.f(r8, "other");
        if (r7 >= 0) goto L5;
        return false;
    L5:
        if (r7 > (size() - r10)) goto L21;
        int r11 = r10 + r7;
        int r1 = SegmentedByteStringKt.segment(this, r7);
    L8:
        if (r7 >= r11) goto L16;
        if (r1 != 0) goto L11;
        int r2 = 0;
    L12:
        int r3 = getDirectory$okio()[r1] - r2;
        int r4 = getDirectory$okio()[getSegments$okio().length + r1];
        int r5 = Math.min(r11, r3 + r2) - r7;
        if (r8.rangeEquals(r9, getSegments$okio()[r1], (r7 - r2) + r4, r5) == false) goto L22;
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
    @NotNull
    public String string(@NotNull Charset r2) {
        Intrinsics.f(r2, "charset");
        return toByteString().string(r2);
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString substring(int r12, int r13) {
        int r0 = 0;
        if (r12 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L40;
        if (r13 > size()) goto L10;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L37;
        int r4 = r13 - r12;
        if (r4 < 0) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L36;
        if (r12 == 0) goto L20;
    L22:
        if (r12 == r13) goto L42;
        int r6 = SegmentedByteStringKt.segment(this, r12);
        int r14 = SegmentedByteStringKt.segment(this, r13 - 1);
        byte[][] r7 = (byte[][]) ArraysKt.k(getSegments$okio(), r6, r14 + 1);
        int[] r8 = new int[r7.length * 2];
        if (r6 > r14) goto L30;
        int r9 = 0;
        int r10 = r6;
    L27:
        r8[r9] = Math.min(getDirectory$okio()[r10] - r12, r4);
        int r11 = r9 + 1;
        r8[r9 + r7.length] = getDirectory$okio()[getSegments$okio().length + r10];
        if (r10 == r14) goto L30;
        r10 = r10 + 1;
        r9 = r11;
    L30:
        if (r6 == 0) goto L33;
        r0 = getDirectory$okio()[r6 - 1];
    L33:
        int r15 = r7.length;
        r8[r15] = (r12 - r0) + r8[r15];
        return new SegmentedByteString(r7, r8);
    L42:
        return ByteString.EMPTY;
    L20:
        if (r13 != size()) goto L22;
        return this;
    L36:
        throw new IllegalArgumentException(("endIndex=" + r13 + " < beginIndex=" + r12).toString());
    L16:
        r5 = false;
        goto L17
    L37:
        StringBuilder r16 = a.p(r13, "endIndex=", " > length(");
        r16.append(size());
        r16.append(')');
        throw new IllegalArgumentException(r16.toString().toString());
    L10:
        r3 = false;
        goto L12
    L40:
        throw new IllegalArgumentException(a.f(r12, "beginIndex=", " < 0").toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    @NotNull
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
        ArraysKt.g(getSegments$okio()[r2], r4, r0, r5, r5 + r7);
        r4 = r4 + r7;
        r2 = r2 + 1;
        r3 = r6;
        goto L3
    L5:
        return r0;
    }

    @Override // okio.ByteString
    @NotNull
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write(@NotNull OutputStream r7) {
        Intrinsics.f(r7, "out");
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
    public void write$okio(@NotNull Buffer r11, int r12, int r13) {
        Intrinsics.f(r11, "buffer");
        int r14 = r13 + r12;
        int r0 = SegmentedByteStringKt.segment(this, r12);
    L3:
        if (r12 >= r14) goto L12;
        if (r0 != 0) goto L6;
        int r1 = 0;
    L7:
        int r2 = getDirectory$okio()[r0] - r1;
        int r3 = getDirectory$okio()[getSegments$okio().length + r0];
        int r4 = Math.min(r14, r2 + r1) - r12;
        int r6 = (r12 - r1) + r3;
        Segment r5 = new Segment(getSegments$okio()[r0], r6, r6 + r4, true, false);
        Segment r7 = r11.head;
        if (r7 != null) goto L10;
        r5.prev = r5;
        r5.next = r5;
        r11.head = r5;
    L11:
        r12 = r12 + r4;
        r0 = r0 + 1;
        goto L3
    L10:
        Intrinsics.c(r7);
        Segment r8 = r7.prev;
        Intrinsics.c(r8);
        r8.push(r5);
        goto L11
    L6:
        r1 = getDirectory$okio()[r0 - 1];
        goto L7
    L12:
        r11.setSize$okio(r11.size() + ((long) size()));
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int r7, @NotNull byte[] r8, int r9, int r10) {
        Intrinsics.f(r8, "other");
        if (r7 >= 0) goto L5;
        return false;
    L5:
        if (r7 > (size() - r10)) goto L24;
        if (r9 >= 0) goto L8;
        return false;
    L8:
        if (r9 > (r8.length - r10)) goto L26;
        int r11 = r10 + r7;
        int r1 = SegmentedByteStringKt.segment(this, r7);
    L11:
        if (r7 >= r11) goto L19;
        if (r1 != 0) goto L14;
        int r2 = 0;
    L15:
        int r3 = getDirectory$okio()[r1] - r2;
        int r4 = getDirectory$okio()[getSegments$okio().length + r1];
        int r5 = Math.min(r11, r3 + r2) - r7;
        if (Util.arrayRangeEquals(getSegments$okio()[r1], (r7 - r2) + r4, r8, r9, r5) == false) goto L27;
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
}
