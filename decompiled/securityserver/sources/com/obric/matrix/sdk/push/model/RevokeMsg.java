package com.obric.matrix.sdk.push.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RevokeMsg {

    @NotNull
    private final String msgId;

    @Nullable
    private final String revokeData;

    @NotNull
    private final String revokeId;

    public RevokeMsg(@NotNull String r2, @NotNull String r3, @Nullable String r4) {
        Intrinsics.f(r2, "msgId");
        Intrinsics.f(r3, "revokeId");
        this.msgId = r2;
        this.revokeId = r3;
        this.revokeData = r4;
    }

    public static /* synthetic */ RevokeMsg copy$default(RevokeMsg r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.msgId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.revokeId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.revokeData;
    L12:
        return r0.copy(r1, r2, r3);
    }

    @NotNull
    public final String component1() {
        return this.msgId;
    }

    @NotNull
    public final String component2() {
        return this.revokeId;
    }

    @Nullable
    public final String component3() {
        return this.revokeData;
    }

    @NotNull
    public final RevokeMsg copy(@NotNull String r1, @NotNull String r2, @Nullable String r3) {
        Intrinsics.f(r1, "msgId");
        Intrinsics.f(r2, "revokeId");
        return new RevokeMsg(r1, r2, r3);
    }

    public boolean equals(@Nullable Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RevokeMsg) == true) goto L8;
        return false;
    L8:
        RevokeMsg r6 = (RevokeMsg) r5;
        if (Intrinsics.a(this.msgId, r6.msgId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.a(this.revokeId, r6.revokeId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.a(this.revokeData, r6.revokeData) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @NotNull
    public final String getMsgId() {
        return this.msgId;
    }

    @Nullable
    public final String getRevokeData() {
        return this.revokeData;
    }

    @NotNull
    public final String getRevokeId() {
        return this.revokeId;
    }

    public int hashCode() {
        int r0 = this.msgId.hashCode() * 31;
        int r1 = (this.revokeId.hashCode() + r0) * 31;
        String r2 = this.revokeData;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r1 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    @NotNull
    public String toString() {
        return "RevokeMsg(msgId=" + this.msgId + ", revokeId=" + this.revokeId + ", revokeData=" + this.revokeData + ')';
    }
}
