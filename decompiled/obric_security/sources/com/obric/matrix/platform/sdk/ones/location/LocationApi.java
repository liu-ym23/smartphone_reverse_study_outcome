package com.obric.matrix.platform.sdk.ones.location;

import android.content.Context;
import android.location.Address;
import android.net.Uri;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.matrix.platform.sdk.ones.internal.tunnel.CmdManager;
import com.obric.matrix.platform.sdk.ones.internal.tunnel.MatrixEventObserver;
import com.obric.matrix.platform.sdk.ones.internal.util.KtExt;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.proto.DecodeLocationRequest;
import com.obric.matrix.proto.GetIntersectFencesRequest;
import com.obric.matrix.proto.GetIntersectFencesResponse;
import com.obric.matrix.proto.GetLocationRequest;
import com.obric.matrix.proto.LocationInfo;
import com.obric.matrix.proto.MATRIX_CMD;
import com.obric.matrix.proto.RefreshLocationRequest;
import com.obric.matrix.proto.Request;
import com.obric.matrix.proto.RequestBody;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocationApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002/0B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JP\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102)\u0010\u0012\u001a%\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\u0002\u0010\u0019JZ\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2@\u0010\u0012\u001a<\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\f0\u001dH\u0007JB\u0010 \u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2)\u0010!\u001a%\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\f0\u0013H\u0007¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u0018H\u0007J!\u0010&\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020(H\u0007¢\u0006\u0002\u0010)J%\u0010*\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0+H\u0007¢\u0006\u0002\u0010,J\u0017\u0010-\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010.R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u00061"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/location/LocationApi;", "", "()V", "TAG", "", "locationObserver", "Lcom/obric/matrix/platform/sdk/ones/location/LocationApi$LocationObserver;", "getLocationObserver", "()Lcom/obric/matrix/platform/sdk/ones/location/LocationApi$LocationObserver;", "locationObserver$delegate", "Lkotlin/Lazy;", "decodeLocation", "", "context", "Landroid/content/Context;", "longitude", "", "latitude", "resultCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Lcom/obric/matrix/proto/LocationInfo;", "(Landroid/content/Context;DDLkotlin/jvm/functions/Function2;)Lkotlin/Unit;", "getIntersectFences", "request", "Lcom/obric/matrix/proto/GetIntersectFencesRequest;", "Lkotlin/Function3;", "Lcom/obric/matrix/proto/GetIntersectFencesResponse;", "errMsg", "getLocation", "listener", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)Lkotlin/Unit;", "locationInfoToAddress", "Landroid/location/Address;", BatteryTypeInf.BATTERY_LOC_API, "refreshLocation", "option", "Lcom/obric/matrix/platform/sdk/ones/location/LocationApi$LocationOption;", "(Landroid/content/Context;Lcom/obric/matrix/platform/sdk/ones/location/LocationApi$LocationOption;)Lkotlin/Unit;", "registerLocationChangeListener", "Lkotlin/Function0;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;", "unregisterLocationChangeListener", "(Landroid/content/Context;)Lkotlin/Unit;", "LocationObserver", "LocationOption", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocationApi {
    public static final LocationApi INSTANCE = null;
    private static final String TAG = "LocationApi";
    private static final Lazy locationObserver$delegate = null;

    /* JADX INFO: compiled from: LocationApi.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/location/LocationApi$LocationObserver;", "Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/MatrixEventObserver;", "()V", "callback", "Lkotlin/Function0;", "", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "(Lkotlin/jvm/functions/Function0;)V", "handleContentChange", "uri", "Landroid/net/Uri;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LocationObserver extends MatrixEventObserver {
        private volatile Function0<Unit> callback;

        public LocationObserver() {
            super(LocationConst.PATH_LOCATION_STATUS, false, null, 4, null);
        }

        public final Function0<Unit> getCallback() {
            return this.callback;
        }

        public final void setCallback(Function0<Unit> r1) {
            this.callback = r1;
        }

        @Override // com.obric.matrix.platform.sdk.ones.internal.tunnel.MatrixEventObserver
        public void handleContentChange(Uri r2) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            if (this.callback != null) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(r2.getPath(), LocationConst.PATH_LOCATION_STATUS) == false) goto L11;
            Function0<Unit> r1 = this.callback;
            if (r1 == null) goto L12;
            r1.invoke();
            return;
        L12:
            return;
        }
    }

    /* JADX INFO: compiled from: LocationApi.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/location/LocationApi$LocationOption;", "", "ignoreCache", "", "(Z)V", "getIgnoreCache", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LocationOption {
        private final boolean ignoreCache;

        public LocationOption() {
            boolean r2 = false;
            this(r2, 1, null);
        }

        public static /* synthetic */ LocationOption copy$default(LocationOption r0, boolean r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.ignoreCache;
        L6:
            return r0.copy(r1);
        }

        public final boolean component1() {
            return this.ignoreCache;
        }

        public final LocationOption copy(boolean r1) {
            return new LocationOption(r1);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof LocationOption) == true) goto L9;
            return false;
        L9:
            if (this.ignoreCache == ((LocationOption) r4).ignoreCache) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            boolean r0 = this.ignoreCache;
            if (r0 == false) goto L6;
            return 1;
        L6:
            return r0 ? 1 : 0;
        }

        public String toString() {
            return "LocationOption(ignoreCache=" + this.ignoreCache + ')';
        }

        public LocationOption(boolean r1) {
            this.ignoreCache = r1;
        }

        public /* synthetic */ LocationOption(boolean r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = false;
        L5:
            this(r1);
        }

        public final boolean getIgnoreCache() {
            return this.ignoreCache;
        }
    }

    @JvmStatic
    public static final Unit refreshLocation(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return refreshLocation$default(r2, null, 2, null);
    }

    private LocationApi() {
    }

    public static final /* synthetic */ LocationObserver access$getLocationObserver(LocationApi r0) {
        return r0.getLocationObserver();
    }

    static {
        INSTANCE = new LocationApi();
        locationObserver$delegate = LazyKt.lazy(LocationApi$locationObserver$2.INSTANCE);
    }

    private final LocationObserver getLocationObserver() {
        return (LocationObserver) locationObserver$delegate.getValue();
    }

    @JvmStatic
    public static final Unit getLocation(Context r4, final Function2<? super Boolean, ? super LocationInfo, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "listener");
        KtExt r1 = KtExt.INSTANCE;
        Request r6 = new Request.Builder().cmd(Integer.valueOf(MATRIX_CMD.CMD_GET_LOCATION.getValue())).body(new RequestBody.Builder().getLocationRequest(new GetLocationRequest.Builder().packageName(r4.getPackageName()).build()).build()).build();     // Catch: Throwable -> L5
        MLog.d$default(TAG, "getLocation, request: " + r6, null, 4, null);     // Catch: Throwable -> L5
        CmdManager r0 = CmdManager.INSTANCE;     // Catch: Throwable -> L5
        int r2 = MATRIX_CMD.CMD_GET_LOCATION.getValue();     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r6, "request");     // Catch: Throwable -> L5
        r0.sendCmd(r2, r6, new LocationApi$getLocation$1$1(r5));     // Catch: Throwable -> L5
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        MLog.e("tryRun , failed, " + th);
        return null;
    }

    public final Unit decodeLocation(Context r3, double r4, double r6, final Function2<? super Boolean, ? super LocationInfo, Unit> r8) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r8, "resultCallback");
        KtExt r0 = KtExt.INSTANCE;
        Request r5 = new Request.Builder().cmd(Integer.valueOf(MATRIX_CMD.CMD_DECODE_LOCATION.getValue())).body(new RequestBody.Builder().decodeLocationRequest(new DecodeLocationRequest.Builder().packageName(r3.getPackageName()).longitude(Double.valueOf(r4)).latitude(Double.valueOf(r6)).build()).build()).build();     // Catch: Throwable -> L5
        MLog.d$default(TAG, "decodeLocation, request: " + r5, null, 4, null);     // Catch: Throwable -> L5
        CmdManager r2 = CmdManager.INSTANCE;     // Catch: Throwable -> L5
        int r7 = MATRIX_CMD.CMD_DECODE_LOCATION.getValue();     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r5, "request");     // Catch: Throwable -> L5
        r2.sendCmd(r7, r5, new LocationApi$decodeLocation$1$1(r8));     // Catch: Throwable -> L5
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        MLog.e("tryRun , failed, " + th);
        return null;
    }

    @JvmStatic
    public static final Address locationInfoToAddress(LocationInfo r3) {
        if (r3 != null) goto L4;
        Address r0 = (Address) null;
        return null;
    L4:
        Address r1 = new Address(Locale.getDefault());
        Double r2 = r3.latitude;
        Intrinsics.checkNotNullExpressionValue(r2, "location.latitude");
        r1.setLatitude(r2.doubleValue());
        Double r4 = r3.longitude;
        Intrinsics.checkNotNullExpressionValue(r4, "location.longitude");
        r1.setLongitude(r4.doubleValue());
        r1.setAdminArea(r3.administrativeArea);
        r1.setSubAdminArea(r3.subAdministrativeArea);
        r1.setCountryName(r3.country);
        r1.setLocality(r3.locality);
        r1.setSubLocality(r3.subLocality);
        r1.setAddressLine(0, r3.addressLine);
        return r1;
    }

    @JvmStatic
    public static final Unit refreshLocation(Context r3, LocationOption r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "option");
        KtExt r1 = KtExt.INSTANCE;
        Request r5 = new Request.Builder().cmd(Integer.valueOf(MATRIX_CMD.CMD_REFRESH_LOCATION.getValue())).body(new RequestBody.Builder().refreshLocationRequest(new RefreshLocationRequest.Builder().packageName(r3.getPackageName()).ignoreCache(Boolean.valueOf(r4.getIgnoreCache())).build()).build()).build();     // Catch: Throwable -> L5
        MLog.d$default(TAG, "refreshLocation, request: " + r5, null, 4, null);     // Catch: Throwable -> L5
        CmdManager r6 = CmdManager.INSTANCE;     // Catch: Throwable -> L5
        int r0 = MATRIX_CMD.CMD_REFRESH_LOCATION.getValue();     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r5, "request");     // Catch: Throwable -> L5
        r6.sendCmd(r0, r5, new LocationApi$refreshLocation$1$1());     // Catch: Throwable -> L5
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        MLog.e("tryRun , failed, " + th);
        return null;
    }

    public static /* synthetic */ Unit refreshLocation$default(Context r1, LocationOption r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        boolean r0 = false;
        r2 = new LocationOption(r0, 1, null);
    L6:
        return refreshLocation(r1, r2);
    }

    @JvmStatic
    public static final void getIntersectFences(Context r3, GetIntersectFencesRequest r4, final Function3<? super Boolean, ? super GetIntersectFencesResponse, ? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "resultCallback");
        Request r6 = new Request.Builder().cmd(Integer.valueOf(MATRIX_CMD.CMD_GET_INTERSECT_FENCES.getValue())).appPkg(r3.getPackageName()).body(new RequestBody.Builder().getIntersectFencesRequest(r4).build()).build();
        MLog.d$default(TAG, "getIntersectFences, request: " + r6, null, 4, null);
        CmdManager r7 = CmdManager.INSTANCE;
        int r0 = MATRIX_CMD.CMD_GET_INTERSECT_FENCES.getValue();
        Intrinsics.checkNotNullExpressionValue(r6, "_request");
        r7.sendCmd(r0, r6, new AnonymousClass1(r5));
    }

    @JvmStatic
    public static final Unit registerLocationChangeListener(Context r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "listener");
        KtExt r0 = KtExt.INSTANCE;
        MLog.i$default(TAG, "registerLocationChangeListener", null, 4, null);     // Catch: Throwable -> L5
        LocationObserver r1 = access$getLocationObserver(INSTANCE);     // Catch: Throwable -> L5
        r1.setCallback(r5);     // Catch: Throwable -> L5
        r1.register(r4);     // Catch: Throwable -> L5
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        MLog.e("tryRun , failed, " + th);
        return null;
    }

    @JvmStatic
    public static final Unit unregisterLocationChangeListener(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        KtExt r0 = KtExt.INSTANCE;
        MLog.i$default(TAG, "unregisterLocationChangeListener", null, 4, null);     // Catch: Throwable -> L5
        LocationObserver r1 = access$getLocationObserver(INSTANCE);     // Catch: Throwable -> L5
        r1.setCallback(null);     // Catch: Throwable -> L5
        r1.unregister(r4);     // Catch: Throwable -> L5
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        MLog.e("tryRun , failed, " + th);
        return null;
    }
}
