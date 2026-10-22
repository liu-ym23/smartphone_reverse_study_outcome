package androidx.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
class ViewGroupOverlayApi14 extends ViewOverlayApi14 implements ViewGroupOverlayImpl {
    ViewGroupOverlayApi14(Context r1, ViewGroup r2, View r3) {
        super(r1, r2, r3);
    }

    static ViewGroupOverlayApi14 createFrom(ViewGroup r0) {
        return (ViewGroupOverlayApi14) ViewOverlayApi14.createFrom(r0);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void add(@NonNull View r1) {
        this.mOverlayViewGroup.add(r1);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void remove(@NonNull View r1) {
        this.mOverlayViewGroup.remove(r1);
    }
}
