package com.obric.safecheck.riskcontrol.ui;

import com.bytedanceos.preventdisturb.Contact;
import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RiskAppDetailViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/obric/safecheck/riskcontrol/ui/RiskAppDetailUiState;", "", Contact.CONTENT_SCHEME, "Lcom/obric/safecheck/riskcontrol/ui/RiskAppContentUiInfo;", "appInfo", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;", "controlFlags", "", SafeCushionConstant.FINISH_STATE, "", "(Lcom/obric/safecheck/riskcontrol/ui/RiskAppContentUiInfo;Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;IZ)V", "getAppInfo", "()Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;", "getContent", "()Lcom/obric/safecheck/riskcontrol/ui/RiskAppContentUiInfo;", "getControlFlags", "()I", "getFinish", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskAppDetailUiState {
    private final RiskAppUiInfo appInfo;
    private final RiskAppContentUiInfo content;
    private final int controlFlags;
    private final boolean finish;

    public RiskAppDetailUiState() {
        this(null, null, 0, false, 15, null);
    }

    public static /* synthetic */ RiskAppDetailUiState copy$default(RiskAppDetailUiState r0, RiskAppContentUiInfo r1, RiskAppUiInfo r2, int r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.content;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.appInfo;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.controlFlags;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.finish;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final RiskAppContentUiInfo component1() {
        return this.content;
    }

    public final RiskAppUiInfo component2() {
        return this.appInfo;
    }

    public final int component3() {
        return this.controlFlags;
    }

    public final boolean component4() {
        return this.finish;
    }

    public final RiskAppDetailUiState copy(RiskAppContentUiInfo r1, RiskAppUiInfo r2, int r3, boolean r4) {
        return new RiskAppDetailUiState(r1, r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof RiskAppDetailUiState) == false) goto L14;
        RiskAppDetailUiState r4 = (RiskAppDetailUiState) r3;
        if (Intrinsics.areEqual(this.content, r4.content) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.appInfo, r4.appInfo) == true) goto L10;
        return false;
    L10:
        if (this.controlFlags == r4.controlFlags) goto L12;
        return false;
    L12:
        if (this.finish == r4.finish) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        RiskAppContentUiInfo r0 = this.content;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        RiskAppUiInfo r4 = this.appInfo;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (((r3 + r1) * 31) + Integer.hashCode(this.controlFlags)) * 31;
        boolean r6 = this.finish;
        ?? r7 = r6;
        if (r6 == false) goto L13;
        r7 = 1;
    L13:
        return r5 + r7;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "RiskAppDetailUiState(content=" + this.content + ", appInfo=" + this.appInfo + ", controlFlags=" + this.controlFlags + ", finish=" + this.finish + ")";
    }

    public RiskAppDetailUiState(RiskAppContentUiInfo r1, RiskAppUiInfo r2, int r3, boolean r4) {
        this.content = r1;
        this.appInfo = r2;
        this.controlFlags = r3;
        this.finish = r4;
    }

    public /* synthetic */ RiskAppDetailUiState(RiskAppContentUiInfo r2, RiskAppUiInfo r3, int r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        RiskAppContentUiInfo r8 = (RiskAppContentUiInfo) null;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        RiskAppUiInfo r9 = (RiskAppUiInfo) null;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = false;
    L14:
        this(r2, r3, r4, r5);
    }

    public final RiskAppContentUiInfo getContent() {
        return this.content;
    }

    public final RiskAppUiInfo getAppInfo() {
        return this.appInfo;
    }

    public final int getControlFlags() {
        return this.controlFlags;
    }

    public final boolean getFinish() {
        return this.finish;
    }
}
