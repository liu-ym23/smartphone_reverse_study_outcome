package com.obric.matrix.location_api;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/obric/matrix/location_api/ILocationServiceDebug;", "Lcom/bytedance/news/common/service/manager/IService;", "isMockEnable", "", "openMockActivity", "", "setMockEnable", "enable", "location_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ILocationServiceDebug extends IService {
    boolean isMockEnable();

    void openMockActivity();

    void setMockEnable(boolean r1);
}
