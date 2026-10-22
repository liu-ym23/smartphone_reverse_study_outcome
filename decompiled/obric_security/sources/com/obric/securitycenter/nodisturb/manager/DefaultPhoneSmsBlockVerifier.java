package com.obric.securitycenter.nodisturb.manager;

import com.obric.security.nodisturbapi.InterceptResult;
import com.obric.security.nodisturbapi.SmsData;
import com.obric.securitycenter.nodisturb.checker.CallBlockChecker;
import com.obric.securitycenter.nodisturb.checker.SmsBlockChecker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultPhoneSmsBlockVerifier.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/securitycenter/nodisturb/manager/DefaultPhoneSmsBlockVerifier;", "Lcom/obric/securitycenter/nodisturb/manager/PhoneSmsBlockVerifier;", "callBlockChecker", "Lcom/obric/securitycenter/nodisturb/checker/CallBlockChecker;", "smsBlockChecker", "Lcom/obric/securitycenter/nodisturb/checker/SmsBlockChecker;", "(Lcom/obric/securitycenter/nodisturb/checker/CallBlockChecker;Lcom/obric/securitycenter/nodisturb/checker/SmsBlockChecker;)V", "checkCallIntercept", "Lcom/obric/security/nodisturbapi/InterceptResult;", "ruleMask", "", "target", "", "checkSmsIntercept", "smsData", "Lcom/obric/security/nodisturbapi/SmsData;", "onDestroy", "", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DefaultPhoneSmsBlockVerifier implements PhoneSmsBlockVerifier {
    private final CallBlockChecker callBlockChecker;
    private final SmsBlockChecker smsBlockChecker;

    public DefaultPhoneSmsBlockVerifier(CallBlockChecker r2, SmsBlockChecker r3) {
        Intrinsics.checkNotNullParameter(r2, "callBlockChecker");
        Intrinsics.checkNotNullParameter(r3, "smsBlockChecker");
        this.callBlockChecker = r2;
        this.smsBlockChecker = r3;
    }

    @Override // com.obric.securitycenter.nodisturb.manager.PhoneSmsBlockVerifier
    public InterceptResult checkCallIntercept(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "target");
        return this.callBlockChecker.check(r2, r3);
    }

    @Override // com.obric.securitycenter.nodisturb.manager.PhoneSmsBlockVerifier
    public InterceptResult checkSmsIntercept(int r2, SmsData r3) {
        Intrinsics.checkNotNullParameter(r3, "smsData");
        return this.smsBlockChecker.check(r2, r3);
    }

    @Override // com.obric.securitycenter.nodisturb.manager.PhoneSmsBlockVerifier
    public void onDestroy() {
        this.callBlockChecker.onDestroy();
        this.smsBlockChecker.onDestroy();
    }
}
