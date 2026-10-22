package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import android.widget.ScrollView;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OScrollView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 Y2\u00020\u00012\u00020\u0002:\u0001YB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020\u0017H\u0016J\b\u0010*\u001a\u00020\u0017H\u0002J\b\u0010+\u001a\u00020\bH\u0002J\u0010\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020%H\u0002J\b\u00100\u001a\u00020%H\u0002J\u0012\u00101\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u00103\u001a\u00020\rJ\b\u00104\u001a\u00020%H\u0014J\u0010\u00105\u001a\u00020\r2\u0006\u0010-\u001a\u00020.H\u0016J(\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\bH\u0014J\u0010\u0010;\u001a\u00020\r2\u0006\u0010-\u001a\u00020.H\u0016JP\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\rH\u0014J\u0010\u0010F\u001a\u00020%2\u0006\u0010>\u001a\u00020\u0017H\u0002J\b\u0010G\u001a\u00020%H\u0002J\b\u0010H\u001a\u00020%H\u0002J\b\u0010I\u001a\u00020\bH\u0002J\b\u0010J\u001a\u00020%H\u0002J\u0012\u0010K\u001a\u00020%2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010N\u001a\u00020\rH\u0002J\u0010\u0010O\u001a\u00020\r2\u0006\u0010P\u001a\u00020\u0017H\u0002J\b\u0010Q\u001a\u00020\rH\u0002J\u001e\u0010R\u001a\u0004\u0018\u00010\u00112\n\u0010S\u001a\u0006\u0012\u0002\b\u00030T2\u0006\u0010U\u001a\u00020VH\u0002J\u0018\u0010W\u001a\u00020%2\u0006\u0010X\u001a\u00020\b2\u0006\u0010-\u001a\u00020.H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/obric/oui/bouncelayout/OScrollView;", "Landroid/widget/ScrollView;", "Lcom/obric/oui/bouncelayout/IBounceTranslationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bounceBottom", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "bounceStoppedForTouch", "", "bounceTop", "edgeEffectsInstalled", "edgeFieldBottom", "Ljava/lang/reflect/Field;", "edgeFieldTop", "edgeFieldsResolved", "manualBounceActiveEdge", "manualBounceActivePointerId", "manualBounceDownY", "", "manualBounceDragging", "manualBounceLastY", "manualBounceTouchActive", "originalBottomEffect", "Landroid/widget/EdgeEffect;", "originalTopEffect", "overscrollDelegate", "Lcom/obric/oui/bouncelayout/BounceOverscrollDelegate;", "scrollerField", "touchSlop", "translationDelegate", "Lcom/obric/oui/bouncelayout/BounceTranslationDelegate;", "abortCurrentFling", "", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "getBounceTranslation", "getCurrentFlingVelocity", "getScrollRangeY", "handleManualBouncePointerUp", "ev", "Landroid/view/MotionEvent;", "initEdgeEffectReflection", "installBounceEdgeEffectsIfPossible", "isBounceEffectActive", "effect", "isOverScrolling", "onDetachedFromWindow", "onInterceptTouchEvent", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "overScrollBy", "deltaX", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "pullManualBounce", "releaseManualBounce", "releaseStoppedBounceIfNeeded", "resolveManualBounceReleaseEdge", "restoreOriginalEdgeEffects", "setOnBounceTranslationListener", "listener", "Lcom/obric/oui/bouncelayout/OnBounceTranslationListener;", "shouldHandleManualBounce", "shouldStartManualBounce", "totalDeltaY", "stopBounceIfNeeded", "tryGetField", "clazz", "Ljava/lang/Class;", "name", "", "updateManualBounceActivePointer", "pointerIndex", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OScrollView extends ScrollView implements IBounceTranslationView {
    public static final Companion Companion = null;
    private static final int INVALID_POINTER_ID = -1;
    private static final int MANUAL_BOUNCE_BOTTOM = 2;
    private static final int MANUAL_BOUNCE_NONE = 0;
    private static final int MANUAL_BOUNCE_TOP = 1;
    public static final String TAG = "OScrollView";
    private BounceEdgeEffect bounceBottom;
    private boolean bounceStoppedForTouch;
    private BounceEdgeEffect bounceTop;
    private boolean edgeEffectsInstalled;
    private Field edgeFieldBottom;
    private Field edgeFieldTop;
    private boolean edgeFieldsResolved;
    private int manualBounceActiveEdge;
    private int manualBounceActivePointerId;
    private float manualBounceDownY;
    private boolean manualBounceDragging;
    private float manualBounceLastY;
    private boolean manualBounceTouchActive;
    private EdgeEffect originalBottomEffect;
    private EdgeEffect originalTopEffect;
    private final BounceOverscrollDelegate overscrollDelegate;
    private Field scrollerField;
    private final int touchSlop;
    private final BounceTranslationDelegate translationDelegate;

    /* JADX INFO: compiled from: OScrollView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/bouncelayout/OScrollView$Companion;", "", "()V", "INVALID_POINTER_ID", "", "MANUAL_BOUNCE_BOTTOM", "MANUAL_BOUNCE_NONE", "MANUAL_BOUNCE_TOP", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public OScrollView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OScrollView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OScrollView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceBottom$p(OScrollView r0) {
        return r0.bounceBottom;
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceTop$p(OScrollView r0) {
        return r0.bounceTop;
    }

    public OScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.touchSlop = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.manualBounceActivePointerId = -1;
        this.overscrollDelegate = new BounceOverscrollDelegate(new OScrollView$overscrollDelegate$1(this), new OScrollView$overscrollDelegate$2(this));
        this.translationDelegate = new BounceTranslationDelegate(new OScrollView$translationDelegate$1(this), new OScrollView$translationDelegate$2(this));
        setOverScrollMode(0);
        BounceEdgeEffect.Companion.bypassHiddenApi("Landroid/widget/ScrollView;");
        initEdgeEffectReflection();
        installBounceEdgeEffectsIfPossible();
    }

    @Override // com.obric.oui.bouncelayout.IBounceTranslationView
    public float getBounceTranslation() {
        BounceEdgeEffect r0 = this.bounceTop;
        float r1 = 0.0f;
        if (r0 != null) goto L5;
        float r2 = 0.0f;
    L6:
        BounceEdgeEffect r3 = this.bounceBottom;
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
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 == null) goto L12;
        Intrinsics.checkNotNull(r0);
        if (r0.getDistance() != 0.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
        BounceEdgeEffect r2 = this.bounceTop;
        Intrinsics.checkNotNull(r2);
        if (r2.isFinished() == true) goto L12;
    L11:
        boolean r3 = true;
    L13:
        BounceEdgeEffect r4 = this.bounceBottom;
        if (r4 == null) goto L23;
        Intrinsics.checkNotNull(r4);
        if (r4.getDistance() != 0.0f) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L22;
        BounceEdgeEffect r6 = this.bounceBottom;
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

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.overscrollDelegate.onSizeChanged();
        BounceEdgeEffect r5 = this.bounceTop;
        if (r5 == null) goto L6;
        r5.setSize(r1, r2);
    L6:
        BounceEdgeEffect r0 = this.bounceBottom;
        if (r0 == null) goto L11;
        r0.setSize(r1, r2);
        return;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        int r0 = r5.getActionMasked();
        if (r0 != 0) goto L5;
        this.bounceStoppedForTouch = stopBounceIfNeeded();
        this.manualBounceTouchActive = false;
        this.manualBounceDragging = false;
        this.manualBounceActiveEdge = 0;
        this.manualBounceActivePointerId = r5.getPointerId(0);
        float r1 = r5.getY(0);
        this.manualBounceDownY = r1;
        this.manualBounceLastY = r1;
    L38:
        return super.onInterceptTouchEvent(r5);
    L5:
        if (r0 != 1) goto L7;
    L35:
        this.manualBounceTouchActive = false;
        this.manualBounceDragging = false;
        this.manualBounceActiveEdge = 0;
        this.manualBounceActivePointerId = -1;
        releaseStoppedBounceIfNeeded();
        goto L38
    L7:
        if (r0 == 2) goto L24;
        if (r0 == 3) goto L35;
        if (r0 == 5) goto L20;
        if (r0 != 6) goto L38;
        if (this.manualBounceTouchActive == false) goto L38;
        handleManualBouncePointerUp(r5);
        return true;
    L20:
        if (this.manualBounceTouchActive == false) goto L38;
        updateManualBounceActivePointer(r5.getActionIndex(), r5);
        return true;
    L24:
        if (shouldHandleManualBounce() == false) goto L38;
        int r2 = r5.findPointerIndex(this.manualBounceActivePointerId);
        if (r2 >= 0) goto L29;
        return false;
    L29:
        if (shouldStartManualBounce(r5.getY(r2) - this.manualBounceDownY) == false) goto L38;
        this.manualBounceTouchActive = true;
        this.manualBounceDragging = true;
        this.bounceStoppedForTouch = false;
        this.manualBounceLastY = this.manualBounceDownY;
        ViewParent r4 = getParent();
        if (r4 == null) goto L34;
        r4.requestDisallowInterceptTouchEvent(true);
    L34:
        return true;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        int r0 = r5.getActionMasked();
        boolean r1 = false;
        boolean r2 = true;
        if (r0 == 0) goto L43;
        if (r0 == 1) goto L38;
        if (r0 == 2) goto L23;
        if (r0 == 3) goto L38;
        if (r0 == 5) goto L19;
        if (r0 != 6) goto L50;
        if (this.manualBounceTouchActive == false) goto L50;
        handleManualBouncePointerUp(r5);
        return true;
    L50:
        return super.onTouchEvent(r5);
    L19:
        if (this.manualBounceTouchActive == false) goto L50;
        updateManualBounceActivePointer(r5.getActionIndex(), r5);
        return true;
    L23:
        if (this.manualBounceTouchActive == false) goto L50;
        int r3 = r5.findPointerIndex(this.manualBounceActivePointerId);
        if (r3 >= 0) goto L28;
        releaseManualBounce();
        return true;
    L28:
        float r6 = r5.getY(r3);
        float r4 = r6 - this.manualBounceLastY;
        if (this.manualBounceDragging == true) goto L31;
    L35:
        this.manualBounceLastY = r6;
        return true;
    L31:
        if (r4 != 0.0f) goto L33;
        r1 = true;
    L33:
        if (r1 == true) goto L35;
        pullManualBounce(r4);
    L38:
        if (this.manualBounceTouchActive == false) goto L41;
        releaseManualBounce();
        return true;
    L41:
        releaseStoppedBounceIfNeeded();
        goto L50
    L43:
        if (stopBounceIfNeeded() == false) goto L45;
    L48:
        this.bounceStoppedForTouch = r2;
        this.manualBounceTouchActive = false;
        this.manualBounceDragging = false;
        this.manualBounceActiveEdge = 0;
        this.manualBounceActivePointerId = r5.getPointerId(0);
        float r7 = r5.getY(0);
        this.manualBounceDownY = r7;
        this.manualBounceLastY = r7;
        goto L50
    L45:
        if (this.bounceStoppedForTouch == true) goto L48;
        r2 = false;
        goto L48
    }

    private final void updateManualBounceActivePointer(int r2, MotionEvent r3) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 >= r3.getPointerCount()) goto L9;
        this.manualBounceActivePointerId = r3.getPointerId(r2);
        this.manualBounceLastY = r3.getY(r2);
        return;
    }

    private final void handleManualBouncePointerUp(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 < r4.getPointerCount()) goto L8;
        return;
    L8:
        if (r4.getPointerId(r0) == this.manualBounceActivePointerId) goto L10;
        return;
    L10:
        if (r0 != 0) goto L12;
        int r1 = 1;
    L14:
        if (r1 >= r4.getPointerCount()) goto L16;
        updateManualBounceActivePointer(r1, r4);
        return;
    L16:
        this.manualBounceActivePointerId = -1;
        return;
    L12:
        r1 = 0;
        goto L14
    }

    @Override // android.view.View
    protected boolean overScrollBy(int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, boolean r14) {
        boolean r15 = super.overScrollBy(r6, r7, r8, r9, r10, r11, r12, r13, r14);
        if (r14 == false) goto L5;
    L57:
        return r15;
    L5:
        if (this.edgeEffectsInstalled == false) goto L57;
        if (r11 <= 0) goto L57;
        int r16 = r9 + r7;
        BounceDebugLogger r17 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L10;
        BounceDebugLogger.log(this, "overScrollFlingFrame", "scrollY=" + r9 + " deltaY=" + r7 + " finalScrollY=" + r16 + " range=" + r11);
    L10:
        boolean r18 = false;
        if (r16 > 0) goto L34;
        if (r7 >= 0) goto L34;
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 != null) goto L17;
    L15:
        boolean r1 = false;
    L19:
        if (r1 == false) goto L34;
        float r2 = getCurrentFlingVelocity();
        int r3 = Math.abs(r16);
        if (getHeight() <= 0) goto L26;
        BounceEdgeEffect r4 = this.bounceTop;
        if (r4 == null) goto L26;
        r4.onPull(r3 / getHeight(), 0.5f);
    L26:
        BounceDebugLogger r5 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L29;
        BounceDebugLogger.log(this, "flingAbsorbTop", "velocity=" + r2 + " overscroll=" + r3);
    L29:
        BounceEdgeEffect r19 = this.bounceTop;
        if (r19 == null) goto L33;
        r19.onAbsorb((int) r2);
    L33:
        abortCurrentFling();
        goto L34
    L17:
        if (r0.isFinished() != true) goto L15;
        r1 = true;
    L34:
        if (r16 < r11) goto L57;
        if (r7 <= 0) goto L57;
        BounceEdgeEffect r20 = this.bounceBottom;
        if (r20 != null) goto L40;
    L42:
        if (r18 == false) goto L57;
        float r21 = getCurrentFlingVelocity();
        int r22 = r16 - r11;
        if (getHeight() <= 0) goto L49;
        BounceEdgeEffect r110 = this.bounceBottom;
        if (r110 == null) goto L49;
        r110.onPull(r22 / getHeight(), 0.5f);
    L49:
        BounceDebugLogger r23 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L52;
        BounceDebugLogger.log(this, "flingAbsorbBottom", "velocity=" + r21 + " overscroll=" + r22);
    L52:
        BounceEdgeEffect r24 = this.bounceBottom;
        if (r24 == null) goto L56;
        r24.onAbsorb(-((int) r21));
    L56:
        abortCurrentFling();
        goto L57
    L40:
        if (r20.isFinished() != true) goto L42;
        r18 = true;
        goto L42
    }

    private final boolean shouldHandleManualBounce() {
        if (this.edgeEffectsInstalled == true) goto L5;
        return false;
    L5:
        if (getHeight() > 0) goto L8;
        return false;
    L8:
        if (getScrollRangeY() > 0) goto L11;
        return true;
    L11:
        if (isBounceEffectActive(this.bounceTop) == true) goto L15;
        if (isBounceEffectActive(this.bounceBottom) == true) goto L15;
        return false;
    L15:
        return true;
    }

    private final boolean shouldStartManualBounce(float r4) {
        if (Math.abs(r4) > this.touchSlop) goto L6;
        return false;
    L6:
        if (isBounceEffectActive(this.bounceTop) == false) goto L8;
    L19:
        return true;
    L8:
        if (isBounceEffectActive(this.bounceBottom) == true) goto L19;
        if (r4 <= 0.0f) goto L16;
        if (canScrollVertically(-1) == false) goto L18;
        return false;
    L18:
        return true;
    L16:
        if (canScrollVertically(1) == false) goto L18;
        return false;
    }

    private final void pullManualBounce(float r7) {
        if (getHeight() > 0) goto L5;
        return;
    L5:
        float r0 = r7 / getHeight();
        boolean r1 = isBounceEffectActive(this.bounceTop);
        boolean r2 = isBounceEffectActive(this.bounceBottom);
        if (r1 == false) goto L12;
        this.manualBounceActiveEdge = 1;
        BounceEdgeEffect r8 = this.bounceTop;
        if (r8 == null) goto L29;
        r8.onPull(r0, 0.5f);
    L29:
        invalidate();
        return;
    L12:
        if (r2 == false) goto L18;
        this.manualBounceActiveEdge = 2;
        BounceEdgeEffect r9 = this.bounceBottom;
        if (r9 == null) goto L29;
        r9.onPull(-r0, 0.5f);
        goto L29
    L18:
        if (r7 <= 0.0f) goto L24;
        this.manualBounceActiveEdge = 1;
        BounceEdgeEffect r10 = this.bounceTop;
        if (r10 == null) goto L29;
        r10.onPull(r0, 0.5f);
        goto L29
    L24:
        if (r7 >= 0.0f) goto L29;
        this.manualBounceActiveEdge = 2;
        BounceEdgeEffect r11 = this.bounceBottom;
        if (r11 == null) goto L29;
        r11.onPull(-r0, 0.5f);
        goto L29
    }

    private final void releaseManualBounce() {
        this.manualBounceTouchActive = false;
        this.manualBounceDragging = false;
        this.manualBounceActivePointerId = -1;
        this.bounceStoppedForTouch = false;
        BounceDebugLogger r1 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L5;
        BounceDebugLogger.log(this, "manualBounceRelease", "translation=" + getBounceTranslation() + " range=" + getScrollRangeY() + " activeEdge=" + this.manualBounceActiveEdge);
    L5:
        int r2 = resolveManualBounceReleaseEdge();
        if (r2 != 1) goto L8;
        BounceEdgeEffect r3 = this.bounceTop;
        if (r3 == null) goto L18;
        r3.onRelease();
    L18:
        this.manualBounceActiveEdge = 0;
        invalidate();
        return;
    L8:
        if (r2 != 2) goto L18;
        BounceEdgeEffect r4 = this.bounceBottom;
        if (r4 == null) goto L18;
        r4.onRelease();
        goto L18
    }

    private final void releaseStoppedBounceIfNeeded() {
        if (this.bounceStoppedForTouch == true) goto L5;
        return;
    L5:
        int r0 = resolveManualBounceReleaseEdge();
        if (r0 != 1) goto L8;
        BounceEdgeEffect r1 = this.bounceTop;
        if (r1 == null) goto L18;
        r1.onRelease();
    L18:
        this.bounceStoppedForTouch = false;
        invalidate();
        return;
    L8:
        if (r0 != 2) goto L18;
        BounceEdgeEffect r2 = this.bounceBottom;
        if (r2 == null) goto L18;
        r2.onRelease();
        goto L18
    }

    private final int resolveManualBounceReleaseEdge() {
        int r0 = this.manualBounceActiveEdge;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        boolean r1 = isBounceEffectActive(this.bounceTop);
        boolean r2 = isBounceEffectActive(this.bounceBottom);
        if (r1 == false) goto L10;
        if (r2 == true) goto L10;
        return 1;
    L10:
        if (r2 == false) goto L13;
        if (r1 == true) goto L13;
    L29:
        return 2;
    L13:
        BounceEdgeEffect r3 = this.bounceTop;
        if (r3 != null) goto L16;
        float r4 = 0.0f;
    L18:
        if (r4 > 0.0f) goto L31;
        BounceEdgeEffect r5 = this.bounceBottom;
        if (r5 != null) goto L23;
        float r6 = 0.0f;
    L25:
        if (r6 < 0.0f) goto L29;
        return 0;
    L23:
        r6 = r5.getTranslation();
        goto L25
    L31:
        return 1;
    L16:
        r4 = r3.getTranslation();
        goto L18
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

    private final boolean stopBounceIfNeeded() {
        if (this.edgeEffectsInstalled == true) goto L5;
        return false;
    L5:
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 != null) goto L8;
        float r1 = 0.0f;
    L10:
        if (r1 != 0.0f) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L25;
        BounceEdgeEffect r3 = this.bounceBottom;
        if (r3 != null) goto L17;
        float r4 = 0.0f;
    L19:
        if (r4 != 0.0f) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == false) goto L25;
        boolean r6 = false;
    L26:
        BounceEdgeEffect r7 = this.bounceTop;
        if (r7 != null) goto L30;
    L28:
        boolean r8 = false;
    L32:
        if (r8 == true) goto L42;
        BounceEdgeEffect r9 = this.bounceBottom;
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
        abortCurrentFling();
        BounceEdgeEffect r12 = this.bounceTop;
        if (r12 == null) goto L51;
        r12.stopAnimationForTouch();
    L51:
        BounceEdgeEffect r13 = this.bounceBottom;
        if (r13 == null) goto L55;
        r13.stopAnimationForTouch();
    L55:
        invalidate();
        return true;
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

    private final int getScrollRangeY() {
        View r1 = getChildAt(0);
        if (r1 != null) goto L5;
        return 0;
    L5:
        int r2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        return Math.max(0, r1.getHeight() - r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r4) {
        if (r4 != null) goto L5;
        super.dispatchDraw(r4);
        return;
    L5:
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 != null) goto L8;
        float r1 = 0.0f;
    L9:
        BounceEdgeEffect r2 = this.bounceBottom;
        if (r2 != null) goto L12;
        float r3 = 0.0f;
    L13:
        float r5 = r1 + r3;
        if (r5 != 0.0f) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == true) goto L19;
        int r7 = r4.save();
        r4.translate(0.0f, r5);
        super.dispatchDraw(r4);
        r4.restoreToCount(r7);
        return;
    L19:
        super.dispatchDraw(r4);
        return;
    L16:
        r6 = false;
        goto L17
    L12:
        r3 = r2.getTranslation();
        goto L13
    L8:
        r1 = r0.getTranslation();
        goto L9
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 == null) goto L6;
        r0.finish();
    L6:
        BounceEdgeEffect r1 = this.bounceBottom;
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
        Field r1 = tryGetField(ScrollView.class, "mEdgeGlowTop");     // Catch: Throwable -> L14
        if (r1 != null) goto L9;
        r1 = tryGetField(ScrollView.class, "mTopGlow");     // Catch: Throwable -> L14
    L9:
        this.edgeFieldTop = r1;     // Catch: Throwable -> L14
        Field r2 = tryGetField(ScrollView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L14
        if (r2 != null) goto L12;
        r2 = tryGetField(ScrollView.class, "mBottomGlow");     // Catch: Throwable -> L14
    L12:
        this.edgeFieldBottom = r2;     // Catch: Throwable -> L14
        this.scrollerField = tryGetField(ScrollView.class, "mScroller");     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Log.w(TAG, "Failed to reflect edge effect fields", th);
        this.edgeFieldTop = null;
        this.edgeFieldBottom = null;
        this.scrollerField = null;
    }

    private final void installBounceEdgeEffectsIfPossible() {
        if (this.bounceTop == null) goto L5;
        return;
    L5:
        if (this.bounceBottom != null) goto L35;
        this.overscrollDelegate.onSizeChanged();
        Field r1 = this.edgeFieldTop;
        if (r1 != null) goto L10;
        return;
    L10:
        Field r2 = this.edgeFieldBottom;
        if (r2 != null) goto L32;
        return;
    L32:
        Object r5 = r1.get(this);     // Catch: Throwable -> L29
        if ((r5 instanceof EdgeEffect) == false) goto L17;
        EdgeEffect r6 = (EdgeEffect) r5;     // Catch: Throwable -> L29
    L18:
        this.originalTopEffect = r6;     // Catch: Throwable -> L29
        Object r7 = r2.get(this);     // Catch: Throwable -> L29
        if ((r7 instanceof EdgeEffect) == false) goto L21;
        EdgeEffect r8 = (EdgeEffect) r7;     // Catch: Throwable -> L29
    L22:
        this.originalBottomEffect = r8;     // Catch: Throwable -> L29
        Context r9 = getContext();     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r9, "context");     // Catch: Throwable -> L29
        BounceEdgeEffect r10 = new BounceEdgeEffect(r9, this, 0, this.overscrollDelegate.getMaxOverscrollPx());     // Catch: Throwable -> L29
        Context r11 = getContext();     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r11, "context");     // Catch: Throwable -> L29
        BounceEdgeEffect r12 = new BounceEdgeEffect(r11, this, 1, this.overscrollDelegate.getMaxOverscrollPx());     // Catch: Throwable -> L29
        if (getWidth() > 0) goto L25;
    L27:
        r1.set(this, r10);     // Catch: Throwable -> L29
        r2.set(this, r12);     // Catch: Throwable -> L29
        this.bounceTop = r10;     // Catch: Throwable -> L29
        this.bounceBottom = r12;     // Catch: Throwable -> L29
        this.edgeEffectsInstalled = true;     // Catch: Throwable -> L29
        this.overscrollDelegate.applyMaxToEffects();     // Catch: Throwable -> L29
        this.translationDelegate.updateBounceListeners();     // Catch: Throwable -> L29
        return;
    L25:
        if (getHeight() <= 0) goto L27;
        r10.setSize(getWidth(), getHeight());     // Catch: Throwable -> L29
        r12.setSize(getWidth(), getHeight());     // Catch: Throwable -> L29
        goto L27
    L21:
        r8 = null;
        goto L22
    L17:
        r6 = null;
    L29:
        th = move-exception;
        Log.w(TAG, "Failed to install BounceEdgeEffects, restoring original.", th);
        restoreOriginalEdgeEffects();
        this.bounceTop = null;
        this.bounceBottom = null;
        this.edgeEffectsInstalled = false;
        return;
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

    private final void restoreOriginalEdgeEffects() {
        Field r0 = this.edgeFieldTop;     // Catch: Throwable -> L11
        if (r0 == null) goto L6;
        r0.set(this, this.originalTopEffect);     // Catch: Throwable -> L11
    L6:
        Field r1 = this.edgeFieldBottom;     // Catch: Throwable -> L11
        if (r1 == null) goto L16;
        r1.set(this, this.originalBottomEffect);     // Catch: Throwable -> L11
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
        th = move-exception;
        Log.w(TAG, "Failed to reflect edge effect fields", th);
        Field r3 = (Field) null;
        return null;
    }
}
