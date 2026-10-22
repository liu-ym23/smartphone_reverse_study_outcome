package com.obric.oui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.security.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ODropdownTrigger.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016J0\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0014J\u0018\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J\u000e\u0010-\u001a\u00020#2\u0006\u0010\t\u001a\u00020\nJ\b\u0010.\u001a\u00020#H\u0002J\b\u0010/\u001a\u00020#H\u0002R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00060"}, d2 = {"Lcom/obric/oui/ODropdownTrigger;", "Lcom/obric/oui/layout/OUILinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "active", "", "getActive", "()Z", "setActive", "(Z)V", "backgroundOff", "backgroundOn", "icon", "Landroid/widget/ImageView;", "iconOff", "iconOn", "offValue", "", "getOffValue", "()Ljava/lang/String;", "setOffValue", "(Ljava/lang/String;)V", "onValue", "getOnValue", "setOnValue", "value", "Landroid/widget/TextView;", "getValue", "()Landroid/widget/TextView;", "init", "", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setActiveValue", "turnOff", "turnOn", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public class ODropdownTrigger extends OUILinearLayout {
    private HashMap _$_findViewCache;
    private boolean active;
    private final int backgroundOff;
    private final int backgroundOn;
    private final ImageView icon;
    private final int iconOff;
    private final int iconOn;
    private String offValue;
    private String onValue;
    private final TextView value;

    public ODropdownTrigger(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public ODropdownTrigger(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
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

    public /* synthetic */ ODropdownTrigger(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
        AttributeSet r6 = (AttributeSet) null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public ODropdownTrigger(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11, null, 8, null);
        this.offValue = "";
        this.onValue = "";
        TypedArray r12 = r9.getTheme().obtainStyledAttributes(r10, R.styleable.ODropdownTrigger, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r12, "context.theme.obtainStyl…           0, 0\n        )");
        this.backgroundOff = r12.getColor(0, getResources().getColor(R.color.oui_fill_element_2, r9.getTheme()));
        this.backgroundOn = r12.getColor(1, getResources().getColor(R.color.oui_fill_active, r9.getTheme()));
        this.iconOff = r12.getResourceId(2, R.drawable.dropdown_default_off);
        this.iconOn = r12.getResourceId(3, R.drawable.dropdown_default_on);
        TextView r13 = new TextView(new ContextThemeWrapper(r9, R.style.ODropdownTriggerTextM1Thin));
        this.value = r13;
        addView(r13);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(r13.getLayoutParams());
        r2.weight = 1.0f;
        r2.rightMargin = r12.getDimensionPixelOffset(5, MathKt.roundToInt(TypedValue.applyDimension(1, 0, Resources.getSystem().getDisplayMetrics())));
        r13.setLayoutParams(r2);
        ImageView r14 = new ImageView(new ContextThemeWrapper(r9, r12.getResourceId(4, R.style.ODropdownTriggerIcon)));
        this.icon = r14;
        addView(r14);
        String r15 = r9.getString(R.string.common_expand_more);
        Intrinsics.checkNotNullExpressionValue(r15, "context.getString(R.string.common_expand_more)");
        this.offValue = r15;
        String r16 = r9.getString(R.string.common_collapse);
        Intrinsics.checkNotNullExpressionValue(r16, "context.getString(R.string.common_collapse)");
        this.onValue = r16;
        turnOff();
    }

    public final TextView getValue() {
        return this.value;
    }

    public final boolean getActive() {
        return this.active;
    }

    public final void setActive(boolean r1) {
        this.active = r1;
    }

    public final String getOffValue() {
        return this.offValue;
    }

    public final void setOffValue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.offValue = r2;
    }

    public final String getOnValue() {
        return this.onValue;
    }

    public final void setOnValue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.onValue = r2;
    }

    public static /* synthetic */ void init$default(ODropdownTrigger r0, String r1, String r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = "";
    L6:
        r0.init(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
    }

    public final void init(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "offValue");
        Intrinsics.checkNotNullParameter(r4, "onValue");
        this.value.setText(r3);
        this.offValue = r3;
        this.onValue = r4;
    }

    public final void setActiveValue(boolean r1) {
        this.active = r1;
        if (r1 == false) goto L5;
        turnOn();
        return;
    L5:
        turnOff();
    }

    private final void turnOn() {
        this.icon.setImageResource(this.iconOn);
        this.value.setText(this.onValue);
    }

    private final void turnOff() {
        this.icon.setImageResource(this.iconOff);
        this.value.setText(this.offValue);
    }

    @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
