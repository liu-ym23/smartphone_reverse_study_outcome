package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ShowableListMenu;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {
    private int mActivePointerId;
    private Runnable mDisallowIntercept;
    private boolean mForwarding;
    private final int mLongPressTimeout;
    private final float mScaledTouchSlop;
    final View mSrc;
    private final int mTapTimeout;
    private final int[] mTmpLocation;
    private Runnable mTriggerLongPress;

    public class DisallowIntercept implements Runnable {
        final /* synthetic */ ForwardingListener this$0;

        public DisallowIntercept(ForwardingListener r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent r1 = this.this$0.mSrc.getParent();
            if (r1 == null) goto L6;
            r1.requestDisallowInterceptTouchEvent(true);
            return;
        }
    }

    public class TriggerLongPress implements Runnable {
        final /* synthetic */ ForwardingListener this$0;

        public TriggerLongPress(ForwardingListener r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.onLongPress();
        }
    }

    public ForwardingListener(View r3) {
        this.mTmpLocation = new int[2];
        this.mSrc = r3;
        r3.setLongClickable(true);
        r3.addOnAttachStateChangeListener(this);
        this.mScaledTouchSlop = ViewConfiguration.get(r3.getContext()).getScaledTouchSlop();
        int r4 = ViewConfiguration.getTapTimeout();
        this.mTapTimeout = r4;
        this.mLongPressTimeout = (ViewConfiguration.getLongPressTimeout() + r4) / 2;
    }

    private void clearCallbacks() {
        Runnable r0 = this.mTriggerLongPress;
        if (r0 == null) goto L5;
        this.mSrc.removeCallbacks(r0);
    L5:
        Runnable r1 = this.mDisallowIntercept;
        if (r1 == null) goto L9;
        this.mSrc.removeCallbacks(r1);
        return;
    }

    private boolean onTouchForwarded(MotionEvent r5) {
        View r0 = this.mSrc;
        ShowableListMenu r1 = getPopup();
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.isShowing() == false) goto L26;
        DropDownListView r2 = (DropDownListView) r1.getListView();
        if (r2 != null) goto L10;
        return false;
    L10:
        if (r2.isShown() == false) goto L27;
        MotionEvent r3 = MotionEvent.obtainNoHistory(r5);
        toGlobalMotionEvent(r0, r3);
        toLocalMotionEvent(r2, r3);
        boolean r4 = r2.onForwardedEvent(r3, this.mActivePointerId);
        r3.recycle();
        int r6 = r5.getActionMasked();
        if (r6 != 1) goto L15;
    L17:
        boolean r7 = false;
    L18:
        if (r4 == false) goto L24;
        if (r7 == true) goto L21;
        return false;
    L21:
        return true;
    L24:
        return false;
    L15:
        if (r6 == 3) goto L17;
        r7 = true;
        goto L18
    L27:
        return false;
    L26:
        return false;
    }

    private boolean onTouchObserved(MotionEvent r6) {
        View r0 = this.mSrc;
        if (r0.isEnabled() == true) goto L5;
        return false;
    L5:
        int r1 = r6.getActionMasked();
        if (r1 != 0) goto L8;
        this.mActivePointerId = r6.getPointerId(0);
        if (this.mDisallowIntercept != null) goto L24;
        this.mDisallowIntercept = new DisallowIntercept(this);
    L24:
        r0.postDelayed(this.mDisallowIntercept, this.mTapTimeout);
        if (this.mTriggerLongPress != null) goto L27;
        this.mTriggerLongPress = new TriggerLongPress(this);
    L27:
        r0.postDelayed(this.mTriggerLongPress, this.mLongPressTimeout);
    L28:
        return false;
    L8:
        if (r1 != 1) goto L10;
    L20:
        clearCallbacks();
        goto L28
    L10:
        if (r1 != 2) goto L12;
        int r2 = r6.findPointerIndex(this.mActivePointerId);
        if (r2 < 0) goto L28;
        if (pointInView(r0, r6.getX(r2), r6.getY(r2), this.mScaledTouchSlop) == true) goto L28;
        clearCallbacks();
        r0.getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L12:
        if (r1 == 3) goto L20;
        goto L20
    }

    private static boolean pointInView(View r2, float r3, float r4, float r5) {
        float r0 = -r5;
        if (r3 >= r0) goto L5;
    L11:
        return false;
    L5:
        if (r4 < r0) goto L11;
        if (r3 >= ((r2.getRight() - r2.getLeft()) + r5)) goto L11;
        if (r4 >= ((r2.getBottom() - r2.getTop()) + r5)) goto L11;
        return true;
    }

    private boolean toGlobalMotionEvent(View r2, MotionEvent r3) {
        int[] r1 = this.mTmpLocation;
        r2.getLocationOnScreen(r1);
        r3.offsetLocation(r1[0], r1[1]);
        return true;
    }

    private boolean toLocalMotionEvent(View r2, MotionEvent r3) {
        int[] r1 = this.mTmpLocation;
        r2.getLocationOnScreen(r1);
        r3.offsetLocation(-r1[0], -r1[1]);
        return true;
    }

    public abstract ShowableListMenu getPopup();

    public boolean onForwardingStarted() {
        ShowableListMenu r1 = getPopup();
        if (r1 != null) goto L5;
        return true;
    L5:
        if (r1.isShowing() == true) goto L10;
        r1.show();
        return true;
    L10:
        return true;
    }

    public boolean onForwardingStopped() {
        ShowableListMenu r1 = getPopup();
        if (r1 != null) goto L5;
        return true;
    L5:
        if (r1.isShowing() == false) goto L10;
        r1.dismiss();
        return true;
    L10:
        return true;
    }

    public void onLongPress() {
        clearCallbacks();
        View r0 = this.mSrc;
        if (r0.isEnabled() == true) goto L5;
        return;
    L5:
        if (r0.isLongClickable() == false) goto L8;
        return;
    L8:
        if (onForwardingStarted() == true) goto L10;
        return;
    L10:
        r0.getParent().requestDisallowInterceptTouchEvent(true);
        long r5 = SystemClock.uptimeMillis();
        MotionEvent r1 = MotionEvent.obtain(r5, r5, 3, 0.0f, 0.0f, 0);
        r0.onTouchEvent(r1);
        r1.recycle();
        this.mForwarding = true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r11, MotionEvent r12) {
        boolean r13 = this.mForwarding;
        if (r13 == false) goto L12;
        if (onTouchForwarded(r12) == false) goto L7;
    L10:
        boolean r14 = true;
    L19:
        this.mForwarding = r14;
        if (r14 == true) goto L25;
        if (r13 == false) goto L24;
        return true;
    L24:
        return false;
    L25:
        return true;
    L7:
        if (onForwardingStopped() == false) goto L10;
        r14 = false;
        goto L19
    L12:
        if (onTouchObserved(r12) == true) goto L14;
    L16:
        r14 = false;
    L17:
        if (r14 == false) goto L19;
        long r4 = SystemClock.uptimeMillis();
        MotionEvent r2 = MotionEvent.obtain(r4, r4, 3, 0.0f, 0.0f, 0);
        this.mSrc.onTouchEvent(r2);
        r2.recycle();
        goto L19
    L14:
        if (onForwardingStarted() == false) goto L16;
        r14 = true;
        goto L17
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r1) {
        this.mForwarding = false;
        this.mActivePointerId = -1;
        Runnable r2 = this.mDisallowIntercept;
        if (r2 == null) goto L6;
        this.mSrc.removeCallbacks(r2);
        return;
    }
}
