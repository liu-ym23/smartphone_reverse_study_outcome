package um;

import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f22373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22374b;

    public c(e r5, String r10) {
        this.f22373a = new WeakReference(r5);
        this.f22374b = r10;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r24) {
        e r5 = (e) this.f22373a.get();
        if (r5 == null) goto L40;
        WeakReference r10 = r5.f22376a;
        if (r10 == null) goto L8;
        LynxUI r11 = (LynxUI) r10.get();
    L9:
        if (r11 == null) goto L41;
        View r12 = r11.getView();
        String r13 = this.f22374b;
        e.c(r5, r13);
        if (r13 == "layout-animation-create") goto L26;
        if (r13 == "layout-animation-update") goto L26;
        if (r13 == "layout-animation-delete") goto L19;
        return;
    L19:
        if ((r24 instanceof j) == true) goto L21;
    L23:
        r11.updateLayout(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new Rect());
        return;
    L21:
        if (r5.f22395y == false) goto L23;
        r12.setLayerType(0, null);
        r5.f22395y = false;
    L26:
        if ((r24 instanceof h) == false) goto L30;
        r5.f22393w.remove(r11.getSign());
        return;
    L30:
        if ((r24 instanceof j) == true) goto L32;
        return;
    L32:
        if (r5.f22395y == false) goto L39;
        if (r12 == null) goto L35;
        r12.setLayerType(0, null);
    L35:
        r5.f22395y = false;
        return;
    L39:
        return;
    L41:
        return;
    L8:
        r11 = null;
        goto L9
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r5) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r10) {
        e r5 = (e) this.f22373a.get();
        if (r5 == null) goto L44;
        WeakReference r11 = r5.f22376a;
        if (r11 == null) goto L8;
        LynxUI r12 = (LynxUI) r11.get();
    L9:
        if (r12 == null) goto L45;
        View r13 = r12.getView();
        HashMap r14 = d.f22375a;
        Map<String, on.a> r15 = r12.getEvents();
        String r16 = this.f22374b;
        if (r15 == null) goto L17;
        if (r12.getEvents().containsKey("animationstart") == false) goto L17;
        HashMap r17 = d.f22375a;
        r17.put("animation_type", r16);
        r12.getLynxContext().g.b(new on.b(r12.getSign(), "animationstart", r17));
    L17:
        if (r16 == "layout-animation-create") goto L30;
        if (r16 == "layout-animation-update") goto L30;
        if (r16 == "layout-animation-delete") goto L24;
        return;
    L24:
        if ((r10 instanceof j) == true) goto L26;
        return;
    L26:
        if (r13.getLayerType() != 0) goto L41;
        r5.f22395y = true;
        r13.setLayerType(2, null);
        return;
    L41:
        return;
    L30:
        if ((r10 instanceof h) == false) goto L34;
        r5.f22393w.put(r12.getSign(), (h) r10);
        return;
    L34:
        if ((r10 instanceof j) == true) goto L36;
        return;
    L36:
        if (r13.getLayerType() != 0) goto L43;
        r5.f22395y = true;
        r13.setLayerType(2, null);
        return;
    L43:
        return;
    L45:
        return;
    L8:
        r12 = null;
        goto L9
    }
}
