package com.obric.matrix.base.settings.config;

import java.util.List;
import kotlin.Metadata;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<com.obric.matrix.base.settings.config.b>] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0000H\u0016R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/obric/matrix/base/settings/config/GenericNetworkConfig;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "()V", "allowPathList", "", "", "getAllowPathList", "()Ljava/util/List;", "setAllowPathList", "(Ljava/util/List;)V", "enableSecurityCheck", "", "getEnableSecurityCheck", "()Ljava/lang/Boolean;", "setEnableSecurityCheck", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "create", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("enable_security_check")
    private Boolean f8857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("allow_path_list")
    private List<String> f8858b;

    public b() {
    }

    public b a() {
        return new b();
    }

    public final List<String> b() {
        return this.f8858b;
    }

    public final Boolean c() {
        return this.f8857a;
    }
}
