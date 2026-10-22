package com.obric.safecheck.riskcontrol.ui;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RiskAppListViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/safecheck/riskcontrol/ui/RiskAppListUiState;", "", "items", "", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppListItemUiState;", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskAppListUiState {
    private final List<RiskAppListItemUiState> items;

    /* JADX WARN: Multi-variable type inference failed */
    public RiskAppListUiState() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RiskAppListUiState copy$default(RiskAppListUiState r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.items;
    L6:
        return r0.copy(r1);
    }

    public final List<RiskAppListItemUiState> component1() {
        return this.items;
    }

    public final RiskAppListUiState copy(List<RiskAppListItemUiState> r1) {
        Intrinsics.checkNotNullParameter(r1, "items");
        return new RiskAppListUiState(r1);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof RiskAppListUiState) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.items, ((RiskAppListUiState) r2).items) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        List<RiskAppListItemUiState> r0 = this.items;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "RiskAppListUiState(items=" + this.items + ")";
    }

    public RiskAppListUiState(List<RiskAppListItemUiState> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.items = r2;
    }

    public /* synthetic */ RiskAppListUiState(List r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        this(r1);
    }

    public final List<RiskAppListItemUiState> getItems() {
        return this.items;
    }
}
