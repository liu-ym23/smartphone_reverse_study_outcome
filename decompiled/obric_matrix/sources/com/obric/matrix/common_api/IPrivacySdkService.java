package com.obric.matrix.common_api;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/obric/matrix/common_api/IPrivacySdkService;", "Lcom/bytedance/news/common/service/manager/IService;", "getIDAttestation", "", LocationMonitorConst.INFO, "appId", "common_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IPrivacySdkService extends IService {
    String getIDAttestation(String r1, String r2);
}
