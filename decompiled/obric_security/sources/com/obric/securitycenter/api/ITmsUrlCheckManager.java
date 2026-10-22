package com.obric.securitycenter.api;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: UrlCheckResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&¨\u0006\t"}, d2 = {"Lcom/obric/securitycenter/api/ITmsUrlCheckManager;", "", "checkUrlSync", "Lcom/obric/securitycenter/api/UrlCheckResult;", "url", "", "checkUrlsSync", "", "urls", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ITmsUrlCheckManager {
    UrlCheckResult checkUrlSync(String r1);

    List<UrlCheckResult> checkUrlsSync(List<String> r1);
}
