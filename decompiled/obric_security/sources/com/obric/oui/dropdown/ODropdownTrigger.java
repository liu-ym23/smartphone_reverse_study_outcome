package com.obric.oui.dropdown;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUILogger;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.constraintlayout.core.motion.utils.TypedValues;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OBaseTextView;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ODropdownTrigger.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "use CardListItem")
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00142\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,J0\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0014J\u0018\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0014J\b\u00106\u001a\u00020)H\u0016J\b\u00107\u001a\u00020)H\u0016J\b\u00108\u001a\u00020)H\u0016R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\t\u001a\u0004\u0018\u00010\u0014@BX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170$X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u00069"}, d2 = {"Lcom/obric/oui/dropdown/ODropdownTrigger;", "Lcom/obric/oui/layout/OUILinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "active", "getActive", "()Z", "setActive", "(Z)V", "active$delegate", "Lkotlin/properties/ReadWriteProperty;", "backgroundOff", "backgroundOn", "Lcom/obric/oui/dropdown/ODropdown;", "dropdown", "value", "Landroid/app/Activity;", "dropdownActivity", "getDropdownActivity", "()Landroid/app/Activity;", "setDropdownActivity", "(Landroid/app/Activity;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "iconOff", "iconOn", TypedValues.Custom.S_REFERENCE, "Ljava/lang/ref/WeakReference;", "Landroid/widget/TextView;", "getValue", "()Landroid/widget/TextView;", "init", "", "popup", "defaultValue", "", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "showPopup", "turnOff", "turnOn", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ODropdownTrigger extends OUILinearLayout {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final ReadWriteProperty active$delegate;
    private final int backgroundOff;
    private final int backgroundOn;
    private ODropdown dropdown;
    private final ImageView icon;
    private final int iconOff;
    private final int iconOn;
    private WeakReference<Activity> reference;
    private final TextView value;

    public static /* synthetic */ void $r8$lambda$7UaMnwmxmHUjMtl6zO8LgfrPFm8(ODropdownTrigger r0, View r1) {
        m323_init_$lambda1(r0, r1);
    }

    public ODropdownTrigger(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public ODropdownTrigger(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ ODropdownTrigger(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public ODropdownTrigger(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11, null, 8, null);
        Delegates r12 = Delegates.INSTANCE;
        final boolean r0 = false;
        this.active$delegate = new ODropdownTrigger$special$$inlined$observable$1(r0, this);
        if ((r9 instanceof Activity) == false) goto L5;
        setDropdownActivity((Activity) r9);
    L5:
        TypedArray r13 = r9.getTheme().obtainStyledAttributes(r10, R.styleable.ODropdownTrigger, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r13, "context.theme.obtainStyl…           0, 0\n        )");
        this.backgroundOff = r13.getColor(R.styleable.ODropdownTrigger_oui_backgroundOff, getResources().getColor(R.color.oui_fill_element_2, r9.getTheme()));
        this.backgroundOn = r13.getColor(R.styleable.ODropdownTrigger_oui_backgroundOn, getResources().getColor(R.color.oui_fill_active, r9.getTheme()));
        this.iconOff = r13.getResourceId(R.styleable.ODropdownTrigger_oui_iconOff, R.drawable.dropdown_default_off);
        this.iconOn = r13.getResourceId(R.styleable.ODropdownTrigger_oui_iconOn, R.drawable.dropdown_default_on);
        OBaseTextView r7 = new OBaseTextView(new ContextThemeWrapper(r9, r13.getResourceId(R.styleable.ODropdownTrigger_oui_textStyle, R.style.ODropdownTriggerText)), null, 0, 6, null);
        this.value = r7;
        addView(r7);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(r7.getLayoutParams());
        r1.weight = 1.0f;
        r1.rightMargin = r13.getDimensionPixelOffset(R.styleable.ODropdownTrigger_oui_midMargin, OUnitExtensionKt.vdp(this, 0));
        r7.setLayoutParams(r1);
        ImageView r14 = new ImageView(new ContextThemeWrapper(r9, r13.getResourceId(R.styleable.ODropdownTrigger_oui_imageStyle, R.style.ODropdownTriggerIcon)));
        this.icon = r14;
        addView(r14);
        turnOff();
        setOnClickListener(new ODropdownTrigger$$ExternalSyntheticLambda0(this));
    }

    public final TextView getValue() {
        return this.value;
    }

    protected final ImageView getIcon() {
        return this.icon;
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(ODropdownTrigger.class, "active", "getActive()Z", 0))};
    }

    public final boolean getActive() {
        return ((Boolean) this.active$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setActive(boolean r4) {
        this.active$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(r4));
    }

    public final Activity getDropdownActivity() {
        WeakReference<Activity> r0 = this.reference;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException(TypedValues.Custom.S_REFERENCE);
        r0 = null;
    L6:
        return r0.get();
    }

    public final void setDropdownActivity(Activity r2) {
        this.reference = new WeakReference(r2);
    }

    /* JADX INFO: renamed from: _init_$lambda-1, reason: not valid java name */
    private static final void m323_init_$lambda1(ODropdownTrigger r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.showPopup();
    }

    public static /* synthetic */ void init$default(ODropdownTrigger r0, ODropdown r1, CharSequence r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.init(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
    }

    public final void init(ODropdown r2, CharSequence r3) {
        Intrinsics.checkNotNullParameter(r2, "popup");
        this.dropdown = r2;
        this.value.setText(r3);
    }

    public void showPopup() {
        if (getDropdownActivity() != null) goto L6;
        OUILogger.e$default(OUILogger.INSTANCE, "ODropdownTrigger", "no activity for popup showing", null, 4, null);
        return;
    L6:
        Activity r9 = getDropdownActivity();
        if (r9 == null) goto L15;
        ODropdown r7 = this.dropdown;
        if (r7 == null) goto L13;
        ODropdown.DefaultImpls.start$default(r7, this, r9, null, new ODropdownTrigger$showPopup$1$1(this), 4, null);
        Unit r0 = Unit.INSTANCE;
    L13:
        setActive(true);
        return;
    }

    public void turnOn() {
        this.icon.setImageResource(this.iconOn);
        setBackgroundColor(this.backgroundOn);
    }

    public void turnOff() {
        this.icon.setImageResource(this.iconOff);
        setBackgroundColor(this.backgroundOff);
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
