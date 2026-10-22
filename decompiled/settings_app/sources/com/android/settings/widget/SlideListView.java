package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.android.settings.R;
import com.android.settings.stickylistheaders.StickyListHeadersListView;

/* JADX INFO: loaded from: classes.dex */
public class SlideListView extends StickyListHeadersListView {
    private final int DEFAULT_PRE_POSITION;
    private final int MISS;
    private final int SELECT;
    private final int SPECIAL;
    private final float SPEED_CARDINAL;
    private int mCheckboxId;
    private Point mCurrPoint;
    private Point mDownPoint;
    private float mDownScrollStartY;
    private int mEndX;
    private boolean mIsChecked;
    private Listener mListener;
    private OnQuickBarChangedListener mOnQuickBarChangedListener;
    private int mPrePosition;
    private SelectScroller mScroller;
    private float mSelectDownScrollStartFrac;
    private float mSelectUpScrollStartFrac;
    private boolean mSlideEnable;
    private int mStartX;
    private int mState;
    private int[] mTempLoc;
    private TouchMonitorListener mTouchMonitorListener;
    private float mUpScrollStartY;

    /* JADX INFO: renamed from: com.android.settings.widget.SlideListView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface Listener {
        boolean isChecked(int r1);

        void setChecked(int r1, boolean r2);
    }

    public interface OnQuickBarChangedListener {
        boolean processQuickBar();
    }

    private final class SelectScroller implements Runnable {
        public static final int DOWN = 2;
        public static final int UP = 1;
        private boolean mAbort;
        private long mCurrTime;
        private long mPrevTime;
        private int mScrollDir;
        private float mScrollSpeed;
        private boolean mScrolling;
        final /* synthetic */ SlideListView this$0;

        private SelectScroller(SlideListView r1) {
            this.this$0 = r1;
            this.mScrolling = false;
        }

        /* synthetic */ SelectScroller(SlideListView r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void startScroll(int r3) {
            if (this.mScrolling == true) goto L6;
            this.mScrolling = true;
            this.mAbort = false;
            this.mScrollDir = r3;
            this.mPrevTime = SystemClock.uptimeMillis();
            this.this$0.post(this);
            return;
        }

        public void stopScroll() {
            this.this$0.removeCallbacks(this);
            this.mScrolling = false;
        }

        public boolean isScrolling() {
            return this.mScrolling;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mAbort == false) goto L5;
            return;
        L5:
            int r0 = this.this$0.getFirstVisiblePosition();
            int r1 = this.this$0.getLastVisiblePosition();
            int r2 = this.this$0.getCount();
            int r3 = this.this$0.getListPaddingTop();
            int r4 = (this.this$0.getListHeight() - r3) - this.this$0.getListPaddingBottom();
            performSelectAction();
            if (this.mScrollDir != 1) goto L20;
            View r5 = this.this$0.getListChildAt(0);
            if (r5 == null) goto L18;
            if (r0 != 0) goto L14;
            if (r5.getTop() == r3) goto L18;
        L14:
            if (SlideListView.access$100(this.this$0).y < r3) goto L17;
            r3 = SlideListView.access$100(this.this$0).y;
        L17:
            this.mScrollSpeed = (r3 - SlideListView.access$200(this.this$0)) * 0.01f;
        L32:
            long r6 = SystemClock.uptimeMillis();
            this.mCurrTime = r6;
            float r7 = r6 - this.mPrevTime;
            this.this$0.smoothScrollBy(Math.round(this.mScrollSpeed * r7), (int) r7);
            this.this$0.invalidate();
            this.mPrevTime = this.mCurrTime;
            this.this$0.post(this);
            return;
        L18:
            this.mScrolling = false;
            return;
        L20:
            View r8 = this.this$0.getListChildAt(r1 - r0);
            if (r8 != null) goto L23;
        L34:
            this.mScrolling = false;
            return;
        L23:
            if (r1 == (r2 - 1)) goto L25;
        L27:
            int r9 = this.this$0.getListHeight() - this.this$0.getListPaddingBottom();
            if (SlideListView.access$100(this.this$0).y > r9) goto L31;
            r9 = SlideListView.access$100(this.this$0).y;
        L31:
            this.mScrollSpeed = (r9 - SlideListView.access$300(this.this$0)) * 0.01f;
            goto L32
        L25:
            if (r8.getBottom() > (r4 + r3)) goto L27;
            goto L27
        }

