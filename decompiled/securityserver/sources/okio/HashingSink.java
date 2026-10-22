package okio;

import com.bytedance.apm.battery.dao.DBHelper;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class HashingSink extends ForwardingSink {
    public static final Companion Companion = null;
    private final Mac mac;
    private final MessageDigest messageDigest;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final HashingSink hmacSha1(@NotNull Sink r2, @NotNull ByteString r3) {
            Intrinsics.f(r2, "sink");
            Intrinsics.f(r3, "key");
            return new HashingSink(r2, r3, "HmacSHA1");
        }

        @JvmStatic
        @NotNull
        public final HashingSink hmacSha256(@NotNull Sink r2, @NotNull ByteString r3) {
            Intrinsics.f(r2, "sink");
            Intrinsics.f(r3, "key");
            return new HashingSink(r2, r3, "HmacSHA256");
        }

        @JvmStatic
        @NotNull
        public final HashingSink hmacSha512(@NotNull Sink r2, @NotNull ByteString r3) {
            Intrinsics.f(r2, "sink");
            Intrinsics.f(r3, "key");
            return new HashingSink(r2, r3, "HmacSHA512");
        }

        @JvmStatic
        @NotNull
        public final HashingSink md5(@NotNull Sink r2) {
            Intrinsics.f(r2, "sink");
            return new HashingSink(r2, "MD5");
        }

        @JvmStatic
        @NotNull
        public final HashingSink sha1(@NotNull Sink r2) {
            Intrinsics.f(r2, "sink");
            return new HashingSink(r2, "SHA-1");
        }

        @JvmStatic
        @NotNull
        public final HashingSink sha256(@NotNull Sink r2) {
            Intrinsics.f(r2, "sink");
            return new HashingSink(r2, "SHA-256");
        }

        @JvmStatic
        @NotNull
        public final HashingSink sha512(@NotNull Sink r2) {
            Intrinsics.f(r2, "sink");
            return new HashingSink(r2, "SHA-512");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public HashingSink(@NotNull Sink r2, @NotNull String r3) {
        Intrinsics.f(r2, "sink");
        Intrinsics.f(r3, "algorithm");
        super(r2);
        this.messageDigest = MessageDigest.getInstance(r3);
        this.mac = null;
    }

    @JvmStatic
    @NotNull
    public static final HashingSink hmacSha1(@NotNull Sink r1, @NotNull ByteString r2) {
        return Companion.hmacSha1(r1, r2);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink hmacSha256(@NotNull Sink r1, @NotNull ByteString r2) {
        return Companion.hmacSha256(r1, r2);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink hmacSha512(@NotNull Sink r1, @NotNull ByteString r2) {
        return Companion.hmacSha512(r1, r2);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink md5(@NotNull Sink r1) {
        return Companion.md5(r1);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink sha1(@NotNull Sink r1) {
        return Companion.sha1(r1);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink sha256(@NotNull Sink r1) {
        return Companion.sha256(r1);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink sha512(@NotNull Sink r1) {
        return Companion.sha512(r1);
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m197deprecated_hash() {
        return hash();
    }

    @JvmName
    @NotNull
    public final ByteString hash() {
        MessageDigest r0 = this.messageDigest;
        if (r0 == null) goto L5;
        byte[] r2 = r0.digest();
    L6:
        Intrinsics.e(r2, "result");
        return new ByteString(r2);
    L5:
        Mac r3 = this.mac;
        Intrinsics.c(r3);
        r2 = r3.doFinal();
        goto L6
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(@NotNull Buffer r8, long r9) {
        Intrinsics.f(r8, DBHelper.BATTERY_COL_SOURCE);
        Util.checkOffsetAndCount(r8.size(), 0, r9);
        Segment r0 = r8.head;
        Intrinsics.c(r0);
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
        Intrinsics.c(r0);
        goto L4
    L8:
        Mac r5 = this.mac;
        Intrinsics.c(r5);
        r5.update(r0.data, r0.pos, r3);
        goto L9
    L10:
        super.write(r8, r9);
    }

    public HashingSink(@NotNull Sink r2, @NotNull ByteString r3, @NotNull String r4) {
        Intrinsics.f(r2, "sink");
        Intrinsics.f(r3, "key");
        Intrinsics.f(r4, "algorithm");
        super(r2);
        Mac r5 = Mac.getInstance(r4);     // Catch: InvalidKeyException -> L5
        r5.init(new SecretKeySpec(r3.toByteArray(), r4));     // Catch: InvalidKeyException -> L5
        this.mac = r5;     // Catch: InvalidKeyException -> L5
        this.messageDigest = null;     // Catch: InvalidKeyException -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}
