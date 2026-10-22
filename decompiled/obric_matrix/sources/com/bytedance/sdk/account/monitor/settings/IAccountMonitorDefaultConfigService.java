package com.bytedance.sdk.account.monitor.settings;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/account/monitor/settings/IAccountMonitorDefaultConfigService;", "Lcom/bytedance/news/common/service/manager/IService;", "Lcom/bytedance/sdk/account/monitor/settings/b;", "getDefaultMonitorConfig", "()Lcom/bytedance/sdk/account/monitor/settings/b;", "defaultMonitorConfig", "", "getDefaultSeed", "()I", "defaultSeed", "account-sdk-monitor_release"}, k = 1, mv = {1, 1, 15})
public interface IAccountMonitorDefaultConfigService extends IService {

    public static final class a {
        public static int a(IAccountMonitorDefaultConfigService r0) {
            return c.f5707l.m();
        }
    }

    b getDefaultMonitorConfig();

    int getDefaultSeed();
}
