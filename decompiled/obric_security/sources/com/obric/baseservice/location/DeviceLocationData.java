package com.obric.baseservice.location;

import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceLocationData.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0010J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u009e\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012¨\u00064"}, d2 = {"Lcom/obric/baseservice/location/DeviceLocationData;", "", "longitude", "", "latitude", "country", "", AccountInfoBundleKey.COUNTRY_CODE, "province", "city", "locality", "district", "subLocality", "addressLine", "cityCode", "districtCode", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddressLine", "()Ljava/lang/String;", "getCity", "getCityCode", "getCountry", "getCountryCode", "getDistrict", "getDistrictCode", "getLatitude", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLocality", "getLongitude", "getProvince", "getSubLocality", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/baseservice/location/DeviceLocationData;", "equals", "", "other", "hashCode", "", "toString", "baseservice_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class DeviceLocationData {
    private final String addressLine;
    private final String city;
    private final String cityCode;
    private final String country;
    private final String countryCode;
    private final String district;
    private final String districtCode;
    private final Double latitude;
    private final String locality;
    private final Double longitude;
    private final String province;
    private final String subLocality;

    public DeviceLocationData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public static /* synthetic */ DeviceLocationData copy$default(DeviceLocationData r13, Double r14, Double r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        Double r2 = r13.longitude;
    L7:
        if ((r26 & 2) == 0) goto L9;
        Double r3 = r13.latitude;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r4 = r13.country;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r5 = r13.countryCode;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r6 = r13.province;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r7 = r13.city;
    L27:
        if ((r26 & 64) == 0) goto L29;
        String r8 = r13.locality;
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r9 = r13.district;
    L35:
        if ((r26 & 256) == 0) goto L37;
        String r10 = r13.subLocality;
    L39:
        if ((r26 & 512) == 0) goto L41;
        String r11 = r13.addressLine;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        String r12 = r13.cityCode;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        String r1 = r13.districtCode;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final Double component1() {
        return this.longitude;
    }

    public final String component10() {
        return this.addressLine;
    }

    public final String component11() {
        return this.cityCode;
    }

    public final String component12() {
        return this.districtCode;
    }

    public final Double component2() {
        return this.latitude;
    }

    public final String component3() {
        return this.country;
    }

    public final String component4() {
        return this.countryCode;
    }

    public final String component5() {
        return this.province;
    }

    public final String component6() {
        return this.city;
    }

    public final String component7() {
        return this.locality;
    }

    public final String component8() {
        return this.district;
    }

    public final String component9() {
        return this.subLocality;
    }

    public final DeviceLocationData copy(Double r15, Double r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26) {
        return new DeviceLocationData(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof DeviceLocationData) == false) goto L30;
        DeviceLocationData r4 = (DeviceLocationData) r3;
        if (Intrinsics.areEqual(this.longitude, r4.longitude) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.latitude, r4.latitude) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.country, r4.country) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.countryCode, r4.countryCode) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.province, r4.province) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.city, r4.city) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.locality, r4.locality) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.district, r4.district) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.subLocality, r4.subLocality) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.addressLine, r4.addressLine) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.cityCode, r4.cityCode) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.districtCode, r4.districtCode) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        Double r0 = this.longitude;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Double r4 = this.latitude;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.country;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.countryCode;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.province;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.city;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.locality;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.district;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.subLocality;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.addressLine;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.cityCode;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.districtCode;
        if (r34 == null) goto L50;
        r1 = r34.hashCode();
    L50:
        return r33 + r1;
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "DeviceLocationData(longitude=" + this.longitude + ", latitude=" + this.latitude + ", country=" + this.country + ", countryCode=" + this.countryCode + ", province=" + this.province + ", city=" + this.city + ", locality=" + this.locality + ", district=" + this.district + ", subLocality=" + this.subLocality + ", addressLine=" + this.addressLine + ", cityCode=" + this.cityCode + ", districtCode=" + this.districtCode + ")";
    }

    public DeviceLocationData(Double r1, Double r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12) {
        this.longitude = r1;
        this.latitude = r2;
        this.country = r3;
        this.countryCode = r4;
        this.province = r5;
        this.city = r6;
        this.locality = r7;
        this.district = r8;
        this.subLocality = r9;
        this.addressLine = r10;
        this.cityCode = r11;
        this.districtCode = r12;
    }

    public /* synthetic */ DeviceLocationData(Double r14, Double r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, int r26, DefaultConstructorMarker r27) {
        String r2 = null;
        if ((r26 & 1) == 0) goto L5;
        Double r1 = (Double) null;
        Double r3 = null;
    L7:
        if ((r26 & 2) == 0) goto L9;
        Double r4 = (Double) null;
        Double r5 = null;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r6 = (String) null;
        String r7 = null;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r8 = (String) null;
        String r9 = null;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r10 = (String) null;
        String r11 = null;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r12 = (String) null;
        String r13 = null;
    L27:
        if ((r26 & 64) == 0) goto L29;
        String r28 = (String) null;
        String r29 = null;
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r30 = (String) null;
        String r31 = null;
    L35:
        if ((r26 & 256) == 0) goto L37;
        String r110 = (String) null;
        String r111 = null;
    L39:
        if ((r26 & 512) == 0) goto L41;
        String r112 = (String) null;
        String r113 = null;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        String r114 = (String) null;
        String r115 = null;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        String r0 = (String) null;
    L50:
        this(r3, r5, r7, r9, r11, r13, r29, r31, r111, r113, r115, r2);
        return;
    L49:
        r2 = r25;
        goto L50
    L45:
        r115 = r24;
        goto L47
    L41:
        r113 = r23;
        goto L43
    L37:
        r111 = r22;
        goto L39
    L33:
        r31 = r21;
        goto L35
    L29:
        r29 = r20;
        goto L31
    L25:
        r13 = r19;
        goto L27
    L21:
        r11 = r18;
        goto L23
    L17:
        r9 = r17;
        goto L19
    L13:
        r7 = r16;
        goto L15
    L9:
        r5 = r15;
        goto L11
    L5:
        r3 = r14;
        goto L7
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final Double getLatitude() {
        return this.latitude;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getProvince() {
        return this.province;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getLocality() {
        return this.locality;
    }

    public final String getDistrict() {
        return this.district;
    }

    public final String getSubLocality() {
        return this.subLocality;
    }

    public final String getAddressLine() {
        return this.addressLine;
    }

    public final String getCityCode() {
        return this.cityCode;
    }

    public final String getDistrictCode() {
        return this.districtCode;
    }
}
