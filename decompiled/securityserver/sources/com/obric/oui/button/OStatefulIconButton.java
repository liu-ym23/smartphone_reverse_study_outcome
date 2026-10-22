package com.obric.oui.button;

import android.view.View;
import com.bytedance.securityserver.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OStatefulIconButton extends OIconButton {
    public static final int[] p = null;
    public boolean o;

    @Metadata
    public static final class Companion {
    }

    static {
        p = new int[]{R.attr.state_checked};
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int r1) {
        int[] r2 = super.onCreateDrawableState(r1 + 1);
        if (this.o == false) goto L5;
        View.mergeDrawableStates(r2, p);
    L5:
        Intrinsics.e(r2, "drawableState");
        return r2;
    }

    public final void setChecked(boolean r2) {
        if (this.o == r2) goto L6;
        this.o = r2;
        refreshDrawableState();
        return;
    }
}
