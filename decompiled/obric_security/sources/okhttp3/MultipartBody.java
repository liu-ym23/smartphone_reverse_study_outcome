package okhttp3;

import com.qq.taf.jce.JceStruct;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE = null;
    private static final byte[] COLONSPACE = null;
    private static final byte[] CRLF = null;
    private static final byte[] DASHDASH = null;
    public static final MediaType DIGEST = null;
    public static final MediaType FORM = null;
    public static final MediaType MIXED = null;
    public static final MediaType PARALLEL = null;
    private final ByteString boundary;
    private long contentLength;
    private final MediaType contentType;
    private final MediaType originalType;
    private final List<Part> parts;

    public static final class Builder {
        private final ByteString boundary;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder(String r2) {
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
            this.boundary = ByteString.encodeUtf8(r2);
        }

        public Builder setType(MediaType r3) {
            if (r3 == null) goto L10;
            if (r3.type().equals("multipart") == false) goto L8;
            this.type = r3;
            return this;
        L8:
            throw new IllegalArgumentException("multipart != " + r3);
        L10:
            throw new NullPointerException("type == null");
        }

        public Builder addPart(RequestBody r1) {
            return addPart(Part.create(r1));
        }

        public Builder addPart(@Nullable Headers r1, RequestBody r2) {
            return addPart(Part.create(r1, r2));
        }

        public Builder addFormDataPart(String r1, String r2) {
            return addPart(Part.createFormData(r1, r2));
        }

        public Builder addFormDataPart(String r1, @Nullable String r2, RequestBody r3) {
            return addPart(Part.createFormData(r1, r2, r3));
        }

        public Builder addPart(Part r2) {
            if (r2 == null) goto L6;
            this.parts.add(r2);
            return this;
        L6:
            throw new NullPointerException("part == null");
        }

        public MultipartBody build() {
            if (this.parts.isEmpty() == true) goto L7;
            return new MultipartBody(this.boundary, this.type, this.parts);
        L7:
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    public static final class Part {
        final RequestBody body;

        @Nullable
        final Headers headers;

        public static Part create(RequestBody r1) {
            return create(null, r1);
        }

        public static Part create(@Nullable Headers r1, RequestBody r2) {
            if (r2 == null) goto L18;
            if (r1 != null) goto L5;
        L9:
            if (r1 == null) goto L16;
            if (r1.get(HTTP.CONTENT_LEN) == null) goto L16;
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        L16:
            return new Part(r1, r2);
        L5:
            if (r1.get("Content-Type") == null) goto L9;
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        L18:
            throw new NullPointerException("body == null");
        }

        public static Part createFormData(String r1, String r2) {
            return createFormData(r1, null, RequestBody.create(null, r2));
        }

        public static Part createFormData(String r2, @Nullable String r3, RequestBody r4) {
            if (r2 == null) goto L9;
            StringBuilder r0 = new StringBuilder("form-data; name=");
            MultipartBody.appendQuotedString(r0, r2);
            if (r3 == null) goto L7;
            r0.append("; filename=");
            MultipartBody.appendQuotedString(r0, r3);
        L7:
            return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", r0.toString()).build(), r4);
        L9:
            throw new NullPointerException("name == null");
        }

        private Part(@Nullable Headers r1, RequestBody r2) {
            this.headers = r1;
            this.body = r2;
        }

        @Nullable
        public Headers headers() {
            return this.headers;
        }

        public RequestBody body() {
            return this.body;
        }
    }

    static {
        MIXED = MediaType.get("multipart/mixed");
        ALTERNATIVE = MediaType.get("multipart/alternative");
        DIGEST = MediaType.get("multipart/digest");
        PARALLEL = MediaType.get("multipart/parallel");
        FORM = MediaType.get("multipart/form-data");
        COLONSPACE = new byte[]{58, 32};
        CRLF = new byte[]{JceStruct.SIMPLE_LIST, 10};
        DASHDASH = new byte[]{45, 45};
    }

    MultipartBody(ByteString r3, MediaType r4, List<Part> r5) {
        this.contentLength = -1;
        this.boundary = r3;
        this.originalType = r4;
        this.contentType = MediaType.get(r4 + "; boundary=" + r3.utf8());
        this.parts = Util.immutableList(r5);
    }

    public MediaType type() {
        return this.originalType;
    }

    public String boundary() {
        return this.boundary.utf8();
    }

    public int size() {
        return this.parts.size();
    }

    public List<Part> parts() {
        return this.parts;
    }

    public Part part(int r1) {
        return this.parts.get(r1);
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.contentType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        long r0 = this.contentLength;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        long r1 = writeOrCountBytes(null, true);
        this.contentLength = r1;
        return r1;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink r2) throws IOException {
        writeOrCountBytes(r2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long writeOrCountBytes(@Nullable BufferedSink r13, boolean r14) throws IOException {
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
        Headers r7 = r6.headers;
        RequestBody r8 = r6.body;
        r13.write(DASHDASH);
        r13.write(this.boundary);
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
        r0.clear();
        return -1;
    L26:
        byte[] r2 = DASHDASH;
        r13.write(r2);
        r13.write(this.boundary);
        r13.write(r2);
        r13.write(CRLF);
        if (r14 == false) goto L35;
        long r4 = r3 + r0.size();
        r0.clear();
        return r4;
    L35:
        return r3;
    L4:
        r0 = 0;
        goto L5
    }

    static StringBuilder appendQuotedString(StringBuilder r5, String r6) {
        r5.append(Typography.quote);
        int r1 = r6.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L14;
        char r3 = r6.charAt(r2);
        if (r3 != '\n') goto L7;
        r5.append("%0A");
    L13:
        r2 = r2 + 1;
        goto L3
    L7:
        if (r3 == '\r') goto L11;
        if (r3 == '\"') goto L10;
        r5.append(r3);
        goto L13
    L10:
        r5.append("%22");
        goto L13
    L11:
        r5.append("%0D");
        goto L13
    L14:
        r5.append(Typography.quote);
        return r5;
    }
}
