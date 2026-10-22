package cz.msebera.android.httpclient.params;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class SyncBasicHttpParams extends BasicHttpParams {
    private static final long serialVersionUID = 5387834869062660642L;

    public SyncBasicHttpParams() {
    }

    @Override // cz.msebera.android.httpclient.params.BasicHttpParams, cz.msebera.android.httpclient.params.HttpParams
    public synchronized boolean removeParameter(String r1) {
        monitor-enter(this);
        boolean r2 = super.removeParameter(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.params.BasicHttpParams, cz.msebera.android.httpclient.params.HttpParams
    public synchronized HttpParams setParameter(String r1, Object r2) {
        monitor-enter(this);
        HttpParams r3 = super.setParameter(r1, r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.params.BasicHttpParams, cz.msebera.android.httpclient.params.HttpParams
    public synchronized Object getParameter(String r1) {
        monitor-enter(this);
        Object r2 = super.getParameter(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.params.BasicHttpParams
    public synchronized boolean isParameterSet(String r1) {
        monitor-enter(this);
        boolean r2 = super.isParameterSet(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.params.BasicHttpParams
    public synchronized boolean isParameterSetLocally(String r1) {
        monitor-enter(this);
        boolean r2 = super.isParameterSetLocally(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.params.BasicHttpParams
    public synchronized void setParameters(String[] r1, Object r2) {
        monitor-enter(this);
        super.setParameters(r1, r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.params.BasicHttpParams
    public synchronized void clear() {
        monitor-enter(this);
        super.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.params.BasicHttpParams
    public synchronized Object clone() throws CloneNotSupportedException {
        monitor-enter(this);
        Object r0 = super.clone();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
