package com.obric.oui.scrollbar;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$2 extends RecyclerView.OnScrollListener {
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r2, int r3) {
        Intrinsics.f(r2, "recyclerView");
        super.onScrollStateChanged(r2, r3);
        if (r3 == 0) goto L6;
        return;
    L6:
        throw null;
    }
}
