package tm;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22152b;

    public d(int r5, int r10) {
        this.f22151a = r5;
        this.f22152b = r10;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r5) {
        int r10 = this.f22151a;
        int r11 = this.f22152b;
        if (r11 != 1) goto L5;
        float r12 = r10;
        int r13 = ((int) (r5 * r12)) + 1;
        if (r13 > r10) goto L32;
        r10 = r13;
    L32:
        float r14 = r10;
    L27:
        return r14 / r12;
    L5:
        if (r11 != 2) goto L7;
        r12 = r10;
        int r15 = (int) (r5 * r12);
        if (r15 != r10) goto L25;
        r15 = r15 - 1;
    L25:
        r14 = r15;
        goto L27
    L7:
        if (r11 != 3) goto L9;
        int r16 = (int) (r5 * r10);
        if (r16 != r10) goto L21;
        r16 = r16 - 1;
    L21:
        float r17 = r16;
        int r18 = r10 - 1;
    L17:
        return r17 / r18;
    L9:
        if (r11 == 4) goto L12;
        return 0.0f;
    L12:
        int r19 = ((int) (r5 * r10)) + 1;
        if (r19 <= r10) goto L15;
        r19 = r10;
    L15:
        r17 = r19;
        r18 = r10 + 1;
        goto L17
    }
}
