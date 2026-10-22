package com.google.android.material.slider;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    static final int DEF_STYLE_RES = 0;
    private static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION = "minSeparation(%s) must be greater or equal to 0";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE = "minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE_UNIT = "minSeparation(%s) cannot be set as a dimension when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    private static final String EXCEPTION_ILLEGAL_VALUE = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom(%s) must be smaller than valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_TO = "valueTo(%s) must be greater than valueFrom(%s)";
    private static final int HALO_ALPHA = 63;
    private static final long LABEL_ANIMATION_ENTER_DURATION = 83;
    private static final long LABEL_ANIMATION_EXIT_DURATION = 117;
    private static final String TAG = null;
    private static final double THRESHOLD = 1.0E-4d;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    static final int UNIT_PX = 0;
    static final int UNIT_VALUE = 1;
    private static final String WARNING_FLOATING_POINT_ERROR = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.";
    private BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender;

    @NonNull
    private final AccessibilityHelper accessibilityHelper;
    private final AccessibilityManager accessibilityManager;
    private int activeThumbIdx;

    @NonNull
    private final Paint activeTicksPaint;

    @NonNull
    private final Paint activeTrackPaint;

    @NonNull
    private final List<L> changeListeners;
    private int defaultThumbRadius;
    private boolean dirtyConfig;
    private int focusedThumbIdx;
    private boolean forceDrawCompatHalo;
    private LabelFormatter formatter;

    @NonNull
    private ColorStateList haloColor;

    @NonNull
    private final Paint haloPaint;
    private int haloRadius;

    @NonNull
    private final Paint inactiveTicksPaint;

    @NonNull
    private final Paint inactiveTrackPaint;
    private boolean isLongPress;
    private int labelBehavior;

    @NonNull
    private final TooltipDrawableFactory labelMaker;
    private int labelPadding;

    @NonNull
    private final List<TooltipDrawable> labels;
    private boolean labelsAreAnimatedIn;
    private ValueAnimator labelsInAnimator;
    private ValueAnimator labelsOutAnimator;
    private MotionEvent lastEvent;
    private int minTrackSidePadding;
    private final int scaledTouchSlop;
    private int separationUnit;
    private float stepSize;

    @NonNull
    private final MaterialShapeDrawable thumbDrawable;
    private boolean thumbIsPressed;

    @NonNull
    private final Paint thumbPaint;
    private int thumbRadius;

    @NonNull
    private ColorStateList tickColorActive;

    @NonNull
    private ColorStateList tickColorInactive;
    private boolean tickVisible;
    private float[] ticksCoordinates;
    private float touchDownX;

    @NonNull
    private final List<T> touchListeners;
    private float touchPosition;

    @NonNull
    private ColorStateList trackColorActive;

    @NonNull
    private ColorStateList trackColorInactive;
    private int trackHeight;
    private int trackSidePadding;
    private int trackTop;
    private int trackWidth;
    private float valueFrom;
    private float valueTo;
    private ArrayList<Float> values;
    private int widgetHeight;

    private class AccessibilityEventSender implements Runnable {
        final /* synthetic */ BaseSlider this$0;
        int virtualViewId;

        private AccessibilityEventSender(BaseSlider r1) {
            this.this$0 = r1;
            this.virtualViewId = -1;
        }

        /* synthetic */ AccessibilityEventSender(BaseSlider r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.access$300(this.this$0).sendEventForVirtualView(this.virtualViewId, 4);
        }

        void setVirtualViewId(int r1) {
            this.virtualViewId = r1;
        }
    }

    private static class AccessibilityHelper extends ExploreByTouchHelper {
        private final BaseSlider<?, ?, ?> slider;
        Rect virtualViewBounds;

        AccessibilityHelper(BaseSlider<?, ?, ?> r2) {
            super(r2);
            this.virtualViewBounds = new Rect();
            this.slider = r2;
        }

        @NonNull
        private String startOrEndDescription(int r2) {
            if (r2 != (this.slider.getValues().size() - 1)) goto L7;
            Context r1 = this.slider.getContext();
            int r3 = R.string.material_slider_range_end;
        L6:
            return r1.getString(r3);
        L7:
            if (r2 != 0) goto L9;
            r1 = this.slider.getContext();
            r3 = R.string.material_slider_range_start;
            goto L6
        L9:
            return "";
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float r5, float r6) {
            int r0 = 0;
        L4:
            if (r0 >= this.slider.getValues().size()) goto L9;
            this.slider.updateBoundsForVirturalViewId(r0, this.virtualViewBounds);
            if (this.virtualViewBounds.contains((int) r5, (int) r6) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L9:
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> r3) {
            int r0 = 0;
        L4:
            if (r0 >= this.slider.getValues().size()) goto L6;
            r3.add(Integer.valueOf(r0));
            r0 = r0 + 1;
            goto L4
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int r5, int r6, Bundle r7) {
            if (this.slider.isEnabled() == true) goto L6;
            return false;
        L6:
            if (r6 == 4096) goto L20;
            if (r6 == 8192) goto L20;
            if (r6 == 16908349) goto L11;
            return false;
        L11:
            if (r7 != null) goto L13;
        L19:
            return false;
        L13:
            if (r7.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE) == false) goto L19;
            float r8 = r7.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE);
            if (BaseSlider.access$600(this.slider, r5, r8) == false) goto L19;
        L17:
            BaseSlider.access$700(this.slider);
            this.slider.postInvalidate();
            invalidateVirtualView(r5);
            return true;
        L20:
            float r9 = BaseSlider.access$800(this.slider, 20);
            if (r6 != 8192) goto L24;
            r9 = -r9;
        L24:
            if (this.slider.isRtl() == false) goto L26;
            r9 = -r9;
        L26:
            float r10 = MathUtils.clamp(this.slider.getValues().get(r5).floatValue() + r9, this.slider.getValueFrom(), this.slider.getValueTo());
            if (BaseSlider.access$600(this.slider, r5, r10) == true) goto L17;
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int r6, AccessibilityNodeInfoCompat r7) {
            r7.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> r0 = this.slider.getValues();
            float r1 = r0.get(r6).floatValue();
            float r2 = this.slider.getValueFrom();
            float r3 = this.slider.getValueTo();
            if (this.slider.isEnabled() == true) goto L5;
        L10:
            r7.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, r2, r3, r1));
            r7.setClassName(SeekBar.class.getName());
            StringBuilder r4 = new StringBuilder();
            if (this.slider.getContentDescription() == null) goto L14;
            r4.append(this.slider.getContentDescription());
            r4.append(",");
        L14:
            if (r0.size() <= 1) goto L16;
            r4.append(startOrEndDescription(r6));
            r4.append(BaseSlider.access$500(this.slider, r1));
        L16:
            r7.setContentDescription(r4.toString());
            this.slider.updateBoundsForVirturalViewId(r6, this.virtualViewBounds);
            r7.setBoundsInParent(this.virtualViewBounds);
            return;
        L5:
            if (r1 <= r2) goto L8;
            r7.addAction(8192);
        L8:
            if (r1 >= r3) goto L10;
            r7.addAction(4096);
            goto L10
        }
    }

    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = null;
        boolean hasFocus;
        float stepSize;
        float valueFrom;
        float valueTo;
        ArrayList<Float> values;

        static {
            CREATOR = new AnonymousClass1();
        }

        private SliderState(@NonNull Parcel r3) {
            super(r3);
            this.valueFrom = r3.readFloat();
            this.valueTo = r3.readFloat();
            ArrayList<Float> r0 = new ArrayList();
            this.values = r0;
            r3.readList(r0, Float.class.getClassLoader());
            this.stepSize = r3.readFloat();
            this.hasFocus = r3.createBooleanArray()[0];
        }

        /* synthetic */ SliderState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        SliderState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            r2.writeFloat(this.valueFrom);
            r2.writeFloat(this.valueTo);
            r2.writeList(this.values);
            r2.writeFloat(this.stepSize);
            r2.writeBooleanArray(new boolean[]{this.hasFocus});
        }
    }

    private interface TooltipDrawableFactory {
        TooltipDrawable createTooltipDrawable();
    }

    static {
        TAG = BaseSlider.class.getSimpleName();
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_Slider;
    }

    public BaseSlider(@NonNull Context r2) {
        this(r2, null);
    }

    public BaseSlider(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.sliderStyle);
    }

    public BaseSlider(@NonNull Context r6, @Nullable final AttributeSet r7, final int r8) {
        super(MaterialThemeOverlay.wrap(r6, r7, r8, DEF_STYLE_RES), r7, r8);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.labelsAreAnimatedIn = false;
        this.thumbIsPressed = false;
        this.values = new ArrayList();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.tickVisible = true;
        this.isLongPress = false;
        MaterialShapeDrawable r1 = new MaterialShapeDrawable();
        this.thumbDrawable = r1;
        this.separationUnit = 0;
        Context r9 = getContext();
        Paint r2 = new Paint();
        this.inactiveTrackPaint = r2;
        r2.setStyle(Paint.Style.STROKE);
        r2.setStrokeCap(Paint.Cap.ROUND);
        Paint r3 = new Paint();
        this.activeTrackPaint = r3;
        r3.setStyle(Paint.Style.STROKE);
        r3.setStrokeCap(Paint.Cap.ROUND);
        Paint r4 = new Paint(1);
        this.thumbPaint = r4;
        r4.setStyle(Paint.Style.FILL);
        r4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint r5 = new Paint(1);
        this.haloPaint = r5;
        r5.setStyle(Paint.Style.FILL);
        Paint r10 = new Paint();
        this.inactiveTicksPaint = r10;
        r10.setStyle(Paint.Style.STROKE);
        r10.setStrokeCap(Paint.Cap.ROUND);
        Paint r11 = new Paint();
        this.activeTicksPaint = r11;
        r11.setStyle(Paint.Style.STROKE);
        r11.setStrokeCap(Paint.Cap.ROUND);
        loadResources(r9.getResources());
        this.labelMaker = new AnonymousClass1(this, r7, r8);
        processAttributes(r9, r7, r8);
        setFocusable(true);
        setClickable(true);
        r1.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(r9).getScaledTouchSlop();
        AccessibilityHelper r12 = new AccessibilityHelper(this);
        this.accessibilityHelper = r12;
        ViewCompat.setAccessibilityDelegate(this, r12);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    static /* synthetic */ TooltipDrawable access$000(Context r0, TypedArray r1) {
        return parseLabelDrawable(r0, r1);
    }

    static /* synthetic */ List access$100(BaseSlider r0) {
        return r0.labels;
    }

    static /* synthetic */ AccessibilityHelper access$300(BaseSlider r0) {
        return r0.accessibilityHelper;
    }

    static /* synthetic */ String access$500(BaseSlider r0, float r1) {
        return r0.formatValue(r1);
    }

    static /* synthetic */ boolean access$600(BaseSlider r0, int r1, float r2) {
        return r0.snapThumbToValue(r1, r2);
    }

    static /* synthetic */ void access$700(BaseSlider r0) {
        r0.updateHaloHotspot();
    }

    static /* synthetic */ float access$800(BaseSlider r0, int r1) {
        return r0.calculateStepIncrement(r1);
    }

    private void attachLabelToContentView(TooltipDrawable r1) {
        r1.setRelativeToView(ViewUtils.getContentView(this));
    }

    private Float calculateIncrementForKey(int r3) {
        if (this.isLongPress == false) goto L5;
        float r0 = calculateStepIncrement(20);
    L7:
        if (r3 == 21) goto L28;
        if (r3 == 22) goto L23;
        if (r3 == 69) goto L21;
        if (r3 == 70) goto L19;
        if (r3 == 81) goto L19;
        return null;
    L19:
        return Float.valueOf(r0);
    L21:
        return Float.valueOf(-r0);
    L23:
        if (isRtl() == false) goto L26;
        r0 = -r0;
    L26:
        return Float.valueOf(r0);
    L28:
        if (isRtl() == true) goto L32;
        r0 = -r0;
    L32:
        return Float.valueOf(r0);
    L5:
        r0 = calculateStepIncrement();
        goto L7
    }

    private float calculateStepIncrement() {
        float r1 = this.stepSize;
        if (r1 != 0.0f) goto L6;
        return 1.0f;
    L6:
        return r1;
    }

    private float calculateStepIncrement(int r3) {
        float r0 = calculateStepIncrement();
        float r1 = (this.valueTo - this.valueFrom) / r0;
        float r2 = r3;
        if (r1 > r2) goto L6;
        return r0;
    L6:
        return Math.round(r1 / r2) * r0;
    }

    private int calculateTop() {
        int r0 = this.trackTop;
        int r2 = 0;
        if (this.labelBehavior != 1) goto L6;
        r2 = this.labels.get(0).getIntrinsicHeight();
    L6:
        return r0 + r2;
    }

    private ValueAnimator createLabelAnimator(boolean r5) {
        float r0 = 0.0f;
        if (r5 == false) goto L5;
        float r2 = 0.0f;
    L6:
        if (r5 == false) goto L8;
        ValueAnimator r3 = this.labelsOutAnimator;
    L9:
        float r4 = getAnimatorCurrentValueOrDefault(r3, r2);
        if (r5 == false) goto L12;
        r0 = 1.0f;
    L12:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{r4, r0});
        if (r5 == false) goto L15;
        long r6 = LABEL_ANIMATION_ENTER_DURATION;
    L16:
        r1.setDuration(r6);
        if (r5 == false) goto L19;
        TimeInterpolator r7 = AnimationUtils.DECELERATE_INTERPOLATOR;
    L20:
        r1.setInterpolator(r7);
        r1.addUpdateListener(new AnonymousClass2(this));
        return r1;
    L19:
        r7 = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
        goto L20
    L15:
        r6 = LABEL_ANIMATION_EXIT_DURATION;
        goto L16
    L8:
        r3 = this.labelsInAnimator;
        goto L9
    L5:
        r2 = 1.0f;
        goto L6
    }

    private void createLabelPool() {
        if (this.labels.size() <= this.values.size()) goto L12;
        List<TooltipDrawable> r0 = this.labels.subList(this.values.size(), this.labels.size());
        Iterator<TooltipDrawable> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        TooltipDrawable r2 = r1.next();
        if (ViewCompat.isAttachedToWindow(this) == false) goto L6;
        detachLabelFromContentView(r2);
        goto L6
    L10:
        r0.clear();
    L12:
        if (this.labels.size() >= this.values.size()) goto L16;
        TooltipDrawable r3 = this.labelMaker.createTooltipDrawable();
        this.labels.add(r3);
        if (ViewCompat.isAttachedToWindow(this) == false) goto L12;
        attachLabelToContentView(r3);
        goto L12
    L16:
        int r4 = 1;
        if (this.labels.size() != 1) goto L19;
        r4 = 0;
    L19:
        Iterator<TooltipDrawable> r5 = this.labels.iterator();
    L21:
        if (r5.hasNext() == false) goto L23;
        r5.next().setStrokeWidth(r4);
        goto L21
    }

    private void detachLabelFromContentView(TooltipDrawable r2) {
        ViewOverlayImpl r0 = ViewUtils.getContentViewOverlay(this);
        if (r0 == null) goto L6;
        r0.remove(r2);
        r2.detachView(ViewUtils.getContentView(this));
        return;
    }

    private float dimenToValue(float r3) {
        if (r3 != 0.0f) goto L5;
        return 0.0f;
    L5:
        float r4 = (r3 - this.trackSidePadding) / this.trackWidth;
        float r0 = this.valueFrom;
        return (r4 * (r0 - this.valueTo)) + r0;
    }

    private void dispatchOnChangedFromUser(int r5) {
        Iterator<L> r0 = this.changeListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onValueChange(this, this.values.get(r5).floatValue(), true);
        goto L4
    L6:
        AccessibilityManager r1 = this.accessibilityManager;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isEnabled() == false) goto L14;
        scheduleAccessibilityEventSender(r5);
        return;
    }

    private void dispatchOnChangedProgrammatically() {
        Iterator<L> r0 = this.changeListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        L r1 = r0.next();
        Iterator<Float> r2 = this.values.iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        r1.onValueChange(this, r2.next().floatValue(), false);
        goto L7
    }

    private void drawActiveTrack(@NonNull Canvas r11, int r12, int r13) {
        float[] r0 = getActiveRange();
        int r1 = this.trackSidePadding;
        float r14 = r12;
        float r8 = r13;
        r11.drawLine(r1 + (r0[0] * r14), r8, r1 + (r0[1] * r14), r8, this.activeTrackPaint);
    }

    private void drawInactiveTrack(@NonNull Canvas r12, int r13, int r14) {
        float[] r0 = getActiveRange();
        int r1 = this.trackSidePadding;
        float r4 = r13;
        float r6 = r1 + (r0[1] * r4);
        if (r6 >= (r1 + r13)) goto L5;
        float r9 = r14;
        r12.drawLine(r6, r9, r1 + r13, r9, this.inactiveTrackPaint);
    L5:
        int r15 = this.trackSidePadding;
        float r5 = r15 + (r0[0] * r4);
        if (r5 <= r15) goto L9;
        float r7 = r14;
        r12.drawLine(r15, r7, r5, r7, this.inactiveTrackPaint);
        return;
    }

    private void drawThumbs(@NonNull Canvas r6, int r7, int r8) {
        if (isEnabled() == true) goto L8;
        Iterator<Float> r0 = this.values.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        r6.drawCircle(this.trackSidePadding + (normalizeValue(r0.next().floatValue()) * r7), r8, this.thumbRadius, this.thumbPaint);
    L8:
        Iterator<Float> r1 = this.values.iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        Float r2 = r1.next();
        r6.save();
        int r3 = this.trackSidePadding + ((int) (normalizeValue(r2.floatValue()) * r7));
        int r4 = this.thumbRadius;
        r6.translate(r3 - r4, r8 - r4);
        this.thumbDrawable.draw(r6);
        r6.restore();
        goto L10
    }

    private void ensureLabelsAdded() {
        if (this.labelBehavior != 2) goto L6;
        return;
    L6:
        if (this.labelsAreAnimatedIn == true) goto L8;
        this.labelsAreAnimatedIn = true;
        ValueAnimator r0 = createLabelAnimator(true);
        this.labelsInAnimator = r0;
        this.labelsOutAnimator = null;
        r0.start();
    L8:
        Iterator<TooltipDrawable> r1 = this.labels.iterator();
        int r4 = 0;
    L10:
        if (r4 >= this.values.size()) goto L19;
        if (r1.hasNext() == false) goto L19;
        if (r4 == this.focusedThumbIdx) goto L17;
        setValueForLabel(r1.next(), this.values.get(r4).floatValue());
    L17:
        r4 = r4 + 1;
    L19:
        if (r1.hasNext() == false) goto L23;
        setValueForLabel(r1.next(), this.values.get(this.focusedThumbIdx).floatValue());
        return;
    L23:
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[]{Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size())}));
    }

    private void ensureLabelsRemoved() {
        if (this.labelsAreAnimatedIn == false) goto L6;
        this.labelsAreAnimatedIn = false;
        ValueAnimator r0 = createLabelAnimator(false);
        this.labelsOutAnimator = r0;
        this.labelsInAnimator = null;
        r0.addListener(new AnonymousClass3(this));
        this.labelsOutAnimator.start();
        return;
    }

    private void focusThumbOnFocusGained(int r4) {
        if (r4 != 1) goto L5;
        moveFocus(Integer.MAX_VALUE);
        return;
    L5:
        if (r4 != 2) goto L7;
        moveFocus(Integer.MIN_VALUE);
        return;
    L7:
        if (r4 != 17) goto L9;
        moveFocusInAbsoluteDirection(Integer.MAX_VALUE);
        return;
    L9:
        if (r4 != 66) goto L19;
        moveFocusInAbsoluteDirection(Integer.MIN_VALUE);
        return;
    }

    private String formatValue(float r3) {
        if (hasLabelFormatter() == false) goto L7;
        return this.formatter.getFormattedValue(r3);
    L7:
        if (((int) r3) != r3) goto L9;
        String r2 = "%.0f";
    L11:
        return String.format(r2, new Object[]{Float.valueOf(r3)});
    L9:
        r2 = "%.2f";
        goto L11
    }

    private float[] getActiveRange() {
        float r0 = ((Float) Collections.max(getValues())).floatValue();
        float r1 = ((Float) Collections.min(getValues())).floatValue();
        if (this.values.size() != 1) goto L5;
        r1 = this.valueFrom;
    L5:
        float r2 = normalizeValue(r1);
        float r3 = normalizeValue(r0);
        if (isRtl() == false) goto L9;
        return new float[]{r3, r2};
    L9:
        return new float[]{r2, r3};
    }

    private static float getAnimatorCurrentValueOrDefault(ValueAnimator r1, float r2) {
        if (r1 != null) goto L4;
        return r2;
    L4:
        if (r1.isRunning() == false) goto L8;
        float r3 = ((Float) r1.getAnimatedValue()).floatValue();
        r1.cancel();
        return r3;
    L8:
        return r2;
    }

    private float getClampedValue(int r4, float r5) {
        float r0 = getMinSeparation();
        if (this.separationUnit != 0) goto L6;
        r0 = dimenToValue(r0);
    L6:
        if (isRtl() == false) goto L8;
        r0 = -r0;
    L8:
        int r1 = r4 + 1;
        if (r1 < this.values.size()) goto L11;
        float r2 = this.valueTo;
    L12:
        int r6 = r4 - 1;
        if (r6 >= 0) goto L15;
        float r3 = this.valueFrom;
    L17:
        return MathUtils.clamp(r5, r3, r2);
    L15:
        r3 = this.values.get(r6).floatValue() + r0;
        goto L17
    L11:
        r2 = this.values.get(r1).floatValue() - r0;
        goto L12
    }

    @ColorInt
    private int getColorForState(@NonNull ColorStateList r2) {
        return r2.getColorForState(getDrawableState(), r2.getDefaultColor());
    }

    private float getValueOfTouchPosition() {
        double r0 = snapPosition(this.touchPosition);
        if (isRtl() == false) goto L5;
        r0 = 1.0d - r0;
    L5:
        float r2 = this.valueTo;
        float r4 = this.valueFrom;
        return (float) ((r0 * ((double) (r2 - r4))) + ((double) r4));
    }

    private float getValueOfTouchPositionAbsolute() {
        float r0 = this.touchPosition;
        if (isRtl() == false) goto L5;
        r0 = 1.0f - r0;
    L5:
        float r1 = this.valueTo;
        float r2 = this.valueFrom;
        return (r0 * (r1 - r2)) + r2;
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth(this.trackHeight);
        this.activeTrackPaint.setStrokeWidth(this.trackHeight);
        this.inactiveTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
        this.activeTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
    }

    private boolean isInVerticalScrollingContainer() {
        ViewParent r4 = getParent();
    L3:
        boolean r1 = false;
        if ((r4 instanceof ViewGroup) == false) goto L15;
        ViewGroup r0 = (ViewGroup) r4;
        if (r0.canScrollVertically(1) == false) goto L8;
    L9:
        r1 = true;
    L10:
        if (r1 == false) goto L14;
        if (r0.shouldDelayChildPressedState() == false) goto L14;
        return true;
    L14:
        r4 = r4.getParent();
        goto L3
    L8:
        if (r0.canScrollVertically(-1) == false) goto L10;
    L15:
        return false;
    }

    private boolean isMultipleOfStepSize(float r3) {
        double r2 = new BigDecimal(Float.toString(r3)).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
        if (Math.abs(Math.round(r2) - r2) >= THRESHOLD) goto L5;
        return true;
    L5:
        return false;
    }

    private void loadResources(@NonNull Resources r2) {
        this.widgetHeight = r2.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int r0 = r2.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.minTrackSidePadding = r0;
        this.trackSidePadding = r0;
        this.defaultThumbRadius = r2.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.trackTop = r2.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
        this.labelPadding = r2.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
    }

    private void maybeCalculateTicksCoordinates() {
        if (this.stepSize > 0.0f) goto L5;
        return;
    L5:
        validateConfigurationIfDirty();
        int r0 = Math.min((int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f), (this.trackWidth / (this.trackHeight * 2)) + 1);
        float[] r1 = this.ticksCoordinates;
        if (r1 != null) goto L8;
    L9:
        this.ticksCoordinates = new float[r0 * 2];
    L10:
        float r2 = this.trackWidth / (r0 - 1);
        int r3 = 0;
    L12:
        if (r3 >= (r0 * 2)) goto L14;
        float[] r4 = this.ticksCoordinates;
        r4[r3] = this.trackSidePadding + ((r3 / 2) * r2);
        r4[r3 + 1] = calculateTop();
        r3 = r3 + 2;
        goto L12
    L14:
        return;
    L8:
        if (r1.length == (r0 * 2)) goto L10;
        goto L9
    }

    private void maybeDrawHalo(@NonNull Canvas r9, int r10, int r11) {
        if (shouldDrawCompatHalo() == false) goto L9;
        int r12 = (int) (this.trackSidePadding + (normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * r10));
        if (Build.VERSION.SDK_INT >= 28) goto L7;
        int r0 = this.haloRadius;
        r9.clipRect(r12 - r0, r11 - r0, r12 + r0, r0 + r11, Region.Op.UNION);
    L7:
        r9.drawCircle(r12, r11, this.haloRadius, this.haloPaint);
        return;
    }

    private void maybeDrawTicks(@NonNull Canvas r6) {
        if (this.tickVisible == true) goto L5;
        return;
    L5:
        if (this.stepSize <= 0.0f) goto L10;
        float[] r0 = getActiveRange();
        int r1 = pivotIndex(this.ticksCoordinates, r0[0]);
        int r2 = pivotIndex(this.ticksCoordinates, r0[1]);
        int r3 = r1 * 2;
        r6.drawPoints(this.ticksCoordinates, 0, r3, this.inactiveTicksPaint);
        int r4 = r2 * 2;
        r6.drawPoints(this.ticksCoordinates, r3, r4 - r3, this.activeTicksPaint);
        float[] r5 = this.ticksCoordinates;
        r6.drawPoints(r5, r4, r5.length - r4, this.inactiveTicksPaint);
        return;
    }

    private void maybeIncreaseTrackSidePadding() {
        int r0 = Math.max(this.thumbRadius - this.defaultThumbRadius, 0);
        this.trackSidePadding = this.minTrackSidePadding + r0;
        if (ViewCompat.isLaidOut(this) == false) goto L6;
        updateTrackWidth(getWidth());
        return;
    }

    private boolean moveFocus(int r12) {
        int r0 = this.focusedThumbIdx;
        int r13 = (int) MathUtils.clamp(((long) r0) + ((long) r12), 0, this.values.size() - 1);
        this.focusedThumbIdx = r13;
        if (r13 != r0) goto L7;
        return false;
    L7:
        if (this.activeThumbIdx == (-1)) goto L9;
        this.activeThumbIdx = r13;
    L9:
        updateHaloHotspot();
        postInvalidate();
        return true;
    }

    private boolean moveFocusInAbsoluteDirection(int r2) {
        if (isRtl() == false) goto L9;
        if (r2 != Integer.MIN_VALUE) goto L7;
        r2 = Integer.MAX_VALUE;
        goto L9
    L7:
        r2 = -r2;
    L9:
        return moveFocus(r2);
    }

    private float normalizeValue(float r3) {
        float r0 = this.valueFrom;
        float r4 = (r3 - r0) / (this.valueTo - r0);
        if (isRtl() == true) goto L5;
        return r4;
    L5:
        return 1.0f - r4;
    }

    private Boolean onKeyDownNoActiveThumb(int r5, @NonNull KeyEvent r6) {
        Boolean r0 = Boolean.TRUE;
        if (r5 == 61) goto L26;
        if (r5 != 66) goto L7;
    L23:
        this.activeThumbIdx = this.focusedThumbIdx;
        postInvalidate();
        return r0;
    L7:
        if (r5 != 81) goto L9;
    L21:
        moveFocus(1);
        return r0;
    L9:
        if (r5 != 69) goto L11;
        moveFocus(-1);
        return r0;
    L11:
        if (r5 == 70) goto L21;
        switch(r5) {
            case 21: goto L17;
            case 22: goto L15;
            case 23: goto L23;
            default: goto L13;
        };
    L13:
        return null;
    L15:
        moveFocusInAbsoluteDirection(1);
        return r0;
    L17:
        moveFocusInAbsoluteDirection(-1);
        return r0;
    L26:
        if (r6.hasNoModifiers() == false) goto L31;
        boolean r4 = moveFocus(1);
    L29:
        return Boolean.valueOf(r4);
    L31:
        if (r6.isShiftPressed() == false) goto L34;
        r4 = moveFocus(-1);
        goto L29
    L34:
        return Boolean.FALSE;
    }

    private void onStartTrackingTouch() {
        Iterator<T> r0 = this.touchListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onStartTrackingTouch(this);
        goto L4
    }

    private void onStopTrackingTouch() {
        Iterator<T> r0 = this.touchListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onStopTrackingTouch(this);
        goto L4
    }

    @NonNull
    private static TooltipDrawable parseLabelDrawable(@NonNull Context r2, @NonNull TypedArray r3) {
        return TooltipDrawable.createFromAttributes(r2, null, 0, r3.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip));
    }

    private static int pivotIndex(float[] r0, float r1) {
        return Math.round(r1 * ((r0.length / 2) - 1));
    }

    private void processAttributes(Context r8, AttributeSet r9, int r10) {
        TypedArray r11 = ThemeEnforcement.obtainStyledAttributes(r8, r9, R.styleable.Slider, r10, DEF_STYLE_RES, new int[0]);
        this.valueFrom = r11.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.valueTo = r11.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(new Float[]{Float.valueOf(this.valueFrom)});
        this.stepSize = r11.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        int r1 = R.styleable.Slider_trackColor;
        boolean r2 = r11.hasValue(r1);
        if (r2 == false) goto L5;
        int r3 = r1;
    L6:
        if (r2 == true) goto L9;
        r1 = R.styleable.Slider_trackColorActive;
    L9:
        ColorStateList r4 = MaterialResources.getColorStateList(r8, r11, r3);
        if (r4 != null) goto L13;
        r4 = AppCompatResources.getColorStateList(r8, R.color.material_slider_inactive_track_color);
    L13:
        setTrackInactiveTintList(r4);
        ColorStateList r5 = MaterialResources.getColorStateList(r8, r11, r1);
        if (r5 != null) goto L17;
        r5 = AppCompatResources.getColorStateList(r8, R.color.material_slider_active_track_color);
    L17:
        setTrackActiveTintList(r5);
        this.thumbDrawable.setFillColor(MaterialResources.getColorStateList(r8, r11, R.styleable.Slider_thumbColor));
        int r6 = R.styleable.Slider_thumbStrokeColor;
        if (r11.hasValue(r6) == false) goto L20;
        setThumbStrokeColor(MaterialResources.getColorStateList(r8, r11, r6));
    L20:
        setThumbStrokeWidth(r11.getDimension(R.styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList r7 = MaterialResources.getColorStateList(r8, r11, R.styleable.Slider_haloColor);
        if (r7 != null) goto L24;
        r7 = AppCompatResources.getColorStateList(r8, R.color.material_slider_halo_color);
    L24:
        setHaloTintList(r7);
        this.tickVisible = r11.getBoolean(R.styleable.Slider_tickVisible, true);
        int r12 = R.styleable.Slider_tickColor;
        boolean r13 = r11.hasValue(r12);
        if (r13 == false) goto L27;
        int r14 = r12;
    L28:
        if (r13 == true) goto L31;
        r12 = R.styleable.Slider_tickColorActive;
    L31:
        ColorStateList r15 = MaterialResources.getColorStateList(r8, r11, r14);
        if (r15 != null) goto L35;
        r15 = AppCompatResources.getColorStateList(r8, R.color.material_slider_inactive_tick_marks_color);
    L35:
        setTickInactiveTintList(r15);
        ColorStateList r16 = MaterialResources.getColorStateList(r8, r11, r12);
        if (r16 != null) goto L39;
        r16 = AppCompatResources.getColorStateList(r8, R.color.material_slider_active_tick_marks_color);
    L39:
        setTickActiveTintList(r16);
        setThumbRadius(r11.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(r11.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(r11.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(r11.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        this.labelBehavior = r11.getInt(R.styleable.Slider_labelBehavior, 0);
        if (r11.getBoolean(R.styleable.Slider_android_enabled, true) == true) goto L42;
        setEnabled(false);
    L42:
        r11.recycle();
        return;
    L27:
        r14 = R.styleable.Slider_tickColorInactive;
        goto L28
    L5:
        r3 = R.styleable.Slider_trackColorInactive;
        goto L6
    }

    private void scheduleAccessibilityEventSender(int r3) {
        BaseSlider<S, L, T>.AccessibilityEventSender r0 = this.accessibilityEventSender;
        if (r0 != null) goto L5;
        this.accessibilityEventSender = new AccessibilityEventSender(this, null);
    L6:
        this.accessibilityEventSender.setVirtualViewId(r3);
        postDelayed(this.accessibilityEventSender, 200);
        return;
    L5:
        removeCallbacks(r0);
        goto L6
    }

    private void setValueForLabel(TooltipDrawable r4, float r5) {
        r4.setText(formatValue(r5));
        int r0 = (this.trackSidePadding + ((int) (normalizeValue(r5) * this.trackWidth))) - (r4.getIntrinsicWidth() / 2);
        int r6 = calculateTop() - (this.labelPadding + this.thumbRadius);
        r4.setBounds(r0, r6 - r4.getIntrinsicHeight(), r4.getIntrinsicWidth() + r0, r6);
        Rect r7 = new Rect(r4.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, r7);
        r4.setBounds(r7);
        ViewUtils.getContentViewOverlay(this).add(r4);
    }

    private void setValuesInternal(@NonNull ArrayList<Float> r3) {
        if (r3.isEmpty() == true) goto L12;
        Collections.sort(r3);
        if (this.values.size() == r3.size()) goto L7;
    L9:
        this.values = r3;
        this.dirtyConfig = true;
        this.focusedThumbIdx = 0;
        updateHaloHotspot();
        createLabelPool();
        dispatchOnChangedProgrammatically();
        postInvalidate();
        return;
    L7:
        if (this.values.equals(r3) == false) goto L9;
        return;
    L12:
        throw new IllegalArgumentException("At least one value must be set");
    }

    private boolean shouldDrawCompatHalo() {
        if (this.forceDrawCompatHalo == false) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L10;
        if ((getBackground() instanceof RippleDrawable) == false) goto L10;
        return false;
    }

    private boolean snapActiveThumbToValue(float r2) {
        return snapThumbToValue(this.activeThumbIdx, r2);
    }

    private double snapPosition(float r3) {
        float r0 = this.stepSize;
        if (r0 <= 0.0f) goto L7;
        int r2 = (int) ((this.valueTo - this.valueFrom) / r0);
        return ((double) Math.round(r3 * r2)) / ((double) r2);
    L7:
        return r3;
    }

    private boolean snapThumbToValue(int r5, float r6) {
        this.focusedThumbIdx = r5;
        if (Math.abs(r6 - this.values.get(r5).floatValue()) >= THRESHOLD) goto L6;
        return false;
    L6:
        this.values.set(r5, Float.valueOf(getClampedValue(r5, r6)));
        dispatchOnChangedFromUser(r5);
        return true;
    }

    private boolean snapTouchPosition() {
        return snapActiveThumbToValue(getValueOfTouchPosition());
    }

    private void updateHaloHotspot() {
        if (shouldDrawCompatHalo() == false) goto L5;
        return;
    L5:
        if (getMeasuredWidth() <= 0) goto L11;
        Drawable r0 = getBackground();
        if ((r0 instanceof RippleDrawable) == false) goto L12;
        int r1 = (int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * this.trackWidth) + this.trackSidePadding);
        int r2 = calculateTop();
        int r5 = this.haloRadius;
        DrawableCompat.setHotspotBounds(r0, r1 - r5, r2 - r5, r1 + r5, r2 + r5);
        return;
    L12:
        return;
    }

    private void updateTrackWidth(int r2) {
        this.trackWidth = Math.max(r2 - (this.trackSidePadding * 2), 0);
        maybeCalculateTicksCoordinates();
    }

    private void validateConfigurationIfDirty() {
        if (this.dirtyConfig == false) goto L6;
        validateValueFrom();
        validateValueTo();
        validateStepSize();
        validateValues();
        validateMinSeparation();
        warnAboutFloatingPointError();
        this.dirtyConfig = false;
        return;
    }

    private void validateMinSeparation() {
        float r0 = getMinSeparation();
        if (r0 < 0.0f) goto L21;
        float r2 = this.stepSize;
        if (r2 > 0.0f) goto L7;
        return;
    L7:
        if (r0 > 0.0f) goto L9;
        return;
    L9:
        if (this.separationUnit != 1) goto L18;
        if (r0 < r2) goto L16;
        if (isMultipleOfStepSize(r0) == false) goto L16;
        return;
    L16:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE, new Object[]{Float.valueOf(r0), Float.valueOf(this.stepSize), Float.valueOf(this.stepSize)}));
    L18:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE_UNIT, new Object[]{Float.valueOf(r0), Float.valueOf(this.stepSize)}));
    L21:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION, new Object[]{Float.valueOf(r0)}));
    }

    private void validateStepSize() {
        if (this.stepSize > 0.0f) goto L5;
        return;
    L5:
        if (valueLandsOnTick(this.valueTo) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, new Object[]{Float.valueOf(this.stepSize), Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)}));
    }

    private void validateValueFrom() {
        if (this.valueFrom >= this.valueTo) goto L6;
        return;
    L6:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_FROM, new Object[]{Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)}));
    }

    private void validateValueTo() {
        if (this.valueTo <= this.valueFrom) goto L6;
        return;
    L6:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_TO, new Object[]{Float.valueOf(this.valueTo), Float.valueOf(this.valueFrom)}));
    }

    private void validateValues() {
        Iterator<Float> r0 = this.values.iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        Float r1 = r0.next();
        if (r1.floatValue() < this.valueFrom) goto L17;
        if (r1.floatValue() > this.valueTo) goto L17;
        if (this.stepSize <= 0.0f) goto L4;
        if (valueLandsOnTick(r1.floatValue()) == true) goto L4;
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_DISCRETE_VALUE, new Object[]{r1, Float.valueOf(this.valueFrom), Float.valueOf(this.stepSize), Float.valueOf(this.stepSize)}));
    L17:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE, new Object[]{r1, Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)}));
    }

    private boolean valueLandsOnTick(float r2) {
        return isMultipleOfStepSize(r2 - this.valueFrom);
    }

    private float valueToX(float r2) {
        return (normalizeValue(r2) * this.trackWidth) + this.trackSidePadding;
    }

    private void warnAboutFloatingPointError() {
        float r0 = this.stepSize;
        if (r0 != 0.0f) goto L6;
        return;
    L6:
        if (((int) r0) == r0) goto L8;
        Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERROR, new Object[]{"stepSize", Float.valueOf(r0)}));
    L8:
        float r1 = this.valueFrom;
        if (((int) r1) == r1) goto L11;
        Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERROR, new Object[]{"valueFrom", Float.valueOf(r1)}));
    L11:
        float r8 = this.valueTo;
        if (((int) r8) == r8) goto L15;
        Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERROR, new Object[]{"valueTo", Float.valueOf(r8)}));
        return;
    }

    public void addOnChangeListener(@NonNull L r1) {
        this.changeListeners.add(r1);
    }

    public void addOnSliderTouchListener(@NonNull T r1) {
        this.touchListeners.add(r1);
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent r2) {
        if (this.accessibilityHelper.dispatchHoverEvent(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.dispatchHoverEvent(r2) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent r1) {
        return super.dispatchKeyEvent(r1);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        Iterator<TooltipDrawable> r0 = this.labels.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        TooltipDrawable r1 = r0.next();
        if (r1.isStateful() == false) goto L4;
        r1.setState(getDrawableState());
        goto L4
    L9:
        if (this.thumbDrawable.isStateful() == false) goto L11;
        this.thumbDrawable.setState(getDrawableState());
    L11:
        this.haloPaint.setColor(getColorForState(this.haloColor));
        this.haloPaint.setAlpha(63);
    }

    @VisibleForTesting
    void forceDrawCompatHalo(boolean r1) {
        this.forceDrawCompatHalo = r1;
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    final int getAccessibilityFocusedVirtualViewId() {
        return this.accessibilityHelper.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    @Dimension
    public int getHaloRadius() {
        return this.haloRadius;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.haloColor;
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    protected float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public float getThumbElevation() {
        return this.thumbDrawable.getElevation();
    }

    @Dimension
    public int getThumbRadius() {
        return this.thumbRadius;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.thumbDrawable.getStrokeColor();
    }

    public float getThumbStrokeWidth() {
        return this.thumbDrawable.getStrokeWidth();
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.thumbDrawable.getFillColor();
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.tickColorActive;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.tickColorInactive;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.tickColorInactive.equals(this.tickColorActive) == false) goto L7;
        return this.tickColorActive;
    L7:
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.trackColorActive;
    }

    @Dimension
    public int getTrackHeight() {
        return this.trackHeight;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.trackColorInactive;
    }

    @Dimension
    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.trackColorInactive.equals(this.trackColorActive) == false) goto L7;
        return this.trackColorActive;
    L7:
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Dimension
    public int getTrackWidth() {
        return this.trackWidth;
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public float getValueTo() {
        return this.valueTo;
    }

    @NonNull
    List<Float> getValues() {
        return new ArrayList(this.values);
    }

    public boolean hasLabelFormatter() {
        if (this.formatter == null) goto L5;
        return true;
    L5:
        return false;
    }

    final boolean isRtl() {
        if (ViewCompat.getLayoutDirection(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isTickVisible() {
        return this.tickVisible;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<TooltipDrawable> r0 = this.labels.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        attachLabelToContentView(r0.next());
        goto L4
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        BaseSlider<S, L, T>.AccessibilityEventSender r0 = this.accessibilityEventSender;
        if (r0 == null) goto L5;
        removeCallbacks(r0);
    L5:
        this.labelsAreAnimatedIn = false;
        Iterator<TooltipDrawable> r1 = this.labels.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        detachLabelFromContentView(r1.next());
        goto L7
    L9:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas r4) {
        if (this.dirtyConfig == false) goto L5;
        validateConfigurationIfDirty();
        maybeCalculateTicksCoordinates();
    L5:
        super.onDraw(r4);
        int r0 = calculateTop();
        drawInactiveTrack(r4, this.trackWidth, r0);
        if (((Float) Collections.max(getValues())).floatValue() <= this.valueFrom) goto L8;
        drawActiveTrack(r4, this.trackWidth, r0);
    L8:
        maybeDrawTicks(r4);
        if (this.thumbIsPressed == true) goto L13;
        if (isFocused() == true) goto L13;
    L17:
        drawThumbs(r4, this.trackWidth, r0);
        return;
    L13:
        if (isEnabled() == false) goto L17;
        maybeDrawHalo(r4, this.trackWidth, r0);
        if (this.activeThumbIdx == (-1)) goto L17;
        ensureLabelsAdded();
        goto L17
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean r1, int r2, @Nullable Rect r3) {
        super.onFocusChanged(r1, r2, r3);
        if (r1 == true) goto L5;
        this.activeThumbIdx = -1;
        ensureLabelsRemoved();
        this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
        return;
    L5:
        focusThumbOnFocusGained(r2);
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r6, @NonNull KeyEvent r7) {
        if (isEnabled() == true) goto L7;
        return super.onKeyDown(r6, r7);
    L7:
        if (this.values.size() != 1) goto L10;
        this.activeThumbIdx = 0;
    L10:
        if (this.activeThumbIdx != (-1)) goto L16;
        Boolean r0 = onKeyDownNoActiveThumb(r6, r7);
        if (r0 == null) goto L15;
        return r0.booleanValue();
    L15:
        return super.onKeyDown(r6, r7);
    L16:
        this.isLongPress |= r7.isLongPress();
        Float r1 = calculateIncrementForKey(r6);
        if (r1 == null) goto L23;
        if (snapActiveThumbToValue(this.values.get(this.activeThumbIdx).floatValue() + r1.floatValue()) == false) goto L21;
        updateHaloHotspot();
        postInvalidate();
    L21:
        return true;
    L23:
        if (r6 != 23) goto L25;
    L39:
        this.activeThumbIdx = -1;
        ensureLabelsRemoved();
        postInvalidate();
        return true;
    L25:
        if (r6 == 61) goto L31;
        if (r6 == 66) goto L39;
        return super.onKeyDown(r6, r7);
    L31:
        if (r7.hasNoModifiers() == false) goto L35;
        return moveFocus(1);
    L35:
        if (r7.isShiftPressed() == true) goto L37;
        return false;
    L37:
        return moveFocus(-1);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r2, @NonNull KeyEvent r3) {
        this.isLongPress = false;
        return super.onKeyUp(r2, r3);
    }

    @Override // android.view.View
    protected void onMeasure(int r4, int r5) {
        int r6 = this.widgetHeight;
        int r1 = 0;
        if (this.labelBehavior != 1) goto L5;
        r1 = this.labels.get(0).getIntrinsicHeight();
    L5:
        super.onMeasure(r4, View.MeasureSpec.makeMeasureSpec(r6 + r1, BasicMeasure.EXACTLY));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r2) {
        SliderState r3 = (SliderState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        this.valueFrom = r3.valueFrom;
        this.valueTo = r3.valueTo;
        setValuesInternal(r3.values);
        this.stepSize = r3.stepSize;
        if (r3.hasFocus == false) goto L6;
        requestFocus();
        return;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SliderState r1 = new SliderState(super.onSaveInstanceState());
        r1.valueFrom = this.valueFrom;
        r1.valueTo = this.valueTo;
        r1.values = new ArrayList(this.values);
        r1.stepSize = this.stepSize;
        r1.hasFocus = hasFocus();
        return r1;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        updateTrackWidth(r1);
        updateHaloHotspot();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent r6) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        float r0 = r6.getX();
        float r2 = (r0 - this.trackSidePadding) / this.trackWidth;
        this.touchPosition = r2;
        float r3 = Math.max(0.0f, r2);
        this.touchPosition = r3;
        this.touchPosition = Math.min(1.0f, r3);
        int r4 = r6.getActionMasked();
        if (r4 == 0) goto L39;
        if (r4 != 1) goto L9;
        this.thumbIsPressed = false;
        MotionEvent r1 = this.lastEvent;
        if (r1 == null) goto L35;
        if (r1.getActionMasked() != 0) goto L35;
        if (Math.abs(this.lastEvent.getX() - r6.getX()) > this.scaledTouchSlop) goto L35;
        if (Math.abs(this.lastEvent.getY() - r6.getY()) > this.scaledTouchSlop) goto L35;
        if (pickActiveThumb() == false) goto L35;
        onStartTrackingTouch();
    L35:
        if (this.activeThumbIdx == (-1)) goto L37;
        snapTouchPosition();
        this.activeThumbIdx = -1;
        onStopTrackingTouch();
    L37:
        ensureLabelsRemoved();
    L38:
        invalidate();
    L46:
        setPressed(this.thumbIsPressed);
        this.lastEvent = MotionEvent.obtain(r6);
        return true;
    L9:
        if (r4 != 2) goto L46;
        if (this.thumbIsPressed == true) goto L20;
        if (isInVerticalScrollingContainer() == true) goto L16;
    L18:
        getParent().requestDisallowInterceptTouchEvent(true);
        onStartTrackingTouch();
        goto L20
    L16:
        if (Math.abs(r0 - this.touchDownX) >= this.scaledTouchSlop) goto L18;
        return false;
    L20:
        if (pickActiveThumb() == false) goto L46;
        this.thumbIsPressed = true;
        snapTouchPosition();
        updateHaloHotspot();
        goto L38
    L39:
        this.touchDownX = r0;
        if (isInVerticalScrollingContainer() == true) goto L46;
        getParent().requestDisallowInterceptTouchEvent(true);
        if (pickActiveThumb() == false) goto L46;
        requestFocus();
        this.thumbIsPressed = true;
        snapTouchPosition();
        updateHaloHotspot();
        invalidate();
        onStartTrackingTouch();
        goto L46
    }

    protected boolean pickActiveThumb() {
        if (this.activeThumbIdx == (-1)) goto L5;
        return true;
    L5:
        float r0 = getValueOfTouchPositionAbsolute();
        float r3 = valueToX(r0);
        this.activeThumbIdx = 0;
        float r5 = Math.abs(this.values.get(0).floatValue() - r0);
        int r6 = 1;
    L7:
        if (r6 >= this.values.size()) goto L34;
        float r7 = Math.abs(this.values.get(r6).floatValue() - r0);
        float r8 = valueToX(this.values.get(r6).floatValue());
        if (Float.compare(r7, r5) > 1) goto L34;
        if (isRtl() == false) goto L17;
        if ((r8 - r3) > 0.0f) goto L18;
    L19:
        boolean r9 = false;
    L21:
        if (Float.compare(r7, r5) >= 0) goto L24;
    L22:
        this.activeThumbIdx = r6;
        r5 = r7;
    L32:
        r6 = r6 + 1;
        goto L7
    L24:
        if (Float.compare(r7, r5) != 0) goto L32;
        if (Math.abs(r8 - r3) < this.scaledTouchSlop) goto L27;
        if (r9 == false) goto L32;
    L27:
        this.activeThumbIdx = -1;
        return false;
    L18:
        r9 = true;
        goto L21
    L17:
        if ((r8 - r3) >= 0.0f) goto L19;
    L34:
        if (this.activeThumbIdx == (-1)) goto L37;
        return true;
    L37:
        return false;
    }

    public void removeOnChangeListener(@NonNull L r1) {
        this.changeListeners.remove(r1);
    }

    public void removeOnSliderTouchListener(@NonNull T r1) {
        this.touchListeners.remove(r1);
    }

    protected void setActiveThumbIndex(int r1) {
        this.activeThumbIdx = r1;
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        setLayerType(r3, null);
        return;
    L5:
        r3 = 2;
        goto L6
    }

    public void setFocusedThumbIndex(int r2) {
        if (r2 < 0) goto L8;
        if (r2 >= this.values.size()) goto L8;
        this.focusedThumbIdx = r2;
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(r2);
        postInvalidate();
        return;
    L8:
        throw new IllegalArgumentException("index out of range");
    }

    public void setHaloRadius(@IntRange(from = 0) @Dimension int r2) {
        if (r2 != this.haloRadius) goto L5;
        return;
    L5:
        this.haloRadius = r2;
        Drawable r3 = getBackground();
        if (shouldDrawCompatHalo() == false) goto L8;
    L11:
        postInvalidate();
        return;
    L8:
        if ((r3 instanceof RippleDrawable) == false) goto L11;
        DrawableUtils.setRippleDrawableRadius((RippleDrawable) r3, this.haloRadius);
    }

    public void setHaloRadiusResource(@DimenRes int r2) {
        setHaloRadius(getResources().getDimensionPixelSize(r2));
    }

    public void setHaloTintList(@NonNull ColorStateList r3) {
        if (r3.equals(this.haloColor) == false) goto L5;
        return;
    L5:
        this.haloColor = r3;
        Drawable r0 = getBackground();
        if (shouldDrawCompatHalo() == false) goto L8;
    L11:
        this.haloPaint.setColor(getColorForState(r3));
        this.haloPaint.setAlpha(63);
        invalidate();
        return;
    L8:
        if ((r0 instanceof RippleDrawable) == false) goto L11;
        ((RippleDrawable) r0).setColor(r3);
    }

    public void setLabelBehavior(int r2) {
        if (this.labelBehavior == r2) goto L6;
        this.labelBehavior = r2;
        requestLayout();
        return;
    }

    public void setLabelFormatter(@Nullable LabelFormatter r1) {
        this.formatter = r1;
    }

    protected void setSeparationUnit(int r1) {
        this.separationUnit = r1;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setStepSize(float r5) {
        if (r5 < 0.0f) goto L9;
        if (this.stepSize == r5) goto L10;
        this.stepSize = r5;
        this.dirtyConfig = true;
        postInvalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, new Object[]{Float.valueOf(r5), Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)}));
    }

    public void setThumbElevation(float r1) {
        this.thumbDrawable.setElevation(r1);
    }

    public void setThumbElevationResource(@DimenRes int r2) {
        setThumbElevation(getResources().getDimension(r2));
    }

    public void setThumbRadius(@IntRange(from = 0) @Dimension int r4) {
        if (r4 != this.thumbRadius) goto L5;
        return;
    L5:
        this.thumbRadius = r4;
        maybeIncreaseTrackSidePadding();
        this.thumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, this.thumbRadius).build());
        MaterialShapeDrawable r5 = this.thumbDrawable;
        int r0 = this.thumbRadius;
        r5.setBounds(0, 0, r0 * 2, r0 * 2);
        postInvalidate();
    }

    public void setThumbRadiusResource(@DimenRes int r2) {
        setThumbRadius(getResources().getDimensionPixelSize(r2));
    }

    public void setThumbStrokeColor(@Nullable ColorStateList r2) {
        this.thumbDrawable.setStrokeColor(r2);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@ColorRes int r2) {
        if (r2 == 0) goto L5;
        setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), r2));
        return;
    }

    public void setThumbStrokeWidth(float r2) {
        this.thumbDrawable.setStrokeWidth(r2);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@DimenRes int r2) {
        if (r2 == 0) goto L5;
        setThumbStrokeWidth(getResources().getDimension(r2));
        return;
    }

    public void setThumbTintList(@NonNull ColorStateList r2) {
        if (r2.equals(this.thumbDrawable.getFillColor()) == false) goto L5;
        return;
    L5:
        this.thumbDrawable.setFillColor(r2);
        invalidate();
    }

    public void setTickActiveTintList(@NonNull ColorStateList r2) {
        if (r2.equals(this.tickColorActive) == false) goto L5;
        return;
    L5:
        this.tickColorActive = r2;
        this.activeTicksPaint.setColor(getColorForState(r2));
        invalidate();
    }

    public void setTickInactiveTintList(@NonNull ColorStateList r2) {
        if (r2.equals(this.tickColorInactive) == false) goto L5;
        return;
    L5:
        this.tickColorInactive = r2;
        this.inactiveTicksPaint.setColor(getColorForState(r2));
        invalidate();
    }

    public void setTickTintList(@NonNull ColorStateList r1) {
        setTickInactiveTintList(r1);
        setTickActiveTintList(r1);
    }

    public void setTickVisible(boolean r2) {
        if (this.tickVisible == r2) goto L6;
        this.tickVisible = r2;
        postInvalidate();
        return;
    }

    public void setTrackActiveTintList(@NonNull ColorStateList r2) {
        if (r2.equals(this.trackColorActive) == false) goto L5;
        return;
    L5:
        this.trackColorActive = r2;
        this.activeTrackPaint.setColor(getColorForState(r2));
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) @Dimension int r2) {
        if (this.trackHeight == r2) goto L6;
        this.trackHeight = r2;
        invalidateTrack();
        postInvalidate();
        return;
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList r2) {
        if (r2.equals(this.trackColorInactive) == false) goto L5;
        return;
    L5:
        this.trackColorInactive = r2;
        this.inactiveTrackPaint.setColor(getColorForState(r2));
        invalidate();
    }

    public void setTrackTintList(@NonNull ColorStateList r1) {
        setTrackInactiveTintList(r1);
        setTrackActiveTintList(r1);
    }

    public void setValueFrom(float r1) {
        this.valueFrom = r1;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValueTo(float r1) {
        this.valueTo = r1;
        this.dirtyConfig = true;
        postInvalidate();
    }

    void setValues(@NonNull List<Float> r2) {
        setValuesInternal(new ArrayList(r2));
    }

    void setValues(@NonNull Float... r2) {
        ArrayList<Float> r0 = new ArrayList();
        Collections.addAll(r0, r2);
        setValuesInternal(r0);
    }

    void updateBoundsForVirturalViewId(int r4, Rect r5) {
        int r0 = this.trackSidePadding + ((int) (normalizeValue(getValues().get(r4).floatValue()) * this.trackWidth));
        int r6 = calculateTop();
        int r3 = this.thumbRadius;
        r5.set(r0 - r3, r6 - r3, r0 + r3, r6 + r3);
    }
}
