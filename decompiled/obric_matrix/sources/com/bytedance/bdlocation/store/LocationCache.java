package com.bytedance.bdlocation.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.bytedance.mpaas.app.a;
import com.obric.matrix.r.b;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class LocationCache {
    private static final String SHARED_KEY_LOCATE_TIME = "LocateTime";
    private static final String SHARED_KEY_LOCATION_CACHE = "location_cache";
    private static final String SHARED_KEY_LOCATION_DENY_TIME = "LocationDenyTime";
    private static final String SHARED_KEY_LOCATION_SETTINGS = "bd_location_settings";
    private static final String SHARED_KEY_MOCK_WIFI_NAME = "MockWifiName";
    private static final String SHARED_KEY_PRECISE_LATLNG = "PreciseLatLng";
    private static final String SHARED_NAME = "BDLocationCache";
    private static final String TAG = "BDLocationCache";
    private static LocationCache sInstance;
    private Context mContext;
    private LocationCacheInfo mLocationCacheInfo;
    private SharedPreferences mSharedPreferences;

    private LocationCache() {
        if (this.mContext != null) goto L5;
        this.mContext = BDLocationConfig.getContext();
    L5:
        Context r0 = this.mContext;
        if (r0 == null) goto L9;
        this.mSharedPreferences = INVOKEVIRTUAL_com_bytedance_bdlocation_store_LocationCache_com_obric_matrix_SPLancet_getSharedPreferences2(r0, "BDLocationCache", 0);
        return;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences INVOKEVIRTUAL_com_bytedance_bdlocation_store_LocationCache_com_obric_matrix_SPLancet_getSharedPreferences2(Context r0, String r1, int r2) {
        return b.g(a.a()).getSharedPreferences(r1, r2);
    }

    private boolean checkCache() {
        if (this.mSharedPreferences != null) goto L8;
        if (BDLocationConfig.getContext() == null) goto L8;
        Logger.i("checkCache: BDLocationConfig.getContext() is null");
        Context r0 = BDLocationConfig.getContext();
        this.mContext = r0;
        this.mSharedPreferences = INVOKEVIRTUAL_com_bytedance_bdlocation_store_LocationCache_com_obric_matrix_SPLancet_getSharedPreferences2(r0, "BDLocationCache", 0);
    L8:
        if (this.mSharedPreferences == null) goto L11;
        return true;
    L11:
        Logger.i("checkCache: mSharedPreferences is null");
        return false;
    }

    private LocationCacheInfo fromCacheInfoJson(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return null;
    L10:
        return (LocationCacheInfo) JsonUtil.sGson.m(r3, LocationCacheInfo.class);
    L7:
        th = move-exception;
        Logger.e("BDLocation", th);
        return null;
    }

    public static LocationCache getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(LocationCache.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new LocationCache();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LocationCache.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void setLocationCache(LocationCacheInfo r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        String r0 = toCacheInfoJson(r3);
        if (TextUtils.isEmpty(r0) == true) goto L7;
        setStringValue(SHARED_KEY_LOCATION_CACHE, r0);
        setLocateTime(System.currentTimeMillis());
    L7:
        this.mLocationCacheInfo = r3;
    }

    @Nullable
    private String toCacheInfoJson(LocationCacheInfo r2) {
        if (r2 != null) goto L9;
    L8:
        return null;
    L9:
        return JsonUtil.sGson.v(r2);
    L6:
        th = move-exception;
        Logger.e("BDLocation", th);
        goto L8
    }

    public void clearLocalLocationCache() {
        removeKey(SHARED_KEY_LOCATION_CACHE);
        this.mLocationCacheInfo = null;
    }

    public void executeLocationCache(BDLocation r5) {
        if (this.mLocationCacheInfo != null) goto L5;
        this.mLocationCacheInfo = getLocationCache();
    L5:
        LocationCacheInfo r0 = this.mLocationCacheInfo;
        if (r0 == null) goto L10;
        int r1 = LocationUtil.compareLocation(r0.getLatestLocation(), r5);
        Logger.d("BDLocationCache", "executeLocationCache:compareLocation range:" + r1);
        if (r1 == (-1)) goto L13;
    L11:
        BDLocationConfig.notificationLocationChange(r1, r5);
    L13:
        if (this.mLocationCacheInfo != null) goto L15;
        this.mLocationCacheInfo = new LocationCacheInfo();
    L15:
        this.mLocationCacheInfo.setLatestLocation(r5);
        StringBuilder r2 = new StringBuilder();
        r2.append("ConnectManager:setLatestLocation is executed and location is ");
        if (r5 != null) goto L18;
        String r6 = "";
    L19:
        r2.append(r6);
        Logger.d(r2.toString());
        setLocationCache(this.mLocationCacheInfo);
        return;
    L18:
        r6 = r5.getAddress();
        goto L19
    L10:
        Logger.d("BDLocationCache", "executeLocationCache:mLocationCacheInfo==null");
        r1 = 0;
        goto L11
    }

    public boolean getBooleanValue(String r3) {
        if (checkCache() == true) goto L6;
        return false;
    L6:
        return this.mSharedPreferences.getBoolean(r3, false);
    }

    public int getIntValue(String r3) {
        if (checkCache() == true) goto L6;
        return 0;
    L6:
        return this.mSharedPreferences.getInt(r3, 0);
    }

    public LocationCacheInfo getLocationCache() {
        Logger.i("getLocationCache start");
        if (this.mLocationCacheInfo != null) goto L6;
        this.mLocationCacheInfo = fromCacheInfoJson(getStringValue(SHARED_KEY_LOCATION_CACHE));
        Logger.i("getLocationCache fromCacheInfoJson");
    L6:
        if (this.mLocationCacheInfo != null) goto L9;
        this.mLocationCacheInfo = new LocationCacheInfo();
    L9:
        return this.mLocationCacheInfo;
    }

    public long getLocationDenyTime() {
        return getLongValue(SHARED_KEY_LOCATION_DENY_TIME);
    }

    public String getLocationSettings() {
        return getStringValue(SHARED_KEY_LOCATION_SETTINGS);
    }

    public long getLongValue(String r4) {
        if (checkCache() == true) goto L6;
        return 0;
    L6:
        return this.mSharedPreferences.getLong(r4, 0);
    }

    public String getMockWifiName() {
        return getStringValue(SHARED_KEY_MOCK_WIFI_NAME);
    }

    public String getPreciseLatLng() {
        return getStringValue(SHARED_KEY_PRECISE_LATLNG);
    }

    public String getStringValue(String r3) {
        if (checkCache() == true) goto L6;
        return "";
    L6:
        return this.mSharedPreferences.getString(r3, "");
    }

    public void removeKey(String r2) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r1 = this.mSharedPreferences.edit();
        r1.remove(r2);
        r1.commit();
    }

    public void setBooleanValue(String r2, boolean r3) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r1 = this.mSharedPreferences.edit();
        r1.putBoolean(r2, r3);
        r1.apply();
    }

    public void setIntValue(String r2, int r3) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r1 = this.mSharedPreferences.edit();
        r1.putInt(r2, r3);
        r1.apply();
    }

    public void setLocateTime(long r2) {
        setLongValue(SHARED_KEY_LOCATE_TIME, r2);
    }

    public void setLocationDenyTime(long r2) {
        setLongValue(SHARED_KEY_LOCATION_DENY_TIME, r2);
    }

    public void setLocationSettings(Context r3, String r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.mSharedPreferences != null) goto L7;
        this.mSharedPreferences = INVOKEVIRTUAL_com_bytedance_bdlocation_store_LocationCache_com_obric_matrix_SPLancet_getSharedPreferences2(r3, "BDLocationCache", 0);
    L7:
        setStringValue(SHARED_KEY_LOCATION_SETTINGS, r4);
    }

    public void setLongValue(String r2, long r3) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r1 = this.mSharedPreferences.edit();
        r1.putLong(r2, r3);
        r1.apply();
    }

    public void setMockLocation(BDLocation r2) {
        if (this.mLocationCacheInfo != null) goto L6;
        this.mLocationCacheInfo = getLocationCache();
    L6:
        if (this.mLocationCacheInfo != null) goto L8;
        this.mLocationCacheInfo = new LocationCacheInfo();
    L8:
        this.mLocationCacheInfo.setMockLocation(r2);
        setLocationCache(this.mLocationCacheInfo);
    }

    public void setMockWifiName(String r2) {
        setStringValue(SHARED_KEY_MOCK_WIFI_NAME, r2);
    }

    public void setPreciseLatLng(String r2) {
        setStringValue(SHARED_KEY_PRECISE_LATLNG, r2);
    }

    public void setStringValue(String r2, String r3) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r1 = this.mSharedPreferences.edit();
        r1.putString(r2, r3);
        r1.apply();
    }
}
