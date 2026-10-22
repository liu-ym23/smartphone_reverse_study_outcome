package com.obric.security.mainpage.delegate.data;

import com.obric.security.battertpower.AppPowerProfileData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PowerRankFeatureData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/security/mainpage/delegate/data/PowerRankFeatureData;", "Lcom/obric/security/mainpage/delegate/data/Feature;", "key", "", "appData", "", "Lcom/obric/security/battertpower/AppPowerProfileData;", "(Ljava/lang/String;Ljava/util/List;)V", "getAppData", "()Ljava/util/List;", "getKey", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PowerRankFeatureData extends Feature {
    public static final Companion Companion = null;
    public static final int position = 3;
    private final List<AppPowerProfileData> appData;
    private final String key;

    /* JADX INFO: compiled from: PowerRankFeatureData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/security/mainpage/delegate/data/PowerRankFeatureData$Companion;", "", "()V", "position", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PowerRankFeatureData() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PowerRankFeatureData copy$default(PowerRankFeatureData r0, String r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.getKey();
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.appData;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return getKey();
    }

    public final List<AppPowerProfileData> component2() {
        return this.appData;
    }

    public final PowerRankFeatureData copy(String r1, List<AppPowerProfileData> r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        return new PowerRankFeatureData(r1, r2);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PowerRankFeatureData) == false) goto L10;
        PowerRankFeatureData r4 = (PowerRankFeatureData) r3;
        if (Intrinsics.areEqual(getKey(), r4.getKey()) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.appData, r4.appData) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = getKey();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<AppPowerProfileData> r4 = this.appData;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "PowerRankFeatureData(key=" + getKey() + ", appData=" + this.appData + ")";
    }

    @Override // com.obric.security.mainpage.delegate.data.Feature
    public String getKey() {
        return this.key;
    }

    public /* synthetic */ PowerRankFeatureData(String r1, List r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "powerRank";
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
        List r5 = (List) null;
    L8:
        this(r1, r2);
    }

    public final List<AppPowerProfileData> getAppData() {
        return this.appData;
    }

    public PowerRankFeatureData(String r3, List<AppPowerProfileData> r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        super("powerRank", 3);
        this.key = r3;
        this.appData = r4;
    }
}
