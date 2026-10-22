package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.ReasonPhraseCatalog;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHttpResponse extends AbstractHttpMessage implements HttpResponse {
    private int code;
    private HttpEntity entity;
    private Locale locale;
    private final ReasonPhraseCatalog reasonCatalog;
    private String reasonPhrase;
    private StatusLine statusline;
    private ProtocolVersion ver;

    public BasicHttpResponse(StatusLine r2, ReasonPhraseCatalog r3, Locale r4) {
        this.statusline = (StatusLine) Args.notNull(r2, "Status line");
        this.ver = r2.getProtocolVersion();
        this.code = r2.getStatusCode();
        this.reasonPhrase = r2.getReasonPhrase();
        this.reasonCatalog = r3;
        this.locale = r4;
    }

    public BasicHttpResponse(StatusLine r2) {
        this.statusline = (StatusLine) Args.notNull(r2, "Status line");
        this.ver = r2.getProtocolVersion();
        this.code = r2.getStatusCode();
        this.reasonPhrase = r2.getReasonPhrase();
        this.reasonCatalog = null;
        this.locale = null;
    }

    public BasicHttpResponse(ProtocolVersion r2, int r3, String r4) {
        Args.notNegative(r3, "Status code");
        this.statusline = null;
        this.ver = r2;
        this.code = r3;
        this.reasonPhrase = r4;
        this.reasonCatalog = null;
        this.locale = null;
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        return this.ver;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public StatusLine getStatusLine() {
        if (this.statusline != null) goto L14;
        ProtocolVersion r1 = this.ver;
        if (r1 != null) goto L8;
        r1 = HttpVersion.HTTP_1_1;
    L8:
        int r2 = this.code;
        String r3 = this.reasonPhrase;
        if (r3 != null) goto L12;
        r3 = getReason(r2);
    L12:
        this.statusline = new BasicStatusLine(r1, r2, r3);
    L14:
        return this.statusline;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public HttpEntity getEntity() {
        return this.entity;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public Locale getLocale() {
        return this.locale;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setStatusLine(StatusLine r2) {
        this.statusline = (StatusLine) Args.notNull(r2, "Status line");
        this.ver = r2.getProtocolVersion();
        this.code = r2.getStatusCode();
        this.reasonPhrase = r2.getReasonPhrase();
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setStatusLine(ProtocolVersion r2, int r3) {
        Args.notNegative(r3, "Status code");
        this.statusline = null;
        this.ver = r2;
        this.code = r3;
        this.reasonPhrase = null;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setStatusLine(ProtocolVersion r2, int r3, String r4) {
        Args.notNegative(r3, "Status code");
        this.statusline = null;
        this.ver = r2;
        this.code = r3;
        this.reasonPhrase = r4;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setStatusCode(int r2) {
        Args.notNegative(r2, "Status code");
        this.statusline = null;
        this.code = r2;
        this.reasonPhrase = null;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setReasonPhrase(String r3) {
        this.statusline = null;
        if (TextUtils.isBlank(r3) == false) goto L5;
        r3 = null;
    L5:
        this.reasonPhrase = r3;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setEntity(HttpEntity r1) {
        this.entity = r1;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setLocale(Locale r2) {
        this.locale = (Locale) Args.notNull(r2, "Locale");
        this.statusline = null;
    }

    protected String getReason(int r2) {
        ReasonPhraseCatalog r0 = this.reasonCatalog;
        if (r0 == null) goto L9;
        Locale r1 = this.locale;
        if (r1 != null) goto L11;
        r1 = Locale.getDefault();
    L11:
        return r0.getReason(r2, r1);
    L9:
        return null;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(getStatusLine());
        r0.append(TokenParser.SP);
        r0.append(this.headergroup);
        if (this.entity == null) goto L6;
        r0.append(TokenParser.SP);
        r0.append(this.entity);
    L6:
        return r0.toString();
    }
}
