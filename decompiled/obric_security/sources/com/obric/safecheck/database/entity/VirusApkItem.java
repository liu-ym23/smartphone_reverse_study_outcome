package com.obric.safecheck.database.entity;

import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: VirusApkItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JS\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/obric/safecheck/database/entity/VirusApkItem;", "", ApkVirusCheckProvider.KEY_PKG, "", ApkVirusCheckProvider.KEY_VIRUS_TYPE, ApkVirusCheckProvider.KEY_VIRUS_TYPE_CODE, "", "virusName", "virusDescription", "timestamp", "riskControlState", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPkg", "()Ljava/lang/String;", "getRiskControlState", "getTimestamp", "getVirusDescription", "getVirusName", "getVirusType", "getVirusTypeCode", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class VirusApkItem {
    private static final String CONTROLLED_VALUE = "1";
    public static final Companion Companion = null;
    private final String pkg;
    private final String riskControlState;
    private final String timestamp;
    private final String virusDescription;
    private final String virusName;
    private final String virusType;
    private final int virusTypeCode;

    /* JADX INFO: compiled from: VirusApkItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\b\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/safecheck/database/entity/VirusApkItem$Companion;", "", "()V", "CONTROLLED_VALUE", "", "isRiskControlled", "", "state", "parseRiskControlUserId", "", "riskControlState", AccountInfoBundleKey.USER_ID, "controlled", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final String riskControlState(int r1, boolean r2) {
            if (r2 == false) goto L4;
            String r0 = "1";
        L6:
            return r1 + ":" + r0;
        L4:
            r0 = "0";
            goto L6
        }

        public final int parseRiskControlUserId(String r2) {
            if (r2 == null) goto L8;
            String r1 = StringsKt.substringBefore(r2, ':', "");
            if (r1 == null) goto L8;
            Integer r3 = StringsKt.toIntOrNull(r1);
            if (r3 == null) goto L8;
            return r3.intValue();
        L8:
            return 0;
        }

        public final boolean isRiskControlled(String r2) {
            if (r2 == null) goto L4;
            String r1 = StringsKt.substringAfter(r2, ':', "");
        L6:
            return Intrinsics.areEqual(r1, "1");
        L4:
            r1 = null;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ VirusApkItem copy$default(VirusApkItem r5, String r6, String r7, int r8, String r9, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.pkg;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.virusType;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.virusTypeCode;
    L11:
        int r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.virusName;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.virusDescription;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.timestamp;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.riskControlState;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.pkg;
    }

    public final String component2() {
        return this.virusType;
    }

    public final int component3() {
        return this.virusTypeCode;
    }

    public final String component4() {
        return this.virusName;
    }

    public final String component5() {
        return this.virusDescription;
    }

    public final String component6() {
        return this.timestamp;
    }

    public final String component7() {
        return this.riskControlState;
    }

    public final VirusApkItem copy(String r9, String r10, int r11, String r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r9, ApkVirusCheckProvider.KEY_PKG);
        Intrinsics.checkNotNullParameter(r10, ApkVirusCheckProvider.KEY_VIRUS_TYPE);
        Intrinsics.checkNotNullParameter(r14, "timestamp");
        Intrinsics.checkNotNullParameter(r15, "riskControlState");
        return new VirusApkItem(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof VirusApkItem) == false) goto L20;
        VirusApkItem r4 = (VirusApkItem) r3;
        if (Intrinsics.areEqual(this.pkg, r4.pkg) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.virusType, r4.virusType) == true) goto L10;
        return false;
    L10:
        if (this.virusTypeCode == r4.virusTypeCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.virusName, r4.virusName) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.virusDescription, r4.virusDescription) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.timestamp, r4.timestamp) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.riskControlState, r4.riskControlState) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r0 = this.pkg;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.virusType;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((r3 + r5) * 31) + Integer.hashCode(this.virusTypeCode)) * 31;
        String r7 = this.virusName;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.virusDescription;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.timestamp;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.riskControlState;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
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
        return "VirusApkItem(pkg=" + this.pkg + ", virusType=" + this.virusType + ", virusTypeCode=" + this.virusTypeCode + ", virusName=" + this.virusName + ", virusDescription=" + this.virusDescription + ", timestamp=" + this.timestamp + ", riskControlState=" + this.riskControlState + ")";
    }

    public VirusApkItem(String r2, String r3, int r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        Intrinsics.checkNotNullParameter(r3, ApkVirusCheckProvider.KEY_VIRUS_TYPE);
        Intrinsics.checkNotNullParameter(r7, "timestamp");
        Intrinsics.checkNotNullParameter(r8, "riskControlState");
        this.pkg = r2;
        this.virusType = r3;
        this.virusTypeCode = r4;
        this.virusName = r5;
        this.virusDescription = r6;
        this.timestamp = r7;
        this.riskControlState = r8;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final String getVirusType() {
        return this.virusType;
    }

    public final int getVirusTypeCode() {
        return this.virusTypeCode;
    }

    public final String getVirusName() {
        return this.virusName;
    }

    public /* synthetic */ VirusApkItem(String r11, String r12, int r13, String r14, String r15, String r16, String r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 16) == 0) goto L5;
        String r1 = (String) null;
        String r7 = null;
    L7:
        if ((r18 & 64) == 0) goto L9;
        String r9 = "";
    L10:
        this(r11, r12, r13, r14, r7, r16, r9);
        return;
    L9:
        r9 = r17;
        goto L10
    L5:
        r7 = r15;
        goto L7
    }

    public final String getVirusDescription() {
        return this.virusDescription;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final String getRiskControlState() {
        return this.riskControlState;
    }
}
