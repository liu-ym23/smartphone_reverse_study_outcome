package com.obric.matrix.picolinks_api;

import com.bytedance.news.common.service.manager.IService;
import com.obric.matrix.u.b;
import com.obric.matrix.w.b0;
import com.obric.matrix.w.m0;
import com.obric.matrix.w.n0;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000bH&J \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/picolinks_api/IPicoLinks;", "Lcom/bytedance/news/common/service/manager/IService;", "callbackPicoLink", "Lio/reactivex/Maybe;", "Lcom/obric/matrix/model/BaseResponseBody;", "request", "Lcom/obric/matrix/proto/Request;", "doStartPicoLinks", "", "Lcom/obric/matrix/proto/StartPicoLinksRequest;", "callback", "Lkotlin/Function1;", "Lcom/obric/matrix/proto/StartPicoLinksResponse;", "startPicoLinks", "Lcom/obric/matrix/platform/server/IServerCallback;", "picolinks_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IPicoLinks extends IService {
    f.a.a<b> callbackPicoLink(b0 r1);

    void doStartPicoLinks(m0 r1, l<? super n0, f0> r2);

    f.a.a<b> startPicoLinks(b0 r1, com.obric.matrix.platform.e.b r2);
}
