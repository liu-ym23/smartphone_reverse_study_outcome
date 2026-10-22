package com.obric.oui.lisitem;

import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.securityserver.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OListItemCustom extends OListItemGeneral {
    public OTextView A;
    public ImageView B;
    public String C;
    public FrameLayout y;
    public OUIFrameLayout z;

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return MathKt.a(getResources().getDimension(R.dimen.oui_listitem_content_width_large));
    }

    @NotNull
    public final OUIFrameLayout getContentImgBackground() {
        OUIFrameLayout r0 = this.z;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("contentImgBackground");
        throw null;
    }

    @NotNull
    public final FrameLayout getMTitleInfo() {
        FrameLayout r0 = this.y;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("mTitleInfo");
        throw null;
    }

    @NotNull
    public final ImageView getTrailingImageView() {
        ImageView r0 = this.B;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("trailingImageView");
        throw null;
    }

    @NotNull
    public final OTextView getTrailingText() {
        OTextView r0 = this.A;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("trailingText");
        throw null;
    }

    @Nullable
    public final String getTrailingTextString() {
        return this.C;
    }

    public final void setContentImgBackground(@NotNull OUIFrameLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.z = r2;
    }

    public final void setImageView(@Nullable Drawable r1) {
        ImageView r0 = this.B;
        if (r0 == null) goto L6;
        r0.setImageDrawable(r1);
        return;
    L6:
        Intrinsics.m("trailingImageView");
        throw null;
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

    public final void setMTitleInfo(@NotNull FrameLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.y = r2;
    }

    public final void setTrailingImageView(@NotNull ImageView r2) {
        Intrinsics.f(r2, "<set-?>");
        this.B = r2;
    }

    public final void setTrailingText(@NotNull OTextView r2) {
        Intrinsics.f(r2, "<set-?>");
        this.A = r2;
    }

    public final void setTrailingTextString(@Nullable String r1) {
        this.C = r1;
        i();
        String r2 = this.C;
        if (r2 == null) goto L6;
        setTrailingText(r2);
        return;
    }

    public final void setTrailingText(@NotNull String r2) {
        Intrinsics.f(r2, "text");
        OTextView r1 = this.A;
        if (r1 == null) goto L6;
        r1.setText(r2);
        return;
    L6:
        Intrinsics.m("trailingText");
        throw null;
    }
}
