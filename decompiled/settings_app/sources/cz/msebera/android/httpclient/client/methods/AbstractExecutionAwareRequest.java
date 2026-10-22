package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.client.utils.CloneUtils;
import cz.msebera.android.httpclient.concurrent.Cancellable;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger;
import cz.msebera.android.httpclient.message.AbstractHttpMessage;
import cz.msebera.android.httpclient.message.HeaderGroup;
import cz.msebera.android.httpclient.params.HttpParams;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractExecutionAwareRequest extends AbstractHttpMessage implements HttpExecutionAware, AbortableHttpRequest, Cloneable, HttpRequest {
    private final AtomicBoolean aborted;
    private final AtomicReference<Cancellable> cancellableRef;

    protected AbstractExecutionAwareRequest() {
        this.aborted = new AtomicBoolean(false);
        this.cancellableRef = new AtomicReference(null);
    }

    @Override // cz.msebera.android.httpclient.client.methods.AbortableHttpRequest
    @Deprecated
    public void setConnectionRequest(final ClientConnectionRequest r2) {
        setCancellable(new AnonymousClass1(this, r2));
    }

    @Override // cz.msebera.android.httpclient.client.methods.AbortableHttpRequest
    @Deprecated
    public void setReleaseTrigger(final ConnectionReleaseTrigger r2) {
        setCancellable(new AnonymousClass2(this, r2));
    }

    @Override // cz.msebera.android.httpclient.client.methods.AbortableHttpRequest
    public void abort() {
        if (this.aborted.compareAndSet(false, true) == false) goto L8;
        Cancellable r3 = this.cancellableRef.getAndSet(null);
        if (r3 == null) goto L9;
        r3.cancel();
        return;
    L9:
        return;
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpExecutionAware
    public boolean isAborted() {
        return this.aborted.get();
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpExecutionAware
    public void setCancellable(Cancellable r2) {
        if (this.aborted.get() == true) goto L6;
        this.cancellableRef.set(r2);
        return;
    }

    public Object clone() throws CloneNotSupportedException {
        AbstractExecutionAwareRequest r0 = (AbstractExecutionAwareRequest) super.clone();
        r0.headergroup = (HeaderGroup) CloneUtils.cloneObject(this.headergroup);
        r0.params = (HttpParams) CloneUtils.cloneObject(this.params);
        return r0;
    }

    public void completed() {
        this.cancellableRef.set(null);
    }

    public void reset() {
        Cancellable r0 = this.cancellableRef.getAndSet(null);
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.aborted.set(false);
    }
}
