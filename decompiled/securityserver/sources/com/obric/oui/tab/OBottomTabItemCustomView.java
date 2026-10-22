package com.obric.oui.tab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.securityserver.R;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class OBottomTabItemCustomView extends RelativeLayout {
    public final int b;
    public final int c;
    public final ImageView e;
    public final TextView f;
    public ColorStateList i;
    public Integer j;

    public OBottomTabItemCustomView(Context r4) {
        Intrinsics.f(r4, "context");
        super(r4, null);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setClickable(false);
        setFocusable(false);
        LayoutInflater.from(r4).inflate(R.layout.o_tab_bottom_item, this, true);
        View r5 = findViewById(R.id.icon_container);
        Intrinsics.e(r5, "findViewById(R.id.icon_container)");
        FrameLayout r6 = (FrameLayout) r5;
        View r7 = findViewById(R.id.icon);
        Intrinsics.e(r7, "findViewById(R.id.icon)");
        this.e = (ImageView) r7;
        View r8 = findViewById(R.id.title);
        Intrinsics.e(r8, "findViewById(R.id.title)");
        this.f = (TextView) r8;
        this.b = ContextCompat.getColor(getContext(), R.color.oui_text_3);
        this.c = ContextCompat.getColor(getContext(), R.color.oui_accent_fg);
    }

    @Deprecated
    public static /* synthetic */ void getSelectedBgColor$annotations() {
    }

    @NotNull
    public final ImageView getIcon() {
        return this.e;
    }

    @Nullable
    public final Integer getSelectedBgColor() {
        return this.j;
    }

    @Nullable
    public final ColorStateList getTextColor() {
        return this.i;
    }

    @NotNull
    public final TextView getTitle() {
        return this.f;
    }

    @Override // android.view.View
    public void setSelected(boolean r4) {
        super.setSelected(r4);
        TextView r0 = this.f;
        ImageView r1 = this.e;
        if (r4 == false) goto L10;
        ColorStateList r5 = this.i;
        int r3 = this.c;
        if (r5 == null) goto L7;
        r3 = r5.getColorForState(RelativeLayout.SELECTED_STATE_SET, r3);
    L7:
        r0.setTextColor(r3);
        if (r1.getDrawable() == null) goto L18;
        Drawable r6 = DrawableCompat.wrap(r1.getDrawable());
        r6.setTint(r3);
        r1.setImageDrawable(r6);
        return;
    L18:
        return;
    L10:
        ColorStateList r7 = this.i;
        if (r7 == null) goto L13;
        int r8 = r7.getDefaultColor();
    L14:
        r0.setTextColor(r8);
        if (r1.getDrawable() == null) goto L20;
        Drawable r9 = DrawableCompat.wrap(r1.getDrawable());
        r9.setTint(r8);
        r1.setImageDrawable(r9);
        return;
    L20:
        return;
    L13:
        r8 = this.b;
        goto L14
    }

    public final void setSelectedBgColor(@Nullable Integer r3) {
        this.j = r3;
        if (r3 != null) goto L5;
        return;
    L5:
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setCornerRadius(getResources().getDimension(R.dimen.oui_r_m1));
        r0.setColor(r3.intValue());
    }

    public final void setTextColor(@Nullable ColorStateList r3) {
        this.i = r3;
        if (r3 != null) goto L5;
        return;
    L5:
        this.f.setTextColor(r3.getDefaultColor());
        ImageView r2 = this.e;
        if (r2.getDrawable() == null) goto L9;
        Drawable r0 = DrawableCompat.wrap(r2.getDrawable());
        r0.setTint(r3.getDefaultColor());
        r2.setImageDrawable(r0);
        return;
    }
}
