package u4;

import android.os.SystemClock;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import java.util.ArrayList;
import java.util.Iterator;
import ko.r;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends b {
    public final /* synthetic */ int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f22251h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f22252i;

    public /* synthetic */ f(int r5) {
        this.f = r5;
    }

    @Override // u4.b
    public final void b(long r11, JSONObject r13) {
        switch(this.f) {
            case 0: goto L46;
            case 1: goto L25;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r13, "result");
        ArrayList r5 = new ArrayList();
        ArrayList r10 = new ArrayList();
        Iterator r12 = this.d.iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        Object r14 = r12.next();
        if (((a) r14).f22241b.o("res_load_perf.res_load_finish").longValue() >= r11) goto L6;
        r10.add(r14);
        goto L6
    L10:
        int r15 = r10.size();
        this.g = r15;
        if (r15 <= 0) goto L23;
        Iterator r16 = r10.iterator();
        int r17 = 0;
    L14:
        if (r16.hasNext() == false) goto L22;
        Object r18 = r16.next();
        int r19 = r17 + 1;
        if (r17 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        a r20 = (a) r18;
        if (r17 >= 3) goto L21;
        r5.add(b.a((JSONObject) r20.f22241b.f18728b, "sub_res_dur"));
    L21:
        this.f22251h += r20.f22240a;
        r17 = r19;
        goto L14
    L22:
        this.f22252i = this.f22251h / ((long) this.g);
    L23:
        JSONObject r110 = new JSONObject();
        qo.a.k("res_dur_avg", this.f22252i, r110);
        qo.a.e(this.g, "res_count", r110);
        qo.a.k("res_dur_sum", this.f22251h, r110);
        qo.a.j(new JSONArray(r5), "sub_res_dur_list", r110);
        qo.a.j(r110, "sub_res_dur", r13);
        return;
    L25:
        Intrinsics.checkNotNullParameter(r13, "result");
        ArrayList r21 = new ArrayList();
        ArrayList r22 = new ArrayList();
        Iterator r23 = this.d.iterator();
    L27:
        if (r23.hasNext() == false) goto L31;
        Object r24 = r23.next();
        if (((a) r24).f22241b.o("perf.jsb_func_call_end").longValue() >= r11) goto L27;
        r22.add(r24);
        goto L27
    L31:
        int r111 = r22.size();
        this.g = r111;
        if (r111 <= 0) goto L44;
        Iterator r112 = r22.iterator();
        int r113 = 0;
    L35:
        if (r112.hasNext() == false) goto L43;
        Object r25 = r112.next();
        int r26 = r113 + 1;
        if (r113 >= 0) goto L39;
        CollectionsKt.throwIndexOverflow();
    L39:
        a r27 = (a) r25;
        if (r113 >= 3) goto L42;
        JSONObject r114 = new JSONObject();
        r114.put(ICronetClient.KEY_REQUEST_START, r27.f22241b.o("perf.jsb_func_call_start").longValue());
        r114.put("request_end", r27.f22241b.o("perf.jsb_callback_call_start").longValue());
        r21.add(r114);
    L42:
        this.f22251h += r27.f22240a;
        r113 = r26;
        goto L35
    L43:
        this.f22252i = this.f22251h / ((long) this.g);
    L44:
        JSONObject r115 = new JSONObject();
        qo.a.k("request_dur_avg", this.f22252i, r115);
        qo.a.e(this.g, "request_count", r115);
        qo.a.k("request_dur_sum", this.f22251h, r115);
        qo.a.j(new JSONArray(r21), "request_dur_list", r115);
        qo.a.j(r115, "request_dur", r13);
        return;
    L46:
        Intrinsics.checkNotNullParameter(r13, "result");
        ArrayList r28 = new ArrayList();
        ArrayList r29 = new ArrayList();
        Iterator r30 = this.d.iterator();
    L48:
        if (r30.hasNext() == false) goto L52;
        Object r31 = r30.next();
        if (((System.currentTimeMillis() - SystemClock.elapsedRealtime()) + ((a) r31).f22241b.o("callback_ts").longValue()) >= r11) goto L48;
        r29.add(r31);
        goto L48
    L52:
        int r116 = r29.size();
        this.g = r116;
        if (r116 <= 0) goto L65;
        Iterator r117 = r29.iterator();
        int r118 = 0;
    L56:
        if (r117.hasNext() == false) goto L64;
        Object r32 = r117.next();
        int r33 = r118 + 1;
        if (r118 >= 0) goto L60;
        CollectionsKt.throwIndexOverflow();
    L60:
        a r34 = (a) r32;
        if (r118 >= 3) goto L63;
        JSONObject r119 = new JSONObject();
        r119.put("request_url", r34.f22241b.p("request_url"));
        long r35 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        r r36 = r34.f22241b;
        r119.put(ICronetClient.KEY_REQUEST_START, r36.o("invoke_ts").longValue() + r35);
        r119.put("request_end", r36.o("callback_ts").longValue() + (System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        r28.add(r119);
    L63:
        this.f22251h += r34.f22240a;
        r118 = r33;
        goto L56
    L64:
        this.f22252i = this.f22251h / ((long) this.g);
    L65:
        JSONObject r120 = new JSONObject();
        qo.a.k("request_dur_avg", this.f22252i, r120);
        qo.a.e(this.g, "request_count", r120);
        qo.a.k("request_dur_sum", this.f22251h, r120);
        qo.a.j(new JSONArray(r28), "request_dur_list", r120);
        qo.a.j(r120, "request_dur", r13);
    }

    @Override // u4.b
    public final boolean d(r r5) {
        switch(this.f) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "accessor");
        String r10 = r5.p("res_info.res_type");
        return this.f22242a.contains(r10);
    L6:
        Intrinsics.checkNotNullParameter(r5, "accessor");
        String r11 = r5.p("info.jsb_name");
        return this.f22243b.contains(r11);
    L8:
        Intrinsics.checkNotNullParameter(r5, "accessor");
        String r12 = r5.p("bridge_name");
        return this.f22243b.contains(r12);
    }

    @Override // u4.b
    public final void e(r r10) {
        switch(this.f) {
            case 0: goto L20;
            case 1: goto L16;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r10, "accessor");
        Long r5 = 0L;
        Intrinsics.checkNotNullParameter("res_load_perf.res_load_finish", "pathX");
        Intrinsics.checkNotNullParameter("res_load_perf.res_load_start", "pathY");
        Object r11 = r10.f("res_load_perf.res_load_finish");
        Object r12 = r10.f("res_load_perf.res_load_start");
        if (r11 == null) goto L12;
        if (r12 == null) goto L12;
        if ((r11 instanceof Number) == false) goto L12;
        if ((r12 instanceof Number) == false) goto L12;
        r5 = Long.valueOf(((Number) r11).longValue() - ((Number) r12).longValue());
    L12:
        long r13 = r5.longValue();
        if (r13 <= 0) goto L24;
        c(new a(r13, r10));
        return;
    L24:
        return;
    L16:
        Intrinsics.checkNotNullParameter(r10, "accessor");
        long r14 = r10.o("perf.jsb_call").longValue();
        if (r14 <= 0) goto L25;
        c(new a(r14, r10));
        return;
    L25:
        return;
    L20:
        Intrinsics.checkNotNullParameter(r10, "accessor");
        long r15 = r10.o("cost_time").longValue();
        if (r15 <= 0) goto L26;
        c(new a(r15, r10));
        return;
    }
}
