package androidx.recyclerview.widget;

import a.a;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R;
import com.bytedance.librarian.LibrarianImpl;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = false;
    static final boolean ALLOW_THREAD_GAP_WORK = false;
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = null;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = null;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION = false;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator = null;
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;

    @NonNull
    private EdgeEffectFactory mEdgeEffectFactory;
    boolean mEnableFastScroller;

    @VisibleForTesting
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private OnItemTouchListener mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<ItemDecoration> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;

    @VisibleForTesting
    LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;

    @VisibleForTesting
    final List<ViewHolder> mPendingAccessibilityImportanceChange;
    private SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final Recycler mRecycler;
    RecyclerListener mRecyclerListener;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final State mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final ViewFlinger mViewFlinger;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;

    public static abstract class Adapter<VH extends ViewHolder> {
        private boolean mHasStableIds;
        private final AdapterDataObservable mObservable;

        public Adapter() {
            this.mObservable = new AdapterDataObservable();
            this.mHasStableIds = false;
        }

        public final void bindViewHolder(@NonNull VH r3, int r4) {
            r3.mPosition = r4;
            if (hasStableIds() == false) goto L5;
            r3.mItemId = getItemId(r4);
        L5:
            r3.setFlags(1, 519);
            TraceCompat.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(r3, r4, r3.getUnmodifiedPayloads());
            r3.clearPayload();
            ViewGroup.LayoutParams r2 = r3.itemView.getLayoutParams();
            if ((r2 instanceof LayoutParams) == false) goto L8;
            ((LayoutParams) r2).mInsetsDirty = true;
        L8:
            TraceCompat.endSection();
        }

        @NonNull
        public final VH createViewHolder(@NonNull ViewGroup r2, int r3) {
            TraceCompat.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);     // Catch: Throwable -> L7
            VH r1 = (VH) onCreateViewHolder(r2, r3);
            if (r1.itemView.getParent() != null) goto L10;
            r1.mItemViewType = r3;     // Catch: Throwable -> L7
            TraceCompat.endSection();
            return r1;
        L10:
            throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            TraceCompat.endSection();
            throw th;
        }

        public abstract int getItemCount();

        public long getItemId(int r1) {
            return -1;
        }

        public int getItemViewType(int r1) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.mObservable.hasObservers();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public final void notifyItemChanged(int r2) {
            this.mObservable.notifyItemRangeChanged(r2, 1);
        }

        public final void notifyItemInserted(int r2) {
            this.mObservable.notifyItemRangeInserted(r2, 1);
        }

        public final void notifyItemMoved(int r1, int r2) {
            this.mObservable.notifyItemMoved(r1, r2);
        }

        public final void notifyItemRangeChanged(int r1, int r2) {
            this.mObservable.notifyItemRangeChanged(r1, r2);
        }

        public final void notifyItemRangeInserted(int r1, int r2) {
            this.mObservable.notifyItemRangeInserted(r1, r2);
        }

        public final void notifyItemRangeRemoved(int r1, int r2) {
            this.mObservable.notifyItemRangeRemoved(r1, r2);
        }

        public final void notifyItemRemoved(int r2) {
            this.mObservable.notifyItemRangeRemoved(r2, 1);
        }

        public void onAttachedToRecyclerView(@NonNull RecyclerView r1) {
        }

        public abstract void onBindViewHolder(@NonNull VH r1, int r2);

        public void onBindViewHolder(@NonNull VH r1, int r2, @NonNull List<Object> r3) {
            onBindViewHolder(r1, r2);
        }

        @NonNull
        public abstract VH onCreateViewHolder(@NonNull ViewGroup r1, int r2);

        public void onDetachedFromRecyclerView(@NonNull RecyclerView r1) {
        }

        public boolean onFailedToRecycleView(@NonNull VH r1) {
            return false;
        }

        public void onViewAttachedToWindow(@NonNull VH r1) {
        }

        public void onViewDetachedFromWindow(@NonNull VH r1) {
        }

        public void onViewRecycled(@NonNull VH r1) {
        }

        public void registerAdapterDataObserver(@NonNull AdapterDataObserver r1) {
            this.mObservable.registerObserver(r1);
        }

        public void setHasStableIds(boolean r2) {
            if (hasObservers() == true) goto L7;
            this.mHasStableIds = r2;
            return;
        L7:
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void unregisterAdapterDataObserver(@NonNull AdapterDataObserver r1) {
            this.mObservable.unregisterObserver(r1);
        }

        public final void notifyItemChanged(int r2, @Nullable Object r3) {
            this.mObservable.notifyItemRangeChanged(r2, 1, r3);
        }

        public final void notifyItemRangeChanged(int r1, int r2, @Nullable Object r3) {
            this.mObservable.notifyItemRangeChanged(r1, r2, r3);
        }
    }

    public static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        public AdapterDataObservable() {
        }

        public boolean hasObservers() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void notifyChanged() {
            int r0 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r0)).onChanged();
            r0 = r0 - 1;
            goto L3
        }

        public void notifyItemMoved(int r4, int r5) {
            int r0 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r0)).onItemRangeMoved(r4, r5, 1);
            r0 = r0 - 1;
            goto L3
        }

        public void notifyItemRangeChanged(int r2, int r3) {
            notifyItemRangeChanged(r2, r3, null);
        }

        public void notifyItemRangeInserted(int r3, int r4) {
            int r0 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r0)).onItemRangeInserted(r3, r4);
            r0 = r0 - 1;
            goto L3
        }

        public void notifyItemRangeRemoved(int r3, int r4) {
            int r0 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r0)).onItemRangeRemoved(r3, r4);
            r0 = r0 - 1;
            goto L3
        }

        public void notifyItemRangeChanged(int r3, int r4, @Nullable Object r5) {
            int r0 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r0)).onItemRangeChanged(r3, r4, r5);
            r0 = r0 - 1;
            goto L3
        }
    }

    public static abstract class AdapterDataObserver {
        public AdapterDataObserver() {
        }

        public void onChanged() {
        }

        public void onItemRangeChanged(int r1, int r2) {
        }

        public void onItemRangeInserted(int r1, int r2) {
        }

        public void onItemRangeMoved(int r1, int r2, int r3) {
        }

        public void onItemRangeRemoved(int r1, int r2) {
        }

        public void onItemRangeChanged(int r1, int r2, @Nullable Object r3) {
            onItemRangeChanged(r1, r2);
        }
    }

    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int r1, int r2);
    }

    public static class EdgeEffectFactory {
        public static final int DIRECTION_BOTTOM = 3;
        public static final int DIRECTION_LEFT = 0;
        public static final int DIRECTION_RIGHT = 2;
        public static final int DIRECTION_TOP = 1;

        @Retention(RetentionPolicy.SOURCE)
        public @interface EdgeDirection {
        }

        public EdgeEffectFactory() {
        }

        @NonNull
        public EdgeEffect createEdgeEffect(@NonNull RecyclerView r1, int r2) {
            return new EdgeEffect(r1.getContext());
        }
    }

    public static abstract class ItemAnimator {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        private long mAddDuration;
        private long mChangeDuration;
        private ArrayList<ItemAnimatorFinishedListener> mFinishedListeners;
        private ItemAnimatorListener mListener;
        private long mMoveDuration;
        private long mRemoveDuration;

        @Retention(RetentionPolicy.SOURCE)
        public @interface AdapterChanges {
        }

        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        public interface ItemAnimatorListener {
            void onAnimationFinished(@NonNull ViewHolder r1);
        }

        public static class ItemHolderInfo {
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            public ItemHolderInfo() {
            }

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder r2) {
                return setFrom(r2, 0);
            }

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder r1, int r2) {
                View r3 = r1.itemView;
                this.left = r3.getLeft();
                this.top = r3.getTop();
                this.right = r3.getRight();
                this.bottom = r3.getBottom();
                return this;
            }
        }

        public ItemAnimator() {
            this.mListener = null;
            this.mFinishedListeners = new ArrayList();
            this.mAddDuration = 120;
            this.mRemoveDuration = 120;
            this.mMoveDuration = 250;
            this.mChangeDuration = 250;
        }

        public static int buildAdapterChangeFlagsForAnimations(ViewHolder r4) {
            int r0 = r4.mFlags;
            int r1 = r0 & 14;
            if (r4.isInvalid() == false) goto L6;
            return 4;
        L6:
            if ((r0 & 4) != 0) goto L13;
            int r2 = r4.getOldPosition();
            int r5 = r4.getAdapterPosition();
            if (r2 == (-1)) goto L14;
            if (r5 == (-1)) goto L15;
            if (r2 != r5) goto L12;
            return r1;
        L12:
            return r1 | 2048;
        L15:
            return r1;
        L14:
            return r1;
        L13:
            return r1;
        }

        public abstract boolean animateAppearance(@NonNull ViewHolder r1, @Nullable ItemHolderInfo r2, @NonNull ItemHolderInfo r3);

        public abstract boolean animateChange(@NonNull ViewHolder r1, @NonNull ViewHolder r2, @NonNull ItemHolderInfo r3, @NonNull ItemHolderInfo r4);

        public abstract boolean animateDisappearance(@NonNull ViewHolder r1, @NonNull ItemHolderInfo r2, @Nullable ItemHolderInfo r3);

        public abstract boolean animatePersistence(@NonNull ViewHolder r1, @NonNull ItemHolderInfo r2, @NonNull ItemHolderInfo r3);

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder r1) {
            return true;
        }

        public final void dispatchAnimationFinished(@NonNull ViewHolder r1) {
            onAnimationFinished(r1);
            ItemAnimatorListener r0 = this.mListener;
            if (r0 == null) goto L6;
            r0.onAnimationFinished(r1);
            return;
        }

        public final void dispatchAnimationStarted(@NonNull ViewHolder r1) {
            onAnimationStarted(r1);
        }

        public final void dispatchAnimationsFinished() {
            int r0 = this.mFinishedListeners.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            this.mFinishedListeners.get(r1).onAnimationsFinished();
            r1 = r1 + 1;
            goto L3
        L5:
            this.mFinishedListeners.clear();
        }

        public abstract void endAnimation(@NonNull ViewHolder r1);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(@Nullable ItemAnimatorFinishedListener r2) {
            boolean r0 = isRunning();
            if (r2 == null) goto L7;
            if (r0 == true) goto L6;
            r2.onAnimationsFinished();
            goto L7
        L6:
            this.mFinishedListeners.add(r2);
        L7:
            return r0;
        }

        @NonNull
        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }

        public void onAnimationFinished(@NonNull ViewHolder r1) {
        }

        public void onAnimationStarted(@NonNull ViewHolder r1) {
        }

        @NonNull
        public ItemHolderInfo recordPostLayoutInformation(@NonNull State r1, @NonNull ViewHolder r2) {
            return obtainHolderInfo().setFrom(r2);
        }

        @NonNull
        public ItemHolderInfo recordPreLayoutInformation(@NonNull State r1, @NonNull ViewHolder r2, int r3, @NonNull List<Object> r4) {
            return obtainHolderInfo().setFrom(r2);
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long r1) {
            this.mAddDuration = r1;
        }

        public void setChangeDuration(long r1) {
            this.mChangeDuration = r1;
        }

        public void setListener(ItemAnimatorListener r1) {
            this.mListener = r1;
        }

        public void setMoveDuration(long r1) {
            this.mMoveDuration = r1;
        }

        public void setRemoveDuration(long r1) {
            this.mRemoveDuration = r1;
        }

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder r1, @NonNull List<Object> r2) {
            return canReuseUpdatedViewHolder(r1);
        }
    }

    public class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        final /* synthetic */ RecyclerView this$0;

        public ItemAnimatorRestoreListener(RecyclerView r1) {
            this.this$0 = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
        public void onAnimationFinished(ViewHolder r3) {
            r3.setIsRecyclable(true);
            if (r3.mShadowedHolder != null) goto L5;
        L7:
            r3.mShadowingHolder = null;
            if (r3.shouldBeKeptAsChild() == false) goto L10;
            return;
        L10:
            if (this.this$0.removeAnimatingView(r3.itemView) == false) goto L12;
            return;
        L12:
            if (r3.isTmpDetached() == false) goto L17;
            this.this$0.removeDetachedView(r3.itemView, false);
            return;
        L17:
            return;
        L5:
            if (r3.mShadowingHolder != null) goto L7;
            r3.mShadowedHolder = null;
            goto L7
        }
    }

    public static abstract class ItemDecoration {
        public ItemDecoration() {
        }

        @Deprecated
        public void getItemOffsets(@NonNull Rect r1, int r2, @NonNull RecyclerView r3) {
            r1.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(@NonNull Canvas r1, @NonNull RecyclerView r2) {
        }

        @Deprecated
        public void onDrawOver(@NonNull Canvas r1, @NonNull RecyclerView r2) {
        }

        public void getItemOffsets(@NonNull Rect r1, @NonNull View r2, @NonNull RecyclerView r3, @NonNull State r4) {
            getItemOffsets(r1, ((LayoutParams) r2.getLayoutParams()).getViewLayoutPosition(), r3);
        }

        public void onDraw(@NonNull Canvas r1, @NonNull RecyclerView r2, @NonNull State r3) {
            onDraw(r1, r2);
        }

        public void onDrawOver(@NonNull Canvas r1, @NonNull RecyclerView r2, @NonNull State r3) {
            onDrawOver(r1, r2);
        }
    }

    public static abstract class LayoutManager {
        boolean mAutoMeasure;
        ChildHelper mChildHelper;
        private int mHeight;
        private int mHeightMode;
        ViewBoundsCheck mHorizontalBoundCheck;
        private final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback;
        boolean mIsAttachedToWindow;
        private boolean mItemPrefetchEnabled;
        private boolean mMeasurementCacheEnabled;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations;

        @Nullable
        SmoothScroller mSmoothScroller;
        ViewBoundsCheck mVerticalBoundCheck;
        private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        public interface LayoutPrefetchRegistry {
            void addPosition(int r1, int r2);
        }

        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;

            public Properties() {
            }
        }

        public LayoutManager() {
            ViewBoundsCheck.Callback r0 = new AnonymousClass1(this);
            this.mHorizontalBoundCheckCallback = r0;
            ViewBoundsCheck.Callback r1 = new AnonymousClass2(this);
            this.mVerticalBoundCheckCallback = r1;
            this.mHorizontalBoundCheck = new ViewBoundsCheck(r0);
            this.mVerticalBoundCheck = new ViewBoundsCheck(r1);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        private void addViewInt(View r5, int r6, boolean r7) {
            ViewHolder r0 = RecyclerView.getChildViewHolderInt(r5);
            if (r7 == false) goto L5;
        L8:
            this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(r0);
        L9:
            LayoutParams r8 = (LayoutParams) r5.getLayoutParams();
            if (r0.wasReturnedFromScrap() == true) goto L30;
            if (r0.isScrap() == true) goto L30;
            if (r5.getParent() != this.mRecyclerView) goto L24;
            int r1 = this.mChildHelper.indexOfChild(r5);
            if (r6 != (-1)) goto L19;
            r6 = this.mChildHelper.getChildCount();
        L19:
            if (r1 == (-1)) goto L22;
            if (r1 == r6) goto L35;
            this.mRecyclerView.mLayout.moveView(r1, r6);
        L35:
            if (r8.mPendingInvalidate == false) goto L38;
            r0.itemView.invalidate();
            r8.mPendingInvalidate = false;
            return;
        L38:
            return;
        L22:
            StringBuilder r9 = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
            r9.append(this.mRecyclerView.indexOfChild(r5));
            throw new IllegalStateException(a.g(this.mRecyclerView, r9));
        L24:
            this.mChildHelper.addView(r5, r6, false);
            r8.mInsetsDirty = true;
            SmoothScroller r10 = this.mSmoothScroller;
            if (r10 == null) goto L35;
            if (r10.isRunning() == false) goto L35;
            this.mSmoothScroller.onChildAttachedToWindow(r5);
        L30:
            if (r0.isScrap() == false) goto L32;
            r0.unScrap();
        L33:
            this.mChildHelper.attachViewToParent(r5, r6, r5.getLayoutParams(), false);
            goto L35
        L32:
            r0.clearReturnedFromScrapFlag();
            goto L33
        L5:
            if (r0.isRemoved() == true) goto L8;
            this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(r0);
            goto L9
        }

        public static int chooseSize(int r2, int r3, int r4) {
            int r0 = View.MeasureSpec.getMode(r2);
            int r5 = View.MeasureSpec.getSize(r2);
            if (r0 == Integer.MIN_VALUE) goto L9;
            if (r0 != 1073741824) goto L7;
            return r5;
        L7:
            return Math.max(r3, r4);
        L9:
            return Math.min(r5, Math.max(r3, r4));
        }

        private void detachViewInternal(int r1, @NonNull View r2) {
            this.mChildHelper.detachViewFromParent(r1);
        }

        @Deprecated
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            int r5 = r1 - r2;
            int r6 = 0;
            int r7 = Math.max(0, r5);
            if (r4 == false) goto L7;
            if (r3 < 0) goto L6;
        L5:
            r6 = 1073741824;
        L16:
            return View.MeasureSpec.makeMeasureSpec(r3, r6);
        L6:
            r3 = 0;
            goto L16
        L7:
            if (r3 >= 0) goto L5;
            if (r3 != (-1)) goto L13;
            r3 = r7;
            goto L5
        L13:
            if (r3 != (-2)) goto L6;
            r6 = Integer.MIN_VALUE;
            r3 = r7;
            goto L16
        }

        private int[] getChildRectangleOnScreenScrollAmount(View r8, Rect r9) {
            int r0 = getPaddingLeft();
            int r1 = getPaddingTop();
            int r2 = getWidth() - getPaddingRight();
            int r3 = getHeight() - getPaddingBottom();
            int r4 = (r8.getLeft() + r9.left) - r8.getScrollX();
            int r5 = (r8.getTop() + r9.top) - r8.getScrollY();
            int r10 = r9.width() + r4;
            int r11 = r9.height() + r5;
            int r6 = r4 - r0;
            int r7 = Math.min(0, r6);
            int r12 = r5 - r1;
            int r13 = Math.min(0, r12);
            int r14 = r10 - r2;
            int r15 = Math.max(0, r14);
            int r16 = Math.max(0, r11 - r3);
            if (getLayoutDirection() != 1) goto L7;
            if (r15 != 0) goto L11;
            r15 = Math.max(r7, r14);
        L11:
            if (r13 != 0) goto L15;
            r13 = Math.min(r12, r16);
        L15:
            return new int[]{r15, r13};
        L7:
            if (r7 != 0) goto L10;
            r7 = Math.min(r6, r15);
        L10:
            r15 = r7;
            goto L11
        }

        public static Properties getProperties(@NonNull Context r2, @Nullable AttributeSet r3, int r4, int r5) {
            Properties r0 = new Properties();
            TypedArray r6 = r2.obtainStyledAttributes(r3, R.styleable.RecyclerView, r4, r5);
            r0.orientation = r6.getInt(R.styleable.RecyclerView_android_orientation, 1);
            r0.spanCount = r6.getInt(R.styleable.RecyclerView_spanCount, 1);
            r0.reverseLayout = r6.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
            r0.stackFromEnd = r6.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
            r6.recycle();
            return r0;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView r7, int r8, int r9) {
            View r10 = r7.getFocusedChild();
            if (r10 != null) goto L5;
            return false;
        L5:
            int r1 = getPaddingLeft();
            int r2 = getPaddingTop();
            int r3 = getWidth() - getPaddingRight();
            int r4 = getHeight() - getPaddingBottom();
            Rect r5 = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(r10, r5);
            if ((r5.left - r8) < r3) goto L8;
        L16:
            return false;
        L8:
            if ((r5.right - r8) <= r1) goto L16;
            if ((r5.top - r9) >= r4) goto L16;
            if ((r5.bottom - r9) <= r2) goto L16;
            return true;
        }

        private static boolean isMeasurementUpToDate(int r3, int r4, int r5) {
            int r0 = View.MeasureSpec.getMode(r4);
            int r6 = View.MeasureSpec.getSize(r4);
            if (r5 <= 0) goto L7;
            if (r3 == r5) goto L7;
            return false;
        L7:
            if (r0 == Integer.MIN_VALUE) goto L16;
            if (r0 != 0) goto L10;
            return true;
        L10:
            if (r0 == 1073741824) goto L12;
            return false;
        L12:
            if (r6 == r3) goto L14;
            return false;
        L14:
            return true;
        L16:
            if (r6 >= r3) goto L18;
            return false;
        L18:
            return true;
        }

        private void scrapOrRecycleView(Recycler r3, int r4, View r5) {
            ViewHolder r0 = RecyclerView.getChildViewHolderInt(r5);
            if (r0.shouldIgnore() == false) goto L6;
            return;
        L6:
            if (r0.isInvalid() == true) goto L8;
        L12:
            detachViewAt(r4);
            r3.scrapView(r5);
            this.mRecyclerView.mViewInfoStore.onViewDetached(r0);
            return;
        L8:
            if (r0.isRemoved() == true) goto L12;
            if (this.mRecyclerView.mAdapter.hasStableIds() == true) goto L12;
            removeViewAt(r4);
            r3.recycleViewHolderInternal(r0);
        }

        public void addDisappearingView(View r2) {
            addDisappearingView(r2, -1);
        }

        public void addView(View r2) {
            addView(r2, -1);
        }

        public void assertInLayoutOrScroll(String r1) {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 == null) goto L6;
            r0.assertInLayoutOrScroll(r1);
            return;
        }

        public void assertNotInLayoutOrScroll(String r1) {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 == null) goto L6;
            r0.assertNotInLayoutOrScroll(r1);
            return;
        }

        public void attachView(@NonNull View r3, int r4, LayoutParams r5) {
            ViewHolder r0 = RecyclerView.getChildViewHolderInt(r3);
            if (r0.isRemoved() == false) goto L5;
            this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(r0);
        L6:
            this.mChildHelper.attachViewToParent(r3, r4, r5, r0.isRemoved());
            return;
        L5:
            this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(r0);
            goto L6
        }

        public void calculateItemDecorationsForChild(@NonNull View r1, @NonNull Rect r2) {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L6;
            r2.set(0, 0, 0, 0);
            return;
        L6:
            r2.set(r0.getItemDecorInsetsForChild(r1));
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams r1) {
            if (r1 == null) goto L4;
            return true;
        L4:
            return false;
        }

        public void collectAdjacentPrefetchPositions(int r1, int r2, State r3, LayoutPrefetchRegistry r4) {
        }

        public void collectInitialPrefetchPositions(int r1, LayoutPrefetchRegistry r2) {
        }

        public int computeHorizontalScrollExtent(@NonNull State r1) {
            return 0;
        }

        public int computeHorizontalScrollOffset(@NonNull State r1) {
            return 0;
        }

        public int computeHorizontalScrollRange(@NonNull State r1) {
            return 0;
        }

        public int computeVerticalScrollExtent(@NonNull State r1) {
            return 0;
        }

        public int computeVerticalScrollOffset(@NonNull State r1) {
            return 0;
        }

        public int computeVerticalScrollRange(@NonNull State r1) {
            return 0;
        }

        public void detachAndScrapAttachedViews(@NonNull Recycler r3) {
            int r0 = getChildCount() - 1;
        L3:
            if (r0 < 0) goto L5;
            scrapOrRecycleView(r3, r0, getChildAt(r0));
            r0 = r0 - 1;
            goto L3
        }

        public void detachAndScrapView(@NonNull View r2, @NonNull Recycler r3) {
            scrapOrRecycleView(r3, this.mChildHelper.indexOfChild(r2), r2);
        }

        public void detachAndScrapViewAt(int r2, @NonNull Recycler r3) {
            scrapOrRecycleView(r3, r2, getChildAt(r2));
        }

        public void detachView(@NonNull View r2) {
            int r0 = this.mChildHelper.indexOfChild(r2);
            if (r0 < 0) goto L6;
            detachViewInternal(r0, r2);
            return;
        }

        public void detachViewAt(int r2) {
            detachViewInternal(r2, getChildAt(r2));
        }

        public void dispatchAttachedToWindow(RecyclerView r2) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(r2);
        }

        public void dispatchDetachedFromWindow(RecyclerView r2, Recycler r3) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(r2, r3);
        }

        public void endAnimation(View r1) {
            ItemAnimator r0 = this.mRecyclerView.mItemAnimator;
            if (r0 == null) goto L6;
            r0.endAnimation(RecyclerView.getChildViewHolderInt(r1));
            return;
        }

        @Nullable
        public View findContainingItemView(@NonNull View r3) {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L5;
            return null;
        L5:
            View r4 = r0.findContainingItemView(r3);
            if (r4 != null) goto L9;
            return null;
        L9:
            if (this.mChildHelper.isHidden(r4) == false) goto L11;
            return null;
        L11:
            return r4;
        }

        @Nullable
        public View findViewByPosition(int r6) {
            int r0 = getChildCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L17;
            View r2 = getChildAt(r1);
            ViewHolder r3 = RecyclerView.getChildViewHolderInt(r2);
            if (r3 == null) goto L16;
            if (r3.getLayoutPosition() != r6) goto L16;
            if (r3.shouldIgnore() == true) goto L16;
            if (this.mRecyclerView.mState.isPreLayout() == true) goto L15;
            if (r3.isRemoved() == true) goto L16;
        L15:
            return r2;
        L16:
            r1 = r1 + 1;
            goto L3
        L17:
            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
            if ((r1 instanceof LayoutParams) == false) goto L7;
            return new LayoutParams((LayoutParams) r1);
        L7:
            if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
            return new LayoutParams((ViewGroup.MarginLayoutParams) r1);
        L11:
            return new LayoutParams(r1);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(@NonNull View r1) {
            return ((LayoutParams) r1.getLayoutParams()).mDecorInsets.bottom;
        }

        @Nullable
        public View getChildAt(int r1) {
            ChildHelper r0 = this.mChildHelper;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getChildAt(r1);
        }

        public int getChildCount() {
            ChildHelper r0 = this.mChildHelper;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getChildCount();
        }

        public boolean getClipToPadding() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.mClipToPadding == false) goto L7;
            return true;
        }

        public int getColumnCountForAccessibility(@NonNull Recycler r1, @NonNull State r2) {
            RecyclerView r3 = this.mRecyclerView;
            if (r3 != null) goto L5;
            return 1;
        L5:
            if (r3.mAdapter != null) goto L8;
            return 1;
        L8:
            if (canScrollHorizontally() == true) goto L10;
            return 1;
        L10:
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getDecoratedBottom(@NonNull View r2) {
            int r0 = r2.getBottom();
            return getBottomDecorationHeight(r2) + r0;
        }

        public void getDecoratedBoundsWithMargins(@NonNull View r1, @NonNull Rect r2) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(r1, r2);
        }

        public int getDecoratedLeft(@NonNull View r2) {
            return r2.getLeft() - getLeftDecorationWidth(r2);
        }

        public int getDecoratedMeasuredHeight(@NonNull View r2) {
            Rect r1 = ((LayoutParams) r2.getLayoutParams()).mDecorInsets;
            return (r2.getMeasuredHeight() + r1.top) + r1.bottom;
        }

        public int getDecoratedMeasuredWidth(@NonNull View r2) {
            Rect r1 = ((LayoutParams) r2.getLayoutParams()).mDecorInsets;
            return (r2.getMeasuredWidth() + r1.left) + r1.right;
        }

        public int getDecoratedRight(@NonNull View r2) {
            int r0 = r2.getRight();
            return getRightDecorationWidth(r2) + r0;
        }

        public int getDecoratedTop(@NonNull View r2) {
            return r2.getTop() - getTopDecorationHeight(r2);
        }

        @Nullable
        public View getFocusedChild() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L5;
            return null;
        L5:
            View r1 = r0.getFocusedChild();
            if (r1 != null) goto L8;
        L11:
            return null;
        L8:
            if (this.mChildHelper.isHidden(r1) == true) goto L11;
            return r1;
        }

        @Px
        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 == null) goto L5;
            Adapter r1 = r0.getAdapter();
        L6:
            if (r1 != null) goto L10;
            return 0;
        L10:
            return r1.getItemCount();
        L5:
            r1 = null;
            goto L6
        }

        public int getItemViewType(@NonNull View r1) {
            return RecyclerView.getChildViewHolderInt(r1).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(@NonNull View r1) {
            return ((LayoutParams) r1.getLayoutParams()).mDecorInsets.left;
        }

        @Px
        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.mRecyclerView);
        }

        @Px
        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.mRecyclerView);
        }

        @Px
        public int getPaddingBottom() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getPaddingBottom();
        }

        @Px
        public int getPaddingEnd() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return ViewCompat.getPaddingEnd(r0);
        }

        @Px
        public int getPaddingLeft() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getPaddingLeft();
        }

        @Px
        public int getPaddingRight() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getPaddingRight();
        }

        @Px
        public int getPaddingStart() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return ViewCompat.getPaddingStart(r0);
        }

        @Px
        public int getPaddingTop() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getPaddingTop();
        }

        public int getPosition(@NonNull View r1) {
            return ((LayoutParams) r1.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(@NonNull View r1) {
            return ((LayoutParams) r1.getLayoutParams()).mDecorInsets.right;
        }

        public int getRowCountForAccessibility(@NonNull Recycler r1, @NonNull State r2) {
            RecyclerView r3 = this.mRecyclerView;
            if (r3 != null) goto L5;
            return 1;
        L5:
            if (r3.mAdapter != null) goto L8;
            return 1;
        L8:
            if (canScrollVertically() == true) goto L10;
            return 1;
        L10:
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getSelectionModeForAccessibility(@NonNull Recycler r1, @NonNull State r2) {
            return 0;
        }

        public int getTopDecorationHeight(@NonNull View r1) {
            return ((LayoutParams) r1.getLayoutParams()).mDecorInsets.top;
        }

        public void getTransformedBoundingBox(@NonNull View r5, boolean r6, @NonNull Rect r7) {
            if (r6 == false) goto L4;
            Rect r8 = ((LayoutParams) r5.getLayoutParams()).mDecorInsets;
            r7.set(-r8.left, -r8.top, r5.getWidth() + r8.right, r5.getHeight() + r8.bottom);
        L6:
            if (this.mRecyclerView == null) goto L12;
            Matrix r9 = r5.getMatrix();
            if (r9 == null) goto L12;
            if (r9.isIdentity() == true) goto L12;
            RectF r4 = this.mRecyclerView.mTempRectF;
            r4.set(r7);
            r9.mapRect(r4);
            r7.set((int) Math.floor(r4.left), (int) Math.floor(r4.top), (int) Math.ceil(r4.right), (int) Math.ceil(r4.bottom));
        L12:
            r7.offset(r5.getLeft(), r5.getTop());
            return;
        L4:
            r7.set(0, 0, r5.getWidth(), r5.getHeight());
            goto L6
        }

        @Px
        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public boolean hasFlexibleChildInBothOrientations() {
            int r0 = getChildCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            ViewGroup.LayoutParams r3 = getChildAt(r2).getLayoutParams();
            if (r3.width >= 0) goto L10;
            if (r3.height >= 0) goto L10;
            return true;
        L10:
            r2 = r2 + 1;
            goto L3
        L11:
            return false;
        }

        public boolean hasFocus() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.hasFocus() == false) goto L7;
            return true;
        }

        public void ignoreView(@NonNull View r3) {
            ViewParent r0 = r3.getParent();
            RecyclerView r1 = this.mRecyclerView;
            if (r0 == r1) goto L5;
        L8:
            StringBuilder r2 = new StringBuilder("View should be fully attached to be ignored");
            throw new IllegalArgumentException(a.g(this.mRecyclerView, r2));
        L5:
            if (r1.indexOfChild(r3) == (-1)) goto L8;
            ViewHolder r4 = RecyclerView.getChildViewHolderInt(r3);
            r4.addFlags(128);
            this.mRecyclerView.mViewInfoStore.removeViewHolder(r4);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.isFocused() == false) goto L7;
            return true;
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(@NonNull Recycler r1, @NonNull State r2) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller r0 = this.mSmoothScroller;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.isRunning() == false) goto L7;
            return true;
        }

        public boolean isViewPartiallyVisible(@NonNull View r3, boolean r4, boolean r5) {
            if (this.mHorizontalBoundCheck.isViewWithinBoundFlags(r3, 24579) == true) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r4 == false) goto L11;
            return r2;
        L11:
            return !r2;
        L5:
            if (this.mVerticalBoundCheck.isViewWithinBoundFlags(r3, 24579) == false) goto L7;
            r2 = true;
            goto L8
        }

        public void layoutDecorated(@NonNull View r2, int r3, int r4, int r5, int r6) {
            Rect r1 = ((LayoutParams) r2.getLayoutParams()).mDecorInsets;
            r2.layout(r3 + r1.left, r4 + r1.top, r5 - r1.right, r6 - r1.bottom);
        }

        public void layoutDecoratedWithMargins(@NonNull View r3, int r4, int r5, int r6, int r7) {
            LayoutParams r2 = (LayoutParams) r3.getLayoutParams();
            Rect r0 = r2.mDecorInsets;
            r3.layout((r4 + r0.left) + ((ViewGroup.MarginLayoutParams) r2).leftMargin, (r5 + r0.top) + ((ViewGroup.MarginLayoutParams) r2).topMargin, (r6 - r0.right) - ((ViewGroup.MarginLayoutParams) r2).rightMargin, (r7 - r0.bottom) - ((ViewGroup.MarginLayoutParams) r2).bottomMargin);
        }

        public void measureChild(@NonNull View r6, int r7, int r8) {
            LayoutParams r0 = (LayoutParams) r6.getLayoutParams();
            Rect r1 = this.mRecyclerView.getItemDecorInsetsForChild(r6);
            int r2 = (r1.left + r1.right) + r7;
            int r9 = (r1.top + r1.bottom) + r8;
            int r10 = getWidth();
            int r3 = getWidthMode();
            int r4 = getPaddingLeft();
            int r11 = getChildMeasureSpec(r10, r3, (getPaddingRight() + r4) + r2, ((ViewGroup.MarginLayoutParams) r0).width, canScrollHorizontally());
            int r5 = getHeight();
            int r12 = getHeightMode();
            int r13 = getPaddingTop();
            int r14 = getChildMeasureSpec(r5, r12, (getPaddingBottom() + r13) + r9, ((ViewGroup.MarginLayoutParams) r0).height, canScrollVertically());
            if (shouldMeasureChild(r6, r11, r14, r0) == false) goto L6;
            r6.measure(r11, r14);
            return;
        }

        public void measureChildWithMargins(@NonNull View r6, int r7, int r8) {
            LayoutParams r0 = (LayoutParams) r6.getLayoutParams();
            Rect r1 = this.mRecyclerView.getItemDecorInsetsForChild(r6);
            int r2 = (r1.left + r1.right) + r7;
            int r9 = (r1.top + r1.bottom) + r8;
            int r10 = getWidth();
            int r3 = getWidthMode();
            int r4 = getPaddingLeft();
            int r11 = getChildMeasureSpec(r10, r3, (((getPaddingRight() + r4) + ((ViewGroup.MarginLayoutParams) r0).leftMargin) + ((ViewGroup.MarginLayoutParams) r0).rightMargin) + r2, ((ViewGroup.MarginLayoutParams) r0).width, canScrollHorizontally());
            int r5 = getHeight();
            int r12 = getHeightMode();
            int r13 = getPaddingTop();
            int r14 = getChildMeasureSpec(r5, r12, (((getPaddingBottom() + r13) + ((ViewGroup.MarginLayoutParams) r0).topMargin) + ((ViewGroup.MarginLayoutParams) r0).bottomMargin) + r9, ((ViewGroup.MarginLayoutParams) r0).height, canScrollVertically());
            if (shouldMeasureChild(r6, r11, r14, r0) == false) goto L6;
            r6.measure(r11, r14);
            return;
        }

        public void moveView(int r3, int r4) {
            View r0 = getChildAt(r3);
            if (r0 == null) goto L7;
            detachViewAt(r3);
            attachView(r0, r4);
            return;
        L7:
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + r3 + this.mRecyclerView.toString());
        }

        public void offsetChildrenHorizontal(@Px int r1) {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 == null) goto L6;
            r0.offsetChildrenHorizontal(r1);
            return;
        }

        public void offsetChildrenVertical(@Px int r1) {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 == null) goto L6;
            r0.offsetChildrenVertical(r1);
            return;
        }

        public void onAdapterChanged(@Nullable Adapter r1, @Nullable Adapter r2) {
        }

        public boolean onAddFocusables(@NonNull RecyclerView r1, @NonNull ArrayList<View> r2, int r3, int r4) {
            return false;
        }

        @CallSuper
        public void onAttachedToWindow(RecyclerView r1) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView r1) {
        }

        @Nullable
        public View onFocusSearchFailed(@NonNull View r1, int r2, @NonNull Recycler r3, @NonNull State r4) {
            return null;
        }

        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r3) {
            RecyclerView r0 = this.mRecyclerView;
            onInitializeAccessibilityEvent(r0.mRecycler, r0.mState, r3);
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat r3) {
            RecyclerView r0 = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(r0.mRecycler, r0.mState, r3);
        }

        public void onInitializeAccessibilityNodeInfoForItem(View r3, AccessibilityNodeInfoCompat r4) {
            ViewHolder r0 = RecyclerView.getChildViewHolderInt(r3);
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isRemoved() == false) goto L7;
            return;
        L7:
            if (this.mChildHelper.isHidden(r0.itemView) == true) goto L12;
            RecyclerView r1 = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(r1.mRecycler, r1.mState, r3, r4);
            return;
        }

        @Nullable
        public View onInterceptFocusSearch(@NonNull View r1, int r2) {
            return null;
        }

        public void onItemsAdded(@NonNull RecyclerView r1, int r2, int r3) {
        }

        public void onItemsChanged(@NonNull RecyclerView r1) {
        }

        public void onItemsMoved(@NonNull RecyclerView r1, int r2, int r3, int r4) {
        }

        public void onItemsRemoved(@NonNull RecyclerView r1, int r2, int r3) {
        }

        public void onItemsUpdated(@NonNull RecyclerView r1, int r2, int r3) {
        }

        public void onLayoutChildren(Recycler r1, State r2) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onLayoutCompleted(State r1) {
        }

        public void onMeasure(@NonNull Recycler r1, @NonNull State r2, int r3, int r4) {
            this.mRecyclerView.defaultOnMeasure(r3, r4);
        }

        @Deprecated
        public boolean onRequestChildFocus(@NonNull RecyclerView r1, @NonNull View r2, @Nullable View r3) {
            if (isSmoothScrolling() == false) goto L5;
        L8:
            return true;
        L5:
            if (r1.isComputingLayout() == true) goto L8;
            return false;
        }

        public void onRestoreInstanceState(Parcelable r1) {
        }

        @Nullable
        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int r1) {
        }

        public void onSmoothScrollerStopped(SmoothScroller r2) {
            if (this.mSmoothScroller != r2) goto L6;
            this.mSmoothScroller = null;
            return;
        }

        public boolean performAccessibilityAction(int r3, @Nullable Bundle r4) {
            RecyclerView r0 = this.mRecyclerView;
            return performAccessibilityAction(r0.mRecycler, r0.mState, r3, r4);
        }

        public boolean performAccessibilityActionForItem(@NonNull Recycler r1, @NonNull State r2, @NonNull View r3, int r4, @Nullable Bundle r5) {
            return false;
        }

        public void postOnAnimation(Runnable r1) {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 == null) goto L6;
            ViewCompat.postOnAnimation(r0, r1);
            return;
        }

        public void removeAllViews() {
            int r0 = getChildCount() - 1;
        L3:
            if (r0 < 0) goto L5;
            this.mChildHelper.removeViewAt(r0);
            r0 = r0 - 1;
            goto L3
        }

        public void removeAndRecycleAllViews(@NonNull Recycler r3) {
            int r0 = getChildCount() - 1;
        L3:
            if (r0 < 0) goto L8;
            if (RecyclerView.getChildViewHolderInt(getChildAt(r0)).shouldIgnore() == true) goto L7;
            removeAndRecycleViewAt(r0, r3);
        L7:
            r0 = r0 - 1;
            goto L3
        }

        public void removeAndRecycleScrapInt(Recycler r7) {
            int r0 = r7.getScrapCount();
            int r1 = r0 - 1;
        L3:
            if (r1 < 0) goto L15;
            View r2 = r7.getScrapViewAt(r1);
            ViewHolder r3 = RecyclerView.getChildViewHolderInt(r2);
            if (r3.shouldIgnore() == true) goto L14;
            r3.setIsRecyclable(false);
            if (r3.isTmpDetached() == false) goto L10;
            this.mRecyclerView.removeDetachedView(r2, false);
        L10:
            ItemAnimator r4 = this.mRecyclerView.mItemAnimator;
            if (r4 == null) goto L13;
            r4.endAnimation(r3);
        L13:
            r3.setIsRecyclable(true);
            r7.quickRecycleScrapView(r2);
        L14:
            r1 = r1 - 1;
            goto L3
        L15:
            r7.clearScrap();
            if (r0 <= 0) goto L22;
            this.mRecyclerView.invalidate();
            return;
        }

        public void removeAndRecycleView(@NonNull View r1, @NonNull Recycler r2) {
            removeView(r1);
            r2.recycleView(r1);
        }

        public void removeAndRecycleViewAt(int r2, @NonNull Recycler r3) {
            View r0 = getChildAt(r2);
            removeViewAt(r2);
            r3.recycleView(r0);
        }

        public boolean removeCallbacks(Runnable r1) {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L5;
            return false;
        L5:
            return r0.removeCallbacks(r1);
        }

        public void removeDetachedView(@NonNull View r2) {
            this.mRecyclerView.removeDetachedView(r2, false);
        }

        public void removeView(View r1) {
            this.mChildHelper.removeView(r1);
        }

        public void removeViewAt(int r2) {
            if (getChildAt(r2) == null) goto L6;
            this.mChildHelper.removeViewAt(r2);
            return;
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView r7, @NonNull View r8, @NonNull Rect r9, boolean r10) {
            return requestChildRectangleOnScreen(r7, r8, r9, r10, false);
        }

        public void requestLayout() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 == null) goto L6;
            r0.requestLayout();
            return;
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int r1, Recycler r2, State r3) {
            return 0;
        }

        public void scrollToPosition(int r1) {
        }

        public int scrollVerticallyBy(int r1, Recycler r2, State r3) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean r1) {
            this.mAutoMeasure = r1;
        }

        public void setExactMeasureSpecsFrom(RecyclerView r3) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(r3.getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r3.getHeight(), BasicMeasure.EXACTLY));
        }

        public final void setItemPrefetchEnabled(boolean r2) {
            if (r2 == this.mItemPrefetchEnabled) goto L8;
            this.mItemPrefetchEnabled = r2;
            this.mPrefetchMaxCountObserved = 0;
            RecyclerView r1 = this.mRecyclerView;
            if (r1 == null) goto L9;
            r1.mRecycler.updateViewCacheSize();
            return;
        L9:
            return;
        }

        public void setMeasureSpecs(int r2, int r3) {
            this.mWidth = View.MeasureSpec.getSize(r2);
            int r4 = View.MeasureSpec.getMode(r2);
            this.mWidthMode = r4;
            if (r4 == 0) goto L5;
        L7:
            this.mHeight = View.MeasureSpec.getSize(r3);
            int r5 = View.MeasureSpec.getMode(r3);
            this.mHeightMode = r5;
            if (r5 == 0) goto L10;
            return;
        L10:
            if (RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC == true) goto L14;
            this.mHeight = 0;
            return;
        L14:
            return;
        L5:
            if (RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC == true) goto L7;
            this.mWidth = 0;
            goto L7
        }

        public void setMeasuredDimension(Rect r3, int r4, int r5) {
            int r0 = r3.width();
            int r1 = getPaddingLeft() + r0;
            int r2 = getPaddingRight() + r1;
            int r6 = r3.height();
            int r7 = getPaddingTop() + r6;
            int r8 = getPaddingBottom() + r7;
            setMeasuredDimension(chooseSize(r4, r2, getMinimumWidth()), chooseSize(r5, r8, getMinimumHeight()));
        }

        public void setMeasuredDimensionFromChildren(int r9, int r10) {
            int r0 = getChildCount();
            if (r0 != 0) goto L6;
            this.mRecyclerView.defaultOnMeasure(r9, r10);
            return;
        L6:
            int r1 = Integer.MIN_VALUE;
            int r4 = Integer.MAX_VALUE;
            int r5 = 0;
            int r2 = Integer.MIN_VALUE;
            int r3 = Integer.MAX_VALUE;
        L7:
            if (r5 >= r0) goto L21;
            View r6 = getChildAt(r5);
            Rect r7 = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(r6, r7);
            int r8 = r7.left;
            if (r8 >= r3) goto L11;
            r3 = r8;
        L11:
            int r11 = r7.right;
            if (r11 <= r1) goto L14;
            r1 = r11;
        L14:
            int r12 = r7.top;
            if (r12 >= r4) goto L17;
            r4 = r12;
        L17:
            int r13 = r7.bottom;
            if (r13 <= r2) goto L20;
            r2 = r13;
        L20:
            r5 = r5 + 1;
            goto L7
        L21:
            this.mRecyclerView.mTempRect.set(r3, r4, r1, r2);
            setMeasuredDimension(this.mRecyclerView.mTempRect, r9, r10);
        }

        public void setMeasurementCacheEnabled(boolean r1) {
            this.mMeasurementCacheEnabled = r1;
        }

        public void setRecyclerView(RecyclerView r2) {
            if (r2 != null) goto L4;
            this.mRecyclerView = null;
            this.mChildHelper = null;
            this.mWidth = 0;
            this.mHeight = 0;
        L5:
            this.mWidthMode = BasicMeasure.EXACTLY;
            this.mHeightMode = BasicMeasure.EXACTLY;
            return;
        L4:
            this.mRecyclerView = r2;
            this.mChildHelper = r2.mChildHelper;
            this.mWidth = r2.getWidth();
            this.mHeight = r2.getHeight();
            goto L5
        }

        public boolean shouldMeasureChild(View r2, int r3, int r4, LayoutParams r5) {
            if (r2.isLayoutRequested() == false) goto L5;
        L12:
            return true;
        L5:
            if (this.mMeasurementCacheEnabled == false) goto L12;
            if (isMeasurementUpToDate(r2.getWidth(), r3, ((ViewGroup.MarginLayoutParams) r5).width) == false) goto L12;
            if (isMeasurementUpToDate(r2.getHeight(), r4, ((ViewGroup.MarginLayoutParams) r5).height) == false) goto L12;
            return false;
        }

        public boolean shouldMeasureTwice() {
            return false;
        }

        public boolean shouldReMeasureChild(View r2, int r3, int r4, LayoutParams r5) {
            if (this.mMeasurementCacheEnabled == true) goto L5;
        L10:
            return true;
        L5:
            if (isMeasurementUpToDate(r2.getMeasuredWidth(), r3, ((ViewGroup.MarginLayoutParams) r5).width) == false) goto L10;
            if (isMeasurementUpToDate(r2.getMeasuredHeight(), r4, ((ViewGroup.MarginLayoutParams) r5).height) == false) goto L10;
            return false;
        }

        public void smoothScrollToPosition(RecyclerView r1, State r2, int r3) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(SmoothScroller r2) {
            SmoothScroller r0 = this.mSmoothScroller;
            if (r0 == null) goto L8;
            if (r2 == r0) goto L8;
            if (r0.isRunning() == false) goto L8;
            this.mSmoothScroller.stop();
        L8:
            this.mSmoothScroller = r2;
            r2.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(@NonNull View r1) {
            ViewHolder r0 = RecyclerView.getChildViewHolderInt(r1);
            r0.stopIgnoring();
            r0.resetInternal();
            r0.addFlags(4);
        }

        public void stopSmoothScroller() {
            SmoothScroller r0 = this.mSmoothScroller;
            if (r0 == null) goto L6;
            r0.stop();
            return;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public void addDisappearingView(View r2, int r3) {
            addViewInt(r2, r3, true);
        }

        public void addView(View r2, int r3) {
            addViewInt(r2, r3, false);
        }

        @CallSuper
        public void onDetachedFromWindow(RecyclerView r1, Recycler r2) {
            onDetachedFromWindow(r1);
        }

        public void onInitializeAccessibilityEvent(@NonNull Recycler r2, @NonNull State r3, @NonNull AccessibilityEvent r4) {
            RecyclerView r5 = this.mRecyclerView;
            if (r5 == null) goto L20;
            if (r4 == null) goto L22;
            boolean r6 = true;
            if (r5.canScrollVertically(1) == false) goto L9;
        L16:
            r4.setScrollable(r6);
            Adapter r1 = this.mRecyclerView.mAdapter;
            if (r1 == null) goto L21;
            r4.setItemCount(r1.getItemCount());
            return;
        L21:
            return;
        L9:
            if (this.mRecyclerView.canScrollVertically(-1) == true) goto L16;
            if (this.mRecyclerView.canScrollHorizontally(-1) == true) goto L16;
            if (this.mRecyclerView.canScrollHorizontally(1) == true) goto L16;
            r6 = false;
            goto L16
        L22:
            return;
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull Recycler r4, @NonNull State r5, @NonNull AccessibilityNodeInfoCompat r6) {
            if (this.mRecyclerView.canScrollVertically(-1) == false) goto L5;
        L6:
            r6.addAction(8192);
            r6.setScrollable(true);
        L8:
            if (this.mRecyclerView.canScrollVertically(1) == false) goto L10;
        L11:
            r6.addAction(4096);
            r6.setScrollable(true);
        L12:
            r6.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(r4, r5), getColumnCountForAccessibility(r4, r5), isLayoutHierarchical(r4, r5), getSelectionModeForAccessibility(r4, r5)));
            return;
        L10:
            if (this.mRecyclerView.canScrollHorizontally(1) == false) goto L12;
        L5:
            if (this.mRecyclerView.canScrollHorizontally(-1) == false) goto L8;
            goto L6
        }

        public void onItemsUpdated(@NonNull RecyclerView r1, int r2, int r3, @Nullable Object r4) {
            onItemsUpdated(r1, r2, r3);
        }

        public boolean onRequestChildFocus(@NonNull RecyclerView r1, @NonNull State r2, @NonNull View r3, @Nullable View r4) {
            return onRequestChildFocus(r1, r3, r4);
        }

        public boolean performAccessibilityAction(@NonNull Recycler r8, @NonNull State r9, int r10, @Nullable Bundle r11) {
            RecyclerView r12 = this.mRecyclerView;
            if (r12 != null) goto L6;
            return false;
        L6:
            if (r10 == 4096) goto L20;
            if (r10 == 8192) goto L11;
            int r2 = 0;
            int r3 = 0;
        L26:
            if (r3 != 0) goto L29;
            if (r2 != 0) goto L29;
            return false;
        L29:
            this.mRecyclerView.smoothScrollBy(r2, r3, null, Integer.MIN_VALUE, true);
            return true;
        L11:
            if (r12.canScrollVertically(-1) == false) goto L13;
            int r13 = -((getHeight() - getPaddingTop()) - getPaddingBottom());
        L15:
            if (this.mRecyclerView.canScrollHorizontally(-1) == false) goto L18;
            int r14 = -((getWidth() - getPaddingLeft()) - getPaddingRight());
        L17:
            r3 = r13;
            r2 = r14;
        L18:
            r3 = r13;
            r2 = 0;
            goto L26
        L13:
            r13 = 0;
            goto L15
        L20:
            if (r12.canScrollVertically(1) == false) goto L22;
            r13 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        L24:
            if (this.mRecyclerView.canScrollHorizontally(1) == false) goto L18;
            r14 = (getWidth() - getPaddingLeft()) - getPaddingRight();
            goto L17
        L22:
            r13 = 0;
            goto L24
        }

        public boolean performAccessibilityActionForItem(@NonNull View r8, int r9, @Nullable Bundle r10) {
            RecyclerView r0 = this.mRecyclerView;
            return performAccessibilityActionForItem(r0.mRecycler, r0.mState, r8, r9, r10);
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView r3, @NonNull View r4, @NonNull Rect r5, boolean r6, boolean r7) {
            int[] r8 = getChildRectangleOnScreenScrollAmount(r4, r5);
            int r0 = r8[0];
            int r9 = r8[1];
            if (r7 == true) goto L5;
        L6:
            if (r0 != 0) goto L10;
            if (r9 != 0) goto L10;
        L9:
            return false;
        L10:
            if (r6 == false) goto L12;
            r3.scrollBy(r0, r9);
        L13:
            return true;
        L12:
            r3.smoothScrollBy(r0, r9);
            goto L13
        L5:
            if (isFocusedChildVisibleAfterScrolling(r3, r0, r9) == false) goto L9;
            goto L6
        }

        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            int r9 = Math.max(0, r4 - r6);
            if (r8 == false) goto L11;
            if (r7 < 0) goto L6;
        L5:
            r5 = 1073741824;
        L22:
            return View.MeasureSpec.makeMeasureSpec(r7, r5);
        L6:
            if (r7 != (-1)) goto L10;
            if (r5 == Integer.MIN_VALUE) goto L14;
            if (r5 == 0) goto L10;
            if (r5 != 1073741824) goto L10;
        L14:
            r7 = r9;
        L10:
            r5 = 0;
            r7 = 0;
            goto L22
        L11:
            if (r7 >= 0) goto L5;
            if (r7 == (-1)) goto L14;
            if (r7 != (-2)) goto L10;
            if (r5 == Integer.MIN_VALUE) goto L20;
            if (r5 == 1073741824) goto L20;
            r7 = r9;
            r5 = 0;
        L20:
            r7 = r9;
            r5 = Integer.MIN_VALUE;
            goto L22
        }

        public void onInitializeAccessibilityNodeInfoForItem(@NonNull Recycler r7, @NonNull State r8, @NonNull View r9, @NonNull AccessibilityNodeInfoCompat r10) {
            int r11 = 0;
            if (canScrollVertically() == false) goto L5;
            int r0 = getPosition(r9);
        L7:
            if (canScrollHorizontally() == false) goto L9;
            r11 = getPosition(r9);
        L9:
            r10.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r0, 1, r11, 1, false, false));
            return;
        L5:
            r0 = 0;
            goto L7
        }

        public void attachView(@NonNull View r2, int r3) {
            attachView(r2, r3, (LayoutParams) r2.getLayoutParams());
        }

        public LayoutParams generateLayoutParams(Context r1, AttributeSet r2) {
            return new LayoutParams(r1, r2);
        }

        public void setMeasuredDimension(int r1, int r2) {
            RecyclerView.access$300(this.mRecyclerView, r1, r2);
        }

        public void attachView(@NonNull View r2) {
            attachView(r2, -1);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        final Rect mDecorInsets;
        boolean mInsetsDirty;
        boolean mPendingInvalidate;
        ViewHolder mViewHolder;

        public LayoutParams(Context r1, AttributeSet r2) {
            super(r1, r2);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public int getViewAdapterPosition() {
            return this.mViewHolder.getAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

        @Deprecated
        public int getViewPosition() {
            return this.mViewHolder.getPosition();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.isUpdated();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.isInvalid();
        }

        public boolean viewNeedsUpdate() {
            return this.mViewHolder.needsUpdate();
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(LayoutParams r1) {
            super(r1);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }
    }

    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(@NonNull View r1);

        void onChildViewDetachedFromWindow(@NonNull View r1);
    }

    public static abstract class OnFlingListener {
        public OnFlingListener() {
        }

        public abstract boolean onFling(int r1, int r2);
    }

    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(@NonNull RecyclerView r1, @NonNull MotionEvent r2);

        void onRequestDisallowInterceptTouchEvent(boolean r1);

        void onTouchEvent(@NonNull RecyclerView r1, @NonNull MotionEvent r2);
    }

    public static abstract class OnScrollListener {
        public OnScrollListener() {
        }

        public void onScrollStateChanged(@NonNull RecyclerView r1, int r2) {
        }

        public void onScrolled(@NonNull RecyclerView r1, int r2, int r3) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Orientation {
    }

    public static class RecycledViewPool {
        private static final int DEFAULT_MAX_SCRAP = 5;
        private int mAttachCount;
        SparseArray<ScrapData> mScrap;

        public static class ScrapData {
            long mBindRunningAverageNs;
            long mCreateRunningAverageNs;
            int mMaxScrap;
            final ArrayList<ViewHolder> mScrapHeap;

            public ScrapData() {
                this.mScrapHeap = new ArrayList();
                this.mMaxScrap = 5;
                this.mCreateRunningAverageNs = 0;
                this.mBindRunningAverageNs = 0;
            }
        }

        public RecycledViewPool() {
            this.mScrap = new SparseArray();
            this.mAttachCount = 0;
        }

        private ScrapData getScrapDataForType(int r2) {
            ScrapData r0 = this.mScrap.get(r2);
            if (r0 != null) goto L6;
            ScrapData r1 = new ScrapData();
            this.mScrap.put(r2, r1);
            return r1;
        L6:
            return r0;
        }

        public void attach() {
            this.mAttachCount++;
        }

        public void clear() {
            int r0 = 0;
        L4:
            if (r0 >= this.mScrap.size()) goto L6;
            this.mScrap.valueAt(r0).mScrapHeap.clear();
            r0 = r0 + 1;
            goto L4
        }

        public void detach() {
            this.mAttachCount--;
        }

        public void factorInBindTime(int r3, long r4) {
            ScrapData r5 = getScrapDataForType(r3);
            r5.mBindRunningAverageNs = runningAverage(r5.mBindRunningAverageNs, r4);
        }

        public void factorInCreateTime(int r3, long r4) {
            ScrapData r5 = getScrapDataForType(r3);
            r5.mCreateRunningAverageNs = runningAverage(r5.mCreateRunningAverageNs, r4);
        }

        @Nullable
        public ViewHolder getRecycledView(int r2) {
            ScrapData r1 = this.mScrap.get(r2);
            if (r1 != null) goto L5;
            return null;
        L5:
            if (r1.mScrapHeap.isEmpty() == true) goto L17;
            ArrayList<ViewHolder> r3 = r1.mScrapHeap;
            int r4 = r3.size() - 1;
        L7:
            if (r4 < 0) goto L18;
            if (r3.get(r4).isAttachedToTransitionOverlay() == false) goto L11;
            r4 = r4 - 1;
            goto L7
        L11:
            return r3.remove(r4);
        L18:
            return null;
        L17:
            return null;
        }

        public int getRecycledViewCount(int r1) {
            return getScrapDataForType(r1).mScrapHeap.size();
        }

        public void onAdapterChanged(Adapter r1, Adapter r2, boolean r3) {
            if (r1 == null) goto L4;
            detach();
        L4:
            if (r3 == false) goto L6;
        L8:
            if (r2 == null) goto L11;
            attach();
            return;
        L11:
            return;
        L6:
            if (this.mAttachCount != 0) goto L8;
            clear();
            goto L8
        }

        public void putRecycledView(ViewHolder r3) {
            int r0 = r3.getItemViewType();
            ArrayList<ViewHolder> r1 = getScrapDataForType(r0).mScrapHeap;
            if (this.mScrap.get(r0).mMaxScrap > r1.size()) goto L5;
            return;
        L5:
            r3.resetInternal();
            r1.add(r3);
        }

        public long runningAverage(long r5, long r7) {
            if (r5 != 0) goto L5;
            return r7;
        L5:
            long r8 = r7 / 4;
            return r8 + ((r5 / 4) * 3);
        }

        public void setMaxRecycledViews(int r1, int r2) {
            ScrapData r0 = getScrapDataForType(r1);
            r0.mMaxScrap = r2;
            ArrayList<ViewHolder> r3 = r0.mScrapHeap;
        L4:
            if (r3.size() <= r2) goto L6;
            r3.remove(r3.size() - 1);
            goto L4
        }

        public int size() {
            int r0 = 0;
            int r1 = 0;
        L4:
            if (r0 >= this.mScrap.size()) goto L9;
            ArrayList<ViewHolder> r2 = this.mScrap.valueAt(r0).mScrapHeap;
            if (r2 == null) goto L8;
            r1 = r2.size() + r1;
        L8:
            r0 = r0 + 1;
            goto L4
        L9:
            return r1;
        }

        public boolean willBindInTime(int r3, long r4, long r6) {
            long r2 = getScrapDataForType(r3).mBindRunningAverageNs;
            if (r2 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r4 + r2) < r6) goto L8;
            return false;
        }

        public boolean willCreateInTime(int r3, long r4, long r6) {
            long r2 = getScrapDataForType(r3).mCreateRunningAverageNs;
            if (r2 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r4 + r2) < r6) goto L8;
            return false;
        }
    }

    public final class Recycler {
        static final int DEFAULT_CACHE_SIZE = 2;
        final ArrayList<ViewHolder> mAttachedScrap;
        final ArrayList<ViewHolder> mCachedViews;
        ArrayList<ViewHolder> mChangedScrap;
        RecycledViewPool mRecyclerPool;
        private int mRequestedCacheMax;
        private final List<ViewHolder> mUnmodifiableAttachedScrap;
        private ViewCacheExtension mViewCacheExtension;
        int mViewCacheMax;
        final /* synthetic */ RecyclerView this$0;

        public Recycler(RecyclerView r2) {
            this.this$0 = r2;
            ArrayList<ViewHolder> r3 = new ArrayList();
            this.mAttachedScrap = r3;
            this.mChangedScrap = null;
            this.mCachedViews = new ArrayList();
            this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(r3);
            this.mRequestedCacheMax = 2;
            this.mViewCacheMax = 2;
        }

        private void attachAccessibilityDelegateOnBind(ViewHolder r2) {
            if (this.this$0.isAccessibilityEnabled() == false) goto L15;
            View r3 = r2.itemView;
            if (ViewCompat.getImportantForAccessibility(r3) != 0) goto L7;
            ViewCompat.setImportantForAccessibility(r3, 1);
        L7:
            RecyclerViewAccessibilityDelegate r1 = this.this$0.mAccessibilityDelegate;
            if (r1 != null) goto L10;
            return;
        L10:
            AccessibilityDelegateCompat r4 = r1.getItemDelegate();
            if ((r4 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) == false) goto L13;
            ((RecyclerViewAccessibilityDelegate.ItemDelegate) r4).saveOriginalDelegate(r3);
        L13:
            ViewCompat.setAccessibilityDelegate(r3, r4);
            return;
        }

        private void invalidateDisplayListInt(ViewHolder r2) {
            View r3 = r2.itemView;
            if ((r3 instanceof ViewGroup) == false) goto L6;
            invalidateDisplayListInt((ViewGroup) r3, false);
            return;
        }

        private boolean tryBindViewHolderByDeadline(@NonNull ViewHolder r10, int r11, int r12, long r13) {
            r10.mOwnerRecyclerView = this.this$0;
            int r2 = r10.getItemViewType();
            long r7 = this.this$0.getNanoTime();
            if (r13 != RecyclerView.FOREVER_NS) goto L5;
        L8:
            this.this$0.mAdapter.bindViewHolder(r10, r11);
            long r14 = this.this$0.getNanoTime();
            this.mRecyclerPool.factorInBindTime(r10.getItemViewType(), r14 - r7);
            attachAccessibilityDelegateOnBind(r10);
            if (this.this$0.mState.isPreLayout() == false) goto L13;
            r10.mPreLayoutPosition = r12;
            return true;
        L13:
            return true;
        L5:
            if (this.mRecyclerPool.willBindInTime(r2, r7, r13) == true) goto L8;
            return false;
        }

        public void addViewHolderToRecycledViewPool(@NonNull ViewHolder r5, boolean r6) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(r5);
            View r0 = r5.itemView;
            RecyclerViewAccessibilityDelegate r1 = this.this$0.mAccessibilityDelegate;
            if (r1 == null) goto L9;
            AccessibilityDelegateCompat r2 = r1.getItemDelegate();
            if ((r2 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) == false) goto L7;
            AccessibilityDelegateCompat r3 = ((RecyclerViewAccessibilityDelegate.ItemDelegate) r2).getAndRemoveOriginalDelegateForItem(r0);
        L8:
            ViewCompat.setAccessibilityDelegate(r0, r3);
            goto L9
        L7:
            r3 = null;
        L9:
            if (r6 == false) goto L11;
            dispatchViewRecycled(r5);
        L11:
            r5.mOwnerRecyclerView = null;
            getRecycledViewPool().putRecycledView(r5);
        }

        public void bindViewToPosition(@NonNull View r7, int r8) {
            ViewHolder r9 = RecyclerView.getChildViewHolderInt(r7);
            if (r9 == null) goto L23;
            int r2 = this.this$0.mAdapterHelper.findPositionOffset(r8);
            if (r2 >= 0) goto L7;
        L21:
            StringBuilder r10 = a.r("Inconsistency detected. Invalid item position ", r8, "(offset:", r2, ").state:");
            r10.append(this.this$0.mState.getItemCount());
            throw new IndexOutOfBoundsException(a.g(this.this$0, r10));
        L7:
            if (r2 >= this.this$0.mAdapter.getItemCount()) goto L21;
            tryBindViewHolderByDeadline(r9, r2, r8, RecyclerView.FOREVER_NS);
            ViewGroup.LayoutParams r11 = r9.itemView.getLayoutParams();
            if (r11 != null) goto L12;
            LayoutParams r6 = (LayoutParams) this.this$0.generateDefaultLayoutParams();
            r9.itemView.setLayoutParams(r6);
        L15:
            boolean r12 = true;
            r6.mInsetsDirty = true;
            r6.mViewHolder = r9;
            if (r9.itemView.getParent() == null) goto L19;
            r12 = false;
        L19:
            r6.mPendingInvalidate = r12;
            return;
        L12:
            if (this.this$0.checkLayoutParams(r11) == true) goto L14;
            r6 = (LayoutParams) this.this$0.generateLayoutParams(r11);
            r9.itemView.setLayoutParams(r6);
            goto L15
        L14:
            r6 = (LayoutParams) r11;
            goto L15
        L23:
            StringBuilder r13 = new StringBuilder("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
            throw new IllegalArgumentException(a.g(this.this$0, r13));
        }

        public void clear() {
            this.mAttachedScrap.clear();
            recycleAndClearCachedViews();
        }

        public void clearOldPositions() {
            int r0 = this.mCachedViews.size();
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            this.mCachedViews.get(r2).clearOldPosition();
            r2 = r2 + 1;
            goto L3
        L5:
            int r3 = this.mAttachedScrap.size();
            int r4 = 0;
        L6:
            if (r4 >= r3) goto L8;
            this.mAttachedScrap.get(r4).clearOldPosition();
            r4 = r4 + 1;
            goto L6
        L8:
            ArrayList<ViewHolder> r5 = this.mChangedScrap;
            if (r5 == null) goto L13;
            int r6 = r5.size();
        L11:
            if (r1 >= r6) goto L17;
            this.mChangedScrap.get(r1).clearOldPosition();
            r1 = r1 + 1;
            goto L11
        L17:
            return;
        }

        public void clearScrap() {
            this.mAttachedScrap.clear();
            ArrayList<ViewHolder> r1 = this.mChangedScrap;
            if (r1 == null) goto L6;
            r1.clear();
            return;
        }

        public int convertPreLayoutPositionToPostLayout(int r4) {
            if (r4 >= 0) goto L4;
        L10:
            StringBuilder r5 = a.p(r4, "invalid position ", ". State item count is ");
            r5.append(this.this$0.mState.getItemCount());
            throw new IndexOutOfBoundsException(a.g(this.this$0, r5));
        L4:
            if (r4 >= this.this$0.mState.getItemCount()) goto L10;
            if (this.this$0.mState.isPreLayout() == true) goto L9;
            return r4;
        L9:
            return this.this$0.mAdapterHelper.findPositionOffset(r4);
        }

        public void dispatchViewRecycled(@NonNull ViewHolder r2) {
            RecyclerListener r0 = this.this$0.mRecyclerListener;
            if (r0 == null) goto L5;
            r0.onViewRecycled(r2);
        L5:
            Adapter r1 = this.this$0.mAdapter;
            if (r1 == null) goto L8;
            r1.onViewRecycled(r2);
        L8:
            RecyclerView r3 = this.this$0;
            if (r3.mState == null) goto L12;
            r3.mViewInfoStore.removeViewHolder(r2);
            return;
        }

        public ViewHolder getChangedScrapViewForPosition(int r10) {
            ArrayList<ViewHolder> r0 = this.mChangedScrap;
            if (r0 == null) goto L32;
            int r1 = r0.size();
            if (r1 == 0) goto L32;
            int r2 = 0;
            int r3 = 0;
        L9:
            if (r3 >= r1) goto L18;
            ViewHolder r5 = this.mChangedScrap.get(r3);
            if (r5.wasReturnedFromScrap() == true) goto L16;
            if (r5.getLayoutPosition() != r10) goto L16;
            r5.addFlags(32);
            return r5;
        L16:
            r3 = r3 + 1;
            goto L9
        L18:
            if (this.this$0.mAdapter.hasStableIds() == false) goto L32;
            int r11 = this.this$0.mAdapterHelper.findPositionOffset(r10);
            if (r11 <= 0) goto L32;
            if (r11 >= this.this$0.mAdapter.getItemCount()) goto L32;
            long r6 = this.this$0.mAdapter.getItemId(r11);
        L24:
            if (r2 >= r1) goto L32;
            ViewHolder r12 = this.mChangedScrap.get(r2);
            if (r12.wasReturnedFromScrap() == true) goto L31;
            if (r12.getItemId() != r6) goto L31;
            r12.addFlags(32);
            return r12;
        L31:
            r2 = r2 + 1;
        L32:
            return null;
        }

        public RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool != null) goto L6;
            this.mRecyclerPool = new RecycledViewPool();
        L6:
            return this.mRecyclerPool;
        }

        public int getScrapCount() {
            return this.mAttachedScrap.size();
        }

        @NonNull
        public List<ViewHolder> getScrapList() {
            return this.mUnmodifiableAttachedScrap;
        }

        public ViewHolder getScrapOrCachedViewForId(long r6, int r8, boolean r9) {
            int r0 = this.mAttachedScrap.size() - 1;
        L3:
            if (r0 < 0) goto L19;
            ViewHolder r1 = this.mAttachedScrap.get(r0);
            if (r1.getItemId() != r6) goto L18;
            if (r1.wasReturnedFromScrap() == true) goto L18;
            if (r8 == r1.getItemViewType()) goto L10;
            if (r9 == true) goto L18;
            this.mAttachedScrap.remove(r0);
            this.this$0.removeDetachedView(r1.itemView, false);
            quickRecycleScrapView(r1.itemView);
            goto L18
        L10:
            r1.addFlags(32);
            if (r1.isRemoved() == true) goto L13;
        L15:
            return r1;
        L13:
            if (this.this$0.mState.isPreLayout() == true) goto L15;
            r1.setFlags(2, 14);
        L18:
            r0 = r0 - 1;
            goto L3
        L19:
            int r2 = this.mCachedViews.size();
        L20:
            r2 = r2 - 1;
            if (r2 < 0) goto L35;
            ViewHolder r3 = this.mCachedViews.get(r2);
            if (r3.getItemId() != r6) goto L20;
            if (r3.isAttachedToTransitionOverlay() == true) goto L20;
            if (r8 == r3.getItemViewType()) goto L28;
            if (r9 == true) goto L20;
            recycleCachedViewAt(r2);
            return null;
        L28:
            if (r9 == true) goto L30;
            this.mCachedViews.remove(r2);
        L30:
            return r3;
        L35:
            return null;
        }

        public ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int r6, boolean r7) {
            int r0 = this.mAttachedScrap.size();
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L17;
            ViewHolder r3 = this.mAttachedScrap.get(r2);
            if (r3.wasReturnedFromScrap() == true) goto L16;
            if (r3.getLayoutPosition() != r6) goto L16;
            if (r3.isInvalid() == true) goto L16;
            if (this.this$0.mState.mInPreLayout == true) goto L14;
            if (r3.isRemoved() == true) goto L16;
        L14:
            r3.addFlags(32);
            return r3;
        L16:
            r2 = r2 + 1;
            goto L3
        L17:
            if (r7 == true) goto L26;
            View r4 = this.this$0.mChildHelper.findHiddenNonRemovedView(r6);
            if (r4 == null) goto L26;
            ViewHolder r8 = RecyclerView.getChildViewHolderInt(r4);
            this.this$0.mChildHelper.unhide(r4);
            int r9 = this.this$0.mChildHelper.indexOfChild(r4);
            if (r9 == (-1)) goto L24;
            this.this$0.mChildHelper.detachViewFromParent(r9);
            scrapView(r4);
            r8.addFlags(8224);
            return r8;
        L24:
            StringBuilder r5 = new StringBuilder("layout index should not be -1 after unhiding a view:");
            r5.append(r8);
            throw new IllegalStateException(a.g(this.this$0, r5));
        L26:
            int r10 = this.mCachedViews.size();
        L27:
            if (r1 >= r10) goto L38;
            ViewHolder r11 = this.mCachedViews.get(r1);
            if (r11.isInvalid() == true) goto L37;
            if (r11.getLayoutPosition() != r6) goto L37;
            if (r11.isAttachedToTransitionOverlay() == true) goto L37;
            if (r7 == true) goto L36;
            this.mCachedViews.remove(r1);
        L36:
            return r11;
        L37:
            r1 = r1 + 1;
            goto L27
        L38:
            return null;
        }

        public View getScrapViewAt(int r1) {
            return this.mAttachedScrap.get(r1).itemView;
        }

        @NonNull
        public View getViewForPosition(int r2) {
            return getViewForPosition(r2, false);
        }

        public void markItemDecorInsetsDirty() {
            int r0 = this.mCachedViews.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            LayoutParams r2 = (LayoutParams) this.mCachedViews.get(r1).itemView.getLayoutParams();
            if (r2 == null) goto L7;
            r2.mInsetsDirty = true;
        L7:
            r1 = r1 + 1;
            goto L3
        }

        public void markKnownViewsInvalid() {
            int r0 = this.mCachedViews.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            ViewHolder r2 = this.mCachedViews.get(r1);
            if (r2 == null) goto L7;
            r2.addFlags(6);
            r2.addChangePayload(null);
        L7:
            r1 = r1 + 1;
            goto L3
        L8:
            Adapter r3 = this.this$0.mAdapter;
            if (r3 != null) goto L11;
        L12:
            recycleAndClearCachedViews();
            return;
        L11:
            if (r3.hasStableIds() == false) goto L12;
        }

        public void offsetPositionRecordsForInsert(int r5, int r6) {
            int r0 = this.mCachedViews.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L10;
            ViewHolder r2 = this.mCachedViews.get(r1);
            if (r2 == null) goto L9;
            if (r2.mPosition < r5) goto L9;
            r2.offsetPosition(r6, true);
        L9:
            r1 = r1 + 1;
            goto L3
        }

        public void offsetPositionRecordsForMove(int r9, int r10) {
            if (r9 >= r10) goto L4;
            int r0 = -1;
            int r1 = r9;
            int r2 = r10;
        L5:
            int r3 = this.mCachedViews.size();
            int r5 = 0;
        L6:
            if (r5 >= r3) goto L17;
            ViewHolder r6 = this.mCachedViews.get(r5);
            if (r6 == null) goto L16;
            int r7 = r6.mPosition;
            if (r7 < r1) goto L16;
            if (r7 > r2) goto L16;
            if (r7 != r9) goto L15;
            r6.offsetPosition(r10 - r9, false);
            goto L16
        L15:
            r6.offsetPosition(r0, false);
        L16:
            r5 = r5 + 1;
            goto L6
        L17:
            return;
        L4:
            r0 = 1;
            r2 = r9;
            r1 = r10;
            goto L5
        }

        public void offsetPositionRecordsForRemove(int r5, int r6, boolean r7) {
            int r0 = r5 + r6;
            int r1 = this.mCachedViews.size() - 1;
        L3:
            if (r1 < 0) goto L12;
            ViewHolder r2 = this.mCachedViews.get(r1);
            if (r2 == null) goto L11;
            int r3 = r2.mPosition;
            if (r3 < r0) goto L9;
            r2.offsetPosition(-r6, r7);
            goto L11
        L9:
            if (r3 < r5) goto L11;
            r2.addFlags(8);
            recycleCachedViewAt(r1);
        L11:
            r1 = r1 - 1;
            goto L3
        }

        public void onAdapterChanged(Adapter r1, Adapter r2, boolean r3) {
            clear();
            getRecycledViewPool().onAdapterChanged(r1, r2, r3);
        }

        public void quickRecycleScrapView(View r2) {
            ViewHolder r3 = RecyclerView.getChildViewHolderInt(r2);
            r3.mScrapContainer = null;
            r3.mInChangeScrap = false;
            r3.clearReturnedFromScrapFlag();
            recycleViewHolderInternal(r3);
        }

        public void recycleAndClearCachedViews() {
            int r0 = this.mCachedViews.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            recycleCachedViewAt(r0);
            r0 = r0 - 1;
            goto L3
        L5:
            this.mCachedViews.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L10;
            this.this$0.mPrefetchRegistry.clearPrefetchPositions();
            return;
        }

        public void recycleCachedViewAt(int r3) {
            addViewHolderToRecycledViewPool(this.mCachedViews.get(r3), true);
            this.mCachedViews.remove(r3);
        }

        public void recycleView(@NonNull View r4) {
            ViewHolder r0 = RecyclerView.getChildViewHolderInt(r4);
            if (r0.isTmpDetached() == false) goto L6;
            this.this$0.removeDetachedView(r4, false);
        L6:
            if (r0.isScrap() == false) goto L9;
            r0.unScrap();
        L11:
            recycleViewHolderInternal(r0);
            if (this.this$0.mItemAnimator != null) goto L14;
            return;
        L14:
            if (r0.isRecyclable() == true) goto L18;
            this.this$0.mItemAnimator.endAnimation(r0);
            return;
        L18:
            return;
        L9:
            if (r0.wasReturnedFromScrap() == false) goto L11;
            r0.clearReturnedFromScrapFlag();
            goto L11
        }

        public void recycleViewHolderInternal(ViewHolder r7) {
            boolean r1 = false;
            boolean r2 = true;
            if (r7.isScrap() == false) goto L5;
        L59:
            StringBuilder r3 = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
            r3.append(r7.isScrap());
            r3.append(" isAttached:");
            if (r7.itemView.getParent() == null) goto L62;
            r1 = true;
        L62:
            r3.append(r1);
            throw new IllegalArgumentException(a.g(this.this$0, r3));
        L5:
            if (r7.itemView.getParent() != null) goto L59;
            if (r7.isTmpDetached() == false) goto L10;
            StringBuilder r4 = new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
            r4.append(r7);
            throw new IllegalArgumentException(a.g(this.this$0, r4));
        L10:
            if (r7.shouldIgnore() == true) goto L56;
            boolean r0 = r7.doesTransientStatePreventRecycling();
            Adapter r5 = this.this$0.mAdapter;
            if (r5 == null) goto L17;
            if (r0 == false) goto L17;
            if (r5.onFailedToRecycleView(r7) == false) goto L17;
            boolean r6 = true;
        L18:
            if (r6 == true) goto L24;
            if (r7.isRecyclable() == true) goto L24;
            r2 = false;
        L49:
            this.this$0.mViewInfoStore.removeViewHolder(r7);
            if (r1 == true) goto L66;
            if (r2 == true) goto L67;
            if (r0 == false) goto L68;
            r7.mOwnerRecyclerView = null;
            return;
        L68:
            return;
        L67:
            return;
        L66:
            return;
        L24:
            if (this.mViewCacheMax > 0) goto L26;
        L44:
            boolean r8 = false;
        L45:
            if (r8 == true) goto L48;
            addViewHolderToRecycledViewPool(r7, true);
        L47:
            r1 = r8;
            goto L49
        L48:
            r2 = false;
            goto L47
        L26:
            if (r7.hasAnyOfTheFlags(526) == true) goto L44;
            int r9 = this.mCachedViews.size();
            if (r9 < this.mViewCacheMax) goto L32;
            if (r9 <= 0) goto L32;
            recycleCachedViewAt(0);
            r9 = r9 - 1;
        L32:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L43;
            if (r9 <= 0) goto L43;
            if (this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(r7.mPosition) == true) goto L43;
            int r10 = r9 - 1;
        L37:
            if (r10 < 0) goto L42;
            if (this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(this.mCachedViews.get(r10).mPosition) == false) goto L42;
            r10 = r10 - 1;
        L42:
            r9 = r10 + 1;
        L43:
            this.mCachedViews.add(r9, r7);
            r8 = true;
        L17:
            r6 = false;
            goto L18
        L56:
            throw new IllegalArgumentException(a.g(this.this$0, new StringBuilder("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
        }

        public void scrapView(View r3) {
            ViewHolder r4 = RecyclerView.getChildViewHolderInt(r3);
            if (r4.hasAnyOfTheFlags(12) == true) goto L14;
            if (r4.isUpdated() == false) goto L14;
            if (this.this$0.canReuseUpdatedViewHolder(r4) == true) goto L14;
            if (this.mChangedScrap != null) goto L12;
            this.mChangedScrap = new ArrayList();
        L12:
            r4.setScrapContainer(this, true);
            this.mChangedScrap.add(r4);
            return;
        L14:
            if (r4.isInvalid() == true) goto L16;
        L22:
            r4.setScrapContainer(this, false);
            this.mAttachedScrap.add(r4);
            return;
        L16:
            if (r4.isRemoved() == true) goto L22;
            if (this.this$0.mAdapter.hasStableIds() == true) goto L22;
            StringBuilder r0 = new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            throw new IllegalArgumentException(a.g(this.this$0, r0));
        }

        public void setRecycledViewPool(RecycledViewPool r2) {
            RecycledViewPool r0 = this.mRecyclerPool;
            if (r0 == null) goto L5;
            r0.detach();
        L5:
            this.mRecyclerPool = r2;
            if (r2 != null) goto L8;
            return;
        L8:
            if (this.this$0.getAdapter() == null) goto L12;
            this.mRecyclerPool.attach();
            return;
        }

        public void setViewCacheExtension(ViewCacheExtension r1) {
            this.mViewCacheExtension = r1;
        }

        public void setViewCacheSize(int r1) {
            this.mRequestedCacheMax = r1;
            updateViewCacheSize();
        }

        @Nullable
        public ViewHolder tryGetViewHolderForPositionByDeadline(int r17, boolean r18, long r19) {
            if (r17 >= 0) goto L5;
        L111:
            StringBuilder r1 = a.r("Invalid item position ", r17, "(", r17, "). Item count:");
            r1.append(this.this$0.mState.getItemCount());
            throw new IndexOutOfBoundsException(a.g(this.this$0, r1));
        L5:
            if (r17 >= this.this$0.mState.getItemCount()) goto L111;
            boolean r7 = true;
            if (this.this$0.mState.isPreLayout() == false) goto L11;
            ViewHolder r2 = getChangedScrapViewForPosition(r17);
            if (r2 == null) goto L12;
            boolean r4 = true;
        L13:
            if (r2 != null) goto L28;
            r2 = getScrapOrHiddenOrCachedHolderForPosition(r17, r18);
            if (r2 == null) goto L28;
            if (validateViewHolderForOffsetPosition(r2) == true) goto L27;
            if (r18 == true) goto L26;
            r2.addFlags(4);
            if (r2.isScrap() == false) goto L23;
            this.this$0.removeDetachedView(r2.itemView, false);
            r2.unScrap();
        L25:
            recycleViewHolderInternal(r2);
            goto L26
        L23:
            if (r2.wasReturnedFromScrap() == false) goto L25;
            r2.clearReturnedFromScrapFlag();
        L26:
            r2 = null;
            goto L28
        L27:
            r4 = true;
        L28:
            if (r2 != null) goto L72;
            int r5 = this.this$0.mAdapterHelper.findPositionOffset(r17);
            if (r5 >= 0) goto L32;
        L73:
            StringBuilder r3 = a.r("Inconsistency detected. Invalid item position ", r17, "(offset:", r5, ").state:");
            r3.append(this.this$0.mState.getItemCount());
            throw new IndexOutOfBoundsException(a.g(this.this$0, r3));
        L32:
            if (r5 >= this.this$0.mAdapter.getItemCount()) goto L73;
            int r9 = this.this$0.mAdapter.getItemViewType(r5);
            if (this.this$0.mAdapter.hasStableIds() == false) goto L38;
            r2 = getScrapOrCachedViewForId(this.this$0.mAdapter.getItemId(r5), r9, r18);
            if (r2 == null) goto L38;
            r2.mPosition = r5;
            r4 = true;
        L38:
            if (r2 != null) goto L52;
            ViewCacheExtension r0 = this.mViewCacheExtension;
            if (r0 == null) goto L52;
            View r6 = r0.getViewForPositionAndType(this, r17, r9);
            if (r6 == null) goto L52;
            r2 = this.this$0.getChildViewHolder(r6);
            if (r2 == null) goto L51;
            if (r2.shouldIgnore() == false) goto L52;
            throw new IllegalArgumentException(a.g(this.this$0, new StringBuilder("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.")));
        L51:
            throw new IllegalArgumentException(a.g(this.this$0, new StringBuilder("getViewForPositionAndType returned a view which does not have a ViewHolder")));
        L52:
            if (r2 != null) goto L59;
            ViewHolder r8 = getRecycledViewPool().getRecycledView(r9);
            if (r8 == null) goto L58;
            r8.resetInternal();
            if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST == false) goto L58;
            invalidateDisplayListInt(r8);
        L58:
            r2 = r8;
        L59:
            if (r2 != null) goto L72;
            long r10 = this.this$0.getNanoTime();
            if (r19 != RecyclerView.FOREVER_NS) goto L63;
        L65:
            RecyclerView r11 = this.this$0;
            ViewHolder r12 = r11.mAdapter.createViewHolder(r11, r9);
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L70;
            RecyclerView r13 = RecyclerView.findNestedRecyclerView(r12.itemView);
            if (r13 == null) goto L70;
            r12.mNestedRecyclerView = new WeakReference(r13);
        L70:
            this.mRecyclerPool.factorInCreateTime(r9, this.this$0.getNanoTime() - r10);
            ViewHolder r14 = r12;
        L71:
            boolean r15 = r4;
            if (r15 == false) goto L84;
            if (this.this$0.mState.isPreLayout() == true) goto L84;
            if (r14.hasAnyOfTheFlags(8192) == false) goto L84;
            r14.setFlags(0, 8192);
            if (this.this$0.mState.mRunSimpleAnimations == false) goto L84;
            int r16 = ItemAnimator.buildAdapterChangeFlagsForAnimations(r14) | 4096;
            RecyclerView r20 = this.this$0;
            this.this$0.recordAnimationInfoIfBouncedHiddenView(r14, r20.mItemAnimator.recordPreLayoutInformation(r20.mState, r14, r16, r14.getUnmodifiedPayloads()));
        L84:
            if (this.this$0.mState.isPreLayout() == false) goto L89;
            if (r14.isBound() == false) goto L89;
            r14.mPreLayoutPosition = r17;
        L95:
            boolean r21 = false;
        L97:
            ViewGroup.LayoutParams r22 = r14.itemView.getLayoutParams();
            if (r22 != null) goto L101;
            LayoutParams r23 = (LayoutParams) this.this$0.generateDefaultLayoutParams();
            r14.itemView.setLayoutParams(r23);
        L104:
            r23.mViewHolder = r14;
            if (r15 == false) goto L108;
            if (r21 == false) goto L108;
        L109:
            r23.mPendingInvalidate = r7;
            return r14;
        L108:
            r7 = false;
            goto L109
        L101:
            if (this.this$0.checkLayoutParams(r22) == true) goto L103;
            r23 = (LayoutParams) this.this$0.generateLayoutParams(r22);
            r14.itemView.setLayoutParams(r23);
            goto L104
        L103:
            r23 = (LayoutParams) r22;
        L89:
            if (r14.isBound() == true) goto L91;
        L96:
            r21 = tryBindViewHolderByDeadline(r14, this.this$0.mAdapterHelper.findPositionOffset(r17), r17, r19);
            goto L97
        L91:
            if (r14.needsUpdate() == true) goto L96;
            if (r14.isInvalid() == false) goto L95;
        L63:
            if (this.mRecyclerPool.willCreateInTime(r9, r10, r19) == true) goto L65;
            return null;
        L72:
            r14 = r2;
        L12:
            r4 = false;
            goto L13
        L11:
            r2 = null;
            goto L12
        }

        public void unscrapView(ViewHolder r2) {
            if (r2.mInChangeScrap == false) goto L5;
            this.mChangedScrap.remove(r2);
        L6:
            r2.mScrapContainer = null;
            r2.mInChangeScrap = false;
            r2.clearReturnedFromScrapFlag();
            return;
        L5:
            this.mAttachedScrap.remove(r2);
            goto L6
        }

        public void updateViewCacheSize() {
            LayoutManager r0 = this.this$0.mLayout;
            if (r0 == null) goto L5;
            int r1 = r0.mPrefetchMaxCountObserved;
        L6:
            this.mViewCacheMax = this.mRequestedCacheMax + r1;
            int r2 = this.mCachedViews.size() - 1;
        L7:
            if (r2 < 0) goto L11;
            if (this.mCachedViews.size() <= this.mViewCacheMax) goto L14;
            recycleCachedViewAt(r2);
            r2 = r2 - 1;
            goto L7
        L14:
            return;
        L11:
            return;
        L5:
            r1 = 0;
            goto L6
        }

        public boolean validateViewHolderForOffsetPosition(ViewHolder r6) {
            if (r6.isRemoved() == true) goto L5;
            int r0 = r6.mPosition;
            if (r0 >= 0) goto L9;
        L22:
            StringBuilder r1 = new StringBuilder("Inconsistency detected. Invalid view holder adapter position");
            r1.append(r6);
            throw new IndexOutOfBoundsException(a.g(this.this$0, r1));
        L9:
            if (r0 >= this.this$0.mAdapter.getItemCount()) goto L22;
            if (this.this$0.mState.isPreLayout() == true) goto L16;
            if (this.this$0.mAdapter.getItemViewType(r6.mPosition) == r6.getItemViewType()) goto L16;
            return false;
        L16:
            if (this.this$0.mAdapter.hasStableIds() == true) goto L18;
            return true;
        L18:
            if (r6.getItemId() == this.this$0.mAdapter.getItemId(r6.mPosition)) goto L20;
            return false;
        L20:
            return true;
        L5:
            return this.this$0.mState.isPreLayout();
        }

        public void viewRangeUpdate(int r4, int r5) {
            int r6 = r5 + r4;
            int r0 = this.mCachedViews.size() - 1;
        L3:
            if (r0 < 0) goto L12;
            ViewHolder r1 = this.mCachedViews.get(r0);
            if (r1 == null) goto L11;
            int r2 = r1.mPosition;
            if (r2 < r4) goto L11;
            if (r2 >= r6) goto L11;
            r1.addFlags(2);
            recycleCachedViewAt(r0);
        L11:
            r0 = r0 - 1;
            goto L3
        }

        public View getViewForPosition(int r3, boolean r4) {
            return tryGetViewHolderForPositionByDeadline(r3, r4, RecyclerView.FOREVER_NS).itemView;
        }

        private void invalidateDisplayListInt(ViewGroup r5, boolean r6) {
            int r0 = r5.getChildCount() - 1;
        L3:
            if (r0 < 0) goto L8;
            View r2 = r5.getChildAt(r0);
            if ((r2 instanceof ViewGroup) == false) goto L7;
            invalidateDisplayListInt((ViewGroup) r2, true);
        L7:
            r0 = r0 - 1;
            goto L3
        L8:
            if (r6 == true) goto L11;
            return;
        L11:
            if (r5.getVisibility() != 4) goto L13;
            r5.setVisibility(0);
            r5.setVisibility(4);
            return;
        L13:
            int r4 = r5.getVisibility();
            r5.setVisibility(4);
            r5.setVisibility(r4);
        }
    }

    public interface RecyclerListener {
        void onViewRecycled(@NonNull ViewHolder r1);
    }

    public class RecyclerViewDataObserver extends AdapterDataObserver {
        final /* synthetic */ RecyclerView this$0;

        public RecyclerViewDataObserver(RecyclerView r1) {
            this.this$0 = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            this.this$0.assertNotInLayoutOrScroll(null);
            RecyclerView r0 = this.this$0;
            r0.mState.mStructureChanged = true;
            r0.processDataSetCompletelyChanged(true);
            if (this.this$0.mAdapterHelper.hasPendingUpdates() == true) goto L6;
            this.this$0.requestLayout();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r3, int r4, Object r5) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeChanged(r3, r4, r5) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int r3, int r4) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeInserted(r3, r4) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int r3, int r4, int r5) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeMoved(r3, r4, r5) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int r3, int r4) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeRemoved(r3, r4) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        public void triggerUpdateProcessor() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION == false) goto L9;
            RecyclerView r0 = this.this$0;
            if (r0.mHasFixedSize == false) goto L9;
            if (r0.mIsAttached == false) goto L9;
            ViewCompat.postOnAnimation(r0, r0.mUpdateChildViewsRunnable);
            return;
        L9:
            RecyclerView r2 = this.this$0;
            r2.mAdapterUpdateDuringMeasure = true;
            r2.requestLayout();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable mLayoutState;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            if (r2 != null) goto L6;
            r2 = LayoutManager.class.getClassLoader();
        L6:
            this.mLayoutState = r1.readParcelable(r2);
        }

        public void copyFrom(SavedState r1) {
            this.mLayoutState = r1.mLayoutState;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeParcelable(this.mLayoutState, 0);
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }
    }

    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        public SimpleOnItemTouchListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView r1, @NonNull MotionEvent r2) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean r1) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView r1, @NonNull MotionEvent r2) {
        }
    }

    public static abstract class SmoothScroller {
        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final Action mRecyclingAction;
        private boolean mRunning;
        private boolean mStarted;
        private int mTargetPosition;
        private View mTargetView;

        public static class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
            private boolean mChanged;
            private int mConsecutiveUpdates;
            private int mDuration;
            private int mDx;
            private int mDy;
            private Interpolator mInterpolator;
            private int mJumpToPosition;

            public Action(@Px int r3, @Px int r4) {
                this(r3, r4, Integer.MIN_VALUE, null);
            }

            private void validate() {
                if (this.mInterpolator == null) goto L10;
                if (this.mDuration >= 1) goto L10;
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            L10:
                if (this.mDuration < 1) goto L13;
                return;
            L13:
                throw new IllegalStateException("Scroll duration must be a positive number");
            }

            public int getDuration() {
                return this.mDuration;
            }

            @Px
            public int getDx() {
                return this.mDx;
            }

            @Px
            public int getDy() {
                return this.mDy;
            }

            @Nullable
            public Interpolator getInterpolator() {
                return this.mInterpolator;
            }

            public boolean hasJumpTarget() {
                if (this.mJumpToPosition < 0) goto L5;
                return true;
            L5:
                return false;
            }

            public void jumpTo(int r1) {
                this.mJumpToPosition = r1;
            }

            public void runIfNecessary(RecyclerView r6) {
                int r0 = this.mJumpToPosition;
                if (r0 < 0) goto L7;
                this.mJumpToPosition = -1;
                r6.jumpToPositionForSmoothScroller(r0);
                this.mChanged = false;
                return;
            L7:
                if (this.mChanged == false) goto L12;
                validate();
                r6.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
                int r7 = this.mConsecutiveUpdates + 1;
                this.mConsecutiveUpdates = r7;
                if (r7 <= 10) goto L11;
                Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            L11:
                this.mChanged = false;
                return;
            L12:
                this.mConsecutiveUpdates = 0;
            }

            public void setDuration(int r2) {
                this.mChanged = true;
                this.mDuration = r2;
            }

            public void setDx(@Px int r2) {
                this.mChanged = true;
                this.mDx = r2;
            }

            public void setDy(@Px int r2) {
                this.mChanged = true;
                this.mDy = r2;
            }

            public void setInterpolator(@Nullable Interpolator r2) {
                this.mChanged = true;
                this.mInterpolator = r2;
            }

            public void update(@Px int r1, @Px int r2, int r3, @Nullable Interpolator r4) {
                this.mDx = r1;
                this.mDy = r2;
                this.mDuration = r3;
                this.mInterpolator = r4;
                this.mChanged = true;
            }

            public Action(@Px int r2, @Px int r3, int r4) {
                this(r2, r3, r4, null);
            }

            public Action(@Px int r2, @Px int r3, int r4, @Nullable Interpolator r5) {
                this.mJumpToPosition = -1;
                this.mChanged = false;
                this.mConsecutiveUpdates = 0;
                this.mDx = r2;
                this.mDy = r3;
                this.mDuration = r4;
                this.mInterpolator = r5;
            }
        }

        public interface ScrollVectorProvider {
            @Nullable
            PointF computeScrollVectorForPosition(int r1);
        }

        public SmoothScroller() {
            this.mTargetPosition = -1;
            this.mRecyclingAction = new Action(0, 0);
        }

        @Nullable
        public PointF computeScrollVectorForPosition(int r2) {
            Object r1 = getLayoutManager();
            if ((r1 instanceof ScrollVectorProvider) == true) goto L5;
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        L5:
            return ((ScrollVectorProvider) r1).computeScrollVectorForPosition(r2);
        }

        public View findViewByPosition(int r1) {
            return this.mRecyclerView.mLayout.findViewByPosition(r1);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View r1) {
            return this.mRecyclerView.getChildLayoutPosition(r1);
        }

        @Nullable
        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int r1) {
            this.mRecyclerView.scrollToPosition(r1);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public void normalize(@NonNull PointF r3) {
            float r2 = r3.x;
            float r0 = r3.y;
            float r4 = (float) Math.sqrt((r0 * r0) + (r2 * r2));
            r3.x /= r4;
            r3.y /= r4;
        }

        public void onAnimation(int r7, int r8) {
            RecyclerView r0 = this.mRecyclerView;
            if (this.mTargetPosition == (-1)) goto L5;
            if (r0 == null) goto L5;
        L7:
            if (this.mPendingInitialRun == true) goto L9;
        L19:
            this.mPendingInitialRun = false;
            View r1 = this.mTargetView;
            if (r1 == null) goto L26;
            if (getChildPosition(r1) != this.mTargetPosition) goto L24;
            onTargetFound(this.mTargetView, r0.mState, this.mRecyclingAction);
            this.mRecyclingAction.runIfNecessary(r0);
            stop();
            goto L26
        L24:
            Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
            this.mTargetView = null;
        L26:
            if (this.mRunning == false) goto L33;
            onSeekTargetStep(r7, r8, r0.mState, this.mRecyclingAction);
            boolean r9 = this.mRecyclingAction.hasJumpTarget();
            this.mRecyclingAction.runIfNecessary(r0);
            if (r9 == true) goto L30;
            return;
        L30:
            if (this.mRunning == false) goto L35;
            this.mPendingInitialRun = true;
            r0.mViewFlinger.postOnAnimation();
            return;
        L35:
            return;
        L33:
            return;
        L9:
            if (this.mTargetView != null) goto L19;
            if (this.mLayoutManager == null) goto L19;
            PointF r2 = computeScrollVectorForPosition(this.mTargetPosition);
            if (r2 == null) goto L19;
            float r3 = r2.x;
            if (r3 == 0.0f) goto L17;
        L18:
            r0.scrollStep((int) Math.signum(r3), (int) Math.signum(r2.y), null);
            goto L19
        L17:
            if (r2.y == 0.0f) goto L19;
        L5:
            stop();
            goto L7
        }

        public void onChildAttachedToWindow(View r3) {
            if (getChildPosition(r3) != getTargetPosition()) goto L6;
            this.mTargetView = r3;
            return;
        }

        public abstract void onSeekTargetStep(@Px int r1, @Px int r2, @NonNull State r3, @NonNull Action r4);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(@NonNull View r1, @NonNull State r2, @NonNull Action r3);

        public void setTargetPosition(int r1) {
            this.mTargetPosition = r1;
        }

        public void start(RecyclerView r3, LayoutManager r4) {
            r3.mViewFlinger.stop();
            if (this.mStarted == false) goto L5;
            Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        L5:
            this.mRecyclerView = r3;
            this.mLayoutManager = r4;
            int r5 = this.mTargetPosition;
            if (r5 == (-1)) goto L10;
            r3.mState.mTargetPosition = r5;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = findViewByPosition(getTargetPosition());
            onStart();
            this.mRecyclerView.mViewFlinger.postOnAnimation();
            this.mStarted = true;
            return;
        L10:
            throw new IllegalArgumentException("Invalid target position");
        }

        public final void stop() {
            if (this.mRunning == true) goto L5;
            return;
        L5:
            this.mRunning = false;
            onStop();
            this.mRecyclerView.mState.mTargetPosition = -1;
            this.mTargetView = null;
            this.mTargetPosition = -1;
            this.mPendingInitialRun = false;
            this.mLayoutManager.onSmoothScrollerStopped(this);
            this.mLayoutManager = null;
            this.mRecyclerView = null;
        }
    }

    public static class State {
        static final int STEP_ANIMATIONS = 4;
        static final int STEP_LAYOUT = 2;
        static final int STEP_START = 1;
        private SparseArray<Object> mData;
        int mDeletedInvisibleItemCountSincePreviousLayout;
        long mFocusedItemId;
        int mFocusedItemPosition;
        int mFocusedSubChildId;
        boolean mInPreLayout;
        boolean mIsMeasuring;
        int mItemCount;
        int mLayoutStep;
        int mPreviousLayoutItemCount;
        int mRemainingScrollHorizontal;
        int mRemainingScrollVertical;
        boolean mRunPredictiveAnimations;
        boolean mRunSimpleAnimations;
        boolean mStructureChanged;
        int mTargetPosition;
        boolean mTrackOldChangeHolders;

        public State() {
            this.mTargetPosition = -1;
            this.mPreviousLayoutItemCount = 0;
            this.mDeletedInvisibleItemCountSincePreviousLayout = 0;
            this.mLayoutStep = 1;
            this.mItemCount = 0;
            this.mStructureChanged = false;
            this.mInPreLayout = false;
            this.mTrackOldChangeHolders = false;
            this.mIsMeasuring = false;
            this.mRunSimpleAnimations = false;
            this.mRunPredictiveAnimations = false;
        }

        public void assertLayoutStep(int r4) {
            if ((this.mLayoutStep & r4) == 0) goto L6;
            return;
        L6:
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(r4) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
        }

        public boolean didStructureChange() {
            return this.mStructureChanged;
        }

        public <T> T get(int r1) {
            SparseArray<Object> r0 = this.mData;
            if (r0 != null) goto L7;
            return null;
        L7:
            return (T) r0.get(r1);
        }

        public int getItemCount() {
            if (this.mInPreLayout == false) goto L6;
            return this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
        L6:
            return this.mItemCount;
        }

        public int getRemainingScrollHorizontal() {
            return this.mRemainingScrollHorizontal;
        }

        public int getRemainingScrollVertical() {
            return this.mRemainingScrollVertical;
        }

        public int getTargetScrollPosition() {
            return this.mTargetPosition;
        }

        public boolean hasTargetScrollPosition() {
            if (this.mTargetPosition == (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isMeasuring() {
            return this.mIsMeasuring;
        }

        public boolean isPreLayout() {
            return this.mInPreLayout;
        }

        public void prepareForNestedPrefetch(Adapter r2) {
            this.mLayoutStep = 1;
            this.mItemCount = r2.getItemCount();
            this.mInPreLayout = false;
            this.mTrackOldChangeHolders = false;
            this.mIsMeasuring = false;
        }

        public void put(int r2, Object r3) {
            if (this.mData != null) goto L5;
            this.mData = new SparseArray();
        L5:
            this.mData.put(r2, r3);
        }

        public void remove(int r1) {
            SparseArray<Object> r0 = this.mData;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.remove(r1);
        }

        public String toString() {
            return "State{mTargetPosition=" + this.mTargetPosition + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mIsMeasuring=" + this.mIsMeasuring + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
        }

        public boolean willRunPredictiveAnimations() {
            return this.mRunPredictiveAnimations;
        }

        public boolean willRunSimpleAnimations() {
            return this.mRunSimpleAnimations;
        }
    }

    public static abstract class ViewCacheExtension {
        public ViewCacheExtension() {
        }

        @Nullable
        public abstract View getViewForPositionAndType(@NonNull Recycler r1, int r2, int r3);
    }

    public class ViewFlinger implements Runnable {
        private boolean mEatRunOnAnimationRequest;
        Interpolator mInterpolator;
        private int mLastFlingX;
        private int mLastFlingY;
        OverScroller mOverScroller;
        private boolean mReSchedulePostAnimationCallback;
        final /* synthetic */ RecyclerView this$0;

        public ViewFlinger(RecyclerView r3) {
            this.this$0 = r3;
            Interpolator r0 = RecyclerView.sQuinticInterpolator;
            this.mInterpolator = r0;
            this.mEatRunOnAnimationRequest = false;
            this.mReSchedulePostAnimationCallback = false;
            this.mOverScroller = new OverScroller(r3.getContext(), r0);
        }

        private int computeScrollDuration(int r5, int r6, int r7, int r8) {
            int r0 = Math.abs(r5);
            int r1 = Math.abs(r6);
            if (r0 <= r1) goto L5;
            boolean r2 = true;
        L6:
            int r9 = (int) Math.sqrt((r8 * r8) + (r7 * r7));
            int r10 = (int) Math.sqrt((r6 * r6) + (r5 * r5));
            RecyclerView r11 = this.this$0;
            if (r2 == false) goto L9;
            int r12 = r11.getWidth();
        L10:
            int r13 = r12 / 2;
            float r14 = r12;
            float r15 = r13;
            float r4 = (distanceInfluenceForSnapDuration(Math.min(1.0f, (r10 * 1.0f) / r14)) * r15) + r15;
            if (r9 <= 0) goto L13;
            int r16 = Math.round(Math.abs(r4 / r9) * 1000.0f) * 4;
        L18:
            return Math.min(r16, 2000);
        L13:
            if (r2 == true) goto L16;
            r0 = r1;
        L16:
            r16 = (int) (((r0 / r14) + 1.0f) * 300.0f);
            goto L18
        L9:
            r12 = r11.getHeight();
            goto L10
        L5:
            r2 = false;
            goto L6
        }

        private float distanceInfluenceForSnapDuration(float r1) {
            return (float) Math.sin((r1 - 0.5f) * 0.47123894f);
        }

        private void internalPostOnAnimation() {
            this.this$0.removeCallbacks(this);
            ViewCompat.postOnAnimation(this.this$0, this);
        }

        public void fling(int r13, int r14) {
            this.this$0.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            Interpolator r0 = this.mInterpolator;
            Interpolator r1 = RecyclerView.sQuinticInterpolator;
            if (r0 == r1) goto L5;
            this.mInterpolator = r1;
            this.mOverScroller = new OverScroller(this.this$0.getContext(), r1);
        L5:
            this.mOverScroller.fling(0, 0, r13, r14, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            postOnAnimation();
        }

        public void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest == false) goto L5;
            this.mReSchedulePostAnimationCallback = true;
            return;
        L5:
            internalPostOnAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView r1 = this.this$0;
            if (r1.mLayout != null) goto L6;
            stop();
            return;
        L6:
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            r1.consumePendingUpdateOperations();
            OverScroller r2 = this.mOverScroller;
            if (r2.computeScrollOffset() == false) goto L83;
            int r4 = r2.getCurrX();
            int r5 = r2.getCurrY();
            int r6 = r4 - this.mLastFlingX;
            int r13 = r5 - this.mLastFlingY;
            this.mLastFlingX = r4;
            this.mLastFlingY = r5;
            RecyclerView r7 = this.this$0;
            int[] r10 = r7.mReusableIntPair;
            r10[0] = 0;
            r10[1] = 0;
            if (r7.dispatchNestedPreScroll(r6, r13, r10, null, 1) == false) goto L12;
            int[] r8 = this.this$0.mReusableIntPair;
            r6 = r6 - r8[0];
            r13 = r13 - r8[1];
        L12:
            if (this.this$0.getOverScrollMode() == 2) goto L14;
            this.this$0.considerReleasingGlowsOnScroll(r6, r13);
        L14:
            RecyclerView r9 = this.this$0;
            if (r9.mAdapter == null) goto L29;
            int[] r11 = r9.mReusableIntPair;
            r11[0] = 0;
            r11[1] = 0;
            r9.scrollStep(r6, r13, r11);
            RecyclerView r12 = this.this$0;
            int[] r14 = r12.mReusableIntPair;
            int r15 = r14[0];
            int r16 = r14[1];
            r6 = r6 - r15;
            r13 = r13 - r16;
            SmoothScroller r17 = r12.mLayout.mSmoothScroller;
            if (r17 == null) goto L31;
            if (r17.isPendingInitialRun() == true) goto L31;
            if (r17.isRunning() == false) goto L31;
            int r18 = this.this$0.mState.getItemCount();
            if (r18 != 0) goto L26;
            r17.stop();
            goto L31
        L26:
            if (r17.getTargetPosition() < r18) goto L28;
            r17.setTargetPosition(r18 - 1);
            r17.onAnimation(r15, r16);
            goto L31
        L28:
            r17.onAnimation(r15, r16);
        L31:
            if (this.this$0.mItemDecorations.isEmpty() == true) goto L33;
            this.this$0.invalidate();
        L33:
            RecyclerView r19 = this.this$0;
            int[] r20 = r19.mReusableIntPair;
            r20[0] = 0;
            r20[1] = 0;
            r19.dispatchNestedScroll(r15, r16, r6, r13, null, 1, r20);
            RecyclerView r21 = this.this$0;
            int[] r22 = r21.mReusableIntPair;
            int r23 = r6 - r22[0];
            int r110 = r13 - r22[1];
            if (r15 != 0) goto L36;
            if (r16 != 0) goto L36;
        L38:
            if (RecyclerView.access$200(this.this$0) == true) goto L41;
            this.this$0.invalidate();
        L41:
            if (r2.getCurrX() != r2.getFinalX()) goto L43;
            boolean r24 = true;
        L45:
            if (r2.getCurrY() != r2.getFinalY()) goto L47;
            boolean r25 = true;
        L49:
            if (r2.isFinished() == true) goto L56;
            if (r24 == true) goto L52;
            if (r23 != 0) goto L52;
        L55:
            boolean r26 = false;
        L57:
            SmoothScroller r27 = this.this$0.mLayout.mSmoothScroller;
            if (r27 != null) goto L60;
        L62:
            if (r26 == true) goto L64;
        L80:
            postOnAnimation();
            RecyclerView r3 = this.this$0;
            GapWorker r28 = r3.mGapWorker;
            if (r28 == null) goto L83;
            r28.postFromTraversal(r3, r15, r16);
            goto L83
        L64:
            if (this.this$0.getOverScrollMode() == 2) goto L78;
            int r29 = (int) r2.getCurrVelocity();
            if (r23 >= 0) goto L68;
            int r30 = -r29;
        L71:
            if (r110 >= 0) goto L73;
            r29 = -r29;
        L76:
            this.this$0.absorbGlows(r30, r29);
            goto L78
        L73:
            if (r110 > 0) goto L76;
            r29 = 0;
            goto L76
        L68:
            if (r23 <= 0) goto L70;
            r30 = r29;
            goto L71
        L70:
            r30 = 0;
        L78:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L83;
            this.this$0.mPrefetchRegistry.clearPrefetchPositions();
            goto L83
        L60:
            if (r27.isPendingInitialRun() == false) goto L62;
        L52:
            if (r25 == true) goto L56;
            if (r110 == 0) goto L55;
        L56:
            r26 = true;
            goto L57
        L47:
            r25 = false;
            goto L49
        L43:
            r24 = false;
        L36:
            r21.dispatchOnScrolled(r15, r16);
            goto L38
        L29:
            r16 = 0;
            r15 = 0;
        L83:
            SmoothScroller r31 = this.this$0.mLayout.mSmoothScroller;
            if (r31 != null) goto L86;
        L88:
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback == false) goto L91;
            internalPostOnAnimation();
            return;
        L91:
            this.this$0.setScrollState(0);
            this.this$0.stopNestedScroll(1);
            return;
        L86:
            if (r31.isPendingInitialRun() == false) goto L88;
            r31.onAnimation(0, 0);
            goto L88
        }

        public void smoothScrollBy(int r9, int r10, int r11, @Nullable Interpolator r12) {
            if (r11 != Integer.MIN_VALUE) goto L5;
            r11 = computeScrollDuration(r9, r10, 0, 0);
        L5:
            int r7 = r11;
            if (r12 != null) goto L9;
            r12 = RecyclerView.sQuinticInterpolator;
        L9:
            if (this.mInterpolator == r12) goto L11;
            this.mInterpolator = r12;
            this.mOverScroller = new OverScroller(this.this$0.getContext(), r12);
        L11:
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            this.this$0.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, r9, r10, r7);
            postOnAnimation();
        }

        public void stop() {
            this.this$0.removeCallbacks(this);
            this.mOverScroller.abortAnimation();
        }
    }

    public static abstract class ViewHolder {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = null;
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;

        @NonNull
        public final View itemView;
        int mFlags;
        boolean mInChangeScrap;
        private int mIsRecyclableCount;
        long mItemId;
        int mItemViewType;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads;

        @VisibleForTesting
        int mPendingAccessibilityState;
        int mPosition;
        int mPreLayoutPosition;
        Recycler mScrapContainer;
        ViewHolder mShadowedHolder;
        ViewHolder mShadowingHolder;
        List<Object> mUnmodifiedPayloads;
        private int mWasImportantForAccessibilityBeforeHidden;

        static {
            FULLUPDATE_PAYLOADS = Collections.emptyList();
        }

        public ViewHolder(@NonNull View r4) {
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mItemViewType = -1;
            this.mPreLayoutPosition = -1;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            this.mPayloads = null;
            this.mUnmodifiedPayloads = null;
            this.mIsRecyclableCount = 0;
            this.mScrapContainer = null;
            this.mInChangeScrap = false;
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            if (r4 == null) goto L7;
            this.itemView = r4;
            return;
        L7:
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads != null) goto L6;
            ArrayList r0 = new ArrayList();
            this.mPayloads = r0;
            this.mUnmodifiedPayloads = Collections.unmodifiableList(r0);
            return;
        }

        public void addChangePayload(Object r3) {
            if (r3 != null) goto L6;
            addFlags(1024);
            return;
        L6:
            if ((1024 & this.mFlags) != 0) goto L10;
            createPayloadsIfNeeded();
            this.mPayloads.add(r3);
            return;
        }

        public void addFlags(int r2) {
            this.mFlags = r2 | this.mFlags;
        }

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void clearPayload() {
            List<Object> r0 = this.mPayloads;
            if (r0 == null) goto L5;
            r0.clear();
        L5:
            this.mFlags &= -1025;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        public boolean doesTransientStatePreventRecycling() {
            if ((this.mFlags & 16) == 0) goto L5;
        L7:
            return false;
        L5:
            if (ViewCompat.hasTransientState(this.itemView) == false) goto L7;
            return true;
        }

        public void flagRemovedAndOffsetPosition(int r2, int r3, boolean r4) {
            addFlags(8);
            offsetPosition(r3, r4);
            this.mPosition = r2;
        }

        public final int getAdapterPosition() {
            RecyclerView r0 = this.mOwnerRecyclerView;
            if (r0 != null) goto L7;
            return -1;
        L7:
            return r0.getAdapterPositionFor(this);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int r0 = this.mPreLayoutPosition;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            return this.mPosition;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int r0 = this.mPreLayoutPosition;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            return this.mPosition;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) goto L14;
            List<Object> r0 = this.mPayloads;
            if (r0 == null) goto L12;
            if (r0.size() == 0) goto L12;
            return this.mUnmodifiedPayloads;
        L12:
            return FULLUPDATE_PAYLOADS;
        L14:
            return FULLUPDATE_PAYLOADS;
        }

        public boolean hasAnyOfTheFlags(int r1) {
            if ((this.mFlags & r1) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isAdapterPositionUnknown() {
            if ((this.mFlags & 512) == 0) goto L5;
        L8:
            return true;
        L5:
            if (isInvalid() == true) goto L8;
            return false;
        }

        public boolean isAttachedToTransitionOverlay() {
            if (this.itemView.getParent() != null) goto L5;
        L7:
            return false;
        L5:
            if (this.itemView.getParent() == this.mOwnerRecyclerView) goto L7;
            return true;
        }

        public boolean isBound() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean isInvalid() {
            if ((this.mFlags & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isRecyclable() {
            if ((this.mFlags & 16) == 0) goto L5;
        L7:
            return false;
        L5:
            if (ViewCompat.hasTransientState(this.itemView) == true) goto L7;
            return true;
        }

        public boolean isRemoved() {
            if ((this.mFlags & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isScrap() {
            if (this.mScrapContainer == null) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isTmpDetached() {
            if ((this.mFlags & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isUpdated() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean needsUpdate() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void offsetPosition(int r3, boolean r4) {
            if (this.mOldPosition != (-1)) goto L6;
            this.mOldPosition = this.mPosition;
        L6:
            if (this.mPreLayoutPosition != (-1)) goto L8;
            this.mPreLayoutPosition = this.mPosition;
        L8:
            if (r4 == false) goto L10;
            this.mPreLayoutPosition += r3;
        L10:
            this.mPosition += r3;
            if (this.itemView.getLayoutParams() == null) goto L14;
            ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            return;
        }

        public void onEnteredHiddenState(RecyclerView r3) {
            int r0 = this.mPendingAccessibilityState;
            if (r0 == (-1)) goto L5;
            this.mWasImportantForAccessibilityBeforeHidden = r0;
        L6:
            r3.setChildImportantForAccessibilityInternal(this, 4);
            return;
        L5:
            this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
            goto L6
        }

        public void onLeftHiddenState(RecyclerView r2) {
            r2.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        public void saveOldPosition() {
            if (this.mOldPosition != (-1)) goto L6;
            this.mOldPosition = this.mPosition;
            return;
        }

        public void setFlags(int r3, int r4) {
            int r5 = r3 & r4;
            this.mFlags = r5 | (this.mFlags & (~r4));
        }

        public final void setIsRecyclable(boolean r3) {
            int r1 = this.mIsRecyclableCount;
            if (r3 == false) goto L5;
            int r2 = r1 - 1;
        L6:
            this.mIsRecyclableCount = r2;
            if (r2 >= 0) goto L9;
            this.mIsRecyclableCount = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            return;
        L9:
            if (r3 == true) goto L12;
            if (r2 != 1) goto L12;
            this.mFlags |= 16;
            return;
        L12:
            if (r3 == false) goto L18;
            if (r2 != 0) goto L19;
            this.mFlags &= -17;
            return;
        L19:
            return;
        L18:
            return;
        L5:
            r2 = r1 + 1;
            goto L6
        }

        public void setScrapContainer(Recycler r1, boolean r2) {
            this.mScrapContainer = r1;
            this.mInChangeScrap = r2;
        }

        public boolean shouldBeKeptAsChild() {
            if ((this.mFlags & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean shouldIgnore() {
            if ((this.mFlags & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            if (getClass().isAnonymousClass() == false) goto L5;
            String r0 = "ViewHolder";
        L6:
            StringBuilder r1 = a.t(r0, "{");
            r1.append(Integer.toHexString(hashCode()));
            r1.append(" position=");
            r1.append(this.mPosition);
            r1.append(" id=");
            r1.append(this.mItemId);
            r1.append(", oldPos=");
            r1.append(this.mOldPosition);
            r1.append(", pLpos:");
            r1.append(this.mPreLayoutPosition);
            StringBuilder r2 = new StringBuilder(r1.toString());
            if (isScrap() == false) goto L14;
            r2.append(" scrap ");
            if (this.mInChangeScrap == false) goto L11;
            String r3 = "[changeScrap]";
        L12:
            r2.append(r3);
            goto L14
        L11:
            r3 = "[attachedScrap]";
        L14:
            if (isInvalid() == false) goto L17;
            r2.append(" invalid");
        L17:
            if (isBound() == true) goto L20;
            r2.append(" unbound");
        L20:
            if (needsUpdate() == false) goto L23;
            r2.append(" update");
        L23:
            if (isRemoved() == false) goto L26;
            r2.append(" removed");
        L26:
            if (shouldIgnore() == false) goto L29;
            r2.append(" ignored");
        L29:
            if (isTmpDetached() == false) goto L32;
            r2.append(" tmpDetached");
        L32:
            if (isRecyclable() == true) goto L35;
            r2.append(" not recyclable(" + this.mIsRecyclableCount + ")");
        L35:
            if (isAdapterPositionUnknown() == false) goto L38;
            r2.append(" undefined adapter position");
        L38:
            if (this.itemView.getParent() != null) goto L40;
            r2.append(" no parent");
        L40:
            r2.append("}");
            return r2.toString();
        L5:
            r0 = getClass().getSimpleName();
            goto L6
        }

        public void unScrap() {
            this.mScrapContainer.unscrapView(this);
        }

        public boolean wasReturnedFromScrap() {
            if ((this.mFlags & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        NESTED_SCROLLING_ATTRS = new int[]{android.R.attr.nestedScrollingEnabled};
        FORCE_INVALIDATE_DISPLAY_LIST = false;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = true;
        POST_UPDATES_ON_ANIMATION = true;
        ALLOW_THREAD_GAP_WORK = true;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
        IGNORE_DETACHED_FOCUSED_CHILD = false;
        Class r1 = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, r1, r1};
        sQuinticInterpolator = new AnonymousClass3();
    }

    public RecyclerView(@NonNull Context r2) {
        this(r2, null);
    }

    public static /* synthetic */ void access$000(RecyclerView r0, View r1, int r2, ViewGroup.LayoutParams r3) {
        r0.attachViewToParent(r1, r2, r3);
    }

    public static /* synthetic */ void access$100(RecyclerView r0, int r1) {
        r0.detachViewFromParent(r1);
    }

    public static /* synthetic */ boolean access$200(RecyclerView r0) {
        return r0.awakenScrollBars();
    }

    public static /* synthetic */ void access$300(RecyclerView r0, int r1, int r2) {
        r0.setMeasuredDimension(r1, r2);
    }

    private void addAnimatingView(ViewHolder r6) {
        View r0 = r6.itemView;
        if (r0.getParent() != this) goto L5;
        boolean r1 = true;
    L6:
        this.mRecycler.unscrapView(getChildViewHolder(r0));
        if (r6.isTmpDetached() == false) goto L9;
        this.mChildHelper.attachViewToParent(r0, -1, r0.getLayoutParams(), true);
        return;
    L9:
        if (r1 == true) goto L11;
        this.mChildHelper.addView(r0, true);
        return;
    L11:
        this.mChildHelper.hide(r0);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void animateChange(@NonNull ViewHolder r2, @NonNull ViewHolder r3, @NonNull ItemAnimator.ItemHolderInfo r4, @NonNull ItemAnimator.ItemHolderInfo r5, boolean r6, boolean r7) {
        r2.setIsRecyclable(false);
        if (r6 == false) goto L5;
        addAnimatingView(r2);
    L5:
        if (r2 == r3) goto L10;
        if (r7 == false) goto L8;
        addAnimatingView(r3);
    L8:
        r2.mShadowedHolder = r3;
        addAnimatingView(r2);
        this.mRecycler.unscrapView(r2);
        r3.setIsRecyclable(false);
        r3.mShadowingHolder = r2;
    L10:
        if (this.mItemAnimator.animateChange(r2, r3, r4, r5) == false) goto L13;
        postAnimationRunner();
        return;
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    public static void clearNestedRecyclerViewIfNotNested(@NonNull ViewHolder r3) {
        WeakReference<RecyclerView> r0 = r3.mNestedRecyclerView;
        if (r0 == null) goto L23;
        RecyclerView r1 = r0.get();
    L6:
        if (r1 == null) goto L14;
        if (r1 == r3.itemView) goto L9;
        Object r2 = r1.getParent();
        if ((r2 instanceof View) == true) goto L12;
        r1 = null;
        goto L6
    L12:
        r1 = (View) r2;
        goto L6
    L9:
        return;
    L14:
        r3.mNestedRecyclerView = null;
        return;
    }

    private void createLayoutManager(Context r7, String r8, AttributeSet r9, int r10, int r11) {
        if (r8 == null) goto L42;
        String r12 = r8.trim();
        if (r12.isEmpty() == true) goto L48;
        String r13 = getFullClassName(r7, r12);
    L10:
        e = move-exception;
        throw new IllegalStateException(r9.getPositionDescription() + ": Class is not a LayoutManager " + r13, e);
    L18:
        e = move-exception;
        throw new IllegalStateException(r9.getPositionDescription() + ": Unable to find LayoutManager " + r13, e);
    L12:
        e = move-exception;
        throw new IllegalStateException(r9.getPositionDescription() + ": Cannot access non-public constructor " + r13, e);
    L14:
        e = move-exception;
        throw new IllegalStateException(r9.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r13, e);
    L16:
        e = move-exception;
        throw new IllegalStateException(r9.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r13, e);
    L8:
        if (isInEditMode() == false) goto L20;
        ClassLoader r1 = getClass().getClassLoader();     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
    L21:
        Class<? extends U> r2 = Class.forName(r13, false, r1).asSubclass(LayoutManager.class);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        Constructor r4 = r2.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L25
        Object[] r5 = {r7, r9, Integer.valueOf(r10), Integer.valueOf(r11)};     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L25
    L28:
        r4.setAccessible(true);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        setLayoutManager((LayoutManager) r4.newInstance(r5));     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        return;
    L25:
        e = move-exception;
        r5 = null;
        r4 = r2.getConstructor(null);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L29
    L29:
        e = move-exception;
        e.initCause(e);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        throw new IllegalStateException(r9.getPositionDescription() + ": Error creating LayoutManager " + r13, e);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
    L20:
        r1 = r7.getClassLoader();     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        goto L21
    L48:
        return;
    }

    private boolean didChildRangeChange(int r4, int r5) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] r3 = this.mMinMaxLayoutPositions;
        if (r3[0] != r4) goto L7;
        if (r3[1] != r5) goto L7;
        return false;
    L7:
        return true;
    }

    private void dispatchContentChangedIfNecessary() {
        int r0 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (isAccessibilityEnabled() == false) goto L9;
        AccessibilityEvent r1 = AccessibilityEvent.obtain();
        r1.setEventType(2048);
        AccessibilityEventCompat.setContentChangeTypes(r1, r0);
        sendAccessibilityEventUnchecked(r1);
        return;
    }

    private void dispatchLayoutStep1() {
        boolean r1 = true;
        this.mState.assertLayoutStep(1);
        fillRemainingScrollValues(this.mState);
        this.mState.mIsMeasuring = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.clear();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        State r0 = this.mState;
        if (r0.mRunSimpleAnimations == true) goto L5;
    L7:
        r1 = false;
    L8:
        r0.mTrackOldChangeHolders = r1;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        r0.mInPreLayout = r0.mRunPredictiveAnimations;
        r0.mItemCount = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.mRunSimpleAnimations == false) goto L32;
        int r2 = this.mChildHelper.getChildCount();
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L32;
        ViewHolder r4 = getChildViewHolderInt(this.mChildHelper.getChildAt(r3));
        if (r4.shouldIgnore() == true) goto L30;
        if (r4.isInvalid() == true) goto L17;
    L19:
        this.mViewInfoStore.addToPreLayout(r4, this.mItemAnimator.recordPreLayoutInformation(this.mState, r4, ItemAnimator.buildAdapterChangeFlagsForAnimations(r4), r4.getUnmodifiedPayloads()));
        if (this.mState.mTrackOldChangeHolders == false) goto L30;
        if (r4.isUpdated() == false) goto L30;
        if (r4.isRemoved() == true) goto L30;
        if (r4.shouldIgnore() == true) goto L30;
        if (r4.isInvalid() == true) goto L30;
        this.mViewInfoStore.addToOldChangeHolders(getChangedHolderKey(r4), r4);
        goto L30
    L17:
        if (this.mAdapter.hasStableIds() == true) goto L19;
    L30:
        r3 = r3 + 1;
    L32:
        if (this.mState.mRunPredictiveAnimations == false) goto L50;
        saveOldPositions();
        State r5 = this.mState;
        boolean r6 = r5.mStructureChanged;
        r5.mStructureChanged = false;
        this.mLayout.onLayoutChildren(this.mRecycler, r5);
        this.mState.mStructureChanged = r6;
        int r7 = 0;
    L35:
        if (r7 >= this.mChildHelper.getChildCount()) goto L49;
        ViewHolder r8 = getChildViewHolderInt(this.mChildHelper.getChildAt(r7));
        if (r8.shouldIgnore() == true) goto L48;
        if (this.mViewInfoStore.isInPreLayout(r8) == true) goto L48;
        int r9 = ItemAnimator.buildAdapterChangeFlagsForAnimations(r8);
        boolean r10 = r8.hasAnyOfTheFlags(8192);
        if (r10 == true) goto L44;
        r9 = r9 | 4096;
    L44:
        ItemAnimator.ItemHolderInfo r11 = this.mItemAnimator.recordPreLayoutInformation(this.mState, r8, r9, r8.getUnmodifiedPayloads());
        if (r10 == false) goto L47;
        recordAnimationInfoIfBouncedHiddenView(r8, r11);
        goto L48
    L47:
        this.mViewInfoStore.addToAppearedInPreLayoutHolders(r8, r11);
    L48:
        r7 = r7 + 1;
        goto L35
    L49:
        clearOldPositions();
    L51:
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.mLayoutStep = 2;
        return;
    L50:
        clearOldPositions();
        goto L51
    L5:
        if (this.mItemsChanged == false) goto L7;
        goto L7
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mItemCount = this.mAdapter.getItemCount();
        State r0 = this.mState;
        r0.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        r0.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, r0);
        State r1 = this.mState;
        r1.mStructureChanged = false;
        this.mPendingSavedState = null;
        if (r1.mRunSimpleAnimations == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        r1.mRunSimpleAnimations = r2;
        r1.mLayoutStep = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        return;
    L5:
        if (this.mItemAnimator == null) goto L7;
        r2 = true;
        goto L8
    }

    private void dispatchLayoutStep3() {
        this.mState.assertLayoutStep(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        State r0 = this.mState;
        r0.mLayoutStep = 1;
        if (r0.mRunSimpleAnimations == false) goto L24;
        int r1 = this.mChildHelper.getChildCount() - 1;
    L5:
        if (r1 < 0) goto L23;
        ViewHolder r5 = getChildViewHolderInt(this.mChildHelper.getChildAt(r1));
        if (r5.shouldIgnore() == true) goto L22;
        long r2 = getChangedHolderKey(r5);
        ItemAnimator.ItemHolderInfo r4 = this.mItemAnimator.recordPostLayoutInformation(this.mState, r5);
        ViewHolder r6 = this.mViewInfoStore.getFromOldChangeHolders(r2);
        if (r6 != null) goto L12;
    L21:
        this.mViewInfoStore.addToPostLayout(r5, r4);
        goto L22
    L12:
        if (r6.shouldIgnore() == true) goto L21;
        boolean r8 = this.mViewInfoStore.isDisappearing(r6);
        boolean r9 = this.mViewInfoStore.isDisappearing(r5);
        if (r8 == false) goto L17;
        if (r6 != r5) goto L17;
        this.mViewInfoStore.addToPostLayout(r5, r4);
    L17:
        ItemAnimator.ItemHolderInfo r7 = this.mViewInfoStore.popFromPreLayout(r6);
        this.mViewInfoStore.addToPostLayout(r5, r4);
        ItemAnimator.ItemHolderInfo r10 = this.mViewInfoStore.popFromPostLayout(r5);
        if (r7 != null) goto L20;
        handleMissingPreInfoForChangeError(r2, r5, r6);
        goto L22
    L20:
        animateChange(r6, r5, r7, r10, r8, r9);
    L22:
        r1 = r1 - 1;
        goto L5
    L23:
        this.mViewInfoStore.process(this.mViewInfoProcessCallback);
    L24:
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        State r3 = this.mState;
        r3.mPreviousLayoutItemCount = r3.mItemCount;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        r3.mRunSimpleAnimations = false;
        r3.mRunPredictiveAnimations = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<ViewHolder> r11 = this.mRecycler.mChangedScrap;
        if (r11 == null) goto L27;
        r11.clear();
    L27:
        LayoutManager r12 = this.mLayout;
        if (r12.mPrefetchMaxObservedInInitialPrefetch == false) goto L30;
        r12.mPrefetchMaxCountObserved = 0;
        r12.mPrefetchMaxObservedInInitialPrefetch = false;
        this.mRecycler.updateViewCacheSize();
    L30:
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.clear();
        int[] r13 = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(r13[0], r13[1]) == false) goto L33;
        dispatchOnScrolled(0, 0);
    L33:
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent r3) {
        OnItemTouchListener r0 = this.mInterceptingOnItemTouchListener;
        if (r0 == null) goto L5;
        r0.onTouchEvent(this, r3);
        int r4 = r3.getAction();
        if (r4 == 3) goto L13;
        if (r4 == 1) goto L13;
    L14:
        return true;
    L13:
        this.mInterceptingOnItemTouchListener = null;
        goto L14
    L5:
        if (r3.getAction() != 0) goto L9;
        return false;
    L9:
        return findInterceptingOnItemTouchListener(r3);
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent r7) {
        int r0 = r7.getAction();
        int r1 = this.mOnItemTouchListeners.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        OnItemTouchListener r4 = this.mOnItemTouchListeners.get(r3);
        if (r4.onInterceptTouchEvent(this, r7) == false) goto L10;
        if (r0 == 3) goto L10;
        this.mInterceptingOnItemTouchListener = r4;
        return true;
    L10:
        r3 = r3 + 1;
        goto L3
    L11:
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] r9) {
        int r0 = this.mChildHelper.getChildCount();
        if (r0 != 0) goto L6;
        r9[0] = -1;
        r9[1] = -1;
        return;
    L6:
        int r3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int r4 = Integer.MIN_VALUE;
        int r5 = 0;
    L7:
        if (r5 >= r0) goto L17;
        ViewHolder r6 = getChildViewHolderInt(this.mChildHelper.getChildAt(r5));
        if (r6.shouldIgnore() == true) goto L16;
        int r7 = r6.getLayoutPosition();
        if (r7 >= r3) goto L14;
        r3 = r7;
    L14:
        if (r7 <= r4) goto L16;
        r4 = r7;
    L16:
        r5 = r5 + 1;
        goto L7
    L17:
        r9[0] = r3;
        r9[1] = r4;
    }

    @Nullable
    public static RecyclerView findNestedRecyclerView(@NonNull View r4) {
        if ((r4 instanceof ViewGroup) == true) goto L6;
        return null;
    L6:
        if ((r4 instanceof RecyclerView) == true) goto L8;
        ViewGroup r5 = (ViewGroup) r4;
        int r0 = r5.getChildCount();
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L15;
        RecyclerView r3 = findNestedRecyclerView(r5.getChildAt(r2));
        if (r3 != null) goto L13;
        r2 = r2 + 1;
        goto L10
    L13:
        return r3;
    L15:
        return null;
    L8:
        return (RecyclerView) r4;
    }

    @Nullable
    private View findNextViewToFocus() {
        State r0 = this.mState;
        int r1 = r0.mFocusedItemPosition;
        if (r1 != (-1)) goto L6;
        r1 = 0;
    L6:
        int r2 = r0.getItemCount();
        int r3 = r1;
    L7:
        if (r3 >= r2) goto L16;
        ViewHolder r4 = findViewHolderForAdapterPosition(r3);
        if (r4 == null) goto L16;
        if (r4.itemView.hasFocusable() == true) goto L14;
        r3 = r3 + 1;
        goto L7
    L14:
        return r4.itemView;
    L16:
        int r5 = Math.min(r2, r1);
    L17:
        r5 = r5 - 1;
        if (r5 < 0) goto L27;
        ViewHolder r6 = findViewHolderForAdapterPosition(r5);
        if (r6 == null) goto L21;
        if (r6.itemView.hasFocusable() == false) goto L17;
        return r6.itemView;
    L21:
        return null;
    L27:
        return null;
    }

    public static ViewHolder getChildViewHolderInt(View r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return ((LayoutParams) r0.getLayoutParams()).mViewHolder;
    }

    public static void getDecoratedBoundsWithMarginsInt(View r6, Rect r7) {
        LayoutParams r0 = (LayoutParams) r6.getLayoutParams();
        Rect r1 = r0.mDecorInsets;
        r7.set((r6.getLeft() - r1.left) - ((ViewGroup.MarginLayoutParams) r0).leftMargin, (r6.getTop() - r1.top) - ((ViewGroup.MarginLayoutParams) r0).topMargin, (r6.getRight() + r1.right) + ((ViewGroup.MarginLayoutParams) r0).rightMargin, (r6.getBottom() + r1.bottom) + ((ViewGroup.MarginLayoutParams) r0).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View r3) {
        int r2 = r3.getId();
    L4:
        if (r3.isFocused() == true) goto L12;
        if ((r3 instanceof ViewGroup) == false) goto L12;
        if (r3.hasFocus() == false) goto L12;
        r3 = ((ViewGroup) r3).getFocusedChild();
        if (r3.getId() == (-1)) goto L4;
        r2 = r3.getId();
    L12:
        return r2;
    }

    private String getFullClassName(Context r2, String r3) {
        if (r3.charAt(0) != '.') goto L7;
        return r2.getPackageName() + r3;
    L7:
        if (r3.contains(LibrarianImpl.Constants.DOT) == false) goto L10;
        return r3;
    L10:
        return RecyclerView.class.getPackage().getName() + '.' + r3;
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper != null) goto L6;
        this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
    L6:
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long r6, ViewHolder r8, ViewHolder r9) {
        int r0 = this.mChildHelper.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L18;
        ViewHolder r2 = getChildViewHolderInt(this.mChildHelper.getChildAt(r1));
        if (r2 == r8) goto L17;
        if (getChangedHolderKey(r2) != r6) goto L17;
        Adapter r7 = this.mAdapter;
        if (r7 != null) goto L12;
    L15:
        StringBuilder r10 = new StringBuilder("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
        r10.append(r2);
        r10.append(" \n View Holder 2:");
        r10.append(r8);
        throw new IllegalStateException(a.g(this, r10));
    L12:
        if (r7.hasStableIds() == false) goto L15;
        StringBuilder r11 = new StringBuilder("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
        r11.append(r2);
        r11.append(" \n View Holder 2:");
        r11.append(r8);
        throw new IllegalStateException(a.g(this, r11));
    L17:
        r1 = r1 + 1;
        goto L3
    L18:
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + r9 + " cannot be found but it is necessary for " + r8 + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int r0 = this.mChildHelper.getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L14;
        ViewHolder r3 = getChildViewHolderInt(this.mChildHelper.getChildAt(r2));
        if (r3 == null) goto L13;
        if (r3.shouldIgnore() == true) goto L13;
        if (r3.isUpdated() == false) goto L13;
        return true;
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (ViewCompat.getImportantForAutofill(this) != 0) goto L6;
        ViewCompat.setImportantForAutofill(this, 8);
        return;
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new AnonymousClass5(this));
    }

    private boolean isPreferredNextFocus(View r10, View r11, int r12) {
        if (r11 == null) goto L88;
        if (r11 != this) goto L7;
        return false;
    L7:
        if (findContainingItemView(r11) != null) goto L10;
        return false;
    L10:
        if (r10 != null) goto L13;
        return true;
    L13:
        if (findContainingItemView(r10) != null) goto L15;
        return true;
    L15:
        this.mTempRect.set(0, 0, r10.getWidth(), r10.getHeight());
        this.mTempRect2.set(0, 0, r11.getWidth(), r11.getHeight());
        offsetDescendantRectToMyCoords(r10, this.mTempRect);
        offsetDescendantRectToMyCoords(r11, this.mTempRect2);
        byte r13 = -1;
        if (this.mLayout.getLayoutDirection() != 1) goto L18;
        int r14 = -1;
    L19:
        Rect r2 = this.mTempRect;
        int r3 = r2.left;
        Rect r4 = this.mTempRect2;
        int r5 = r4.left;
        if (r3 < r5) goto L24;
        if (r2.right <= r5) goto L24;
    L26:
        int r6 = r2.right;
        int r7 = r4.right;
        if (r6 > r7) goto L29;
        if (r3 >= r7) goto L29;
    L31:
        int r8 = 0;
    L32:
        int r9 = r2.top;
        int r15 = r4.top;
        if (r9 < r15) goto L37;
        if (r2.bottom <= r15) goto L37;
    L39:
        int r16 = r2.bottom;
        int r17 = r4.bottom;
        if (r16 > r17) goto L42;
        if (r9 >= r17) goto L42;
    L44:
        r13 = 0;
    L45:
        if (r12 != 1) goto L47;
        if (r13 < 0) goto L81;
        if (r13 == 0) goto L79;
        return false;
    L79:
        if ((r8 * r14) <= 0) goto L81;
        return false;
    L81:
        return true;
    L47:
        if (r12 != 2) goto L49;
        if (r13 > 0) goto L75;
        if (r13 == 0) goto L73;
        return false;
    L73:
        if ((r8 * r14) >= 0) goto L75;
        return false;
    L75:
        return true;
    L49:
        if (r12 != 17) goto L51;
        if (r8 < 0) goto L69;
        return false;
    L69:
        return true;
    L51:
        if (r12 != 33) goto L53;
        if (r13 < 0) goto L66;
        return false;
    L66:
        return true;
    L53:
        if (r12 != 66) goto L55;
        if (r8 > 0) goto L63;
        return false;
    L63:
        return true;
    L55:
        if (r12 != 130) goto L59;
        if (r13 > 0) goto L58;
        return false;
    L58:
        return true;
    L59:
        StringBuilder r18 = new StringBuilder("Invalid direction: ");
        r18.append(r12);
        throw new IllegalArgumentException(a.g(this, r18));
    L42:
        if (r9 <= r15) goto L44;
    L37:
        if (r2.bottom >= r4.bottom) goto L39;
        r13 = 1;
    L29:
        if (r3 <= r5) goto L31;
        r8 = -1;
    L24:
        if (r2.right >= r4.right) goto L26;
        r8 = 1;
        goto L32
    L18:
        r14 = 1;
        goto L19
    L88:
        return false;
    }

    private void onPointerUp(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r4.getPointerId(r0) != this.mScrollPointerId) goto L9;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.mScrollPointerId = r4.getPointerId(r1);
        int r2 = (int) (r4.getX(r1) + 0.5f);
        this.mLastTouchX = r2;
        this.mInitialTouchX = r2;
        int r5 = (int) (r4.getY(r1) + 0.5f);
        this.mLastTouchY = r5;
        this.mInitialTouchY = r5;
        return;
    L6:
        r1 = 0;
        goto L7
    }

    private boolean predictiveItemAnimationsEnabled() {
        if (this.mItemAnimator != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mLayout.supportsPredictiveItemAnimations() == false) goto L7;
        return true;
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout == false) goto L8;
        this.mAdapterHelper.reset();
        if (this.mDispatchItemsChangedEvent == false) goto L8;
        this.mLayout.onItemsChanged(this);
    L8:
        if (predictiveItemAnimationsEnabled() == false) goto L10;
        this.mAdapterHelper.preProcess();
    L11:
        boolean r1 = true;
        if (this.mItemsAddedOrRemoved == false) goto L14;
    L17:
        boolean r0 = true;
    L18:
        State r3 = this.mState;
        if (this.mFirstLayoutComplete == true) goto L21;
    L31:
        boolean r4 = false;
    L32:
        r3.mRunSimpleAnimations = r4;
        State r5 = this.mState;
        if (r5.mRunSimpleAnimations == false) goto L40;
        if (r0 == false) goto L40;
        if (this.mDataSetHasChangedAfterLayout == true) goto L40;
        if (predictiveItemAnimationsEnabled() == false) goto L40;
    L41:
        r5.mRunPredictiveAnimations = r1;
        return;
    L40:
        r1 = false;
        goto L41
    L21:
        if (this.mItemAnimator == null) goto L31;
        boolean r6 = this.mDataSetHasChangedAfterLayout;
        if (r6 == true) goto L27;
        if (r0 == true) goto L27;
        if (this.mLayout.mRequestedSimpleAnimations == false) goto L31;
    L27:
        if (r6 == true) goto L29;
    L30:
        r4 = true;
        goto L32
    L29:
        if (this.mAdapter.hasStableIds() == false) goto L31;
    L14:
        if (this.mItemsChanged == true) goto L17;
        r0 = false;
        goto L18
    L10:
        this.mAdapterHelper.consumeUpdatesInOnePass();
        goto L11
    }

    private void pullGlows(float r7, float r8, float r9, float r10) {
        boolean r3 = true;
        if (r8 >= 0.0f) goto L7;
        ensureLeftGlow();
        EdgeEffectCompat.onPull(this.mLeftGlow, (-r8) / getWidth(), 1.0f - (r9 / getHeight()));
    L5:
        boolean r11 = true;
    L11:
        if (r10 >= 0.0f) goto L14;
        ensureTopGlow();
        EdgeEffectCompat.onPull(this.mTopGlow, (-r10) / getHeight(), r7 / getWidth());
    L17:
        if (r3 == false) goto L19;
    L22:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L19:
        if (r8 != 0.0f) goto L22;
        if (r10 != 0.0f) goto L22;
        return;
    L14:
        if (r10 <= 0.0f) goto L16;
        ensureBottomGlow();
        EdgeEffectCompat.onPull(this.mBottomGlow, r10 / getHeight(), 1.0f - (r7 / getWidth()));
        goto L17
    L16:
        r3 = r11;
        goto L17
    L7:
        if (r8 <= 0.0f) goto L9;
        ensureRightGlow();
        EdgeEffectCompat.onPull(this.mRightGlow, r8 / getWidth(), r9 / getHeight());
        goto L5
    L9:
        r11 = false;
        goto L11
    }

    private void recoverFocusFromState() {
        if (this.mPreserveFocusAfterLayout == true) goto L5;
        return;
    L5:
        if (this.mAdapter != null) goto L7;
        return;
    L7:
        if (hasFocus() == true) goto L9;
        return;
    L9:
        if (getDescendantFocusability() != 393216) goto L11;
        return;
    L11:
        if (getDescendantFocusability() != 131072) goto L16;
        if (isFocused() == false) goto L16;
        return;
    L16:
        if (isFocused() == true) goto L30;
        View r0 = getFocusedChild();
        if (IGNORE_DETACHED_FOCUSED_CHILD == false) goto L28;
        if (r0.getParent() == null) goto L24;
        if (r0.hasFocus() == true) goto L28;
    L24:
        if (this.mChildHelper.getChildCount() != 0) goto L30;
        requestFocus();
        return;
    L28:
        if (this.mChildHelper.isHidden(r0) == true) goto L30;
        return;
    L30:
        View r1 = null;
        if (this.mState.mFocusedItemId != (-1)) goto L33;
    L35:
        ViewHolder r2 = null;
    L36:
        if (r2 == null) goto L44;
        if (this.mChildHelper.isHidden(r2.itemView) == true) goto L44;
        if (r2.itemView.hasFocusable() == false) goto L44;
        r1 = r2.itemView;
    L46:
        if (r1 == null) goto L60;
        int r6 = this.mState.mFocusedSubChildId;
        if (r6 == (-1)) goto L54;
        View r7 = r1.findViewById(r6);
        if (r7 == null) goto L54;
        if (r7.isFocusable() == false) goto L54;
        r1 = r7;
    L54:
        r1.requestFocus();
        return;
    L60:
        return;
    L44:
        if (this.mChildHelper.getChildCount() <= 0) goto L46;
        r1 = findNextViewToFocus();
        goto L46
    L33:
        if (this.mAdapter.hasStableIds() == false) goto L35;
        r2 = findViewHolderForItemId(this.mState.mFocusedItemId);
        goto L36
    }

    private void releaseGlows() {
        EdgeEffect r0 = this.mLeftGlow;
        if (r0 == null) goto L5;
        r0.onRelease();
        boolean r1 = this.mLeftGlow.isFinished();
    L6:
        EdgeEffect r2 = this.mTopGlow;
        if (r2 == null) goto L9;
        r2.onRelease();
        r1 = r1 | this.mTopGlow.isFinished();
    L9:
        EdgeEffect r3 = this.mRightGlow;
        if (r3 == null) goto L12;
        r3.onRelease();
        r1 = r1 | this.mRightGlow.isFinished();
    L12:
        EdgeEffect r4 = this.mBottomGlow;
        if (r4 == null) goto L15;
        r4.onRelease();
        r1 = r1 | this.mBottomGlow.isFinished();
    L15:
        if (r1 == false) goto L18;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L18:
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void requestChildOnScreen(@NonNull View r12, @Nullable View r13) {
        if (r13 == null) goto L4;
        View r0 = r13;
    L5:
        this.mTempRect.set(0, 0, r0.getWidth(), r0.getHeight());
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof LayoutParams) == false) goto L10;
        LayoutParams r2 = (LayoutParams) r1;
        if (r2.mInsetsDirty == true) goto L10;
        Rect r3 = r2.mDecorInsets;
        Rect r4 = this.mTempRect;
        r4.left -= r3.left;
        r4.right += r3.right;
        r4.top -= r3.top;
        r4.bottom += r3.bottom;
    L10:
        if (r13 == null) goto L12;
        offsetDescendantRectToMyCoords(r13, this.mTempRect);
        offsetRectIntoDescendantCoords(r12, this.mTempRect);
    L12:
        LayoutManager r5 = this.mLayout;
        Rect r8 = this.mTempRect;
        boolean r9 = !this.mFirstLayoutComplete;
        if (r13 != null) goto L15;
        boolean r10 = true;
    L16:
        r5.requestChildRectangleOnScreen(this, r12, r8, r9, r10);
        return;
    L15:
        r10 = false;
        goto L16
    L4:
        r0 = r12;
        goto L5
    }

    private void resetFocusInfo() {
        State r2 = this.mState;
        r2.mFocusedItemId = -1;
        r2.mFocusedItemPosition = -1;
        r2.mFocusedSubChildId = -1;
    }

    private void resetScroll() {
        VelocityTracker r0 = this.mVelocityTracker;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        ViewHolder r1 = null;
        if (this.mPreserveFocusAfterLayout == true) goto L5;
    L9:
        View r0 = null;
    L10:
        if (r0 == null) goto L13;
        r1 = findContainingViewHolder(r0);
    L13:
        if (r1 != null) goto L15;
        resetFocusInfo();
        return;
    L15:
        State r2 = this.mState;
        if (this.mAdapter.hasStableIds() == false) goto L18;
        long r3 = r1.getItemId();
    L19:
        r2.mFocusedItemId = r3;
        State r4 = this.mState;
        if (this.mDataSetHasChangedAfterLayout == false) goto L23;
        int r5 = -1;
    L26:
        r4.mFocusedItemPosition = r5;
        this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(r1.itemView);
        return;
    L23:
        if (r1.isRemoved() == false) goto L25;
        r5 = r1.mOldPosition;
        goto L26
    L25:
        r5 = r1.getAdapterPosition();
        goto L26
    L18:
        r3 = -1;
        goto L19
    L5:
        if (hasFocus() == false) goto L9;
        if (this.mAdapter == null) goto L9;
        r0 = getFocusedChild();
        goto L10
    }

    private void setAdapterInternal(@Nullable Adapter r3, boolean r4, boolean r5) {
        Adapter r0 = this.mAdapter;
        if (r0 == null) goto L5;
        r0.unregisterAdapterDataObserver(this.mObserver);
        this.mAdapter.onDetachedFromRecyclerView(this);
    L5:
        if (r4 == false) goto L7;
        if (r5 == true) goto L7;
    L8:
        this.mAdapterHelper.reset();
        Adapter r6 = this.mAdapter;
        this.mAdapter = r3;
        if (r3 == null) goto L11;
        r3.registerAdapterDataObserver(this.mObserver);
        r3.onAttachedToRecyclerView(this);
    L11:
        LayoutManager r7 = this.mLayout;
        if (r7 == null) goto L14;
        r7.onAdapterChanged(r6, this.mAdapter);
    L14:
        this.mRecycler.onAdapterChanged(r6, this.mAdapter, r4);
        this.mState.mStructureChanged = true;
        return;
    L7:
        removeAndRecycleViews();
        goto L8
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        LayoutManager r1 = this.mLayout;
        if (r1 == null) goto L6;
        r1.stopSmoothScroller();
        return;
    }

    public void absorbGlows(int r3, int r4) {
        if (r3 >= 0) goto L6;
        ensureLeftGlow();
        if (this.mLeftGlow.isFinished() == false) goto L10;
        this.mLeftGlow.onAbsorb(-r3);
    L10:
        if (r4 >= 0) goto L14;
        ensureTopGlow();
        if (this.mTopGlow.isFinished() == false) goto L18;
        this.mTopGlow.onAbsorb(-r4);
    L18:
        if (r3 != 0) goto L20;
        if (r4 != 0) goto L20;
        return;
    L20:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L14:
        if (r4 <= 0) goto L18;
        ensureBottomGlow();
        if (this.mBottomGlow.isFinished() == false) goto L18;
        this.mBottomGlow.onAbsorb(r4);
        goto L18
    L6:
        if (r3 <= 0) goto L10;
        ensureRightGlow();
        if (this.mRightGlow.isFinished() == false) goto L10;
        this.mRightGlow.onAbsorb(r3);
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r2, int r3, int r4) {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L5;
    L6:
        super.addFocusables(r2, r3, r4);
        return;
    L5:
        if (r0.onAddFocusables(this, r2, r3, r4) == false) goto L6;
    }

    public void addItemDecoration(@NonNull ItemDecoration r3, int r4) {
        LayoutManager r0 = this.mLayout;
        if (r0 == null) goto L6;
        r0.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
    L6:
        if (this.mItemDecorations.isEmpty() == false) goto L8;
        setWillNotDraw(false);
    L8:
        if (r4 >= 0) goto L10;
        this.mItemDecorations.add(r3);
    L11:
        markItemDecorInsetsDirty();
        requestLayout();
        return;
    L10:
        this.mItemDecorations.add(r4, r3);
        goto L11
    }

    public void addOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener r2) {
        if (this.mOnChildAttachStateListeners != null) goto L5;
        this.mOnChildAttachStateListeners = new ArrayList();
    L5:
        this.mOnChildAttachStateListeners.add(r2);
    }

    public void addOnItemTouchListener(@NonNull OnItemTouchListener r1) {
        this.mOnItemTouchListeners.add(r1);
    }

    public void addOnScrollListener(@NonNull OnScrollListener r2) {
        if (this.mScrollListeners != null) goto L5;
        this.mScrollListeners = new ArrayList();
    L5:
        this.mScrollListeners.add(r2);
    }

    public void animateAppearance(@NonNull ViewHolder r2, @Nullable ItemAnimator.ItemHolderInfo r3, @NonNull ItemAnimator.ItemHolderInfo r4) {
        r2.setIsRecyclable(false);
        if (this.mItemAnimator.animateAppearance(r2, r3, r4) == false) goto L6;
        postAnimationRunner();
        return;
    }

    public void animateDisappearance(@NonNull ViewHolder r2, @NonNull ItemAnimator.ItemHolderInfo r3, @Nullable ItemAnimator.ItemHolderInfo r4) {
        addAnimatingView(r2);
        r2.setIsRecyclable(false);
        if (this.mItemAnimator.animateDisappearance(r2, r3, r4) == false) goto L6;
        postAnimationRunner();
        return;
    }

    public void assertInLayoutOrScroll(String r3) {
        if (isComputingLayout() == true) goto L9;
        if (r3 != null) goto L8;
        throw new IllegalStateException(a.g(this, new StringBuilder("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
    L8:
        throw new IllegalStateException(a.g(this, a.q(r3)));
    }

    public void assertNotInLayoutOrScroll(String r3) {
        if (isComputingLayout() == false) goto L10;
        if (r3 != null) goto L8;
        throw new IllegalStateException(a.g(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
    L8:
        throw new IllegalStateException(r3);
    L10:
        if (this.mDispatchScrollCounter <= 0) goto L13;
        Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(a.g(this, new StringBuilder(""))));
        return;
    }

    public boolean canReuseUpdatedViewHolder(ViewHolder r2) {
        ItemAnimator r1 = this.mItemAnimator;
        if (r1 != null) goto L5;
    L8:
        return true;
    L5:
        if (r1.canReuseUpdatedViewHolder(r2, r2.getUnmodifiedPayloads()) == true) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r2) {
        if ((r2 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mLayout.checkLayoutParams((LayoutParams) r2) == false) goto L7;
        return true;
    }

    public void clearOldPositions() {
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        ViewHolder r2 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r1));
        if (r2.shouldIgnore() == true) goto L7;
        r2.clearOldPosition();
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        this.mRecycler.clearOldPositions();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> r0 = this.mOnChildAttachStateListeners;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> r0 = this.mScrollListeners;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollExtent(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollOffset(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollRange(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollExtent(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollOffset(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollRange(this.mState);
    }

    public void considerReleasingGlowsOnScroll(int r3, int r4) {
        EdgeEffect r0 = this.mLeftGlow;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = false;
    L9:
        EdgeEffect r2 = this.mRightGlow;
        if (r2 != null) goto L12;
    L15:
        EdgeEffect r5 = this.mTopGlow;
        if (r5 != null) goto L18;
    L21:
        EdgeEffect r6 = this.mBottomGlow;
        if (r6 != null) goto L24;
    L27:
        if (r1 == false) goto L30;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L30:
        return;
    L24:
        if (r6.isFinished() == true) goto L27;
        if (r4 >= 0) goto L27;
        this.mBottomGlow.onRelease();
        r1 = r1 | this.mBottomGlow.isFinished();
        goto L27
    L18:
        if (r5.isFinished() == true) goto L21;
        if (r4 <= 0) goto L21;
        this.mTopGlow.onRelease();
        r1 = r1 | this.mTopGlow.isFinished();
        goto L21
    L12:
        if (r2.isFinished() == true) goto L15;
        if (r3 >= 0) goto L15;
        this.mRightGlow.onRelease();
        r1 = r1 | this.mRightGlow.isFinished();
        goto L15
    L5:
        if (r0.isFinished() == true) goto L8;
        if (r3 <= 0) goto L8;
        this.mLeftGlow.onRelease();
        r1 = this.mLeftGlow.isFinished();
        goto L9
    }

    public void consumePendingUpdateOperations() {
        if (this.mFirstLayoutComplete == true) goto L5;
    L25:
        TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        return;
    L5:
        if (this.mDataSetHasChangedAfterLayout == true) goto L25;
        if (this.mAdapterHelper.hasPendingUpdates() == true) goto L11;
        return;
    L11:
        if (this.mAdapterHelper.hasAnyUpdateTypes(4) == false) goto L22;
        if (this.mAdapterHelper.hasAnyUpdateTypes(11) == true) goto L22;
        TraceCompat.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mAdapterHelper.preProcess();
        if (this.mLayoutWasDefered == false) goto L17;
    L20:
        stopInterceptRequestLayout(true);
        onExitLayoutOrScroll();
        TraceCompat.endSection();
        return;
    L17:
        if (hasUpdatedView() == false) goto L19;
        dispatchLayout();
        goto L20
    L19:
        this.mAdapterHelper.consumePostponedUpdates();
    L22:
        if (this.mAdapterHelper.hasPendingUpdates() == false) goto L28;
        TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        return;
    }

    public void defaultOnMeasure(int r3, int r4) {
        int r0 = getPaddingLeft();
        int r5 = LayoutManager.chooseSize(r3, getPaddingRight() + r0, ViewCompat.getMinimumWidth(this));
        int r1 = getPaddingTop();
        setMeasuredDimension(r5, LayoutManager.chooseSize(r4, getPaddingBottom() + r1, ViewCompat.getMinimumHeight(this)));
    }

    public void dispatchChildAttached(View r3) {
        ViewHolder r0 = getChildViewHolderInt(r3);
        onChildAttachedToWindow(r3);
        Adapter r1 = this.mAdapter;
        if (r1 == null) goto L6;
        if (r0 == null) goto L6;
        r1.onViewAttachedToWindow(r0);
    L6:
        List<OnChildAttachStateChangeListener> r2 = this.mOnChildAttachStateListeners;
        if (r2 == null) goto L11;
        int r4 = r2.size() - 1;
    L9:
        if (r4 < 0) goto L13;
        this.mOnChildAttachStateListeners.get(r4).onChildViewAttachedToWindow(r3);
        r4 = r4 - 1;
        goto L9
    L13:
        return;
    }

    public void dispatchChildDetached(View r3) {
        ViewHolder r0 = getChildViewHolderInt(r3);
        onChildDetachedFromWindow(r3);
        Adapter r1 = this.mAdapter;
        if (r1 == null) goto L6;
        if (r0 == null) goto L6;
        r1.onViewDetachedFromWindow(r0);
    L6:
        List<OnChildAttachStateChangeListener> r2 = this.mOnChildAttachStateListeners;
        if (r2 == null) goto L11;
        int r4 = r2.size() - 1;
    L9:
        if (r4 < 0) goto L13;
        this.mOnChildAttachStateListeners.get(r4).onChildViewDetachedFromWindow(r3);
        r4 = r4 - 1;
        goto L9
    L13:
        return;
    }

    public void dispatchLayout() {
        if (this.mAdapter != null) goto L7;
        Log.e(TAG, "No adapter attached; skipping layout");
        return;
    L7:
        if (this.mLayout != null) goto L10;
        Log.e(TAG, "No layout manager attached; skipping layout");
        return;
    L10:
        State r0 = this.mState;
        r0.mIsMeasuring = false;
        if (r0.mLayoutStep != 1) goto L14;
        dispatchLayoutStep1();
        this.mLayout.setExactMeasureSpecsFrom(this);
        dispatchLayoutStep2();
    L22:
        dispatchLayoutStep3();
        return;
    L14:
        if (this.mAdapterHelper.hasUpdates() == false) goto L16;
    L21:
        this.mLayout.setExactMeasureSpecsFrom(this);
        dispatchLayoutStep2();
        goto L22
    L16:
        if (this.mLayout.getWidth() != getWidth()) goto L21;
        if (this.mLayout.getHeight() != getHeight()) goto L21;
        this.mLayout.setExactMeasureSpecsFrom(this);
        goto L22
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r1, float r2, boolean r3) {
        return getScrollingChildHelper().dispatchNestedFling(r1, r2, r3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r1, float r2) {
        return getScrollingChildHelper().dispatchNestedPreFling(r1, r2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r1, int r2, int[] r3, int[] r4) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r1, r2, r3, r4);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return getScrollingChildHelper().dispatchNestedScroll(r7, r8, r9, r10, r11);
    }

    public void dispatchOnScrollStateChanged(int r3) {
        LayoutManager r0 = this.mLayout;
        if (r0 == null) goto L5;
        r0.onScrollStateChanged(r3);
    L5:
        onScrollStateChanged(r3);
        OnScrollListener r1 = this.mScrollListener;
        if (r1 == null) goto L8;
        r1.onScrollStateChanged(this, r3);
    L8:
        List<OnScrollListener> r2 = this.mScrollListeners;
        if (r2 == null) goto L13;
        int r4 = r2.size() - 1;
    L11:
        if (r4 < 0) goto L15;
        this.mScrollListeners.get(r4).onScrollStateChanged(this, r3);
        r4 = r4 - 1;
        goto L11
    L15:
        return;
    }

    public void dispatchOnScrolled(int r5, int r6) {
        this.mDispatchScrollCounter++;
        int r0 = getScrollX();
        int r1 = getScrollY();
        onScrollChanged(r0, r1, r0 - r5, r1 - r6);
        onScrolled(r5, r6);
        OnScrollListener r2 = this.mScrollListener;
        if (r2 == null) goto L5;
        r2.onScrolled(this, r5, r6);
    L5:
        List<OnScrollListener> r3 = this.mScrollListeners;
        if (r3 == null) goto L10;
        int r4 = r3.size() - 1;
    L8:
        if (r4 < 0) goto L10;
        this.mScrollListeners.get(r4).onScrolled(this, r5, r6);
        r4 = r4 - 1;
    L10:
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int r0 = this.mPendingAccessibilityImportanceChange.size() - 1;
    L3:
        if (r0 < 0) goto L13;
        ViewHolder r1 = this.mPendingAccessibilityImportanceChange.get(r0);
        if (r1.itemView.getParent() != this) goto L12;
        if (r1.shouldIgnore() == true) goto L12;
        int r2 = r1.mPendingAccessibilityState;
        if (r2 == (-1)) goto L12;
        ViewCompat.setImportantForAccessibility(r1.itemView, r2);
        r1.mPendingAccessibilityState = -1;
    L12:
        r0 = r0 - 1;
        goto L3
    L13:
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r1) {
        onPopulateAccessibilityEvent(r1);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> r1) {
        dispatchThawSelfOnly(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> r1) {
        dispatchFreezeSelfOnly(r1);
    }

    @Override // android.view.View
    public void draw(Canvas r8) {
        super.draw(r8);
        int r0 = this.mItemDecorations.size();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        this.mItemDecorations.get(r2).onDrawOver(r8, this, this.mState);
        r2 = r2 + 1;
        goto L3
    L5:
        EdgeEffect r3 = this.mLeftGlow;
        boolean r4 = true;
        if (r3 != null) goto L8;
    L20:
        boolean r5 = false;
    L21:
        EdgeEffect r6 = this.mTopGlow;
        if (r6 != null) goto L24;
    L35:
        EdgeEffect r7 = this.mRightGlow;
        if (r7 != null) goto L38;
    L50:
        EdgeEffect r9 = this.mBottomGlow;
        if (r9 != null) goto L53;
    L64:
        if (r5 == false) goto L66;
    L72:
        r4 = r5;
    L73:
        if (r4 == false) goto L77;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L77:
        return;
    L66:
        if (this.mItemAnimator == null) goto L72;
        if (this.mItemDecorations.size() <= 0) goto L72;
        if (this.mItemAnimator.isRunning() == false) goto L72;
    L53:
        if (r9.isFinished() == true) goto L64;
        int r10 = r8.save();
        r8.rotate(180.0f);
        if (this.mClipToPadding == false) goto L57;
        r8.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
    L58:
        EdgeEffect r11 = this.mBottomGlow;
        if (r11 != null) goto L61;
    L63:
        r5 = r5 | r1;
        r8.restoreToCount(r10);
        goto L64
    L61:
        if (r11.draw(r8) == false) goto L63;
        r1 = true;
        goto L63
    L57:
        r8.translate(-getWidth(), -getHeight());
        goto L58
    L38:
        if (r7.isFinished() == true) goto L50;
        int r12 = r8.save();
        int r13 = getWidth();
        if (this.mClipToPadding == false) goto L42;
        int r14 = getPaddingTop();
    L43:
        r8.rotate(90.0f);
        r8.translate(-r14, -r13);
        EdgeEffect r15 = this.mRightGlow;
        if (r15 != null) goto L46;
    L48:
        boolean r16 = false;
    L49:
        r5 = r5 | r16;
        r8.restoreToCount(r12);
        goto L50
    L46:
        if (r15.draw(r8) == false) goto L48;
        r16 = true;
        goto L49
    L42:
        r14 = 0;
        goto L43
    L24:
        if (r6.isFinished() == true) goto L35;
        int r17 = r8.save();
        if (this.mClipToPadding == false) goto L28;
        r8.translate(getPaddingLeft(), getPaddingTop());
    L28:
        EdgeEffect r18 = this.mTopGlow;
        if (r18 != null) goto L31;
    L33:
        boolean r19 = false;
    L34:
        r5 = r5 | r19;
        r8.restoreToCount(r17);
        goto L35
    L31:
        if (r18.draw(r8) == false) goto L33;
        r19 = true;
        goto L34
    L8:
        if (r3.isFinished() == true) goto L20;
        int r20 = r8.save();
        if (this.mClipToPadding == false) goto L12;
        int r21 = getPaddingBottom();
    L13:
        r8.rotate(270.0f);
        r8.translate((-getHeight()) + r21, 0.0f);
        EdgeEffect r22 = this.mLeftGlow;
        if (r22 != null) goto L16;
    L18:
        r5 = false;
    L19:
        r8.restoreToCount(r20);
        goto L21
    L16:
        if (r22.draw(r8) == false) goto L18;
        r5 = true;
        goto L19
    L12:
        r21 = 0;
        goto L13
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r1, View r2, long r3) {
        return super.drawChild(r1, r2, r3);
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow == null) goto L5;
        return;
    L5:
        EdgeEffect r0 = this.mEdgeEffectFactory.createEdgeEffect(this, 3);
        this.mBottomGlow = r0;
        if (this.mClipToPadding == false) goto L8;
        r0.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        return;
    L8:
        r0.setSize(getMeasuredWidth(), getMeasuredHeight());
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow == null) goto L5;
        return;
    L5:
        EdgeEffect r0 = this.mEdgeEffectFactory.createEdgeEffect(this, 0);
        this.mLeftGlow = r0;
        if (this.mClipToPadding == false) goto L8;
        r0.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        return;
    L8:
        r0.setSize(getMeasuredHeight(), getMeasuredWidth());
    }

    public void ensureRightGlow() {
        if (this.mRightGlow == null) goto L5;
        return;
    L5:
        EdgeEffect r0 = this.mEdgeEffectFactory.createEdgeEffect(this, 2);
        this.mRightGlow = r0;
        if (this.mClipToPadding == false) goto L8;
        r0.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        return;
    L8:
        r0.setSize(getMeasuredHeight(), getMeasuredWidth());
    }

    public void ensureTopGlow() {
        if (this.mTopGlow == null) goto L5;
        return;
    L5:
        EdgeEffect r0 = this.mEdgeEffectFactory.createEdgeEffect(this, 1);
        this.mTopGlow = r0;
        if (this.mClipToPadding == false) goto L8;
        r0.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        return;
    L8:
        r0.setSize(getMeasuredWidth(), getMeasuredHeight());
    }

    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final void fillRemainingScrollValues(State r3) {
        if (getScrollState() != 2) goto L5;
        OverScroller r2 = this.mViewFlinger.mOverScroller;
        r3.mRemainingScrollHorizontal = r2.getFinalX() - r2.getCurrX();
        r3.mRemainingScrollVertical = r2.getFinalY() - r2.getCurrY();
        return;
    L5:
        r3.mRemainingScrollHorizontal = 0;
        r3.mRemainingScrollVertical = 0;
    }

    @Nullable
    public View findChildViewUnder(float r6, float r7) {
        int r0 = this.mChildHelper.getChildCount() - 1;
    L3:
        if (r0 < 0) goto L14;
        View r1 = this.mChildHelper.getChildAt(r0);
        float r2 = r1.getTranslationX();
        float r3 = r1.getTranslationY();
        if (r6 < (r1.getLeft() + r2)) goto L13;
        if (r6 > (r1.getRight() + r2)) goto L13;
        if (r7 < (r1.getTop() + r3)) goto L13;
        if (r7 > (r1.getBottom() + r3)) goto L13;
        return r1;
    L13:
        r0 = r0 - 1;
        goto L3
    L14:
        return null;
    }

    @Nullable
    public View findContainingItemView(@NonNull View r3) {
        ViewParent r0 = r3.getParent();
    L3:
        if (r0 == null) goto L8;
        if (r0 == this) goto L8;
        if ((r0 instanceof View) == false) goto L8;
        r3 = r0;
        r0 = r3.getParent();
    L8:
        if (r0 == this) goto L15;
        return null;
    L15:
        return r3;
    }

    @Nullable
    public ViewHolder findContainingViewHolder(@NonNull View r1) {
        View r2 = findContainingItemView(r1);
        if (r2 != null) goto L6;
        return null;
    L6:
        return getChildViewHolder(r2);
    }

    @Nullable
    public ViewHolder findViewHolderForAdapterPosition(int r6) {
        ViewHolder r1 = null;
        if (this.mDataSetHasChangedAfterLayout == false) goto L5;
        return null;
    L5:
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L18;
        ViewHolder r3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r2));
        if (r3 == null) goto L17;
        if (r3.isRemoved() == true) goto L17;
        if (getAdapterPositionFor(r3) != r6) goto L17;
        if (this.mChildHelper.isHidden(r3.itemView) == false) goto L16;
        r1 = r3;
        goto L17
    L16:
        return r3;
    L17:
        r2 = r2 + 1;
        goto L6
    L18:
        return r1;
    }

    public ViewHolder findViewHolderForItemId(long r7) {
        Adapter r0 = this.mAdapter;
        ViewHolder r1 = null;
        if (r0 != null) goto L5;
    L20:
        return r1;
    L5:
        if (r0.hasStableIds() == false) goto L20;
        int r2 = this.mChildHelper.getUnfilteredChildCount();
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L20;
        ViewHolder r4 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r3));
        if (r4 == null) goto L19;
        if (r4.isRemoved() == true) goto L19;
        if (r4.getItemId() != r7) goto L19;
        if (this.mChildHelper.isHidden(r4.itemView) == false) goto L18;
        r1 = r4;
        goto L19
    L18:
        return r4;
    L19:
        r3 = r3 + 1;
        goto L8
    }

    @Nullable
    public ViewHolder findViewHolderForLayoutPosition(int r2) {
        return findViewHolderForPosition(r2, false);
    }

    @Nullable
    @Deprecated
    public ViewHolder findViewHolderForPosition(int r2) {
        return findViewHolderForPosition(r2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean fling(int r8, int r9) {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L7;
        Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return false;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return false;
    L9:
        int r1 = r0.canScrollHorizontally();
        boolean r2 = this.mLayout.canScrollVertically();
        if (r1 != 0) goto L12;
    L13:
        r8 = 0;
    L14:
        if (r2 == true) goto L16;
    L17:
        r9 = 0;
    L18:
        if (r8 != 0) goto L21;
        if (r9 != 0) goto L21;
        return false;
    L21:
        float r3 = r8;
        float r4 = r9;
        if (dispatchNestedPreFling(r3, r4) == false) goto L24;
    L39:
        return false;
    L24:
        if (r1 != 0) goto L28;
        if (r2 == true) goto L28;
        boolean r6 = false;
    L29:
        dispatchNestedFling(r3, r4, r6);
        OnFlingListener r5 = this.mOnFlingListener;
        if (r5 != null) goto L32;
    L34:
        if (r6 == false) goto L39;
        if (r2 == false) goto L37;
        r1 = (r1 == true ? 1 : 0) | 2;
    L37:
        startNestedScroll(r1, 1);
        int r7 = this.mMaxFlingVelocity;
        int r10 = Math.max(-r7, Math.min(r8, r7));
        int r11 = this.mMaxFlingVelocity;
        this.mViewFlinger.fling(r10, Math.max(-r11, Math.min(r9, r11)));
        return true;
    L32:
        if (r5.onFling(r8, r9) == false) goto L34;
        return true;
    L28:
        r6 = true;
        goto L29
    L16:
        if (Math.abs(r9) >= this.mMinFlingVelocity) goto L18;
    L12:
        if (Math.abs(r8) >= this.mMinFlingVelocity) goto L14;
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View r9, int r10) {
        View r0 = this.mLayout.onInterceptFocusSearch(r9, r10);
        if (r0 == null) goto L5;
        return r0;
    L5:
        boolean r1 = true;
        if (this.mAdapter != null) goto L8;
    L14:
        boolean r2 = false;
    L15:
        FocusFinder r3 = FocusFinder.getInstance();
        if (r2 == true) goto L18;
    L61:
        View r4 = r3.findNextFocus(this, r9, r10);
        if (r4 != null) goto L68;
        if (r2 == false) goto L68;
        consumePendingUpdateOperations();
        if (findContainingItemView(r9) != null) goto L67;
        return null;
    L67:
        startInterceptRequestLayout();
        View r5 = this.mLayout.onFocusSearchFailed(r9, r10, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
    L69:
        if (r5 == null) goto L79;
        if (r5.hasFocusable() == true) goto L79;
        if (getFocusedChild() == null) goto L75;
        requestChildOnScreen(r5, null);
        return r9;
    L75:
        return super.focusSearch(r9, r10);
    L79:
        if (isPreferredNextFocus(r9, r5, r10) == false) goto L82;
        return r5;
    L82:
        return super.focusSearch(r9, r10);
    L68:
        r5 = r4;
        goto L69
    L18:
        if (r10 == 2) goto L21;
        if (r10 != 1) goto L61;
    L21:
        if (this.mLayout.canScrollVertically() == false) goto L32;
        if (r10 != 2) goto L24;
        int r6 = 130;
    L26:
        if (r3.findNextFocus(this, r9, r6) != null) goto L28;
        boolean r7 = true;
    L30:
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION == false) goto L33;
        r10 = r6;
    L33:
        if (r7 == false) goto L35;
    L55:
        if (r7 == false) goto L60;
        consumePendingUpdateOperations();
        if (findContainingItemView(r9) != null) goto L59;
        return null;
    L59:
        startInterceptRequestLayout();
        this.mLayout.onFocusSearchFailed(r9, r10, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
    L60:
        r5 = r3.findNextFocus(this, r9, r10);
        goto L69
    L35:
        if (this.mLayout.canScrollHorizontally() == false) goto L55;
        if (this.mLayout.getLayoutDirection() != 1) goto L39;
        boolean r8 = true;
    L40:
        if (r10 != 2) goto L42;
        boolean r11 = true;
    L44:
        if ((r8 ^ r11) == false) goto L46;
        int r12 = 66;
    L48:
        if (r3.findNextFocus(this, r9, r12) == null) goto L52;
        r1 = false;
    L52:
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION == false) goto L54;
        r10 = r12;
    L54:
        r7 = r1;
        goto L55
    L46:
        r12 = 17;
        goto L48
    L42:
        r11 = false;
        goto L44
    L39:
        r8 = false;
        goto L40
    L28:
        r7 = false;
        goto L30
    L24:
        r6 = 33;
        goto L26
    L32:
        r7 = false;
        goto L33
    L8:
        if (this.mLayout == null) goto L14;
        if (isComputingLayout() == true) goto L14;
        if (this.mLayoutSuppressed == true) goto L14;
        r2 = true;
        goto L15
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager r0 = this.mLayout;
        if (r0 == null) goto L7;
        return r0.generateDefaultLayoutParams();
    L7:
        throw new IllegalStateException(a.g(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        LayoutManager r0 = this.mLayout;
        if (r0 == null) goto L7;
        return r0.generateLayoutParams(getContext(), r3);
    L7:
        throw new IllegalStateException(a.g(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @Nullable
    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionFor(ViewHolder r2) {
        if (r2.hasAnyOfTheFlags(524) == false) goto L5;
        return -1;
    L5:
        if (r2.isBound() == true) goto L8;
        return -1;
    L8:
        return this.mAdapterHelper.applyPendingUpdatesToPosition(r2.mPosition);
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager r0 = this.mLayout;
        if (r0 == null) goto L7;
        return r0.getBaseline();
    L7:
        return super.getBaseline();
    }

    public long getChangedHolderKey(ViewHolder r1) {
        if (this.mAdapter.hasStableIds() == false) goto L6;
        return r1.getItemId();
    L6:
        return r1.mPosition;
    }

    public int getChildAdapterPosition(@NonNull View r1) {
        ViewHolder r0 = getChildViewHolderInt(r1);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getAdapterPosition();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r2, int r3) {
        ChildDrawingOrderCallback r0 = this.mChildDrawingOrderCallback;
        if (r0 != null) goto L7;
        return super.getChildDrawingOrder(r2, r3);
    L7:
        return r0.onGetChildDrawingOrder(r2, r3);
    }

    public long getChildItemId(@NonNull View r3) {
        Adapter r2 = this.mAdapter;
        if (r2 != null) goto L5;
        return -1;
    L5:
        if (r2.hasStableIds() == false) goto L13;
        ViewHolder r4 = getChildViewHolderInt(r3);
        if (r4 != null) goto L10;
        return -1;
    L10:
        return r4.getItemId();
    L13:
        return -1;
    }

    public int getChildLayoutPosition(@NonNull View r1) {
        ViewHolder r0 = getChildViewHolderInt(r1);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getLayoutPosition();
    }

    @Deprecated
    public int getChildPosition(@NonNull View r1) {
        return getChildAdapterPosition(r1);
    }

    public ViewHolder getChildViewHolder(@NonNull View r4) {
        ViewParent r0 = r4.getParent();
        if (r0 == null) goto L9;
        if (r0 == this) goto L9;
        throw new IllegalArgumentException("View " + r4 + " is not a direct child of " + this);
    L9:
        return getChildViewHolderInt(r4);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    @Nullable
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(@NonNull View r1, @NonNull Rect r2) {
        getDecoratedBoundsWithMarginsInt(r1, r2);
    }

    @NonNull
    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Nullable
    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View r9) {
        LayoutParams r0 = (LayoutParams) r9.getLayoutParams();
        if (r0.mInsetsDirty == true) goto L7;
        return r0.mDecorInsets;
    L7:
        if (this.mState.isPreLayout() == true) goto L9;
    L14:
        Rect r1 = r0.mDecorInsets;
        r1.set(0, 0, 0, 0);
        int r3 = this.mItemDecorations.size();
        int r4 = 0;
    L15:
        if (r4 >= r3) goto L17;
        this.mTempRect.set(0, 0, 0, 0);
        this.mItemDecorations.get(r4).getItemOffsets(this.mTempRect, r9, this, this.mState);
        int r5 = r1.left;
        Rect r6 = this.mTempRect;
        r1.left = r5 + r6.left;
        r1.top += r6.top;
        r1.right += r6.right;
        r1.bottom += r6.bottom;
        r4 = r4 + 1;
        goto L15
    L17:
        r0.mInsetsDirty = false;
        return r1;
    L9:
        if (r0.isItemChanged() == true) goto L13;
        if (r0.isViewInvalid() == false) goto L14;
    L13:
        return r0.mDecorInsets;
    }

    @NonNull
    public ItemDecoration getItemDecorationAt(int r3) {
        int r0 = getItemDecorationCount();
        if (r3 < 0) goto L8;
        if (r3 >= r0) goto L8;
        return this.mItemDecorations.get(r3);
    L8:
        throw new IndexOutOfBoundsException(r3 + " is an invalid index for size " + r0);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    @Nullable
    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK == true) goto L5;
        return 0;
    L5:
        return System.nanoTime();
    }

    @Nullable
    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    @NonNull
    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean hasPendingAdapterUpdates() {
        if (this.mFirstLayoutComplete == true) goto L5;
    L10:
        return true;
    L5:
        if (this.mDataSetHasChangedAfterLayout == true) goto L10;
        if (this.mAdapterHelper.hasPendingUpdates() == true) goto L10;
        return false;
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new AnonymousClass6(this));
    }

    @VisibleForTesting
    public void initFastScroller(StateListDrawable r11, Drawable r12, StateListDrawable r13, Drawable r14) {
        if (r11 == null) goto L9;
        if (r12 == null) goto L9;
        if (r13 == null) goto L9;
        if (r14 == null) goto L9;
        Resources r0 = getContext().getResources();
        new FastScroller(this, r11, r12, r13, r14, r0.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), r0.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), r0.getDimensionPixelOffset(R.dimen.fastscroll_margin));
        return;
    L9:
        throw new IllegalArgumentException(a.g(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) goto L5;
        return;
    L5:
        LayoutManager r0 = this.mLayout;
        if (r0 == null) goto L8;
        r0.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
    L8:
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager r0 = this.mAccessibilityManager;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEnabled() == false) goto L7;
        return true;
    }

    public boolean isAnimating() {
        ItemAnimator r0 = this.mItemAnimator;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isRunning() == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        if (this.mLayoutOrScrollCounter <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    public void jumpToPositionForSmoothScroller(int r2) {
        if (this.mLayout != null) goto L5;
        return;
    L5:
        setScrollState(2);
        this.mLayout.scrollToPosition(r2);
        awakenScrollBars();
    }

    public void markItemDecorInsetsDirty() {
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(r1).getLayoutParams()).mInsetsDirty = true;
        r1 = r1 + 1;
        goto L3
    L5:
        this.mRecycler.markItemDecorInsetsDirty();
    }

    public void markKnownViewsInvalid() {
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        ViewHolder r2 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r1));
        if (r2 == null) goto L9;
        if (r2.shouldIgnore() == true) goto L9;
        r2.addFlags(6);
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        markItemDecorInsetsDirty();
        this.mRecycler.markKnownViewsInvalid();
    }

    public void offsetChildrenHorizontal(@Px int r4) {
        int r0 = this.mChildHelper.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mChildHelper.getChildAt(r1).offsetLeftAndRight(r4);
        r1 = r1 + 1;
        goto L3
    }

    public void offsetChildrenVertical(@Px int r4) {
        int r0 = this.mChildHelper.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mChildHelper.getChildAt(r1).offsetTopAndBottom(r4);
        r1 = r1 + 1;
        goto L3
    }

    public void offsetPositionRecordsForInsert(int r6, int r7) {
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        ViewHolder r3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r2));
        if (r3 == null) goto L11;
        if (r3.shouldIgnore() == true) goto L11;
        if (r3.mPosition < r6) goto L11;
        r3.offsetPosition(r7, false);
        this.mState.mStructureChanged = true;
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        this.mRecycler.offsetPositionRecordsForInsert(r6, r7);
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int r10, int r11) {
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        if (r10 >= r11) goto L5;
        int r2 = -1;
        int r3 = r10;
        int r4 = r11;
    L6:
        int r6 = 0;
    L7:
        if (r6 >= r0) goto L19;
        ViewHolder r7 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r6));
        if (r7 == null) goto L18;
        int r8 = r7.mPosition;
        if (r8 < r3) goto L18;
        if (r8 > r4) goto L18;
        if (r8 != r10) goto L16;
        r7.offsetPosition(r11 - r10, false);
    L17:
        this.mState.mStructureChanged = true;
        goto L18
    L16:
        r7.offsetPosition(r2, false);
    L18:
        r6 = r6 + 1;
        goto L7
    L19:
        this.mRecycler.offsetPositionRecordsForMove(r10, r11);
        requestLayout();
        return;
    L5:
        r4 = r10;
        r3 = r11;
        r2 = 1;
        goto L6
    }

    public void offsetPositionRecordsForRemove(int r8, int r9, boolean r10) {
        int r0 = r8 + r9;
        int r1 = this.mChildHelper.getUnfilteredChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L14;
        ViewHolder r3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r2));
        if (r3 == null) goto L13;
        if (r3.shouldIgnore() == true) goto L13;
        int r4 = r3.mPosition;
        if (r4 < r0) goto L11;
        r3.offsetPosition(-r9, r10);
        this.mState.mStructureChanged = true;
        goto L13
    L11:
        if (r4 < r8) goto L13;
        r3.flagRemovedAndOffsetPosition(r8 - 1, -r9, r10);
        this.mState.mStructureChanged = true;
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        this.mRecycler.offsetPositionRecordsForRemove(r8, r9, r10);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean r1 = true;
        this.mIsAttached = true;
        if (this.mFirstLayoutComplete == true) goto L5;
    L7:
        r1 = false;
    L8:
        this.mFirstLayoutComplete = r1;
        LayoutManager r2 = this.mLayout;
        if (r2 == null) goto L11;
        r2.dispatchAttachedToWindow(this);
    L11:
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK == false) goto L25;
        ThreadLocal<GapWorker> r0 = GapWorker.sGapWorker;
        GapWorker r3 = r0.get();
        this.mGapWorker = r3;
        if (r3 != null) goto L23;
        this.mGapWorker = new GapWorker();
        Display r4 = ViewCompat.getDisplay(this);
        if (isInEditMode() == true) goto L21;
        if (r4 == null) goto L21;
        float r5 = r4.getRefreshRate();
        if (r5 < 30.0f) goto L21;
    L22:
        GapWorker r6 = this.mGapWorker;
        r6.mFrameIntervalNs = (long) (1.0E9f / r5);
        r0.set(r6);
    L21:
        r5 = 60.0f;
    L23:
        this.mGapWorker.add(this);
        return;
    L25:
        return;
    L5:
        if (isLayoutRequested() == true) goto L7;
        goto L7
    }

    public void onChildAttachedToWindow(@NonNull View r1) {
    }

    public void onChildDetachedFromWindow(@NonNull View r1) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ItemAnimator r0 = this.mItemAnimator;
        if (r0 == null) goto L5;
        r0.endAnimations();
    L5:
        stopScroll();
        this.mIsAttached = false;
        LayoutManager r1 = this.mLayout;
        if (r1 == null) goto L8;
        r1.dispatchDetachedFromWindow(this, this.mRecycler);
    L8:
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.onDetach();
        if (ALLOW_THREAD_GAP_WORK == false) goto L14;
        GapWorker r2 = this.mGapWorker;
        if (r2 == null) goto L15;
        r2.remove(this);
        this.mGapWorker = null;
        return;
    L15:
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        super.onDraw(r5);
        int r0 = this.mItemDecorations.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mItemDecorations.get(r1).onDraw(r5, this, this.mState);
        r1 = r1 + 1;
        goto L3
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent r6) {
        if (this.mLayout != null) goto L6;
        return false;
    L6:
        if (this.mLayoutSuppressed == false) goto L9;
        return false;
    L9:
        if (r6.getAction() == 8) goto L11;
    L34:
        return false;
    L11:
        if ((r6.getSource() & 2) == 0) goto L21;
        if (this.mLayout.canScrollVertically() == false) goto L15;
        float r0 = -r6.getAxisValue(9);
    L17:
        if (this.mLayout.canScrollHorizontally() == false) goto L19;
        float r3 = r6.getAxisValue(10);
    L30:
        if (r0 == 0.0f) goto L32;
    L33:
        scrollByInternal((int) (r3 * this.mScaledHorizontalScrollFactor), (int) (r0 * this.mScaledVerticalScrollFactor), r6);
        goto L34
    L32:
        if (r3 == 0.0f) goto L34;
    L19:
        r3 = 0.0f;
        goto L30
    L15:
        r0 = 0.0f;
        goto L17
    L21:
        if ((r6.getSource() & 4194304) == 0) goto L28;
        float r1 = r6.getAxisValue(26);
        if (this.mLayout.canScrollVertically() == false) goto L26;
        r0 = -r1;
        goto L19
    L26:
        if (this.mLayout.canScrollHorizontally() == false) goto L28;
        r3 = r1;
        r0 = 0.0f;
    L28:
        r0 = 0.0f;
        r3 = 0.0f;
        goto L30
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r9) {
        if (this.mLayoutSuppressed == false) goto L5;
        return false;
    L5:
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(r9) == false) goto L9;
        cancelScroll();
        return true;
    L9:
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L12;
        return false;
    L12:
        boolean r1 = r0.canScrollHorizontally();
        boolean r3 = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker != null) goto L15;
        this.mVelocityTracker = VelocityTracker.obtain();
    L15:
        this.mVelocityTracker.addMovement(r9);
        int r4 = r9.getActionMasked();
        int r5 = r9.getActionIndex();
        if (r4 == 0) goto L49;
        if (r4 == 1) goto L47;
        if (r4 != 2) goto L20;
        int r6 = r9.findPointerIndex(this.mScrollPointerId);
        if (r6 >= 0) goto L33;
        Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
    L33:
        int r7 = (int) (r9.getX(r6) + 0.5f);
        int r10 = (int) (r9.getY(r6) + 0.5f);
        if (this.mScrollState == 1) goto L59;
        int r8 = r7 - this.mInitialTouchX;
        int r11 = r10 - this.mInitialTouchY;
        if (r1 == true) goto L38;
    L40:
        boolean r2 = false;
    L41:
        if (r3 == true) goto L43;
    L45:
        if (r2 == false) goto L59;
        setScrollState(1);
        goto L59
    L43:
        if (Math.abs(r11) <= this.mTouchSlop) goto L45;
        this.mLastTouchY = r10;
        r2 = true;
        goto L45
    L38:
        if (Math.abs(r8) <= this.mTouchSlop) goto L40;
        this.mLastTouchX = r7;
        r2 = true;
    L59:
        if (this.mScrollState == 1) goto L61;
        return false;
    L61:
        return true;
    L20:
        if (r4 != 3) goto L22;
        cancelScroll();
        goto L59
    L22:
        if (r4 != 5) goto L24;
        this.mScrollPointerId = r9.getPointerId(r5);
        int r12 = (int) (r9.getX(r5) + 0.5f);
        this.mLastTouchX = r12;
        this.mInitialTouchX = r12;
        int r13 = (int) (r9.getY(r5) + 0.5f);
        this.mLastTouchY = r13;
        this.mInitialTouchY = r13;
        goto L59
    L24:
        if (r4 != 6) goto L59;
        onPointerUp(r9);
        goto L59
    L47:
        this.mVelocityTracker.clear();
        stopNestedScroll(0);
        goto L59
    L49:
        if (this.mIgnoreMotionEventTillDown == false) goto L51;
        this.mIgnoreMotionEventTillDown = false;
    L51:
        this.mScrollPointerId = r9.getPointerId(0);
        int r14 = (int) (r9.getX() + 0.5f);
        this.mLastTouchX = r14;
        this.mInitialTouchX = r14;
        int r15 = (int) (r9.getY() + 0.5f);
        this.mLastTouchY = r15;
        this.mInitialTouchY = r15;
        if (this.mScrollState != 2) goto L54;
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
        stopNestedScroll(1);
    L54:
        int[] r16 = this.mNestedOffsets;
        r16[1] = 0;
        r16[0] = 0;
        int r17 = r1;
        if (r3 == false) goto L57;
        r17 = (r1 ? 1 : 0) | 2;
    L57:
        startNestedScroll(r17, 0);
        goto L59
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        TraceCompat.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public void onMeasure(int r7, int r8) {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L7;
        defaultOnMeasure(r7, r8);
        return;
    L7:
        if (r0.isAutoMeasureEnabled() == false) goto L22;
        int r1 = View.MeasureSpec.getMode(r7);
        int r2 = View.MeasureSpec.getMode(r8);
        this.mLayout.onMeasure(this.mRecycler, this.mState, r7, r8);
        if (r1 != 1073741824) goto L13;
        if (r2 != 1073741824) goto L13;
        return;
    L13:
        if (this.mAdapter != null) goto L16;
        return;
    L16:
        if (this.mState.mLayoutStep != 1) goto L18;
        dispatchLayoutStep1();
    L18:
        this.mLayout.setMeasureSpecs(r7, r8);
        this.mState.mIsMeasuring = true;
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(r7, r8);
        if (this.mLayout.shouldMeasureTwice() == false) goto L43;
        this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), BasicMeasure.EXACTLY));
        this.mState.mIsMeasuring = true;
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(r7, r8);
        return;
    L43:
        return;
    L22:
        if (this.mHasFixedSize == false) goto L26;
        this.mLayout.onMeasure(this.mRecycler, this.mState, r7, r8);
        return;
    L26:
        if (this.mAdapterUpdateDuringMeasure == false) goto L33;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        onExitLayoutOrScroll();
        State r3 = this.mState;
        if (r3.mRunPredictiveAnimations == false) goto L30;
        r3.mInPreLayout = true;
    L31:
        this.mAdapterUpdateDuringMeasure = false;
        stopInterceptRequestLayout(false);
    L36:
        Adapter r4 = this.mAdapter;
        if (r4 == null) goto L39;
        State r5 = this.mState;
        r5.mItemCount = r4.getItemCount();
    L40:
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, r7, r8);
        stopInterceptRequestLayout(false);
        this.mState.mInPreLayout = false;
        return;
    L39:
        this.mState.mItemCount = 0;
        goto L40
    L30:
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mInPreLayout = false;
        goto L31
    L33:
        if (this.mState.mRunPredictiveAnimations == false) goto L36;
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r2, Rect r3) {
        if (isComputingLayout() == false) goto L7;
        return false;
    L7:
        return super.onRequestFocusInDescendants(r2, r3);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        this.mPendingSavedState = r3;
        super.onRestoreInstanceState(r3.getSuperState());
        LayoutManager r4 = this.mLayout;
        if (r4 == null) goto L12;
        Parcelable r1 = this.mPendingSavedState.mLayoutState;
        if (r1 == null) goto L13;
        r4.onRestoreInstanceState(r1);
        return;
    L13:
        return;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        SavedState r1 = this.mPendingSavedState;
        if (r1 == null) goto L5;
        r0.copyFrom(r1);
    L9:
        return r0;
    L5:
        LayoutManager r2 = this.mLayout;
        if (r2 == null) goto L8;
        r0.mLayoutState = r2.onSaveInstanceState();
        goto L9
    L8:
        r0.mLayoutState = null;
        goto L9
    }

    public void onScrollStateChanged(int r1) {
    }

    public void onScrolled(@Px int r1, @Px int r2) {
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 != r3) goto L5;
        if (r2 != r4) goto L5;
        return;
    L5:
        invalidateGlows();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r18) {
        int r8 = 0;
        if (this.mLayoutSuppressed == false) goto L5;
    L104:
        return false;
    L5:
        if (this.mIgnoreMotionEventTillDown == true) goto L104;
        if (dispatchToOnItemTouchListeners(r18) == false) goto L11;
        cancelScroll();
        return true;
    L11:
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L14;
        return false;
    L14:
        boolean r10 = r0.canScrollHorizontally();
        boolean r11 = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker != null) goto L17;
        this.mVelocityTracker = VelocityTracker.obtain();
    L17:
        int r1 = r18.getActionMasked();
        int r2 = r18.getActionIndex();
        if (r1 != 0) goto L20;
        int[] r3 = this.mNestedOffsets;
        r3[1] = 0;
        r3[0] = 0;
    L20:
        MotionEvent r12 = MotionEvent.obtain(r18);
        int[] r4 = this.mNestedOffsets;
        r12.offsetLocation(r4[0], r4[1]);
        if (r1 == 0) goto L97;
        if (r1 != 1) goto L24;
        this.mVelocityTracker.addMovement(r12);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
        if (r10 == false) goto L85;
        float r5 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
    L86:
        if (r11 == false) goto L88;
        float r6 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
    L90:
        if (r5 != 0.0f) goto L94;
        if (r6 != 0.0f) goto L94;
    L95:
        setScrollState(0);
    L96:
        resetScroll();
    L102:
        r12.recycle();
        return true;
    L94:
        if (fling((int) r5, (int) r6) == true) goto L96;
    L88:
        r6 = 0.0f;
        goto L90
    L85:
        r5 = 0.0f;
        goto L86
    L24:
        if (r1 != 2) goto L26;
        int r7 = r18.findPointerIndex(this.mScrollPointerId);
        if (r7 >= 0) goto L39;
        Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
    L39:
        int r13 = (int) (r18.getX(r7) + 0.5f);
        int r14 = (int) (r18.getY(r7) + 0.5f);
        int r9 = this.mLastTouchX - r13;
        int r15 = this.mLastTouchY - r14;
        if (this.mScrollState == 1) goto L56;
        if (r10 == false) goto L47;
        if (r9 <= 0) goto L44;
        r9 = Math.max(0, r9 - this.mTouchSlop);
    L45:
        if (r9 == 0) goto L47;
        boolean r16 = true;
    L48:
        if (r11 == false) goto L54;
        if (r15 <= 0) goto L51;
        r15 = Math.max(0, r15 - this.mTouchSlop);
    L52:
        if (r15 == 0) goto L54;
        r16 = true;
        goto L54
    L51:
        r15 = Math.min(0, r15 + this.mTouchSlop);
    L54:
        if (r16 == false) goto L56;
        setScrollState(1);
        goto L56
    L44:
        r9 = Math.min(0, r9 + this.mTouchSlop);
    L47:
        r16 = false;
    L56:
        int r17 = r9;
        int r19 = r15;
        if (this.mScrollState != 1) goto L101;
        int[] r20 = this.mReusableIntPair;
        r20[0] = 0;
        r20[1] = 0;
        if (r10 == false) goto L61;
        int r21 = r17;
    L62:
        if (r11 == false) goto L64;
        int r22 = r19;
    L66:
        if (dispatchNestedPreScroll(r21, r22, r20, this.mScrollOffset, 0) == false) goto L68;
        int[] r23 = this.mReusableIntPair;
        r17 = r17 - r23[0];
        r19 = r19 - r23[1];
        int[] r24 = this.mNestedOffsets;
        int r25 = r24[0];
        int[] r26 = this.mScrollOffset;
        r24[0] = r25 + r26[0];
        r24[1] = r24[1] + r26[1];
        getParent().requestDisallowInterceptTouchEvent(true);
    L68:
        int r27 = r19;
        int[] r28 = this.mScrollOffset;
        this.mLastTouchX = r13 - r28[0];
        this.mLastTouchY = r14 - r28[1];
        if (r10 == false) goto L71;
        int r29 = r17;
    L72:
        if (r11 == false) goto L75;
        r8 = r27;
    L75:
        if (scrollByInternal(r29, r8, r18) == false) goto L77;
        getParent().requestDisallowInterceptTouchEvent(true);
    L77:
        GapWorker r30 = this.mGapWorker;
        if (r30 == null) goto L101;
        if (r17 != 0) goto L81;
        if (r27 == 0) goto L101;
    L81:
        r30.postFromTraversal(this, r17, r27);
        goto L101
    L71:
        r29 = 0;
        goto L72
    L64:
        r22 = 0;
        goto L66
    L61:
        r21 = 0;
    L101:
        this.mVelocityTracker.addMovement(r12);
        goto L102
    L26:
        if (r1 != 3) goto L28;
        cancelScroll();
        goto L101
    L28:
        if (r1 != 5) goto L30;
        this.mScrollPointerId = r18.getPointerId(r2);
        int r31 = (int) (r18.getX(r2) + 0.5f);
        this.mLastTouchX = r31;
        this.mInitialTouchX = r31;
        int r32 = (int) (r18.getY(r2) + 0.5f);
        this.mLastTouchY = r32;
        this.mInitialTouchY = r32;
        goto L101
    L30:
        if (r1 != 6) goto L101;
        onPointerUp(r18);
        goto L101
    L97:
        this.mScrollPointerId = r18.getPointerId(0);
        int r33 = (int) (r18.getX() + 0.5f);
        this.mLastTouchX = r33;
        this.mInitialTouchX = r33;
        int r34 = (int) (r18.getY() + 0.5f);
        this.mLastTouchY = r34;
        this.mInitialTouchY = r34;
        int r110 = r10;
        if (r11 == false) goto L100;
        r110 = (r10 ? 1 : 0) | 2;
    L100:
        startNestedScroll(r110, 0);
        goto L101
    }

    public void postAnimationRunner() {
        if (this.mPostedAnimatorRunner == false) goto L5;
        return;
    L5:
        if (this.mIsAttached == false) goto L9;
        ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
        return;
    }

    public void processDataSetCompletelyChanged(boolean r2) {
        this.mDispatchItemsChangedEvent = r2 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(ViewHolder r4, ItemAnimator.ItemHolderInfo r5) {
        r4.setFlags(0, 8192);
        if (this.mState.mTrackOldChangeHolders == true) goto L5;
    L11:
        this.mViewInfoStore.addToPreLayout(r4, r5);
        return;
    L5:
        if (r4.isUpdated() == false) goto L11;
        if (r4.isRemoved() == true) goto L11;
        if (r4.shouldIgnore() == true) goto L11;
        long r0 = getChangedHolderKey(r4);
        this.mViewInfoStore.addToOldChangeHolders(r0, r4);
        goto L11
    }

    public void removeAndRecycleViews() {
        ItemAnimator r0 = this.mItemAnimator;
        if (r0 == null) goto L5;
        r0.endAnimations();
    L5:
        LayoutManager r1 = this.mLayout;
        if (r1 == null) goto L8;
        r1.removeAndRecycleAllViews(this.mRecycler);
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
    L8:
        this.mRecycler.clear();
    }

    public boolean removeAnimatingView(View r3) {
        startInterceptRequestLayout();
        boolean r0 = this.mChildHelper.removeViewIfHidden(r3);
        if (r0 == false) goto L5;
        ViewHolder r4 = getChildViewHolderInt(r3);
        this.mRecycler.unscrapView(r4);
        this.mRecycler.recycleViewHolderInternal(r4);
    L5:
        stopInterceptRequestLayout(!r0);
        return r0;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View r3, boolean r4) {
        ViewHolder r0 = getChildViewHolderInt(r3);
        if (r0 != null) goto L5;
    L12:
        r3.clearAnimation();
        dispatchChildDetached(r3);
        super.removeDetachedView(r3, r4);
        return;
    L5:
        if (r0.isTmpDetached() == false) goto L8;
        r0.clearTmpDetachFlag();
        goto L12
    L8:
        if (r0.shouldIgnore() == true) goto L12;
        StringBuilder r5 = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
        r5.append(r0);
        throw new IllegalArgumentException(a.g(this, r5));
    }

    public void removeItemDecoration(@NonNull ItemDecoration r3) {
        LayoutManager r0 = this.mLayout;
        if (r0 == null) goto L5;
        r0.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
    L5:
        this.mItemDecorations.remove(r3);
        if (this.mItemDecorations.isEmpty() == true) goto L8;
    L12:
        markItemDecorInsetsDirty();
        requestLayout();
        return;
    L8:
        if (getOverScrollMode() != 2) goto L10;
        boolean r4 = true;
    L11:
        setWillNotDraw(r4);
        goto L12
    L10:
        r4 = false;
        goto L11
    }

    public void removeItemDecorationAt(int r3) {
        int r0 = getItemDecorationCount();
        if (r3 < 0) goto L8;
        if (r3 >= r0) goto L8;
        removeItemDecoration(getItemDecorationAt(r3));
        return;
    L8:
        throw new IndexOutOfBoundsException(r3 + " is an invalid index for size " + r0);
    }

    public void removeOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener r1) {
        List<OnChildAttachStateChangeListener> r0 = this.mOnChildAttachStateListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove(r1);
    }

    public void removeOnItemTouchListener(@NonNull OnItemTouchListener r2) {
        this.mOnItemTouchListeners.remove(r2);
        if (this.mInterceptingOnItemTouchListener != r2) goto L6;
        this.mInterceptingOnItemTouchListener = null;
        return;
    }

    public void removeOnScrollListener(@NonNull OnScrollListener r1) {
        List<OnScrollListener> r0 = this.mScrollListeners;
        if (r0 == null) goto L6;
        r0.remove(r1);
        return;
    }

    public void repositionShadowingViews() {
        int r0 = this.mChildHelper.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        View r2 = this.mChildHelper.getChildAt(r1);
        ViewHolder r3 = getChildViewHolder(r2);
        if (r3 == null) goto L13;
        ViewHolder r4 = r3.mShadowingHolder;
        if (r4 == null) goto L13;
        View r5 = r4.itemView;
        int r6 = r2.getLeft();
        int r7 = r2.getTop();
        if (r6 == r5.getLeft()) goto L11;
    L12:
        r5.layout(r6, r7, r5.getWidth() + r6, r5.getHeight() + r7);
        goto L13
    L11:
        if (r7 != r5.getTop()) goto L12;
    L13:
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r3, View r4) {
        if (this.mLayout.onRequestChildFocus(this, this.mState, r3, r4) == true) goto L6;
        if (r4 == null) goto L6;
        requestChildOnScreen(r3, r4);
    L6:
        super.requestChildFocus(r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View r2, Rect r3, boolean r4) {
        return this.mLayout.requestChildRectangleOnScreen(this, r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r4) {
        int r0 = this.mOnItemTouchListeners.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mOnItemTouchListeners.get(r1).onRequestDisallowInterceptTouchEvent(r4);
        r1 = r1 + 1;
        goto L3
    L5:
        super.requestDisallowInterceptTouchEvent(r4);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth == 0) goto L5;
    L7:
        this.mLayoutWasDefered = true;
        return;
    L5:
        if (this.mLayoutSuppressed == true) goto L7;
        super.requestLayout();
    }

    public void saveOldPositions() {
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        ViewHolder r2 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r1));
        if (r2.shouldIgnore() == true) goto L7;
        r2.saveOldPosition();
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.view.View
    public void scrollBy(int r4, int r5) {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L7;
        Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        boolean r1 = r0.canScrollHorizontally();
        boolean r2 = this.mLayout.canScrollVertically();
        if (r1 == true) goto L13;
        if (r2 == true) goto L13;
        return;
    L13:
        if (r1 == true) goto L16;
        r4 = 0;
    L16:
        if (r2 == true) goto L19;
        r5 = 0;
    L19:
        scrollByInternal(r4, r5, null);
    }

    public boolean scrollByInternal(int r19, int r20, MotionEvent r21) {
        consumePendingUpdateOperations();
        if (this.mAdapter == null) goto L5;
        int[] r0 = this.mReusableIntPair;
        r0[0] = 0;
        r0[1] = 0;
        scrollStep(r19, r20, r0);
        int[] r1 = this.mReusableIntPair;
        int r2 = r1[0];
        int r3 = r1[1];
        int r14 = r3;
        int r15 = r2;
        int r16 = r19 - r2;
        int r17 = r20 - r3;
    L7:
        if (this.mItemDecorations.isEmpty() == true) goto L9;
        invalidate();
    L9:
        int[] r7 = this.mReusableIntPair;
        r7[0] = 0;
        r7[1] = 0;
        dispatchNestedScroll(r15, r14, r16, r17, this.mScrollOffset, 0, r7);
        int[] r4 = this.mReusableIntPair;
        int r5 = r4[0];
        int r6 = r16 - r5;
        int r8 = r4[1];
        int r9 = r17 - r8;
        if (r5 != 0) goto L14;
        if (r8 != 0) goto L14;
        boolean r10 = false;
    L15:
        int r11 = this.mLastTouchX;
        int[] r12 = this.mScrollOffset;
        int r13 = r12[0];
        this.mLastTouchX = r11 - r13;
        int r18 = this.mLastTouchY;
        int r22 = r12[1];
        this.mLastTouchY = r18 - r22;
        int[] r23 = this.mNestedOffsets;
        r23[0] = r23[0] + r13;
        r23[1] = r23[1] + r22;
        if (getOverScrollMode() == 2) goto L22;
        if (r21 != null) goto L19;
    L21:
        considerReleasingGlowsOnScroll(r19, r20);
        goto L22
    L19:
        if (MotionEventCompat.isFromSource(r21, 8194) == true) goto L21;
        pullGlows(r21.getX(), r6, r21.getY(), r9);
    L22:
        if (r15 != 0) goto L24;
        if (r14 != 0) goto L24;
    L26:
        if (awakenScrollBars() == true) goto L28;
        invalidate();
    L28:
        if (r10 == true) goto L34;
        if (r15 != 0) goto L35;
        if (r14 == 0) goto L33;
        return true;
    L33:
        return false;
    L35:
        return true;
    L34:
        return true;
    L24:
        dispatchOnScrolled(r15, r14);
    L14:
        r10 = true;
        goto L15
    L5:
        r14 = 0;
        r15 = 0;
        r16 = 0;
        r17 = 0;
        goto L7
    }

    public void scrollStep(int r5, int r6, @Nullable int[] r7) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        TraceCompat.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        if (r5 == 0) goto L5;
        int r8 = this.mLayout.scrollHorizontallyBy(r5, this.mRecycler, this.mState);
    L6:
        if (r6 == 0) goto L8;
        int r9 = this.mLayout.scrollVerticallyBy(r6, this.mRecycler, this.mState);
    L9:
        TraceCompat.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (r7 == null) goto L13;
        r7[0] = r8;
        r7[1] = r9;
        return;
    L13:
        return;
    L8:
        r9 = 0;
        goto L9
    L5:
        r8 = 0;
        goto L6
    }

    @Override // android.view.View
    public void scrollTo(int r1, int r2) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int r2) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        stopScroll();
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L9;
        Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r0.scrollToPosition(r2);
        awakenScrollBars();
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent r2) {
        if (shouldDeferAccessibilityEvent(r2) == false) goto L5;
        return;
    L5:
        super.sendAccessibilityEventUnchecked(r2);
    }

    public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate r1) {
        this.mAccessibilityDelegate = r1;
        ViewCompat.setAccessibilityDelegate(this, r1);
    }

    public void setAdapter(@Nullable Adapter r3) {
        setLayoutFrozen(false);
        setAdapterInternal(r3, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback r2) {
        if (r2 != this.mChildDrawingOrderCallback) goto L5;
        return;
    L5:
        this.mChildDrawingOrderCallback = r2;
        if (r2 == null) goto L8;
        boolean r3 = true;
    L9:
        setChildrenDrawingOrderEnabled(r3);
        return;
    L8:
        r3 = false;
        goto L9
    }

    @VisibleForTesting
    public boolean setChildImportantForAccessibilityInternal(ViewHolder r2, int r3) {
        if (isComputingLayout() == false) goto L6;
        r2.mPendingAccessibilityState = r3;
        this.mPendingAccessibilityImportanceChange.add(r2);
        return false;
    L6:
        ViewCompat.setImportantForAccessibility(r2.itemView, r3);
        return true;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean r2) {
        if (r2 == this.mClipToPadding) goto L5;
        invalidateGlows();
    L5:
        this.mClipToPadding = r2;
        super.setClipToPadding(r2);
        if (this.mFirstLayoutComplete == false) goto L9;
        requestLayout();
        return;
    }

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory r1) {
        Preconditions.checkNotNull(r1);
        this.mEdgeEffectFactory = r1;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean r1) {
        this.mHasFixedSize = r1;
    }

    public void setItemAnimator(@Nullable ItemAnimator r3) {
        ItemAnimator r0 = this.mItemAnimator;
        if (r0 == null) goto L5;
        r0.endAnimations();
        this.mItemAnimator.setListener(null);
    L5:
        this.mItemAnimator = r3;
        if (r3 == null) goto L9;
        r3.setListener(this.mItemAnimatorListener);
        return;
    }

    public void setItemViewCacheSize(int r1) {
        this.mRecycler.setViewCacheSize(r1);
    }

    @Deprecated
    public void setLayoutFrozen(boolean r1) {
        suppressLayout(r1);
    }

    public void setLayoutManager(@Nullable LayoutManager r3) {
        if (r3 != this.mLayout) goto L5;
        return;
    L5:
        stopScroll();
        if (this.mLayout == null) goto L14;
        ItemAnimator r0 = this.mItemAnimator;
        if (r0 == null) goto L10;
        r0.endAnimations();
    L10:
        this.mLayout.removeAndRecycleAllViews(this.mRecycler);
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        this.mRecycler.clear();
        if (this.mIsAttached == false) goto L13;
        this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
    L13:
        this.mLayout.setRecyclerView(null);
        this.mLayout = null;
    L15:
        this.mChildHelper.removeAllViewsUnfiltered();
        this.mLayout = r3;
        if (r3 != null) goto L18;
    L24:
        this.mRecycler.updateViewCacheSize();
        requestLayout();
        return;
    L18:
        if (r3.mRecyclerView != null) goto L22;
        r3.setRecyclerView(this);
        if (this.mIsAttached == false) goto L24;
        this.mLayout.dispatchAttachedToWindow(this);
        goto L24
    L22:
        StringBuilder r1 = new StringBuilder("LayoutManager ");
        r1.append(r3);
        r1.append(" is already attached to a RecyclerView:");
        throw new IllegalArgumentException(a.g(r3.mRecyclerView, r1));
    L14:
        this.mRecycler.clear();
        goto L15
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition r1) {
        if (r1 != null) goto L6;
        super.setLayoutTransition(null);
        return;
    L6:
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r1) {
        getScrollingChildHelper().setNestedScrollingEnabled(r1);
    }

    public void setOnFlingListener(@Nullable OnFlingListener r1) {
        this.mOnFlingListener = r1;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable OnScrollListener r1) {
        this.mScrollListener = r1;
    }

    public void setPreserveFocusAfterLayout(boolean r1) {
        this.mPreserveFocusAfterLayout = r1;
    }

    public void setRecycledViewPool(@Nullable RecycledViewPool r1) {
        this.mRecycler.setRecycledViewPool(r1);
    }

    public void setRecyclerListener(@Nullable RecyclerListener r1) {
        this.mRecyclerListener = r1;
    }

    public void setScrollState(int r2) {
        if (r2 != this.mScrollState) goto L5;
        return;
    L5:
        this.mScrollState = r2;
        if (r2 == 2) goto L8;
        stopScrollersInternal();
    L8:
        dispatchOnScrollStateChanged(r2);
    }

    public void setScrollingTouchSlop(int r4) {
        ViewConfiguration r0 = ViewConfiguration.get(getContext());
        if (r4 != 0) goto L5;
    L8:
        this.mTouchSlop = r0.getScaledTouchSlop();
        return;
    L5:
        if (r4 == 1) goto L7;
        Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + r4 + "; using default value");
        goto L8
    L7:
        this.mTouchSlop = r0.getScaledPagingTouchSlop();
    }

    public void setViewCacheExtension(@Nullable ViewCacheExtension r1) {
        this.mRecycler.setViewCacheExtension(r1);
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent r3) {
        int r1 = 0;
        if (isComputingLayout() == false) goto L12;
        if (r3 == null) goto L6;
        int r4 = AccessibilityEventCompat.getContentChangeTypes(r3);
    L7:
        if (r4 == 0) goto L10;
        r1 = r4;
    L10:
        this.mEatenAccessibilityChangeFlags |= r1;
        return true;
    L6:
        r4 = 0;
        goto L7
    L12:
        return false;
    }

    public void smoothScrollBy(@Px int r2, @Px int r3) {
        smoothScrollBy(r2, r3, null);
    }

    public void smoothScrollToPosition(int r3) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L9;
        Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r0.smoothScrollToPosition(this, this.mState, r3);
    }

    public void startInterceptRequestLayout() {
        int r0 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = r0;
        if (r0 == 1) goto L5;
        return;
    L5:
        if (this.mLayoutSuppressed == true) goto L9;
        this.mLayoutWasDefered = false;
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r1) {
        return getScrollingChildHelper().startNestedScroll(r1);
    }

    public void stopInterceptRequestLayout(boolean r4) {
        if (this.mInterceptRequestLayoutDepth >= 1) goto L6;
        this.mInterceptRequestLayoutDepth = 1;
    L6:
        if (r4 == true) goto L11;
        if (this.mLayoutSuppressed == true) goto L11;
        this.mLayoutWasDefered = false;
    L11:
        if (this.mInterceptRequestLayoutDepth != 1) goto L25;
        if (r4 == false) goto L23;
        if (this.mLayoutWasDefered == false) goto L23;
        if (this.mLayoutSuppressed == true) goto L23;
        if (this.mLayout == null) goto L23;
        if (this.mAdapter == null) goto L23;
        dispatchLayout();
    L23:
        if (this.mLayoutSuppressed == true) goto L25;
        this.mLayoutWasDefered = false;
    L25:
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean r10) {
        if (r10 == this.mLayoutSuppressed) goto L16;
        assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
        if (r10 == true) goto L14;
        this.mLayoutSuppressed = false;
        if (this.mLayoutWasDefered == true) goto L9;
    L13:
        this.mLayoutWasDefered = false;
        return;
    L9:
        if (this.mLayout == null) goto L13;
        if (this.mAdapter == null) goto L13;
        requestLayout();
        goto L13
    L14:
        long r3 = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(r3, r3, 3, 0.0f, 0.0f, 0));
        this.mLayoutSuppressed = true;
        this.mIgnoreMotionEventTillDown = true;
        stopScroll();
        return;
    }

    public void swapAdapter(@Nullable Adapter r2, boolean r3) {
        setLayoutFrozen(false);
        setAdapterInternal(r2, true, r3);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void viewRangeUpdate(int r7, int r8, Object r9) {
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        int r1 = r7 + r8;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L14;
        View r3 = this.mChildHelper.getUnfilteredChildAt(r2);
        ViewHolder r4 = getChildViewHolderInt(r3);
        if (r4 == null) goto L13;
        if (r4.shouldIgnore() == true) goto L13;
        int r5 = r4.mPosition;
        if (r5 < r7) goto L13;
        if (r5 >= r1) goto L13;
        r4.addFlags(2);
        r4.addChangePayload(r9);
        ((LayoutParams) r3.getLayoutParams()).mInsetsDirty = true;
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        this.mRecycler.viewRangeUpdate(r7, r8);
    }

    public RecyclerView(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.recyclerViewStyle);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10, int r11) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r7, r8, r9, r10, r11);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12, int r13) {
        return getScrollingChildHelper().dispatchNestedScroll(r8, r9, r10, r11, r12, r13);
    }

    @Nullable
    public ViewHolder findViewHolderForPosition(int r6, boolean r7) {
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        ViewHolder r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L20;
        ViewHolder r3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r2));
        if (r3 == null) goto L19;
        if (r3.isRemoved() == true) goto L19;
        if (r7 == false) goto L13;
        if (r3.mPosition != r6) goto L19;
    L16:
        if (this.mChildHelper.isHidden(r3.itemView) == false) goto L18;
        r1 = r3;
        goto L19
    L18:
        return r3;
    L13:
        if (r3.getLayoutPosition() == r6) goto L16;
    L19:
        r2 = r2 + 1;
        goto L3
    L20:
        return r1;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int r1) {
        return getScrollingChildHelper().hasNestedScrollingParent(r1);
    }

    public void onExitLayoutOrScroll(boolean r3) {
        int r0 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = r0;
        if (r0 >= 1) goto L8;
        this.mLayoutOrScrollCounter = 0;
        if (r3 == false) goto L9;
        dispatchContentChangedIfNecessary();
        dispatchPendingImportantForAccessibilityChanges();
        return;
    L9:
        return;
    }

    public void smoothScrollBy(@Px int r2, @Px int r3, @Nullable Interpolator r4) {
        smoothScrollBy(r2, r3, r4, Integer.MIN_VALUE);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int r1, int r2) {
        return getScrollingChildHelper().startNestedScroll(r1, r2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int r1) {
        getScrollingChildHelper().stopNestedScroll(r1);
    }

    public RecyclerView(@NonNull Context r16, @Nullable AttributeSet r17, int r18) {
        super(r16, r17, r18);
        this.mObserver = new RecyclerViewDataObserver(this);
        this.mRecycler = new Recycler(this);
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new AnonymousClass1(this);
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList();
        this.mOnItemTouchListeners = new ArrayList();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new EdgeEffectFactory();
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger(this);
        if (ALLOW_THREAD_GAP_WORK == false) goto L5;
        GapWorker.LayoutPrefetchRegistryImpl r0 = new GapWorker.LayoutPrefetchRegistryImpl();
    L6:
        this.mPrefetchRegistry = r0;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener(this);
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new AnonymousClass2(this);
        this.mViewInfoProcessCallback = new AnonymousClass4(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration r1 = ViewConfiguration.get(r16);
        this.mTouchSlop = r1.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(r1, r16);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(r1, r16);
        this.mMinFlingVelocity = r1.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = r1.getScaledMaximumFlingVelocity();
        if (getOverScrollMode() != 2) goto L9;
        boolean r2 = true;
    L10:
        setWillNotDraw(r2);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L13;
        ViewCompat.setImportantForAccessibility(this, 1);
    L13:
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray r14 = r16.obtainStyledAttributes(r17, R.styleable.RecyclerView, r18, 0);
        saveAttributeDataForStyleable(r16, R.styleable.RecyclerView, r17, r14, r18, 0);
        String r3 = r14.getString(R.styleable.RecyclerView_layoutManager);
        if (r14.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) != (-1)) goto L16;
        setDescendantFocusability(262144);
    L16:
        this.mClipToPadding = r14.getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
        boolean r4 = r14.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = r4;
        if (r4 == false) goto L19;
        initFastScroller((StateListDrawable) r14.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), r14.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) r14.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), r14.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
    L19:
        r14.recycle();
        createLayoutManager(r16, r3, r17, r18, 0);
        int[] r5 = NESTED_SCROLLING_ATTRS;
        TypedArray r12 = r16.obtainStyledAttributes(r17, r5, r18, 0);
        saveAttributeDataForStyleable(r16, r5, r17, r12, r18, 0);
        boolean r6 = r12.getBoolean(0, true);
        r12.recycle();
        setNestedScrollingEnabled(r6);
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int r9, int r10, int r11, int r12, int[] r13, int r14, @NonNull int[] r15) {
        getScrollingChildHelper().dispatchNestedScroll(r9, r10, r11, r12, r13, r14, r15);
    }

    public void smoothScrollBy(@Px int r7, @Px int r8, @Nullable Interpolator r9, int r10) {
        smoothScrollBy(r7, r8, r9, r10, false);
    }

    public void smoothScrollBy(@Px int r3, @Px int r4, @Nullable Interpolator r5, int r6, boolean r7) {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L7;
        Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        int r1 = 0;
        if (r0.canScrollHorizontally() == true) goto L13;
        r3 = 0;
    L13:
        if (this.mLayout.canScrollVertically() == true) goto L15;
        r4 = 0;
    L15:
        if (r3 != 0) goto L18;
        if (r4 != 0) goto L18;
        return;
    L18:
        if (r6 == Integer.MIN_VALUE) goto L22;
        if (r6 > 0) goto L22;
        scrollBy(r3, r4);
        return;
    L22:
        if (r7 == true) goto L24;
    L29:
        this.mViewFlinger.smoothScrollBy(r3, r4, r6, r5);
        return;
    L24:
        if (r3 == 0) goto L26;
        r1 = 1;
    L26:
        if (r4 == 0) goto L28;
        r1 = r1 | 2;
    L28:
        startNestedScroll(r1, 1);
        goto L29
    }

    public void addItemDecoration(@NonNull ItemDecoration r2) {
        addItemDecoration(r2, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r3) {
        LayoutManager r0 = this.mLayout;
        if (r0 == null) goto L7;
        return r0.generateLayoutParams(r3);
    L7:
        throw new IllegalStateException(a.g(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }
}
