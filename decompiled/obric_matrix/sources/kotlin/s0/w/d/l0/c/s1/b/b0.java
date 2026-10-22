package kotlin.s0.w.d.l0.c.s1.b;

import com.bytedance.common.wschannel.WsConstants;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends p implements kotlin.s0.w.d.l0.e.a.n0.b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z f19110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Annotation[] f19111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f19113d;

    public b0(z r2, Annotation[] r3, String r4, boolean r5) {
        kotlin.n0.d.o.f(r2, WsConstants.KEY_CONNECTION_TYPE);
        kotlin.n0.d.o.f(r3, "reflectAnnotations");
        this.f19110a = r2;
        this.f19111b = r3;
        this.f19112c = r4;
        this.f19113d = r5;
    }

    public e R(kotlin.s0.w.d.l0.g.c r2) {
        kotlin.n0.d.o.f(r2, "fqName");
        return i.a(this.f19111b, r2);
    }

    public List<e> S() {
        return i.b(this.f19111b);
    }

    public z T() {
        return this.f19110a;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.b0
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.n0.x b() {
        return T();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.b0
    public boolean c() {
        return this.f19113d;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return S();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.b0
    public kotlin.s0.w.d.l0.g.f getName() {
        String r0 = this.f19112c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return kotlin.s0.w.d.l0.g.f.j(r0);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.n0.a i(kotlin.s0.w.d.l0.g.c r1) {
        return R(r1);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public boolean l() {
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(b0.class.getName());
        r0.append(": ");
        if (c() == false) goto L5;
        String r2 = "vararg ";
    L6:
        r0.append(r2);
        r0.append(getName());
        r0.append(": ");
        r0.append(T());
        return r0.toString();
    L5:
        r2 = "";
        goto L6
    }
}
