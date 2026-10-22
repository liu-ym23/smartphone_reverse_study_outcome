package com.obric.oui.tab;

import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class OBottomTabItem extends View {
    public CharSequence b;
    public Drawable c;

    @Nullable
    public final Drawable getIcon() {
        return this.c;
    }

    @Nullable
    public final CharSequence getText() {
        return this.b;
    }

    @Override // android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setIcon(@Nullable Drawable r1) {
        this.c = r1;
    }

    public final void setText(@Nullable CharSequence r1) {
        this.b = r1;
    }
}
