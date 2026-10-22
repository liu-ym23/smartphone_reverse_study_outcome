package com.obric.common.oea.style.scene.qsanim.morph;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.obric.common.oea.foundation.util.OEALogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SeekBarMorphParentLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b&\u0018\u0000 +2\u00020\u0001:\u0001+B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0017J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\nH&J\b\u0010#\u001a\u00020!H&J\u0010\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u001fH&J8\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00182\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010(\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0005J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\nH&R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/SeekBarMorphParentLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "forceFactor", "", "invertDirection", "", "lastForce", "lastProgress", "lastTouchPoint", "Landroid/graphics/PointF;", "getLastTouchPoint", "()Landroid/graphics/PointF;", "setLastTouchPoint", "(Landroid/graphics/PointF;)V", "maxProgress", "minProgress", "seekBarChild", "Landroid/widget/SeekBar;", "getSeekBarChild", "()Landroid/widget/SeekBar;", "setSeekBarChild", "(Landroid/widget/SeekBar;)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "dragContinue", "", "force", "dragEnd", "getDeltaMove", "motionEvent", "init", "seekBar", "morphFactor", "startDrag", "initForce", "Companion", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SeekBarMorphParentLayout extends FrameLayout {
    public static final Companion Companion = null;
    private static final float FORCE_FACTOR_DEF = 0.2f;
    private static final float FORCE_FACTOR_MAX = 0.3f;
    private static final float FORCE_FACTOR_MIN = 0.1f;
    public static final String TAG = "MorphSeekBarParentLayout";
    private float forceFactor;
    private boolean invertDirection;
    private float lastForce;
    private float lastProgress;
    private PointF lastTouchPoint;
    private int maxProgress;
    private int minProgress;
    protected SeekBar seekBarChild;

    /* JADX INFO: compiled from: SeekBarMorphParentLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/SeekBarMorphParentLayout$Companion;", "", "()V", "FORCE_FACTOR_DEF", "", "FORCE_FACTOR_MAX", "FORCE_FACTOR_MIN", "TAG", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
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

    public SeekBarMorphParentLayout(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public SeekBarMorphParentLayout(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public abstract void dragContinue(float r1);

    public abstract void dragEnd();

    public abstract float getDeltaMove(MotionEvent r1);

    public abstract void startDrag(float r1);

    public /* synthetic */ SeekBarMorphParentLayout(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
        AttributeSet r6 = (AttributeSet) null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public SeekBarMorphParentLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.lastTouchPoint = new PointF(0.0f, 0.0f);
        this.maxProgress = 100;
    }

    protected final SeekBar getSeekBarChild() {
        SeekBar r1 = this.seekBarChild;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("seekBarChild");
    L5:
        return r1;
    }

    protected final void setSeekBarChild(SeekBar r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.seekBarChild = r2;
    }

    protected final PointF getLastTouchPoint() {
        return this.lastTouchPoint;
    }

    protected final void setLastTouchPoint(PointF r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.lastTouchPoint = r2;
    }

    public static /* synthetic */ void init$default(SeekBarMorphParentLayout r6, SeekBar r7, int r8, int r9, float r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L20;
        if ((r12 & 2) == 0) goto L6;
        r8 = 100;
    L6:
        int r2 = r8;
        if ((r12 & 4) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r12 & 8) == 0) goto L13;
        r10 = 0.15f;
    L13:
        float r4 = r10;
        if ((r12 & 16) == 0) goto L16;
        boolean r5 = false;
    L17:
        r6.init(r7, r2, r3, r4, r5);
        return;
    L16:
        r5 = r11;
        goto L17
    L9:
        r3 = r9;
        goto L11
    L20:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
    }

    protected final void init(SeekBar r4, int r5, int r6, float r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r4, "seekBar");
        OEALogger.INSTANCE.d(TAG, "init, maxProgress: " + r5 + ", minProgress: " + r6 + ", morphFactor: " + r7);
        if (Intrinsics.areEqual(r4.getParent(), this) == false) goto L7;
        this.seekBarChild = r4;
        this.invertDirection = r8;
        this.minProgress = r6;
        this.maxProgress = r5;
        return;
    L7:
        throw new IllegalArgumentException("seekBar must be a child of this view".toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r11) {
        SeekBar r0 = this.seekBarChild;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("seekBarChild");
    L5:
        float r1 = r0.getProgress();
        if (r11 == null) goto L8;
        Integer r2 = Integer.valueOf(r11.getAction());
    L10:
        if (r2 != null) goto L13;
    L20:
        if (r2 != null) goto L23;
    L48:
        if (r2 != null) goto L51;
    L53:
        if (r2 != null) goto L56;
    L19:
        boolean r6 = false;
    L58:
        if (r6 == false) goto L60;
        return true;
    L60:
        if (super.dispatchTouchEvent(r11) == false) goto L63;
        return true;
    L63:
        return false;
    L56:
        if (r2.intValue() != 3) goto L19;
    L57:
        dragEnd();
        goto L19
    L51:
        if (r2.intValue() != 1) goto L53;
    L23:
        if (r2.intValue() != 2) goto L48;
        float r3 = getDeltaMove(r11);
        float r4 = (r1 - this.lastProgress) / r3;
        float r5 = 0.0f;
        if (r4 != 0.0f) goto L27;
    L31:
        this.lastTouchPoint = new PointF(r11.getX(), r11.getY());
        this.lastProgress = r1;
        int r7 = this.maxProgress;
        if (r1 < r7) goto L34;
    L38:
        r5 = this.lastForce + (this.forceFactor * r3);
        if (r5 <= r7) goto L41;
    L44:
        this.lastForce = r5;
        r6 = true;
    L45:
        if (r6 == false) goto L47;
        dragContinue(r5);
    L47:
        OEALogger.INSTANCE.d(TAG, "needMorph: " + r6 + ", force: " + r5 + ", process: " + r1 + ", deltaMove: " + r3 + ", forceFactor: " + this.forceFactor + ", f: " + r4);
        goto L58
    L41:
        if (r5 < this.minProgress) goto L44;
        this.lastForce = r1;
    L37:
        r6 = false;
        goto L45
    L34:
        if (r1 <= this.minProgress) goto L38;
        this.lastForce = r1;
        goto L37
    L27:
        if (this.invertDirection == false) goto L29;
        float r8 = RangesKt.coerceIn(r4, -0.3f, -0.1f);
    L30:
        this.forceFactor = r8;
        goto L31
    L29:
        r8 = RangesKt.coerceIn(r4, 0.1f, 0.3f);
        goto L30
    L13:
        if (r2.intValue() != 0) goto L20;
        startDrag(r1);
        this.lastTouchPoint = new PointF(r11.getX(), r11.getY());
        this.lastProgress = r1;
        this.lastForce = r1;
        if (this.invertDirection == false) goto L17;
        float r9 = -0.2f;
    L18:
        this.forceFactor = r9;
        goto L19
    L17:
        r9 = 0.2f;
        goto L18
    L8:
        r2 = null;
        goto L10
    }
}
