package androidx.coordinatorlayout.widget;

import a.a;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.R;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.bytedance.librarian.LibrarianImpl;
import com.google.android.material.badge.BadgeDrawable;
import com.ss.android.common.ApiConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    static final Class<?>[] CONSTRUCTOR_PARAMS = null;
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR = null;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME = null;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors = null;
    private static final Pools.Pool<Rect> sRectPool = null;
    private OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private final int[] mBehaviorConsumed;
    private View mBehaviorTouchView;
    private final DirectedAcyclicGraph<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private WindowInsetsCompat mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private final int[] mNestedScrollingV2ConsumedCompat;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private OnPreDrawListener mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final List<View> mTempList1;

    public interface AttachedBehavior {
        @NonNull
        Behavior getBehavior();
    }

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        @Nullable
        public static Object getTag(@NonNull View r0) {
            return ((LayoutParams) r0.getLayoutParams()).mBehaviorTag;
        }

        public static void setTag(@NonNull View r0, @Nullable Object r1) {
            ((LayoutParams) r0.getLayoutParams()).mBehaviorTag = r1;
        }

        public boolean blocksInteractionBelow(@NonNull CoordinatorLayout r1, @NonNull V r2) {
            if (getScrimOpacity(r1, r2) <= 0.0f) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull Rect r3) {
            return false;
        }

        @ColorInt
        public int getScrimColor(@NonNull CoordinatorLayout r1, @NonNull V r2) {
            return ViewCompat.MEASURED_STATE_MASK;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getScrimOpacity(@NonNull CoordinatorLayout r1, @NonNull V r2) {
            return 0.0f;
        }

        public boolean layoutDependsOn(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3) {
            return false;
        }

        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull WindowInsetsCompat r3) {
            return r3;
        }

        public void onAttachedToLayoutParams(@NonNull LayoutParams r1) {
        }

        public boolean onDependentViewChanged(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3) {
            return false;
        }

        public void onDependentViewRemoved(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull MotionEvent r3) {
            return false;
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout r1, @NonNull V r2, int r3) {
            return false;
        }

        public boolean onMeasureChild(@NonNull CoordinatorLayout r1, @NonNull V r2, int r3, int r4, int r5, int r6) {
            return false;
        }

        public boolean onNestedFling(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3, float r4, float r5, boolean r6) {
            return false;
        }

        public boolean onNestedPreFling(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3, float r4, float r5) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3, int r4, int r5, @NonNull int[] r6) {
        }

        @Deprecated
        public void onNestedScroll(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3, int r4, int r5, int r6, int r7) {
        }

        @Deprecated
        public void onNestedScrollAccepted(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3, @NonNull View r4, int r5) {
        }

        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull Rect r3, boolean r4) {
            return false;
        }

        public void onRestoreInstanceState(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull Parcelable r3) {
        }

        @Nullable
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r1, @NonNull V r2) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3, @NonNull View r4, int r5) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3) {
        }

        public boolean onTouchEvent(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull MotionEvent r3) {
            return false;
        }

        public Behavior(Context r1, AttributeSet r2) {
        }

        public void onNestedPreScroll(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3, int r4, int r5, @NonNull int[] r6, int r7) {
            if (r7 != 0) goto L5;
            onNestedPreScroll(r1, r2, r3, r4, r5, r6);
            return;
        }

        @Deprecated
        public void onNestedScroll(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3, int r4, int r5, int r6, int r7, int r8) {
            if (r8 != 0) goto L5;
            onNestedScroll(r1, r2, r3, r4, r5, r6, r7);
            return;
        }

        public void onNestedScrollAccepted(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3, @NonNull View r4, int r5, int r6) {
            if (r6 != 0) goto L5;
            onNestedScrollAccepted(r1, r2, r3, r4, r5);
            return;
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3, @NonNull View r4, int r5, int r6) {
            if (r6 == 0) goto L4;
            return false;
        L4:
            return onStartNestedScroll(r1, r2, r3, r4, r5);
        }

        public void onStopNestedScroll(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3, int r4) {
            if (r4 != 0) goto L5;
            onStopNestedScroll(r1, r2, r3);
            return;
        }

        public void onNestedScroll(@NonNull CoordinatorLayout r3, @NonNull V r4, @NonNull View r5, int r6, int r7, int r8, int r9, int r10, @NonNull int[] r11) {
            r11[0] = r11[0] + r8;
            r11[1] = r11[1] + r9;
            onNestedScroll(r3, r4, r5, r6, r7, r8, r9, r10);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface DispatchChangeEvent {
    }

    public class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        final /* synthetic */ CoordinatorLayout this$0;

        public HierarchyChangeListener(CoordinatorLayout r1) {
            this.this$0 = r1;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View r1, View r2) {
            ViewGroup.OnHierarchyChangeListener r0 = this.this$0.mOnHierarchyChangeListener;
            if (r0 == null) goto L6;
            r0.onChildViewAdded(r1, r2);
            return;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View r3, View r4) {
            this.this$0.onChildViewsChanged(2);
            ViewGroup.OnHierarchyChangeListener r2 = this.this$0.mOnHierarchyChangeListener;
            if (r2 == null) goto L6;
            r2.onChildViewRemoved(r3, r4);
            return;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int anchorGravity;
        public int dodgeInsetEdges;
        public int gravity;
        public int insetEdge;
        public int keyline;
        View mAnchorDirectChild;
        int mAnchorId;
        View mAnchorView;
        Behavior mBehavior;
        boolean mBehaviorResolved;
        Object mBehaviorTag;
        private boolean mDidAcceptNestedScrollNonTouch;
        private boolean mDidAcceptNestedScrollTouch;
        private boolean mDidBlockInteraction;
        private boolean mDidChangeAfterNestedScroll;
        int mInsetOffsetX;
        int mInsetOffsetY;
        final Rect mLastChildRect;

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        private void resolveAnchorView(View r5, CoordinatorLayout r6) {
            View r0 = r6.findViewById(this.mAnchorId);
            this.mAnchorView = r0;
            if (r0 == null) goto L28;
            if (r0 == r6) goto L6;
            ViewParent r2 = r0.getParent();
        L12:
            if (r2 == r6) goto L25;
            if (r2 == null) goto L25;
            if (r2 == r5) goto L16;
            if ((r2 instanceof View) == false) goto L24;
            r0 = r2;
        L24:
            r2 = r2.getParent();
            goto L12
        L16:
            if (r6.isInEditMode() == false) goto L20;
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
        L20:
            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
        L25:
            this.mAnchorDirectChild = r0;
            return;
        L6:
            if (r6.isInEditMode() == false) goto L10;
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
        L10:
            throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
        L28:
            if (r6.isInEditMode() == false) goto L32;
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
        L32:
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + r6.getResources().getResourceName(this.mAnchorId) + " to anchor view " + r5);
        }

        private boolean shouldDodge(View r1, int r2) {
            int r3 = GravityCompat.getAbsoluteGravity(((LayoutParams) r1.getLayoutParams()).insetEdge, r2);
            if (r3 != 0) goto L5;
        L7:
            return false;
        L5:
            if ((GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, r2) & r3) != r3) goto L7;
            return true;
        }

        private boolean verifyAnchorView(View r5, CoordinatorLayout r6) {
            if (this.mAnchorView.getId() == this.mAnchorId) goto L5;
            return false;
        L5:
            View r0 = this.mAnchorView;
            ViewParent r1 = r0.getParent();
        L6:
            if (r1 == r6) goto L16;
            if (r1 == null) goto L14;
            if (r1 == r5) goto L14;
            if ((r1 instanceof View) == false) goto L13;
            r0 = r1;
        L13:
            r1 = r1.getParent();
        L14:
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return false;
        L16:
            this.mAnchorDirectChild = r0;
            return true;
        }

        public boolean checkAnchorChanged() {
            if (this.mAnchorView == null) goto L5;
        L7:
            return false;
        L5:
            if (this.mAnchorId == (-1)) goto L7;
            return true;
        }

        public boolean dependsOn(CoordinatorLayout r2, View r3, View r4) {
            if (r4 != this.mAnchorDirectChild) goto L5;
        L12:
            return true;
        L5:
            if (shouldDodge(r4, ViewCompat.getLayoutDirection(r2)) == true) goto L12;
            Behavior r1 = this.mBehavior;
            if (r1 != null) goto L9;
        L11:
            return false;
        L9:
            if (r1.layoutDependsOn(r2, r3, r4) == false) goto L11;
            goto L11
        }

        public boolean didBlockInteraction() {
            if (this.mBehavior != null) goto L6;
            this.mDidBlockInteraction = false;
        L6:
            return this.mDidBlockInteraction;
        }

        public View findAnchorView(CoordinatorLayout r3, View r4) {
            if (this.mAnchorId != (-1)) goto L7;
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return null;
        L7:
            if (this.mAnchorView != null) goto L9;
        L10:
            resolveAnchorView(r4, r3);
        L12:
            return this.mAnchorView;
        L9:
            if (verifyAnchorView(r4, r3) == true) goto L12;
            goto L10
        }

        @IdRes
        public int getAnchorId() {
            return this.mAnchorId;
        }

        @Nullable
        public Behavior getBehavior() {
            return this.mBehavior;
        }

        public boolean getChangedAfterNestedScroll() {
            return this.mDidChangeAfterNestedScroll;
        }

        public Rect getLastChildRect() {
            return this.mLastChildRect;
        }

        public void invalidateAnchor() {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
        }

        public boolean isBlockingInteractionBelow(CoordinatorLayout r3, View r4) {
            boolean r0 = this.mDidBlockInteraction;
            if (r0 == false) goto L6;
            return true;
        L6:
            Behavior r1 = this.mBehavior;
            if (r1 == null) goto L9;
            boolean r5 = r1.blocksInteractionBelow(r3, r4);
        L10:
            boolean r6 = r5 | r0;
            this.mDidBlockInteraction = r6;
            return r6;
        L9:
            r5 = false;
            goto L10
        }

        public boolean isNestedScrollAccepted(int r2) {
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L8;
            return false;
        L8:
            return this.mDidAcceptNestedScrollNonTouch;
        L10:
            return this.mDidAcceptNestedScrollTouch;
        }

        public void resetChangedAfterNestedScroll() {
            this.mDidChangeAfterNestedScroll = false;
        }

        public void resetNestedScroll(int r2) {
            setNestedScrollAccepted(r2, false);
        }

        public void resetTouchBehaviorTracking() {
            this.mDidBlockInteraction = false;
        }

        public void setAnchorId(@IdRes int r1) {
            invalidateAnchor();
            this.mAnchorId = r1;
        }

        public void setBehavior(@Nullable Behavior r2) {
            Behavior r0 = this.mBehavior;
            if (r0 == r2) goto L10;
            if (r0 == null) goto L6;
            r0.onDetachedFromLayoutParams();
        L6:
            this.mBehavior = r2;
            this.mBehaviorTag = null;
            this.mBehaviorResolved = true;
            if (r2 == null) goto L11;
            r2.onAttachedToLayoutParams(this);
            return;
        L11:
            return;
        }

        public void setChangedAfterNestedScroll(boolean r1) {
            this.mDidChangeAfterNestedScroll = r1;
        }

        public void setLastChildRect(Rect r1) {
            this.mLastChildRect.set(r1);
        }

        public void setNestedScrollAccepted(int r2, boolean r3) {
            if (r2 != 0) goto L4;
            this.mDidAcceptNestedScrollTouch = r3;
            return;
        L4:
            if (r2 != 1) goto L10;
            this.mDidAcceptNestedScrollNonTouch = r3;
            return;
        }

        public LayoutParams(@NonNull Context r5, @Nullable AttributeSet r6) {
            super(r5, r6);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
            TypedArray r2 = r5.obtainStyledAttributes(r6, R.styleable.CoordinatorLayout_Layout);
            this.gravity = r2.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.mAnchorId = r2.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.anchorGravity = r2.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.keyline = r2.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.insetEdge = r2.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.dodgeInsetEdges = r2.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            boolean r0 = r2.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
            this.mBehaviorResolved = r0;
            if (r0 == false) goto L5;
            this.mBehavior = CoordinatorLayout.parseBehavior(r5, r6, r2.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
        L5:
            r2.recycle();
            Behavior r7 = this.mBehavior;
            if (r7 == null) goto L9;
            r7.onAttachedToLayoutParams(this);
            return;
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r2) {
            super(r2);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(ViewGroup.LayoutParams r2) {
            super(r2);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }
    }

    public class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ CoordinatorLayout this$0;

        public OnPreDrawListener(CoordinatorLayout r1) {
            this.this$0 = r1;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.this$0.onChildViewsChanged(0);
            return true;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        SparseArray<Parcelable> behaviorStates;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r6, ClassLoader r7) {
            super(r6, r7);
            int r0 = r6.readInt();
            int[] r1 = new int[r0];
            r6.readIntArray(r1);
            Parcelable[] r8 = r6.readParcelableArray(r7);
            this.behaviorStates = new SparseArray(r0);
            int r9 = 0;
        L3:
            if (r9 >= r0) goto L5;
            this.behaviorStates.append(r1[r9], r8[r9]);
            r9 = r9 + 1;
            goto L3
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r6, int r7) {
            super.writeToParcel(r6, r7);
            SparseArray<Parcelable> r0 = this.behaviorStates;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.size();
        L6:
            r6.writeInt(r2);
            int[] r3 = new int[r2];
            Parcelable[] r4 = new Parcelable[r2];
        L7:
            if (r1 >= r2) goto L9;
            r3[r1] = this.behaviorStates.keyAt(r1);
            r4[r1] = this.behaviorStates.valueAt(r1);
            r1 = r1 + 1;
            goto L7
        L9:
            r6.writeIntArray(r3);
            r6.writeParcelableArray(r4, r7);
            return;
        L5:
            r2 = 0;
            goto L6
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }
    }

    public static class ViewElevationComparator implements Comparator<View> {
        public ViewElevationComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(View r1, View r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(View r1, View r2) {
            float r0 = ViewCompat.getZ(r1);
            float r3 = ViewCompat.getZ(r2);
            if (r0 <= r3) goto L7;
            return -1;
        L7:
            if (r0 >= r3) goto L10;
            return 1;
        L10:
            return 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        if (r0 == null) goto L5;
        String r1 = r0.getName();
    L6:
        WIDGET_PACKAGE_NAME = r1;
        TOP_SORTED_CHILDREN_COMPARATOR = new ViewElevationComparator();
        CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        sConstructors = new ThreadLocal();
        sRectPool = new Pools.SynchronizedPool(12);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public CoordinatorLayout(@NonNull Context r2) {
        this(r2, null);
    }

    @NonNull
    private static Rect acquireTempRect() {
        Rect r0 = sRectPool.acquire();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new Rect();
    }

    private static int clamp(int r0, int r1, int r2) {
        if (r0 >= r1) goto L4;
        return r1;
    L4:
        if (r0 <= r2) goto L6;
        return r2;
    L6:
        return r0;
    }

    private void constrainChildRect(LayoutParams r6, Rect r7, int r8, int r9) {
        int r0 = getWidth();
        int r1 = getHeight();
        int r2 = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r6).leftMargin, Math.min(r7.left, ((r0 - getPaddingRight()) - r8) - ((ViewGroup.MarginLayoutParams) r6).rightMargin));
        int r5 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) r6).topMargin, Math.min(r7.top, ((r1 - getPaddingBottom()) - r9) - ((ViewGroup.MarginLayoutParams) r6).bottomMargin));
        r7.set(r2, r5, r8 + r2, r9 + r5);
    }

    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat r5) {
        if (r5.isConsumed() == false) goto L5;
        return r5;
    L5:
        int r0 = getChildCount();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L15;
        View r2 = getChildAt(r1);
        if (ViewCompat.getFitsSystemWindows(r2) == false) goto L14;
        Behavior r3 = ((LayoutParams) r2.getLayoutParams()).getBehavior();
        if (r3 == null) goto L14;
        r5 = r3.onApplyWindowInsets(this, r2, r5);
        if (r5.isConsumed() == true) goto L15;
    L14:
        r1 = r1 + 1;
    L15:
        return r5;
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View r5, int r6, Rect r7, Rect r8, LayoutParams r9, int r10, int r11) {
        int r4 = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(r9.gravity), r6);
        int r12 = GravityCompat.getAbsoluteGravity(resolveGravity(r9.anchorGravity), r6);
        int r13 = r4 & 7;
        int r14 = r4 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        int r15 = r12 & 7;
        int r16 = r12 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        if (r15 == 1) goto L7;
        if (r15 == 5) goto L6;
        int r17 = r7.left;
    L9:
        if (r16 == 16) goto L13;
        if (r16 == 80) goto L12;
        int r18 = r7.top;
    L14:
        if (r13 == 1) goto L17;
        if (r13 == 5) goto L18;
        r17 = r17 - r10;
    L18:
        if (r14 == 16) goto L21;
        if (r14 == 80) goto L22;
        r18 = r18 - r11;
    L22:
        r8.set(r17, r18, r10 + r17, r11 + r18);
        return;
    L21:
        r18 = r18 - (r11 / 2);
        goto L22
    L17:
        r17 = r17 - (r10 / 2);
        goto L18
    L12:
        r18 = r7.bottom;
        goto L14
    L13:
        r18 = r7.top + (r7.height() / 2);
        goto L14
    L6:
        r17 = r7.right;
        goto L9
    L7:
        r17 = r7.left + (r7.width() / 2);
        goto L9
    }

    private int getKeyline(int r5) {
        int[] r0 = this.mKeylines;
        if (r0 != null) goto L6;
        Log.e(TAG, "No keylines defined for " + this + " - attempted index lookup " + r5);
        return 0;
    L6:
        if (r5 >= 0) goto L8;
    L12:
        Log.e(TAG, "Keyline index " + r5 + " out of range for " + this);
        return 0;
    L8:
        if (r5 >= r0.length) goto L12;
        return r0[r5];
    }

    private void getTopSortedChildren(List<View> r5) {
        r5.clear();
        boolean r0 = isChildrenDrawingOrderEnabled();
        int r1 = getChildCount();
        int r2 = r1 - 1;
    L3:
        if (r2 < 0) goto L8;
        if (r0 == false) goto L6;
        int r3 = getChildDrawingOrder(r1, r2);
    L7:
        r5.add(getChildAt(r3));
        r2 = r2 - 1;
        goto L3
    L6:
        r3 = r2;
        goto L7
    L8:
        Comparator<View> r4 = TOP_SORTED_CHILDREN_COMPARATOR;
        if (r4 == null) goto L15;
        Collections.sort(r5, r4);
        return;
    }

    private boolean hasDependencies(View r1) {
        return this.mChildDag.hasOutgoingEdges(r1);
    }

    private void layoutChild(View r9, int r10) {
        LayoutParams r0 = (LayoutParams) r9.getLayoutParams();
        Rect r7 = acquireTempRect();
        r7.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r0).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) r0).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r0).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r0).bottomMargin);
        if (this.mLastInsets != null) goto L5;
    L9:
        Rect r8 = acquireTempRect();
        GravityCompat.apply(resolveGravity(r0.gravity), r9.getMeasuredWidth(), r9.getMeasuredHeight(), r7, r8, r10);
        r9.layout(r8.left, r8.top, r8.right, r8.bottom);
        releaseTempRect(r7);
        releaseTempRect(r8);
        return;
    L5:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L9;
        if (ViewCompat.getFitsSystemWindows(r9) == true) goto L9;
        r7.left = this.mLastInsets.getSystemWindowInsetLeft() + r7.left;
        r7.top = this.mLastInsets.getSystemWindowInsetTop() + r7.top;
        r7.right -= this.mLastInsets.getSystemWindowInsetRight();
        r7.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
        goto L9
    }

    private void layoutChildWithAnchor(View r4, View r5, int r6) {
        Rect r0 = acquireTempRect();
        Rect r1 = acquireTempRect();
        getDescendantRect(r5, r0);     // Catch: Throwable -> L6
        getDesiredAnchoredChildRect(r4, r6, r0, r1);     // Catch: Throwable -> L6
        r4.layout(r1.left, r1.top, r1.right, r1.bottom);     // Catch: Throwable -> L6
        releaseTempRect(r0);
        releaseTempRect(r1);
        return;
    L6:
        th = move-exception;
        releaseTempRect(r0);
        releaseTempRect(r1);
        throw th;
    }

    private void layoutChildWithKeyline(View r9, int r10, int r11) {
        LayoutParams r0 = (LayoutParams) r9.getLayoutParams();
        int r1 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(r0.gravity), r11);
        int r2 = r1 & 7;
        int r3 = r1 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        int r4 = getWidth();
        int r5 = getHeight();
        int r6 = r9.getMeasuredWidth();
        int r7 = r9.getMeasuredHeight();
        if (r11 != 1) goto L5;
        r10 = r4 - r10;
    L5:
        int r12 = getKeyline(r10) - r6;
        if (r2 != 1) goto L8;
        r12 = r12 + (r6 / 2);
    L13:
        if (r3 != 16) goto L15;
        int r13 = r7 / 2;
    L19:
        int r14 = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r0).leftMargin, Math.min(r12, ((r4 - getPaddingRight()) - r6) - ((ViewGroup.MarginLayoutParams) r0).rightMargin));
        int r8 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) r0).topMargin, Math.min(r13, ((r5 - getPaddingBottom()) - r7) - ((ViewGroup.MarginLayoutParams) r0).bottomMargin));
        r9.layout(r14, r8, r6 + r14, r7 + r8);
        return;
    L15:
        if (r3 == 80) goto L17;
        r13 = 0;
        goto L19
    L17:
        r13 = r7;
        goto L19
    L8:
        if (r2 != 5) goto L13;
        r12 = r12 + r6;
        goto L13
    }

    private void offsetChildByInset(View r9, Rect r10, int r11) {
        if (ViewCompat.isLaidOut(r9) == true) goto L6;
        return;
    L6:
        if (r9.getWidth() > 0) goto L8;
        return;
    L8:
        if (r9.getHeight() <= 0) goto L54;
        LayoutParams r0 = (LayoutParams) r9.getLayoutParams();
        Behavior r1 = r0.getBehavior();
        Rect r2 = acquireTempRect();
        Rect r3 = acquireTempRect();
        r3.set(r9.getLeft(), r9.getTop(), r9.getRight(), r9.getBottom());
        if (r1 != null) goto L13;
    L19:
        r2.set(r3);
    L20:
        releaseTempRect(r3);
        if (r2.isEmpty() == false) goto L24;
        releaseTempRect(r2);
        return;
    L24:
        int r12 = GravityCompat.getAbsoluteGravity(r0.dodgeInsetEdges, r11);
        boolean r4 = true;
        if ((r12 & 48) != 48) goto L29;
        int r5 = (r2.top - ((ViewGroup.MarginLayoutParams) r0).topMargin) - r0.mInsetOffsetY;
        int r6 = r10.top;
        if (r5 >= r6) goto L29;
        setInsetOffsetY(r9, r6 - r5);
        boolean r7 = true;
    L31:
        if ((r12 & 80) != 80) goto L35;
        int r8 = ((getHeight() - r2.bottom) - ((ViewGroup.MarginLayoutParams) r0).bottomMargin) + r0.mInsetOffsetY;
        int r13 = r10.bottom;
        if (r8 >= r13) goto L35;
        setInsetOffsetY(r9, r8 - r13);
        r7 = true;
    L35:
        if (r7 == true) goto L38;
        setInsetOffsetY(r9, 0);
    L38:
        if ((r12 & 3) != 3) goto L42;
        int r14 = (r2.left - ((ViewGroup.MarginLayoutParams) r0).leftMargin) - r0.mInsetOffsetX;
        int r15 = r10.left;
        if (r14 >= r15) goto L42;
        setInsetOffsetX(r9, r15 - r14);
        boolean r16 = true;
    L44:
        if ((r12 & 5) != 5) goto L48;
        int r17 = ((getWidth() - r2.right) - ((ViewGroup.MarginLayoutParams) r0).rightMargin) + r0.mInsetOffsetX;
        int r18 = r10.right;
        if (r17 >= r18) goto L48;
        setInsetOffsetX(r9, r17 - r18);
    L49:
        if (r4 == true) goto L51;
        setInsetOffsetX(r9, 0);
    L51:
        releaseTempRect(r2);
        return;
    L48:
        r4 = r16;
    L42:
        r16 = false;
    L29:
        r7 = false;
        goto L31
    L13:
        if (r1.getInsetDodgeRect(this, r9, r2) == false) goto L19;
        if (r3.contains(r2) == true) goto L20;
        throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + r2.toShortString() + " | Bounds:" + r3.toShortString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Behavior parseBehavior(Context r3, AttributeSet r4, String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L7;
        return null;
    L7:
        if (r5.startsWith(LibrarianImpl.Constants.DOT) == false) goto L10;
        r5 = r3.getPackageName() + r5;
    L27:
        ThreadLocal<Map<String, Constructor<Behavior>>> r0 = sConstructors;     // Catch: Exception -> L18
        Map<String, Constructor<Behavior>> r1 = r0.get();     // Catch: Exception -> L18
        if (r1 != null) goto L20;
        r1 = new HashMap();     // Catch: Exception -> L18
        r0.set(r1);     // Catch: Exception -> L18
    L20:
        Constructor<Behavior> r2 = r1.get(r5);     // Catch: Exception -> L18
        if (r2 != null) goto L23;
        r2 = Class.forName(r5, false, r3.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);     // Catch: Exception -> L18
        r2.setAccessible(true);     // Catch: Exception -> L18
        r1.put(r5, r2);     // Catch: Exception -> L18
    L23:
        return r2.newInstance(new Object[]{r3, r4});
    L18:
        e = move-exception;
        throw new RuntimeException(a.A("Could not inflate Behavior subclass ", r5), e);
    L10:
        if (r5.indexOf(46) >= 0) goto L27;
        String r6 = WIDGET_PACKAGE_NAME;
        if (TextUtils.isEmpty(r6) == true) goto L27;
        r5 = r6 + '.' + r5;
        goto L27
    }

    private boolean performIntercept(MotionEvent r24, int r25) {
        int r3 = r24.getActionMasked();
        List<View> r4 = this.mTempList1;
        getTopSortedChildren(r4);
        int r5 = r4.size();
        MotionEvent r7 = null;
        int r8 = 0;
        boolean r9 = false;
        boolean r10 = false;
    L3:
        if (r8 >= r5) goto L34;
        View r11 = r4.get(r8);
        LayoutParams r12 = (LayoutParams) r11.getLayoutParams();
        Behavior r13 = r12.getBehavior();
        if (r9 == true) goto L7;
        if (r10 == true) goto L7;
    L16:
        if (r9 == true) goto L25;
        if (r13 == null) goto L25;
        if (r25 == 0) goto L22;
        if (r25 != 1) goto L23;
        r9 = r13.onTouchEvent(this, r11, r24);
    L23:
        if (r9 == false) goto L25;
        this.mBehaviorTouchView = r11;
        goto L25
    L22:
        r9 = r13.onInterceptTouchEvent(this, r11, r24);
    L25:
        boolean r14 = r12.didBlockInteraction();
        boolean r15 = r12.isBlockingInteractionBelow(this, r11);
        if (r15 == false) goto L29;
        if (r14 == true) goto L29;
        r10 = true;
    L30:
        if (r15 == false) goto L33;
        if (r10 == false) goto L34;
    L33:
        r8 = r8 + 1;
    L29:
        r10 = false;
    L7:
        if (r3 == 0) goto L16;
        if (r13 == null) goto L33;
        if (r7 != null) goto L11;
        long r17 = SystemClock.uptimeMillis();
        r7 = MotionEvent.obtain(r17, r17, 3, 0.0f, 0.0f, 0);
    L11:
        if (r25 == 0) goto L15;
        if (r25 != 1) goto L33;
        r13.onTouchEvent(this, r11, r7);
        goto L33
    L15:
        r13.onInterceptTouchEvent(this, r11, r7);
    L34:
        r4.clear();
        return r9;
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.clear();
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L16;
        View r3 = getChildAt(r2);
        LayoutParams r4 = getResolvedLayoutParams(r3);
        r4.findAnchorView(this, r3);
        this.mChildDag.addNode(r3);
        int r5 = 0;
    L5:
        if (r5 >= r0) goto L15;
        if (r5 == r2) goto L14;
        View r6 = getChildAt(r5);
        if (r4.dependsOn(this, r3, r6) == false) goto L14;
        if (this.mChildDag.contains(r6) == true) goto L13;
        this.mChildDag.addNode(r6);
    L13:
        this.mChildDag.addEdge(r6, r3);
    L14:
        r5 = r5 + 1;
        goto L5
    L15:
        r2 = r2 + 1;
        goto L3
    L16:
        this.mDependencySortedChildren.addAll(this.mChildDag.getSortedList());
        Collections.reverse(this.mDependencySortedChildren);
    }

    private static void releaseTempRect(@NonNull Rect r1) {
        r1.setEmpty();
        sRectPool.release(r1);
    }

    private void resetTouchBehaviors(boolean r14) {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        View r3 = getChildAt(r2);
        Behavior r4 = ((LayoutParams) r3.getLayoutParams()).getBehavior();
        if (r4 == null) goto L11;
        long r7 = SystemClock.uptimeMillis();
        MotionEvent r5 = MotionEvent.obtain(r7, r7, 3, 0.0f, 0.0f, 0);
        if (r14 == false) goto L9;
        r4.onInterceptTouchEvent(this, r3, r5);
    L10:
        r5.recycle();
        goto L11
    L9:
        r4.onTouchEvent(this, r3, r5);
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        int r15 = 0;
    L13:
        if (r15 >= r0) goto L15;
        ((LayoutParams) getChildAt(r15).getLayoutParams()).resetTouchBehaviorTracking();
        r15 = r15 + 1;
        goto L13
    L15:
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    private static int resolveAnchoredChildGravity(int r0) {
        if (r0 != 0) goto L5;
        return 17;
    L5:
        return r0;
    }

    private static int resolveGravity(int r1) {
        if ((r1 & 7) != 0) goto L6;
        r1 = r1 | GravityCompat.START;
    L6:
        if ((r1 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST) == 0) goto L8;
        return r1;
    L8:
        return r1 | 48;
    }

    private static int resolveKeylineGravity(int r0) {
        if (r0 != 0) goto L5;
        return BadgeDrawable.TOP_END;
    L5:
        return r0;
    }

    private void setInsetOffsetX(View r2, int r3) {
        LayoutParams r1 = (LayoutParams) r2.getLayoutParams();
        int r0 = r1.mInsetOffsetX;
        if (r0 == r3) goto L6;
        ViewCompat.offsetLeftAndRight(r2, r3 - r0);
        r1.mInsetOffsetX = r3;
        return;
    }

    private void setInsetOffsetY(View r2, int r3) {
        LayoutParams r1 = (LayoutParams) r2.getLayoutParams();
        int r0 = r1.mInsetOffsetY;
        if (r0 == r3) goto L6;
        ViewCompat.offsetTopAndBottom(r2, r3 - r0);
        r1.mInsetOffsetY = r3;
        return;
    }

    private void setupForInsets() {
        if (ViewCompat.getFitsSystemWindows(this) == true) goto L5;
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
        return;
    L5:
        if (this.mApplyWindowInsetsListener != null) goto L7;
        this.mApplyWindowInsetsListener = new AnonymousClass1(this);
    L7:
        ViewCompat.setOnApplyWindowInsetsListener(this, this.mApplyWindowInsetsListener);
        setSystemUiVisibility(1280);
    }

    public void addPreDrawListener() {
        if (this.mIsAttachedToWindow == true) goto L5;
    L8:
        this.mNeedsPreDrawListener = true;
        return;
    L5:
        if (this.mOnPreDrawListener != null) goto L7;
        this.mOnPreDrawListener = new OnPreDrawListener(this);
    L7:
        getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        goto L8
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

    public void dispatchDependentViewsChanged(@NonNull View r5) {
        List r0 = this.mChildDag.getIncomingEdges(r5);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L17;
        int r1 = 0;
    L8:
        if (r1 >= r0.size()) goto L18;
        View r2 = (View) r0.get(r1);
        Behavior r3 = ((LayoutParams) r2.getLayoutParams()).getBehavior();
        if (r3 == null) goto L12;
        r3.onDependentViewChanged(this, r2, r5);
    L12:
        r1 = r1 + 1;
        goto L8
    L18:
        return;
    }

    public boolean doViewsOverlap(@NonNull View r5, @NonNull View r6) {
        boolean r1 = false;
        if (r5.getVisibility() == 0) goto L5;
    L30:
        return false;
    L5:
        if (r6.getVisibility() != 0) goto L30;
        Rect r0 = acquireTempRect();
        if (r5.getParent() == this) goto L9;
        boolean r2 = true;
    L10:
        getChildRect(r5, r2, r0);
        Rect r7 = acquireTempRect();
        if (r6.getParent() == this) goto L13;
        boolean r3 = true;
    L14:
        getChildRect(r6, r3, r7);
    L24:
        th = move-exception;
        releaseTempRect(r0);
        releaseTempRect(r7);
        throw th;
    L16:
        if (r0.left <= r7.right) goto L18;
    L26:
        releaseTempRect(r0);
        releaseTempRect(r7);
        return r1;
    L18:
        if (r0.top > r7.bottom) goto L26;
        if (r0.right < r7.left) goto L26;
        if (r0.bottom < r7.top) goto L26;
        r1 = true;
        goto L26
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r9, View r10, long r11) {
        LayoutParams r0 = (LayoutParams) r10.getLayoutParams();
        Behavior r1 = r0.mBehavior;
        if (r1 == null) goto L14;
        float r2 = r1.getScrimOpacity(this, r10);
        if (r2 <= 0.0f) goto L14;
        if (this.mScrimPaint != null) goto L9;
        this.mScrimPaint = new Paint();
    L9:
        this.mScrimPaint.setColor(r0.mBehavior.getScrimColor(this, r10));
        this.mScrimPaint.setAlpha(clamp(Math.round(r2 * 255.0f), 0, 255));
        int r3 = r9.save();
        if (r10.isOpaque() == false) goto L12;
        r9.clipRect(r10.getLeft(), r10.getTop(), r10.getRight(), r10.getBottom(), Region.Op.DIFFERENCE);
    L12:
        r9.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
        r9.restoreToCount(r3);
    L14:
        return super.drawChild(r9, r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r0 = getDrawableState();
        Drawable r1 = this.mStatusBarBackground;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L11;
        invalidate();
        return;
    L11:
        return;
    L5:
        if (r1.isStateful() == false) goto L7;
        r2 = r1.setState(r0);
        goto L8
    }

    public void ensurePreDrawListener() {
        int r0 = getChildCount();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (hasDependencies(getChildAt(r2)) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        r1 = true;
    L9:
        if (r1 == this.mNeedsPreDrawListener) goto L16;
        if (r1 == false) goto L12;
        addPreDrawListener();
        return;
    L12:
        removePreDrawListener();
        return;
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    public void getChildRect(View r3, boolean r4, Rect r5) {
        if (r3.isLayoutRequested() == false) goto L5;
    L11:
        r5.setEmpty();
        return;
    L5:
        if (r3.getVisibility() == 8) goto L11;
        if (r4 == false) goto L9;
        getDescendantRect(r3, r5);
        return;
    L9:
        r5.set(r3.getLeft(), r3.getTop(), r3.getRight(), r3.getBottom());
    }

    @NonNull
    public List<View> getDependencies(@NonNull View r2) {
        List<View> r3 = this.mChildDag.getOutgoingEdges(r2);
        this.mTempDependenciesList.clear();
        if (r3 == null) goto L6;
        this.mTempDependenciesList.addAll(r3);
    L6:
        return this.mTempDependenciesList;
    }

    @VisibleForTesting
    public final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    @NonNull
    public List<View> getDependents(@NonNull View r2) {
        List r3 = this.mChildDag.getIncomingEdges(r2);
        this.mTempDependenciesList.clear();
        if (r3 == null) goto L6;
        this.mTempDependenciesList.addAll(r3);
    L6:
        return this.mTempDependenciesList;
    }

    public void getDescendantRect(View r1, Rect r2) {
        ViewGroupUtils.getDescendantRect(this, r1, r2);
    }

    public void getDesiredAnchoredChildRect(View r12, int r13, Rect r14, Rect r15) {
        LayoutParams r0 = (LayoutParams) r12.getLayoutParams();
        int r9 = r12.getMeasuredWidth();
        int r10 = r12.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(r12, r13, r14, r15, r0, r9, r10);
        constrainChildRect(r0, r15, r9, r10);
    }

    public void getLastChildRect(View r1, Rect r2) {
        r2.set(((LayoutParams) r1.getLayoutParams()).getLastChildRect());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutParams getResolvedLayoutParams(View r6) {
        LayoutParams r5 = (LayoutParams) r6.getLayoutParams();
        if (r5.mBehaviorResolved == false) goto L5;
    L21:
        return r5;
    L5:
        if ((r6 instanceof AttachedBehavior) == false) goto L10;
        Behavior r7 = ((AttachedBehavior) r6).getBehavior();
        if (r7 != null) goto L9;
        Log.e(TAG, "Attached behavior class is null");
    L9:
        r5.setBehavior(r7);
        r5.mBehaviorResolved = true;
        goto L21
    L10:
        Class<?> r8 = r6.getClass();
        DefaultBehavior r3 = null;
    L11:
        if (r8 == null) goto L15;
        r3 = (DefaultBehavior) r8.getAnnotation(DefaultBehavior.class);
        if (r3 != null) goto L15;
        r8 = r8.getSuperclass();
    L15:
        if (r3 != null) goto L22;
    L20:
        r5.mBehaviorResolved = true;
        goto L21
    L22:
        r5.setBehavior(r3.value().getDeclaredConstructor(null).newInstance(null));     // Catch: Exception -> L18
    L18:
        e = move-exception;
        Log.e(TAG, "Default behavior class " + r3.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
        goto L20
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        int r0 = super.getSuggestedMinimumHeight();
        int r1 = getPaddingTop();
        return Math.max(r0, getPaddingBottom() + r1);
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        int r0 = super.getSuggestedMinimumWidth();
        int r1 = getPaddingLeft();
        return Math.max(r0, getPaddingRight() + r1);
    }

    public boolean isPointInChildBounds(@NonNull View r2, int r3, int r4) {
        Rect r0 = acquireTempRect();
        getDescendantRect(r2, r0);
        boolean r1 = r0.contains(r3, r4);     // Catch: Throwable -> L6
        releaseTempRect(r0);
        return r1;
    L6:
        th = move-exception;
        releaseTempRect(r0);
        throw th;
    }

    public void offsetChildToAnchor(View r17, int r18) {
        LayoutParams r10 = (LayoutParams) r17.getLayoutParams();
        if (r10.mAnchorView == null) goto L22;
        Rect r11 = acquireTempRect();
        Rect r12 = acquireTempRect();
        Rect r13 = acquireTempRect();
        getDescendantRect(r10.mAnchorView, r11);
        boolean r14 = false;
        getChildRect(r17, false, r12);
        int r15 = r17.getMeasuredWidth();
        int r7 = r17.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(r17, r18, r11, r13, r10, r15, r7);
        if (r13.left == r12.left) goto L7;
    L10:
        r14 = true;
    L11:
        constrainChildRect(r10, r13, r15, r7);
        int r0 = r13.left - r12.left;
        int r1 = r13.top - r12.top;
        if (r0 == 0) goto L14;
        ViewCompat.offsetLeftAndRight(r17, r0);
    L14:
        if (r1 == 0) goto L16;
        ViewCompat.offsetTopAndBottom(r17, r1);
    L16:
        if (r14 == false) goto L20;
        Behavior r2 = r10.getBehavior();
        if (r2 == null) goto L20;
        r2.onDependentViewChanged(this, r17, r10.mAnchorView);
    L20:
        releaseTempRect(r11);
        releaseTempRect(r12);
        releaseTempRect(r13);
        return;
    L7:
        if (r13.top == r12.top) goto L11;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener == false) goto L9;
        if (this.mOnPreDrawListener != null) goto L7;
        this.mOnPreDrawListener = new OnPreDrawListener(this);
    L7:
        getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
    L9:
        if (this.mLastInsets == null) goto L11;
    L13:
        this.mIsAttachedToWindow = true;
        return;
    L11:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L13;
        ViewCompat.requestApplyInsets(this);
        goto L13
    }

    public final void onChildViewsChanged(int r18) {
        int r2 = ViewCompat.getLayoutDirection(this);
        int r3 = this.mDependencySortedChildren.size();
        Rect r4 = acquireTempRect();
        Rect r5 = acquireTempRect();
        Rect r6 = acquireTempRect();
        int r8 = 0;
    L3:
        if (r8 >= r3) goto L61;
        View r9 = this.mDependencySortedChildren.get(r8);
        LayoutParams r10 = (LayoutParams) r9.getLayoutParams();
        if (r18 == 0) goto L7;
    L9:
        int r11 = 0;
    L10:
        if (r11 >= r8) goto L15;
        if (r10.mAnchorDirectChild != this.mDependencySortedChildren.get(r11)) goto L14;
        offsetChildToAnchor(r9, r2);
    L14:
        r11 = r11 + 1;
        goto L10
    L15:
        getChildRect(r9, true, r5);
        if (r10.insetEdge == 0) goto L34;
        if (r5.isEmpty() == true) goto L34;
        int r12 = GravityCompat.getAbsoluteGravity(r10.insetEdge, r2);
        int r13 = r12 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        if (r13 != 48) goto L22;
        r4.top = Math.max(r4.top, r5.bottom);
    L26:
        int r14 = r12 & 7;
        if (r14 != 3) goto L29;
        r4.left = Math.max(r4.left, r5.right);
        goto L34
    L29:
        if (r14 != 5) goto L34;
        r4.right = Math.max(r4.right, getWidth() - r5.left);
        goto L34
    L22:
        if (r13 != 80) goto L26;
        r4.bottom = Math.max(r4.bottom, getHeight() - r5.top);
    L34:
        if (r10.dodgeInsetEdges == 0) goto L39;
        if (r9.getVisibility() != 0) goto L39;
        offsetChildByInset(r9, r4, r2);
    L39:
        if (r18 == 2) goto L44;
        getLastChildRect(r9, r6);
        if (r6.equals(r5) == true) goto L60;
        recordLastChildRect(r9, r5);
    L60:
        r8 = r8 + 1;
    L44:
        int r15 = r8 + 1;
    L45:
        if (r15 >= r3) goto L60;
        View r16 = this.mDependencySortedChildren.get(r15);
        LayoutParams r17 = (LayoutParams) r16.getLayoutParams();
        Behavior r19 = r17.getBehavior();
        if (r19 == null) goto L59;
        if (r19.layoutDependsOn(this, r16, r9) == false) goto L59;
        if (r18 == 0) goto L52;
    L54:
        if (r18 == 2) goto L56;
        boolean r110 = r19.onDependentViewChanged(this, r16, r9);
    L57:
        if (r18 != 1) goto L59;
        r17.setChangedAfterNestedScroll(r110);
        goto L59
    L56:
        r19.onDependentViewRemoved(this, r16, r9);
        r110 = true;
        goto L57
    L52:
        if (r17.getChangedAfterNestedScroll() == false) goto L54;
        r17.resetChangedAfterNestedScroll();
    L59:
        r15 = r15 + 1;
        goto L45
    L7:
        if (r9.getVisibility() != 8) goto L9;
    L61:
        releaseTempRect(r4);
        releaseTempRect(r5);
        releaseTempRect(r6);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener == true) goto L5;
    L7:
        View r1 = this.mNestedScrollingTarget;
        if (r1 == null) goto L10;
        onStopNestedScroll(r1);
    L10:
        this.mIsAttachedToWindow = false;
        return;
    L5:
        if (this.mOnPreDrawListener == null) goto L7;
        getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        goto L7
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        super.onDraw(r5);
        if (this.mDrawStatusBarBackground == true) goto L5;
        return;
    L5:
        if (this.mStatusBarBackground == null) goto L14;
        WindowInsetsCompat r0 = this.mLastInsets;
        if (r0 == null) goto L9;
        int r1 = r0.getSystemWindowInsetTop();
    L10:
        if (r1 <= 0) goto L15;
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), r1);
        this.mStatusBarBackground.draw(r5);
        return;
    L15:
        return;
    L9:
        r1 = 0;
        goto L10
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r4) {
        int r0 = r4.getActionMasked();
        if (r0 != 0) goto L5;
        resetTouchBehaviors(true);
    L5:
        boolean r5 = performIntercept(r4, 0);
        if (r0 != 1) goto L8;
    L9:
        resetTouchBehaviors(true);
    L10:
        return r5;
    L8:
        if (r0 != 3) goto L10;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        int r7 = ViewCompat.getLayoutDirection(this);
        int r8 = this.mDependencySortedChildren.size();
        int r9 = 0;
    L3:
        if (r9 >= r8) goto L13;
        View r10 = this.mDependencySortedChildren.get(r9);
        if (r10.getVisibility() == 8) goto L12;
        Behavior r11 = ((LayoutParams) r10.getLayoutParams()).getBehavior();
        if (r11 != null) goto L10;
    L11:
        onLayoutChild(r10, r7);
        goto L12
    L10:
        if (r11.onLayoutChild(this, r10, r7) == false) goto L11;
    L12:
        r9 = r9 + 1;
        goto L3
    }

    public void onLayoutChild(@NonNull View r3, int r4) {
        LayoutParams r0 = (LayoutParams) r3.getLayoutParams();
        if (r0.checkAnchorChanged() == true) goto L13;
        View r1 = r0.mAnchorView;
        if (r1 == null) goto L7;
        layoutChildWithAnchor(r3, r1, r4);
        return;
    L7:
        int r2 = r0.keyline;
        if (r2 < 0) goto L10;
        layoutChildWithKeyline(r3, r2, r4);
        return;
    L10:
        layoutChild(r3, r4);
        return;
    L13:
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    @Override // android.view.View
    public void onMeasure(int r31, int r32) {
        prepareChildren();
        ensurePreDrawListener();
        int r8 = getPaddingLeft();
        int r0 = getPaddingTop();
        int r9 = getPaddingRight();
        int r1 = getPaddingBottom();
        int r10 = ViewCompat.getLayoutDirection(this);
        if (r10 != 1) goto L5;
        boolean r12 = true;
    L6:
        int r13 = View.MeasureSpec.getMode(r31);
        int r14 = View.MeasureSpec.getSize(r31);
        int r15 = View.MeasureSpec.getMode(r32);
        int r16 = View.MeasureSpec.getSize(r32);
        int r17 = r8 + r9;
        int r18 = r0 + r1;
        int r2 = getSuggestedMinimumWidth();
        int r3 = getSuggestedMinimumHeight();
        if (this.mLastInsets != null) goto L9;
    L11:
        boolean r19 = false;
    L12:
        int r6 = this.mDependencySortedChildren.size();
        int r5 = r2;
        int r4 = r3;
        int r7 = 0;
        int r11 = 0;
    L13:
        if (r11 >= r6) goto L50;
        View r20 = this.mDependencySortedChildren.get(r11);
        if (r20.getVisibility() != 8) goto L17;
        int r22 = r11;
        int r29 = r6;
        int r28 = r8;
    L49:
        r11 = r22 + 1;
        r8 = r28;
        r6 = r29;
        goto L13
    L17:
        LayoutParams r21 = (LayoutParams) r20.getLayoutParams();
        int r23 = r21.keyline;
        if (r23 < 0) goto L34;
        if (r13 == 0) goto L34;
        int r24 = getKeyline(r23);
        int r110 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(r21.gravity), r10) & 7;
        int r25 = r7;
        if (r110 != 3) goto L24;
        if (r12 == true) goto L24;
    L26:
        int r26 = Math.max(0, (r14 - r9) - r24);
    L36:
        if (r19 == true) goto L38;
    L40:
        int r111 = r31;
        int r27 = r32;
    L41:
        Behavior r30 = r21.getBehavior();
        if (r30 == null) goto L46;
        LayoutParams r210 = r21;
        int r211 = r25;
        r22 = r11;
        int r212 = r4;
        r28 = r8;
        int r33 = r5;
        r29 = r6;
        if (r30.onMeasureChild(this, r20, r111, r26, r27, 0) == false) goto L47;
    L48:
        LayoutParams r34 = r210;
        int r35 = Math.max(r33, ((r20.getMeasuredWidth() + r17) + ((ViewGroup.MarginLayoutParams) r34).leftMargin) + ((ViewGroup.MarginLayoutParams) r34).rightMargin);
        int r36 = Math.max(r212, ((r20.getMeasuredHeight() + r18) + ((ViewGroup.MarginLayoutParams) r34).topMargin) + ((ViewGroup.MarginLayoutParams) r34).bottomMargin);
        r7 = View.combineMeasuredStates(r211, r20.getMeasuredState());
        r5 = r35;
        r4 = r36;
    L47:
        onMeasureChild(r20, r111, r26, r27, 0);
        goto L48
    L46:
        r210 = r21;
        r212 = r4;
        r29 = r6;
        r28 = r8;
        r211 = r25;
        r22 = r11;
        r33 = r5;
        goto L47
    L38:
        if (ViewCompat.getFitsSystemWindows(r20) == true) goto L40;
        int r37 = this.mLastInsets.getSystemWindowInsetRight() + this.mLastInsets.getSystemWindowInsetLeft();
        int r112 = this.mLastInsets.getSystemWindowInsetBottom() + this.mLastInsets.getSystemWindowInsetTop();
        int r38 = View.MeasureSpec.makeMeasureSpec(r14 - r37, r13);
        int r39 = View.MeasureSpec.makeMeasureSpec(r16 - r112, r15);
        r111 = r38;
        r27 = r39;
    L24:
        if (r110 != 5) goto L27;
        if (r12 == true) goto L26;
    L27:
        if (r110 != 5) goto L30;
        if (r12 == true) goto L30;
    L32:
        r26 = Math.max(0, r24 - r8);
    L30:
        if (r110 != 3) goto L35;
        if (r12 == true) goto L32;
    L35:
        r26 = 0;
    L34:
        r25 = r7;
        goto L35
    L50:
        int r113 = r7;
        setMeasuredDimension(View.resolveSizeAndState(r5, r31, (-16777216) & r113), View.resolveSizeAndState(r4, r32, r113 << 16));
        return;
    L9:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L11;
        r19 = true;
        goto L12
    L5:
        r12 = false;
        goto L6
    }

    public void onMeasureChild(View r1, int r2, int r3, int r4, int r5) {
        measureChildWithMargins(r1, r2, r3, r4, r5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r12, float r13, float r14, boolean r15) {
        int r0 = getChildCount();
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r0) goto L14;
        View r6 = getChildAt(r2);
        if (r6.getVisibility() == 8) goto L13;
        LayoutParams r4 = (LayoutParams) r6.getLayoutParams();
        if (r4.isNestedScrollAccepted(0) == false) goto L13;
        Behavior r5 = r4.getBehavior();
        if (r5 == null) goto L13;
        r3 = r3 | r5.onNestedFling(this, r6, r12, r13, r14, r15);
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        if (r3 == false) goto L16;
        onChildViewsChanged(1);
    L16:
        return r3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r11, float r12, float r13) {
        int r0 = getChildCount();
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r0) goto L14;
        View r6 = getChildAt(r2);
        if (r6.getVisibility() == 8) goto L13;
        LayoutParams r4 = (LayoutParams) r6.getLayoutParams();
        if (r4.isNestedScrollAccepted(0) == false) goto L13;
        Behavior r5 = r4.getBehavior();
        if (r5 == null) goto L13;
        r3 = r3 | r5.onNestedPreFling(this, r6, r11, r12, r13);
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        return r3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View r7, int r8, int r9, int[] r10) {
        onNestedPreScroll(r7, r8, r9, r10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View r8, int r9, int r10, int r11, int r12) {
        onNestedScroll(r8, r9, r10, r11, r12, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View r2, View r3, int r4) {
        onNestedScrollAccepted(r2, r3, r4, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r7) {
        if ((r7 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r7);
        return;
    L6:
        SavedState r8 = (SavedState) r7;
        super.onRestoreInstanceState(r8.getSuperState());
        SparseArray<Parcelable> r9 = r8.behaviorStates;
        int r0 = getChildCount();
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L15;
        View r2 = getChildAt(r1);
        int r3 = r2.getId();
        Behavior r4 = getResolvedLayoutParams(r2).getBehavior();
        if (r3 == (-1)) goto L14;
        if (r4 == null) goto L14;
        Parcelable r5 = r9.get(r3);
        if (r5 == null) goto L14;
        r4.onRestoreInstanceState(this, r2, r5);
    L14:
        r1 = r1 + 1;
        goto L7
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> r1 = new SparseArray();
        int r2 = getChildCount();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L11;
        View r4 = getChildAt(r3);
        int r5 = r4.getId();
        Behavior r6 = ((LayoutParams) r4.getLayoutParams()).getBehavior();
        if (r5 == (-1)) goto L10;
        if (r6 == null) goto L10;
        Parcelable r7 = r6.onSaveInstanceState(this, r4);
        if (r7 == null) goto L10;
        r1.append(r5, r7);
    L10:
        r3 = r3 + 1;
        goto L3
    L11:
        r0.behaviorStates = r1;
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View r2, View r3, int r4) {
        return onStartNestedScroll(r2, r3, r4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View r2) {
        onStopNestedScroll(r2, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r18) {
        int r2 = r18.getActionMasked();
        if (this.mBehaviorTouchView != null) goto L8;
        boolean r3 = performIntercept(r18, 1);
        if (r3 == true) goto L9;
    L7:
        boolean r6 = false;
    L12:
        MotionEvent r8 = null;
        if (this.mBehaviorTouchView != null) goto L15;
        r6 = r6 | super.onTouchEvent(r18);
    L17:
        if (r8 == null) goto L19;
        r8.recycle();
    L19:
        if (r2 != 1) goto L21;
    L22:
        resetTouchBehaviors(false);
    L23:
        return r6;
    L21:
        if (r2 != 3) goto L23;
    L15:
        if (r3 == false) goto L17;
        long r11 = SystemClock.uptimeMillis();
        r8 = MotionEvent.obtain(r11, r11, 3, 0.0f, 0.0f, 0);
        super.onTouchEvent(r8);
    L9:
        Behavior r7 = ((LayoutParams) this.mBehaviorTouchView.getLayoutParams()).getBehavior();
        if (r7 == null) goto L7;
        r6 = r7.onTouchEvent(this, this.mBehaviorTouchView, r18);
        goto L12
    L8:
        r3 = false;
        goto L9
    }

    public void recordLastChildRect(View r1, Rect r2) {
        ((LayoutParams) r1.getLayoutParams()).setLastChildRect(r2);
    }

    public void removePreDrawListener() {
        if (this.mIsAttachedToWindow == true) goto L5;
    L7:
        this.mNeedsPreDrawListener = false;
        return;
    L5:
        if (this.mOnPreDrawListener == null) goto L7;
        getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View r2, Rect r3, boolean r4) {
        Behavior r0 = ((LayoutParams) r2.getLayoutParams()).getBehavior();
        if (r0 == null) goto L9;
        if (r0.onRequestChildRectangleOnScreen(this, r2, r3, r4) == false) goto L9;
        return true;
    L9:
        return super.requestChildRectangleOnScreen(r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r1) {
        super.requestDisallowInterceptTouchEvent(r1);
        if (r1 == true) goto L5;
        return;
    L5:
        if (this.mDisallowInterceptReset == true) goto L9;
        resetTouchBehaviors(false);
        this.mDisallowInterceptReset = true;
        return;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean r1) {
        super.setFitsSystemWindows(r1);
        setupForInsets();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener r1) {
        this.mOnHierarchyChangeListener = r1;
    }

    public void setStatusBarBackground(@Nullable Drawable r3) {
        Drawable r0 = this.mStatusBarBackground;
        if (r0 == r3) goto L21;
        Drawable r1 = null;
        if (r0 == null) goto L7;
        r0.setCallback(null);
    L7:
        if (r3 == null) goto L9;
        r1 = r3.mutate();
    L9:
        this.mStatusBarBackground = r1;
        if (r1 != null) goto L12;
    L19:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L12:
        if (r1.isStateful() == false) goto L14;
        this.mStatusBarBackground.setState(getDrawableState());
    L14:
        DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
        Drawable r4 = this.mStatusBarBackground;
        if (getVisibility() != 0) goto L17;
        boolean r2 = true;
    L18:
        r4.setVisible(r2, false);
        this.mStatusBarBackground.setCallback(this);
        goto L19
    L17:
        r2 = false;
        goto L18
    }

    public void setStatusBarBackgroundColor(@ColorInt int r2) {
        setStatusBarBackground(new ColorDrawable(r2));
    }

    public void setStatusBarBackgroundResource(@DrawableRes int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = ContextCompat.getDrawable(getContext(), r2);
    L5:
        setStatusBarBackground(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        super.setVisibility(r3);
        if (r3 != 0) goto L5;
        boolean r4 = true;
    L6:
        Drawable r1 = this.mStatusBarBackground;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isVisible() == r4) goto L13;
        this.mStatusBarBackground.setVisible(r4, false);
        return;
    L13:
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final WindowInsetsCompat setWindowInsets(WindowInsetsCompat r4) {
        if (ObjectsCompat.equals(this.mLastInsets, r4) == true) goto L17;
        this.mLastInsets = r4;
        boolean r0 = false;
        if (r4 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        this.mDrawStatusBarBackground = r2;
        if (r2 == false) goto L13;
    L15:
        setWillNotDraw(r0);
        WindowInsetsCompat r5 = dispatchApplyWindowInsetsToBehaviors(r4);
        requestLayout();
        return r5;
    L13:
        if (getBackground() != null) goto L15;
        r0 = true;
        goto L15
    L7:
        if (r4.getSystemWindowInsetTop() <= 0) goto L9;
        r2 = true;
        goto L10
    L17:
        return r4;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r2) {
        if (super.verifyDrawable(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (r2 == this.mStatusBarBackground) goto L8;
        return false;
    }

    public CoordinatorLayout(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.coordinatorLayoutStyle);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r17, int r18, int r19, int[] r20, int r21) {
        int r9 = getChildCount();
        boolean r0 = false;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r11 >= r9) goto L25;
        View r2 = getChildAt(r11);
        if (r2.getVisibility() == 8) goto L24;
        LayoutParams r1 = (LayoutParams) r2.getLayoutParams();
        if (r1.isNestedScrollAccepted(r21) == false) goto L24;
        Behavior r3 = r1.getBehavior();
        if (r3 == null) goto L24;
        int[] r6 = this.mBehaviorConsumed;
        r6[0] = 0;
        r6[1] = 0;
        r3.onNestedPreScroll(this, r2, r17, r18, r19, r6, r21);
        int[] r4 = this.mBehaviorConsumed;
        if (r18 <= 0) goto L17;
        int r5 = Math.max(r12, r4[0]);
    L16:
        r12 = r5;
        int[] r7 = this.mBehaviorConsumed;
        if (r19 <= 0) goto L22;
        int r8 = Math.max(r13, r7[1]);
    L21:
        r13 = r8;
        r0 = true;
        goto L24
    L22:
        r8 = Math.min(r13, r7[1]);
        goto L21
    L17:
        r5 = Math.min(r12, r4[0]);
    L24:
        r11 = r11 + 1;
        goto L4
    L25:
        r20[0] = r12;
        r20[1] = r13;
        if (r0 == false) goto L34;
        onChildViewsChanged(1);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r9, int r10, int r11, int r12, int r13, int r14) {
        onNestedScroll(r9, r10, r11, r12, r13, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r10, View r11, int r12, int r13) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(r10, r11, r12, r13);
        this.mNestedScrollingTarget = r11;
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        View r4 = getChildAt(r1);
        LayoutParams r2 = (LayoutParams) r4.getLayoutParams();
        if (r2.isNestedScrollAccepted(r13) == false) goto L10;
        Behavior r3 = r2.getBehavior();
        if (r3 == null) goto L10;
        r3.onNestedScrollAccepted(this, r4, r10, r11, r12, r13);
    L10:
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r15, View r16, int r17, int r18) {
        int r8 = getChildCount();
        int r10 = 0;
        boolean r11 = false;
    L3:
        if (r10 >= r8) goto L12;
        View r2 = getChildAt(r10);
        if (r2.getVisibility() == 8) goto L11;
        LayoutParams r13 = (LayoutParams) r2.getLayoutParams();
        Behavior r0 = r13.getBehavior();
        if (r0 == null) goto L10;
        boolean r1 = r0.onStartNestedScroll(this, r2, r15, r16, r17, r18);
        r11 = r11 | r1;
        r13.setNestedScrollAccepted(r18, r1);
        goto L11
    L10:
        r13.setNestedScrollAccepted(r18, false);
    L11:
        r10 = r10 + 1;
        goto L3
    L12:
        return r11;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r6, int r7) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(r6, r7);
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        View r2 = getChildAt(r1);
        LayoutParams r3 = (LayoutParams) r2.getLayoutParams();
        if (r3.isNestedScrollAccepted(r7) == false) goto L11;
        Behavior r4 = r3.getBehavior();
        if (r4 == null) goto L10;
        r4.onStopNestedScroll(this, r2, r6, r7);
    L10:
        r3.resetNestedScroll(r7);
        r3.resetChangedAfterNestedScroll();
    L11:
        r1 = r1 + 1;
        goto L3
    L12:
        this.mNestedScrollingTarget = null;
    }

    public CoordinatorLayout(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        super(r10, r11, r12);
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new DirectedAcyclicGraph();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        int r0 = 0;
        if (r12 != 0) goto L5;
        TypedArray r1 = r10.obtainStyledAttributes(r11, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
    L6:
        if (r12 != 0) goto L8;
        saveAttributeDataForStyleable(r10, R.styleable.CoordinatorLayout, r11, r1, 0, R.style.Widget_Support_CoordinatorLayout);
    L9:
        int r13 = r1.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (r13 == 0) goto L14;
        Resources r14 = r10.getResources();
        this.mKeylines = r14.getIntArray(r13);
        float r15 = r14.getDisplayMetrics().density;
        int r16 = this.mKeylines.length;
    L12:
        if (r0 >= r16) goto L14;
        int[] r17 = this.mKeylines;
        r17[r0] = (int) (r17[r0] * r15);
        r0 = r0 + 1;
    L14:
        this.mStatusBarBackground = r1.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        r1.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L19;
        ViewCompat.setImportantForAccessibility(this, 1);
        return;
    L19:
        return;
    L8:
        saveAttributeDataForStyleable(r10, R.styleable.CoordinatorLayout, r11, r1, r12, 0);
        goto L9
    L5:
        r1 = r10.obtainStyledAttributes(r11, R.styleable.CoordinatorLayout, r12, 0);
        goto L6
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View r18, int r19, int r20, int r21, int r22, int r23, @NonNull int[] r24) {
        int r11 = getChildCount();
        boolean r0 = false;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r13 >= r11) goto L24;
        View r2 = getChildAt(r13);
        if (r2.getVisibility() == 8) goto L23;
        LayoutParams r1 = (LayoutParams) r2.getLayoutParams();
        if (r1.isNestedScrollAccepted(r23) == false) goto L23;
        Behavior r3 = r1.getBehavior();
        if (r3 == null) goto L23;
        int[] r7 = this.mBehaviorConsumed;
        r7[0] = 0;
        r7[1] = 0;
        r3.onNestedScroll(this, r2, r18, r19, r20, r21, r22, r23, r7);
        int[] r4 = this.mBehaviorConsumed;
        if (r21 <= 0) goto L17;
        int r5 = Math.max(r14, r4[0]);
    L16:
        r14 = r5;
        if (r22 <= 0) goto L21;
        boolean r6 = true;
        int r8 = Math.max(r15, this.mBehaviorConsumed[1]);
    L20:
        r15 = r8;
        r0 = r6;
        goto L23
    L21:
        r6 = true;
        r8 = Math.min(r15, this.mBehaviorConsumed[1]);
        goto L20
    L17:
        r5 = Math.min(r14, r4[0]);
    L23:
        r13 = r13 + 1;
        goto L4
    L24:
        r24[0] = r24[0] + r14;
        r24[1] = r24[1] + r15;
        if (r0 == false) goto L33;
        onChildViewsChanged(1);
        return;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        if ((r1 instanceof LayoutParams) == false) goto L7;
        return new LayoutParams((LayoutParams) r1);
    L7:
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r1);
    L11:
        return new LayoutParams(r1);
    }
}
