package com.obric.oui.titlebar;

import android.widget.FrameLayout;
import android.widget.ImageView;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class OContainerTitleBar extends OTitleBar {
    public int c;
    public int e;
    public int f;
    public int i;

    @Nullable
    public final ImageView getEndButton() {
        return null;
    }

    @Nullable
    public final FrameLayout getEndContainer() {
        return null;
    }

    public final int getMEnd0Color() {
        return this.f;
    }

    public final int getMEnd1Color() {
        return this.i;
    }

    public final int getMStart0Color() {
        return this.c;
    }

    public final int getMStart1Color() {
        return this.e;
    }

    @Nullable
    public final ImageView getStartButton0() {
        return null;
    }

    @Nullable
    public final ImageView getStartButton1() {
        return null;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r1) {
    }

    public final void setMEnd0Color(int r1) {
        this.f = r1;
    }

    public final void setMEnd1Color(int r1) {
        this.i = r1;
    }

    public final void setMStart0Color(int r1) {
        this.c = r1;
    }

    public final void setMStart1Color(int r1) {
        this.e = r1;
    }
}
