package okhttp3;

import com.ss.android.http.legacy.protocol.HTTP;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MultipartBody extends RequestBody {

    @JvmField
    @NotNull
    public static final MediaType ALTERNATIVE = null;
    private static final byte[] COLONSPACE = null;
    private static final byte[] CRLF = null;
    public static final Companion Companion = null;
    private static final byte[] DASHDASH = null;

    @JvmField
    @NotNull
    public static final MediaType DIGEST = null;

    @JvmField
    @NotNull
    public static final MediaType FORM = null;

    @JvmField
    @NotNull
    public static final MediaType MIXED = null;

    @JvmField
    @NotNull
    public static final MediaType PARALLEL = null;
    private final ByteString boundaryByteString;
    private long contentLength;
    private final MediaType contentType;

    @NotNull
    private final List<Part> parts;

    @NotNull
    private final MediaType type;

    @Metadata
    public static final class Builder {
        private final ByteString boundary;
        private final List<Part> parts;
        private MediaType type;

        /* JADX WARN: Multi-variable type inference failed */
        @JvmOverloads
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @NotNull
        public final Builder addFormDataPart(@NotNull String r2, @NotNull String r3) {
            Intrinsics.f(r2, "name");
            Intrinsics.f(r3, "value");
            addPart(Part.Companion.createFormData(r2, r3));
            return this;
        }

        @NotNull
        public final Builder addPart(@NotNull RequestBody r2) {
            Intrinsics.f(r2, "body");
            addPart(Part.Companion.create(r2));
            return this;
        }

        @NotNull
        public final MultipartBody build() {
            if ((!this.parts.isEmpty()) == false) goto L7;
            return new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
        L7:
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        @NotNull
        public final Builder setType(@NotNull MediaType r3) {
            Intrinsics.f(r3, "type");
            if (Intrinsics.a(r3.type(), "multipart") == false) goto L7;
            this.type = r3;
            return this;
        L7:
            throw new IllegalArgumentException(("multipart != " + r3).toString());
        }

        @JvmOverloads
        public Builder(@NotNull String r2) {
            Intrinsics.f(r2, "boundary");
            this.boundary = ByteString.Companion.encodeUtf8(r2);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        @NotNull
        public final Builder addFormDataPart(@NotNull String r2, @Nullable String r3, @NotNull RequestBody r4) {
            Intrinsics.f(r2, "name");
            Intrinsics.f(r4, "body");
            addPart(Part.Companion.createFormData(r2, r3, r4));
            return this;
        }

        @NotNull
        public final Builder addPart(@Nullable Headers r2, @NotNull RequestBody r3) {
            Intrinsics.f(r3, "body");
            addPart(Part.Companion.create(r2, r3));
            return this;
        }

        @NotNull
        public final Builder addPart(@NotNull Part r2) {
            Intrinsics.f(r2, "part");
            this.parts.add(r2);
            return this;
        }

        public /* synthetic */ Builder(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = UUID.randomUUID().toString();
            Intrinsics.e(r1, "UUID.randomUUID().toString()");
        L5:
            this(r1);
        }
    }

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final void appendQuotedString$okhttp(@NotNull StringBuilder r5, @NotNull String r6) {
            Intrinsics.f(r5, "$this$appendQuotedString");
            Intrinsics.f(r6, "key");
            r5.append('\"');
            int r0 = r6.length();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L14;
            char r2 = r6.charAt(r1);
            if (r2 != '\n') goto L7;
            r5.append("%0A");
        L13:
            r1 = r1 + 1;
            goto L3
        L7:
            if (r2 == '\r') goto L11;
            if (r2 == '\"') goto L10;
            r5.append(r2);
            goto L13
        L10:
            r5.append("%22");
            goto L13
        L11:
            r5.append("%0D");
            goto L13
        L14:
            r5.append('\"');
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public static final class Part {
        public static final Companion Companion = null;

        @NotNull
        private final RequestBody body;

        @Nullable
        private final Headers headers;

        @Metadata
        public static final class Companion {
            private Companion() {
            }

            @JvmStatic
            @NotNull
            public final Part create(@NotNull RequestBody r2) {
                Intrinsics.f(r2, "body");
                return create(null, r2);
            }

            @JvmStatic
            @NotNull
            public final Part createFormData(@NotNull String r4, @NotNull String r5) {
                Intrinsics.f(r4, "name");
                Intrinsics.f(r5, "value");
                return createFormData(r4, null, RequestBody.Companion.create$default(RequestBody.Companion, r5, null, 1, null));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            @JvmStatic
            @NotNull
            public final Part create(@Nullable Headers r4, @NotNull RequestBody r5) {
                Intrinsics.f(r5, "body");
                DefaultConstructorMarker r3 = null;
                if (r4 == null) goto L5;
                String r0 = r4.get("Content-Type");
            L6:
                boolean r1 = false;
                if (r0 != null) goto L9;
                boolean r2 = true;
            L10:
                if (r2 == false) goto L22;
                if (r4 == null) goto L13;
                String r6 = r4.get(HTTP.CONTENT_LEN);
            L14:
                if (r6 != null) goto L16;
                r1 = true;
            L16:
                if (r1 == false) goto L20;
                return new Part(r4, r5, r3);
            L20:
                throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
            L13:
                r6 = null;
                goto L14
            L22:
                throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
            L9:
                r2 = false;
                goto L10
            L5:
                r0 = null;
                goto L6
            }

            @JvmStatic
            @NotNull
            public final Part createFormData(@NotNull String r3, @Nullable String r4, @NotNull RequestBody r5) {
                Intrinsics.f(r3, "name");
                Intrinsics.f(r5, "body");
                StringBuilder r0 = new StringBuilder();
                r0.append("form-data; name=");
                Companion r1 = MultipartBody.Companion;
                r1.appendQuotedString$okhttp(r0, r3);
                if (r4 == null) goto L5;
                r0.append("; filename=");
                r1.appendQuotedString$okhttp(r0, r4);
            L5:
                String r6 = r0.toString();
                Intrinsics.e(r6, "StringBuilder().apply(builderAction).toString()");
                return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", r6).build(), r5);
            }
        }

        static {
            Companion = new Companion(null);
        }

        private Part(Headers r1, RequestBody r2) {
            this.headers = r1;
            this.body = r2;
        }

        @JvmStatic
        @NotNull
        public static final Part create(@Nullable Headers r1, @NotNull RequestBody r2) {
            return Companion.create(r1, r2);
        }

        @JvmStatic
        @NotNull
        public static final Part createFormData(@NotNull String r1, @NotNull String r2) {
            return Companion.createFormData(r1, r2);
        }

        @Deprecated
        @JvmName
        @NotNull
        /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
        public final RequestBody m127deprecated_body() {
            return this.body;
        }

        @Deprecated
        @JvmName
        @Nullable
        /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
        public final Headers m128deprecated_headers() {
            return this.headers;
        }

        @JvmName
        @NotNull
        public final RequestBody body() {
            return this.body;
        }

        @JvmName
        @Nullable
        public final Headers headers() {
            return this.headers;
        }

        public /* synthetic */ Part(Headers r1, RequestBody r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        @JvmStatic
        @NotNull
        public static final Part create(@NotNull RequestBody r1) {
            return Companion.create(r1);
        }

        @JvmStatic
        @NotNull
        public static final Part createFormData(@NotNull String r1, @Nullable String r2, @NotNull RequestBody r3) {
            return Companion.createFormData(r1, r2, r3);
        }
    }

    static {
        Companion = new Companion(null);
        MediaType.Companion r0 = MediaType.Companion;
        MIXED = r0.get("multipart/mixed");
        ALTERNATIVE = r0.get("multipart/alternative");
        DIGEST = r0.get("multipart/digest");
        PARALLEL = r0.get("multipart/parallel");
        FORM = r0.get("multipart/form-data");
        COLONSPACE = new byte[]{(byte) 58, (byte) 32};
        CRLF = new byte[]{(byte) 13, (byte) 10};
        byte r1 = (byte) 45;
        DASHDASH = new byte[]{r1, r1};
    }

    public MultipartBody(@NotNull ByteString r2, @NotNull MediaType r3, @NotNull List<Part> r4) {
        Intrinsics.f(r2, "boundaryByteString");
        Intrinsics.f(r3, "type");
        Intrinsics.f(r4, "parts");
        this.boundaryByteString = r2;
        this.type = r3;
        this.parts = r4;
        this.contentType = MediaType.Companion.get(r3 + "; boundary=" + boundary());
        this.contentLength = -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long writeOrCountBytes(BufferedSink r13, boolean r14) {
        if (r14 == false) goto L4;
        r13 = new Buffer();
        Buffer r0 = r13;
    L5:
        int r1 = this.parts.size();
        long r3 = 0;
        int r5 = 0;
    L6:
        if (r5 >= r1) goto L26;
        Part r6 = this.parts.get(r5);
        Headers r7 = r6.headers();
        RequestBody r8 = r6.body();
        Intrinsics.c(r13);
        r13.write(DASHDASH);
        r13.write(this.boundaryByteString);
        r13.write(CRLF);
        if (r7 == null) goto L12;
        int r9 = r7.size();
        int r10 = 0;
    L10:
        if (r10 >= r9) goto L12;
        r13.writeUtf8(r7.name(r10)).write(COLONSPACE).writeUtf8(r7.value(r10)).write(CRLF);
        r10 = r10 + 1;
    L12:
        MediaType r11 = r8.contentType();
        if (r11 == null) goto L15;
        r13.writeUtf8("Content-Type: ").writeUtf8(r11.toString()).write(CRLF);
    L15:
        long r12 = r8.contentLength();
        if (r12 == (-1)) goto L18;
        r13.writeUtf8("Content-Length: ").writeDecimalLong(r12).write(CRLF);
    L21:
        byte[] r15 = CRLF;
        r13.write(r15);
        if (r14 == false) goto L24;
        r3 = r3 + r12;
    L25:
        r13.write(r15);
        r5 = r5 + 1;
        goto L6
    L24:
        r8.writeTo(r13);
        goto L25
    L18:
        if (r14 == false) goto L21;
        Intrinsics.c(r0);
        r0.clear();
        return -1;
    L26:
        Intrinsics.c(r13);
        byte[] r2 = DASHDASH;
        r13.write(r2);
        r13.write(this.boundaryByteString);
        r13.write(r2);
        r13.write(CRLF);
        if (r14 == false) goto L35;
        Intrinsics.c(r0);
        long r4 = r3 + r0.size();
        r0.clear();
        return r4;
    L35:
        return r3;
    L4:
        r0 = 0;
        goto L5
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_boundary, reason: not valid java name */
    public final String m123deprecated_boundary() {
        return boundary();
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_parts, reason: not valid java name */
    public final List<Part> m124deprecated_parts() {
        return this.parts;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m125deprecated_size() {
        return size();
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_type, reason: not valid java name */
    public final MediaType m126deprecated_type() {
        return this.type;
    }

    @JvmName
    @NotNull
    public final String boundary() {
        return this.boundaryByteString.utf8();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        long r0 = this.contentLength;
        if (r0 != (-1)) goto L6;
        long r1 = writeOrCountBytes(null, true);
        this.contentLength = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // okhttp3.RequestBody
    @NotNull
    public MediaType contentType() {
        return this.contentType;
    }

    @NotNull
    public final Part part(int r1) {
        return this.parts.get(r1);
    }

    @JvmName
    @NotNull
    public final List<Part> parts() {
        return this.parts;
    }

    @JvmName
    public final int size() {
        return this.parts.size();
    }

    @JvmName
    @NotNull
    public final MediaType type() {
        return this.type;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(@NotNull BufferedSink r2) {
        Intrinsics.f(r2, "sink");
        writeOrCountBytes(r2, false);
    }
}
