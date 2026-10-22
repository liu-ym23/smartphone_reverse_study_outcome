package com.obric.matrix.sdk.push.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Message {

    @NotNull
    private final String data;

    @NotNull
    private final String msgId;

    public Message(@NotNull String r2, @NotNull String r3) {
        Intrinsics.f(r2, "msgId");
        Intrinsics.f(r3, "data");
        this.msgId = r2;
        this.data = r3;
    }

    public static /* synthetic */ Message copy$default(Message r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.msgId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.data;
    L9:
        return r0.copy(r1, r2);
    }

    @NotNull
    public final String component1() {
        return this.msgId;
    }

    @NotNull
    public final String component2() {
        return this.data;
    }

    @NotNull
    public final Message copy(@NotNull String r1, @NotNull String r2) {
        Intrinsics.f(r1, "msgId");
        Intrinsics.f(r2, "data");
        return new Message(r1, r2);
    }

    public boolean equals(@Nullable Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Message) == true) goto L8;
        return false;
    L8:
        Message r6 = (Message) r5;
        if (Intrinsics.a(this.msgId, r6.msgId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.a(this.data, r6.data) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @NotNull
    public final String getData() {
        return this.data;
    }

    @NotNull
    public final String getMsgId() {
        return this.msgId;
    }

    public int hashCode() {
        int r0 = this.msgId.hashCode() * 31;
        return this.data.hashCode() + r0;
    }

    @NotNull
    public String toString() {
        return "Message(msgId=" + this.msgId + ", data=" + this.data + ')';
    }
}
