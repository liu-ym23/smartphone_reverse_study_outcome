package com.obric.safecheck.urlmonitor;

import com.obric.securitycenter.api.GlobalManagerCreator;
import com.obric.securitycenter.api.ITmsUrlCheckManager;
import com.obric.securitycenter.api.UrlCheckResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TcUrlMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001c\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b¨\u0006\n"}, d2 = {"Lcom/obric/safecheck/urlmonitor/TcUrlMonitor;", "", "()V", "checkUrlSync", "Lcom/obric/securitycenter/api/UrlCheckResult;", "url", "", "checkUrlsSync", "", "urls", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class TcUrlMonitor {
    public static final TcUrlMonitor INSTANCE = null;

    static {
        INSTANCE = new TcUrlMonitor();
    }

    private TcUrlMonitor() {
    }

    public final UrlCheckResult checkUrlSync(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        ITmsUrlCheckManager r1 = (ITmsUrlCheckManager) GlobalManagerCreator.INSTANCE.getManager(ITmsUrlCheckManager.class);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.checkUrlSync(r2);
    }

    public final List<UrlCheckResult> checkUrlsSync(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "urls");
        ITmsUrlCheckManager r1 = (ITmsUrlCheckManager) GlobalManagerCreator.INSTANCE.getManager(ITmsUrlCheckManager.class);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.checkUrlsSync(r2);
    }
}
