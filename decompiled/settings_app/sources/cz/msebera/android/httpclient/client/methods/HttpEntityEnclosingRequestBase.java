package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.client.utils.CloneUtils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HttpEntityEnclosingRequestBase extends HttpRequestBase implements HttpEntityEnclosingRequest {
    private HttpEntity entity;

    public HttpEntityEnclosingRequestBase() {
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

    @Override // cz.msebera.android.httpclient.client.methods.AbstractExecutionAwareRequest
    public Object clone() throws CloneNotSupportedException {
        HttpEntityEnclosingRequestBase r0 = (HttpEntityEnclosingRequestBase) super.clone();
        HttpEntity r1 = this.entity;
        if (r1 == null) goto L5;
        r0.entity = (HttpEntity) CloneUtils.cloneObject(r1);
    L5:
        return r0;
    }
}
