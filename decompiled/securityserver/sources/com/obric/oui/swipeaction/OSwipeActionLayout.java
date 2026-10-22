package com.obric.oui.swipeaction;

import android.view.MotionEvent;
import android.widget.FrameLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class OSwipeActionLayout extends FrameLayout {
    public static final /* synthetic */ int j = 0;
    public int b;
    public boolean c;
    public boolean e;
    public int f;
    public SwipeActionsListener i;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public interface SwipeActionsListener {
    }

    private final int getLViewWidth() {
        return 0;
    }

    private final boolean getLeftOpenFinished() {
        if (this.f != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getLeftViewOpened() {
        return false;
    }

    private final int getPreviousPosition() {
        return 0;
    }

    private final int getRViewWidth() {
        return 0;
    }

    private final boolean getRightOpenFinished() {
        if ((-this.f) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getRightViewEmpty() {
        return true;
    }

    private final boolean getRightViewOpened() {
        return false;
    }

    private final void setRightViewPadding(int r2) {
        if (this.b != 3) goto L6;
        setRightViewPadding(0);
        return;
    }

    @Override // android.view.View
    public final void computeScroll() {
        Intrinsics.c(null);
        throw null;
    }

    @Nullable
    public final SwipeActionsListener getActionsListener() {
        return this.i;
    }

    public final boolean getContinuousSwipe() {
        return this.e;
    }

    public final int getDirection() {
        return this.b;
    }

    public final boolean getSwipeEnabled() {
        return this.c;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        throw new RuntimeException("'oui_sal_draggedItem' must be specified");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        Intrinsics.f(r1, "event");
        Intrinsics.c(null);
        throw null;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        this.f = r1;
        super.onSizeChanged(r1, r2, r3, r4);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r1) {
        Intrinsics.f(r1, "event");
        Intrinsics.c(null);
        throw null;
    }

    public final void setActionsListener(@Nullable SwipeActionsListener r1) {
        this.i = r1;
    }

    public final void setContinuousSwipe(boolean r1) {
        this.e = r1;
    }

    public final void setDirection(int r1) {
        this.b = r1;
    }

    public final void setSwipeEnabled(boolean r1) {
        this.c = r1;
    }
}
