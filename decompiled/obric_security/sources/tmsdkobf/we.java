package tmsdkobf;

import android.os.HandlerThread;
import tmsdk.common.creator.ManagerCreatorC;
import tmsdk.common.module.threadpool.CommonThreadPoolManager;

/* JADX INFO: loaded from: classes5.dex */
public class we {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CommonThreadPoolManager f601a;
    private long b;
    private String c;

    public we(long r1, String r3) {
        this.b = r1;
        if (r3 == null) goto L5;
        String r2 = r3 + "-";
    L6:
        this.c = r2;
        this.f601a = (CommonThreadPoolManager) ManagerCreatorC.getManager(CommonThreadPoolManager.class);
        return;
    L5:
        r2 = "no_pkg_name-";
        goto L6
    }

    public void a(int r7, Runnable r8, String r9) {
        this.f601a.addTask(r7, r8, a(r9), this.b);
    }

    public void b(Runnable r4, String r5) {
        this.f601a.addUrgentTask(r4, a(r5), this.b);
    }

    public Thread c(Runnable r4, String r5) {
        return this.f601a.newFreeThread(r4, a(r5), this.b);
    }

    public void a(Runnable r4, String r5) {
        this.f601a.addTask(r4, a(r5), this.b);
    }

    public HandlerThread b(String r4) {
        return this.f601a.newFreeHandlerThread(a(r4), 0, this.b);
    }

    private String a(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        return this.c + r2;
    }

    public HandlerThread a(String r4, int r5) {
        return this.f601a.newFreeHandlerThread(a(r4), r5, this.b);
    }
}
