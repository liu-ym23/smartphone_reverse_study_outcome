package com.obric.matrix.opush.base.settings;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/opush/base/settings/IPushSettingsService;", "", "getAppHostCount", "", "getHostAppList", "", "pkgName", "getLocalSettings", "Lcom/obric/matrix/opush/base/settings/PushLocalSettings;", "isHostAppList", "", "putHostAppList", "", "token", "removeHostAppList", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface a {
    PushLocalSettings a();

    void b(String r1);

    boolean c(String r1);

    void d(String r1, String r2);

    int e();

    String f(String r1);
}
