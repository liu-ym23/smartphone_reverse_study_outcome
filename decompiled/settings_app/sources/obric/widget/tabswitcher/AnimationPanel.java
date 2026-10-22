package obric.widget.tabswitcher;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.android.settingslib.applications.RecentAppOpsAccess;
import java.util.ArrayList;
import obric.widget.tabswitcher.model.TabBrick;

/* JADX INFO: loaded from: classes5.dex */
public class AnimationPanel extends FrameLayout {
    private static final long DOWN_SCROLL_INTERVAL = 100;
    private PointF comingTabLoc;
    private boolean mAnimating;
    private AnimatorSet mAnimatorSet;
    private boolean mCanScroll;
    private final float mDrawableTopOffset;
    private int mDuration;
    private PickPutBehavior mEditableTabBarBehavior;
    private boolean mIsUp;
    private float mLastX;
    private float mLastY;
    private Paint mPaint;
    private PointF mPickIconLoc;
    private TabBrick mPickTab;
    private Pickable mPickable;
    private TabBrick mPutTab;
    private Putable mPutable;
    private int mStatusBarHeight;
    private PickPutBehavior mTabbarBehavoir;

    private class PickRunnable implements Runnable {
        final /* synthetic */ AnimationPanel this$0;
        private float x;
        private float y;

