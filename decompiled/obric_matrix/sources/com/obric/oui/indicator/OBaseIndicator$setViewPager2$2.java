package com.obric.oui.indicator;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00068V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"com/obric/oui/indicator/OBaseIndicator$setViewPager2$2", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "Lcom/obric/oui/indicator/OBaseIndicator$c;", "Lkotlin/f0;", "onChanged", "()V", "Lkotlin/Function1;", "a", "()Lkotlin/n0/c/l;", "releaseAction", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OBaseIndicator$setViewPager2$2 extends RecyclerView.AdapterDataObserver implements OBaseIndicator.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ OBaseIndicator f11100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ViewPager2 f11101g;

    static final class a extends q implements l<OBaseIndicator.c, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OBaseIndicator$setViewPager2$2 f11102f;

        a(OBaseIndicator$setViewPager2$2 r1) {
            this.f11102f = r1;
            super(1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(OBaseIndicator.c r2) {
            o.f(r2, "it");
            RecyclerView.Adapter r1 = this.f11102f.f11101g.getAdapter();
            o.c(r1);
            r1.unregisterAdapterDataObserver((RecyclerView.AdapterDataObserver) r2);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(OBaseIndicator.c r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    @Override // com.obric.oui.indicator.OBaseIndicator.c
    public l<OBaseIndicator.c, f0> a() {
        return new a(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        super.onChanged();
        this.f11100f.o();
    }
}
