package com.bytedance.common.wschannel.r;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f3659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f3660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3662d;

    public b(@NonNull c r1, a r2, int r3, int r4) {
        this.f3660b = r1;
        this.f3659a = r2;
        this.f3662d = r3;
        this.f3661c = r4;
    }

    public String toString() {
        return "ConnectEvent{mType=" + this.f3659a + ", connectionState=" + this.f3660b + ", mChannelId=" + this.f3662d + ", errorCode=" + this.f3661c + '}';
    }
}
