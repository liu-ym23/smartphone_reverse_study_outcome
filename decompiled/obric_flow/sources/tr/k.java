package tr;

import android.animation.Animator;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f22174b;

    public /* synthetic */ k(Object r5, int r10) {
        this.f22173a = r10;
        this.f22174b = r5;
    }

    private final void a(Animator r5) {
    }

    private final void b(Animator r5) {
    }

    private final void c(Animator r5) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
        switch(this.f22173a) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        Intrinsics.checkNotNullParameter(r5, "arg0");
        return;
    L7:
        Intrinsics.checkNotNullParameter(r5, "arg0");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        Object r10 = this.f22174b;
        switch(this.f22173a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        ((com.obric.flow.cardlistpage.ui.popup.b) r10).e = null;
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "arg0");
        int r11 = OIndexScrollbar.D;
        OIndexScrollbar r12 = (OIndexScrollbar) r10;
        r12.getClass();
        OIndexScrollbar.a(r12);
        return;
    L8:
        Intrinsics.checkNotNullParameter(r5, "arg0");
        OIndexScrollbar r13 = (OIndexScrollbar) r10;
        r13.getClass();
        r13.e();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r5) {
        switch(this.f22173a) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        Intrinsics.checkNotNullParameter(r5, "arg0");
        return;
    L7:
        Intrinsics.checkNotNullParameter(r5, "arg0");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        Object r10 = this.f22174b;
        switch(this.f22173a) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        Intrinsics.checkNotNullParameter(r5, "arg0");
        int r11 = OIndexScrollbar.D;
        OIndexScrollbar r12 = (OIndexScrollbar) r10;
        r12.getClass();
        OIndexScrollbar.b(r12);
        return;
    L7:
        Intrinsics.checkNotNullParameter(r5, "arg0");
        ((OIndexScrollbar) r10).getClass();
    }
}
