package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(18)
class ViewOverlayApi18 implements ViewOverlayImpl {
    private final ViewOverlay mViewOverlay;

    ViewOverlayApi18(@NonNull View r1) {
        this.mViewOverlay = r1.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(@NonNull Drawable r1) {
        this.mViewOverlay.add(r1);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(@NonNull Drawable r1) {
        this.mViewOverlay.remove(r1);
    }
}
