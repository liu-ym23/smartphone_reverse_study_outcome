package com.obric.oui.chip;

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
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OChip.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "use com.obric.oui.chip.v2.OChip instead")
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u00017B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ0\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0014J\u0018\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0014J\b\u0010/\u001a\u00020\nH\u0016J>\u00100\u001a\u00020\u001726\u00101\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00170\u0013J\u0010\u00102\u001a\u00020\u00172\b\u00101\u001a\u0004\u0018\u000103J\u0010\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\nH\u0002J\u0010\u00106\u001a\u00020\u00172\u0006\u00105\u001a\u00020\nH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00170\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00068"}, d2 = {"Lcom/obric/oui/chip/OChip;", "Lcom/obric/oui/layout/OUIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checked", "", "chipIcon", "Landroid/widget/ImageView;", "getChipIcon", "()Landroid/widget/ImageView;", "closeIcon", "getCloseIcon", "enableChecked", "onCheckedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "", "parent", "Landroid/view/View;", "kotlin.jvm.PlatformType", "value", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "performClick", "setOnCheckedListener", "l", "setOnCloseListener", "Landroid/view/View$OnClickListener;", "updateChipIcon", "enable", "updateCloseIcon", "Style", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OChip extends OUIFrameLayout {
    private boolean checked;
    private final ImageView chipIcon;
    private final ImageView closeIcon;
    private final boolean enableChecked;
    private Function2<? super OChip, ? super Boolean, Unit> onCheckedListener;
    private final View parent;
    private final TextView textView;

    /* JADX INFO: compiled from: OChip.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/chip/OChip$Style;", "", "(Ljava/lang/String;I)V", "Default", "Rect", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final Style Default = null;
        public static final Style Rect = null;

        private static final /* synthetic */ Style[] $values() {
            return new Style[]{Default, Rect};
        }

        public static Style valueOf(String r1) {
            return (Style) Enum.valueOf(Style.class, r1);
        }

        public static Style[] values() {
            return (Style[]) $VALUES.clone();
        }

        private Style(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Default = new Style("Default", 0);
            Rect = new Style("Rect", 1);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: OChip.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Style.values().length];
            r0[Style.Default.ordinal()] = 1;
            r0[Style.Rect.ordinal()] = 2;
            $EnumSwitchMapping$0 = r0;
        }
    }

    public OChip(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OChip(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public static final /* synthetic */ boolean access$getChecked$p(OChip r0) {
        return r0.checked;
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

    public OChip(final Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11, null, 8, null);
        View r12 = FrameLayout.inflate(r9, R.layout.o_chip, this);
        this.parent = r12;
        View r0 = r12.findViewById(R.id.chip_icon);
        Intrinsics.checkNotNullExpressionValue(r0, "parent.findViewById(R.id.chip_icon)");
        ImageView r1 = (ImageView) r0;
        this.chipIcon = r1;
        View r2 = r12.findViewById(R.id.chip_text);
        Intrinsics.checkNotNullExpressionValue(r2, "parent.findViewById(R.id.chip_text)");
        TextView r3 = (TextView) r2;
        this.textView = r3;
        View r13 = r12.findViewById(R.id.close_icon);
        Intrinsics.checkNotNullExpressionValue(r13, "parent.findViewById(R.id.close_icon)");
        ImageView r14 = (ImageView) r13;
        this.closeIcon = r14;
        this.onCheckedListener = new OChip$onCheckedListener$1(this, r9);
        TypedArray r15 = r9.obtainStyledAttributes(r10, R.styleable.OChip);
        getChipIcon().setImageDrawable(r15.getDrawable(R.styleable.OChip_oui_chip_icon));
        getTextView().setText(r15.getText(R.styleable.OChip_oui_text));
        getCloseIcon().setImageDrawable(r15.getDrawable(R.styleable.OChip_oui_close_icon));
        int r16 = r15.getColor(R.styleable.OChip_oui_chip_icon_tint_color, -1);
        int r4 = r15.getColor(R.styleable.OChip_oui_close_icon_tint_color, -1);
        int r5 = r15.getColor(R.styleable.OChip_oui_text_color, -1);
        boolean r6 = false;
        this.enableChecked = r15.getBoolean(R.styleable.OChip_oui_enable_checked, false);
        Style r7 = Style.values()[r15.getInt(R.styleable.OChip_oui_chip_style, 0)];
        r15.recycle();
        if (r1.getDrawable() == null) goto L5;
        boolean r17 = true;
    L6:
        updateChipIcon(r17);
        if (r14.getDrawable() == null) goto L9;
        r6 = true;
    L9:
        updateCloseIcon(r6);
        if (r16 == (-1)) goto L15;
        Drawable r18 = r1.getDrawable();
        if (r18 == null) goto L15;
        r18.setTint(r16);
    L15:
        if (r4 == (-1)) goto L20;
        Drawable r19 = r14.getDrawable();
        if (r19 == null) goto L20;
        r19.setTint(r4);
    L20:
        if (r5 == (-1)) goto L22;
        r3.setTextColor(r5);
    L22:
        int r20 = WhenMappings.$EnumSwitchMapping$0[r7.ordinal()];
        if (r20 != 1) goto L25;
        int r21 = OUnitExtensionKt.vdp(this, 99);
    L30:
        setRadius(r21);
        return;
    L25:
        if (r20 != 2) goto L28;
        r21 = OUnitExtensionKt.vdp(this, 8);
        goto L30
    L28:
        throw new NoWhenBranchMatchedException();
    L5:
        r17 = false;
        goto L6
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

    private final void updateChipIcon(boolean r5) {
        if (r5 == false) goto L9;
        TextView r6 = this.textView;
        ViewGroup.LayoutParams r1 = r6.getLayoutParams();
        if (r1 == null) goto L8;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        r2.setMarginStart(OUnitExtensionKt.vdp(this, 4));
        r6.setLayoutParams(r2);
        this.chipIcon.setVisibility(0);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        TextView r7 = this.textView;
        ViewGroup.LayoutParams r3 = r7.getLayoutParams();
        if (r3 == null) goto L14;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        r4.setMarginStart(OUnitExtensionKt.vdp(this, 6));
        r7.setLayoutParams(r4);
        this.chipIcon.setVisibility(8);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final void updateCloseIcon(boolean r5) {
        if (r5 == false) goto L9;
        TextView r6 = this.textView;
        ViewGroup.LayoutParams r2 = r6.getLayoutParams();
        if (r2 == null) goto L8;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        r3.setMarginEnd(OUnitExtensionKt.vdp(this, 6));
        r6.setLayoutParams(r3);
        this.closeIcon.setVisibility(0);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        TextView r7 = this.textView;
        ViewGroup.LayoutParams r4 = r7.getLayoutParams();
        if (r4 == null) goto L14;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r4;
        r8.setMarginEnd(OUnitExtensionKt.vdp(this, 6));
        r7.setLayoutParams(r8);
        this.closeIcon.setVisibility(8);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setOnCloseListener(View.OnClickListener r1) {
        this.closeIcon.setOnClickListener(r1);
    }

    public final void setOnCheckedListener(Function2<? super OChip, ? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "l");
        this.onCheckedListener = r2;
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

    @Override // android.view.View
    public boolean performClick() {
        if (this.enableChecked == false) goto L6;
        boolean r0 = !this.checked;
        this.checked = r0;
        this.onCheckedListener.invoke(this, Boolean.valueOf(r0));
    L6:
        return super.performClick();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
