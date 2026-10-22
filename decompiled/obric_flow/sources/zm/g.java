package zm;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23484c;
    public final String d;
    public final String e;
    public final boolean f;

    public g(String r5, int r10, int r11, String r12, boolean r13, String r14) {
        this.f23482a = r10;
        this.f23483b = r11;
        this.f23484c = r5;
        this.d = r12;
        this.e = r14;
        this.f = r13;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L15:
        return false;
    L8:
        if (g.class != r5.getClass()) goto L15;
        g r10 = (g) r5;
        if (this.f23482a != r10.f23482a) goto L15;
        if (this.f23483b != r10.f23483b) goto L15;
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f23482a), Integer.valueOf(this.f23483b)});
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r10) {
        int r5 = this.f23483b;
        String r11 = this.d;
        t.h(r10, this.f23484c, this.f23482a, r5, r11, this.e, this.f);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r10) {
        int r5 = this.f23483b;
        String r11 = this.d;
        t.h(r10, this.f23484c, this.f23482a, r5, r11, this.e, this.f);
    }
}
