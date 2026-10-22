package com.bytedance.bdlocation.service;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.api.IBeaconManager;
import com.bytedance.bdlocation.api.ILocate;
import com.bytedance.bdlocation.api.ILocationH3Core;
import com.bytedance.bdlocation.api.IManager;
import com.bytedance.bdlocation.api.IRegionDataCore;
import com.bytedance.bdlocation.api.IShakeManager;
import com.bytedance.bdlocation.api.ITraceRouteManager;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.provider.DefaultBeaconProvider;
import com.bytedance.bdlocation.provider.DefaultBpeaProvider;
import com.bytedance.bdlocation.provider.DefaultLocationH3Core;
import com.bytedance.bdlocation.provider.DefaultRegionDataCore;
import com.bytedance.bdlocation.provider.DefaultShakeProvider;
import com.bytedance.bdlocation.provider.DefaultTraceRouteProvider;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationExtrasService {
    private static final String AMAP_CLASS_NAME = "com.bytedance.bdlocation.amap.AMapLocationImpl";
    private static final String BEACON_CLASS_NAME = "com.bytedance.byte_beacon.BeaconManagerImpl";
    private static final String BPEA_CLASS_NAME = "com.bytedance.location_bpea.BPEAManager";
    private static final String BYTE_CLASS_NAME = "com.bytedance.bdlocation.bytelocation.ByteLocationImpl";
    private static final String GMAP_CLASS_NAME = "com.bytedance.bdlocation.glocation.GoogleLocationImpl";
    private static final String H3CORE_CLASS_NAME = "com.uber.h3core.BDLocationH3Core";
    private static final String MOCK_CLASS_NAME = "com.bytedance.bdlocation.locationmock.MockLocationImpl";
    private static final String REGION_DATA_CLASS_NAME = "com.bytedance.region_data.RegionDataCore";
    private static final String SHAKE_CLASS_NAME = "com.bytedance.bdlocation_impl.shake.ShakeManager";
    private static final String TMAP_CLASS_NAME = "com.bytedance.bdlocation.tencent.TencentLocationImpl";
    private static final String TRACEROUTE_CLASS_NAME = "com.bytedance.bdlocation.traceroute.TraceRouterCore";
    private static ILocate sAmapLocate;
    private static IBPEALocal sBPEAManager;
    private static IBeaconManager sBeaconManager;
    private static ILocate sByteLocate;
    private static ILocate sGmapLocate;
    private static ILocationH3Core sILocationH3Core;
    private static IRegionDataCore sIRegionDataCore;
    private static ILocate sMockLocate;
    private static IShakeManager sShakeManager;
    private static ILocate sSysLocate;
    private static ILocate sTmapLocate;
    private static ITraceRouteManager sTraceRouteManager;

    public BDLocationExtrasService() {
    }

    private static synchronized ILocate getAmapLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sAmapLocate != null) goto L7;
        sAmapLocate = (ILocate) getLocalManager(AMAP_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        ILocate r1 = sAmapLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    public static synchronized IBPEALocal getBPEAManager() {
        monitor-enter(BDLocationExtrasService.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (sBPEAManager != null) goto L10;
        if (BDLocationConfig.enableBpea() == false) goto L10;
        sBPEAManager = (IBPEALocal) getLocalManager(BPEA_CLASS_NAME);     // Catch: Throwable -> L15
    L10:
        if (sBPEAManager != null) goto L12;
        sBPEAManager = new DefaultBpeaProvider();     // Catch: Throwable -> L15
    L12:
        IBPEALocal r1 = sBPEAManager;     // Catch: Throwable -> L15
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    public static synchronized IBeaconManager getBeaconManager() {
        monitor-enter(BDLocationExtrasService.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sBeaconManager != null) goto L8;
        sBeaconManager = (IBeaconManager) getLocalManager(BEACON_CLASS_NAME);     // Catch: Throwable -> L13
    L8:
        if (sBeaconManager != null) goto L10;
        sBeaconManager = new DefaultBeaconProvider();     // Catch: Throwable -> L13
    L10:
        IBeaconManager r1 = sBeaconManager;     // Catch: Throwable -> L13
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    private static synchronized ILocate getByteLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sByteLocate != null) goto L7;
        sByteLocate = (ILocate) getLocalManager(BYTE_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        ILocate r1 = sByteLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    private static synchronized ILocate getGmapLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sGmapLocate != null) goto L7;
        sGmapLocate = (ILocate) getLocalManager(GMAP_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        ILocate r1 = sGmapLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    private static IManager getLocalManager(String r6) {
        IManager r0 = null;
        IManager r1 = (IManager) Class.forName(r6).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{BDLocationConfig.getContext()});     // Catch: Throwable -> L8
        Logger.d("getLocalManager:" + r6);     // Catch: Throwable -> L6
        return r1;
    L6:
        th = th;
        r0 = r1;
    L9:
        Logger.i("BDLocationExtrasService getLocalManager error：" + th.toString());
        return r0;
    L8:
        th = th;
        goto L9
    }

    @Nullable
    public static synchronized ILocate getLocate(Context r2, int r3) {
        monitor-enter(BDLocationExtrasService.class);
        ILocate r1 = null;
        if (r3 != 0) goto L7;
        r1 = getSysLocate(r2);     // Catch: Throwable -> L25
    L28:
    L23:
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    L7:
        if (r3 != 1) goto L9;
        r1 = getAmapLocate();     // Catch: Throwable -> L25
        goto L28
    L9:
        if (r3 != 2) goto L11;
        r1 = getGmapLocate();     // Catch: Throwable -> L25
        goto L28
    L11:
        if (r3 != 3) goto L13;
        r1 = getByteLocate();     // Catch: Throwable -> L25
        goto L28
    L13:
        if (r3 != 4) goto L15;
        r1 = getMockLocate();     // Catch: Throwable -> L25
        goto L28
    L15:
        if (r3 != 5) goto L23;
        r1 = getTmapLocate();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public static synchronized ILocationH3Core getLocationH3Core() {
        monitor-enter(BDLocationExtrasService.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sILocationH3Core != null) goto L8;
        sILocationH3Core = (ILocationH3Core) getLocalManager(H3CORE_CLASS_NAME);     // Catch: Throwable -> L13
    L8:
        if (sILocationH3Core != null) goto L10;
        sILocationH3Core = new DefaultLocationH3Core();     // Catch: Throwable -> L13
    L10:
        ILocationH3Core r1 = sILocationH3Core;     // Catch: Throwable -> L13
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    private static synchronized ILocate getMockLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sMockLocate != null) goto L7;
        sMockLocate = (ILocate) getLocalManager(MOCK_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        ILocate r1 = sMockLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    public static synchronized IRegionDataCore getRegionDataCore() {
        monitor-enter(BDLocationExtrasService.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sIRegionDataCore != null) goto L8;
        sIRegionDataCore = (IRegionDataCore) getLocalManager(REGION_DATA_CLASS_NAME);     // Catch: Throwable -> L13
    L8:
        if (sIRegionDataCore != null) goto L10;
        sIRegionDataCore = new DefaultRegionDataCore();     // Catch: Throwable -> L13
    L10:
        IRegionDataCore r1 = sIRegionDataCore;     // Catch: Throwable -> L13
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    public static synchronized IShakeManager getShakeManager() {
        monitor-enter(BDLocationExtrasService.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sShakeManager != null) goto L8;
        sShakeManager = (IShakeManager) getLocalManager(SHAKE_CLASS_NAME);     // Catch: Throwable -> L13
    L8:
        if (sShakeManager != null) goto L10;
        sShakeManager = new DefaultShakeProvider();     // Catch: Throwable -> L13
    L10:
        IShakeManager r1 = sShakeManager;     // Catch: Throwable -> L13
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    private static synchronized ILocate getSysLocate(Context r2) {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sSysLocate != null) goto L7;
        sSysLocate = new SystemBaseLocationImpl(r2);     // Catch: Throwable -> L10
    L7:
        ILocate r3 = sSysLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r3;
    }

    private static synchronized ILocate getTmapLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sTmapLocate != null) goto L7;
        sTmapLocate = (ILocate) getLocalManager(TMAP_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        ILocate r1 = sTmapLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    public static synchronized ITraceRouteManager getTraceRouteManager() {
        monitor-enter(BDLocationExtrasService.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sTraceRouteManager != null) goto L8;
        sTraceRouteManager = (ITraceRouteManager) getLocalManager(TRACEROUTE_CLASS_NAME);     // Catch: Throwable -> L13
    L8:
        if (sTraceRouteManager != null) goto L10;
        sTraceRouteManager = new DefaultTraceRouteProvider();     // Catch: Throwable -> L13
    L10:
        ITraceRouteManager r1 = sTraceRouteManager;     // Catch: Throwable -> L13
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    private static void setAmapLocate(ILocate r0) {
        sAmapLocate = r0;
    }

    private static void setBPEAManager(IBPEALocal r0) {
        sBPEAManager = r0;
    }

    private static void setByteLocate(ILocate r0) {
        sByteLocate = r0;
    }

    private static void setGmapLocate(ILocate r0) {
        sGmapLocate = r0;
    }

    public static void setShakeManager(IShakeManager r0) {
        sShakeManager = r0;
    }
}
