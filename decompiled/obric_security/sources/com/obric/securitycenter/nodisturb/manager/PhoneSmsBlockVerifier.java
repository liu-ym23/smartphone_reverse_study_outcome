package com.obric.securitycenter.nodisturb.manager;

import com.obric.security.nodisturbapi.InterceptResult;
import com.obric.security.nodisturbapi.SmsData;
import kotlin.Metadata;

/* JADX INFO: compiled from: PhoneSmsBlockVerifier.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/obric/securitycenter/nodisturb/manager/PhoneSmsBlockVerifier;", "", "checkCallIntercept", "Lcom/obric/security/nodisturbapi/InterceptResult;", "ruleMask", "", "target", "", "checkSmsIntercept", "smsData", "Lcom/obric/security/nodisturbapi/SmsData;", "onDestroy", "", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PhoneSmsBlockVerifier {
    InterceptResult checkCallIntercept(int r1, String r2);

    InterceptResult checkSmsIntercept(int r1, SmsData r2);

    void onDestroy();
}
