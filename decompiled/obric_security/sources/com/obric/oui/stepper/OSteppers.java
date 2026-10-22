package com.obric.oui.stepper;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.haptic.VibratorSmt;
import com.obric.oui.layout.OUIConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSteppers.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 92\u00020\u0001:\u00029:B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020\rJ\u0006\u0010%\u001a\u00020\rJ\u0006\u0010&\u001a\u00020\rJ\u0006\u0010'\u001a\u00020\rJ0\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\rH\u0014J\u0018\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\rH\u0014J\b\u00102\u001a\u00020!H\u0002J\b\u00103\u001a\u00020!H\u0002J\b\u00104\u001a\u00020!H\u0002J\u000e\u00105\u001a\u00020!2\u0006\u0010\f\u001a\u00020\rJ\u000e\u00106\u001a\u00020!2\u0006\u0010\f\u001a\u00020\rJ\u000e\u00107\u001a\u00020!2\u0006\u0010\f\u001a\u00020\rJ\u000e\u00108\u001a\u00020!2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0014\u0010\u0010R\u001e\u0010\u0015\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/obric/oui/stepper/OSteppers;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addContainerView", "Landroid/view/ViewGroup;", "decContainerView", "etCounter", "Landroid/widget/EditText;", "value", "", "mMaxValue", "setMMaxValue", "(I)V", "mMinValue", "setMMinValue", "mStepValue", "setMStepValue", "mValue", "setMValue", "onValueChangeListener", "Lcom/obric/oui/stepper/OSteppers$OnValueChangeListener;", "getOnValueChangeListener", "()Lcom/obric/oui/stepper/OSteppers$OnValueChangeListener;", "setOnValueChangeListener", "(Lcom/obric/oui/stepper/OSteppers$OnValueChangeListener;)V", "tvAdd", "Lcom/obric/oui/button/OButton;", "tvDec", "checkCounter", "", "clearFocus", "expandTouchHeight", "touchableHeight", "getMaxValue", "getMinValue", "getValue", "onLayout", "changed", "", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshCounter", "registerEvent", "registerInputFilter", "setMaxValue", "setMinValue", "setStepValue", "setValue", "Companion", "OnValueChangeListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSteppers extends OUIConstraintLayout {
    public static final Companion Companion = null;
    public static final int NUMBER_SIZE = 13;
    public static final int STEP = 1;
    public static final double TEXT_STROKE_WIDTH = 1.5d;
    private final ViewGroup addContainerView;
    private final ViewGroup decContainerView;
    private final EditText etCounter;
    private int mMaxValue;
    private int mMinValue;
    private int mStepValue;
    private int mValue;
    private OnValueChangeListener onValueChangeListener;
    private final OButton tvAdd;
    private final OButton tvDec;

    /* JADX INFO: compiled from: OSteppers.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/oui/stepper/OSteppers$Companion;", "", "()V", "NUMBER_SIZE", "", "STEP", "TEXT_STROKE_WIDTH", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OSteppers.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/oui/stepper/OSteppers$OnValueChangeListener;", "", "onInputBeyondLimit", "", "input", "", "onTryToExceedMaximum", "onTryToExceedMinimum", "onValueChange", "oldValue", "newValue", "onValueEmpty", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnValueChangeListener {

        /* JADX INFO: compiled from: OSteppers.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onInputBeyondLimit(OnValueChangeListener r0, int r1) {
                Intrinsics.checkNotNullParameter(r0, "this");
            }

            public static void onTryToExceedMaximum(OnValueChangeListener r1) {
                Intrinsics.checkNotNullParameter(r1, "this");
            }

            public static void onTryToExceedMinimum(OnValueChangeListener r1) {
                Intrinsics.checkNotNullParameter(r1, "this");
            }

            public static void onValueEmpty(OnValueChangeListener r1) {
                Intrinsics.checkNotNullParameter(r1, "this");
            }
        }

        void onInputBeyondLimit(int r1);

        void onTryToExceedMaximum();

        void onTryToExceedMinimum();

        void onValueChange(int r1, int r2);

        void onValueEmpty();
    }

    public static /* synthetic */ void $r8$lambda$FEXxyf6GhKLyMIUXnSW6PuJorPU(OSteppers r0, View r1) {
        m540registerEvent$lambda3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$FZLArISMxlA3RPflFS1f3RjaPCc(OSteppers r0, View r1) {
        m541registerEvent$lambda4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$K73YMD5GyDx5Fpa6c5sCLw4_hcY(OSteppers r0, View r1) {
        m538registerEvent$lambda1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$X-xBTJCISIBcTJwteteqL3SWaC8, reason: not valid java name */
    public static /* synthetic */ void m537$r8$lambda$XxBTJCISIBcTJwteteqL3SWaC8(OSteppers r0, int r1) {
        m542registerInputFilter$lambda5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$XexZo2eSlDcJfGqQZfF2Xb1EWho(OSteppers r0, View r1) {
        m539registerEvent$lambda2(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OSteppers(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OSteppers(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ void access$checkCounter(OSteppers r0) {
        r0.checkCounter();
    }

    public static final /* synthetic */ void access$setMValue(OSteppers r0, int r1) {
        r0.setMValue(r1);
    }

    public OSteppers(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, 0, null, 12, null);
        this.mMaxValue = 100;
        this.mStepValue = 1;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        LayoutInflater.from(r9).inflate(R.layout.o_widget_steppers, this);
        View r1 = findViewById(R.id.tv_add);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.tv_add)");
        this.tvAdd = (OButton) r1;
        View r2 = findViewById(R.id.tv_dec);
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.tv_dec)");
        this.tvDec = (OButton) r2;
        View r3 = findViewById(R.id.et_counter);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.et_counter)");
        this.etCounter = (EditText) r3;
        View r4 = findViewById(R.id.increase_container);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.increase_container)");
        this.addContainerView = (ViewGroup) r4;
        View r5 = findViewById(R.id.decrease_container);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.decrease_container)");
        this.decContainerView = (ViewGroup) r5;
        TypedArray r11 = r9.obtainStyledAttributes(r10, R.styleable.OSteppers, 0, 0);
        setMValue(r11.getInt(R.styleable.OSteppers_oui_stepper_value, 0));
        setMMinValue(r11.getInt(R.styleable.OSteppers_oui_min_value, Integer.MIN_VALUE));
        setMMaxValue(r11.getInt(R.styleable.OSteppers_oui_max_value, Integer.MAX_VALUE));
        setMStepValue(r11.getInt(R.styleable.OSteppers_oui_step, 1));
        r11.recycle();
        OSteppers r12 = this;
        int r0 = OUnitExtensionKt.vdp(r12, 4);
        r12.setPadding(r0, r0, r0, r0);
        setRadius(r9.getResources().getDimensionPixelSize(R.dimen.oui_r_m2_rect));
        setBackgroundResource(R.color.oui_fill_sunken_variable);
        registerEvent();
        refreshCounter();
    }

    public final OnValueChangeListener getOnValueChangeListener() {
        return this.onValueChangeListener;
    }

    public final void setOnValueChangeListener(OnValueChangeListener r1) {
        this.onValueChangeListener = r1;
    }

    private final void setMValue(int r2) {
        if (this.mValue != r2) goto L5;
        return;
    L5:
        this.mValue = r2;
        OnValueChangeListener r0 = this.onValueChangeListener;
        if (r0 == null) goto L9;
        r0.onValueChange(r2, r2);
    L9:
        refreshCounter();
    }

    private final void setMMinValue(int r1) {
        this.mMinValue = r1;
        registerInputFilter();
        refreshCounter();
    }

    private final void setMMaxValue(int r1) {
        this.mMaxValue = r1;
        registerInputFilter();
        refreshCounter();
    }

    private final void setMStepValue(int r1) {
        this.mStepValue = r1;
        refreshCounter();
    }

    private final void registerEvent() {
        this.tvAdd.setOnClickListener(new OSteppers$$ExternalSyntheticLambda0(this));
        this.tvDec.setOnClickListener(new OSteppers$$ExternalSyntheticLambda1(this));
        this.addContainerView.setOnClickListener(new OSteppers$$ExternalSyntheticLambda2(this));
        this.decContainerView.setOnClickListener(new OSteppers$$ExternalSyntheticLambda3(this));
        this.etCounter.addTextChangedListener(new AnonymousClass5(this));
    }

    /* JADX INFO: renamed from: registerEvent$lambda-1, reason: not valid java name */
    private static final void m538registerEvent$lambda1(OSteppers r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        int r3 = r1.mValue + r1.mStepValue;
        if (r3 >= r1.mMinValue) goto L5;
        return;
    L5:
        if (r3 > r1.mMaxValue) goto L10;
        r1.setMValue(r3);
        r1.etCounter.clearFocus();
        VibratorSmt.vibrateEffectWithHapticPlayer(r1.getContext(), 3);
        return;
    }

    /* JADX INFO: renamed from: registerEvent$lambda-2, reason: not valid java name */
    private static final void m539registerEvent$lambda2(OSteppers r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        int r3 = r1.mValue - r1.mStepValue;
        if (r3 >= r1.mMinValue) goto L5;
        return;
    L5:
        if (r3 > r1.mMaxValue) goto L10;
        r1.setMValue(r3);
        r1.etCounter.clearFocus();
        VibratorSmt.vibrateEffectWithHapticPlayer(r1.getContext(), 3);
        return;
    }

    /* JADX INFO: renamed from: registerEvent$lambda-3, reason: not valid java name */
    private static final void m540registerEvent$lambda3(OSteppers r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OnValueChangeListener r2 = r0.onValueChangeListener;
        if (r2 == null) goto L7;
        r2.onTryToExceedMaximum();
        return;
    }

    /* JADX INFO: renamed from: registerEvent$lambda-4, reason: not valid java name */
    private static final void m541registerEvent$lambda4(OSteppers r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OnValueChangeListener r2 = r0.onValueChangeListener;
        if (r2 == null) goto L7;
        r2.onTryToExceedMinimum();
        return;
    }

    private final void registerInputFilter() {
        this.etCounter.setFilters(new InputFilterMinMax[]{new InputFilterMinMax(this.mMinValue, this.mMaxValue, new OSteppers$$ExternalSyntheticLambda4(this))});
    }

    /* JADX INFO: renamed from: registerInputFilter$lambda-5, reason: not valid java name */
    private static final void m542registerInputFilter$lambda5(OSteppers r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        OnValueChangeListener r3 = r1.onValueChangeListener;
        if (r3 == null) goto L7;
        r3.onInputBeyondLimit(r2);
        return;
    }

    private final void checkCounter() {
        OButton r0 = this.tvAdd;
        boolean r3 = true;
        if (getValue() >= this.mMaxValue) goto L5;
        boolean r1 = true;
    L6:
        r0.setEnabled(r1);
        OButton r2 = this.tvAdd;
        if (getValue() >= this.mMaxValue) goto L9;
        boolean r4 = true;
    L10:
        r2.setClickable(r4);
        OButton r5 = this.tvDec;
        if (getValue() <= this.mMinValue) goto L13;
        boolean r6 = true;
    L14:
        r5.setEnabled(r6);
        OButton r7 = this.tvDec;
        if (getValue() > this.mMinValue) goto L18;
        r3 = false;
    L18:
        r7.setClickable(r3);
        return;
    L13:
        r6 = false;
        goto L14
    L9:
        r4 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public static /* synthetic */ void expandTouchHeight$default(OSteppers r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = OUnitExtensionKt.vdp(r0, 44);
    L5:
        r0.expandTouchHeight(r1);
    }

    public final void expandTouchHeight(int r6) {
        OSteppers r0 = this;
        ViewExtensionsKt.increaseHitAreaForViews(r0, OUnitExtensionKt.vdp(r0, 32), r6, new View[]{this.addContainerView, this.etCounter, this.decContainerView});
        ViewExtensionsKt.expandTouchArea(this.tvAdd, r6);
        ViewExtensionsKt.expandTouchArea(this.tvDec, r6);
    }

    public final int getValue() {
        return this.mValue;
    }

    public final void setValue(int r3) {
        if (r3 < this.mMinValue) goto L9;
        if (r3 > this.mMaxValue) goto L9;
        setMValue(r3);
        return;
    L9:
        throw new IllegalArgumentException(r3 + " is not in [" + this.mMinValue + ", " + this.mMaxValue + "].");
    }

    public final int getMinValue() {
        return this.mMinValue;
    }

    public final void setMinValue(int r2) {
        setMMinValue(r2);
        setMValue(Math.max(r2, this.mValue));
    }

    public final int getMaxValue() {
        return this.mMaxValue;
    }

    public final void setMaxValue(int r2) {
        setMMaxValue(r2);
        setMValue(Math.min(r2, this.mValue));
    }

    public final void setStepValue(int r2) {
        if (this.mStepValue <= 0) goto L7;
        setMStepValue(r2);
        return;
    L7:
        throw new IllegalArgumentException("step value should be a positive integer");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        super.clearFocus();
        this.etCounter.clearFocus();
    }

    private final void refreshCounter() {
        this.etCounter.setText(String.valueOf(this.mValue), TextView.BufferType.EDITABLE);
        checkCounter();
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
