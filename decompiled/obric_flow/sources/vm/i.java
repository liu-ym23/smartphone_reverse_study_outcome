package vm;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import com.airbnb.lottie.t;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.utils.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22602c;
    public int d;
    public boolean e;
    public boolean f;
    public final LynxUI g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f22603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap f22604i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SparseArray f22605j;

    public i(LynxUI r5) {
        this.f22600a = 0;
        this.f22601b = 0;
        this.f22602c = 0;
        this.d = 0;
        this.f22605j = new SparseArray();
        this.g = r5;
        this.f22603h = new HashMap();
        this.f22604i = new HashMap();
    }

    public final ValueAnimator a(int r5, LynxUI r10, int r11, int r12, tm.b r13, boolean r14) {
        ValueAnimator r15 = ValueAnimator.ofInt(new int[]{r11, r12});
        r15.setDuration(r13.f22141b);
        r15.setInterpolator(tm.e.a(r13));
        r15.setStartDelay(r13.f22142c);
        r15.addListener(new g(r10, r5, this, r14));
        if (r5 != 16) goto L5;
        r15.addUpdateListener(new a(r10, 1));
        return r15;
    L5:
        if (r5 != 32) goto L7;
        r15.addUpdateListener(new a(r10, 2));
        return r15;
    L7:
        if (r5 != 256) goto L9;
    L17:
        r15.addUpdateListener(new a(r10, 5));
        return r15;
    L9:
        if (r5 != 512) goto L11;
    L15:
        r15.addUpdateListener(new a(r10, 0));
        return r15;
    L11:
        if (r5 == 1024) goto L17;
        if (r5 == 2048) goto L15;
        return r15;
    }

    public final void b() {
        HashMap r5 = this.f22603h;
        Iterator r10 = ((HashMap) r5.clone()).values().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((Animator) r10.next()).cancel();
        goto L4
    L6:
        r5.clear();
        this.f22604i.clear();
    }

    public final void c(LynxBaseUI r21, int r22, Object r23) {
        if (this.f22605j.size() != 0) goto L5;
        return;
    L5:
        if (this.f22605j.get(r22) == null) goto L60;
        LynxUI r5 = this.g;
        if (r5 == null) goto L10;
        LynxBaseUI r10 = r5;
    L11:
        tm.b r11 = (tm.b) this.f22605j.get(r22);
        HashMap r12 = this.f22604i;
        float r13 = 1.0f;
        if (r22 == 1) goto L52;
        if (r22 != 64) goto L16;
        Integer r14 = (Integer) r23;
        int r15 = r14.intValue();
        ValueAnimator r16 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r10.getLynxBackground().e), r14});
        r12.put(64, r16);
        r16.setDuration(Math.round(r11.f22141b));
        r16.setInterpolator(tm.e.a(r11));
        r16.setStartDelay(r11.f22142c);
        r16.addListener(new b(this, r10, r22, r10, r15));
        r16.addUpdateListener(new t(r10, 6));
        return;
    L16:
        if (r22 == 128) goto L28;
        if (r22 == 4096) goto L21;
        return;
    L21:
        if ((r10 instanceof LynxUI) == false) goto L62;
        LynxUI r17 = (LynxUI) r10;
        r17.getLynxContext().f10145m.getFontSize();
        r17.getFontSize();
        r17.getLynxContext().f10145m.getLatestWidth();
        r17.getLynxContext().f10145m.getLatestHeight();
        n r18 = n.n((List) r23, r17.getLatestWidth(), r17.getLatestHeight());
        if (r18 == null) goto L63;
        float r19 = r17.getTranslationX();
        float r110 = r17.getTranslationY();
        float r111 = r17.getView().getTranslationZ();
        float r112 = r17.getView().getRotation();
        float r113 = r17.getView().getRotationX();
        float r114 = r17.getView().getRotationY();
        float r115 = r17.getView().getScaleX();
        float r116 = r17.getView().getScaleY();
        ValueAnimator r20 = ValueAnimator.ofInt(new int[]{0});
        r12.put(4096, r20);
        r20.setDuration(r11.f22141b);
        r20.setInterpolator(tm.e.a(r11));
        r20.setStartDelay(r11.f22142c);
        r20.addListener(new c(this, r17, r22, r17, r18));
        r20.addUpdateListener(new d(r19, r18, r17, r110, r111, r112, r113, r114, r115, r116));
        return;
    L63:
        return;
    L62:
        return;
    L28:
        if (this.f == false) goto L31;
        return;
    L31:
        if ((r10.getParent() instanceof UIShadowProxy) == false) goto L33;
        LynxUI r24 = (LynxUI) r10.getParent();
    L34:
        int r25 = ((Integer) r23).intValue();
        int r117 = r24.getView().getVisibility();
        if (r25 != 1) goto L37;
        int r26 = 0;
    L38:
        if (r117 == r26) goto L65;
        this.e = true;
        float r27 = r24.getView().getAlpha();
        float r28 = 0.0f;
        if (r117 != 0) goto L44;
        r13 = 0.0f;
    L43:
        r28 = r27;
    L49:
        ValueAnimator r118 = ValueAnimator.ofObject(new FloatEvaluator(), new Object[]{Float.valueOf(r28), Float.valueOf(r13)});
        r118.setDuration(r11.f22141b);
        r118.setInterpolator(tm.e.a(r11));
        r118.setStartDelay(r11.f22142c);
        r118.addUpdateListener(new a(r24, 4));
        r118.addListener(new f(this, r10, r22, r24, r26, r27));
        r12.put(128, r118);
        return;
    L44:
        if (r117 != 4) goto L46;
    L47:
        if (r26 != 0) goto L43;
        r24.getView().setAlpha(0.0f);
        goto L49
    L46:
        if (r117 != 8) goto L43;
    L65:
        return;
    L37:
        r26 = 4;
        goto L38
    L33:
        r24 = (LynxUI) r10;
        goto L34
    L52:
        if (this.e == true) goto L66;
        float r29 = Math.min(((Float) r23).floatValue(), 1.0f);
        LynxUI r30 = (LynxUI) r10;
        ValueAnimator r119 = ValueAnimator.ofObject(new FloatEvaluator(), new Object[]{Float.valueOf(r30.getView().getAlpha()), Float.valueOf(r29)});
        r12.put(1, r119);
        r119.setDuration(r11.f22141b);
        r119.setInterpolator(tm.e.a(r11));
        r119.setStartDelay(r11.f22142c);
        r119.addListener(new e(this, r30, r22, r30, r29));
        r119.addUpdateListener(new a(r30, 3));
        this.f = true;
        return;
    L66:
        return;
    L10:
        r10 = r21;
        goto L11
    }

    public final void d(Integer r5) {
        HashMap r10 = this.f22603h;
        Animator r11 = (Animator) r10.get(r5);
        if (r11 == null) goto L6;
        r11.cancel();
        r10.remove(r5);
        return;
    }

    public final boolean e(int r5) {
        if (this.f22605j.indexOfKey(r5) < 0) goto L6;
        return true;
    L6:
        return false;
    }
}
