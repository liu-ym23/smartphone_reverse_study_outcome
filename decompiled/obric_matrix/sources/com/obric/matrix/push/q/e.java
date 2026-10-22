package com.obric.matrix.push.q;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\bJ\b\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/push/sync/ByteSyncConfig;", "", "()V", "getChannelId", "", "getHost", "", "getSettingsBizId", "", "getSyncBizId", "getUpstreamServiceId", "getUserSyncBizId", "isBoe", "", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f9784a = null;

    static {
        f9784a = new e();
    }

    private e() {
    }

    private final boolean g() {
        return com.obric.matrix.base.env.d.f8838a.e();
    }

    public final int a() {
        return 1;
    }

    public final String b() {
        if (g() == false) goto L5;
        return "http://cloudpush-boe.bytedance.net";
    L5:
        return "https://os.obriccloud.com";
    }

    public final long c() {
        return 10;
    }

    public final long d() {
        if (g() == false) goto L5;
        return 893;
    L5:
        return 24;
    }

    public final int e() {
        if (g() == false) goto L5;
        return 16778021;
    L5:
        return 33554513;
    }

    public final long f() {
        if (g() == false) goto L5;
        return 924;
    L5:
        return 42;
    }
}
