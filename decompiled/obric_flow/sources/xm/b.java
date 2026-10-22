package xm;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.lynx.tasm.animation.keyframe.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f23161a;

    public b(d r5) {
        this.f23161a = r5;
    }

    @Override // com.lynx.tasm.animation.keyframe.d
    public final void a(String r5) {
        this.f23161a.f23171l.remove(r5);
        View r10 = this.f23161a.f23164a.getView();
        if (r10 != null) goto L5;
        return;
    L5:
        ViewParent r11 = r10.getParent();
        if (r11 == null) goto L8;
        ((ViewGroup) r11).removeView(r10);
    L8:
        this.f23161a.f23170k = false;
    }
}
