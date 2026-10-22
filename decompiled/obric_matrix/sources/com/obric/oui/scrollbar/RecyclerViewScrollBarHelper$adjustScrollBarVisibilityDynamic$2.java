package com.obric.oui.scrollbar;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.n0.d.b0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/obric/oui/scrollbar/RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "Lkotlin/f0;", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$2 extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView f11332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ b0 f11333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ float f11334c;

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView r2, int r3) {
        o.f(r2, "recyclerView");
        super.onScrollStateChanged(r2, r3);
        if (r3 != 0) goto L9;
        int r4 = this.f11332a.computeVerticalScrollRange();
        b0 r5 = this.f11333b;
        int r0 = r5.f18428f;
        if (r4 <= r0) goto L7;
        r5.f18428f = r4;
        a.b(a.f11343a, this.f11332a, this.f11334c, r4);
        return;
    L7:
        a.b(a.f11343a, this.f11332a, this.f11334c, r0);
        return;
    }
}
