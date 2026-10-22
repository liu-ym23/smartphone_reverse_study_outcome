package com.obric.oui.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.common.oui.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OIconButtonFloating.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J,\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010\u0018\u001a\u00020\r2\b\b\u0001\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001bJ\u0010\u0010\u001a\u001a\u00020\r2\b\b\u0001\u0010\u0019\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/button/OIconButtonFloating;", "Lcom/obric/oui/button/OShadowFrame;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "iconView", "Landroidx/appcompat/widget/AppCompatImageView;", "applyDynamicTheme", "", "themeStyle", "initContent", "contentView", "Landroid/widget/FrameLayout;", "typedArray", "Landroid/content/res/TypedArray;", "setIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "drawableResId", "setIconBgColor", "color", "setIconTintColor", "Landroid/content/res/ColorStateList;", "updateUIOnEnableChanged", "enabled", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OIconButtonFloating extends OShadowFrame {
    private AppCompatImageView iconView;

    public OIconButtonFloating(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, 0, 14, null);
    }

    public OIconButtonFloating(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, 0, 12, null);
    }

    public OIconButtonFloating(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, 0, 8, null);
    }

    public /* synthetic */ OIconButtonFloating(Context r2, AttributeSet r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r2, r3, r4, r5);
    }

    public OIconButtonFloating(Context r2, AttributeSet r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, r5);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void initContent(Context r5, FrameLayout r6, AttributeSet r7, TypedArray r8) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "contentView");
        if (r8 != null) goto L5;
        return;
    L5:
        ColorStateList r9 = r8.getColorStateList(R.styleable.OShadowFrame_oui_widgetTintColor);
        Drawable r0 = r8.getDrawable(R.styleable.OShadowFrame_oui_widgetIcon);
        AppCompatImageView r1 = new AppCompatImageView(r5);
        this.iconView = r1;
        r1.setDuplicateParentStateEnabled(true);
        AppCompatImageView r2 = null;
        if (r0 == null) goto L16;
        AppCompatImageView r3 = this.iconView;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r3 = null;
    L10:
        r3.setImageDrawable(r0);
        if (r9 == null) goto L16;
        AppCompatImageView r4 = this.iconView;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r4 = null;
    L15:
        r4.setImageTintList(r9);
    L16:
        AppCompatImageView r10 = this.iconView;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L20:
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-1, -1);
        r11.gravity = 17;
        Unit r12 = Unit.INSTANCE;
        r6.addView(r2, r11);
        if (getEnableMaterial() == false) goto L24;
        initMaterials(r5, r8);
        return;
    L24:
        return;
    L19:
        r2 = r10;
        goto L20
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.common.style.ODynamicThemeWidget
    public void applyDynamicTheme(int r1) {
        super.applyDynamicTheme(r1);
    }

    @Override // com.obric.oui.button.OShadowFrame
    protected void updateUIOnEnableChanged(boolean r3) {
        super.updateUIOnEnableChanged(r3);
        AppCompatImageView r0 = null;
        if (r3 == false) goto L9;
        AppCompatImageView r2 = this.iconView;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L8:
        r0.setAlpha(1.0f);
        return;
    L7:
        r0 = r2;
        goto L8
    L9:
        AppCompatImageView r4 = this.iconView;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L13:
        r0.setAlpha(0.3f);
        return;
    L12:
        r0 = r4;
        goto L13
    }

    public final void setIcon(int r1) {
        AppCompatImageView r0 = this.iconView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r0 = null;
    L5:
        r0.setImageResource(r1);
    }

    public final void setIcon(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        AppCompatImageView r1 = this.iconView;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r1 = null;
    L5:
        r1.setImageDrawable(r2);
    }

    public final void setIconTintColor(int r1) {
        AppCompatImageView r0 = this.iconView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r0 = null;
    L5:
        r0.setColorFilter(r1);
    }

    public final void setIconTintColor(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, "color");
        AppCompatImageView r1 = this.iconView;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r1 = null;
    L5:
        r1.setImageTintList(r2);
    }

    public final void setIconBgColor(int r1) {
        setBgColor(r1);
    }
}
