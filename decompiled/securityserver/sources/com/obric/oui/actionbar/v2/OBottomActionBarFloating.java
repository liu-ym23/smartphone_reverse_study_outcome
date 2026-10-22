package com.obric.oui.actionbar.v2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OBottomActionBarFloating extends FrameLayout {

    @Metadata
    public static final class Companion {
    }

    @Nullable
    public final ViewGroup getActionGroup() {
        return null;
    }

    public final void setButtons(@NotNull List<? extends View> r2) {
        Intrinsics.f(r2, "buttons");
        if (r2.isEmpty() == false) goto L6;
        return;
    L6:
        if (r2.size() == 1) goto L10;
        r2.size();
        return;
    }
}
