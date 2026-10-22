package com.obric.security.health.model;

import com.bytedance.apm.constant.SlardarConfigConsts;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006¢\u0006\u0002\u0010\u0014J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0010HÆ\u0003J\u0015\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\t\u00105\u001a\u00020\fHÆ\u0003J\t\u00106\u001a\u00020\u000eHÆ\u0003J\u008d\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0006HÆ\u0001J\u0013\u00108\u001a\u00020\u00102\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0006HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b!\u0010 R\u0011\u0010\"\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0011\u0010#\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b#\u0010 R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 ¨\u0006<"}, d2 = {"Lcom/obric/security/health/model/HealthCheckItemSnapshot;", "", SlardarConfigConsts.CONFIG_ID, "", "moduleId", "titleResId", "", "completedTitleResId", "problemTitleResId", "actionTextResId", "score", "fixCapability", "Lcom/obric/security/health/model/HealthFixCapability;", "status", "Lcom/obric/security/health/model/HealthCheckStatus;", "visible", "", "evidence", "", "earnedScore", "(Ljava/lang/String;Ljava/lang/String;IIIIILcom/obric/security/health/model/HealthFixCapability;Lcom/obric/security/health/model/HealthCheckStatus;ZLjava/util/Map;I)V", "getActionTextResId", "()I", "getCompletedTitleResId", "getEarnedScore", "getEvidence", "()Ljava/util/Map;", "getFixCapability", "()Lcom/obric/security/health/model/HealthFixCapability;", "getId", "()Ljava/lang/String;", "isAutoFixable", "()Z", "isCompleted", "isFixable", "isNavigateFixable", "getModuleId", "getProblemTitleResId", "getScore", "getStatus", "()Lcom/obric/security/health/model/HealthCheckStatus;", "getTitleResId", "getVisible", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthCheckItemSnapshot {
    private final int actionTextResId;
    private final int completedTitleResId;
    private final int earnedScore;
    private final Map<String, String> evidence;
    private final HealthFixCapability fixCapability;
    private final String id;
    private final String moduleId;
    private final int problemTitleResId;
    private final int score;
    private final HealthCheckStatus status;
    private final int titleResId;
    private final boolean visible;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HealthCheckItemSnapshot copy$default(HealthCheckItemSnapshot r13, String r14, String r15, int r16, int r17, int r18, int r19, int r20, HealthFixCapability r21, HealthCheckStatus r22, boolean r23, Map r24, int r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        String r2 = r13.id;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r3 = r13.moduleId;
    L11:
        if ((r26 & 4) == 0) goto L13;
        int r4 = r13.titleResId;
    L15:
        if ((r26 & 8) == 0) goto L17;
        int r5 = r13.completedTitleResId;
    L19:
        if ((r26 & 16) == 0) goto L21;
        int r6 = r13.problemTitleResId;
    L23:
        if ((r26 & 32) == 0) goto L25;
        int r7 = r13.actionTextResId;
    L27:
        if ((r26 & 64) == 0) goto L29;
        int r8 = r13.score;
    L31:
        if ((r26 & 128) == 0) goto L33;
        HealthFixCapability r9 = r13.fixCapability;
    L35:
        if ((r26 & 256) == 0) goto L37;
        HealthCheckStatus r10 = r13.status;
    L39:
        if ((r26 & 512) == 0) goto L41;
        boolean r11 = r13.visible;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        Map r12 = r13.evidence;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        int r1 = r13.earnedScore;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final boolean component10() {
        return this.visible;
    }

    public final Map<String, String> component11() {
        return this.evidence;
    }

    public final int component12() {
        return this.earnedScore;
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

    public final HealthCheckStatus component9() {
        return this.status;
    }

    public final HealthCheckItemSnapshot copy(String r15, String r16, int r17, int r18, int r19, int r20, int r21, HealthFixCapability r22, HealthCheckStatus r23, boolean r24, Map<String, String> r25, int r26) {
        Intrinsics.checkNotNullParameter(r15, SlardarConfigConsts.CONFIG_ID);
        Intrinsics.checkNotNullParameter(r16, "moduleId");
        Intrinsics.checkNotNullParameter(r22, "fixCapability");
        Intrinsics.checkNotNullParameter(r23, "status");
        Intrinsics.checkNotNullParameter(r25, "evidence");
        return new HealthCheckItemSnapshot(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HealthCheckItemSnapshot) == false) goto L30;
        HealthCheckItemSnapshot r4 = (HealthCheckItemSnapshot) r3;
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
        if (Intrinsics.areEqual(this.fixCapability, r4.fixCapability) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.status, r4.status) == true) goto L24;
        return false;
    L24:
        if (this.visible == r4.visible) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.evidence, r4.evidence) == true) goto L28;
        return false;
    L28:
        if (this.earnedScore == r4.earnedScore) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v26 */
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
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        HealthCheckStatus r10 = this.status;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        boolean r13 = this.visible;
        ?? r14 = r13;
        if (r13 == false) goto L21;
        r14 = 1;
    L21:
        int r15 = (r12 + r14) * 31;
        Map<String, String> r16 = this.evidence;
        if (r16 == null) goto L25;
        r1 = r16.hashCode();
    L25:
        return ((r15 + r1) * 31) + Integer.hashCode(this.earnedScore);
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HealthCheckItemSnapshot(id=" + this.id + ", moduleId=" + this.moduleId + ", titleResId=" + this.titleResId + ", completedTitleResId=" + this.completedTitleResId + ", problemTitleResId=" + this.problemTitleResId + ", actionTextResId=" + this.actionTextResId + ", score=" + this.score + ", fixCapability=" + this.fixCapability + ", status=" + this.status + ", visible=" + this.visible + ", evidence=" + this.evidence + ", earnedScore=" + this.earnedScore + ")";
    }

    public HealthCheckItemSnapshot(String r2, String r3, int r4, int r5, int r6, int r7, int r8, HealthFixCapability r9, HealthCheckStatus r10, boolean r11, Map<String, String> r12, int r13) {
        Intrinsics.checkNotNullParameter(r2, SlardarConfigConsts.CONFIG_ID);
        Intrinsics.checkNotNullParameter(r3, "moduleId");
        Intrinsics.checkNotNullParameter(r9, "fixCapability");
        Intrinsics.checkNotNullParameter(r10, "status");
        Intrinsics.checkNotNullParameter(r12, "evidence");
        this.id = r2;
        this.moduleId = r3;
        this.titleResId = r4;
        this.completedTitleResId = r5;
        this.problemTitleResId = r6;
        this.actionTextResId = r7;
        this.score = r8;
        this.fixCapability = r9;
        this.status = r10;
        this.visible = r11;
        this.evidence = r12;
        this.earnedScore = r13;
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

    public final HealthCheckStatus getStatus() {
        return this.status;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public /* synthetic */ HealthCheckItemSnapshot(String r16, String r17, int r18, int r19, int r20, int r21, int r22, HealthFixCapability r23, HealthCheckStatus r24, boolean r25, Map r26, int r27, int r28, DefaultConstructorMarker r29) {
        if ((r28 & 1024) == 0) goto L5;
        Map r13 = MapsKt.emptyMap();
    L7:
        if ((r28 & 2048) != 0) goto L9;
        int r14 = r27;
    L14:
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r13, r14);
        return;
    L9:
        if (r24 != HealthCheckStatus.PASS) goto L11;
        int r0 = r22;
    L12:
        r14 = r0;
        goto L14
    L11:
        r0 = 0;
        goto L12
    L5:
        r13 = r26;
        goto L7
    }

    public final Map<String, String> getEvidence() {
        return this.evidence;
    }

    public final int getEarnedScore() {
        return this.earnedScore;
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

    public final boolean isCompleted() {
        if (this.status != HealthCheckStatus.PASS) goto L5;
        return true;
    L5:
        return false;
    }
}
