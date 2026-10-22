package com.bytedance.retrofit2;

import a.a;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.mime.AbsTypedOutput;
import com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes.dex */
public final class RequestBuilder {
    private boolean addCommonParam;

    @Nullable
    private String apiUrl;

    @Nullable
    private TypedOutput body;
    private int commonParamLevel;
    private String contentTypeHeader;
    private final boolean enableRecordFormFields;
    private Object extraInfo;
    private final FormUrlEncodedTypedOutput formBody;
    private final boolean hasBody;

    @Nullable
    private List<Header> headers;
    private int maxLength;
    private String method;

    @Nullable
    private final MultipartTypedOutput multipartBody;

    @Nullable
    private final MultipartBody.Builder multipartBuilder;
    private int priorityLevel;

    @Nullable
    private String queryObjectParams;

    @Nullable
    private StringBuilder queryParams;

    @Nullable
    private String relativeUrl;

    @Nullable
    private RequestBody requestBody;
    private final int requestPriorityLevel;
    private boolean responseStreaming;
    private final Endpoint server;
    private final String serviceType;
    private final Map<Class<?>, Object> tags;
    private boolean useRequestBody;

    public static class ContentTypeOverridingRequestBody extends RequestBody {
        private final String contentType;
        private final RequestBody delegate;

        public ContentTypeOverridingRequestBody(RequestBody r1, String r2) {
            this.delegate = r1;
            this.contentType = r2;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return MediaType.parse(this.contentType);
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink r1) {
            this.delegate.writeTo(r1);
        }
    }

    public static class MimeOverridingTypedOutput extends AbsTypedOutput {
        private final TypedOutput delegate;
        private final String mimeType;

