package vm;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap f22597c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f22598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22599b;

    static {
        HashMap r5 = new HashMap();
        f22597c = r5;
        r5.put("animation_type", "transition");
    }

    public h(LynxBaseUI r5, int r10) {
        this.f22598a = new WeakReference(r5);
        this.f22599b = r10;
    }

    public final void a(String r5) {
        LynxBaseUI r10 = (LynxBaseUI) this.f22598a.get();
        if (r10 != null) goto L6;
        return;
    L6:
        if ((r10 instanceof UIShadowProxy) == false) goto L9;
        r10 = ((UIShadowProxy) r10).f10388a;
    L9:
        if (r10.getEvents() != null) goto L11;
        return;
    L11:
        if (r10.getEvents().containsKey(r5) == false) goto L34;
        HashMap r11 = f22597c;
        int r12 = this.f22599b;
        if (r12 != 1) goto L15;
        String r13 = "opacity";
    L31:
        r11.put("animation_type", "transition-".concat(r13));
        r10.getLynxContext().g.b(new on.b(r10.getSign(), r5, r11));
        return;
    L15:
        if (r12 == 2) goto L29;
        switch(r12) {
            case 4: goto L28;
            case 8: goto L27;
            case 16: goto L26;
            case 32: goto L25;
            case 64: goto L24;
            case 128: goto L23;
            case 256: goto L22;
            case 512: goto L21;
            case 1024: goto L20;
            case 2048: goto L19;
            case 4096: goto L18;
            default: goto L17;
        };
    L17:
        new IllegalArgumentException(com.lynx.jsbridge.a.d(r12, "Unsupported animated property: "));
        r13 = "none";
        goto L31
    L18:
        r13 = "transform";
        goto L31
    L19:
        r13 = "bottom";
        goto L31
    L20:
        r13 = "right";
        goto L31
    L21:
        r13 = "top";
        goto L31
    L22:
        r13 = OpenPageMethod.ALIGN_LEFT;
        goto L31
    L23:
        r13 = "visibility";
        goto L31
    L24:
        r13 = "background-color";
        goto L31
    L25:
        r13 = "height";
        goto L31
    L26:
        r13 = "width";
        goto L31
    L27:
        r13 = "scaleXY";
        goto L31
    L28:
        r13 = "scaleY";
        goto L31
    L29:
        r13 = "scaleX";
        goto L31
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r5) {
        super.onAnimationEnd(r5);
        a("transitionend");
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r5) {
        super.onAnimationStart(r5);
        a("transitionstart");
    }
}
