package com.bytedance.bdlocation.init;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.LocationNotification;
import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.callback.RegionUploadCallback;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.entity.gis.BdGisResult;
import com.bytedance.bdlocation.entity.region.RegionBean;
import com.bytedance.bdlocation.permission.request.RequestPermissionUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationAgent {
    public BDLocationAgent() {
    }

    public static void addNotification(LocationNotification r0, int r1) {
        BDLocationHelper.getInstance();
        BDLocationHelper.addNotification(r0, r1);
    }

    public static void addNotification(LocationNotification r0, Object r1) {
        BDLocationHelper.getInstance();
        BDLocationHelper.addNotification(r0, r1);
    }

    public static void addSubmitNotification(Object r0, LocationSubmitNotification r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        BDLocationHelper.getInstance();
        BDLocationHelper.addSubmitNotification(r0, r1);
    }

    @Nullable
    @WorkerThread
    public static BDPoint convertGCJ02(BDPoint r1) {
        return BDLocationHelper.getInstance().convertGCJ02(r1);
    }

    @Nullable
    @WorkerThread
    public static BDLocation geocode(double r0, double r2, int r4, @Nullable Object r5) {
        BdGisResult r1 = getBdGisResult(r0, r2, r4, r5);
        if (r1 != null) goto L5;
        return null;
    L5:
        return LocationUtil.locationResultToBDLocation(null, r1.location);
    }

    @Nullable
    @WorkerThread
    public static BDLocation geocode(double r0, double r2, int r4, boolean r5) {
        BdGisResult r1 = getBdGisResult(r0, r2, r4, r5);
        if (r1 != null) goto L5;
        return null;
    L5:
        return LocationUtil.locationResultToBDLocation(null, r1.location);
    }

    @Nullable
    @WorkerThread
    public static BdGisResult getBdGisResult(double r7, double r9, int r11, @Nullable Object r12) {
        return BDLocationHelper.getInstance().geocode(r7, r9, r11, r12);
    }

    @Nullable
    @WorkerThread
    public static BdGisResult getBdGisResult(double r7, double r9, int r11, boolean r12) {
        return BDLocationHelper.getInstance().geocode(r7, r9, r11, r12);
    }

    @Nullable
    @WorkerThread
    public static BDLocation getIPLocation(Object r1, int r2) {
        return BDLocationHelper.getInstance().getIPLocation(r1, r2);
    }

    @Nullable
    public static BDLocation getLastKnownLocation(int r1, boolean r2) {
        return BDLocationHelper.getInstance().getLastKnowLocation(r1, r2);
    }

    @Nullable
    public static BDLocation getLastKnownLocation(Object r1) {
        return BDLocationHelper.getInstance().getLastKnowLocation(r1);
    }

    @Nullable
    public static BDLocation getLastKnownLocation(Object r1, int r2, boolean r3) {
        return BDLocationHelper.getInstance().getLastKnowLocation(r1, r2, r3);
    }

    public static void getLightLocation(Object r1, String r2, boolean r3) {
        BDLocationHelper.getInstance().getLightLocation(r1, r2, r3);
    }

    @Nullable
    @WorkerThread
    public static RegionBean getRegion(boolean r1) {
        return BDLocationHelper.getInstance().getRegion(r1);
    }

    @Nullable
    @WorkerThread
    public static RegionBean getRegion(boolean r1, boolean r2) {
        return BDLocationHelper.getInstance().getRegion(r1, r2);
    }

    public static void init(LocationInitConfig r1) {
        BDLocationHelper.getInstance().init(r1);
    }

    public static boolean isInit() {
        return BDLocationHelper.getInstance().isInit();
    }

    public static void removeNotification(LocationNotification r0, int r1) {
        BDLocationHelper.getInstance();
        BDLocationHelper.removeNotification(r0, r1);
    }

    public static void removeSubmitNotification(LocationSubmitNotification r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        BDLocationHelper.getInstance();
        BDLocationHelper.removeSubmitNotification(r0);
    }

    public static void requestLocationPermission(Activity r1, @Nullable Object r2, int r3, RequestPermissionUtils.OnPermissionListener r4) {
        BDLocationHelper.getInstance().requestLocationPermission(r1, r2, r3, r4);
    }

    public static void setBaseUrl(String r1) {
        BDLocationHelper.getInstance().setBaseUrl(r1);
    }

    public static void updateSettings(Context r1, JSONObject r2) {
        BDLocationHelper.getInstance().updateSettings(r1, r2);
    }

    @WorkerThread
    public static boolean uploadRegionInfo() {
        return BDLocationHelper.getInstance().uploadRegionInfo();
    }

    public static void uploadRegionInfoAsync(RegionUploadCallback r1) {
        BDLocationHelper.getInstance().uploadRegionInfoAsync(r1);
    }
}
