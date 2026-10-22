package um;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f22376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22378c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f22379h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f22380i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f22381j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f22382k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f22383l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f22384m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f22385n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f22386o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f22387p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f22388q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Rect f22389r;
    public com.obric.oui.panel.header.a s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public f f22390t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public i f22391u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public g f22392v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final SparseArray f22393w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f22394x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f22395y;

    public e() {
        this.f22393w = new SparseArray(0);
        this.f22394x = -1.0f;
        this.f22395y = false;
    }

    public static void c(e r5, String r10) {
        WeakReference r11 = r5.f22376a;
        if (r11 == null) goto L5;
        LynxUI r12 = (LynxUI) r11.get();
    L6:
        if (r12 == null) goto L21;
        View r13 = r12.getView();
        com.obric.oui.panel.header.a r14 = r5.s;
        if (r14 == null) goto L13;
        if (r13 == null) goto L12;
        r13.removeOnAttachStateChangeListener(r14);
    L12:
        r5.s = null;
    L13:
        r5.d();
        HashMap r15 = d.f22375a;
        if (r12.getEvents() != null) goto L16;
        return;
    L16:
        if (r12.getEvents().containsKey("animationend") == false) goto L20;
        HashMap r16 = d.f22375a;
        r16.put("animation_type", r10);
        r12.getLynxContext().g.b(new on.b(r12.getSign(), "animationend", r16));
        return;
    L20:
        return;
    L21:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void a(View r5, String r10) {
        WeakReference r11 = this.f22376a;
        if (r11 == null) goto L5;
        LynxUI r12 = (LynxUI) r11.get();
    L6:
        if (r12 == null) goto L18;
        com.obric.oui.panel.header.a r13 = this.s;
        if (r13 != null) goto L11;
    L13:
        View.OnAttachStateChangeListener r14 = this.s;
        if (r14 == null) goto L16;
        r5.removeOnAttachStateChangeListener(r14);
    L16:
        com.obric.oui.panel.header.a r15 = new com.obric.oui.panel.header.a(this, r10);
        this.s = r15;
        r5.addOnAttachStateChangeListener(r15);
        return;
    L11:
        if (((String) r13.f14004c).equals(r10) == false) goto L13;
        return;
    L18:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void b(String r5) {
        com.obric.oui.panel.header.a r10 = this.s;
        if (r10 != null) goto L5;
        return;
    L5:
        if (((String) r10.f14004c).equals(r5) == false) goto L22;
        WeakReference r11 = this.f22376a;
        if (r11 != null) goto L10;
        return;
    L10:
        if (r11.get() == null) goto L19;
        View r12 = ((LynxUI) this.f22376a.get()).getView();
        if (r12 != null) goto L14;
        return;
    L14:
        if (r12.getAnimation() == null) goto L21;
        r12.clearAnimation();
        d();
        return;
    L21:
        return;
    L19:
        return;
    }

    public final void d() {
        WeakReference r5 = this.f22376a;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.get() == null) goto L9;
        ((LynxUI) this.f22376a.get()).updateLayout(this.f22377b, this.f22378c, this.d, this.e, this.f, this.g, this.f22379h, this.f22380i, this.f22385n, this.f22386o, this.f22387p, this.f22388q, this.f22381j, this.f22382k, this.f22383l, this.f22384m, this.f22389r);
        return;
    }
}
