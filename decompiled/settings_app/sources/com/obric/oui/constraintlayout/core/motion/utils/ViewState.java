package com.obric.oui.constraintlayout.core.motion.utils;

import com.obric.oui.constraintlayout.core.motion.MotionWidget;

/* JADX INFO: loaded from: classes4.dex */
public class ViewState {
    public int bottom;
    public int left;
    public int right;
    public float rotation;
    public int top;

    public ViewState() {
    }

    public void getState(MotionWidget r2) {
        this.left = r2.getLeft();
        this.top = r2.getTop();
        this.right = r2.getRight();
        this.bottom = r2.getBottom();
        this.rotation = (int) r2.getRotationZ();
    }

    public int width() {
        return this.right - this.left;
    }

    public int height() {
        return this.bottom - this.top;
    }
}
