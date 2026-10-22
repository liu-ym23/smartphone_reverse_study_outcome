package com.obric.oui.popover.view;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.obric.oui.popover.PopoverLinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class LinkPopoverView extends PopoverLinearLayout {
    @NotNull
    public final ImageView getIvArrow() {
        return null;
    }

    @NotNull
    public final ImageView getIvIcon() {
        return null;
    }

    @NotNull
    public final TextView getTvTips() {
        return null;
    }

    public void setLeftIcon(@DrawableRes int r1) {
        throw null;
    }

    public final void setTips(@NotNull CharSequence r1) {
        Intrinsics.f(r1, "charSequence");
        throw null;
    }

    public void setLeftIcon(@Nullable Drawable r1) {
        throw null;
    }
}
