package com.obric.matrix.base.settings.config;

import java.util.List;
import kotlin.Metadata;
import kotlin.i0.r;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<com.obric.matrix.base.settings.config.i>] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u0000H\u0016R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/obric/matrix/base/settings/config/OpenAuthConfig;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "()V", "needCheckClientDeadList", "", "", "getNeedCheckClientDeadList", "()Ljava/util/List;", "setNeedCheckClientDeadList", "(Ljava/util/List;)V", "needCheckTokenCmdList", "", "getNeedCheckTokenCmdList", "setNeedCheckTokenCmdList", "needRemoveXTtToken", "", "getNeedRemoveXTtToken", "()Z", "setNeedRemoveXTtToken", "(Z)V", "refreshTokenConfig", "Lcom/obric/matrix/base/settings/config/RefreshTokenConfig;", "getRefreshTokenConfig", "()Lcom/obric/matrix/base/settings/config/RefreshTokenConfig;", "setRefreshTokenConfig", "(Lcom/obric/matrix/base/settings/config/RefreshTokenConfig;)V", "create", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("refresh_token_config")
    private RefreshTokenConfig f8878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("need_check_client_dead_list")
    private List<String> f8879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("need_check_token_cmd_list")
    private List<Integer> f8880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.gson.y.c("is_need_remove_x_tt_token")
    private boolean f8881d;

    public i() {
        this.f8878a = new RefreshTokenConfig(false, 0, 0, 7, null);
        this.f8879b = r.g();
        this.f8880c = r.g();
    }

    public i a() {
        return new i();
    }

    public final boolean b() {
        return this.f8881d;
    }
}
