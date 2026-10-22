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

/* JADX INFO: compiled from: HashingSink.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\u001f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000eH\u0007¢\u0006\u0002\b\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\u0010\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lokio/HashingSink;", "Lokio/ForwardingSink;", "Lokio/Sink;", "sink", "digest", "Ljava/security/MessageDigest;", "(Lokio/Sink;Ljava/security/MessageDigest;)V", "algorithm", "", "(Lokio/Sink;Ljava/lang/String;)V", "mac", "Ljavax/crypto/Mac;", "(Lokio/Sink;Ljavax/crypto/Mac;)V", "key", "Lokio/ByteString;", "(Lokio/Sink;Lokio/ByteString;Ljava/lang/String;)V", "hash", "()Lokio/ByteString;", "messageDigest", "-deprecated_hash", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HashingSink extends ForwardingSink implements Sink {
    public static final Companion Companion = null;
    private final Mac mac;
    private final MessageDigest messageDigest;

    /* JADX INFO: compiled from: HashingSink.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, d2 = {"Lokio/HashingSink$Companion;", "", "()V", "hmacSha1", "Lokio/HashingSink;", "sink", "Lokio/Sink;", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "md5", "sha1", "sha256", "sha512", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HashingSink md5(Sink r2) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            return new HashingSink(r2, "MD5");
        }

        @JvmStatic
        public final HashingSink sha1(Sink r2) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            return new HashingSink(r2, "SHA-1");
        }

        @JvmStatic
        public final HashingSink sha256(Sink r2) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            return new HashingSink(r2, "SHA-256");
        }

        @JvmStatic
        public final HashingSink sha512(Sink r2) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            return new HashingSink(r2, "SHA-512");
        }

        @JvmStatic
        public final HashingSink hmacSha1(Sink r2, ByteString r3) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            Intrinsics.checkNotNullParameter(r3, "key");
            return new HashingSink(r2, r3, "HmacSHA1");
        }

        @JvmStatic
        public final HashingSink hmacSha256(Sink r2, ByteString r3) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            Intrinsics.checkNotNullParameter(r3, "key");
            return new HashingSink(r2, r3, "HmacSHA256");
        }

        @JvmStatic
        public final HashingSink hmacSha512(Sink r2, ByteString r3) {
            Intrinsics.checkNotNullParameter(r2, "sink");
            Intrinsics.checkNotNullParameter(r3, "key");
            return new HashingSink(r2, r3, "HmacSHA512");
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final HashingSink hmacSha1(Sink r1, ByteString r2) {
        return Companion.hmacSha1(r1, r2);
    }

    @JvmStatic
    public static final HashingSink hmacSha256(Sink r1, ByteString r2) {
        return Companion.hmacSha256(r1, r2);
    }

    @JvmStatic
    public static final HashingSink hmacSha512(Sink r1, ByteString r2) {
        return Companion.hmacSha512(r1, r2);
    }

    @JvmStatic
    public static final HashingSink md5(Sink r1) {
        return Companion.md5(r1);
    }

    @JvmStatic
    public static final HashingSink sha1(Sink r1) {
        return Companion.sha1(r1);
    }

    @JvmStatic
    public static final HashingSink sha256(Sink r1) {
        return Companion.sha256(r1);
    }

    @JvmStatic
    public static final HashingSink sha512(Sink r1) {
        return Companion.sha512(r1);
    }

    public HashingSink(Sink r2, MessageDigest r3) {
        Intrinsics.checkNotNullParameter(r2, "sink");
        Intrinsics.checkNotNullParameter(r3, "digest");
        super(r2);
        this.messageDigest = r3;
        this.mac = null;
    }

    public HashingSink(Sink r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "sink");
        Intrinsics.checkNotNullParameter(r3, "algorithm");
        MessageDigest r4 = MessageDigest.getInstance(r3);
        Intrinsics.checkNotNullExpressionValue(r4, "getInstance(algorithm)");
        this(r2, r4);
    }

    public HashingSink(Sink r2, Mac r3) {
        Intrinsics.checkNotNullParameter(r2, "sink");
        Intrinsics.checkNotNullParameter(r3, "mac");
        super(r2);
        this.mac = r3;
        this.messageDigest = null;
    }

    public HashingSink(Sink r3, ByteString r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "sink");
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

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer r8, long r9) throws IOException {
        Intrinsics.checkNotNullParameter(r8, "source");
        _UtilKt.checkOffsetAndCount(r8.size(), 0, r9);
        Segment r0 = r8.head;
        Intrinsics.checkNotNull(r0);
        long r1 = 0;
    L4:
        if (r1 >= r9) goto L10;
        int r3 = (int) Math.min(r9 - r1, r0.limit - r0.pos);
        MessageDigest r4 = this.messageDigest;
        if (r4 == null) goto L8;
        r4.update(r0.data, r0.pos, r3);
    L9:
        r1 = r1 + ((long) r3);
        r0 = r0.next;
        Intrinsics.checkNotNull(r0);
        goto L4
    L8:
        Mac r5 = this.mac;
        Intrinsics.checkNotNull(r5);
        r5.update(r0.data, r0.pos, r3);
        goto L9
    L10:
        super.write(r8, r9);
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
    public final ByteString m3243deprecated_hash() {
        return hash();
    }
}
