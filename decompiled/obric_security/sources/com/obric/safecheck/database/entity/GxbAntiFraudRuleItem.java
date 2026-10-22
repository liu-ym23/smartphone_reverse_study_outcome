package com.obric.safecheck.database.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GxbAntiFraudRuleItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b5\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010>\u001a\u00020\fHÆ\u0003J\t\u0010?\u001a\u00020\fHÆ\u0003J\u009b\u0001\u0010@\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\fHÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R\u001e\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0014\"\u0004\b2\u0010\u0016¨\u0006F"}, d2 = {"Lcom/obric/safecheck/database/entity/GxbAntiFraudRuleItem;", "", "ruleNo", "", "ruleId", "", "appMd5", "area", "areaType", "disposeTime", "packetName", "ruleState", "", "ruleType", "signMd5", "signSha1", "signSha256", "version", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppMd5", "()Ljava/lang/String;", "setAppMd5", "(Ljava/lang/String;)V", "getArea", "setArea", "getAreaType", "setAreaType", "getDisposeTime", "setDisposeTime", "getPacketName", "setPacketName", "getRuleId", "()J", "setRuleId", "(J)V", "getRuleNo", "setRuleNo", "getRuleState", "()I", "setRuleState", "(I)V", "getRuleType", "setRuleType", "getSignMd5", "setSignMd5", "getSignSha1", "setSignSha1", "getSignSha256", "setSignSha256", "getVersion", "setVersion", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbAntiFraudRuleItem {
    private String appMd5;
    private String area;
    private String areaType;
    private String disposeTime;
    private String packetName;
    private long ruleId;
    private String ruleNo;
    private int ruleState;
    private int ruleType;
    private String signMd5;
    private String signSha1;
    private String signSha256;
    private String version;

    public GxbAntiFraudRuleItem() {
        this(null, 0, null, null, null, null, null, 0, 0, null, null, null, null, 8191, null);
    }

    public static /* synthetic */ GxbAntiFraudRuleItem copy$default(GxbAntiFraudRuleItem r15, String r16, long r17, String r19, String r20, String r21, String r22, String r23, int r24, int r25, String r26, String r27, String r28, String r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        String r2 = r15.ruleNo;
    L7:
        if ((r30 & 2) == 0) goto L9;
        long r3 = r15.ruleId;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r5 = r15.appMd5;
    L15:
        if ((r30 & 8) == 0) goto L17;
        String r6 = r15.area;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r7 = r15.areaType;
    L23:
        if ((r30 & 32) == 0) goto L25;
        String r8 = r15.disposeTime;
    L27:
        if ((r30 & 64) == 0) goto L29;
        String r9 = r15.packetName;
    L31:
        if ((r30 & 128) == 0) goto L33;
        int r10 = r15.ruleState;
    L35:
        if ((r30 & 256) == 0) goto L37;
        int r11 = r15.ruleType;
    L39:
        if ((r30 & 512) == 0) goto L41;
        String r12 = r15.signMd5;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        String r13 = r15.signSha1;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        String r14 = r15.signSha256;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        String r1 = r15.version;
    L55:
        return r15.copy(r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r1);
    L53:
        r1 = r29;
        goto L55
    L49:
        r14 = r28;
        goto L51
    L45:
        r13 = r27;
        goto L47
    L41:
        r12 = r26;
        goto L43
    L37:
        r11 = r25;
        goto L39
    L33:
        r10 = r24;
        goto L35
    L29:
        r9 = r23;
        goto L31
    L25:
        r8 = r22;
        goto L27
    L21:
        r7 = r21;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r5 = r19;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final String component1() {
        return this.ruleNo;
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

    public final String component13() {
        return this.version;
    }

    public final long component2() {
        return this.ruleId;
    }

    public final String component3() {
        return this.appMd5;
    }

    public final String component4() {
        return this.area;
    }

    public final String component5() {
        return this.areaType;
    }

    public final String component6() {
        return this.disposeTime;
    }

    public final String component7() {
        return this.packetName;
    }

    public final int component8() {
        return this.ruleState;
    }

    public final int component9() {
        return this.ruleType;
    }

    public final GxbAntiFraudRuleItem copy(String r17, long r18, String r20, String r21, String r22, String r23, String r24, int r25, int r26, String r27, String r28, String r29, String r30) {
        Intrinsics.checkNotNullParameter(r17, "ruleNo");
        Intrinsics.checkNotNullParameter(r30, "version");
        return new GxbAntiFraudRuleItem(r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof GxbAntiFraudRuleItem) == false) goto L32;
        GxbAntiFraudRuleItem r6 = (GxbAntiFraudRuleItem) r5;
        if (Intrinsics.areEqual(this.ruleNo, r6.ruleNo) == true) goto L8;
        return false;
    L8:
        if (this.ruleId == r6.ruleId) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.appMd5, r6.appMd5) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.area, r6.area) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.areaType, r6.areaType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.disposeTime, r6.disposeTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.packetName, r6.packetName) == true) goto L20;
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
        if (Intrinsics.areEqual(this.signSha256, r6.signSha256) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.version, r6.version) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        String r0 = this.ruleNo;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + Long.hashCode(this.ruleId)) * 31;
        String r4 = this.appMd5;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.area;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.areaType;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.disposeTime;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.packetName;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (((((r15 + r17) * 31) + Integer.hashCode(this.ruleState)) * 31) + Integer.hashCode(this.ruleType)) * 31;
        String r19 = this.signMd5;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.signSha1;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.signSha256;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.version;
        if (r28 == null) goto L42;
        r1 = r28.hashCode();
    L42:
        return r27 + r1;
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
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
        return "GxbAntiFraudRuleItem(ruleNo=" + this.ruleNo + ", ruleId=" + this.ruleId + ", appMd5=" + this.appMd5 + ", area=" + this.area + ", areaType=" + this.areaType + ", disposeTime=" + this.disposeTime + ", packetName=" + this.packetName + ", ruleState=" + this.ruleState + ", ruleType=" + this.ruleType + ", signMd5=" + this.signMd5 + ", signSha1=" + this.signSha1 + ", signSha256=" + this.signSha256 + ", version=" + this.version + ")";
    }

    public GxbAntiFraudRuleItem(String r2, long r3, String r5, String r6, String r7, String r8, String r9, int r10, int r11, String r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r2, "ruleNo");
        Intrinsics.checkNotNullParameter(r15, "version");
        this.ruleNo = r2;
        this.ruleId = r3;
        this.appMd5 = r5;
        this.area = r6;
        this.areaType = r7;
        this.disposeTime = r8;
        this.packetName = r9;
        this.ruleState = r10;
        this.ruleType = r11;
        this.signMd5 = r12;
        this.signSha1 = r13;
        this.signSha256 = r14;
        this.version = r15;
    }

    public final String getRuleNo() {
        return this.ruleNo;
    }

    public final void setRuleNo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.ruleNo = r2;
    }

    public final long getRuleId() {
        return this.ruleId;
    }

    public final void setRuleId(long r1) {
        this.ruleId = r1;
    }

    public /* synthetic */ GxbAntiFraudRuleItem(String r17, long r18, String r20, String r21, String r22, String r23, String r24, int r25, int r26, String r27, String r28, String r29, String r30, int r31, DefaultConstructorMarker r32) {
        String r2 = "";
        if ((r31 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r31 & 2) == 0) goto L9;
        long r3 = 0;
    L10:
        String r6 = null;
        if ((r31 & 4) == 0) goto L13;
        String r5 = (String) null;
        String r7 = null;
    L15:
        if ((r31 & 8) == 0) goto L17;
        String r8 = (String) null;
        String r9 = null;
    L19:
        if ((r31 & 16) == 0) goto L21;
        String r10 = (String) null;
        String r11 = null;
    L23:
        if ((r31 & 32) == 0) goto L25;
        String r12 = (String) null;
        String r13 = null;
    L27:
        if ((r31 & 64) == 0) goto L29;
        String r14 = (String) null;
        String r15 = null;
    L30:
        int r16 = 0;
        if ((r31 & 128) == 0) goto L33;
        int r19 = 0;
    L35:
        if ((r31 & 256) != 0) goto L39;
        r16 = r26;
    L39:
        if ((r31 & 512) == 0) goto L41;
        String r110 = (String) null;
        String r111 = null;
    L43:
        if ((r31 & 1024) == 0) goto L45;
        String r112 = (String) null;
        String r113 = null;
    L47:
        if ((r31 & 2048) == 0) goto L49;
        String r114 = (String) null;
    L51:
        if ((r31 & 4096) != 0) goto L54;
        r2 = r30;
    L54:
        this(r1, r3, r7, r9, r11, r13, r15, r19, r16, r111, r113, r6, r2);
        return;
    L49:
        r6 = r29;
        goto L51
    L45:
        r113 = r28;
        goto L47
    L41:
        r111 = r27;
        goto L43
    L33:
        r19 = r25;
        goto L35
    L29:
        r15 = r24;
        goto L30
    L25:
        r13 = r23;
        goto L27
    L21:
        r11 = r22;
        goto L23
    L17:
        r9 = r21;
        goto L19
    L13:
        r7 = r20;
        goto L15
    L9:
        r3 = r18;
        goto L10
    L5:
        r1 = r17;
        goto L7
    }

    public final String getAppMd5() {
        return this.appMd5;
    }

    public final void setAppMd5(String r1) {
        this.appMd5 = r1;
    }

    public final String getArea() {
        return this.area;
    }

    public final void setArea(String r1) {
        this.area = r1;
    }

    public final String getAreaType() {
        return this.areaType;
    }

    public final void setAreaType(String r1) {
        this.areaType = r1;
    }

    public final String getDisposeTime() {
        return this.disposeTime;
    }

    public final void setDisposeTime(String r1) {
        this.disposeTime = r1;
    }

    public final String getPacketName() {
        return this.packetName;
    }

    public final void setPacketName(String r1) {
        this.packetName = r1;
    }

    public final int getRuleState() {
        return this.ruleState;
    }

    public final void setRuleState(int r1) {
        this.ruleState = r1;
    }

    public final int getRuleType() {
        return this.ruleType;
    }

    public final void setRuleType(int r1) {
        this.ruleType = r1;
    }

    public final String getSignMd5() {
        return this.signMd5;
    }

    public final void setSignMd5(String r1) {
        this.signMd5 = r1;
    }

    public final String getSignSha1() {
        return this.signSha1;
    }

    public final void setSignSha1(String r1) {
        this.signSha1 = r1;
    }

    public final String getSignSha256() {
        return this.signSha256;
    }

    public final void setSignSha256(String r1) {
        this.signSha256 = r1;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.version = r2;
    }
}
