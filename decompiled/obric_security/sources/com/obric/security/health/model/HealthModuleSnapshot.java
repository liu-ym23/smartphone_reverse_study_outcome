package com.obric.security.health.model;

import com.bytedance.apm.constant.SlardarConfigConsts;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\""}, d2 = {"Lcom/obric/security/health/model/HealthModuleSnapshot;", "", SlardarConfigConsts.CONFIG_ID, "", "titleResId", "", "iconResId", "maxScore", "earnedScore", "items", "", "Lcom/obric/security/health/model/HealthCheckItemSnapshot;", "(Ljava/lang/String;IIIILjava/util/List;)V", "getEarnedScore", "()I", "getIconResId", "getId", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "getMaxScore", "getTitleResId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthModuleSnapshot {
    private final int earnedScore;
    private final int iconResId;
    private final String id;
    private final List<HealthCheckItemSnapshot> items;
    private final int maxScore;
    private final int titleResId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HealthModuleSnapshot copy$default(HealthModuleSnapshot r4, String r5, int r6, int r7, int r8, int r9, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.id;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.titleResId;
    L8:
        int r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.iconResId;
    L11:
        int r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.maxScore;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.earnedScore;
    L17:
        int r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.items;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.id;
    }

    public final int component2() {
        return this.titleResId;
    }

    public final int component3() {
        return this.iconResId;
    }

    public final int component4() {
        return this.maxScore;
    }

    public final int component5() {
        return this.earnedScore;
    }

    public final List<HealthCheckItemSnapshot> component6() {
        return this.items;
    }

    public final HealthModuleSnapshot copy(String r8, int r9, int r10, int r11, int r12, List<HealthCheckItemSnapshot> r13) {
        Intrinsics.checkNotNullParameter(r8, SlardarConfigConsts.CONFIG_ID);
        Intrinsics.checkNotNullParameter(r13, "items");
        return new HealthModuleSnapshot(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HealthModuleSnapshot) == false) goto L18;
        HealthModuleSnapshot r4 = (HealthModuleSnapshot) r3;
        if (Intrinsics.areEqual(this.id, r4.id) == true) goto L8;
        return false;
    L8:
        if (this.titleResId == r4.titleResId) goto L10;
        return false;
    L10:
        if (this.iconResId == r4.iconResId) goto L12;
        return false;
    L12:
        if (this.maxScore == r4.maxScore) goto L14;
        return false;
    L14:
        if (this.earnedScore == r4.earnedScore) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.items, r4.items) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((((((r2 * 31) + Integer.hashCode(this.titleResId)) * 31) + Integer.hashCode(this.iconResId)) * 31) + Integer.hashCode(this.maxScore)) * 31) + Integer.hashCode(this.earnedScore)) * 31;
        List<HealthCheckItemSnapshot> r4 = this.items;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HealthModuleSnapshot(id=" + this.id + ", titleResId=" + this.titleResId + ", iconResId=" + this.iconResId + ", maxScore=" + this.maxScore + ", earnedScore=" + this.earnedScore + ", items=" + this.items + ")";
    }

    public HealthModuleSnapshot(String r2, int r3, int r4, int r5, int r6, List<HealthCheckItemSnapshot> r7) {
        Intrinsics.checkNotNullParameter(r2, SlardarConfigConsts.CONFIG_ID);
        Intrinsics.checkNotNullParameter(r7, "items");
        this.id = r2;
        this.titleResId = r3;
        this.iconResId = r4;
        this.maxScore = r5;
        this.earnedScore = r6;
        this.items = r7;
    }

    public final String getId() {
        return this.id;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final int getMaxScore() {
        return this.maxScore;
    }

    public final int getEarnedScore() {
        return this.earnedScore;
    }

    public final List<HealthCheckItemSnapshot> getItems() {
        return this.items;
    }
}
