package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"AppCompatCustomView"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class VisibilityAwareImageButton extends ImageButton {
    private int userSetVisibility;

    public VisibilityAwareImageButton(Context r2) {
        this(r2, null);
    }

    public final int getUserSetVisibility() {
        return this.userSetVisibility;
    }

    public final void internalSetVisibility(int r1, boolean r2) {
        super.setVisibility(r1);
        if (r2 == false) goto L6;
        this.userSetVisibility = r1;
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int r2) {
        internalSetVisibility(r2, true);
    }

    public VisibilityAwareImageButton(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public VisibilityAwareImageButton(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.userSetVisibility = getVisibility();
    }
}
