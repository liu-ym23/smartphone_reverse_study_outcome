package com.obric.matrix.base.settings.config;

import java.util.List;
import kotlin.Metadata;
import kotlin.i0.r;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<com.obric.matrix.base.settings.config.h>] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u0000H\u0016R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/obric/matrix/base/settings/config/OnePartyCommonNetworkConfig;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "()V", "allowPathList", "", "", "getAllowPathList", "()Ljava/util/List;", "setAllowPathList", "(Ljava/util/List;)V", "create", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("allow_path_list")
    private List<String> f8877a;

    public h() {
        this.f8877a = r.g();
    }

    public h a() {
        return new h();
    }

    public final List<String> b() {
        return this.f8877a;
    }
}
