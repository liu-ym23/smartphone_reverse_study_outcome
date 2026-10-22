package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OHorizontalScrollView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0001IB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J\b\u0010%\u001a\u00020\u001dH\u0002J\u0012\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010(\u001a\u00020\u000eJ\b\u0010)\u001a\u00020\u001dH\u0014J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,H\u0016J(\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bH\u0014J\u0010\u00102\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,H\u0016JP\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u000eH\u0014J\b\u0010=\u001a\u00020\u001dH\u0002J\b\u0010>\u001a\u00020\bH\u0002J\b\u0010?\u001a\u00020\u001dH\u0002J\u0012\u0010@\u001a\u00020\u001d2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020\u000eH\u0002J\u001e\u0010D\u001a\u0004\u0018\u00010\u00112\n\u0010E\u001a\u0006\u0012\u0002\b\u00030F2\u0006\u0010G\u001a\u00020HH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/obric/oui/bouncelayout/OHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "Lcom/obric/oui/bouncelayout/IBounceTranslationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bounceLeft", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "bounceRight", "bounceStoppedForTouch", "", "edgeEffectsInstalled", "edgeFieldLeft", "Ljava/lang/reflect/Field;", "edgeFieldRight", "edgeFieldsResolved", "originalLeftEffect", "Landroid/widget/EdgeEffect;", "originalRightEffect", "overscrollDelegate", "Lcom/obric/oui/bouncelayout/BounceOverscrollDelegate;", "scrollerField", "translationDelegate", "Lcom/obric/oui/bouncelayout/BounceTranslationDelegate;", "abortCurrentFling", "", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "getBounceTranslation", "", "getCurrentFlingVelocity", "initEdgeEffectReflection", "installBounceEdgeEffectsIfPossible", "isBounceEffectActive", "effect", "isOverScrolling", "onDetachedFromWindow", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "overScrollBy", "deltaX", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "releaseStoppedBounceIfNeeded", "resolveStoppedBounceReleaseEdge", "restoreOriginalEdgeEffects", "setOnBounceTranslationListener", "listener", "Lcom/obric/oui/bouncelayout/OnBounceTranslationListener;", "stopBounceIfNeeded", "tryGetField", "clazz", "Ljava/lang/Class;", "name", "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OHorizontalScrollView extends HorizontalScrollView implements IBounceTranslationView {
    private static final int BOUNCE_EDGE_NONE = -1;
    public static final Companion Companion = null;
    public static final String TAG = "OHorizontalScrollView";
    private BounceEdgeEffect bounceLeft;
    private BounceEdgeEffect bounceRight;
    private boolean bounceStoppedForTouch;
    private boolean edgeEffectsInstalled;
    private Field edgeFieldLeft;
    private Field edgeFieldRight;
    private boolean edgeFieldsResolved;
    private EdgeEffect originalLeftEffect;
    private EdgeEffect originalRightEffect;
    private final BounceOverscrollDelegate overscrollDelegate;
    private Field scrollerField;
    private final BounceTranslationDelegate translationDelegate;

    /* JADX INFO: compiled from: OHorizontalScrollView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/bouncelayout/OHorizontalScrollView$Companion;", "", "()V", "BOUNCE_EDGE_NONE", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public OHorizontalScrollView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OHorizontalScrollView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OHorizontalScrollView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceLeft$p(OHorizontalScrollView r0) {
        return r0.bounceLeft;
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceRight$p(OHorizontalScrollView r0) {
        return r0.bounceRight;
    }

    public OHorizontalScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.overscrollDelegate = new BounceOverscrollDelegate(new OHorizontalScrollView$overscrollDelegate$1(this), new OHorizontalScrollView$overscrollDelegate$2(this));
        this.translationDelegate = new BounceTranslationDelegate(new OHorizontalScrollView$translationDelegate$1(this), new OHorizontalScrollView$translationDelegate$2(this));
        setOverScrollMode(0);
        BounceEdgeEffect.Companion.bypassHiddenApi("Landroid/widget/HorizontalScrollView;");
        initEdgeEffectReflection();
        installBounceEdgeEffectsIfPossible();
    }

    @Override // com.obric.oui.bouncelayout.IBounceTranslationView
    public float getBounceTranslation() {
        BounceEdgeEffect r0 = this.bounceLeft;
        float r1 = 0.0f;
        if (r0 != null) goto L5;
        float r2 = 0.0f;
    L6:
        BounceEdgeEffect r3 = this.bounceRight;
        if (r3 == null) goto L11;
        r1 = r3.getTranslation();
    L11:
        return r2 + r1;
    L5:
        r2 = r0.getTranslation();
        goto L6
    }

    @Override // com.obric.oui.bouncelayout.IBounceTranslationView
    public void setOnBounceTranslationListener(OnBounceTranslationListener r1) {
        this.translationDelegate.setOnBounceTranslationListener(r1);
    }

    public final boolean isOverScrolling() {
        BounceEdgeEffect r0 = this.bounceLeft;
        if (r0 == null) goto L12;
        Intrinsics.checkNotNull(r0);
        if (r0.getDistance() != 0.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
        BounceEdgeEffect r2 = this.bounceLeft;
        Intrinsics.checkNotNull(r2);
        if (r2.isFinished() == true) goto L12;
    L11:
        boolean r3 = true;
    L13:
        BounceEdgeEffect r4 = this.bounceRight;
        if (r4 == null) goto L23;
        Intrinsics.checkNotNull(r4);
        if (r4.getDistance() != 0.0f) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L22;
        BounceEdgeEffect r6 = this.bounceRight;
        Intrinsics.checkNotNull(r6);
        if (r6.isFinished() == true) goto L23;
    L22:
        boolean r7 = true;
    L24:
        if (r3 == true) goto L29;
        if (r7 == false) goto L28;
        return true;
    L28:
        return false;
    L29:
        return true;
    L18:
        r5 = false;
    L23:
        r7 = false;
        goto L24
    L7:
        r1 = false;
    L12:
        r3 = false;
        goto L13
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        if (r2.getActionMasked() != 0) goto L6;
        this.bounceStoppedForTouch = stopBounceIfNeeded();
    L6:
        return super.onInterceptTouchEvent(r2);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        int r0 = r3.getActionMasked();
        boolean r1 = true;
        if (r0 == 0) goto L18;
        if (r0 != 1) goto L6;
    L8:
        BounceEdgeEffect r2 = this.bounceLeft;
        if (r2 == null) goto L12;
        r2.updateTouchDeltaX(0.0f);
    L12:
        BounceEdgeEffect r4 = this.bounceRight;
        if (r4 == null) goto L16;
        r4.updateTouchDeltaX(0.0f);
    L16:
        releaseStoppedBounceIfNeeded();
    L25:
        return super.onTouchEvent(r3);
    L6:
        if (r0 == 3) goto L8;
    L18:
        if (stopBounceIfNeeded() == false) goto L20;
    L23:
        this.bounceStoppedForTouch = r1;
        goto L25
    L20:
        if (this.bounceStoppedForTouch == true) goto L23;
        r1 = false;
        goto L23
    }

    @Override // android.view.View
    protected boolean overScrollBy(int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, boolean r14) {
        if (r14 == true) goto L4;
    L13:
        boolean r15 = super.overScrollBy(r6, r7, r8, r9, r10, r11, r12, r13, r14);
        if (r14 == false) goto L16;
    L64:
        return r15;
    L16:
        if (this.edgeEffectsInstalled == false) goto L64;
        if (r10 <= 0) goto L64;
        int r16 = r8 + r6;
        BounceDebugLogger r17 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L21;
        BounceDebugLogger.log(this, "overScrollFlingFrame", "scrollX=" + r8 + " deltaX=" + r6 + " finalScrollX=" + r16 + " range=" + r10);
    L21:
        boolean r18 = false;
        if (r16 > 0) goto L43;
        if (r6 >= 0) goto L43;
        BounceEdgeEffect r0 = this.bounceLeft;
        if (r0 != null) goto L28;
    L26:
        boolean r1 = false;
    L30:
        if (r1 == false) goto L43;
        float r2 = getCurrentFlingVelocity();
        int r3 = Math.abs(r16);
        BounceEdgeEffect r4 = this.bounceLeft;
        if (r4 == null) goto L35;
        r4.onPull(r3 / getWidth(), 0.5f);
    L35:
        BounceDebugLogger r5 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L38;
        BounceDebugLogger.log(this, "flingAbsorbLeft", "velocity=" + r2 + " overscroll=" + r3);
    L38:
        BounceEdgeEffect r19 = this.bounceLeft;
        if (r19 == null) goto L42;
        r19.onAbsorb((int) r2);
    L42:
        abortCurrentFling();
        goto L43
    L28:
        if (r0.isFinished() != true) goto L26;
        r1 = true;
    L43:
        if (r16 < r10) goto L64;
        if (r6 <= 0) goto L64;
        BounceEdgeEffect r20 = this.bounceRight;
        if (r20 != null) goto L49;
    L51:
        if (r18 == false) goto L64;
        float r21 = getCurrentFlingVelocity();
        int r22 = r16 - r10;
        BounceEdgeEffect r110 = this.bounceRight;
        if (r110 == null) goto L56;
        r110.onPull(r22 / getWidth(), 0.5f);
    L56:
        BounceDebugLogger r111 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L59;
        BounceDebugLogger.log(this, "flingAbsorbRight", "velocity=" + r21 + " overscroll=" + r22);
    L59:
        BounceEdgeEffect r23 = this.bounceRight;
        if (r23 == null) goto L63;
        r23.onAbsorb(-((int) r21));
    L63:
        abortCurrentFling();
        goto L64
    L49:
        if (r20.isFinished() != true) goto L51;
        r18 = true;
        goto L51
    L4:
        if (this.edgeEffectsInstalled == false) goto L13;
        float r24 = r6;
        BounceEdgeEffect r25 = this.bounceLeft;
        if (r25 == null) goto L9;
        r25.updateTouchDeltaX(r24);
    L9:
        BounceEdgeEffect r26 = this.bounceRight;
        if (r26 == null) goto L13;
        r26.updateTouchDeltaX(r24);
        goto L13
    }

    private final boolean stopBounceIfNeeded() {
        if (this.edgeEffectsInstalled == true) goto L5;
        return false;
    L5:
        BounceEdgeEffect r0 = this.bounceLeft;
        if (r0 != null) goto L8;
        float r1 = 0.0f;
    L10:
        if (r1 != 0.0f) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L25;
        BounceEdgeEffect r3 = this.bounceRight;
        if (r3 != null) goto L17;
        float r4 = 0.0f;
    L19:
        if (r4 != 0.0f) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == false) goto L25;
        boolean r6 = false;
    L26:
        BounceEdgeEffect r7 = this.bounceLeft;
        if (r7 != null) goto L30;
    L28:
        boolean r8 = false;
    L32:
        if (r8 == true) goto L42;
        BounceEdgeEffect r9 = this.bounceRight;
        if (r9 != null) goto L37;
    L35:
        boolean r10 = false;
    L39:
        if (r10 == true) goto L42;
        boolean r11 = false;
    L43:
        if (r6 == true) goto L47;
        if (r11 == true) goto L47;
        return false;
    L47:
        Field r12 = this.scrollerField;
        OverScroller r13 = null;
        if (r12 != null) goto L50;
        Object r14 = null;
    L52:
        if ((r14 instanceof OverScroller) == false) goto L54;
        r13 = (OverScroller) r14;
    L54:
        if (r13 == null) goto L57;
        r13.abortAnimation();
    L57:
        BounceEdgeEffect r15 = this.bounceLeft;
        if (r15 == null) goto L61;
        r15.stopAnimationForTouch();
    L61:
        BounceEdgeEffect r16 = this.bounceRight;
        if (r16 == null) goto L65;
        r16.stopAnimationForTouch();
    L65:
        invalidate();
        return true;
    L50:
        r14 = r12.get(this);
        goto L52
    L37:
        if (r9.isFinished() == true) goto L35;
        r10 = true;
    L42:
        r11 = true;
        goto L43
    L30:
        if (r7.isFinished() == true) goto L28;
        r8 = true;
        goto L32
    L21:
        r5 = false;
        goto L22
    L17:
        r4 = r3.getTranslation();
    L25:
        r6 = true;
        goto L26
    L12:
        r2 = false;
        goto L13
    L8:
        r1 = r0.getTranslation();
        goto L10
    }

    private final void releaseStoppedBounceIfNeeded() {
        if (this.bounceStoppedForTouch == true) goto L5;
        return;
    L5:
        int r0 = resolveStoppedBounceReleaseEdge();
        if (r0 != 2) goto L8;
        BounceEdgeEffect r1 = this.bounceLeft;
        if (r1 == null) goto L18;
        r1.onRelease();
    L18:
        this.bounceStoppedForTouch = false;
        invalidate();
        return;
    L8:
        if (r0 != 3) goto L18;
        BounceEdgeEffect r2 = this.bounceRight;
        if (r2 == null) goto L18;
        r2.onRelease();
        goto L18
    }

    private final int resolveStoppedBounceReleaseEdge() {
        boolean r0 = isBounceEffectActive(this.bounceLeft);
        boolean r1 = isBounceEffectActive(this.bounceRight);
        if (r0 == false) goto L7;
        if (r1 == true) goto L7;
        return 2;
    L7:
        if (r1 == false) goto L10;
        if (r0 == true) goto L10;
    L26:
        return 3;
    L10:
        BounceEdgeEffect r2 = this.bounceLeft;
        if (r2 != null) goto L13;
        float r3 = 0.0f;
    L15:
        if (r3 > 0.0f) goto L28;
        BounceEdgeEffect r4 = this.bounceRight;
        if (r4 != null) goto L20;
        float r5 = 0.0f;
    L22:
        if (r5 < 0.0f) goto L26;
        return -1;
    L20:
        r5 = r4.getTranslation();
        goto L22
    L28:
        return 2;
    L13:
        r3 = r2.getTranslation();
        goto L15
    }

    private final boolean isBounceEffectActive(BounceEdgeEffect r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.getDistance() != 0.0f) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L17;
        if (r4.getTranslation() != 0.0f) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L17;
        if (r4.isFinished() == false) goto L17;
        return false;
    L12:
        r1 = false;
    L17:
        return true;
    L7:
        r0 = false;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.edgeEffectsInstalled == true) goto L8;
        super.dispatchDraw(r4);
        return;
    L8:
        BounceEdgeEffect r0 = this.bounceLeft;
        if (r0 != null) goto L11;
        float r1 = 0.0f;
    L12:
        BounceEdgeEffect r2 = this.bounceRight;
        if (r2 != null) goto L15;
        float r3 = 0.0f;
    L16:
        float r5 = r1 + r3;
        if (r5 != 0.0f) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == true) goto L22;
        int r7 = r4.save();
        r4.translate(r5, 0.0f);
        super.dispatchDraw(r4);
        r4.restoreToCount(r7);
        return;
    L22:
        super.dispatchDraw(r4);
        return;
    L19:
        r6 = false;
        goto L20
    L15:
        r3 = r2.getTranslation();
        goto L16
    L11:
        r1 = r0.getTranslation();
        goto L12
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.overscrollDelegate.onSizeChanged();
        BounceEdgeEffect r5 = this.bounceLeft;
        if (r5 == null) goto L6;
        r5.setSize(r1, r2);
    L6:
        BounceEdgeEffect r0 = this.bounceRight;
        if (r0 == null) goto L11;
        r0.setSize(r1, r2);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BounceEdgeEffect r0 = this.bounceLeft;
        if (r0 == null) goto L6;
        r0.finish();
    L6:
        BounceEdgeEffect r1 = this.bounceRight;
        if (r1 == null) goto L10;
        r1.finish();
    L10:
        restoreOriginalEdgeEffects();
    }

    private final void initEdgeEffectReflection() {
        if (this.edgeFieldsResolved == false) goto L5;
        return;
    L5:
        this.edgeFieldsResolved = true;
        Field r1 = tryGetField(HorizontalScrollView.class, "mEdgeGlowLeft");     // Catch: Throwable -> L18
        if (r1 != null) goto L11;
        r1 = tryGetField(HorizontalScrollView.class, "mLeftGlow");     // Catch: Throwable -> L18
        if (r1 != null) goto L11;
        r1 = tryGetField(HorizontalScrollView.class, "mEdgeEffectLeft");     // Catch: Throwable -> L18
    L11:
        this.edgeFieldLeft = r1;     // Catch: Throwable -> L18
        Field r2 = tryGetField(HorizontalScrollView.class, "mEdgeGlowRight");     // Catch: Throwable -> L18
        if (r2 != null) goto L16;
        r2 = tryGetField(HorizontalScrollView.class, "mRightGlow");     // Catch: Throwable -> L18
        if (r2 != null) goto L16;
        r2 = tryGetField(HorizontalScrollView.class, "mEdgeEffectRight");     // Catch: Throwable -> L18
    L16:
        this.edgeFieldRight = r2;     // Catch: Throwable -> L18
        this.scrollerField = tryGetField(HorizontalScrollView.class, "mScroller");     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Log.w(TAG, "Failed to reflect fields", th);
        this.edgeFieldLeft = null;
        this.edgeFieldRight = null;
        this.scrollerField = null;
    }

    private final float getCurrentFlingVelocity() {
        Field r1 = this.scrollerField;     // Catch: Throwable -> L14
        OverScroller r2 = null;
        if (r1 != null) goto L6;
        Object r3 = null;
    L8:
        if ((r3 instanceof OverScroller) == false) goto L10;
        r2 = (OverScroller) r3;     // Catch: Throwable -> L14
    L10:
        if (r2 != null) goto L12;
        return 1000.0f;
    L12:
        return r2.getCurrVelocity();
    L6:
        r3 = r1.get(this);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Log.w(TAG, "Failed to get scroller velocity", th);
        return 1000.0f;
    }

    private final void abortCurrentFling() {
        Field r0 = this.scrollerField;     // Catch: Throwable -> L13
        OverScroller r1 = null;
        if (r0 != null) goto L5;
        Object r2 = null;
    L7:
        if ((r2 instanceof OverScroller) == false) goto L9;
        r1 = (OverScroller) r2;     // Catch: Throwable -> L13
    L9:
        if (r1 == null) goto L16;
        r1.abortAnimation();     // Catch: Throwable -> L13
        return;
    L16:
        return;
    L5:
        r2 = r0.get(this);     // Catch: Throwable -> L13
    }

    private final void installBounceEdgeEffectsIfPossible() {
        if (this.bounceLeft == null) goto L5;
        return;
    L5:
        if (this.bounceRight != null) goto L35;
        this.overscrollDelegate.onSizeChanged();
        Field r1 = this.edgeFieldLeft;
        if (r1 != null) goto L10;
        return;
    L10:
        Field r2 = this.edgeFieldRight;
        if (r2 != null) goto L32;
        return;
    L32:
        Object r4 = r1.get(this);     // Catch: Throwable -> L29
        if ((r4 instanceof EdgeEffect) == false) goto L17;
        EdgeEffect r5 = (EdgeEffect) r4;     // Catch: Throwable -> L29
    L18:
        this.originalLeftEffect = r5;     // Catch: Throwable -> L29
        Object r6 = r2.get(this);     // Catch: Throwable -> L29
        if ((r6 instanceof EdgeEffect) == false) goto L21;
        EdgeEffect r7 = (EdgeEffect) r6;     // Catch: Throwable -> L29
    L22:
        this.originalRightEffect = r7;     // Catch: Throwable -> L29
        Context r8 = getContext();     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r8, "context");     // Catch: Throwable -> L29
        BounceEdgeEffect r9 = new BounceEdgeEffect(r8, this, 2, this.overscrollDelegate.getMaxOverscrollPx());     // Catch: Throwable -> L29
        r9.setUseHeightForHorizontalSize(true);     // Catch: Throwable -> L29
        Context r10 = getContext();     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r10, "context");     // Catch: Throwable -> L29
        BounceEdgeEffect r11 = new BounceEdgeEffect(r10, this, 3, this.overscrollDelegate.getMaxOverscrollPx());     // Catch: Throwable -> L29
        r11.setUseHeightForHorizontalSize(true);     // Catch: Throwable -> L29
        if (getWidth() > 0) goto L25;
    L27:
        r1.set(this, r9);     // Catch: Throwable -> L29
        r2.set(this, r11);     // Catch: Throwable -> L29
        this.bounceLeft = r9;     // Catch: Throwable -> L29
        this.bounceRight = r11;     // Catch: Throwable -> L29
        this.edgeEffectsInstalled = true;     // Catch: Throwable -> L29
        this.overscrollDelegate.applyMaxToEffects();     // Catch: Throwable -> L29
        this.translationDelegate.updateBounceListeners();     // Catch: Throwable -> L29
        return;
    L25:
        if (getHeight() <= 0) goto L27;
        r9.setSize(getWidth(), getHeight());     // Catch: Throwable -> L29
        r11.setSize(getWidth(), getHeight());     // Catch: Throwable -> L29
        goto L27
    L21:
        r7 = null;
        goto L22
    L17:
        r5 = null;
    L29:
        th = move-exception;
        Log.w(TAG, "Failed to install BounceEdgeEffects, restoring original.", th);
        restoreOriginalEdgeEffects();
        this.bounceLeft = null;
        this.bounceRight = null;
        this.edgeEffectsInstalled = false;
        return;
    }

    private final void restoreOriginalEdgeEffects() {
        Field r0 = this.edgeFieldLeft;     // Catch: Throwable -> L11
        if (r0 == null) goto L6;
        r0.set(this, this.originalLeftEffect);     // Catch: Throwable -> L11
    L6:
        Field r1 = this.edgeFieldRight;     // Catch: Throwable -> L11
        if (r1 == null) goto L16;
        r1.set(this, this.originalRightEffect);     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L11:
        th = move-exception;
        Log.w(TAG, "Failed to restore original edge effects", th);
    }

    private final Field tryGetField(Class<?> r1, String r2) {
        Field r0 = r1.getDeclaredField(r2);     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L4:
        Field r3 = (Field) null;
        return null;
    }
}
