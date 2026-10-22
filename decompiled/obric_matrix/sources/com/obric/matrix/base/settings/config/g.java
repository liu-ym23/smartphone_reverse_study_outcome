package com.obric.matrix.base.settings.config;

import java.util.Map;
import kotlin.Metadata;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<com.obric.matrix.base.settings.config.g>] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0000H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/obric/matrix/base/settings/config/MatrixTtnetConfig;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "()V", "defaultTimeOutMil", "", "getDefaultTimeOutMil", "()J", "setDefaultTimeOutMil", "(J)V", "requestTimeoutMap", "", "", "", "getRequestTimeoutMap", "()Ljava/util/Map;", "setRequestTimeoutMap", "(Ljava/util/Map;)V", "create", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("request_timeout_map")
    private Map<String, Integer> f8875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("default_time_out_mil")
    private long f8876b;

    public g() {
        this.f8876b = 20000;
    }

    public g a() {
        return new g();
    }

    public final long b() {
        return this.f8876b;
    }

    public final Map<String, Integer> c() {
        return this.f8875a;
    }
}
