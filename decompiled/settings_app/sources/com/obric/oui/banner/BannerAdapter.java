package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.common.oui.R;
import com.obric.oui.banner.configs.IBannerConfig;
import com.obric.oui.banner.interfaces.BannerOperator;
import com.obric.oui.banner.interfaces.OnBannerItemClickListener;
import com.obric.oui.banner.utils.BannerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BannerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016J\u0006\u0010)\u001a\u00020&J\u0018\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010(\u001a\u00020&H\u0016J\u0018\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020&H\u0016J\u0010\u00100\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0002H\u0016J\u0010\u00101\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0002H\u0016J\u0010\u00102\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0002H\u0016J\u000e\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020!J\u0006\u00105\u001a\u00020\bJ\u000e\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\u0016J\u000e\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020!0#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/obric/oui/banner/BannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/oui/banner/BannerViewHolder;", "bannerOperator", "Lcom/obric/oui/banner/interfaces/BannerOperator;", "(Lcom/obric/oui/banner/interfaces/BannerOperator;)V", "createdHolders", "Ljava/util/WeakHashMap;", "", "getCreatedHolders", "()Ljava/util/WeakHashMap;", "setCreatedHolders", "(Ljava/util/WeakHashMap;)V", "value", "", "Lcom/obric/oui/banner/BannerData;", "dataSet", "getDataSet", "()Ljava/util/List;", "setDataSet", "(Ljava/util/List;)V", "mBannerGridConfig", "Lcom/obric/oui/banner/configs/IBannerConfig;", "mBannerItemClickListener", "Lcom/obric/oui/banner/interfaces/OnBannerItemClickListener;", "useInfiniteItemCount", "", "getUseInfiniteItemCount", "()Z", "setUseInfiniteItemCount", "(Z)V", "viewHolderFactoryList", "", "Lcom/obric/oui/banner/IBannerViewHolderFactory;", "viewHolderFactoryMap", "", "", "getItemCount", "", "getItemViewType", "position", "getRealItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "registerViewHolder", "factory", "release", "setBannerConfig", "config", "setBannerItemClickListener", "onBannerClickListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerAdapter extends RecyclerView.Adapter<BannerViewHolder> {
    private final BannerOperator bannerOperator;
    private WeakHashMap<BannerViewHolder, Unit> createdHolders;
    private List<? extends BannerData> dataSet;
    private IBannerConfig mBannerGridConfig;
    private OnBannerItemClickListener mBannerItemClickListener;
    private boolean useInfiniteItemCount;
    private final List<IBannerViewHolderFactory> viewHolderFactoryList;
    private final Map<String, IBannerViewHolderFactory> viewHolderFactoryMap;

    /* JADX INFO: renamed from: $r8$lambda$c2Ty1ObBhdkdXjdPHT2GJ-wX_zw, reason: not valid java name */
    public static /* synthetic */ void m1057$r8$lambda$c2Ty1ObBhdkdXjdPHT2GJwX_zw(BannerAdapter r0, View r1) {
        m1058onBindViewHolder$lambda0(r0, r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((BannerViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r1) {
        onViewAttachedToWindow((BannerViewHolder) r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder r1) {
        onViewDetachedFromWindow((BannerViewHolder) r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder r1) {
        onViewRecycled((BannerViewHolder) r1);
    }

    public BannerAdapter(BannerOperator r2) {
        Intrinsics.checkNotNullParameter(r2, "bannerOperator");
        this.bannerOperator = r2;
        this.viewHolderFactoryMap = new LinkedHashMap();
        this.viewHolderFactoryList = new ArrayList();
        this.createdHolders = new WeakHashMap();
        this.dataSet = CollectionsKt.emptyList();
        this.useInfiniteItemCount = true;
        registerViewHolder(StubViewHolder.Companion);
    }

    public final WeakHashMap<BannerViewHolder, Unit> getCreatedHolders() {
        return this.createdHolders;
    }

    public final void setCreatedHolders(WeakHashMap<BannerViewHolder, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.createdHolders = r2;
    }

    public final List<BannerData> getDataSet() {
        return this.dataSet;
    }

    public final void setDataSet(List<? extends BannerData> r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.dataSet = r2;
        notifyDataSetChanged();
    }

    public final boolean getUseInfiniteItemCount() {
        return this.useInfiniteItemCount;
    }

    public final void setUseInfiniteItemCount(boolean r1) {
        this.useInfiniteItemCount = r1;
    }

    public final void registerViewHolder(IBannerViewHolderFactory r3) {
        Intrinsics.checkNotNullParameter(r3, "factory");
        this.viewHolderFactoryMap.put(r3.getKey(), r3);
        this.viewHolderFactoryList.add(r3);
    }

    public final int getRealItemCount() {
        return this.dataSet.size();
    }

    public final void setBannerItemClickListener(OnBannerItemClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onBannerClickListener");
        this.mBannerItemClickListener = r2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.useInfiniteItemCount == false) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return this.dataSet.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BannerViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        if (this.viewHolderFactoryList.isEmpty() == true) goto L7;
        BannerViewHolder r4 = this.viewHolderFactoryList.get(r3).newInstance(r2);
        r4.setBannerOperator(this.bannerOperator);
        return r4;
    L7:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }

    public void onBindViewHolder(BannerViewHolder r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        int r6 = BannerUtils.INSTANCE.getRealPosition(this.useInfiniteItemCount, r5, getRealItemCount());
        if (this.dataSet.isEmpty() == false) goto L6;
        r4.onBind(r6, new StubBannerData());
        return;
    L6:
        BannerData r0 = this.dataSet.get(r6);
        if ((r0 instanceof GridBannerData) == false) goto L9;
        ((GridBannerData) r0).setBannerGridConfig(this.mBannerGridConfig);
    L9:
        r4.onBind(r6, r0);
        r4.itemView.setTag(R.id.banner_pos_key, Integer.valueOf(r6));
        if (r4.itemView.hasOnClickListeners() == true) goto L13;
        r4.itemView.setOnClickListener(new BannerAdapter$$ExternalSyntheticLambda0(this));
        return;
    }

    /* JADX INFO: renamed from: onBindViewHolder$lambda-0, reason: not valid java name */
    private static final void m1058onBindViewHolder$lambda0(BannerAdapter r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Object r3 = r2.getTag(R.id.banner_pos_key);
        if (r3 == null) goto L10;
        int r4 = ((Integer) r3).intValue();
        OnBannerItemClickListener r0 = r1.mBannerItemClickListener;
        if (r0 == null) goto L11;
        r0.onItemClick(r1.dataSet.get(r4), r4);
        return;
    L11:
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r3) {
        if (this.viewHolderFactoryList.isEmpty() == true) goto L11;
        if (this.dataSet.isEmpty() == false) goto L7;
        String r4 = StubViewHolder.Companion.getKey();
    L8:
        IBannerViewHolderFactory r5 = this.viewHolderFactoryMap.get(r4);
        return CollectionsKt.indexOf(this.viewHolderFactoryList, r5);
    L7:
        List<? extends BannerData> r0 = this.dataSet;
        r4 = r0.get(r3 % r0.size()).getHolderKey();
        goto L8
    L11:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }

    public void onViewAttachedToWindow(BannerViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.onViewAttachedToWindow(r2);
        r2.onAttach();
        this.createdHolders.put(r2, Unit.INSTANCE);
    }

    public void onViewDetachedFromWindow(BannerViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.onViewDetachedFromWindow(r2);
        r2.onDetach();
        this.createdHolders.remove(r2);
    }

    public void onViewRecycled(BannerViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.onViewRecycled(r2);
        r2.onViewRecycled();
    }

    public final void release() {
        Iterator<Map.Entry<BannerViewHolder, Unit>> r1 = this.createdHolders.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().getKey().onDetach();
        goto L4
    }

    public final void setBannerConfig(IBannerConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.mBannerGridConfig = r2;
    }
}
