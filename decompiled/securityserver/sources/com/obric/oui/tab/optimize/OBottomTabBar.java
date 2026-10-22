package com.obric.oui.tab.optimize;

import android.graphics.Canvas;
import android.widget.LinearLayout;
import com.obric.oui.common.SdkInit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OBottomTabBar extends LinearLayout {
    public OnTabSelectedListener b;
    public boolean c;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public interface OnTabSelectedListener {
    }

    static {
        new SdkInit();
    }

    public final int getSelectedIndex() {
        return 0;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r7) {
        super.onDraw(r7);
        if (r7 != null) goto L5;
        return;
    L5:
        if (this.c == false) goto L10;
        r7.save();
        r7.drawLine(0.0f, 0.0f, getWidth(), 0.0f, null);
        r7.restore();
        return;
    }

    public final void setOnTabSelectedListener(@NotNull OnTabSelectedListener r2) {
        Intrinsics.f(r2, "listener");
        this.b = r2;
    }

    public final void setShowTopLine(boolean r1) {
        this.c = r1;
        invalidate();
    }
}
