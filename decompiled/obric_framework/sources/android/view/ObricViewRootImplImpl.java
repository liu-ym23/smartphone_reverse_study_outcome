package android.view;

import android.animation.ValueAnimator;
import android.app.clickviewtree.ClickViewTraceContext;
import android.graphics.Insets;
import android.os.Message;
import android.util.Log;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.ImeTracker;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ObricViewRootImplImpl implements IObricViewRootImpl {
    private static final Set<String> IME_ANIMATION_WHITELIST = null;
    private static final long IME_ANIM_DURATION_MS = 285;
    private static final Interpolator IME_ANIM_INTERPOLATOR = null;
    private static final String TAG = "AutoImeAnim";
    private final ViewRootImpl mBase;
    private ValueAnimator mPendingImeAnim;

    /* JADX INFO: renamed from: android.view.ObricViewRootImplImpl$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ObricViewRootImplImpl this$0;
        final /* synthetic */ WindowInsetsAnimation val$anim;
        final /* synthetic */ WindowInsetsAnimation.Bounds val$bounds;
        final /* synthetic */ int val$endBottom;
        final /* synthetic */ View val$root;
        final /* synthetic */ boolean val$show;
        final /* synthetic */ int val$startBottom;

        AnonymousClass1(ObricViewRootImplImpl this$0, View r2, WindowInsetsAnimation r3, WindowInsetsAnimation.Bounds r4, int r5, int r6, boolean r7) {
            this.this$0 = this$0;
            this.val$root = r2;
            this.val$anim = r3;
            this.val$bounds = r4;
            this.val$startBottom = r5;
            this.val$endBottom = r6;
            this.val$show = r7;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ObricViewRootImplImpl.m46$$Nest$fgetmBase(this.this$0).mView == this.val$root) goto L6;
            Log.w(ObricViewRootImplImpl.TAG, "startSimulatedImeAnimation: mView changed, abort");
            ObricInsetsStateImpl.clearAnimatingImeBottom();
            return;
        L6:
            Log.d(ObricViewRootImplImpl.TAG, "startSimulatedImeAnimation: dispatchStart");
            this.val$root.dispatchWindowInsetsAnimationStart(this.val$anim, this.val$bounds);
            ValueAnimator va = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            va.setDuration(ObricViewRootImplImpl.IME_ANIM_DURATION_MS);
            final WindowInsetsAnimation r1 = this.val$anim;
            final int r2 = this.val$startBottom;
            final int r3 = this.val$endBottom;
            final View r4 = this.val$root;
            va.addUpdateListener(new ObricViewRootImplImpl$1$$ExternalSyntheticLambda0(r1, r2, r3, r4));
            va.addListener(new C00001(this));
            ObricViewRootImplImpl.m48$$Nest$fputmPendingImeAnim(this.this$0, va);
            va.start();
        }

        static /* synthetic */ void lambda$run$0(WindowInsetsAnimation anim, int startBottom, int endBottom, View root, ValueAnimator animation) {
            float frac = animation.getAnimatedFraction();
            anim.setFraction(frac);
            float ip = anim.getInterpolatedFraction();
            int curBottom = (int) (startBottom + ((endBottom - startBottom) * ip));
            ObricInsetsStateImpl.setAnimatingImeBottom(curBottom);
            WindowInsets cur = new WindowInsets.Builder().setInsets(WindowInsets.Type.ime(), Insets.of(0, 0, 0, curBottom)).setVisible(WindowInsets.Type.ime(), true).build();
            root.dispatchWindowInsetsAnimationProgress(cur, Collections.singletonList(anim));
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBase, reason: not valid java name */
    static /* bridge */ /* synthetic */ ViewRootImpl m46$$Nest$fgetmBase(ObricViewRootImplImpl r0) {
        return r0.mBase;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingImeAnim, reason: not valid java name */
    static /* bridge */ /* synthetic */ ValueAnimator m47$$Nest$fgetmPendingImeAnim(ObricViewRootImplImpl r0) {
        return r0.mPendingImeAnim;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPendingImeAnim, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m48$$Nest$fputmPendingImeAnim(ObricViewRootImplImpl r0, ValueAnimator r1) {
        r0.mPendingImeAnim = r1;
    }

    static {
        IME_ANIMATION_WHITELIST = Set.of("com.bytedance.dreamina");
        IME_ANIM_INTERPOLATOR = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    }

    public ObricViewRootImplImpl(ViewRootImpl base) {
        this.mBase = base;
    }

    public void updateAutoInsetsChanged(ImeTracker.Token statsToken, Message msg, boolean show) {
        if (statsToken != null) goto L4;
        return;
    L4:
        if (this.mBase.mDisplay != null) goto L6;
        return;
    L6:
        if (this.mBase.mDisplay.getObricExt().isObricVirtualDisplay() == false) goto L31;
        int types = msg.arg1;
        if ((WindowInsets.Type.ime() & types) != 0) goto L12;
        return;
    L12:
        if ("AUTO_IME_TAG".equals(statsToken.getTag()) == true) goto L15;
        return;
    L15:
        if (this.mBase.mContext == null) goto L17;
        String pkg = this.mBase.mContext.getPackageName();
    L18:
        if (pkg != null) goto L20;
    L22:
        boolean inWhitelist = false;
    L23:
        Log.d(TAG, "updateAutoInsetsChanged: show=" + show + ", pkg=" + pkg + ", inWhitelist=" + inWhitelist);
        if (inWhitelist == true) goto L27;
        this.mBase.notifyInsetsChanged();
        return;
    L27:
        startSimulatedImeAnimation(show);
        return;
    L20:
        if (IME_ANIMATION_WHITELIST.contains(pkg) == false) goto L22;
        inWhitelist = true;
        goto L23
    L17:
        pkg = null;
        goto L18
    }

    private void startSimulatedImeAnimation(boolean show) {
        View root = this.mBase.mView;
        if (root != null) goto L7;
        Log.w(TAG, "startSimulatedImeAnimation: mView is null, fallback to notifyInsetsChanged");
        ObricInsetsStateImpl.clearAnimatingImeBottom();
        this.mBase.notifyInsetsChanged();
        return;
    L7:
        if (this.mPendingImeAnim == null) goto L10;
        Log.d(TAG, "startSimulatedImeAnimation: cancel pending anim");
        this.mPendingImeAnim.cancel();
        this.mPendingImeAnim = null;
    L10:
        if (show == false) goto L12;
        int startBottom = 0;
    L13:
        if (show == false) goto L15;
        int endBottom = 58;
    L16:
        WindowInsetsAnimation anim = new WindowInsetsAnimation(WindowInsets.Type.ime(), IME_ANIM_INTERPOLATOR, IME_ANIM_DURATION_MS);
        WindowInsetsAnimation.Bounds bounds = new WindowInsetsAnimation.Bounds(Insets.NONE, Insets.of(0, 0, 0, 58));
        ObricInsetsStateImpl.setAnimatingImeBottom(startBottom);
        Log.d(TAG, "startSimulatedImeAnimation: dispatchPrepare, show=" + show + ", startBottom=" + startBottom + ", endBottom=" + endBottom);
        root.dispatchWindowInsetsAnimationPrepare(anim);
        this.mBase.notifyInsetsChanged();
        root.post(new AnonymousClass1(this, root, anim, bounds, startBottom, endBottom, show));
        return;
    L15:
        endBottom = 0;
        goto L16
    L12:
        startBottom = 58;
        goto L13
    }

    public void startInput() {
        this.mBase.mHandler.post(new AnonymousClass2(this));
    }

    public void onMovedToDisplay() {
        if (this.mBase.mDisplay.getObricExt().isObricVirtualDisplay() == false) goto L6;
        this.mBase.getInsetsController().setRequestedVisibleTypes(0, WindowInsets.Type.ime());
        return;
    }

    public void beginPointerEvent(MotionEvent event, View root) {
    L8:
        t = move-exception;
        Log.w(TAG, "beginPointerEvent: click viewtree trace failed", t);
        return;
    L3:
        if (this.mBase.mDisplay != null) goto L5;
        int r0 = -1;
    L6:
        ClickViewTraceContext.beginTrace(event, root, r0);     // Catch: Throwable -> L8
        return;
    L5:
        r0 = this.mBase.mDisplay.getDisplayId();     // Catch: Throwable -> L8
        goto L6
    }

    public void finishPointerEvent(MotionEvent event, boolean handled) {
        ClickViewTraceContext.endTrace(event, handled);     // Catch: Throwable -> L4
        return;
    L4:
        t = move-exception;
        Log.w(TAG, "finishPointerEvent: click viewtree trace failed", t);
    }
}
