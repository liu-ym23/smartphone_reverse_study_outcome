package obric.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes5.dex */
public class CircleProgressPopup extends PopupWindow {
    private static final int DEFAULT_CIRCLE_ANIM_DURATION = 1000;
    private static final String TAG = "CirclePopup";
    private ValueAnimator mCircleAnimator;
    private int mCircleAnimatorDuration;
    private final CircleProgressView mCircleProgressView;
    private final Context mContext;
    private AnimatorSet mEndAnimor;
    private CircleProgressListener mListener;
    private AnimatorSet mStartAnimor;

    public interface CircleProgressListener {
        void cancel();

        void complete();
    }

    public static abstract class CircleProgressListenerAdapter implements CircleProgressListener {
        @Override // obric.widget.CircleProgressPopup.CircleProgressListener
        public void cancel() {
        }

        @Override // obric.widget.CircleProgressPopup.CircleProgressListener
        public void complete() {
        }

        public CircleProgressListenerAdapter() {
        }
    }

    static /* synthetic */ CircleProgressView access$000(CircleProgressPopup r0) {
        return r0.mCircleProgressView;
    }

    static /* synthetic */ void access$100(CircleProgressPopup r0) {
        r0.playCircleAnim();
    }

    static /* synthetic */ void access$200(CircleProgressPopup r0) {
        r0.reset();
    }

    static /* synthetic */ void access$301(CircleProgressPopup r0) {
        super.dismiss();
    }

    static /* synthetic */ CircleProgressListener access$400(CircleProgressPopup r0) {
        return r0.mListener;
    }

    public CircleProgressPopup(Context context) {
        this.mCircleAnimatorDuration = 1000;
        this.mContext = context;
        CircleProgressView r0 = new CircleProgressView(context);
        this.mCircleProgressView = r0;
        setContentView(r0);
        setWidth(-2);
        setHeight(-2);
        setFocusable(false);
        setTouchable(false);
        setWindowLayoutType(1002);
        setClippingEnabled(false);
        setAttachedInDecor(false);
        initAnim();
    }

    public void show(View view, int x, int y, final boolean withAnim) {
        if (isShowing() == false) goto L5;
        dismissImmediate();
    L5:
        int[] r1 = new int[2];
        view.getLocationOnScreen(r1);
        int r3 = (r1[0] + x) - (this.mCircleProgressView.getCircleWidth() / 2);
        int r6 = (r1[1] + y) - (this.mCircleProgressView.getCircleHeight() / 2);
        this.mCircleProgressView.reset();
        showAtLocation(view, 0, r3, r6);
        playStartAnim(withAnim);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.mEndAnimor.isRunning() == false) goto L5;
        return;
    L5:
        if (isShowing() == false) goto L9;
        cancelCircleAnim();
        reset();
        playEndAnim();
        return;
    }

    public void setCircleProgressListener(CircleProgressListener listener) {
        this.mListener = listener;
    }

    public void setCircleAnimDuration(int duration) {
        this.mCircleAnimatorDuration = duration;
    }

    private void dismissImmediate() {
        cancelCircleAnim();
        reset();
        super.dismiss();
    }

    private void initAnim() {
        this.mStartAnimor = new AnimatorSet();
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this.mCircleProgressView, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.mCircleProgressView, "scaleX", new float[]{0.5f, 1.0f});
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.mCircleProgressView, "scaleY", new float[]{0.5f, 1.0f});
        this.mStartAnimor.setDuration(100);
        this.mStartAnimor.playTogether(new Animator[]{r0, r2, r4});
        this.mEndAnimor = new AnimatorSet();
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.mCircleProgressView, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this.mCircleProgressView, "scaleX", new float[]{1.0f, 0.5f});
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this.mCircleProgressView, "scaleY", new float[]{1.0f, 0.5f});
        this.mEndAnimor.setDuration(300);
        this.mEndAnimor.playTogether(new Animator[]{r3, r5, r6});
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        this.mCircleAnimator = r1;
        r1.setDuration(this.mCircleAnimatorDuration);
        this.mCircleAnimator.addUpdateListener(new AnonymousClass1(this));
    }

    private void cancelCircleAnim() {
        if (this.mStartAnimor.isRunning() == false) goto L9;
        CircleProgressListener r0 = this.mListener;
        if (r0 == null) goto L9;
        r0.cancel();
        return;
    L9:
        if (this.mCircleAnimator.isRunning() == false) goto L12;
        this.mCircleAnimator.cancel();
        return;
    }

    private void reset() {
        this.mCircleAnimator.removeAllListeners();
        this.mStartAnimor.removeAllListeners();
        this.mEndAnimor.removeAllListeners();
        if (this.mCircleAnimator.isRunning() == false) goto L6;
        this.mCircleAnimator.cancel();
    L6:
        if (this.mStartAnimor.isRunning() == false) goto L9;
        this.mStartAnimor.end();
    L9:
        if (this.mEndAnimor.isRunning() == false) goto L12;
        this.mEndAnimor.end();
        return;
    }

    private void playStartAnim(final boolean nextAnim) {
        this.mStartAnimor.start();
        this.mStartAnimor.addListener(new AnonymousClass2(this, nextAnim));
    }

    private void playEndAnim() {
        this.mEndAnimor.start();
        this.mEndAnimor.addListener(new AnonymousClass3(this));
    }

    private void playCircleAnim() {
        this.mCircleAnimator.setDuration(this.mCircleAnimatorDuration);
        if (this.mListener == null) goto L5;
        this.mCircleAnimator.addListener(new AnonymousClass4(this));
    L5:
        this.mCircleAnimator.start();
    }
}
