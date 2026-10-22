package com.obric.security.mainpage.delegate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.drakeet.multitype.ItemViewDelegate;
import com.obric.security.R;
import com.obric.security.mainpage.delegate.data.KeyFeatureData;
import com.obric.security.mainpage.delegate.viewholder.KeyFeatureViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyFeatureDelegate.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/security/mainpage/delegate/KeyFeatureDelegate;", "Lcom/drakeet/multitype/ItemViewDelegate;", "Lcom/obric/security/mainpage/delegate/data/KeyFeatureData;", "Lcom/obric/security/mainpage/delegate/viewholder/KeyFeatureViewHolder;", "()V", "onBindViewHolder", "", "holder", "item", "onCreateViewHolder", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "onViewDetachedFromWindow", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class KeyFeatureDelegate extends ItemViewDelegate<KeyFeatureData, KeyFeatureViewHolder> {
    public KeyFeatureDelegate() {
    }

    @Override // com.drakeet.multitype.ItemViewDelegate
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, KeyFeatureData r2) {
        onBindViewHolder((KeyFeatureViewHolder) r1, r2);
    }

    @Override // com.drakeet.multitype.ItemViewDelegate
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(Context r1, ViewGroup r2) {
        return onCreateViewHolder(r1, r2);
    }

    @Override // com.drakeet.multitype.ItemViewDelegate
    public /* bridge */ /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder r1) {
        onViewDetachedFromWindow((KeyFeatureViewHolder) r1);
    }

    public void onBindViewHolder(KeyFeatureViewHolder r1, KeyFeatureData r2) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        Intrinsics.checkNotNullParameter(r2, "item");
        r1.onBind(r2);
    }

    public void onViewDetachedFromWindow(KeyFeatureViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.onViewDetachedFromWindow(r2);
    }

    @Override // com.drakeet.multitype.ItemViewDelegate
    public KeyFeatureViewHolder onCreateViewHolder(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r5 = LayoutInflater.from(r3).inflate(R.layout.key_feature_layout, r4, false);
        Intrinsics.checkNotNullExpressionValue(r5, "LayoutInflater.from(cont…re_layout, parent, false)");
        return new KeyFeatureViewHolder(r5);
    }
}
