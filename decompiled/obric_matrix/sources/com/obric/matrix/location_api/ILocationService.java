package com.obric.matrix.location_api;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import com.obric.matrix.u.b;
import com.obric.matrix.w.b0;
import com.obric.matrix.w.o;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/location_api/ILocationService;", "Lcom/bytedance/news/common/service/manager/IService;", "decodeLocation", "Lio/reactivex/Maybe;", "Lcom/obric/matrix/model/BaseResponseBody;", "request", "Lcom/obric/matrix/proto/Request;", "getIntersectFences", "getLocation", "Lcom/obric/matrix/proto/LocationInfo;", "init", "", "context", "Landroid/content/Context;", "refreshLocation", "location_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ILocationService extends IService {
    f.a.a<b> decodeLocation(b0 r1);

    f.a.a<b> getIntersectFences(b0 r1);

    o getLocation();

    f.a.a<b> getLocation(b0 r1);

    void init(Context r1);

    f.a.a<b> refreshLocation(b0 r1);
}