        private void performSelectAction() {
            if (SlideListView.access$100(this.this$0).y >= this.this$0.getListPaddingTop()) goto L7;
            SlideListView r3 = this.this$0;
            SlideListView.access$400(r3, r3.getFirstVisiblePosition());
            return;
        L7:
            if (SlideListView.access$100(this.this$0).y <= (this.this$0.getListHeight() - this.this$0.getListPaddingBottom())) goto L10;
            SlideListView r4 = this.this$0;
            SlideListView.access$400(r4, r4.getLastVisiblePosition());
            return;
        L10:
            SlideListView r0 = this.this$0;
            int r1 = r0.pointToPosition(SlideListView.access$100(r0).x, SlideListView.access$100(this.this$0).y);
            SlideListView r2 = this.this$0;
            View r5 = r2.getListChildAt(r1 - r2.getFirstVisiblePosition());
            if (r5 != null) goto L13;
            return;
        L13:
            if (r5.findViewById(SlideListView.access$500(this.this$0)) == null) goto L17;
            SlideListView.access$400(this.this$0, r1);
            return;
        }
    }

    public interface TouchMonitorListener {
        void onTouchActionUp();
    }

    static /* synthetic */ Point access$100(SlideListView r0) {
        return r0.mCurrPoint;
    }

    static /* synthetic */ float access$200(SlideListView r0) {
        return r0.mUpScrollStartY;
    }

    static /* synthetic */ float access$300(SlideListView r0) {
        return r0.mDownScrollStartY;
    }

    static /* synthetic */ void access$400(SlideListView r0, int r1) {
        r0.onMoving(r1);
    }

    static /* synthetic */ int access$500(SlideListView r0) {
        return r0.mCheckboxId;
    }

    public SlideListView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.mIsChecked = false;
        this.mTempLoc = new int[2];
        this.MISS = -1;
        this.SELECT = 1;
        this.SPECIAL = -2;
        this.mState = -1;
        this.DEFAULT_PRE_POSITION = -2;
        this.mPrePosition = -2;
        this.mSelectUpScrollStartFrac = 0.2f;
        this.mSelectDownScrollStartFrac = 0.2f;
        this.SPEED_CARDINAL = 0.01f;
        this.mDownPoint = new Point();
        this.mCurrPoint = new Point();
        init(r2, r3);
    }

    public SlideListView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mIsChecked = false;
        this.mTempLoc = new int[2];
        this.MISS = -1;
        this.SELECT = 1;
        this.SPECIAL = -2;
        this.mState = -1;
        this.DEFAULT_PRE_POSITION = -2;
        this.mPrePosition = -2;
        this.mSelectUpScrollStartFrac = 0.2f;
        this.mSelectDownScrollStartFrac = 0.2f;
        this.SPEED_CARDINAL = 0.01f;
        this.mDownPoint = new Point();
        this.mCurrPoint = new Point();
        init(r3, r4);
    }

    public SlideListView(Context r2) {
        super(r2);
        this.mIsChecked = false;
        this.mTempLoc = new int[2];
        this.MISS = -1;
        this.SELECT = 1;
        this.SPECIAL = -2;
        this.mState = -1;
        this.DEFAULT_PRE_POSITION = -2;
        this.mPrePosition = -2;
        this.mSelectUpScrollStartFrac = 0.2f;
        this.mSelectDownScrollStartFrac = 0.2f;
        this.SPEED_CARDINAL = 0.01f;
        this.mDownPoint = new Point();
        this.mCurrPoint = new Point();
    }

    private void init(Context r3, AttributeSet r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.SlideListView, 0, 0);
        if (r5 == null) goto L7;
        this.mCheckboxId = r5.getResourceId(0, 0);
        this.mSlideEnable = r5.getBoolean(1, false);
        r5.recycle();
    L7:
        this.mScroller = new SelectScroller(this, null);
    }

    public void setTouchMonitorListener(TouchMonitorListener r1) {
        this.mTouchMonitorListener = r1;
    }

    public void setSlideListener(Listener r1) {
        this.mListener = r1;
    }

    public void setSlideEnable(boolean r1) {
        if (r1 == true) goto L4;
        recovery();
    L4:
        this.mSlideEnable = r1;
    }

    public boolean isSlideEnable() {
        return this.mSlideEnable;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r4) {
        if (this.mSlideEnable == false) goto L5;
        int r0 = startCheckPosition(r4);
        int r1 = r4.getActionMasked();
        if (r0 <= (-1)) goto L12;
        if (r1 != 0) goto L12;
        return true;
    L12:
        return super.onInterceptTouchEvent(r4);
    L5:
        return super.onInterceptTouchEvent(r4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r9) {
        if (processQuickBar(r9.getAction()) == false) goto L6;
        return true;
    L6:
        if (this.mSlideEnable == false) goto L8;
        initScrollData();
        int r0 = startCheckPosition(r9);
        int r2 = (int) r9.getX();
        int r3 = (int) r9.getY();
        this.mCurrPoint.set(r2, r3);
        int r4 = r9.getActionMasked();
        if (r4 == 0) goto L39;
        if (r4 != 1) goto L13;
    L36:
        recovery();
        TouchMonitorListener r1 = this.mTouchMonitorListener;
        if (r1 == null) goto L48;
        r1.onTouchActionUp();
    L48:
        return super.onTouchEvent(r9);
    L13:
        if (r4 != 2) goto L15;
        if (r0 == (-2)) goto L23;
        if (r0 == (-1)) goto L20;
    L22:
        boolean r5 = false;
    L24:
        int r6 = this.mState;
        if (r6 == 1) goto L29;
        if (r5 == true) goto L29;
        onDown(r0);
        return true;
    L29:
        if (r6 != 1) goto L32;
        if (r0 != (-2)) goto L32;
        return true;
    L32:
        if (r5 == true) goto L48;
        continueSelect(r2, r3, r0);
        return true;
    L20:
        if (this.mState != (-1)) goto L22;
    L23:
        r5 = true;
        goto L24
    L15:
        if (r4 == 3) goto L36;
    L39:
        this.mDownPoint.set(r2, r3);
        if (r0 == (-2)) goto L48;
        if (r0 == (-1)) goto L43;
    L45:
        onDown(r0);
        return true;
    L43:
        if (this.mState != (-1)) goto L45;
    L8:
        return super.onTouchEvent(r9);
    }

    public void setOnQuickBarChanged(OnQuickBarChangedListener r1) {
        this.mOnQuickBarChangedListener = r1;
    }

    private boolean processQuickBar(int r1) {
        if (r1 != 0) goto L10;
        OnQuickBarChangedListener r0 = this.mOnQuickBarChangedListener;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.processQuickBar();
    L10:
        return false;
    }

    private int startCheckPosition(MotionEvent r2) {
        return viewIdHitPosition(r2, this.mCheckboxId);
    }

    private void onDown(int r3) {
        Listener r0 = this.mListener;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 > (-1)) goto L7;
        return;
    L7:
        if (this.mPrePosition == r3) goto L13;
        this.mState = 1;
        this.mIsChecked = r0.isChecked(r3 - getHeaderViewsCount());
        onMoving(r3);
        return;
    }

    private void onMoving(int r6) {
        Listener r0 = this.mListener;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r6 <= (-1)) goto L56;
        int r1 = this.mPrePosition;
        if (r1 != r6) goto L10;
        return;
    L10:
        if (this.mState == 1) goto L12;
    L41:
        this.mPrePosition = r6;
        return;
    L12:
        if (r1 != (-2)) goto L14;
        r0.setChecked(r6 - getHeaderViewsCount(), !this.mIsChecked);
        goto L41
    L14:
        if (r1 <= r6) goto L28;
        int r2 = r1 - 1;
    L16:
        if (r2 < r6) goto L41;
        if (r2 < getFirstVisiblePosition()) goto L27;
        if (r2 > getLastVisiblePosition()) goto L27;
        if (r2 < getHeaderViewsCount()) goto L27;
        if (r2 >= getCount()) goto L27;
        this.mListener.setChecked(r2 - getHeaderViewsCount(), !this.mIsChecked);
    L27:
        r2 = r2 - 1;
        goto L16
    L28:
        int r3 = r1 + 1;
    L29:
        if (r3 > r6) goto L41;
        if (r3 < getFirstVisiblePosition()) goto L40;
        if (r3 > getLastVisiblePosition()) goto L40;
        if (r3 < getHeaderViewsCount()) goto L40;
        if (r3 >= getCount()) goto L40;
        this.mListener.setChecked(r3 - getHeaderViewsCount(), !this.mIsChecked);
    L40:
        r3 = r3 + 1;
        goto L29
    }

    private void recovery() {
        if (this.mState != (-1)) goto L6;
        return;
    L6:
        if (this.mScroller.isScrolling() == false) goto L8;
        this.mScroller.stopScroll();
    L8:
        this.mIsChecked = false;
        this.mState = -1;
        this.mPrePosition = -2;
        this.mStartX = 0;
        this.mEndX = 0;
    }

    public boolean isSelecting() {
        if (this.mState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private int viewIdHitPosition(MotionEvent r8, int r9) {
        int r0 = pointToPosition((int) r8.getX(), (int) r8.getY());
        int r1 = getHeaderViewsCount();
        int r2 = getFooterViewsCount();
        int r3 = getCount();
        if (r0 == (-1)) goto L43;
        if (r0 < r1) goto L43;
        if (r0 >= (r3 - r2)) goto L43;
        int r4 = (int) r8.getRawX();
        int r10 = (int) r8.getRawY();
        View r5 = getListChildAt(r0 - getFirstVisiblePosition());
        if (r5 != null) goto L10;
        return -1;
    L10:
        if (r9 != 0) goto L12;
        View r11 = null;
    L14:
        if (r11 != null) goto L16;
    L34:
        if (r11 != null) goto L43;
        if (this.mState != 1) goto L43;
        if (r4 <= this.mStartX) goto L43;
        if (r4 >= this.mEndX) goto L43;
        return -2;
    L16:
        if (r11.getVisibility() != 0) goto L34;
        if (this.mState == 1) goto L20;
    L24:
        r11.getLocationOnScreen(this.mTempLoc);
        int[] r6 = this.mTempLoc;
        int r7 = r6[0];
        if (r4 <= r7) goto L43;
        if (r10 <= r6[1]) goto L43;
        if (r4 >= (r7 + r11.getWidth())) goto L43;
        if (r10 >= (this.mTempLoc[1] + r11.getHeight())) goto L43;
        int r12 = this.mTempLoc[0];
        this.mStartX = r12;
        this.mEndX = r12 + r11.getWidth();
        return r0;
    L20:
        if (r4 <= this.mStartX) goto L24;
        if (r4 >= this.mEndX) goto L24;
        return r0;
    L12:
        r11 = r5.findViewById(r9);
    L43:
        return -1;
    }

    private void initScrollData() {
        int r0 = getListPaddingTop();
        float r1 = (getListHeight() - r0) - getListPaddingBottom();
        float r2 = r0;
        this.mUpScrollStartY = (this.mSelectUpScrollStartFrac * r1) + r2;
        this.mDownScrollStartY = r2 + ((1.0f - this.mSelectDownScrollStartFrac) * r1);
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        initScrollData();
    }

    private void continueSelect(int r4, int r5, int r6) {
        int r7 = r5 - this.mDownPoint.y;
        float r8 = r5;
        float r0 = this.mDownScrollStartY;
        if (r8 <= r0) goto L7;
        if (r7 <= 0) goto L7;
        this.mScroller.startScroll(2);
        return;
    L7:
        float r1 = this.mUpScrollStartY;
        if (r8 >= r1) goto L13;
        if (r7 >= 0) goto L13;
        this.mScroller.startScroll(1);
        return;
    L13:
        if (r8 > r1) goto L15;
    L17:
        onMoving(r6);
        return;
    L15:
        if (r8 >= r0) goto L17;
        this.mScroller.stopScroll();
        goto L17
    }
}
