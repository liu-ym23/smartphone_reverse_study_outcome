package xm;

import android.view.View;
import android.view.ViewGroup;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements com.lynx.tasm.animation.keyframe.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f23162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f23163b;

    public c(d r5, g r10) {
        this.f23163b = r5;
        this.f23162a = r10;
    }

    @Override // com.lynx.tasm.animation.keyframe.d
    public final void a(String r27) {
        this.f23163b.f23171l.remove(r27);
        d r5 = this.f23163b;
        if (r5.f23166c == null) goto L11;
        View r10 = r5.f23164a.getView();
        if (r10 == null) goto L11;
        ViewGroup r11 = (ViewGroup) r10.getParent();
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if (r11 == null) goto L10;
        r11.removeView(r10);
    L10:
        int[] r13 = new int[2];
        r5.f23166c.getLocationOnScreen(r13);
        r5.d.removeChild(r5.f23164a);
        r5.d.insertChild(r5.f23164a, r5.f23165b);
        int r14 = r10.getLeft() + r13[0];
        int r15 = r10.getTop() - r13[1];
        LynxUI r16 = r5.f23164a;
        r16.updateLayout(r14, r15, r12.width, r12.height, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r16.getBound());
    L11:
        g r17 = this.f23162a;
        if (r17 == null) goto L14;
        ((e) r17).f23172a.decrementAndGet();
    L14:
        this.f23163b.f23169j = false;
    }
}
