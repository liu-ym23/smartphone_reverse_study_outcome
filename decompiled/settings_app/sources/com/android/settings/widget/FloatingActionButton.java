package com.android.settings.widget;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton extends ImageView {
    public FloatingActionButton(Context r1, AttributeSet r2) {
        super(r1, r2);
        setScaleType(ImageView.ScaleType.CENTER);
        setStateListAnimator(AnimatorInflater.loadStateListAnimator(r1, R.anim.fab_elevation));
        setOutlineProvider(new AnonymousClass1(this));
        setClipToOutline(true);
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        invalidateOutline();
    }
}
