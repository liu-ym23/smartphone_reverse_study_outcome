package com.bytedanceos.oui;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.obric.security.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MultiSegmentProgressBar.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0002;<B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010'\u001a\u0004\u0018\u00010\n2\u0006\u0010(\u001a\u00020\u0010H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0014J\u000e\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\bJ\u000e\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\fJ\u000e\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020\nJ\u000e\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020\u0010J\u000e\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u001cJ\u0014\u00107\u001a\u00020*2\f\u00108\u001a\b\u0012\u0004\u0012\u00020!0 J\u000e\u00109\u001a\u00020*2\u0006\u0010.\u001a\u00020\bJ\b\u0010:\u001a\u00020*H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/bytedanceos/oui/MultiSegmentProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animateSmallProgressBar", "", "animatedPercents", "", "animationDurationMs", "", "animator", "Landroid/animation/ValueAnimator;", "barBackgroundColor", "", "bgClipPath", "Landroid/graphics/Path;", "bgCornerRadii", "bgPaint", "Landroid/graphics/Paint;", "bgRect", "Landroid/graphics/RectF;", "cubicOut", "Lcom/bytedanceos/oui/MultiSegmentProgressBar$CubicOutInterpolator;", "reusablePath", "segmentGap", "", "segmentPaint", "segmentRect", "segments", "", "Lcom/bytedanceos/oui/MultiSegmentProgressBar$Segment;", "startPercents", "syncRightCornerWithFirstSegmentLeft", "targetPercents", "useSegmentGap", "zeroRadii", "getCurrentPercents", "prevCount", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setAnimateSmallProgressBar", "enable", "setAnimationDuration", "ms", "setBackgroundCornerRadii", "radii", "setBarBackgroundColor", "color", "setSegmentGap", "dp", "setSegments", "list", "setUseSegmentGap", "updateBackgroundRightCorner", "CubicOutInterpolator", "Segment", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiSegmentProgressBar extends View {
    private HashMap _$_findViewCache;
    private boolean animateSmallProgressBar;
    private float[] animatedPercents;
    private long animationDurationMs;
    private ValueAnimator animator;
    private int barBackgroundColor;
    private final Path bgClipPath;
    private float[] bgCornerRadii;
    private final Paint bgPaint;
    private final RectF bgRect;
    private final CubicOutInterpolator cubicOut;
    private final Path reusablePath;
    private float segmentGap;
    private final Paint segmentPaint;
    private final RectF segmentRect;
    private List<Segment> segments;
    private float[] startPercents;
    private boolean syncRightCornerWithFirstSegmentLeft;
    private float[] targetPercents;
    private boolean useSegmentGap;
    private final float[] zeroRadii;

    /* JADX INFO: compiled from: MultiSegmentProgressBar.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedanceos/oui/MultiSegmentProgressBar$CubicOutInterpolator;", "Landroid/animation/TimeInterpolator;", "()V", "getInterpolation", "", "t", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class CubicOutInterpolator implements TimeInterpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r2) {
            float r3 = 1.0f - r2;
            return 1.0f - ((r3 * r3) * r3);
        }

        public CubicOutInterpolator() {
        }
    }

    /* JADX INFO: compiled from: MultiSegmentProgressBar.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedanceos/oui/MultiSegmentProgressBar$Segment;", "", "color", "", "percent", "", "cornerRadii", "", "(IF[F)V", "getColor", "()I", "getCornerRadii", "()[F", "getPercent", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Segment {
        private final int color;
        private final float[] cornerRadii;
        private final float percent;

        public static /* synthetic */ Segment copy$default(Segment r0, int r1, float r2, float[] r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.color;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.percent;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.cornerRadii;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final int component1() {
            return this.color;
        }

        public final float component2() {
            return this.percent;
        }

        public final float[] component3() {
            return this.cornerRadii;
        }

        public final Segment copy(int r1, float r2, float[] r3) {
            return new Segment(r1, r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Segment) == false) goto L12;
            Segment r4 = (Segment) r3;
            if (this.color == r4.color) goto L8;
            return false;
        L8:
            if (Float.compare(this.percent, r4.percent) == 0) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.cornerRadii, r4.cornerRadii) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            int r0 = ((Integer.hashCode(this.color) * 31) + Float.hashCode(this.percent)) * 31;
            float[] r2 = this.cornerRadii;
            if (r2 == null) goto L5;
            int r3 = Arrays.hashCode(r2);
        L7:
            return r0 + r3;
        L5:
            r3 = 0;
            goto L7
        }

        public String toString() {
            return "Segment(color=" + this.color + ", percent=" + this.percent + ", cornerRadii=" + Arrays.toString(this.cornerRadii) + ")";
        }

        public Segment(int r1, float r2, float[] r3) {
            this.color = r1;
            this.percent = r2;
            this.cornerRadii = r3;
        }

        public final int getColor() {
            return this.color;
        }

        public final float getPercent() {
            return this.percent;
        }

        public /* synthetic */ Segment(int r1, float r2, float[] r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = null;
            float[] r6 = (float[]) null;
        L5:
            this(r1, r2, r3);
        }

        public final float[] getCornerRadii() {
            return this.cornerRadii;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MultiSegmentProgressBar(Context r3) {
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap r0 = this._$_findViewCache;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public View _$_findCachedViewById(int r3) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new HashMap();
    L5:
        View r0 = (View) this._$_findViewCache.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        View r1 = findViewById(r3);
        this._$_findViewCache.put(Integer.valueOf(r3), r1);
        return r1;
    L9:
        return r0;
    }

    public static final /* synthetic */ float[] access$getAnimatedPercents$p(MultiSegmentProgressBar r0) {
        return r0.animatedPercents;
    }

    public static final /* synthetic */ float[] access$getStartPercents$p(MultiSegmentProgressBar r0) {
        return r0.startPercents;
    }

    public static final /* synthetic */ float[] access$getTargetPercents$p(MultiSegmentProgressBar r0) {
        return r0.targetPercents;
    }

    public static final /* synthetic */ void access$setAnimatedPercents$p(MultiSegmentProgressBar r0, float[] r1) {
        r0.animatedPercents = r1;
    }

    public static final /* synthetic */ void access$setStartPercents$p(MultiSegmentProgressBar r0, float[] r1) {
        r0.startPercents = r1;
    }

    public static final /* synthetic */ void access$setTargetPercents$p(MultiSegmentProgressBar r0, float[] r1) {
        r0.targetPercents = r1;
    }

    public /* synthetic */ MultiSegmentProgressBar(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
        AttributeSet r5 = (AttributeSet) null;
    L5:
        this(r1, r2);
    }

    public MultiSegmentProgressBar(Context r6, AttributeSet r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        this.bgPaint = new Paint(1);
        this.segmentPaint = new Paint(1);
        this.barBackgroundColor = R.color.oui_fill_element_3;
        this.bgCornerRadii = new float[8];
        this.syncRightCornerWithFirstSegmentLeft = true;
        this.useSegmentGap = true;
        this.animateSmallProgressBar = true;
        this.segments = CollectionsKt.emptyList();
        this.animationDurationMs = 300;
        this.cubicOut = new CubicOutInterpolator();
        this.bgRect = new RectF();
        this.segmentRect = new RectF();
        this.reusablePath = new Path();
        this.bgClipPath = new Path();
        float[] r1 = new float[8];
        int r3 = 0;
    L3:
        if (r3 >= 8) goto L5;
        r1[r3] = 0.0f;
        r3 = r3 + 1;
        goto L3
    L5:
        this.zeroRadii = r1;
        Resources r2 = getResources();
        Intrinsics.checkNotNullExpressionValue(r2, "resources");
        float r4 = r2.getDisplayMetrics().density * 8.0f;
        this.bgCornerRadii = new float[]{r4, r4, r4, r4, r4, r4, r4, r4};
        this.bgPaint.setColor(r6.getColor(this.barBackgroundColor));
    }

    public final void setBarBackgroundColor(int r2) {
        this.barBackgroundColor = r2;
        this.bgPaint.setColor(r2);
        invalidate();
    }

    public final void setBackgroundCornerRadii(float[] r4) {
        Intrinsics.checkNotNullParameter(r4, "radii");
        if (r4.length != 8) goto L6;
        System.arraycopy(r4, 0, this.bgCornerRadii, 0, 8);
        invalidate();
        return;
    }

    public final void setSegmentGap(float r3) {
        Resources r0 = getResources();
        Intrinsics.checkNotNullExpressionValue(r0, "resources");
        this.segmentGap = r3 * r0.getDisplayMetrics().density;
        invalidate();
    }

    public final void setSegments(List<Segment> r10) {
        Intrinsics.checkNotNullParameter(r10, "list");
        int r0 = this.segments.size();
        int r1 = r10.size();
        float[] r2 = getCurrentPercents(r0);
        float[] r3 = new float[r1];
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r5 >= r1) goto L6;
        r3[r5] = RangesKt.coerceIn(r10.get(r5).getPercent(), 0.0f, 1.0f);
        r5 = r5 + 1;
        goto L4
    L6:
        if (r0 == 0) goto L8;
    L14:
        this.segments = r10;
        if (r0 != r1) goto L18;
        if (r2 == null) goto L18;
    L21:
        this.startPercents = r2;
        this.targetPercents = r3;
        float[] r11 = new float[r1];
    L22:
        if (r4 >= r1) goto L24;
        float[] r6 = this.startPercents;
        Intrinsics.checkNotNull(r6);
        r11[r4] = r6[r4];
        r4 = r4 + 1;
        goto L22
    L24:
        this.animatedPercents = r11;
        ValueAnimator r12 = this.animator;
        if (r12 == null) goto L27;
        r12.cancel();
    L27:
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r13.setDuration(this.animationDurationMs);
        r13.setInterpolator(this.cubicOut);
        r13.addUpdateListener(new MultiSegmentProgressBar$setSegments$$inlined$apply$lambda$1(this));
        r13.start();
        Unit r7 = Unit.INSTANCE;
        this.animator = r13;
        return;
    L18:
        r2 = new float[r1];
        int r14 = 0;
    L19:
        if (r14 >= r1) goto L21;
        r2[r14] = 0.0f;
        r14 = r14 + 1;
        goto L19
    L8:
        if (this.animateSmallProgressBar == false) goto L14;
        this.segments = r10;
        float[] r8 = (float[]) null;
        this.startPercents = null;
        this.targetPercents = r3;
        float[] r15 = Arrays.copyOf(r3, r1);
        Intrinsics.checkNotNullExpressionValue(r15, "copyOf(this, size)");
        this.animatedPercents = r15;
        ValueAnimator r16 = this.animator;
        if (r16 == null) goto L12;
        r16.cancel();
    L12:
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas r18) {
        Intrinsics.checkNotNullParameter(r18, "canvas");
        super.onDraw(r18);
        float r2 = getWidth();
        float r3 = getHeight();
        updateBackgroundRightCorner();
        this.bgRect.set(0.0f, 0.0f, r2, r3);
        this.reusablePath.reset();
        this.reusablePath.addRoundRect(this.bgRect, this.bgCornerRadii, Path.Direction.CW);
        r18.drawPath(this.reusablePath, this.bgPaint);
        this.bgClipPath.reset();
        this.bgClipPath.addRoundRect(this.bgRect, this.bgCornerRadii, Path.Direction.CW);
        if (this.segments.isEmpty() == false) goto L5;
        return;
    L5:
        int r4 = r18.save();
        r18.clipPath(this.bgClipPath);
        Iterator<T> r6 = this.segments.iterator();
        float r9 = 0.0f;
        int r8 = 0;
    L7:
        if (r6.hasNext() == false) goto L84;
        Segment r10 = (Segment) r6.next();
        float[] r11 = this.animatedPercents;
        if (r11 == null) goto L13;
        Float r12 = ArraysKt.getOrNull(r11, r8);
        if (r12 == null) goto L13;
        float r13 = r12.floatValue();
    L14:
        float r14 = r2 * r13;
        if (r14 > 0.0f) goto L17;
        r9 = r9 + r14;
    L83:
        r8 = r8 + 1;
        goto L7
    L17:
        float r15 = r14 + r9;
        boolean r16 = true;
        if (r8 != CollectionsKt.getLastIndex(this.segments)) goto L20;
        boolean r17 = true;
    L22:
        if (r15 < (r2 - 0.5f)) goto L24;
    L27:
        boolean r19 = true;
    L29:
        if (this.useSegmentGap == false) goto L32;
        if (r17 == true) goto L32;
        float r110 = r15 - this.segmentGap;
    L34:
        if (r110 <= r9) goto L82;
        this.segmentRect.set(r9, 0.0f, r110, r3);
        this.reusablePath.reset();
        float[] r20 = r10.getCornerRadii();
        if (r20 != null) goto L39;
        r20 = this.zeroRadii;
    L39:
        if (r19 == false) goto L81;
        r20 = Arrays.copyOf(r20, r20.length);
        Intrinsics.checkNotNullExpressionValue(r20, "copyOf(this, size)");
        Float r111 = Float.valueOf(r20[2]);
        if (r111.floatValue() <= 0.0f) goto L43;
        boolean r112 = true;
    L44:
        Float r113 = null;
        if (r112 == true) goto L48;
        r111 = null;
    L48:
        if (r111 == null) goto L50;
        float r114 = r111.floatValue();
    L51:
        r20[2] = r114;
        Float r115 = Float.valueOf(r20[3]);
        if (r115.floatValue() <= 0.0f) goto L54;
        boolean r116 = true;
    L55:
        if (r116 == true) goto L58;
        r115 = null;
    L58:
        if (r115 == null) goto L60;
        float r117 = r115.floatValue();
    L61:
        r20[3] = r117;
        Float r118 = Float.valueOf(r20[4]);
        if (r118.floatValue() <= 0.0f) goto L64;
        boolean r119 = true;
    L65:
        if (r119 == true) goto L68;
        r118 = null;
    L68:
        if (r118 == null) goto L70;
        float r120 = r118.floatValue();
    L71:
        r20[4] = r120;
        Float r121 = Float.valueOf(r20[5]);
        if (r121.floatValue() > 0.0f) goto L75;
        r16 = false;
    L75:
        if (r16 == false) goto L77;
        r113 = r121;
    L77:
        if (r113 == null) goto L79;
        float r122 = r113.floatValue();
    L80:
        r20[5] = r122;
        goto L81
    L79:
        r122 = r20[7];
        goto L80
    L70:
        r120 = r20[6];
        goto L71
    L64:
        r119 = false;
        goto L65
    L60:
        r117 = r20[1];
        goto L61
    L54:
        r116 = false;
        goto L55
    L50:
        r114 = r20[0];
        goto L51
    L43:
        r112 = false;
    L81:
        this.reusablePath.addRoundRect(this.segmentRect, r20, Path.Direction.CW);
        this.segmentPaint.setColor(r10.getColor());
        r18.drawPath(this.reusablePath, this.segmentPaint);
    L82:
        r9 = r15;
    L32:
        r110 = r15;
        goto L34
    L24:
        if (r13 >= 0.999f) goto L27;
        r19 = false;
        goto L29
    L20:
        r17 = false;
    L13:
        r13 = r10.getPercent();
        goto L14
    L84:
        r18.restoreToCount(r4);
    }

    private final void updateBackgroundRightCorner() {
        if (this.syncRightCornerWithFirstSegmentLeft == true) goto L6;
        return;
    L6:
        if (this.segments.isEmpty() == false) goto L8;
        return;
    L8:
        Segment r0 = (Segment) CollectionsKt.firstOrNull(this.segments);
        if (r0 != null) goto L11;
        return;
    L11:
        float[] r1 = r0.getCornerRadii();
        if (r1 != null) goto L14;
        return;
    L14:
        float[] r3 = this.bgCornerRadii;
        r3[2] = r1[0];
        r3[3] = r1[1];
        r3[4] = r1[6];
        r3[5] = r1[7];
    }

    public final void setUseSegmentGap(boolean r1) {
        this.useSegmentGap = r1;
        invalidate();
    }

    public final void setAnimationDuration(long r1) {
        this.animationDurationMs = r1;
    }

    private final float[] getCurrentPercents(int r6) {
        float[] r0 = this.animatedPercents;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        if (r0.length != r6) goto L8;
        float[] r5 = this.animatedPercents;
        Intrinsics.checkNotNull(r5);
        float[] r7 = Arrays.copyOf(r5, r5.length);
        Intrinsics.checkNotNullExpressionValue(r7, "copyOf(this, size)");
        return r7;
    L8:
        if ((!this.segments.isEmpty()) == true) goto L10;
    L15:
        return null;
    L10:
        if (this.segments.size() != r6) goto L15;
        float[] r1 = new float[r6];
        int r2 = 0;
    L12:
        if (r2 >= r6) goto L19;
        r1[r2] = RangesKt.coerceIn(this.segments.get(r2).getPercent(), 0.0f, 1.0f);
        r2 = r2 + 1;
        goto L12
    L19:
        return r1;
    }

    public final void setAnimateSmallProgressBar(boolean r1) {
        this.animateSmallProgressBar = r1;
        invalidate();
    }
}
