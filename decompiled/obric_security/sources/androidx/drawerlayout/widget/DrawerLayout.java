package androidx.drawerlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    private static final boolean ALLOW_EDGE_LOCK = false;
    static final boolean CAN_HIDE_DESCENDANTS = false;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    private static final int DRAWER_ELEVATION = 10;
    static final int[] LAYOUT_ATTRS = null;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 160;
    private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION = false;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final int[] THEME_ATTRS = null;
    private static final float TOUCH_SLOP_SENSITIVITY = 1.0f;
    private final ChildAccessibilityDelegate mChildAccessibilityDelegate;
    private Rect mChildHitRect;
    private Matrix mChildInvertedMatrix;
    private boolean mChildrenCanceledTouch;
    private boolean mDisallowInterceptRequested;
    private boolean mDrawStatusBarBackground;
    private float mDrawerElevation;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final ViewDragCallback mLeftCallback;
    private final ViewDragHelper mLeftDragger;
    private DrawerListener mListener;
    private List<DrawerListener> mListeners;
    private int mLockModeEnd;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mLockModeStart;
    private int mMinDrawerMargin;
    private final ArrayList<View> mNonDrawerViews;
    private final ViewDragCallback mRightCallback;
    private final ViewDragHelper mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private Drawable mShadowEnd;
    private Drawable mShadowLeft;
    private Drawable mShadowLeftResolved;
    private Drawable mShadowRight;
    private Drawable mShadowRightResolved;
    private Drawable mShadowStart;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;

    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect;
        final /* synthetic */ DrawerLayout this$0;

        AccessibilityDelegate(DrawerLayout r1) {
            this.this$0 = r1;
            this.mTmpRect = new Rect();
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r4, AccessibilityNodeInfoCompat r5) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS == false) goto L5;
            super.onInitializeAccessibilityNodeInfo(r4, r5);
        L9:
            r5.setClassName(DrawerLayout.class.getName());
            r5.setFocusable(false);
            r5.setFocused(false);
            r5.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
            r5.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
            return;
        L5:
            AccessibilityNodeInfoCompat r0 = AccessibilityNodeInfoCompat.obtain(r5);
            super.onInitializeAccessibilityNodeInfo(r4, r0);
            r5.setSource(r4);
            Object r1 = ViewCompat.getParentForAccessibility(r4);
            if ((r1 instanceof View) == false) goto L8;
            r5.setParent((View) r1);
        L8:
            copyNodeInfoNoChildren(r5, r0);
            r0.recycle();
            addChildrenForAccessibility(r5, (ViewGroup) r4);
            goto L9
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r1, AccessibilityEvent r2) {
            super.onInitializeAccessibilityEvent(r1, r2);
            r2.setClassName(DrawerLayout.class.getName());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(View r3, AccessibilityEvent r4) {
            if (r4.getEventType() != 32) goto L12;
            List<CharSequence> r5 = r4.getText();
            View r6 = this.this$0.findVisibleDrawer();
            if (r6 == null) goto L13;
            int r7 = this.this$0.getDrawerViewAbsoluteGravity(r6);
            CharSequence r2 = this.this$0.getDrawerTitle(r7);
            if (r2 == null) goto L14;
            r5.add(r2);
            return true;
        L14:
            return true;
        L13:
            return true;
        L12:
            return super.dispatchPopulateAccessibilityEvent(r3, r4);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup r2, View r3, AccessibilityEvent r4) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS == true) goto L10;
            if (DrawerLayout.includeChildForAccessibility(r3) == true) goto L10;
            return false;
        L10:
            return super.onRequestSendAccessibilityEvent(r2, r3, r4);
        }

        private void addChildrenForAccessibility(AccessibilityNodeInfoCompat r4, ViewGroup r5) {
            int r3 = r5.getChildCount();
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L8;
            View r1 = r5.getChildAt(r0);
            if (DrawerLayout.includeChildForAccessibility(r1) == false) goto L7;
            r4.addChild(r1);
        L7:
            r0 = r0 + 1;
            goto L3
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat r1, AccessibilityNodeInfoCompat r2) {
            Rect r0 = this.mTmpRect;
            r2.getBoundsInParent(r0);
            r1.setBoundsInParent(r0);
            r2.getBoundsInScreen(r0);
            r1.setBoundsInScreen(r0);
            r1.setVisibleToUser(r2.isVisibleToUser());
            r1.setPackageName(r2.getPackageName());
            r1.setClassName(r2.getClassName());
            r1.setContentDescription(r2.getContentDescription());
            r1.setEnabled(r2.isEnabled());
            r1.setClickable(r2.isClickable());
            r1.setFocusable(r2.isFocusable());
            r1.setFocused(r2.isFocused());
            r1.setAccessibilityFocused(r2.isAccessibilityFocused());
            r1.setSelected(r2.isSelected());
            r1.setLongClickable(r2.isLongClickable());
            r1.addAction(r2.getActions());
        }
    }

    static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        ChildAccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r1, AccessibilityNodeInfoCompat r2) {
            super.onInitializeAccessibilityNodeInfo(r1, r2);
            if (DrawerLayout.includeChildForAccessibility(r1) == true) goto L6;
            r2.setParent(null);
            return;
        }
    }

    public interface DrawerListener {
        void onDrawerClosed(View r1);

        void onDrawerOpened(View r1);

        void onDrawerSlide(View r1, float r2);

        void onDrawerStateChanged(int r1);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int FLAG_IS_CLOSING = 4;
        private static final int FLAG_IS_OPENED = 1;
        private static final int FLAG_IS_OPENING = 2;
        public int gravity;
        boolean isPeeking;
        float onScreen;
        int openState;

        public LayoutParams(Context r3, AttributeSet r4) {
            super(r3, r4);
            this.gravity = 0;
            TypedArray r5 = r3.obtainStyledAttributes(r4, DrawerLayout.LAYOUT_ATTRS);
            this.gravity = r5.getInt(0, 0);
            r5.recycle();
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.gravity = 0;
        }

        public LayoutParams(int r1, int r2, int r3) {
            this(r1, r2);
            this.gravity = r3;
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.gravity = 0;
            this.gravity = r2.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.gravity = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.gravity = 0;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        int openDrawerGravity;

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.openDrawerGravity = 0;
            this.openDrawerGravity = r1.readInt();
            this.lockModeLeft = r1.readInt();
            this.lockModeRight = r1.readInt();
            this.lockModeStart = r1.readInt();
            this.lockModeEnd = r1.readInt();
        }

        public SavedState(Parcelable r1) {
            super(r1);
            this.openDrawerGravity = 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.openDrawerGravity);
            r1.writeInt(this.lockModeLeft);
            r1.writeInt(this.lockModeRight);
            r1.writeInt(this.lockModeStart);
            r1.writeInt(this.lockModeEnd);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public static abstract class SimpleDrawerListener implements DrawerListener {
        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(View r1) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(View r1) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerSlide(View r1, float r2) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerStateChanged(int r1) {
        }

        public SimpleDrawerListener() {
        }
    }

    private class ViewDragCallback extends ViewDragHelper.Callback {
        private final int mAbsGravity;
        private ViewDragHelper mDragger;
        private final Runnable mPeekRunnable;
        final /* synthetic */ DrawerLayout this$0;

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean onEdgeLock(int r1) {
            return false;
        }

        ViewDragCallback(DrawerLayout r1, int r2) {
            this.this$0 = r1;
            this.mPeekRunnable = new AnonymousClass1(this);
            this.mAbsGravity = r2;
        }

        public void setDragger(ViewDragHelper r1) {
            this.mDragger = r1;
        }

        public void removeCallbacks() {
            this.this$0.removeCallbacks(this.mPeekRunnable);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View r2, int r3) {
            if (this.this$0.isDrawerView(r2) == true) goto L5;
        L9:
            return false;
        L5:
            if (this.this$0.checkDrawerViewAbsoluteGravity(r2, this.mAbsGravity) == false) goto L9;
            if (this.this$0.getDrawerLockMode(r2) != 0) goto L9;
            return true;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int r3) {
            this.this$0.updateDrawerState(this.mAbsGravity, r3, this.mDragger.getCapturedView());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View r1, int r2, int r3, int r4, int r5) {
            int r6 = r1.getWidth();
            if (this.this$0.checkDrawerViewAbsoluteGravity(r1, 3) == false) goto L5;
            float r7 = r2 + r6;
        L6:
            float r8 = r7 / r6;
            this.this$0.setDrawerViewOffset(r1, r8);
            if (r8 != 0.0f) goto L9;
            int r9 = 4;
        L10:
            r1.setVisibility(r9);
            this.this$0.invalidate();
            return;
        L9:
            r9 = 0;
            goto L10
        L5:
            r7 = this.this$0.getWidth() - r2;
            goto L6
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View r1, int r2) {
            ((LayoutParams) r1.getLayoutParams()).isPeeking = false;
            closeOtherDrawer();
        }

        private void closeOtherDrawer() {
            int r1 = 3;
            if (this.mAbsGravity != 3) goto L5;
            r1 = 5;
        L5:
            View r0 = this.this$0.findDrawerWithGravity(r1);
            if (r0 == null) goto L9;
            this.this$0.closeDrawer(r0);
            return;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View r6, float r7, float r8) {
            float r9 = this.this$0.getDrawerViewOffset(r6);
            int r0 = r6.getWidth();
            if (this.this$0.checkDrawerViewAbsoluteGravity(r6, 3) == true) goto L5;
            int r1 = this.this$0.getWidth();
            if (r7 >= 0.0f) goto L15;
        L18:
            r1 = r1 - r0;
        L19:
            int r10 = r1;
        L20:
            this.mDragger.settleCapturedViewAt(r10, r6.getTop());
            this.this$0.invalidate();
            return;
        L15:
            if (r7 != 0.0f) goto L19;
            if (r9 <= 0.5f) goto L19;
        L5:
            if (r7 > 0.0f) goto L11;
            if (r7 == 0.0f) goto L8;
        L10:
            r10 = -r0;
            goto L20
        L8:
            if (r9 <= 0.5f) goto L10;
        L11:
            r10 = 0;
            goto L20
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeTouched(int r3, int r4) {
            this.this$0.postDelayed(this.mPeekRunnable, 160);
        }

        void peekDrawer() {
            int r0 = this.mDragger.getEdgeSize();
            int r3 = 0;
            if (this.mAbsGravity != 3) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L11;
            View r4 = this.this$0.findDrawerWithGravity(3);
            if (r4 == null) goto L10;
            r3 = -r4.getWidth();
        L10:
            int r5 = r3 + r0;
        L12:
            if (r4 == null) goto L23;
            if (r1 == true) goto L15;
        L16:
            if (r1 == false) goto L18;
            return;
        L18:
            if (r4.getLeft() > r5) goto L20;
            return;
        L20:
            if (this.this$0.getDrawerLockMode(r4) != 0) goto L26;
            LayoutParams r2 = (LayoutParams) r4.getLayoutParams();
            this.mDragger.smoothSlideViewTo(r4, r5, r4.getTop());
            r2.isPeeking = true;
            this.this$0.invalidate();
            closeOtherDrawer();
            this.this$0.cancelChildViewTouch();
            return;
        L26:
            return;
        L15:
            if (r4.getLeft() < r5) goto L20;
        L23:
            return;
        L11:
            r4 = this.this$0.findDrawerWithGravity(5);
            r5 = this.this$0.getWidth() - r0;
            goto L12
        L5:
            r1 = false;
            goto L6
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int r2, int r3) {
            if ((r2 & 1) != 1) goto L5;
            View r4 = this.this$0.findDrawerWithGravity(3);
        L6:
            if (r4 != null) goto L8;
            return;
        L8:
            if (this.this$0.getDrawerLockMode(r4) != 0) goto L12;
            this.mDragger.captureChildView(r4, r3);
            return;
        L12:
            return;
        L5:
            r4 = this.this$0.findDrawerWithGravity(5);
            goto L6
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View r1) {
            if (this.this$0.isDrawerView(r1) == true) goto L7;
            return 0;
        L7:
            return r1.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View r2, int r3, int r4) {
            if (this.this$0.checkDrawerViewAbsoluteGravity(r2, 3) == true) goto L5;
            int r1 = this.this$0.getWidth();
            return Math.max(r1 - r2.getWidth(), Math.min(r3, r1));
        L5:
            return Math.max(-r2.getWidth(), Math.min(r3, 0));
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View r1, int r2, int r3) {
            return r1.getTop();
        }
    }

    static {
        THEME_ATTRS = new int[]{R.attr.colorPrimaryDark};
        LAYOUT_ATTRS = new int[]{R.attr.layout_gravity};
        CAN_HIDE_DESCENDANTS = true;
        SET_DRAWER_SHADOW_FROM_ELEVATION = true;
    }

    public DrawerLayout(Context r2) {
        this(r2, null);
    }

    public DrawerLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public DrawerLayout(Context r6, AttributeSet r7, int r8) {
        super(r6, r7, r8);
        this.mChildAccessibilityDelegate = new ChildAccessibilityDelegate();
        this.mScrimColor = DEFAULT_SCRIM_COLOR;
        this.mScrimPaint = new Paint();
        this.mFirstLayout = true;
        this.mLockModeLeft = 3;
        this.mLockModeRight = 3;
        this.mLockModeStart = 3;
        this.mLockModeEnd = 3;
        this.mShadowStart = null;
        this.mShadowEnd = null;
        this.mShadowLeft = null;
        this.mShadowRight = null;
        setDescendantFocusability(262144);
        float r0 = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) ((64.0f * r0) + 0.5f);
        float r1 = 400.0f * r0;
        ViewDragCallback r2 = new ViewDragCallback(this, 3);
        this.mLeftCallback = r2;
        ViewDragCallback r9 = new ViewDragCallback(this, 5);
        this.mRightCallback = r9;
        ViewDragHelper r4 = ViewDragHelper.create(this, 1.0f, r2);
        this.mLeftDragger = r4;
        r4.setEdgeTrackingEnabled(1);
        r4.setMinVelocity(r1);
        r2.setDragger(r4);
        ViewDragHelper r3 = ViewDragHelper.create(this, 1.0f, r9);
        this.mRightDragger = r3;
        r3.setEdgeTrackingEnabled(2);
        r3.setMinVelocity(r1);
        r9.setDragger(r3);
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate(this));
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L10;
        setOnApplyWindowInsetsListener(new AnonymousClass1(this));
        setSystemUiVisibility(1280);
        TypedArray r10 = r6.obtainStyledAttributes(THEME_ATTRS);
        this.mStatusBarBackground = r10.getDrawable(0);     // Catch: Throwable -> L7
        r10.recycle();
    L7:
        th = move-exception;
        r10.recycle();
        throw th;
    L10:
        this.mDrawerElevation = r0 * 10.0f;
        this.mNonDrawerViews = new ArrayList();
    }

    public void setDrawerElevation(float r3) {
        this.mDrawerElevation = r3;
        int r4 = 0;
    L4:
        if (r4 >= getChildCount()) goto L9;
        View r0 = getChildAt(r4);
        if (isDrawerView(r0) == false) goto L8;
        ViewCompat.setElevation(r0, this.mDrawerElevation);
    L8:
        r4 = r4 + 1;
        goto L4
    }

    public float getDrawerElevation() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == true) goto L5;
        return 0.0f;
    L5:
        return this.mDrawerElevation;
    }

    public void setChildInsets(Object r1, boolean r2) {
        this.mLastInsets = r1;
        this.mDrawStatusBarBackground = r2;
        if (r2 == false) goto L5;
    L7:
        boolean r3 = false;
    L8:
        setWillNotDraw(r3);
        requestLayout();
        return;
    L5:
        if (getBackground() != null) goto L7;
        r3 = true;
        goto L8
    }

    public void setDrawerShadow(Drawable r3, int r4) {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == false) goto L6;
        return;
    L6:
        if ((r4 & GravityCompat.START) != 8388611) goto L9;
        this.mShadowStart = r3;
    L17:
        resolveShadowDrawables();
        invalidate();
        return;
    L9:
        if ((r4 & GravityCompat.END) != 8388613) goto L12;
        this.mShadowEnd = r3;
        goto L17
    L12:
        if ((r4 & 3) != 3) goto L15;
        this.mShadowLeft = r3;
        goto L17
    L15:
        if ((r4 & 5) != 5) goto L19;
        this.mShadowRight = r3;
        goto L17
    }

    public void setDrawerShadow(int r2, int r3) {
        setDrawerShadow(ContextCompat.getDrawable(getContext(), r2), r3);
    }

    public void setScrimColor(int r1) {
        this.mScrimColor = r1;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(DrawerListener r2) {
        DrawerListener r0 = this.mListener;
        if (r0 == null) goto L5;
        removeDrawerListener(r0);
    L5:
        if (r2 == null) goto L7;
        addDrawerListener(r2);
    L7:
        this.mListener = r2;
    }

    public void addDrawerListener(DrawerListener r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.mListeners != null) goto L7;
        this.mListeners = new ArrayList();
    L7:
        this.mListeners.add(r2);
    }

    public void removeDrawerListener(DrawerListener r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        List<DrawerListener> r0 = this.mListeners;
        if (r0 != null) goto L7;
        return;
    L7:
        r0.remove(r1);
    }

    public void setDrawerLockMode(int r2) {
        setDrawerLockMode(r2, 3);
        setDrawerLockMode(r2, 5);
    }

    public void setDrawerLockMode(int r4, int r5) {
        int r0 = GravityCompat.getAbsoluteGravity(r5, ViewCompat.getLayoutDirection(this));
        if (r5 != 3) goto L5;
        this.mLockModeLeft = r4;
    L15:
        if (r4 == 0) goto L21;
        if (r0 != 3) goto L18;
        ViewDragHelper r6 = this.mLeftDragger;
    L19:
        r6.cancel();
        goto L21
    L18:
        r6 = this.mRightDragger;
    L21:
        if (r4 != 1) goto L23;
        View r7 = findDrawerWithGravity(r0);
        if (r7 == null) goto L34;
        closeDrawer(r7);
        return;
    L34:
        return;
    L23:
        if (r4 != 2) goto L35;
        View r8 = findDrawerWithGravity(r0);
        if (r8 == null) goto L32;
        openDrawer(r8);
        return;
    L32:
        return;
    L35:
        return;
    L5:
        if (r5 != 5) goto L7;
        this.mLockModeRight = r4;
        goto L15
    L7:
        if (r5 != 8388611) goto L9;
        this.mLockModeStart = r4;
        goto L15
    L9:
        if (r5 != 8388613) goto L15;
        this.mLockModeEnd = r4;
        goto L15
    }

    public void setDrawerLockMode(int r2, View r3) {
        if (isDrawerView(r3) == false) goto L7;
        setDrawerLockMode(r2, ((LayoutParams) r3.getLayoutParams()).gravity);
        return;
    L7:
        throw new IllegalArgumentException("View " + r3 + " is not a drawer with appropriate layout_gravity");
    }

    public int getDrawerLockMode(int r4) {
        int r0 = ViewCompat.getLayoutDirection(this);
        if (r4 != 3) goto L5;
        int r5 = this.mLockModeLeft;
        if (r5 == 3) goto L38;
        return r5;
    L38:
        if (r0 != 0) goto L40;
        int r3 = this.mLockModeStart;
    L41:
        if (r3 == 3) goto L47;
        return r3;
    L47:
        return 0;
    L40:
        r3 = this.mLockModeEnd;
        goto L41
    L5:
        if (r4 != 5) goto L7;
        int r6 = this.mLockModeRight;
        if (r6 == 3) goto L30;
        return r6;
    L30:
        if (r0 != 0) goto L32;
        int r7 = this.mLockModeEnd;
    L33:
        if (r7 == 3) goto L46;
        return r7;
    L46:
        return 0;
    L32:
        r7 = this.mLockModeStart;
        goto L33
    L7:
        if (r4 != 8388611) goto L9;
        int r8 = this.mLockModeStart;
        if (r8 == 3) goto L22;
        return r8;
    L22:
        if (r0 != 0) goto L24;
        int r9 = this.mLockModeLeft;
    L25:
        if (r9 == 3) goto L45;
        return r9;
    L45:
        return 0;
    L24:
        r9 = this.mLockModeRight;
        goto L25
    L9:
        if (r4 != 8388613) goto L48;
        int r10 = this.mLockModeEnd;
        if (r10 == 3) goto L14;
        return r10;
    L14:
        if (r0 != 0) goto L16;
        int r11 = this.mLockModeRight;
    L17:
        if (r11 == 3) goto L43;
        return r11;
    L43:
        return 0;
    L16:
        r11 = this.mLockModeLeft;
        goto L17
    L48:
        return 0;
    }

    public int getDrawerLockMode(View r3) {
        if (isDrawerView(r3) == false) goto L7;
        return getDrawerLockMode(((LayoutParams) r3.getLayoutParams()).gravity);
    L7:
        throw new IllegalArgumentException("View " + r3 + " is not a drawer");
    }

    public void setDrawerTitle(int r2, CharSequence r3) {
        int r4 = GravityCompat.getAbsoluteGravity(r2, ViewCompat.getLayoutDirection(this));
        if (r4 != 3) goto L6;
        this.mTitleLeft = r3;
        return;
    L6:
        if (r4 != 5) goto L10;
        this.mTitleRight = r3;
        return;
    }

    public CharSequence getDrawerTitle(int r2) {
        int r3 = GravityCompat.getAbsoluteGravity(r2, ViewCompat.getLayoutDirection(this));
        if (r3 != 3) goto L7;
        return this.mTitleLeft;
    L7:
        if (r3 == 5) goto L9;
        return null;
    L9:
        return this.mTitleRight;
    }

    private boolean isInBoundsOfChild(float r2, float r3, View r4) {
        if (this.mChildHitRect != null) goto L5;
        this.mChildHitRect = new Rect();
    L5:
        r4.getHitRect(this.mChildHitRect);
        return this.mChildHitRect.contains((int) r2, (int) r3);
    }

    private boolean dispatchTransformedGenericPointerEvent(MotionEvent r3, View r4) {
        if (r4.getMatrix().isIdentity() == true) goto L5;
        MotionEvent r2 = getTransformedMotionEvent(r3, r4);
        boolean r5 = r4.dispatchGenericMotionEvent(r2);
        r2.recycle();
        return r5;
    L5:
        float r0 = getScrollX() - r4.getLeft();
        float r6 = getScrollY() - r4.getTop();
        r3.offsetLocation(r0, r6);
        boolean r7 = r4.dispatchGenericMotionEvent(r3);
        r3.offsetLocation(-r0, -r6);
        return r7;
    }

    private MotionEvent getTransformedMotionEvent(MotionEvent r4, View r5) {
        float r0 = getScrollX() - r5.getLeft();
        float r1 = getScrollY() - r5.getTop();
        MotionEvent r6 = MotionEvent.obtain(r4);
        r6.offsetLocation(r0, r1);
        Matrix r7 = r5.getMatrix();
        if (r7.isIdentity() == false) goto L5;
    L8:
        return r6;
    L5:
        if (this.mChildInvertedMatrix != null) goto L7;
        this.mChildInvertedMatrix = new Matrix();
    L7:
        r7.invert(this.mChildInvertedMatrix);
        r6.transform(this.mChildInvertedMatrix);
        goto L8
    }

    void updateDrawerState(int r4, int r5, View r6) {
        int r7 = this.mLeftDragger.getViewDragState();
        int r0 = this.mRightDragger.getViewDragState();
        if (r7 == 1) goto L11;
        if (r0 == 1) goto L11;
        int r2 = 2;
        if (r7 == 2) goto L12;
        if (r0 == 2) goto L12;
        r2 = 0;
    L12:
        if (r6 == null) goto L21;
        if (r5 != 0) goto L21;
        LayoutParams r8 = (LayoutParams) r6.getLayoutParams();
        if (r8.onScreen != 0.0f) goto L18;
        dispatchOnDrawerClosed(r6);
        goto L21
    L18:
        if (r8.onScreen != 1.0f) goto L21;
        dispatchOnDrawerOpened(r6);
    L21:
        if (r2 == this.mDrawerState) goto L27;
        this.mDrawerState = r2;
        List<DrawerListener> r9 = this.mListeners;
        if (r9 == null) goto L29;
        int r10 = r9.size() - 1;
    L25:
        if (r10 < 0) goto L30;
        this.mListeners.get(r10).onDrawerStateChanged(r2);
        r10 = r10 - 1;
        goto L25
    L30:
        return;
    L29:
        return;
    L27:
        return;
    L11:
        r2 = 1;
        goto L12
    }

    void dispatchOnDrawerClosed(View r4) {
        LayoutParams r0 = (LayoutParams) r4.getLayoutParams();
        if ((r0.openState & 1) != 1) goto L16;
        r0.openState = 0;
        List<DrawerListener> r1 = this.mListeners;
        if (r1 == null) goto L9;
        int r2 = r1.size() - 1;
    L7:
        if (r2 < 0) goto L9;
        this.mListeners.get(r2).onDrawerClosed(r4);
        r2 = r2 - 1;
    L9:
        updateChildrenImportantForAccessibility(r4, false);
        if (hasWindowFocus() == false) goto L17;
        View r3 = getRootView();
        if (r3 == null) goto L18;
        r3.sendAccessibilityEvent(32);
        return;
    L18:
        return;
    L17:
        return;
    }

    void dispatchOnDrawerOpened(View r4) {
        LayoutParams r0 = (LayoutParams) r4.getLayoutParams();
        if ((r0.openState & 1) != 0) goto L14;
        r0.openState = 1;
        List<DrawerListener> r1 = this.mListeners;
        if (r1 == null) goto L9;
        int r2 = r1.size() - 1;
    L7:
        if (r2 < 0) goto L9;
        this.mListeners.get(r2).onDrawerOpened(r4);
        r2 = r2 - 1;
    L9:
        updateChildrenImportantForAccessibility(r4, true);
        if (hasWindowFocus() == false) goto L15;
        sendAccessibilityEvent(32);
        return;
    L15:
        return;
    }

    private void updateChildrenImportantForAccessibility(View r5, boolean r6) {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        View r2 = getChildAt(r1);
        if (r6 == false) goto L7;
    L8:
        if (r6 == false) goto L11;
        if (r2 != r5) goto L11;
    L10:
        ViewCompat.setImportantForAccessibility(r2, 1);
    L12:
        r1 = r1 + 1;
    L11:
        ViewCompat.setImportantForAccessibility(r2, 4);
        goto L12
    L7:
        if (isDrawerView(r2) == false) goto L10;
    }

    void dispatchOnDrawerSlide(View r3, float r4) {
        List<DrawerListener> r0 = this.mListeners;
        if (r0 == null) goto L7;
        int r1 = r0.size() - 1;
    L5:
        if (r1 < 0) goto L9;
        this.mListeners.get(r1).onDrawerSlide(r3, r4);
        r1 = r1 - 1;
        goto L5
    L9:
        return;
    }

    void setDrawerViewOffset(View r3, float r4) {
        LayoutParams r0 = (LayoutParams) r3.getLayoutParams();
        if (r4 != r0.onScreen) goto L5;
        return;
    L5:
        r0.onScreen = r4;
        dispatchOnDrawerSlide(r3, r4);
    }

    float getDrawerViewOffset(View r1) {
        return ((LayoutParams) r1.getLayoutParams()).onScreen;
    }

    int getDrawerViewAbsoluteGravity(View r1) {
        return GravityCompat.getAbsoluteGravity(((LayoutParams) r1.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
    }

    boolean checkDrawerViewAbsoluteGravity(View r1, int r2) {
        if ((getDrawerViewAbsoluteGravity(r1) & r2) != r2) goto L5;
        return true;
    L5:
        return false;
    }

    View findOpenDrawer() {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        View r2 = getChildAt(r1);
        if ((((LayoutParams) r2.getLayoutParams()).openState & 1) == 1) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    void moveDrawerToOffset(View r3, float r4) {
        float r0 = getDrawerViewOffset(r3);
        float r1 = r3.getWidth();
        int r2 = ((int) (r1 * r4)) - ((int) (r0 * r1));
        if (checkDrawerViewAbsoluteGravity(r3, 3) == true) goto L6;
        r2 = -r2;
    L6:
        r3.offsetLeftAndRight(r2);
        setDrawerViewOffset(r3, r4);
    }

    View findDrawerWithGravity(int r5) {
        int r6 = GravityCompat.getAbsoluteGravity(r5, ViewCompat.getLayoutDirection(this)) & 7;
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        View r2 = getChildAt(r1);
        if ((getDrawerViewAbsoluteGravity(r2) & 7) == r6) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    static String gravityToString(int r2) {
        if ((r2 & 3) != 3) goto L7;
        return "LEFT";
    L7:
        if ((r2 & 5) != 5) goto L11;
        return "RIGHT";
    L11:
        return Integer.toHexString(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.View
    protected void onMeasure(int r18, int r19) {
        int r1 = View.MeasureSpec.getMode(r18);
        int r2 = View.MeasureSpec.getMode(r19);
        int r3 = View.MeasureSpec.getSize(r18);
        int r4 = View.MeasureSpec.getSize(r19);
        if (r1 != 1073741824) goto L6;
        if (r2 != 1073741824) goto L6;
    L16:
        setMeasuredDimension(r3, r4);
        if (this.mLastInsets != null) goto L19;
    L21:
        boolean r5 = false;
    L22:
        int r7 = ViewCompat.getLayoutDirection(this);
        int r8 = getChildCount();
        int r9 = 0;
        boolean r10 = false;
        boolean r11 = false;
    L23:
        if (r9 >= r8) goto L72;
        View r12 = getChildAt(r9);
        if (r12.getVisibility() == 8) goto L69;
        LayoutParams r13 = (LayoutParams) r12.getLayoutParams();
        if (r5 == false) goto L44;
        int r15 = GravityCompat.getAbsoluteGravity(r13.gravity, r7);
        if (ViewCompat.getFitsSystemWindows(r12) == false) goto L37;
        WindowInsets r6 = (WindowInsets) this.mLastInsets;
        if (r15 != 3) goto L34;
        r6 = r6.replaceSystemWindowInsets(r6.getSystemWindowInsetLeft(), r6.getSystemWindowInsetTop(), 0, r6.getSystemWindowInsetBottom());
    L36:
        r12.dispatchApplyWindowInsets(r6);
        goto L44
    L34:
        if (r15 != 5) goto L36;
        r6 = r6.replaceSystemWindowInsets(0, r6.getSystemWindowInsetTop(), r6.getSystemWindowInsetRight(), r6.getSystemWindowInsetBottom());
        goto L36
    L37:
        WindowInsets r14 = (WindowInsets) this.mLastInsets;
        if (r15 != 3) goto L40;
        r14 = r14.replaceSystemWindowInsets(r14.getSystemWindowInsetLeft(), r14.getSystemWindowInsetTop(), 0, r14.getSystemWindowInsetBottom());
    L42:
        r13.leftMargin = r14.getSystemWindowInsetLeft();
        r13.topMargin = r14.getSystemWindowInsetTop();
        r13.rightMargin = r14.getSystemWindowInsetRight();
        r13.bottomMargin = r14.getSystemWindowInsetBottom();
        goto L44
    L40:
        if (r15 != 5) goto L42;
        r14 = r14.replaceSystemWindowInsets(0, r14.getSystemWindowInsetTop(), r14.getSystemWindowInsetRight(), r14.getSystemWindowInsetBottom());
    L44:
        if (isContentView(r12) == false) goto L48;
        r12.measure(View.MeasureSpec.makeMeasureSpec((r3 - r13.leftMargin) - r13.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((r4 - r13.topMargin) - r13.bottomMargin, 1073741824));
        goto L69
    L48:
        if (isDrawerView(r12) == false) goto L71;
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == false) goto L54;
        float r16 = ViewCompat.getElevation(r12);
        float r17 = this.mDrawerElevation;
        if (r16 == r17) goto L54;
        ViewCompat.setElevation(r12, r17);
    L54:
        int r20 = getDrawerViewAbsoluteGravity(r12) & 7;
        if (r20 != 3) goto L57;
        boolean r110 = true;
    L58:
        if (r110 == false) goto L60;
        if (r10 == false) goto L60;
    L64:
        throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(r20) + " but this DrawerLayout already has a drawer view along that edge");
    L60:
        if (r110 == true) goto L65;
        if (r11 == true) goto L64;
    L65:
        if (r110 == false) goto L67;
        r10 = true;
    L68:
        r12.measure(getChildMeasureSpec(r18, (this.mMinDrawerMargin + r13.leftMargin) + r13.rightMargin, r13.width), getChildMeasureSpec(r19, r13.topMargin + r13.bottomMargin, r13.height));
        goto L69
    L67:
        r11 = true;
        goto L68
    L57:
        r110 = false;
        goto L58
    L71:
        throw new IllegalStateException("Child " + r12 + " at index " + r9 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
    L69:
        r9 = r9 + 1;
        goto L23
    L72:
        return;
    L19:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L21;
        r5 = true;
    L6:
        if (isInEditMode() == false) goto L74;
        if (r1 == Integer.MIN_VALUE) goto L12;
        if (r1 != 0) goto L12;
        r3 = 300;
    L12:
        if (r2 == Integer.MIN_VALUE) goto L16;
        if (r2 != 0) goto L16;
        r4 = 300;
        goto L16
    L74:
        throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
    }

    private void resolveShadowDrawables() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == false) goto L5;
        return;
    L5:
        this.mShadowLeftResolved = resolveLeftShadow();
        this.mShadowRightResolved = resolveRightShadow();
    }

    private Drawable resolveLeftShadow() {
        int r0 = ViewCompat.getLayoutDirection(this);
        if (r0 != 0) goto L8;
        Drawable r1 = this.mShadowStart;
        if (r1 == null) goto L13;
        mirror(r1, r0);
        return this.mShadowStart;
    L13:
        return this.mShadowLeft;
    L8:
        Drawable r2 = this.mShadowEnd;
        if (r2 == null) goto L13;
        mirror(r2, r0);
        return this.mShadowEnd;
    }

    private Drawable resolveRightShadow() {
        int r0 = ViewCompat.getLayoutDirection(this);
        if (r0 != 0) goto L8;
        Drawable r1 = this.mShadowEnd;
        if (r1 == null) goto L13;
        mirror(r1, r0);
        return this.mShadowEnd;
    L13:
        return this.mShadowRight;
    L8:
        Drawable r2 = this.mShadowStart;
        if (r2 == null) goto L13;
        mirror(r2, r0);
        return this.mShadowStart;
    }

    private boolean mirror(Drawable r1, int r2) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (DrawableCompat.isAutoMirrored(r1) == false) goto L10;
        DrawableCompat.setLayoutDirection(r1, r2);
        return true;
    L10:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        boolean r1 = true;
        this.mInLayout = true;
        int r2 = r20 - r18;
        int r3 = getChildCount();
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L41;
        View r6 = getChildAt(r5);
        if (r6.getVisibility() == 8) goto L40;
        LayoutParams r7 = (LayoutParams) r6.getLayoutParams();
        if (isContentView(r6) == false) goto L10;
        r6.layout(r7.leftMargin, r7.topMargin, r7.leftMargin + r6.getMeasuredWidth(), r7.topMargin + r6.getMeasuredHeight());
        goto L40
    L10:
        int r8 = r6.getMeasuredWidth();
        int r9 = r6.getMeasuredHeight();
        if (checkDrawerViewAbsoluteGravity(r6, 3) == false) goto L13;
        float r11 = r8;
        int r10 = (-r8) + ((int) (r7.onScreen * r11));
        float r12 = (r8 + r10) / r11;
    L15:
        if (r12 == r7.onScreen) goto L17;
        boolean r13 = r1;
    L18:
        int r14 = r7.gravity & 112;
        if (r14 != 16) goto L21;
        int r15 = r21 - r19;
        int r16 = (r15 - r9) / 2;
        if (r16 >= r7.topMargin) goto L28;
        r16 = r7.topMargin;
    L30:
        r6.layout(r10, r16, r8 + r10, r9 + r16);
    L31:
        if (r13 == false) goto L34;
        setDrawerViewOffset(r6, r12);
    L34:
        if (r7.onScreen <= 0.0f) goto L36;
        int r4 = 0;
    L38:
        if (r6.getVisibility() == r4) goto L40;
        r6.setVisibility(r4);
        goto L40
    L36:
        r4 = 4;
        goto L38
    L28:
        if ((r16 + r9) <= (r15 - r7.bottomMargin)) goto L30;
        r16 = (r15 - r7.bottomMargin) - r9;
        goto L30
    L21:
        if (r14 == 80) goto L23;
        r6.layout(r10, r7.topMargin, r8 + r10, r7.topMargin + r9);
        goto L31
    L23:
        int r22 = r21 - r19;
        r6.layout(r10, (r22 - r7.bottomMargin) - r6.getMeasuredHeight(), r8 + r10, r22 - r7.bottomMargin);
        goto L31
    L17:
        r13 = false;
        goto L18
    L13:
        float r110 = r8;
        int r111 = r2 - ((int) (r7.onScreen * r110));
        r12 = (r2 - r111) / r110;
        r10 = r111;
    L40:
        r5 = r5 + 1;
        r1 = true;
        goto L3
    L41:
        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInLayout == true) goto L6;
        super.requestLayout();
        return;
    }

    @Override // android.view.View
    public void computeScroll() {
        int r0 = getChildCount();
        float r1 = 0.0f;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1 = Math.max(r1, ((LayoutParams) getChildAt(r2).getLayoutParams()).onScreen);
        r2 = r2 + 1;
        goto L3
    L5:
        this.mScrimOpacity = r1;
        boolean r3 = this.mLeftDragger.continueSettling(true);
        boolean r4 = this.mRightDragger.continueSettling(true);
        if (r3 == true) goto L8;
        if (r4 == true) goto L8;
        return;
    L8:
        ViewCompat.postInvalidateOnAnimation(this);
    }

    private static boolean hasOpaqueBackground(View r2) {
        Drawable r3 = r2.getBackground();
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.getOpacity() != (-1)) goto L9;
        return true;
    L9:
        return false;
    }

    public void setStatusBarBackground(Drawable r1) {
        this.mStatusBarBackground = r1;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    public void setStatusBarBackground(int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = ContextCompat.getDrawable(getContext(), r2);
    L5:
        this.mStatusBarBackground = r3;
        invalidate();
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setStatusBarBackgroundColor(int r2) {
        this.mStatusBarBackground = new ColorDrawable(r2);
        invalidate();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r1) {
        resolveShadowDrawables();
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        super.onDraw(r5);
        if (this.mDrawStatusBarBackground == true) goto L5;
        return;
    L5:
        if (this.mStatusBarBackground == null) goto L14;
        Object r0 = this.mLastInsets;
        if (r0 == null) goto L9;
        int r1 = ((WindowInsets) r0).getSystemWindowInsetTop();
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
    protected boolean drawChild(Canvas r15, View r16, long r17) {
        int r3 = getHeight();
        boolean r4 = isContentView(r16);
        int r5 = getWidth();
        int r6 = r15.save();
        int r8 = 0;
        if (r4 == false) goto L27;
        int r9 = getChildCount();
        int r10 = 0;
        int r11 = 0;
    L5:
        if (r10 >= r9) goto L26;
        View r12 = getChildAt(r10);
        if (r12 == r16) goto L25;
        if (r12.getVisibility() != 0) goto L25;
        if (hasOpaqueBackground(r12) == false) goto L25;
        if (isDrawerView(r12) == false) goto L25;
        if (r12.getHeight() < r3) goto L25;
        if (checkDrawerViewAbsoluteGravity(r12, 3) == false) goto L22;
        int r13 = r12.getRight();
        if (r13 <= r11) goto L25;
        r11 = r13;
        goto L25
    L22:
        int r14 = r12.getLeft();
        if (r14 >= r5) goto L25;
        r5 = r14;
    L25:
        r10 = r10 + 1;
        goto L5
    L26:
        r15.clipRect(r11, 0, r5, getHeight());
        r8 = r11;
    L27:
        boolean r18 = super.drawChild(r15, r16, r17);
        r15.restoreToCount(r6);
        float r7 = this.mScrimOpacity;
        if (r7 <= 0.0f) goto L32;
        if (r4 == false) goto L32;
        int r2 = this.mScrimColor;
        this.mScrimPaint.setColor((r2 & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * r7)) << 24));
        r15.drawRect(r8, 0.0f, r5, getHeight(), this.mScrimPaint);
    L41:
        return r18;
    L32:
        if (this.mShadowLeftResolved == null) goto L37;
        if (checkDrawerViewAbsoluteGravity(r16, 3) == false) goto L37;
        int r19 = this.mShadowLeftResolved.getIntrinsicWidth();
        int r20 = r16.getRight();
        float r21 = Math.max(0.0f, Math.min(r20 / this.mLeftDragger.getEdgeSize(), 1.0f));
        this.mShadowLeftResolved.setBounds(r20, r16.getTop(), r19 + r20, r16.getBottom());
        this.mShadowLeftResolved.setAlpha((int) (r21 * 255.0f));
        this.mShadowLeftResolved.draw(r15);
    L37:
        if (this.mShadowRightResolved == null) goto L41;
        if (checkDrawerViewAbsoluteGravity(r16, 5) == false) goto L41;
        int r22 = this.mShadowRightResolved.getIntrinsicWidth();
        int r23 = r16.getLeft();
        float r24 = Math.max(0.0f, Math.min((getWidth() - r23) / this.mRightDragger.getEdgeSize(), 1.0f));
        this.mShadowRightResolved.setBounds(r23 - r22, r16.getTop(), r23, r16.getBottom());
        this.mShadowRightResolved.setAlpha((int) (r24 * 255.0f));
        this.mShadowRightResolved.draw(r15);
        goto L41
    }

    boolean isContentView(View r1) {
        if (((LayoutParams) r1.getLayoutParams()).gravity != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isDrawerView(View r2) {
        int r1 = GravityCompat.getAbsoluteGravity(((LayoutParams) r2.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(r2));
        if ((r1 & 3) == 0) goto L6;
        return true;
    L6:
        if ((r1 & 5) == 0) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r7) {
        int r0 = r7.getActionMasked();
        boolean r1 = this.mLeftDragger.shouldInterceptTouchEvent(r7) | this.mRightDragger.shouldInterceptTouchEvent(r7);
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L6;
    L12:
        closeDrawers(true);
        this.mDisallowInterceptRequested = false;
        this.mChildrenCanceledTouch = false;
    L13:
        boolean r8 = false;
    L23:
        if (r1 == true) goto L32;
        if (r8 == false) goto L26;
        return true;
    L26:
        if (hasPeekingDrawer() == false) goto L28;
        return true;
    L28:
        if (this.mChildrenCanceledTouch == false) goto L31;
        return true;
    L31:
        return false;
    L32:
        return true;
    L6:
        if (r0 == 2) goto L10;
        if (r0 == 3) goto L12;
    L10:
        if (this.mLeftDragger.checkTouchSlop(3) == false) goto L13;
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        goto L13
    L14:
        float r2 = r7.getX();
        float r9 = r7.getY();
        this.mInitialMotionX = r2;
        this.mInitialMotionY = r9;
        if (this.mScrimOpacity <= 0.0f) goto L21;
        View r10 = this.mLeftDragger.findTopChildUnder((int) r2, (int) r9);
        if (r10 == null) goto L21;
        if (isContentView(r10) == false) goto L21;
        r8 = true;
    L22:
        this.mDisallowInterceptRequested = false;
        this.mChildrenCanceledTouch = false;
    L21:
        r8 = false;
        goto L22
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent r7) {
        if ((r7.getSource() & 2) == 0) goto L25;
        if (r7.getAction() == 10) goto L25;
        if (this.mScrimOpacity <= 0.0f) goto L25;
        int r0 = getChildCount();
        if (r0 == 0) goto L22;
        float r1 = r7.getX();
        float r2 = r7.getY();
        int r3 = r0 - 1;
    L12:
        if (r3 < 0) goto L31;
        View r4 = getChildAt(r3);
        if (isInBoundsOfChild(r1, r2, r4) == false) goto L21;
        if (isContentView(r4) == true) goto L21;
        if (dispatchTransformedGenericPointerEvent(r7, r4) == false) goto L21;
        return true;
    L21:
        r3 = r3 - 1;
        goto L12
    L31:
        return false;
    L22:
        return false;
    L25:
        return super.dispatchGenericMotionEvent(r7);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r7) {
        this.mLeftDragger.processTouchEvent(r7);
        this.mRightDragger.processTouchEvent(r7);
        int r0 = r7.getAction() & 255;
        if (r0 == 0) goto L23;
        if (r0 != 1) goto L6;
        float r1 = r7.getX();
        float r8 = r7.getY();
        View r3 = this.mLeftDragger.findTopChildUnder((int) r1, (int) r8);
        if (r3 != null) goto L12;
    L21:
        boolean r9 = true;
    L22:
        closeDrawers(r9);
        this.mDisallowInterceptRequested = false;
    L24:
        return true;
    L12:
        if (isContentView(r3) == false) goto L21;
        float r2 = r1 - this.mInitialMotionX;
        float r10 = r8 - this.mInitialMotionY;
        int r4 = this.mLeftDragger.getTouchSlop();
        if (((r2 * r2) + (r10 * r10)) >= (r4 * r4)) goto L21;
        View r11 = findOpenDrawer();
        if (r11 == null) goto L21;
        if (getDrawerLockMode(r11) == 2) goto L21;
        r9 = false;
        goto L22
    L6:
        if (r0 != 3) goto L24;
        closeDrawers(true);
        this.mDisallowInterceptRequested = false;
        this.mChildrenCanceledTouch = false;
        goto L24
    L23:
        float r5 = r7.getX();
        float r12 = r7.getY();
        this.mInitialMotionX = r5;
        this.mInitialMotionY = r12;
        this.mDisallowInterceptRequested = false;
        this.mChildrenCanceledTouch = false;
        goto L24
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r1) {
        super.requestDisallowInterceptTouchEvent(r1);
        this.mDisallowInterceptRequested = r1;
        if (r1 == false) goto L6;
        closeDrawers(true);
        return;
    }

    public void closeDrawers() {
        closeDrawers(false);
    }

    void closeDrawers(boolean r10) {
        int r0 = getChildCount();
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r0) goto L16;
        View r4 = getChildAt(r2);
        LayoutParams r5 = (LayoutParams) r4.getLayoutParams();
        if (isDrawerView(r4) == false) goto L15;
        if (r10 == true) goto L8;
    L10:
        int r6 = r4.getWidth();
        if (checkDrawerViewAbsoluteGravity(r4, 3) == false) goto L13;
        boolean r7 = this.mLeftDragger.smoothSlideViewTo(r4, -r6, r4.getTop());
    L14:
        r3 = r3 | r7;
        r5.isPeeking = false;
        goto L15
    L13:
        r7 = this.mRightDragger.smoothSlideViewTo(r4, getWidth(), r4.getTop());
        goto L14
    L8:
        if (r5.isPeeking == true) goto L10;
    L15:
        r2 = r2 + 1;
        goto L3
    L16:
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        if (r3 == false) goto L24;
        invalidate();
        return;
    }

    public void openDrawer(View r2) {
        openDrawer(r2, true);
    }

    public void openDrawer(View r4, boolean r5) {
        if (isDrawerView(r4) == false) goto L17;
        LayoutParams r0 = (LayoutParams) r4.getLayoutParams();
        if (this.mFirstLayout == false) goto L8;
        r0.onScreen = 1.0f;
        r0.openState = 1;
        updateChildrenImportantForAccessibility(r4, true);
    L14:
        invalidate();
        return;
    L8:
        if (r5 == false) goto L13;
        r0.openState |= 2;
        if (checkDrawerViewAbsoluteGravity(r4, 3) == false) goto L12;
        this.mLeftDragger.smoothSlideViewTo(r4, 0, r4.getTop());
        goto L14
    L12:
        this.mRightDragger.smoothSlideViewTo(r4, getWidth() - r4.getWidth(), r4.getTop());
        goto L14
    L13:
        moveDrawerToOffset(r4, 1.0f);
        updateDrawerState(r0.gravity, 0, r4);
        r4.setVisibility(0);
        goto L14
    L17:
        throw new IllegalArgumentException("View " + r4 + " is not a sliding drawer");
    }

    public void openDrawer(int r2) {
        openDrawer(r2, true);
    }

    public void openDrawer(int r2, boolean r3) {
        View r0 = findDrawerWithGravity(r2);
        if (r0 == null) goto L7;
        openDrawer(r0, r3);
        return;
    L7:
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(r2));
    }

    public void closeDrawer(View r2) {
        closeDrawer(r2, true);
    }

    public void closeDrawer(View r5, boolean r6) {
        if (isDrawerView(r5) == false) goto L17;
        LayoutParams r0 = (LayoutParams) r5.getLayoutParams();
        if (this.mFirstLayout == false) goto L8;
        r0.onScreen = 0.0f;
        r0.openState = 0;
    L14:
        invalidate();
        return;
    L8:
        if (r6 == false) goto L13;
        r0.openState |= 4;
        if (checkDrawerViewAbsoluteGravity(r5, 3) == false) goto L12;
        this.mLeftDragger.smoothSlideViewTo(r5, -r5.getWidth(), r5.getTop());
        goto L14
    L12:
        this.mRightDragger.smoothSlideViewTo(r5, getWidth(), r5.getTop());
        goto L14
    L13:
        moveDrawerToOffset(r5, 0.0f);
        updateDrawerState(r0.gravity, 0, r5);
        r5.setVisibility(4);
        goto L14
    L17:
        throw new IllegalArgumentException("View " + r5 + " is not a sliding drawer");
    }

    public void closeDrawer(int r2) {
        closeDrawer(r2, true);
    }

    public void closeDrawer(int r2, boolean r3) {
        View r0 = findDrawerWithGravity(r2);
        if (r0 == null) goto L7;
        closeDrawer(r0, r3);
        return;
    L7:
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(r2));
    }

    public boolean isDrawerOpen(View r3) {
        if (isDrawerView(r3) == false) goto L10;
        if ((((LayoutParams) r3.getLayoutParams()).openState & 1) == 1) goto L11;
        return false;
    L11:
        return true;
    L10:
        throw new IllegalArgumentException("View " + r3 + " is not a drawer");
    }

    public boolean isDrawerOpen(int r1) {
        View r2 = findDrawerWithGravity(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        return isDrawerOpen(r2);
    }

    public boolean isDrawerVisible(View r3) {
        if (isDrawerView(r3) == false) goto L10;
        if (((LayoutParams) r3.getLayoutParams()).onScreen <= 0.0f) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException("View " + r3 + " is not a drawer");
    }

    public boolean isDrawerVisible(int r1) {
        View r2 = findDrawerWithGravity(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        return isDrawerVisible(r2);
    }

    private boolean hasPeekingDrawer() {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (((LayoutParams) getChildAt(r2).getLayoutParams()).isPeeking == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        if ((r1 instanceof LayoutParams) == false) goto L6;
        return new LayoutParams((LayoutParams) r1);
    L6:
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r1);
    L9:
        return new LayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r2) {
        if ((r2 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r2) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r7, int r8, int r9) {
        if (getDescendantFocusability() != 393216) goto L5;
        return;
    L5:
        int r0 = getChildCount();
        int r1 = 0;
        int r2 = 0;
        boolean r3 = false;
    L6:
        if (r2 >= r0) goto L14;
        View r4 = getChildAt(r2);
        if (isDrawerView(r4) == true) goto L10;
        this.mNonDrawerViews.add(r4);
    L13:
        r2 = r2 + 1;
        goto L6
    L10:
        if (isDrawerOpen(r4) == false) goto L13;
        r4.addFocusables(r7, r8, r9);
        r3 = true;
        goto L13
    L14:
        if (r3 == true) goto L21;
        int r5 = this.mNonDrawerViews.size();
    L16:
        if (r1 >= r5) goto L21;
        View r6 = this.mNonDrawerViews.get(r1);
        if (r6.getVisibility() != 0) goto L20;
        r6.addFocusables(r7, r8, r9);
    L20:
        r1 = r1 + 1;
    L21:
        this.mNonDrawerViews.clear();
    }

    private boolean hasVisibleDrawer() {
        if (findVisibleDrawer() == null) goto L5;
        return true;
    L5:
        return false;
    }

    View findVisibleDrawer() {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        View r2 = getChildAt(r1);
        if (isDrawerView(r2) == false) goto L9;
        if (isDrawerVisible(r2) == false) goto L9;
        return r2;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return null;
    }

    void cancelChildViewTouch() {
        if (this.mChildrenCanceledTouch == true) goto L10;
        long r3 = SystemClock.uptimeMillis();
        MotionEvent r0 = MotionEvent.obtain(r3, r3, 3, 0.0f, 0.0f, 0);
        int r1 = getChildCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        getChildAt(r2).dispatchTouchEvent(r0);
        r2 = r2 + 1;
        goto L5
    L7:
        r0.recycle();
        this.mChildrenCanceledTouch = true;
        return;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r2, KeyEvent r3) {
        if (r2 != 4) goto L9;
        if (hasVisibleDrawer() == false) goto L9;
        r3.startTracking();
        return true;
    L9:
        return super.onKeyDown(r2, r3);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r2, KeyEvent r3) {
        if (r2 != 4) goto L14;
        View r4 = findVisibleDrawer();
        if (r4 != null) goto L7;
    L9:
        if (r4 == null) goto L11;
        return true;
    L11:
        return false;
    L7:
        if (getDrawerLockMode(r4) != 0) goto L9;
        closeDrawers();
        goto L9
    L14:
        return super.onKeyUp(r2, r3);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r4) {
        if ((r4 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) r4;
        super.onRestoreInstanceState(r5.getSuperState());
        if (r5.openDrawerGravity == 0) goto L12;
        View r0 = findDrawerWithGravity(r5.openDrawerGravity);
        if (r0 == null) goto L12;
        openDrawer(r0);
    L12:
        if (r5.lockModeLeft == 3) goto L15;
        setDrawerLockMode(r5.lockModeLeft, 3);
    L15:
        if (r5.lockModeRight == 3) goto L18;
        setDrawerLockMode(r5.lockModeRight, 5);
    L18:
        if (r5.lockModeStart == 3) goto L21;
        setDrawerLockMode(r5.lockModeStart, GravityCompat.START);
    L21:
        if (r5.lockModeEnd == 3) goto L24;
        setDrawerLockMode(r5.lockModeEnd, GravityCompat.END);
        return;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        int r0 = getChildCount();
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L17;
        LayoutParams r4 = (LayoutParams) getChildAt(r3).getLayoutParams();
        boolean r6 = true;
        if (r4.openState != 1) goto L7;
        boolean r5 = true;
    L9:
        if (r4.openState == 2) goto L12;
        r6 = false;
    L12:
        if (r5 == true) goto L16;
        if (r6 == true) goto L16;
        r3 = r3 + 1;
    L16:
        r1.openDrawerGravity = r4.gravity;
        goto L17
    L7:
        r5 = false;
    L17:
        r1.lockModeLeft = this.mLockModeLeft;
        r1.lockModeRight = this.mLockModeRight;
        r1.lockModeStart = this.mLockModeStart;
        r1.lockModeEnd = this.mLockModeEnd;
        return r1;
    }

    @Override // android.view.ViewGroup
    public void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        super.addView(r1, r2, r3);
        if (findOpenDrawer() == null) goto L5;
    L8:
        ViewCompat.setImportantForAccessibility(r1, 4);
    L10:
        if (CAN_HIDE_DESCENDANTS == true) goto L13;
        ViewCompat.setAccessibilityDelegate(r1, this.mChildAccessibilityDelegate);
        return;
    L13:
        return;
    L5:
        if (isDrawerView(r1) == true) goto L8;
        ViewCompat.setImportantForAccessibility(r1, 1);
        goto L10
    }

    static boolean includeChildForAccessibility(View r2) {
        if (ViewCompat.getImportantForAccessibility(r2) != 4) goto L5;
    L7:
        return false;
    L5:
        if (ViewCompat.getImportantForAccessibility(r2) == 2) goto L7;
        return true;
    }
}
