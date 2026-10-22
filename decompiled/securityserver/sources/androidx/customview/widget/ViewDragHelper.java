package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = null;
    private int mActivePointerId;
    private final Callback mCallback;
    private View mCapturedView;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private OverScroller mScroller;
    private final Runnable mSetIdleRunnable;
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;

    public static abstract class Callback {
        public Callback() {
        }

        public int clampViewPositionHorizontal(@NonNull View r1, int r2, int r3) {
            return 0;
        }

        public int clampViewPositionVertical(@NonNull View r1, int r2, int r3) {
            return 0;
        }

        public int getOrderedChildIndex(int r1) {
            return r1;
        }

        public int getViewHorizontalDragRange(@NonNull View r1) {
            return 0;
        }

        public int getViewVerticalDragRange(@NonNull View r1) {
            return 0;
        }

        public void onEdgeDragStarted(int r1, int r2) {
        }

        public boolean onEdgeLock(int r1) {
            return false;
        }

        public void onEdgeTouched(int r1, int r2) {
        }

        public void onViewCaptured(@NonNull View r1, int r2) {
        }

        public void onViewDragStateChanged(int r1) {
        }

        public void onViewPositionChanged(@NonNull View r1, int r2, int r3, @Px int r4, @Px int r5) {
        }

        public void onViewReleased(@NonNull View r1, float r2, float r3) {
        }

        public abstract boolean tryCaptureView(@NonNull View r1, int r2);
    }

    static {
        sInterpolator = new AnonymousClass1();
    }

    private ViewDragHelper(@NonNull Context r2, @NonNull ViewGroup r3, @NonNull Callback r4) {
        this.mActivePointerId = -1;
        this.mSetIdleRunnable = new AnonymousClass2(this);
        if (r3 == null) goto L10;
        if (r4 == null) goto L8;
        this.mParentView = r3;
        this.mCallback = r4;
        ViewConfiguration r5 = ViewConfiguration.get(r2);
        this.mEdgeSize = (int) ((r2.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.mTouchSlop = r5.getScaledTouchSlop();
        this.mMaxVelocity = r5.getScaledMaximumFlingVelocity();
        this.mMinVelocity = r5.getScaledMinimumFlingVelocity();
        this.mScroller = new OverScroller(r2, sInterpolator);
        return;
    L8:
        throw new IllegalArgumentException("Callback may not be null");
    L10:
        throw new IllegalArgumentException("Parent view may not be null");
    }

    private boolean checkNewEdgeDrag(float r4, float r5, int r6, int r7) {
        float r8 = Math.abs(r4);
        float r9 = Math.abs(r5);
        if ((this.mInitialEdgesTouched[r6] & r7) == r7) goto L5;
        return false;
    L5:
        if ((this.mTrackingEdges & r7) != 0) goto L7;
        return false;
    L7:
        if ((this.mEdgeDragsLocked[r6] & r7) != r7) goto L9;
        return false;
    L9:
        if ((this.mEdgeDragsInProgress[r6] & r7) == r7) goto L30;
        int r0 = this.mTouchSlop;
        if (r8 > r0) goto L16;
        if (r9 > r0) goto L16;
        return false;
    L16:
        if (r8 >= (r9 * 0.5f)) goto L22;
        if (this.mCallback.onEdgeLock(r7) == false) goto L22;
        int[] r3 = this.mEdgeDragsLocked;
        r3[r6] = r3[r6] | r7;
        return false;
    L22:
        if ((this.mEdgeDragsInProgress[r6] & r7) == 0) goto L24;
        return false;
    L24:
        if (r8 <= this.mTouchSlop) goto L32;
        return true;
    L32:
        return false;
    L30:
        return false;
    }

    private boolean checkTouchSlop(View r5, float r6, float r7) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.mCallback.getViewHorizontalDragRange(r5) <= 0) goto L8;
        boolean r1 = true;
    L10:
        if (this.mCallback.getViewVerticalDragRange(r5) <= 0) goto L12;
        boolean r8 = true;
    L13:
        if (r1 == false) goto L19;
        if (r8 == false) goto L19;
        float r9 = (r7 * r7) + (r6 * r6);
        int r4 = this.mTouchSlop;
        if (r9 > (r4 * r4)) goto L18;
        return false;
    L18:
        return true;
    L19:
        if (r1 == true) goto L21;
        if (r8 == true) goto L26;
        return false;
    L26:
        if (Math.abs(r7) > this.mTouchSlop) goto L28;
        return false;
    L28:
        return true;
    L21:
        if (Math.abs(r6) > this.mTouchSlop) goto L23;
        return false;
    L23:
        return true;
    L12:
        r8 = false;
        goto L13
    L8:
        r1 = false;
        goto L10
    }

    private int clampMag(int r1, int r2, int r3) {
        int r0 = Math.abs(r1);
        if (r0 >= r2) goto L6;
        return 0;
    L6:
        if (r0 <= r3) goto L11;
        if (r1 <= 0) goto L10;
        return r3;
    L10:
        return -r3;
    L11:
        return r1;
    }

    private void clearMotionHistory() {
        float[] r0 = this.mInitialMotionX;
        if (r0 != null) goto L5;
        return;
    L5:
        Arrays.fill(r0, 0.0f);
        Arrays.fill(this.mInitialMotionY, 0.0f);
        Arrays.fill(this.mLastMotionX, 0.0f);
        Arrays.fill(this.mLastMotionY, 0.0f);
        Arrays.fill(this.mInitialEdgesTouched, 0);
        Arrays.fill(this.mEdgeDragsInProgress, 0);
        Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }

    private int computeAxisDuration(int r4, int r5, int r6) {
        if (r4 != 0) goto L5;
        return 0;
    L5:
        int r0 = this.mParentView.getWidth();
        float r1 = r0 / 2;
        float r3 = (distanceInfluenceForSnapDuration(Math.min(1.0f, Math.abs(r4) / r0)) * r1) + r1;
        int r7 = Math.abs(r5);
        if (r7 <= 0) goto L8;
        int r8 = Math.round(Math.abs(r3 / r7) * 1000.0f) * 4;
    L10:
        return Math.min(r8, 600);
    L8:
        r8 = (int) (((Math.abs(r4) / r6) + 1.0f) * 256.0f);
        goto L10
    }

    private int computeSettleDuration(View r7, int r8, int r9, int r10, int r11) {
        int r12 = clampMag(r10, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int r13 = clampMag(r11, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int r0 = Math.abs(r8);
        int r1 = Math.abs(r9);
        int r2 = Math.abs(r12);
        int r3 = Math.abs(r13);
        int r4 = r2 + r3;
        int r5 = r0 + r1;
        if (r12 == 0) goto L6;
        float r6 = r2;
        float r14 = r4;
    L5:
        float r15 = r6 / r14;
        if (r13 == 0) goto L10;
        float r16 = r3;
        float r17 = r4;
    L9:
        float r18 = r16 / r17;
        int r19 = computeAxisDuration(r8, r12, this.mCallback.getViewHorizontalDragRange(r7));
        return (int) ((computeAxisDuration(r9, r13, this.mCallback.getViewVerticalDragRange(r7)) * r18) + (r19 * r15));
    L10:
        r16 = r1;
        r17 = r5;
        goto L9
    L6:
        r6 = r0;
        r14 = r5;
        goto L5
    }

    public static ViewDragHelper create(@NonNull ViewGroup r2, @NonNull Callback r3) {
        return new ViewDragHelper(r2.getContext(), r2, r3);
    }

    private void dispatchViewReleased(float r4, float r5) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, r4, r5);
        this.mReleaseInProgress = false;
        if (this.mDragState != 1) goto L6;
        setDragState(0);
        return;
    }

    private float distanceInfluenceForSnapDuration(float r1) {
        return (float) Math.sin((r1 - 0.5f) * 0.47123894f);
    }

    private void dragTo(int r11, int r12, int r13, int r14) {
        int r0 = this.mCapturedView.getLeft();
        int r1 = this.mCapturedView.getTop();
        if (r13 == 0) goto L5;
        r11 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, r11, r13);
        ViewCompat.offsetLeftAndRight(this.mCapturedView, r11 - r0);
    L5:
        int r6 = r11;
        if (r14 == 0) goto L8;
        r12 = this.mCallback.clampViewPositionVertical(this.mCapturedView, r12, r14);
        ViewCompat.offsetTopAndBottom(this.mCapturedView, r12 - r1);
    L8:
        int r7 = r12;
        if (r13 != 0) goto L11;
        if (r14 != 0) goto L11;
        return;
    L11:
        Callback r4 = this.mCallback;
        View r5 = this.mCapturedView;
        r4.onViewPositionChanged(r5, r6, r7, r6 - r0, r7 - r1);
    }

    private void ensureMotionHistorySizeForId(int r10) {
        float[] r0 = this.mInitialMotionX;
        if (r0 != null) goto L5;
    L6:
        int r11 = r10 + 1;
        float[] r1 = new float[r11];
        float[] r2 = new float[r11];
        float[] r3 = new float[r11];
        float[] r4 = new float[r11];
        int[] r5 = new int[r11];
        int[] r6 = new int[r11];
        int[] r12 = new int[r11];
        if (r0 == null) goto L9;
        System.arraycopy(r0, 0, r1, 0, r0.length);
        float[] r7 = this.mInitialMotionY;
        System.arraycopy(r7, 0, r2, 0, r7.length);
        float[] r8 = this.mLastMotionX;
        System.arraycopy(r8, 0, r3, 0, r8.length);
        float[] r9 = this.mLastMotionY;
        System.arraycopy(r9, 0, r4, 0, r9.length);
        int[] r13 = this.mInitialEdgesTouched;
        System.arraycopy(r13, 0, r5, 0, r13.length);
        int[] r14 = this.mEdgeDragsInProgress;
        System.arraycopy(r14, 0, r6, 0, r14.length);
        int[] r15 = this.mEdgeDragsLocked;
        System.arraycopy(r15, 0, r12, 0, r15.length);
    L9:
        this.mInitialMotionX = r1;
        this.mInitialMotionY = r2;
        this.mLastMotionX = r3;
        this.mLastMotionY = r4;
        this.mInitialEdgesTouched = r5;
        this.mEdgeDragsInProgress = r6;
        this.mEdgeDragsLocked = r12;
        return;
    L5:
        if (r0.length <= r10) goto L6;
    }

    private boolean forceSettleCapturedViewAt(int r11, int r12, int r13, int r14) {
        int r2 = this.mCapturedView.getLeft();
        int r3 = this.mCapturedView.getTop();
        int r15 = r11 - r2;
        int r16 = r12 - r3;
        if (r15 != 0) goto L7;
        if (r16 != 0) goto L7;
        this.mScroller.abortAnimation();
        setDragState(0);
        return false;
    L7:
        int r6 = computeSettleDuration(this.mCapturedView, r15, r16, r13, r14);
        this.mScroller.startScroll(r2, r3, r15, r16, r6);
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int r4, int r5) {
        if (r4 >= (this.mParentView.getLeft() + this.mEdgeSize)) goto L5;
        int r0 = 1;
    L7:
        if (r5 >= (this.mParentView.getTop() + this.mEdgeSize)) goto L10;
        r0 = r0 | 4;
    L10:
        if (r4 <= (this.mParentView.getRight() - this.mEdgeSize)) goto L13;
        r0 = r0 | 2;
    L13:
        if (r5 > (this.mParentView.getBottom() - this.mEdgeSize)) goto L15;
        return r0;
    L15:
        return r0 | 8;
    L5:
        r0 = 0;
        goto L7
    }

    private boolean isValidPointerForActionMove(int r2) {
        if (isPointerDown(r2) == true) goto L6;
        Log.e(TAG, "Ignoring pointerId=" + r2 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    L6:
        return true;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.customview.widget.ViewDragHelper$Callback] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void reportNewEdgeDrags(float r3, float r4, int r5) {
        boolean r0 = checkNewEdgeDrag(r3, r4, r5, 1);
        ?? r1 = r0;
        if (checkNewEdgeDrag(r4, r3, r5, 4) == false) goto L5;
        r1 = (r0 ? 1 : 0) | 4;
    L5:
        ?? r2 = r1;
        if (checkNewEdgeDrag(r3, r4, r5, 2) == false) goto L8;
        r2 = (r1 == true ? 1 : 0) | 2;
    L8:
        ?? r6 = r2;
        if (checkNewEdgeDrag(r4, r3, r5, 8) == false) goto L11;
        r6 = (r2 == true ? 1 : 0) | 8;
    L11:
        if (r6 == 0) goto L14;
        int[] r7 = this.mEdgeDragsInProgress;
        r7[r5] = (r7[r5] | r6) == true ? 1 : 0;
        this.mCallback.onEdgeDragStarted(r6, r5);
        return;
    }

    private void saveInitialMotion(float r3, float r4, int r5) {
        ensureMotionHistorySizeForId(r5);
        float[] r0 = this.mInitialMotionX;
        this.mLastMotionX[r5] = r3;
        r0[r5] = r3;
        float[] r1 = this.mInitialMotionY;
        this.mLastMotionY[r5] = r4;
        r1[r5] = r4;
        this.mInitialEdgesTouched[r5] = getEdgesTouched((int) r3, (int) r4);
        this.mPointersDown |= 1 << r5;
    }

    private void saveLastMotion(MotionEvent r7) {
        int r0 = r7.getPointerCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        int r2 = r7.getPointerId(r1);
        if (isValidPointerForActionMove(r2) == false) goto L8;
        float r3 = r7.getX(r1);
        float r4 = r7.getY(r1);
        this.mLastMotionX[r2] = r3;
        this.mLastMotionY[r2] = r4;
    L8:
        r1 = r1 + 1;
        goto L3
    }

    public void abort() {
        cancel();
        if (this.mDragState != 2) goto L5;
        int r0 = this.mScroller.getCurrX();
        int r1 = this.mScroller.getCurrY();
        this.mScroller.abortAnimation();
        int r5 = this.mScroller.getCurrX();
        int r6 = this.mScroller.getCurrY();
        this.mCallback.onViewPositionChanged(this.mCapturedView, r5, r6, r5 - r0, r6 - r1);
    L5:
        setDragState(0);
    }

    public boolean canScroll(@NonNull View r14, boolean r15, int r16, int r17, int r18, int r19) {
        if ((r14 instanceof ViewGroup) == false) goto L18;
        ViewGroup r1 = (ViewGroup) r14;
        int r3 = r14.getScrollX();
        int r4 = r14.getScrollY();
        int r5 = r1.getChildCount() - 1;
    L5:
        if (r5 < 0) goto L18;
        View r7 = r1.getChildAt(r5);
        int r6 = r18 + r3;
        if (r6 < r7.getLeft()) goto L17;
        if (r6 >= r7.getRight()) goto L17;
        int r8 = r19 + r4;
        if (r8 < r7.getTop()) goto L17;
        if (r8 >= r7.getBottom()) goto L17;
        if (canScroll(r7, true, r16, r17, r6 - r7.getLeft(), r8 - r7.getTop()) == false) goto L17;
        return true;
    L17:
        r5 = r5 - 1;
    L18:
        if (r15 == true) goto L20;
    L24:
        return false;
    L20:
        if (r14.canScrollHorizontally(-r16) == false) goto L22;
        return true;
    L22:
        if (r14.canScrollVertically(-r17) == false) goto L24;
        return true;
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        VelocityTracker r0 = this.mVelocityTracker;
        if (r0 == null) goto L6;
        r0.recycle();
        this.mVelocityTracker = null;
        return;
    }

    public void captureChildView(@NonNull View r3, int r4) {
        if (r3.getParent() != this.mParentView) goto L7;
        this.mCapturedView = r3;
        this.mActivePointerId = r4;
        this.mCallback.onViewCaptured(r3, r4);
        setDragState(1);
        return;
    L7:
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
    }

    public boolean continueSettling(boolean r12) {
        if (this.mDragState != 2) goto L23;
        boolean r0 = this.mScroller.computeScrollOffset();
        int r3 = this.mScroller.getCurrX();
        int r10 = this.mScroller.getCurrY();
        int r8 = r3 - this.mCapturedView.getLeft();
        int r9 = r10 - this.mCapturedView.getTop();
        if (r8 == 0) goto L7;
        ViewCompat.offsetLeftAndRight(this.mCapturedView, r8);
    L7:
        if (r9 == 0) goto L9;
        ViewCompat.offsetTopAndBottom(this.mCapturedView, r9);
    L9:
        if (r8 != 0) goto L11;
        if (r9 != 0) goto L11;
    L12:
        if (r0 == true) goto L14;
    L18:
        if (r0 == true) goto L23;
        if (r12 == false) goto L21;
        this.mParentView.post(this.mSetIdleRunnable);
        goto L23
    L21:
        setDragState(0);
        goto L23
    L14:
        if (r3 != this.mScroller.getFinalX()) goto L18;
        if (r10 != this.mScroller.getFinalY()) goto L18;
        this.mScroller.abortAnimation();
        r0 = false;
    L11:
        this.mCallback.onViewPositionChanged(this.mCapturedView, r3, r10, r8, r9);
    L23:
        if (this.mDragState != 2) goto L26;
        return true;
    L26:
        return false;
    }

    @Nullable
    public View findTopChildUnder(int r4, int r5) {
        int r0 = this.mParentView.getChildCount() - 1;
    L3:
        if (r0 < 0) goto L14;
        View r1 = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(r0));
        if (r4 < r1.getLeft()) goto L13;
        if (r4 >= r1.getRight()) goto L13;
        if (r5 < r1.getTop()) goto L13;
        if (r5 >= r1.getBottom()) goto L13;
        return r1;
    L13:
        r0 = r0 - 1;
        goto L3
    L14:
        return null;
    }

    public void flingCapturedView(int r11, int r12, int r13, int r14) {
        if (this.mReleaseInProgress == false) goto L7;
        this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId), r11, r13, r12, r14);
        setDragState(2);
        return;
    L7:
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    @Nullable
    public View getCapturedView() {
        return this.mCapturedView;
    }

    @Px
    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    @Px
    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int r2, int r3) {
        return isViewUnder(this.mCapturedView, r2, r3);
    }

    public boolean isEdgeTouched(int r5) {
        int r0 = this.mInitialEdgesTouched.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (isEdgeTouched(r5, r2) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean isPointerDown(int r2) {
        if ((this.mPointersDown & (1 << r2)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isViewUnder(@Nullable View r2, int r3, int r4) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r3 >= r2.getLeft()) goto L8;
        return false;
    L8:
        if (r3 < r2.getRight()) goto L10;
        return false;
    L10:
        if (r4 >= r2.getTop()) goto L12;
        return false;
    L12:
        if (r4 >= r2.getBottom()) goto L18;
        return true;
    L18:
        return false;
    }

    public void processTouchEvent(@NonNull MotionEvent r10) {
        int r0 = r10.getActionMasked();
        int r1 = r10.getActionIndex();
        if (r0 != 0) goto L6;
        cancel();
    L6:
        if (this.mVelocityTracker != null) goto L8;
        this.mVelocityTracker = VelocityTracker.obtain();
    L8:
        this.mVelocityTracker.addMovement(r10);
        int r2 = 0;
        if (r0 != 0) goto L11;
        float r3 = r10.getX();
        float r4 = r10.getY();
        int r11 = r10.getPointerId(0);
        View r5 = findTopChildUnder((int) r3, (int) r4);
        saveInitialMotion(r3, r4, r11);
        tryCaptureViewForDrag(r5, r11);
        int r6 = this.mInitialEdgesTouched[r11];
        int r7 = this.mTrackingEdges;
        if ((r6 & r7) == 0) goto L102;
        this.mCallback.onEdgeTouched(r6 & r7, r11);
        return;
    L102:
        return;
    L11:
        if (r0 == 1) goto L75;
        if (r0 == 2) goto L54;
        if (r0 == 3) goto L50;
        if (r0 != 5) goto L19;
        int r8 = r10.getPointerId(r1);
        float r9 = r10.getX(r1);
        float r12 = r10.getY(r1);
        saveInitialMotion(r9, r12, r8);
        if (this.mDragState != 0) goto L47;
        tryCaptureViewForDrag(findTopChildUnder((int) r9, (int) r12), r8);
        int r13 = this.mInitialEdgesTouched[r8];
        int r14 = this.mTrackingEdges;
        if ((r13 & r14) == 0) goto L94;
        this.mCallback.onEdgeTouched(r13 & r14, r8);
        return;
    L94:
        return;
    L47:
        if (isCapturedViewUnder((int) r9, (int) r12) == false) goto L96;
        tryCaptureViewForDrag(this.mCapturedView, r8);
        return;
    L96:
        return;
    L19:
        if (r0 != 6) goto L103;
        int r15 = r10.getPointerId(r1);
        if (this.mDragState == 1) goto L24;
    L40:
        clearMotionHistory(r15);
        return;
    L24:
        if (r15 != this.mActivePointerId) goto L40;
        int r16 = r10.getPointerCount();
    L27:
        if (r2 >= r16) goto L37;
        int r17 = r10.getPointerId(r2);
        if (r17 == this.mActivePointerId) goto L36;
        View r18 = findTopChildUnder((int) r10.getX(r2), (int) r10.getY(r2));
        View r19 = this.mCapturedView;
        if (r18 != r19) goto L36;
        if (tryCaptureViewForDrag(r19, r17) == false) goto L36;
        int r110 = this.mActivePointerId;
    L38:
        if (r110 != (-1)) goto L40;
        releaseViewForPointerUp();
    L36:
        r2 = r2 + 1;
        goto L27
    L37:
        r110 = -1;
        goto L38
    L103:
        return;
    L50:
        if (this.mDragState != 1) goto L52;
        dispatchViewReleased(0.0f, 0.0f);
    L52:
        cancel();
        return;
    L54:
        if (this.mDragState == 1) goto L56;
        int r20 = r10.getPointerCount();
    L60:
        if (r2 >= r20) goto L73;
        int r21 = r10.getPointerId(r2);
        if (isValidPointerForActionMove(r21) == false) goto L72;
        float r22 = r10.getX(r2);
        float r23 = r10.getY(r2);
        float r24 = r22 - this.mInitialMotionX[r21];
        float r25 = r23 - this.mInitialMotionY[r21];
        reportNewEdgeDrags(r24, r25, r21);
        if (this.mDragState == 1) goto L73;
        View r26 = findTopChildUnder((int) r22, (int) r23);
        if (checkTouchSlop(r26, r24, r25) == false) goto L72;
        if (tryCaptureViewForDrag(r26, r21) == true) goto L73;
    L72:
        r2 = r2 + 1;
    L73:
        saveLastMotion(r10);
        return;
    L56:
        if (isValidPointerForActionMove(this.mActivePointerId) == false) goto L104;
        int r27 = r10.findPointerIndex(this.mActivePointerId);
        float r28 = r10.getX(r27);
        float r29 = r10.getY(r27);
        float[] r30 = this.mLastMotionX;
        int r31 = this.mActivePointerId;
        int r32 = (int) (r28 - r30[r31]);
        int r33 = (int) (r29 - this.mLastMotionY[r31]);
        dragTo(this.mCapturedView.getLeft() + r32, this.mCapturedView.getTop() + r33, r32, r33);
        saveLastMotion(r10);
        return;
    L104:
        return;
    L75:
        if (this.mDragState != 1) goto L77;
        releaseViewForPointerUp();
    L77:
        cancel();
    }

    public void setDragState(int r3) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState == r3) goto L8;
        this.mDragState = r3;
        this.mCallback.onViewDragStateChanged(r3);
        if (this.mDragState != 0) goto L9;
        this.mCapturedView = null;
        return;
    L9:
        return;
    }

    public void setEdgeTrackingEnabled(int r1) {
        this.mTrackingEdges = r1;
    }

    public void setMinVelocity(float r1) {
        this.mMinVelocity = r1;
    }

    public boolean settleCapturedViewAt(int r4, int r5) {
        if (this.mReleaseInProgress == false) goto L7;
        return forceSettleCapturedViewAt(r4, r5, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
    L7:
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean shouldInterceptTouchEvent(@NonNull MotionEvent r17) {
        int r2 = r17.getActionMasked();
        int r3 = r17.getActionIndex();
        if (r2 != 0) goto L6;
        cancel();
    L6:
        if (this.mVelocityTracker != null) goto L8;
        this.mVelocityTracker = VelocityTracker.obtain();
    L8:
        this.mVelocityTracker.addMovement(r17);
        if (r2 == 0) goto L64;
        if (r2 == 1) goto L63;
        if (r2 == 2) goto L30;
        if (r2 == 3) goto L63;
        if (r2 != 5) goto L17;
        int r4 = r17.getPointerId(r3);
        float r7 = r17.getX(r3);
        float r1 = r17.getY(r3);
        saveInitialMotion(r7, r1, r4);
        int r5 = this.mDragState;
        if (r5 != 0) goto L25;
        int r6 = this.mInitialEdgesTouched[r4];
        int r8 = this.mTrackingEdges;
        if ((r6 & r8) != 0) goto L24;
    L18:
        boolean r9 = false;
    L73:
        if (this.mDragState == 1) goto L75;
        return r9;
    L75:
        return true;
    L24:
        this.mCallback.onEdgeTouched(r6 & r8, r4);
        goto L18
    L25:
        if (r5 != 2) goto L18;
        View r10 = findTopChildUnder((int) r7, (int) r1);
        if (r10 != this.mCapturedView) goto L18;
        tryCaptureViewForDrag(r10, r4);
        goto L18
    L17:
        if (r2 != 6) goto L18;
        clearMotionHistory(r17.getPointerId(r3));
        goto L18
    L30:
        if (this.mInitialMotionX == null) goto L18;
        if (this.mInitialMotionY == null) goto L18;
        int r11 = r17.getPointerCount();
        int r12 = 0;
    L35:
        if (r12 >= r11) goto L62;
        int r13 = r17.getPointerId(r12);
        if (isValidPointerForActionMove(r13) == false) goto L61;
        float r14 = r17.getX(r12);
        float r15 = r17.getY(r12);
        float r16 = r14 - this.mInitialMotionX[r13];
        float r18 = r15 - this.mInitialMotionY[r13];
        View r19 = findTopChildUnder((int) r14, (int) r15);
        if (r19 != null) goto L42;
    L44:
        boolean r20 = false;
    L45:
        if (r20 == false) goto L54;
        int r110 = r19.getLeft();
        int r111 = (int) r16;
        int r112 = this.mCallback.clampViewPositionHorizontal(r19, r110 + r111, r111);
        int r113 = r19.getTop();
        int r114 = (int) r18;
        int r21 = this.mCallback.clampViewPositionVertical(r19, r113 + r114, r114);
        int r115 = this.mCallback.getViewHorizontalDragRange(r19);
        int r116 = this.mCallback.getViewVerticalDragRange(r19);
        if (r115 == 0) goto L50;
        if (r115 <= 0) goto L54;
        if (r112 != r110) goto L54;
    L50:
        if (r116 == 0) goto L62;
        if (r116 <= 0) goto L54;
        if (r21 == r113) goto L62;
    L54:
        reportNewEdgeDrags(r16, r18, r13);
        if (this.mDragState == 1) goto L62;
        if (r20 == false) goto L61;
        if (tryCaptureViewForDrag(r19, r13) == false) goto L61;
    L42:
        if (checkTouchSlop(r19, r16, r18) == false) goto L44;
        r20 = true;
    L61:
        r12 = r12 + 1;
    L62:
        saveLastMotion(r17);
    L63:
        cancel();
        goto L18
    L64:
        float r22 = r17.getX();
        float r23 = r17.getY();
        r9 = false;
        int r24 = r17.getPointerId(0);
        saveInitialMotion(r22, r23, r24);
        View r25 = findTopChildUnder((int) r22, (int) r23);
        if (r25 == this.mCapturedView) goto L67;
    L69:
        int r26 = this.mInitialEdgesTouched[r24];
        int r27 = this.mTrackingEdges;
        if ((r26 & r27) == 0) goto L73;
        this.mCallback.onEdgeTouched(r26 & r27, r24);
        goto L73
    L67:
        if (this.mDragState != 2) goto L69;
        tryCaptureViewForDrag(r25, r24);
        goto L69
    }

    public boolean smoothSlideViewTo(@NonNull View r1, int r2, int r3) {
        this.mCapturedView = r1;
        this.mActivePointerId = -1;
        boolean r4 = forceSettleCapturedViewAt(r2, r3, 0, 0);
        if (r4 == false) goto L5;
    L9:
        return r4;
    L5:
        if (this.mDragState != 0) goto L9;
        if (this.mCapturedView == null) goto L9;
        this.mCapturedView = null;
        goto L9
    }

    public boolean tryCaptureViewForDrag(View r3, int r4) {
        if (r3 == this.mCapturedView) goto L5;
    L7:
        if (r3 != null) goto L9;
        return false;
    L9:
        if (this.mCallback.tryCaptureView(r3, r4) == false) goto L14;
        this.mActivePointerId = r4;
        captureChildView(r3, r4);
        return true;
    L14:
        return false;
    L5:
        if (this.mActivePointerId != r4) goto L7;
        return true;
    }

    private float clampMag(float r2, float r3, float r4) {
        float r1 = Math.abs(r2);
        if (r1 >= r3) goto L6;
        return 0.0f;
    L6:
        if (r1 > r4) goto L8;
        return r2;
    L8:
        if (r2 <= 0.0f) goto L11;
        return r4;
    L11:
        return -r4;
    }

    public static ViewDragHelper create(@NonNull ViewGroup r1, float r2, @NonNull Callback r3) {
        ViewDragHelper r4 = create(r1, r3);
        r4.mTouchSlop = (int) ((1.0f / r2) * r4.mTouchSlop);
        return r4;
    }

    public boolean isEdgeTouched(int r2, int r3) {
        if (isPointerDown(r3) == true) goto L5;
    L7:
        return false;
    L5:
        if ((this.mInitialEdgesTouched[r3] & r2) == 0) goto L7;
        return true;
    }

    public boolean checkTouchSlop(int r5) {
        int r0 = this.mInitialMotionX.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (checkTouchSlop(r5, r2) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean checkTouchSlop(int r7, int r8) {
        if (isPointerDown(r8) == true) goto L6;
        return false;
    L6:
        if ((r7 & 1) != 1) goto L8;
        boolean r0 = true;
    L10:
        if ((r7 & 2) != 2) goto L12;
        boolean r9 = true;
    L13:
        float r3 = this.mLastMotionX[r8] - this.mInitialMotionX[r8];
        float r4 = this.mLastMotionY[r8] - this.mInitialMotionY[r8];
        if (r0 == false) goto L20;
        if (r9 == false) goto L20;
        float r5 = (r4 * r4) + (r3 * r3);
        int r6 = this.mTouchSlop;
        if (r5 > (r6 * r6)) goto L19;
        return false;
    L19:
        return true;
    L20:
        if (r0 == true) goto L22;
        if (r9 == true) goto L27;
        return false;
    L27:
        if (Math.abs(r4) > this.mTouchSlop) goto L29;
        return false;
    L29:
        return true;
    L22:
        if (Math.abs(r3) > this.mTouchSlop) goto L24;
        return false;
    L24:
        return true;
    L12:
        r9 = false;
        goto L13
    L8:
        r0 = false;
        goto L10
    }

    private void clearMotionHistory(int r3) {
        if (this.mInitialMotionX != null) goto L5;
        return;
    L5:
        if (isPointerDown(r3) == false) goto L10;
        this.mInitialMotionX[r3] = 0.0f;
        this.mInitialMotionY[r3] = 0.0f;
        this.mLastMotionX[r3] = 0.0f;
        this.mLastMotionY[r3] = 0.0f;
        this.mInitialEdgesTouched[r3] = 0;
        this.mEdgeDragsInProgress[r3] = 0;
        this.mEdgeDragsLocked[r3] = 0;
        int r0 = this.mPointersDown;
        this.mPointersDown = (~(1 << r3)) & r0;
        return;
    }
}
