package com.obric.oui.sheet;

import android.widget.FrameLayout;
import android.widget.ImageView;
import com.obric.oui.titlebar.OTitleBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OInsetTitleBar extends OTitleBar {
    public FrameLayout c;
    public int e;
    public int f;
    public int i;
    public int j;

    @Nullable
    public final ImageView getEndButton0() {
        return null;
    }

    @Nullable
    public final ImageView getEndButton1() {
        return null;
    }

    public final int getMEnd0Color() {
        return this.i;
    }

    public final int getMEnd1Color() {
        return this.j;
    }

    @NotNull
    public final FrameLayout getMRightAction() {
        FrameLayout r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("mRightAction");
        throw null;
    }

    public final int getMStart0Color() {
        return this.e;
    }

    public final int getMStart1Color() {
        return this.f;
    }

    @Nullable
    public final ImageView getStartButton0() {
        return null;
    }

    @Nullable
    public final ImageView getStartButton1() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r1) {
    }

    public final void setMEnd0Color(int r1) {
        this.i = r1;
    }

    public final void setMEnd1Color(int r1) {
        this.j = r1;
    }

    public final void setMRightAction(@NotNull FrameLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.c = r2;
    }

    public final void setMStart0Color(int r1) {
        this.e = r1;
    }

    public final void setMStart1Color(int r1) {
        this.f = r1;
    }
}
