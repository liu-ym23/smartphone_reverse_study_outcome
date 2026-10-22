package com.obric.oui.button;

import android.widget.ImageView;
import com.obric.common.oui.b;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R*\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/button/OStatefulIconButton;", "Lcom/obric/oui/button/OIconButton;", "", "extraSpace", "", "onCreateDrawableState", "(I)[I", "", "value", "o", "Z", "isChecked", "()Z", "setChecked", "(Z)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class OStatefulIconButton extends OIconButton {
    private static final int[] p = null;
    private boolean o;

    static {
        p = new int[]{b.f8200i};
    }

    public static final /* synthetic */ int[] h(int[] r0, int[] r1) {
        return ImageView.mergeDrawableStates(r0, r1);
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int r1) {
        int[] r2 = super.onCreateDrawableState(r1 + 1);
        if (this.o == false) goto L5;
        h(r2, p);
    L5:
        o.e(r2, "drawableState");
        return r2;
    }

    public final void setChecked(boolean r2) {
        if (this.o == r2) goto L6;
        this.o = r2;
        refreshDrawableState();
        return;
    }
}
