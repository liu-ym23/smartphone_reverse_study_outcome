package androidx.constraintlayout.motion.utils;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ViewState {
    public int bottom;
    public int left;
    public int right;
    public float rotation;
    public int top;

    public ViewState() {
    }

    public void getState(View r2) {
        this.left = r2.getLeft();
        this.top = r2.getTop();
        this.right = r2.getRight();
        this.bottom = r2.getBottom();
        this.rotation = r2.getRotation();
    }

    public int height() {
        return this.bottom - this.top;
    }

    public int width() {
        return this.right - this.left;
    }
}
