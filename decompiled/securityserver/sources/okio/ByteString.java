package okio;

import a.a;
import java.io.EOFException;
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
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okio.internal.ByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final Companion Companion = null;

    @JvmField
    @NotNull
    public static final ByteString EMPTY = null;
    private static final long serialVersionUID = 1;

    @NotNull
    private final byte[] data;
    private transient int hashCode;

    @Nullable
    private transient String utf8;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ByteString encodeString$default(Companion r0, String r1, Charset r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = Charsets.f354a;
        L6:
            return r0.encodeString(r1, r2);
        }

        public static /* synthetic */ ByteString of$default(Companion r0, byte[] r1, int r2, int r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r3 = r1.length;
        L9:
            return r0.of(r1, r2, r3);
        }

        @Deprecated
        @JvmName
        @Nullable
        /* JADX INFO: renamed from: -deprecated_decodeBase64, reason: not valid java name */
        public final ByteString m186deprecated_decodeBase64(@NotNull String r2) {
            Intrinsics.f(r2, "string");
            return decodeBase64(r2);
        }

        @Deprecated
        @JvmName
        @NotNull
        /* JADX INFO: renamed from: -deprecated_decodeHex, reason: not valid java name */
        public final ByteString m187deprecated_decodeHex(@NotNull String r2) {
            Intrinsics.f(r2, "string");
            return decodeHex(r2);
        }

        @Deprecated
        @JvmName
        @NotNull
        /* JADX INFO: renamed from: -deprecated_encodeString, reason: not valid java name */
        public final ByteString m188deprecated_encodeString(@NotNull String r2, @NotNull Charset r3) {
            Intrinsics.f(r2, "string");
            Intrinsics.f(r3, "charset");
            return encodeString(r2, r3);
        }

        @Deprecated
        @JvmName
        @NotNull
        /* JADX INFO: renamed from: -deprecated_encodeUtf8, reason: not valid java name */
        public final ByteString m189deprecated_encodeUtf8(@NotNull String r2) {
            Intrinsics.f(r2, "string");
            return encodeUtf8(r2);
        }

        @Deprecated
        @JvmName
        @NotNull
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m190deprecated_of(@NotNull ByteBuffer r2) {
            Intrinsics.f(r2, "buffer");
            return of(r2);
        }

        @Deprecated
        @JvmName
        @NotNull
        /* JADX INFO: renamed from: -deprecated_read, reason: not valid java name */
        public final ByteString m192deprecated_read(@NotNull InputStream r2, int r3) {
            Intrinsics.f(r2, "inputstream");
            return read(r2, r3);
        }

        @JvmStatic
        @Nullable
        public final ByteString decodeBase64(@NotNull String r1) {
            Intrinsics.f(r1, "$this$decodeBase64");
            byte[] r0 = Base64.decodeBase64ToArray(r1);
            if (r0 != null) goto L7;
            return null;
        L7:
            return new ByteString(r0);
        }

        @JvmStatic
        @NotNull
        public final ByteString decodeHex(@NotNull String r6) {
            Intrinsics.f(r6, "$this$decodeHex");
            int r0 = 0;
            if ((r6.length() % 2) != 0) goto L5;
            boolean r5 = true;
        L6:
            if (r5 == false) goto L13;
            int r7 = r6.length() / 2;
            byte[] r2 = new byte[r7];
        L8:
            if (r0 >= r7) goto L11;
            int r3 = r0 * 2;
            r2[r0] = (byte) (ByteStringKt.access$decodeHexDigit(r6.charAt(r3 + 1)) + (ByteStringKt.access$decodeHexDigit(r6.charAt(r3)) << 4));
            r0 = r0 + 1;
            goto L8
        L11:
            return new ByteString(r2);
        L13:
            throw new IllegalArgumentException("Unexpected hex string: ".concat(r6).toString());
        L5:
            r5 = false;
            goto L6
        }

        @JvmStatic
        @JvmName
        @NotNull
        public final ByteString encodeString(@NotNull String r1, @NotNull Charset r2) {
            Intrinsics.f(r1, "$this$encode");
            Intrinsics.f(r2, "charset");
            byte[] r3 = r1.getBytes(r2);
            Intrinsics.e(r3, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(r3);
        }

        @JvmStatic
        @NotNull
        public final ByteString encodeUtf8(@NotNull String r2) {
            Intrinsics.f(r2, "$this$encodeUtf8");
            ByteString r1 = new ByteString(Platform.asUtf8ToByteArray(r2));
            r1.setUtf8$okio(r2);
            return r1;
        }

        @JvmStatic
        @JvmName
        @NotNull
        public final ByteString of(@NotNull ByteBuffer r1) {
            Intrinsics.f(r1, "$this$toByteString");
            byte[] r0 = new byte[r1.remaining()];
            r1.get(r0);
            return new ByteString(r0);
        }

        @JvmStatic
        @JvmName
        @NotNull
        public final ByteString read(@NotNull InputStream r4, int r5) {
            Intrinsics.f(r4, "$this$readByteString");
            int r3 = 0;
            if (r5 < 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L17;
            byte[] r1 = new byte[r5];
        L8:
            if (r3 >= r5) goto L15;
            int r2 = r4.read(r1, r3, r5 - r3);
            if (r2 == (-1)) goto L13;
            r3 = r3 + r2;
            goto L8
        L13:
            throw new EOFException();
        L15:
            return new ByteString(r1);
        L17:
            throw new IllegalArgumentException(a.e(r5, "byteCount < 0: ").toString());
        L5:
            r0 = false;
            goto L6
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @Deprecated
        @JvmName
        @NotNull
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m191deprecated_of(@NotNull byte[] r2, int r3, int r4) {
            Intrinsics.f(r2, "array");
            return of(r2, r3, r4);
        }

        @JvmStatic
        @NotNull
        public final ByteString of(@NotNull byte... r2) {
            Intrinsics.f(r2, "data");
            byte[] r3 = Arrays.copyOf(r2, r2.length);
            Intrinsics.e(r3, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(r3);
        }

        @JvmStatic
        @JvmName
        @NotNull
        public final ByteString of(@NotNull byte[] r7, int r8, int r9) {
            Intrinsics.f(r7, "$this$toByteString");
            Util.checkOffsetAndCount(r7.length, r8, r9);
            return new ByteString(ArraysKt.j(r7, r8, r9 + r8));
        }
    }

    static {
        Companion = new Companion(null);
        EMPTY = new ByteString(new byte[0]);
    }

    public ByteString(@NotNull byte[] r2) {
        Intrinsics.f(r2, "data");
        this.data = r2;
    }

    @JvmStatic
    @Nullable
    public static final ByteString decodeBase64(@NotNull String r1) {
        return Companion.decodeBase64(r1);
    }

    @JvmStatic
    @NotNull
    public static final ByteString decodeHex(@NotNull String r1) {
        return Companion.decodeHex(r1);
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final ByteString encodeString(@NotNull String r1, @NotNull Charset r2) {
        return Companion.encodeString(r1, r2);
    }

    @JvmStatic
    @NotNull
    public static final ByteString encodeUtf8(@NotNull String r1) {
        return Companion.encodeUtf8(r1);
    }

    public static /* synthetic */ int indexOf$default(ByteString r0, ByteString r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = 0;
    L7:
        return r0.indexOf(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString r0, ByteString r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = r0.size();
    L7:
        return r0.lastIndexOf(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final ByteString of(@NotNull ByteBuffer r1) {
        return Companion.of(r1);
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final ByteString read(@NotNull InputStream r1, int r2) {
        return Companion.read(r1, r2);
    }

    private final void readObject(ObjectInputStream r3) {
        int r0 = r3.readInt();
        ByteString r4 = Companion.read(r3, r0);
        Field r1 = ByteString.class.getDeclaredField("data");
        Intrinsics.e(r1, "field");
        r1.setAccessible(true);
        r1.set(this, r4.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString r0, int r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L12;
        if ((r3 & 1) == 0) goto L7;
        r1 = 0;
    L7:
        if ((r3 & 2) == 0) goto L10;
        r2 = r0.size();
    L10:
        return r0.substring(r1, r2);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    private final void writeObject(ObjectOutputStream r2) {
        r2.writeInt(this.data.length);
        r2.write(this.data);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m184deprecated_getByte(int r1) {
        return getByte(r1);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m185deprecated_size() {
        return size();
    }

    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer r1 = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        Intrinsics.e(r1, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return r1;
    }

    @NotNull
    public String base64() {
        return Base64.encodeBase64$default(getData$okio(), null, 1, null);
    }

    @NotNull
    public String base64Url() {
        return Base64.encodeBase64(getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ByteString r1) {
        return compareTo2(r1);
    }

    @NotNull
    public ByteString digest$okio(@NotNull String r2) {
        Intrinsics.f(r2, "algorithm");
        byte[] r1 = MessageDigest.getInstance(r2).digest(this.data);
        Intrinsics.e(r1, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(r1);
    }

    public final boolean endsWith(@NotNull ByteString r4) {
        Intrinsics.f(r4, "suffix");
        return rangeEquals(size() - r4.size(), r4, 0, r4.size());
    }

    public boolean equals(@Nullable Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ByteString) == false) goto L13;
        ByteString r6 = (ByteString) r5;
        if (r6.size() != getData$okio().length) goto L13;
        if (r6.rangeEquals(0, getData$okio(), 0, getData$okio().length) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @JvmName
    public final byte getByte(int r1) {
        return internalGet$okio(r1);
    }

    @NotNull
    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    @Nullable
    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int r0 = getHashCode$okio();
        if (r0 != 0) goto L7;
        int r1 = Arrays.hashCode(getData$okio());
        setHashCode$okio(r1);
        return r1;
    L7:
        return r0;
    }

    @NotNull
    public String hex() {
        char[] r0 = new char[getData$okio().length * 2];
        byte[] r8 = getData$okio();
        int r1 = r8.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L6;
        byte r4 = r8[r2];
        int r5 = r3 + 1;
        r0[r3] = ByteStringKt.getHEX_DIGIT_CHARS()[(r4 >> 4) & 15];
        r3 = r3 + 2;
        r0[r5] = ByteStringKt.getHEX_DIGIT_CHARS()[r4 & 15];
        r2 = r2 + 1;
        goto L3
    L6:
        return new String(r0);
    }

    @NotNull
    public ByteString hmac$okio(@NotNull String r3, @NotNull ByteString r4) {
        Intrinsics.f(r3, "algorithm");
        Intrinsics.f(r4, "key");
        Mac r0 = Mac.getInstance(r3);     // Catch: InvalidKeyException -> L5
        r0.init(new SecretKeySpec(r4.toByteArray(), r3));     // Catch: InvalidKeyException -> L5
        byte[] r2 = r0.doFinal(this.data);     // Catch: InvalidKeyException -> L5
        Intrinsics.e(r2, "mac.doFinal(data)");     // Catch: InvalidKeyException -> L5
        return new ByteString(r2);
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @NotNull
    public ByteString hmacSha1(@NotNull ByteString r2) {
        Intrinsics.f(r2, "key");
        return hmac$okio("HmacSHA1", r2);
    }

    @NotNull
    public ByteString hmacSha256(@NotNull ByteString r2) {
        Intrinsics.f(r2, "key");
        return hmac$okio("HmacSHA256", r2);
    }

    @NotNull
    public ByteString hmacSha512(@NotNull ByteString r2) {
        Intrinsics.f(r2, "key");
        return hmac$okio("HmacSHA512", r2);
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString r4) {
        return indexOf$default(this, r4, 0, 2, null);
    }

    @NotNull
    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int r1) {
        return getData$okio()[r1];
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString r4) {
        return lastIndexOf$default(this, r4, 0, 2, null);
    }

    @NotNull
    public ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int r2, @NotNull ByteString r3, int r4, int r5) {
        Intrinsics.f(r3, "other");
        return r3.rangeEquals(r4, getData$okio(), r2, r5);
    }

    public final void setHashCode$okio(int r1) {
        this.hashCode = r1;
    }

    public final void setUtf8$okio(@Nullable String r1) {
        this.utf8 = r1;
    }

    @NotNull
    public ByteString sha1() {
        return digest$okio("SHA-1");
    }

    @NotNull
    public ByteString sha256() {
        return digest$okio("SHA-256");
    }

    @NotNull
    public ByteString sha512() {
        return digest$okio("SHA-512");
    }

    @JvmName
    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(@NotNull ByteString r3) {
        Intrinsics.f(r3, "prefix");
        return rangeEquals(0, r3, 0, r3.size());
    }

    @NotNull
    public String string(@NotNull Charset r2) {
        Intrinsics.f(r2, "charset");
        return new String(this.data, r2);
    }

    @JvmOverloads
    @NotNull
    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    @NotNull
    public ByteString toAsciiLowercase() {
        int r0 = 0;
    L4:
        if (r0 >= getData$okio().length) goto L30;
        byte r1 = getData$okio()[r0];
        byte r2 = (byte) 65;
        if (r1 < r2) goto L20;
        byte r3 = (byte) 90;
        if (r1 > r3) goto L20;
        byte[] r5 = getData$okio();
        byte[] r6 = Arrays.copyOf(r5, r5.length);
        Intrinsics.e(r6, "java.util.Arrays.copyOf(this, size)");
        int r4 = r0 + 1;
        r6[r0] = (byte) (r1 + 32);
    L12:
        if (r4 >= r6.length) goto L21;
        byte r7 = r6[r4];
        if (r7 < r2) goto L18;
        if (r7 > r3) goto L18;
        r6[r4] = (byte) (r7 + 32);
    L18:
        r4 = r4 + 1;
        goto L12
    L21:
        return new ByteString(r6);
    L20:
        r0 = r0 + 1;
        goto L4
    L30:
        return this;
    }

    @NotNull
    public ByteString toAsciiUppercase() {
        int r0 = 0;
    L4:
        if (r0 >= getData$okio().length) goto L30;
        byte r1 = getData$okio()[r0];
        byte r2 = (byte) 97;
        if (r1 < r2) goto L20;
        byte r3 = (byte) 122;
        if (r1 > r3) goto L20;
        byte[] r5 = getData$okio();
        byte[] r6 = Arrays.copyOf(r5, r5.length);
        Intrinsics.e(r6, "java.util.Arrays.copyOf(this, size)");
        int r4 = r0 + 1;
        r6[r0] = (byte) (r1 - 32);
    L12:
        if (r4 >= r6.length) goto L21;
        byte r7 = r6[r4];
        if (r7 < r2) goto L18;
        if (r7 > r3) goto L18;
        r6[r4] = (byte) (r7 - 32);
    L18:
        r4 = r4 + 1;
        goto L12
    L21:
        return new ByteString(r6);
    L20:
        r0 = r0 + 1;
        goto L4
    L30:
        return this;
    }

    @NotNull
    public byte[] toByteArray() {
        byte[] r1 = getData$okio();
        byte[] r2 = Arrays.copyOf(r1, r1.length);
        Intrinsics.e(r2, "java.util.Arrays.copyOf(this, size)");
        return r2;
    }

    @NotNull
    public String toString() {
        if (getData$okio().length != 0) goto L5;
        return "[size=0]";
    L5:
        int r0 = ByteStringKt.access$codePointIndexToCharIndex(getData$okio(), 64);
        if (r0 == (-1)) goto L8;
        String r1 = utf8();
        if (r1 == null) goto L27;
        String r2 = r1.substring(0, r0);
        Intrinsics.e(r2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String r3 = StringsKt.B(StringsKt.B(StringsKt.B(r2, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
        if (r0 >= r1.length()) goto L25;
        return "[size=" + getData$okio().length + " text=" + r3 + "…]";
    L25:
        return "[text=" + r3 + ']';
    L27:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L8:
        if (getData$okio().length <= 64) goto L29;
        StringBuilder r4 = new StringBuilder("[size=");
        r4.append(getData$okio().length);
        r4.append(" hex=");
        if (64 > getData$okio().length) goto L18;
        if (64 == getData$okio().length) goto L16;
        ByteString this = new ByteString(ArraysKt.j(getData$okio(), 0, 64));
    L16:
        r4.append(this.hex());
        r4.append("…]");
        return r4.toString();
    L18:
        throw new IllegalArgumentException(a.l(new StringBuilder("endIndex > length("), getData$okio().length, ')').toString());
    L29:
        return "[hex=" + hex() + ']';
    }

    @NotNull
    public String utf8() {
        String r0 = getUtf8$okio();
        if (r0 != null) goto L6;
        String r1 = Platform.toUtf8String(internalArray$okio());
        setUtf8$okio(r1);
        return r1;
    L6:
        return r0;
    }

    public void write(@NotNull OutputStream r2) {
        Intrinsics.f(r2, "out");
        r2.write(this.data);
    }

    public void write$okio(@NotNull Buffer r2, int r3, int r4) {
        Intrinsics.f(r2, "buffer");
        ByteStringKt.commonWrite(this, r2, r3, r4);
    }

    public static /* synthetic */ int indexOf$default(ByteString r0, byte[] r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = 0;
    L7:
        return r0.indexOf(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString r0, byte[] r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = r0.size();
    L7:
        return r0.lastIndexOf(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    @JvmStatic
    @NotNull
    public static final ByteString of(@NotNull byte... r1) {
        return Companion.of(r1);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(@NotNull ByteString r10) {
        Intrinsics.f(r10, "other");
        int r0 = size();
        int r1 = r10.size();
        int r2 = Math.min(r0, r1);
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L11;
        int r7 = getByte(r4) & 255;
        int r8 = r10.getByte(r4) & 255;
        if (r7 != r8) goto L8;
        r4 = r4 + 1;
        goto L4
    L8:
        if (r7 >= r8) goto L18;
    L15:
        return -1;
    L18:
        return 1;
    L11:
        if (r0 == r1) goto L19;
        if (r0 >= r1) goto L18;
    L19:
        return 0;
    }

    public final boolean endsWith(@NotNull byte[] r4) {
        Intrinsics.f(r4, "suffix");
        return rangeEquals(size() - r4.length, r4, 0, r4.length);
    }

    @JvmOverloads
    public final int indexOf(@NotNull byte[] r4) {
        return indexOf$default(this, r4, 0, 2, null);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull byte[] r4) {
        return lastIndexOf$default(this, r4, 0, 2, null);
    }

    public boolean rangeEquals(int r2, @NotNull byte[] r3, int r4, int r5) {
        Intrinsics.f(r3, "other");
        if (r2 >= 0) goto L5;
    L12:
        return false;
    L5:
        if (r2 > (getData$okio().length - r5)) goto L12;
        if (r4 < 0) goto L12;
        if (r4 > (r3.length - r5)) goto L12;
        if (Util.arrayRangeEquals(getData$okio(), r2, r3, r4, r5) == false) goto L12;
        return true;
    }

    public final boolean startsWith(@NotNull byte[] r3) {
        Intrinsics.f(r3, "prefix");
        return rangeEquals(0, r3, 0, r3.length);
    }

    @JvmOverloads
    @NotNull
    public final ByteString substring(int r4) {
        return substring$default(this, r4, 0, 2, null);
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final ByteString of(@NotNull byte[] r1, int r2, int r3) {
        return Companion.of(r1, r2, r3);
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString r2, int r3) {
        Intrinsics.f(r2, "other");
        return indexOf(r2.internalArray$okio(), r3);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString r2, int r3) {
        Intrinsics.f(r2, "other");
        return lastIndexOf(r2.internalArray$okio(), r3);
    }

    @JvmOverloads
    @NotNull
    public ByteString substring(int r4, int r5) {
        boolean r0 = false;
        if (r4 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L27;
        if (r5 > getData$okio().length) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L25;
        if ((r5 - r4) < 0) goto L15;
        r0 = true;
    L15:
        if (r0 == false) goto L23;
        if (r4 != 0) goto L21;
        if (r5 != getData$okio().length) goto L21;
        return this;
    L21:
        return new ByteString(ArraysKt.j(getData$okio(), r4, r5));
    L23:
        throw new IllegalArgumentException("endIndex < beginIndex".toString());
    L25:
        throw new IllegalArgumentException(a.l(new StringBuilder("endIndex > length("), getData$okio().length, ')').toString());
    L10:
        r3 = false;
        goto L11
    L27:
        throw new IllegalArgumentException("beginIndex < 0".toString());
    L5:
        r2 = false;
        goto L6
    }

    @JvmOverloads
    public int indexOf(@NotNull byte[] r5, int r6) {
        Intrinsics.f(r5, "other");
        int r0 = getData$okio().length - r5.length;
        int r7 = Math.max(r6, 0);
        if (r7 <= r0) goto L5;
    L9:
        return -1;
    L5:
        if (Util.arrayRangeEquals(getData$okio(), r7, r5, 0, r5.length) == true) goto L13;
        if (r7 == r0) goto L9;
        r7 = r7 + 1;
        goto L5
    L13:
        return r7;
    }

    @JvmOverloads
    public int lastIndexOf(@NotNull byte[] r4, int r5) {
        Intrinsics.f(r4, "other");
        int r6 = Math.min(r5, getData$okio().length - r4.length);
    L3:
        if (r6 < 0) goto L8;
        if (Util.arrayRangeEquals(getData$okio(), r6, r4, 0, r4.length) == true) goto L12;
        r6 = r6 - 1;
        goto L3
    L12:
        return r6;
    L8:
        return -1;
    }
}
