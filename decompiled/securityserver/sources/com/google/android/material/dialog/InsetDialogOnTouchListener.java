package com.google.android.material.dialog;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class InsetDialogOnTouchListener implements View.OnTouchListener {

    @NonNull
    private final Dialog dialog;
    private final int leftInset;
    private final int prePieSlop;
    private final int topInset;

    public InsetDialogOnTouchListener(@NonNull Dialog r2, @NonNull Rect r3) {
        this.dialog = r2;
        this.leftInset = r3.left;
        this.topInset = r3.top;
        this.prePieSlop = ViewConfiguration.get(r2.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View r6, @NonNull MotionEvent r7) {
        View r0 = r6.findViewById(R.id.content);
        int r2 = r0.getLeft() + this.leftInset;
        int r1 = r0.getWidth() + r2;
        int r4 = r0.getTop() + this.topInset;
        if (new RectF(r2, r4, r1, r0.getHeight() + r4).contains(r7.getX(), r7.getY()) == false) goto L6;
        return false;
    L6:
        MotionEvent r3 = MotionEvent.obtain(r7);
        if (r7.getAction() != 1) goto L9;
        r3.setAction(4);
    L9:
        r6.performClick();
        return this.dialog.onTouchEvent(r3);
    }
}
