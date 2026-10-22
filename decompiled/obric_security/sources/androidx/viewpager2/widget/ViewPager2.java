package androidx.viewpager2.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.StatefulAdapter;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {
    public static final int OFFSCREEN_PAGE_LIMIT_DEFAULT = -1;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static boolean sFeatureEnhancedA11yEnabled = true;
    AccessibilityProvider mAccessibilityProvider;
    int mCurrentItem;
    private RecyclerView.AdapterDataObserver mCurrentItemDataSetChangeObserver;
    boolean mCurrentItemDirty;
    private CompositeOnPageChangeCallback mExternalPageChangeCallbacks;
    private FakeDrag mFakeDragger;
    private LinearLayoutManager mLayoutManager;
    private int mOffscreenPageLimit;
    private CompositeOnPageChangeCallback mPageChangeEventDispatcher;
    private PageTransformerAdapter mPageTransformerAdapter;
    private PagerSnapHelper mPagerSnapHelper;
    private Parcelable mPendingAdapterState;
    private int mPendingCurrentItem;
    RecyclerView mRecyclerView;
    private RecyclerView.ItemAnimator mSavedItemAnimator;
    private boolean mSavedItemAnimatorPresent;
    ScrollEventAdapter mScrollEventAdapter;
    private final Rect mTmpChildRect;
    private final Rect mTmpContainerRect;
    private boolean mUserInputEnabled;

    private abstract class AccessibilityProvider {
        final /* synthetic */ ViewPager2 this$0;

        boolean handlesGetAccessibilityClassName() {
            return false;
        }

        boolean handlesLmPerformAccessibilityAction(int r1) {
            return false;
        }

        boolean handlesPerformAccessibilityAction(int r1, Bundle r2) {
            return false;
        }

        boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        void onAttachAdapter(RecyclerView.Adapter<?> r1) {
        }

        void onDetachAdapter(RecyclerView.Adapter<?> r1) {
        }

        void onInitialize(CompositeOnPageChangeCallback r1, RecyclerView r2) {
        }

        void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        }

        void onLmInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat r1) {
        }

        void onRestorePendingState() {
        }

        void onRvInitializeAccessibilityEvent(AccessibilityEvent r1) {
        }

        void onSetLayoutDirection() {
        }

        void onSetNewCurrentItem() {
        }

        void onSetOrientation() {
        }

        void onSetUserInputEnabled() {
        }

        private AccessibilityProvider(ViewPager2 r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AccessibilityProvider(ViewPager2 r1, AnonymousClass1 r2) {
            this(r1);
        }

        String onGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        boolean onPerformAccessibilityAction(int r1, Bundle r2) {
            throw new IllegalStateException("Not implemented.");
        }

        boolean onLmPerformAccessibilityAction(int r1) {
            throw new IllegalStateException("Not implemented.");
        }

        CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }
    }

    class BasicAccessibilityProvider extends AccessibilityProvider {
        final /* synthetic */ ViewPager2 this$0;

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesRvGetAccessibilityClassName() {
            return true;
        }

        BasicAccessibilityProvider(ViewPager2 r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int r2) {
            if (r2 == 8192) goto L7;
            if (r2 == 4096) goto L7;
        L9:
            return false;
        L7:
            if (this.this$0.isUserInputEnabled() == true) goto L9;
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean onLmPerformAccessibilityAction(int r1) {
            if (handlesLmPerformAccessibilityAction(r1) == false) goto L7;
            return false;
        L7:
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onLmInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat r1) {
            if (this.this$0.isUserInputEnabled() == true) goto L6;
            r1.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            r1.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            r1.setScrollable(false);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public CharSequence onRvGetAccessibilityClassName() {
            if (handlesRvGetAccessibilityClassName() == false) goto L7;
            return "androidx.viewpager.widget.ViewPager";
        L7:
            throw new IllegalStateException();
        }
    }

    private static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        private DataSetChangeObserver() {
        }

        /* synthetic */ DataSetChangeObserver(AnonymousClass1 r1) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r1, int r2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r1, int r2, Object r3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r1, int r2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r1, int r2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r1, int r2, int r3) {
            onChanged();
        }
    }

    private class LinearLayoutManagerImpl extends LinearLayoutManager {
        final /* synthetic */ ViewPager2 this$0;

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView r1, View r2, Rect r3, boolean r4, boolean r5) {
            return false;
        }

        LinearLayoutManagerImpl(ViewPager2 r1, Context r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(RecyclerView.Recycler r2, RecyclerView.State r3, int r4, Bundle r5) {
            if (this.this$0.mAccessibilityProvider.handlesLmPerformAccessibilityAction(r4) == false) goto L7;
            return this.this$0.mAccessibilityProvider.onLmPerformAccessibilityAction(r4);
        L7:
            return super.performAccessibilityAction(r2, r3, r4, r5);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler r1, RecyclerView.State r2, AccessibilityNodeInfoCompat r3) {
            super.onInitializeAccessibilityNodeInfo(r1, r2, r3);
            this.this$0.mAccessibilityProvider.onLmInitializeAccessibilityNodeInfo(r3);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void calculateExtraLayoutSpace(RecyclerView.State r3, int[] r4) {
            int r0 = this.this$0.getOffscreenPageLimit();
            if (r0 != (-1)) goto L6;
            super.calculateExtraLayoutSpace(r3, r4);
            return;
        L6:
            int r2 = this.this$0.getPageSize() * r0;
            r4[0] = r2;
            r4[1] = r2;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OffscreenPageLimit {
    }

    public static abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int r1) {
        }

        public void onPageScrolled(int r1, float r2, int r3) {
        }

        public void onPageSelected(int r1) {
        }

        public OnPageChangeCallback() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    class PageAwareAccessibilityProvider extends AccessibilityProvider {
        private final AccessibilityViewCommand mActionPageBackward;
        private final AccessibilityViewCommand mActionPageForward;
        private RecyclerView.AdapterDataObserver mAdapterDataObserver;
        final /* synthetic */ ViewPager2 this$0;

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesGetAccessibilityClassName() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesPerformAccessibilityAction(int r1, Bundle r2) {
            if (r1 != 8192) goto L5;
        L8:
            return true;
        L5:
            if (r1 == 4096) goto L8;
            return false;
        }

        PageAwareAccessibilityProvider(ViewPager2 r2) {
            this.this$0 = r2;
            super(r2, null);
            this.mActionPageForward = new AnonymousClass1(this);
            this.mActionPageBackward = new AnonymousClass2(this);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onInitialize(CompositeOnPageChangeCallback r1, RecyclerView r2) {
            ViewCompat.setImportantForAccessibility(r2, 2);
            this.mAdapterDataObserver = new AnonymousClass3(this);
            if (ViewCompat.getImportantForAccessibility(this.this$0) != 0) goto L6;
            ViewCompat.setImportantForAccessibility(this.this$0, 1);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public String onGetAccessibilityClassName() {
            if (handlesGetAccessibilityClassName() == false) goto L7;
            return "androidx.viewpager.widget.ViewPager";
        L7:
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onRestorePendingState() {
            updatePageAccessibilityActions();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onAttachAdapter(RecyclerView.Adapter<?> r1) {
            updatePageAccessibilityActions();
            if (r1 == null) goto L6;
            r1.registerAdapterDataObserver(this.mAdapterDataObserver);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onDetachAdapter(RecyclerView.Adapter<?> r1) {
            if (r1 == null) goto L5;
            r1.unregisterAdapterDataObserver(this.mAdapterDataObserver);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onSetOrientation() {
            updatePageAccessibilityActions();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onSetNewCurrentItem() {
            updatePageAccessibilityActions();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onSetUserInputEnabled() {
            updatePageAccessibilityActions();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onSetLayoutDirection() {
            updatePageAccessibilityActions();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
            addCollectionInfo(r1);
            addScrollActions(r1);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean onPerformAccessibilityAction(int r2, Bundle r3) {
            if (handlesPerformAccessibilityAction(r2, r3) == false) goto L11;
            if (r2 != 8192) goto L7;
            int r4 = this.this$0.getCurrentItem() - 1;
        L8:
            setCurrentItemFromAccessibilityCommand(r4);
            return true;
        L7:
            r4 = this.this$0.getCurrentItem() + 1;
            goto L8
        L11:
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onRvInitializeAccessibilityEvent(AccessibilityEvent r2) {
            r2.setSource(this.this$0);
            r2.setClassName(onGetAccessibilityClassName());
        }

        void setCurrentItemFromAccessibilityCommand(int r2) {
            if (this.this$0.isUserInputEnabled() == false) goto L6;
            this.this$0.setCurrentItemInternal(r2, true);
            return;
        }

        void updatePageAccessibilityActions() {
            ViewPager2 r0 = this.this$0;
            int r1 = R.id.accessibilityActionPageLeft;
            ViewCompat.removeAccessibilityAction(r0, R.id.accessibilityActionPageLeft);
            ViewCompat.removeAccessibilityAction(r0, R.id.accessibilityActionPageRight);
            ViewCompat.removeAccessibilityAction(r0, R.id.accessibilityActionPageUp);
            ViewCompat.removeAccessibilityAction(r0, R.id.accessibilityActionPageDown);
            if (this.this$0.getAdapter() != null) goto L5;
            return;
        L5:
            int r5 = this.this$0.getAdapter().getItemCount();
            if (r5 != 0) goto L9;
            return;
        L9:
            if (this.this$0.isUserInputEnabled() == true) goto L12;
            return;
        L12:
            if (this.this$0.getOrientation() != 0) goto L26;
            boolean r3 = this.this$0.isRtl();
            if (r3 == false) goto L16;
            int r4 = 16908360;
        L17:
            if (r3 == false) goto L20;
            r1 = 16908361;
        L20:
            if (this.this$0.mCurrentItem >= (r5 - 1)) goto L23;
            ViewCompat.replaceAccessibilityAction(r0, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(r4, null), null, this.mActionPageForward);
        L23:
            if (this.this$0.mCurrentItem <= 0) goto L32;
            ViewCompat.replaceAccessibilityAction(r0, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(r1, null), null, this.mActionPageBackward);
            return;
        L32:
            return;
        L16:
            r4 = 16908361;
            goto L17
        L26:
            if (this.this$0.mCurrentItem >= (r5 - 1)) goto L29;
            ViewCompat.replaceAccessibilityAction(r0, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageDown, null), null, this.mActionPageForward);
        L29:
            if (this.this$0.mCurrentItem <= 0) goto L34;
            ViewCompat.replaceAccessibilityAction(r0, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageUp, null), null, this.mActionPageBackward);
            return;
        }

        private void addCollectionInfo(AccessibilityNodeInfo r4) {
            if (this.this$0.getAdapter() != null) goto L5;
            int r3 = 0;
            int r0 = 0;
        L9:
            AccessibilityNodeInfoCompat.wrap(r4).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(r3, r0, false, 0));
            return;
        L5:
            if (this.this$0.getOrientation() != 1) goto L7;
            r3 = this.this$0.getAdapter().getItemCount();
            r0 = 0;
            goto L9
        L7:
            r0 = this.this$0.getAdapter().getItemCount();
            r3 = 0;
            goto L9
        }

        private void addScrollActions(AccessibilityNodeInfo r3) {
            RecyclerView.Adapter r0 = this.this$0.getAdapter();
            if (r0 != null) goto L5;
            return;
        L5:
            int r1 = r0.getItemCount();
            if (r1 != 0) goto L8;
            return;
        L8:
            if (this.this$0.isUserInputEnabled() == true) goto L11;
            return;
        L11:
            if (this.this$0.mCurrentItem <= 0) goto L14;
            r3.addAction(8192);
        L14:
            if (this.this$0.mCurrentItem >= (r1 - 1)) goto L16;
            r3.addAction(4096);
        L16:
            r3.setScrollable(true);
        }
    }

    public interface PageTransformer {
        void transformPage(View r1, float r2);
    }

    private class PagerSnapHelperImpl extends PagerSnapHelper {
        final /* synthetic */ ViewPager2 this$0;

        PagerSnapHelperImpl(ViewPager2 r1) {
            this.this$0 = r1;
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        public View findSnapView(RecyclerView.LayoutManager r2) {
            if (this.this$0.isFakeDragging() == false) goto L6;
            return null;
        L6:
            return super.findSnapView(r2);
        }
    }

    private class RecyclerViewImpl extends RecyclerView {
        final /* synthetic */ ViewPager2 this$0;

        RecyclerViewImpl(ViewPager2 r1, Context r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            if (this.this$0.mAccessibilityProvider.handlesRvGetAccessibilityClassName() == false) goto L7;
            return this.this$0.mAccessibilityProvider.onRvGetAccessibilityClassName();
        L7:
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
            super.onInitializeAccessibilityEvent(r2);
            r2.setFromIndex(this.this$0.mCurrentItem);
            r2.setToIndex(this.this$0.mCurrentItem);
            this.this$0.mAccessibilityProvider.onRvInitializeAccessibilityEvent(r2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent r2) {
            if (this.this$0.isUserInputEnabled() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onTouchEvent(r2) == false) goto L7;
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent r2) {
            if (this.this$0.isUserInputEnabled() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onInterceptTouchEvent(r2) == false) goto L7;
            return true;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable mAdapterState;
        int mCurrentItem;
        int mRecyclerViewId;

        SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            readValues(r1, r2);
        }

        SavedState(Parcel r2) {
            super(r2);
            readValues(r2, null);
        }

        SavedState(Parcelable r1) {
            super(r1);
        }

        private void readValues(Parcel r2, ClassLoader r3) {
            this.mRecyclerViewId = r2.readInt();
            this.mCurrentItem = r2.readInt();
            this.mAdapterState = r2.readParcelable(r3);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            r2.writeInt(this.mRecyclerViewId);
            r2.writeInt(this.mCurrentItem);
            r2.writeParcelable(this.mAdapterState, r3);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollState {
    }

    private static class SmoothScrollToPosition implements Runnable {
        private final int mPosition;
        private final RecyclerView mRecyclerView;

        SmoothScrollToPosition(int r1, RecyclerView r2) {
            this.mPosition = r1;
            this.mRecyclerView = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mRecyclerView.smoothScrollToPosition(this.mPosition);
        }
    }

    static {
    }

    public ViewPager2(Context r4) {
        super(r4);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new AnonymousClass1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(r4, null);
    }

    public ViewPager2(Context r4, AttributeSet r5) {
        super(r4, r5);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new AnonymousClass1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(r4, r5);
    }

    public ViewPager2(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new AnonymousClass1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(r3, r4);
    }

    public ViewPager2(Context r2, AttributeSet r3, int r4, int r5) {
        super(r2, r3, r4, r5);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new AnonymousClass1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(r2, r3);
    }

    private void initialize(Context r3, AttributeSet r4) {
        if (sFeatureEnhancedA11yEnabled == false) goto L5;
        AccessibilityProvider r0 = new PageAwareAccessibilityProvider(this);
    L6:
        this.mAccessibilityProvider = r0;
        RecyclerViewImpl r1 = new RecyclerViewImpl(this, r3);
        this.mRecyclerView = r1;
        r1.setId(ViewCompat.generateViewId());
        this.mRecyclerView.setDescendantFocusability(131072);
        LinearLayoutManagerImpl r2 = new LinearLayoutManagerImpl(this, r3);
        this.mLayoutManager = r2;
        this.mRecyclerView.setLayoutManager(r2);
        this.mRecyclerView.setScrollingTouchSlop(1);
        setOrientation(r3, r4);
        this.mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mRecyclerView.addOnChildAttachStateChangeListener(enforceChildFillListener());
        this.mScrollEventAdapter = new ScrollEventAdapter(this);
        this.mFakeDragger = new FakeDrag(this, this.mScrollEventAdapter, this.mRecyclerView);
        PagerSnapHelperImpl r5 = new PagerSnapHelperImpl(this);
        this.mPagerSnapHelper = r5;
        r5.attachToRecyclerView(this.mRecyclerView);
        this.mRecyclerView.addOnScrollListener(this.mScrollEventAdapter);
        CompositeOnPageChangeCallback r6 = new CompositeOnPageChangeCallback(3);
        this.mPageChangeEventDispatcher = r6;
        this.mScrollEventAdapter.setOnPageChangeCallback(r6);
        OnPageChangeCallback r7 = new AnonymousClass2(this);
        OnPageChangeCallback r8 = new AnonymousClass3(this);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(r7);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(r8);
        this.mAccessibilityProvider.onInitialize(this.mPageChangeEventDispatcher, this.mRecyclerView);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(this.mExternalPageChangeCallbacks);
        PageTransformerAdapter r9 = new PageTransformerAdapter(this.mLayoutManager);
        this.mPageTransformerAdapter = r9;
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(r9);
        RecyclerView r10 = this.mRecyclerView;
        attachViewToParent(r10, 0, r10.getLayoutParams());
        return;
    L5:
        r0 = new BasicAccessibilityProvider(this);
        goto L6
    }

    private RecyclerView.OnChildAttachStateChangeListener enforceChildFillListener() {
        return new AnonymousClass4(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (this.mAccessibilityProvider.handlesGetAccessibilityClassName() == false) goto L7;
        return this.mAccessibilityProvider.onGetAccessibilityClassName();
    L7:
        return super.getAccessibilityClassName();
    }

    private void setOrientation(Context r9, AttributeSet r10) {
        TypedArray r0 = r9.obtainStyledAttributes(r10, androidx.viewpager2.R.styleable.ViewPager2);
        saveAttributeDataForStyleable(r9, androidx.viewpager2.R.styleable.ViewPager2, r10, r0, 0, 0);
        setOrientation(r0.getInt(androidx.viewpager2.R.styleable.ViewPager2_android_orientation, 0));     // Catch: Throwable -> L6
        r0.recycle();
        return;
    L6:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.mRecyclerViewId = this.mRecyclerView.getId();
        int r0 = this.mPendingCurrentItem;
        if (r0 != (-1)) goto L5;
        r0 = this.mCurrentItem;
    L5:
        r1.mCurrentItem = r0;
        Parcelable r2 = this.mPendingAdapterState;
        if (r2 == null) goto L8;
        r1.mAdapterState = r2;
    L11:
        return r1;
    L8:
        Object r3 = this.mRecyclerView.getAdapter();
        if ((r3 instanceof StatefulAdapter) == false) goto L11;
        r1.mAdapterState = ((StatefulAdapter) r3).saveState();
        goto L11
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        this.mPendingCurrentItem = r3.mCurrentItem;
        this.mPendingAdapterState = r3.mAdapterState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void restorePendingState() {
        if (this.mPendingCurrentItem != (-1)) goto L5;
        return;
    L5:
        RecyclerView.Adapter r0 = getAdapter();
        if (r0 != 0) goto L8;
        return;
    L8:
        Parcelable r2 = this.mPendingAdapterState;
        if (r2 != null) goto L11;
    L14:
        int r1 = Math.max(0, Math.min(this.mPendingCurrentItem, r0.getItemCount() - 1));
        this.mCurrentItem = r1;
        this.mPendingCurrentItem = -1;
        this.mRecyclerView.scrollToPosition(r1);
        this.mAccessibilityProvider.onRestorePendingState();
        return;
    L11:
        if ((r0 instanceof StatefulAdapter) == false) goto L13;
        ((StatefulAdapter) r0).restoreState(r2);
    L13:
        this.mPendingAdapterState = null;
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> r4) {
        Parcelable r0 = r4.get(getId());
        if ((r0 instanceof SavedState) == false) goto L5;
        int r1 = ((SavedState) r0).mRecyclerViewId;
        r4.put(this.mRecyclerView.getId(), r4.get(r1));
        r4.remove(r1);
    L5:
        super.dispatchRestoreInstanceState(r4);
        restorePendingState();
    }

    public void setAdapter(RecyclerView.Adapter r3) {
        RecyclerView.Adapter r0 = this.mRecyclerView.getAdapter();
        this.mAccessibilityProvider.onDetachAdapter(r0);
        unregisterCurrentItemDataSetTracker(r0);
        this.mRecyclerView.setAdapter(r3);
        this.mCurrentItem = 0;
        restorePendingState();
        this.mAccessibilityProvider.onAttachAdapter(r3);
        registerCurrentItemDataSetTracker(r3);
    }

    private void registerCurrentItemDataSetTracker(RecyclerView.Adapter<?> r1) {
        if (r1 == null) goto L5;
        r1.registerAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        return;
    }

    private void unregisterCurrentItemDataSetTracker(RecyclerView.Adapter<?> r1) {
        if (r1 == null) goto L5;
        r1.unregisterAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        return;
    }

    public RecyclerView.Adapter getAdapter() {
        return this.mRecyclerView.getAdapter();
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r2) {
        throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    protected void onMeasure(int r6, int r7) {
        measureChild(this.mRecyclerView, r6, r7);
        int r0 = this.mRecyclerView.getMeasuredWidth();
        int r1 = this.mRecyclerView.getMeasuredHeight();
        int r2 = this.mRecyclerView.getMeasuredState();
        int r3 = r0 + (getPaddingLeft() + getPaddingRight());
        int r4 = r1 + (getPaddingTop() + getPaddingBottom());
        int r5 = Math.max(r3, getSuggestedMinimumWidth());
        int r8 = Math.max(r4, getSuggestedMinimumHeight());
        setMeasuredDimension(resolveSizeAndState(r5, r6, r2), resolveSizeAndState(r8, r7, r2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        int r9 = this.mRecyclerView.getMeasuredWidth();
        int r0 = this.mRecyclerView.getMeasuredHeight();
        Rect r1 = this.mTmpContainerRect;
        r1.left = getPaddingLeft();
        Rect r2 = this.mTmpContainerRect;
        r2.right = (r7 - r5) - getPaddingRight();
        Rect r10 = this.mTmpContainerRect;
        r10.top = getPaddingTop();
        Rect r11 = this.mTmpContainerRect;
        r11.bottom = (r8 - r6) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.TOP_START, r9, r0, this.mTmpContainerRect, this.mTmpChildRect);
        this.mRecyclerView.layout(this.mTmpChildRect.left, this.mTmpChildRect.top, this.mTmpChildRect.right, this.mTmpChildRect.bottom);
        if (this.mCurrentItemDirty == false) goto L6;
        updateCurrentItem();
        return;
    }

    void updateCurrentItem() {
        PagerSnapHelper r0 = this.mPagerSnapHelper;
        if (r0 == null) goto L15;
        View r1 = r0.findSnapView(this.mLayoutManager);
        if (r1 != null) goto L7;
        return;
    L7:
        int r2 = this.mLayoutManager.getPosition(r1);
        if (r2 != this.mCurrentItem) goto L10;
    L12:
        this.mCurrentItemDirty = false;
        return;
    L10:
        if (getScrollState() != 0) goto L12;
        this.mPageChangeEventDispatcher.onPageSelected(r2);
        goto L12
    L15:
        throw new IllegalStateException("Design assumption violated.");
    }

    int getPageSize() {
        RecyclerView r0 = this.mRecyclerView;
        if (getOrientation() != 0) goto L5;
        int r2 = r0.getWidth() - r0.getPaddingLeft();
        int r1 = r0.getPaddingRight();
    L7:
        return r2 - r1;
    L5:
        r2 = r0.getHeight() - r0.getPaddingTop();
        r1 = r0.getPaddingBottom();
        goto L7
    }

    public void setOrientation(int r2) {
        this.mLayoutManager.setOrientation(r2);
        this.mAccessibilityProvider.onSetOrientation();
    }

    public int getOrientation() {
        return this.mLayoutManager.getOrientation();
    }

    boolean isRtl() {
        if (this.mLayoutManager.getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void setCurrentItem(int r2) {
        setCurrentItem(r2, true);
    }

    public void setCurrentItem(int r2, boolean r3) {
        if (isFakeDragging() == true) goto L7;
        setCurrentItemInternal(r2, r3);
        return;
    L7:
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    void setCurrentItemInternal(int r9, boolean r10) {
        RecyclerView.Adapter r0 = getAdapter();
        if (r0 != null) goto L9;
        if (this.mPendingCurrentItem == (-1)) goto L36;
        this.mPendingCurrentItem = Math.max(r9, 0);
        return;
    L36:
        return;
    L9:
        if (r0.getItemCount() > 0) goto L11;
        return;
    L11:
        int r11 = Math.min(Math.max(r9, 0), r0.getItemCount() - 1);
        if (r11 == this.mCurrentItem) goto L14;
    L16:
        int r1 = this.mCurrentItem;
        if (r11 != r1) goto L20;
        if (r10 == false) goto L20;
        return;
    L20:
        double r2 = r1;
        this.mCurrentItem = r11;
        this.mAccessibilityProvider.onSetNewCurrentItem();
        if (this.mScrollEventAdapter.isIdle() == true) goto L23;
        r2 = this.mScrollEventAdapter.getRelativeScrollPosition();
    L23:
        this.mScrollEventAdapter.notifyProgrammaticScroll(r11, r10);
        if (r10 == true) goto L27;
        this.mRecyclerView.scrollToPosition(r11);
        return;
    L27:
        double r3 = r11;
        if (Math.abs(r3 - r2) <= 3.0d) goto L34;
        RecyclerView r12 = this.mRecyclerView;
        if (r3 <= r2) goto L32;
        int r4 = r11 - 3;
    L33:
        r12.scrollToPosition(r4);
        this.mRecyclerView.post(new SmoothScrollToPosition(r11, this.mRecyclerView));
        return;
    L32:
        r4 = r11 + 3;
        goto L33
    L34:
        this.mRecyclerView.smoothScrollToPosition(r11);
        return;
    L14:
        if (this.mScrollEventAdapter.isIdle() == false) goto L16;
    }

    public int getCurrentItem() {
        return this.mCurrentItem;
    }

    public int getScrollState() {
        return this.mScrollEventAdapter.getScrollState();
    }

    public boolean beginFakeDrag() {
        return this.mFakeDragger.beginFakeDrag();
    }

    public boolean fakeDragBy(float r1) {
        return this.mFakeDragger.fakeDragBy(r1);
    }

    public boolean endFakeDrag() {
        return this.mFakeDragger.endFakeDrag();
    }

    public boolean isFakeDragging() {
        return this.mFakeDragger.isFakeDragging();
    }

    void snapToPage() {
        View r0 = this.mPagerSnapHelper.findSnapView(this.mLayoutManager);
        if (r0 != null) goto L5;
        return;
    L5:
        int[] r1 = this.mPagerSnapHelper.calculateDistanceToFinalSnap(this.mLayoutManager, r0);
        int r2 = r1[0];
        if (r2 == 0) goto L8;
    L9:
        this.mRecyclerView.smoothScrollBy(r2, r1[1]);
        return;
    L8:
        if (r1[1] != 0) goto L9;
    }

    public void setUserInputEnabled(boolean r1) {
        this.mUserInputEnabled = r1;
        this.mAccessibilityProvider.onSetUserInputEnabled();
    }

    public boolean isUserInputEnabled() {
        return this.mUserInputEnabled;
    }

    public void setOffscreenPageLimit(int r2) {
        if (r2 < 1) goto L5;
    L9:
        this.mOffscreenPageLimit = r2;
        this.mRecyclerView.requestLayout();
        return;
    L5:
        if (r2 == (-1)) goto L9;
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r1) {
        return this.mRecyclerView.canScrollHorizontally(r1);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int r1) {
        return this.mRecyclerView.canScrollVertically(r1);
    }

    public void registerOnPageChangeCallback(OnPageChangeCallback r1) {
        this.mExternalPageChangeCallbacks.addOnPageChangeCallback(r1);
    }

    public void unregisterOnPageChangeCallback(OnPageChangeCallback r1) {
        this.mExternalPageChangeCallbacks.removeOnPageChangeCallback(r1);
    }

    public void setPageTransformer(PageTransformer r4) {
        if (r4 == null) goto L9;
        if (this.mSavedItemAnimatorPresent == true) goto L7;
        this.mSavedItemAnimator = this.mRecyclerView.getItemAnimator();
        this.mSavedItemAnimatorPresent = true;
    L7:
        this.mRecyclerView.setItemAnimator(null);
    L12:
        if (r4 != this.mPageTransformerAdapter.getPageTransformer()) goto L14;
        return;
    L14:
        this.mPageTransformerAdapter.setPageTransformer(r4);
        requestTransform();
        return;
    L9:
        if (this.mSavedItemAnimatorPresent == false) goto L12;
        this.mRecyclerView.setItemAnimator(this.mSavedItemAnimator);
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        goto L12
    }

    public void requestTransform() {
        if (this.mPageTransformerAdapter.getPageTransformer() != null) goto L5;
        return;
    L5:
        double r0 = this.mScrollEventAdapter.getRelativeScrollPosition();
        int r2 = (int) r0;
        float r1 = (float) (r0 - ((double) r2));
        this.mPageTransformerAdapter.onPageScrolled(r2, r1, Math.round(getPageSize() * r1));
    }

    @Override // android.view.View
    public void setLayoutDirection(int r1) {
        super.setLayoutDirection(r1);
        this.mAccessibilityProvider.onSetLayoutDirection();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        this.mAccessibilityProvider.onInitializeAccessibilityNodeInfo(r1);
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int r2, Bundle r3) {
        if (this.mAccessibilityProvider.handlesPerformAccessibilityAction(r2, r3) == false) goto L7;
        return this.mAccessibilityProvider.onPerformAccessibilityAction(r2, r3);
    L7:
        return super.performAccessibilityAction(r2, r3);
    }

    public void addItemDecoration(RecyclerView.ItemDecoration r1) {
        this.mRecyclerView.addItemDecoration(r1);
    }

    public void addItemDecoration(RecyclerView.ItemDecoration r1, int r2) {
        this.mRecyclerView.addItemDecoration(r1, r2);
    }

    public RecyclerView.ItemDecoration getItemDecorationAt(int r1) {
        return this.mRecyclerView.getItemDecorationAt(r1);
    }

    public int getItemDecorationCount() {
        return this.mRecyclerView.getItemDecorationCount();
    }

    public void invalidateItemDecorations() {
        this.mRecyclerView.invalidateItemDecorations();
    }

    public void removeItemDecorationAt(int r1) {
        this.mRecyclerView.removeItemDecorationAt(r1);
    }

    public void removeItemDecoration(RecyclerView.ItemDecoration r1) {
        this.mRecyclerView.removeItemDecoration(r1);
    }
}
