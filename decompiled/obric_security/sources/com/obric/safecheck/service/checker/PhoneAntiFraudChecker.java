package com.obric.safecheck.service.checker;

import com.obric.security.safecheckapi.CheckResult;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: PhoneAntiFraudChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&¨\u0006\b"}, d2 = {"Lcom/obric/safecheck/service/checker/PhoneAntiFraudChecker;", "", "check", "", "Lcom/obric/security/safecheckapi/CheckResult;", "phoneNumbers", "", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface PhoneAntiFraudChecker {
    List<CheckResult> check(List<String> r1);
}
