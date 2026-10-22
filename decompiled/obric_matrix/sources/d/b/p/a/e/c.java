package d.b.p.a.e;

import android.app.Application;
import android.content.Context;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;

/* JADX INFO: loaded from: classes.dex */
public class c extends d.b.p.a.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f14254a;

    public c() {
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "EnterTransitionCrashPlugin";
    }

    @Override // d.b.p.a.g.a
    public void c(Application r1) {
        super.c(r1);
        this.f14254a = r1;
    }

    @Override // d.b.p.a.g.a
    public void d() {
        super.d();
        EnterTransitionCrashOptimizer.fix(this.f14254a);
    }
}
