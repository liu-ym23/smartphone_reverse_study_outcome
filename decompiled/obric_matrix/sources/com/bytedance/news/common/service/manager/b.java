package com.bytedance.news.common.service.manager;

import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.IBadger;
import com.bytedance.mpaas.app.AppInfo;
import com.bytedance.mpaas.app.AppInfoProvider;
import com.bytedance.mpaas.monitor.IMonitorService;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.sdk.account.monitor.AccountMonitorDefaultConfigServiceImpl;
import com.bytedance.sdk.account.monitor.AccountSdkMonitorServiceImpl;
import com.bytedance.sdk.account.monitor.IAccountSdkMonitorService;
import com.bytedance.sdk.account.monitor.settings.IAccountMonitorDefaultConfigService;
import com.bytedance.sdk.account.settings.ISettingsGetter;
import com.bytedance.sdk.account.settings.SettingsGetterImpl;
import com.obric.matrix.MySettingsConfigProviderImpl;
import com.obric.matrix.account.OAccountImpl;
import com.obric.matrix.account_api.IAccount;
import com.obric.matrix.account_api.ISecShareService;
import com.obric.matrix.account_api.SecShareServiceImpl;
import com.obric.matrix.atomic_capability.AtomicCapabilityServiceImpl;
import com.obric.matrix.atomic_capability_api.IAtomicCapabilityService;
import com.obric.matrix.badge.BadgeApiImpl;
import com.obric.matrix.biz_example.BizExampleImpl;
import com.obric.matrix.biz_example_api.IBizExample;
import com.obric.matrix.common.MetaSecImpl;
import com.obric.matrix.common.MonitorServiceImpl;
import com.obric.matrix.common.attestation.PrivacySdkServiceImpl;
import com.obric.matrix.common.network.CommonNetworkImpl;
import com.obric.matrix.common_api.IBadgeApi;
import com.obric.matrix.common_api.ICommonNetworkApi;
import com.obric.matrix.common_api.IMetaSec;
import com.obric.matrix.common_api.IPrivacySdkService;
import com.obric.matrix.larksso.LarkSSOImpl;
import com.obric.matrix.larksso_api.ILarkSSOService;
import com.obric.matrix.launch.bdtracker.BDTrackerInitTaskHooker;
import com.obric.matrix.launch.godzilla.MatrixGodzillaInitTaskHook;
import com.obric.matrix.launch.ttnet.TTNetInitTaskHooker;
import com.obric.matrix.location.LocationServiceImpl;
import com.obric.matrix.location_api.ILocationService;
import com.obric.matrix.opush.PushImpl;
import com.obric.matrix.opush_api.IPush;
import com.obric.matrix.osettings.OSettingsImpl;
import com.obric.matrix.osettings_api.IOSettings;
import com.obric.matrix.ostracker.TeaTrackerImpl;
import com.obric.matrix.ostracker_api.IOSTracker;
import com.obric.matrix.picolinks.PicoLinksImpl;
import com.obric.matrix.picolinks_api.IPicoLinks;
import com.obric.matrix.ws.IWsDebugImpl;
import com.obric.matrix.ws.IWsImpl;
import com.obric.matrix.ws_api.IWs;
import com.obric.matrix.ws_api.IWsDebug;
import com.ss.android.init.tasks.BdtrackerInitTaskHook;
import com.ss.android.init.tasks.GodzillaInitTaskHook;
import com.ss.android.init.tasks.TTNetInitTaskHook;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static <T> T a(Class<T> r1) {
        if (r1 != SettingsConfigProvider.class) goto L7;
        return (T) new MySettingsConfigProviderImpl();
    L7:
        if (r1 != IAtomicCapabilityService.class) goto L11;
        return (T) new AtomicCapabilityServiceImpl();
    L11:
        if (r1 != IWs.class) goto L15;
        return (T) new IWsImpl();
    L15:
        if (r1 != IOSTracker.class) goto L19;
        return (T) new TeaTrackerImpl();
    L19:
        if (r1 != IBadger.class) goto L23;
        return (T) new BadgerCore();
    L23:
        if (r1 != IMetaSec.class) goto L27;
        return (T) new MetaSecImpl();
    L27:
        if (r1 != IBadgeApi.class) goto L31;
        return (T) new BadgeApiImpl();
    L31:
        if (r1 != IMonitorService.class) goto L35;
        return (T) new MonitorServiceImpl();
    L35:
        if (r1 != BdtrackerInitTaskHook.class) goto L39;
        return (T) new BDTrackerInitTaskHooker();
    L39:
        if (r1 != IPush.class) goto L43;
        return (T) new PushImpl();
    L43:
        if (r1 != IWsDebug.class) goto L47;
        return (T) new IWsDebugImpl();
    L47:
        if (r1 != com.obric.matrix.push_api.IPush.class) goto L51;
        return (T) new com.obric.matrix.push.PushImpl();
    L51:
        if (r1 != IPicoLinks.class) goto L55;
        return (T) new PicoLinksImpl();
    L55:
        if (r1 != IOSettings.class) goto L59;
        return (T) new OSettingsImpl();
    L59:
        if (r1 != IPrivacySdkService.class) goto L63;
        return (T) new PrivacySdkServiceImpl();
    L63:
        if (r1 != ILocationService.class) goto L67;
        return (T) new LocationServiceImpl();
    L67:
        if (r1 != ISettingsGetter.class) goto L71;
        return (T) new SettingsGetterImpl();
    L71:
        if (r1 != GodzillaInitTaskHook.class) goto L75;
        return (T) new MatrixGodzillaInitTaskHook();
    L75:
        if (r1 != ICommonNetworkApi.class) goto L79;
        return (T) new CommonNetworkImpl();
    L79:
        if (r1 != ILarkSSOService.class) goto L83;
        return (T) new LarkSSOImpl();
    L83:
        if (r1 != IAccountMonitorDefaultConfigService.class) goto L87;
        return (T) new AccountMonitorDefaultConfigServiceImpl();
    L87:
        if (r1 != AppInfoProvider.class) goto L91;
        return (T) AppInfo.getInstatnce();
    L91:
        if (r1 != ISecShareService.class) goto L95;
        return (T) new SecShareServiceImpl();
    L95:
        if (r1 != IAccountSdkMonitorService.class) goto L99;
        return (T) new AccountSdkMonitorServiceImpl();
    L99:
        if (r1 != IAccount.class) goto L103;
        return (T) new OAccountImpl();
    L103:
        if (r1 != IBizExample.class) goto L107;
        return (T) new BizExampleImpl();
    L107:
        if (r1 == TTNetInitTaskHook.class) goto L109;
        return null;
    L109:
        return (T) new TTNetInitTaskHooker();
    }

    public static <T> T b(Class<T> r0) {
        return null;
    }
}
