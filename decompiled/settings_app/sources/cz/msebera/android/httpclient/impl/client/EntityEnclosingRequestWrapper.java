package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class EntityEnclosingRequestWrapper extends RequestWrapper implements HttpEntityEnclosingRequest {
    private boolean consumed;
    private HttpEntity entity;

    class EntityWrapper extends HttpEntityWrapper {
        final /* synthetic */ EntityEnclosingRequestWrapper this$0;

        EntityWrapper(EntityEnclosingRequestWrapper r1, HttpEntity r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
        public void consumeContent() throws IOException {
            EntityEnclosingRequestWrapper.access$002(this.this$0, true);
            super.consumeContent();
        }

        @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
        public InputStream getContent() throws IOException {
            EntityEnclosingRequestWrapper.access$002(this.this$0, true);
            return super.getContent();
        }

        @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
        public void writeTo(OutputStream r3) throws IOException {
            EntityEnclosingRequestWrapper.access$002(this.this$0, true);
            super.writeTo(r3);
        }
    }

    static /* synthetic */ boolean access$002(EntityEnclosingRequestWrapper r0, boolean r1) {
        r0.consumed = r1;
        return r1;
    }

    public EntityEnclosingRequestWrapper(HttpEntityEnclosingRequest r1) throws ProtocolException {
        super(r1);
        setEntity(r1.getEntity());
    }

    @Override // cz.msebera.android.httpclient.HttpEntityEnclosingRequest
    public HttpEntity getEntity() {
        return this.entity;
    }

    @Override // cz.msebera.android.httpclient.HttpEntityEnclosingRequest
    public void setEntity(HttpEntity r2) {
        if (r2 == null) goto L4;
        EntityWrapper r0 = new EntityWrapper(this, r2);
    L5:
        this.entity = r0;
        this.consumed = false;
        return;
    L4:
        r0 = null;
        goto L5
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

    @Override // cz.msebera.android.httpclient.impl.client.RequestWrapper
    public boolean isRepeatable() {
        HttpEntity r0 = this.entity;
        if (r0 != null) goto L5;
    L10:
        return true;
    L5:
        if (r0.isRepeatable() == true) goto L10;
        if (this.consumed == false) goto L10;
        return false;
    }
}
