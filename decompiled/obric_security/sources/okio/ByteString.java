package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import org.apache.commons.io.IOUtils;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: loaded from: classes5.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final ByteString EMPTY = null;
    static final char[] HEX_DIGITS = null;
    private static final long serialVersionUID = 1;
    final byte[] data;
    transient int hashCode;
    transient String utf8;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ByteString r1) {
        return compareTo2(r1);
    }

    static {
        HEX_DIGITS = new char[]{DeepCleanSAFEngine.DetailPath.KEY, DeepCleanSAFEngine.DetailPath.DETAIL_PATH, DeepCleanSAFEngine.DetailPath.FILENAME, DeepCleanSAFEngine.DetailPath.FILESIZE, DeepCleanSAFEngine.DetailPath.CTIME, DeepCleanSAFEngine.DetailPath.MTIME, DeepCleanSAFEngine.DetailPath.ATIME, DeepCleanSAFEngine.DetailPath.IMPORTANT, '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        EMPTY = of(new byte[0]);
    }

    ByteString(byte[] r1) {
        this.data = r1;
    }

    public static ByteString of(byte... r1) {
        if (r1 == null) goto L6;
        return new ByteString((byte[]) r1.clone());
    L6:
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString of(byte[] r7, int r8, int r9) {
        if (r7 == null) goto L6;
        Util.checkOffsetAndCount(r7.length, r8, r9);
        byte[] r0 = new byte[r9];
        System.arraycopy(r7, r8, r0, 0, r9);
        return new ByteString(r0);
    L6:
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString of(ByteBuffer r1) {
        if (r1 == null) goto L6;
        byte[] r0 = new byte[r1.remaining()];
        r1.get(r0);
        return new ByteString(r0);
    L6:
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString encodeUtf8(String r2) {
        if (r2 == null) goto L6;
        ByteString r0 = new ByteString(r2.getBytes(Util.UTF_8));
        r0.utf8 = r2;
        return r0;
    L6:
        throw new IllegalArgumentException("s == null");
    }

    public static ByteString encodeString(String r1, Charset r2) {
        if (r1 == null) goto L9;
        if (r2 == null) goto L7;
        return new ByteString(r1.getBytes(r2));
    L7:
        throw new IllegalArgumentException("charset == null");
    L9:
        throw new IllegalArgumentException("s == null");
    }

    public String utf8() {
        String r0 = this.utf8;
        if (r0 != null) goto L7;
        String r1 = new String(this.data, Util.UTF_8);
        this.utf8 = r1;
        return r1;
    L7:
        return r0;
    }

    public String string(Charset r2) {
        if (r2 == null) goto L6;
        return new String(this.data, r2);
    L6:
        throw new IllegalArgumentException("charset == null");
    }

    public String base64() {
        return Base64.encode(this.data);
    }

    public ByteString md5() {
        return digest("MD5");
    }

    public ByteString sha1() {
        return digest("SHA-1");
    }

    public ByteString sha256() {
        return digest("SHA-256");
    }

    public ByteString sha512() {
        return digest("SHA-512");
    }

    private ByteString digest(String r1) {
        return of(MessageDigest.getInstance(r1).digest(this.data));
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public ByteString hmacSha1(ByteString r2) {
        return hmac("HmacSHA1", r2);
    }

    public ByteString hmacSha256(ByteString r2) {
        return hmac("HmacSHA256", r2);
    }

    public ByteString hmacSha512(ByteString r2) {
        return hmac("HmacSHA512", r2);
    }

    private ByteString hmac(String r3, ByteString r4) {
        Mac r0 = Mac.getInstance(r3);     // Catch: InvalidKeyException -> L4 NoSuchAlgorithmException -> L7
        r0.init(new SecretKeySpec(r4.toByteArray(), r3));     // Catch: InvalidKeyException -> L4 NoSuchAlgorithmException -> L7
        return of(r0.doFinal(this.data));
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L7:
        e = move-exception;
        throw new AssertionError(e);
    }

    public String base64Url() {
        return Base64.encodeUrl(this.data);
    }

    @Nullable
    public static ByteString decodeBase64(String r1) {
        if (r1 == null) goto L9;
        byte[] r2 = Base64.decode(r1);
        if (r2 != null) goto L10;
        return null;
    L10:
        return new ByteString(r2);
    L9:
        throw new IllegalArgumentException("base64 == null");
    }

    public String hex() {
        byte[] r8 = this.data;
        char[] r0 = new char[r8.length * 2];
        int r1 = r8.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L6;
        byte r4 = r8[r2];
        int r5 = r3 + 1;
        char[] r6 = HEX_DIGITS;
        r0[r3] = r6[(r4 >> 4) & 15];
        r3 = r5 + 1;
        r0[r5] = r6[r4 & 15];
        r2 = r2 + 1;
        goto L3
    L6:
        return new String(r0);
    }

    public static ByteString decodeHex(String r5) {
        if (r5 == null) goto L13;
        if ((r5.length() % 2) != 0) goto L11;
        int r0 = r5.length() / 2;
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L9;
        int r3 = r2 * 2;
        r1[r2] = (byte) ((decodeHexDigit(r5.charAt(r3)) << 4) + decodeHexDigit(r5.charAt(r3 + 1)));
        r2 = r2 + 1;
        goto L6
    L9:
        return of(r1);
    L11:
        throw new IllegalArgumentException("Unexpected hex string: " + r5);
    L13:
        throw new IllegalArgumentException("hex == null");
    }

    private static int decodeHexDigit(char r3) {
        if (r3 >= '0') goto L5;
    L8:
        char r0 = 'a';
        if (r3 >= 'a') goto L11;
    L14:
        r0 = 'A';
        if (r3 < 'A') goto L20;
        if (r3 > 'F') goto L20;
    L13:
        return (r3 - r0) + 10;
    L20:
        throw new IllegalArgumentException("Unexpected hex digit: " + r3);
    L11:
        if (r3 > 'f') goto L14;
    L5:
        if (r3 > '9') goto L8;
        return r3 - DeepCleanSAFEngine.DetailPath.KEY;
    }

    public static ByteString read(InputStream r4, int r5) throws IOException {
        if (r4 == null) goto L16;
        if (r5 < 0) goto L14;
        byte[] r0 = new byte[r5];
        int r1 = 0;
    L5:
        if (r1 >= r5) goto L12;
        int r2 = r4.read(r0, r1, r5 - r1);
        if (r2 == (-1)) goto L10;
        r1 = r1 + r2;
        goto L5
    L10:
        throw new EOFException();
    L12:
        return new ByteString(r0);
    L14:
        throw new IllegalArgumentException("byteCount < 0: " + r5);
    L16:
        throw new IllegalArgumentException("in == null");
    }

    public ByteString toAsciiLowercase() {
        int r0 = 0;
    L3:
        byte[] r1 = this.data;
        if (r0 >= r1.length) goto L22;
        byte r2 = r1[r0];
        if (r2 < 65) goto L21;
        if (r2 > 90) goto L21;
        byte[] r5 = (byte[]) r1.clone();
        int r3 = r0 + 1;
        r5[r0] = (byte) (r2 + 32);
    L12:
        if (r3 >= r5.length) goto L20;
        byte r4 = r5[r3];
        if (r4 < 65) goto L18;
        if (r4 > 90) goto L18;
        r5[r3] = (byte) (r4 + 32);
    L18:
        r3 = r3 + 1;
        goto L12
    L20:
        return new ByteString(r5);
    L21:
        r0 = r0 + 1;
        goto L3
    L22:
        return this;
    }

    public ByteString toAsciiUppercase() {
        int r0 = 0;
    L3:
        byte[] r1 = this.data;
        if (r0 >= r1.length) goto L22;
        byte r2 = r1[r0];
        if (r2 < 97) goto L21;
        if (r2 > 122) goto L21;
        byte[] r5 = (byte[]) r1.clone();
        int r3 = r0 + 1;
        r5[r0] = (byte) (r2 - 32);
    L12:
        if (r3 >= r5.length) goto L20;
        byte r4 = r5[r3];
        if (r4 < 97) goto L18;
        if (r4 > 122) goto L18;
        r5[r3] = (byte) (r4 - 32);
    L18:
        r3 = r3 + 1;
        goto L12
    L20:
        return new ByteString(r5);
    L21:
        r0 = r0 + 1;
        goto L3
    L22:
        return this;
    }

    public ByteString substring(int r2) {
        return substring(r2, this.data.length);
    }

    public ByteString substring(int r4, int r5) {
        if (r4 < 0) goto L18;
        byte[] r0 = this.data;
        if (r5 > r0.length) goto L16;
        int r1 = r5 - r4;
        if (r1 < 0) goto L14;
        if (r4 == 0) goto L9;
    L11:
        byte[] r3 = new byte[r1];
        System.arraycopy(r0, r4, r3, 0, r1);
        return new ByteString(r3);
    L9:
        if (r5 != r0.length) goto L11;
        return this;
    L14:
        throw new IllegalArgumentException("endIndex < beginIndex");
    L16:
        throw new IllegalArgumentException("endIndex > length(" + this.data.length + ")");
    L18:
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public byte getByte(int r1) {
        return this.data[r1];
    }

    public int size() {
        return this.data.length;
    }

    public byte[] toByteArray() {
        return (byte[]) this.data.clone();
    }

    byte[] internalArray() {
        return this.data;
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    public void write(OutputStream r1) throws IOException {
        if (r1 == null) goto L6;
        r1.write(this.data);
        return;
    L6:
        throw new IllegalArgumentException("out == null");
    }

    void write(Buffer r3) {
        byte[] r2 = this.data;
        r3.write(r2, 0, r2.length);
    }

    public boolean rangeEquals(int r1, ByteString r2, int r3, int r4) {
        return r2.rangeEquals(r3, this.data, r1, r4);
    }

    public boolean rangeEquals(int r2, byte[] r3, int r4, int r5) {
        if (r2 < 0) goto L11;
        byte[] r1 = this.data;
        if (r2 > (r1.length - r5)) goto L11;
        if (r4 < 0) goto L11;
        if (r4 > (r3.length - r5)) goto L11;
        if (Util.arrayRangeEquals(r1, r2, r3, r4, r5) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public final boolean startsWith(ByteString r3) {
        return rangeEquals(0, r3, 0, r3.size());
    }

    public final boolean startsWith(byte[] r3) {
        return rangeEquals(0, r3, 0, r3.length);
    }

    public final boolean endsWith(ByteString r4) {
        return rangeEquals(size() - r4.size(), r4, 0, r4.size());
    }

    public final boolean endsWith(byte[] r4) {
        return rangeEquals(size() - r4.length, r4, 0, r4.length);
    }

    public final int indexOf(ByteString r2) {
        return indexOf(r2.internalArray(), 0);
    }

    public final int indexOf(ByteString r1, int r2) {
        return indexOf(r1.internalArray(), r2);
    }

    public final int indexOf(byte[] r2) {
        return indexOf(r2, 0);
    }

    public int indexOf(byte[] r5, int r6) {
        int r7 = Math.max(r6, 0);
        int r1 = this.data.length - r5.length;
    L3:
        if (r7 > r1) goto L8;
        if (Util.arrayRangeEquals(this.data, r7, r5, 0, r5.length) == true) goto L6;
        r7 = r7 + 1;
        goto L3
    L6:
        return r7;
    L8:
        return -1;
    }

    public final int lastIndexOf(ByteString r2) {
        return lastIndexOf(r2.internalArray(), size());
    }

    public final int lastIndexOf(ByteString r1, int r2) {
        return lastIndexOf(r1.internalArray(), r2);
    }

    public final int lastIndexOf(byte[] r2) {
        return lastIndexOf(r2, size());
    }

    public int lastIndexOf(byte[] r4, int r5) {
        int r6 = Math.min(r5, this.data.length - r4.length);
    L3:
        if (r6 < 0) goto L8;
        if (Util.arrayRangeEquals(this.data, r6, r4, 0, r4.length) == true) goto L6;
        r6 = r6 - 1;
        goto L3
    L6:
        return r6;
    L8:
        return -1;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ByteString) == false) goto L13;
        ByteString r6 = (ByteString) r5;
        int r1 = r6.size();
        byte[] r4 = this.data;
        if (r1 != r4.length) goto L13;
        if (r6.rangeEquals(0, r4, 0, r4.length) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L7;
        int r1 = Arrays.hashCode(this.data);
        this.hashCode = r1;
        return r1;
    L7:
        return r0;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ByteString r10) {
        int r0 = size();
        int r1 = r10.size();
        int r2 = Math.min(r0, r1);
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L12;
        int r7 = getByte(r4) & UByte.MAX_VALUE;
        int r8 = r10.getByte(r4) & UByte.MAX_VALUE;
        if (r7 != r8) goto L8;
        r4 = r4 + 1;
        goto L4
    L8:
        if (r7 >= r8) goto L11;
        return -1;
    L11:
        return 1;
    L12:
        if (r0 != r1) goto L14;
        return 0;
    L14:
        if (r0 >= r1) goto L17;
        return -1;
    L17:
        return 1;
    }

    public String toString() {
        if (this.data.length != 0) goto L6;
        return "[size=0]";
    L6:
        String r0 = utf8();
        int r2 = codePointIndexToCharIndex(r0, 64);
        if (r2 == (-1)) goto L9;
        String r1 = r0.substring(0, r2).replace("\\", "\\\\").replace(IOUtils.LINE_SEPARATOR_UNIX, "\\n").replace("\r", "\\r");
        if (r2 >= r0.length()) goto L17;
        return "[size=" + this.data.length + " text=" + r1 + "…]";
    L17:
        return "[text=" + r1 + "]";
    L9:
        if (this.data.length > 64) goto L12;
        return "[hex=" + hex() + "]";
    L12:
        return "[size=" + this.data.length + " hex=" + substring(0, 64).hex() + "…]";
    }

    static int codePointIndexToCharIndex(String r5, int r6) {
        int r0 = r5.length();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L18;
        if (r2 == r6) goto L5;
        int r3 = r5.codePointAt(r1);
        if (Character.isISOControl(r3) == false) goto L13;
        if (r3 == 10) goto L13;
        if (r3 == 13) goto L13;
        return -1;
    L13:
        if (r3 == 65533) goto L23;
        r2 = r2 + 1;
        r1 = r1 + Character.charCount(r3);
        goto L3
    L23:
        return -1;
    L5:
        return r1;
    L18:
        return r5.length();
    }

    private void readObject(ObjectInputStream r3) throws IOException {
        ByteString r4 = read(r3, r3.readInt());
        Field r0 = ByteString.class.getDeclaredField("data");     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        r0.set(this, r4.data);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        return;
    L6:
        throw new AssertionError();
    L8:
        throw new AssertionError();
    }

    private void writeObject(ObjectOutputStream r2) throws IOException {
        r2.writeInt(this.data.length);
        r2.write(this.data);
    }
}
