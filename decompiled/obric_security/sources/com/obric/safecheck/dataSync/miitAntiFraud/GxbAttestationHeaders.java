package com.obric.safecheck.dataSync.miitAntiFraud;

import android.content.Context;
import com.obric.baseservice.privacy.PrivacySdkManager;
import com.obric.olog.OLog;
import com.obric.securitycenter.api.ApplicationContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;

/* JADX INFO: compiled from: GxbAttestationHeaders.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAttestationHeaders;", "", "()V", "HEADER_APP_ID", "", "HEADER_CERT_CHAIN", "addTo", "Lokhttp3/Request$Builder;", "builder", "pemCertChain", "appId", "getPemCertChain", "logTag", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbAttestationHeaders {
    public static final String HEADER_APP_ID = "x-att-app-id";
    public static final String HEADER_CERT_CHAIN = "x-att-certchain";
    public static final GxbAttestationHeaders INSTANCE = null;

    public final String appId() {
        return PrivacySdkManager.APP_ID;
    }

    static {
        INSTANCE = new GxbAttestationHeaders();
    }

    private GxbAttestationHeaders() {
    }

    public final String getPemCertChain(String r7) {
        Intrinsics.checkNotNullParameter(r7, "logTag");
        Context r1 = ApplicationContainer.INSTANCE.getApplication();
        if (r1 != null) goto L11;
        OLog.e(r7, "get id attestation failed, application is null");
        return "";
    L11:
        return PrivacySdkManager.getIdAttestationString$default(PrivacySdkManager.INSTANCE, r1, false, false, 6, null);
    L8:
        th = move-exception;
        OLog.e(r7, "get id attestation failed", th);
        return "";
    }

    public final Request.Builder addTo(Request.Builder r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Intrinsics.checkNotNullParameter(r3, "pemCertChain");
        Request.Builder r1 = r2.addHeader(HEADER_APP_ID, appId()).addHeader(HEADER_CERT_CHAIN, r3);
        Intrinsics.checkNotNullExpressionValue(r1, "builder\n            .add…CERT_CHAIN, pemCertChain)");
        return r1;
    }
}
