package com.obric.oui.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OCheckBoxLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0015\u001a\u00020\rJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0014J\b\u0010\"\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u0019H\u0002J\u000e\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0017J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u0017H\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0017H\u0016J\u0010\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010,J\u0010\u0010-\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010.J\u0010\u0010/\u001a\u00020\u00192\b\b\u0001\u00100\u001a\u00020\bJ\b\u00101\u001a\u00020\u0019H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBoxLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundDrawable", "Lcom/obric/oui/common/style/OStateGradientDrawable;", "checkBox", "Lcom/obric/oui/checkbox/OCheckBox;", "value", "checkedState", "getCheckedState", "()I", "setCheckedState", "(I)V", "layoutSizePx", "getCheckBox", "isChecked", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "performClick", "refreshDimensionCache", "setAlwaysLight", "light", "setChecked", "checked", "setEnabled", "enabled", "setOnCheckedChangeListener", "listener", "Lcom/obric/oui/checkbox/OCheckBox$OnCheckedChangeListener;", "setOnCheckedStateChangedListener", "Lcom/obric/oui/checkbox/OCheckBox$OnCheckedStateChangedListener;", "setPrimaryColor", "color", "toggle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCheckBoxLayout extends FrameLayout implements Checkable {
    private final OStateGradientDrawable backgroundDrawable;
    private OCheckBox checkBox;
    private int layoutSizePx;

    public OCheckBoxLayout(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OCheckBoxLayout(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r1) {
        return true;
    }

    public /* synthetic */ OCheckBoxLayout(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OCheckBoxLayout(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        OStateGradientDrawable r0 = new OStateGradientDrawable();
        this.backgroundDrawable = r0;
        refreshDimensionCache();
        if (r6 == null) goto L5;
        OCheckBox r3 = new OCheckBox(r5, r6, r7);
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-2, -2);
        r8.gravity = 17;
        r3.setLayoutParams(r8);
        this.checkBox = r3;
        addView(r3);
    L6:
        this.checkBox.setEnableExpandTouchRect(false);
        r0.setCornerRadius(this.layoutSizePx);
        ColorStateList r9 = ContextCompat.getColorStateList(r5, R.color.o_checkbox_layout_bg_color);
        Intrinsics.checkNotNull(r9);
        Intrinsics.checkNotNullExpressionValue(r9, "getColorStateList(contex…eckbox_layout_bg_color)!!");
        r0.setSolidColors(r9);
        setBackground(r0);
        setClickable(true);
        return;
    L5:
        OCheckBox r10 = new OCheckBox(r5);
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.gravity = 17;
        r10.setLayoutParams(r11);
        this.checkBox = r10;
        addView(r10);
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        int r3 = View.MeasureSpec.makeMeasureSpec(this.layoutSizePx, 1073741824);
        super.onMeasure(r3, r3);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        refreshDimensionCache();
        this.backgroundDrawable.setCornerRadius(this.layoutSizePx);
    }

    private final void refreshDimensionCache() {
        this.layoutSizePx = OUnitExtensionKt.vdp(this, 32);
    }

    @Override // android.view.View
    public boolean performClick() {
        return this.checkBox.performClick();
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        this.checkBox.setEnabled(r1);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checkBox.isChecked();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r1) {
        this.checkBox.setChecked(r1);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.checkBox.toggle();
    }

    public final int getCheckedState() {
        return this.checkBox.getCheckedState();
    }

    public final void setCheckedState(int r1) {
        this.checkBox.setCheckedState(r1);
    }

    public final void setOnCheckedChangeListener(OCheckBox.OnCheckedChangeListener r1) {
        this.checkBox.setOnCheckedChangeListener(r1);
    }

    public final void setOnCheckedStateChangedListener(OCheckBox.OnCheckedStateChangedListener r1) {
        this.checkBox.setOnCheckedStateChangedListener(r1);
    }

    public final void setPrimaryColor(int r1) {
        this.checkBox.setPrimaryColor(r1);
    }

    public final void setAlwaysLight(boolean r1) {
        this.checkBox.setAlwaysLight(r1);
    }

    public final OCheckBox getCheckBox() {
        return this.checkBox;
    }
}
