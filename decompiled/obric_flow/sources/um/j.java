package um;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f22396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f22397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f22398c;

    public j(View r5, float r10, float r11) {
        this.f22396a = r5;
        this.f22397b = r10;
        this.f22398c = r11 - r10;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r5, Transformation r10) {
        float r11 = (this.f22398c * r5) + this.f22397b;
        this.f22396a.setAlpha(r11);
    }

    @Override // android.view.animation.Animation
    public final boolean willChangeBounds() {
        return false;
    }
}
