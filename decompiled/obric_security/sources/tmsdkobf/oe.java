package tmsdkobf;

import tmsdk.common.TMSDKContext;
import tmsdk.common.creator.ManagerCreatorC;

/* JADX INFO: loaded from: classes5.dex */
public final class oe implements me {
    private static ne b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f397a;

    public oe(long r1) {
        this.f397a = r1;
        if (b == null) goto L5;
    L14:
        b = (ne) ManagerCreatorC.getManager(ne.class);
        return;
    L5:
        monitor-enter(oe.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        ne r2 = new ne();     // Catch: Throwable -> L11
        b = r2;     // Catch: Throwable -> L11
        r2.onCreate(TMSDKContext.getApplicaionContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(oe.class);     // Catch: Throwable -> L11
        goto L14
    }

    @Override // tmsdkobf.me
    public o3 a(String r4) {
        return b.a(r4, this.f397a);
    }

    @Override // tmsdkobf.me
    public p6 b(String r4) {
        return b.b(r4, this.f397a);
    }
}
