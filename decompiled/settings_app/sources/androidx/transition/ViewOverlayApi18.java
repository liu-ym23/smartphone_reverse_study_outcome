package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: loaded from: classes.dex */
class ViewOverlayApi18 implements ViewOverlayImpl {
    private final ViewOverlay mViewOverlay;

    ViewOverlayApi18(View r1) {
        this.mViewOverlay = r1.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(Drawable r1) {
        this.mViewOverlay.add(r1);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(Drawable r1) {
        this.mViewOverlay.remove(r1);
    }
}
