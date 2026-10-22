package com.bytedance.bdlocation.amap;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.amap.api.location.a;
import com.amap.api.location.b;
import com.amap.api.location.d;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.trace.TraceCons;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class AMapLocationImpl extends BaseLocate {
    public static final String GEOCODE_TYPE = "AMap";
    public static final String LOCATION_NAME = "AMap";
    private a mClient;
    private Context mContext;
    private Handler mHandler;
    private AMapListener mListener;
    private a mSingleClient;
    private String sdkVersion;

    private class AMapListener implements b {
        private BDLocationCallback mCallback;
        private long mLocationStartTime;
        private Looper mLooper;
        private LocationOption mOption;
        final /* synthetic */ AMapLocationImpl this$0;

        public AMapListener(AMapLocationImpl r1, BDLocationCallback r2, LocationOption r3, Looper r4) {
            this.this$0 = r1;
            this.mCallback = r2;
            this.mOption = r3;
            this.mLooper = r4;
            this.mLocationStartTime = SystemClock.elapsedRealtime();
        }

        static /* synthetic */ LocationOption access$100(AMapListener r0) {
            return r0.mOption;
        }

        static /* synthetic */ BDLocationCallback access$300(AMapListener r0) {
            return r0.mCallback;
        }

        static /* synthetic */ long access$400(AMapListener r2) {
            return r2.mLocationStartTime;
        }

        @Override // com.amap.api.location.b
        public void onLocationChanged(final AMapLocation r4) {
            if (r4 != null) goto L5;
            return;
        L5:
            if (AMapLocationImpl.access$000(this.this$0) != null) goto L7;
            AMapLocationImpl.access$002(this.this$0, new Handler(this.mLooper));
        L7:
            AMapLocationImpl.access$000(this.this$0).post(new AnonymousClass1(this, r4));
        }
    }

    @Keep
    public AMapLocationImpl(Context r3) {
        super(r3);
        this.sdkVersion = "";
        this.mContext = r3;
        a.j(r3, BDLocationConfig.isPrivacyConfirmed(), BDLocationConfig.isPrivacyConfirmed());
        a.i(r3, BDLocationConfig.isPrivacyConfirmed());
        a r0 = new a(r3.getApplicationContext());     // Catch: Exception -> L5
        this.mSingleClient = r0;     // Catch: Exception -> L5
        this.sdkVersion = r0.c();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    static /* synthetic */ Handler access$000(AMapLocationImpl r0) {
        return r0.mHandler;
    }

    static /* synthetic */ Handler access$002(AMapLocationImpl r0, Handler r1) {
        r0.mHandler = r1;
        return r1;
    }

    static /* synthetic */ BDLocation access$200(AMapLocationImpl r0, AMapLocation r1, LocationOption r2) {
        return r0.transform(r1, r2);
    }

    static /* synthetic */ String access$500(AMapLocationImpl r0) {
        return r0.sdkVersion;
    }

    static /* synthetic */ BDLocationException access$600(AMapLocationImpl r0, int r1, String r2) {
        return r0.mapBDException(r1, r2);
    }

    static /* synthetic */ void access$700(AMapLocationImpl r0, BDLocationCallback r1, BDLocationException r2) {
        r0.onError(r1, r2);
    }

    @NonNull
    private BDLocationException mapBDException(@NonNull int r4, @NonNull String r5) {
        if (r4 != 12) goto L10;
        if (r5.contains("1206") == false) goto L14;
        BDLocationException r6 = new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", "AMap", BDLocationException.ERROR_DEVICE_LOCATION_DISABLE);
    L7:
        r6.addExtra(TraceCons.EXTRA_FAIL_AMAP_CODE, String.valueOf(r4));
        return r6;
    L14:
        BDLocationException r1 = new BDLocationException(r5, "AMap", BDLocationException.ERROR_AMAP_FAIL);
        r1.addExtra(TraceCons.EXTRA_FAIL_AMAP_CODE, String.valueOf(r4));
        return r1;
    L10:
        if (r4 != 4) goto L14;
        if (r5.contains("0401") == false) goto L14;
        r6 = new BDLocationException("网络异常，未连接到网络，请连接网络", "AMap", BDLocationException.ERROR_ABNORMAL_NETWORK);
        goto L7
    }

    private void onError(BDLocationCallback r1, BDLocationException r2) {
        if (r1 == null) goto L4;
        r1.onError(r2);
    L4:
        onLocateError("AMap", r2);
    }

    private synchronized void startContinuousLocation(BDLocationCallback r5, LocationOption r6, Looper r7, AMapLocationClientOption r8) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            monitor-enter(r4)
            android.content.Context r0 = r4.mContext     // Catch: java.lang.Throwable -> L56
            if (r0 != 0) goto L13
            com.bytedance.bdlocation.exception.BDLocationException r0 = new com.bytedance.bdlocation.exception.BDLocationException     // Catch: java.lang.Throwable -> L56
            java.lang.String r1 = "mContext is null"
            java.lang.String r2 = "AMap"
            java.lang.String r3 = "76"
            r0.<init>(r1, r2, r3)     // Catch: java.lang.Throwable -> L56
            r5.onError(r0)     // Catch: java.lang.Throwable -> L56
        L13:
            com.amap.api.location.a r0 = r4.mClient     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            if (r0 != 0) goto L24
            com.amap.api.location.a r0 = new com.amap.api.location.a     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            android.content.Context r1 = r4.mContext     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            android.content.Context r1 = r1.getApplicationContext()     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            r0.<init>(r1)     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            r4.mClient = r0     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
        L24:
            r4.stopLocation()     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            com.bytedance.bdlocation.amap.AMapLocationImpl$AMapListener r0 = new com.bytedance.bdlocation.amap.AMapLocationImpl$AMapListener     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            r0.<init>(r4, r5, r6, r7)     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            r4.mListener = r0     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            com.amap.api.location.a r6 = r4.mClient     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            r6.e(r8)     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            com.amap.api.location.a r6 = r4.mClient     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            r7 = 1
            r6.b(r7)     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            com.amap.api.location.a r6 = r4.mClient     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            com.bytedance.bdlocation.amap.AMapLocationImpl$AMapListener r7 = r4.mListener     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            r6.d(r7)     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            com.amap.api.location.a r6 = r4.mClient     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            r6.f()     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L56
            goto L54
        L46:
            com.bytedance.bdlocation.exception.BDLocationException r6 = new com.bytedance.bdlocation.exception.BDLocationException     // Catch: java.lang.Throwable -> L56
            java.lang.String r7 = "amap client is null"
            java.lang.String r8 = "AMap"
            java.lang.String r0 = "76"
            r6.<init>(r7, r8, r0)     // Catch: java.lang.Throwable -> L56
            r5.onError(r6)     // Catch: java.lang.Throwable -> L56
        L54:
            monitor-exit(r4)
            return
        L56:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdlocation.amap.AMapLocationImpl.startContinuousLocation(com.bytedance.bdlocation.callback.BDLocationCallback, com.bytedance.bdlocation.client.LocationOption, android.os.Looper, com.amap.api.location.AMapLocationClientOption):void");
    }

    private void startSingleLocation(BDLocationCallback r5, LocationOption r6, Looper r7, AMapLocationClientOption r8) {
    L8:
        e = move-exception;
        r5.onError(new BDLocationException(e.getMessage(), "AMap", BDLocationException.ERROR_AMAP_CLIENT));
        return;
    L4:
        if (this.mSingleClient != null) goto L6;
        r5.onError(new BDLocationException("amap client is null", "AMap", BDLocationException.ERROR_AMAP_CLIENT));     // Catch: Exception -> L8
    L6:
        AMapListener r2 = new AMapListener(this, r5, r6, r7);     // Catch: Exception -> L8
        this.mSingleClient.e(r8);     // Catch: Exception -> L8
        this.mSingleClient.b(true);     // Catch: Exception -> L8
        this.mSingleClient.d(r2);     // Catch: Exception -> L8
        this.mSingleClient.f();     // Catch: Exception -> L8
    }

    private int transAMapTypeToBDType(int r4) {
        if (r4 != 1) goto L6;
        return 1;
    L6:
        if (r4 != 2) goto L9;
        return 8;
    L9:
        if (r4 != 4) goto L11;
        return 5;
    L11:
        if (r4 != 5) goto L14;
        return 2;
    L14:
        if (r4 != 6) goto L18;
        return 3;
    L18:
        if (r4 != 8) goto L20;
        return 9;
    L20:
        if (r4 != 9) goto L24;
        return 10;
    L24:
        if (r4 != 11) goto L26;
        return 11;
    L26:
        return 0;
    }

    private BDLocation transform(AMapLocation r12, LocationOption r13) {
        BDLocation r0 = new BDLocation(r12, "AMap");
        String r2 = r12.Q();
        Logger.d("AMap", "The CoordType of AMapLocation is " + r2);
        if ("GCJ02".equals(r2) == false) goto L6;
        r0.setCoordinateSystem(LocationInfoConst.GCJ_O2);
    L6:
        if ("WGS84".equals(r2) == false) goto L8;
        r0.setCoordinateSystem(LocationInfoConst.WGS_84);
    L8:
        if (r13 != null) goto L10;
    L12:
        r0.setMock(r12.isMock());
        r0.setAddress(r12.L());
        r0.setCountry(r12.R());
        r0.setAdministrativeArea(r12.a0());
        r0.setCity(r12.O());
        r0.setDistrict(r12.T());
        r0.setCityCode(r12.P());
        r0.setStreet(r12.e0());
        r0.setStreetNum(r12.g0());
        r0.setFloor(r12.W());
        r0.setBuildingId(r12.N());
        r0.setLocationMs(System.currentTimeMillis());
        r0.setPoi(r12.Z());
        r0.setAoi(r12.M());
        r0.setBearing(r12.getBearing());
        r0.setSpeed(r12.getSpeed());
        r0.setTrustedLevel(r12.h0());
        r0.setLocationDetail(r12.X());
        r0.setSatellites(r12.d0());
        int r14 = r12.Y();
        Logger.i("AMapLocationImpl amapType:" + r14);
        r0.setLocationType(transAMapTypeToBDType(r14));
        boolean r11 = d.d(r12.getLatitude(), r12.getLongitude());
        Logger.d("AMap", "The result of the method isAMapDataAvailable is " + r11);
        if (r11 == false) goto L15;
        r0.setGCJ02(new BDPoint(r12.getLatitude(), r12.getLongitude(), r12.getProvider()));
        r0.setCoordinateSystem(LocationInfoConst.GCJ_O2);
    L15:
        return r0;
    L10:
        if (r13.getGeocodeMode() != 1) goto L12;
        r0.setGeocodeSDKName("AMap");
        goto L12
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    @Nullable
    public BDPoint convertGCJ02(@NonNull BDPoint r8) {
        DPoint r0 = new DPoint(r8.getLatitude(), r8.getLongitude());     // Catch: Exception -> L4
        d r1 = new d(this.mContext);     // Catch: Exception -> L4
        r1.c(d.b.f537l);     // Catch: Exception -> L4
        r1.b(r0);     // Catch: Exception -> L4
        DPoint r7 = r1.a();     // Catch: Exception -> L4
        return new BDPoint(r7.b(), r7.d(), r8.getProvider());
    L4:
        e = move-exception;
        Logger.e("", e);
        return null;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public String getLocateName() {
        return "AMap";
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public boolean isAMapDataAvailable(double r1, double r3) {
        return d.d(r1, r3);
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void startLocation(@NonNull BDLocationCallback r9, @NonNull LocationOption r10, @NonNull Looper r11) {
        if (LocationUtil.isLocationEnabled() == true) goto L7;
        r9.onError(new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", "AMap", BDLocationException.ERROR_DEVICE_LOCATION_DISABLE));
        return;
    L7:
        if (BDLocationConfig.isBackground() == false) goto L9;
        return;
    L9:
        AMapLocationClientOption r0 = new AMapLocationClientOption();
        AMapLocationClientOption.Z(AMapLocationClientOption.c.f494g);
        if (r10.getMode() != 0) goto L14;
        AMapLocationClientOption.b r2 = AMapLocationClientOption.b.f489f;
    L12:
        r0.Y(r2);
        boolean r3 = false;
        r0.a0(false);
        if (r10.getMaxCacheTime() == 0) goto L20;
        r3 = true;
    L20:
        r0.X(r3);
        if (r10.isOnceLocation() == false) goto L23;
        Logger.d("AMapLocationImpl startSingleLocation amap version:" + this.sdkVersion);
        r0.W(1000);
        r0.c0(true);
        r0.V(r10.getLocationTimeOutMs());
        startSingleLocation(r9, r10, r11, r0);
    L24:
        onLocateStart("AMap");
        return;
    L23:
        Logger.d("AMapLocationImpl startLocation");
        r0.W(r10.getInterval());
        startContinuousLocation(r9, r10, r11, r0);
        goto L24
    L14:
        if (r10.getMode() != 1) goto L16;
        r2 = AMapLocationClientOption.b.f490g;
        goto L12
    L16:
        r2 = AMapLocationClientOption.b.f491h;
        goto L12
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public synchronized void stopLocation() {
        monitor-enter(this);
        a r0 = this.mClient;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.g();     // Catch: Throwable -> L9
        this.mClient.h(this.mListener);     // Catch: Throwable -> L9
    L6:
        this.mListener = null;     // Catch: Throwable -> L9
        onLocateStop("AMap");     // Catch: Throwable -> L9
        Logger.d("AMapLocationImpl stopLocation");     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void stopSingleLocation(AMapListener r2) {
        if (this.mSingleClient == null) goto L6;
        Logger.d("AMapLocationImpl stopSingleLocation");
        this.mSingleClient.g();
        this.mSingleClient.h(r2);
        return;
    }
}
