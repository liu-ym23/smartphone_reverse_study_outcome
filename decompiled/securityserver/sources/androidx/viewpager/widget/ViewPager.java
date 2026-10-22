package androidx.viewpager.widget;

import a.a;
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
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.ss.android.common.ApiConstants;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
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
    static final int[] LAYOUT_ATTRS = null;
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
    PagerAdapter mAdapter;
    private List<OnAdapterChangeListener> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
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
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private OnPageChangeListener mOnPageChangeListener;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffect mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    public static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        public ItemInfo() {
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

        public LayoutParams(Context r2, AttributeSet r3) {
            super(r2, r3);
            this.widthFactor = 0.0f;
            TypedArray r4 = r2.obtainStyledAttributes(r3, ViewPager.LAYOUT_ATTRS);
            this.gravity = r4.getInteger(0, 48);
            r4.recycle();
        }
    }

    public class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ ViewPager this$0;

        public MyAccessibilityDelegate(ViewPager r1) {
            this.this$0 = r1;
        }

        private boolean canScroll() {
            PagerAdapter r1 = this.this$0.mAdapter;
            if (r1 != null) goto L5;
        L7:
            return false;
        L5:
            if (r1.getCount() <= 1) goto L7;
            return true;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r2, AccessibilityEvent r3) {
            super.onInitializeAccessibilityEvent(r2, r3);
            r3.setClassName(ViewPager.class.getName());
            r3.setScrollable(canScroll());
            if (r3.getEventType() != 4096) goto L8;
            PagerAdapter r4 = this.this$0.mAdapter;
            if (r4 == null) goto L9;
            r3.setItemCount(r4.getCount());
            r3.setFromIndex(this.this$0.mCurItem);
            r3.setToIndex(this.this$0.mCurItem);
            return;
        L9:
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfoCompat r3) {
            super.onInitializeAccessibilityNodeInfo(r2, r3);
            r3.setClassName(ViewPager.class.getName());
            r3.setScrollable(canScroll());
            if (this.this$0.canScrollHorizontally(1) == false) goto L6;
            r3.addAction(4096);
        L6:
            if (this.this$0.canScrollHorizontally(-1) == false) goto L9;
            r3.addAction(8192);
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View r2, int r3, Bundle r4) {
            if (super.performAccessibilityAction(r2, r3, r4) == false) goto L6;
            return true;
        L6:
            if (r3 == 4096) goto L16;
            if (r3 == 8192) goto L11;
            return false;
        L11:
            if (this.this$0.canScrollHorizontally(-1) == false) goto L14;
            ViewPager r1 = this.this$0;
            r1.setCurrentItem(r1.mCurItem - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.this$0.canScrollHorizontally(1) == false) goto L19;
            ViewPager r5 = this.this$0;
            r5.setCurrentItem(r5.mCurItem + 1);
            return true;
        L19:
            return false;
        }
    }

    public interface OnAdapterChangeListener {
        void onAdapterChanged(@NonNull ViewPager r1, @Nullable PagerAdapter r2, @Nullable PagerAdapter r3);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int r1);

        void onPageScrolled(int r1, float r2, @Px int r3);

        void onPageSelected(int r1);
    }

    public interface PageTransformer {
        void transformPage(@NonNull View r1, float r2);
    }

    public class PagerObserver extends DataSetObserver {
        final /* synthetic */ ViewPager this$0;

        public PagerObserver(ViewPager r1) {
            this.this$0 = r1;
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

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(@NonNull Parcelable r1) {
            super(r1);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("FragmentPager.SavedState{");
            r0.append(Integer.toHexString(System.identityHashCode(this)));
            r0.append(" position=");
            return a.n(r0, "}", this.position);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            r2.writeInt(this.position);
            r2.writeParcelable(this.adapterState, r3);
        }

        public SavedState(Parcel r2, ClassLoader r3) {
            super(r2, r3);
            if (r3 != null) goto L5;
            r3 = getClass().getClassLoader();
        L5:
            this.position = r2.readInt();
            this.adapterState = r2.readParcelable(r3);
            this.loader = r3;
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public SimpleOnPageChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r1) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r1, float r2, int r3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r1) {
        }
    }

    public static class ViewPositionComparator implements Comparator<View> {
        public ViewPositionComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(View r1, View r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(View r2, View r3) {
            LayoutParams r1 = (LayoutParams) r2.getLayoutParams();
            LayoutParams r4 = (LayoutParams) r3.getLayoutParams();
            boolean r5 = r1.isDecor;
            if (r5 == r4.isDecor) goto L9;
            if (r5 == false) goto L6;
            return 1;
        L6:
            return -1;
        L9:
            return r1.position - r4.position;
        }
    }

    static {
        LAYOUT_ATTRS = new int[]{R.attr.layout_gravity};
        COMPARATOR = new AnonymousClass1();
        sInterpolator = new AnonymousClass2();
        sPositionComparator = new ViewPositionComparator();
    }

    public ViewPager(@NonNull Context r2) {
        super(r2);
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

    private void calculatePageOffsets(ItemInfo r11, int r12, ItemInfo r13) {
        int r0 = this.mAdapter.getCount();
        int r1 = getClientWidth();
        if (r1 <= 0) goto L5;
        float r2 = this.mPageMargin / r1;
    L7:
        if (r13 == null) goto L39;
        int r3 = r13.position;
        int r4 = r11.position;
        if (r3 >= r4) goto L25;
        float r5 = (r13.offset + r13.widthFactor) + r2;
        int r6 = r3 + 1;
        int r14 = 0;
    L12:
        if (r6 > r11.position) goto L39;
        if (r14 >= this.mItems.size()) goto L39;
        ItemInfo r7 = this.mItems.get(r14);
    L16:
        ItemInfo r8 = r7;
        if (r6 <= r8.position) goto L22;
        if (r14 >= (this.mItems.size() - 1)) goto L22;
        r14 = r14 + 1;
        r7 = this.mItems.get(r14);
    L22:
        if (r6 >= r8.position) goto L24;
        r5 = r5 + (this.mAdapter.getPageWidth(r6) + r2);
        r6 = r6 + 1;
        goto L22
    L24:
        r8.offset = r5;
        r5 = r5 + (r8.widthFactor + r2);
        r6 = r6 + 1;
        goto L12
    L25:
        if (r3 <= r4) goto L39;
        int r9 = this.mItems.size() - 1;
        float r15 = r13.offset;
    L27:
        r3 = r3 - 1;
        if (r3 < r11.position) goto L39;
        if (r9 < 0) goto L39;
        ItemInfo r10 = this.mItems.get(r9);
    L31:
        ItemInfo r16 = r10;
        if (r3 >= r16.position) goto L36;
        if (r9 <= 0) goto L36;
        r9 = r9 - 1;
        r10 = this.mItems.get(r9);
    L36:
        if (r3 <= r16.position) goto L38;
        r15 = r15 - (this.mAdapter.getPageWidth(r3) + r2);
        r3 = r3 - 1;
        goto L36
    L38:
        r15 = r15 - (r16.widthFactor + r2);
        r16.offset = r15;
    L39:
        int r17 = this.mItems.size();
        float r18 = r11.offset;
        int r19 = r11.position;
        int r20 = r19 - 1;
        if (r19 != 0) goto L42;
        float r21 = r18;
    L43:
        this.mFirstOffset = r21;
        int r22 = r0 - 1;
        if (r19 != r22) goto L46;
        float r23 = (r11.widthFactor + r18) - 1.0f;
    L47:
        this.mLastOffset = r23;
        int r24 = r12 - 1;
    L48:
        if (r24 < 0) goto L57;
        ItemInfo r25 = this.mItems.get(r24);
    L50:
        int r26 = r25.position;
        if (r20 <= r26) goto L53;
        r18 = r18 - (this.mAdapter.getPageWidth(r20) + r2);
        r20 = r20 - 1;
        goto L50
    L53:
        r18 = r18 - (r25.widthFactor + r2);
        r25.offset = r18;
        if (r26 != 0) goto L56;
        this.mFirstOffset = r18;
    L56:
        r24 = r24 - 1;
        r20 = r20 - 1;
        goto L48
    L57:
        float r27 = (r11.offset + r11.widthFactor) + r2;
        int r110 = r11.position + 1;
        int r111 = r12 + 1;
    L58:
        if (r111 >= r17) goto L66;
        ItemInfo r28 = this.mItems.get(r111);
    L60:
        int r29 = r28.position;
        if (r110 >= r29) goto L63;
        r27 = r27 + (this.mAdapter.getPageWidth(r110) + r2);
        r110 = r110 + 1;
        goto L60
    L63:
        if (r29 != r22) goto L65;
        this.mLastOffset = (r28.widthFactor + r27) - 1.0f;
    L65:
        r28.offset = r27;
        r27 = r27 + (r28.widthFactor + r2);
        r111 = r111 + 1;
        r110 = r110 + 1;
        goto L58
    L66:
        this.mNeedCalculatePageOffsets = false;
        return;
    L46:
        r23 = Float.MAX_VALUE;
        goto L47
    L42:
        r21 = -3.4028235E38f;
        goto L43
    L5:
        r2 = 0.0f;
        goto L7
    }

    private void completeScroll(boolean r8) {
        if (this.mScrollState != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        setScrollingCacheEnabled(false);
        if ((!this.mScroller.isFinished()) == false) goto L15;
        this.mScroller.abortAnimation();
        int r1 = getScrollX();
        int r4 = getScrollY();
        int r5 = this.mScroller.getCurrX();
        int r6 = this.mScroller.getCurrY();
        if (r1 != r5) goto L12;
        if (r4 == r6) goto L15;
    L12:
        scrollTo(r5, r6);
        if (r5 == r1) goto L15;
        pageScrolled(r5);
    L15:
        this.mPopulatePending = false;
        int r2 = 0;
    L17:
        if (r2 >= this.mItems.size()) goto L22;
        ItemInfo r7 = this.mItems.get(r2);
        if (r7.scrolling == false) goto L21;
        r7.scrolling = false;
        r0 = true;
    L21:
        r2 = r2 + 1;
        goto L17
    L22:
        if (r0 == false) goto L30;
        if (r8 == false) goto L25;
        ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
        return;
    L25:
        this.mEndScrollRunnable.run();
        return;
    L30:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private int determineTargetPage(int r2, float r3, int r4, int r5) {
        if (Math.abs(r5) <= this.mFlingDistance) goto L10;
        if (Math.abs(r4) <= this.mMinimumVelocity) goto L10;
        if (r4 > 0) goto L15;
        r2 = r2 + 1;
    L15:
        if (this.mItems.size() <= 0) goto L18;
        ItemInfo r6 = this.mItems.get(0);
        ArrayList<ItemInfo> r1 = this.mItems;
        return Math.max(r6.position, Math.min(r2, r1.get(r1.size() - 1).position));
    L18:
        return r2;
    L10:
        if (r2 < this.mCurItem) goto L12;
        float r7 = 0.4f;
    L13:
        r2 = r2 + ((int) (r3 + r7));
        goto L15
    L12:
        r7 = 0.6f;
        goto L13
    }

    private void dispatchOnPageScrolled(int r4, float r5, int r6) {
        OnPageChangeListener r0 = this.mOnPageChangeListener;
        if (r0 == null) goto L5;
        r0.onPageScrolled(r4, r5, r6);
    L5:
        List<OnPageChangeListener> r1 = this.mOnPageChangeListeners;
        if (r1 == null) goto L13;
        int r2 = r1.size();
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L13;
        OnPageChangeListener r7 = this.mOnPageChangeListeners.get(r3);
        if (r7 == null) goto L12;
        r7.onPageScrolled(r4, r5, r6);
    L12:
        r3 = r3 + 1;
    L13:
        OnPageChangeListener r8 = this.mInternalPageChangeListener;
        if (r8 == null) goto L20;
        r8.onPageScrolled(r4, r5, r6);
        return;
    }

    private void dispatchOnPageSelected(int r4) {
        OnPageChangeListener r0 = this.mOnPageChangeListener;
        if (r0 == null) goto L5;
        r0.onPageSelected(r4);
    L5:
        List<OnPageChangeListener> r1 = this.mOnPageChangeListeners;
        if (r1 == null) goto L13;
        int r2 = r1.size();
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L13;
        OnPageChangeListener r5 = this.mOnPageChangeListeners.get(r3);
        if (r5 == null) goto L12;
        r5.onPageSelected(r4);
    L12:
        r3 = r3 + 1;
    L13:
        OnPageChangeListener r6 = this.mInternalPageChangeListener;
        if (r6 == null) goto L20;
        r6.onPageSelected(r4);
        return;
    }

    private void dispatchOnScrollStateChanged(int r4) {
        OnPageChangeListener r0 = this.mOnPageChangeListener;
        if (r0 == null) goto L5;
        r0.onPageScrollStateChanged(r4);
    L5:
        List<OnPageChangeListener> r1 = this.mOnPageChangeListeners;
        if (r1 == null) goto L13;
        int r2 = r1.size();
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L13;
        OnPageChangeListener r5 = this.mOnPageChangeListeners.get(r3);
        if (r5 == null) goto L12;
        r5.onPageScrollStateChanged(r4);
    L12:
        r3 = r3 + 1;
    L13:
        OnPageChangeListener r6 = this.mInternalPageChangeListener;
        if (r6 == null) goto L20;
        r6.onPageScrollStateChanged(r4);
        return;
    }

    private void enableLayers(boolean r7) {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (r7 == false) goto L6;
        int r3 = this.mPageTransformerLayerType;
    L7:
        getChildAt(r2).setLayerType(r3, null);
        r2 = r2 + 1;
        goto L3
    L6:
        r3 = 0;
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

    private Rect getChildRectInPagerCoordinates(Rect r3, View r4) {
        if (r3 != null) goto L4;
        r3 = new Rect();
    L4:
        if (r4 != null) goto L7;
        r3.set(0, 0, 0, 0);
        return r3;
    L7:
        r3.left = r4.getLeft();
        r3.right = r4.getRight();
        r3.top = r4.getTop();
        r3.bottom = r4.getBottom();
        ViewParent r5 = r4.getParent();
    L9:
        if ((r5 instanceof ViewGroup) == false) goto L12;
        if (r5 == this) goto L12;
        ViewGroup r6 = (ViewGroup) r5;
        int r0 = r3.left;
        r3.left = r6.getLeft() + r0;
        int r1 = r3.right;
        r3.right = r6.getRight() + r1;
        int r2 = r3.top;
        r3.top = r6.getTop() + r2;
        int r7 = r3.bottom;
        r3.bottom = r6.getBottom() + r7;
        r5 = r6.getParent();
    L12:
        return r3;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
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
        r10.widthFactor = this.mAdapter.getPageWidth(r11);
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

    private static boolean isDecorView(@NonNull View r1) {
        if (r1.getClass().getAnnotation(DecorView.class) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isGutterDrag(float r3, float r4) {
        if (r3 >= this.mGutterSize) goto L7;
        if (r4 <= 0.0f) goto L7;
    L10:
        return true;
    L7:
        if (r3 > (getWidth() - this.mGutterSize)) goto L9;
    L11:
        return false;
    L9:
        if (r4 >= 0.0f) goto L11;
        goto L10
    }

    private void onSecondaryPointerUp(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r4.getPointerId(r0) != this.mActivePointerId) goto L11;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.mLastMotionX = r4.getX(r1);
        this.mActivePointerId = r4.getPointerId(r1);
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

    private boolean pageScrolled(int r8) {
        if (this.mItems.size() == 0) goto L5;
        ItemInfo r0 = infoForCurrentScrollPosition();
        int r3 = getClientWidth();
        int r4 = this.mPageMargin;
        int r5 = r3 + r4;
        float r6 = r3;
        int r7 = r0.position;
        float r9 = ((r8 / r6) - r0.offset) / (r0.widthFactor + (r4 / r6));
        this.mCalledSuper = false;
        onPageScrolled(r7, r9, (int) (r5 * r9));
        if (this.mCalledSuper == false) goto L17;
        return true;
    L17:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    L5:
        if (this.mFirstLayout == false) goto L7;
        return false;
    L7:
        this.mCalledSuper = false;
        onPageScrolled(0, 0.0f, 0);
        if (this.mCalledSuper == false) goto L11;
        return false;
    L11:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean performDrag(float r10) {
        float r0 = this.mLastMotionX - r10;
        this.mLastMotionX = r10;
        float r11 = getScrollX() + r0;
        float r1 = getClientWidth();
        float r2 = this.mFirstOffset * r1;
        float r3 = this.mLastOffset * r1;
        boolean r4 = false;
        ItemInfo r5 = this.mItems.get(0);
        ArrayList<ItemInfo> r6 = this.mItems;
        ItemInfo r7 = r6.get(r6.size() - 1);
        if (r5.position == 0) goto L5;
        r2 = r5.offset * r1;
        boolean r8 = false;
    L7:
        if (r7.position == (this.mAdapter.getCount() - 1)) goto L9;
        r3 = r7.offset * r1;
        boolean r9 = false;
    L11:
        if (r11 >= r2) goto L16;
        if (r8 == false) goto L14;
        this.mLeftEdge.onPull(Math.abs(r2 - r11) / r1);
        r4 = true;
    L14:
        r11 = r2;
    L20:
        int r12 = (int) r11;
        this.mLastMotionX = (r11 - r12) + this.mLastMotionX;
        scrollTo(r12, getScrollY());
        pageScrolled(r12);
        return r4;
    L16:
        if (r11 <= r3) goto L20;
        if (r9 == false) goto L19;
        this.mRightEdge.onPull(Math.abs(r11 - r3) / r1);
        r4 = true;
    L19:
        r11 = r3;
        goto L20
    L9:
        r9 = true;
        goto L11
    L5:
        r8 = true;
        goto L7
    }

    private void recomputeScrollPosition(int r2, int r3, int r4, int r5) {
        if (r3 > 0) goto L4;
    L9:
        ItemInfo r6 = infoForPosition(this.mCurItem);
        if (r6 == null) goto L12;
        float r7 = Math.min(r6.offset, this.mLastOffset);
    L13:
        int r8 = (int) (r7 * ((r2 - getPaddingLeft()) - getPaddingRight()));
        if (r8 == getScrollX()) goto L19;
        completeScroll(false);
        scrollTo(r8, getScrollY());
        return;
    L19:
        return;
    L12:
        r7 = 0.0f;
        goto L13
    L4:
        if (this.mItems.isEmpty() == true) goto L9;
        if (this.mScroller.isFinished() == true) goto L8;
        this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        return;
    L8:
        scrollTo((int) ((getScrollX() / (((r3 - getPaddingLeft()) - getPaddingRight()) + r5)) * (((r2 - getPaddingLeft()) - getPaddingRight()) + r4)), getScrollY());
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

    private void requestParentDisallowInterceptTouchEvent(boolean r1) {
        ViewParent r0 = getParent();
        if (r0 == null) goto L6;
        r0.requestDisallowInterceptTouchEvent(r1);
        return;
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        if (this.mLeftEdge.isFinished() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mRightEdge.isFinished() == true) goto L8;
        return false;
    }

    private void scrollToItem(int r6, boolean r7, int r8, boolean r9) {
        ItemInfo r0 = infoForPosition(r6);
        if (r0 == null) goto L5;
        int r1 = (int) (Math.max(this.mFirstOffset, Math.min(r0.offset, this.mLastOffset)) * getClientWidth());
    L6:
        if (r7 == false) goto L10;
        smoothScrollTo(r1, 0, r8);
        if (r9 == false) goto L14;
        dispatchOnPageSelected(r6);
        return;
    L14:
        return;
    L10:
        if (r9 == false) goto L12;
        dispatchOnPageSelected(r6);
    L12:
        completeScroll(false);
        scrollTo(r1, 0);
        pageScrolled(r1);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    private void setScrollingCacheEnabled(boolean r2) {
        if (this.mScrollingCacheEnabled == r2) goto L6;
        this.mScrollingCacheEnabled = r2;
        return;
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

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r7, int r8, int r9) {
        int r0 = r7.size();
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
        r3.addFocusables(r7, r8, r9);
    L14:
        r2 = r2 + 1;
    L16:
        if (r1 != 262144) goto L20;
        if (r0 == r7.size()) goto L20;
        return;
    L20:
        if (isFocusable() == true) goto L23;
        return;
    L23:
        if ((r9 & 1) == 1) goto L25;
    L29:
        r7.add(this);
        return;
    L25:
        if (isInTouchMode() == false) goto L29;
        if (isFocusableInTouchMode() == true) goto L29;
    }

    public ItemInfo addNewItem(int r3, int r4) {
        ItemInfo r0 = new ItemInfo();
        r0.position = r3;
        r0.object = this.mAdapter.instantiateItem(this, r3);
        r0.widthFactor = this.mAdapter.getPageWidth(r3);
        if (r4 >= 0) goto L5;
    L8:
        this.mItems.add(r0);
    L9:
        return r0;
    L5:
        if (r4 >= this.mItems.size()) goto L8;
        this.mItems.add(r4, r0);
        goto L9
    }

    public void addOnAdapterChangeListener(@NonNull OnAdapterChangeListener r2) {
        if (this.mAdapterChangeListeners != null) goto L5;
        this.mAdapterChangeListeners = new ArrayList();
    L5:
        this.mAdapterChangeListeners.add(r2);
    }

    public void addOnPageChangeListener(@NonNull OnPageChangeListener r2) {
        if (this.mOnPageChangeListeners != null) goto L5;
        this.mOnPageChangeListeners = new ArrayList();
    L5:
        this.mOnPageChangeListeners.add(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> r5) {
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L13;
        View r1 = getChildAt(r0);
        if (r1.getVisibility() != 0) goto L12;
        ItemInfo r2 = infoForChild(r1);
        if (r2 == null) goto L12;
        if (r2.position != this.mCurItem) goto L12;
        r1.addTouchables(r5);
    L12:
        r0 = r0 + 1;
        goto L4
    }

    @Override // android.view.ViewGroup
    public void addView(View r4, int r5, ViewGroup.LayoutParams r6) {
        if (checkLayoutParams(r6) == true) goto L5;
        r6 = generateLayoutParams(r6);
    L5:
        LayoutParams r0 = (LayoutParams) r6;
        boolean r1 = r0.isDecor | isDecorView(r4);
        r0.isDecor = r1;
        if (this.mInLayout == false) goto L11;
        if (r1 == true) goto L10;
        r0.needsMeasure = true;
        addViewInLayout(r4, r5, r6);
        return;
    L10:
        throw new IllegalStateException("Cannot add pager decor view during layout");
    L11:
        super.addView(r4, r5, r6);
    }

    public boolean arrowScroll(int r5) {
        View r0 = findFocus();
        if (r0 != this) goto L5;
    L4:
        r0 = null;
    L17:
        View r1 = FocusFinder.getInstance().findNextFocus(this, r0, r5);
        if (r1 == null) goto L32;
        if (r1 == r0) goto L32;
        if (r5 != 17) goto L26;
        int r2 = getChildRectInPagerCoordinates(this.mTempRect, r1).left;
        int r3 = getChildRectInPagerCoordinates(this.mTempRect, r0).left;
        if (r0 == null) goto L25;
        if (r2 < r3) goto L25;
        boolean r4 = pageLeft();
    L43:
        if (r4 == false) goto L45;
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(r5));
    L45:
        return r4;
    L25:
        r4 = r1.requestFocus();
        goto L43
    L26:
        if (r5 != 66) goto L40;
        int r6 = getChildRectInPagerCoordinates(this.mTempRect, r1).left;
        int r7 = getChildRectInPagerCoordinates(this.mTempRect, r0).left;
        if (r0 == null) goto L31;
        if (r6 > r7) goto L31;
        r4 = pageRight();
    L31:
        r4 = r1.requestFocus();
    L40:
        r4 = false;
    L32:
        if (r5 != 17) goto L34;
    L42:
        r4 = pageLeft();
        goto L43
    L34:
        if (r5 == 1) goto L42;
        if (r5 != 66) goto L38;
    L41:
        r4 = pageRight();
        goto L43
    L38:
        if (r5 != 2) goto L40;
    L5:
        if (r0 == null) goto L17;
        ViewParent r8 = r0.getParent();
    L8:
        if ((r8 instanceof ViewGroup) == false) goto L12;
        if (r8 == this) goto L17;
        r8 = r8.getParent();
        goto L8
    L12:
        StringBuilder r9 = new StringBuilder();
        r9.append(r0.getClass().getSimpleName());
        ViewParent r10 = r0.getParent();
    L14:
        if ((r10 instanceof ViewGroup) == false) goto L16;
        r9.append(" => ");
        r9.append(r10.getClass().getSimpleName());
        r10 = r10.getParent();
        goto L14
    L16:
        Log.e(TAG, "arrowScroll tried to find focus based on non-child current focused view " + r9.toString());
        goto L4
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

    public boolean canScroll(View r13, boolean r14, int r15, int r16, int r17) {
        if ((r13 instanceof ViewGroup) == false) goto L18;
        ViewGroup r1 = (ViewGroup) r13;
        int r3 = r13.getScrollX();
        int r4 = r13.getScrollY();
        int r5 = r1.getChildCount() - 1;
    L5:
        if (r5 < 0) goto L18;
        View r7 = r1.getChildAt(r5);
        int r6 = r16 + r3;
        if (r6 < r7.getLeft()) goto L17;
        if (r6 >= r7.getRight()) goto L17;
        int r8 = r17 + r4;
        if (r8 < r7.getTop()) goto L17;
        if (r8 >= r7.getBottom()) goto L17;
        if (canScroll(r7, true, r15, r6 - r7.getLeft(), r8 - r7.getTop()) == false) goto L17;
        return true;
    L17:
        r5 = r5 - 1;
    L18:
        if (r14 == true) goto L20;
    L22:
        return false;
    L20:
        if (r13.canScrollHorizontally(-r15) == false) goto L22;
        return true;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r5) {
        if (this.mAdapter != null) goto L5;
        return false;
    L5:
        int r0 = getClientWidth();
        int r2 = getScrollX();
        if (r5 < 0) goto L8;
        if (r5 > 0) goto L13;
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

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r2) {
        if ((r2 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r2) == false) goto L7;
        return true;
    }

    public void clearOnPageChangeListeners() {
        List<OnPageChangeListener> r0 = this.mOnPageChangeListeners;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mIsScrollStarted = true;
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
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        scrollTo(r2, r3);
        if (pageScrolled(r2) == true) goto L12;
        this.mScroller.abortAnimation();
        scrollTo(0, r3);
        goto L12
    }

    public void dataSetChanged() {
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
        if (r8 != (-2)) goto L23;
        this.mItems.remove(r5);
        r5 = r5 - 1;
        if (r6 == true) goto L19;
        this.mAdapter.startUpdate(this);
        r6 = true;
    L19:
        this.mAdapter.destroyItem(this, r7.position, r7.object);
        int r3 = this.mCurItem;
        if (r3 != r7.position) goto L22;
        r2 = Math.max(0, Math.min(r3, r0 - 1));
    L22:
        r1 = true;
        goto L29
    L23:
        int r9 = r7.position;
        if (r9 == r8) goto L29;
        if (r9 != this.mCurItem) goto L28;
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
        int r4 = getChildCount();
        int r10 = 0;
    L35:
        if (r10 >= r4) goto L40;
        LayoutParams r11 = (LayoutParams) getChildAt(r10).getLayoutParams();
        if (r11.isDecor == true) goto L39;
        r11.widthFactor = 0.0f;
    L39:
        r10 = r10 + 1;
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

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r2) {
        if (super.dispatchKeyEvent(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (executeKeyEvent(r2) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r7) {
        if (r7.getEventType() == 4096) goto L5;
        int r0 = getChildCount();
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L19;
        View r3 = getChildAt(r2);
        if (r3.getVisibility() != 0) goto L18;
        ItemInfo r4 = infoForChild(r3);
        if (r4 == null) goto L18;
        if (r4.position != this.mCurItem) goto L18;
        if (r3.dispatchPopulateAccessibilityEvent(r7) == false) goto L18;
        return true;
    L18:
        r2 = r2 + 1;
        goto L7
    L19:
        return false;
    L5:
        return super.dispatchPopulateAccessibilityEvent(r7);
    }

    public float distanceInfluenceForSnapDuration(float r1) {
        return (float) Math.sin((r1 - 0.5f) * 0.47123894f);
    }

    @Override // android.view.View
    public void draw(Canvas r8) {
        super.draw(r8);
        int r0 = getOverScrollMode();
        boolean r1 = false;
        if (r0 == 0) goto L13;
        if (r0 != 1) goto L11;
        PagerAdapter r2 = this.mAdapter;
        if (r2 == null) goto L11;
        if (r2.getCount() > 1) goto L13;
    L11:
        this.mLeftEdge.finish();
        this.mRightEdge.finish();
    L18:
        if (r1 == false) goto L21;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L21:
        return;
    L13:
        if (this.mLeftEdge.isFinished() == true) goto L16;
        int r3 = r8.save();
        int r4 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r5 = getWidth();
        r8.rotate(270.0f);
        r8.translate(getPaddingTop() + (-r4), this.mFirstOffset * r5);
        this.mLeftEdge.setSize(r4, r5);
        r1 = this.mLeftEdge.draw(r8);
        r8.restoreToCount(r3);
    L16:
        if (this.mRightEdge.isFinished() == true) goto L18;
        int r6 = r8.save();
        int r7 = getWidth();
        int r9 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        r8.rotate(90.0f);
        r8.translate(-getPaddingTop(), (-(this.mLastOffset + 1.0f)) * r7);
        this.mRightEdge.setSize(r9, r7);
        r1 = r1 | this.mRightEdge.draw(r8);
        r8.restoreToCount(r6);
        goto L18
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r0 = this.mMarginDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isStateful() == false) goto L9;
        r0.setState(getDrawableState());
        return;
    }

    public void endFakeDrag() {
        if (this.mFakeDragging == false) goto L10;
        if (this.mAdapter == null) goto L7;
        VelocityTracker r0 = this.mVelocityTracker;
        r0.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r1 = (int) r0.getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int r2 = getClientWidth();
        int r3 = getScrollX();
        ItemInfo r4 = infoForCurrentScrollPosition();
        setCurrentItemInternal(determineTargetPage(r4.position, ((r3 / r2) - r4.offset) / r4.widthFactor, r1, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, r1);
    L7:
        endDrag();
        this.mFakeDragging = false;
        return;
    L10:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(@NonNull KeyEvent r4) {
        if (r4.getAction() != 0) goto L25;
        int r0 = r4.getKeyCode();
        if (r0 == 21) goto L22;
        if (r0 == 22) goto L18;
        if (r0 != 61) goto L25;
        if (r4.hasNoModifiers() == false) goto L15;
        return arrowScroll(2);
    L15:
        if (r4.hasModifiers(1) == false) goto L25;
        return arrowScroll(1);
    L18:
        if (r4.hasModifiers(2) == false) goto L30;
        return pageRight();
    L30:
        return arrowScroll(66);
    L22:
        if (r4.hasModifiers(2) == false) goto L32;
        return pageLeft();
    L32:
        return arrowScroll(17);
    L25:
        return false;
    }

    public void fakeDragBy(float r11) {
        if (this.mFakeDragging == false) goto L22;
        if (this.mAdapter != null) goto L7;
        return;
    L7:
        this.mLastMotionX += r11;
        float r0 = getScrollX() - r11;
        float r12 = getClientWidth();
        float r1 = this.mFirstOffset * r12;
        float r2 = this.mLastOffset * r12;
        ItemInfo r3 = this.mItems.get(0);
        ArrayList<ItemInfo> r4 = this.mItems;
        ItemInfo r5 = r4.get(r4.size() - 1);
        if (r3.position == 0) goto L11;
        r1 = r3.offset * r12;
    L11:
        if (r5.position == (this.mAdapter.getCount() - 1)) goto L14;
        r2 = r5.offset * r12;
    L14:
        if (r0 >= r1) goto L17;
        r0 = r1;
    L19:
        int r6 = (int) r0;
        this.mLastMotionX = (r0 - r6) + this.mLastMotionX;
        scrollTo(r6, getScrollY());
        pageScrolled(r6);
        MotionEvent r13 = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(r13);
        r13.recycle();
        return;
    L17:
        if (r0 <= r2) goto L19;
        r0 = r2;
        goto L19
    L22:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateDefaultLayoutParams();
    }

    @Nullable
    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r3, int r4) {
        if (this.mDrawingOrder != 2) goto L6;
        r4 = (r3 - 1) - r4;
    L6:
        return ((LayoutParams) this.mDrawingOrderedChildren.get(r4).getLayoutParams()).childIndex;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public ItemInfo infoForAnyChild(View r2) {
    L2:
        Object r0 = r2.getParent();
        if (r0 == this) goto L12;
        if (r0 == null) goto L9;
        if ((r0 instanceof View) == false) goto L16;
        r2 = (View) r0;
        goto L2
    L16:
        return null;
    L9:
        return null;
    L12:
        return infoForChild(r2);
    }

    public ItemInfo infoForChild(View r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mItems.size()) goto L9;
        ItemInfo r1 = this.mItems.get(r0);
        if (this.mAdapter.isViewFromObject(r5, r1.object) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    public ItemInfo infoForPosition(int r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.mItems.size()) goto L9;
        ItemInfo r1 = this.mItems.get(r0);
        if (r1.position == r4) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    public void initViewPager() {
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
        this.mLeftEdge = new EdgeEffect(r1);
        this.mRightEdge = new EdgeEffect(r1);
        this.mFlingDistance = (int) (25.0f * r3);
        this.mCloseEnough = (int) (2.0f * r3);
        this.mDefaultGutterSize = (int) (r3 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L5;
        ViewCompat.setImportantForAccessibility(this, 1);
    L5:
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass4(this));
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller r0 = this.mScroller;
        if (r0 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r0.isFinished() == true) goto L7;
        this.mScroller.abortAnimation();
        goto L7
    }

    @Override // android.view.View
    public void onDraw(Canvas r18) {
        super.onDraw(r18);
        if (this.mPageMargin > 0) goto L5;
        return;
    L5:
        if (this.mMarginDrawable != null) goto L7;
        return;
    L7:
        if (this.mItems.size() > 0) goto L9;
        return;
    L9:
        if (this.mAdapter == null) goto L34;
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
        if (r9 >= r10) goto L35;
    L12:
        int r11 = r5.position;
        if (r9 <= r11) goto L16;
        if (r6 >= r8) goto L16;
        r6 = r6 + 1;
        r5 = this.mItems.get(r6);
    L16:
        if (r9 != r11) goto L18;
        float r12 = r5.offset;
        float r13 = r5.widthFactor;
        float r14 = (r12 + r13) * r4;
        r7 = (r12 + r13) + r3;
    L20:
        if ((this.mPageMargin + r14) <= r1) goto L24;
        this.mMarginDrawable.setBounds(Math.round(r14), this.mTopPageBounds, Math.round(this.mPageMargin + r14), this.mBottomPageBounds);
        this.mMarginDrawable.draw(r18);
    L24:
        if (r14 > (r1 + r2)) goto L36;
        r9 = r9 + 1;
        r3 = r3;
        goto L11
    L36:
        return;
    L18:
        float r15 = this.mAdapter.getPageWidth(r9);
        r14 = (r7 + r15) * r4;
        r7 = (r15 + r3) + r7;
        goto L20
    L35:
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r16) {
        int r0 = r16.getAction() & 255;
        if (r0 != 3) goto L5;
    L60:
        resetTouch();
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
        int r1 = this.mActivePointerId;
        if (r1 == (-1)) goto L56;
        int r2 = r16.findPointerIndex(r1);
        float r10 = r16.getX(r2);
        float r3 = r10 - this.mLastMotionX;
        float r11 = Math.abs(r3);
        float r12 = r16.getY(r2);
        float r13 = Math.abs(r12 - this.mInitialMotionY);
        if (r3 != 0.0f) goto L27;
    L32:
        int r4 = this.mTouchSlop;
        if (r11 <= r4) goto L42;
        if ((r11 * 0.5f) <= r13) goto L42;
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        setScrollState(1);
        float r5 = this.mInitialMotionX;
        float r6 = this.mTouchSlop;
        if (r3 <= 0.0f) goto L39;
        float r7 = r5 + r6;
    L40:
        this.mLastMotionX = r7;
        this.mLastMotionY = r12;
        setScrollingCacheEnabled(true);
    L45:
        if (this.mIsBeingDragged == false) goto L56;
        if (performDrag(r10) == false) goto L56;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L56
    L39:
        r7 = r5 - r6;
    L42:
        if (r13 <= r4) goto L45;
        this.mIsUnableToDrag = true;
        goto L45
    L27:
        if (isGutterDrag(this.mLastMotionX, r3) == true) goto L32;
        if (canScroll(this, false, (int) r3, (int) r10, (int) r12) == false) goto L32;
        this.mLastMotionX = r10;
        this.mLastMotionY = r12;
        this.mIsUnableToDrag = true;
        return false;
    L56:
        if (this.mVelocityTracker != null) goto L58;
        this.mVelocityTracker = VelocityTracker.obtain();
    L58:
        this.mVelocityTracker.addMovement(r16);
        return this.mIsBeingDragged;
    L18:
        if (r0 != 6) goto L56;
        onSecondaryPointerUp(r16);
        goto L56
    L49:
        float r8 = r16.getX();
        this.mInitialMotionX = r8;
        this.mLastMotionX = r8;
        float r9 = r16.getY();
        this.mInitialMotionY = r9;
        this.mLastMotionY = r9;
        this.mActivePointerId = r16.getPointerId(0);
        this.mIsUnableToDrag = false;
        this.mIsScrollStarted = true;
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

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        int r1 = getChildCount();
        int r2 = r22 - r20;
        int r3 = r23 - r21;
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
        int r14 = r12.gravity;
        int r15 = r14 & 7;
        int r16 = r14 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        if (r15 != 1) goto L12;
        int r17 = Math.max((r2 - r13.getMeasuredWidth()) / 2, r4);
    L17:
        int r18 = r17;
        int r110 = r4;
        r4 = r18;
    L21:
        if (r16 != 16) goto L23;
        int r111 = Math.max((r3 - r13.getMeasuredHeight()) / 2, r5);
    L28:
        int r112 = r111;
        int r113 = r5;
        r5 = r112;
    L31:
        int r9 = r4 + r8;
        r13.layout(r9, r5, r13.getMeasuredWidth() + r9, r13.getMeasuredHeight() + r5);
        r11 = r11 + 1;
        r5 = r113;
        r4 = r110;
        goto L32
    L23:
        if (r16 != 48) goto L25;
        r113 = r13.getMeasuredHeight() + r5;
        goto L31
    L25:
        if (r16 == 80) goto L27;
        r113 = r5;
        goto L31
    L27:
        r111 = (r3 - r7) - r13.getMeasuredHeight();
        r7 = r7 + r13.getMeasuredHeight();
        goto L28
    L12:
        if (r15 != 3) goto L14;
        r110 = r13.getMeasuredWidth() + r4;
        goto L21
    L14:
        if (r15 == 5) goto L16;
        r110 = r4;
        goto L21
    L16:
        r17 = (r2 - r6) - r13.getMeasuredWidth();
        r6 = r6 + r13.getMeasuredWidth();
    L32:
        r10 = r10 + 1;
        goto L4
    L33:
        int r24 = (r2 - r4) - r6;
        int r25 = 0;
    L34:
        if (r25 >= r1) goto L46;
        View r26 = getChildAt(r25);
        if (r26.getVisibility() == 8) goto L45;
        LayoutParams r27 = (LayoutParams) r26.getLayoutParams();
        if (r27.isDecor == true) goto L45;
        ItemInfo r114 = infoForChild(r26);
        if (r114 == null) goto L45;
        float r115 = r24;
        int r116 = ((int) (r114.offset * r115)) + r4;
        if (r27.needsMeasure == false) goto L44;
        r27.needsMeasure = false;
        r26.measure(View.MeasureSpec.makeMeasureSpec((int) (r115 * r27.widthFactor), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec((r3 - r5) - r7, BasicMeasure.EXACTLY));
    L44:
        r26.layout(r116, r5, r26.getMeasuredWidth() + r116, r26.getMeasuredHeight() + r5);
    L45:
        r25 = r25 + 1;
        goto L34
    L46:
        this.mTopPageBounds = r5;
        this.mBottomPageBounds = r3 - r7;
        this.mDecorChildCount = r11;
        if (this.mFirstLayout == false) goto L49;
        boolean r28 = false;
        scrollToItem(this.mCurItem, false, 0, false);
    L50:
        this.mFirstLayout = r28;
        return;
    L49:
        r28 = false;
        goto L50
    }

    @Override // android.view.View
    public void onMeasure(int r14, int r15) {
        int r0 = 0;
        setMeasuredDimension(View.getDefaultSize(0, r14), View.getDefaultSize(0, r15));
        int r16 = getMeasuredWidth();
        this.mGutterSize = Math.min(r16 / 10, this.mDefaultGutterSize);
        int r17 = (r16 - getPaddingLeft()) - getPaddingRight();
        int r18 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int r1 = getChildCount();
        int r2 = 0;
    L3:
        boolean r4 = true;
        int r5 = BasicMeasure.EXACTLY;
        if (r2 >= r1) goto L48;
        View r6 = getChildAt(r2);
        if (r6.getVisibility() == 8) goto L47;
        LayoutParams r3 = (LayoutParams) r6.getLayoutParams();
        if (r3 == null) goto L47;
        if (r3.isDecor == false) goto L47;
        int r7 = r3.gravity;
        int r8 = r7 & 7;
        int r9 = r7 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        if (r9 != 48) goto L14;
    L17:
        boolean r10 = true;
    L19:
        if (r8 != 3) goto L21;
    L24:
        int r11 = Integer.MIN_VALUE;
        if (r10 == false) goto L27;
        int r12 = Integer.MIN_VALUE;
        r11 = 1073741824;
    L30:
        int r13 = ((ViewGroup.LayoutParams) r3).width;
        if (r13 == (-2)) goto L35;
        if (r13 == (-1)) goto L34;
    L33:
        r11 = 1073741824;
    L36:
        int r19 = ((ViewGroup.LayoutParams) r3).height;
        if (r19 == (-2)) goto L41;
        if (r19 != (-1)) goto L42;
        r19 = r18;
    L42:
        r6.measure(View.MeasureSpec.makeMeasureSpec(r13, r11), View.MeasureSpec.makeMeasureSpec(r19, r5));
        if (r10 == false) goto L45;
        r18 = r18 - r6.getMeasuredHeight();
        goto L47
    L45:
        if (r4 == false) goto L47;
        r17 = r17 - r6.getMeasuredWidth();
        goto L47
    L41:
        r19 = r18;
        r5 = r12;
        goto L42
    L34:
        r13 = r17;
        goto L33
    L35:
        r13 = r17;
        goto L36
    L27:
        if (r4 == false) goto L29;
        r12 = 1073741824;
        goto L30
    L29:
        r12 = Integer.MIN_VALUE;
        goto L30
    L21:
        if (r8 == 5) goto L24;
        r4 = false;
        goto L24
    L14:
        if (r9 == 80) goto L17;
        r10 = false;
    L47:
        r2 = r2 + 1;
        goto L3
    L48:
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(r17, BasicMeasure.EXACTLY);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(r18, BasicMeasure.EXACTLY);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int r110 = getChildCount();
    L49:
        if (r0 >= r110) goto L58;
        View r20 = getChildAt(r0);
        if (r20.getVisibility() == 8) goto L57;
        LayoutParams r21 = (LayoutParams) r20.getLayoutParams();
        if (r21 != null) goto L55;
    L56:
        r20.measure(View.MeasureSpec.makeMeasureSpec((int) (r17 * r21.widthFactor), BasicMeasure.EXACTLY), this.mChildHeightMeasureSpec);
        goto L57
    L55:
        if (r21.isDecor == false) goto L56;
    L57:
        r0 = r0 + 1;
        goto L49
    }

    @CallSuper
    public void onPageScrolled(int r13, float r14, int r15) {
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
    L17:
        int r12 = r11;
        int r16 = r3;
        r3 = r12;
    L20:
        int r17 = (r3 + r0) - r8.getLeft();
        if (r17 == 0) goto L23;
        r8.offsetLeftAndRight(r17);
    L23:
        r3 = r16;
        goto L24
    L12:
        if (r10 != 3) goto L14;
        r16 = r8.getWidth() + r3;
        goto L20
    L14:
        if (r10 == 5) goto L16;
        r16 = r3;
        goto L20
    L16:
        r11 = (r5 - r4) - r8.getMeasuredWidth();
        r4 = r4 + r8.getMeasuredWidth();
    L24:
        r7 = r7 + 1;
    L25:
        dispatchOnPageScrolled(r13, r14, r15);
        if (this.mPageTransformer == null) goto L34;
        int r18 = getScrollX();
        int r19 = getChildCount();
    L28:
        if (r1 >= r19) goto L34;
        View r110 = getChildAt(r1);
        if (((LayoutParams) r110.getLayoutParams()).isDecor == true) goto L33;
        this.mPageTransformer.transformPage(r110, (r110.getLeft() - r18) / getClientWidth());
    L33:
        r1 = r1 + 1;
    L34:
        this.mCalledSuper = true;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r9, Rect r10) {
        int r0 = getChildCount();
        if ((r9 & 2) == 0) goto L5;
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
        if (r5.requestFocus(r9, r10) == false) goto L16;
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
    public void onRestoreInstanceState(Parcelable r4) {
        if ((r4 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) r4;
        super.onRestoreInstanceState(r5.getSuperState());
        PagerAdapter r0 = this.mAdapter;
        if (r0 == null) goto L9;
        r0.restoreState(r5.adapterState, r5.loader);
        setCurrentItemInternal(r5.position, false, true);
        return;
    L9:
        this.mRestoredCurItem = r5.position;
        this.mRestoredAdapterState = r5.adapterState;
        this.mRestoredClassLoader = r5.loader;
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
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 == r3) goto L6;
        int r5 = this.mPageMargin;
        recomputeScrollPosition(r1, r3, r5, r5);
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r8) {
        if (this.mFakeDragging == false) goto L5;
        return true;
    L5:
        boolean r2 = false;
        if (r8.getAction() == 0) goto L8;
    L10:
        PagerAdapter r0 = this.mAdapter;
        if (r0 != null) goto L13;
    L61:
        return false;
    L13:
        if (r0.getCount() == 0) goto L61;
        if (this.mVelocityTracker != null) goto L18;
        this.mVelocityTracker = VelocityTracker.obtain();
    L18:
        this.mVelocityTracker.addMovement(r8);
        int r1 = r8.getAction() & 255;
        if (r1 == 0) goto L57;
        if (r1 == 1) goto L55;
        if (r1 == 2) goto L36;
        if (r1 == 3) goto L33;
        if (r1 != 5) goto L28;
        int r3 = r8.getActionIndex();
        this.mLastMotionX = r8.getX(r3);
        this.mActivePointerId = r8.getPointerId(r3);
    L58:
        if (r2 == false) goto L60;
        ViewCompat.postInvalidateOnAnimation(this);
    L60:
        return true;
    L28:
        if (r1 != 6) goto L58;
        onSecondaryPointerUp(r8);
        this.mLastMotionX = r8.getX(r8.findPointerIndex(this.mActivePointerId));
        goto L58
    L33:
        if (this.mIsBeingDragged == false) goto L58;
        scrollToItem(this.mCurItem, true, 0, false);
        r2 = resetTouch();
        goto L58
    L36:
        if (this.mIsBeingDragged == true) goto L52;
        int r4 = r8.findPointerIndex(this.mActivePointerId);
        if (r4 != (-1)) goto L40;
        r2 = resetTouch();
        goto L58
    L40:
        float r5 = r8.getX(r4);
        float r6 = Math.abs(r5 - this.mLastMotionX);
        float r7 = r8.getY(r4);
        float r9 = Math.abs(r7 - this.mLastMotionY);
        if (r6 <= this.mTouchSlop) goto L52;
        if (r6 <= r9) goto L52;
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        float r10 = this.mInitialMotionX;
        if ((r5 - r10) <= 0.0f) goto L47;
        float r11 = r10 + this.mTouchSlop;
    L48:
        this.mLastMotionX = r11;
        this.mLastMotionY = r7;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        ViewParent r12 = getParent();
        if (r12 == null) goto L52;
        r12.requestDisallowInterceptTouchEvent(true);
        goto L52
    L47:
        r11 = r10 - this.mTouchSlop;
    L52:
        if (this.mIsBeingDragged == false) goto L58;
        r2 = performDrag(r8.getX(r8.findPointerIndex(this.mActivePointerId)));
        goto L58
    L55:
        if (this.mIsBeingDragged == false) goto L58;
        VelocityTracker r13 = this.mVelocityTracker;
        r13.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r14 = (int) r13.getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int r15 = getClientWidth();
        int r16 = getScrollX();
        ItemInfo r17 = infoForCurrentScrollPosition();
        float r18 = r15;
        setCurrentItemInternal(determineTargetPage(r17.position, ((r16 / r18) - r17.offset) / (r17.widthFactor + (this.mPageMargin / r18)), r14, (int) (r8.getX(r8.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, r14);
        r2 = resetTouch();
        goto L58
    L57:
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        float r19 = r8.getX();
        this.mInitialMotionX = r19;
        this.mLastMotionX = r19;
        float r20 = r8.getY();
        this.mInitialMotionY = r20;
        this.mLastMotionY = r20;
        this.mActivePointerId = r8.getPointerId(0);
        goto L58
    L8:
        if (r8.getEdgeFlags() == 0) goto L10;
        return false;
    }

    public boolean pageLeft() {
        int r0 = this.mCurItem;
        if (r0 <= 0) goto L6;
        setCurrentItem(r0 - 1, true);
        return true;
    L6:
        return false;
    }

    public boolean pageRight() {
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

    public void populate() {
        populate(this.mCurItem);
    }

    public void removeOnAdapterChangeListener(@NonNull OnAdapterChangeListener r1) {
        List<OnAdapterChangeListener> r0 = this.mAdapterChangeListeners;
        if (r0 == null) goto L6;
        r0.remove(r1);
        return;
    }

    public void removeOnPageChangeListener(@NonNull OnPageChangeListener r1) {
        List<OnPageChangeListener> r0 = this.mOnPageChangeListeners;
        if (r0 == null) goto L6;
        r0.remove(r1);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r2) {
        if (this.mInLayout == false) goto L5;
        removeViewInLayout(r2);
        return;
    L5:
        super.removeView(r2);
    }

    public void setAdapter(@Nullable PagerAdapter r8) {
        PagerAdapter r0 = this.mAdapter;
        int r2 = 0;
        if (r0 == null) goto L9;
        r0.setViewPagerObserver(null);
        this.mAdapter.startUpdate(this);
        int r1 = 0;
    L6:
        if (r1 >= this.mItems.size()) goto L8;
        ItemInfo r3 = this.mItems.get(r1);
        this.mAdapter.destroyItem(this, r3.position, r3.object);
        r1 = r1 + 1;
        goto L6
    L8:
        this.mAdapter.finishUpdate(this);
        this.mItems.clear();
        removeNonDecorViews();
        this.mCurItem = 0;
        scrollTo(0, 0);
    L9:
        PagerAdapter r4 = this.mAdapter;
        this.mAdapter = r8;
        this.mExpectedAdapterCount = 0;
        if (r8 != null) goto L12;
    L20:
        List<OnAdapterChangeListener> r5 = this.mAdapterChangeListeners;
        if (r5 != null) goto L23;
        return;
    L23:
        if (r5.isEmpty() == true) goto L30;
        int r6 = this.mAdapterChangeListeners.size();
    L25:
        if (r2 >= r6) goto L31;
        this.mAdapterChangeListeners.get(r2).onAdapterChanged(this, r4, r8);
        r2 = r2 + 1;
        goto L25
    L31:
        return;
    L30:
        return;
    L12:
        if (this.mObserver != null) goto L14;
        this.mObserver = new PagerObserver(this);
    L14:
        this.mAdapter.setViewPagerObserver(this.mObserver);
        this.mPopulatePending = false;
        boolean r7 = this.mFirstLayout;
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
        if (r7 == true) goto L19;
        populate();
        goto L20
    L19:
        requestLayout();
        goto L20
    }

    public void setCurrentItem(int r3) {
        this.mPopulatePending = false;
        setCurrentItemInternal(r3, !this.mFirstLayout, false);
    }

    public void setCurrentItemInternal(int r2, boolean r3, boolean r4) {
        setCurrentItemInternal(r2, r3, r4, 0);
    }

    public OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener r2) {
        OnPageChangeListener r0 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = r2;
        return r0;
    }

    public void setOffscreenPageLimit(int r4) {
        if (r4 >= 1) goto L6;
        Log.w(TAG, "Requested offscreen page limit " + r4 + " too small; defaulting to 1");
        r4 = 1;
    L6:
        if (r4 == this.mOffscreenPageLimit) goto L9;
        this.mOffscreenPageLimit = r4;
        populate();
        return;
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener r1) {
        this.mOnPageChangeListener = r1;
    }

    public void setPageMargin(int r3) {
        int r0 = this.mPageMargin;
        this.mPageMargin = r3;
        int r1 = getWidth();
        recomputeScrollPosition(r1, r1, r3, r0);
        requestLayout();
    }

    public void setPageMarginDrawable(@Nullable Drawable r1) {
        this.mMarginDrawable = r1;
        if (r1 == null) goto L5;
        refreshDrawableState();
    L5:
        if (r1 != null) goto L7;
        boolean r2 = true;
    L8:
        setWillNotDraw(r2);
        invalidate();
        return;
    L7:
        r2 = false;
        goto L8
    }

    public void setPageTransformer(boolean r2, @Nullable PageTransformer r3) {
        setPageTransformer(r2, r3, 2);
    }

    public void setScrollState(int r2) {
        if (this.mScrollState != r2) goto L5;
        return;
    L5:
        this.mScrollState = r2;
        if (this.mPageTransformer == null) goto L11;
        if (r2 == 0) goto L9;
        boolean r0 = true;
    L10:
        enableLayers(r0);
        goto L11
    L9:
        r0 = false;
    L11:
        dispatchOnScrollStateChanged(r2);
    }

    public void smoothScrollTo(int r2, int r3) {
        smoothScrollTo(r2, r3, 0);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r2) {
        if (super.verifyDrawable(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (r2 == this.mMarginDrawable) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    public void populate(int r18) {
        int r2 = this.mCurItem;
        if (r2 == r18) goto L5;
        ItemInfo r3 = infoForPosition(r2);
        this.mCurItem = r18;
    L7:
        if (this.mAdapter != null) goto L11;
        sortChildDrawingOrder();
        return;
    L11:
        if (this.mPopulatePending == false) goto L15;
        sortChildDrawingOrder();
        return;
    L15:
        if (getWindowToken() != null) goto L17;
        return;
    L17:
        this.mAdapter.startUpdate(this);
        int r1 = this.mOffscreenPageLimit;
        int r4 = Math.max(0, this.mCurItem - r1);
        int r6 = this.mAdapter.getCount();
        int r5 = Math.min(r6 - 1, this.mCurItem + r1);
        if (r6 != this.mExpectedAdapterCount) goto L139;
        int r7 = 0;
    L21:
        if (r7 >= this.mItems.size()) goto L27;
        ItemInfo r8 = this.mItems.get(r7);
        int r9 = r8.position;
        int r10 = this.mCurItem;
        if (r9 >= r10) goto L24;
        r7 = r7 + 1;
        goto L21
    L24:
        if (r9 != r10) goto L27;
    L28:
        if (r8 != null) goto L32;
        if (r6 <= 0) goto L32;
        r8 = addNewItem(this.mCurItem, r7);
    L32:
        if (r8 == null) goto L103;
        int r11 = r7 - 1;
        if (r11 < 0) goto L36;
        ItemInfo r12 = this.mItems.get(r11);
    L37:
        int r13 = getClientWidth();
        if (r13 > 0) goto L40;
        float r15 = 0.0f;
    L41:
        int r14 = this.mCurItem - 1;
        float r16 = 0.0f;
    L42:
        if (r14 < 0) goto L67;
        if (r16 < r15) goto L57;
        if (r14 >= r4) goto L57;
        if (r12 == null) goto L67;
        if (r14 != r12.position) goto L66;
        if (r12.scrolling == true) goto L66;
        this.mItems.remove(r11);
        this.mAdapter.destroyItem(this, r14, r12.object);
        r11 = r11 - 1;
        r7 = r7 - 1;
        if (r11 < 0) goto L55;
        ItemInfo r17 = this.mItems.get(r11);
    L56:
        r12 = r17;
    L55:
        r17 = null;
    L66:
        r14 = r14 - 1;
    L57:
        if (r12 != null) goto L59;
    L63:
        r16 = r16 + addNewItem(r14, r11 + 1).widthFactor;
        r7 = r7 + 1;
        if (r11 < 0) goto L55;
        r17 = this.mItems.get(r11);
        goto L56
    L59:
        if (r14 != r12.position) goto L63;
        r16 = r16 + r12.widthFactor;
        r11 = r11 - 1;
        if (r11 < 0) goto L55;
        r17 = this.mItems.get(r11);
    L67:
        float r19 = r8.widthFactor;
        int r20 = r7 + 1;
        if (r19 < 2.0f) goto L70;
    L102:
        calculatePageOffsets(r8, r7, r3);
        this.mAdapter.setPrimaryItem(this, this.mCurItem, r8.object);
        goto L103
    L70:
        if (r20 >= this.mItems.size()) goto L72;
        ItemInfo r21 = this.mItems.get(r20);
    L73:
        if (r13 > 0) goto L75;
        float r110 = 0.0f;
    L76:
        int r111 = this.mCurItem;
    L77:
        r111 = r111 + 1;
        if (r111 >= r6) goto L102;
        if (r19 < r110) goto L92;
        if (r111 <= r5) goto L92;
        if (r21 == null) goto L102;
        if (r111 != r21.position) goto L77;
        if (r21.scrolling == true) goto L77;
        this.mItems.remove(r20);
        this.mAdapter.destroyItem(this, r111, r21.object);
        if (r20 < this.mItems.size()) goto L90;
    L91:
        r21 = null;
        goto L77
    L90:
        r21 = this.mItems.get(r20);
    L92:
        if (r21 == null) goto L98;
        if (r111 != r21.position) goto L98;
        r19 = r19 + r21.widthFactor;
        r20 = r20 + 1;
        if (r20 >= this.mItems.size()) goto L91;
        r21 = this.mItems.get(r20);
    L98:
        ItemInfo r22 = addNewItem(r111, r20);
        r20 = r20 + 1;
        r19 = r19 + r22.widthFactor;
        if (r20 >= this.mItems.size()) goto L91;
        r21 = this.mItems.get(r20);
        goto L77
    L75:
        r110 = (getPaddingRight() / r13) + 2.0f;
        goto L76
    L72:
        r21 = null;
        goto L73
    L40:
        r15 = (getPaddingLeft() / r13) + (2.0f - r8.widthFactor);
        goto L41
    L36:
        r12 = null;
    L103:
        this.mAdapter.finishUpdate(this);
        int r23 = getChildCount();
        int r24 = 0;
    L104:
        if (r24 >= r23) goto L113;
        View r25 = getChildAt(r24);
        LayoutParams r26 = (LayoutParams) r25.getLayoutParams();
        r26.childIndex = r24;
        if (r26.isDecor == true) goto L112;
        if (r26.widthFactor != 0.0f) goto L112;
        ItemInfo r27 = infoForChild(r25);
        if (r27 == null) goto L112;
        r26.widthFactor = r27.widthFactor;
        r26.position = r27.position;
    L112:
        r24 = r24 + 1;
        goto L104
    L113:
        sortChildDrawingOrder();
        if (hasFocus() == false) goto L133;
        View r28 = findFocus();
        if (r28 == null) goto L118;
        ItemInfo r29 = infoForAnyChild(r28);
    L119:
        if (r29 != null) goto L121;
    L122:
        int r30 = 0;
    L124:
        if (r30 >= getChildCount()) goto L183;
        View r31 = getChildAt(r30);
        ItemInfo r32 = infoForChild(r31);
        if (r32 == null) goto L132;
        if (r32.position != this.mCurItem) goto L132;
        if (r31.requestFocus(2) == false) goto L132;
        return;
    L132:
        r30 = r30 + 1;
        goto L124
    L183:
        return;
    L121:
        if (r29.position != this.mCurItem) goto L122;
        return;
    L118:
        r29 = null;
        goto L119
    L133:
        return;
    L27:
        r8 = null;
        goto L28
    L139:
        String r33 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L136
    L138:
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + r6 + " Pager id: " + r33 + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
    L136:
        r33 = Integer.toHexString(getId());
        goto L138
    L5:
        r3 = null;
        goto L7
    }

    public void setCurrentItemInternal(int r5, boolean r6, boolean r7, int r8) {
        PagerAdapter r0 = this.mAdapter;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L39:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r0.getCount() <= 0) goto L39;
        if (r7 == true) goto L15;
        if (this.mCurItem != r5) goto L15;
        if (this.mItems.size() == 0) goto L15;
        setScrollingCacheEnabled(false);
        return;
    L15:
        if (r5 >= 0) goto L18;
        r5 = 0;
    L20:
        int r2 = this.mOffscreenPageLimit;
        int r3 = this.mCurItem;
        if (r5 <= (r3 + r2)) goto L23;
    L24:
        int r4 = 0;
    L26:
        if (r4 >= this.mItems.size()) goto L29;
        this.mItems.get(r4).scrolling = true;
        r4 = r4 + 1;
    L29:
        if (this.mCurItem == r5) goto L32;
        r1 = true;
    L32:
        if (this.mFirstLayout == false) goto L37;
        this.mCurItem = r5;
        if (r1 == false) goto L36;
        dispatchOnPageSelected(r5);
    L36:
        requestLayout();
        return;
    L37:
        populate(r5);
        scrollToItem(r5, r6, r8, r1);
        return;
    L23:
        if (r5 >= (r3 - r2)) goto L29;
    L18:
        if (r5 < this.mAdapter.getCount()) goto L20;
        r5 = this.mAdapter.getCount() - 1;
        goto L20
    }

    public void setPageTransformer(boolean r5, @Nullable PageTransformer r6, int r7) {
        int r1 = 1;
        if (r6 == null) goto L5;
        boolean r2 = true;
    L7:
        if (this.mPageTransformer == null) goto L9;
        boolean r3 = true;
    L10:
        if (r2 == r3) goto L12;
        boolean r4 = true;
    L13:
        this.mPageTransformer = r6;
        setChildrenDrawingOrderEnabled(r2);
        if (r2 == false) goto L18;
        if (r5 == false) goto L17;
        r1 = 2;
    L17:
        this.mDrawingOrder = r1;
        this.mPageTransformerLayerType = r7;
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

    public void smoothScrollTo(int r9, int r10, int r11) {
        if (getChildCount() != 0) goto L6;
        setScrollingCacheEnabled(false);
        return;
    L6:
        Scroller r0 = this.mScroller;
        if (r0 != null) goto L9;
    L16:
        int r1 = getScrollX();
    L15:
        int r3 = r1;
        int r4 = getScrollY();
        int r5 = r9 - r3;
        int r6 = r10 - r4;
        if (r5 != 0) goto L22;
        if (r6 != 0) goto L22;
        completeScroll(false);
        populate();
        setScrollState(0);
        return;
    L22:
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int r12 = getClientWidth();
        int r13 = r12 / 2;
        float r14 = r12;
        float r15 = r13;
        float r2 = (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(r5) * 1.0f) / r14)) * r15) + r15;
        int r16 = Math.abs(r11);
        if (r16 <= 0) goto L25;
        int r17 = Math.round(Math.abs(r2 / r16) * 1000.0f) * 4;
    L26:
        int r7 = Math.min(r17, 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(r3, r4, r5, r6, r7);
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L25:
        r17 = (int) (((Math.abs(r5) / ((this.mAdapter.getPageWidth(this.mCurItem) * r14) + this.mPageMargin)) + 1.0f) * 100.0f);
        goto L26
    L9:
        if (r0.isFinished() == true) goto L16;
        if (this.mIsScrollStarted == false) goto L13;
        r1 = this.mScroller.getCurrX();
    L14:
        this.mScroller.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L15
    L13:
        r1 = this.mScroller.getStartX();
        goto L14
    }

    public void setCurrentItem(int r2, boolean r3) {
        this.mPopulatePending = false;
        setCurrentItemInternal(r2, r3, false);
    }

    public void setPageMarginDrawable(@DrawableRes int r2) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), r2));
    }

    public ViewPager(@NonNull Context r1, @Nullable AttributeSet r2) {
        super(r1, r2);
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
}
