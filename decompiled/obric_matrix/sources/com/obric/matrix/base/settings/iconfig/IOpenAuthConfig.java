package com.obric.matrix.base.settings.iconfig;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.obric.matrix.base.settings.config.i;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.news.common.settings.api.annotation.a(storageKey = "open_auth_config")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/obric/matrix/base/settings/iconfig/IOpenAuthConfig;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "getOpenAuthConfig", "Lcom/obric/matrix/base/settings/config/OpenAuthConfig;", "getOpenAuthConfigStr", "", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IOpenAuthConfig extends ISettings {
    i getOpenAuthConfig();

    String getOpenAuthConfigStr();
}
