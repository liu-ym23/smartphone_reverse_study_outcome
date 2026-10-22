package com.obric.securitycenter.api;

import kotlin.Metadata;

/* JADX INFO: compiled from: WifiDetect.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/securitycenter/api/ITmsWifiDetectManager;", "", "detectCurrentWifi", "Lcom/obric/securitycenter/api/WifiDetectResult;", "timeoutMillis", "", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ITmsWifiDetectManager {

    /* JADX INFO: compiled from: WifiDetect.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ WifiDetectResult detectCurrentWifi$default(ITmsWifiDetectManager r0, long r1, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 1) == 0) goto L7;
            r1 = 15000;
        L7:
            return r0.detectCurrentWifi(r1);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: detectCurrentWifi");
        }
    }

    WifiDetectResult detectCurrentWifi(long r1);
}
