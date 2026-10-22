package zm;

import android.graphics.Rect;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f23503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final an.a f23504b;

    public m(an.a r5) {
        this.f23503a = new Rect();
        this.f23504b = r5;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
        Rect r10 = this.f23503a;
        if (r10.width() != 0) goto L5;
        return;
    L5:
        if (r10.height() == 0) goto L10;
        an.a r11 = this.f23504b;
        r11.setBounds(r10);
        r5.setShader(r11.f326b);
        return;
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r5) {
    }
}
