package com.obric.securitycenter.api;

import kotlin.Metadata;

/* JADX INFO: compiled from: UrlCheckResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/securitycenter/api/IVirusDbUpdateManager;", "", "checkVirusDbUpdateSync", "Lcom/obric/securitycenter/api/VirusDbCheckResult;", "updateVirusDbSync", "Lcom/obric/securitycenter/api/VirusDbUpdateResult;", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IVirusDbUpdateManager {
    VirusDbCheckResult checkVirusDbUpdateSync();

    VirusDbUpdateResult updateVirusDbSync();
}
