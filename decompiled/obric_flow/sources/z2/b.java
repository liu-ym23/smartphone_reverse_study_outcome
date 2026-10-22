package z2;

import com.bytedance.ai.monitor.AppletMonitorableEvent$EventOrigin;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f23367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f23368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f23369c;
    public final /* synthetic */ long d;

    public /* synthetic */ b(String r5, g r10, long r11, int r12) {
        this.f23367a = r12;
        this.f23368b = r5;
        this.f23369c = r10;
        this.d = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f23367a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        AppletMonitorableEvent$EventOrigin r5 = AppletMonitorableEvent$EventOrigin.f2385b;
        f r10 = new f(this.f23368b, r5);
        this.f23369c.b(r10);
        r10.d = true;
        r10.e = this.d;
        d.c(r10);
        return;
    L6:
        AppletMonitorableEvent$EventOrigin r11 = AppletMonitorableEvent$EventOrigin.f2385b;
        f r12 = new f(this.f23368b, r11);
        this.f23369c.b(r12);
        r12.e = this.d;
        d.c(r12);
        return;
    L8:
        AppletMonitorableEvent$EventOrigin r13 = AppletMonitorableEvent$EventOrigin.f2384a;
        f r14 = new f(this.f23368b, r13);
        this.f23369c.b(r14);
        r14.e = this.d;
        d.c(r14);
    }
}
