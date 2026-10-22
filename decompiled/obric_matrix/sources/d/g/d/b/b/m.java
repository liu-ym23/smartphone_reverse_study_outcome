package d.g.d.b.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f16800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f16801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private i f16802c;

    static {
        new d.g.d.b.a();
    }

    public m(Context r2, AttributeSet r3, int r4, int r5) {
        kotlin.n0.d.o.f(r2, "context");
        this.f16800a = new j(r2, r3, r4, r5);
        this.f16801b = new g(r2, r3, r4, r5);
    }

    public e a() {
        return this.f16801b;
    }

    public i b() {
        i r0 = this.f16802c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        kotlin.n0.d.o.v("mOUIEffectHelper");
        throw null;
    }

    public f c() {
        return this.f16800a;
    }

    public final void d(View r2) {
        kotlin.n0.d.o.f(r2, "owner");
        this.f16800a.F(r2);
        this.f16801b.f(r2);
        this.f16802c = new i(r2);
    }
}
