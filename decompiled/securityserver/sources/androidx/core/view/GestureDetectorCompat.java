package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public final class GestureDetectorCompat {
    private final GestureDetectorCompatImpl mImpl;

    public interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent r1);

        void setIsLongpressEnabled(boolean r1);

        void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener r1);
    }

    public static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        private static final int DOUBLE_TAP_TIMEOUT = 0;
        private static final int LONGPRESS_TIMEOUT = 0;
        private static final int LONG_PRESS = 2;
        private static final int SHOW_PRESS = 1;
        private static final int TAP = 3;
        private static final int TAP_TIMEOUT = 0;
        private boolean mAlwaysInBiggerTapRegion;
        private boolean mAlwaysInTapRegion;
        MotionEvent mCurrentDownEvent;
        boolean mDeferConfirmSingleTap;
        GestureDetector.OnDoubleTapListener mDoubleTapListener;
        private int mDoubleTapSlopSquare;
        private float mDownFocusX;
        private float mDownFocusY;
        private final Handler mHandler;
        private boolean mInLongPress;
        private boolean mIsDoubleTapping;
        private boolean mIsLongpressEnabled;
        private float mLastFocusX;
        private float mLastFocusY;
        final GestureDetector.OnGestureListener mListener;
        private int mMaximumFlingVelocity;
        private int mMinimumFlingVelocity;
        private MotionEvent mPreviousUpEvent;
        boolean mStillDown;
        private int mTouchSlopSquare;
        private VelocityTracker mVelocityTracker;

        public class GestureHandler extends Handler {
            final /* synthetic */ GestureDetectorCompatImplBase this$0;

            public GestureHandler(GestureDetectorCompatImplBase r1) {
                this.this$0 = r1;
            }

            @Override // android.os.Handler
            public void handleMessage(Message r4) {
                int r0 = r4.what;
                if (r0 != 1) goto L5;
                GestureDetectorCompatImplBase r3 = this.this$0;
                r3.mListener.onShowPress(r3.mCurrentDownEvent);
                return;
            L5:
                if (r0 != 2) goto L7;
                this.this$0.dispatchLongPress();
                return;
            L7:
                if (r0 != 3) goto L15;
                GestureDetectorCompatImplBase r5 = this.this$0;
                GestureDetector.OnDoubleTapListener r6 = r5.mDoubleTapListener;
                if (r6 != null) goto L11;
                return;
            L11:
                if (r5.mStillDown == true) goto L13;
                r6.onSingleTapConfirmed(r5.mCurrentDownEvent);
                return;
            L13:
                r5.mDeferConfirmSingleTap = true;
                return;
            L15:
                throw new RuntimeException("Unknown message " + r4);
            }

            public GestureHandler(GestureDetectorCompatImplBase r1, Handler r2) {
                this.this$0 = r1;
                super(r2.getLooper());
            }
        }

        static {
            LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
            TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
            DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
        }

        public GestureDetectorCompatImplBase(Context r2, GestureDetector.OnGestureListener r3, Handler r4) {
            if (r4 == null) goto L5;
            this.mHandler = new GestureHandler(this, r4);
        L6:
            this.mListener = r3;
            if ((r3 instanceof GestureDetector.OnDoubleTapListener) == false) goto L9;
            setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) r3);
        L9:
            init(r2);
            return;
        L5:
            this.mHandler = new GestureHandler(this);
            goto L6
        }

        private void cancel() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mIsDoubleTapping = false;
            this.mStillDown = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress == false) goto L6;
            this.mInLongPress = false;
            return;
        }

        private void cancelTaps() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mIsDoubleTapping = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress == false) goto L6;
            this.mInLongPress = false;
            return;
        }

        private void init(Context r4) {
            if (r4 == null) goto L10;
            if (this.mListener == null) goto L8;
            this.mIsLongpressEnabled = true;
            ViewConfiguration r5 = ViewConfiguration.get(r4);
            int r0 = r5.getScaledTouchSlop();
            int r1 = r5.getScaledDoubleTapSlop();
            this.mMinimumFlingVelocity = r5.getScaledMinimumFlingVelocity();
            this.mMaximumFlingVelocity = r5.getScaledMaximumFlingVelocity();
            this.mTouchSlopSquare = r0 * r0;
            this.mDoubleTapSlopSquare = r1 * r1;
            return;
        L8:
            throw new IllegalArgumentException("OnGestureListener must not be null");
        L10:
            throw new IllegalArgumentException("Context must not be null");
        }

        private boolean isConsideredDoubleTap(MotionEvent r7, MotionEvent r8, MotionEvent r9) {
            if (this.mAlwaysInBiggerTapRegion == true) goto L6;
            return false;
        L6:
            if ((r9.getEventTime() - r8.getEventTime()) <= DOUBLE_TAP_TIMEOUT) goto L8;
            return false;
        L8:
            int r10 = ((int) r7.getX()) - ((int) r9.getX());
            int r11 = ((int) r7.getY()) - ((int) r9.getY());
            if (((r11 * r11) + (r10 * r10)) >= this.mDoubleTapSlopSquare) goto L12;
            return true;
        L12:
            return false;
        }

        public void dispatchLongPress() {
            this.mHandler.removeMessages(3);
            this.mDeferConfirmSingleTap = false;
            this.mInLongPress = true;
            this.mListener.onLongPress(this.mCurrentDownEvent);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.mIsLongpressEnabled;
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean onTouchEvent(MotionEvent r13) {
            int r0 = r13.getAction();
            if (this.mVelocityTracker != null) goto L5;
            this.mVelocityTracker = VelocityTracker.obtain();
        L5:
            this.mVelocityTracker.addMovement(r13);
            int r1 = r0 & 255;
            if (r1 != 6) goto L8;
            boolean r4 = true;
        L9:
            if (r4 == false) goto L11;
            int r5 = r13.getActionIndex();
        L12:
            int r6 = r13.getPointerCount();
            int r8 = 0;
            float r9 = 0.0f;
            float r10 = 0.0f;
        L13:
            if (r8 >= r6) goto L18;
            if (r5 == r8) goto L17;
            r9 = r9 + r13.getX(r8);
            r10 = r10 + r13.getY(r8);
        L17:
            r8 = r8 + 1;
            goto L13
        L18:
            if (r4 == false) goto L20;
            int r7 = r6 - 1;
        L21:
            float r11 = r7;
            float r12 = r9 / r11;
            float r14 = r10 / r11;
            if (r1 == 0) goto L91;
            if (r1 == 1) goto L62;
            if (r1 == 2) goto L42;
            if (r1 != 3) goto L28;
            cancel();
            return false;
        L28:
            if (r1 == 5) goto L39;
            if (r1 != 6) goto L127;
            this.mLastFocusX = r12;
            this.mDownFocusX = r12;
            this.mLastFocusY = r14;
            this.mDownFocusY = r14;
            this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
            int r2 = r13.getActionIndex();
            int r3 = r13.getPointerId(r2);
            float r15 = this.mVelocityTracker.getXVelocity(r3);
            float r16 = this.mVelocityTracker.getYVelocity(r3);
            int r17 = 0;
        L32:
            if (r17 >= r6) goto L129;
            if (r17 == r2) goto L38;
            int r18 = r13.getPointerId(r17);
            if (((this.mVelocityTracker.getYVelocity(r18) * r16) + (this.mVelocityTracker.getXVelocity(r18) * r15)) >= 0.0f) goto L38;
            this.mVelocityTracker.clear();
            return false;
        L38:
            r17 = r17 + 1;
            goto L32
        L129:
            return false;
        L127:
            return false;
        L39:
            this.mLastFocusX = r12;
            this.mDownFocusX = r12;
            this.mLastFocusY = r14;
            this.mDownFocusY = r14;
            cancelTaps();
            return false;
        L42:
            if (this.mInLongPress == true) goto L128;
            float r19 = this.mLastFocusX - r12;
            float r20 = this.mLastFocusY - r14;
            if (this.mIsDoubleTapping == false) goto L48;
            return this.mDoubleTapListener.onDoubleTapEvent(r13);
        L48:
            if (this.mAlwaysInTapRegion == false) goto L58;
            int r21 = (int) (r12 - this.mDownFocusX);
            int r22 = (int) (r14 - this.mDownFocusY);
            int r23 = (r22 * r22) + (r21 * r21);
            if (r23 <= this.mTouchSlopSquare) goto L52;
            boolean r110 = this.mListener.onScroll(this.mCurrentDownEvent, r13, r19, r20);
            this.mLastFocusX = r12;
            this.mLastFocusY = r14;
            this.mAlwaysInTapRegion = false;
            this.mHandler.removeMessages(3);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        L54:
            if (r23 <= this.mTouchSlopSquare) goto L124;
            this.mAlwaysInBiggerTapRegion = false;
        L124:
            return r110;
        L52:
            r110 = false;
            goto L54
        L58:
            if (Math.abs(r19) < 1.0f) goto L60;
        L61:
            boolean r24 = this.mListener.onScroll(this.mCurrentDownEvent, r13, r19, r20);
            this.mLastFocusX = r12;
            this.mLastFocusY = r14;
            return r24;
        L60:
            if (Math.abs(r20) >= 1.0f) goto L61;
            return false;
        L128:
            return false;
        L62:
            this.mStillDown = false;
            MotionEvent r25 = MotionEvent.obtain(r13);
            if (this.mIsDoubleTapping == false) goto L66;
            r110 = this.mDoubleTapListener.onDoubleTapEvent(r13);
        L83:
            MotionEvent r26 = this.mPreviousUpEvent;
            if (r26 == null) goto L86;
            r26.recycle();
        L86:
            this.mPreviousUpEvent = r25;
            VelocityTracker r27 = this.mVelocityTracker;
            if (r27 == null) goto L89;
            r27.recycle();
            this.mVelocityTracker = null;
        L89:
            this.mIsDoubleTapping = false;
            this.mDeferConfirmSingleTap = false;
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            goto L124
        L66:
            if (this.mInLongPress == false) goto L69;
            this.mHandler.removeMessages(3);
            this.mInLongPress = false;
        L81:
            r110 = false;
            goto L83
        L69:
            if (this.mAlwaysInTapRegion == false) goto L76;
            boolean r28 = this.mListener.onSingleTapUp(r13);
            if (this.mDeferConfirmSingleTap == false) goto L75;
            GestureDetector.OnDoubleTapListener r29 = this.mDoubleTapListener;
            if (r29 == null) goto L75;
            r29.onSingleTapConfirmed(r13);
        L75:
            r110 = r28;
            goto L83
        L76:
            VelocityTracker r30 = this.mVelocityTracker;
            int r31 = r13.getPointerId(0);
            r30.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
            float r32 = r30.getYVelocity(r31);
            float r33 = r30.getXVelocity(r31);
            if (Math.abs(r32) <= this.mMinimumFlingVelocity) goto L79;
        L82:
            r110 = this.mListener.onFling(this.mCurrentDownEvent, r13, r33, r32);
            goto L83
        L79:
            if (Math.abs(r33) <= this.mMinimumFlingVelocity) goto L81;
        L91:
            if (this.mDoubleTapListener == null) goto L104;
            boolean r34 = this.mHandler.hasMessages(3);
            if (r34 == false) goto L95;
            this.mHandler.removeMessages(3);
        L95:
            MotionEvent r35 = this.mCurrentDownEvent;
            if (r35 == null) goto L103;
            MotionEvent r36 = this.mPreviousUpEvent;
            if (r36 == null) goto L103;
            if (r34 == false) goto L103;
            if (isConsideredDoubleTap(r35, r36, r13) == false) goto L103;
            this.mIsDoubleTapping = true;
            boolean r37 = this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | this.mDoubleTapListener.onDoubleTapEvent(r13);
        L105:
            this.mLastFocusX = r12;
            this.mDownFocusX = r12;
            this.mLastFocusY = r14;
            this.mDownFocusY = r14;
            MotionEvent r38 = this.mCurrentDownEvent;
            if (r38 == null) goto L108;
            r38.recycle();
        L108:
            this.mCurrentDownEvent = MotionEvent.obtain(r13);
            this.mAlwaysInTapRegion = true;
            this.mAlwaysInBiggerTapRegion = true;
            this.mStillDown = true;
            this.mInLongPress = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mIsLongpressEnabled == false) goto L111;
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageAtTime(2, (this.mCurrentDownEvent.getDownTime() + ((long) TAP_TIMEOUT)) + ((long) LONGPRESS_TIMEOUT));
        L111:
            this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + ((long) TAP_TIMEOUT));
            return r37 | this.mListener.onDown(r13);
        L103:
            this.mHandler.sendEmptyMessageDelayed(3, DOUBLE_TAP_TIMEOUT);
        L104:
            r37 = false;
            goto L105
        L20:
            r7 = r6;
            goto L21
        L11:
            r5 = -1;
            goto L12
        L8:
            r4 = false;
            goto L9
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean r1) {
            this.mIsLongpressEnabled = r1;
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener r1) {
            this.mDoubleTapListener = r1;
        }
    }

    public static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        private final GestureDetector mDetector;

        public GestureDetectorCompatImplJellybeanMr2(Context r2, GestureDetector.OnGestureListener r3, Handler r4) {
            this.mDetector = new GestureDetector(r2, r3, r4);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.mDetector.isLongpressEnabled();
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean onTouchEvent(MotionEvent r1) {
            return this.mDetector.onTouchEvent(r1);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean r1) {
            this.mDetector.setIsLongpressEnabled(r1);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener r1) {
            this.mDetector.setOnDoubleTapListener(r1);
        }
    }

    public GestureDetectorCompat(Context r2, GestureDetector.OnGestureListener r3) {
        this(r2, r3, null);
    }

    public boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent r1) {
        return this.mImpl.onTouchEvent(r1);
    }

    public void setIsLongpressEnabled(boolean r1) {
        this.mImpl.setIsLongpressEnabled(r1);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener r1) {
        this.mImpl.setOnDoubleTapListener(r1);
    }

    public GestureDetectorCompat(Context r2, GestureDetector.OnGestureListener r3, Handler r4) {
        this.mImpl = new GestureDetectorCompatImplJellybeanMr2(r2, r3, r4);
    }
}
