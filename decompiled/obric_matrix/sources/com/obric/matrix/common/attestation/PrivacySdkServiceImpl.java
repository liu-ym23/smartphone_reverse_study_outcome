package com.obric.matrix.common.attestation;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.matrix.common_api.IPrivacySdkService;
import i.a.a.a.c;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/common/attestation/PrivacySdkServiceImpl;", "Lcom/obric/matrix/common_api/IPrivacySdkService;", "()V", "getIDAttestation", "", LocationMonitorConst.INFO, "appId", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrivacySdkServiceImpl implements IPrivacySdkService {
    public PrivacySdkServiceImpl() {
    }

    @Override // com.obric.matrix.common_api.IPrivacySdkService
    public String getIDAttestation(String r1, String r2) {
        o.f(r1, LocationMonitorConst.INFO);
        o.f(r2, "appId");
        return c.f17599a.a().d(r1, r2);
    }
}
