package okhttp3;

import com.android.settings.search.IndexDatabaseHelper;
import com.bytedance.apm.constant.PerfConsts;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: compiled from: MultipartBody.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0003\"#$B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\b\u0015J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0012J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\b\u0018J\r\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\b\u0019J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u001aJ\u001a\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0014¨\u0006%"}, d2 = {"Lokhttp3/MultipartBody;", "Lokhttp3/RequestBody;", "boundaryByteString", "Lokio/ByteString;", "type", "Lokhttp3/MediaType;", "parts", "", "Lokhttp3/MultipartBody$Part;", "(Lokio/ByteString;Lokhttp3/MediaType;Ljava/util/List;)V", "boundary", "", "()Ljava/lang/String;", "contentLength", "", "contentType", "()Ljava/util/List;", PerfConsts.PERF_DISK_FILE_SIZE, "", "()I", "()Lokhttp3/MediaType;", "-deprecated_boundary", "part", "index", "-deprecated_parts", "-deprecated_size", "-deprecated_type", "writeOrCountBytes", "sink", "Lokio/BufferedSink;", "countBytes", "", "writeTo", "", "Builder", "Companion", "Part", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE = null;
    private static final byte[] COLONSPACE = null;
    private static final byte[] CRLF = null;
    public static final Companion Companion = null;
    private static final byte[] DASHDASH = null;
    public static final MediaType DIGEST = null;
    public static final MediaType FORM = null;
    public static final MediaType MIXED = null;
    public static final MediaType PARALLEL = null;
    private final ByteString boundaryByteString;
    private long contentLength;
    private final MediaType contentType;
    private final List<Part> parts;
    private final MediaType type;

    /* JADX INFO: compiled from: MultipartBody.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003J \u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokhttp3/MultipartBody$Builder;", "", "boundary", "", "(Ljava/lang/String;)V", "Lokio/ByteString;", "parts", "", "Lokhttp3/MultipartBody$Part;", "type", "Lokhttp3/MediaType;", "addFormDataPart", "name", "value", "filename", "body", "Lokhttp3/RequestBody;", "addPart", "headers", "Lokhttp3/Headers;", "part", IndexDatabaseHelper.MetaColumns.BUILD, "Lokhttp3/MultipartBody;", "setType", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private final ByteString boundary;
        private final List<Part> parts;
        private MediaType type;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public Builder(String r2) {
            Intrinsics.checkNotNullParameter(r2, "boundary");
            this.boundary = ByteString.Companion.encodeUtf8(r2);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        public /* synthetic */ Builder(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(r1, "randomUUID().toString()");
        L5:
            this(r1);
        }

        public final Builder setType(MediaType r3) {
            Intrinsics.checkNotNullParameter(r3, "type");
            if (Intrinsics.areEqual(r3.type(), "multipart") == false) goto L7;
            this.type = r3;
            return this;
        L7:
            throw new IllegalArgumentException(Intrinsics.stringPlus("multipart != ", r3).toString());
        }

        public final Builder addPart(RequestBody r2) {
            Intrinsics.checkNotNullParameter(r2, "body");
            addPart(Part.Companion.create(r2));
            return this;
        }

        public final Builder addPart(Headers r2, RequestBody r3) {
            Intrinsics.checkNotNullParameter(r3, "body");
            addPart(Part.Companion.create(r2, r3));
            return this;
        }

        public final Builder addFormDataPart(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "value");
            addPart(Part.Companion.createFormData(r2, r3));
            return this;
        }

        public final Builder addFormDataPart(String r2, String r3, RequestBody r4) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r4, "body");
            addPart(Part.Companion.createFormData(r2, r3, r4));
            return this;
        }

        public final Builder addPart(Part r2) {
            Intrinsics.checkNotNullParameter(r2, "part");
            this.parts.add(r2);
            return this;
        }

        public final MultipartBody build() {
            if ((!this.parts.isEmpty()) == false) goto L7;
            return new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
        L7:
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }
    }

    /* JADX INFO: compiled from: MultipartBody.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\r\u001a\u00020\u000e*\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/MultipartBody$Companion;", "", "()V", "ALTERNATIVE", "Lokhttp3/MediaType;", "COLONSPACE", "", "CRLF", "DASHDASH", "DIGEST", "FORM", "MIXED", "PARALLEL", "appendQuotedString", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "key", "", "appendQuotedString$okhttp", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final void appendQuotedString$okhttp(StringBuilder r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "<this>");
            Intrinsics.checkNotNullParameter(r6, "key");
            r5.append('\"');
            int r0 = r6.length();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L14;
            int r2 = r1 + 1;
            char r3 = r6.charAt(r1);
            if (r3 != '\n') goto L8;
            r5.append("%0A");
        L13:
            r1 = r2;
            goto L3
        L8:
            if (r3 != '\r') goto L10;
            r5.append("%0D");
            goto L13
        L10:
            if (r3 != '\"') goto L12;
            r5.append("%22");
            goto L13
        L12:
            r5.append(r3);
            goto L13
        L14:
            r5.append('\"');
        }
    }

    /* JADX INFO: compiled from: MultipartBody.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\tJ\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b\nR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\b¨\u0006\f"}, d2 = {"Lokhttp3/MultipartBody$Part;", "", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", "(Lokhttp3/Headers;Lokhttp3/RequestBody;)V", "()Lokhttp3/RequestBody;", "()Lokhttp3/Headers;", "-deprecated_body", "-deprecated_headers", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Part {
        public static final Companion Companion = null;
        private final RequestBody body;
        private final Headers headers;

        /* JADX INFO: compiled from: MultipartBody.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\u000e"}, d2 = {"Lokhttp3/MultipartBody$Part$Companion;", "", "()V", "create", "Lokhttp3/MultipartBody$Part;", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", "createFormData", "name", "", "value", "filename", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Part create(RequestBody r2) {
                Intrinsics.checkNotNullParameter(r2, "body");
                return create(null, r2);
            }

            @JvmStatic
            public final Part create(Headers r4, RequestBody r5) {
                Intrinsics.checkNotNullParameter(r5, "body");
                DefaultConstructorMarker r3 = null;
                if (r4 != null) goto L5;
                String r0 = null;
            L6:
                boolean r1 = true;
                if (r0 != null) goto L9;
                boolean r2 = true;
            L10:
                if (r2 == false) goto L23;
                if (r4 != null) goto L13;
                String r6 = null;
            L14:
                if (r6 == null) goto L17;
                r1 = false;
            L17:
                if (r1 == false) goto L21;
                return new Part(r4, r5, r3);
            L21:
                throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
            L13:
                r6 = r4.get("Content-Length");
                goto L14
            L23:
                throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
            L9:
                r2 = false;
                goto L10
            L5:
                r0 = r4.get("Content-Type");
                goto L6
            }

            @JvmStatic
            public final Part createFormData(String r4, String r5) {
                Intrinsics.checkNotNullParameter(r4, "name");
                Intrinsics.checkNotNullParameter(r5, "value");
                return createFormData(r4, null, RequestBody.Companion.create$default(RequestBody.Companion, r5, null, 1, null));
            }

            @JvmStatic
            public final Part createFormData(String r3, String r4, RequestBody r5) {
                Intrinsics.checkNotNullParameter(r3, "name");
                Intrinsics.checkNotNullParameter(r5, "body");
                StringBuilder r0 = new StringBuilder();
                r0.append("form-data; name=");
                MultipartBody.Companion.appendQuotedString$okhttp(r0, r3);
                if (r4 == null) goto L5;
                r0.append("; filename=");
                MultipartBody.Companion.appendQuotedString$okhttp(r0, r4);
            L5:
                String r6 = r0.toString();
                Intrinsics.checkNotNullExpressionValue(r6, "StringBuilder().apply(builderAction).toString()");
                return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", r6).build(), r5);
            }
        }

        static {
            Companion = new Companion(null);
        }

        public /* synthetic */ Part(Headers r1, RequestBody r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        @JvmStatic
        public static final Part create(Headers r1, RequestBody r2) {
            return Companion.create(r1, r2);
        }

        @JvmStatic
        public static final Part create(RequestBody r1) {
            return Companion.create(r1);
        }

        @JvmStatic
        public static final Part createFormData(String r1, String r2) {
            return Companion.createFormData(r1, r2);
        }

        @JvmStatic
        public static final Part createFormData(String r1, String r2, RequestBody r3) {
            return Companion.createFormData(r1, r2, r3);
        }

        private Part(Headers r1, RequestBody r2) {
            this.headers = r1;
            this.body = r2;
        }

        public final Headers headers() {
            return this.headers;
        }

        public final RequestBody body() {
            return this.body;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "headers", imports = {}))
        /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
        public final Headers m3170deprecated_headers() {
            return this.headers;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
        /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
        public final RequestBody m3169deprecated_body() {
            return this.body;
        }
    }

    public final MediaType type() {
        return this.type;
    }

    public final List<Part> parts() {
        return this.parts;
    }

    public MultipartBody(ByteString r2, MediaType r3, List<Part> r4) {
        Intrinsics.checkNotNullParameter(r2, "boundaryByteString");
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "parts");
        this.boundaryByteString = r2;
        this.type = r3;
        this.parts = r4;
        this.contentType = MediaType.Companion.get(r3 + "; boundary=" + boundary());
        this.contentLength = -1;
    }

    public final String boundary() {
        return this.boundaryByteString.utf8();
    }

    public final int size() {
        return this.parts.size();
    }

    public final Part part(int r1) {
        return this.parts.get(r1);
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.contentType;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "type", imports = {}))
    /* JADX INFO: renamed from: -deprecated_type, reason: not valid java name */
    public final MediaType m3168deprecated_type() {
        return this.type;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "boundary", imports = {}))
    /* JADX INFO: renamed from: -deprecated_boundary, reason: not valid java name */
    public final String m3165deprecated_boundary() {
        return boundary();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = PerfConsts.PERF_DISK_FILE_SIZE, imports = {}))
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m3167deprecated_size() {
        return size();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "parts", imports = {}))
    /* JADX INFO: renamed from: -deprecated_parts, reason: not valid java name */
    public final List<Part> m3166deprecated_parts() {
        return this.parts;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        long r0 = this.contentLength;
        if (r0 != (-1)) goto L6;
        long r1 = writeOrCountBytes(null, true);
        this.contentLength = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "sink");
        writeOrCountBytes(r2, false);
    }

    private final long writeOrCountBytes(BufferedSink r16, boolean r17) throws IOException {
        if (r17 == false) goto L5;
        Buffer r1 = new Buffer();
        Buffer r2 = r1;
    L6:
        int r3 = this.parts.size();
        long r5 = 0;
        int r7 = 0;
    L7:
        if (r7 >= r3) goto L27;
        int r8 = r7 + 1;
        Part r9 = this.parts.get(r7);
        Headers r10 = r9.headers();
        RequestBody r11 = r9.body();
        Intrinsics.checkNotNull(r2);
        r2.write(DASHDASH);
        r2.write(this.boundaryByteString);
        r2.write(CRLF);
        if (r10 == null) goto L13;
        int r12 = r10.size();
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L13;
        r2.writeUtf8(r10.name(r13)).write(COLONSPACE).writeUtf8(r10.value(r13)).write(CRLF);
        r13 = r13 + 1;
    L13:
        MediaType r14 = r11.contentType();
        if (r14 == null) goto L16;
        r2.writeUtf8("Content-Type: ").writeUtf8(r14.toString()).write(CRLF);
    L16:
        long r15 = r11.contentLength();
        if (r15 == (-1)) goto L19;
        r2.writeUtf8("Content-Length: ").writeDecimalLong(r15).write(CRLF);
    L22:
        byte[] r18 = CRLF;
        r2.write(r18);
        if (r17 == false) goto L25;
        r5 = r5 + r15;
    L26:
        r2.write(r18);
        r7 = r8;
        goto L7
    L25:
        r11.writeTo(r2);
        goto L26
    L19:
        if (r17 == false) goto L22;
        Intrinsics.checkNotNull(r1);
        r1.clear();
        return -1;
    L27:
        Intrinsics.checkNotNull(r2);
        byte[] r4 = DASHDASH;
        r2.write(r4);
        r2.write(this.boundaryByteString);
        r2.write(r4);
        r2.write(CRLF);
        if (r17 == false) goto L36;
        Intrinsics.checkNotNull(r1);
        long r6 = r5 + r1.size();
        r1.clear();
        return r6;
    L36:
        return r5;
    L5:
        r1 = null;
        r2 = r16;
        goto L6
    }

    static {
        Companion = new Companion(null);
        MIXED = MediaType.Companion.get("multipart/mixed");
        ALTERNATIVE = MediaType.Companion.get("multipart/alternative");
        DIGEST = MediaType.Companion.get("multipart/digest");
        PARALLEL = MediaType.Companion.get("multipart/parallel");
        FORM = MediaType.Companion.get("multipart/form-data");
        COLONSPACE = new byte[]{58, 32};
        CRLF = new byte[]{13, 10};
        DASHDASH = new byte[]{45, 45};
    }
}
