package d.b.p.a.e;

import android.app.Application;
import android.content.Context;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;

/* JADX INFO: loaded from: classes.dex */
public class a extends d.b.p.a.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f14253a;

    public a() {
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "BadParcelableExceptionPlugin";
    }

    @Override // d.b.p.a.g.a
    public void c(Application r1) {
        super.c(r1);
        this.f14253a = r1;
    }

    @Override // d.b.p.a.g.a
    public void d() {
        super.d();
        BadParcelableCrashOptimizer.fix(this.f14253a);
    }
}
