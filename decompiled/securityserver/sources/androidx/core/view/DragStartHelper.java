package androidx.core.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class DragStartHelper {
    private boolean mDragging;
    private int mLastTouchX;
    private int mLastTouchY;
    private final OnDragStartListener mListener;
    private final View.OnLongClickListener mLongClickListener;
    private final View.OnTouchListener mTouchListener;
    private final View mView;

    public interface OnDragStartListener {
        boolean onDragStart(View r1, DragStartHelper r2);
    }

    public DragStartHelper(View r2, OnDragStartListener r3) {
        this.mLongClickListener = new AnonymousClass1(this);
        this.mTouchListener = new AnonymousClass2(this);
        this.mView = r2;
        this.mListener = r3;
    }

    public void attach() {
        this.mView.setOnLongClickListener(this.mLongClickListener);
        this.mView.setOnTouchListener(this.mTouchListener);
    }

    public void detach() {
        this.mView.setOnLongClickListener(null);
        this.mView.setOnTouchListener(null);
    }

    public void getTouchPosition(Point r2) {
        r2.set(this.mLastTouchX, this.mLastTouchY);
    }

    public boolean onLongClick(View r2) {
        return this.mListener.onDragStart(r2, this);
    }

    public boolean onTouch(View r7, MotionEvent r8) {
        int r0 = (int) r8.getX();
        int r1 = (int) r8.getY();
        int r2 = r8.getAction();
        if (r2 != 0) goto L5;
        this.mLastTouchX = r0;
        this.mLastTouchY = r1;
    L28:
        return false;
    L5:
        if (r2 != 1) goto L7;
    L26:
        this.mDragging = false;
        goto L28
    L7:
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L26;
    L12:
        if (MotionEventCompat.isFromSource(r8, 8194) == false) goto L28;
        if ((r8.getButtonState() & 1) == 0) goto L28;
        if (this.mDragging == true) goto L28;
        if (this.mLastTouchX == r0) goto L22;
    L24:
        this.mLastTouchX = r0;
        this.mLastTouchY = r1;
        boolean r9 = this.mListener.onDragStart(r7, this);
        this.mDragging = r9;
        return r9;
    L22:
        if (this.mLastTouchY != r1) goto L24;
        goto L24
    }
}
