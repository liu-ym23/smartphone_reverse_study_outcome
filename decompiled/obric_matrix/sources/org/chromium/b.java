package org.chromium;

import com.ttnet.org.chromium.net.TTMonitorProvider;

/* JADX INFO: loaded from: classes2.dex */
public class b extends TTMonitorProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f22662a;

    private b() {
    }

    public static b a() {
        if (f22662a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f22662a != null) goto L9;
        f22662a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f22662a;
    }

    @Override // com.ttnet.org.chromium.net.TTMonitorProvider
    public void handleApiResult(boolean r37, String r38, String r39, String r40, long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, boolean r61, long r62, long r64, String r66, String r67, String r68, int r69, int r70, String r71) {
        c.W().U(r37, r38, r39, r40, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r62, r64, r66, r67, r68, r69, r70, r71);
    }

    @Override // com.ttnet.org.chromium.net.TTMonitorProvider
    public boolean handleApiSample(String r1, String r2) {
        return c.W().V(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.TTMonitorProvider
    public void sendAppMonitorEvent(String r1, String r2) {
        c.W().y0(r1, r2);
    }
}
