package com.obric.oui.popover.view;

import a.a;
import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ProfilePopoverView extends LinkPopoverView {
    public final void setAvatarClickListener(@NotNull View.OnClickListener r2) {
        Intrinsics.f(r2, "listener");
        getIvIcon().setOnClickListener(r2);
    }

    @Override // com.obric.oui.popover.view.LinkPopoverView
    public void setLeftIcon(int r7) {
        float r0 = 12;
        float r4 = 9;
        setPadding(a.d("Resources.getSystem()", 1, r0), a.d("Resources.getSystem()", 1, r4), a.d("Resources.getSystem()", 1, r0), a.d("Resources.getSystem()", 1, r4));
        super.setLeftIcon(r7);
    }

    @Override // com.obric.oui.popover.view.LinkPopoverView
    public void setLeftIcon(@Nullable Drawable r7) {
        float r0 = 12;
        float r4 = 9;
        setPadding(a.d("Resources.getSystem()", 1, r0), a.d("Resources.getSystem()", 1, r4), a.d("Resources.getSystem()", 1, r0), a.d("Resources.getSystem()", 1, r4));
        super.setLeftIcon(r7);
    }
}
