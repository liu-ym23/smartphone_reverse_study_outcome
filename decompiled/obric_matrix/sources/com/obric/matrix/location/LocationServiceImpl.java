package com.obric.matrix.location;

import android.content.Context;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.network.model.LocationResult;
import com.bytedance.bdlocation.network.model.Place;
import com.obric.matrix.common_api.INetworkApi;
import com.obric.matrix.location_api.ILocationService;
import com.obric.matrix.w.b0;
import com.obric.matrix.w.c0;
import com.obric.matrix.w.e0;
import com.obric.matrix.w.j;
import com.obric.matrix.w.l;
import com.obric.matrix.w.o;
import com.obric.matrix.w.z;
import d.b.r.d0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.f0;
import kotlin.i0.m0;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0018"}, d2 = {"Lcom/obric/matrix/location/LocationServiceImpl;", "Lcom/obric/matrix/location_api/ILocationService;", "()V", "decodeBdLocation", "Lcom/bytedance/bdlocation/BDLocation;", "request", "Lcom/obric/matrix/proto/Request;", "decodeLocation", "Lio/reactivex/Maybe;", "Lcom/obric/matrix/model/BaseResponseBody;", "getBDLocation", "getBdLocation", "callingPkg", "", "getIntersectFences", "getLocation", "Lcom/obric/matrix/proto/LocationInfo;", "init", "", "context", "Landroid/content/Context;", "refreshLocation", "retryStartLocation", "Companion", "location_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocationServiceImpl implements ILocationService {
    public static final a Companion = null;
    private static final String TAG = "LocationServiceImpl";

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/matrix/location/LocationServiceImpl$Companion;", "", "()V", "TAG", "", "toLocationInfo", "Lcom/obric/matrix/proto/LocationInfo;", "Lcom/bytedance/bdlocation/BDLocation;", "toLocationInfo$location_cnRelease", "location_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final o a(BDLocation r3) {
            if (r3 != null) goto L5;
            return null;
        L5:
            o.a r2 = new o.a();
            r2.l(Double.valueOf(r3.getLongitude()));
            r2.j(Double.valueOf(r3.getLatitude()));
            r2.f(r3.getCountry());
            r2.g(r3.getCountryCode());
            r2.b(r3.getAdministrativeArea());
            r2.n(r3.getSubAdministrativeArea());
            r2.d(r3.getCity());
            r2.h(r3.getDistrict());
            r2.p(r3.getTown());
            r2.m(r3.getStreet());
            LocationResult r0 = r3.getLocationResult();
            if (r0 == null) goto L11;
            Place r1 = r0.place;
            if (r1 == null) goto L11;
            String r4 = r1.locality;
            if (r4 == null) goto L11;
        L12:
            r2.k(r4);
            LocationResult r5 = r3.getLocationResult();
            if (r5 == null) goto L18;
            Place r6 = r5.place;
            if (r6 == null) goto L18;
            String r7 = r6.subLocality;
            if (r7 == null) goto L18;
        L19:
            r2.o(r7);
            r2.a(r3.getAddress());
            r2.e(r3.getCityCode());
            r2.i(r3.getDistrictLocalID());
            return r2.c();
        L18:
            r7 = r3.getDistrict();
        L11:
            r4 = r3.getCity();
            goto L12
        }
    }

    static {
        Companion = new a(null);
    }

    public LocationServiceImpl() {
    }

    public static /* synthetic */ void a(LocationServiceImpl r0, b0 r1, f.a.b r2) {
        m63getLocation$lambda0(r0, r1, r2);
    }

    public static /* synthetic */ void b(b0 r0, LocationServiceImpl r1, f.a.b r2) {
        m62getIntersectFences$lambda6(r0, r1, r2);
    }

    public static /* synthetic */ void c(LocationServiceImpl r0, b0 r1, f.a.b r2) {
        m64refreshLocation$lambda1(r0, r1, r2);
    }

    public static /* synthetic */ void d(LocationServiceImpl r0, b0 r1, f.a.b r2) {
        m61decodeLocation$lambda2(r0, r1, r2);
    }

    private final BDLocation decodeBdLocation(b0 r8) {
        c0 r7 = r8.o;
        if (r7 == null) goto L13;
        com.obric.matrix.w.d r9 = r7.o;
        if (r9 == null) goto L13;
        String r10 = r8.n;
        Double r0 = r9.f10259g;
        Double r11 = r9.f10260h;
        f r1 = f.o();
        kotlin.n0.d.o.e(r0, "longitude");
        double r2 = r0.doubleValue();
        kotlin.n0.d.o.e(r11, "latitude");
        BDLocation r12 = r1.n(r2, r11.doubleValue());
        if (r12 == null) goto L11;
        com.obric.matrix.r.c.c.b(TAG, "decodeBdLocation by [" + r10 + ']');
        return r12;
    L11:
        throw new com.obric.matrix.q.c.a(-100016, "decodeLocation result empty", null, 4, null);
    L13:
        throw new com.obric.matrix.s.e(r8);
    }

    /* JADX INFO: renamed from: decodeLocation$lambda-2, reason: not valid java name */
    private static final void m61decodeLocation$lambda2(LocationServiceImpl r4, b0 r5, f.a.b r6) {
        kotlin.n0.d.o.f(r4, "this$0");
        kotlin.n0.d.o.f(r5, "$request");
        kotlin.n0.d.o.f(r6, "it");
        BDLocation r7 = r4.decodeBdLocation(r5);     // Catch: Throwable -> L5
        com.obric.matrix.u.b.a r1 = new com.obric.matrix.u.b.a();     // Catch: Throwable -> L5
        r1.c(new com.obric.matrix.u.a("", 0, ""));     // Catch: Throwable -> L5
        e0.a r0 = new e0.a();     // Catch: Throwable -> L5
        com.obric.matrix.w.e.a r2 = new com.obric.matrix.w.e.a();     // Catch: Throwable -> L5
        r2.b(Companion.a(r7));     // Catch: Throwable -> L5
        r0.c(r2.a());     // Catch: Throwable -> L5
        e0 r8 = r0.b();     // Catch: Throwable -> L5
        kotlin.n0.d.o.e(r8, "Builder()\n              …                ).build()");     // Catch: Throwable -> L5
        r1.d(r8);     // Catch: Throwable -> L5
        com.obric.matrix.u.b r9 = r1.a();     // Catch: Throwable -> L5
        g.d(r5.n, null);     // Catch: Throwable -> L5
        r6.b(r9);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.obric.matrix.r.c.c.g(TAG, "decodeLocation error: ", th);
        g.d(r5.n, th);
        r6.onError(th);
    }

    private final BDLocation getBDLocation(b0 r2) {
        c0 r0 = r2.o;
        if (r0 == null) goto L9;
        if (r0.m == null) goto L9;
        String r3 = r2.n;
        kotlin.n0.d.o.e(r3, "callingPkg");
        return getBdLocation(r3);
    L9:
        throw new com.obric.matrix.s.e(r2);
    }

    private final BDLocation getBdLocation(String r8) {
        BDLocation r0 = f.o().p();     // Catch: BDLocationException -> L12
        g.f(r8, r0, null);
        if (r0 == null) goto L11;
        if (r0.isEmpty() == true) goto L11;
        com.obric.matrix.r.c.c.b(TAG, "getBDLocation by [" + r8 + "], locationMs: " + r0.getLocationMs());
        return r0;
    L11:
        throw new com.obric.matrix.q.c.a(-100016, "getLastKnownLocation result empty", null, 4, null);
    L12:
        e = move-exception;
        g.f(r8, null, e);
        throw new com.obric.matrix.q.c.a(-100015, "getLastKnownLocation failed", e);
    }

    /* JADX INFO: renamed from: getIntersectFences$lambda-6, reason: not valid java name */
    private static final void m62getIntersectFences$lambda6(b0 r13, LocationServiceImpl r14, f.a.b r15) {
        kotlin.n0.d.o.f(r13, "$request");
        kotlin.n0.d.o.f(r14, "this$0");
        kotlin.n0.d.o.f(r15, "subscriber");
        v.a r16 = v.f21457g;     // Catch: Throwable -> L19
        c0 r17 = r13.o;     // Catch: Throwable -> L19
        if (r17 == null) goto L6;
        com.obric.matrix.w.i r18 = r17.p;     // Catch: Throwable -> L19
    L7:
        if (r18 == null) goto L18;
        kotlin.n0.d.o.e(r18, "request.body?.getInterse…t null\"\n                )");     // Catch: Throwable -> L19
        String r19 = com.obric.matrix.r.e.e.d(r18);     // Catch: Throwable -> L19
        com.obric.matrix.r.c.c.b(TAG, "getIntersectFences params: " + r19);     // Catch: Throwable -> L19
        INetworkApi r5 = INetworkApi.Companion.a();     // Catch: Throwable -> L19
        Map<String, String> r7 = m0.e(a0.a(INetworkApi.CONTENT_TYPE, "application/json"));     // Catch: Throwable -> L19
        Map<String, String> r8 = m0.h();     // Catch: Throwable -> L19
        byte[] r110 = r19.toString().getBytes(kotlin.u0.d.f21429a);     // Catch: Throwable -> L19
        kotlin.n0.d.o.e(r110, "this as java.lang.String).getBytes(charset)");     // Catch: Throwable -> L19
        d0<String> r111 = r5.executePost("https://location.bytedance.com/location/gis/fence/v1/get_intersect_fences", r7, r8, true, new d.b.r.k0.g(INetworkApi.DEFAULT_CONTENT_TYPE, r110, new String[0])).execute();     // Catch: Throwable -> L19
        com.obric.matrix.r.c.c.b(TAG, "getIntersectFences ret: " + r111);     // Catch: Throwable -> L19
        if (r111.e() == false) goto L16;
        j r112 = (j) com.obric.matrix.r.e.e.a(r111.a(), j.class);     // Catch: Throwable -> L19
        if (r112 == null) goto L14;
        kotlin.n0.d.o.e(r112, "GsonUtils.from(ret.body(…rse error\")\n            }");     // Catch: Throwable -> L19
        com.obric.matrix.u.b.a r4 = new com.obric.matrix.u.b.a();     // Catch: Throwable -> L19
        r4.c(new com.obric.matrix.u.a("", 0, ""));     // Catch: Throwable -> L19
        e0.a r0 = new e0.a();     // Catch: Throwable -> L19
        r0.e(r112);     // Catch: Throwable -> L19
        e0 r113 = r0.b();     // Catch: Throwable -> L19
        kotlin.n0.d.o.e(r113, "Builder().getIntersectFe…                ).build()");     // Catch: Throwable -> L19
        r4.d(r113);     // Catch: Throwable -> L19
        r15.b(r4.a());     // Catch: Throwable -> L19
        g.e(r13.n, null);     // Catch: Throwable -> L19
        Object r114 = f0.f18324a;     // Catch: Throwable -> L19
        v.b(r114);     // Catch: Throwable -> L19
    L21:
        Throwable r115 = v.d(r114);
        if (r115 == null) goto L26;
        com.obric.matrix.r.c.c.g(TAG, "getIntersectFences error: ", r115);
        r15.onError(r115);
        g.e(r13.n, r115);
        return;
    L26:
        return;
    L14:
        throw new IllegalArgumentException("json parse error");     // Catch: Throwable -> L19
    L16:
        throw new com.obric.matrix.q.c.a(r111.b(), "getIntersectFences error: " + r111, null, 4, null);     // Catch: Throwable -> L19
    L18:
        throw new com.obric.matrix.s.d(r13, "getIntersectFencesRequest null");     // Catch: Throwable -> L19
    L6:
        r18 = null;
    L19:
        th = move-exception;
        v.a r1 = v.f21457g;
        r114 = w.a(th);
        v.b(r114);
        goto L21
    }

    /* JADX INFO: renamed from: getLocation$lambda-0, reason: not valid java name */
    private static final void m63getLocation$lambda0(LocationServiceImpl r3, b0 r4, f.a.b r5) {
        kotlin.n0.d.o.f(r3, "this$0");
        kotlin.n0.d.o.f(r4, "$request");
        kotlin.n0.d.o.f(r5, "it");
        BDLocation r6 = r3.getBDLocation(r4);     // Catch: Throwable -> L5
        com.obric.matrix.u.b.a r7 = new com.obric.matrix.u.b.a();     // Catch: Throwable -> L5
        r7.c(new com.obric.matrix.u.a("", 0, ""));     // Catch: Throwable -> L5
        e0.a r0 = new e0.a();     // Catch: Throwable -> L5
        l.a r1 = new l.a();     // Catch: Throwable -> L5
        r1.b(Companion.a(r6));     // Catch: Throwable -> L5
        r0.f(r1.a());     // Catch: Throwable -> L5
        e0 r8 = r0.b();     // Catch: Throwable -> L5
        kotlin.n0.d.o.e(r8, "Builder()\n              …                ).build()");     // Catch: Throwable -> L5
        r7.d(r8);     // Catch: Throwable -> L5
        r5.b(r7.a());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.obric.matrix.r.c.c.g(TAG, "getLocation error: ", th);
        r5.onError(th);
    }

    /* JADX INFO: renamed from: refreshLocation$lambda-1, reason: not valid java name */
    private static final void m64refreshLocation$lambda1(LocationServiceImpl r5, b0 r6, f.a.b r7) {
        kotlin.n0.d.o.f(r5, "this$0");
        kotlin.n0.d.o.f(r6, "$request");
        kotlin.n0.d.o.f(r7, "it");
        boolean r1 = false;
        Boolean r2 = null;
        r5.retryStartLocation(r6);     // Catch: Throwable -> L14
        com.obric.matrix.u.b.a r8 = new com.obric.matrix.u.b.a();     // Catch: Throwable -> L14
        r8.c(new com.obric.matrix.u.a("", 0, ""));     // Catch: Throwable -> L14
        e0.a r0 = new e0.a();     // Catch: Throwable -> L14
        r0.i(new com.obric.matrix.w.a0.a().a());     // Catch: Throwable -> L14
        e0 r3 = r0.b();     // Catch: Throwable -> L14
        kotlin.n0.d.o.e(r3, "Builder()\n              …                 .build()");     // Catch: Throwable -> L14
        r8.d(r3);     // Catch: Throwable -> L14
        com.obric.matrix.u.b r9 = r8.a();     // Catch: Throwable -> L14
        String r4 = r6.n;     // Catch: Throwable -> L14
        c0 r10 = r6.o;     // Catch: Throwable -> L14
        if (r10 == null) goto L8;
        z r11 = r10.n;     // Catch: Throwable -> L14
        if (r11 == null) goto L8;
        Boolean r12 = r11.f10599g;     // Catch: Throwable -> L14
    L9:
        if (r12 != null) goto L11;
        boolean r13 = false;
    L12:
        g.g(r4, r13, null);     // Catch: Throwable -> L14
        r7.b(r9);     // Catch: Throwable -> L14
        return;
    L11:
        r13 = r12.booleanValue();     // Catch: Throwable -> L14
    L8:
        r12 = null;
    L14:
        th = move-exception;
        com.obric.matrix.r.c.c.g(TAG, "refreshLocation error: ", th);
        String r14 = r6.n;
        c0 r15 = r6.o;
        if (r15 == null) goto L20;
        z r16 = r15.n;
        if (r16 == null) goto L20;
        r2 = r16.f10599g;
    L20:
        if (r2 == null) goto L23;
        r1 = r2.booleanValue();
    L23:
        g.g(r14, r1, th);
        r7.onError(th);
    }

    private final void retryStartLocation(b0 r6) {
        c0 r5 = r6.o;
        if (r5 == null) goto L9;
        z r7 = r5.n;
        if (r7 == null) goto L9;
        String r8 = r6.n;
        Boolean r9 = r7.f10599g;
        com.obric.matrix.r.c.c.b(TAG, "retryStartLocation by [" + r8 + "], ignoreCache: " + r9);
        f r0 = f.o();
        kotlin.n0.d.o.e(r9, "ignoreCache");
        r0.A(true, false, r9.booleanValue(), "call_refreshLocation_by_" + r8);
        return;
    L9:
        throw new com.obric.matrix.s.e(r6);
    }

    @Override // com.obric.matrix.location_api.ILocationService
    public f.a.a<com.obric.matrix.u.b> decodeLocation(final b0 r2) {
        kotlin.n0.d.o.f(r2, "request");
        f.a.a<com.obric.matrix.u.b> r1 = f.a.a.b(new d(this, r2));
        kotlin.n0.d.o.e(r1, "create {\n        try {\n …nError(t)\n        }\n    }");
        return r1;
    }

    @Override // com.obric.matrix.location_api.ILocationService
    public f.a.a<com.obric.matrix.u.b> getIntersectFences(final b0 r2) {
        kotlin.n0.d.o.f(r2, "request");
        f.a.a<com.obric.matrix.u.b> r1 = f.a.a.b(new b(r2, this));
        kotlin.n0.d.o.e(r1, "create { subscriber ->\n …ppPkg,it)\n        }\n    }");
        return r1;
    }

    @Override // com.obric.matrix.location_api.ILocationService
    public o getLocation() {
        return Companion.a(getBdLocation("com.obric.matrix"));
    L4:
        th = move-exception;
        com.obric.matrix.r.c.c.g(TAG, "getLocation error: ", th);
        return null;
    }

    @Override // com.obric.matrix.location_api.ILocationService
    public f.a.a<com.obric.matrix.u.b> getLocation(final b0 r2) {
        kotlin.n0.d.o.f(r2, "request");
        f.a.a<com.obric.matrix.u.b> r1 = f.a.a.b(new com.obric.matrix.location.a(this, r2));
        kotlin.n0.d.o.e(r1, "create {\n        try {\n …nError(t)\n        }\n    }");
        return r1;
    }

    @Override // com.obric.matrix.location_api.ILocationService
    public void init(Context r1) {
        kotlin.n0.d.o.f(r1, "context");
        f.o().s(com.obric.matrix.r.b.g(r1));
    }

    @Override // com.obric.matrix.location_api.ILocationService
    public f.a.a<com.obric.matrix.u.b> refreshLocation(final b0 r2) {
        kotlin.n0.d.o.f(r2, "request");
        f.a.a<com.obric.matrix.u.b> r1 = f.a.a.b(new c(this, r2));
        kotlin.n0.d.o.e(r1, "create {\n        try {\n …nError(t)\n        }\n    }");
        return r1;
    }
}
