package uq;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends a.a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f22428y;

    public /* synthetic */ b(int r5) {
        this.f22428y = r5;
    }

    @Override // a.a
    public final void E(Object r5, float r10) {
        switch(this.f22428y) {
            case 0: goto L16;
            case 1: goto L14;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L6;
            default: goto L4;
        };
    L4:
        ((View) r5).setRotationY(r10);
        return;
    L6:
        ((View) r5).setRotationX(r10);
        return;
    L8:
        ((View) r5).setRotation(r10);
        return;
    L10:
        ((View) r5).setScaleY(r10);
        return;
    L12:
        ((View) r5).setScaleX(r10);
        return;
    L14:
        ((View) r5).setTranslationY(r10);
        return;
    L16:
        ((View) r5).setAlpha(r10);
    }

    @Override // a.a
    public final float u(Object r5) {
        switch(this.f22428y) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            default: goto L5;
        };
    L5:
        return ((View) r5).getRotationY();
    L7:
        return ((View) r5).getRotationX();
    L9:
        return ((View) r5).getRotation();
    L11:
        return ((View) r5).getScaleY();
    L13:
        return ((View) r5).getScaleX();
    L15:
        return ((View) r5).getTranslationY();
    L17:
        return ((View) r5).getAlpha();
    }
}
