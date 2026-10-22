package com.obric.security.cleaner.cacheFragment.viewholder;

import android.view.View;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.fg.module.cleanV2.RubbishEntity;

/* JADX INFO: compiled from: UninstallCacheViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/security/cleaner/cacheFragment/viewholder/UninstallCacheViewHolder;", "Lcom/obric/security/cleaner/cacheFragment/viewholder/SoftCacheViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "onBind", "", "data", "Ltmsdk/fg/module/cleanV2/RubbishEntity;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class UninstallCacheViewHolder extends SoftCacheViewHolder {
    public UninstallCacheViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    @Override // com.obric.security.cleaner.cacheFragment.viewholder.SoftCacheViewHolder, com.obric.security.cleaner.cacheFragment.viewholder.RubbishBaseViewHolder
    public void onBind(RubbishEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        OLog.d("UninstallCacheViewHolder", "onBind: " + r3);
        super.onBind(r3);
    }
}
