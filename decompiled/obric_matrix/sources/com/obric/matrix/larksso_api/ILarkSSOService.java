package com.obric.matrix.larksso_api;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/obric/matrix/larksso_api/ILarkSSOService;", "Lcom/bytedance/news/common/service/manager/IService;", "clearCache", "", "getAccessToken", "", "init", "larkSSOAuthIfNeeded", "force", "", "setCallback", "ssoCallback", "Lcom/obric/matrix/larksso_api/OnLarkSSOCallback;", "larksso_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ILarkSSOService extends IService {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(ILarkSSOService r0, boolean r1, int r2, Object r3) {
            if (r3 != null) goto L9;
            if ((r2 & 1) == 0) goto L6;
            r1 = false;
        L6:
            r0.larkSSOAuthIfNeeded(r1);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: larkSSOAuthIfNeeded");
        }
    }

    void clearCache();

    String getAccessToken();

    void init();

    void larkSSOAuthIfNeeded(boolean r1);

    void setCallback(com.obric.matrix.larksso_api.a r1);
}
