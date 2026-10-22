package com.obric.oui.tab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.obric.common.oui.R;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OBottomTabItemCustomView.kt */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "使用 optimize 包下的 OBottomTabItem")
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@FX\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001a\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/obric/oui/tab/OBottomTabItemCustomView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defaultSelectTextColor", "", "defaultTextColor", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "iconContainer", "Landroid/widget/FrameLayout;", "selectedBg", "Landroid/graphics/drawable/Drawable;", "value", "selectedBgColor", "getSelectedBgColor$annotations", "()V", "getSelectedBgColor", "()Ljava/lang/Integer;", "setSelectedBgColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Landroid/content/res/ColorStateList;", "textColor", "getTextColor", "()Landroid/content/res/ColorStateList;", "setTextColor", "(Landroid/content/res/ColorStateList;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setSelected", "", MaterialConfigFormatNames.SELECTED, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomTabItemCustomView extends RelativeLayout {
    private final int defaultSelectTextColor;
    private final int defaultTextColor;
    private final ImageView icon;
    private final FrameLayout iconContainer;
    private Drawable selectedBg;
    private Integer selectedBgColor;
    private ColorStateList textColor;
    private final TextView title;

    /* JADX WARN: Multi-variable type inference failed */
    public OBottomTabItemCustomView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    @Deprecated(message = "2024.11.4 最新的设计规范移除了选中状态的背景色")
    public static /* synthetic */ void getSelectedBgColor$annotations() {
    }

    public /* synthetic */ OBottomTabItemCustomView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OBottomTabItemCustomView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setClickable(false);
        setFocusable(false);
        LayoutInflater.from(r3).inflate(R.layout.o_tab_bottom_item, this, true);
        View r5 = findViewById(R.id.icon_container);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.icon_container)");
        this.iconContainer = (FrameLayout) r5;
        View r6 = findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.icon)");
        this.icon = (ImageView) r6;
        View r7 = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.title)");
        this.title = (TextView) r7;
        this.defaultTextColor = ContextCompat.getColor(getContext(), R.color.oui_text_3);
        this.defaultSelectTextColor = ContextCompat.getColor(getContext(), R.color.oui_accent_fg);
    }

    public final ImageView getIcon() {
        return this.icon;
    }

    public final TextView getTitle() {
        return this.title;
    }

    public final ColorStateList getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(ColorStateList r3) {
        this.textColor = r3;
        if (r3 != null) goto L5;
        return;
    L5:
        this.title.setTextColor(r3.getDefaultColor());
        if (this.icon.getDrawable() == null) goto L9;
        ImageView r2 = this.icon;
        Drawable r0 = DrawableCompat.wrap(r2.getDrawable());
        r0.setTint(r3.getDefaultColor());
        r2.setImageDrawable(r0);
        return;
    }

    public final Integer getSelectedBgColor() {
        return this.selectedBgColor;
    }

    public final void setSelectedBgColor(Integer r4) {
        this.selectedBgColor = r4;
        if (r4 != null) goto L5;
        return;
    L5:
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setCornerRadius(getResources().getDimension(R.dimen.oui_r_m1));
        r0.setColor(r4.intValue());
        this.selectedBg = r0;
    }

    @Override // android.view.View
    public void setSelected(boolean r3) {
        super.setSelected(r3);
        Integer r0 = null;
        if (r3 == false) goto L14;
        ColorStateList r4 = this.textColor;
        if (r4 == null) goto L8;
        r0 = Integer.valueOf(r4.getColorForState(RelativeLayout.SELECTED_STATE_SET, this.defaultSelectTextColor));
    L8:
        if (r0 != null) goto L10;
        int r5 = this.defaultSelectTextColor;
    L11:
        this.title.setTextColor(r5);
        if (this.icon.getDrawable() == null) goto L25;
        ImageView r2 = this.icon;
        Drawable r1 = DrawableCompat.wrap(r2.getDrawable());
        r1.setTint(r5);
        r2.setImageDrawable(r1);
        return;
    L25:
        return;
    L10:
        r5 = r0.intValue();
        goto L11
    L14:
        ColorStateList r6 = this.textColor;
        if (r6 == null) goto L18;
        r0 = Integer.valueOf(r6.getDefaultColor());
    L18:
        if (r0 != null) goto L20;
        int r7 = this.defaultTextColor;
    L21:
        this.title.setTextColor(r7);
        if (this.icon.getDrawable() == null) goto L27;
        ImageView r8 = this.icon;
        Drawable r9 = DrawableCompat.wrap(r8.getDrawable());
        r9.setTint(r7);
        r8.setImageDrawable(r9);
        return;
    L27:
        return;
    L20:
        r7 = r0.intValue();
        goto L21
    }
}
