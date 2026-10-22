package com.obric.security.health.model;

import com.bytedance.apm.constant.SlardarConfigConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003JY\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010'\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000f¨\u0006+"}, d2 = {"Lcom/obric/security/health/model/HealthCheckItemPresentation;", "", SlardarConfigConsts.CONFIG_ID, "", "moduleId", "titleResId", "", "completedTitleResId", "problemTitleResId", "actionTextResId", "score", "fixCapability", "Lcom/obric/security/health/model/HealthFixCapability;", "(Ljava/lang/String;Ljava/lang/String;IIIIILcom/obric/security/health/model/HealthFixCapability;)V", "getActionTextResId", "()I", "getCompletedTitleResId", "getFixCapability", "()Lcom/obric/security/health/model/HealthFixCapability;", "getId", "()Ljava/lang/String;", "isAutoFixable", "", "()Z", "isFixable", "isNavigateFixable", "getModuleId", "getProblemTitleResId", "getScore", "getTitleResId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthCheckItemPresentation {
    private final int actionTextResId;
    private final int completedTitleResId;
    private final HealthFixCapability fixCapability;
    private final String id;
    private final String moduleId;
    private final int problemTitleResId;
    private final int score;
    private final int titleResId;

    public static /* synthetic */ HealthCheckItemPresentation copy$default(HealthCheckItemPresentation r9, String r10, String r11, int r12, int r13, int r14, int r15, int r16, HealthFixCapability r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.id;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.moduleId;
    L11:
        if ((r18 & 4) == 0) goto L13;
        int r4 = r9.titleResId;
    L15:
        if ((r18 & 8) == 0) goto L17;
        int r5 = r9.completedTitleResId;
    L19:
        if ((r18 & 16) == 0) goto L21;
        int r6 = r9.problemTitleResId;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = r9.actionTextResId;
    L27:
        if ((r18 & 64) == 0) goto L29;
        int r8 = r9.score;
    L31:
        if ((r18 & 128) == 0) goto L33;
        HealthFixCapability r1 = r9.fixCapability;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.moduleId;
    }

    public final int component3() {
        return this.titleResId;
    }

    public final int component4() {
        return this.completedTitleResId;
    }

    public final int component5() {
        return this.problemTitleResId;
    }

    public final int component6() {
        return this.actionTextResId;
    }

    public final int component7() {
        return this.score;
    }

    public final HealthFixCapability component8() {
        return this.fixCapability;
    }

    public final HealthCheckItemPresentation copy(String r11, String r12, int r13, int r14, int r15, int r16, int r17, HealthFixCapability r18) {
        Intrinsics.checkNotNullParameter(r11, SlardarConfigConsts.CONFIG_ID);
        Intrinsics.checkNotNullParameter(r12, "moduleId");
        Intrinsics.checkNotNullParameter(r18, "fixCapability");
        return new HealthCheckItemPresentation(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HealthCheckItemPresentation) == false) goto L22;
        HealthCheckItemPresentation r4 = (HealthCheckItemPresentation) r3;
        if (Intrinsics.areEqual(this.id, r4.id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.moduleId, r4.moduleId) == true) goto L10;
        return false;
    L10:
        if (this.titleResId == r4.titleResId) goto L12;
        return false;
    L12:
        if (this.completedTitleResId == r4.completedTitleResId) goto L14;
        return false;
    L14:
        if (this.problemTitleResId == r4.problemTitleResId) goto L16;
        return false;
    L16:
        if (this.actionTextResId == r4.actionTextResId) goto L18;
        return false;
    L18:
        if (this.score == r4.score) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.fixCapability, r4.fixCapability) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.moduleId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((((((((((r3 + r5) * 31) + Integer.hashCode(this.titleResId)) * 31) + Integer.hashCode(this.completedTitleResId)) * 31) + Integer.hashCode(this.problemTitleResId)) * 31) + Integer.hashCode(this.actionTextResId)) * 31) + Integer.hashCode(this.score)) * 31;
        HealthFixCapability r7 = this.fixCapability;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HealthCheckItemPresentation(id=" + this.id + ", moduleId=" + this.moduleId + ", titleResId=" + this.titleResId + ", completedTitleResId=" + this.completedTitleResId + ", problemTitleResId=" + this.problemTitleResId + ", actionTextResId=" + this.actionTextResId + ", score=" + this.score + ", fixCapability=" + this.fixCapability + ")";
    }

    public HealthCheckItemPresentation(String r2, String r3, int r4, int r5, int r6, int r7, int r8, HealthFixCapability r9) {
        Intrinsics.checkNotNullParameter(r2, SlardarConfigConsts.CONFIG_ID);
        Intrinsics.checkNotNullParameter(r3, "moduleId");
        Intrinsics.checkNotNullParameter(r9, "fixCapability");
        this.id = r2;
        this.moduleId = r3;
        this.titleResId = r4;
        this.completedTitleResId = r5;
        this.problemTitleResId = r6;
        this.actionTextResId = r7;
        this.score = r8;
        this.fixCapability = r9;
    }

    public final String getId() {
        return this.id;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public final int getCompletedTitleResId() {
        return this.completedTitleResId;
    }

    public final int getProblemTitleResId() {
        return this.problemTitleResId;
    }

    public final int getActionTextResId() {
        return this.actionTextResId;
    }

    public final int getScore() {
        return this.score;
    }

    public final HealthFixCapability getFixCapability() {
        return this.fixCapability;
    }

    public final boolean isFixable() {
        if (this.fixCapability == HealthFixCapability.NONE) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isAutoFixable() {
        if (this.fixCapability != HealthFixCapability.AUTO) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNavigateFixable() {
        if (this.fixCapability != HealthFixCapability.NAVIGATE) goto L5;
        return true;
    L5:
        return false;
    }
}
