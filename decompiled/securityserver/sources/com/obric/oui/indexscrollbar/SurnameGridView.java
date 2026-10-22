package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SurnameGridView extends GridView {
    public OnPressChangeListener b;
    public int c;
    public int e;

    @Metadata
    public interface OnPressChangeListener {
        void a(int r1);
    }

    public SurnameGridView(@Nullable Context r1, @Nullable AttributeSet r2) {
        super(r1, r2);
        this.c = -1;
        this.e = -1;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.f(r5, "ev");
        int r0 = pointToPosition((int) r5.getX(), (int) r5.getY());
        int r1 = r5.getActionMasked();
        if (r1 != 0) goto L5;
        this.c = r0;
    L15:
        if (this.e == r0) goto L18;
        OnPressChangeListener r2 = this.b;
        Intrinsics.c(r2);
        r2.a(r0);
        this.e = r0;
    L18:
        return super.onTouchEvent(r5);
    L5:
        if (r1 != 1) goto L7;
    L9:
        r0 = -1;
        goto L15
    L7:
        if (r1 != 2) goto L9;
        int r3 = this.c;
        if (r3 != r0) goto L9;
        r0 = r3;
        goto L15
    }

    public final void setOnPressChangeListener(@Nullable OnPressChangeListener r1) {
        this.b = r1;
    }
}
