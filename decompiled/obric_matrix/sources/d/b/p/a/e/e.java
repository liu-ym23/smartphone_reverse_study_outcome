package d.b.p.a.e;

import android.app.Application;
import android.content.Context;
import com.bytedance.sysoptimizer.LayoutInflaterAsyncCrashOptimizer;

/* JADX INFO: loaded from: classes.dex */
public class e extends d.b.p.a.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f14256a;

    public e() {
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "LayoutInflaterAsyncCrashPlugin";
    }

    @Override // d.b.p.a.g.a
    public void c(Application r1) {
        super.c(r1);
        this.f14256a = r1;
    }

    @Override // d.b.p.a.g.a
    public void d() {
        super.d();
        LayoutInflaterAsyncCrashOptimizer.fix(this.f14256a);
    }
}