        public MimeOverridingTypedOutput(TypedOutput r1, String r2) {
            this.delegate = r1;
            this.mimeType = r2;
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
        public String bodyCompressType() {
            TypedOutput r1 = this.delegate;
            if ((r1 instanceof AbsTypedOutput) == true) goto L5;
            return null;
        L5:
            return ((AbsTypedOutput) r1).bodyCompressType();
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
        public TTRequestCompressManager.CompressData compressRequestBody(String r2, String r3, boolean r4) {
            TypedOutput r1 = this.delegate;
            if ((r1 instanceof AbsTypedOutput) == true) goto L5;
            return null;
        L5:
            return ((AbsTypedOutput) r1).compressRequestBody(r2, r3, r4);
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public String fileName() {
            return this.delegate.fileName();
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
        public byte[] getOriginBody() {
            TypedOutput r1 = this.delegate;
            if ((r1 instanceof AbsTypedOutput) == true) goto L5;
            return null;
        L5:
            return ((AbsTypedOutput) r1).getOriginBody();
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
        public boolean interceptRequestBody() {
            TypedOutput r1 = this.delegate;
            if ((r1 instanceof AbsTypedOutput) == true) goto L5;
            return false;
        L5:
            return ((AbsTypedOutput) r1).interceptRequestBody();
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public long length() {
            return this.delegate.length();
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public String md5Stub() {
            this.mBodyMd5Stub = this.delegate.md5Stub();
            return this.mBodyMd5Stub;
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public String mimeType() {
            return this.mimeType;
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public void writeTo(OutputStream r1) {
            this.delegate.writeTo(r1);
        }
    }

    public RequestBuilder(String r5, Endpoint r6, @Nullable String r7, @Nullable List<Header> r8, String r9, int r10, int r11, boolean r12, int r13, boolean r14, int r15, Object r16, boolean r17, boolean r18, boolean r19, String r20, boolean r21) {
        this.tags = new LinkedHashMap();
        this.method = r5;
        this.server = r6;
        this.relativeUrl = r7;
        this.contentTypeHeader = r9;
        this.priorityLevel = r10;
        this.requestPriorityLevel = r11;
        this.responseStreaming = r12;
        this.maxLength = r13;
        this.addCommonParam = r14;
        this.commonParamLevel = r15;
        this.extraInfo = r16;
        this.hasBody = r17;
        this.headers = r8;
        this.serviceType = r20;
        this.enableRecordFormFields = r21;
        if (r18 == false) goto L5;
        FormUrlEncodedTypedOutput r3 = new FormUrlEncodedTypedOutput(r21);
        this.formBody = r3;
        this.multipartBody = null;
        this.body = r3;
        this.multipartBuilder = null;
        return;
    L5:
        if (r19 == false) goto L7;
        this.formBody = null;
        MultipartTypedOutput r1 = new MultipartTypedOutput();
        this.multipartBody = r1;
        this.body = r1;
        MultipartBody.Builder r2 = new MultipartBody.Builder();
        this.multipartBuilder = r2;
        r2.setType(MultipartBody.FORM);
        return;
    L7:
        this.formBody = null;
        this.multipartBody = null;
        this.multipartBuilder = null;
    }

    private StringBuilder newUrlBuilder(String r2, String r3) {
        StringBuilder r1 = new StringBuilder(r2);
        if (r2.endsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L5;
        r1.deleteCharAt(r1.length() - 1);
    L5:
        r1.append(r3);
        return r1;
    }

    public void addFormField(String r1, String r2, boolean r3) {
        this.formBody.addField(r1, r3, r2, r3);
    }

    public void addHeader(String r3, String r4) {
        if (r3 == null) goto L13;
        if ("Content-Type".equalsIgnoreCase(r3) == false) goto L7;
        this.contentTypeHeader = r4;
        return;
    L7:
        List r0 = this.headers;
        if (r0 != null) goto L10;
        r0 = new ArrayList(2);
        this.headers = r0;
    L10:
        r0.add(new Header(r3, r4));
        return;
    L13:
        throw new IllegalArgumentException("Header name must not be null.");
    }

    public void addPart(String r1, TypedOutput r2) {
        this.multipartBody.addPart(r1, r2);
    }

    public void addPathParam(String r5, String r6, boolean r7) {
        String r0 = this.relativeUrl;
        if (r0 == null) goto L20;
        if (r5 == null) goto L18;
        if (r6 == null) goto L16;
        if (r7 == false) goto L11;
        String r8 = URLEncoder.encode(r6, "UTF-8").replace("+", "%20");     // Catch: UnsupportedEncodingException -> L9
        this.relativeUrl = this.relativeUrl.replace("{" + r5 + "}", r8);     // Catch: UnsupportedEncodingException -> L9
    L21:
        return;
    L11:
        this.relativeUrl = r0.replace("{" + r5 + "}", r6);     // Catch: UnsupportedEncodingException -> L9
    L9:
        e = move-exception;
        throw new RuntimeException("Unable to convert path parameter \"" + r5 + "\" value to UTF-8:" + r6, e);
    L16:
        throw new IllegalArgumentException(a.k("Path replacement \"", r5, "\" value must not be null."));
    L18:
        throw new IllegalArgumentException("Path replacement name must not be null.");
    L20:
        throw new AssertionError();
    }

    public void addQueryParam(String r3, String r4, boolean r5) {
        if (r3 == null) goto L28;
        StringBuilder r0 = this.queryParams;     // Catch: UnsupportedEncodingException -> L6
        if (r0 != null) goto L9;
        r0 = new StringBuilder();     // Catch: UnsupportedEncodingException -> L6
        this.queryParams = r0;     // Catch: UnsupportedEncodingException -> L6
    L9:
        if (r0.length() <= 0) goto L11;
        char r2 = '&';
    L12:
        r0.append(r2);     // Catch: UnsupportedEncodingException -> L6
        if (r5 == false) goto L16;
        r3 = URLEncoder.encode(r3, "UTF-8");     // Catch: UnsupportedEncodingException -> L6
    L16:
        if (r5 == false) goto L18;
        r4 = URLEncoder.encode(r4, "UTF-8");     // Catch: UnsupportedEncodingException -> L6
    L18:
        if (r4 != null) goto L20;
    L23:
        r0.append(r3);     // Catch: UnsupportedEncodingException -> L6
        return;
    L20:
        if (r4.isEmpty() == true) goto L23;
        r0.append(r3);     // Catch: UnsupportedEncodingException -> L6
        r0.append('=');     // Catch: UnsupportedEncodingException -> L6
        r0.append(r4);     // Catch: UnsupportedEncodingException -> L6
        return;
    L11:
        r2 = '?';
    L6:
        e = move-exception;
        throw new RuntimeException("Unable to convert query parameter \"" + r3 + "\" value to UTF-8: " + r4, e);
    L28:
        throw new IllegalArgumentException("Query param name must not be null.");
    }

    public <T> void addTag(Class<? super T> r1, T r2) {
        this.tags.put(r1, r1.cast(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.bytedance.retrofit2.RequestBuilder] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.bytedance.retrofit2.mime.TypedOutput] */
    public Request build(ExpandCallback<?> r18) {
        MultipartTypedOutput r2 = this.multipartBody;
        if (r2 != null) goto L5;
    L11:
        ?? r3 = this.server.getUrl();
        if (Platform.squareRetrofitExists() == false) goto L95;
        HttpUrl r4 = HttpUrl.parse(r3);
        if (r4 == null) goto L28;
        if (r4.encodedPath() != null) goto L18;
    L22:
        HttpUrl r5 = r4.resolve(this.relativeUrl);
        if (r5 == null) goto L26;
        r3 = new StringBuilder(r5.toString());
    L46:
        StringBuilder r6 = this.queryParams;
        if (r6 != null) goto L49;
    L56:
        String r7 = this.queryObjectParams;
        if (r7 == null) goto L59;
        r3.append(r7);
    L59:
        this.apiUrl = r3.toString();
        if ((r18 instanceof ExpandCallback) == false) goto L62;
        r18.onAsyncPreRequest(this);
    L62:
        TypedOutput r1 = this.body;
        List<Header> r8 = this.headers;
        RequestBody r9 = this.requestBody;
        ContentTypeOverridingRequestBody r10 = null;
        if (this.useRequestBody == false) goto L78;
        if (r9 != null) goto L71;
        MultipartBody.Builder r11 = this.multipartBuilder;
        if (r11 == null) goto L69;
        r9 = r11.build();
        goto L71
    L69:
        if (this.hasBody == false) goto L71;
        r9 = RequestBody.create(null, new byte[0]);
    L71:
        if (r9 != null) goto L73;
    L77:
        List<Header> r12 = r8;
        RequestBody r13 = r9;
        ?? r14 = r1;
    L86:
        if (r14 != 0) goto L93;
        if (Utils.requiresRequestBody(this.method) == false) goto L93;
        if (this.useRequestBody == true) goto L93;
        r14 = new FormUrlEncodedTypedOutput();
        r14.addField("body", "null");
    L93:
        return new Request(this.method, this.apiUrl, r12, r14, r13, this.priorityLevel, this.requestPriorityLevel, this.responseStreaming, this.maxLength, this.addCommonParam, this.commonParamLevel, this.extraInfo, this.serviceType, this.tags);
    L73:
        if (this.contentTypeHeader == null) goto L77;
        r10 = new ContentTypeOverridingRequestBody(r9, this.contentTypeHeader);
    L75:
        r12 = r8;
        TypedOutput r15 = r1;
    L76:
        r13 = r10;
        r14 = r15;
        goto L86
    L78:
        String r16 = this.contentTypeHeader;
        if (r16 == null) goto L75;
        if (r1 == null) goto L82;
        r12 = r8;
        r15 = new MimeOverridingTypedOutput(r1, r16);
        goto L76
    L82:
        Header r17 = new Header("Content-Type", r16);
        if (r8 != null) goto L85;
        r8 = Collections.singletonList(r17);
        goto L75
    L85:
        r8.add(r17);
        goto L75
    L49:
        if ('?' != r6.charAt(0)) goto L55;
        String r19 = this.relativeUrl;
        if (r19 == null) goto L55;
        if (r19.indexOf(63) == (-1)) goto L55;
        r6.setCharAt(0, '&');
    L55:
        r3.append(r6);
        goto L56
    L26:
        throw new IllegalArgumentException("Malformed URL. Base: " + r4 + ", Relative: " + this.relativeUrl);
    L18:
        if (r4.encodedPath().length() <= 0) goto L22;
        if (LibrarianImpl.Constants.SEPARATOR.equals(this.relativeUrl) == false) goto L22;
        r3 = newUrlBuilder(r3, this.relativeUrl);
        goto L46
    L28:
        throw new IllegalArgumentException("Malformed URL. Base: " + r4 + ", Relative: " + this.relativeUrl);
    L95:
        URI r20 = URI.create(r3);     // Catch: Throwable -> L38
        if (r20.getPath() == null) goto L37;
        if (r20.getPath().length() < 1) goto L37;
        if (LibrarianImpl.Constants.SEPARATOR.equals(this.relativeUrl) == false) goto L37;
        r3 = newUrlBuilder(r3, this.relativeUrl);     // Catch: Throwable -> L38
    L94:
    L37:
        r3 = new StringBuilder(r20.resolve(this.relativeUrl).toString());     // Catch: Throwable -> L38
    L38:
        String r21 = this.relativeUrl;
        if (r21 != null) goto L41;
    L45:
        r3 = newUrlBuilder(r3, this.relativeUrl);
        goto L46
    L41:
        if (r21.startsWith("http://") == false) goto L43;
    L44:
        r3 = new StringBuilder(this.relativeUrl);
        goto L46
    L43:
        if (this.relativeUrl.startsWith("https://") == false) goto L45;
    L5:
        if (r2.getPartCount() != 0) goto L11;
        if (this.useRequestBody == true) goto L11;
        throw new IllegalStateException("Multipart requests must contain at least one part.");
    }

    @Nullable
    public String getApiUrl() {
        return this.apiUrl;
    }

    @Nullable
    public TypedOutput getBody() {
        return this.body;
    }

    public Object getExtraInfo() {
        return this.extraInfo;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public String getRelativeUrl() {
        return this.relativeUrl;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public boolean isAddCommonParam() {
        return this.addCommonParam;
    }

    public boolean isResponseStreaming() {
        return this.responseStreaming;
    }

    public void setAddCommonParam(boolean r1) {
        this.addCommonParam = r1;
    }

    public void setApiUrl(String r1) {
        this.apiUrl = r1;
    }

    public void setBody(RequestBody r1) {
        this.requestBody = r1;
    }

    public void setCommonParamLevel(int r1) {
        this.commonParamLevel = r1;
    }

    public void setExtraInfo(Object r1) {
        this.extraInfo = r1;
    }

    public void setHeaders(List<Header> r1) {
        this.headers = r1;
    }

    public void setMaxLength(int r1) {
        this.maxLength = r1;
    }

    public void setMethod(String r4, String r5) {
        String r0 = this.method;
        if (r0 == null) goto L7;
        this.method = r0.replace("{" + r4 + "}", r5);
        return;
    L7:
        throw new AssertionError();
    }

    public void setPriorityLevel(int r1) {
        this.priorityLevel = r1;
    }

    public void setQueryObjectParams(String r1) {
        this.queryObjectParams = r1;
    }

    public void setRelativeUrl(Object r1) {
        if (r1 == null) goto L6;
        this.relativeUrl = r1.toString();
        return;
    L6:
        throw new NullPointerException("@Url parameter is null.");
    }

    public void setResponseStreaming(boolean r1) {
        this.responseStreaming = r1;
    }

    public void useRequestBody() {
        this.useRequestBody = true;
    }

    public void addPart(String r1, String r2, TypedOutput r3) {
        this.multipartBody.addPart(r1, r2, r3);
    }

    public void setBody(TypedOutput r1) {
        this.body = r1;
    }

    public void addPart(Headers r1, RequestBody r2) {
        this.multipartBuilder.addPart(r1, r2);
    }

    public void addPart(MultipartBody.Part r1) {
        this.multipartBuilder.addPart(r1);
    }

    public void setMethod(String r1) {
        this.method = r1;
    }
}
