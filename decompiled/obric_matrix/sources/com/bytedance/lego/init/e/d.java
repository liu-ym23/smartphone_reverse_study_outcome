package com.bytedance.lego.init.e;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.ss.ttuploader.TTUploadResolver;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final enum d extends Enum<d> implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f4869f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f4870g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f4871h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f4872i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d f4873j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final d f4874k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d f4875l = null;
    public static final d m = null;
    public static final d n = null;
    private static final /* synthetic */ d[] o = null;

    static {
        d r0 = new d("SECOND_5", 0, 5000);
        f4869f = r0;
        d r1 = new d("SECOND_8", 1, 8000);
        f4870g = r1;
        d r3 = new d("SECOND_15", 2, 15000);
        f4871h = r3;
        d r5 = new d("SECOND_30", 3, LocationInfoConst.HALF_MINUTES);
        f4872i = r5;
        d r7 = new d("SECOND_60", 4, TTUploadResolver.HOST_MAX_CACHE_TIME);
        f4873j = r7;
        d r9 = new d("MINUTE_2", 5, LocationInfoConst.TWO_MINUTES);
        f4874k = r9;
        d r11 = new d("MINUTE_5", 6, 300000);
        f4875l = r11;
        d r13 = new d("MINUTE_10", 7, 600000);
        m = r13;
        d r12 = new d("MINUTE_15", 8, 900000);
        n = r12;
        o = new d[]{r0, r1, r3, r5, r7, r9, r11, r13, r12};
    }

    private d(String r1, int r2, int r3) {
        super(r1, r2);
    }

    public static d valueOf(String r1) {
        return (d) Enum.valueOf(d.class, r1);
    }

    public static d[] values() {
        return (d[]) o.clone();
    }
}
