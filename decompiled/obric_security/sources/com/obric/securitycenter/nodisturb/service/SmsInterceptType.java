package com.obric.securitycenter.nodisturb.service;

import kotlin.Metadata;

/* JADX INFO: compiled from: SmsInterceptType.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/securitycenter/nodisturb/service/SmsInterceptType;", "", "()V", "BLACK_LIST", "", "HARMFUL", "HIGH_RISK", "KEYWORD", "MEDIUM_RISK", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmsInterceptType {
    public static final int BLACK_LIST = 0;
    public static final int HARMFUL = 4;
    public static final int HIGH_RISK = 3;
    public static final SmsInterceptType INSTANCE = null;
    public static final int KEYWORD = 1;
    public static final int MEDIUM_RISK = 2;

    static {
        INSTANCE = new SmsInterceptType();
    }

    private SmsInterceptType() {
    }
}
