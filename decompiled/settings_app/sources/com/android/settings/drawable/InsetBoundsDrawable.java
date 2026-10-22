package com.android.settings.drawable;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class InsetBoundsDrawable extends DrawableWrapper {
    private final int mInsetBoundsSides;

    public InsetBoundsDrawable(Drawable r1, int r2) {
        super(r1);
        this.mInsetBoundsSides = r2;
    }

    @Override // com.android.settings.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setBounds(int r2, int r3, int r4, int r5) {
        int r0 = this.mInsetBoundsSides;
        super.setBounds(r2 + r0, r3, r4 - r0, r5);
    }
}
