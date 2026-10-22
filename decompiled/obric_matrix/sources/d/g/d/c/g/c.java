package d.g.d.c.g;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import d.g.d.c.g.a;
import kotlin.a0;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c<D extends a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DialogInterface.OnDismissListener f16922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DialogInterface.OnCancelListener f16923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DialogInterface.OnShowListener f16924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View.OnClickListener f16925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f16926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f16927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a.EnumC0445a f16928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private u<Integer, Integer> f16929h;

    public c(Context r2) {
        o.f(r2, "context");
        this.f16926e = true;
        this.f16928g = a.EnumC0445a.f16915g;
        this.f16929h = a0.a(null, null);
    }

    public static /* synthetic */ c i(c r0, boolean r1, View.OnClickListener r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.h(r1, r2);
        return r0;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCloseIcon");
    }

    public final D a() {
        D r0 = (D) c();
        r0.s(this.f16927f, this.f16925d);
        r0.setCancelable(this.f16926e);
        r0.f(this.f16928g, this.f16929h.c(), this.f16929h.d());
        return r0;
    }

    public c<D> b(boolean r1) {
        this.f16926e = r1;
        return this;
    }

    public abstract D c();

    public final DialogInterface.OnCancelListener d() {
        return this.f16923b;
    }

    public final DialogInterface.OnDismissListener e() {
        return this.f16922a;
    }

    public final boolean f() {
        return this.f16927f;
    }

    public final DialogInterface.OnShowListener g() {
        return this.f16924c;
    }

    public c<D> h(boolean r1, View.OnClickListener r2) {
        this.f16927f = r1;
        this.f16925d = r2;
        return this;
    }
}
