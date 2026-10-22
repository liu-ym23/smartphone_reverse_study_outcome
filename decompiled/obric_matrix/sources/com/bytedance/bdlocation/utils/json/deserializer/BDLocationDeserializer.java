package com.bytedance.bdlocation.utils.json.deserializer;

import android.os.Build;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.BdLBSResult;
import com.bytedance.bdlocation.network.model.LocationResult;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.m;
import com.google.gson.p;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationDeserializer implements i<BDLocation> {
    public static final String TAG = "BDLocationDeserializer";

    public BDLocationDeserializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.i
    @Nullable
    public BDLocation deserialize(j r6, Type r7, h r8) {
        m r9 = r6.c();
        if (r9 != null) goto L6;
        return null;
    L6:
        BDLocation r10 = new BDLocation(r9.y("mProvider").l(), r9.y("mLocationSDKName").l());
        r10.setCoordinateSystem(r9.y("mCoordinateSystem").l());
        r10.setAccuracy(r9.y("mAccuracy").s());
        r10.setAltitude(r9.y("mAltitude").s());
        r10.setBearing(r9.y("mBearing").s());
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 26) goto L10;
        r10.setBearingAccuracyDegrees(r9.y("mBearingAccuracyDegrees").s());
    L10:
        if (r0 < 17) goto L12;
        r10.setElapsedRealtimeNanos(r9.y("mElapsedRealtimeNanos").g());
    L12:
        r10.setLatitude(r9.y("mLatitude").r());
        r10.setLongitude(r9.y("mLongitude").r());
        r10.setSpeed(r9.y("mSpeed").s());
        if (r0 < 26) goto L15;
        r10.setSpeedAccuracyMetersPerSecond(r9.y("mSpeedAccuracyMetersPerSecond").s());
    L15:
        r10.setTime(r9.y("mTime").g());
        if (r0 < 26) goto L18;
        r10.setVerticalAccuracyMeters(r9.y("mVerticalAccuracyMeters").s());
    L18:
        p r1 = r9.y("mAddress");
        if (r1 == null) goto L21;
        r10.setAddress(r1.l());
    L21:
        p r2 = r9.y("mCountry");
        if (r2 == null) goto L24;
        r10.setCountry(r2.l());
    L24:
        p r3 = r9.y("mAdministrativeArea");
        if (r3 == null) goto L27;
        r10.setAdministrativeArea(r3.l());
    L27:
        p r4 = r9.y("mSubAdministrativeArea");
        if (r4 == null) goto L30;
        r10.setSubAdministrativeArea(r4.l());
    L30:
        p r5 = r9.y("mCity");
        if (r5 == null) goto L33;
        r10.setCity(r5.l());
    L33:
        p r11 = r9.y("mDistrict");
        if (r11 == null) goto L36;
        r10.setDistrict(r11.l());
    L36:
        p r12 = r9.y("mCityCode");
        if (r12 == null) goto L39;
        r10.setCityCode(r12.l());
    L39:
        p r13 = r9.y("mStreet");
        if (r13 == null) goto L42;
        r10.setStreet(r13.l());
    L42:
        p r14 = r9.y("mStreetNum");
        if (r14 == null) goto L45;
        r10.setStreetNum(r14.l());
    L45:
        p r15 = r9.y("mFloor");
        if (r15 == null) goto L48;
        r10.setFloor(r15.l());
    L48:
        r10.setLocationMs(r9.y("mLocationMs").g());
        p r16 = r9.y("mLocationSDKName");
        if (r16 == null) goto L51;
        r10.setLocationSDKName(r16.l());
    L51:
        p r17 = r9.y("mPoi");
        if (r17 == null) goto L54;
        r10.setPoi(r17.l());
    L54:
        BDPoint r18 = new BDPoint();
        m r19 = r9.x("mGCJ02");
        if (r19 == null) goto L60;
        p r20 = r19.y("provider");
        if (r20 == null) goto L59;
        r18.setProvider(r20.l());
    L59:
        r18.setLongitude(r19.y("longitude").r());
        r18.setLatitude(r19.y("latitude").r());
        r10.setGCJ02(r18);
    L60:
        r10.setLocationType(r9.y("mLocationType").a());
        p r21 = r9.y("mCountryCode");
        if (r21 == null) goto L63;
        r10.setCountryCode(r21.l());
    L63:
        p r22 = r9.y("mCountryLocalID");
        if (r22 == null) goto L66;
        r10.setCountryLocalID(r22.l());
    L66:
        p r23 = r9.y("mLocalID");
        if (r23 == null) goto L69;
        r10.setLocalID(r23.l());
    L69:
        p r24 = r9.y("mDistrictLocalID");
        if (r24 == null) goto L72;
        r10.setDistrictLocalID(r24.l());
    L72:
        p r25 = r9.y("mGeoNameID");
        if (r25 == null) goto L75;
        r10.setGeoNameID(r25.l());
    L75:
        p r26 = r9.y("mGeocodeSDKName");
        if (r26 == null) goto L78;
        r10.setGeocodeSDKName(r26.l());
    L78:
        p r27 = r9.y("mAoi");
        if (r27 == null) goto L81;
        r10.setAoi(r27.l());
    L81:
        p r28 = r9.y("mMockDuration");
        if (r28 == null) goto L84;
        r10.setMockDuration(r28.g());
    L84:
        p r29 = r9.y("mTown");
        if (r29 == null) goto L87;
        r10.setTown(r29.l());
    L87:
        p r30 = r9.y("mVillage");
        if (r30 == null) goto L90;
        r10.setVillage(r30.l());
    L90:
        p r31 = r9.y("mCountryId");
        if (r31 == null) goto L93;
        r10.setCountryId(r31.g());
    L93:
        p r32 = r9.y("mSubdivisionId");
        if (r32 == null) goto L96;
        r10.setSubdivisionId(r32.g());
    L96:
        p r33 = r9.y("mCityId");
        if (r33 == null) goto L99;
        r10.setCityId(r33.g());
    L99:
        p r34 = r9.y("mDistrictId");
        if (r34 == null) goto L102;
        r10.setDistrictId(r34.g());
    L102:
        p r35 = r9.y("mTownId");
        if (r35 == null) goto L105;
        r10.setTownId(r35.g());
    L105:
        p r36 = r9.y("mVillageId");
        if (r36 == null) goto L108;
        r10.setVillageId(r36.g());
    L108:
        p r37 = r9.y("mCountryAsciName");
        if (r37 == null) goto L111;
        r10.setCountryAsciName(r37.l());
    L111:
        p r38 = r9.y("mSubdivisionAsciName");
        if (r38 == null) goto L114;
        r10.setSubdivisionAsciName(r38.l());
    L114:
        p r39 = r9.y("mCityAsciName");
        if (r39 == null) goto L117;
        r10.setCityAsciName(r39.l());
    L117:
        p r40 = r9.y("mDistrictAsciName");
        if (r40 == null) goto L120;
        r10.setDistrictAsciName(r40.l());
    L120:
        p r41 = r9.y("mTownAsciName");
        if (r41 == null) goto L123;
        r10.setTownAsciName(r41.l());
    L123:
        p r42 = r9.y("mVillageAsciName");
        if (r42 == null) goto L126;
        r10.setVillageAsciName(r42.l());
    L126:
        p r43 = r9.y("mAdCode");
        if (r43 == null) goto L129;
        r10.setAdCode(r43.l());
    L129:
        p r44 = r9.y("mIsDisputed");
        if (r44 == null) goto L132;
        r10.setIsDisputed(r44.q());
    L132:
        p r45 = r9.y("mIsCompliance");
        if (r45 == null) goto L135;
        r10.setIsCompliance(r45.q());
    L135:
        p r46 = r9.y("mTrustedLevel");
        if (r46 == null) goto L138;
        r10.setTrustedLevel(r46.a());
    L138:
        p r47 = r9.y("mLocationDetail");
        if (r47 == null) goto L141;
        r10.setLocationDetail(r47.l());
    L141:
        p r48 = r9.y("mSatellites");
        if (r48 == null) goto L144;
        r10.setSatellites(r48.a());
    L144:
        p r49 = r9.y("mBuildingId");
        if (r49 == null) goto L184;
        r10.setBuildingId(r49.l());
    L184:
        m r50 = r9.x("mBdLBSResult");     // Catch: Exception -> L151
        if (r50 == null) goto L186;
        r10.setBdLBSResult((BdLBSResult) JsonUtil.sGson.h(r50, BdLBSResult.class));     // Catch: Exception -> L151
    L186:
        m r51 = r9.x("mLocationResult");     // Catch: Exception -> L157
        if (r51 == null) goto L182;
        r10.setLocationResult((LocationResult) JsonUtil.sGson.h(r51, LocationResult.class));     // Catch: Exception -> L157
    L182:
        m r52 = r9.x("mGCJ02");     // Catch: Exception -> L163
        if (r52 == null) goto L180;
        r10.setGCJ02((BDPoint) JsonUtil.sGson.h(r52, BDPoint.class));     // Catch: Exception -> L163
    L180:
        g r53 = r9.w("mPoiEntities");     // Catch: Exception -> L169
        if (r53 == null) goto L178;
        r10.setPoiEntities((List) JsonUtil.sGson.i(r53, new AnonymousClass1(this).getType()));     // Catch: Exception -> L169
    L178:
        g r54 = r9.w("mAoiEntities");     // Catch: Exception -> L175
        if (r54 == null) goto L177;
        r10.setAoiEntities((List) JsonUtil.sGson.i(r54, new AnonymousClass2(this).getType()));     // Catch: Exception -> L175
    L177:
        return r10;
    L175:
        e = move-exception;
        Logger.e(TAG, e);
    L169:
        e = move-exception;
        Logger.e(TAG, e);
    L163:
        e = move-exception;
        Logger.e(TAG, e);
    L157:
        e = move-exception;
        Logger.e(TAG, e);
    L151:
        e = move-exception;
        Logger.e(TAG, e);
        goto L186
    }

    @Override // com.google.gson.i
    @Nullable
    public /* bridge */ /* synthetic */ BDLocation deserialize(j r1, Type r2, h r3) {
        return deserialize(r1, r2, r3);
    }
}
