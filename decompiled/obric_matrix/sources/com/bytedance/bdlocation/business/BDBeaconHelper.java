package com.bytedance.bdlocation.business;

import com.bytedance.bdlocation.callback.BDBeaconCallback;
import com.bytedance.bdlocation.service.BDLocationExtrasService;

/* JADX INFO: loaded from: classes.dex */
public class BDBeaconHelper {
    public BDBeaconHelper() {
    }

    public static void startBeaconTask(String r1, BDBeaconCallback r2) {
        BDLocationExtrasService.getBeaconManager().startBeaconTask(r1, r2);
    }

    public static void stopBeaconTask() {
        BDLocationExtrasService.getBeaconManager().stopBeaconTask();
    }
}
