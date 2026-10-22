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
public final class HashingSource extends ForwardingSource {
    public static final Companion Companion = null;
    private final Mac mac;
    private final MessageDigest messageDigest;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final HashingSource hmacSha1(@NotNull Source r2, @NotNull ByteString r3) {
            Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
            Intrinsics.f(r3, "key");
            return new HashingSource(r2, r3, "HmacSHA1");
        }

        @JvmStatic
        @NotNull
        public final HashingSource hmacSha256(@NotNull Source r2, @NotNull ByteString r3) {
            Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
            Intrinsics.f(r3, "key");
            return new HashingSource(r2, r3, "HmacSHA256");
        }

        @JvmStatic
        @NotNull
        public final HashingSource hmacSha512(@NotNull Source r2, @NotNull ByteString r3) {
            Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
            Intrinsics.f(r3, "key");
            return new HashingSource(r2, r3, "HmacSHA512");
        }

        @JvmStatic
        @NotNull
        public final HashingSource md5(@NotNull Source r2) {
            Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
            return new HashingSource(r2, "MD5");
        }

        @JvmStatic
        @NotNull
        public final HashingSource sha1(@NotNull Source r2) {
            Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
            return new HashingSource(r2, "SHA-1");
        }

        @JvmStatic
        @NotNull
        public final HashingSource sha256(@NotNull Source r2) {
            Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
            return new HashingSource(r2, "SHA-256");
        }

        @JvmStatic
        @NotNull
        public final HashingSource sha512(@NotNull Source r2) {
            Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
            return new HashingSource(r2, "SHA-512");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public HashingSource(@NotNull Source r2, @NotNull String r3) {
        Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.f(r3, "algorithm");
        super(r2);
        this.messageDigest = MessageDigest.getInstance(r3);
        this.mac = null;
    }

    @JvmStatic
    @NotNull
    public static final HashingSource hmacSha1(@NotNull Source r1, @NotNull ByteString r2) {
        return Companion.hmacSha1(r1, r2);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource hmacSha256(@NotNull Source r1, @NotNull ByteString r2) {
        return Companion.hmacSha256(r1, r2);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource hmacSha512(@NotNull Source r1, @NotNull ByteString r2) {
        return Companion.hmacSha512(r1, r2);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource md5(@NotNull Source r1) {
        return Companion.md5(r1);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource sha1(@NotNull Source r1) {
        return Companion.sha1(r1);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource sha256(@NotNull Source r1) {
        return Companion.sha256(r1);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource sha512(@NotNull Source r1) {
        return Companion.sha512(r1);
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m198deprecated_hash() {
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

    @Override // okio.ForwardingSource, okio.Source
    public long read(@NotNull Buffer r8, long r9) {
        Intrinsics.f(r8, "sink");
        long r10 = super.read(r8, r9);
        if (r10 == (-1)) goto L15;
        long r0 = r8.size() - r10;
        long r2 = r8.size();
        Segment r4 = r8.head;
        Intrinsics.c(r4);
    L6:
        if (r2 <= r0) goto L9;
        r4 = r4.prev;
        Intrinsics.c(r4);
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
        Intrinsics.c(r4);
        r0 = r2;
        goto L9
    L13:
        Mac r5 = this.mac;
        Intrinsics.c(r5);
        r5.update(r4.data, r1, r4.limit - r1);
    L15:
        return r10;
    }

    public HashingSource(@NotNull Source r2, @NotNull ByteString r3, @NotNull String r4) {
        Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
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
