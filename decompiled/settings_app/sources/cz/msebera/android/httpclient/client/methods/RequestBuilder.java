package cz.msebera.android.httpclient.client.methods;

import com.bytedance.librarian.LibrarianImpl;
import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.utils.URIBuilder;
import cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.message.HeaderGroup;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RequestBuilder {
    private Charset charset;
    private RequestConfig config;
    private HttpEntity entity;
    private HeaderGroup headerGroup;
    private String method;
    private List<NameValuePair> parameters;
    private URI uri;
    private ProtocolVersion version;

    static class InternalEntityEclosingRequest extends HttpEntityEnclosingRequestBase {
        private final String method;

        InternalEntityEclosingRequest(String r1) {
            this.method = r1;
        }

        @Override // cz.msebera.android.httpclient.client.methods.HttpRequestBase, cz.msebera.android.httpclient.client.methods.HttpUriRequest
        public String getMethod() {
            return this.method;
        }
    }

    static class InternalRequest extends HttpRequestBase {
        private final String method;

        InternalRequest(String r1) {
            this.method = r1;
        }

        @Override // cz.msebera.android.httpclient.client.methods.HttpRequestBase, cz.msebera.android.httpclient.client.methods.HttpUriRequest
        public String getMethod() {
            return this.method;
        }
    }

    RequestBuilder(String r2) {
        this.charset = Consts.UTF_8;
        this.method = r2;
    }

    RequestBuilder(String r1, URI r2) {
        this.method = r1;
        this.uri = r2;
    }

    RequestBuilder(String r1, String r2) {
        this.method = r1;
        if (r2 == null) goto L5;
        URI r3 = URI.create(r2);
    L6:
        this.uri = r3;
        return;
    L5:
        r3 = null;
        goto L6
    }

    RequestBuilder() {
        this(null);
    }

    public static RequestBuilder create(String r1) {
        Args.notBlank(r1, "HTTP method");
        return new RequestBuilder(r1);
    }

    public static RequestBuilder get() {
        return new RequestBuilder("GET");
    }

    public static RequestBuilder get(URI r2) {
        return new RequestBuilder("GET", r2);
    }

    public static RequestBuilder get(String r2) {
        return new RequestBuilder("GET", r2);
    }

    public static RequestBuilder head() {
        return new RequestBuilder("HEAD");
    }

    public static RequestBuilder head(URI r2) {
        return new RequestBuilder("HEAD", r2);
    }

    public static RequestBuilder head(String r2) {
        return new RequestBuilder("HEAD", r2);
    }

    public static RequestBuilder patch() {
        return new RequestBuilder("PATCH");
    }

    public static RequestBuilder patch(URI r2) {
        return new RequestBuilder("PATCH", r2);
    }

    public static RequestBuilder patch(String r2) {
        return new RequestBuilder("PATCH", r2);
    }

    public static RequestBuilder post() {
        return new RequestBuilder("POST");
    }

    public static RequestBuilder post(URI r2) {
        return new RequestBuilder("POST", r2);
    }

    public static RequestBuilder post(String r2) {
        return new RequestBuilder("POST", r2);
    }

    public static RequestBuilder put() {
        return new RequestBuilder("PUT");
    }

    public static RequestBuilder put(URI r2) {
        return new RequestBuilder("PUT", r2);
    }

    public static RequestBuilder put(String r2) {
        return new RequestBuilder("PUT", r2);
    }

    public static RequestBuilder delete() {
        return new RequestBuilder("DELETE");
    }

    public static RequestBuilder delete(URI r2) {
        return new RequestBuilder("DELETE", r2);
    }

    public static RequestBuilder delete(String r2) {
        return new RequestBuilder("DELETE", r2);
    }

    public static RequestBuilder trace() {
        return new RequestBuilder("TRACE");
    }

    public static RequestBuilder trace(URI r2) {
        return new RequestBuilder("TRACE", r2);
    }

    public static RequestBuilder trace(String r2) {
        return new RequestBuilder("TRACE", r2);
    }

    public static RequestBuilder options() {
        return new RequestBuilder("OPTIONS");
    }

    public static RequestBuilder options(URI r2) {
        return new RequestBuilder("OPTIONS", r2);
    }

    public static RequestBuilder options(String r2) {
        return new RequestBuilder("OPTIONS", r2);
    }

    public static RequestBuilder copy(HttpRequest r1) {
        Args.notNull(r1, "HTTP request");
        return new RequestBuilder().doCopy(r1);
    }

    private RequestBuilder doCopy(HttpRequest r5) {
        if (r5 != null) goto L4;
        return this;
    L4:
        this.method = r5.getRequestLine().getMethod();
        this.version = r5.getRequestLine().getProtocolVersion();
        if (this.headerGroup != null) goto L7;
        this.headerGroup = new HeaderGroup();
    L7:
        this.headerGroup.clear();
        this.headerGroup.setHeaders(r5.getAllHeaders());
        this.parameters = null;
        this.entity = null;
        if ((r5 instanceof HttpEntityEnclosingRequest) == false) goto L19;
        HttpEntity r1 = ((HttpEntityEnclosingRequest) r5).getEntity();
        ContentType r2 = ContentType.get(r1);
        if (r2 != null) goto L12;
    L17:
        this.entity = r1;
        goto L19
    L12:
        if (r2.getMimeType().equals(ContentType.APPLICATION_FORM_URLENCODED.getMimeType()) == false) goto L17;
        List<NameValuePair> r3 = URLEncodedUtils.parse(r1);     // Catch: IOException -> L27
        if (r3.isEmpty() == true) goto L19;
        this.parameters = r3;     // Catch: IOException -> L27
    L19:
        if ((r5 instanceof HttpUriRequest) == false) goto L21;
        this.uri = ((HttpUriRequest) r5).getURI();
    L23:
        if ((r5 instanceof Configurable) == false) goto L25;
        this.config = ((Configurable) r5).getConfig();
    L26:
        return this;
    L25:
        this.config = null;
        goto L26
    L21:
        this.uri = URI.create(r5.getRequestLine().getUri());
        goto L23
    }

    public RequestBuilder setCharset(Charset r1) {
        this.charset = r1;
        return this;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getMethod() {
        return this.method;
    }

    public ProtocolVersion getVersion() {
        return this.version;
    }

    public RequestBuilder setVersion(ProtocolVersion r1) {
        this.version = r1;
        return this;
    }

    public URI getUri() {
        return this.uri;
    }

    public RequestBuilder setUri(URI r1) {
        this.uri = r1;
        return this;
    }

    public RequestBuilder setUri(String r1) {
        if (r1 == null) goto L4;
        URI r2 = URI.create(r1);
    L5:
        this.uri = r2;
        return this;
    L4:
        r2 = null;
        goto L5
    }

    public Header getFirstHeader(String r1) {
        HeaderGroup r0 = this.headerGroup;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getFirstHeader(r1);
    }

    public Header getLastHeader(String r1) {
        HeaderGroup r0 = this.headerGroup;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLastHeader(r1);
    }

    public Header[] getHeaders(String r1) {
        HeaderGroup r0 = this.headerGroup;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHeaders(r1);
    }

    public RequestBuilder addHeader(Header r2) {
        if (this.headerGroup != null) goto L5;
        this.headerGroup = new HeaderGroup();
    L5:
        this.headerGroup.addHeader(r2);
        return this;
    }

    public RequestBuilder addHeader(String r3, String r4) {
        if (this.headerGroup != null) goto L5;
        this.headerGroup = new HeaderGroup();
    L5:
        this.headerGroup.addHeader(new BasicHeader(r3, r4));
        return this;
    }

    public RequestBuilder removeHeader(Header r2) {
        if (this.headerGroup != null) goto L5;
        this.headerGroup = new HeaderGroup();
    L5:
        this.headerGroup.removeHeader(r2);
        return this;
    }

    public RequestBuilder removeHeaders(String r3) {
        if (r3 == null) goto L12;
        HeaderGroup r0 = this.headerGroup;
        if (r0 == null) goto L12;
        HeaderIterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        if (r3.equalsIgnoreCase(r1.nextHeader().getName()) == false) goto L8;
        r1.remove();
    L12:
        return this;
    }

    public RequestBuilder setHeader(Header r2) {
        if (this.headerGroup != null) goto L5;
        this.headerGroup = new HeaderGroup();
    L5:
        this.headerGroup.updateHeader(r2);
        return this;
    }

    public RequestBuilder setHeader(String r3, String r4) {
        if (this.headerGroup != null) goto L5;
        this.headerGroup = new HeaderGroup();
    L5:
        this.headerGroup.updateHeader(new BasicHeader(r3, r4));
        return this;
    }

    public HttpEntity getEntity() {
        return this.entity;
    }

    public RequestBuilder setEntity(HttpEntity r1) {
        this.entity = r1;
        return this;
    }

    public List<NameValuePair> getParameters() {
        if (this.parameters == null) goto L6;
        return new ArrayList(this.parameters);
    L6:
        return new ArrayList();
    }

    public RequestBuilder addParameter(NameValuePair r2) {
        Args.notNull(r2, "Name value pair");
        if (this.parameters != null) goto L5;
        this.parameters = new LinkedList();
    L5:
        this.parameters.add(r2);
        return this;
    }

    public RequestBuilder addParameter(String r2, String r3) {
        return addParameter(new BasicNameValuePair(r2, r3));
    }

    public RequestBuilder addParameters(NameValuePair... r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        addParameter(r4[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return this;
    }

    public RequestConfig getConfig() {
        return this.config;
    }

    public RequestBuilder setConfig(RequestConfig r1) {
        this.config = r1;
        return this;
    }

    public HttpUriRequest build() {
        URI r0 = this.uri;
        if (r0 != null) goto L6;
        r0 = URI.create(LibrarianImpl.Constants.SEPARATOR);
    L6:
        HttpEntity r1 = this.entity;
        List<NameValuePair> r2 = this.parameters;
        if (r2 != null) goto L9;
    L21:
        if (r1 != null) goto L23;
        HttpRequestBase r3 = new InternalRequest(this.method);
    L24:
        r3.setProtocolVersion(this.version);
        r3.setURI(r0);
        HeaderGroup r4 = this.headerGroup;
        if (r4 == null) goto L27;
        r3.setHeaders(r4.getAllHeaders());
    L27:
        r3.setConfig(this.config);
        return r3;
    L23:
        InternalEntityEclosingRequest r5 = new InternalEntityEclosingRequest(this.method);
        r5.setEntity(r1);
        r3 = r5;
        goto L24
    L9:
        if (r2.isEmpty() == true) goto L21;
        if (r1 == null) goto L12;
    L30:
        r0 = new URIBuilder(r0).setCharset(this.charset).addParameters(this.parameters).build();     // Catch: URISyntaxException -> L29
        goto L21
    L12:
        if ("POST".equalsIgnoreCase(this.method) == false) goto L14;
    L15:
        List<NameValuePair> r6 = this.parameters;
        Charset r7 = this.charset;
        if (r7 != null) goto L19;
        r7 = HTTP.DEF_CONTENT_CHARSET;
    L19:
        r1 = new UrlEncodedFormEntity(r6, r7);
        goto L21
    L14:
        if ("PUT".equalsIgnoreCase(this.method) == false) goto L30;
        goto L15
    }

    public String toString() {
        return "RequestBuilder [method=" + this.method + ", charset=" + this.charset + ", version=" + this.version + ", uri=" + this.uri + ", headerGroup=" + this.headerGroup + ", entity=" + this.entity + ", parameters=" + this.parameters + ", config=" + this.config + "]";
    }
}
