package com.obric.vault.feat.main.diffutil;

import androidx.recyclerview.widget.DiffUtil;
import com.obric.security.battertpower.AppPowerProfileData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsumptionRankDiffCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/vault/feat/main/diffutil/ConsumptionRankDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/obric/security/battertpower/AppPowerProfileData;", "newList", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ConsumptionRankDiffCallback extends DiffUtil.Callback {
    private final List<AppPowerProfileData> newList;
    private final List<AppPowerProfileData> oldList;

    public ConsumptionRankDiffCallback(List<AppPowerProfileData> r1, List<AppPowerProfileData> r2) {
        this.oldList = r1;
        this.newList = r2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        List<AppPowerProfileData> r0 = this.oldList;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        List<AppPowerProfileData> r0 = this.newList;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int r3, int r4) {
        List<AppPowerProfileData> r0 = this.oldList;
        String r1 = null;
        if (r0 == null) goto L5;
        AppPowerProfileData r5 = r0.get(r3);
    L6:
        List<AppPowerProfileData> r2 = this.newList;
        if (r2 == null) goto L9;
        AppPowerProfileData r6 = r2.get(r4);
    L10:
        if (r5 == null) goto L12;
        String r7 = r5.getPkg();
    L13:
        if (r6 == null) goto L16;
        r1 = r6.getPkg();
    L16:
        return Intrinsics.areEqual(r7, r1);
    L12:
        r7 = null;
        goto L13
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int r3, int r4) {
        List<AppPowerProfileData> r0 = this.oldList;
        String r1 = null;
        if (r0 == null) goto L5;
        AppPowerProfileData r5 = r0.get(r3);
    L6:
        List<AppPowerProfileData> r2 = this.newList;
        if (r2 == null) goto L9;
        AppPowerProfileData r6 = r2.get(r4);
    L10:
        if (r5 == null) goto L12;
        Float r7 = Float.valueOf(r5.getPercent());
    L13:
        if (r6 == null) goto L15;
        Float r8 = Float.valueOf(r6.getPercent());
    L17:
        if (Intrinsics.areEqual(r7, r8) == false) goto L26;
        if (r5 == null) goto L20;
        String r9 = r5.getDurationDesc();
    L21:
        if (r6 == null) goto L24;
        r1 = r6.getDurationDesc();
    L24:
        if (Intrinsics.areEqual(r9, r1) == false) goto L26;
        return true;
    L20:
        r9 = null;
    L26:
        return false;
    L15:
        r8 = null;
        goto L17
    L12:
        r7 = null;
        goto L13
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }
}
