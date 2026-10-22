package com.obric.oui.forms;

import android.view.MotionEvent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class AbsOInput extends ConstraintLayout {
    public float b;
    public float c;
    public boolean e;

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r7) {
        if (r7 == null) goto L36;
        if (this.e == false) goto L36;
        float r0 = r7.getX();
        float r1 = r7.getY();
        int r2 = r7.getAction();
        if (r2 != 0) goto L8;
        this.b = r1;
        goto L36
    L8:
        if (r2 != 1) goto L10;
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r2 != 2) goto L12;
        EditText r3 = getInterEditText();
        if (r0 <= this.c) goto L20;
        if (r3.canScrollHorizontally(-1) == false) goto L20;
    L31:
        super.requestDisallowInterceptTouchEvent(true);
    L32:
        this.c = r0;
        this.b = r1;
    L20:
        if (r0 >= this.c) goto L24;
        if (r3.canScrollHorizontally(1) == true) goto L31;
    L24:
        if (r1 >= this.b) goto L28;
        if (r3.canScrollVertically(1) == true) goto L31;
    L28:
        if (r1 <= this.b) goto L32;
        if (r3.canScrollVertically(-1) == false) goto L32;
    L12:
        if (r2 != 3) goto L36;
        super.requestDisallowInterceptTouchEvent(false);
    L36:
        return super.dispatchTouchEvent(r7);
    }

    @NotNull
    public abstract EditText getInterEditText();

    public final void setInScrollView(boolean r1) {
        this.e = r1;
    }
}
