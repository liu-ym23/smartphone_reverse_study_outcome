package com.obric.oui.lisitem;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.securityserver.R;
import com.obric.oui.button.OIconButton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OListItemCircleImg extends OListItemGeneral {
    public String A;
    public Drawable B;
    public Drawable C;
    public OIconButton y;
    public ImageView z;

    @Nullable
    public final Drawable getCircleImage() {
        return this.B;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return MathKt.a(getResources().getDimension(R.dimen.oui_listitem_content_width_large));
    }

    @NotNull
    public final OIconButton getContentImgCircle() {
        return this.y;
    }

    @Nullable
    public final Drawable getIconImage() {
        return this.C;
    }

    @NotNull
    public final ImageView getIvIcon() {
        return this.z;
    }

    @NotNull
    public final SettingsTrailingView getSettingsTrailingView() {
        return null;
    }

    @Nullable
    public final String getTrailingTextString() {
        return this.A;
    }

    public final void setCircleImage(@Nullable Drawable r2) {
        this.B = r2;
        if (r2 == null) goto L5;
        this.y.setImageDrawable(r2);
        this.y.setVisibility(0);
        getMContentElement().setVisibility(0);
    L6:
        i();
        return;
    L5:
        this.y.setVisibility(8);
        getMContentElement().setVisibility(8);
        goto L6
    }

    public final void setContentImgCircle(@NotNull OIconButton r2) {
        Intrinsics.f(r2, "<set-?>");
        this.y = r2;
    }

    public final void setIconImage(@Nullable Drawable r2) {
        this.C = r2;
        if (r2 == null) goto L5;
        this.z.setImageDrawable(r2);
        this.z.setVisibility(0);
    L6:
        i();
        return;
    L5:
        this.z.setVisibility(8);
        goto L6
    }

    @Deprecated
    public final void setImageView(@Nullable Drawable r1) {
        throw null;
    }

    public final void setIvIcon(@NotNull ImageView r2) {
        Intrinsics.f(r2, "<set-?>");
        this.z = r2;
    }

    public final void setListItemSettingsEnabled(boolean r2) {
        setChangeAlphaWhenDisable(false);
        setEnabled(r2);
        if (r2 == false) goto L5;
        getMLeadingElement().setAlpha(1.0f);
        getMClContent().setAlpha(1.0f);
        getMContentElement().setAlpha(1.0f);
        return;
    L5:
        getMLeadingElement().setAlpha(0.3f);
        getMClContent().setAlpha(0.3f);
        getMContentElement().setAlpha(0.3f);
    }

    public final void setTrailingText(@NotNull String r1) {
        Intrinsics.f(r1, "text");
        throw null;
    }

    public final void setTrailingTextString(@Nullable String r1) {
        this.A = r1;
        i();
        String r2 = this.A;
        if (r2 == null) goto L5;
        setTrailingText(r2);
    L5:
        setTrailingView(null);
    }
}
