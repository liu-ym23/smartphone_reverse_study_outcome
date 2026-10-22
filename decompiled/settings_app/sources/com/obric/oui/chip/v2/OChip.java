package com.obric.oui.chip.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.obric.common.oui.R;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.utils.log.L;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OChip.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 ^2\u00020\u0001:\u0001^B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010C\u001a\u00020(2\u0006\u0010D\u001a\u00020\u001dH\u0002J\u0010\u0010E\u001a\u00020(2\u0006\u0010D\u001a\u00020\u001dH\u0002J\u0010\u0010F\u001a\u00020(2\u0006\u0010D\u001a\u00020\u001dH\u0002J\u0018\u0010G\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u00020\u001dH\u0016J\u000e\u0010K\u001a\u00020(2\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010L\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010M\u001a\u00020(2\u0006\u00108\u001a\u00020\u0007J\u000e\u0010N\u001a\u00020(2\u0006\u00109\u001a\u00020\u0007J\u000e\u0010O\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u0007J\u0010\u0010P\u001a\u00020(2\u0006\u0010Q\u001a\u00020\u0007H\u0016J\u0010\u0010R\u001a\u00020(2\u0006\u0010S\u001a\u00020\u0007H\u0016J>\u0010T\u001a\u00020(26\u0010U\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020(0$J\u0010\u0010V\u001a\u00020(2\b\u0010U\u001a\u0004\u0018\u00010*J\u000e\u0010W\u001a\u00020(2\u0006\u0010X\u001a\u00020\u001dJ\u000e\u0010Y\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0007J\u000e\u0010Z\u001a\u00020(2\u0006\u0010@\u001a\u00020\u0007J\u000e\u0010[\u001a\u00020(2\u0006\u0010\\\u001a\u00020\u001dJ\u0010\u0010]\u001a\u00020(2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R@\u0010#\u001a4\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020(\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010+\u001a\n -*\u0004\u0018\u00010,0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00103\u001a\u0002022\u0006\u0010\u001e\u001a\u0002028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010:\u001a\u00020;¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/obric/oui/chip/v2/OChip;", "Lcom/obric/oui/layout/OUIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arrowIcon", "Landroid/widget/ImageView;", "getArrowIcon", "()Landroid/widget/ImageView;", "arrowIconTintColor", "chipArrowSpaceL", "chipArrowSpaceR", "chipContainer", "Lcom/obric/oui/layout/OUILinearLayout;", "getChipContainer", "()Lcom/obric/oui/layout/OUILinearLayout;", "chipIcon", "getChipIcon", "chipIconSpaceL", "chipIconSpaceR", "chipIconTintColor", "closeIcon", "getCloseIcon", "closeIconTintColor", "haveShadow", "", "value", "isOn", "()Z", "setOn", "(Z)V", "onCheckedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "", "onCloseListener", "Landroid/view/View$OnClickListener;", "parent", "Landroid/view/View;", "kotlin.jvm.PlatformType", "pressColor", "shadowsNormal", "", "Lcom/obric/oui/common/style/Shadow;", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textColor", "textColorDisabled", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "toggleable", "widgetBgColor", "widgetBgColorDisabled", "widgetPaddingLeft", "widgetPaddingRight", "initArrowIcon", "enable", "initChipIcon", "initCloseIcon", "initShadows", "typedArray", "Landroid/content/res/TypedArray;", "performClick", "setArrowIconTintColor", "setChipIconTintColor", "setChipTextColor", "setChipTextColorDisabled", "setCloseIconTintColor", "setMinimumHeight", "minHeight", "setMinimumWidth", "minWidth", "setOnCheckedListener", "l", "setOnCloseListener", "setToggleable", "isToggleable", "setWidgetBgColor", "setWidgetBgColorDisabled", "updateCloseIcon", "visible", "updateColors", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OChip extends OUIFrameLayout {
    public static final Companion Companion = null;
    private static final String TAG = "OChip";
    private final ImageView arrowIcon;
    private int arrowIconTintColor;
    private int chipArrowSpaceL;
    private int chipArrowSpaceR;
    private final OUILinearLayout chipContainer;
    private final ImageView chipIcon;
    private int chipIconSpaceL;
    private int chipIconSpaceR;
    private int chipIconTintColor;
    private final ImageView closeIcon;
    private int closeIconTintColor;
    private boolean haveShadow;
    private boolean isOn;
    private Function2<? super OChip, ? super Boolean, Unit> onCheckedListener;
    private View.OnClickListener onCloseListener;
    private final View parent;
    private int pressColor;
    private List<Shadow> shadowsNormal;
    private int textColor;
    private int textColorDisabled;
    private final TextView textView;
    private boolean toggleable;
    private int widgetBgColor;
    private int widgetBgColorDisabled;
    private int widgetPaddingLeft;
    private int widgetPaddingRight;

    /* JADX INFO: compiled from: OChip.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/chip/v2/OChip$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$IuiIXCwgeIVPgm2x1A0k5GxyJnU(OChip r0, View r1) {
        m1078initCloseIcon$lambda5(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public OChip(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OChip(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OChip(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OChip(Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14, null, 8, null);
        View r15 = FrameLayout.inflate(r12, R.layout.o_chip_v2, this);
        this.parent = r15;
        View r0 = r15.findViewById(R.id.chip_container);
        Intrinsics.checkNotNullExpressionValue(r0, "parent.findViewById(R.id.chip_container)");
        OUILinearLayout r1 = (OUILinearLayout) r0;
        this.chipContainer = r1;
        View r2 = r15.findViewById(R.id.chip_icon);
        Intrinsics.checkNotNullExpressionValue(r2, "parent.findViewById(R.id.chip_icon)");
        ImageView r3 = (ImageView) r2;
        this.chipIcon = r3;
        View r4 = r15.findViewById(R.id.chip_text);
        Intrinsics.checkNotNullExpressionValue(r4, "parent.findViewById(R.id.chip_text)");
        this.textView = (TextView) r4;
        View r5 = r15.findViewById(R.id.close_icon);
        Intrinsics.checkNotNullExpressionValue(r5, "parent.findViewById(R.id.close_icon)");
        ImageView r6 = (ImageView) r5;
        this.closeIcon = r6;
        View r16 = r15.findViewById(R.id.arrow_icon);
        Intrinsics.checkNotNullExpressionValue(r16, "parent.findViewById(R.id.arrow_icon)");
        ImageView r17 = (ImageView) r16;
        this.arrowIcon = r17;
        this.isOn = true;
        TypedArray r7 = r12.obtainStyledAttributes(r13, R.styleable.OChip);
        getChipIcon().setImageDrawable(r7.getDrawable(R.styleable.OChip_oui_chip_icon));
        getTextView().setText(r7.getText(R.styleable.OChip_oui_text));
        getCloseIcon().setImageDrawable(r7.getDrawable(R.styleable.OChip_oui_close_icon));
        getArrowIcon().setImageDrawable(r7.getDrawable(R.styleable.OChip_oui_chipArrowIcon));
        this.chipIconTintColor = r7.getColor(R.styleable.OChip_oui_chip_icon_tint_color, 0);
        this.closeIconTintColor = r7.getColor(R.styleable.OChip_oui_close_icon_tint_color, 0);
        this.arrowIconTintColor = r7.getColor(R.styleable.OChip_oui_arrow_icon_tint_color, 0);
        this.textColor = r7.getColor(R.styleable.OChip_oui_text_color, 0);
        this.textColorDisabled = r7.getColor(R.styleable.OChip_oui_text_color_disabled, 0);
        this.widgetBgColor = r7.getColor(R.styleable.OChip_oui_widgetBgColor, 0);
        this.widgetBgColorDisabled = r7.getColor(R.styleable.OChip_oui_widgetBgColorDisabled, 0);
        this.toggleable = r7.getBoolean(R.styleable.OChip_oui_chip_toggleable, false);
        this.widgetPaddingLeft = r7.getDimensionPixelSize(R.styleable.OChip_oui_widgetPaddingL, 0);
        this.widgetPaddingRight = r7.getDimensionPixelSize(R.styleable.OChip_oui_widgetPaddingR, 0);
        this.chipIconSpaceL = r7.getDimensionPixelSize(R.styleable.OChip_oui_chipIconSpaceL, 0);
        this.chipIconSpaceR = r7.getDimensionPixelSize(R.styleable.OChip_oui_chipIconSpaceR, 0);
        this.chipArrowSpaceL = r7.getDimensionPixelSize(R.styleable.OChip_oui_chipArrowSpaceL, 0);
        this.chipArrowSpaceR = r7.getDimensionPixelSize(R.styleable.OChip_oui_chipArrowSpaceR, 0);
        getChipContainer().setPadding(this.widgetPaddingLeft, getChipContainer().getPaddingTop(), this.widgetPaddingRight, getChipContainer().getPaddingBottom());
        int r8 = r7.getColor(R.styleable.OChip_oui_widgetPressColor, 0);
        this.pressColor = r8;
        if (r8 == 0) goto L5;
        getChipContainer().setOverridePressColor(this.pressColor);
        getChipContainer().refreshColors(TAG);
    L5:
        Intrinsics.checkNotNullExpressionValue(r7, "this");
        this.haveShadow = initShadows(r12, r7);
        r7.recycle();
        TypedArray r18 = r12.obtainStyledAttributes(r13, new int[]{android.R.attr.minWidth, android.R.attr.minHeight});
        int r19 = r18.getDimensionPixelSize(0, 0);
        int r9 = r18.getDimensionPixelSize(1, 0);
        if (r19 <= 0) goto L8;
        getChipContainer().setMinimumWidth(r19);
    L8:
        if (r9 <= 0) goto L10;
        getChipContainer().setMinimumHeight(r9);
    L10:
        r18.recycle();
        setChangeAlphaWhenPress(false);
        if (r3.getDrawable() == null) goto L13;
        boolean r110 = true;
    L14:
        initChipIcon(r110);
        if (r6.getDrawable() == null) goto L17;
        boolean r111 = true;
    L18:
        initCloseIcon(r111);
        if (r17.getDrawable() == null) goto L21;
        boolean r112 = true;
    L22:
        initArrowIcon(r112);
        updateColors(true);
        int r113 = OUnitExtensionKt.vdp(this, 99);
        if (this.haveShadow == false) goto L25;
        L.d(TAG, "initShadows, have shadow");
        setShadowCornerRadius(r113);
        r1.setRadius(r113);
    L26:
        setClipChildren(false);
        return;
    L25:
        setRadius(r113);
        goto L26
    L21:
        r112 = false;
        goto L22
    L17:
        r111 = false;
        goto L18
    L13:
        r110 = false;
        goto L14
    }

    public final OUILinearLayout getChipContainer() {
        return this.chipContainer;
    }

    public final ImageView getChipIcon() {
        return this.chipIcon;
    }

    public final TextView getTextView() {
        return this.textView;
    }

    public final ImageView getCloseIcon() {
        return this.closeIcon;
    }

    public final ImageView getArrowIcon() {
        return this.arrowIcon;
    }

    public final boolean isOn() {
        return this.isOn;
    }

    public final void setOn(boolean r2) {
        if (this.isOn == r2) goto L9;
        this.isOn = r2;
        updateColors(r2);
        Function2<? super OChip, ? super Boolean, Unit> r3 = this.onCheckedListener;
        if (r3 == null) goto L10;
        r3.invoke(this, Boolean.valueOf(this.isOn));
        return;
    L10:
        return;
    }

    public final CharSequence getText() {
        CharSequence r1 = this.textView.getText();
        Intrinsics.checkNotNullExpressionValue(r1, "textView.text");
        return r1;
    }

    public final void setText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.textView.setText(r2);
    }

    private final boolean initShadows(Context r4, TypedArray r5) {
        List<Shadow> r6 = OUILayoutHelper.createShadowListFromAttr(r4, r5, R.styleable.OChip_oui_widgetShadowNormal);
        if (r6 == null) goto L5;
        this.shadowsNormal = r6;
        Intrinsics.checkNotNull(r6);
        Shadow r1 = (Shadow) CollectionsKt.getOrNull(r6, 0);
        List<Shadow> r2 = this.shadowsNormal;
        Intrinsics.checkNotNull(r2);
        setShadow(r1, (Shadow) CollectionsKt.getOrNull(r2, 1));
    L5:
        if (r6 == null) goto L8;
        return true;
    L8:
        return false;
    }

    public final void setWidgetBgColor(int r2) {
        if (r2 == 0) goto L7;
        this.widgetBgColor = r2;
        if (isOn() == false) goto L8;
        this.chipContainer.setBackgroundColor(r2);
        return;
    L8:
        return;
    }

    public final void setChipTextColor(int r2) {
        if (r2 == 0) goto L7;
        this.textColor = r2;
        if (isOn() == false) goto L8;
        this.textView.setTextColor(r2);
        return;
    L8:
        return;
    }

    public final void setChipIconTintColor(int r2) {
        if (r2 == 0) goto L10;
        this.chipIconTintColor = r2;
        if (isOn() == false) goto L11;
        Drawable r1 = this.chipIcon.getDrawable();
        if (r1 == null) goto L12;
        r1.setTint(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setCloseIconTintColor(int r2) {
        if (r2 == 0) goto L10;
        this.closeIconTintColor = r2;
        if (isOn() == false) goto L11;
        Drawable r1 = this.closeIcon.getDrawable();
        if (r1 == null) goto L12;
        r1.setTint(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setArrowIconTintColor(int r2) {
        if (r2 == 0) goto L10;
        this.arrowIconTintColor = r2;
        if (isOn() == false) goto L11;
        Drawable r1 = this.arrowIcon.getDrawable();
        if (r1 == null) goto L12;
        r1.setTint(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setWidgetBgColorDisabled(int r2) {
        if (r2 == 0) goto L7;
        this.widgetBgColorDisabled = r2;
        if (isOn() == true) goto L8;
        this.chipContainer.setBackgroundColor(r2);
        return;
    L8:
        return;
    }

    public final void setChipTextColorDisabled(int r2) {
        if (r2 == 0) goto L11;
        this.textColorDisabled = r2;
        if (isOn() == true) goto L12;
        Drawable r0 = this.chipIcon.getDrawable();
        if (r0 == null) goto L9;
        r0.setTint(r2);
    L9:
        this.textView.setTextColor(r2);
        return;
    L12:
        return;
    }

    private final void updateColors(boolean r2) {
        if (r2 == false) goto L27;
        int r3 = this.widgetBgColor;
        if (r3 == 0) goto L7;
        this.chipContainer.setBackgroundColor(r3);
    L7:
        if (this.chipIconTintColor == 0) goto L13;
        Drawable r4 = this.chipIcon.getDrawable();
        if (r4 == null) goto L13;
        r4.setTint(this.chipIconTintColor);
    L13:
        if (this.closeIconTintColor == 0) goto L19;
        Drawable r5 = this.closeIcon.getDrawable();
        if (r5 == null) goto L19;
        r5.setTint(this.closeIconTintColor);
    L19:
        if (this.arrowIconTintColor == 0) goto L24;
        Drawable r6 = this.arrowIcon.getDrawable();
        if (r6 == null) goto L24;
        r6.setTint(this.arrowIconTintColor);
    L24:
        int r7 = this.textColor;
        if (r7 == 0) goto L38;
        this.textView.setTextColor(r7);
        return;
    L38:
        return;
    L27:
        int r8 = this.widgetBgColorDisabled;
        if (r8 == 0) goto L31;
        this.chipContainer.setBackgroundColor(r8);
    L31:
        if (this.textColorDisabled == 0) goto L40;
        Drawable r9 = this.chipIcon.getDrawable();
        if (r9 == null) goto L36;
        r9.setTint(this.textColorDisabled);
    L36:
        this.textView.setTextColor(this.textColorDisabled);
        return;
    }

    private final void initChipIcon(boolean r5) {
        if (r5 == false) goto L9;
        TextView r6 = this.textView;
        ViewGroup.LayoutParams r2 = r6.getLayoutParams();
        if (r2 == null) goto L8;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        r3.setMarginStart(this.chipIconSpaceL);
        r6.setLayoutParams(r3);
        this.chipIcon.setVisibility(0);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        TextView r7 = this.textView;
        ViewGroup.LayoutParams r4 = r7.getLayoutParams();
        if (r4 == null) goto L14;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r4;
        r8.setMarginStart(0);
        r7.setLayoutParams(r8);
        this.chipIcon.setVisibility(8);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final void initCloseIcon(boolean r5) {
        if (r5 == false) goto L9;
        ImageView r6 = this.closeIcon;
        ViewGroup.LayoutParams r2 = r6.getLayoutParams();
        if (r2 == null) goto L8;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        r3.setMarginStart(this.chipIconSpaceR);
        r6.setLayoutParams(r3);
        this.closeIcon.setVisibility(0);
        this.closeIcon.setOnClickListener(new OChip$$ExternalSyntheticLambda0(this));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        ImageView r7 = this.closeIcon;
        ViewGroup.LayoutParams r4 = r7.getLayoutParams();
        if (r4 == null) goto L14;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r4;
        r8.setMarginStart(0);
        r7.setLayoutParams(r8);
        this.closeIcon.setVisibility(8);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* JADX INFO: renamed from: initCloseIcon$lambda-5, reason: not valid java name */
    private static final void m1078initCloseIcon$lambda5(OChip r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r0.isEnabled() == false) goto L9;
        View.OnClickListener r2 = r0.onCloseListener;
        if (r2 == null) goto L10;
        r2.onClick(r0.closeIcon);
        return;
    L10:
        return;
    }

    private final void initArrowIcon(boolean r5) {
        if (r5 == false) goto L9;
        ImageView r6 = this.arrowIcon;
        ViewGroup.LayoutParams r2 = r6.getLayoutParams();
        if (r2 == null) goto L8;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        r3.setMarginStart(this.chipArrowSpaceL);
        r6.setLayoutParams(r3);
        this.arrowIcon.setVisibility(0);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        ImageView r7 = this.arrowIcon;
        ViewGroup.LayoutParams r4 = r7.getLayoutParams();
        if (r4 == null) goto L14;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r4;
        r8.setMarginStart(0);
        r7.setLayoutParams(r8);
        this.arrowIcon.setVisibility(8);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void updateCloseIcon(boolean r5) {
        if (r5 == false) goto L9;
        ImageView r6 = this.closeIcon;
        ViewGroup.LayoutParams r2 = r6.getLayoutParams();
        if (r2 == null) goto L8;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        r3.setMarginStart(this.chipIconSpaceR);
        r6.setLayoutParams(r3);
        this.closeIcon.setVisibility(0);
        OUILinearLayout r7 = this.chipContainer;
        r7.setPadding(this.widgetPaddingLeft, r7.getPaddingTop(), this.widgetPaddingRight, this.chipContainer.getPaddingBottom());
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        ImageView r8 = this.closeIcon;
        ViewGroup.LayoutParams r4 = r8.getLayoutParams();
        if (r4 == null) goto L18;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r4;
        r9.setMarginStart(0);
        r8.setLayoutParams(r9);
        this.closeIcon.setVisibility(8);
        if (this.widgetPaddingLeft != this.widgetPaddingRight) goto L14;
        return;
    L14:
        if (this.chipIcon.getVisibility() != 8) goto L21;
        OUILinearLayout r10 = this.chipContainer;
        r10.setPadding(this.widgetPaddingLeft, r10.getPaddingTop(), this.widgetPaddingLeft, this.chipContainer.getPaddingBottom());
        return;
    L21:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setOnCloseListener(View.OnClickListener r1) {
        this.onCloseListener = r1;
    }

    public final void setOnCheckedListener(Function2<? super OChip, ? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "l");
        this.onCheckedListener = r2;
    }

    public final void setToggleable(boolean r1) {
        this.toggleable = r1;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.toggleable == false) goto L6;
        setOn(!isOn());
    L6:
        return super.performClick();
    }

    @Override // android.view.View
    public void setMinimumWidth(int r1) {
        super.setMinimumWidth(r1);
        this.chipContainer.setMinimumWidth(r1);
    }

    @Override // android.view.View
    public void setMinimumHeight(int r1) {
        super.setMinimumHeight(r1);
        this.chipContainer.setMinimumHeight(r1);
    }
}
