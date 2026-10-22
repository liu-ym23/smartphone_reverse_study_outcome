package com.bytedanceos.security.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.obric.oui.bouncelayout.OListView;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class SlideListView extends OListView {
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

    /* JADX INFO: renamed from: com.bytedanceos.security.widget.SlideListView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface DrawListener {
        void drawHeader(Canvas canvas);
    }

    public interface Listener {
        boolean isChecked(int position);

        void setChecked(int position, boolean isChecked);
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

        private SelectScroller(final SlideListView this$0) {
            this.this$0 = this$0;
            this.mScrolling = false;
        }

        /* synthetic */ SelectScroller(SlideListView r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void startScroll(int dir) {
            if (this.mScrolling == true) goto L6;
            this.mScrolling = true;
            this.mAbort = false;
            this.mScrollDir = dir;
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
            int r3 = this.this$0.getPaddingTop();
            int r4 = (this.this$0.getHeight() - r3) - this.this$0.getPaddingBottom();
            performSelectAction();
            if (this.mScrollDir != 1) goto L20;
            View r5 = this.this$0.getChildAt(0);
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
            View r8 = this.this$0.getChildAt(r1 - r0);
            if (r8 != null) goto L23;
        L34:
            this.mScrolling = false;
            return;
        L23:
            if (r1 == (r2 - 1)) goto L25;
        L27:
            int r9 = this.this$0.getHeight() - this.this$0.getPaddingBottom();
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
            if (SlideListView.access$100(this.this$0).y >= this.this$0.getPaddingTop()) goto L7;
            SlideListView r3 = this.this$0;
            SlideListView.access$400(r3, r3.getFirstVisiblePosition());
            return;
        L7:
            if (SlideListView.access$100(this.this$0).y <= (this.this$0.getHeight() - this.this$0.getPaddingBottom())) goto L10;
            SlideListView r4 = this.this$0;
            SlideListView.access$400(r4, r4.getLastVisiblePosition());
            return;
        L10:
            SlideListView r0 = this.this$0;
            int r1 = r0.pointToPosition(SlideListView.access$100(r0).x, SlideListView.access$100(this.this$0).y);
            SlideListView r2 = this.this$0;
            View r5 = r2.getChildAt(r1 - r2.getFirstVisiblePosition());
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

    public SlideListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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
        init(context, attrs);
    }

    public SlideListView(Context context, AttributeSet attrs) {
        super(context, attrs);
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
        init(context, attrs);
    }

    public SlideListView(Context context) {
        super(context);
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

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) goto L4;
        return;
    L4:
        boolean r1 = false;
        TypedArray r3 = context.obtainStyledAttributes(attrs, R.styleable.SliderListView, 0, 0);
        if (r3 == null) goto L8;
        this.mCheckboxId = r3.getResourceId(0, 0);
        this.mSlideEnable = r3.getBoolean(1, false);
        r3.recycle();
    L8:
        if (this.mCheckboxId == 0) goto L10;
        r1 = true;
    L10:
        this.mSlideEnable = r1;
        this.mScroller = new SelectScroller(this, null);
    }

    public void setTouchMonitorListener(TouchMonitorListener listener) {
        this.mTouchMonitorListener = listener;
    }

    public void setSlideListener(Listener listener) {
        this.mListener = listener;
    }

    public void setSlideEnable(boolean enable) {
        if (enable == true) goto L4;
        recovery();
    L4:
        this.mSlideEnable = enable;
    }

    public boolean isSlideEnable() {
        return this.mSlideEnable;
    }

    @Override // com.obric.oui.bouncelayout.OListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.mSlideEnable == false) goto L5;
        int r0 = startCheckPosition(ev);
        int r1 = ev.getActionMasked();
        if (r0 <= (-1)) goto L12;
        if (r1 != 0) goto L12;
        return true;
    L12:
        return super.onInterceptTouchEvent(ev);
    L5:
        return super.onInterceptTouchEvent(ev);
    }

    @Override // com.obric.oui.bouncelayout.OListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        if (this.mSlideEnable == false) goto L5;
        int r0 = startCheckPosition(ev);
        int r1 = (int) ev.getX();
        int r2 = (int) ev.getY();
        this.mCurrPoint.set(r1, r2);
        int r3 = ev.getActionMasked();
        if (r3 == 0) goto L36;
        if (r3 != 1) goto L10;
    L33:
        recovery();
        TouchMonitorListener r4 = this.mTouchMonitorListener;
        if (r4 == null) goto L45;
        r4.onTouchActionUp();
    L45:
        return super.onTouchEvent(ev);
    L10:
        if (r3 != 2) goto L12;
        if (r0 == (-2)) goto L20;
        if (r0 == (-1)) goto L17;
    L19:
        boolean r5 = false;
    L21:
        int r6 = this.mState;
        if (r6 == 1) goto L26;
        if (r5 == true) goto L26;
        onDown(r0);
        return true;
    L26:
        if (r6 != 1) goto L29;
        if (r0 != (-2)) goto L29;
        return true;
    L29:
        if (r5 == true) goto L45;
        continueSelect(r1, r2, r0);
        return true;
    L17:
        if (this.mState != (-1)) goto L19;
    L20:
        r5 = true;
        goto L21
    L12:
        if (r3 == 3) goto L33;
    L36:
        this.mDownPoint.set(r1, r2);
        if (r0 == (-2)) goto L45;
        if (r0 == (-1)) goto L40;
    L42:
        onDown(r0);
        return true;
    L40:
        if (this.mState != (-1)) goto L42;
    L5:
        return super.onTouchEvent(ev);
    }

    private int startCheckPosition(MotionEvent ev) {
        return viewIdHitPosition(ev, this.mCheckboxId);
    }

    private void onDown(int position) {
        Listener r0 = this.mListener;
        if (r0 != null) goto L5;
        return;
    L5:
        if (position > (-1)) goto L7;
        return;
    L7:
        if (this.mPrePosition == position) goto L13;
        this.mState = 1;
        this.mIsChecked = r0.isChecked(position);
        onMoving(position);
        return;
    }

    private void onMoving(int position) {
        Listener r0 = this.mListener;
        if (r0 != null) goto L5;
        return;
    L5:
        if (position > (-1)) goto L7;
        return;
    L7:
        if (this.mPrePosition == position) goto L13;
        this.mPrePosition = position;
        r0.setChecked(position, !this.mIsChecked);
        return;
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

    private int viewIdHitPosition(MotionEvent ev, int id) {
        int r0 = pointToPosition((int) ev.getX(), (int) ev.getY());
        int r1 = getHeaderViewsCount();
        int r2 = getFooterViewsCount();
        int r3 = getCount();
        if (r0 == (-1)) goto L43;
        if (r0 < r1) goto L43;
        if (r0 >= (r3 - r2)) goto L43;
        int r4 = (int) ev.getRawX();
        int r8 = (int) ev.getRawY();
        View r5 = getChildAt(r0 - getFirstVisiblePosition());
        if (r5 != null) goto L10;
        return -1;
    L10:
        if (id != 0) goto L12;
        View r9 = null;
    L14:
        if (r9 != null) goto L16;
    L34:
        if (r9 != null) goto L43;
        if (this.mState != 1) goto L43;
        if (r4 <= this.mStartX) goto L43;
        if (r4 >= this.mEndX) goto L43;
        return -2;
    L16:
        if (r9.getVisibility() != 0) goto L34;
        if (this.mState == 1) goto L20;
    L24:
        r9.getLocationOnScreen(this.mTempLoc);
        int[] r6 = this.mTempLoc;
        int r7 = r6[0];
        if (r4 <= r7) goto L43;
        if (r8 <= r6[1]) goto L43;
        if (r4 >= (r7 + r9.getWidth())) goto L43;
        if (r8 >= (this.mTempLoc[1] + r9.getHeight())) goto L43;
        int r10 = this.mTempLoc[0];
        this.mStartX = r10;
        this.mEndX = r10 + r9.getWidth();
        return r0;
    L20:
        if (r4 <= this.mStartX) goto L24;
        if (r4 >= this.mEndX) goto L24;
        return r0;
    L12:
        r9 = r5.findViewById(id);
    L43:
        return -1;
    }

    private void initScrollData() {
        int r0 = getPaddingTop();
        float r1 = (getHeight() - r0) - getPaddingBottom();
        float r2 = r0;
        this.mUpScrollStartY = (this.mSelectUpScrollStartFrac * r1) + r2;
        this.mDownScrollStartY = r2 + ((1.0f - this.mSelectDownScrollStartFrac) * r1);
    }

    @Override // com.obric.oui.bouncelayout.OListView, android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        initScrollData();
    }

    private void continueSelect(int x, int y, int position) {
        int r4 = y - this.mDownPoint.y;
        float r5 = y;
        float r0 = this.mDownScrollStartY;
        if (r5 <= r0) goto L7;
        if (r4 <= 0) goto L7;
        this.mScroller.startScroll(2);
        return;
    L7:
        float r1 = this.mUpScrollStartY;
        if (r5 >= r1) goto L13;
        if (r4 >= 0) goto L13;
        this.mScroller.startScroll(1);
        return;
    L13:
        if (r5 > r1) goto L15;
    L17:
        onMoving(position);
        return;
    L15:
        if (r5 >= r0) goto L17;
        this.mScroller.stopScroll();
        goto L17
    }
}
