package com.obric.vault.feat.main.diffutil;

import com.obric.oui.orecyclerview.widget.DiffUtil;
import com.obric.security.battertpower.powerHigh.notice.PowerHighApp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PowerHighAppsDiffCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/vault/feat/main/diffutil/PowerHighAppsDiffCallback;", "Lcom/obric/oui/orecyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/obric/security/battertpower/powerHigh/notice/PowerHighApp;", "newList", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PowerHighAppsDiffCallback extends DiffUtil.Callback {
    private final List<PowerHighApp> newList;
    private final List<PowerHighApp> oldList;

    @Override // com.obric.oui.orecyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int r1, int r2) {
        return true;
    }

    public PowerHighAppsDiffCallback(List<PowerHighApp> r2, List<PowerHighApp> r3) {
        Intrinsics.checkNotNullParameter(r2, "oldList");
        Intrinsics.checkNotNullParameter(r3, "newList");
        this.oldList = r2;
        this.newList = r3;
    }

    @Override // com.obric.oui.orecyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.oldList.size();
    }

    @Override // com.obric.oui.orecyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.newList.size();
    }

    @Override // com.obric.oui.orecyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int r2, int r3) {
        PowerHighApp r4 = this.oldList.get(r2);
        PowerHighApp r1 = this.newList.get(r3);
        return Intrinsics.areEqual(r4.getPackageName(), r1.getPackageName());
    }
}
