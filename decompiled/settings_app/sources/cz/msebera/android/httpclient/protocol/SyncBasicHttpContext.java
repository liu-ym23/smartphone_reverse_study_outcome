package cz.msebera.android.httpclient.protocol;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class SyncBasicHttpContext extends BasicHttpContext {
    public SyncBasicHttpContext(HttpContext r1) {
        super(r1);
    }

    public SyncBasicHttpContext() {
    }

    @Override // cz.msebera.android.httpclient.protocol.BasicHttpContext, cz.msebera.android.httpclient.protocol.HttpContext
    public synchronized Object getAttribute(String r1) {
        monitor-enter(this);
        Object r2 = super.getAttribute(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.protocol.BasicHttpContext, cz.msebera.android.httpclient.protocol.HttpContext
    public synchronized void setAttribute(String r1, Object r2) {
        monitor-enter(this);
        super.setAttribute(r1, r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.protocol.BasicHttpContext, cz.msebera.android.httpclient.protocol.HttpContext
    public synchronized Object removeAttribute(String r1) {
        monitor-enter(this);
        Object r2 = super.removeAttribute(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.protocol.BasicHttpContext
    public synchronized void clear() {
        monitor-enter(this);
        super.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
