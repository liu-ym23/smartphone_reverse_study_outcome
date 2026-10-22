package retrofit2;

import ai.j0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import nu.j;
import nu.k;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.h0;
import okhttp3.i0;
import okhttp3.internal.Util;
import okhttp3.k0;
import okhttp3.n0;
import okhttp3.q0;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;

/* JADX INFO: loaded from: classes3.dex */
final class RequestBuilder {
    private static final char[] HEX_DIGITS = null;
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private static final Pattern PATH_TRAVERSAL = null;
    private final e0 baseUrl;
    private q0 body;
    private h0 contentType;
    private x formBuilder;
    private final boolean hasBody;
    private final b0 headersBuilder;
    private final String method;
    private i0 multipartBuilder;
    private String relativeUrl;
    private final n0 requestBuilder;
    private d0 urlBuilder;

    public static class ContentTypeOverridingRequestBody extends q0 {
        private final h0 contentType;
        private final q0 delegate;

        public ContentTypeOverridingRequestBody(q0 r5, h0 r10) {
            this.delegate = r5;
            this.contentType = r10;
        }

        @Override // okhttp3.q0
        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.q0
        public h0 contentType() {
            return this.contentType;
        }

        @Override // okhttp3.q0
        public void writeTo(k r5) throws IOException {
            this.delegate.writeTo(r5);
        }
    }

    static {
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
    }

    public RequestBuilder(String r5, e0 r10, String r11, c0 r12, h0 r13, boolean r14, boolean r15, boolean r16) {
        this.method = r5;
        this.baseUrl = r10;
        this.relativeUrl = r11;
        this.requestBuilder = new n0();
        this.contentType = r13;
        this.hasBody = r14;
        if (r12 == null) goto L5;
        this.headersBuilder = r12.d();
    L6:
        if (r15 == false) goto L8;
        this.formBuilder = new x();
        return;
    L8:
        if (r16 == false) goto L12;
        i0 r17 = new i0();
        this.multipartBuilder = r17;
        r17.b(k0.f);
        return;
    L12:
        return;
    L5:
        this.headersBuilder = new b0();
        goto L6
    }

    private static String canonicalizeForPath(String r10, boolean r11) {
        int r5 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L27;
        int r13 = r10.codePointAt(r12);
        if (r13 < 32) goto L17;
        if (r13 >= 127) goto L17;
        if (PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(r13) != (-1)) goto L17;
        if (r11 == true) goto L16;
        if (r13 == 47) goto L17;
        if (r13 == 37) goto L17;
    L16:
        r12 = r12 + Character.charCount(r13);
    L17:
        j r14 = new j();
        r14.a0(0, r12, r10);
        canonicalizeForPath(r14, r10, r12, r5, r11);
        return r14.M();
    L27:
        return r10;
    }

