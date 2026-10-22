package com.obric.security.safecheckapi;

import kotlin.Metadata;

/* JADX INFO: compiled from: SecurityConst.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/security/safecheckapi/SecurityConst;", "", "()V", "EXTRA_KEY_ANTI_FRAUD_DETECTION_HIT", "", "SECURITY_PKG", "SECURITY_SERVICE_CLASS", "SMS_MESSAGE_ID", "safecheckapi_release"}, k = 1, mv = {1, 4, 3})
public final class SecurityConst {
    public static final String EXTRA_KEY_ANTI_FRAUD_DETECTION_HIT = "anti_fraud_detection_hit";
    public static final SecurityConst INSTANCE = null;
    public static final String SECURITY_PKG = "com.obric.security";
    public static final String SECURITY_SERVICE_CLASS = "com.obric.safecheck.service.SafaCheckService";
    public static final String SMS_MESSAGE_ID = "sms_message_id";

    static {
        INSTANCE = new SecurityConst();
    }

    private SecurityConst() {
    }
}
