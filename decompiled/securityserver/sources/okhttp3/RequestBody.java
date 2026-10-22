package okhttp3;

import java.io.File;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class RequestBody {
    public static final Companion Companion = null;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ RequestBody create$default(Companion r0, String r1, MediaType r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            return r0.create(r1, r2);
        }

        @JvmStatic
        @NotNull
        @Deprecated
        @JvmOverloads
        public final RequestBody create(@Nullable MediaType r8, @NotNull byte[] r9) {
            return create$default(this, r8, r9, 0, 0, 12, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion r0, ByteString r1, MediaType r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            return r0.create(r1, r2);
        }

        @JvmStatic
        @NotNull
        @Deprecated
        @JvmOverloads
        public final RequestBody create(@Nullable MediaType r8, @NotNull byte[] r9, int r10) {
            return create$default(this, r8, r9, r10, 0, 8, null);
        }

        public static /* synthetic */ RequestBody create$default(Companion r0, byte[] r1, MediaType r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r4 = r1.length;
        L12:
            return r0.create(r1, r2, r3, r4);
        }

        @JvmStatic
        @JvmName
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull byte[] r8) {
            return create$default(this, r8, null, 0, 0, 7, null);
        }

        public static /* synthetic */ RequestBody create$default(Companion r0, File r1, MediaType r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            return r0.create(r1, r2);
        }

        @JvmStatic
        @JvmName
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull byte[] r8, @Nullable MediaType r9) {
            return create$default(this, r8, r9, 0, 0, 6, null);
        }

        public static /* synthetic */ RequestBody create$default(Companion r0, MediaType r1, byte[] r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 4) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r5 & 8) == 0) goto L9;
            r4 = r2.length;
        L9:
            return r0.create(r1, r2, r3, r4);
        }

        @JvmStatic
        @JvmName
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull byte[] r8, @Nullable MediaType r9, int r10) {
            return create$default(this, r8, r9, r10, 0, 4, null);
        }

        @JvmStatic
        @JvmName
        @NotNull
        public final RequestBody create(@NotNull String r4, @Nullable MediaType r5) {
            Intrinsics.f(r4, "$this$toRequestBody");
            Charset r0 = Charsets.f354a;
            if (r5 == null) goto L8;
            Charset r1 = MediaType.charset$default(r5, null, 1, null);
            if (r1 != null) goto L7;
            r5 = MediaType.Companion.parse(r5 + "; charset=utf-8");
            goto L8
        L7:
            r0 = r1;
        L8:
            byte[] r6 = r4.getBytes(r0);
            Intrinsics.e(r6, "(this as java.lang.String).getBytes(charset)");
            return create(r6, r5, 0, r6.length);
        }

        @JvmStatic
        @JvmName
        @NotNull
        public final RequestBody create(@NotNull final ByteString r1, @Nullable final MediaType r2) {
            Intrinsics.f(r1, "$this$toRequestBody");
            return new RequestBody$Companion$toRequestBody$1(r1, r2);
        }

        @JvmStatic
        @JvmName
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull final byte[] r7, @Nullable final MediaType r8, final int r9, final int r10) {
            Intrinsics.f(r7, "$this$toRequestBody");
            Util.checkOffsetAndCount(r7.length, r9, r10);
            return new RequestBody$Companion$toRequestBody$2(r7, r8, r10, r9);
        }

        @JvmStatic
        @JvmName
        @NotNull
        public final RequestBody create(@NotNull final File r1, @Nullable final MediaType r2) {
            Intrinsics.f(r1, "$this$asRequestBody");
            return new RequestBody$Companion$asRequestBody$1(r1, r2);
        }

        @Deprecated
        @JvmStatic
        @NotNull
        public final RequestBody create(@Nullable MediaType r2, @NotNull String r3) {
            Intrinsics.f(r3, "content");
            return create(r3, r2);
        }

        @Deprecated
        @JvmStatic
        @NotNull
        public final RequestBody create(@Nullable MediaType r2, @NotNull ByteString r3) {
            Intrinsics.f(r3, "content");
            return create(r3, r2);
        }

        @JvmStatic
        @NotNull
        @Deprecated
        @JvmOverloads
        public final RequestBody create(@Nullable MediaType r2, @NotNull byte[] r3, int r4, int r5) {
            Intrinsics.f(r3, "content");
            return create(r3, r2, r4, r5);
        }

        @Deprecated
        @JvmStatic
        @NotNull
        public final RequestBody create(@Nullable MediaType r2, @NotNull File r3) {
            Intrinsics.f(r3, "file");
            return create(r3, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RequestBody() {
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final RequestBody create(@NotNull File r1, @Nullable MediaType r2) {
        return Companion.create(r1, r2);
    }

    public long contentLength() {
        return -1;
    }

    @Nullable
    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(@NotNull BufferedSink r1);

    @JvmStatic
    @JvmName
    @NotNull
    public static final RequestBody create(@NotNull String r1, @Nullable MediaType r2) {
        return Companion.create(r1, r2);
    }

    @Deprecated
    @JvmStatic
    @NotNull
    public static final RequestBody create(@Nullable MediaType r1, @NotNull File r2) {
        return Companion.create(r1, r2);
    }

    @Deprecated
    @JvmStatic
    @NotNull
    public static final RequestBody create(@Nullable MediaType r1, @NotNull String r2) {
        return Companion.create(r1, r2);
    }

    @Deprecated
    @JvmStatic
    @NotNull
    public static final RequestBody create(@Nullable MediaType r1, @NotNull ByteString r2) {
        return Companion.create(r1, r2);
    }

    @JvmStatic
    @NotNull
    @Deprecated
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType r7, @NotNull byte[] r8) {
        return Companion.create$default(Companion, r7, r8, 0, 0, 12, null);
    }

    @JvmStatic
    @NotNull
    @Deprecated
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType r7, @NotNull byte[] r8, int r9) {
        return Companion.create$default(Companion, r7, r8, r9, 0, 8, null);
    }

    @JvmStatic
    @NotNull
    @Deprecated
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType r1, @NotNull byte[] r2, int r3, int r4) {
        return Companion.create(r1, r2, r3, r4);
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final RequestBody create(@NotNull ByteString r1, @Nullable MediaType r2) {
        return Companion.create(r1, r2);
    }

    @JvmStatic
    @JvmName
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] r7) {
        return Companion.create$default(Companion, r7, null, 0, 0, 7, null);
    }

    @JvmStatic
    @JvmName
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] r7, @Nullable MediaType r8) {
        return Companion.create$default(Companion, r7, r8, 0, 0, 6, null);
    }

    @JvmStatic
    @JvmName
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] r7, @Nullable MediaType r8, int r9) {
        return Companion.create$default(Companion, r7, r8, r9, 0, 4, null);
    }

    @JvmStatic
    @JvmName
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] r1, @Nullable MediaType r2, int r3, int r4) {
        return Companion.create(r1, r2, r3, r4);
    }
}
