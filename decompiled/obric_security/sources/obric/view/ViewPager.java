package obric.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes5.dex */
public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<ItemInfo> COMPARATOR = null;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int[] LAYOUT_ATTRS = null;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = null;
    private static final ViewPositionComparator sPositionComparator = null;
    private int mActivePointerId;
    private PagerAdapter mAdapter;
    private OnAdapterChangeListener mAdapterChangeListener;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    private int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mIgnoreGutter;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private OnPageChangeListener mOnPageChangeListener;
    private int mOverflingDistance;
    private int mOverscrollDistance;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    interface Decor {
    }

    static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        ItemInfo() {
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        float widthFactor;

        public LayoutParams() {
            super(-1, -1);
            this.widthFactor = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.widthFactor = 0.0f;
            TypedArray r2 = context.obtainStyledAttributes(attrs, ViewPager.access$400());
            this.gravity = r2.getInteger(0, 48);
            r2.recycle();
        }
    }

    class MyAccessibilityDelegate extends View.AccessibilityDelegate {
        final /* synthetic */ ViewPager this$0;

        MyAccessibilityDelegate(final ViewPager this$0) {
            this.this$0 = this$0;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            super.onInitializeAccessibilityEvent(host, event);
            event.setClassName(ViewPager.class.getName());
            AccessibilityRecord r2 = AccessibilityRecord.obtain();
            r2.setScrollable(canScroll());
            if (event.getEventType() == 4096) goto L5;
            return;
        L5:
            if (ViewPager.access$200(this.this$0) == null) goto L9;
            r2.setItemCount(ViewPager.access$200(this.this$0).getCount());
            r2.setFromIndex(ViewPager.access$300(this.this$0));
            r2.setToIndex(ViewPager.access$300(this.this$0));
            return;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setClassName(ViewPager.class.getName());
            info.setScrollable(canScroll());
            if (this.this$0.canScrollHorizontally(1) == false) goto L6;
            info.addAction(4096);
        L6:
            if (this.this$0.canScrollHorizontally(-1) == false) goto L9;
            info.addAction(8192);
            return;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View host, int action, Bundle args) {
            if (super.performAccessibilityAction(host, action, args) == false) goto L6;
            return true;
        L6:
            if (action == 4096) goto L16;
            if (action == 8192) goto L11;
            return false;
        L11:
            if (this.this$0.canScrollHorizontally(-1) == false) goto L14;
            ViewPager r1 = this.this$0;
            r1.setCurrentItem(ViewPager.access$300(r1) - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.this$0.canScrollHorizontally(1) == false) goto L19;
            ViewPager r2 = this.this$0;
            r2.setCurrentItem(ViewPager.access$300(r2) + 1);
            return true;
        L19:
            return false;
        }

        private boolean canScroll() {
            if (ViewPager.access$200(this.this$0) != null) goto L5;
        L7:
            return false;
        L5:
            if (ViewPager.access$200(this.this$0).getCount() <= 1) goto L7;
            return true;
        }
    }

    interface OnAdapterChangeListener {
        void onAdapterChanged(PagerAdapter oldAdapter, PagerAdapter newAdapter);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int state);

        void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);

        void onPageSelected(int position);
    }

    public interface PageTransformer {
        void transformPage(View page, float position);
    }

    private class PagerObserver extends DataSetObserver {
        final /* synthetic */ ViewPager this$0;

        private PagerObserver(final ViewPager this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ PagerObserver(ViewPager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.this$0.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.this$0.dataSetChanged();
        }
    }

    public static class SavedState extends View.BaseSavedState {
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public SavedState(Parcelable superState) {
            super(superState);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.position);
            out.writeParcelable(this.adapterState, flags);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        SavedState(Parcel in, ClassLoader loader) {
            super(in);
            if (loader != null) goto L5;
            loader = getClass().getClassLoader();
        L5:
            this.position = in.readInt();
            this.adapterState = in.readParcelable(loader);
            this.loader = loader;
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        @Override // obric.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // obric.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override // obric.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
        }

        public SimpleOnPageChangeListener() {
        }
    }

    static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(View lhs, View rhs) {
            return compare2(lhs, rhs);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(View lhs, View rhs) {
            LayoutParams r1 = (LayoutParams) lhs.getLayoutParams();
            LayoutParams r2 = (LayoutParams) rhs.getLayoutParams();
            if (r1.isDecor == r2.isDecor) goto L10;
            if (r1.isDecor == false) goto L7;
            return 1;
        L7:
            return -1;
        L10:
            return r1.position - r2.position;
        }
    }

    static /* synthetic */ void access$000(ViewPager r0, int r1) {
        r0.setScrollState(r1);
    }

    static /* synthetic */ PagerAdapter access$200(ViewPager r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ int access$300(ViewPager r0) {
        return r0.mCurItem;
    }

    static /* synthetic */ int[] access$400() {
        return LAYOUT_ATTRS;
    }

    static {
        LAYOUT_ATTRS = new int[]{R.attr.layout_gravity};
        COMPARATOR = new AnonymousClass1();
        sInterpolator = new AnonymousClass2();
        sPositionComparator = new ViewPositionComparator();
    }

    public ViewPager(Context context) {
        super(context);
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new AnonymousClass3(this);
        this.mScrollState = 0;
        initViewPager();
    }

    public ViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new AnonymousClass3(this);
        this.mScrollState = 0;
        initViewPager();
    }

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context r1 = getContext();
        this.mScroller = new Scroller(r1, sInterpolator);
        ViewConfiguration r2 = ViewConfiguration.get(r1);
        float r3 = r1.getResources().getDisplayMetrics().density;
        this.mTouchSlop = r2.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * r3);
        this.mMaximumVelocity = r2.getScaledMaximumFlingVelocity();
        this.mFlingDistance = (int) (25.0f * r3);
        this.mCloseEnough = (int) (2.0f * r3);
        this.mDefaultGutterSize = (int) (r3 * 16.0f);
        setAccessibilityDelegate(new MyAccessibilityDelegate(this));
        if (getImportantForAccessibility() != 0) goto L6;
        setImportantForAccessibility(1);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        super.onDetachedFromWindow();
    }

    private void setScrollState(int newState) {
        if (this.mScrollState != newState) goto L5;
        return;
    L5:
        this.mScrollState = newState;
        if (this.mPageTransformer == null) goto L11;
        if (newState == 0) goto L9;
        boolean r0 = true;
    L10:
        enableLayers(r0);
        goto L11
    L9:
        r0 = false;
    L11:
        OnPageChangeListener r1 = this.mOnPageChangeListener;
        if (r1 == null) goto L15;
        r1.onPageScrollStateChanged(newState);
        return;
    }

    public void setAdapter(PagerAdapter adapter) {
        PagerAdapter r0 = this.mAdapter;
        if (r0 == null) goto L9;
        r0.unregisterDataSetObserver(this.mObserver);
        this.mAdapter.startUpdate(this);
        int r1 = 0;
    L6:
        if (r1 >= this.mItems.size()) goto L8;
        ItemInfo r2 = this.mItems.get(r1);
        this.mAdapter.destroyItem(this, r2.position, r2.object);
        r1 = r1 + 1;
        goto L6
    L8:
        this.mAdapter.finishUpdate(this);
        this.mItems.clear();
        removeNonDecorViews();
        this.mCurItem = 0;
        scrollTo(0, 0);
    L9:
        PagerAdapter r3 = this.mAdapter;
        this.mAdapter = adapter;
        this.mExpectedAdapterCount = 0;
        if (adapter == null) goto L20;
        AnonymousClass1 r4 = null;
        if (this.mObserver != null) goto L14;
        this.mObserver = new PagerObserver(this, r4);
    L14:
        this.mAdapter.registerDataSetObserver(this.mObserver);
        this.mPopulatePending = false;
        boolean r5 = this.mFirstLayout;
        this.mFirstLayout = true;
        this.mExpectedAdapterCount = this.mAdapter.getCount();
        if (this.mRestoredCurItem < 0) goto L17;
        this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
        setCurrentItemInternal(this.mRestoredCurItem, false, true);
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        goto L20
    L17:
        if (r5 == true) goto L19;
        populate();
        goto L20
    L19:
        requestLayout();
    L20:
        OnAdapterChangeListener r7 = this.mAdapterChangeListener;
        if (r7 == null) goto L26;
        if (r3 == adapter) goto L27;
        r7.onAdapterChanged(r3, adapter);
        return;
    L27:
        return;
    }

    private void removeNonDecorViews() {
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L9;
        if (((LayoutParams) getChildAt(r0).getLayoutParams()).isDecor == true) goto L8;
        removeViewAt(r0);
        r0 = r0 - 1;
    L8:
        r0 = r0 + 1;
        goto L4
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    void setOnAdapterChangeListener(OnAdapterChangeListener listener) {
        this.mAdapterChangeListener = listener;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int item) {
        this.mPopulatePending = false;
        setCurrentItemInternal(item, !this.mFirstLayout, false);
    }

    public void setCurrentItem(int item, boolean smoothScroll) {
        this.mPopulatePending = false;
        setCurrentItemInternal(item, smoothScroll, false);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    void setCurrentItemInternal(int item, boolean smoothScroll, boolean always) {
        setCurrentItemInternal(item, smoothScroll, always, 0);
    }

    void setCurrentItemInternal(int item, boolean smoothScroll, boolean always, int velocity) {
        PagerAdapter r0 = this.mAdapter;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L45:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r0.getCount() <= 0) goto L45;
        if (always == true) goto L15;
        if (this.mCurItem != item) goto L15;
        if (this.mItems.size() == 0) goto L15;
        setScrollingCacheEnabled(false);
        return;
    L15:
        if (item >= 0) goto L18;
        item = 0;
    L20:
        int r2 = this.mOffscreenPageLimit;
        int r3 = this.mCurItem;
        if (item <= (r3 + r2)) goto L23;
    L24:
        int r4 = 0;
    L26:
        if (r4 >= this.mItems.size()) goto L29;
        this.mItems.get(r4).scrolling = true;
        r4 = r4 + 1;
    L29:
        if (this.mCurItem == item) goto L32;
        r1 = true;
    L32:
        if (this.mFirstLayout == false) goto L43;
        this.mCurItem = item;
        if (r1 == false) goto L38;
        OnPageChangeListener r6 = this.mOnPageChangeListener;
        if (r6 == null) goto L38;
        r6.onPageSelected(item);
    L38:
        if (r1 == false) goto L42;
        OnPageChangeListener r7 = this.mInternalPageChangeListener;
        if (r7 == null) goto L42;
        r7.onPageSelected(item);
    L42:
        requestLayout();
        return;
    L43:
        populate(item);
        scrollToItem(item, smoothScroll, velocity, r1);
        return;
    L23:
        if (item >= (r3 - r2)) goto L29;
    L18:
        if (item < this.mAdapter.getCount()) goto L20;
        item = this.mAdapter.getCount() - 1;
        goto L20
    }

    private void scrollToItem(int item, boolean smoothScroll, int velocity, boolean dispatchSelected) {
        ItemInfo r0 = infoForPosition(item);
        if (r0 == null) goto L5;
        int r1 = (int) (getClientWidth() * Math.max(this.mFirstOffset, Math.min(r0.offset, this.mLastOffset)));
    L6:
        if (smoothScroll == false) goto L16;
        smoothScrollTo(r1, 0, velocity);
        if (dispatchSelected == false) goto L12;
        OnPageChangeListener r7 = this.mOnPageChangeListener;
        if (r7 == null) goto L12;
        r7.onPageSelected(item);
    L12:
        if (dispatchSelected == false) goto L26;
        OnPageChangeListener r5 = this.mInternalPageChangeListener;
        if (r5 == null) goto L27;
        r5.onPageSelected(item);
        return;
    L27:
        return;
    L26:
        return;
    L16:
        if (dispatchSelected == false) goto L20;
        OnPageChangeListener r8 = this.mOnPageChangeListener;
        if (r8 == null) goto L20;
        r8.onPageSelected(item);
    L20:
        if (dispatchSelected == false) goto L24;
        OnPageChangeListener r9 = this.mInternalPageChangeListener;
        if (r9 == null) goto L24;
        r9.onPageSelected(item);
    L24:
        completeScroll(false);
        scrollTo(r1, 0);
        pageScrolled(r1);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public void setOnPageChangeListener(OnPageChangeListener listener) {
        this.mOnPageChangeListener = listener;
    }

    public void setPageTransformer(boolean reverseDrawingOrder, PageTransformer transformer) {
        int r0 = 1;
        if (transformer == null) goto L5;
        boolean r2 = true;
    L7:
        if (this.mPageTransformer == null) goto L9;
        boolean r3 = true;
    L10:
        if (r2 == r3) goto L12;
        boolean r4 = true;
    L13:
        this.mPageTransformer = transformer;
        setChildrenDrawingOrderEnabledCompat(r2);
        if (r2 == false) goto L18;
        if (reverseDrawingOrder == false) goto L17;
        r0 = 2;
    L17:
        this.mDrawingOrder = r0;
    L19:
        if (r4 == false) goto L22;
        populate();
        return;
    L22:
        return;
    L18:
        this.mDrawingOrder = 0;
        goto L19
    L12:
        r4 = false;
        goto L13
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L7
    }

    void setChildrenDrawingOrderEnabledCompat(boolean enable) {
        if (this.mSetChildrenDrawingOrderEnabled != null) goto L15;
        this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L6
    L6:
        e = move-exception;
        Log.e(TAG, "Can't find setChildrenDrawingOrderEnabled", e);
    L15:
        this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[]{Boolean.valueOf(enable)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Log.e(TAG, "Error changing children drawing order", e);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int childCount, int i) {
        if (this.mDrawingOrder != 2) goto L6;
        i = (childCount - 1) - i;
    L6:
        return ((LayoutParams) this.mDrawingOrderedChildren.get(i).getLayoutParams()).childIndex;
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener listener) {
        OnPageChangeListener r0 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = listener;
        return r0;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public void setOffscreenPageLimit(int limit) {
        if (limit >= 1) goto L6;
        Log.w(TAG, "Requested offscreen page limit " + limit + " too small; defaulting to 1");
        limit = 1;
    L6:
        if (limit == this.mOffscreenPageLimit) goto L9;
        this.mOffscreenPageLimit = limit;
        populate();
        return;
    }

    public void setPageMargin(int marginPixels) {
        int r0 = this.mPageMargin;
        this.mPageMargin = marginPixels;
        int r1 = getWidth();
        recomputeScrollPosition(r1, r1, marginPixels, r0);
        requestLayout();
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public void setPageMarginDrawable(Drawable d) {
        this.mMarginDrawable = d;
        if (d == null) goto L5;
        refreshDrawableState();
    L5:
        if (d != null) goto L7;
        boolean r1 = true;
    L8:
        setWillNotDraw(r1);
        invalidate();
        return;
    L7:
        r1 = false;
        goto L8
    }

    public void setPageMarginDrawable(int resId) {
        setPageMarginDrawable(getContext().getResources().getDrawable(resId));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable who) {
        if (super.verifyDrawable(who) == false) goto L5;
    L8:
        return true;
    L5:
        if (who == this.mMarginDrawable) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r0 = this.mMarginDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isStateful() == false) goto L9;
        r0.setState(getDrawableState());
        return;
    }

    float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((float) (((double) (f - 0.5f)) * 0.4712389167638204d));
    }

    void smoothScrollTo(int x, int y) {
        smoothScrollTo(x, y, 0);
    }

    void smoothScrollTo(int x, int y, int velocity) {
        if (getChildCount() != 0) goto L6;
        setScrollingCacheEnabled(false);
        return;
    L6:
        int r3 = getScrollX();
        int r4 = getScrollY();
        int r5 = x - r3;
        int r6 = y - r4;
        if (r5 != 0) goto L11;
        if (r6 != 0) goto L11;
        completeScroll(false);
        populate();
        setScrollState(0);
        return;
    L11:
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int r9 = getClientWidth();
        int r10 = r9 / 2;
        float r11 = r9;
        float r12 = r10;
        float r13 = r12 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(r5) * 1.0f) / r11)) * r12);
        int r14 = Math.abs(velocity);
        if (r14 <= 0) goto L14;
        int r15 = Math.round(Math.abs(r13 / r14) * 1000.0f) * 4;
    L15:
        this.mScroller.startScroll(r3, r4, r5, r6, Math.min(r15, 600));
        postInvalidateOnAnimation();
        return;
    L14:
        r15 = (int) (((Math.abs(r5) / ((r11 * this.mAdapter.getPageWidth(this.mCurItem)) + this.mPageMargin)) + 1.0f) * 100.0f);
        goto L15
    }

    ItemInfo addNewItem(int position, int index) {
        ItemInfo r0 = new ItemInfo();
        r0.position = position;
        r0.object = this.mAdapter.instantiateItem(this, position);
        r0.widthFactor = this.mAdapter.getPageWidth(position);
        if (index >= 0) goto L5;
    L8:
        this.mItems.add(r0);
    L9:
        return r0;
    L5:
        if (index >= this.mItems.size()) goto L8;
        this.mItems.add(index, r0);
        goto L9
    }

    void dataSetChanged() {
        int r0 = this.mAdapter.getCount();
        this.mExpectedAdapterCount = r0;
        if (this.mItems.size() < ((this.mOffscreenPageLimit * 2) + 1)) goto L5;
    L7:
        boolean r1 = false;
    L8:
        int r2 = this.mCurItem;
        int r5 = 0;
        boolean r6 = false;
    L10:
        if (r5 >= this.mItems.size()) goto L30;
        ItemInfo r7 = this.mItems.get(r5);
        int r8 = this.mAdapter.getItemPosition(r7.object);
        if (r8 == (-1)) goto L29;
        if (r8 != (-2)) goto L24;
        this.mItems.remove(r5);
        r5 = r5 - 1;
        if (r6 == true) goto L19;
        this.mAdapter.startUpdate(this);
        r6 = true;
    L19:
        this.mAdapter.destroyItem(this, r7.position, r7.object);
        if (this.mCurItem != r7.position) goto L22;
        r2 = Math.max(0, Math.min(this.mCurItem, r0 - 1));
    L22:
        r1 = true;
        goto L29
    L24:
        if (r7.position == r8) goto L29;
        if (r7.position != this.mCurItem) goto L28;
        r2 = r8;
    L28:
        r7.position = r8;
    L29:
        r5 = r5 + 1;
        goto L10
    L30:
        if (r6 == false) goto L32;
        this.mAdapter.finishUpdate(this);
    L32:
        Collections.sort(this.mItems, COMPARATOR);
        if (r1 == false) goto L49;
        int r3 = getChildCount();
        int r4 = 0;
    L35:
        if (r4 >= r3) goto L40;
        LayoutParams r9 = (LayoutParams) getChildAt(r4).getLayoutParams();
        if (r9.isDecor == true) goto L39;
        r9.widthFactor = 0.0f;
    L39:
        r4 = r4 + 1;
        goto L35
    L40:
        setCurrentItemInternal(r2, false, true);
        requestLayout();
        return;
    L49:
        return;
    L5:
        if (this.mItems.size() >= r0) goto L7;
        r1 = true;
        goto L8
    }

    void populate() {
        populate(this.mCurItem);
    }

    void populate(int newCurrentItem) {
        int r2 = this.mCurItem;
        if (r2 == newCurrentItem) goto L8;
        if (r2 >= newCurrentItem) goto L6;
        int r4 = 66;
    L7:
        ItemInfo r3 = infoForPosition(r2);
        this.mCurItem = newCurrentItem;
    L10:
        if (this.mAdapter != null) goto L14;
        sortChildDrawingOrder();
        return;
    L14:
        if (this.mPopulatePending == false) goto L18;
        sortChildDrawingOrder();
        return;
    L18:
        if (getWindowToken() != null) goto L20;
        return;
    L20:
        this.mAdapter.startUpdate(this);
        int r1 = this.mOffscreenPageLimit;
        int r5 = Math.max(0, this.mCurItem - r1);
        int r7 = this.mAdapter.getCount();
        int r6 = Math.min(r7 - 1, this.mCurItem + r1);
        if (r7 != this.mExpectedAdapterCount) goto L147;
        int r8 = 0;
    L24:
        if (r8 >= this.mItems.size()) goto L31;
        ItemInfo r9 = this.mItems.get(r8);
        if (r9.position >= this.mCurItem) goto L28;
        r8 = r8 + 1;
        goto L24
    L28:
        if (r9.position != this.mCurItem) goto L31;
    L32:
        if (r9 != null) goto L35;
        if (r7 <= 0) goto L35;
        r9 = addNewItem(this.mCurItem, r8);
    L35:
        if (r9 == null) goto L106;
        int r11 = r8 - 1;
        if (r11 < 0) goto L39;
        ItemInfo r12 = this.mItems.get(r11);
    L40:
        int r13 = getClientWidth();
        if (r13 > 0) goto L43;
        float r15 = 0.0f;
    L44:
        int r10 = this.mCurItem - 1;
        float r14 = 0.0f;
    L45:
        if (r10 < 0) goto L70;
        if (r14 < r15) goto L58;
        if (r10 >= r5) goto L58;
        if (r12 == null) goto L70;
        if (r10 != r12.position) goto L69;
        if (r12.scrolling == true) goto L69;
        this.mItems.remove(r11);
        this.mAdapter.destroyItem(this, r10, r12.object);
        r11 = r11 - 1;
        r8 = r8 - 1;
        if (r11 < 0) goto L67;
        ItemInfo r16 = this.mItems.get(r11);
    L68:
        r12 = r16;
    L67:
        r16 = null;
    L69:
        r10 = r10 - 1;
    L58:
        if (r12 != null) goto L60;
    L64:
        r14 = r14 + addNewItem(r10, r11 + 1).widthFactor;
        r8 = r8 + 1;
        if (r11 < 0) goto L67;
        r16 = this.mItems.get(r11);
        goto L68
    L60:
        if (r10 != r12.position) goto L64;
        r14 = r14 + r12.widthFactor;
        r11 = r11 - 1;
        if (r11 < 0) goto L67;
        r16 = this.mItems.get(r11);
    L70:
        float r17 = r9.widthFactor;
        int r18 = r8 + 1;
        if (r17 < 2.0f) goto L73;
    L105:
        calculatePageOffsets(r9, r8, r3);
        goto L106
    L73:
        if (r18 >= this.mItems.size()) goto L75;
        ItemInfo r19 = this.mItems.get(r18);
    L76:
        if (r13 > 0) goto L78;
        float r110 = 0.0f;
    L79:
        int r111 = this.mCurItem;
    L80:
        r111 = r111 + 1;
        if (r111 >= r7) goto L105;
        if (r17 < r110) goto L95;
        if (r111 <= r6) goto L95;
        if (r19 == null) goto L105;
        if (r111 != r19.position) goto L80;
        if (r19.scrolling == true) goto L80;
        this.mItems.remove(r18);
        this.mAdapter.destroyItem(this, r111, r19.object);
        if (r18 < this.mItems.size()) goto L93;
    L94:
        r19 = null;
        goto L80
    L93:
        r19 = this.mItems.get(r18);
    L95:
        if (r19 == null) goto L101;
        if (r111 != r19.position) goto L101;
        r17 = r17 + r19.widthFactor;
        r18 = r18 + 1;
        if (r18 >= this.mItems.size()) goto L94;
        r19 = this.mItems.get(r18);
    L101:
        ItemInfo r20 = addNewItem(r111, r18);
        r18 = r18 + 1;
        r17 = r17 + r20.widthFactor;
        if (r18 >= this.mItems.size()) goto L94;
        r19 = this.mItems.get(r18);
        goto L80
    L78:
        r110 = (getPaddingRight() / r13) + 2.0f;
        goto L79
    L75:
        r19 = null;
        goto L76
    L43:
        r15 = (2.0f - r9.widthFactor) + (getPaddingLeft() / r13);
        goto L44
    L39:
        r12 = null;
    L106:
        PagerAdapter r21 = this.mAdapter;
        int r22 = this.mCurItem;
        if (r9 == null) goto L109;
        Object r23 = r9.object;
    L110:
        r21.setPrimaryItem(this, r22, r23);
        this.mAdapter.finishUpdate(this);
        int r24 = getChildCount();
        int r25 = 0;
    L111:
        if (r25 >= r24) goto L121;
        View r26 = getChildAt(r25);
        LayoutParams r27 = (LayoutParams) r26.getLayoutParams();
        r27.childIndex = r25;
        if (r27.isDecor == true) goto L120;
        if (r27.widthFactor != 0.0f) goto L120;
        ItemInfo r28 = infoForChild(r26);
        if (r28 == null) goto L120;
        r27.widthFactor = r28.widthFactor;
        r27.position = r28.position;
    L120:
        r25 = r25 + 1;
        goto L111
    L121:
        sortChildDrawingOrder();
        if (hasFocus() == false) goto L141;
        View r29 = findFocus();
        if (r29 == null) goto L126;
        ItemInfo r30 = infoForAnyChild(r29);
    L127:
        if (r30 != null) goto L129;
    L130:
        int r31 = 0;
    L132:
        if (r31 >= getChildCount()) goto L190;
        View r32 = getChildAt(r31);
        ItemInfo r33 = infoForChild(r32);
        if (r33 == null) goto L140;
        if (r33.position != this.mCurItem) goto L140;
        if (r32.requestFocus(r4) == false) goto L140;
        return;
    L140:
        r31 = r31 + 1;
        goto L132
    L190:
        return;
    L129:
        if (r30.position != this.mCurItem) goto L130;
        return;
    L126:
        r30 = null;
        goto L127
    L141:
        return;
    L109:
        r23 = null;
    L31:
        r9 = null;
        goto L32
    L147:
        String r34 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L144
    L146:
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + r7 + " Pager id: " + r34 + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
    L144:
        r34 = Integer.toHexString(getId());
        goto L146
    L6:
        r4 = 17;
        goto L7
    L8:
        r4 = 2;
        r3 = null;
        goto L10
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder == 0) goto L14;
        ArrayList<View> r0 = this.mDrawingOrderedChildren;
        if (r0 != null) goto L7;
        this.mDrawingOrderedChildren = new ArrayList();
    L8:
        int r1 = getChildCount();
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L11;
        View r3 = getChildAt(r2);
        this.mDrawingOrderedChildren.add(r3);
        r2 = r2 + 1;
        goto L9
    L11:
        Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        return;
    L7:
        r0.clear();
        goto L8
    }

    private void calculatePageOffsets(ItemInfo curItem, int curIndex, ItemInfo oldCurInfo) {
        int r0 = this.mAdapter.getCount();
        int r1 = getClientWidth();
        if (r1 <= 0) goto L5;
        float r2 = this.mPageMargin / r1;
    L7:
        if (oldCurInfo == null) goto L40;
        int r3 = oldCurInfo.position;
        if (r3 >= curItem.position) goto L26;
        float r4 = (oldCurInfo.offset + oldCurInfo.widthFactor) + r2;
        int r5 = r3 + 1;
        int r13 = 0;
    L12:
        if (r5 > curItem.position) goto L40;
        if (r13 >= this.mItems.size()) goto L40;
        ItemInfo r6 = this.mItems.get(r13);
    L16:
        ItemInfo r7 = r6;
        if (r5 <= r7.position) goto L22;
        if (r13 >= (this.mItems.size() - 1)) goto L22;
        r13 = r13 + 1;
        r6 = this.mItems.get(r13);
    L22:
        if (r5 >= r7.position) goto L24;
        r4 = r4 + (this.mAdapter.getPageWidth(r5) + r2);
        r5 = r5 + 1;
        goto L22
    L24:
        r7.offset = r4;
        r4 = r4 + (r7.widthFactor + r2);
        r5 = r5 + 1;
        goto L12
    L26:
        if (r3 <= curItem.position) goto L40;
        int r8 = this.mItems.size() - 1;
        float r14 = oldCurInfo.offset;
    L28:
        r3 = r3 - 1;
        if (r3 < curItem.position) goto L40;
        if (r8 < 0) goto L40;
        ItemInfo r9 = this.mItems.get(r8);
    L32:
        ItemInfo r10 = r9;
        if (r3 >= r10.position) goto L37;
        if (r8 <= 0) goto L37;
        r8 = r8 - 1;
        r9 = this.mItems.get(r8);
    L37:
        if (r3 <= r10.position) goto L39;
        r14 = r14 - (this.mAdapter.getPageWidth(r3) + r2);
        r3 = r3 - 1;
        goto L37
    L39:
        r14 = r14 - (r10.widthFactor + r2);
        r10.offset = r14;
    L40:
        int r15 = this.mItems.size();
        float r11 = curItem.offset;
        int r12 = curItem.position - 1;
        if (curItem.position != 0) goto L43;
        float r16 = curItem.offset;
    L44:
        this.mFirstOffset = r16;
        int r17 = r0 - 1;
        if (curItem.position != r17) goto L47;
        float r18 = (curItem.offset + curItem.widthFactor) - 1.0f;
    L48:
        this.mLastOffset = r18;
        int r19 = curIndex - 1;
    L49:
        if (r19 < 0) goto L58;
        ItemInfo r20 = this.mItems.get(r19);
    L52:
        if (r12 <= r20.position) goto L54;
        r11 = r11 - (this.mAdapter.getPageWidth(r12) + r2);
        r12 = r12 - 1;
        goto L52
    L54:
        r11 = r11 - (r20.widthFactor + r2);
        r20.offset = r11;
        if (r20.position != 0) goto L57;
        this.mFirstOffset = r11;
    L57:
        r19 = r19 - 1;
        r12 = r12 - 1;
        goto L49
    L58:
        float r21 = (curItem.offset + curItem.widthFactor) + r2;
        int r110 = curItem.position + 1;
        int r111 = curIndex + 1;
    L59:
        if (r111 >= r15) goto L68;
        ItemInfo r22 = this.mItems.get(r111);
    L62:
        if (r110 >= r22.position) goto L65;
        r21 = r21 + (this.mAdapter.getPageWidth(r110) + r2);
        r110 = r110 + 1;
        goto L62
    L65:
        if (r22.position != r17) goto L67;
        this.mLastOffset = (r22.widthFactor + r21) - 1.0f;
    L67:
        r22.offset = r21;
        r21 = r21 + (r22.widthFactor + r2);
        r111 = r111 + 1;
        r110 = r110 + 1;
        goto L59
    L68:
        this.mNeedCalculatePageOffsets = false;
        return;
    L47:
        r18 = Float.MAX_VALUE;
        goto L48
    L43:
        r16 = -3.4028235E38f;
        goto L44
    L5:
        r2 = 0.0f;
        goto L7
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.position = this.mCurItem;
        PagerAdapter r2 = this.mAdapter;
        if (r2 == null) goto L5;
        r1.adapterState = r2.saveState();
    L5:
        return r1;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if ((state instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(state);
        return;
    L6:
        SavedState r4 = (SavedState) state;
        super.onRestoreInstanceState(r4.getSuperState());
        PagerAdapter r0 = this.mAdapter;
        if (r0 == null) goto L9;
        r0.restoreState(r4.adapterState, r4.loader);
        setCurrentItemInternal(r4.position, false, true);
        return;
    L9:
        this.mRestoredCurItem = r4.position;
        this.mRestoredAdapterState = r4.adapterState;
        this.mRestoredClassLoader = r4.loader;
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (checkLayoutParams(params) == true) goto L5;
        params = generateLayoutParams(params);
    L5:
        LayoutParams r0 = (LayoutParams) params;
        r0.isDecor |= child instanceof Decor;
        if (this.mInLayout == false) goto L14;
        if (r0 != null) goto L9;
    L13:
        r0.needsMeasure = true;
        addViewInLayout(child, index, params);
        return;
    L9:
        if (r0.isDecor == false) goto L13;
        throw new IllegalStateException("Cannot add pager decor view during layout");
    L14:
        super.addView(child, index, params);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mInLayout == false) goto L5;
        removeViewInLayout(view);
        return;
    L5:
        super.removeView(view);
    }

    ItemInfo infoForChild(View child) {
        int r0 = 0;
    L4:
        if (r0 >= this.mItems.size()) goto L9;
        ItemInfo r1 = this.mItems.get(r0);
        if (this.mAdapter.isViewFromObject(child, r1.object) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    ItemInfo infoForAnyChild(View child) {
    L2:
        Object r0 = child.getParent();
        if (r0 == this) goto L12;
        if (r0 == null) goto L9;
        if ((r0 instanceof View) == false) goto L16;
        child = (View) r0;
        goto L2
    L16:
        return null;
    L9:
        return null;
    L12:
        return infoForChild(child);
    }

    ItemInfo infoForPosition(int position) {
        int r0 = 0;
    L4:
        if (r0 >= this.mItems.size()) goto L9;
        ItemInfo r1 = this.mItems.get(r0);
        if (r1.position == position) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean r1 = false;
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
        int r2 = getMeasuredWidth();
        this.mGutterSize = Math.min(r2 / 10, this.mDefaultGutterSize);
        int r3 = (r2 - getPaddingLeft()) - getPaddingRight();
        int r4 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int r5 = getChildCount();
        int r6 = 0;
    L3:
        boolean r7 = true;
        int r8 = 1073741824;
        if (r6 >= r5) goto L51;
        View r9 = getChildAt(r6);
        if (r9.getVisibility() == 8) goto L50;
        LayoutParams r10 = (LayoutParams) r9.getLayoutParams();
        if (r10 == null) goto L50;
        if (r10.isDecor == false) goto L50;
        int r11 = r10.gravity & 7;
        int r12 = r10.gravity & 112;
        if (r12 != 48) goto L14;
    L17:
        boolean r13 = true;
    L19:
        if (r11 != 3) goto L21;
    L24:
        int r14 = Integer.MIN_VALUE;
        if (r13 == false) goto L27;
        int r15 = Integer.MIN_VALUE;
        r14 = 1073741824;
    L31:
        if (r10.width != (-2)) goto L33;
        int r16 = r14;
        int r17 = r3;
    L39:
        if (r10.height != (-2)) goto L41;
        int r18 = r4;
        r8 = r15;
    L45:
        r9.measure(View.MeasureSpec.makeMeasureSpec(r17, r16), View.MeasureSpec.makeMeasureSpec(r18, r8));
        if (r13 == false) goto L48;
        r4 = r4 - r9.getMeasuredHeight();
        goto L50
    L48:
        if (r7 == false) goto L50;
        r3 = r3 - r9.getMeasuredWidth();
        goto L50
    L41:
        if (r10.height == (-1)) goto L43;
        r18 = r10.height;
        goto L45
    L43:
        r18 = r4;
        goto L45
    L33:
        if (r10.width == (-1)) goto L35;
        r17 = r10.width;
    L36:
        r16 = 1073741824;
        goto L39
    L35:
        r17 = r3;
        goto L36
    L27:
        if (r7 == false) goto L29;
        r15 = 1073741824;
        goto L31
    L29:
        r15 = Integer.MIN_VALUE;
        goto L31
    L21:
        if (r11 == 5) goto L24;
        r7 = r1;
        goto L24
    L14:
        if (r12 == 80) goto L17;
        r13 = r1;
    L50:
        r6 = r6 + 1;
        r1 = false;
        goto L3
    L51:
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(r3, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(r4, 1073741824);
        this.mInLayout = true;
        populate();
        int r19 = 0;
        this.mInLayout = false;
        int r20 = getChildCount();
    L52:
        if (r19 >= r20) goto L61;
        View r21 = getChildAt(r19);
        if (r21.getVisibility() == 8) goto L60;
        LayoutParams r22 = (LayoutParams) r21.getLayoutParams();
        if (r22 != null) goto L58;
    L59:
        r21.measure(View.MeasureSpec.makeMeasureSpec((int) (r3 * r22.widthFactor), 1073741824), this.mChildHeightMeasureSpec);
        goto L60
    L58:
        if (r22.isDecor == false) goto L59;
    L60:
        r19 = r19 + 1;
        goto L52
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w == oldw) goto L6;
        int r2 = this.mPageMargin;
        recomputeScrollPosition(w, oldw, r2, r2);
        return;
    }

    private void recomputeScrollPosition(int width, int oldWidth, int margin, int oldMargin) {
        if (oldWidth > 0) goto L4;
    L8:
        ItemInfo r8 = infoForPosition(this.mCurItem);
        if (r8 == null) goto L11;
        float r9 = Math.min(r8.offset, this.mLastOffset);
    L12:
        int r7 = (int) (r9 * ((width - getPaddingLeft()) - getPaddingRight()));
        if (r7 == getScrollX()) goto L18;
        completeScroll(false);
        scrollTo(r7, getScrollY());
        return;
    L18:
        return;
    L11:
        r9 = 0.0f;
        goto L12
    L4:
        if (this.mItems.isEmpty() == true) goto L8;
        int r1 = (int) ((getScrollX() / (((oldWidth - getPaddingLeft()) - getPaddingRight()) + oldMargin)) * (((width - getPaddingLeft()) - getPaddingRight()) + margin));
        scrollTo(r1, getScrollY());
        if (this.mScroller.isFinished() == true) goto L16;
        this.mScroller.startScroll(r1, 0, (int) (infoForPosition(this.mCurItem).offset * width), 0, this.mScroller.getDuration() - this.mScroller.timePassed());
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int r1 = getChildCount();
        int r2 = r - l;
        int r3 = b - t;
        int r4 = getPaddingLeft();
        int r5 = getPaddingTop();
        int r6 = getPaddingRight();
        int r7 = getPaddingBottom();
        int r8 = getScrollX();
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= r1) goto L33;
        View r13 = getChildAt(r10);
        if (r13.getVisibility() == 8) goto L32;
        LayoutParams r12 = (LayoutParams) r13.getLayoutParams();
        if (r12.isDecor == false) goto L32;
        int r14 = r12.gravity & 7;
        int r15 = r12.gravity & 112;
        if (r14 != 1) goto L12;
        int r16 = Math.max((r2 - r13.getMeasuredWidth()) / 2, r4);
    L19:
        int r17 = r16;
        int r18 = r4;
        r4 = r17;
    L21:
        if (r15 != 16) goto L23;
        int r19 = Math.max((r3 - r13.getMeasuredHeight()) / 2, r5);
    L30:
        int r110 = r19;
        int r111 = r5;
        r5 = r110;
    L31:
        int r9 = r4 + r8;
        r13.layout(r9, r5, r13.getMeasuredWidth() + r9, r5 + r13.getMeasuredHeight());
        r11 = r11 + 1;
        r5 = r111;
        r4 = r18;
        goto L32
    L23:
        if (r15 != 48) goto L25;
        r111 = r13.getMeasuredHeight() + r5;
        goto L31
    L25:
        if (r15 == 80) goto L27;
        r111 = r5;
        goto L31
    L27:
        r19 = (r3 - r7) - r13.getMeasuredHeight();
        r7 = r7 + r13.getMeasuredHeight();
        goto L30
    L12:
        if (r14 != 3) goto L14;
        r18 = r13.getMeasuredWidth() + r4;
        goto L21
    L14:
        if (r14 == 5) goto L16;
        r18 = r4;
        goto L21
    L16:
        r16 = (r2 - r6) - r13.getMeasuredWidth();
        r6 = r6 + r13.getMeasuredWidth();
    L32:
        r10 = r10 + 1;
        goto L4
    L33:
        int r20 = (r2 - r4) - r6;
        int r21 = 0;
    L34:
        if (r21 >= r1) goto L46;
        View r22 = getChildAt(r21);
        if (r22.getVisibility() == 8) goto L45;
        LayoutParams r112 = (LayoutParams) r22.getLayoutParams();
        if (r112.isDecor == true) goto L45;
        ItemInfo r113 = infoForChild(r22);
        if (r113 == null) goto L45;
        float r114 = r20;
        int r115 = ((int) (r113.offset * r114)) + r4;
        if (r112.needsMeasure == false) goto L44;
        r112.needsMeasure = false;
        r22.measure(View.MeasureSpec.makeMeasureSpec((int) (r114 * r112.widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec((r3 - r5) - r7, 1073741824));
    L44:
        r22.layout(r115, r5, r22.getMeasuredWidth() + r115, r22.getMeasuredHeight() + r5);
    L45:
        r21 = r21 + 1;
        goto L34
    L46:
        this.mTopPageBounds = r5;
        this.mBottomPageBounds = r3 - r7;
        this.mDecorChildCount = r11;
        if (this.mFirstLayout == false) goto L49;
        boolean r23 = false;
        scrollToItem(this.mCurItem, false, 0, false);
    L50:
        this.mFirstLayout = r23;
        this.mOverscrollDistance = r2;
        this.mOverflingDistance = r2 / 2;
        return;
    L49:
        r23 = false;
        goto L50
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.isFinished() == false) goto L5;
    L14:
        completeScroll(true);
        return;
    L5:
        if (this.mScroller.computeScrollOffset() == false) goto L14;
        int r0 = getScrollX();
        int r1 = getScrollY();
        int r2 = this.mScroller.getCurrX();
        int r3 = this.mScroller.getCurrY();
        if (r0 != r2) goto L9;
        if (r1 != r3) goto L9;
    L12:
        postInvalidateOnAnimation();
        return;
    L9:
        scrollTo(r2, r3);
        if (pageScrolled(r2) == true) goto L12;
        this.mScroller.abortAnimation();
        scrollTo(0, r3);
        goto L12
    }

    private boolean pageScrolled(int xpos) {
        if (this.mItems.size() != 0) goto L9;
        this.mCalledSuper = false;
        onPageScrolled(0, 0.0f, 0);
        if (this.mCalledSuper == false) goto L8;
        return false;
    L8:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    L9:
        ItemInfo r0 = infoForCurrentScrollPosition();
        int r3 = getClientWidth();
        int r4 = this.mPageMargin;
        int r5 = r3 + r4;
        float r6 = r3;
        int r7 = r0.position;
        float r8 = ((xpos / r6) - r0.offset) / (r0.widthFactor + (r4 / r6));
        this.mCalledSuper = false;
        onPageScrolled(r7, r8, (int) (r5 * r8));
        if (this.mCalledSuper == false) goto L14;
        return true;
    L14:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    protected void onPageScrolled(int position, float offset, int offsetPixels) {
        int r1 = 0;
        if (this.mDecorChildCount <= 0) goto L25;
        int r0 = getScrollX();
        int r3 = getPaddingLeft();
        int r4 = getPaddingRight();
        int r5 = getWidth();
        int r6 = getChildCount();
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L25;
        View r8 = getChildAt(r7);
        LayoutParams r9 = (LayoutParams) r8.getLayoutParams();
        if (r9.isDecor == false) goto L24;
        int r10 = r9.gravity & 7;
        if (r10 != 1) goto L12;
        int r11 = Math.max((r5 - r8.getMeasuredWidth()) / 2, r3);
    L19:
        int r12 = r11;
        int r13 = r3;
        r3 = r12;
    L20:
        int r14 = (r3 + r0) - r8.getLeft();
        if (r14 == 0) goto L23;
        r8.offsetLeftAndRight(r14);
    L23:
        r3 = r13;
        goto L24
    L12:
        if (r10 != 3) goto L14;
        r13 = r8.getWidth() + r3;
        goto L20
    L14:
        if (r10 == 5) goto L16;
        r13 = r3;
        goto L20
    L16:
        r11 = (r5 - r4) - r8.getMeasuredWidth();
        r4 = r4 + r8.getMeasuredWidth();
    L24:
        r7 = r7 + 1;
    L25:
        OnPageChangeListener r2 = this.mOnPageChangeListener;
        if (r2 == null) goto L28;
        r2.onPageScrolled(position, offset, offsetPixels);
    L28:
        OnPageChangeListener r15 = this.mInternalPageChangeListener;
        if (r15 == null) goto L32;
        r15.onPageScrolled(position, offset, offsetPixels);
    L32:
        if (this.mPageTransformer == null) goto L40;
        int r16 = getScrollX();
        int r17 = getChildCount();
    L34:
        if (r1 >= r17) goto L40;
        View r18 = getChildAt(r1);
        if (((LayoutParams) r18.getLayoutParams()).isDecor == true) goto L39;
        this.mPageTransformer.transformPage(r18, (r18.getLeft() - r16) / getClientWidth());
    L39:
        r1 = r1 + 1;
    L40:
        this.mCalledSuper = true;
    }

    private void completeScroll(boolean postEvents) {
        if (this.mScrollState != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        setScrollingCacheEnabled(false);
        this.mScroller.abortAnimation();
        int r1 = getScrollX();
        int r4 = getScrollY();
        int r5 = this.mScroller.getCurrX();
        int r6 = this.mScroller.getCurrY();
        if (r1 != r5) goto L10;
        if (r4 == r6) goto L11;
    L10:
        scrollTo(r5, r6);
    L11:
        this.mPopulatePending = false;
        int r2 = 0;
    L13:
        if (r2 >= this.mItems.size()) goto L18;
        ItemInfo r7 = this.mItems.get(r2);
        if (r7.scrolling == false) goto L17;
        r7.scrolling = false;
        r0 = true;
    L17:
        r2 = r2 + 1;
        goto L13
    L18:
        if (r0 == false) goto L26;
        if (postEvents == false) goto L21;
        postOnAnimation(this.mEndScrollRunnable);
        return;
    L21:
        this.mEndScrollRunnable.run();
        return;
    L26:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private boolean isGutterDrag(float x, float dx) {
        if (x >= this.mGutterSize) goto L7;
        if (dx <= 0.0f) goto L7;
    L10:
        return true;
    L7:
        if (x > (getWidth() - this.mGutterSize)) goto L9;
    L11:
        return false;
    L9:
        if (dx >= 0.0f) goto L11;
        goto L10
    }

    private void enableLayers(boolean enable) {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (enable == false) goto L6;
        int r3 = 2;
    L7:
        getChildAt(r2).setLayerType(r3, null);
        r2 = r2 + 1;
        goto L3
    L6:
        r3 = 0;
        goto L7
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int r0 = ev.getAction() & 255;
        if (r0 != 3) goto L5;
    L60:
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        this.mActivePointerId = -1;
        VelocityTracker r1 = this.mVelocityTracker;
        if (r1 == null) goto L63;
        r1.recycle();
        this.mVelocityTracker = null;
    L63:
        return false;
    L5:
        if (r0 == 1) goto L60;
        if (r0 == 0) goto L15;
        if (this.mIsBeingDragged == false) goto L12;
        return true;
    L12:
        if (this.mIsUnableToDrag == false) goto L15;
        return false;
    L15:
        if (r0 == 0) goto L49;
        if (r0 != 2) goto L18;
        int r2 = this.mActivePointerId;
        if (r2 == (-1)) goto L56;
        int r3 = ev.findPointerIndex(r2);
        float r10 = ev.getX(r3);
        float r4 = r10 - this.mLastMotionX;
        float r11 = Math.abs(r4);
        float r12 = ev.getY(r3);
        float r13 = Math.abs(r12 - this.mInitialMotionY);
        if (r4 != 0.0f) goto L27;
    L32:
        int r5 = this.mTouchSlop;
        if (r11 <= r5) goto L42;
        if ((r11 * 0.5f) <= r13) goto L42;
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        setScrollState(1);
        if (r4 <= 0.0f) goto L39;
        float r6 = this.mInitialMotionX + this.mTouchSlop;
    L40:
        this.mLastMotionX = r6;
        this.mLastMotionY = r12;
        setScrollingCacheEnabled(true);
    L45:
        if (this.mIsBeingDragged == false) goto L56;
        if (performDrag(r10) == false) goto L56;
        postInvalidateOnAnimation();
        goto L56
    L39:
        r6 = this.mInitialMotionX - this.mTouchSlop;
    L42:
        if (r13 <= r5) goto L45;
        this.mIsUnableToDrag = true;
        goto L45
    L27:
        if (isGutterDrag(this.mLastMotionX, r4) == true) goto L32;
        if (canScroll(this, false, (int) r4, (int) r10, (int) r12) == false) goto L32;
        this.mLastMotionX = r10;
        this.mLastMotionY = r12;
        this.mIsUnableToDrag = true;
        return false;
    L56:
        if (this.mVelocityTracker != null) goto L58;
        this.mVelocityTracker = VelocityTracker.obtain();
    L58:
        this.mVelocityTracker.addMovement(ev);
        return this.mIsBeingDragged;
    L18:
        if (r0 != 6) goto L56;
        onSecondaryPointerUp(ev);
        goto L56
    L49:
        float r7 = ev.getX();
        this.mInitialMotionX = r7;
        this.mLastMotionX = r7;
        float r8 = ev.getY();
        this.mInitialMotionY = r8;
        this.mLastMotionY = r8;
        this.mActivePointerId = ev.getPointerId(0);
        this.mIsUnableToDrag = false;
        this.mScroller.computeScrollOffset();
        if (this.mScrollState == 2) goto L52;
    L54:
        completeScroll(false);
        this.mIsBeingDragged = false;
        goto L56
    L52:
        if (Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) goto L54;
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        setScrollState(1);
        goto L56
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        if (this.mFakeDragging == false) goto L5;
        return true;
    L5:
        boolean r2 = false;
        if (ev.getAction() == 0) goto L8;
    L10:
        PagerAdapter r0 = this.mAdapter;
        if (r0 != null) goto L13;
    L62:
        return false;
    L13:
        if (r0.getCount() == 0) goto L62;
        if (this.mVelocityTracker != null) goto L18;
        this.mVelocityTracker = VelocityTracker.obtain();
    L18:
        this.mVelocityTracker.addMovement(ev);
        int r1 = ev.getAction() & 255;
        if (r1 != 0) goto L21;
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        float r3 = ev.getX();
        this.mInitialMotionX = r3;
        this.mLastMotionX = r3;
        float r4 = ev.getY();
        this.mInitialMotionY = r4;
        this.mLastMotionY = r4;
        this.mActivePointerId = ev.getPointerId(0);
    L59:
        if (r2 == false) goto L61;
        postInvalidateOnAnimation();
    L61:
        return true;
    L21:
        if (r1 == 1) goto L56;
        if (r1 == 2) goto L37;
        if (r1 == 3) goto L34;
        if (r1 != 5) goto L29;
        int r5 = ev.getActionIndex();
        this.mLastMotionX = ev.getX(r5);
        this.mActivePointerId = ev.getPointerId(r5);
        goto L59
    L29:
        if (r1 != 6) goto L59;
        onSecondaryPointerUp(ev);
        this.mLastMotionX = ev.getX(ev.findPointerIndex(this.mActivePointerId));
        goto L59
    L34:
        if (this.mIsBeingDragged == false) goto L59;
        scrollToItem(this.mCurItem, true, 0, false);
        this.mActivePointerId = -1;
        endDrag();
        goto L59
    L37:
        if (this.mIsBeingDragged == true) goto L53;
        int r6 = ev.findPointerIndex(this.mActivePointerId);
        if (r6 >= 0) goto L41;
        Log.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
        goto L59
    L41:
        float r7 = ev.getX(r6);
        float r8 = Math.abs(r7 - this.mLastMotionX);
        float r9 = ev.getY(r6);
        float r10 = Math.abs(r9 - this.mLastMotionY);
        if (r8 <= this.mTouchSlop) goto L53;
        if (r8 <= r10) goto L53;
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        float r11 = this.mInitialMotionX;
        if ((r7 - r11) <= 0.0f) goto L48;
        float r12 = r11 + this.mTouchSlop;
    L49:
        this.mLastMotionX = r12;
        this.mLastMotionY = r9;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        ViewParent r13 = getParent();
        if (r13 == null) goto L53;
        r13.requestDisallowInterceptTouchEvent(true);
        goto L53
    L48:
        r12 = r11 - this.mTouchSlop;
    L53:
        if (this.mIsBeingDragged == false) goto L59;
        r2 = false | performDrag(ev.getX(ev.findPointerIndex(this.mActivePointerId)));
        goto L59
    L56:
        if (this.mIsBeingDragged == false) goto L59;
        VelocityTracker r14 = this.mVelocityTracker;
        r14.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r15 = (int) r14.getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int r16 = getClientWidth();
        int r17 = getScrollX();
        ItemInfo r18 = infoForCurrentScrollPosition();
        setCurrentItemInternal(determineTargetPage(r18.position, ((r17 / r16) - r18.offset) / r18.widthFactor, r15, (int) (ev.getX(ev.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, r15);
        this.mActivePointerId = -1;
        endDrag();
        goto L59
    L8:
        if (ev.getEdgeFlags() == 0) goto L10;
        return false;
    }

    private void requestParentDisallowInterceptTouchEvent(boolean disallowIntercept) {
        ViewParent r0 = getParent();
        if (r0 == null) goto L6;
        r0.requestDisallowInterceptTouchEvent(disallowIntercept);
        return;
    }

    @Override // android.view.View
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        if (getScrollX() == scrollX) goto L6;
        onScrollChanged(scrollX, getScrollY(), getScrollX(), getScrollY());
        scrollTo(scrollX, getScrollY());
        return;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        int r6 = maxOverScrollX;
        int r7 = maxOverScrollY;
        int r8 = getOverScrollMode();
        if (r8 == 0) goto L7;
        if (r8 == 1) goto L7;
        boolean r11 = false;
    L8:
        if (r8 == 0) goto L12;
        if (r8 == 1) goto L12;
        boolean r9 = false;
    L13:
        int r12 = scrollX + deltaX;
        if (deltaX <= 0) goto L17;
        if (r12 <= scrollRangeX) goto L20;
    L16:
        boolean r13 = true;
    L21:
        float r16 = 0.0f;
        if (isTouchEvent == false) goto L39;
        if (r13 == false) goto L39;
        int r14 = Math.abs(scrollX - scrollRangeX);
        double r15 = r14;
        double r10 = r6;
        if (r15 >= (r10 * 0.5d)) goto L29;
        float r17 = r6;
        int r18 = r14 * 12;
    L27:
        float r19 = (r17 / (r18 + r6)) * deltaX;
    L37:
        r12 = scrollX + ((int) r19);
        goto L39
    L29:
        if (r15 >= (r10 * 0.67d)) goto L32;
        r17 = r6;
        r18 = r14 * 20;
        goto L27
    L32:
        if (Math.abs(deltaX) <= 20) goto L36;
        if (deltaX <= 0) goto L35;
        r19 = 1.0f;
        goto L37
    L35:
        r19 = -1.0f;
        goto L37
    L36:
        r19 = 0.0f;
    L39:
        if (r11 == true) goto L41;
        r6 = 0;
    L41:
        int r0 = scrollY + deltaY;
        if (deltaY <= 0) goto L45;
        if (r0 <= scrollRangeY) goto L48;
    L44:
        boolean r110 = true;
    L49:
        if (isTouchEvent == false) goto L64;
        if (r110 == false) goto L64;
        int r1 = Math.abs(scrollY - scrollRangeY);
        double r111 = r1;
        double r112 = r7;
        if (r111 >= (0.5d * r112)) goto L56;
        r16 = (r7 / ((r1 * 12) + r7)) * deltaY;
    L54:
        float r113 = r16;
    L63:
        r0 = ((int) r113) + scrollY;
        goto L64
    L56:
        if (r111 >= (r112 * 0.67d)) goto L59;
        r16 = (r7 / ((r1 * 20) + r7)) * deltaY;
        goto L54
    L59:
        if (Math.abs(deltaY) <= 20) goto L54;
        if (deltaY <= 0) goto L62;
        r113 = 1.0f;
        goto L63
    L62:
        r113 = -1.0f;
    L64:
        if (r9 == true) goto L66;
        r7 = 0;
    L66:
        int r2 = -(Math.abs(r6) + Math.abs(scrollRangeX));
        int r20 = r6 + scrollRangeX;
        int r4 = -(Math.abs(r7) + Math.abs(scrollRangeY));
        int r21 = r7 + scrollRangeY;
        if (r12 <= r20) goto L71;
        if (r12 <= scrollX) goto L71;
        r12 = r20;
    L70:
        boolean r3 = true;
    L75:
        if (r0 <= r21) goto L78;
        if (r0 <= scrollY) goto L78;
        boolean r5 = true;
        r0 = r21;
    L82:
        onOverScrolled(r12, r0, r3, r5);
        if (r3 == true) goto L87;
        if (r5 == true) goto L87;
        return false;
    L87:
        return true;
    L78:
        if (r0 >= r4) goto L81;
        if (r0 >= scrollY) goto L81;
        r5 = true;
        r0 = r4;
    L81:
        r5 = false;
    L71:
        if (r12 >= r2) goto L74;
        if (r12 >= scrollX) goto L74;
        r12 = r2;
    L74:
        r3 = false;
    L48:
        r110 = false;
        goto L49
    L45:
        if (deltaY >= 0) goto L48;
        if (r0 >= scrollRangeY) goto L48;
    L20:
        r13 = false;
        goto L21
    L17:
        if (deltaX >= 0) goto L20;
        if (r12 >= scrollRangeX) goto L20;
    L12:
        r9 = true;
    L7:
        r11 = true;
        goto L8
    }

    private boolean performDrag(float x) {
        float r1 = this.mLastMotionX - x;
        this.mLastMotionX = x;
        float r11 = getScrollX() + r1;
        float r0 = getClientWidth();
        float r2 = this.mFirstOffset * r0;
        float r3 = this.mLastOffset * r0;
        ItemInfo r4 = this.mItems.get(0);
        ArrayList<ItemInfo> r5 = this.mItems;
        boolean r13 = true;
        ItemInfo r6 = r5.get(r5.size() - 1);
        if (r4.position == 0) goto L5;
        r2 = r4.offset * r0;
        boolean r7 = false;
    L7:
        if (r6.position == (this.mAdapter.getCount() - 1)) goto L9;
        r3 = r6.offset * r0;
        boolean r8 = false;
    L11:
        if (r11 >= r2) goto L15;
        if (r7 == false) goto L18;
        overScrollBy((int) r1, 0, getScrollX(), getScrollY(), (int) r2, 0, this.mOverscrollDistance, 0, true);
    L19:
        if (r13 == true) goto L21;
        int r9 = (int) r11;
        this.mLastMotionX += r11 - r9;
        scrollTo(r9, getScrollY());
        pageScrolled(r9);
    L21:
        return false;
    L18:
        r13 = false;
        goto L19
    L15:
        if (r11 <= r3) goto L18;
        if (r8 == false) goto L18;
        overScrollBy((int) r1, 0, getScrollX(), getScrollY(), (int) r3, 0, this.mOverscrollDistance, 0, true);
        goto L19
    L9:
        r8 = true;
        goto L11
    L5:
        r7 = true;
        goto L7
    }

    private ItemInfo infoForCurrentScrollPosition() {
        int r0 = getClientWidth();
        float r1 = 0.0f;
        if (r0 <= 0) goto L5;
        float r2 = getScrollX() / r0;
    L6:
        if (r0 <= 0) goto L8;
        float r3 = this.mPageMargin / r0;
    L9:
        int r8 = 0;
        boolean r9 = true;
        ItemInfo r7 = null;
        int r6 = -1;
        float r4 = 0.0f;
    L11:
        if (r8 >= this.mItems.size()) goto L30;
        ItemInfo r10 = this.mItems.get(r8);
        if (r9 == true) goto L17;
        int r11 = r6 + 1;
        if (r10.position == r11) goto L17;
        r10 = this.mTempItem;
        r10.offset = (r1 + r4) + r3;
        r10.position = r11;
        r10.widthFactor = this.mAdapter.getPageWidth(r10.position);
        r8 = r8 - 1;
    L17:
        ItemInfo r12 = r10;
        r1 = r12.offset;
        float r5 = (r12.widthFactor + r1) + r3;
        if (r9 == true) goto L24;
        if (r2 >= r1) goto L24;
        return r7;
    L24:
        if (r2 < r5) goto L29;
        if (r8 == (this.mItems.size() - 1)) goto L29;
        int r13 = r12.position;
        float r14 = r12.widthFactor;
        r8 = r8 + 1;
        r9 = false;
        r6 = r13;
        r4 = r14;
        r7 = r12;
    L29:
        return r12;
    L30:
        return r7;
    L8:
        r3 = 0.0f;
        goto L9
    L5:
        r2 = 0.0f;
        goto L6
    }

    private int determineTargetPage(int currentPage, float pageOffset, int velocity, int deltaX) {
        if (Math.abs(deltaX) <= this.mFlingDistance) goto L10;
        if (Math.abs(velocity) <= this.mMinimumVelocity) goto L10;
        if (velocity > 0) goto L15;
        currentPage = currentPage + 1;
    L15:
        if (this.mItems.size() <= 0) goto L18;
        ItemInfo r3 = this.mItems.get(0);
        ArrayList<ItemInfo> r1 = this.mItems;
        return Math.max(r3.position, Math.min(currentPage, r1.get(r1.size() - 1).position));
    L18:
        return currentPage;
    L10:
        if (currentPage < this.mCurItem) goto L12;
        float r4 = 0.4f;
    L13:
        currentPage = (int) ((currentPage + pageOffset) + r4);
        goto L15
    L12:
        r4 = 0.6f;
        goto L13
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPageMargin > 0) goto L5;
        return;
    L5:
        if (this.mMarginDrawable != null) goto L7;
        return;
    L7:
        if (this.mItems.size() > 0) goto L9;
        return;
    L9:
        if (this.mAdapter == null) goto L35;
        int r1 = getScrollX();
        int r2 = getWidth();
        float r4 = r2;
        float r3 = this.mPageMargin / r4;
        int r6 = 0;
        ItemInfo r5 = this.mItems.get(0);
        float r7 = r5.offset;
        int r8 = this.mItems.size();
        int r9 = r5.position;
        int r10 = this.mItems.get(r8 - 1).position;
    L11:
        if (r9 >= r10) goto L36;
    L13:
        if (r9 <= r5.position) goto L17;
        if (r6 >= r8) goto L17;
        r6 = r6 + 1;
        r5 = this.mItems.get(r6);
    L17:
        if (r9 != r5.position) goto L19;
        float r11 = (r5.offset + r5.widthFactor) * r4;
        float r12 = (r5.offset + r5.widthFactor) + r3;
    L20:
        int r13 = this.mPageMargin;
        if ((r13 + r11) <= r1) goto L25;
        this.mMarginDrawable.setBounds((int) r11, this.mTopPageBounds, (int) ((r13 + r11) + 0.5f), this.mBottomPageBounds);
        this.mMarginDrawable.draw(canvas);
    L25:
        if (r11 > (r1 + r2)) goto L37;
        r9 = r9 + 1;
        r7 = r12;
        r3 = r3;
        goto L11
    L37:
        return;
    L19:
        float r14 = this.mAdapter.getPageWidth(r9);
        float r15 = (r7 + r14) * r4;
        r12 = r7 + (r14 + r3);
        r11 = r15;
        goto L20
    L36:
        return;
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged == false) goto L6;
        return false;
    L6:
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker r1 = this.mVelocityTracker;
        if (r1 != null) goto L9;
        this.mVelocityTracker = VelocityTracker.obtain();
    L10:
        long r10 = SystemClock.uptimeMillis();
        MotionEvent r2 = MotionEvent.obtain(r10, r10, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(r2);
        r2.recycle();
        this.mFakeDragBeginTime = r10;
        return true;
    L9:
        r1.clear();
        goto L10
    }

    public void endFakeDrag() {
        if (this.mFakeDragging == false) goto L7;
        VelocityTracker r0 = this.mVelocityTracker;
        r0.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r1 = (int) r0.getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int r2 = getClientWidth();
        int r3 = getScrollX();
        ItemInfo r4 = infoForCurrentScrollPosition();
        setCurrentItemInternal(determineTargetPage(r4.position, ((r3 / r2) - r4.offset) / r4.widthFactor, r1, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, r1);
        endDrag();
        this.mFakeDragging = false;
        return;
    L7:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public void fakeDragBy(float xOffset) {
        if (this.mFakeDragging == false) goto L19;
        this.mLastMotionX += xOffset;
        float r0 = getScrollX() - xOffset;
        float r11 = getClientWidth();
        float r1 = this.mFirstOffset * r11;
        float r2 = this.mLastOffset * r11;
        ItemInfo r3 = this.mItems.get(0);
        ArrayList<ItemInfo> r4 = this.mItems;
        ItemInfo r5 = r4.get(r4.size() - 1);
        if (r3.position == 0) goto L8;
        r1 = r3.offset * r11;
    L8:
        if (r5.position == (this.mAdapter.getCount() - 1)) goto L11;
        r2 = r5.offset * r11;
    L11:
        if (r0 >= r1) goto L14;
        r0 = r1;
    L16:
        int r6 = (int) r0;
        this.mLastMotionX += r0 - r6;
        scrollTo(r6, getScrollY());
        pageScrolled(r6);
        MotionEvent r12 = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(r12);
        r12.recycle();
        return;
    L14:
        if (r0 <= r2) goto L16;
        r0 = r2;
        goto L16
    L19:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    private void onSecondaryPointerUp(MotionEvent ev) {
        int r0 = ev.getActionIndex();
        if (ev.getPointerId(r0) != this.mActivePointerId) goto L11;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.mLastMotionX = ev.getX(r1);
        this.mActivePointerId = ev.getPointerId(r1);
        VelocityTracker r3 = this.mVelocityTracker;
        if (r3 == null) goto L12;
        r3.clear();
        return;
    L12:
        return;
    L6:
        r1 = 0;
        goto L7
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker r0 = this.mVelocityTracker;
        if (r0 == null) goto L6;
        r0.recycle();
        this.mVelocityTracker = null;
        return;
    }

    private void setScrollingCacheEnabled(boolean enabled) {
        if (this.mScrollingCacheEnabled == enabled) goto L6;
        this.mScrollingCacheEnabled = enabled;
        return;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        if (this.mAdapter != null) goto L5;
        return false;
    L5:
        int r0 = getClientWidth();
        int r2 = getScrollX();
        if (direction < 0) goto L8;
        if (direction > 0) goto L13;
        return false;
    L13:
        if (r2 < ((int) (r0 * this.mLastOffset))) goto L15;
        return false;
    L15:
        return true;
    L8:
        if (r2 > ((int) (r0 * this.mFirstOffset))) goto L10;
        return false;
    L10:
        return true;
    }

    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if ((v instanceof ViewGroup) == false) goto L18;
        ViewGroup r1 = (ViewGroup) v;
        int r3 = v.getScrollX();
        int r4 = v.getScrollY();
        int r5 = r1.getChildCount() - 1;
    L5:
        if (r5 < 0) goto L18;
        View r7 = r1.getChildAt(r5);
        int r6 = x + r3;
        if (r6 < r7.getLeft()) goto L17;
        if (r6 >= r7.getRight()) goto L17;
        int r8 = y + r4;
        if (r8 < r7.getTop()) goto L17;
        if (r8 >= r7.getBottom()) goto L17;
        if (canScroll(r7, true, dx, r6 - r7.getLeft(), r8 - r7.getTop()) == false) goto L17;
        return true;
    L17:
        r5 = r5 - 1;
    L18:
        if (checkV == true) goto L20;
    L22:
        return false;
    L20:
        if (v.canScrollHorizontally(-dx) == false) goto L22;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (super.dispatchKeyEvent(event) == false) goto L5;
    L8:
        return true;
    L5:
        if (executeKeyEvent(event) == true) goto L8;
        return false;
    }

    public boolean executeKeyEvent(KeyEvent event) {
        if (event.getAction() != 0) goto L19;
        int r0 = event.getKeyCode();
        if (r0 == 21) goto L24;
        if (r0 == 22) goto L23;
        if (r0 != 61) goto L19;
        if (event.hasNoModifiers() == false) goto L15;
        return arrowScroll(2);
    L15:
        if (event.hasModifiers(1) == false) goto L19;
        return arrowScroll(1);
    L23:
        return arrowScroll(66);
    L24:
        return arrowScroll(17);
    L19:
        return false;
    }

    public boolean arrowScroll(int direction) {
        View r0 = findFocus();
        boolean r2 = false;
        if (r0 != this) goto L5;
    L4:
        r0 = null;
    L19:
        View r3 = FocusFinder.getInstance().findNextFocus(this, r0, direction);
        if (r3 == null) goto L35;
        if (r3 == r0) goto L35;
        if (direction != 17) goto L29;
        int r1 = getChildRectInPagerCoordinates(this.mTempRect, r3).left;
        int r4 = getChildRectInPagerCoordinates(this.mTempRect, r0).left;
        if (r0 == null) goto L27;
        if (r1 < r4) goto L27;
        boolean r5 = pageLeft();
    L28:
        r2 = r5;
    L43:
        if (r2 == false) goto L45;
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
    L45:
        return r2;
    L27:
        r5 = r3.requestFocus();
        goto L28
    L29:
        if (direction != 66) goto L43;
        int r6 = getChildRectInPagerCoordinates(this.mTempRect, r3).left;
        int r7 = getChildRectInPagerCoordinates(this.mTempRect, r0).left;
        if (r0 == null) goto L34;
        if (r6 > r7) goto L34;
        r5 = pageRight();
    L34:
        r5 = r3.requestFocus();
    L35:
        if (direction == 17) goto L42;
        if (direction == 1) goto L42;
        if (direction != 66) goto L40;
    L41:
        r2 = pageRight();
        goto L43
    L40:
        if (direction != 2) goto L43;
    L42:
        r2 = pageLeft();
        goto L43
    L5:
        if (r0 == null) goto L19;
        ViewParent r8 = r0.getParent();
    L8:
        if ((r8 instanceof ViewGroup) == false) goto L12;
        if (r8 == this) goto L10;
        r8 = r8.getParent();
        goto L8
    L10:
        boolean r9 = true;
    L13:
        if (r9 == true) goto L19;
        StringBuilder r10 = new StringBuilder();
        r10.append(r0.getClass().getSimpleName());
        ViewParent r11 = r0.getParent();
    L16:
        if ((r11 instanceof ViewGroup) == false) goto L18;
        r10.append(" => ").append(r11.getClass().getSimpleName());
        r11 = r11.getParent();
        goto L16
    L18:
        Log.e(TAG, "arrowScroll tried to find focus based on non-child current focused view " + r10.toString());
        goto L4
    L12:
        r9 = false;
        goto L13
    }

    private Rect getChildRectInPagerCoordinates(Rect outRect, View child) {
        if (outRect != null) goto L4;
        outRect = new Rect();
    L4:
        if (child != null) goto L7;
        outRect.set(0, 0, 0, 0);
        return outRect;
    L7:
        outRect.left = child.getLeft();
        outRect.right = child.getRight();
        outRect.top = child.getTop();
        outRect.bottom = child.getBottom();
        ViewParent r4 = child.getParent();
    L9:
        if ((r4 instanceof ViewGroup) == false) goto L12;
        if (r4 == this) goto L12;
        ViewGroup r5 = (ViewGroup) r4;
        outRect.left += r5.getLeft();
        outRect.right += r5.getRight();
        outRect.top += r5.getTop();
        outRect.bottom += r5.getBottom();
        r4 = r5.getParent();
    L12:
        return outRect;
    }

    boolean pageLeft() {
        int r0 = this.mCurItem;
        if (r0 <= 0) goto L6;
        setCurrentItem(r0 - 1, true);
        return true;
    L6:
        return false;
    }

    boolean pageRight() {
        PagerAdapter r0 = this.mAdapter;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (this.mCurItem >= (r0.getCount() - 1)) goto L10;
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    L10:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        int r0 = views.size();
        int r1 = getDescendantFocusability();
        if (r1 == 393216) goto L16;
        int r2 = 0;
    L6:
        if (r2 >= getChildCount()) goto L16;
        View r3 = getChildAt(r2);
        if (r3.getVisibility() != 0) goto L14;
        ItemInfo r4 = infoForChild(r3);
        if (r4 == null) goto L14;
        if (r4.position != this.mCurItem) goto L14;
        r3.addFocusables(views, direction, focusableMode);
    L14:
        r2 = r2 + 1;
    L16:
        if (r1 != 262144) goto L20;
        if (r0 == views.size()) goto L20;
        return;
    L20:
        if (isFocusable() == true) goto L23;
        return;
    L23:
        if ((focusableMode & 1) == 1) goto L25;
    L29:
        if (views == null) goto L38;
        views.add(this);
        return;
    L38:
        return;
    L25:
        if (isInTouchMode() == false) goto L29;
        if (isFocusableInTouchMode() == true) goto L29;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> views) {
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L13;
        View r1 = getChildAt(r0);
        if (r1.getVisibility() != 0) goto L12;
        ItemInfo r2 = infoForChild(r1);
        if (r2 == null) goto L12;
        if (r2.position != this.mCurItem) goto L12;
        r1.addTouchables(views);
    L12:
        r0 = r0 + 1;
        goto L4
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        int r0 = getChildCount();
        if ((direction & 2) == 0) goto L5;
        int r1 = r0;
        int r2 = 0;
        int r4 = 1;
    L6:
        if (r2 == r1) goto L17;
        View r5 = getChildAt(r2);
        if (r5.getVisibility() != 0) goto L16;
        ItemInfo r6 = infoForChild(r5);
        if (r6 == null) goto L16;
        if (r6.position != this.mCurItem) goto L16;
        if (r5.requestFocus(direction, previouslyFocusedRect) == false) goto L16;
        return true;
    L16:
        r2 = r2 + r4;
        goto L6
    L17:
        return false;
    L5:
        r2 = r0 - 1;
        r1 = -1;
        r4 = -1;
        goto L6
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        if (event.getEventType() == 4096) goto L5;
        int r0 = getChildCount();
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L19;
        View r3 = getChildAt(r2);
        if (r3.getVisibility() != 0) goto L18;
        ItemInfo r4 = infoForChild(r3);
        if (r4 == null) goto L18;
        if (r4.position != this.mCurItem) goto L18;
        if (r3.dispatchPopulateAccessibilityEvent(event) == false) goto L18;
        return true;
    L18:
        r2 = r2 + 1;
        goto L7
    L19:
        return false;
    L5:
        return super.dispatchPopulateAccessibilityEvent(event);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        if ((p instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(p) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }
}
