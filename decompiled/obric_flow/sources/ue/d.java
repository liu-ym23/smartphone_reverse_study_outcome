package ue;

import android.widget.OverScroller;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends OverScroller {
    @Override // android.widget.OverScroller
    public final void startScroll(int r10, int r11, int r12, int r13, int r14) {
        super.startScroll(r10, r11, r12, r13, Math.min(300, r14));
    }
}
