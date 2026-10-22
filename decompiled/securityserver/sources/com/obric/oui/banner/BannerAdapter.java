package com.obric.oui.banner;

import android.view.ViewGroup;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.securityserver.R;
import com.obric.oui.banner.interfaces.BannerOperator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class BannerAdapter extends RecyclerView.Adapter<BannerViewHolder> {
    public final LinkedHashMap b;
    public final ArrayList c;
    public final WeakHashMap e;
    public List f;
    public boolean i;
    public final BannerOperator j;

    public BannerAdapter() {
        Intrinsics.f(null, "bannerOperator");
        this.j = null;
        LinkedHashMap r0 = new LinkedHashMap();
        this.b = r0;
        ArrayList r1 = new ArrayList();
        this.c = r1;
        this.e = new WeakHashMap();
        this.f = EmptyList.b;
        this.i = true;
        StubViewHolder.Companion r3 = StubViewHolder.g;
        r0.put("_stub", r3);
        r1.add(r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (this.i == false) goto L6;
        return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    L6:
        return this.f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r4) {
        ArrayList r0 = this.c;
        if (r0.isEmpty() == true) goto L11;
        if (this.f.isEmpty() == false) goto L7;
        StubViewHolder.Companion r5 = StubViewHolder.g;
    L8:
        IBannerViewHolderFactory r3 = (IBannerViewHolderFactory) this.b.get("_stub");
        Intrinsics.f(r0, "<this>");
        return r0.indexOf(r3);
    L7:
        List r1 = this.f;
        ((BannerData) r1.get(r4 % r1.size())).a();
        goto L8
    L11:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        BannerViewHolder r6 = (BannerViewHolder) r4;
        Intrinsics.f(r6, "holder");
        boolean r0 = this.i;
        int r1 = this.f.size();
        if (r0 == false) goto L10;
        if (r1 > 0) goto L8;
        r1 = 1;
    L8:
        r5 = r5 % r1;
    L10:
        if (this.f.isEmpty() == false) goto L12;
        StubBannerData r3 = new StubBannerData();
        r6.c = r5;
        r6.b(r3);
        r6.a(true);
        return;
    L12:
        BannerData r2 = (BannerData) this.f.get(r5);
        if ((r2 instanceof GridBannerData) == false) goto L15;
        ((GridBannerData) r2).b();
    L15:
        Intrinsics.f(r2, "data");
        r6.c = r5;
        r6.b(r2);
        r6.a(true);
        r6.itemView.setTag(R.id.banner_pos_key, Integer.valueOf(r5));
        if (r6.itemView.hasOnClickListeners() == true) goto L20;
        r6.itemView.setOnClickListener(new AnonymousClass1(this));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.f(r3, "parent");
        ArrayList r0 = this.c;
        if (r0.isEmpty() == true) goto L7;
        StubViewHolder r5 = ((IBannerViewHolderFactory) r0.get(r4)).a(r3);
        r5.b = this.j;
        return r5;
    L7:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r3) {
        BannerViewHolder r4 = (BannerViewHolder) r3;
        Intrinsics.f(r4, "holder");
        super.onViewAttachedToWindow(r4);
        BannerOperator r0 = r4.b;
        if (r0 == null) goto L7;
        LiveData r1 = r0.getSelectedPosition();
        if (r1 == null) goto L7;
        r1.observeForever(r4.e);
    L7:
        this.e.put(r4, Unit.f330a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r3) {
        BannerViewHolder r4 = (BannerViewHolder) r3;
        Intrinsics.f(r4, "holder");
        super.onViewDetachedFromWindow(r4);
        BannerOperator r0 = r4.b;
        if (r0 == null) goto L7;
        LiveData r1 = r0.getSelectedPosition();
        if (r1 == null) goto L7;
        r1.removeObserver(r4.e);
    L7:
        r4.c();
        this.e.remove(r4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        BannerViewHolder r3 = (BannerViewHolder) r2;
        Intrinsics.f(r3, "holder");
        super.onViewRecycled(r3);
    }
}
