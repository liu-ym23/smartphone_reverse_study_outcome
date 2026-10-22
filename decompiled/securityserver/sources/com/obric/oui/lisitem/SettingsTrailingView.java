package com.obric.oui.lisitem;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SettingsTrailingView extends LinearLayout {
    public TextView b;
    public ImageView c;

    @NotNull
    public final ImageView getIconImageView() {
        return this.c;
    }

    @NotNull
    public final TextView getTextView() {
        return this.b;
    }

    public final void setIconImageView(@NotNull ImageView r2) {
        Intrinsics.f(r2, "<set-?>");
        this.c = r2;
    }

    public final void setTextView(@NotNull TextView r2) {
        Intrinsics.f(r2, "<set-?>");
        this.b = r2;
    }

    public final void setTrailingImage(@Nullable Drawable r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.c.setImageDrawable(r1);
    }

    public final void setTrailingText(@NotNull String r2) {
        Intrinsics.f(r2, "text");
        this.b.setText(r2);
    }
}
