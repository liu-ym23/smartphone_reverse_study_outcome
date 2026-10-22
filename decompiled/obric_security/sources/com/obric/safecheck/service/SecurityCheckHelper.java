package com.obric.safecheck.service;

import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.security.safecheckapi.ApkInfo;
import com.obric.security.safecheckapi.CheckResult;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SecurityCheckHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH&J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH&¨\u0006\u000f"}, d2 = {"Lcom/obric/safecheck/service/SecurityCheckHelper;", "", ApkVirusCheckProvider.METHOD_CHECK_APK, "", "Lcom/obric/security/safecheckapi/CheckResult;", "apkPath", "", "checkApkWithInfo", "apkInfo", "Lcom/obric/security/safecheckapi/ApkInfo;", "checkPhone", "phoneNumbers", "", "checkUrl", "urls", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface SecurityCheckHelper {
    List<CheckResult> checkApk(String r1);

    List<CheckResult> checkApkWithInfo(ApkInfo r1);

    List<CheckResult> checkPhone(List<String> r1);

    List<CheckResult> checkUrl(List<String> r1);
}
