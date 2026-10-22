package wn;

import android.graphics.Matrix;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends f {
    public static final g e = null;
    public static final g f = null;
    public static final g g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g f22893h = null;
    public final /* synthetic */ int d;

    static {
        e = new g(0);
        f = new g(1);
        g = new g(2);
        f22893h = new g(3);
    }

    public /* synthetic */ g(int r5) {
        this.d = r5;
    }

    @Override // wn.f
    public final void b(Matrix r5, float r10, float r11, float r12, float r13, float r14, float r15) {
        switch(this.d) {
            case 0: goto L16;
            case 1: goto L11;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        r5.setScale(r10 / r12, r11 / r13);
        r5.postTranslate(r14, r15);
        return;
    L6:
        float r16 = r10 / r12;
        float r17 = r11 / r13;
        if (r16 <= r17) goto L9;
        r5.setScale(r17, r17);
        r5.postTranslate(((r10 - (r12 * r17)) / 2.0f) + r14, r15);
        return;
    L9:
        r5.setScale(r16, r16);
        r5.postTranslate(r14, ((r11 - (r13 * r16)) / 2.0f) + r15);
        return;
    L11:
        float r18 = r10 / r12;
        float r19 = r11 / r13;
        if (r18 <= r19) goto L14;
        r5.setScale(r18, r18);
        r5.postTranslate(r14, ((r11 - (r13 * r18)) / 2.0f) + r15);
        return;
    L14:
        r5.setScale(r19, r19);
        r5.postTranslate(((r10 - (r12 * r19)) / 2.0f) + r14, r15);
        return;
    L16:
        float r20 = com.lynx.tasm.utils.g.a(1.0f, 0.0f);
        float r21 = Math.round((r10 - (r12 * r20)) * 0.5f);
        float r22 = Math.round((r11 - (r13 * r20)) * 0.5f);
        r5.setScale(r20, r20);
        r5.postTranslate(r21, r22);
    }

    public final String toString() {
        switch(this.d) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        return "fit_xy";
    L6:
        return "fit_center";
    L8:
        return "center_crop";
    L10:
        return "center";
    }
}
