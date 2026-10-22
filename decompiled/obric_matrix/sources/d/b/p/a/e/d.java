package d.b.p.a.e;

import android.app.Application;
import com.bytedance.sysoptimizer.HWReceiverCrashOptimizer;

/* JADX INFO: loaded from: classes.dex */
public class d extends d.b.p.a.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f14255a;

    public d() {
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "HWReceiverCrashPlugin";
    }

    @Override // d.b.p.a.g.a
    public void c(Application r1) {
        super.c(r1);
        this.f14255a = r1;
    }

    @Override // d.b.p.a.g.a
    public void d() {
        super.d();
        HWReceiverCrashOptimizer.fix(this.f14255a);
    }
}
