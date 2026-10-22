package com.android.settings.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.viewpager.widget.ViewPager;
import com.android.settings.R;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class DotsPageIndicator extends View implements ViewPager.OnPageChangeListener {
    private static final int DEFAULT_ANIM_DURATION = 400;
    private static final int DEFAULT_DOT_SIZE = 8;
    private static final int DEFAULT_GAP = 12;
    private static final int DEFAULT_SELECTED_COLOUR = -1;
    private static final int DEFAULT_UNSELECTED_COLOUR = -2130706433;
    private static final float INVALID_FRACTION = -1.0f;
    private static final float MINIMAL_REVEAL = 1.0E-5f;
    public static final String TAG = "DotsPageIndicator";
    private long animDuration;
    private long animHalfDuration;
    private boolean attachedState;
    private final Path combinedUnselectedPath;
    float controlX1;
    float controlX2;
    float controlY1;
    float controlY2;
    private int currentPage;
    private float dotBottomY;
    private float[] dotCenterX;
    private float dotCenterY;
    private int dotDiameter;
    private float dotRadius;
    private float[] dotRevealFractions;
    private float dotTopY;
    float endX1;
    float endX2;
    float endY1;
    float endY2;
    private int gap;
    private float halfDotRadius;
    private final Interpolator interpolator;
    private AnimatorSet joiningAnimationSet;
    private ValueAnimator[] joiningAnimations;
    private float[] joiningFractions;
    private ValueAnimator moveAnimation;
    private ViewPager.OnPageChangeListener pageChangeListener;
    private int pageCount;
    private final RectF rectF;
    private PendingRetreatAnimator retreatAnimation;
    private float retreatingJoinX1;
    private float retreatingJoinX2;
    private PendingRevealAnimator[] revealAnimations;
    private int selectedColour;
    private boolean selectedDotInPosition;
    private float selectedDotX;
    private final Paint selectedPaint;
    private int unselectedColour;
    private final Path unselectedDotLeftPath;
    private final Path unselectedDotPath;
    private final Path unselectedDotRightPath;
    private final Paint unselectedPaint;
    private ViewPager viewPager;

    public class LeftwardStartPredicate extends StartPredicate {
        final /* synthetic */ DotsPageIndicator this$0;

        public LeftwardStartPredicate(DotsPageIndicator r1, float r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // com.android.settings.widget.DotsPageIndicator.StartPredicate
        boolean shouldStart(float r1) {
            if (r1 >= this.thresholdValue) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public class PendingRetreatAnimator extends PendingStartAnimator {
        final /* synthetic */ DotsPageIndicator this$0;

        public PendingRetreatAnimator(final DotsPageIndicator r8, int r9, int r10, int r11, StartPredicate r12) {
            this.this$0 = r8;
            super(r8, r12);
            setDuration(DotsPageIndicator.access$700(r8));
            setInterpolator(DotsPageIndicator.access$800(r8));
            if (r10 <= r9) goto L5;
            float r13 = Math.min(DotsPageIndicator.access$900(r8)[r9], DotsPageIndicator.access$300(r8));
            float r0 = DotsPageIndicator.access$1000(r8);
        L6:
            final float r14 = r13 - r0;
            if (r10 <= r9) goto L9;
            float r15 = DotsPageIndicator.access$900(r8)[r10];
            float r1 = DotsPageIndicator.access$1000(r8);
        L10:
            float r16 = r15 - r1;
            if (r10 <= r9) goto L13;
            float r2 = DotsPageIndicator.access$900(r8)[r10];
            float r3 = DotsPageIndicator.access$1000(r8);
        L14:
            final float r4 = r2 + r3;
            if (r10 <= r9) goto L17;
            float r17 = DotsPageIndicator.access$900(r8)[r10];
            float r5 = DotsPageIndicator.access$1000(r8);
        L18:
            float r18 = r17 + r5;
            DotsPageIndicator.access$1102(r8, new PendingRevealAnimator[r11]);
            final int[] r6 = new int[r11];
            int r7 = 0;
            if (r14 == r16) goto L24;
            setFloatValues(new float[]{r14, r16});
        L21:
            if (r7 >= r11) goto L23;
            int r19 = r9 + r7;
            DotsPageIndicator.access$1100(r8)[r7] = new PendingRevealAnimator(r8, r19, new RightwardStartPredicate(r8, DotsPageIndicator.access$900(r8)[r19]));
            r6[r7] = r19;
            r7 = r7 + 1;
            goto L21
        L23:
            addUpdateListener(new AnonymousClass1(this, r8));
        L28:
            addListener(new AnonymousClass3(this, r8, r6, r14, r4));
            return;
        L24:
            setFloatValues(new float[]{r4, r18});
        L25:
            if (r7 >= r11) goto L27;
            int r20 = r9 - r7;
            DotsPageIndicator.access$1100(r8)[r7] = new PendingRevealAnimator(r8, r20, new LeftwardStartPredicate(r8, DotsPageIndicator.access$900(r8)[r20]));
            r6[r7] = r20;
            r7 = r7 + 1;
            goto L25
        L27:
            addUpdateListener(new AnonymousClass2(this, r8));
            goto L28
        L17:
            r17 = DotsPageIndicator.access$900(r8)[r10];
            r5 = DotsPageIndicator.access$1000(r8);
            goto L18
        L13:
            r2 = Math.max(DotsPageIndicator.access$900(r8)[r9], DotsPageIndicator.access$300(r8));
            r3 = DotsPageIndicator.access$1000(r8);
            goto L14
        L9:
            r15 = DotsPageIndicator.access$900(r8)[r10];
            r1 = DotsPageIndicator.access$1000(r8);
            goto L10
        L5:
            r13 = DotsPageIndicator.access$900(r8)[r10];
            r0 = DotsPageIndicator.access$1000(r8);
            goto L6
        }
    }

    public class PendingRevealAnimator extends PendingStartAnimator {
        private final int dot;
        final /* synthetic */ DotsPageIndicator this$0;

        static /* synthetic */ int access$1700(PendingRevealAnimator r0) {
            return r0.dot;
        }

        public PendingRevealAnimator(final DotsPageIndicator r1, int r2, StartPredicate r3) {
            this.this$0 = r1;
            super(r1, r3);
            this.dot = r2;
            setFloatValues(new float[]{DotsPageIndicator.MINIMAL_REVEAL, 1.0f});
            setDuration(DotsPageIndicator.access$700(r1));
            setInterpolator(DotsPageIndicator.access$800(r1));
            addUpdateListener(new AnonymousClass1(this, r1));
            addListener(new AnonymousClass2(this, r1));
        }
    }

    public abstract class PendingStartAnimator extends ValueAnimator {
        protected boolean hasStarted;
        protected StartPredicate predicate;
        final /* synthetic */ DotsPageIndicator this$0;

        public PendingStartAnimator(DotsPageIndicator r1, StartPredicate r2) {
            this.this$0 = r1;
            this.predicate = r2;
            this.hasStarted = false;
        }

        public void startIfNecessary(float r2) {
            if (this.hasStarted == false) goto L5;
            return;
        L5:
            if (this.predicate.shouldStart(r2) == false) goto L9;
            start();
            this.hasStarted = true;
            return;
        }
    }

    public class RightwardStartPredicate extends StartPredicate {
        final /* synthetic */ DotsPageIndicator this$0;

        public RightwardStartPredicate(DotsPageIndicator r1, float r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // com.android.settings.widget.DotsPageIndicator.StartPredicate
        boolean shouldStart(float r1) {
            if (r1 <= this.thresholdValue) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public abstract class StartPredicate {
        final /* synthetic */ DotsPageIndicator this$0;
        protected float thresholdValue;

        abstract boolean shouldStart(float r1);

        public StartPredicate(DotsPageIndicator r1, float r2) {
            this.this$0 = r1;
            this.thresholdValue = r2;
        }
    }

    static {
    }

    static /* synthetic */ boolean access$002(DotsPageIndicator r0, boolean r1) {
        r0.attachedState = r1;
        return r1;
    }

    static /* synthetic */ ViewPager access$100(DotsPageIndicator r0) {
        return r0.viewPager;
    }

    static /* synthetic */ float access$1000(DotsPageIndicator r0) {
        return r0.dotRadius;
    }

    static /* synthetic */ PendingRevealAnimator[] access$1100(DotsPageIndicator r0) {
        return r0.revealAnimations;
    }

    static /* synthetic */ PendingRevealAnimator[] access$1102(DotsPageIndicator r0, PendingRevealAnimator[] r1) {
        r0.revealAnimations = r1;
        return r1;
    }

    static /* synthetic */ float access$1200(DotsPageIndicator r0) {
        return r0.retreatingJoinX1;
    }

    static /* synthetic */ float access$1202(DotsPageIndicator r0, float r1) {
        r0.retreatingJoinX1 = r1;
        return r1;
    }

    static /* synthetic */ float access$1300(DotsPageIndicator r0) {
        return r0.retreatingJoinX2;
    }

    static /* synthetic */ float access$1302(DotsPageIndicator r0, float r1) {
        r0.retreatingJoinX2 = r1;
        return r1;
    }

    static /* synthetic */ void access$1400(DotsPageIndicator r0) {
        r0.cancelJoiningAnimations();
    }

    static /* synthetic */ void access$1500(DotsPageIndicator r0) {
        r0.clearJoiningFractions();
    }

    static /* synthetic */ void access$1600(DotsPageIndicator r0, int r1, float r2) {
        r0.setDotRevealFraction(r1, r2);
    }

    static /* synthetic */ void access$200(DotsPageIndicator r0, int r1) {
        r0.setPageCount(r1);
    }

    static /* synthetic */ float access$300(DotsPageIndicator r0) {
        return r0.selectedDotX;
    }

    static /* synthetic */ float access$302(DotsPageIndicator r0, float r1) {
        r0.selectedDotX = r1;
        return r1;
    }

    static /* synthetic */ PendingRetreatAnimator access$400(DotsPageIndicator r0) {
        return r0.retreatAnimation;
    }

    static /* synthetic */ boolean access$502(DotsPageIndicator r0, boolean r1) {
        r0.selectedDotInPosition = r1;
        return r1;
    }

    static /* synthetic */ void access$600(DotsPageIndicator r0, int r1, float r2) {
        r0.setJoiningFraction(r1, r2);
    }

    static /* synthetic */ long access$700(DotsPageIndicator r2) {
        return r2.animHalfDuration;
    }

    static /* synthetic */ Interpolator access$800(DotsPageIndicator r0) {
        return r0.interpolator;
    }

    static /* synthetic */ float[] access$900(DotsPageIndicator r0) {
        return r0.dotCenterX;
    }

    public DotsPageIndicator(Context r3) {
        this(r3, null, 0);
    }

    public DotsPageIndicator(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public DotsPageIndicator(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7);
        int r0 = (int) r5.getResources().getDisplayMetrics().scaledDensity;
        TypedArray r8 = getContext().obtainStyledAttributes(r6, R.styleable.DotsPageIndicator, r7, 0);
        int r9 = r8.getDimensionPixelSize(2, r0 * 8);
        this.dotDiameter = r9;
        float r10 = r9 / 2;
        this.dotRadius = r10;
        this.halfDotRadius = r10 / 2.0f;
        this.gap = r8.getDimensionPixelSize(3, r0 * 12);
        long r1 = r8.getInteger(0, 400);
        this.animDuration = r1;
        this.animHalfDuration = r1 / 2;
        this.unselectedColour = r8.getColor(4, DEFAULT_UNSELECTED_COLOUR);
        this.selectedColour = r8.getColor(1, -1);
        r8.recycle();
        Paint r11 = new Paint(1);
        this.unselectedPaint = r11;
        r11.setColor(this.unselectedColour);
        Paint r12 = new Paint(1);
        this.selectedPaint = r12;
        r12.setColor(this.selectedColour);
        this.interpolator = AnimationUtils.loadInterpolator(r5, 17563661);
        this.combinedUnselectedPath = new Path();
        this.unselectedDotPath = new Path();
        this.unselectedDotLeftPath = new Path();
        this.unselectedDotRightPath = new Path();
        this.rectF = new RectF();
        addOnAttachStateChangeListener(new AnonymousClass1(this));
    }

    public void setViewPager(ViewPager r2) {
        this.viewPager = r2;
        r2.setOnPageChangeListener(this);
        setPageCount(r2.getAdapter().getCount());
        r2.getAdapter().registerDataSetObserver(new AnonymousClass2(this));
        setCurrentPageImmediate();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r1) {
        this.pageChangeListener = r1;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int r1, float r2, int r3) {
        ViewPager.OnPageChangeListener r0 = this.pageChangeListener;
        if (r0 == null) goto L6;
        r0.onPageScrolled(r1, r2, r3);
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int r2) {
        if (this.attachedState == false) goto L5;
        setSelectedPage(r2);
    L6:
        ViewPager.OnPageChangeListener r1 = this.pageChangeListener;
        if (r1 == null) goto L10;
        r1.onPageSelected(r2);
        return;
    L10:
        return;
    L5:
        setCurrentPageImmediate();
        goto L6
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int r1) {
        ViewPager.OnPageChangeListener r0 = this.pageChangeListener;
        if (r0 == null) goto L6;
        r0.onPageScrollStateChanged(r1);
        return;
    }

    private void setPageCount(int r1) {
        this.pageCount = r1;
        calculateDotPositions();
        resetState();
    }

    private void calculateDotPositions() {
        int r0 = getPaddingLeft();
        int r1 = getPaddingTop();
        float r2 = (r0 + ((((getWidth() - getPaddingRight()) - r0) - getRequiredWidth()) / 2)) + this.dotRadius;
        this.dotCenterX = new float[this.pageCount];
        int r3 = 0;
    L4:
        if (r3 >= this.pageCount) goto L6;
        this.dotCenterX[r3] = ((this.dotDiameter + this.gap) * r3) + r2;
        r3 = r3 + 1;
        goto L4
    L6:
        float r4 = r1;
        this.dotTopY = r4;
        this.dotCenterY = r4 + this.dotRadius;
        this.dotBottomY = r1 + this.dotDiameter;
        setCurrentPageImmediate();
    }

    private void setCurrentPageImmediate() {
        ViewPager r0 = this.viewPager;
        if (r0 == null) goto L5;
        this.currentPage = r0.getCurrentItem();
    L7:
        if (this.pageCount <= 0) goto L10;
        this.selectedDotX = this.dotCenterX[this.currentPage];
        return;
    L10:
        return;
    L5:
        this.currentPage = 0;
        goto L7
    }

    private void resetState() {
        int r0 = this.pageCount;
        if (r0 <= 0) goto L6;
        float[] r1 = new float[r0 - 1];
        this.joiningFractions = r1;
        Arrays.fill(r1, 0.0f);
        float[] r2 = new float[this.pageCount];
        this.dotRevealFractions = r2;
        Arrays.fill(r2, 0.0f);
        this.retreatingJoinX1 = INVALID_FRACTION;
        this.retreatingJoinX2 = INVALID_FRACTION;
        this.selectedDotInPosition = true;
        return;
    }

    @Override // android.view.View
    protected void onMeasure(int r5, int r6) {
        int r0 = getDesiredHeight();
        int r1 = View.MeasureSpec.getMode(r6);
        if (r1 == Integer.MIN_VALUE) goto L7;
        if (r1 != 1073741824) goto L8;
        r0 = View.MeasureSpec.getSize(r6);
    L8:
        int r7 = getDesiredWidth();
        int r2 = View.MeasureSpec.getMode(r5);
        if (r2 == Integer.MIN_VALUE) goto L13;
        if (r2 != 1073741824) goto L14;
        r7 = View.MeasureSpec.getSize(r5);
    L14:
        setMeasuredDimension(r7, r0);
        calculateDotPositions();
        return;
    L13:
        r7 = Math.min(r7, View.MeasureSpec.getSize(r5));
        goto L14
    L7:
        r0 = Math.min(r0, View.MeasureSpec.getSize(r6));
        goto L8
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        setMeasuredDimension(r1, r2);
        calculateDotPositions();
    }

    @Override // android.view.View
    public void clearAnimation() {
        super.clearAnimation();
        cancelRunningAnimations();
    }

    private int getDesiredHeight() {
        return (getPaddingTop() + this.dotDiameter) + getPaddingBottom();
    }

    private int getRequiredWidth() {
        int r0 = this.pageCount;
        return (this.dotDiameter * r0) + ((r0 - 1) * this.gap);
    }

    private int getDesiredWidth() {
        return (getPaddingLeft() + getRequiredWidth()) + getPaddingRight();
    }

    @Override // android.view.View
    protected void onDraw(Canvas r2) {
        if (this.viewPager != null) goto L5;
        return;
    L5:
        if (this.pageCount == 0) goto L10;
        drawUnselected(r2);
        drawSelected(r2);
        return;
    }

    private void drawUnselected(Canvas r9) {
        this.combinedUnselectedPath.rewind();
        int r0 = 0;
    L3:
        int r1 = this.pageCount;
        if (r0 >= r1) goto L15;
        if (r0 != (r1 - 1)) goto L8;
        int r2 = r0;
    L9:
        float[] r3 = this.dotCenterX;
        float r4 = r3[r0];
        float r5 = r3[r2];
        if (r0 != (this.pageCount - 1)) goto L12;
        float r6 = -1.0f;
    L13:
        this.combinedUnselectedPath.op(getUnselectedPath(r0, r4, r5, r6, this.dotRevealFractions[r0]), Path.Op.UNION);
        r0 = r0 + 1;
        goto L3
    L12:
        r6 = this.joiningFractions[r0];
        goto L13
    L8:
        r2 = r0 + 1;
        goto L9
    L15:
        if (this.retreatingJoinX1 == INVALID_FRACTION) goto L17;
        this.combinedUnselectedPath.op(getRetreatingJoinPath(), Path.Op.UNION);
    L17:
        r9.drawPath(this.combinedUnselectedPath, this.unselectedPaint);
    }

    private Path getUnselectedPath(int r23, float r24, float r25, float r26, float r27) {
        this.unselectedDotPath.rewind();
        if (r26 == 0.0f) goto L7;
        if (r26 == INVALID_FRACTION) goto L7;
    L14:
        if (r26 <= 0.0f) goto L21;
        if (r26 >= 0.5f) goto L21;
        if (this.retreatingJoinX1 != INVALID_FRACTION) goto L21;
        this.unselectedDotLeftPath.rewind();
        this.unselectedDotLeftPath.moveTo(r24, this.dotBottomY);
        RectF r1 = this.rectF;
        float r2 = this.dotRadius;
        r1.set(r24 - r2, this.dotTopY, r2 + r24, this.dotBottomY);
        this.unselectedDotLeftPath.arcTo(this.rectF, 90.0f, 180.0f, true);
        float r3 = (this.dotRadius + r24) + (this.gap * r26);
        this.endX1 = r3;
        float r4 = this.dotCenterY;
        this.endY1 = r4;
        float r5 = this.halfDotRadius;
        float r6 = r24 + r5;
        this.controlX1 = r6;
        float r7 = this.dotTopY;
        this.controlY1 = r7;
        this.controlX2 = r3;
        float r8 = r4 - r5;
        this.controlY2 = r8;
        this.unselectedDotLeftPath.cubicTo(r6, r7, r3, r8, r3, r4);
        this.endX2 = r24;
        float r9 = this.dotBottomY;
        this.endY2 = r9;
        float r10 = this.endX1;
        this.controlX1 = r10;
        float r11 = this.endY1;
        float r12 = this.halfDotRadius;
        float r13 = r11 + r12;
        this.controlY1 = r13;
        float r14 = r24 + r12;
        this.controlX2 = r14;
        this.controlY2 = r9;
        this.unselectedDotLeftPath.cubicTo(r10, r13, r14, r9, r24, r9);
        this.unselectedDotPath.op(this.unselectedDotLeftPath, Path.Op.UNION);
        this.unselectedDotRightPath.rewind();
        this.unselectedDotRightPath.moveTo(r25, this.dotBottomY);
        RectF r15 = this.rectF;
        float r16 = this.dotRadius;
        r15.set(r25 - r16, this.dotTopY, r16 + r25, this.dotBottomY);
        this.unselectedDotRightPath.arcTo(this.rectF, 90.0f, -180.0f, true);
        float r17 = (r25 - this.dotRadius) - (this.gap * r26);
        this.endX1 = r17;
        float r18 = this.dotCenterY;
        this.endY1 = r18;
        float r19 = this.halfDotRadius;
        float r20 = r25 - r19;
        this.controlX1 = r20;
        float r21 = this.dotTopY;
        this.controlY1 = r21;
        this.controlX2 = r17;
        float r22 = r18 - r19;
        this.controlY2 = r22;
        this.unselectedDotRightPath.cubicTo(r20, r21, r17, r22, r17, r18);
        this.endX2 = r25;
        float r28 = this.dotBottomY;
        this.endY2 = r28;
        float r29 = this.endX1;
        this.controlX1 = r29;
        float r30 = this.endY1;
        float r31 = this.halfDotRadius;
        float r32 = r30 + r31;
        this.controlY1 = r32;
        float r33 = r25 - r31;
        this.controlX2 = r33;
        this.controlY2 = r28;
        this.unselectedDotRightPath.cubicTo(r29, r32, r33, r28, r25, r28);
        this.unselectedDotPath.op(this.unselectedDotRightPath, Path.Op.UNION);
    L21:
        if (r26 <= 0.5f) goto L28;
        if (r26 >= 1.0f) goto L28;
        if (this.retreatingJoinX1 != INVALID_FRACTION) goto L28;
        this.unselectedDotPath.moveTo(r24, this.dotBottomY);
        RectF r34 = this.rectF;
        float r35 = this.dotRadius;
        r34.set(r24 - r35, this.dotTopY, r35 + r24, this.dotBottomY);
        this.unselectedDotPath.arcTo(this.rectF, 90.0f, 180.0f, true);
        float r36 = this.dotRadius;
        float r37 = (r24 + r36) + (this.gap / 2);
        this.endX1 = r37;
        float r38 = this.dotCenterY - (r26 * r36);
        this.endY1 = r38;
        float r110 = r37 - (r26 * r36);
        this.controlX1 = r110;
        float r39 = this.dotTopY;
        this.controlY1 = r39;
        float r210 = 1.0f - r26;
        float r40 = r37 - (r36 * r210);
        this.controlX2 = r40;
        this.controlY2 = r38;
        this.unselectedDotPath.cubicTo(r110, r39, r40, r38, r37, r38);
        this.endX2 = r25;
        float r41 = this.dotTopY;
        this.endY2 = r41;
        float r42 = this.endX1;
        float r43 = this.dotRadius;
        float r44 = (r210 * r43) + r42;
        this.controlX1 = r44;
        float r45 = this.endY1;
        this.controlY1 = r45;
        float r46 = r42 + (r43 * r26);
        this.controlX2 = r46;
        this.controlY2 = r41;
        this.unselectedDotPath.cubicTo(r44, r45, r46, r41, r25, r41);
        RectF r47 = this.rectF;
        float r48 = this.dotRadius;
        r47.set(r25 - r48, this.dotTopY, r48 + r25, this.dotBottomY);
        this.unselectedDotPath.arcTo(this.rectF, 270.0f, 180.0f, true);
        float r49 = this.dotCenterY;
        float r50 = this.dotRadius;
        float r51 = r49 + (r26 * r50);
        this.endY1 = r51;
        float r52 = this.endX1;
        float r111 = r52 + (r26 * r50);
        this.controlX1 = r111;
        float r112 = this.dotBottomY;
        this.controlY1 = r112;
        float r53 = (r50 * r210) + r52;
        this.controlX2 = r53;
        this.controlY2 = r51;
        this.unselectedDotPath.cubicTo(r111, r112, r53, r51, r52, r51);
        this.endX2 = r24;
        float r54 = this.dotBottomY;
        this.endY2 = r54;
        float r55 = this.endX1;
        float r56 = this.dotRadius;
        float r57 = r55 - (r210 * r56);
        this.controlX1 = r57;
        float r58 = this.endY1;
        this.controlY1 = r58;
        float r59 = r55 - (r56 * r26);
        this.controlX2 = r59;
        this.controlY2 = r54;
        this.unselectedDotPath.cubicTo(r57, r58, r59, r54, r24, r54);
    L28:
        if (r26 != 1.0f) goto L33;
        if (this.retreatingJoinX1 != INVALID_FRACTION) goto L33;
        RectF r60 = this.rectF;
        float r61 = this.dotRadius;
        r60.set(r24 - r61, this.dotTopY, r61 + r25, this.dotBottomY);
        Path r62 = this.unselectedDotPath;
        RectF r63 = this.rectF;
        float r64 = this.dotRadius;
        r62.addRoundRect(r63, r64, r64, Path.Direction.CW);
    L33:
        if (r27 <= MINIMAL_REVEAL) goto L36;
        this.unselectedDotPath.addCircle(r24, this.dotCenterY, this.dotRadius * r27, Path.Direction.CW);
    L36:
        return this.unselectedDotPath;
    L7:
        if (r27 != 0.0f) goto L14;
        if (r23 == this.currentPage) goto L11;
    L12:
        this.unselectedDotPath.addCircle(this.dotCenterX[r23], this.dotCenterY, this.dotRadius, Path.Direction.CW);
        goto L14
    L11:
        if (this.selectedDotInPosition == true) goto L14;
        goto L12
    }

    private Path getRetreatingJoinPath() {
        this.unselectedDotPath.rewind();
        this.rectF.set(this.retreatingJoinX1, this.dotTopY, this.retreatingJoinX2, this.dotBottomY);
        Path r0 = this.unselectedDotPath;
        RectF r1 = this.rectF;
        float r2 = this.dotRadius;
        r0.addRoundRect(r1, r2, r2, Path.Direction.CW);
        return this.unselectedDotPath;
    }

    private void drawSelected(Canvas r4) {
        r4.drawCircle(this.selectedDotX, this.dotCenterY, this.dotRadius, this.selectedPaint);
    }

    private void setSelectedPage(int r12) {
        int r0 = this.currentPage;
        if (r12 != r0) goto L5;
        return;
    L5:
        if (this.pageCount == 0) goto L20;
        this.currentPage = r12;
        cancelRunningAnimations();
        int r1 = Math.abs(r12 - r0);
        this.moveAnimation = createMoveSelectedAnimator(this.dotCenterX[r12], r0, r12, r1);
        this.joiningAnimations = new ValueAnimator[r1];
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L14;
        ValueAnimator[] r3 = this.joiningAnimations;
        if (r12 <= r0) goto L12;
        int r4 = r0 + r2;
    L13:
        r3[r2] = createJoiningAnimator(r4, ((long) r2) * (this.animDuration / 8));
        r2 = r2 + 1;
        goto L8
    L12:
        r4 = (r0 - 1) - r2;
        goto L13
    L14:
        this.moveAnimation.start();
        startJoiningAnimations();
        return;
    }

    private ValueAnimator createMoveSelectedAnimator(float r9, int r10, int r11, int r12) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{this.selectedDotX, r9});
        if (r11 <= r10) goto L5;
        StartPredicate r2 = new RightwardStartPredicate(this, r9 - ((r9 - this.selectedDotX) * 0.25f));
    L6:
        this.retreatAnimation = new PendingRetreatAnimator(this, r10, r11, r12, r2);
        r0.addUpdateListener(new AnonymousClass3(this));
        r0.addListener(new AnonymousClass4(this));
        if (this.selectedDotInPosition == false) goto L9;
        long r1 = this.animDuration / 4;
    L10:
        r0.setStartDelay(r1);
        r0.setDuration((this.animDuration * 3) / 4);
        r0.setInterpolator(this.interpolator);
        return r0;
    L9:
        r1 = 0;
        goto L10
    L5:
        r2 = new LeftwardStartPredicate(this, r9 + ((this.selectedDotX - r9) * 0.25f));
        goto L6
    }

    private ValueAnimator createJoiningAnimator(final int r4, long r5) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.addUpdateListener(new AnonymousClass5(this, r4));
        r0.setDuration(this.animHalfDuration);
        r0.setStartDelay(r5);
        r0.setInterpolator(this.interpolator);
        return r0;
    }

    private void setJoiningFraction(int r2, float r3) {
        this.joiningFractions[r2] = r3;
        postInvalidateOnAnimation();
    }

    private void clearJoiningFractions() {
        Arrays.fill(this.joiningFractions, 0.0f);
        postInvalidateOnAnimation();
    }

    private void setDotRevealFraction(int r2, float r3) {
        this.dotRevealFractions[r2] = r3;
        postInvalidateOnAnimation();
    }

    private void cancelRunningAnimations() {
        cancelMoveAnimation();
        cancelJoiningAnimations();
        cancelRetreatAnimation();
        cancelRevealAnimations();
        resetState();
    }

    private void cancelMoveAnimation() {
        ValueAnimator r0 = this.moveAnimation;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() == false) goto L9;
        this.moveAnimation.cancel();
        return;
    }

    private void startJoiningAnimations() {
        AnimatorSet r0 = new AnimatorSet();
        this.joiningAnimationSet = r0;
        r0.playTogether(this.joiningAnimations);
        this.joiningAnimationSet.start();
    }

    private void cancelJoiningAnimations() {
        AnimatorSet r0 = this.joiningAnimationSet;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() == false) goto L9;
        this.joiningAnimationSet.cancel();
        return;
    }

    private void cancelRetreatAnimation() {
        PendingRetreatAnimator r0 = this.retreatAnimation;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() == false) goto L9;
        this.retreatAnimation.cancel();
        return;
    }

    private void cancelRevealAnimations() {
        PendingRevealAnimator[] r3 = this.revealAnimations;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].cancel();
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    int getUnselectedColour() {
        return this.unselectedColour;
    }

    int getSelectedColour() {
        return this.selectedColour;
    }

    float getDotCenterY() {
        return this.dotCenterY;
    }

    float getDotCenterX(int r1) {
        return this.dotCenterX[r1];
    }

    float getSelectedDotX() {
        return this.selectedDotX;
    }

    int getCurrentPage() {
        return this.currentPage;
    }
}
