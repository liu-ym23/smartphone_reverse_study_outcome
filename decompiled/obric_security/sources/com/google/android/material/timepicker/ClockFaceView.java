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
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.OnRotateListener {
    private static final float EPSILON = 0.001f;
    private static final int INITIAL_CAPACITY = 12;
    private static final String VALUE_PLACEHOLDER = "";
    private final int clockHandPadding;
    private final ClockHandView clockHandView;
    private float currentHandRotation;
    private final int[] gradientColors;
    private final float[] gradientPositions;
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

    public ClockFaceView(Context r7, AttributeSet r8, int r9) {
        super(r7, r8, r9);
        this.textViewRect = new Rect();
        this.scratch = new RectF();
        this.textViewPool = new SparseArray();
        this.gradientPositions = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray r10 = r7.obtainStyledAttributes(r8, R.styleable.ClockFaceView, r9, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources r11 = getResources();
        ColorStateList r1 = MaterialResources.getColorStateList(r7, r10, R.styleable.ClockFaceView_clockNumberTextColor);
        this.textColor = r1;
        LayoutInflater.from(r7).inflate(R.layout.material_clockface_view, this, true);
        ClockHandView r2 = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.clockHandView = r2;
        this.clockHandPadding = r11.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int r12 = r1.getColorForState(new int[]{android.R.attr.state_selected}, r1.getDefaultColor());
        this.gradientColors = new int[]{r12, r12, r1.getDefaultColor()};
        r2.addOnRotateListener(this);
        int r13 = AppCompatResources.getColorStateList(r7, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList r14 = MaterialResources.getColorStateList(r7, r10, R.styleable.ClockFaceView_clockFaceBackgroundColor);
        if (r14 == null) goto L6;
        r13 = r14.getDefaultColor();
    L6:
        setBackgroundColor(r13);
        getViewTreeObserver().addOnPreDrawListener(new AnonymousClass1(this));
        setFocusable(true);
        r10.recycle();
        this.valueAccessibilityDelegate = new AnonymousClass2(this);
        String[] r15 = new String[12];
        Arrays.fill(r15, "");
        setValues(r15, 0);
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
        this.textViewRect.offset(r2.getPaddingLeft(), r2.getPaddingTop());
        offsetDescendantRectToMyCoords(r2, this.textViewRect);
        this.scratch.set(this.textViewRect);
        RadialGradient r3 = getGradientForTextView(r0, this.scratch);
        r2.getPaint().setShader(r3);
        r2.invalidate();
    L9:
        r1 = r1 + 1;
        goto L4
    }

    private RadialGradient getGradientForTextView(RectF r8, RectF r9) {
        if (RectF.intersects(r8, r9) == true) goto L7;
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
}
