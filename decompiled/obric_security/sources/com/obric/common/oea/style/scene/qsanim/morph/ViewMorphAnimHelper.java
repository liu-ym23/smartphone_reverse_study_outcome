package com.obric.common.oea.style.scene.qsanim.morph;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import com.obric.common.oea.foundation.animation.engine.DynamicAnimation;
import com.obric.common.oea.foundation.animation.engine.FloatPropertyCompat;
import com.obric.common.oea.foundation.util.OEALogger;
import com.obric.common.oea.style.scene.qsanim.common.AnimViewParams;
import com.obric.common.oea.style.scene.qsanim.common.KtExt;
import com.obric.common.oea.style.scene.qsanim.common.SpringAnimUtils;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: ViewMorphAnimHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 N2\u00020\u0001:\u0001NB_\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\b\u00102\u001a\u00020\u001cH\u0002J4\u00103\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b042\u0006\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0005H\u0014J\u0006\u00109\u001a\u00020\u001cJ\b\u0010:\u001a\u00020\u001cH\u0002J\u0016\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0005J\u0006\u0010>\u001a\u00020\u001cJ\r\u0010?\u001a\u00020@H\u0000¢\u0006\u0002\bAJ\u0006\u0010B\u001a\u00020\u001cJ\b\u0010C\u001a\u00020\rH\u0002J\u0018\u0010D\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H\u0002J\u0006\u0010E\u001a\u00020\u001cJ\u0015\u0010F\u001a\u00020\u001c2\u0006\u0010G\u001a\u00020@H\u0000¢\u0006\u0002\bHJ\u0016\u0010I\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u0005J\u0016\u0010L\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0005J\b\u0010M\u001a\u00020\rH\u0002R\u0014\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000RW\u0010\u0015\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0011¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u001a\u0010$\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010'R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u00100RW\u00101\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0011¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/ViewMorphAnimHelper;", "", "view", "Landroid/view/View;", "morphFactorX", "", "morphFactorY", "leftMorphStartForce", "", "rightMorphStartForce", "upMorphStartForce", "downMorphStartForce", "invertYDirection", "", "invertXDirection", "(Landroid/view/View;FFIIIIZZ)V", "currentResetAnimH", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation;", "currentResetAnimW", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "heightUpdateListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "animation", "value", RealFpsTracer.SCROLL_VELOCITY, "", "initialDownPoint", "Landroid/graphics/PointF;", "initialViewX", "initialViewY", "getMorphFactorX", "()F", "getMorphFactorY", "originalHeight", "getOriginalHeight", "setOriginalHeight", "(F)V", "originalWidth", "getOriginalWidth", "setOriginalWidth", "pHeight", "Lcom/obric/common/oea/style/scene/qsanim/common/SpringAnimUtils$CommonFloatProperty;", "pWidth", "touchDownWhenAnimRunning", "getView", "()Landroid/view/View;", "widthUpdateListener", "animResetView", "calculateNewSize", "Lkotlin/Pair;", MaterialConfigFormatNames.X, MaterialConfigFormatNames.Y, "dx", "dy", "cancelAnim", "cancelResetAnim", "dragContinue", "forceX", "forceY", "dragEnd", "getOriginalViewParams", "Lcom/obric/common/oea/style/scene/qsanim/common/AnimViewParams;", "getOriginalViewParams$style_standardRelease", "init", "isAnimRunning", "performViewMorph", "release", "setOriginalViewParams", "viewParams", "setOriginalViewParams$style_standardRelease", "setOriginalViewSize", MaterialConfigFormatNames.WIDTH, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "startDrag", "updateViewSize", "Companion", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public class ViewMorphAnimHelper {
    public static final Companion Companion = null;
    private static final String TAG = "ViewMorphAnimHelper";
    private static int instanceNumber;
    private DynamicAnimation<?> currentResetAnimH;
    private DynamicAnimation<?> currentResetAnimW;
    private final int downMorphStartForce;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private final Function3<DynamicAnimation<?>, Float, Float, Unit> heightUpdateListener;
    private PointF initialDownPoint;
    private float initialViewX;
    private float initialViewY;
    private final boolean invertXDirection;
    private final boolean invertYDirection;
    private final int leftMorphStartForce;
    private final float morphFactorX;
    private final float morphFactorY;
    private float originalHeight;
    private float originalWidth;
    private SpringAnimUtils.CommonFloatProperty pHeight;
    private SpringAnimUtils.CommonFloatProperty pWidth;
    private final int rightMorphStartForce;
    private boolean touchDownWhenAnimRunning;
    private final int upMorphStartForce;
    private final View view;
    private final Function3<DynamicAnimation<?>, Float, Float, Unit> widthUpdateListener;

    /* JADX INFO: compiled from: ViewMorphAnimHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/ViewMorphAnimHelper$Companion;", "", "()V", "TAG", "", "instanceNumber", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ViewMorphAnimHelper(View r13) {
        this(r13, 0.0f, 0.0f, 0, 0, 0, 0, false, false, 510, null);
    }

    public ViewMorphAnimHelper(View r13, float r14) {
        this(r13, r14, 0.0f, 0, 0, 0, 0, false, false, 508, null);
    }

    public ViewMorphAnimHelper(View r13, float r14, float r15) {
        this(r13, r14, r15, 0, 0, 0, 0, false, false, 504, null);
    }

    public ViewMorphAnimHelper(View r13, float r14, float r15, int r16) {
        this(r13, r14, r15, r16, 0, 0, 0, false, false, 496, null);
    }

    public ViewMorphAnimHelper(View r13, float r14, float r15, int r16, int r17) {
        this(r13, r14, r15, r16, r17, 0, 0, false, false, 480, null);
    }

    public ViewMorphAnimHelper(View r13, float r14, float r15, int r16, int r17, int r18) {
        this(r13, r14, r15, r16, r17, r18, 0, false, false, 448, null);
    }

    public ViewMorphAnimHelper(View r13, float r14, float r15, int r16, int r17, int r18, int r19) {
        this(r13, r14, r15, r16, r17, r18, r19, false, false, 384, null);
    }

    public ViewMorphAnimHelper(View r13, float r14, float r15, int r16, int r17, int r18, int r19, boolean r20) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, false, 256, null);
    }

    public ViewMorphAnimHelper(View r2, float r3, float r4, int r5, int r6, int r7, int r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.view = r2;
        this.morphFactorX = r3;
        this.morphFactorY = r4;
        this.leftMorphStartForce = r5;
        this.rightMorphStartForce = r6;
        this.upMorphStartForce = r7;
        this.downMorphStartForce = r8;
        this.invertYDirection = r9;
        this.invertXDirection = r10;
        this.globalLayoutListener = new ViewMorphAnimHelper$globalLayoutListener$1(this);
        boolean r11 = false;
        float r12 = 0;
        if (r3 >= r12) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L29;
        if (r4 >= r12) goto L12;
    L14:
        boolean r14 = false;
    L15:
        if (r14 == false) goto L27;
        if (r3 != 0.0f) goto L19;
    L20:
        r11 = true;
    L21:
        if (r11 == false) goto L25;
        instanceNumber++;
        this.pWidth = new SpringAnimUtils.CommonFloatProperty(0.0f);
        this.pHeight = new SpringAnimUtils.CommonFloatProperty(0.0f);
        this.initialDownPoint = new PointF();
        this.widthUpdateListener = new ViewMorphAnimHelper$widthUpdateListener$1(this);
        this.heightUpdateListener = new ViewMorphAnimHelper$heightUpdateListener$1(this);
        return;
    L25:
        throw new IllegalArgumentException("morphFactorX and morphFactorY can't be both non-zero".toString());
    L19:
        if (r4 != 0.0f) goto L21;
    L27:
        throw new IllegalArgumentException("morphFactorY must be in the range [0, 1]".toString());
    L12:
        if (r3 > 1.0f) goto L14;
        r14 = true;
        goto L15
    L29:
        throw new IllegalArgumentException("morphFactorX must be in the range [0, 1]".toString());
    L5:
        if (r3 > 1.0f) goto L7;
        r13 = true;
        goto L8
    }

    public static final /* synthetic */ float access$getInitialViewX$p(ViewMorphAnimHelper r0) {
        return r0.initialViewX;
    }

    public static final /* synthetic */ float access$getInitialViewY$p(ViewMorphAnimHelper r0) {
        return r0.initialViewY;
    }

    public static final /* synthetic */ void access$setInitialViewX$p(ViewMorphAnimHelper r0, float r1) {
        r0.initialViewX = r1;
    }

    public static final /* synthetic */ void access$setInitialViewY$p(ViewMorphAnimHelper r0, float r1) {
        r0.initialViewY = r1;
    }

    public static final /* synthetic */ boolean access$updateViewSize(ViewMorphAnimHelper r0) {
        return r0.updateViewSize();
    }

    public final View getView() {
        return this.view;
    }

    public final float getMorphFactorX() {
        return this.morphFactorX;
    }

    public final float getMorphFactorY() {
        return this.morphFactorY;
    }

    public /* synthetic */ ViewMorphAnimHelper(View r10, float r11, float r12, int r13, int r14, int r15, int r16, boolean r17, boolean r18, int r19, DefaultConstructorMarker r20) {
        float r2 = 0.0f;
        if ((r19 & 2) == 0) goto L5;
        float r1 = 0.0f;
    L7:
        if ((r19 & 4) != 0) goto L10;
        r2 = r12;
    L10:
        int r4 = Integer.MAX_VALUE;
        if ((r19 & 8) == 0) goto L13;
        int r3 = Integer.MAX_VALUE;
    L15:
        if ((r19 & 16) == 0) goto L17;
        int r5 = Integer.MAX_VALUE;
    L19:
        if ((r19 & 32) == 0) goto L21;
        int r6 = Integer.MAX_VALUE;
    L23:
        if ((r19 & 64) != 0) goto L26;
        r4 = r16;
    L26:
        boolean r8 = false;
        if ((r19 & 128) == 0) goto L29;
        boolean r7 = false;
    L31:
        if ((r19 & 256) != 0) goto L34;
        r8 = r18;
    L34:
        this(r10, r1, r2, r3, r5, r6, r4, r7, r8);
        return;
    L29:
        r7 = r17;
        goto L31
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r3 = r13;
        goto L15
    L5:
        r1 = r11;
        goto L7
    }

    protected final float getOriginalWidth() {
        return this.originalWidth;
    }

    protected final void setOriginalWidth(float r1) {
        this.originalWidth = r1;
    }

    protected final float getOriginalHeight() {
        return this.originalHeight;
    }

    protected final void setOriginalHeight(float r1) {
        this.originalHeight = r1;
    }

    public final void init() {
        if (this.originalWidth != 0.0f) goto L5;
    L6:
        this.view.getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        OEALogger.INSTANCE.d(TAG, "init[" + instanceNumber + "], morphFactorX: " + this.morphFactorX + ", morphFactorY: " + this.morphFactorY + ", leftMorphStart: " + this.leftMorphStartForce + ", rightMorphStart: " + this.rightMorphStartForce + ", topMorphStart: " + this.upMorphStartForce + ", bottomMorphStart: " + this.downMorphStartForce);
        return;
    L5:
        if (this.originalHeight == 0.0f) goto L6;
    }

    public final void release() {
        this.view.getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
    }

    public final void cancelAnim() {
        cancelResetAnim();
    }

    private final void cancelResetAnim() {
        DynamicAnimation<?> r0 = this.currentResetAnimW;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        DynamicAnimation<?> r1 = this.currentResetAnimW;
        if (r1 == null) goto L11;
        Function3<DynamicAnimation<?>, Float, Float, Unit> r2 = this.widthUpdateListener;
        Object r3 = r2;
        if (r2 == null) goto L10;
        r3 = new ViewMorphAnimHelper$sam$com_obric_common_oea_foundation_animation_engine_DynamicAnimation_OnAnimationUpdateListener$0(r2);
    L10:
        r1.removeUpdateListener((DynamicAnimation.OnAnimationUpdateListener) r3);
    L11:
        DynamicAnimation<?> r4 = this.currentResetAnimH;
        if (r4 == null) goto L14;
        r4.cancel();
    L14:
        DynamicAnimation<?> r5 = this.currentResetAnimH;
        if (r5 == null) goto L20;
        Function3<DynamicAnimation<?>, Float, Float, Unit> r6 = this.heightUpdateListener;
        Object r7 = r6;
        if (r6 == null) goto L19;
        r7 = new ViewMorphAnimHelper$sam$com_obric_common_oea_foundation_animation_engine_DynamicAnimation_OnAnimationUpdateListener$0(r6);
    L19:
        r5.removeUpdateListener((DynamicAnimation.OnAnimationUpdateListener) r7);
    L20:
        SpringAnimUtils.INSTANCE.cancelSpring(this.pWidth, SpringAnimUtils.INSTANCE.getPROPERTY_FLOAT());
        SpringAnimUtils.INSTANCE.cancelSpring(this.pHeight, SpringAnimUtils.INSTANCE.getPROPERTY_FLOAT());
    }

    public final void startDrag(float r3, float r4) {
        if (isAnimRunning() == false) goto L5;
        this.touchDownWhenAnimRunning = true;
    L6:
        OEALogger.INSTANCE.d(TAG, "startDrag, x: " + r3 + ", y: " + r4);
        return;
    L5:
        this.initialDownPoint = new PointF(r3, r4);
        this.touchDownWhenAnimRunning = false;
        goto L6
    }

    public final void dragContinue(float r3, float r4) {
        if (isAnimRunning() == false) goto L5;
    L7:
        OEALogger.INSTANCE.d(TAG, "dragContinue, x: " + r3 + ", y: " + r4);
        return;
    L5:
        if (this.touchDownWhenAnimRunning == true) goto L7;
        performViewMorph(r3, r4);
        goto L7
    }

    public final void dragEnd() {
        if (isAnimRunning() == false) goto L5;
    L7:
        OEALogger.INSTANCE.d(TAG, "dragEnd");
        return;
    L5:
        if (this.touchDownWhenAnimRunning == true) goto L7;
        animResetView();
        goto L7
    }

    public final void setOriginalViewSize(float r4, float r5) {
        this.originalWidth = r4;
        this.originalHeight = r5;
        OEALogger.INSTANCE.d(TAG, "setOriginalViewSize, width: " + r4 + ", height: " + r5 + ", initialViewX: " + this.initialViewX + ", initialViewY: " + this.initialViewY);
    }

    public final AnimViewParams getOriginalViewParams$style_standardRelease() {
        return new AnimViewParams(this.originalWidth, this.originalHeight, this.initialViewX, this.initialViewY);
    }

    public final void setOriginalViewParams$style_standardRelease(AnimViewParams r7) {
        Intrinsics.checkNotNullParameter(r7, "viewParams");
        if (r7.getViewWidth() != 0.0f) goto L5;
    L7:
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "setOriginalViewParams, invalid viewParams: " + r7, null, 4, null);
        return;
    L5:
        if (r7.getViewHeight() == 0.0f) goto L7;
        this.originalWidth = r7.getViewWidth();
        this.originalHeight = r7.getViewHeight();
        this.initialViewX = r7.getViewX();
        this.initialViewY = r7.getViewY();
    }

    private final boolean updateViewSize() {
        float r0 = this.view.getWidth();
        float r1 = this.view.getHeight();
        if (r0 != 0.0f) goto L5;
    L8:
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "updateViewSize: width or height is zero", null, 4, null);
        return false;
    L5:
        if (r1 == 0.0f) goto L8;
        this.originalWidth = r0;
        this.originalHeight = r1;
        this.initialViewY = this.view.getY();
        this.initialViewX = this.view.getX();
        this.pWidth = new SpringAnimUtils.CommonFloatProperty(this.originalWidth);
        this.pHeight = new SpringAnimUtils.CommonFloatProperty(this.originalHeight);
        SpringAnimUtils.INSTANCE.clearAnimCache();
        OEALogger.INSTANCE.d(TAG, "instance: " + instanceNumber + ", updateViewSize, originalWidth: " + this.originalWidth + ", originalHeight: " + this.originalHeight + ", initialViewX: " + this.initialViewX + ", initialViewY: " + this.initialViewY);
        return true;
    }

    private final void performViewMorph(float r7, float r8) {
        if (this.morphFactorX == 0.0f) goto L5;
    L8:
        float r0 = r7 - this.initialDownPoint.x;
        int r3 = -1;
        if (this.invertXDirection == false) goto L11;
        int r2 = -1;
    L12:
        float r1 = r0 * r2;
        float r4 = r8 - this.initialDownPoint.y;
        if (this.invertYDirection == true) goto L16;
        r3 = 1;
    L16:
        float r5 = r4 * r3;
        Pair<Integer, Integer> r9 = calculateNewSize(r7, r8, r1, r5);
        if (r9.getSecond().intValue() != this.originalHeight) goto L21;
        if (r9.getFirst().intValue() != this.originalWidth) goto L21;
        return;
    L21:
        if (this.morphFactorX == 0.0f) goto L28;
        if (r1 >= 0) goto L25;
        float r10 = this.initialViewX - (r9.getFirst().floatValue() - this.originalWidth);
    L26:
        this.view.setX(r10);
        goto L28
    L25:
        r10 = this.initialViewX;
    L28:
        if (this.morphFactorY != 0.0f) goto L30;
    L34:
        ViewGroup.LayoutParams r11 = this.view.getLayoutParams();
        r11.width = r9.getFirst().intValue();
        r11.height = r9.getSecond().intValue();
        this.view.requestLayout();
        return;
    L30:
        if (r5 >= 0) goto L32;
        float r12 = this.initialViewY - (r9.getSecond().floatValue() - this.originalHeight);
    L33:
        this.view.setY(r12);
        goto L34
    L32:
        r12 = this.initialViewY;
        goto L33
    L11:
        r2 = 1;
        goto L12
    L5:
        if (this.morphFactorY != 0.0f) goto L8;
        OEALogger.INSTANCE.i(TAG, "performViewMorph: morphFactorX and morphFactorY are both zero, skip");
    }

    protected Pair<Integer, Integer> calculateNewSize(float r12, float r13, float r14, float r15) {
        float r0 = 0;
        if (r14 <= r0) goto L5;
        float r1 = RangesKt.coerceAtLeast(r12 - this.rightMorphStartForce, 0.0f);
    L6:
        float r4 = r1;
        if (r15 <= r0) goto L9;
        float r2 = RangesKt.coerceAtMost(r13 - this.downMorphStartForce, 0.0f);
    L11:
        if (this.morphFactorX == 0.0f) goto L14;
        OEALogger.INSTANCE.d(TAG, "calculateNewSize, x: " + r12 + ", dx: " + r14 + ", coercedDx: " + r4 + ", leftStart: " + this.leftMorphStartForce + ", rightStart: " + this.rightMorphStartForce);
    L14:
        if (this.morphFactorY == 0.0f) goto L16;
        OEALogger.INSTANCE.d(TAG, "calculateNewSize, y: " + r13 + ", dy: " + r15 + ", coercedDy: " + r2 + ", upStart: " + this.upMorphStartForce + ", downStart: " + this.downMorphStartForce);
    L16:
        float r16 = KtExt.dampedClamp$default(KtExt.INSTANCE, r4, this.originalWidth * this.morphFactorX, 0.0f, 4, null);
        float r17 = KtExt.dampedClamp$default(KtExt.INSTANCE, r2, this.originalHeight * this.morphFactorY, 0.0f, 4, null);
        float r18 = this.view.getWidth();
        float r19 = this.view.getHeight();
        float r3 = ((r18 * r17) * (-1.0f)) / r19;
        float r110 = ((r19 * r16) * (-1.0f)) / r18;
        return new Pair(Integer.valueOf(MathKt.roundToInt((this.originalWidth + r16) + r3)), Integer.valueOf(MathKt.roundToInt((this.originalHeight + r17) + r110)));
    L9:
        r2 = RangesKt.coerceAtLeast(r13 - this.upMorphStartForce, 0.0f);
        goto L11
    L5:
        r1 = RangesKt.coerceAtMost(r12 - this.leftMorphStartForce, 0.0f);
        goto L6
    }

    private final void animResetView() {
        float r0 = this.view.getWidth();
        float r1 = this.view.getHeight();
        OEALogger.INSTANCE.d(TAG, "animResetView, " + r0 + ", " + r1 + ", " + this.originalWidth + ", " + this.originalHeight);
        SpringAnimUtils r5 = SpringAnimUtils.INSTANCE;
        SpringAnimUtils.CommonFloatProperty r6 = this.pWidth;
        r6.setValue(r0);
        Unit r2 = Unit.INSTANCE;
        FloatPropertyCompat<SpringAnimUtils.CommonFloatProperty> r7 = SpringAnimUtils.INSTANCE.getPROPERTY_FLOAT();
        float r8 = this.originalWidth;
        Function3<DynamicAnimation<?>, Float, Float, Unit> r3 = this.widthUpdateListener;
        Object r4 = r3;
        if (r3 == null) goto L5;
        r4 = new ViewMorphAnimHelper$sam$com_obric_common_oea_foundation_animation_engine_DynamicAnimation_OnAnimationUpdateListener$0(r3);
    L5:
        this.currentResetAnimW = SpringAnimUtils.springTo$default(r5, r6, r7, r8, 0.0f, 0.0f, (DynamicAnimation.OnAnimationUpdateListener) r4, null, 44, null);
        SpringAnimUtils r9 = SpringAnimUtils.INSTANCE;
        SpringAnimUtils.CommonFloatProperty r10 = this.pHeight;
        r10.setValue(r1);
        Unit r11 = Unit.INSTANCE;
        FloatPropertyCompat<SpringAnimUtils.CommonFloatProperty> r12 = SpringAnimUtils.INSTANCE.getPROPERTY_FLOAT();
        float r13 = this.originalHeight;
        Function3<DynamicAnimation<?>, Float, Float, Unit> r14 = this.heightUpdateListener;
        Object r15 = r14;
        if (r14 == null) goto L8;
        r15 = new ViewMorphAnimHelper$sam$com_obric_common_oea_foundation_animation_engine_DynamicAnimation_OnAnimationUpdateListener$0(r14);
    L8:
        this.currentResetAnimH = SpringAnimUtils.springTo$default(r9, r10, r12, r13, 0.0f, 0.0f, (DynamicAnimation.OnAnimationUpdateListener) r15, null, 44, null);
    }

    private final boolean isAnimRunning() {
        DynamicAnimation<?> r0 = this.currentResetAnimH;
        if (r0 != null) goto L5;
    L6:
        DynamicAnimation<?> r2 = this.currentResetAnimW;
        if (r2 != null) goto L9;
    L11:
        return false;
    L9:
        if (r2.isRunning() != true) goto L11;
        return true;
    L5:
        if (r0.isRunning() != true) goto L6;
        return true;
    }
}
