package zl;

import com.lynx.animax.UIAnimaX;
import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.i;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.utils.n;
import com.lynx.tasm.r;
import dm.c;
import java.lang.ref.WeakReference;
import java.util.Map;
import jm.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends BaseAbility implements c {
    public boolean f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final WeakReference f23454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakReference f23455i;

    public a(UIAnimaX r5, LynxContext r10) {
        this.f = true;
        this.g = false;
        this.f23454h = new WeakReference(r5);
        this.f23455i = new WeakReference(r10);
        this.f9575a.add(this);
        this.g = b.b(b.a("ANIMAX_DISABLE_SHOW_EVENT_LOGBOX", this));
    }

    @Override // dm.c
    public final void a(n r5) {
        p("compositionready", r5);
    }

    @Override // dm.c
    public final void b(n r5) {
        p("completion", r5);
    }

    @Override // dm.c
    public final void c(n r5) {
        p("start", r5);
    }

    @Override // dm.c
    public final void d(n r5) {
        if (this.f == false) goto L6;
        p("update", r5);
        return;
    }

    @Override // dm.c
    public final void e(n r5) {
        p("ready", r5);
    }

    @Override // dm.c
    public final void f(n r5) {
        p("cancel", r5);
    }

    @Override // dm.c
    public final void g(dm.b r5) {
        p("fps", r5);
    }

    @Override // dm.c
    public final void h(n r5) {
        p("repeat", r5);
    }

    @Override // dm.c
    public final void i(dm.a r5) {
        p("warning", r5);
        o(r5, "warn");
    }

    @Override // dm.c
    public final void j(n r5) {
        p("firstframe", r5);
    }

    @Override // dm.c
    public final void k(dm.b r5) {
        p("taplayers", r5);
    }

    @Override // dm.c
    public final void l(dm.a r5) {
        Object r10 = ((Map) r5.f10761a).get("code");
        if ((r10 instanceof Number) == false) goto L5;
        int r11 = ((Number) r10).intValue();
    L7:
        if (r11 != 100) goto L9;
        return;
    L9:
        if (r11 == 101) goto L14;
        p("error", r5);
        o(r5, "error");
        return;
    L14:
        return;
    L5:
        r11 = -1;
        goto L7
    }

    @Override // com.lynx.animax.ability.BaseAbility
    public final String m(String r5) {
        LynxContext r10 = (LynxContext) this.f23455i.get();
        if (r10 != null) goto L6;
        return r5;
    L6:
        return dn.a.J(r10, false, r5);
    }

    public final void o(dm.a r10, String r11) {
        if (this.g == true) goto L20;
        LynxContext r12 = (LynxContext) this.f23455i.get();
        if (r12 != null) goto L8;
        return;
    L8:
        Map r13 = (Map) r10.f10761a;
        Object r5 = r13.get("code");
        if ((r5 instanceof Number) == false) goto L12;
        int r14 = ((Number) r5).intValue();
    L11:
        int r15 = r14;
        Object r16 = r13.get("msg");
        if ((r16 instanceof String) == false) goto L17;
        String r17 = (String) r16;
    L18:
        LynxError r18 = new LynxError(r15, r17, "", r11, -2, null, false);
        r18.f9990a = true;
        r12.b(r18);
        return;
    L17:
        r17 = null;
        goto L18
    L12:
        r14 = -1;
        goto L11
    }

    public final void p(String r5, n r10) {
        LynxBaseUI r11 = (LynxBaseUI) this.f23454h.get();
        LynxContext r12 = (LynxContext) this.f23455i.get();
        if (r11 == null) goto L8;
        if (r12 == null) goto L9;
        r r13 = r12.g;
        int r14 = r11.getSign();
        r13.b(new i((Map) r10.f10761a, r5, r14, 2));
        return;
    L9:
        return;
    }
}
