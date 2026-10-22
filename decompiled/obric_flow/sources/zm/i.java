package zm;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Typeface f23493a;

    public i(Typeface r5) {
        this.f23493a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 != null) goto L7;
        return false;
    L7:
        if (i.class != r5.getClass()) goto L13;
        Typeface r10 = ((i) r5).f23493a;
        return Objects.equals(this.f23493a, r10);
    L13:
        return false;
    }

    public final int hashCode() {
        Typeface r5 = this.f23493a;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.hashCode();
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
        Typeface r10 = this.f23493a;
        if (r10 == null) goto L6;
        r5.setTypeface(r10);
        return;
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r5) {
        Typeface r10 = this.f23493a;
        if (r10 == null) goto L6;
        r5.setTypeface(r10);
        return;
    }
}
