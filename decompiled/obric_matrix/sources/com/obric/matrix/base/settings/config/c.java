package com.obric.matrix.base.settings.config;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<com.obric.matrix.base.settings.config.c>] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020\u0000H\u0016R2\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR,\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR,\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R,\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR2\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR&\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016¨\u0006!"}, d2 = {"Lcom/obric/matrix/base/settings/config/MatrixAuthConfig;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "()V", "authCmdGroupList", "", "", "", "getAuthCmdGroupList", "()Ljava/util/Map;", "setAuthCmdGroupList", "(Ljava/util/Map;)V", "authCmdGroupMap", "getAuthCmdGroupMap", "setAuthCmdGroupMap", "authCmdGroupPermissionMap", "Lcom/obric/matrix/base/settings/config/CmdGroupPermission;", "getAuthCmdGroupPermissionMap", "setAuthCmdGroupPermissionMap", "authPkgBlackList", "getAuthPkgBlackList", "()Ljava/util/List;", "setAuthPkgBlackList", "(Ljava/util/List;)V", "authPkgWhiteMap", "getAuthPkgWhiteMap", "setAuthPkgWhiteMap", "authPkgWhiteMapNew", "getAuthPkgWhiteMapNew", "setAuthPkgWhiteMapNew", "oauthReturnUidBlackList", "getOauthReturnUidBlackList", "setOauthReturnUidBlackList", "create", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("AUTH_PKG_WHITE_MAP")
    private Map<String, String> f8859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("AUTH_PKG_WHITE_MAP_NEW")
    private Map<String, ? extends List<String>> f8860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("AUTH_PKG_BLACK_LIST")
    private List<String> f8861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.gson.y.c("AUTH_CMD_GROUP_MAP")
    private Map<String, String> f8862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.google.gson.y.c("AUTH_CMD_GROUP_LIST")
    private Map<String, ? extends List<String>> f8863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.gson.y.c("AUTH_CMD_GROUP_PERMISSION_MAP")
    private Map<String, a> f8864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.google.gson.y.c("OPEN_AUTH_RETURN_UID_BLACK_LIST")
    private List<String> f8865g;

    public c() {
    }

    public c a() {
        return new c();
    }

    public final Map<String, List<String>> b() {
        return this.f8863e;
    }

    public final Map<String, String> c() {
        return this.f8862d;
    }

    public final Map<String, a> d() {
        return this.f8864f;
    }

    public final List<String> e() {
        return this.f8861c;
    }

    public final Map<String, String> f() {
        return this.f8859a;
    }

    public final Map<String, List<String>> g() {
        return this.f8860b;
    }
}
