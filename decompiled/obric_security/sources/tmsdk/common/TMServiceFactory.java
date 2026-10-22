package tmsdk.common;

import tmsdk.common.creator.ManagerCreatorC;
import tmsdk.common.module.systeminfoservice.DefaultSystemInfoServiceImpl;
import tmsdkobf.g9;
import tmsdkobf.gf;
import tmsdkobf.p6;
import tmsdkobf.re;
import tmsdkobf.se;

/* JADX INFO: loaded from: classes5.dex */
public final class TMServiceFactory {
    public TMServiceFactory() {
    }

    public static p6 getPreferenceService(String r1) {
        return g9.a(TMSDKContext.getApplicaionContext(), r1);
    }

    public static re getSysDBService() {
        return new se(TMSDKContext.getApplicaionContext(), 0);
    }

    public static gf getSystemInfoService() {
        return (gf) ManagerCreatorC.getManager(DefaultSystemInfoServiceImpl.class);
    }
}
