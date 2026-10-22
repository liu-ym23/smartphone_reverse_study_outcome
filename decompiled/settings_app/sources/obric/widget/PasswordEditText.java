package obric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.IntArray;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class PasswordEditText extends EditText {
    private static final int EYE_DRAWABLE_PADDING = 48;
    private static final int INPUT_TYPE_CLEAR_VARIATION_MASK = -4096;
    private static final int INPUT_TYPE_VARIATION_MASK = 4095;
    private EyeAnimator mEyeAnimator;
    private int mEyePaddingLeft;
    private int mEyePaddingRight;
    private int mEyePaddingTop;
    private Rect mEyeRect;
    private int mInvisibleVariation;
    private Runnable mPendingSetInputType;
    private final TouchHelper mTouchHelper;
    private boolean mVisible;
    private int mVisibleVariation;

    private final class EyeAnimator extends Handler {
        private static final int MESSAGE_START = 0;
        private static final int MESSAGE_TICK = 1;
        private AnimationDrawable mAnimationDrawables;
        private int mCurrent;
        private int mDirection;
        private int mNumberOfFrames;
        final /* synthetic */ PasswordEditText this$0;

        public EyeAnimator(final PasswordEditText this$0, Context context) {
            this.this$0 = this$0;
            AnimationDrawable r1 = (AnimationDrawable) context.getResources().getDrawable(R.drawable.pwd_eye_open_close_anim);
            this.mAnimationDrawables = r1;
            this.mNumberOfFrames = r1.getNumberOfFrames();
            resetCurrent();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            int r2 = msg.what;
            if (r2 != 0) goto L5;
            tick();
            return;
        L5:
            if (r2 != 1) goto L11;
            tick();
            return;
        }

        Drawable getCurrentDrawable() {
            return this.mAnimationDrawables.getFrame(this.mCurrent);
        }

        void setEyeAnimatorDrawable(Drawable drawable) {
            AnimationDrawable r1 = (AnimationDrawable) drawable;
            this.mAnimationDrawables = r1;
            this.mNumberOfFrames = r1.getNumberOfFrames();
            resetCurrent();
        }

        void resetCurrent() {
            if (PasswordEditText.access$100(this.this$0) == false) goto L5;
            int r0 = 0;
        L6:
            this.mCurrent = r0;
            return;
        L5:
            r0 = this.mNumberOfFrames - 1;
            goto L6
        }

        void setDirection() {
            if (PasswordEditText.access$100(this.this$0) == false) goto L5;
            int r0 = 1;
        L6:
            this.mDirection = r0;
            return;
        L5:
            r0 = -1;
            goto L6
        }

        int getAnimationDuration() {
            int r0 = this.mAnimationDrawables.getDuration(this.mCurrent);
            int r1 = this.mDirection;
            if (r1 > 0) goto L5;
            if (r1 < 0) goto L8;
            return 0;
        L8:
            return r0 * this.mCurrent;
        L5:
            return r0 * (this.mNumberOfFrames - this.mCurrent);
        }

        void tick() {
            removeMessages(1);
            int r1 = this.mCurrent;
            int r2 = this.mDirection + r1;
            if (r2 >= 0) goto L5;
        L7:
            this.this$0.invalidate();
            return;
        L5:
            if (r2 >= this.mNumberOfFrames) goto L7;
            int r3 = this.mAnimationDrawables.getDuration(r1);
            this.mCurrent = r2;
            sendEmptyMessageDelayed(1, r3);
            goto L7
        }

        void stop() {
            removeMessages(0);
            removeMessages(1);
        }

        void start() {
            sendEmptyMessage(0);
        }
    }

    protected class TouchHelper extends ExploreByTouchHelper {
        final /* synthetic */ PasswordEditText this$0;

        public TouchHelper(final PasswordEditText this$0, View host) {
            this.this$0 = this$0;
            super(host);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float x, float y) {
            Drawable r2 = PasswordEditText.access$500(this.this$0);
            if (r2 == null) goto L8;
            Rect r3 = r2.getBounds();
            if ((((int) x) + this.this$0.getScrollX()) < r3.left) goto L10;
            return 0;
        L10:
            return Integer.MIN_VALUE;
        L8:
            return Integer.MIN_VALUE;
        }

        protected void getVisibleVirtualViews(IntArray virtualViewIds) {
            virtualViewIds.add(0);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> virtualViewIds) {
            virtualViewIds.add(0);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int virtualViewId, AccessibilityEvent event) {
            event.setContentDescription(getItemDescription());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int virtualViewId, AccessibilityNodeInfoCompat node) {
            node.setContentDescription(getItemDescription());
            Drawable r0 = PasswordEditText.access$500(this.this$0);
            if (r0 == null) goto L5;
            node.setBoundsInParent(r0.getBounds());
        L5:
            node.addAction(16);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int virtualViewId, int action, Bundle arguments) {
            if (action == 16) goto L6;
            return false;
        L6:
            PasswordEditText.access$000(this.this$0).setDirection();
            PasswordEditText.access$000(this.this$0).start();
            if (PasswordEditText.access$600(this.this$0) != null) goto L9;
            PasswordEditText.access$602(this.this$0, new AnonymousClass1(this));
        L9:
            PasswordEditText r3 = this.this$0;
            r3.postDelayed(PasswordEditText.access$600(r3), PasswordEditText.access$000(this.this$0).getAnimationDuration() / 2);
            PasswordEditText.access$700(this.this$0);
            PasswordEditText.access$800(this.this$0).invalidateRoot();
            return true;
        }

        CharSequence getItemDescription() {
            if (PasswordEditText.access$100(this.this$0) == false) goto L5;
            int r0 = R.string.hide_password;
        L7:
            return this.this$0.getContext().getString(r0);
        L5:
            r0 = R.string.show_password;
            goto L7
        }
    }

    static /* synthetic */ EyeAnimator access$000(PasswordEditText r0) {
        return r0.mEyeAnimator;
    }

    static /* synthetic */ boolean access$100(PasswordEditText r0) {
        return r0.mVisible;
    }

    static /* synthetic */ int access$200(PasswordEditText r0) {
        return r0.mInvisibleVariation;
    }

    static /* synthetic */ void access$300(PasswordEditText r0, int r1, boolean r2) {
        r0.setInputType(r1, r2);
    }

    static /* synthetic */ int access$400(PasswordEditText r0) {
        return r0.mVisibleVariation;
    }

    static /* synthetic */ Drawable access$500(PasswordEditText r0) {
        return r0.getEyeDrawable();
    }

    static /* synthetic */ Runnable access$600(PasswordEditText r0) {
        return r0.mPendingSetInputType;
    }

    static /* synthetic */ Runnable access$602(PasswordEditText r0, Runnable r1) {
        r0.mPendingSetInputType = r1;
        return r1;
    }

    static /* synthetic */ void access$700(PasswordEditText r0) {
        r0.onEyeIconClick();
    }

    static /* synthetic */ TouchHelper access$800(PasswordEditText r0) {
        return r0.mTouchHelper;
    }

    public PasswordEditText(Context context) {
        this(context, null);
    }

    public PasswordEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
    }

    public PasswordEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mEyePaddingTop = 0;
        if (updateVisibleStatus(getInputType()) == false) goto L7;
        this.mEyeRect = new Rect();
        this.mEyePaddingRight = 48;
        this.mEyeAnimator = new EyeAnimator(this, context);
        TouchHelper r1 = new TouchHelper(this, this);
        this.mTouchHelper = r1;
        ViewCompat.setAccessibilityDelegate(this, r1);
        return;
    L7:
        throw new IllegalArgumentException("PasswordEditText doesn't have password InputType");
    }

    private Drawable getEyeDrawable() {
        return this.mEyeAnimator.getCurrentDrawable();
    }

    public void setEyeAnimator(Drawable drawable) {
        this.mEyeAnimator.setEyeAnimatorDrawable(drawable);
    }

    public void setEyePaddingRight(int padding) {
        this.mEyePaddingRight = padding;
    }

    public void setEyePaddingLeft(int padding) {
        this.mEyePaddingLeft = padding;
    }

    public void setEyePaddingTop(int padding) {
        this.mEyePaddingTop = padding;
    }

    private boolean updateVisibleStatus(int inputType) {
        int r4 = inputType & INPUT_TYPE_VARIATION_MASK;
        if (r4 != 129) goto L5;
    L20:
        this.mInvisibleVariation = r4;
        this.mVisibleVariation = r4 | 144;
        this.mVisible = false;
        return true;
    L5:
        if (r4 == 225) goto L20;
        if (r4 == 18) goto L20;
        if ((r4 & 144) == 0) goto L19;
        int r0 = r4 - 144;
        this.mInvisibleVariation = r0;
        if (r0 != 1) goto L15;
        this.mInvisibleVariation = r0 | 128;
    L17:
        this.mVisibleVariation = r4;
        this.mVisible = true;
        return true;
    L15:
        if (r0 != 2) goto L17;
        this.mInvisibleVariation = r0 | 16;
        goto L17
    L19:
        return false;
    }

    @Override // android.widget.TextView
    public void setInputType(int type) {
        setInputType(type, true);
    }

    private void setInputType(int type, boolean reset) {
        super.setInputType(type);
        updateVisibleStatus(type);
        if (reset == false) goto L6;
        this.mEyeAnimator.resetCurrent();
        return;
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingRight() {
        int r0 = super.getCompoundPaddingRight();
        Drawable r1 = getEyeDrawable();
        if (r1 != null) goto L5;
        return r0;
    L5:
        return r1.getIntrinsicWidth() + Math.max(r0, this.mEyePaddingRight + this.mEyePaddingLeft);
    }

    public int getHorizontalOffsetForDrawables() {
        Drawable r0 = getEyeDrawable();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getIntrinsicWidth();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable r0 = getEyeDrawable();
        int r2 = 0;
        if (getParent() != null) goto L12;
    L8:
        if (r0 == null) goto L14;
        int r1 = r0.getIntrinsicHeight();
        int r3 = r0.getIntrinsicWidth();
        Rect r4 = this.mEyeRect;
        r4.top = ((getHeight() - r1) / 2) + this.mEyePaddingTop;
        Rect r5 = this.mEyeRect;
        r5.bottom = r5.top + r1;
        Rect r6 = this.mEyeRect;
        r6.left = getScrollX() + ((getWidth() - r3) - (this.mEyePaddingRight - r2));
        Rect r7 = this.mEyeRect;
        r7.right = r7.left + r3;
        r0.setBounds(this.mEyeRect);
        r0.draw(canvas);
        return;
    L14:
        return;
    L12:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ((View) getParent()).getLayoutParams();     // Catch: ClassCastException -> L11
        if (r8 == null) goto L8;
        r2 = r8.rightMargin;     // Catch: ClassCastException -> L11
        goto L8
    }

    @Override // android.widget.TextView, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent event, int pointerIndex) {
        if (getPointerIcon() != null) goto L13;
        if (isClickable() == false) goto L13;
        if (isEnabled() == false) goto L13;
        if (isEye(event, this.mEyeRect) == false) goto L13;
        return PointerIcon.getSystemIcon(getContext(), 1002);
    L13:
        return super.onResolvePointerIcon(event, pointerIndex);
    }

    public boolean isEye(MotionEvent event, Rect eyeRect) {
        if (event.getX() >= eyeRect.left) goto L5;
    L11:
        return false;
    L5:
        if (event.getX() > eyeRect.right) goto L11;
        if (event.getY() < eyeRect.top) goto L11;
        if (event.getY() > eyeRect.bottom) goto L11;
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Drawable r0 = getEyeDrawable();
        if (r0 == null) goto L14;
        if ((((int) event.getX()) + getScrollX()) < r0.getBounds().left) goto L14;
        if (event.getAction() != 1) goto L12;
        this.mEyeAnimator.setDirection();
        this.mEyeAnimator.start();
        if (this.mPendingSetInputType != null) goto L11;
        this.mPendingSetInputType = new AnonymousClass1(this);
    L11:
        postDelayed(this.mPendingSetInputType, this.mEyeAnimator.getAnimationDuration() / 2);
        onEyeIconClick();
        this.mTouchHelper.invalidateRoot();
    L12:
        return true;
    L14:
        return super.onTouchEvent(event);
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent event) {
        if (this.mTouchHelper.dispatchHoverEvent(event) == false) goto L7;
        return true;
    L7:
        return super.dispatchHoverEvent(event);
    }

    private void onEyeIconClick() {
        this.mTouchHelper.sendEventForVirtualView(0, 1);
    }
}
