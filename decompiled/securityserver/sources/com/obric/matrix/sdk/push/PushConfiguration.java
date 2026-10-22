package com.obric.matrix.sdk.push;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PushConfiguration {

    @NotNull
    private final String appId;

    @NotNull
    private final String appKey;

    public PushConfiguration(@NotNull String r2, @NotNull String r3) {
        Intrinsics.f(r2, "appId");
        Intrinsics.f(r3, "appKey");
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

    @NotNull
    public final String component1() {
        return this.appId;
    }

    @NotNull
    public final String component2() {
        return this.appKey;
    }

    @NotNull
    public final PushConfiguration copy(@NotNull String r1, @NotNull String r2) {
        Intrinsics.f(r1, "appId");
        Intrinsics.f(r2, "appKey");
        return new PushConfiguration(r1, r2);
    }

    public boolean equals(@Nullable Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PushConfiguration) == true) goto L8;
        return false;
    L8:
        PushConfiguration r6 = (PushConfiguration) r5;
        if (Intrinsics.a(this.appId, r6.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.a(this.appKey, r6.appKey) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    public final String getAppKey() {
        return this.appKey;
    }

    public int hashCode() {
        int r0 = this.appId.hashCode() * 31;
        return this.appKey.hashCode() + r0;
    }

    @NotNull
    public String toString() {
        return "PushConfiguration(appId=" + this.appId + ", appKey=" + this.appKey + ')';
    }
}
