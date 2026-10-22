package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHttpEntityEnclosingRequest extends BasicHttpRequest implements HttpEntityEnclosingRequest {
    private HttpEntity entity;

    public BasicHttpEntityEnclosingRequest(String r1, String r2) {
        super(r1, r2);
    }

    public BasicHttpEntityEnclosingRequest(String r1, String r2, ProtocolVersion r3) {
        super(r1, r2, r3);
    }

    public BasicHttpEntityEnclosingRequest(RequestLine r1) {
        super(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpEntityEnclosingRequest
    public HttpEntity getEntity() {
        return this.entity;
    }

    @Override // cz.msebera.android.httpclient.HttpEntityEnclosingRequest
    public void setEntity(HttpEntity r1) {
        this.entity = r1;
    }

    @Override // cz.msebera.android.httpclient.HttpEntityEnclosingRequest
    public boolean expectContinue() {
        Header r1 = getFirstHeader("Expect");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if ("100-continue".equalsIgnoreCase(r1.getValue()) == false) goto L7;
        return true;
    }
}
