package ts;

import android.os.IBinder;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import fn.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f22176b;

    public /* synthetic */ a(i r5, int r10) {
        this.f22175a = r10;
        this.f22176b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f22175a) {
            case 0: goto L20;
            default: goto L4;
        };
    L4:
        i r10 = this.f22176b;
        Intrinsics.checkNotNullParameter(r10, "this$0");
        if (r10.f16960c == false) goto L19;
        FrameLayout r11 = (FrameLayout) r10.d;
        Object r5 = r11.getContext().getSystemService("window");
        if (r5 == null) goto L18;
        WindowManager r12 = (WindowManager) r5;
        ViewGroup.LayoutParams r13 = r11.getLayoutParams();
        if ((r13 instanceof WindowManager.LayoutParams) == false) goto L11;
        WindowManager.LayoutParams r14 = (WindowManager.LayoutParams) r13;
    L12:
        int r15 = r11.getMeasuredHeight();
        if (r14 != null) goto L15;
        return;
    L15:
        if (r14.height == r15) goto L55;
        r14.height = r15;
        r12.updateViewLayout(r11, r14);
        return;
    L55:
        return;
    L11:
        r14 = null;
        goto L12
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    L19:
        return;
    L20:
        i r16 = this.f22176b;
        Intrinsics.checkNotNullParameter(r16, "this$0");
        if (((FrameLayout) r16.d).isAttachedToWindow() == false) goto L51;
        FrameLayout r17 = (FrameLayout) r16.d;
        if ((r17.getParent() instanceof ViewGroup) == false) goto L57;
        ViewParent r18 = r17.getParent();
        if (r18 == null) goto L50;
        ViewGroup r19 = (ViewGroup) r18;
        r16.e = r19;
        r19.removeView(r17);
        ViewGroup r20 = (ViewGroup) r16.e;
        if (r20 == null) goto L30;
        r20.addOnAttachStateChangeListener((bf.b) r16.f);
    L30:
        Object r21 = r17.getContext().getSystemService("window");
        if (r21 == null) goto L48;
        WindowManager r22 = (WindowManager) r21;
        WindowManager.LayoutParams r23 = new WindowManager.LayoutParams(-1, -2, 1000, 16778024, -3);
        r23.gravity = r16.f16959b;
        ViewGroup r24 = (ViewGroup) r16.e;
        if (r24 != null) goto L35;
        IBinder r25 = null;
    L36:
        r23.token = r25;
        r22.addView(r17, r23);     // Catch: Exception -> L45
        r16.f16960c = true;     // Catch: Exception -> L45
        ViewGroup r26 = (ViewGroup) r16.e;     // Catch: Exception -> L45
        if (r26 != null) goto L41;
        return;
    L41:
        if (r26.getRootWindowInsets() == null) goto L59;
        r17.requestApplyInsets();     // Catch: Exception -> L45
        return;
    L59:
        return;
    L45:
        e = move-exception;
        ps.a.c("OFloatingWindowHelper", Intrinsics.stringPlus("Failed to add view to WindowManager: ", e.getMessage()));
        return;
    L35:
        r25 = r24.getWindowToken();
        goto L36
    L48:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    L50:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L57:
        return;
    }
}
