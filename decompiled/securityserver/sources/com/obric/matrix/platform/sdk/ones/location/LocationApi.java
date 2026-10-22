package com.obric.matrix.platform.sdk.ones.location;

import android.content.Context;
import android.location.Address;
import android.net.Uri;
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
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class LocationApi {

    @NotNull
    public static final LocationApi INSTANCE = null;

    @NotNull
    private static final String TAG = "LocationApi";

    @NotNull
    private static final Lazy locationObserver$delegate = null;

    @Metadata
    public static final class LocationObserver extends MatrixEventObserver {

        @Nullable
        private volatile Function0<Unit> callback;

        public LocationObserver() {
            super(LocationConst.PATH_LOCATION_STATUS, false, null, 4, null);
        }

        @Nullable
        public final Function0<Unit> getCallback() {
            return this.callback;
        }

        @Override // com.obric.matrix.platform.sdk.ones.internal.tunnel.MatrixEventObserver
        public void handleContentChange(@NotNull Uri r2) {
            Intrinsics.f(r2, "uri");
            if (this.callback != null) goto L6;
            return;
        L6:
            if (Intrinsics.a(r2.getPath(), LocationConst.PATH_LOCATION_STATUS) == false) goto L11;
            Function0<Unit> r1 = this.callback;
            if (r1 == null) goto L12;
            r1.invoke();
            return;
        L12:
            return;
        }

        public final void setCallback(@Nullable Function0<Unit> r1) {
            this.callback = r1;
        }
    }

    @Metadata
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

        @NotNull
        public final LocationOption copy(boolean r1) {
            return new LocationOption(r1);
        }

        public boolean equals(@Nullable Object r4) {
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

        public final boolean getIgnoreCache() {
            return this.ignoreCache;
        }

        public int hashCode() {
            boolean r0 = this.ignoreCache;
            if (r0 == false) goto L6;
            return 1;
        L6:
            return r0 ? 1 : 0;
        }

        @NotNull
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
    }

    static {
        INSTANCE = new LocationApi();
        locationObserver$delegate = LazyKt.b(LocationApi$locationObserver$2.INSTANCE);
    }

    private LocationApi() {
    }

    public static final /* synthetic */ LocationObserver access$getLocationObserver(LocationApi r0) {
        return r0.getLocationObserver();
    }

    @JvmStatic
    public static final void getIntersectFences(@NotNull Context r4, @NotNull GetIntersectFencesRequest r5, @NotNull final Function3<? super Boolean, ? super GetIntersectFencesResponse, ? super String, Unit> r6) {
        Intrinsics.f(r4, "context");
        Intrinsics.f(r5, "request");
        Intrinsics.f(r6, "resultCallback");
        Request.Builder r0 = new Request.Builder();
        MATRIX_CMD r1 = MATRIX_CMD.CMD_GET_INTERSECT_FENCES;
        Request r7 = r0.cmd(Integer.valueOf(r1.getValue())).appPkg(r4.getPackageName()).body(new RequestBody.Builder().getIntersectFencesRequest(r5).build()).build();
        MLog.d$default(TAG, "getIntersectFences, request: " + r7, null, 4, null);
        CmdManager r8 = CmdManager.INSTANCE;
        int r2 = r1.getValue();
        Intrinsics.e(r7, "_request");
        r8.sendCmd(r2, r7, new AnonymousClass1(r6));
    }

    @JvmStatic
    @Nullable
    public static final Unit getLocation(@NotNull Context r5, @NotNull final Function2<? super Boolean, ? super LocationInfo, Unit> r6) {
        Intrinsics.f(r5, "context");
        Intrinsics.f(r6, "listener");
        KtExt r1 = KtExt.INSTANCE;
        GetLocationRequest r7 = new GetLocationRequest.Builder().packageName(r5.getPackageName()).build();     // Catch: Throwable -> L5
        Request.Builder r2 = new Request.Builder();     // Catch: Throwable -> L5
        MATRIX_CMD r3 = MATRIX_CMD.CMD_GET_LOCATION;     // Catch: Throwable -> L5
        Request r8 = r2.cmd(Integer.valueOf(r3.getValue())).body(new RequestBody.Builder().getLocationRequest(r7).build()).build();     // Catch: Throwable -> L5
        MLog.d$default(TAG, "getLocation, request: " + r8, null, 4, null);     // Catch: Throwable -> L5
        CmdManager r0 = CmdManager.INSTANCE;     // Catch: Throwable -> L5
        int r4 = r3.getValue();     // Catch: Throwable -> L5
        Intrinsics.e(r8, "request");     // Catch: Throwable -> L5
        r0.sendCmd(r4, r8, new LocationApi$getLocation$1$1(r6));     // Catch: Throwable -> L5
        return Unit.f330a;
    L5:
        th = move-exception;
        MLog.e("tryRun , failed, " + th);
        return null;
    }

    private final LocationObserver getLocationObserver() {
        return (LocationObserver) locationObserver$delegate.getValue();
    }

    @JvmStatic
    @Nullable
    public static final Address locationInfoToAddress(@Nullable LocationInfo r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        Address r0 = new Address(Locale.getDefault());
        Double r1 = r3.latitude;
        Intrinsics.e(r1, "location.latitude");
        r0.setLatitude(r1.doubleValue());
        Double r2 = r3.longitude;
        Intrinsics.e(r2, "location.longitude");
        r0.setLongitude(r2.doubleValue());
        r0.setAdminArea(r3.administrativeArea);
        r0.setSubAdminArea(r3.subAdministrativeArea);
        r0.setCountryName(r3.country);
        r0.setLocality(r3.locality);
        r0.setSubLocality(r3.subLocality);
        r0.setAddressLine(0, r3.addressLine);
        return r0;
    }

    @JvmStatic
    @JvmOverloads
    @Nullable
    public static final Unit refreshLocation(@NotNull Context r2) {
        Intrinsics.f(r2, "context");
        return refreshLocation$default(r2, null, 2, null);
    }

    public static /* synthetic */ Unit refreshLocation$default(Context r1, LocationOption r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        boolean r0 = false;
        r2 = new LocationOption(r0, 1, null);
    L6:
        return refreshLocation(r1, r2);
    }

    @JvmStatic
    @Nullable
    public static final Unit registerLocationChangeListener(@NotNull Context r4, @NotNull Function0<Unit> r5) {
        Intrinsics.f(r4, "context");
        Intrinsics.f(r5, "listener");
        KtExt r0 = KtExt.INSTANCE;
        MLog.i$default(TAG, "registerLocationChangeListener", null, 4, null);     // Catch: Throwable -> L5
        LocationObserver r1 = access$getLocationObserver(INSTANCE);     // Catch: Throwable -> L5
        r1.setCallback(r5);     // Catch: Throwable -> L5
        r1.register(r4);     // Catch: Throwable -> L5
        return Unit.f330a;
    L5:
        th = move-exception;
        MLog.e("tryRun , failed, " + th);
        return null;
    }

    @JvmStatic
    @Nullable
    public static final Unit unregisterLocationChangeListener(@NotNull Context r4) {
        Intrinsics.f(r4, "context");
        KtExt r0 = KtExt.INSTANCE;
        MLog.i$default(TAG, "unregisterLocationChangeListener", null, 4, null);     // Catch: Throwable -> L5
        LocationObserver r1 = access$getLocationObserver(INSTANCE);     // Catch: Throwable -> L5
        r1.setCallback(null);     // Catch: Throwable -> L5
        r1.unregister(r4);     // Catch: Throwable -> L5
        return Unit.f330a;
    L5:
        th = move-exception;
        MLog.e("tryRun , failed, " + th);
        return null;
    }

    @Nullable
    public final Unit decodeLocation(@NotNull Context r3, double r4, double r6, @NotNull final Function2<? super Boolean, ? super LocationInfo, Unit> r8) {
        Intrinsics.f(r3, "context");
        Intrinsics.f(r8, "resultCallback");
        KtExt r0 = KtExt.INSTANCE;
        DecodeLocationRequest r5 = new DecodeLocationRequest.Builder().packageName(r3.getPackageName()).longitude(Double.valueOf(r4)).latitude(Double.valueOf(r6)).build();     // Catch: Throwable -> L5
        Request.Builder r7 = new Request.Builder();     // Catch: Throwable -> L5
        MATRIX_CMD r9 = MATRIX_CMD.CMD_DECODE_LOCATION;     // Catch: Throwable -> L5
        Request r10 = r7.cmd(Integer.valueOf(r9.getValue())).body(new RequestBody.Builder().decodeLocationRequest(r5).build()).build();     // Catch: Throwable -> L5
        MLog.d$default(TAG, "decodeLocation, request: " + r10, null, 4, null);     // Catch: Throwable -> L5
        CmdManager r2 = CmdManager.INSTANCE;     // Catch: Throwable -> L5
        int r11 = r9.getValue();     // Catch: Throwable -> L5
        Intrinsics.e(r10, "request");     // Catch: Throwable -> L5
        r2.sendCmd(r11, r10, new LocationApi$decodeLocation$1$1(r8));     // Catch: Throwable -> L5
        return Unit.f330a;
    L5:
        th = move-exception;
        MLog.e("tryRun , failed, " + th);
        return null;
    }

    @JvmStatic
    @JvmOverloads
    @Nullable
    public static final Unit refreshLocation(@NotNull Context r4, @NotNull LocationOption r5) {
        Intrinsics.f(r4, "context");
        Intrinsics.f(r5, "option");
        KtExt r1 = KtExt.INSTANCE;
        RefreshLocationRequest r6 = new RefreshLocationRequest.Builder().packageName(r4.getPackageName()).ignoreCache(Boolean.valueOf(r5.getIgnoreCache())).build();     // Catch: Throwable -> L5
        Request.Builder r7 = new Request.Builder();     // Catch: Throwable -> L5
        MATRIX_CMD r2 = MATRIX_CMD.CMD_REFRESH_LOCATION;     // Catch: Throwable -> L5
        Request r8 = r7.cmd(Integer.valueOf(r2.getValue())).body(new RequestBody.Builder().refreshLocationRequest(r6).build()).build();     // Catch: Throwable -> L5
        MLog.d$default(TAG, "refreshLocation, request: " + r8, null, 4, null);     // Catch: Throwable -> L5
        CmdManager r9 = CmdManager.INSTANCE;     // Catch: Throwable -> L5
        int r0 = r2.getValue();     // Catch: Throwable -> L5
        Intrinsics.e(r8, "request");     // Catch: Throwable -> L5
        r9.sendCmd(r0, r8, new LocationApi$refreshLocation$1$1());     // Catch: Throwable -> L5
        return Unit.f330a;
    L5:
        th = move-exception;
        MLog.e("tryRun , failed, " + th);
        return null;
    }
}
