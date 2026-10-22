package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Header {
    public static final Companion Companion = null;

    @JvmField
    @NotNull
    public static final ByteString PSEUDO_PREFIX = null;

    @JvmField
    @NotNull
    public static final ByteString RESPONSE_STATUS = null;

    @NotNull
    public static final String RESPONSE_STATUS_UTF8 = ":status";

    @JvmField
    @NotNull
    public static final ByteString TARGET_AUTHORITY = null;

    @NotNull
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";

    @JvmField
    @NotNull
    public static final ByteString TARGET_METHOD = null;

    @NotNull
    public static final String TARGET_METHOD_UTF8 = ":method";

    @JvmField
    @NotNull
    public static final ByteString TARGET_PATH = null;

    @NotNull
    public static final String TARGET_PATH_UTF8 = ":path";

    @JvmField
    @NotNull
    public static final ByteString TARGET_SCHEME = null;

    @NotNull
    public static final String TARGET_SCHEME_UTF8 = ":scheme";

    @JvmField
    public final int hpackSize;

    @JvmField
    @NotNull
    public final ByteString name;

    @JvmField
    @NotNull
    public final ByteString value;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        ByteString.Companion r0 = ByteString.Companion;
        PSEUDO_PREFIX = r0.encodeUtf8(":");
        RESPONSE_STATUS = r0.encodeUtf8(RESPONSE_STATUS_UTF8);
        TARGET_METHOD = r0.encodeUtf8(TARGET_METHOD_UTF8);
        TARGET_PATH = r0.encodeUtf8(TARGET_PATH_UTF8);
        TARGET_SCHEME = r0.encodeUtf8(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = r0.encodeUtf8(TARGET_AUTHORITY_UTF8);
    }

    public Header(@NotNull ByteString r2, @NotNull ByteString r3) {
        Intrinsics.f(r2, "name");
        Intrinsics.f(r3, "value");
        this.name = r2;
        this.value = r3;
        int r4 = r2.size() + 32;
        this.hpackSize = r3.size() + r4;
    }

    public static /* synthetic */ Header copy$default(Header r0, ByteString r1, ByteString r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.name;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.value;
    L9:
        return r0.copy(r1, r2);
    }

    @NotNull
    public final ByteString component1() {
        return this.name;
    }

    @NotNull
    public final ByteString component2() {
        return this.value;
    }

    @NotNull
    public final Header copy(@NotNull ByteString r1, @NotNull ByteString r2) {
        Intrinsics.f(r1, "name");
        Intrinsics.f(r2, "value");
        return new Header(r1, r2);
    }

    public boolean equals(@Nullable Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof Header) == false) goto L10;
        Header r4 = (Header) r3;
        if (Intrinsics.a(this.name, r4.name) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.a(this.value, r4.value) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        ByteString r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ByteString r4 = this.value;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    @NotNull
    public String toString() {
        return this.name.utf8() + ": " + this.value.utf8();
    }

    public Header(@NotNull String r2, @NotNull String r3) {
        Intrinsics.f(r2, "name");
        Intrinsics.f(r3, "value");
        ByteString.Companion r0 = ByteString.Companion;
        this(r0.encodeUtf8(r2), r0.encodeUtf8(r3));
    }

    public Header(@NotNull ByteString r2, @NotNull String r3) {
        Intrinsics.f(r2, "name");
        Intrinsics.f(r3, "value");
        this(r2, ByteString.Companion.encodeUtf8(r3));
    }
}
