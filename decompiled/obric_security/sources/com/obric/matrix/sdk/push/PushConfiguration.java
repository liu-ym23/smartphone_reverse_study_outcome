package com.obric.matrix.sdk.push;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/matrix/sdk/push/PushConfiguration;", "", "appId", "", "appKey", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppKey", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_push_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PushConfiguration {
    private final String appId;
    private final String appKey;

    public PushConfiguration(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "appKey");
        this.appId = r2;
        this.appKey = r3;
    }

    public static /* synthetic */ PushConfiguration copy$default(PushConfiguration r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.appId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.appKey;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.appKey;
    }

    public final PushConfiguration copy(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "appId");
        Intrinsics.checkNotNullParameter(r2, "appKey");
        return new PushConfiguration(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PushConfiguration) == true) goto L8;
        return false;
    L8:
        PushConfiguration r6 = (PushConfiguration) r5;
        if (Intrinsics.areEqual(this.appId, r6.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appKey, r6.appKey) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public int hashCode() {
        return (this.appId.hashCode() * 31) + this.appKey.hashCode();
    }

    public String toString() {
        return "PushConfiguration(appId=" + this.appId + ", appKey=" + this.appKey + ')';
    }
}
