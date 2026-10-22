package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(18)
class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {
    private final ViewGroupOverlay mViewGroupOverlay;

    ViewGroupOverlayApi18(@NonNull ViewGroup r1) {
        this.mViewGroupOverlay = r1.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(@NonNull Drawable r1) {
        this.mViewGroupOverlay.add(r1);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void add(@NonNull View r1) {
        this.mViewGroupOverlay.add(r1);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(@NonNull Drawable r1) {
        this.mViewGroupOverlay.remove(r1);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void remove(@NonNull View r1) {
        this.mViewGroupOverlay.remove(r1);
    }
}
