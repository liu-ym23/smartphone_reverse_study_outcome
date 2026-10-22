package com.bytedance.apm6.hub.b;

import com.bytedance.apm.util.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements d.b.b.g.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.b.b.g.d.a f2161a;

    class a implements com.bytedance.apm6.hub.b.i.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f2162a;

        a(c r1) {
            this.f2162a = r1;
        }

        @Override // com.bytedance.apm6.hub.b.i.b
        public void a(JSONObject r1, boolean r2) {
            c.a(this.f2162a, r1, r2);
        }
    }

    public c() {
        com.bytedance.apm6.hub.b.i.a.g().h();
        com.bytedance.apm6.hub.b.i.a.g().k(new a(this));
    }

    static /* synthetic */ void a(c r0, JSONObject r1, boolean r2) {
        r0.b(r1, r2);
    }

    private void b(JSONObject r7, boolean r8) {
        JSONObject r9 = r7.optJSONObject("performance_modules");
        if (r9 != null) goto L5;
        return;
    L5:
        JSONObject r10 = r9.optJSONObject("disk");
        if (r10 != null) goto L9;
        return;
    L9:
        if (d.b.b.o.a.c() == false) goto L11;
        d.b.b.o.m.b.a("APM-Disk", "parseConfig:" + r10);
    L11:
        d.b.b.g.d.a r11 = new d.b.b.g.d.a();
        boolean r3 = false;
        if (r10.optInt("enable_upload", 0) != 1) goto L14;
        r3 = true;
    L14:
        r11.w(r3);
        if (r10.optInt("dump_threshold") <= 0) goto L18;
        r11.n((((long) r10.optInt("dump_threshold")) * 1024) * 1024);
    L18:
        if (r10.optInt("abnormal_folder_size") <= 0) goto L20;
        r11.p((((long) r10.optInt("abnormal_folder_size")) * 1024) * 1024);
    L20:
        r11.o(((long) r10.optInt("abnormal_file_size", 100)) * 1024);
        if (r10.optInt("dump_top_count") <= 0) goto L23;
        r11.t(r10.optInt("dump_top_count"));
    L23:
        r11.u(r10.optInt("dump_outdated_count", 50));
        r11.v(r10.optInt("dump_top_file_count", 20));
        r11.s(r10.optInt("dump_exception_dir_count", 50));
        if (r10.optInt("outdated_days") <= 0) goto L26;
        r11.r(((long) r10.optInt("outdated_days")) * 86400000);
    L26:
        r11.m(o.e(r10, "disk_customed_paths"));
        r11.q(o.d(r10, "ignored_relative_paths"));
        r11.l(o.d(r10, "compliance_relative_paths"));
        this.f2161a = r11;
        if (d.b.b.o.a.c() == false) goto L29;
        d.b.b.o.m.b.a("APM-Disk", "parseConfig:" + r10);
    L29:
        d.b.b.g.a.d().g(getConfig());
    }

    @Override // d.b.b.g.d.b
    public d.b.b.g.d.a getConfig() {
        return this.f2161a;
    }
}
