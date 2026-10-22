package cz.msebera.android.httpclient.client.methods;

import com.android.settings.utils.HanziToPinyin;
import com.bytedance.librarian.LibrarianImpl;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.message.BasicRequestLine;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import java.net.URI;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HttpRequestBase extends AbstractExecutionAwareRequest implements HttpUriRequest, Configurable {
    private RequestConfig config;
    private URI uri;
    private ProtocolVersion version;

    public abstract String getMethod();

    public void started() {
    }

    public HttpRequestBase() {
    }

    public void setProtocolVersion(ProtocolVersion r1) {
        this.version = r1;
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion r0 = this.version;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return HttpProtocolParams.getVersion(getParams());
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public URI getURI() {
        return this.uri;
    }

    @Override // cz.msebera.android.httpclient.HttpRequest
    public RequestLine getRequestLine() {
        String r0 = getMethod();
        ProtocolVersion r1 = getProtocolVersion();
        URI r3 = getURI();
        if (r3 == null) goto L5;
        String r4 = r3.toASCIIString();
    L6:
        if (r4 != null) goto L8;
    L9:
        r4 = LibrarianImpl.Constants.SEPARATOR;
    L11:
        return new BasicRequestLine(r0, r4, r1);
    L8:
        if (r4.isEmpty() == false) goto L11;
    L5:
        r4 = null;
        goto L6
    }

    @Override // cz.msebera.android.httpclient.client.methods.Configurable
    public RequestConfig getConfig() {
        return this.config;
    }

    public void setConfig(RequestConfig r1) {
        this.config = r1;
    }

    public void setURI(URI r1) {
        this.uri = r1;
    }

    public void releaseConnection() {
        reset();
    }

    public String toString() {
        return getMethod() + HanziToPinyin.Token.SEPARATOR + getURI() + HanziToPinyin.Token.SEPARATOR + getProtocolVersion();
    }
}
