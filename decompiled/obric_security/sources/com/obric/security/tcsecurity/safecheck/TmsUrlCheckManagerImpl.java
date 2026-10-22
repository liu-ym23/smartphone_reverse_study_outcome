package com.obric.security.tcsecurity.safecheck;

import com.obric.matrix.platform.sdk.ones.internal.monitor.EventConstants;
import com.obric.securitycenter.api.ITmsUrlCheckManager;
import com.obric.securitycenter.api.TrackUtils;
import com.obric.securitycenter.api.UrlCheckResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.fg.creator.ManagerCreatorF;
import tmsdk.fg.module.urlcheck.UrlCheckManager;

/* JADX INFO: compiled from: ITmsManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/security/tcsecurity/safecheck/TmsUrlCheckManagerImpl;", "Lcom/obric/securitycenter/api/ITmsUrlCheckManager;", "()V", "urlCheckManager", "Ltmsdk/fg/module/urlcheck/UrlCheckManager;", "checkUrlSync", "Lcom/obric/securitycenter/api/UrlCheckResult;", "url", "", "checkUrlsSync", "", "urls", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class TmsUrlCheckManagerImpl implements ITmsUrlCheckManager {
    public static final TmsUrlCheckManagerImpl INSTANCE = null;
    private static UrlCheckManager urlCheckManager;

    static {
        INSTANCE = new TmsUrlCheckManagerImpl();
    }

    private TmsUrlCheckManagerImpl() {
    }

    @Override // com.obric.securitycenter.api.ITmsUrlCheckManager
    public UrlCheckResult checkUrlSync(String r18) {
        Intrinsics.checkNotNullParameter(r18, "url");
        UrlCheckResult r8 = new UrlCheckResult(false, null, null, 7, null);
        r8.setUrl(r18);
        r8.setHarm(false);
        if (urlCheckManager != null) goto L5;
        urlCheckManager = (UrlCheckManager) ManagerCreatorF.getManager(UrlCheckManager.class);
    L5:
        long r3 = System.currentTimeMillis();
        UrlCheckManager r5 = urlCheckManager;
        if (r5 == null) goto L8;
        tmsdk.common.module.urlcheck.UrlCheckResult r6 = r5.checkUrlSync(r18);
    L9:
        long r7 = System.currentTimeMillis() - r3;
        if (r6 != null) goto L12;
    L13:
        if (r6 != null) goto L15;
    L17:
        TrackUtils r11 = TrackUtils.INSTANCE;
        Pair[] r10 = new Pair[4];
        if (r6 == null) goto L20;
        String r13 = "success";
    L21:
        r10[0] = TuplesKt.to("result", r13);
        if (r6 == null) goto L24;
        int r2 = r6.mEvilType;
    L25:
        r10[1] = TuplesKt.to("risk_type", UrlEvilDescriptionKt.getEvilDescription(r2));
        r10[2] = TuplesKt.to(EventConstants.EVENT_KEY_COST_TIME, Long.valueOf(r7));
        r10[3] = TuplesKt.to("url", r18);
        TrackUtils.trackEvent$default(r11, "url_risk_check", MapsKt.mapOf(r10), false, 4, null);
        return r8;
    L24:
        r2 = -1;
        goto L25
    L20:
        r13 = "failed";
        goto L21
    L15:
        if (r6.result != 2) goto L17;
    L16:
        r8.setHarm(true);
        goto L17
    L12:
        if (r6.result == 3) goto L16;
    L8:
        r6 = null;
        goto L9
    }

    @Override // com.obric.securitycenter.api.ITmsUrlCheckManager
    public List<UrlCheckResult> checkUrlsSync(List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "urls");
        List<String> r4 = r3;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        String r0 = (String) r5.next();
        r2.add(INSTANCE.checkUrlSync(r0));
        goto L4
    L7:
        return r2;
    }
}
