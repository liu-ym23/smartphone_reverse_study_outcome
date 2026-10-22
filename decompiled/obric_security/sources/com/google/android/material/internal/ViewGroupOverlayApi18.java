package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: loaded from: classes2.dex */
class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {
    private final ViewGroupOverlay viewGroupOverlay;

    ViewGroupOverlayApi18(ViewGroup r1) {
        this.viewGroupOverlay = r1.getOverlay();
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void add(Drawable r1) {
        this.viewGroupOverlay.add(r1);
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void remove(Drawable r1) {
        this.viewGroupOverlay.remove(r1);
    }

    @Override // com.google.android.material.internal.ViewGroupOverlayImpl
    public void add(View r1) {
        this.viewGroupOverlay.add(r1);
    }

    @Override // com.google.android.material.internal.ViewGroupOverlayImpl
    public void remove(View r1) {
        this.viewGroupOverlay.remove(r1);
    }
}
