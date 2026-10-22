package com.obric.oui.actionbar.v2;

import android.view.View;
import android.widget.FrameLayout;
import com.obric.oui.utils.log.L;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OBottomActionBarNormalHorizontal extends FrameLayout {

    @Metadata
    public static final class Companion {
    }

    public final int getButtonCount() {
        throw null;
    }

    public final int getMaxButtonCount() {
        return 0;
    }

    public final void setButtons(@NotNull List<? extends View> r1) {
        Intrinsics.f(r1, "buttons");
        if (r1.size() <= 0) goto L7;
        L.g("OBottomActionBarNormalHorizontal", "Cannot set more than 0 buttons");
        return;
    L7:
        throw null;
    }

    public final void setHeaderView(@NotNull View r1) {
        Intrinsics.f(r1, "headerView");
        throw null;
    }

    public final void setMaxButtonCount(int r1) {
        throw null;
    }
}
