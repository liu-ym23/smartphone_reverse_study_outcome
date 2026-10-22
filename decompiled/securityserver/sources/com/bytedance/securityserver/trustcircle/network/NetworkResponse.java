package com.bytedance.securityserver.trustcircle.network;

import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes.dex */
public class NetworkResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f79a;
    public final String b;
    public final String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JsonObject f80d;

    public NetworkResponse(int r1, String r2, String r3, JsonObject r4) {
        this.f79a = r1;
        this.b = r2;
        this.c = r3;
        this.f80d = r4;
    }
}
