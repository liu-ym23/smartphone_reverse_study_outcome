package com.google.i18n.phonenumbers.internal;

import com.google.i18n.phonenumbers.CountryCodeToRegionCodeMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class GeoEntityUtility {
    public static final String REGION_CODE_FOR_NON_GEO_ENTITIES = "001";

    public static boolean isGeoEntity(String r1) {
        return !r1.equals("001");
    }

    public static boolean isGeoEntity(int r1) {
        List<String> r2 = CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap().get(Integer.valueOf(r1));
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.contains("001") == true) goto L7;
        return true;
    }

    private GeoEntityUtility() {
    }
}
