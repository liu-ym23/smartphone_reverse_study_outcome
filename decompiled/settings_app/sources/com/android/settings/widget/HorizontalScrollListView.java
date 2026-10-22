package com.android.settings.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.android.settings.R;
import com.obric.olog.OLog;
import com.obric.oui.bouncelayout.OListView;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalScrollListView extends OListView implements android.view.GestureDetector.OnGestureListener {
    private static int COMPLETE_SCROLL_DURATION = 200;
    private static boolean DEBUG_SCROLL = false;
    public static final int IDLE = 0;
    private static final int MISS = -1;
    private static int RESTORE_SCROLL_DURATION = 150;
    public static final int SCROLLED_LEFT = 4;
    public static final int SCROLLED_RIGHT = 3;
    public static final int SCROLLING_LEFT = 2;
    public static final int SCROLLING_RIGHT = 1;
    public static final int SCROLL_MODE_BOTH = 2;
    public static final int SCROLL_MODE_LEFT = 1;
    public static final int SCROLL_MODE_RIGHT = 0;
    private static String TAG = "HorizontalScrollListView";
    private MotionEvent mCancelEvent;
    private int mClickScrollHitPos;
    private Context mContext;
    private android.view.GestureDetector mDetector;
    private View mHintView;
    private boolean mIntercept;
    protected boolean mIsRunningDeleteAnim;
    private boolean mIsScrollRunning;
    private int mLeftBtnsId;
    private int mLeftBtnsWidth;
    private int mMaxLeftBtnsWidth;
    private int mMaxRightBtnsWidth;
    private ScrollStateListener mOnScrollStateListener;
    private float mOverflowVelocityFactor;
    private boolean mRestoreEatBackKey;
    private int mRightBtnsId;
    private int mRightBtnsWidth;
    private boolean mScrollEnabled;
    private float mScrollFactor;
    private int mScrollHandleId;
    private int mScrollMode;
    private ScrollRunner mScrollRunner;
    private int mScrollState;
    private int mScrolledHintPos;
    private long mScrolledItemId;
    private Scroller mScroller;
    private int[] mTempLoc;
    private int mTouchSlop;
    private float mVelocityFactor;

    public interface ScrollAnimationListener {
        void onAnimationEnd();
    }

    private class ScrollRunner implements Runnable {
        private ScrollAnimationListener listener;
        final /* synthetic */ HorizontalScrollListView this$0;

        ScrollRunner(HorizontalScrollListView r2) {
            this(r2, null);
        }

        ScrollRunner(HorizontalScrollListView r1, ScrollAnimationListener r2) {
            this.this$0 = r1;
            this.listener = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean r0 = HorizontalScrollListView.access$000(this.this$0).computeScrollOffset();
            if (this.this$0.getScrollHandleView() == null) goto L6;
            this.this$0.getScrollHandleView().scrollTo(HorizontalScrollListView.access$000(this.this$0).getCurrX(), 0);
        L6:
            if (r0 == false) goto L8;
            HorizontalScrollListView.access$102(this.this$0, true);
            this.this$0.post(this);
            return;
        L8:
            HorizontalScrollListView.access$102(this.this$0, false);
            if (this.this$0.getHorizontalScrollX() != 0) goto L18;
            HorizontalScrollListView.access$202(this.this$0, 0);
            if (HorizontalScrollListView.access$300(this.this$0) == null) goto L14;
            HorizontalScrollListView.access$300(this.this$0).onScrollRestored();
        L14:
            if (this.this$0.getBtnsView() == null) goto L16;
            this.this$0.getBtnsView().setImportantForAccessibility(2);
        L16:
            this.this$0.saveHintViewPosition(-1);
        L30:
            ScrollAnimationListener r4 = this.listener;
            if (r4 == null) goto L35;
            r4.onAnimationEnd();
            return;
        L35:
            return;
        L18:
            if (this.this$0.getBtnsView() == null) goto L25;
            HorizontalScrollListView r1 = this.this$0;
            if (r1.getHorizontalScrollX() <= 0) goto L22;
            int r2 = 4;
        L23:
            HorizontalScrollListView.access$202(r1, r2);
            goto L25
        L22:
            r2 = 3;
        L25:
            if (HorizontalScrollListView.access$300(this.this$0) == null) goto L28;
            HorizontalScrollListView.access$300(this.this$0).onScrollCompleted();
        L28:
            if (this.this$0.getBtnsView() == null) goto L30;
            this.this$0.getBtnsView().setImportantForAccessibility(1);
            goto L30
        }
    }

    public interface ScrollStateListener {
        boolean isItemCanScroll(int r1);

        void onScrollCompleted();

        void onScrollRestored();

        void onScrollStart(int r1);

        void onScrollStartToComplete();

        void onScrolling();
    }

    static {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent r1) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent r1) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent r1) {
        return false;
    }

    static /* synthetic */ Scroller access$000(HorizontalScrollListView r0) {
        return r0.mScroller;
    }

    static /* synthetic */ boolean access$102(HorizontalScrollListView r0, boolean r1) {
        r0.mIsScrollRunning = r1;
        return r1;
    }

    static /* synthetic */ int access$202(HorizontalScrollListView r0, int r1) {
        r0.mScrollState = r1;
        return r1;
    }

    static /* synthetic */ ScrollStateListener access$300(HorizontalScrollListView r0) {
        return r0.mOnScrollStateListener;
    }

    static /* synthetic */ int access$400(HorizontalScrollListView r0) {
        return r0.mScrollHandleId;
    }

    public HorizontalScrollListView(Context r2) {
        this(r2, null);
        this.mContext = r2;
    }

    public HorizontalScrollListView(Context r17, AttributeSet r18) {
        super(r17, r18);
        this.mScrollState = 0;
        this.mClickScrollHitPos = -1;
        this.mScrolledHintPos = -1;
        this.mScrolledItemId = -1;
        this.mScrollEnabled = true;
        this.mRestoreEatBackKey = true;
        this.mTempLoc = new int[2];
        this.mLeftBtnsWidth = -1;
        this.mRightBtnsWidth = -1;
        this.mMaxLeftBtnsWidth = -1;
        this.mMaxRightBtnsWidth = -1;
        this.mVelocityFactor = 1.0f;
        this.mOverflowVelocityFactor = 0.2f;
        this.mScrollFactor = 0.5f;
        this.mIntercept = false;
        this.mIsScrollRunning = false;
        this.mIsRunningDeleteAnim = false;
        this.mContext = r17;
        if (r18 == null) goto L5;
        TypedArray r2 = getContext().obtainStyledAttributes(r18, R.styleable.HorizontalScrollListView, 0, 0);
        this.mScrollEnabled = r2.getBoolean(8, this.mScrollEnabled);
        this.mRestoreEatBackKey = r2.getBoolean(5, this.mRestoreEatBackKey);
        this.mLeftBtnsWidth = r2.getDimensionPixelSize(1, this.mLeftBtnsWidth);
        this.mRightBtnsWidth = r2.getDimensionPixelSize(7, this.mRightBtnsWidth);
        this.mMaxLeftBtnsWidth = r2.getDimensionPixelSize(2, this.mMaxLeftBtnsWidth);
        this.mMaxRightBtnsWidth = r2.getDimensionPixelSize(3, this.mMaxRightBtnsWidth);
        this.mVelocityFactor = r2.getFloat(12, this.mVelocityFactor);
        this.mOverflowVelocityFactor = r2.getFloat(4, this.mOverflowVelocityFactor);
        this.mScrollFactor = r2.getFloat(9, this.mScrollFactor);
        this.mLeftBtnsId = r2.getResourceId(0, 0);
        this.mRightBtnsId = r2.getResourceId(6, 0);
        this.mScrollHandleId = r2.getResourceId(10, 0);
        this.mScrollMode = r2.getInt(11, 0);
        r2.recycle();
    L5:
        this.mScrollRunner = new ScrollRunner(this);
        this.mScroller = new Scroller(r17, AnimationUtils.loadInterpolator(r17, android.R.anim.decelerate_interpolator));
        this.mDetector = new android.view.GestureDetector(r17, this);
        this.mTouchSlop = ViewConfiguration.get(r17).getScaledTouchSlop();
        this.mCancelEvent = MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        setRecyclerListener(new AnonymousClass1(this));
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        fixHintView();
    }

    @Override // android.view.View
    protected void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        if (this.mScrolledHintPos >= getFirstVisiblePosition()) goto L5;
    L6:
        restoreScrollState(false);
        return;
    L5:
        if (this.mScrolledHintPos > getLastVisiblePosition()) goto L6;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r3, KeyEvent r4) {
        if (r3 != 4) goto L13;
        if (this.mScrollEnabled == false) goto L13;
        if (restoreScrollState(true) == false) goto L13;
        if (this.mRestoreEatBackKey == false) goto L13;
        return true;
    L13:
        return super.onKeyUp(r3, r4);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent r2) {
        if (this.mScrollEnabled == true) goto L5;
        return false;
    L5:
        if (isStateScrolled() == true) goto L7;
    L9:
        this.mClickScrollHitPos = viewIdHitPosition(r2, this.mScrollHandleId);
        return false;
    L7:
        if (isMotionHintView(getBtnsView(), r2) == false) goto L9;
        this.mClickScrollHitPos = -1;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent r5, MotionEvent r6, float r7, float r8) {
        if (this.mScrollEnabled == true) goto L6;
        return false;
    L6:
        if (this.mClickScrollHitPos != (-1)) goto L8;
        return false;
    L8:
        int r0 = (int) (r6.getX() - r5.getX());
        int r9 = (int) (r6.getY() - r5.getY());
        if (DEBUG_SCROLL == false) goto L12;
        OLog.d(TAG, "onScroll deltaX: " + r0 + ", deltaY: " + r9 + ", distanceX: " + r7 + ", distanceY: " + r8);
    L12:
        if (isStateScrolling() == true) goto L33;
        int r10 = this.mScrollMode;
        if (r10 != 1) goto L17;
        if (r0 <= 0) goto L17;
        return false;
    L17:
        if (r10 != 0) goto L21;
        if (r0 >= 0) goto L21;
        return false;
    L21:
        if (Math.abs(r0) >= Math.abs(r9)) goto L24;
        return false;
    L24:
        if (Math.abs(r0) >= this.mTouchSlop) goto L27;
        return false;
    L27:
        if (Math.abs(r7) >= Math.abs(r8)) goto L30;
        return false;
    L30:
        if (Math.abs(r7) >= this.mTouchSlop) goto L32;
        return false;
    L32:
        startScroll(this.mClickScrollHitPos, r0);
    L34:
        return false;
    L33:
        scrolling(this.mClickScrollHitPos, r7);
        goto L34
    }

    @Override // com.obric.oui.bouncelayout.OListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        if (this.mIsRunningDeleteAnim == false) goto L5;
        return true;
    L5:
        View r2 = getChildAt(viewIdHitPosition(r5, 0) - getFirstVisiblePosition());
        if (r2 != null) goto L8;
    L26:
        boolean r3 = false;
    L28:
        if (super.onInterceptTouchEvent(r5) == true) goto L33;
        if (r3 == false) goto L32;
        return true;
    L32:
        return false;
    L33:
        return true;
    L8:
        if (isStateScrolled() == false) goto L22;
        if (r2 != this.mHintView) goto L22;
        if (isMotionHintView(getBtnsView(), r5) == false) goto L15;
        return false;
    L15:
        if (isStateLeft() == false) goto L17;
        int r4 = this.mLeftBtnsId;
    L19:
        if (isMotionHintView(r2.findViewById(r4), r5) == false) goto L26;
    L25:
        r3 = true;
        goto L28
    L17:
        r4 = this.mRightBtnsId;
    L22:
        if (isMotionHintView(r2.findViewById(this.mLeftBtnsId), r5) == true) goto L25;
        if (isMotionHintView(r2.findViewById(this.mRightBtnsId), r5) == false) goto L26;
        goto L25
    }

    @Override // com.obric.oui.bouncelayout.OListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r6) {
        if (this.mIsRunningDeleteAnim == false) goto L6;
        return true;
    L6:
        if (this.mScrollEnabled == true) goto L10;
        return super.onTouchEvent(r6);
    L10:
        if (this.mIsScrollRunning == false) goto L13;
        this.mIntercept = true;
    L18:
        boolean r0 = this.mIntercept;
        int r2 = r6.getAction() & 255;
        if (r2 != 1) goto L21;
    L24:
        ensureScrollState(true);
        doActionUpOrCancel();
    L25:
        if (r0 == false) goto L44;
        Class<?> r7 = Class.forName("android.widget.ListView");     // Catch: InstantiationException -> L28 ClassNotFoundException -> L30 InvocationTargetException -> L32 IllegalAccessException -> L34 IllegalArgumentException -> L36 NoSuchMethodException -> L38 SecurityException -> L40
        r7.getMethod("onCancelPendingInputEvents", new Class[0]).invoke(r7.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.mContext}), new Object[0]);     // Catch: InstantiationException -> L28 ClassNotFoundException -> L30 InvocationTargetException -> L32 IllegalAccessException -> L34 IllegalArgumentException -> L36 NoSuchMethodException -> L38 SecurityException -> L40
    L42:
        return true;
    L30:
        e = move-exception;
        OLog.e(TAG, e.toString());
    L34:
        e = move-exception;
        OLog.e(TAG, e.toString());
    L36:
        e = move-exception;
        OLog.e(TAG, e.toString());
    L28:
        e = move-exception;
        OLog.e(TAG, e.toString());
    L38:
        e = move-exception;
        OLog.e(TAG, e.toString());
    L40:
        e = move-exception;
        OLog.e(TAG, e.toString());
    L32:
        e = move-exception;
        OLog.e(TAG, e.toString());
        goto L42
    L44:
        return super.onTouchEvent(r6);
    L21:
        if (r2 == 3) goto L24;
        if (r0 == false) goto L25;
        super.onTouchEvent(this.mCancelEvent);
        goto L25
    L13:
        if (isStateScrolled() == false) goto L16;
        this.mIntercept = true;
    L16:
        if (onScrolledStateTouchEvent(r6) == true) goto L18;
        this.mDetector.onTouchEvent(r6);
        goto L18
    }

    private void doActionUpOrCancel() {
        this.mIntercept = false;
        this.mClickScrollHitPos = -1;
    }

    private boolean onScrolledStateTouchEvent(MotionEvent r3) {
        boolean r1 = false;
        if (isStateScrolled() == true) goto L6;
        return false;
    L6:
        if (isMotionHintView(getBtnsView(), r3) == false) goto L9;
        return false;
    L9:
        if ((r3.getAction() & 255) != 0) goto L12;
        r1 = true;
    L12:
        if (r1 == false) goto L14;
        restoreScrollState(true);
    L14:
        return r1;
    }

    private int viewIdHitPosition(MotionEvent r6, int r7) {
        int r0 = pointToPosition((int) r6.getX(), (int) r6.getY());
        int r1 = getHeaderViewsCount();
        int r2 = getFooterViewsCount();
        int r3 = getCount();
        if (r0 == (-1)) goto L16;
        if (r0 < r1) goto L16;
        if (r0 >= (r3 - r2)) goto L16;
        View r4 = getChildAt(r0 - getFirstVisiblePosition());
        if (r4 != null) goto L10;
        return r0;
    L10:
        if (r7 == 0) goto L14;
        r4 = r4.findViewById(r7);
    L14:
        if (isMotionHintView(r4, r6) == false) goto L16;
        return r0;
    L16:
        return -1;
    }

    private boolean isMotionHintView(View r6, MotionEvent r7) {
        if (r6 != null) goto L5;
    L16:
        return false;
    L5:
        if (r6.getVisibility() != 0) goto L16;
        int r1 = (int) r7.getRawX();
        int r8 = (int) r7.getRawY();
        r6.getLocationOnScreen(this.mTempLoc);
        int[] r2 = this.mTempLoc;
        int r3 = r2[0];
        if (r1 <= r3) goto L16;
        if (r8 <= r2[1]) goto L16;
        if (r1 >= (r3 + r6.getWidth())) goto L16;
        if (r8 >= (this.mTempLoc[1] + r6.getHeight())) goto L16;
        return true;
    }

    private void startScroll(int r2, float r3) {
        ScrollStateListener r0 = this.mOnScrollStateListener;
        if (r0 != null) goto L5;
    L8:
        saveHintViewPosition(r2);
        scrolling(r2, r3);
        return;
    L5:
        if (r0.isItemCanScroll(r2) == true) goto L7;
        return;
    L7:
        this.mOnScrollStateListener.onScrollStart(r2);
        goto L8
    }

    private void scrolling(int r5, float r6) {
        View r7 = getChildAt(r5 - getFirstVisiblePosition());
        if (r7 != null) goto L5;
        return;
    L5:
        View r0 = this.mHintView;
        if (r0 == null) goto L10;
        if (r0 == r7) goto L10;
        return;
    L10:
        if (this.mIntercept == false) goto L13;
        if (r0 != null) goto L13;
        return;
    L13:
        super.onTouchEvent(this.mCancelEvent);
        int r8 = getHorizontalScrollX();
        int r1 = 2;
        if (r8 == 0) goto L16;
        if (r8 >= 0) goto L21;
        r1 = 1;
    L21:
        this.mScrollState = r1;
    L22:
        int r2 = getBtnsWidth();
        if (r2 > 0) goto L25;
    L28:
        float r3 = this.mVelocityFactor;
    L29:
        int r9 = (int) ((r6 * r3) + r8);
        if (r9 > 0) goto L32;
    L34:
        if (r9 < 0) goto L36;
    L38:
        int r4 = getMaxBtnsWidth();
        if (r4 <= 0) goto L46;
        if (Math.abs(r9) <= r4) goto L46;
        if (r9 <= 0) goto L44;
        r9 = r4;
        goto L46
    L44:
        r9 = -r4;
    L46:
        if (DEBUG_SCROLL == false) goto L48;
        OLog.d(TAG, "oldScrollX: " + r8);
        OLog.d(TAG, "newScrollX: " + r9);
    L48:
        getScrollHandleView().scrollTo(r9, 0);
        ScrollStateListener r10 = this.mOnScrollStateListener;
        if (r10 == null) goto L52;
        r10.onScrolling();
        return;
    L52:
        return;
    L36:
        if (this.mScrollMode != 1) goto L38;
        r9 = 0;
        goto L38
    L32:
        if (this.mScrollMode != 0) goto L34;
        r9 = 0;
        goto L34
    L25:
        if (Math.abs(r8) < r2) goto L28;
        r3 = this.mOverflowVelocityFactor;
        goto L29
    L16:
        if (r6 >= 0.0f) goto L18;
        r1 = 1;
    L18:
        this.mScrollState = r1;
        goto L22
    }

    private void horizontalScrolling(int r8, int r9, int r10, ScrollAnimationListener r11) {
        removeCallbacks(this.mScrollRunner);
        this.mScroller.startScroll(r8, 0, r9, 0, r10);
        ScrollRunner r12 = new ScrollRunner(this, r11);
        this.mScrollRunner = r12;
        post(r12);
    }

    public int getBtnsWidth() {
        if (isStateLeft() == false) goto L5;
        int r0 = this.mRightBtnsWidth;
    L6:
        if (r0 > 0) goto L10;
        View r1 = getBtnsView();
        if (r1 == null) goto L10;
        r0 = r1.getWidth();
    L10:
        if (r0 > 0) goto L14;
        return -1;
    L14:
        return r0;
    L5:
        r0 = this.mLeftBtnsWidth;
        goto L6
    }

    private int getMaxBtnsWidth() {
        if (isStateLeft() == false) goto L5;
        int r1 = this.mMaxRightBtnsWidth;
    L6:
        if (r1 > 0) goto L10;
        return -1;
    L10:
        return r1;
    L5:
        r1 = this.mMaxLeftBtnsWidth;
        goto L6
    }

    public void setMaxLeftBtnsWidth(int r1) {
        this.mMaxLeftBtnsWidth = r1;
    }

    public void setLeftBtnsWidth(int r1) {
        this.mLeftBtnsWidth = r1;
    }

    private boolean completeScrollState() {
        if (this.mHintView != null) goto L5;
        return false;
    L5:
        int r0 = getBtnsWidth();
        if (r0 > 0) goto L8;
        return false;
    L8:
        int r2 = getHorizontalScrollX();
        if (r2 == 0) goto L11;
    L13:
        int r1 = r0 - Math.abs(r2);
        if (r2 >= 0) goto L16;
        r1 = -r1;
    L16:
        horizontalScrolling(r2, r1, COMPLETE_SCROLL_DURATION, null);
        return true;
    L11:
        if (this.mScrollMode != 2) goto L13;
        return false;
    }

    public boolean restoreScrollState(boolean r2) {
        return restoreScrollState(r2, null);
    }

    public boolean restoreScrollState(boolean r5, ScrollAnimationListener r6) {
        if (this.mIsRunningDeleteAnim == false) goto L5;
        return true;
    L5:
        int r2 = 0;
        if (getHorizontalScrollX() != 0) goto L14;
        this.mScrollState = 0;
        saveHintViewPosition(-1);
        if (r6 == null) goto L10;
        r6.onAnimationEnd();
    L10:
        ScrollStateListener r4 = this.mOnScrollStateListener;
        if (r4 == null) goto L13;
        r4.onScrollRestored();
    L13:
        return false;
    L14:
        int r0 = getScrollHandleView().getScrollX();
        int r3 = -r0;
        if (r5 == false) goto L17;
        r2 = RESTORE_SCROLL_DURATION;
    L17:
        horizontalScrolling(r0, r3, r2, r6);
        return true;
    }

    public boolean ensureScrollState(boolean r2) {
        return ensureScrollState(r2, null);
    }

    public boolean ensureScrollState(boolean r5, ScrollAnimationListener r6) {
        if (isStateScrolled() == false) goto L6;
        return true;
    L6:
        if (this.mHintView != null) goto L8;
        return false;
    L8:
        if (getBtnsView() != null) goto L10;
    L18:
        restoreScrollState(r5, r6);
    L19:
        return true;
    L10:
        if (Math.abs(getHorizontalScrollX()) < (getBtnsWidth() * this.mScrollFactor)) goto L18;
        if (completeScrollState() == true) goto L15;
        restoreScrollState(r5, r6);
        goto L19
    L15:
        ScrollStateListener r4 = this.mOnScrollStateListener;
        if (r4 == null) goto L19;
        r4.onScrollStartToComplete();
        goto L19
    }

    private void fixHintView() {
        if (getAdapter() != null) goto L5;
        return;
    L5:
        if (this.mScrolledItemId != (-1)) goto L7;
        return;
    L7:
        if (getAdapter().getItemId(this.mScrolledHintPos) == this.mScrolledItemId) goto L21;
        int r0 = getFirstVisiblePosition();
        int r1 = getLastVisiblePosition();
    L9:
        if (r0 > r1) goto L15;
        if (getAdapter().getItemId(r0) == this.mScrolledItemId) goto L12;
        r0 = r0 + 1;
        goto L9
    L12:
        changeHintView(r0);
        return;
    L15:
        restoreScrollState(false);
        return;
    }

    public void changeHintView(int r4) {
        int r0 = getBtnsWidth();
        if (r0 > 0) goto L5;
        return;
    L5:
        removeCallbacks(this.mScrollRunner);
        if (isStateLeft() == true) goto L10;
        r0 = -r0;
    L10:
        if (getScrollHandleView() == null) goto L12;
        getScrollHandleView().scrollTo(0, 0);
    L12:
        saveHintViewPosition(r4);
        getScrollHandleView().scrollTo(r0, 0);
    }

    public void saveHintViewPosition(int r3) {
        if (r3 != (-1)) goto L5;
        this.mHintView = null;
        this.mScrolledHintPos = -1;
        this.mScrolledItemId = -1;
        return;
    L5:
        this.mHintView = getChildAt(r3 - getFirstVisiblePosition());
        this.mScrolledHintPos = r3;
        this.mScrolledItemId = getAdapter().getItemId(r3);
    }

    public View getHintView() {
        return this.mHintView;
    }

    public int getHintViewPosition() {
        return this.mScrolledHintPos;
    }

    public View getScrollHandleView() {
        View r0 = this.mHintView;
        if (r0 == null) goto L9;
        int r1 = this.mScrollHandleId;
        if (r1 != 0) goto L8;
        return r0;
    L8:
        return r0.findViewById(r1);
    L9:
        return null;
    }

    public View getBtnsView() {
        View r0 = this.mHintView;
        if (r0 != null) goto L7;
        return null;
    L7:
        if (isStateLeft() == false) goto L9;
        int r2 = this.mRightBtnsId;
    L11:
        return r0.findViewById(r2);
    L9:
        r2 = this.mLeftBtnsId;
        goto L11
    }

    public int getHorizontalScrollX() {
        View r0 = getScrollHandleView();
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getScrollX();
    }

    public void setScrollEnabled(boolean r1) {
        this.mScrollEnabled = r1;
    }

    public void setScrollHandleId(int r1) {
        this.mScrollHandleId = r1;
    }

    public void setLeftBtnsId(int r1) {
        this.mLeftBtnsId = r1;
    }

    public boolean isScrollEnabled() {
        return this.mScrollEnabled;
    }

    public void setScrollMode(int r1) {
        this.mScrollMode = r1;
    }

    public int getScrollMode() {
        return this.mScrollMode;
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean isStateLeft() {
        int r1 = this.mScrollState;
        if (r1 != 4) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 2) goto L8;
        return false;
    }

    public boolean isStateRight() {
        int r2 = this.mScrollState;
        if (r2 == 3) goto L8;
        if (r2 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public boolean isStateScrolled() {
        int r1 = this.mScrollState;
        if (r1 != 4) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 3) goto L8;
        return false;
    }

    public boolean isStateScrolling() {
        int r2 = this.mScrollState;
        if (r2 == 2) goto L8;
        if (r2 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public boolean isStateIdle() {
        if (this.mScrollState != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setOnScrollStateChangeListener(ScrollStateListener r1) {
        this.mOnScrollStateListener = r1;
    }

    public void playDeleteItemAnimation(final Animator.AnimatorListener r17) {
        final View r3 = this.mHintView;
        if (r3 != null) goto L7;
        if (r17 == null) goto L40;
        r17.onAnimationStart(null);
        r17.onAnimationEnd(null);
        return;
    L40:
        return;
    L7:
        final View r8 = getBtnsView();
        if (isStateLeft() == false) goto L10;
        int r0 = this.mLeftBtnsId;
    L11:
        final View r9 = r3.findViewById(r0);
        if (r9 == null) goto L14;
        int r1 = r9.getVisibility();
    L15:
        final int r6 = r1;
        final int r7 = r3.getScrollX();
        if (isStateLeft() == false) goto L18;
        int r2 = r3.getWidth();
    L19:
        ValueAnimator r12 = ValueAnimator.ofInt(new int[]{r7, r2});
        r12.setInterpolator(new DecelerateInterpolator(1.5f));
        r12.setDuration(200);
        r12.addUpdateListener(new AnonymousClass2(this, r3));
        r12.addListener(new AnonymousClass3(this, r17, r3, r8, r9, r6, r7));
        if (r9 == null) goto L22;
        r9.setVisibility(4);
    L22:
        if (r8 == null) goto L34;
        AlphaAnimation r4 = new AlphaAnimation(1.0f, 0.0f);
        r4.setDuration(200);
        r4.setFillAfter(true);
        r4.setInterpolator(new DecelerateInterpolator(1.5f));
        if ((r8 instanceof ViewGroup) == false) goto L33;
        ViewGroup r10 = (ViewGroup) r8;
        int r5 = r10.getChildCount();
        int r11 = 0;
    L26:
        if (r11 >= r5) goto L34;
        View r13 = r10.getChildAt(r11);
        if (r13 == null) goto L32;
        if (r13.getVisibility() != 0) goto L32;
        r13.startAnimation(r4);
    L32:
        r11 = r11 + 1;
        goto L26
    L33:
        r8.startAnimation(r4);
    L34:
        r12.start();
        return;
    L18:
        r2 = -r3.getWidth();
        goto L19
    L14:
        r1 = 8;
        goto L15
    L10:
        r0 = this.mRightBtnsId;
        goto L11
    }
}
