package zm;

import android.graphics.Typeface;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f23471a;

    public c0(BaseTextShadowNode r5) {
        this.f23471a = new WeakReference(r5);
    }

    @Override // zm.f0
    public final void b(Typeface r5, int r10) {
        ShadowNode r11 = (ShadowNode) this.f23471a.get();
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.f10351o == false) goto L8;
        return;
    L8:
        if ((r11 instanceof BaseTextShadowNode) == false) goto L10;
        ((BaseTextShadowNode) r11).f10357v.A = true;
    L10:
        r11.n();
    }
}
