package com.obric.security.health.ui;

import com.bytedance.blockframework.interaction.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OptimizeTodoItemClickEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/security/health/ui/OptimizeTodoItemClickEvent;", "Lcom/bytedance/blockframework/interaction/Event;", "itemId", "", "(Ljava/lang/String;)V", "getItemId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class OptimizeTodoItemClickEvent extends Event {
    private final String itemId;

    public static /* synthetic */ OptimizeTodoItemClickEvent copy$default(OptimizeTodoItemClickEvent r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.itemId;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.itemId;
    }

    public final OptimizeTodoItemClickEvent copy(String r1) {
        Intrinsics.checkNotNullParameter(r1, "itemId");
        return new OptimizeTodoItemClickEvent(r1);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof OptimizeTodoItemClickEvent) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.itemId, ((OptimizeTodoItemClickEvent) r2).itemId) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        String r0 = this.itemId;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "OptimizeTodoItemClickEvent(itemId=" + this.itemId + ")";
    }

    public OptimizeTodoItemClickEvent(String r4) {
        Intrinsics.checkNotNullParameter(r4, "itemId");
        super(false, 1, null);
        this.itemId = r4;
    }

    public final String getItemId() {
        return this.itemId;
    }
}
