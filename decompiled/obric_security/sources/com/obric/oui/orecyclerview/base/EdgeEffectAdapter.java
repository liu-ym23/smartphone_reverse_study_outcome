package com.obric.oui.orecyclerview.base;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.search.data.SearchConfigType;

/* JADX INFO: compiled from: EdgeEffectAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 %2\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012J\u001e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020\u001bJ\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u0012J\f\u0010$\u001a\u00020\t*\u00020\tH\u0002J\f\u0010#\u001a\u00020\t*\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/oui/orecyclerview/base/EdgeEffectAdapter;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "animationElapsedTime", "", "animationStartTime", "currentDistance", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "<set-?>", "", "isFinished", "()Z", SearchConfigType.KEY_MODE, "", "pullDistanceSign", "springBack", "Lcom/obric/oui/orecyclerview/base/FluidSpringBack;", "totalPullDistance", "viewportRange", "computeScrollOffset", "getDistance", "onAbsorb", "", RealFpsTracer.SCROLL_VELOCITY, "onPullDistance", "deltaDistance", "forReleasing", "fromAnim", "onRelease", "updateViewportRange", "px", "dp", "Companion", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EdgeEffectAdapter {
    public static final Companion Companion = null;
    private static final int MODE_IDLE = 0;
    private static final int MODE_PULLING = 1;
    private static final int MODE_SPRING_BACK = 2;
    private long animationElapsedTime;
    private long animationStartTime;
    private final Context context;
    private float currentDistance;
    private final DisplayMetrics displayMetrics;
    private boolean isFinished;
    private int mode;
    private float pullDistanceSign;
    private FluidSpringBack springBack;
    private float totalPullDistance;
    private float viewportRange;

    /* JADX INFO: compiled from: EdgeEffectAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/orecyclerview/base/EdgeEffectAdapter$Companion;", "", "()V", "MODE_IDLE", "", "MODE_PULLING", "MODE_SPRING_BACK", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public EdgeEffectAdapter(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.context = r3;
        this.animationStartTime = -1;
        this.animationElapsedTime = -1;
        this.springBack = new FluidSpringBack();
        this.isFinished = true;
        this.displayMetrics = r3.getResources().getDisplayMetrics();
    }

    public final boolean isFinished() {
        return this.isFinished;
    }

    public final float getDistance() {
        return this.currentDistance;
    }

    public final void onAbsorb(int r3) {
        float r4 = dp(r3 / 1000.0f);
        this.animationStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.springBack.absorb(r4, 0.0f);
        this.mode = 2;
        this.isFinished = false;
    }

    public final float onPullDistance(float r8, boolean r9, boolean r10) {
        boolean r1 = false;
        if (Math.signum(r8) != Math.signum(this.currentDistance)) goto L5;
        boolean r0 = true;
    L7:
        if (r0 != r9) goto L59;
        if (r10 == true) goto L59;
        float r11 = dp(r8);
        if (this.mode == 1) goto L21;
        float r4 = FluidRubberBand.Companion.distance(Math.abs(dp(this.currentDistance)), this.viewportRange) * (-Math.signum(this.currentDistance));
        this.totalPullDistance = r4;
        if (r4 != 0.0f) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L18;
        float r6 = Math.signum(r11);
    L19:
        this.pullDistanceSign = r6;
    L26:
        float r7 = this.totalPullDistance;
        float r12 = r11 + r7;
        this.totalPullDistance = r12;
        float r13 = Math.signum(r12);
        float r14 = this.pullDistanceSign;
        if (r13 != r14) goto L29;
        boolean r15 = true;
    L30:
        if (r15 == true) goto L40;
        if (r14 != 0.0f) goto L34;
        boolean r16 = true;
    L35:
        if (r16 == true) goto L40;
        if (r9 == false) goto L38;
        this.totalPullDistance = 0.0f;
        this.pullDistanceSign = 0.0f;
        r12 = 0.0f;
    L45:
        this.currentDistance = px((-FluidRubberBand.Companion.offset(Math.abs(r12), this.viewportRange)) * Math.signum(r12));
        this.mode = 1;
        this.isFinished = false;
        if (r0 == false) goto L58;
        if (r12 != 0.0f) goto L50;
        boolean r17 = true;
    L51:
        if (r17 == true) goto L53;
        return r8;
    L53:
        if (r7 != 0.0f) goto L55;
        r1 = true;
    L55:
        if (r1 == false) goto L62;
        return r8;
    L62:
        return -px(r7);
    L50:
        r17 = false;
        goto L51
    L58:
        return 0.0f;
    L38:
        this.pullDistanceSign = Math.signum(r12);
        goto L45
    L34:
        r16 = false;
    L40:
        if (this.totalPullDistance != 0.0f) goto L42;
        boolean r18 = true;
    L43:
        if (r18 == false) goto L45;
        this.pullDistanceSign = 0.0f;
        goto L45
    L42:
        r18 = false;
        goto L43
    L29:
        r15 = false;
        goto L30
    L18:
        r6 = Math.signum(r4);
        goto L19
    L15:
        r5 = false;
        goto L16
    L21:
        if (this.pullDistanceSign != 0.0f) goto L23;
        boolean r19 = true;
    L24:
        if (r19 == false) goto L26;
        this.pullDistanceSign = Math.signum(r11);
        goto L26
    L23:
        r19 = false;
    L59:
        return 0.0f;
    L5:
        r0 = false;
        goto L7
    }

    public final void onRelease() {
        float r0 = dp(this.currentDistance);
        this.animationStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.springBack.absorb((-r0) / 100.0f, r0);
        this.mode = 2;
        this.isFinished = false;
    }

    public final boolean computeScrollOffset() {
        if (this.animationStartTime != (-1)) goto L6;
        return false;
    L6:
        if (this.mode != 1) goto L8;
        return true;
    L8:
        long r3 = AnimationUtils.currentAnimationTimeMillis() - this.animationStartTime;
        this.animationElapsedTime = r3;
        FluidSpringBack.SpringBackValue r0 = this.springBack.value(r3);
        this.currentDistance = px(r0.getValue());
        boolean r1 = r0.isFinished();
        this.isFinished = r1;
        if (r1 == false) goto L12;
        this.mode = 0;
    L12:
        return !r1;
    }

    public final void updateViewportRange(int r1) {
        this.viewportRange = dp(r1);
    }

    private final float px(float r2) {
        return TypedValue.applyDimension(1, r2, this.displayMetrics);
    }

    private final float dp(float r1) {
        return r1 / this.displayMetrics.density;
    }
}
