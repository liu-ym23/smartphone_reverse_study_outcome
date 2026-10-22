package com.obric.safecheck.dataSync.miitAntiFraud;

import com.bytedance.apm.constant.SlardarConfigConsts;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GxbAntiFraudRule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\u0093\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\fHÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013¨\u00063"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAntiFraudRule;", "", SlardarConfigConsts.CONFIG_ID, "", "appMd5", "", "area", "areaType", "disposeTime", "packetName", "ruleNo", "ruleState", "", "ruleType", "signMd5", "signSha1", "signSha256", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppMd5", "()Ljava/lang/String;", "getArea", "getAreaType", "getDisposeTime", "getId", "()J", "getPacketName", "getRuleNo", "getRuleState", "()I", "getRuleType", "getSignMd5", "getSignSha1", "getSignSha256", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbAntiFraudRule {

    @SerializedName("appMd5")
    private final String appMd5;

    @SerializedName("area")
    private final String area;

    @SerializedName("areaType")
    private final String areaType;

    @SerializedName("disposeTime")
    private final String disposeTime;

    @SerializedName(SlardarConfigConsts.CONFIG_ID)
    private final long id;

    @SerializedName("packetName")
    private final String packetName;

    @SerializedName("ruleNo")
    private final String ruleNo;

    @SerializedName("ruleState")
    private final int ruleState;

    @SerializedName("ruleType")
    private final int ruleType;

    @SerializedName("signMd5")
    private final String signMd5;

    @SerializedName("signSha1")
    private final String signSha1;

    @SerializedName("signSha256")
    private final String signSha256;

    public GxbAntiFraudRule() {
        this(0, null, null, null, null, null, null, 0, 0, null, null, null, 4095, null);
    }

    public static /* synthetic */ GxbAntiFraudRule copy$default(GxbAntiFraudRule r14, long r15, String r17, String r18, String r19, String r20, String r21, String r22, int r23, int r24, String r25, String r26, String r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        long r2 = r14.id;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r4 = r14.appMd5;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r5 = r14.area;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r6 = r14.areaType;
    L19:
        if ((r28 & 16) == 0) goto L21;
        String r7 = r14.disposeTime;
    L23:
        if ((r28 & 32) == 0) goto L25;
        String r8 = r14.packetName;
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r9 = r14.ruleNo;
    L31:
        if ((r28 & 128) == 0) goto L33;
        int r10 = r14.ruleState;
    L35:
        if ((r28 & 256) == 0) goto L37;
        int r11 = r14.ruleType;
    L39:
        if ((r28 & 512) == 0) goto L41;
        String r12 = r14.signMd5;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        String r13 = r14.signSha1;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        String r1 = r14.signSha256;
    L51:
        return r14.copy(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r1);
    L49:
        r1 = r27;
        goto L51
    L45:
        r13 = r26;
        goto L47
    L41:
        r12 = r25;
        goto L43
    L37:
        r11 = r24;
        goto L39
    L33:
        r10 = r23;
        goto L35
    L29:
        r9 = r22;
        goto L31
    L25:
        r8 = r21;
        goto L27
    L21:
        r7 = r20;
        goto L23
    L17:
        r6 = r19;
        goto L19
    L13:
        r5 = r18;
        goto L15
    L9:
        r4 = r17;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component10() {
        return this.signMd5;
    }

    public final String component11() {
        return this.signSha1;
    }

    public final String component12() {
        return this.signSha256;
    }

    public final String component2() {
        return this.appMd5;
    }

    public final String component3() {
        return this.area;
    }

    public final String component4() {
        return this.areaType;
    }

    public final String component5() {
        return this.disposeTime;
    }

    public final String component6() {
        return this.packetName;
    }

    public final String component7() {
        return this.ruleNo;
    }

    public final int component8() {
        return this.ruleState;
    }

    public final int component9() {
        return this.ruleType;
    }

    public final GxbAntiFraudRule copy(long r16, String r18, String r19, String r20, String r21, String r22, String r23, int r24, int r25, String r26, String r27, String r28) {
        return new GxbAntiFraudRule(r16, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof GxbAntiFraudRule) == false) goto L30;
        GxbAntiFraudRule r6 = (GxbAntiFraudRule) r5;
        if (this.id == r6.id) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.appMd5, r6.appMd5) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.area, r6.area) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.areaType, r6.areaType) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.disposeTime, r6.disposeTime) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.packetName, r6.packetName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ruleNo, r6.ruleNo) == true) goto L20;
        return false;
    L20:
        if (this.ruleState == r6.ruleState) goto L22;
        return false;
    L22:
        if (this.ruleType == r6.ruleType) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.signMd5, r6.signMd5) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.signSha1, r6.signSha1) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.signSha256, r6.signSha256) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.id) * 31;
        String r1 = this.appMd5;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.area;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.areaType;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.disposeTime;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.packetName;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.ruleNo;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (((((r16 + r18) * 31) + Integer.hashCode(this.ruleState)) * 31) + Integer.hashCode(this.ruleType)) * 31;
        String r20 = this.signMd5;
        if (r20 == null) goto L29;
        int r21 = r20.hashCode();
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.signSha1;
        if (r23 == null) goto L33;
        int r24 = r23.hashCode();
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.signSha256;
        if (r26 == null) goto L38;
        r2 = r26.hashCode();
    L38:
        return r25 + r2;
    L33:
        r24 = 0;
        goto L34
    L29:
        r21 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return "GxbAntiFraudRule(id=" + this.id + ", appMd5=" + this.appMd5 + ", area=" + this.area + ", areaType=" + this.areaType + ", disposeTime=" + this.disposeTime + ", packetName=" + this.packetName + ", ruleNo=" + this.ruleNo + ", ruleState=" + this.ruleState + ", ruleType=" + this.ruleType + ", signMd5=" + this.signMd5 + ", signSha1=" + this.signSha1 + ", signSha256=" + this.signSha256 + ")";
    }

    public GxbAntiFraudRule(long r1, String r3, String r4, String r5, String r6, String r7, String r8, int r9, int r10, String r11, String r12, String r13) {
        this.id = r1;
        this.appMd5 = r3;
        this.area = r4;
        this.areaType = r5;
        this.disposeTime = r6;
        this.packetName = r7;
        this.ruleNo = r8;
        this.ruleState = r9;
        this.ruleType = r10;
        this.signMd5 = r11;
        this.signSha1 = r12;
        this.signSha256 = r13;
    }

    public final long getId() {
        return this.id;
    }

    public /* synthetic */ GxbAntiFraudRule(long r15, String r17, String r18, String r19, String r20, String r21, String r22, int r23, int r24, String r25, String r26, String r27, int r28, DefaultConstructorMarker r29) {
        if ((r28 & 1) == 0) goto L5;
        long r1 = 0;
    L6:
        String r4 = null;
        if ((r28 & 2) == 0) goto L9;
        String r3 = (String) null;
        String r5 = null;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r6 = (String) null;
        String r7 = null;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r8 = (String) null;
        String r9 = null;
    L19:
        if ((r28 & 16) == 0) goto L21;
        String r10 = (String) null;
        String r11 = null;
    L23:
        if ((r28 & 32) == 0) goto L25;
        String r12 = (String) null;
        String r13 = null;
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r14 = (String) null;
        String r16 = null;
    L30:
        int r110 = 0;
        if ((r28 & 128) == 0) goto L33;
        int r111 = 0;
    L35:
        if ((r28 & 256) != 0) goto L39;
        r110 = r24;
    L39:
        if ((r28 & 512) == 0) goto L41;
        String r112 = (String) null;
        String r113 = null;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        String r114 = (String) null;
        String r115 = null;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        String r0 = (String) null;
    L50:
        this(r1, r5, r7, r9, r11, r13, r16, r111, r110, r113, r115, r4);
        return;
    L49:
        r4 = r27;
        goto L50
    L45:
        r115 = r26;
        goto L47
    L41:
        r113 = r25;
        goto L43
    L33:
        r111 = r23;
        goto L35
    L29:
        r16 = r22;
        goto L30
    L25:
        r13 = r21;
        goto L27
    L21:
        r11 = r20;
        goto L23
    L17:
        r9 = r19;
        goto L19
    L13:
        r7 = r18;
        goto L15
    L9:
        r5 = r17;
        goto L11
    L5:
        r1 = r15;
        goto L6
    }

    public final String getAppMd5() {
        return this.appMd5;
    }

    public final String getArea() {
        return this.area;
    }

    public final String getAreaType() {
        return this.areaType;
    }

    public final String getDisposeTime() {
        return this.disposeTime;
    }

    public final String getPacketName() {
        return this.packetName;
    }

    public final String getRuleNo() {
        return this.ruleNo;
    }

    public final int getRuleState() {
        return this.ruleState;
    }

    public final int getRuleType() {
        return this.ruleType;
    }

    public final String getSignMd5() {
        return this.signMd5;
    }

    public final String getSignSha1() {
        return this.signSha1;
    }

    public final String getSignSha256() {
        return this.signSha256;
    }
}
