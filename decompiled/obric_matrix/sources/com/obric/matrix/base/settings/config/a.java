package com.obric.matrix.base.settings.config;

import java.util.List;
import kotlin.Metadata;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<com.obric.matrix.base.settings.config.a>] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/base/settings/config/CmdGroupPermission;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "()V", "opt", "", "getOpt", "()Ljava/lang/String;", "setOpt", "(Ljava/lang/String;)V", "pkgs", "", "getPkgs", "()Ljava/util/List;", "setPkgs", "(Ljava/util/List;)V", "create", "toString", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("opt")
    private String f8855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("pkgs")
    private List<String> f8856b;

    public a() {
    }

    public final String a() {
        return this.f8855a;
    }

    public final List<String> b() {
        return this.f8856b;
    }

    public String toString() {
        return "{opt=" + this.f8855a + ", pkgs=" + this.f8856b + '}';
    }
}
