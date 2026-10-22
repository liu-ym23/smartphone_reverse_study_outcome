package com.obric.oui.lisitem;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OListItemCheck extends OListItemGeneral {
    @NotNull
    public final ImageView getIcon() {
        View r1 = getMTrailingElement().getChildAt(0);
        if (r1 == null) goto L7;
        return (ImageView) r1;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    }

    public final void setChecked(boolean r1) {
        FrameLayout r0 = getMTrailingElement();
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public final void setCheckedIconLight(boolean r1) {
    }

    public final void setTitle(@NotNull String r2) {
        Intrinsics.f(r2, "str");
        setTitleString(r2);
    }
}
