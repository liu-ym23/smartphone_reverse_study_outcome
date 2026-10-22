package zm;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends CharacterStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.lynx.tasm.behavior.ui.r f23506a;

    public o(com.lynx.tasm.behavior.ui.r r5) {
        this.f23506a = r5;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
        com.lynx.tasm.behavior.ui.r r10 = this.f23506a;
        r5.setShadowLayer(r10.d, r10.f10592b, r10.f10593c, r10.f10591a);
    }
}
