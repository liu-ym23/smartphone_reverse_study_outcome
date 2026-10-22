package com.bytedance.bdlocation.utils.json.serializer;

import android.os.Build;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.google.gson.j;
import com.google.gson.m;
import com.google.gson.q;
import com.google.gson.r;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationSerializer implements r<BDLocation> {
    public BDLocationSerializer() {
    }

    /* JADX INFO: renamed from: serialize, reason: avoid collision after fix types in other method */
    public j serialize2(BDLocation r5, Type r6, q r7) {
        m r8 = new m();
        r8.t("mProvider", r5.getProvider());     // Catch: Exception -> L17
        r8.s("mAccuracy", Float.valueOf(r5.getAccuracy()));     // Catch: Exception -> L17
        r8.s("mAltitude", Double.valueOf(r5.getAltitude()));     // Catch: Exception -> L17
        r8.s("mBearing", Float.valueOf(r5.getBearing()));     // Catch: Exception -> L17
        int r9 = Build.VERSION.SDK_INT;     // Catch: Exception -> L17
        if (r9 < 26) goto L7;
        r8.s("mBearingAccuracyDegrees", Float.valueOf(r5.getBearingAccuracyDegrees()));     // Catch: Exception -> L17
    L7:
        if (r9 < 17) goto L9;
        r8.s("mElapsedRealtimeNanos", Long.valueOf(r5.getElapsedRealtimeNanos()));     // Catch: Exception -> L17
    L9:
        r8.s("mLatitude", Double.valueOf(r5.getLatitude()));     // Catch: Exception -> L17
        r8.s("mLongitude", Double.valueOf(r5.getLongitude()));     // Catch: Exception -> L17
        r8.t("mProvider", r5.getProvider());     // Catch: Exception -> L17
        r8.s("mSpeed", Float.valueOf(r5.getSpeed()));     // Catch: Exception -> L17
        if (r9 < 26) goto L12;
        r8.s("mSpeedAccuracyMetersPerSecond", Float.valueOf(r5.getSpeedAccuracyMetersPerSecond()));     // Catch: Exception -> L17
    L12:
        r8.s("mTime", Long.valueOf(r5.getTime()));     // Catch: Exception -> L17
        if (r9 < 26) goto L15;
        r8.s("mVerticalAccuracyMeters", Float.valueOf(r5.getVerticalAccuracyMeters()));     // Catch: Exception -> L17
    L15:
        r8.t("mAddress", r5.getAddress());     // Catch: Exception -> L17
        r8.t("mCountry", r5.getCountry());     // Catch: Exception -> L17
        r8.t("mAdministrativeArea", r5.getAdministrativeArea());     // Catch: Exception -> L17
        r8.t("mSubAdministrativeArea", r5.getSubAdministrativeArea());     // Catch: Exception -> L17
        r8.t("mCity", r5.getCity());     // Catch: Exception -> L17
        r8.t("mDistrict", r5.getDistrict());     // Catch: Exception -> L17
        r8.t("mCityCode", r5.getCityCode());     // Catch: Exception -> L17
        r8.t("mStreet", r5.getStreet());     // Catch: Exception -> L17
        r8.t("mStreetNum", r5.getStreetNum());     // Catch: Exception -> L17
        r8.t("mFloor", r5.getFloor());     // Catch: Exception -> L17
        r8.s("mLocationMs", Long.valueOf(r5.getLocationMs()));     // Catch: Exception -> L17
        r8.t("mLocationSDKName", r5.getLocationSDKName());     // Catch: Exception -> L17
        r8.t("mCoordinateSystem", r5.getCoordinateSystem());     // Catch: Exception -> L17
        r8.t("mPoi", r5.getPoi());     // Catch: Exception -> L17
        r8.s("mLocationType", Integer.valueOf(r5.getLocationType()));     // Catch: Exception -> L17
        r8.t("mCountryCode", r5.getCountryCode());     // Catch: Exception -> L17
        r8.t("mCountryLocalID", r5.getCountryLocalID());     // Catch: Exception -> L17
        r8.t("mLocalID", r5.getLocalID());     // Catch: Exception -> L17
        r8.t("mDistrictLocalID", r5.getDistrictLocalID());     // Catch: Exception -> L17
        r8.t("mGeoNameID", r5.getGeoNameID());     // Catch: Exception -> L17
        r8.t("mGeocodeSDKName", r5.getGeocodeSDKName());     // Catch: Exception -> L17
        r8.t("mAoi", r5.getAoi());     // Catch: Exception -> L17
        r8.s("mMockDuration", Long.valueOf(r5.getMockDuration()));     // Catch: Exception -> L17
        r8.t("mTown", r5.getTown());     // Catch: Exception -> L17
        r8.t("mVillage", r5.getVillage());     // Catch: Exception -> L17
        r8.s("mCountryId", Long.valueOf(r5.getCountryId()));     // Catch: Exception -> L17
        r8.s("mSubdivisionId", Long.valueOf(r5.getSubdivisionId()));     // Catch: Exception -> L17
        r8.s("mCityId", Long.valueOf(r5.getCityId()));     // Catch: Exception -> L17
        r8.s("mDistrictId", Long.valueOf(r5.getDistrictId()));     // Catch: Exception -> L17
        r8.s("mTownId", Long.valueOf(r5.getTownId()));     // Catch: Exception -> L17
        r8.s("mVillageId", Long.valueOf(r5.getVillageId()));     // Catch: Exception -> L17
        r8.t("mCountryAsciName", r5.getCountryAsciName());     // Catch: Exception -> L17
        r8.t("mSubdivisionAsciName", r5.getSubdivisionAsciName());     // Catch: Exception -> L17
        r8.t("mCityAsciName", r5.getCityAsciName());     // Catch: Exception -> L17
        r8.t("mDistrictAsciName", r5.getDistrictAsciName());     // Catch: Exception -> L17
        r8.t("mTownAsciName", r5.getTownAsciName());     // Catch: Exception -> L17
        r8.t("mVillageAsciName", r5.getVillageAsciName());     // Catch: Exception -> L17
        r8.t("mAdCode", r5.getAdCode());     // Catch: Exception -> L17
        r8.r("mIsDisputed", Boolean.valueOf(r5.getIsDisputed()));     // Catch: Exception -> L17
        r8.r("mIsCompliance", Boolean.valueOf(r5.getIsCompliance()));     // Catch: Exception -> L17
        r8.s("mTrustedLevel", Integer.valueOf(r5.getTrustedLevel()));     // Catch: Exception -> L17
        r8.t("mLocationDetail", r5.getLocationDetail());     // Catch: Exception -> L17
        r8.s("mSatellites", Integer.valueOf(r5.getSatellites()));     // Catch: Exception -> L17
        r8.t("mBuildingId", r5.getBuildingId());     // Catch: Exception -> L17
        r8.q("mBdLBSResult", JsonUtil.safeToJsonTree(r5.getBdLBSResult()));     // Catch: Exception -> L17
        r8.q("mLocationResult", JsonUtil.safeToJsonTree(r5.getLocationResult()));     // Catch: Exception -> L17
        r8.q("mGCJ02", JsonUtil.safeToJsonTree(r5.getGCJ02()));     // Catch: Exception -> L17
        r8.q("mPoiEntities", JsonUtil.safeToJsonTree(r5.getPoiEntities()));     // Catch: Exception -> L17
        r8.q("mAoiEntities", JsonUtil.safeToJsonTree(r5.getAoiEntities()));     // Catch: Exception -> L17
    L19:
        return r8;
    L17:
        e = move-exception;
        Logger.i(e.getMessage());
        goto L19
    }

    @Override // com.google.gson.r
    public /* bridge */ /* synthetic */ j serialize(BDLocation r1, Type r2, q r3) {
        return serialize2(r1, r2, r3);
    }
}
