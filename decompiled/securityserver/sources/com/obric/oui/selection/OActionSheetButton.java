package com.obric.oui.selection;

import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
@Metadata
public final class OActionSheetButton extends OUIFrameLayout {
    public OTextView k;

    @Metadata
    public static final class Companion {
    }

    public static /* synthetic */ void getTvTitle$annotations() {
    }

    @NotNull
    public final OTextView getTvTitle() {
        OTextView r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("tvTitle");
        throw null;
    }

    public final void setText(@NotNull String r2) {
        Intrinsics.f(r2, "str");
        OTextView r1 = this.k;
        if (r1 == null) goto L6;
        r1.setText(r2);
        return;
    L6:
        Intrinsics.m("tvTitle");
        throw null;
    }

    public final void setTextColor(@ColorInt int r1) {
        OTextView r0 = this.k;
        if (r0 == null) goto L6;
        r0.setTextColor(r1);
        return;
    L6:
        Intrinsics.m("tvTitle");
        throw null;
    }

    public final void setTvTitle(@NotNull OTextView r2) {
        Intrinsics.f(r2, "<set-?>");
        this.k = r2;
    }
}
