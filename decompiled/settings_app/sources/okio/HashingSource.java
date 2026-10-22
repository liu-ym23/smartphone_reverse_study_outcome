package okio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HashingSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\u001f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000eH\u0007¢\u0006\u0002\b\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0016R\u0011\u0010\u0010\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lokio/HashingSource;", "Lokio/ForwardingSource;", "Lokio/Source;", "source", "digest", "Ljava/security/MessageDigest;", "(Lokio/Source;Ljava/security/MessageDigest;)V", "algorithm", "", "(Lokio/Source;Ljava/lang/String;)V", "mac", "Ljavax/crypto/Mac;", "(Lokio/Source;Ljavax/crypto/Mac;)V", "key", "Lokio/ByteString;", "(Lokio/Source;Lokio/ByteString;Ljava/lang/String;)V", "hash", "()Lokio/ByteString;", "messageDigest", "-deprecated_hash", "read", "", "sink", "Lokio/Buffer;", "byteCount", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HashingSource extends ForwardingSource implements Source {
    public static final Companion Companion = null;
    private final Mac mac;
    private final MessageDigest messageDigest;

    /* JADX INFO: compiled from: HashingSource.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, d2 = {"Lokio/HashingSource$Companion;", "", "()V", "hmacSha1", "Lokio/HashingSource;", "source", "Lokio/Source;", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "md5", "sha1", "sha256", "sha512", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HashingSource md5(Source r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            return new HashingSource(r2, "MD5");
        }

        @JvmStatic
        public final HashingSource sha1(Source r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            return new HashingSource(r2, "SHA-1");
        }

        @JvmStatic
        public final HashingSource sha256(Source r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            return new HashingSource(r2, "SHA-256");
        }

        @JvmStatic
        public final HashingSource sha512(Source r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            return new HashingSource(r2, "SHA-512");
        }

        @JvmStatic
        public final HashingSource hmacSha1(Source r2, ByteString r3) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r3, "key");
            return new HashingSource(r2, r3, "HmacSHA1");
        }

        @JvmStatic
        public final HashingSource hmacSha256(Source r2, ByteString r3) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r3, "key");
            return new HashingSource(r2, r3, "HmacSHA256");
        }

        @JvmStatic
        public final HashingSource hmacSha512(Source r2, ByteString r3) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r3, "key");
            return new HashingSource(r2, r3, "HmacSHA512");
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final HashingSource hmacSha1(Source r1, ByteString r2) {
        return Companion.hmacSha1(r1, r2);
    }

    @JvmStatic
    public static final HashingSource hmacSha256(Source r1, ByteString r2) {
        return Companion.hmacSha256(r1, r2);
    }

    @JvmStatic
    public static final HashingSource hmacSha512(Source r1, ByteString r2) {
        return Companion.hmacSha512(r1, r2);
    }

    @JvmStatic
    public static final HashingSource md5(Source r1) {
        return Companion.md5(r1);
    }

    @JvmStatic
    public static final HashingSource sha1(Source r1) {
        return Companion.sha1(r1);
    }

    @JvmStatic
    public static final HashingSource sha256(Source r1) {
        return Companion.sha256(r1);
    }

    @JvmStatic
    public static final HashingSource sha512(Source r1) {
        return Companion.sha512(r1);
    }

    public HashingSource(Source r2, MessageDigest r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "digest");
        super(r2);
        this.messageDigest = r3;
        this.mac = null;
    }

    public HashingSource(Source r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "algorithm");
        MessageDigest r4 = MessageDigest.getInstance(r3);
        Intrinsics.checkNotNullExpressionValue(r4, "getInstance(algorithm)");
        this(r2, r4);
    }

    public HashingSource(Source r2, Mac r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "mac");
        super(r2);
        this.mac = r3;
        this.messageDigest = null;
    }

    public HashingSource(Source r3, ByteString r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "algorithm");
        Mac r0 = Mac.getInstance(r5);     // Catch: InvalidKeyException -> L6
        r0.init(new SecretKeySpec(r4.toByteArray(), r5));     // Catch: InvalidKeyException -> L6
        Unit r6 = Unit.INSTANCE;     // Catch: InvalidKeyException -> L6
        Intrinsics.checkNotNullExpressionValue(r0, "try {\n      Mac.getInsta…rgumentException(e)\n    }");
        this(r3, r0);
        return;
    L6:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(Buffer r8, long r9) throws IOException {
        Intrinsics.checkNotNullParameter(r8, "sink");
        long r10 = super.read(r8, r9);
        if (r10 == (-1)) goto L15;
        long r0 = r8.size() - r10;
        long r2 = r8.size();
        Segment r4 = r8.head;
        Intrinsics.checkNotNull(r4);
    L6:
        if (r2 <= r0) goto L9;
        r4 = r4.prev;
        Intrinsics.checkNotNull(r4);
        r2 = r2 - ((long) (r4.limit - r4.pos));
    L9:
        if (r2 >= r8.size()) goto L15;
        int r1 = (int) ((((long) r4.pos) + r0) - r2);
        MessageDigest r3 = this.messageDigest;
        if (r3 == null) goto L13;
        r3.update(r4.data, r1, r4.limit - r1);
    L14:
        r2 = r2 + ((long) (r4.limit - r4.pos));
        r4 = r4.next;
        Intrinsics.checkNotNull(r4);
        r0 = r2;
        goto L9
    L13:
        Mac r5 = this.mac;
        Intrinsics.checkNotNull(r5);
        r5.update(r4.data, r1, r4.limit - r1);
    L15:
        return r10;
    }

    public final ByteString hash() {
        MessageDigest r0 = this.messageDigest;
        if (r0 == null) goto L5;
        byte[] r2 = r0.digest();
    L6:
        Intrinsics.checkNotNullExpressionValue(r2, "result");
        return new ByteString(r2);
    L5:
        Mac r3 = this.mac;
        Intrinsics.checkNotNull(r3);
        r2 = r3.doFinal();
        goto L6
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hash", imports = {}))
    /* JADX INFO: renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m3244deprecated_hash() {
        return hash();
    }
}
