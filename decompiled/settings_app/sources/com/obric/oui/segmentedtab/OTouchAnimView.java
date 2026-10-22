package com.obric.oui.segmentedtab;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OTouchAnimView.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b \u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH&J\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\u000fJ\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/segmentedtab/OTouchAnimView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animValue", "", "pressAnimator", "Landroid/animation/ValueAnimator;", "releaseAnimator", "canPerFormAnim", "", "cancelAnim", "", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isAnimRunning", "onTouchAnimUpdate", "animFraction", "scene", "", "startPressAnim", "startReleaseAnim", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OTouchAnimView extends RelativeLayout {
    private static final float ALPHA_ON_PRESS = 0.5f;
    public static final Companion Companion = null;
    public static final String PRESS_ANIM_SCENE_PRESS = "press_anim";
    public static final String PRESS_ANIM_SCENE_RELEASE = "release_anim";
    private static final String TAG = "TouchAnimView";
    private float animValue;
    private ValueAnimator pressAnimator;
    private ValueAnimator releaseAnimator;

    /* JADX INFO: compiled from: OTouchAnimView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/segmentedtab/OTouchAnimView$Companion;", "", "()V", "ALPHA_ON_PRESS", "", "PRESS_ANIM_SCENE_PRESS", "", "PRESS_ANIM_SCENE_RELEASE", "TAG", "getAnimatedPressAlpha", "fraction", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final float getAnimatedPressAlpha(float r2) {
            return 1 - (r2 * 0.5f);
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$PNiUo8-07B5qQtvN6pvYCoSdr6E, reason: not valid java name */
    public static /* synthetic */ void m1367$r8$lambda$PNiUo807B5qQtvN6pvYCoSdr6E(OTouchAnimView r0, ValueAnimator r1) {
        m1369startPressAnim$lambda1$lambda0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$k8QmJAWrZCKikXEQ-xzP8XjuMLU, reason: not valid java name */
    public static /* synthetic */ void m1368$r8$lambda$k8QmJAWrZCKikXEQxzP8XjuMLU(OTouchAnimView r0, ValueAnimator r1) {
        m1370startReleaseAnim$lambda4$lambda3(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public OTouchAnimView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OTouchAnimView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public abstract boolean canPerFormAnim();

    public abstract void onTouchAnimUpdate(float r1, String r2);

    public /* synthetic */ OTouchAnimView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OTouchAnimView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        int r0 = r3.getAction();
        if (r0 != 0) goto L5;
        startPressAnim();
    L12:
        return super.dispatchTouchEvent(r3);
    L5:
        if (r0 != 1) goto L7;
    L9:
        startReleaseAnim();
        goto L12
    L7:
        if (r0 == 3) goto L9;
        goto L9
    }

    private final void startPressAnim() {
        if (canPerFormAnim() == true) goto L5;
        return;
    L5:
        ValueAnimator r0 = this.releaseAnimator;
        if (r0 == null) goto L9;
        r0.removeAllUpdateListeners();
    L9:
        ValueAnimator r1 = this.releaseAnimator;
        if (r1 == null) goto L13;
        r1.cancel();
    L13:
        ValueAnimator r2 = this.pressAnimator;
        if (r2 == null) goto L17;
        r2.cancel();
    L17:
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{this.animValue, 1.0f});
        r3.setDuration(50);
        r3.setInterpolator(new DecelerateInterpolator());
        r3.addUpdateListener(new OTouchAnimView$$ExternalSyntheticLambda1(this));
        r3.start();
        this.pressAnimator = r3;
    }

    /* JADX INFO: renamed from: startPressAnim$lambda-1$lambda-0, reason: not valid java name */
    private static final void m1369startPressAnim$lambda1$lambda0(OTouchAnimView r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "animator");
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        float r4 = ((Float) r3).floatValue();
        r1.animValue = r4;
        r1.onTouchAnimUpdate(r4, PRESS_ANIM_SCENE_PRESS);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    private final void startReleaseAnim() {
        if (canPerFormAnim() == true) goto L5;
        return;
    L5:
        ValueAnimator r0 = this.pressAnimator;
        if (r0 == null) goto L9;
        r0.removeAllUpdateListeners();
    L9:
        ValueAnimator r1 = this.pressAnimator;
        if (r1 == null) goto L13;
        r1.cancel();
    L13:
        ValueAnimator r2 = this.releaseAnimator;
        if (r2 == null) goto L17;
        r2.cancel();
    L17:
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{this.animValue, 0.0f});
        r3.setDuration(200);
        r3.setInterpolator(new DecelerateInterpolator());
        r3.addUpdateListener(new OTouchAnimView$$ExternalSyntheticLambda0(this));
        r3.start();
        this.releaseAnimator = r3;
    }

    /* JADX INFO: renamed from: startReleaseAnim$lambda-4$lambda-3, reason: not valid java name */
    private static final void m1370startReleaseAnim$lambda4$lambda3(OTouchAnimView r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "animator");
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        float r4 = ((Float) r3).floatValue();
        r1.animValue = r4;
        r1.onTouchAnimUpdate(r4, PRESS_ANIM_SCENE_RELEASE);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    public final boolean isAnimRunning() {
        ValueAnimator r0 = this.pressAnimator;
        if (r0 != null) goto L6;
    L4:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L17;
        ValueAnimator r3 = this.releaseAnimator;
        if (r3 != null) goto L13;
    L11:
        boolean r4 = false;
    L15:
        if (r4 == true) goto L17;
        return false;
    L13:
        if (r3.isRunning() != true) goto L11;
        r4 = true;
    L17:
        return true;
    L6:
        if (r0.isRunning() != true) goto L4;
        r1 = true;
        goto L8
    }

    public final void cancelAnim() {
        ValueAnimator r0 = this.pressAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        ValueAnimator r1 = this.releaseAnimator;
        if (r1 == null) goto L11;
        r1.cancel();
        return;
    }
}
