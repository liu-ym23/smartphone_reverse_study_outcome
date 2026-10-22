package com.bytedance.securityserver.trustcircle.network;

import com.bytedance.retrofit2.HttpMethodContrants;

/* JADX INFO: loaded from: classes.dex */
public class NetworkRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f77a;
    public final String b;
    public final String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f78d;
    public final String e;

    public NetworkRequest(String r2, String r3, String r4, String r5) {
        this.f77a = HttpMethodContrants.POST;
        this.b = r2;
        this.c = r3;
        this.f78d = r4;
        this.e = r5;
    }
}
