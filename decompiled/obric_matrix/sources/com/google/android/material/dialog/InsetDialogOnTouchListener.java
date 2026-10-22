package com.google.android.material.dialog;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
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
        int r1 = this.leftInset + r0.getLeft();
        int r2 = r0.getWidth() + r1;
        int r3 = this.topInset + r0.getTop();
        if (new RectF(r1, r3, r2, r0.getHeight() + r3).contains(r7.getX(), r7.getY()) == false) goto L5;
        return false;
    L5:
        MotionEvent r4 = MotionEvent.obtain(r7);
        if (r7.getAction() != 1) goto L9;
        r4.setAction(4);
    L9:
        if (Build.VERSION.SDK_INT >= 28) goto L11;
        r4.setAction(0);
        int r8 = this.prePieSlop;
        r4.setLocation((-r8) - 1, (-r8) - 1);
    L11:
        r6.performClick();
        return this.dialog.onTouchEvent(r4);
    }
}
