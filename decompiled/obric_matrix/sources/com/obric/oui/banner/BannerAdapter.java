package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0014R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001cR6\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u0018\u0010#\"\u0004\b$\u0010%R\"\u0010,\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R.\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010=\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u00109\u001a\u0004\b!\u0010:\"\u0004\b;\u0010<R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020)0>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010\"¨\u0006A"}, d2 = {"Lcom/obric/oui/banner/BannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/oui/banner/BannerViewHolder;", "", "e", "()I", "getItemCount", "Landroid/view/ViewGroup;", "parent", "viewType", "h", "(Landroid/view/ViewGroup;I)Lcom/obric/oui/banner/BannerViewHolder;", "holder", "position", "Lkotlin/f0;", "g", "(Lcom/obric/oui/banner/BannerViewHolder;I)V", "getItemViewType", "(I)I", "i", "(Lcom/obric/oui/banner/BannerViewHolder;)V", "j", "k", "Lcom/obric/oui/banner/i/b;", "d", "Lcom/obric/oui/banner/i/b;", "mBannerItemClickListener", "Lcom/obric/oui/banner/i/a;", "Lcom/obric/oui/banner/i/a;", "bannerOperator", "", "Lcom/obric/oui/banner/a;", "value", "f", "Ljava/util/List;", "()Ljava/util/List;", "l", "(Ljava/util/List;)V", "dataSet", "", "", "Lcom/obric/oui/banner/d;", "a", "Ljava/util/Map;", "viewHolderFactoryMap", "Lcom/obric/oui/banner/h/a;", "c", "Lcom/obric/oui/banner/h/a;", "mBannerGridConfig", "Ljava/util/WeakHashMap;", "Ljava/util/WeakHashMap;", "getCreatedHolders", "()Ljava/util/WeakHashMap;", "setCreatedHolders", "(Ljava/util/WeakHashMap;)V", "createdHolders", "", "Z", "()Z", "m", "(Z)V", "useInfiniteItemCount", "", "b", "viewHolderFactoryList", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class BannerAdapter extends RecyclerView.Adapter<BannerViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, d> f10769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d> f10770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.oui.banner.h.a f10771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.obric.oui.banner.i.b f10772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WeakHashMap<BannerViewHolder, f0> f10773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<? extends com.obric.oui.banner.a> f10774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.obric.oui.banner.i.a f10776h;

    static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ BannerAdapter f10777f;

        a(BannerAdapter r1) {
            this.f10777f = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Object r3 = r2.getTag(com.obric.common.oui.f.w);
            Objects.requireNonNull(r3, "null cannot be cast to non-null type kotlin.Int");
            int r4 = ((Integer) r3).intValue();
            com.obric.oui.banner.i.b r0 = BannerAdapter.c(this.f10777f);
            if (r0 == null) goto L6;
            r0.a(this.f10777f.d().get(r4), r4);
            return;
        }
    }

    public static final /* synthetic */ com.obric.oui.banner.i.b c(BannerAdapter r0) {
        return r0.f10772d;
    }

    public final List<com.obric.oui.banner.a> d() {
        return this.f10774f;
    }

    public final int e() {
        return this.f10774f.size();
    }

    public final boolean f() {
        return this.f10775g;
    }

    public void g(BannerViewHolder r4, int r5) {
        o.f(r4, "holder");
        int r6 = com.obric.oui.banner.j.a.f10810a.a(this.f10775g, r5, e());
        if (this.f10774f.isEmpty() == false) goto L6;
        r4.d(r6, new g());
        return;
    L6:
        com.obric.oui.banner.a r0 = this.f10774f.get(r6);
        if ((r0 instanceof c) == false) goto L9;
        ((c) r0).b(this.f10771c);
    L9:
        r4.d(r6, r0);
        r4.itemView.setTag(com.obric.common.oui.f.w, Integer.valueOf(r6));
        if (r4.itemView.hasOnClickListeners() == true) goto L13;
        r4.itemView.setOnClickListener(new a(this));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.f10775g == false) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return this.f10774f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r3) {
        if (this.f10770b.isEmpty() == true) goto L11;
        if (this.f10774f.isEmpty() == false) goto L7;
        String r4 = StubViewHolder.f10799f.b();
    L8:
        d r5 = this.f10769a.get(r4);
        return r.U(this.f10770b, r5);
    L7:
        List<? extends com.obric.oui.banner.a> r0 = this.f10774f;
        r4 = r0.get(r3 % r0.size()).a();
        goto L8
    L11:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }

    public BannerViewHolder h(ViewGroup r2, int r3) {
        o.f(r2, "parent");
        if (this.f10770b.isEmpty() == true) goto L7;
        BannerViewHolder r4 = this.f10770b.get(r3).a(r2);
        r4.j(this.f10776h);
        return r4;
    L7:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }

    public void i(BannerViewHolder r2) {
        o.f(r2, "holder");
        super.onViewAttachedToWindow(r2);
        r2.c();
        this.f10773e.put(r2, f0.f18324a);
    }

    public void j(BannerViewHolder r2) {
        o.f(r2, "holder");
        super.onViewDetachedFromWindow(r2);
        r2.f();
        this.f10773e.remove(r2);
    }

    public void k(BannerViewHolder r2) {
        o.f(r2, "holder");
        super.onViewRecycled(r2);
        r2.i();
    }

    public final void l(List<? extends com.obric.oui.banner.a> r2) {
        o.f(r2, "value");
        this.f10774f = r2;
        notifyDataSetChanged();
    }

    public final void m(boolean r1) {
        this.f10775g = r1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        g((BannerViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return h(r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r1) {
        i((BannerViewHolder) r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder r1) {
        j((BannerViewHolder) r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder r1) {
        k((BannerViewHolder) r1);
    }
}
