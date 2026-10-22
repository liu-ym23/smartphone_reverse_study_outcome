package com.obric.baseservice.location;

import android.content.Context;
import com.obric.matrix.platform.sdk.ones.location.LocationApi;
import com.obric.matrix.proto.LocationInfo;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeviceLocationFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0007J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J\f\u0010\u000f\u001a\u00020\u000b*\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/baseservice/location/DeviceLocationFetcher;", "", "()V", "TAG", "", "fetch", "", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function1;", "Lcom/obric/baseservice/location/DeviceLocationData;", "refresh", "ignoreCache", "", "toDeviceData", "Lcom/obric/matrix/proto/LocationInfo;", "baseservice_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class DeviceLocationFetcher {
    public static final DeviceLocationFetcher INSTANCE = null;
    private static final String TAG = "GbtCodeDict";

    @JvmStatic
    public static final void refresh(Context r3) {
        refresh$default(r3, false, 2, null);
    }

    static {
        INSTANCE = new DeviceLocationFetcher();
    }

    private DeviceLocationFetcher() {
    }

    public static final /* synthetic */ DeviceLocationData access$toDeviceData(DeviceLocationFetcher r0, LocationInfo r1) {
        return r0.toDeviceData(r1);
    }

    @JvmStatic
    public static final void fetch(Context r2, final Function1<? super DeviceLocationData, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "callback");
        OLog.e(TAG, "fetch=====");
        Context r4 = r2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r4, "appCtx");     // Catch: Throwable -> L5
        LocationApi.getLocation(r4, new AnonymousClass1(r3));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        OLog.e(TAG, "fetch throw", th);
        r3.invoke(null);
    }

    public static /* synthetic */ void refresh$default(Context r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        refresh(r0, r1);
    }

    @JvmStatic
    public static final void refresh(Context r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Context r5 = r3.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r5, "appCtx");     // Catch: Throwable -> L5
        LocationApi.refreshLocation(r5, new LocationApi.LocationOption(r4));     // Catch: Throwable -> L5
        OLog.d(TAG, "refresh done, ignoreCache=" + r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        OLog.e(TAG, "refresh throw", th);
    }

    private final DeviceLocationData toDeviceData(LocationInfo r15) {
        Double r1 = r15.longitude;
        Double r2 = r15.latitude;
        String r3 = r15.country;
        String r4 = r15.countryCode;
        String r5 = r15.administrativeArea;
        String r14 = r15.city;
        String r0 = r14;
        boolean r6 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        String r8 = null;
        if (r7 == false) goto L13;
        r14 = null;
    L13:
        if (r14 != null) goto L15;
        r14 = r15.locality;
    L15:
        String r9 = r15.locality;
        String r10 = r15.district;
        String r11 = r10;
        if (r11 != null) goto L18;
    L19:
        r6 = true;
    L20:
        if (r6 == true) goto L22;
        r8 = r10;
    L22:
        if (r8 != null) goto L25;
        r8 = r15.subLocality;
    L25:
        return new DeviceLocationData(r1, r2, r3, r4, r5, r14, r9, r8, r15.subLocality, r15.addressLine, r15.cityCode, r15.districtCode);
    L18:
        if (StringsKt.isBlank(r11) == false) goto L20;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r7 = false;
        goto L9
    }
}
