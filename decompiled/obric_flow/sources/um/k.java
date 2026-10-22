package um;

import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends Animation implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxUI f22399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f22400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22401c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f22402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f22403i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f22404j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f22405k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f22406l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f22407m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f22408n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Rect f22409o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f22410p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f22411q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f22412r;
    public float s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f22413t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f22414u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f22415v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f22416w;

    public k(LynxUI r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r110, int r111, int r112, int r113, int r20, int r21, int r22, Rect r23) {
        this.f22399a = r10;
        this.f22400b = r10.getView();
        this.f22401c = r15;
        this.d = r16;
        this.e = r17;
        this.f = r18;
        this.g = r19;
        this.f22402h = r110;
        this.f22403i = r111;
        this.f22404j = r112;
        this.f22405k = r113;
        this.f22406l = r20;
        this.f22407m = r21;
        this.f22408n = r22;
        this.f22409o = r23;
        a(r11, r12, r13, r14);
    }

    public final void a(int r5, int r10, int r11, int r12) {
        LynxUI r13 = this.f22399a;
        this.f22410p = r13.getOriginLeft() - r13.getTranslationX();
        this.f22411q = r13.getOriginTop() - r13.getTranslationY();
        this.f22413t = r13.getWidth();
        int r14 = r13.getHeight();
        this.f22414u = r14;
        this.f22412r = r5 - this.f22410p;
        this.s = r10 - this.f22411q;
        this.f22415v = r11 - this.f22413t;
        this.f22416w = r12 - r14;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r25, Transformation r26) {
        float r5 = (this.f22412r * r25) + this.f22410p;
        float r10 = (this.s * r25) + this.f22411q;
        float r11 = (this.f22415v * r25) + this.f22413t;
        float r12 = (this.f22416w * r25) + this.f22414u;
        this.f22399a.updateLayout(Math.round(r5), Math.round(r10), Math.round(r11), Math.round(r12), this.f22401c, this.d, this.e, this.f, this.g, this.f22402h, this.f22403i, this.f22404j, this.f22405k, this.f22406l, this.f22407m, this.f22408n, this.f22409o);
    }

    @Override // android.view.animation.Animation
    public final boolean willChangeBounds() {
        return true;
    }
}
