package com.obric.safecheck.service.checker;

import com.obric.security.safecheckapi.ApkInfo;
import com.obric.security.safecheckapi.CheckResult;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ApkVirusChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/obric/safecheck/service/checker/ApkVirusChecker;", "", "checkByInfo", "", "Lcom/obric/security/safecheckapi/CheckResult;", "apkInfo", "Lcom/obric/security/safecheckapi/ApkInfo;", "checkByPath", "apkPath", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface ApkVirusChecker {
    List<CheckResult> checkByInfo(ApkInfo r1);

    List<CheckResult> checkByPath(String r1);
}
