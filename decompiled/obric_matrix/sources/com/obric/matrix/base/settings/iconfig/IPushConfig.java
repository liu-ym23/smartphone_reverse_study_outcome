package com.obric.matrix.base.settings.iconfig;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.news.common.settings.api.annotation.a(storageKey = "push_config_storage")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0003H'J\b\u0010\u0005\u001a\u00020\u0003H'¨\u0006\u0006"}, d2 = {"Lcom/obric/matrix/base/settings/iconfig/IPushConfig;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "enableNetworkChangeHeartbeatOpt", "", "enableOceanPushRegister", "enableRSTOpt", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IPushConfig extends ISettings {
    boolean enableNetworkChangeHeartbeatOpt();

    boolean enableOceanPushRegister();

    boolean enableRSTOpt();
}
