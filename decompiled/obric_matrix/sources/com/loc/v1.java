package com.loc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    x1 f7889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f7890b;

    v1(int r2) {
        ByteBuffer r3 = ByteBuffer.allocate(r2);
        this.f7890b = r3;
        r3.order(ByteOrder.LITTLE_ENDIAN);
        this.f7889a = new x1(this.f7890b);
    }

    public final v1 a() {
        this.f7889a.c(this.f7890b);
        return this;
    }
}
