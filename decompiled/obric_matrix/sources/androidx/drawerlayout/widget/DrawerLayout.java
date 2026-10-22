package androidx.drawerlayout.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout extends ViewGroup implements Openable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.drawerlayout.widget.DrawerLayout";
    private static final boolean ALLOW_EDGE_LOCK = false;
    static final boolean CAN_HIDE_DESCENDANTS = false;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
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
    private static boolean sEdgeSizeUsingSystemGestureInsets;
    private final AccessibilityViewCommand mActionDismiss;
    private final ChildAccessibilityDelegate mChildAccessibilityDelegate;
    private Rect mChildHitRect;
    private Matrix mChildInvertedMatrix;
    private boolean mChildrenCanceledTouch;
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

    @Nullable
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
            r2.getBoundsInScreen(r0);
            r1.setBoundsInScreen(r0);
            r1.setVisibleToUser(r2.isVisibleToUser());
            r1.setPackageName(r2.getPackageName());
            r1.setClassName(r2.getClassName());
            r1.setContentDescription(r2.getContentDescription());
            r1.setEnabled(r2.isEnabled());
            r1.setFocused(r2.isFocused());
            r1.setAccessibilityFocused(r2.isAccessibilityFocused());
            r1.setSelected(r2.isSelected());
            r1.addAction(r2.getActions());
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
        public void onInitializeAccessibilityEvent(View r1, AccessibilityEvent r2) {
            super.onInitializeAccessibilityEvent(r1, r2);
            r2.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r4, AccessibilityNodeInfoCompat r5) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS == false) goto L5;
            super.onInitializeAccessibilityNodeInfo(r4, r5);
        L9:
            r5.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
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
        public boolean onRequestSendAccessibilityEvent(ViewGroup r2, View r3, AccessibilityEvent r4) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS == true) goto L10;
            if (DrawerLayout.includeChildForAccessibility(r3) == true) goto L10;
            return false;
        L10:
            return super.onRequestSendAccessibilityEvent(r2, r3, r4);
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
        void onDrawerClosed(@NonNull View r1);

        void onDrawerOpened(@NonNull View r1);

        void onDrawerSlide(@NonNull View r1, float r2);

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

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.gravity = 0;
        }

        public LayoutParams(int r1, int r2, int r3) {
            this(r1, r2);
            this.gravity = r3;
        }

        public LayoutParams(@NonNull Context r3, @Nullable AttributeSet r4) {
            super(r3, r4);
            this.gravity = 0;
            TypedArray r5 = r3.obtainStyledAttributes(r4, DrawerLayout.LAYOUT_ATTRS);
            this.gravity = r5.getInt(0, 0);
            r5.recycle();
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams r1) {
            super(r1);
            this.gravity = 0;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.gravity = 0;
        }

        public LayoutParams(@NonNull LayoutParams r2) {
            super(r2);
            this.gravity = 0;
            this.gravity = r2.gravity;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        int openDrawerGravity;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(@NonNull Parcel r1, @Nullable ClassLoader r2) {
            super(r1, r2);
            this.openDrawerGravity = 0;
            this.openDrawerGravity = r1.readInt();
            this.lockModeLeft = r1.readInt();
            this.lockModeRight = r1.readInt();
            this.lockModeStart = r1.readInt();
            this.lockModeEnd = r1.readInt();
        }

        public SavedState(@NonNull Parcelable r1) {
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
    }

    public static abstract class SimpleDrawerListener implements DrawerListener {
        public SimpleDrawerListener() {
        }

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
    }

    private class ViewDragCallback extends ViewDragHelper.Callback {
        private final int mAbsGravity;
        private ViewDragHelper mDragger;
        private final Runnable mPeekRunnable;
        final /* synthetic */ DrawerLayout this$0;

        ViewDragCallback(DrawerLayout r1, int r2) {
            this.this$0 = r1;
            this.mPeekRunnable = new AnonymousClass1(this);
            this.mAbsGravity = r2;
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

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View r1) {
            if (this.this$0.isDrawerView(r1) == true) goto L7;
            return 0;
        L7:
            return r1.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int r2, int r3) {
            if ((r2 & 1) != 1) goto L5;
            DrawerLayout r4 = this.this$0;
            int r0 = 3;
        L6:
            View r5 = r4.findDrawerWithGravity(r0);
            if (r5 != null) goto L9;
            return;
        L9:
            if (this.this$0.getDrawerLockMode(r5) != 0) goto L13;
            this.mDragger.captureChildView(r5, r3);
            return;
        L13:
            return;
        L5:
            r4 = this.this$0;
            r0 = 5;
            goto L6
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean onEdgeLock(int r1) {
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeTouched(int r3, int r4) {
            this.this$0.postDelayed(this.mPeekRunnable, 160);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View r1, int r2) {
            ((LayoutParams) r1.getLayoutParams()).isPeeking = false;
            closeOtherDrawer();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int r2) {
            this.this$0.updateDrawerState(r2, this.mDragger.getCapturedView());
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

        public void removeCallbacks() {
            this.this$0.removeCallbacks(this.mPeekRunnable);
        }

        public void setDragger(ViewDragHelper r1) {
            this.mDragger = r1;
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
    }

    static {
        boolean r0 = true;
        THEME_ATTRS = new int[]{R.attr.colorPrimaryDark};
        LAYOUT_ATTRS = new int[]{R.attr.layout_gravity};
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 19) goto L5;
        boolean r2 = true;
    L6:
        CAN_HIDE_DESCENDANTS = r2;
        if (r1 < 21) goto L9;
        boolean r3 = true;
    L10:
        SET_DRAWER_SHADOW_FROM_ELEVATION = r3;
        if (r1 >= 29) goto L14;
        r0 = false;
    L14:
        sEdgeSizeUsingSystemGestureInsets = r0;
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public DrawerLayout(@NonNull Context r2) {
        this(r2, null);
    }

    public DrawerLayout(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, androidx.drawerlayout.R.attr.drawerLayoutStyle);
    }

    public DrawerLayout(@NonNull Context r8, @Nullable AttributeSet r9, int r10) {
        super(r8, r9, r10);
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
        this.mActionDismiss = new AnonymousClass1(this);
        setDescendantFocusability(262144);
        float r3 = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) ((64.0f * r3) + 0.5f);
        float r4 = r3 * 400.0f;
        ViewDragCallback r5 = new ViewDragCallback(this, 3);
        this.mLeftCallback = r5;
        ViewDragCallback r1 = new ViewDragCallback(this, 5);
        this.mRightCallback = r1;
        ViewDragHelper r6 = ViewDragHelper.create(this, 1.0f, r5);
        this.mLeftDragger = r6;
        r6.setEdgeTrackingEnabled(1);
        r6.setMinVelocity(r4);
        r5.setDragger(r6);
        ViewDragHelper r7 = ViewDragHelper.create(this, 1.0f, r1);
        this.mRightDragger = r7;
        r7.setEdgeTrackingEnabled(2);
        r7.setMinVelocity(r4);
        r1.setDragger(r7);
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate(this));
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.getFitsSystemWindows(this) == true) goto L5;
    L13:
        TypedArray r11 = r8.obtainStyledAttributes(r9, androidx.drawerlayout.R.styleable.DrawerLayout, r10, 0);
        int r12 = androidx.drawerlayout.R.styleable.DrawerLayout_elevation;     // Catch: Throwable -> L22
        if (r11.hasValue(r12) == false) goto L18;
        float r13 = r11.getDimension(r12, 0.0f);     // Catch: Throwable -> L22
    L17:
        this.mDrawerElevation = r13;     // Catch: Throwable -> L22
        r11.recycle();
        this.mNonDrawerViews = new ArrayList();
        return;
    L18:
        r13 = getResources().getDimension(androidx.drawerlayout.R.dimen.def_drawer_elevation);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r11.recycle();
        throw th;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        setOnApplyWindowInsetsListener(new AnonymousClass2(this));
        setSystemUiVisibility(1280);
        TypedArray r2 = r8.obtainStyledAttributes(THEME_ATTRS);
        this.mStatusBarBackground = r2.getDrawable(0);     // Catch: Throwable -> L9
        r2.recycle();
    L9:
        th = move-exception;
        r2.recycle();
        throw th;
    L12:
        this.mStatusBarBackground = null;
        goto L13
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

    static String gravityToString(int r2) {
        if ((r2 & 3) != 3) goto L7;
        return "LEFT";
    L7:
        if ((r2 & 5) != 5) goto L11;
        return "RIGHT";
    L11:
        return Integer.toHexString(r2);
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

    private boolean hasVisibleDrawer() {
        if (findVisibleDrawer() == null) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean includeChildForAccessibility(View r2) {
        if (ViewCompat.getImportantForAccessibility(r2) != 4) goto L5;
    L7:
        return false;
    L5:
        if (ViewCompat.getImportantForAccessibility(r2) == 2) goto L7;
        return true;
    }

    private boolean isInBoundsOfChild(float r2, float r3, View r4) {
        if (this.mChildHitRect != null) goto L5;
        this.mChildHitRect = new Rect();
    L5:
        r4.getHitRect(this.mChildHitRect);
        return this.mChildHitRect.contains((int) r2, (int) r3);
    }

    private void mirror(Drawable r1, int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (DrawableCompat.isAutoMirrored(r1) == false) goto L8;
        DrawableCompat.setLayoutDirection(r1, r2);
        return;
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

    private void resolveShadowDrawables() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == false) goto L5;
        return;
    L5:
        this.mShadowLeftResolved = resolveLeftShadow();
        this.mShadowRightResolved = resolveRightShadow();
    }

    private void updateChildAccessibilityAction(View r4) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r0 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS;
        ViewCompat.removeAccessibilityAction(r4, r0.getId());
        if (isDrawerOpen(r4) == true) goto L5;
        return;
    L5:
        if (getDrawerLockMode(r4) == 2) goto L9;
        ViewCompat.replaceAccessibilityAction(r4, r0, null, this.mActionDismiss);
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
        int r3 = 1;
    L12:
        ViewCompat.setImportantForAccessibility(r2, r3);
        r1 = r1 + 1;
    L11:
        r3 = 4;
        goto L12
    L7:
        if (isDrawerView(r2) == false) goto L10;
    }

    public void addDrawerListener(@NonNull DrawerListener r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.mListeners != null) goto L7;
        this.mListeners = new ArrayList();
    L7:
        this.mListeners.add(r2);
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

    @Override // android.view.ViewGroup
    public void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        super.addView(r1, r2, r3);
        if (findOpenDrawer() == null) goto L5;
    L8:
        int r4 = 4;
    L9:
        ViewCompat.setImportantForAccessibility(r1, r4);
        if (CAN_HIDE_DESCENDANTS == true) goto L13;
        ViewCompat.setAccessibilityDelegate(r1, this.mChildAccessibilityDelegate);
        return;
    L13:
        return;
    L5:
        if (isDrawerView(r1) == true) goto L8;
        r4 = 1;
        goto L9
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

    boolean checkDrawerViewAbsoluteGravity(View r1, int r2) {
        if ((getDrawerViewAbsoluteGravity(r1) & r2) != r2) goto L5;
        return true;
    L5:
        return false;
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

    @Override // androidx.customview.widget.Openable
    public void close() {
        closeDrawer(GravityCompat.START);
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

    public void closeDrawer(@NonNull View r2) {
        closeDrawer(r2, true);
    }

    public void closeDrawer(@NonNull View r5, boolean r6) {
        if (isDrawerView(r5) == false) goto L18;
        LayoutParams r0 = (LayoutParams) r5.getLayoutParams();
        if (this.mFirstLayout == false) goto L8;
        r0.onScreen = 0.0f;
        r0.openState = 0;
    L15:
        invalidate();
        return;
    L8:
        if (r6 == false) goto L14;
        r0.openState |= 4;
        if (checkDrawerViewAbsoluteGravity(r5, 3) == false) goto L12;
        ViewDragHelper r7 = this.mLeftDragger;
        int r1 = -r5.getWidth();
    L13:
        r7.smoothSlideViewTo(r5, r1, r5.getTop());
        goto L15
    L12:
        r7 = this.mRightDragger;
        r1 = getWidth();
        goto L13
    L14:
        moveDrawerToOffset(r5, 0.0f);
        updateDrawerState(0, r5);
        r5.setVisibility(4);
        goto L15
    L18:
        throw new IllegalArgumentException("View " + r5 + " is not a sliding drawer");
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
        updateChildAccessibilityAction(r4);
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
        updateChildAccessibilityAction(r4);
        if (hasWindowFocus() == false) goto L15;
        sendAccessibilityEvent(32);
        return;
    L15:
        return;
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
        this.mScrimPaint.setColor((r2 & ViewCompat.MEASURED_SIZE_MASK) | (((int) ((((-16777216) & r2) >>> 24) * r7)) << 24));
        r15.drawRect(r8, 0.0f, r5, getHeight(), this.mScrimPaint);
    L42:
        return r18;
    L32:
        if (this.mShadowLeftResolved == null) goto L38;
        if (checkDrawerViewAbsoluteGravity(r16, 3) == false) goto L38;
        int r19 = this.mShadowLeftResolved.getIntrinsicWidth();
        int r20 = r16.getRight();
        float r21 = Math.max(0.0f, Math.min(r20 / this.mLeftDragger.getEdgeSize(), 1.0f));
        this.mShadowLeftResolved.setBounds(r20, r16.getTop(), r19 + r20, r16.getBottom());
        this.mShadowLeftResolved.setAlpha((int) (r21 * 255.0f));
        Drawable r0 = this.mShadowLeftResolved;
    L36:
        r0.draw(r15);
    L38:
        if (this.mShadowRightResolved == null) goto L42;
        if (checkDrawerViewAbsoluteGravity(r16, 5) == false) goto L42;
        int r22 = this.mShadowRightResolved.getIntrinsicWidth();
        int r23 = r16.getLeft();
        float r24 = Math.max(0.0f, Math.min((getWidth() - r23) / this.mRightDragger.getEdgeSize(), 1.0f));
        this.mShadowRightResolved.setBounds(r23 - r22, r16.getTop(), r23, r16.getBottom());
        this.mShadowRightResolved.setAlpha((int) (r24 * 255.0f));
        r0 = this.mShadowRightResolved;
        goto L36
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

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
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

    public float getDrawerElevation() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == true) goto L5;
        return 0.0f;
    L5:
        return this.mDrawerElevation;
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

    public int getDrawerLockMode(@NonNull View r3) {
        if (isDrawerView(r3) == false) goto L7;
        return getDrawerLockMode(((LayoutParams) r3.getLayoutParams()).gravity);
    L7:
        throw new IllegalArgumentException("View " + r3 + " is not a drawer");
    }

    @Nullable
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

    int getDrawerViewAbsoluteGravity(View r1) {
        return GravityCompat.getAbsoluteGravity(((LayoutParams) r1.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
    }

    float getDrawerViewOffset(View r1) {
        return ((LayoutParams) r1.getLayoutParams()).onScreen;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    boolean isContentView(View r1) {
        if (((LayoutParams) r1.getLayoutParams()).gravity != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDrawerOpen(int r1) {
        View r2 = findDrawerWithGravity(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        return isDrawerOpen(r2);
    }

    public boolean isDrawerOpen(@NonNull View r3) {
        if (isDrawerView(r3) == false) goto L10;
        if ((((LayoutParams) r3.getLayoutParams()).openState & 1) == 1) goto L11;
        return false;
    L11:
        return true;
    L10:
        throw new IllegalArgumentException("View " + r3 + " is not a drawer");
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

    public boolean isDrawerVisible(int r1) {
        View r2 = findDrawerWithGravity(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        return isDrawerVisible(r2);
    }

    public boolean isDrawerVisible(@NonNull View r3) {
        if (isDrawerView(r3) == false) goto L10;
        if (((LayoutParams) r3.getLayoutParams()).onScreen <= 0.0f) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException("View " + r3 + " is not a drawer");
    }

    @Override // androidx.customview.widget.Openable
    public boolean isOpen() {
        return isDrawerOpen(GravityCompat.START);
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

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        super.onDraw(r5);
        if (this.mDrawStatusBarBackground == true) goto L5;
        return;
    L5:
        if (this.mStatusBarBackground != null) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L11;
        Object r0 = this.mLastInsets;
        if (r0 == null) goto L11;
        int r1 = ((WindowInsets) r0).getSystemWindowInsetTop();
    L12:
        if (r1 <= 0) goto L17;
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), r1);
        this.mStatusBarBackground.draw(r5);
        return;
    L17:
        return;
    L11:
        r1 = 0;
        goto L12
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r7) {
        int r0 = r7.getActionMasked();
        boolean r1 = this.mLeftDragger.shouldInterceptTouchEvent(r7) | this.mRightDragger.shouldInterceptTouchEvent(r7);
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L6;
    L12:
        closeDrawers(true);
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
        this.mChildrenCanceledTouch = false;
    L21:
        r8 = false;
        goto L22
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

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        boolean r1 = true;
        this.mInLayout = true;
        int r2 = r20 - r18;
        int r3 = getChildCount();
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L43;
        View r6 = getChildAt(r5);
        if (r6.getVisibility() == 8) goto L41;
        LayoutParams r7 = (LayoutParams) r6.getLayoutParams();
        if (isContentView(r6) == false) goto L10;
        int r8 = ((ViewGroup.MarginLayoutParams) r7).leftMargin;
        r6.layout(r8, ((ViewGroup.MarginLayoutParams) r7).topMargin, r6.getMeasuredWidth() + r8, ((ViewGroup.MarginLayoutParams) r7).topMargin + r6.getMeasuredHeight());
        goto L41
    L10:
        int r9 = r6.getMeasuredWidth();
        int r10 = r6.getMeasuredHeight();
        if (checkDrawerViewAbsoluteGravity(r6, 3) == false) goto L13;
        float r11 = r9;
        int r12 = (-r9) + ((int) (r7.onScreen * r11));
        float r13 = (r9 + r12) / r11;
    L15:
        if (r13 == r7.onScreen) goto L17;
        boolean r14 = r1;
    L18:
        int r15 = r7.gravity & 112;
        if (r15 != 16) goto L21;
        int r16 = r21 - r19;
        int r110 = (r16 - r10) / 2;
        int r111 = ((ViewGroup.MarginLayoutParams) r7).topMargin;
        if (r110 >= r111) goto L28;
        r110 = r111;
    L31:
        r6.layout(r12, r110, r9 + r12, r10 + r110);
    L32:
        if (r14 == false) goto L35;
        setDrawerViewOffset(r6, r13);
    L35:
        if (r7.onScreen <= 0.0f) goto L37;
        int r4 = 0;
    L39:
        if (r6.getVisibility() == r4) goto L41;
        r6.setVisibility(r4);
        goto L41
    L37:
        r4 = 4;
        goto L39
    L28:
        int r112 = r110 + r10;
        int r22 = ((ViewGroup.MarginLayoutParams) r7).bottomMargin;
        if (r112 <= (r16 - r22)) goto L31;
        r110 = (r16 - r22) - r10;
        goto L31
    L21:
        if (r15 == 80) goto L24;
        int r113 = ((ViewGroup.MarginLayoutParams) r7).topMargin;
        int r23 = r9 + r12;
        int r24 = r10 + r113;
    L23:
        r6.layout(r12, r113, r23, r24);
        goto L32
    L24:
        int r25 = r21 - r19;
        r113 = (r25 - ((ViewGroup.MarginLayoutParams) r7).bottomMargin) - r6.getMeasuredHeight();
        r23 = r9 + r12;
        r24 = r25 - ((ViewGroup.MarginLayoutParams) r7).bottomMargin;
        goto L23
    L17:
        r14 = false;
        goto L18
    L13:
        float r114 = r9;
        int r115 = r2 - ((int) (r7.onScreen * r114));
        r13 = (r2 - r115) / r114;
        r12 = r115;
    L41:
        r5 = r5 + 1;
        r1 = true;
        goto L3
    L43:
        if (sEdgeSizeUsingSystemGestureInsets == false) goto L47;
        WindowInsets r26 = getRootWindowInsets();
        if (r26 == null) goto L47;
        Insets r27 = WindowInsetsCompat.toWindowInsetsCompat(r26).getSystemGestureInsets();
        ViewDragHelper r28 = this.mLeftDragger;
        r28.setEdgeSize(Math.max(r28.getDefaultEdgeSize(), r27.left));
        ViewDragHelper r29 = this.mRightDragger;
        r29.setEdgeSize(Math.max(r29.getDefaultEdgeSize(), r27.right));
    L47:
        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    protected void onMeasure(int r19, int r20) {
        int r1 = Build.VERSION.SDK_INT;
        int r2 = View.MeasureSpec.getMode(r19);
        int r3 = View.MeasureSpec.getMode(r20);
        int r4 = View.MeasureSpec.getSize(r19);
        int r5 = View.MeasureSpec.getSize(r20);
        char r7 = 0;
        if (r2 != 1073741824) goto L6;
        if (r3 != 1073741824) goto L6;
    L11:
        setMeasuredDimension(r4, r5);
        if (this.mLastInsets != null) goto L14;
    L16:
        boolean r6 = false;
    L17:
        int r8 = ViewCompat.getLayoutDirection(this);
        int r9 = getChildCount();
        int r10 = 0;
        boolean r11 = false;
        boolean r12 = false;
    L18:
        if (r10 >= r9) goto L73;
        View r13 = getChildAt(r10);
        if (r13.getVisibility() != 8) goto L22;
        boolean r17 = r6;
    L70:
        r10 = r10 + 1;
        r6 = r17;
        r7 = 0;
        goto L18
    L22:
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        if (r6 == false) goto L43;
        int r15 = GravityCompat.getAbsoluteGravity(r14.gravity, r8);
        if (ViewCompat.getFitsSystemWindows(r13) == false) goto L34;
        if (r1 < 21) goto L43;
        WindowInsets r16 = (WindowInsets) this.mLastInsets;
        if (r15 != 3) goto L30;
        r17 = r6;
        r16 = r16.replaceSystemWindowInsets(r16.getSystemWindowInsetLeft(), r16.getSystemWindowInsetTop(), 0, r16.getSystemWindowInsetBottom());
    L33:
        r13.dispatchApplyWindowInsets(r16);
    L45:
        if (isContentView(r13) == false) goto L49;
        r13.measure(View.MeasureSpec.makeMeasureSpec((r4 - ((ViewGroup.MarginLayoutParams) r14).leftMargin) - ((ViewGroup.MarginLayoutParams) r14).rightMargin, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec((r5 - ((ViewGroup.MarginLayoutParams) r14).topMargin) - ((ViewGroup.MarginLayoutParams) r14).bottomMargin, BasicMeasure.EXACTLY));
        goto L70
    L49:
        if (isDrawerView(r13) == false) goto L72;
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == false) goto L55;
        float r18 = ViewCompat.getElevation(r13);
        float r21 = this.mDrawerElevation;
        if (r18 == r21) goto L55;
        ViewCompat.setElevation(r13, r21);
    L55:
        int r22 = getDrawerViewAbsoluteGravity(r13) & 7;
        if (r22 != 3) goto L58;
        boolean r23 = true;
    L59:
        if (r23 == false) goto L61;
        if (r11 == false) goto L61;
    L65:
        throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(r22) + " but this " + TAG + " already has a drawer view along that edge");
    L61:
        if (r23 == true) goto L66;
        if (r12 == true) goto L65;
    L66:
        if (r23 == false) goto L68;
        r11 = true;
    L69:
        r13.measure(ViewGroup.getChildMeasureSpec(r19, (this.mMinDrawerMargin + ((ViewGroup.MarginLayoutParams) r14).leftMargin) + ((ViewGroup.MarginLayoutParams) r14).rightMargin, ((ViewGroup.MarginLayoutParams) r14).width), ViewGroup.getChildMeasureSpec(r20, ((ViewGroup.MarginLayoutParams) r14).topMargin + ((ViewGroup.MarginLayoutParams) r14).bottomMargin, ((ViewGroup.MarginLayoutParams) r14).height));
        goto L70
    L68:
        r12 = true;
        goto L69
    L58:
        r23 = false;
        goto L59
    L72:
        throw new IllegalStateException("Child " + r13 + " at index " + r10 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
    L30:
        r17 = r6;
        if (r15 != 5) goto L33;
        r16 = r16.replaceSystemWindowInsets(0, r16.getSystemWindowInsetTop(), r16.getSystemWindowInsetRight(), r16.getSystemWindowInsetBottom());
        goto L33
    L34:
        r17 = r6;
        if (r1 < 21) goto L45;
        WindowInsets r24 = (WindowInsets) this.mLastInsets;
        if (r15 != 3) goto L40;
        r24 = r24.replaceSystemWindowInsets(r24.getSystemWindowInsetLeft(), r24.getSystemWindowInsetTop(), 0, r24.getSystemWindowInsetBottom());
    L42:
        ((ViewGroup.MarginLayoutParams) r14).leftMargin = r24.getSystemWindowInsetLeft();
        ((ViewGroup.MarginLayoutParams) r14).topMargin = r24.getSystemWindowInsetTop();
        ((ViewGroup.MarginLayoutParams) r14).rightMargin = r24.getSystemWindowInsetRight();
        ((ViewGroup.MarginLayoutParams) r14).bottomMargin = r24.getSystemWindowInsetBottom();
        goto L45
    L40:
        if (r15 != 5) goto L42;
        r24 = r24.replaceSystemWindowInsets(0, r24.getSystemWindowInsetTop(), r24.getSystemWindowInsetRight(), r24.getSystemWindowInsetBottom());
    L43:
        r17 = r6;
        goto L45
    L73:
        return;
    L14:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L16;
        r6 = true;
    L6:
        if (isInEditMode() == false) goto L75;
        if (r2 != 0) goto L9;
        r4 = 300;
    L9:
        if (r3 != 0) goto L11;
        r5 = 300;
        goto L11
    L75:
        throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r4) {
        if ((r4 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) r4;
        super.onRestoreInstanceState(r5.getSuperState());
        int r0 = r5.openDrawerGravity;
        if (r0 == 0) goto L11;
        View r1 = findDrawerWithGravity(r0);
        if (r1 == null) goto L11;
        openDrawer(r1);
    L11:
        int r2 = r5.lockModeLeft;
        if (r2 == 3) goto L14;
        setDrawerLockMode(r2, 3);
    L14:
        int r3 = r5.lockModeRight;
        if (r3 == 3) goto L17;
        setDrawerLockMode(r3, 5);
    L17:
        int r6 = r5.lockModeStart;
        if (r6 == 3) goto L20;
        setDrawerLockMode(r6, GravityCompat.START);
    L20:
        int r7 = r5.lockModeEnd;
        if (r7 == 3) goto L24;
        setDrawerLockMode(r7, GravityCompat.END);
        return;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r1) {
        resolveShadowDrawables();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        int r0 = getChildCount();
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L17;
        LayoutParams r4 = (LayoutParams) getChildAt(r3).getLayoutParams();
        int r5 = r4.openState;
        boolean r6 = true;
        if (r5 != 1) goto L7;
        boolean r7 = true;
    L9:
        if (r5 == 2) goto L12;
        r6 = false;
    L12:
        if (r7 == true) goto L16;
        if (r6 == true) goto L16;
        r3 = r3 + 1;
    L16:
        r1.openDrawerGravity = r4.gravity;
        goto L17
    L7:
        r7 = false;
    L17:
        r1.lockModeLeft = this.mLockModeLeft;
        r1.lockModeRight = this.mLockModeRight;
        r1.lockModeStart = this.mLockModeStart;
        r1.lockModeEnd = this.mLockModeEnd;
        return r1;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r7) {
        this.mLeftDragger.processTouchEvent(r7);
        this.mRightDragger.processTouchEvent(r7);
        int r0 = r7.getAction() & 255;
        boolean r1 = false;
        if (r0 == 0) goto L21;
        if (r0 != 1) goto L6;
        float r2 = r7.getX();
        float r8 = r7.getY();
        View r3 = this.mLeftDragger.findTopChildUnder((int) r2, (int) r8);
        if (r3 != null) goto L12;
    L19:
        r1 = true;
    L20:
        closeDrawers(r1);
    L23:
        return true;
    L12:
        if (isContentView(r3) == false) goto L19;
        float r4 = r2 - this.mInitialMotionX;
        float r9 = r8 - this.mInitialMotionY;
        int r5 = this.mLeftDragger.getTouchSlop();
        if (((r4 * r4) + (r9 * r9)) >= (r5 * r5)) goto L19;
        View r10 = findOpenDrawer();
        if (r10 == null) goto L19;
        if (getDrawerLockMode(r10) != 2) goto L20;
    L6:
        if (r0 != 3) goto L23;
        closeDrawers(true);
    L22:
        this.mChildrenCanceledTouch = false;
        goto L23
    L21:
        float r6 = r7.getX();
        float r11 = r7.getY();
        this.mInitialMotionX = r6;
        this.mInitialMotionY = r11;
        goto L22
    }

    @Override // androidx.customview.widget.Openable
    public void open() {
        openDrawer(GravityCompat.START);
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

    public void openDrawer(@NonNull View r2) {
        openDrawer(r2, true);
    }

    public void openDrawer(@NonNull View r4, boolean r5) {
        if (isDrawerView(r4) == false) goto L17;
        LayoutParams r0 = (LayoutParams) r4.getLayoutParams();
        if (this.mFirstLayout == false) goto L8;
        r0.onScreen = 1.0f;
        r0.openState = 1;
        updateChildrenImportantForAccessibility(r4, true);
        updateChildAccessibilityAction(r4);
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
        updateDrawerState(0, r4);
        r4.setVisibility(0);
        goto L14
    L17:
        throw new IllegalArgumentException("View " + r4 + " is not a sliding drawer");
    }

    public void removeDrawerListener(@NonNull DrawerListener r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        List<DrawerListener> r0 = this.mListeners;
        if (r0 != null) goto L7;
        return;
    L7:
        r0.remove(r1);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r1) {
        super.requestDisallowInterceptTouchEvent(r1);
        if (r1 == false) goto L6;
        closeDrawers(true);
        return;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInLayout == true) goto L6;
        super.requestLayout();
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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

    public void setDrawerLockMode(int r2, @NonNull View r3) {
        if (isDrawerView(r3) == false) goto L7;
        setDrawerLockMode(r2, ((LayoutParams) r3.getLayoutParams()).gravity);
        return;
    L7:
        throw new IllegalArgumentException("View " + r3 + " is not a drawer with appropriate layout_gravity");
    }

    public void setDrawerShadow(@DrawableRes int r2, int r3) {
        setDrawerShadow(ContextCompat.getDrawable(getContext(), r2), r3);
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

    public void setDrawerTitle(int r2, @Nullable CharSequence r3) {
        int r4 = GravityCompat.getAbsoluteGravity(r2, ViewCompat.getLayoutDirection(this));
        if (r4 != 3) goto L6;
        this.mTitleLeft = r3;
        return;
    L6:
        if (r4 != 5) goto L10;
        this.mTitleRight = r3;
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

    public void setScrimColor(@ColorInt int r1) {
        this.mScrimColor = r1;
        invalidate();
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

    public void setStatusBarBackground(@Nullable Drawable r1) {
        this.mStatusBarBackground = r1;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int r2) {
        this.mStatusBarBackground = new ColorDrawable(r2);
        invalidate();
    }

    void updateDrawerState(int r5, View r6) {
        int r0 = this.mLeftDragger.getViewDragState();
        int r1 = this.mRightDragger.getViewDragState();
        int r2 = 2;
        if (r0 == 1) goto L10;
        if (r1 == 1) goto L10;
        if (r0 == 2) goto L11;
        if (r1 == 2) goto L11;
        r2 = 0;
    L11:
        if (r6 == null) goto L20;
        if (r5 != 0) goto L20;
        float r7 = ((LayoutParams) r6.getLayoutParams()).onScreen;
        if (r7 != 0.0f) goto L17;
        dispatchOnDrawerClosed(r6);
        goto L20
    L17:
        if (r7 != 1.0f) goto L20;
        dispatchOnDrawerOpened(r6);
    L20:
        if (r2 == this.mDrawerState) goto L26;
        this.mDrawerState = r2;
        List<DrawerListener> r8 = this.mListeners;
        if (r8 == null) goto L28;
        int r9 = r8.size() - 1;
    L24:
        if (r9 < 0) goto L29;
        this.mListeners.get(r9).onDrawerStateChanged(r2);
        r9 = r9 - 1;
        goto L24
    L29:
        return;
    L28:
        return;
    L26:
        return;
    L10:
        r2 = 1;
        goto L11
    }
}
