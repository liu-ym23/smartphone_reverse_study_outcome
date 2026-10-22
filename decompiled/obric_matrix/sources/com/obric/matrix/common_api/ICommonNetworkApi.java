package com.obric.matrix.common_api;

import com.bytedance.news.common.service.manager.IService;
import com.obric.matrix.w.b0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Lcom/obric/matrix/common_api/ICommonNetworkApi;", "Lcom/bytedance/news/common/service/manager/IService;", "getTTNetParameters", "Lio/reactivex/Maybe;", "Lcom/obric/matrix/model/BaseResponseBody;", "request", "Lcom/obric/matrix/proto/Request;", "onePartyNetworkRequest", "processGenericNetworkRequest", "sendApplogEventRequest", "common_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICommonNetworkApi extends IService {
    f.a.a<com.obric.matrix.u.b> getTTNetParameters(b0 r1);

    f.a.a<com.obric.matrix.u.b> onePartyNetworkRequest(b0 r1);

    f.a.a<com.obric.matrix.u.b> processGenericNetworkRequest(b0 r1);

    f.a.a<com.obric.matrix.u.b> sendApplogEventRequest(b0 r1);
}
