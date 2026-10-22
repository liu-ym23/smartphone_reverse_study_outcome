package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.OnRotateListener {
    private static final float EPSILON = 0.001f;
    private static final int INITIAL_CAPACITY = 12;
    private static final String VALUE_PLACEHOLDER = "";
    private final int clockHandPadding;
    private final ClockHandView clockHandView;
    private final int clockSize;
    private float currentHandRotation;
    private final int[] gradientColors;
    private final float[] gradientPositions;
    private final int minimumHeight;
    private final int minimumWidth;
    private final RectF scratch;
    private final ColorStateList textColor;
    private final SparseArray<TextView> textViewPool;
    private final Rect textViewRect;
    private final AccessibilityDelegateCompat valueAccessibilityDelegate;
    private String[] values;

    static /* synthetic */ ClockHandView access$000(ClockFaceView r0) {
        return r0.clockHandView;
    }

    static /* synthetic */ int access$100(ClockFaceView r0) {
        return r0.clockHandPadding;
    }

    static /* synthetic */ SparseArray access$200(ClockFaceView r0) {
        return r0.textViewPool;
    }

    public ClockFaceView(Context r2) {
        this(r2, null);
    }

    public ClockFaceView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.materialClockStyle);
    }

    public ClockFaceView(Context r8, AttributeSet r9, int r10) {
        super(r8, r9, r10);
        this.textViewRect = new Rect();
        this.scratch = new RectF();
        this.textViewPool = new SparseArray();
        this.gradientPositions = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray r11 = r8.obtainStyledAttributes(r9, R.styleable.ClockFaceView, r10, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources r12 = getResources();
        ColorStateList r1 = MaterialResources.getColorStateList(r8, r11, R.styleable.ClockFaceView_clockNumberTextColor);
        this.textColor = r1;
        LayoutInflater.from(r8).inflate(R.layout.material_clockface_view, this, true);
        ClockHandView r2 = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.clockHandView = r2;
        this.clockHandPadding = r12.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int r3 = r1.getColorForState(new int[]{android.R.attr.state_selected}, r1.getDefaultColor());
        this.gradientColors = new int[]{r3, r3, r1.getDefaultColor()};
        r2.addOnRotateListener(this);
        int r0 = AppCompatResources.getColorStateList(r8, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList r13 = MaterialResources.getColorStateList(r8, r11, R.styleable.ClockFaceView_clockFaceBackgroundColor);
        if (r13 == null) goto L6;
        r0 = r13.getDefaultColor();
    L6:
        setBackgroundColor(r0);
        getViewTreeObserver().addOnPreDrawListener(new AnonymousClass1(this));
        setFocusable(true);
        r11.recycle();
        this.valueAccessibilityDelegate = new AnonymousClass2(this);
        String[] r14 = new String[12];
        Arrays.fill(r14, "");
        setValues(r14, 0);
        this.minimumHeight = r12.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.minimumWidth = r12.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.clockSize = r12.getDimensionPixelSize(R.dimen.material_clock_size);
    }

    public void setValues(String[] r1, int r2) {
        this.values = r1;
        updateTextViews(r2);
    }

    private void updateTextViews(int r9) {
        LayoutInflater r0 = LayoutInflater.from(getContext());
        int r1 = this.textViewPool.size();
        int r3 = 0;
    L4:
        if (r3 >= Math.max(this.values.length, r1)) goto L14;
        TextView r4 = this.textViewPool.get(r3);
        if (r3 < this.values.length) goto L8;
        removeView(r4);
        this.textViewPool.remove(r3);
    L13:
        r3 = r3 + 1;
        goto L4
    L8:
        if (r4 != null) goto L10;
        r4 = (TextView) r0.inflate(R.layout.material_clockface_textview, this, false);
        this.textViewPool.put(r3, r4);
        addView(r4);
    L10:
        r4.setVisibility(0);
        r4.setText(this.values[r3]);
        r4.setTag(R.id.material_value_index, Integer.valueOf(r3));
        ViewCompat.setAccessibilityDelegate(r4, this.valueAccessibilityDelegate);
        r4.setTextColor(this.textColor);
        if (r9 == 0) goto L13;
        r4.setContentDescription(getResources().getString(r9, new Object[]{this.values[r3]}));
        goto L13
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r3) {
        super.onInitializeAccessibilityNodeInfo(r3);
        AccessibilityNodeInfoCompat.wrap(r3).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.values.length, false, 1));
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void setRadius(int r2) {
        if (r2 == getRadius()) goto L6;
        super.setRadius(r2);
        this.clockHandView.setCircleRadius(getRadius());
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        findIntersectingTextView();
    }

    public void setHandRotation(float r2) {
        this.clockHandView.setHandRotation(r2);
        findIntersectingTextView();
    }

    private void findIntersectingTextView() {
        RectF r0 = this.clockHandView.getCurrentSelectorBox();
        int r1 = 0;
    L4:
        if (r1 >= this.textViewPool.size()) goto L10;
        TextView r2 = this.textViewPool.get(r1);
        if (r2 == null) goto L9;
        r2.getDrawingRect(this.textViewRect);
        offsetDescendantRectToMyCoords(r2, this.textViewRect);
        r2.setSelected(r0.contains(this.textViewRect.centerX(), this.textViewRect.centerY()));
        r2.getPaint().setShader(getGradientForTextView(r0, this.textViewRect, r2));
        r2.invalidate();
    L9:
        r1 = r1 + 1;
        goto L4
    }

    private RadialGradient getGradientForTextView(RectF r8, Rect r9, TextView r10) {
        this.scratch.set(r9);
        this.scratch.offset(r10.getPaddingLeft(), r10.getPaddingTop());
        if (RectF.intersects(r8, this.scratch) == true) goto L7;
        return null;
    L7:
        return new RadialGradient(r8.centerX() - this.scratch.left, r8.centerY() - this.scratch.top, r8.width() * 0.5f, this.gradientColors, this.gradientPositions, Shader.TileMode.CLAMP);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float r2, boolean r3) {
        if (Math.abs(this.currentHandRotation - r2) <= 0.001f) goto L6;
        this.currentHandRotation = r2;
        findIntersectingTextView();
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r3, int r4) {
        DisplayMetrics r5 = getResources().getDisplayMetrics();
        int r6 = (int) (this.clockSize / max3(this.minimumHeight / r5.heightPixels, this.minimumWidth / r5.widthPixels, 1.0f));
        int r7 = View.MeasureSpec.makeMeasureSpec(r6, 1073741824);
        setMeasuredDimension(r6, r6);
        super.onMeasure(r7, r7);
    }

    private static float max3(float r0, float r1, float r2) {
        return Math.max(Math.max(r0, r1), r2);
    }
}
