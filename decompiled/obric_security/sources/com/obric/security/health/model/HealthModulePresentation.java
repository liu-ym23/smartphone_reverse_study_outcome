package com.obric.security.health.model;

import com.bytedance.apm.constant.SlardarConfigConsts;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/obric/security/health/model/HealthModulePresentation;", "", SlardarConfigConsts.CONFIG_ID, "", "titleResId", "", "iconResId", "maxScore", "items", "", "Lcom/obric/security/health/model/HealthCheckItemPresentation;", "(Ljava/lang/String;IIILjava/util/List;)V", "getIconResId", "()I", "getId", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "getMaxScore", "getTitleResId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthModulePresentation {
    private final int iconResId;
    private final String id;
    private final List<HealthCheckItemPresentation> items;
    private final int maxScore;
    private final int titleResId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HealthModulePresentation copy$default(HealthModulePresentation r3, String r4, int r5, int r6, int r7, List r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.id;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.titleResId;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.iconResId;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.maxScore;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.items;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
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

    public final List<HealthCheckItemPresentation> component5() {
        return this.items;
    }

    public final HealthModulePresentation copy(String r7, int r8, int r9, int r10, List<HealthCheckItemPresentation> r11) {
        Intrinsics.checkNotNullParameter(r7, SlardarConfigConsts.CONFIG_ID);
        Intrinsics.checkNotNullParameter(r11, "items");
        return new HealthModulePresentation(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HealthModulePresentation) == false) goto L16;
        HealthModulePresentation r4 = (HealthModulePresentation) r3;
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
        if (Intrinsics.areEqual(this.items, r4.items) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((((r2 * 31) + Integer.hashCode(this.titleResId)) * 31) + Integer.hashCode(this.iconResId)) * 31) + Integer.hashCode(this.maxScore)) * 31;
        List<HealthCheckItemPresentation> r4 = this.items;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HealthModulePresentation(id=" + this.id + ", titleResId=" + this.titleResId + ", iconResId=" + this.iconResId + ", maxScore=" + this.maxScore + ", items=" + this.items + ")";
    }

    public HealthModulePresentation(String r2, int r3, int r4, int r5, List<HealthCheckItemPresentation> r6) {
        Intrinsics.checkNotNullParameter(r2, SlardarConfigConsts.CONFIG_ID);
        Intrinsics.checkNotNullParameter(r6, "items");
        this.id = r2;
        this.titleResId = r3;
        this.iconResId = r4;
        this.maxScore = r5;
        this.items = r6;
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

    public final List<HealthCheckItemPresentation> getItems() {
        return this.items;
    }
}