    public void addFormField(String r10, String r11, boolean r12) {
        if (r12 == false) goto L5;
        x r13 = this.formBuilder;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "value");
        r13.f20762a.add(uj.a.h(r10, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, 83));
        r13.f20763b.add(uj.a.h(r11, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, 83));
        return;
    L5:
        x r14 = this.formBuilder;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "value");
        r14.f20762a.add(uj.a.h(r10, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, 91));
        r14.f20763b.add(uj.a.h(r11, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, 91));
    }

    public void addHeader(String r5, String r10) {
        if ("Content-Type".equalsIgnoreCase(r5) == true) goto L11;
        this.headersBuilder.a(r5, r10);
        return;
    L11:
        Pattern r11 = h0.e;     // Catch: IllegalArgumentException -> L6
        this.contentType = z.f(r10);     // Catch: IllegalArgumentException -> L6
        return;
    L6:
        e = move-exception;
        throw new IllegalArgumentException(j0.C("Malformed content type: ", r10), e);
    }

    public void addHeaders(c0 r5) {
        b0 r10 = this.headersBuilder;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "headers");
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.c(r5.c(r12), r5.e(r12));
        r12 = r12 + 1;
        goto L3
    }

    public void addPart(c0 r5, q0 r10) {
        this.multipartBuilder.a(r5, r10);
    }

    public void addPathParam(String r5, String r10, boolean r11) {
        if (this.relativeUrl == null) goto L11;
        String r12 = canonicalizeForPath(r10, r11);
        String r13 = this.relativeUrl.replace("{" + r5 + "}", r12);
        if (PATH_TRAVERSAL.matcher(r13).matches() == true) goto L9;
        this.relativeUrl = r13;
        return;
    L9:
        throw new IllegalArgumentException(j0.C("@Path parameters shouldn't perform path traversal ('.' or '..'): ", r10));
    L11:
        throw new AssertionError();
    }

    public void addQueryParam(String r12, String r13, boolean r14) {
        String r5 = this.relativeUrl;
        String r10 = null;
        if (r5 == null) goto L9;
        d0 r11 = this.baseUrl.g(r5);
        this.urlBuilder = r11;
        if (r11 == null) goto L8;
        this.relativeUrl = null;
        goto L9
    L8:
        throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
    L9:
        if (r14 == false) goto L17;
        d0 r15 = this.urlBuilder;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r12, "encodedName");
        if (r15.g != null) goto L13;
        r15.g = new ArrayList();
    L13:
        ArrayList r16 = r15.g;
        Intrinsics.checkNotNull(r16);
        r16.add(uj.a.h(r12, 0, 0, " \"'<>#&=", true, false, true, false, 211));
        ArrayList r17 = r15.g;
        Intrinsics.checkNotNull(r17);
        if (r13 == null) goto L16;
        r10 = uj.a.h(r13, 0, 0, " \"'<>#&=", true, false, true, false, 211);
    L16:
        r17.add(r10);
        return;
    L17:
        d0 r18 = this.urlBuilder;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r12, "name");
        if (r18.g != null) goto L20;
        r18.g = new ArrayList();
    L20:
        ArrayList r19 = r18.g;
        Intrinsics.checkNotNull(r19);
        r19.add(uj.a.h(r12, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, 219));
        ArrayList r110 = r18.g;
        Intrinsics.checkNotNull(r110);
        if (r13 == null) goto L23;
        r10 = uj.a.h(r13, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, 219);
    L23:
        r110.add(r10);
    }

    public <T> void addTag(Class<T> r5, T r10) {
        this.requestBuilder.f(r5, r10);
    }

    public n0 get() {
        d0 r5 = this.urlBuilder;
        if (r5 == null) goto L5;
        e0 r10 = r5.a();
    L7:
        q0 r11 = this.body;
        if (r11 != null) goto L22;
        x r12 = this.formBuilder;
        if (r12 == null) goto L12;
        r11 = new y(r12.f20762a, r12.f20763b);
        goto L22
    L12:
        i0 r13 = this.multipartBuilder;
        if (r13 == null) goto L20;
        ArrayList r14 = r13.f20662c;
        if (r14.isEmpty() == true) goto L18;
        r11 = new k0(r13.f20660a, r13.f20661b, Util.toImmutableList(r14));
        goto L22
    L18:
        throw new IllegalStateException("Multipart body must have at least one part.");
    L20:
        if (this.hasBody == false) goto L22;
        r11 = q0.create(null, new byte[0]);
    L22:
        h0 r15 = this.contentType;
        if (r15 == null) goto L27;
        if (r11 == null) goto L26;
        r11 = new ContentTypeOverridingRequestBody(r11, r15);
        goto L27
    L26:
        this.headersBuilder.a("Content-Type", r15.f20657a);
    L27:
        n0 r16 = this.requestBuilder;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r10, "url");
        r16.f20713a = r10;
        c0 r17 = this.headersBuilder.d();
        Intrinsics.checkNotNullParameter(r17, "headers");
        r16.f20715c = r17.d();
        r16.d(this.method, r11);
        return r16;
    L5:
        r10 = this.baseUrl.j(this.relativeUrl);
        if (r10 != null) goto L7;
        throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
    }

    public void setBody(q0 r5) {
        this.body = r5;
    }

    public void setRelativeUrl(Object r5) {
        this.relativeUrl = r5.toString();
    }

    public void addPart(okhttp3.j0 r5) {
        i0 r10 = this.multipartBuilder;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "part");
        r10.f20662c.add(r5);
    }

    private static void canonicalizeForPath(j r10, String r11, int r12, int r13, boolean r14) {
        j r5 = null;
    L3:
        if (r12 >= r13) goto L34;
        int r15 = r11.codePointAt(r12);
        if (r14 == false) goto L16;
        if (r15 == 9) goto L33;
        if (r15 == 10) goto L33;
        if (r15 == 12) goto L33;
        if (r15 != 13) goto L16;
    L33:
        r12 = r12 + Character.charCount(r15);
    L16:
        if (r15 >= 32) goto L18;
    L27:
        if (r5 != null) goto L29;
        r5 = new j();
    L29:
        r5.c0(r15);
    L31:
        if (r5.y() == true) goto L33;
        byte r16 = r5.readByte();
        int r17 = r16 & UByte.MAX_VALUE;
        r10.T(37);
        char[] r18 = HEX_DIGITS;
        r10.T(r18[(r17 >> 4) & 15]);
        r10.T(r18[r16 & 15]);
        goto L31
    L18:
        if (r15 >= 127) goto L27;
        if (PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(r15) != (-1)) goto L27;
        if (r14 == false) goto L23;
    L26:
        r10.c0(r15);
        goto L33
    L23:
        if (r15 == 47) goto L27;
        if (r15 != 37) goto L26;
    }
}
