package com.obric.oui.chip.v2;

import android.view.View;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OChip extends OUIFrameLayout {
    public Function2 k;
    public boolean l;

    @Metadata
    public static final class Companion {
    }

    @NotNull
    public final CharSequence getText() {
        throw null;
    }

    public final void setOn(boolean r2) {
        if (this.l == r2) goto L8;
        this.l = r2;
        Function2 r0 = this.k;
        if (r0 == null) goto L9;
        Unit r1 = (Unit) r0.mo7invoke(this, Boolean.valueOf(r2));
        return;
    L9:
        return;
    }

    public final void setOnCheckedListener(@NotNull Function2<? super OChip, ? super Boolean, Unit> r2) {
        Intrinsics.f(r2, "l");
        this.k = r2;
    }

    public final void setOnCloseListener(@Nullable View.OnClickListener r1) {
    }

    public final void setText(@NotNull CharSequence r1) {
        Intrinsics.f(r1, "value");
        throw null;
    }
}
