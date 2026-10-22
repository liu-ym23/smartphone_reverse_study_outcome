package com.obric.safecheck.service.checker;

import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.security.safecheckapi.CheckResult;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: UrlTmsSecurityChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/obric/safecheck/service/checker/UrlTmsSecurityChecker;", "", "check", "", "Lcom/obric/security/safecheckapi/CheckResult;", ApkVirusCheckProvider.KEY_RESULTS, "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface UrlTmsSecurityChecker {
    List<CheckResult> check(List<CheckResult> r1);
}
