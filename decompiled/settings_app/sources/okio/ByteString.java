package okio;

import android.icu.text.PluralRules;
import com.android.settings.applications.PreferredSettingsUtils;
import com.bytedance.apm.constant.PerfConsts;
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
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okio.internal._ByteStringKt;

/* JADX INFO: compiled from: ByteString.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 ]2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001]B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0011\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J,\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J\u0015\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0010H\u0010¢\u0006\u0002\b#J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0000J\u0013\u0010'\u001a\u00020%2\b\u0010\u001a\u001a\u0004\u0018\u00010(H\u0096\u0002J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b,J\u0015\u0010,\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0007¢\u0006\u0002\b-J\r\u0010.\u001a\u00020\tH\u0010¢\u0006\u0002\b/J\b\u0010\b\u001a\u00020\tH\u0016J\b\u00100\u001a\u00020\u0010H\u0016J\u001d\u00101\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u0000H\u0010¢\u0006\u0002\b3J\u0010\u00104\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u0010\u00105\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u0010\u00106\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u001a\u00107\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\tH\u0017J\u001a\u00107\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00108\u001a\u00020\tH\u0007J\r\u00109\u001a\u00020\u0004H\u0010¢\u0006\u0002\b:J\u0015\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020\tH\u0010¢\u0006\u0002\b=J\u001a\u0010>\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\tH\u0017J\u001a\u0010>\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00108\u001a\u00020\tH\u0007J\u0006\u0010?\u001a\u00020\u0000J(\u0010@\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J(\u0010@\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J\u0010\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020DH\u0002J\u0006\u0010E\u001a\u00020\u0000J\u0006\u0010F\u001a\u00020\u0000J\u0006\u0010G\u001a\u00020\u0000J\r\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\bHJ\u000e\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020\u0004J\u000e\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020\u0000J\u0010\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020MH\u0016J\u001c\u0010N\u001a\u00020\u00002\b\b\u0002\u0010O\u001a\u00020\t2\b\b\u0002\u0010P\u001a\u00020\tH\u0017J\b\u0010Q\u001a\u00020\u0000H\u0016J\b\u0010R\u001a\u00020\u0000H\u0016J\b\u0010S\u001a\u00020\u0004H\u0016J\b\u0010T\u001a\u00020\u0010H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010U\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020WH\u0016J%\u0010U\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020Y2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0010¢\u0006\u0002\bZJ\u0010\u0010[\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020\\H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006^"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "data", "", "([B)V", "getData$okio", "()[B", "hashCode", "", "getHashCode$okio", "()I", "setHashCode$okio", "(I)V", PerfConsts.PERF_DISK_FILE_SIZE, "utf8", "", "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "base64Url", "compareTo", PluralRules.KEYWORD_OTHER, "copyInto", "", "offset", "target", "targetOffset", "byteCount", "digest", "algorithm", "digest$okio", "endsWith", "", PreferredSettingsUtils.OTHERS_SUFFIX_KEY, "equals", "", "get", "", "index", "getByte", "-deprecated_getByte", "getSize", "getSize$okio", "hex", "hmac", "key", "hmac$okio", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "pos", "internalGet$okio", "lastIndexOf", "md5", "rangeEquals", "otherOffset", "readObject", "in", "Ljava/io/ObjectInputStream;", "sha1", "sha256", "sha512", "-deprecated_size", "startsWith", "prefix", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeObject", "Ljava/io/ObjectOutputStream;", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final Companion Companion = null;
    public static final ByteString EMPTY = null;
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    /* JADX INFO: compiled from: ByteString.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\b\u0016J\u0014\u0010\u0013\u001a\u00020\u00042\n\u0010\u0017\u001a\u00020\u0018\"\u00020\u0019H\u0007J%\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0016J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b!J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\tH\u0007J\f\u0010\u000b\u001a\u00020\u0004*\u00020\tH\u0007J\u001b\u0010\"\u001a\u00020\u0004*\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\rJ\f\u0010\u0011\u001a\u00020\u0004*\u00020\tH\u0007J\u0019\u0010#\u001a\u00020\u0004*\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u001eJ\u0011\u0010$\u001a\u00020\u0004*\u00020\u0015H\u0007¢\u0006\u0002\b\u0013J%\u0010$\u001a\u00020\u0004*\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lokio/ByteString$Companion;", "", "()V", "EMPTY", "Lokio/ByteString;", "serialVersionUID", "", "decodeBase64", "string", "", "-deprecated_decodeBase64", "decodeHex", "-deprecated_decodeHex", "encodeString", "charset", "Ljava/nio/charset/Charset;", "-deprecated_encodeString", "encodeUtf8", "-deprecated_encodeUtf8", "of", "buffer", "Ljava/nio/ByteBuffer;", "-deprecated_of", "data", "", "", "array", "offset", "", "byteCount", "read", "inputstream", "Ljava/io/InputStream;", "-deprecated_read", "encode", "readByteString", "toByteString", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ ByteString of$default(Companion r0, byte[] r1, int r2, int r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r3 = _UtilKt.getDEFAULT__ByteString_size();
        L9:
            return r0.of(r1, r2, r3);
        }

        private Companion() {
        }

        @JvmStatic
        public final ByteString of(ByteBuffer r1) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            byte[] r0 = new byte[r1.remaining()];
            r1.get(r0);
            return new ByteString(r0);
        }

        public static /* synthetic */ ByteString encodeString$default(Companion r0, String r1, Charset r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = Charsets.UTF_8;
        L6:
            return r0.encodeString(r1, r2);
        }

        @JvmStatic
        public final ByteString encodeString(String r1, Charset r2) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            Intrinsics.checkNotNullParameter(r2, "charset");
            byte[] r3 = r1.getBytes(r2);
            Intrinsics.checkNotNullExpressionValue(r3, "this as java.lang.String).getBytes(charset)");
            return new ByteString(r3);
        }

        @JvmStatic
        public final ByteString read(InputStream r4, int r5) throws IOException {
            Intrinsics.checkNotNullParameter(r4, "<this>");
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
            throw new IllegalArgumentException(("byteCount < 0: " + r5).toString());
        L5:
            r0 = false;
            goto L6
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        /* JADX INFO: renamed from: -deprecated_decodeBase64, reason: not valid java name */
        public final ByteString m3229deprecated_decodeBase64(String r2) {
            Intrinsics.checkNotNullParameter(r2, "string");
            return decodeBase64(r2);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        /* JADX INFO: renamed from: -deprecated_decodeHex, reason: not valid java name */
        public final ByteString m3230deprecated_decodeHex(String r2) {
            Intrinsics.checkNotNullParameter(r2, "string");
            return decodeHex(r2);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        /* JADX INFO: renamed from: -deprecated_encodeString, reason: not valid java name */
        public final ByteString m3231deprecated_encodeString(String r2, Charset r3) {
            Intrinsics.checkNotNullParameter(r2, "string");
            Intrinsics.checkNotNullParameter(r3, "charset");
            return encodeString(r2, r3);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        /* JADX INFO: renamed from: -deprecated_encodeUtf8, reason: not valid java name */
        public final ByteString m3232deprecated_encodeUtf8(String r2) {
            Intrinsics.checkNotNullParameter(r2, "string");
            return encodeUtf8(r2);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m3233deprecated_of(ByteBuffer r2) {
            Intrinsics.checkNotNullParameter(r2, "buffer");
            return of(r2);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m3234deprecated_of(byte[] r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "array");
            return of(r2, r3, r4);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        /* JADX INFO: renamed from: -deprecated_read, reason: not valid java name */
        public final ByteString m3235deprecated_read(InputStream r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "inputstream");
            return read(r2, r3);
        }

        @JvmStatic
        public final ByteString of(byte... r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            byte[] r3 = Arrays.copyOf(r2, r2.length);
            Intrinsics.checkNotNullExpressionValue(r3, "copyOf(this, size)");
            return new ByteString(r3);
        }

        @JvmStatic
        public final ByteString of(byte[] r7, int r8, int r9) {
            Intrinsics.checkNotNullParameter(r7, "<this>");
            int r6 = _UtilKt.resolveDefaultParameter(r7, r9);
            _UtilKt.checkOffsetAndCount(r7.length, r8, r6);
            return new ByteString(ArraysKt.copyOfRange(r7, r8, r6 + r8));
        }

        @JvmStatic
        public final ByteString encodeUtf8(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            ByteString r1 = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(r2));
            r1.setUtf8$okio(r2);
            return r1;
        }

        @JvmStatic
        public final ByteString decodeBase64(String r1) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            byte[] r0 = _Base64Kt.decodeBase64ToArray(r1);
            if (r0 != null) goto L7;
            return null;
        L7:
            return new ByteString(r0);
        }

        @JvmStatic
        public final ByteString decodeHex(String r6) {
            Intrinsics.checkNotNullParameter(r6, "<this>");
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
            r2[r0] = (byte) ((_ByteStringKt.access$decodeHexDigit(r6.charAt(r3)) << 4) + _ByteStringKt.access$decodeHexDigit(r6.charAt(r3 + 1)));
            r0 = r0 + 1;
            goto L8
        L11:
            return new ByteString(r2);
        L13:
            throw new IllegalArgumentException(("Unexpected hex string: " + r6).toString());
        L5:
            r5 = false;
            goto L6
        }
    }

    @JvmStatic
    public static final ByteString decodeBase64(String r1) {
        return Companion.decodeBase64(r1);
    }

    @JvmStatic
    public static final ByteString decodeHex(String r1) {
        return Companion.decodeHex(r1);
    }

    @JvmStatic
    public static final ByteString encodeString(String r1, Charset r2) {
        return Companion.encodeString(r1, r2);
    }

    @JvmStatic
    public static final ByteString encodeUtf8(String r1) {
        return Companion.encodeUtf8(r1);
    }

    @JvmStatic
    public static final ByteString of(ByteBuffer r1) {
        return Companion.of(r1);
    }

    @JvmStatic
    public static final ByteString of(byte... r1) {
        return Companion.of(r1);
    }

    @JvmStatic
    public static final ByteString of(byte[] r1, int r2, int r3) {
        return Companion.of(r1, r2, r3);
    }

    @JvmStatic
    public static final ByteString read(InputStream r1, int r2) throws IOException {
        return Companion.read(r1, r2);
    }

    public final int indexOf(ByteString r4) {
        Intrinsics.checkNotNullParameter(r4, PluralRules.KEYWORD_OTHER);
        return indexOf$default(this, r4, 0, 2, null);
    }

    public final int indexOf(byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, PluralRules.KEYWORD_OTHER);
        return indexOf$default(this, r4, 0, 2, null);
    }

    public final int lastIndexOf(ByteString r4) {
        Intrinsics.checkNotNullParameter(r4, PluralRules.KEYWORD_OTHER);
        return lastIndexOf$default(this, r4, 0, 2, null);
    }

    public final int lastIndexOf(byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, PluralRules.KEYWORD_OTHER);
        return lastIndexOf$default(this, r4, 0, 2, null);
    }

    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    public final ByteString substring(int r4) {
        return substring$default(this, r4, 0, 2, null);
    }

    public ByteString(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.data = r2;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ByteString r1) {
        return compareTo2(r1);
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public final void setHashCode$okio(int r1) {
        this.hashCode = r1;
    }

    public final String getUtf8$okio() {
        return this.utf8;
    }

    public final void setUtf8$okio(String r1) {
        this.utf8 = r1;
    }

    public String string(Charset r2) {
        Intrinsics.checkNotNullParameter(r2, "charset");
        return new String(this.data, r2);
    }

    public final ByteString md5() {
        return digest$okio("MD5");
    }

    public final ByteString sha1() {
        return digest$okio("SHA-1");
    }

    public final ByteString sha256() {
        return digest$okio("SHA-256");
    }

    public final ByteString sha512() {
        return digest$okio("SHA-512");
    }

    public ByteString digest$okio(String r3) {
        Intrinsics.checkNotNullParameter(r3, "algorithm");
        MessageDigest r4 = MessageDigest.getInstance(r3);
        r4.update(this.data, 0, size());
        byte[] r2 = r4.digest();
        Intrinsics.checkNotNullExpressionValue(r2, "digestBytes");
        return new ByteString(r2);
    }

    public ByteString hmacSha1(ByteString r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return hmac$okio("HmacSHA1", r2);
    }

    public ByteString hmacSha256(ByteString r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return hmac$okio("HmacSHA256", r2);
    }

    public ByteString hmacSha512(ByteString r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return hmac$okio("HmacSHA512", r2);
    }

    public ByteString hmac$okio(String r3, ByteString r4) {
        Intrinsics.checkNotNullParameter(r3, "algorithm");
        Intrinsics.checkNotNullParameter(r4, "key");
        Mac r0 = Mac.getInstance(r3);     // Catch: InvalidKeyException -> L5
        r0.init(new SecretKeySpec(r4.toByteArray(), r3));     // Catch: InvalidKeyException -> L5
        byte[] r2 = r0.doFinal(this.data);     // Catch: InvalidKeyException -> L5
        Intrinsics.checkNotNullExpressionValue(r2, "mac.doFinal(data)");     // Catch: InvalidKeyException -> L5
        return new ByteString(r2);
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static /* synthetic */ ByteString substring$default(ByteString r0, int r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L12;
        if ((r3 & 1) == 0) goto L7;
        r1 = 0;
    L7:
        if ((r3 & 2) == 0) goto L10;
        r2 = _UtilKt.getDEFAULT__ByteString_size();
    L10:
        return r0.substring(r1, r2);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    public final byte getByte(int r1) {
        return internalGet$okio(r1);
    }

    public final int size() {
        return getSize$okio();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer r1 = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(r1, "wrap(data).asReadOnlyBuffer()");
        return r1;
    }

    public void write(OutputStream r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "out");
        r2.write(this.data);
    }

    public void write$okio(Buffer r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "buffer");
        _ByteStringKt.commonWrite(this, r2, r3, r4);
    }

    public static /* synthetic */ void copyInto$default(ByteString r1, int r2, byte[] r3, int r4, int r5, int r6, Object r7) {
        if (r7 != null) goto L12;
        if ((r6 & 1) == 0) goto L7;
        r2 = 0;
    L7:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        r1.copyInto(r2, r3, r4, r5);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
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

    public final int indexOf(ByteString r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, PluralRules.KEYWORD_OTHER);
        return indexOf(r2.internalArray$okio(), r3);
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

    public static /* synthetic */ int lastIndexOf$default(ByteString r0, ByteString r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = _UtilKt.getDEFAULT__ByteString_size();
    L7:
        return r0.lastIndexOf(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString r0, byte[] r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = _UtilKt.getDEFAULT__ByteString_size();
    L7:
        return r0.lastIndexOf(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    private final void readObject(ObjectInputStream r3) throws IOException {
        int r0 = r3.readInt();
        ByteString r4 = Companion.read(r3, r0);
        Field r1 = ByteString.class.getDeclaredField("data");
        r1.setAccessible(true);
        r1.set(this, r4.data);
    }

    private final void writeObject(ObjectOutputStream r2) throws IOException {
        r2.writeInt(this.data.length);
        r2.write(this.data);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m3227deprecated_getByte(int r1) {
        return getByte(r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = PerfConsts.PERF_DISK_FILE_SIZE, imports = {}))
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m3228deprecated_size() {
        return size();
    }

    static {
        Companion = new Companion(null);
        EMPTY = new ByteString(new byte[0]);
    }

    public String utf8() {
        String r0 = getUtf8$okio();
        if (r0 != null) goto L6;
        String r1 = _JvmPlatformKt.toUtf8String(internalArray$okio());
        setUtf8$okio(r1);
        return r1;
    L6:
        return r0;
    }

    public String base64() {
        return _Base64Kt.encodeBase64$default(getData$okio(), null, 1, null);
    }

    public String base64Url() {
        return _Base64Kt.encodeBase64(getData$okio(), _Base64Kt.getBASE64_URL_SAFE());
    }

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
        r0[r3] = _ByteStringKt.getHEX_DIGIT_CHARS()[(r4 >> 4) & 15];
        r3 = r5 + 1;
        r0[r5] = _ByteStringKt.getHEX_DIGIT_CHARS()[r4 & 15];
        r2 = r2 + 1;
        goto L3
    L6:
        return StringsKt.concatToString(r0);
    }

    public ByteString toAsciiLowercase() {
        int r0 = 0;
    L4:
        if (r0 >= getData$okio().length) goto L30;
        byte r1 = getData$okio()[r0];
        if (r1 < 65) goto L20;
        if (r1 > 90) goto L20;
        byte[] r5 = getData$okio();
        byte[] r6 = Arrays.copyOf(r5, r5.length);
        Intrinsics.checkNotNullExpressionValue(r6, "copyOf(this, size)");
        int r4 = r0 + 1;
        r6[r0] = (byte) (r1 + 32);
    L12:
        if (r4 >= r6.length) goto L21;
        byte r2 = r6[r4];
        if (r2 < 65) goto L18;
        if (r2 > 90) goto L18;
        r6[r4] = (byte) (r2 + 32);
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

    public ByteString toAsciiUppercase() {
        int r0 = 0;
    L4:
        if (r0 >= getData$okio().length) goto L30;
        byte r1 = getData$okio()[r0];
        if (r1 < 97) goto L20;
        if (r1 > 122) goto L20;
        byte[] r5 = getData$okio();
        byte[] r6 = Arrays.copyOf(r5, r5.length);
        Intrinsics.checkNotNullExpressionValue(r6, "copyOf(this, size)");
        int r4 = r0 + 1;
        r6[r0] = (byte) (r1 - 32);
    L12:
        if (r4 >= r6.length) goto L21;
        byte r2 = r6[r4];
        if (r2 < 97) goto L18;
        if (r2 > 122) goto L18;
        r6[r4] = (byte) (r2 - 32);
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

    public ByteString substring(int r4, int r5) {
        int r6 = _UtilKt.resolveDefaultParameter(this, r5);
        boolean r0 = true;
        if (r4 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L28;
        if (r6 > getData$okio().length) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L26;
        if ((r6 - r4) >= 0) goto L16;
        r0 = false;
    L16:
        if (r0 == false) goto L24;
        if (r4 != 0) goto L22;
        if (r6 != getData$okio().length) goto L22;
        return this;
    L22:
        return new ByteString(ArraysKt.copyOfRange(getData$okio(), r4, r6));
    L24:
        throw new IllegalArgumentException("endIndex < beginIndex".toString());
    L26:
        throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
    L10:
        r3 = false;
        goto L11
    L28:
        throw new IllegalArgumentException("beginIndex < 0".toString());
    L5:
        r2 = false;
        goto L6
    }

    public byte internalGet$okio(int r1) {
        return getData$okio()[r1];
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public byte[] toByteArray() {
        byte[] r1 = getData$okio();
        byte[] r2 = Arrays.copyOf(r1, r1.length);
        Intrinsics.checkNotNullExpressionValue(r2, "copyOf(this, size)");
        return r2;
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public boolean rangeEquals(int r2, ByteString r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, PluralRules.KEYWORD_OTHER);
        return r3.rangeEquals(r4, getData$okio(), r2, r5);
    }

    public boolean rangeEquals(int r2, byte[] r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, PluralRules.KEYWORD_OTHER);
        if (r2 >= 0) goto L5;
    L12:
        return false;
    L5:
        if (r2 > (getData$okio().length - r5)) goto L12;
        if (r4 < 0) goto L12;
        if (r4 > (r3.length - r5)) goto L12;
        if (_UtilKt.arrayRangeEquals(getData$okio(), r2, r3, r4, r5) == false) goto L12;
        return true;
    }

    public void copyInto(int r2, byte[] r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "target");
        ArraysKt.copyInto(getData$okio(), r3, r4, r2, r5 + r2);
    }

    public final boolean startsWith(ByteString r3) {
        Intrinsics.checkNotNullParameter(r3, "prefix");
        return rangeEquals(0, r3, 0, r3.size());
    }

    public final boolean startsWith(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "prefix");
        return rangeEquals(0, r3, 0, r3.length);
    }

    public final boolean endsWith(ByteString r4) {
        Intrinsics.checkNotNullParameter(r4, PreferredSettingsUtils.OTHERS_SUFFIX_KEY);
        return rangeEquals(size() - r4.size(), r4, 0, r4.size());
    }

    public final boolean endsWith(byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, PreferredSettingsUtils.OTHERS_SUFFIX_KEY);
        return rangeEquals(size() - r4.length, r4, 0, r4.length);
    }

    public int indexOf(byte[] r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, PluralRules.KEYWORD_OTHER);
        int r0 = getData$okio().length - r5.length;
        int r7 = Math.max(r6, 0);
        if (r7 <= r0) goto L5;
    L9:
        return -1;
    L5:
        if (_UtilKt.arrayRangeEquals(getData$okio(), r7, r5, 0, r5.length) == true) goto L13;
        if (r7 == r0) goto L9;
        r7 = r7 + 1;
        goto L5
    L13:
        return r7;
    }

    public final int lastIndexOf(ByteString r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, PluralRules.KEYWORD_OTHER);
        return lastIndexOf(r2.internalArray$okio(), r3);
    }

    public int lastIndexOf(byte[] r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, PluralRules.KEYWORD_OTHER);
        int r6 = Math.min(_UtilKt.resolveDefaultParameter(this, r5), getData$okio().length - r4.length);
    L4:
        if ((-1) >= r6) goto L10;
        if (_UtilKt.arrayRangeEquals(getData$okio(), r6, r4, 0, r4.length) == true) goto L13;
        r6 = r6 - 1;
        goto L4
    L13:
        return r6;
    L10:
        return -1;
    }

    public boolean equals(Object r5) {
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

    public int hashCode() {
        int r0 = getHashCode$okio();
        if (r0 != 0) goto L7;
        int r1 = Arrays.hashCode(getData$okio());
        setHashCode$okio(r1);
        return r1;
    L7:
        return r0;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, PluralRules.KEYWORD_OTHER);
        int r0 = size();
        int r1 = r10.size();
        int r2 = Math.min(r0, r1);
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L10;
        int r7 = getByte(r4) & 255;
        int r8 = r10.getByte(r4) & 255;
        if (r7 != r8) goto L8;
        r4 = r4 + 1;
        goto L4
    L8:
        if (r7 < r8) goto L18;
    L15:
        return 1;
    L18:
        return -1;
    L10:
        if (r0 == r1) goto L19;
        if (r0 >= r1) goto L15;
    L19:
        return 0;
    }

    public String toString() {
        boolean r1 = true;
        if (getData$okio().length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return "[size=0]";
    L8:
        int r2 = _ByteStringKt.access$codePointIndexToCharIndex(getData$okio(), 64);
        if (r2 == (-1)) goto L11;
        String r3 = utf8();
        String r8 = r3.substring(0, r2);
        Intrinsics.checkNotNullExpressionValue(r8, "this as java.lang.String…ing(startIndex, endIndex)");
        String r4 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r8, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (r2 >= r3.length()) goto L36;
        return "[size=" + getData$okio().length + " text=" + r4 + "…]";
    L36:
        return "[text=" + r4 + ']';
    L11:
        if (getData$okio().length <= 64) goto L38;
        StringBuilder r5 = new StringBuilder("[size=").append(getData$okio().length).append(" hex=");
        int r6 = _UtilKt.resolveDefaultParameter(this, 64);
        if (r6 > getData$okio().length) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L31;
        if ((r6 + 0) >= 0) goto L22;
        r1 = false;
    L22:
        if (r1 == false) goto L29;
        if (r6 != getData$okio().length) goto L26;
        ByteString r9 = this;
    L39:
        return r5.append(r9.hex()).append("…]").toString();
    L26:
        r9 = new ByteString(ArraysKt.copyOfRange(getData$okio(), 0, r6));
        goto L39
    L29:
        throw new IllegalArgumentException("endIndex < beginIndex".toString());
    L31:
        throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
    L16:
        r7 = false;
        goto L17
    L38:
        return "[hex=" + hex() + ']';
    L5:
        r0 = false;
        goto L6
    }
}