        public PickRunnable(final AnimationPanel this$0, float x, float y) {
            this.this$0 = this$0;
            this.x = x;
            this.y = y;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AnimationPanel.access$000(this.this$0) == true) goto L6;
            AnimationPanel.access$100(this.this$0, this.x, this.y);
            AnimationPanel.access$202(this.this$0, true);
            return;
        }
    }

    private void limitPosition(PointF pointF) {
    }

    static /* synthetic */ boolean access$000(AnimationPanel r0) {
        return r0.mIsUp;
    }

    static /* synthetic */ void access$100(AnimationPanel r0, float r1, float r2) {
        r0.pickIfNeeded(r1, r2);
    }

    static /* synthetic */ boolean access$202(AnimationPanel r0, boolean r1) {
        r0.mCanScroll = r1;
        return r1;
    }

    static /* synthetic */ boolean access$302(AnimationPanel r0, boolean r1) {
        r0.mAnimating = r1;
        return r1;
    }

    static /* synthetic */ Putable access$400(AnimationPanel r0) {
        return r0.mPutable;
    }

    static /* synthetic */ TabBrick access$500(AnimationPanel r0) {
        return r0.mPutTab;
    }

    static /* synthetic */ Pickable access$600(AnimationPanel r0) {
        return r0.mPickable;
    }

    static /* synthetic */ TabBrick access$700(AnimationPanel r0) {
        return r0.mPickTab;
    }

    static /* synthetic */ void access$800(AnimationPanel r0) {
        r0.deselect();
    }

    public AnimationPanel(Context context, PickPutBehavior editableTabBarBehavior, PickPutBehavior tabbarBehavoir, float drawableTopOffset) {
        super(context);
        this.mDuration = 400;
        this.mCanScroll = false;
        setBackgroundColor(0);
        this.mEditableTabBarBehavior = editableTabBarBehavior;
        this.mTabbarBehavoir = tabbarBehavoir;
        this.mPaint = new Paint();
        this.mDrawableTopOffset = drawableTopOffset;
        this.mStatusBarHeight = getStatusBarHeight(context);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent e) {
        if (this.mAnimating == false) goto L5;
        return true;
    L5:
        int r0 = e.getAction();
        if (r0 == 0) goto L27;
        if (r0 == 1) goto L19;
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L19;
    L28:
        this.mLastX = e.getX();
        this.mLastY = e.getY();
        return true;
    L14:
        if (this.mPickable == null) goto L28;
        if (this.mCanScroll == false) goto L28;
        float r1 = e.getX() - this.mLastX;
        float r2 = e.getY() - this.mLastY;
        this.mPickIconLoc.x += r1;
        this.mPickIconLoc.y += r2;
        invalidate();
    L19:
        if (this.mPickable != null) goto L21;
    L26:
        this.mCanScroll = false;
        this.mIsUp = true;
        goto L28
    L21:
        if (this.mCanScroll == false) goto L26;
        findPut(e);
        if (this.mPutable == null) goto L25;
        doPut();
        goto L26
    L25:
        cancel();
        goto L26
    L27:
        this.mIsUp = false;
        postDelayed(new PickRunnable(this, e.getRawX(), e.getRawY()), 100);
        goto L28
    }

    private void pickIfNeeded(float x, float y) {
        if (this.mPickable == null) goto L5;
        return;
    L5:
        if (this.mEditableTabBarBehavior.peek(x, y) == null) goto L8;
        this.mPickable = this.mEditableTabBarBehavior;
    L10:
        Pickable r0 = this.mPickable;
        if (r0 == null) goto L15;
        TabBrick r2 = r0.pick(x, y);
        this.mPickTab = r2;
        this.mPickIconLoc = getPickOrPutPoint(r2);
        invalidate();
        return;
    L15:
        return;
    L8:
        if (this.mTabbarBehavoir.peek(x, y) == null) goto L10;
        this.mPickable = this.mTabbarBehavoir;
        goto L10
    }

    private void findPut(MotionEvent e) {
        TabBrick r0 = this.mEditableTabBarBehavior.peek(e.getRawX(), e.getRawY());
        if (r0 != null) goto L5;
    L7:
        TabBrick r1 = this.mTabbarBehavoir.peek(e.getRawX(), e.getRawY());
        if (r1 != null) goto L10;
    L12:
        Putable r2 = this.mPutable;
        if (r2 == null) goto L16;
        TabBrick r4 = r2.peek(e.getRawX(), e.getRawY());
        this.mPutTab = r4;
        this.comingTabLoc = getPickOrPutPoint(r4);
        return;
    L16:
        return;
    L10:
        if (r1.getRect().contains(this.mPickTab.getRect()) == true) goto L12;
        this.mPutable = this.mTabbarBehavoir;
        goto L12
    L5:
        if (r0.getRect().contains(this.mPickTab.getRect()) == true) goto L7;
        this.mPutable = this.mEditableTabBarBehavior;
        goto L12
    }

    public void endAnimationPanelAnimation() {
        AnimatorSet r0 = this.mAnimatorSet;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() == false) goto L9;
        this.mAnimatorSet.end();
        return;
    }

    private void doPut() {
        if (this.mPutable == null) goto L6;
        this.mAnimatorSet = new AnimatorSet();
        ArrayList r0 = new ArrayList();
        PointF r1 = getPickOrPutPoint(this.mPutTab);
        PointF r2 = this.mPickIconLoc;
        r0.add(translate(r2, r1, r2));
        PointF r3 = getPickOrPutPoint(this.mPickTab);
        PointF r4 = this.comingTabLoc;
        r0.add(translate(r4, r3, r4));
        this.mAnimatorSet.playTogether(r0);
        this.mAnimatorSet.addListener(new AnonymousClass1(this));
        this.mAnimatorSet.start();
        return;
    }

    private void cancel() {
        PointF r0 = getPickOrPutPoint(this.mPickTab);
        PointF r1 = this.mPickIconLoc;
        Animator r2 = translate(r1, r0, r1);
        r2.addListener(new AnonymousClass2(this));
        r2.start();
    }

    private PointF getPickOrPutPoint(TabBrick tabBrick) {
        if (tabBrick == null) goto L4;
        float r0 = tabBrick.getRect().left;
        float r2 = (tabBrick.getRect().top - getTop()) - this.mStatusBarHeight;
    L6:
        return new PointF(r0, r2);
    L4:
        r0 = 0.0f;
        r2 = 0.0f;
        goto L6
    }

    private void deselect() {
        this.mPickable = null;
        this.mPutable = null;
        this.mPickTab = null;
        this.mPutTab = null;
    }

    private Animator translate(PointF start, PointF end, final PointF target) {
        ValueAnimator r4 = ValueAnimator.ofObject(new AnonymousClass3(this), new Object[]{start, end});
        r4.setDuration(this.mDuration);
        r4.addUpdateListener(new AnonymousClass4(this, target));
        return r4;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        TabBrick r0 = this.mPutTab;
        if (r0 == null) goto L6;
        canvas.drawBitmap(r0.getDrawable(), this.comingTabLoc.x + this.mPutTab.getDrawableOffsetX(), this.comingTabLoc.y + this.mDrawableTopOffset, this.mPaint);
    L6:
        if (this.mPickTab == null) goto L9;
        limitPosition(this.mPickIconLoc);
        canvas.drawBitmap(this.mPickTab.getDrawable(), this.mPickIconLoc.x + this.mPickTab.getDrawableOffsetX(), this.mPickIconLoc.y + this.mDrawableTopOffset, this.mPaint);
        return;
    }

    boolean isAnimating() {
        return this.mAnimating;
    }

    public static int getStatusBarHeight(Context context) {
        int r0 = context.getResources().getIdentifier("status_bar_height", "dimen", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        if (r0 > 0) goto L7;
        return 0;
    L7:
        return context.getResources().getDimensionPixelSize(r0);
    }
}
