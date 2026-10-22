package com.google.android.material.slider;

import a.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    private static final int DEF_STYLE_RES = 0;
    private static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    private static final String EXCEPTION_ILLEGAL_VALUE = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom(%s) must be smaller than valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_TO = "valueTo(%s) must be greater than valueFrom(%s)";
    private static final int HALO_ALPHA = 63;
    private static final String TAG = "BaseSlider";
    private static final double THRESHOLD = 1.0E-4d;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
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
    private MotionEvent lastEvent;
    private final int scaledTouchSlop;
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

    public class AccessibilityEventSender implements Runnable {
        final /* synthetic */ BaseSlider this$0;
        int virtualViewId;

        private AccessibilityEventSender(BaseSlider r1) {
            this.this$0 = r1;
            this.virtualViewId = -1;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.access$300(this.this$0).sendEventForVirtualView(this.virtualViewId, 4);
        }

        public void setVirtualViewId(int r1) {
            this.virtualViewId = r1;
        }

        public /* synthetic */ AccessibilityEventSender(BaseSlider r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public static class AccessibilityHelper extends ExploreByTouchHelper {
        private final BaseSlider<?, ?, ?> slider;
        Rect virtualViewBounds;

        public AccessibilityHelper(BaseSlider<?, ?, ?> r2) {
            super(r2);
            this.virtualViewBounds = new Rect();
            this.slider = r2;
        }

        @NonNull
        private String startOrEndDescription(int r2) {
            if (r2 == (this.slider.getValues().size() - 1)) goto L5;
            if (r2 == 0) goto L8;
            return "";
        L8:
            return this.slider.getContext().getString(R.string.material_slider_range_start);
        L5:
            return this.slider.getContext().getString(R.string.material_slider_range_end);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float r5, float r6) {
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
        public void getVisibleVirtualViews(List<Integer> r3) {
            int r0 = 0;
        L4:
            if (r0 >= this.slider.getValues().size()) goto L6;
            r3.add(Integer.valueOf(r0));
            r0 = r0 + 1;
            goto L4
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int r5, int r6, Bundle r7) {
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
            if (BaseSlider.access$600(this.slider, r5, r10) == false) goto L30;
            BaseSlider.access$700(this.slider);
            this.slider.postInvalidate();
            invalidateVirtualView(r5);
            return true;
        L30:
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int r6, AccessibilityNodeInfoCompat r7) {
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

    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = null;
        boolean hasFocus;
        float stepSize;
        float valueFrom;
        float valueTo;
        ArrayList<Float> values;

        static {
            CREATOR = new AnonymousClass1();
        }

        public /* synthetic */ SliderState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
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

        public SliderState(Parcelable r1) {
            super(r1);
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
    }

    public interface TooltipDrawableFactory {
        TooltipDrawable createTooltipDrawable();
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_Slider;
    }

    public BaseSlider(@NonNull Context r2) {
        this(r2, null);
    }

    public static /* synthetic */ int access$000() {
        return DEF_STYLE_RES;
    }

    public static /* synthetic */ TooltipDrawable access$100(Context r0, TypedArray r1) {
        return parseLabelDrawable(r0, r1);
    }

    public static /* synthetic */ AccessibilityHelper access$300(BaseSlider r0) {
        return r0.accessibilityHelper;
    }

    public static /* synthetic */ String access$500(BaseSlider r0, float r1) {
        return r0.formatValue(r1);
    }

    public static /* synthetic */ boolean access$600(BaseSlider r0, int r1, float r2) {
        return r0.snapThumbToValue(r1, r2);
    }

    public static /* synthetic */ void access$700(BaseSlider r0) {
        r0.updateHaloHotspot();
    }

    public static /* synthetic */ float access$800(BaseSlider r0, int r1) {
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

    private void calculateTicksCoordinates() {
        validateConfigurationIfDirty();
        int r0 = Math.min((int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f), (this.trackWidth / (this.trackHeight * 2)) + 1);
        float[] r1 = this.ticksCoordinates;
        if (r1 != null) goto L5;
    L6:
        this.ticksCoordinates = new float[r0 * 2];
    L7:
        float r2 = this.trackWidth / (r0 - 1);
        int r3 = 0;
    L9:
        if (r3 >= (r0 * 2)) goto L11;
        float[] r4 = this.ticksCoordinates;
        r4[r3] = ((r3 / 2) * r2) + this.trackSidePadding;
        r4[r3 + 1] = calculateTop();
        r3 = r3 + 2;
        goto L9
    L11:
        return;
    L5:
        if (r1.length == (r0 * 2)) goto L7;
        goto L6
    }

    private int calculateTop() {
        int r0 = this.trackTop;
        int r3 = 0;
        if (this.labelBehavior != 1) goto L6;
        r3 = this.labels.get(0).getIntrinsicHeight();
    L6:
        return r0 + r3;
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

    private void dispatchOnChangedProgramatically() {
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
        r11.drawLine((r0[0] * r14) + r1, r8, (r0[1] * r14) + r1, r8, this.activeTrackPaint);
    }

    private void drawInactiveTrack(@NonNull Canvas r12, int r13, int r14) {
        float[] r0 = getActiveRange();
        int r1 = this.trackSidePadding;
        float r4 = r13;
        float r6 = (r0[1] * r4) + r1;
        if (r6 >= (r1 + r13)) goto L5;
        float r9 = r14;
        r12.drawLine(r6, r9, r1 + r13, r9, this.inactiveTrackPaint);
    L5:
        int r15 = this.trackSidePadding;
        float r5 = (r0[0] * r4) + r15;
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
        Float r1 = r0.next();
        r6.drawCircle((normalizeValue(r1.floatValue()) * r7) + this.trackSidePadding, r8, this.thumbRadius, this.thumbPaint);
    L8:
        Iterator<Float> r2 = this.values.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        Float r3 = r2.next();
        r6.save();
        int r4 = this.trackSidePadding + ((int) (normalizeValue(r3.floatValue()) * r7));
        int r5 = this.thumbRadius;
        r6.translate(r4 - r5, r8 - r5);
        this.thumbDrawable.draw(r6);
        r6.restore();
        goto L10
    }

    private void drawTicks(@NonNull Canvas r6) {
        float[] r0 = getActiveRange();
        int r1 = pivotIndex(this.ticksCoordinates, r0[0]);
        int r2 = pivotIndex(this.ticksCoordinates, r0[1]);
        int r3 = r1 * 2;
        r6.drawPoints(this.ticksCoordinates, 0, r3, this.inactiveTicksPaint);
        int r4 = r2 * 2;
        r6.drawPoints(this.ticksCoordinates, r3, r4 - r3, this.activeTicksPaint);
        float[] r5 = this.ticksCoordinates;
        r6.drawPoints(r5, r4, r5.length - r4, this.inactiveTicksPaint);
    }

    private void ensureLabels() {
        if (this.labelBehavior != 2) goto L5;
        return;
    L5:
        Iterator<TooltipDrawable> r0 = this.labels.iterator();
        int r1 = 0;
    L7:
        if (r1 >= this.values.size()) goto L16;
        if (r0.hasNext() == false) goto L16;
        if (r1 == this.focusedThumbIdx) goto L14;
        setValueForLabel(r0.next(), this.values.get(r1).floatValue());
    L14:
        r1 = r1 + 1;
    L16:
        if (r0.hasNext() == false) goto L20;
        setValueForLabel(r0.next(), this.values.get(this.focusedThumbIdx).floatValue());
        return;
    L20:
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[]{Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size())}));
    }

    private void focusThumbOnFocusGained(int r4) {
        if (r4 != 1) goto L5;
        moveFocus(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        return;
    L5:
        if (r4 != 2) goto L7;
        moveFocus(Integer.MIN_VALUE);
        return;
    L7:
        if (r4 != 17) goto L9;
        moveFocusInAbsoluteDirection(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        return;
    L9:
        if (r4 != 66) goto L19;
        moveFocusInAbsoluteDirection(Integer.MIN_VALUE);
        return;
    }

    private String formatValue(float r2) {
        if (hasLabelFormatter() == false) goto L7;
        return this.formatter.getFormattedValue(r2);
    L7:
        if (((int) r2) != r2) goto L9;
        String r1 = "%.0f";
    L11:
        return String.format(r1, new Object[]{Float.valueOf(r2)});
    L9:
        r1 = "%.2f";
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

    private float getClampedValue(int r3, float r4) {
        int r0 = r3 + 1;
        if (r0 < this.values.size()) goto L5;
        float r1 = this.valueTo;
    L6:
        int r5 = r3 - 1;
        if (r5 >= 0) goto L9;
        float r2 = this.valueFrom;
    L11:
        return MathUtils.clamp(r4, r2, r1);
    L9:
        r2 = this.values.get(r5).floatValue();
        goto L11
    L5:
        r1 = this.values.get(r0).floatValue();
        goto L6
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
        return a.a(r1, r2, r0, r2);
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth(this.trackHeight);
        this.activeTrackPaint.setStrokeWidth(this.trackHeight);
        this.inactiveTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
        this.activeTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
    }

    private boolean isInScrollingContainer() {
        ViewParent r1 = getParent();
    L4:
        if ((r1 instanceof ViewGroup) == false) goto L10;
        if (((ViewGroup) r1).shouldDelayChildPressedState() == true) goto L7;
        r1 = r1.getParent();
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private void loadResources(@NonNull Resources r2) {
        this.widgetHeight = r2.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        this.trackSidePadding = r2.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.trackTop = r2.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
        this.labelPadding = r2.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
    }

    private void maybeDrawHalo(@NonNull Canvas r4, int r5, int r6) {
        if (shouldDrawCompatHalo() == false) goto L6;
        r4.drawCircle((int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * r5) + this.trackSidePadding), r6, this.haloRadius, this.haloPaint);
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
        r2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
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

    private Boolean onKeyDownNoActiveThumb(int r4, @NonNull KeyEvent r5) {
        if (r4 == 61) goto L26;
        if (r4 != 66) goto L7;
    L23:
        this.activeThumbIdx = this.focusedThumbIdx;
        postInvalidate();
        return Boolean.TRUE;
    L7:
        if (r4 != 81) goto L9;
    L21:
        moveFocus(1);
        return Boolean.TRUE;
    L9:
        if (r4 != 69) goto L11;
        moveFocus(-1);
        return Boolean.TRUE;
    L11:
        if (r4 == 70) goto L21;
        switch(r4) {
            case 21: goto L17;
            case 22: goto L15;
            case 23: goto L23;
            default: goto L13;
        };
    L13:
        return null;
    L15:
        moveFocusInAbsoluteDirection(1);
        return Boolean.TRUE;
    L17:
        moveFocusInAbsoluteDirection(-1);
        return Boolean.TRUE;
    L26:
        if (r5.hasNoModifiers() == false) goto L30;
        return Boolean.valueOf(moveFocus(1));
    L30:
        if (r5.isShiftPressed() == false) goto L34;
        return Boolean.valueOf(moveFocus(-1));
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
        boolean r12 = r11.hasValue(R.styleable.Slider_trackColor);
        if (r12 == false) goto L5;
        int r1 = R.styleable.Slider_trackColor;
    L6:
        if (r12 == false) goto L8;
        int r13 = R.styleable.Slider_trackColor;
    L9:
        ColorStateList r2 = MaterialResources.getColorStateList(r8, r11, r1);
        if (r2 != null) goto L13;
        r2 = AppCompatResources.getColorStateList(r8, R.color.material_slider_inactive_track_color);
    L13:
        setTrackInactiveTintList(r2);
        ColorStateList r14 = MaterialResources.getColorStateList(r8, r11, r13);
        if (r14 != null) goto L17;
        r14 = AppCompatResources.getColorStateList(r8, R.color.material_slider_active_track_color);
    L17:
        setTrackActiveTintList(r14);
        ColorStateList r15 = MaterialResources.getColorStateList(r8, r11, R.styleable.Slider_thumbColor);
        this.thumbDrawable.setFillColor(r15);
        ColorStateList r16 = MaterialResources.getColorStateList(r8, r11, R.styleable.Slider_haloColor);
        if (r16 != null) goto L21;
        r16 = AppCompatResources.getColorStateList(r8, R.color.material_slider_halo_color);
    L21:
        setHaloTintList(r16);
        boolean r17 = r11.hasValue(R.styleable.Slider_tickColor);
        if (r17 == false) goto L24;
        int r3 = R.styleable.Slider_tickColor;
    L25:
        if (r17 == false) goto L27;
        int r18 = R.styleable.Slider_tickColor;
    L28:
        ColorStateList r4 = MaterialResources.getColorStateList(r8, r11, r3);
        if (r4 != null) goto L32;
        r4 = AppCompatResources.getColorStateList(r8, R.color.material_slider_inactive_tick_marks_color);
    L32:
        setTickInactiveTintList(r4);
        ColorStateList r19 = MaterialResources.getColorStateList(r8, r11, r18);
        if (r19 != null) goto L36;
        r19 = AppCompatResources.getColorStateList(r8, R.color.material_slider_active_tick_marks_color);
    L36:
        setTickActiveTintList(r19);
        setThumbRadius(r11.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(r11.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(r11.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(r11.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        this.labelBehavior = r11.getInt(R.styleable.Slider_labelBehavior, 0);
        r11.recycle();
        return;
    L27:
        r18 = R.styleable.Slider_tickColorActive;
        goto L28
    L24:
        r3 = R.styleable.Slider_tickColorInactive;
        goto L25
    L8:
        r13 = R.styleable.Slider_trackColorActive;
        goto L9
    L5:
        r1 = R.styleable.Slider_trackColorInactive;
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
        dispatchOnChangedProgramatically();
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
    L8:
        return true;
    L5:
        if ((getBackground() instanceof RippleDrawable) == false) goto L8;
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
        if (Math.abs(r6 - this.values.get(r5).floatValue()) >= THRESHOLD) goto L6;
        return false;
    L6:
        this.values.set(r5, Float.valueOf(getClampedValue(r5, r6)));
        this.focusedThumbIdx = r5;
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

    private void validateConfigurationIfDirty() {
        if (this.dirtyConfig == false) goto L6;
        validateValueFrom();
        validateValueTo();
        validateStepSize();
        validateValues();
        this.dirtyConfig = false;
        return;
    }

    private void validateStepSize() {
        float r0 = this.stepSize;
        if (r0 > 0.0f) goto L5;
        return;
    L5:
        if ((((this.valueTo - this.valueFrom) / r0) % 1.0f) <= THRESHOLD) goto L10;
        String r1 = Float.toString(this.stepSize);
        String r2 = Float.toString(this.valueFrom);
        String r5 = Float.toString(this.valueTo);
        StringBuilder r3 = new StringBuilder("The stepSize(");
        r3.append(r1);
        r3.append(") must be 0, or a factor of the valueFrom(");
        r3.append(r2);
        r3.append(")-valueTo(");
        throw new IllegalStateException(a.o(r3, r5, ") range"));
    }

    private void validateValueFrom() {
        if (this.valueFrom >= this.valueTo) goto L6;
        return;
    L6:
        throw new IllegalStateException("valueFrom(" + Float.toString(this.valueFrom) + ") must be smaller than valueTo(" + Float.toString(this.valueTo) + ")");
    }

    private void validateValueTo() {
        if (this.valueTo <= this.valueFrom) goto L6;
        return;
    L6:
        throw new IllegalStateException("valueTo(" + Float.toString(this.valueTo) + ") must be greater than valueFrom(" + Float.toString(this.valueFrom) + ")");
    }

    private void validateValues() {
        Iterator<Float> r0 = this.values.iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        Float r1 = r0.next();
        if (r1.floatValue() < this.valueFrom) goto L16;
        if (r1.floatValue() > this.valueTo) goto L16;
        if (this.stepSize <= 0.0f) goto L4;
        if ((((this.valueFrom - r1.floatValue()) / this.stepSize) % 1.0f) <= THRESHOLD) goto L4;
        throw new IllegalStateException("Value(" + Float.toString(r1.floatValue()) + ") must be equal to valueFrom(" + Float.toString(this.valueFrom) + ") plus a multiple of stepSize(" + Float.toString(this.stepSize) + ") when using stepSize(" + Float.toString(this.stepSize) + ")");
    L16:
        String r2 = Float.toString(r1.floatValue());
        String r3 = Float.toString(this.valueFrom);
        String r8 = Float.toString(this.valueTo);
        StringBuilder r4 = new StringBuilder("Slider value(");
        r4.append(r2);
        r4.append(") must be greater or equal to valueFrom(");
        r4.append(r3);
        r4.append("), and lower or equal to valueTo(");
        throw new IllegalStateException(a.o(r4, r8, ")"));
    }

    private float valueToX(float r2) {
        return (normalizeValue(r2) * this.trackWidth) + this.trackSidePadding;
    }

    public void addOnChangeListener(@Nullable L r1) {
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
    public void drawableStateChanged() {
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
    public void forceDrawCompatHalo(boolean r1) {
        this.forceDrawCompatHalo = r1;
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
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
    public List<Float> getValues() {
        return new ArrayList(this.values);
    }

    public boolean hasLabelFormatter() {
        if (this.formatter == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isRtl() {
        if (ViewCompat.getLayoutDirection(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<TooltipDrawable> r0 = this.labels.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        attachLabelToContentView(r0.next());
        goto L4
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.AccessibilityEventSender r0 = this.accessibilityEventSender;
        if (r0 == null) goto L5;
        removeCallbacks(r0);
    L5:
        Iterator<TooltipDrawable> r1 = this.labels.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        detachLabelFromContentView(r1.next());
        goto L7
    L9:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas r5) {
        if (this.dirtyConfig == false) goto L7;
        validateConfigurationIfDirty();
        if (this.stepSize <= 0.0f) goto L7;
        calculateTicksCoordinates();
    L7:
        super.onDraw(r5);
        int r0 = calculateTop();
        drawInactiveTrack(r5, this.trackWidth, r0);
        if (((Float) Collections.max(getValues())).floatValue() <= this.valueFrom) goto L11;
        drawActiveTrack(r5, this.trackWidth, r0);
    L11:
        if (this.stepSize <= 0.0f) goto L14;
        drawTicks(r5);
    L14:
        if (this.thumbIsPressed == true) goto L18;
        if (isFocused() == true) goto L18;
    L22:
        drawThumbs(r5, this.trackWidth, r0);
        return;
    L18:
        if (isEnabled() == false) goto L22;
        maybeDrawHalo(r5, this.trackWidth, r0);
        if (this.activeThumbIdx == (-1)) goto L22;
        ensureLabels();
        goto L22
    }

    @Override // android.view.View
    public void onFocusChanged(boolean r1, int r2, @Nullable Rect r3) {
        super.onFocusChanged(r1, r2, r3);
        if (r1 == true) goto L9;
        this.activeThumbIdx = -1;
        Iterator<TooltipDrawable> r4 = this.labels.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        TooltipDrawable r5 = r4.next();
        ViewUtils.getContentViewOverlay(this).remove(r5);
        goto L6
    L8:
        this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
        return;
    L9:
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
        if (snapActiveThumbToValue(r1.floatValue() + this.values.get(this.activeThumbIdx).floatValue()) == false) goto L21;
        updateHaloHotspot();
        postInvalidate();
    L21:
        return true;
    L23:
        if (r6 != 23) goto L25;
    L39:
        this.activeThumbIdx = -1;
        Iterator<TooltipDrawable> r8 = this.labels.iterator();
    L41:
        if (r8.hasNext() == false) goto L43;
        ViewUtils.getContentViewOverlay(this).remove(r8.next());
        goto L41
    L43:
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
    public void onMeasure(int r4, int r5) {
        int r6 = this.widgetHeight;
        int r2 = 0;
        if (this.labelBehavior != 1) goto L5;
        r2 = this.labels.get(0).getIntrinsicHeight();
    L5:
        super.onMeasure(r4, View.MeasureSpec.makeMeasureSpec(r6 + r2, BasicMeasure.EXACTLY));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r2) {
        SliderState r3 = (SliderState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        this.valueFrom = r3.valueFrom;
        this.valueTo = r3.valueTo;
        setValuesInternal(r3.values);
        this.stepSize = r3.stepSize;
        if (r3.hasFocus == false) goto L5;
        requestFocus();
    L5:
        dispatchOnChangedProgramatically();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState r1 = new SliderState(super.onSaveInstanceState());
        r1.valueFrom = this.valueFrom;
        r1.valueTo = this.valueTo;
        r1.values = new ArrayList(this.values);
        r1.stepSize = this.stepSize;
        r1.hasFocus = hasFocus();
        return r1;
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        this.trackWidth = Math.max(r1 - (this.trackSidePadding * 2), 0);
        if (this.stepSize <= 0.0f) goto L5;
        calculateTicksCoordinates();
    L5:
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
        if (r4 == 0) goto L38;
        if (r4 != 1) goto L9;
        this.thumbIsPressed = false;
        MotionEvent r1 = this.lastEvent;
        if (r1 == null) goto L31;
        if (r1.getActionMasked() != 0) goto L31;
        if (Math.abs(this.lastEvent.getX() - r6.getX()) > this.scaledTouchSlop) goto L31;
        if (Math.abs(this.lastEvent.getY() - r6.getY()) > this.scaledTouchSlop) goto L31;
        pickActiveThumb();
    L31:
        if (this.activeThumbIdx == (-1)) goto L33;
        snapTouchPosition();
        this.activeThumbIdx = -1;
    L33:
        Iterator<TooltipDrawable> r5 = this.labels.iterator();
    L35:
        if (r5.hasNext() == false) goto L37;
        ViewUtils.getContentViewOverlay(this).remove(r5.next());
        goto L35
    L37:
        onStopTrackingTouch();
        invalidate();
    L45:
        setPressed(this.thumbIsPressed);
        this.lastEvent = MotionEvent.obtain(r6);
        return true;
    L9:
        if (r4 != 2) goto L45;
        if (this.thumbIsPressed == true) goto L18;
        if (Math.abs(r0 - this.touchDownX) >= this.scaledTouchSlop) goto L16;
        return false;
    L16:
        getParent().requestDisallowInterceptTouchEvent(true);
        onStartTrackingTouch();
    L18:
        if (pickActiveThumb() == false) goto L45;
        this.thumbIsPressed = true;
        snapTouchPosition();
        updateHaloHotspot();
        invalidate();
        goto L45
    L38:
        this.touchDownX = r0;
        if (isInScrollingContainer() == true) goto L45;
        getParent().requestDisallowInterceptTouchEvent(true);
        if (pickActiveThumb() == false) goto L45;
        requestFocus();
        this.thumbIsPressed = true;
        snapTouchPosition();
        updateHaloHotspot();
        invalidate();
        onStartTrackingTouch();
        goto L45
    }

    public boolean pickActiveThumb() {
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
        if (isRtl() == false) goto L18;
        if ((r8 - r3) <= 0.0f) goto L16;
    L15:
        boolean r9 = true;
    L21:
        if (Float.compare(r7, r5) >= 0) goto L24;
        this.activeThumbIdx = r6;
    L31:
        r5 = r7;
    L32:
        r6 = r6 + 1;
        goto L7
    L24:
        if (Float.compare(r7, r5) != 0) goto L32;
        if (Math.abs(r8 - r3) < this.scaledTouchSlop) goto L27;
        if (r9 == false) goto L32;
        this.activeThumbIdx = r6;
        goto L31
    L27:
        this.activeThumbIdx = -1;
        return false;
    L16:
        r9 = false;
        goto L21
    L18:
        if ((r8 - r3) >= 0.0f) goto L16;
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

    public void setActiveThumbIndex(int r1) {
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

    public void setStepSize(float r5) {
        if (r5 >= 0.0f) goto L5;
        String r6 = Float.toString(r5);
        String r1 = Float.toString(this.valueFrom);
        String r4 = Float.toString(this.valueTo);
        StringBuilder r2 = new StringBuilder("The stepSize(");
        r2.append(r6);
        r2.append(") must be 0, or a factor of the valueFrom(");
        r2.append(r1);
        r2.append(")-valueTo(");
        throw new IllegalArgumentException(a.o(r2, r4, ") range"));
    L5:
        if (this.stepSize == r5) goto L10;
        this.stepSize = r5;
        this.dirtyConfig = true;
        postInvalidate();
        return;
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
        this.thumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, this.thumbRadius).build());
        MaterialShapeDrawable r5 = this.thumbDrawable;
        int r0 = this.thumbRadius;
        r5.setBounds(0, 0, r0 * 2, r0 * 2);
        postInvalidate();
    }

    public void setThumbRadiusResource(@DimenRes int r2) {
        setThumbRadius(getResources().getDimensionPixelSize(r2));
    }

    public void setThumbTintList(@NonNull ColorStateList r1) {
        this.thumbDrawable.setFillColor(r1);
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

    public void setValues(@NonNull Float... r2) {
        ArrayList<Float> r0 = new ArrayList();
        Collections.addAll(r0, r2);
        setValuesInternal(r0);
    }

    public void updateBoundsForVirturalViewId(int r4, Rect r5) {
        int r0 = this.trackSidePadding + ((int) (normalizeValue(getValues().get(r4).floatValue()) * this.trackWidth));
        int r6 = calculateTop();
        int r3 = this.thumbRadius;
        r5.set(r0 - r3, r6 - r3, r0 + r3, r6 + r3);
    }

    public BaseSlider(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.sliderStyle);
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

    public BaseSlider(@NonNull Context r9, @Nullable final AttributeSet r10, final int r11) {
        super(MaterialThemeOverlay.wrap(r9, r10, r11, DEF_STYLE_RES), r10, r11);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.thumbIsPressed = false;
        this.values = new ArrayList();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.isLongPress = false;
        MaterialShapeDrawable r12 = new MaterialShapeDrawable();
        this.thumbDrawable = r12;
        Context r0 = getContext();
        Paint r1 = new Paint();
        this.inactiveTrackPaint = r1;
        Paint.Style r2 = Paint.Style.STROKE;
        r1.setStyle(r2);
        Paint.Cap r3 = Paint.Cap.ROUND;
        r1.setStrokeCap(r3);
        Paint r4 = new Paint();
        this.activeTrackPaint = r4;
        r4.setStyle(r2);
        r4.setStrokeCap(r3);
        Paint r5 = new Paint(1);
        this.thumbPaint = r5;
        Paint.Style r6 = Paint.Style.FILL;
        r5.setStyle(r6);
        r5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint r7 = new Paint(1);
        this.haloPaint = r7;
        r7.setStyle(r6);
        Paint r8 = new Paint();
        this.inactiveTicksPaint = r8;
        r8.setStyle(r2);
        r8.setStrokeCap(r3);
        Paint r13 = new Paint();
        this.activeTicksPaint = r13;
        r13.setStyle(r2);
        r13.setStrokeCap(r3);
        loadResources(r0.getResources());
        this.labelMaker = new AnonymousClass1(this, r10, r11);
        processAttributes(r0, r10, r11);
        setFocusable(true);
        setClickable(true);
        r12.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(r0).getScaledTouchSlop();
        AccessibilityHelper r14 = new AccessibilityHelper(this);
        this.accessibilityHelper = r14;
        ViewCompat.setAccessibilityDelegate(this, r14);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public void setValues(@NonNull List<Float> r2) {
        setValuesInternal(new ArrayList(r2));
    }
}
