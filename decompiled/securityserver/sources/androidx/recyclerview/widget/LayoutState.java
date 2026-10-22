package androidx.recyclerview.widget;

import a.a;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class LayoutState {
    static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    static final int ITEM_DIRECTION_HEAD = -1;
    static final int ITEM_DIRECTION_TAIL = 1;
    static final int LAYOUT_END = 1;
    static final int LAYOUT_START = -1;
    int mAvailable;
    int mCurrentPosition;
    int mEndLine;
    boolean mInfinite;
    int mItemDirection;
    int mLayoutDirection;
    boolean mRecycle;
    int mStartLine;
    boolean mStopInFocusable;

    public LayoutState() {
        this.mRecycle = true;
        this.mStartLine = 0;
        this.mEndLine = 0;
    }

    public boolean hasMore(RecyclerView.State r1) {
        int r0 = this.mCurrentPosition;
        if (r0 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r0 >= r1.getItemCount()) goto L7;
        return true;
    }

    public View next(RecyclerView.Recycler r3) {
        View r4 = r3.getViewForPosition(this.mCurrentPosition);
        this.mCurrentPosition += this.mItemDirection;
        return r4;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("LayoutState{mAvailable=");
        r0.append(this.mAvailable);
        r0.append(", mCurrentPosition=");
        r0.append(this.mCurrentPosition);
        r0.append(", mItemDirection=");
        r0.append(this.mItemDirection);
        r0.append(", mLayoutDirection=");
        r0.append(this.mLayoutDirection);
        r0.append(", mStartLine=");
        r0.append(this.mStartLine);
        r0.append(", mEndLine=");
        return a.l(r0, this.mEndLine, '}');
    }
}
