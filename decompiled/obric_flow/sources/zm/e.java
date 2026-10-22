package zm;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f23477a;

    public e(float r5) {
        this.f23477a = r5;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
        float r10 = this.f23477a;
        if (Float.isNaN(r10) == true) goto L6;
        r5.setLetterSpacing(r10 / r5.getTextSize());
        return;
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r5) {
        float r10 = this.f23477a;
        if (Float.isNaN(r10) == true) goto L6;
        r5.setLetterSpacing(r10 / r5.getTextSize());
        return;
    }
}
