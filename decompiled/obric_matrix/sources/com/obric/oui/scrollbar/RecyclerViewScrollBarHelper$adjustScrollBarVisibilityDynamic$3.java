package com.obric.oui.scrollbar;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.n0.d.b0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"com/obric/oui/scrollbar/RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "Lkotlin/f0;", "onChanged", "()V", "", "positionStart", "itemCount", "onItemRangeInserted", "(II)V", "onItemRangeRemoved", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 extends RecyclerView.AdapterDataObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView f11335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ b0 f11336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ float f11337c;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 f11338f;

        a(RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 r1) {
            this.f11338f = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 r3 = this.f11338f;
            r3.f11336b.f18428f = 0;
            com.obric.oui.scrollbar.a r0 = com.obric.oui.scrollbar.a.f11343a;
            RecyclerView r1 = r3.f11335a;
            com.obric.oui.scrollbar.a.b(r0, r1, r3.f11337c, r1.computeVerticalScrollRange());
        }
    }

    static final class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 f11339f;

        b(RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 r1) {
            this.f11339f = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = this.f11339f.f11335a.computeVerticalScrollRange();
            RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 r3 = this.f11339f;
            b0 r1 = r3.f11336b;
            if (r0 <= r1.f18428f) goto L5;
            r1.f18428f = r0;
        L5:
            com.obric.oui.scrollbar.a.b(com.obric.oui.scrollbar.a.f11343a, r3.f11335a, r3.f11337c, r1.f18428f);
        }
    }

    static final class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 f11340f;

        c(RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 r1) {
            this.f11340f = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 r3 = this.f11340f;
            r3.f11336b.f18428f = 0;
            com.obric.oui.scrollbar.a r0 = com.obric.oui.scrollbar.a.f11343a;
            RecyclerView r1 = r3.f11335a;
            com.obric.oui.scrollbar.a.b(r0, r1, r3.f11337c, r1.computeVerticalScrollRange());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        this.f11335a.post(new a(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeInserted(int r1, int r2) {
        this.f11335a.post(new b(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeRemoved(int r1, int r2) {
        this.f11335a.post(new c(this));
    }
}
