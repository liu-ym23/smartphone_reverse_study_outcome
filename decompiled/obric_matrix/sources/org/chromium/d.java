package org.chromium;

import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;

/* JADX INFO: loaded from: classes2.dex */
public class d implements ICronetDepend {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d f22665b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ICronetDepend f22666a;

    private d() {
    }

    public static d a() {
        if (f22665b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f22665b != null) goto L9;
        f22665b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f22665b;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public String getSsCookieKey() {
        ICronetDepend r0 = this.f22666a;
        if (r0 != null) goto L5;
        return CronetHttpURLConnection.SS_COOKIE;
    L5:
        return r0.getSsCookieKey();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void loggerD(String r1, String r2) {
        ICronetDepend r0 = this.f22666a;
        if (r0 == null) goto L6;
        r0.loggerD(r1, r2);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public boolean loggerDebug() {
        ICronetDepend r0 = this.f22666a;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.loggerDebug();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void setAdapter(ICronetDepend r1) {
        this.f22666a = r1;
    }
}
