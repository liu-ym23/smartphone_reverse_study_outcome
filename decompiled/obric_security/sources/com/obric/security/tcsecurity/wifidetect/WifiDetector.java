package com.obric.security.tcsecurity.wifidetect;

import com.obric.securitycenter.api.WifiDetectResult;
import kotlin.Metadata;
import tmsdk.bg.module.wifidetect.WifiDetectManager;

/* JADX INFO: compiled from: WifiDetectors.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/obric/security/tcsecurity/wifidetect/WifiDetector;", "", "detect", "", "mgr", "Ltmsdk/bg/module/wifidetect/WifiDetectManager;", "timeoutMillis", "", "result", "Lcom/obric/securitycenter/api/WifiDetectResult;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface WifiDetector {
    boolean detect(WifiDetectManager r1, long r2, WifiDetectResult r4);
}
