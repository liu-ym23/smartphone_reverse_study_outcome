package com.bytedance.apm6.hub.b;

import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements d.b.b.d.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile d.b.b.d.b.a f2156a;

    /* JADX INFO: renamed from: com.bytedance.apm6.hub.b.a$a, reason: collision with other inner class name */
    class C0067a implements com.bytedance.apm6.hub.b.i.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f2157a;

        C0067a(a r1) {
            this.f2157a = r1;
        }

        @Override // com.bytedance.apm6.hub.b.i.b
        public void a(JSONObject r1, boolean r2) {
            a.a(this.f2157a, r1, r2);
        }
    }

    public a() {
        com.bytedance.apm6.hub.b.i.a.g().h();
        com.bytedance.apm6.hub.b.i.a.g().k(new C0067a(this));
    }

    static /* synthetic */ void a(a r0, JSONObject r1, boolean r2) {
        r0.b(r1, r2);
    }

    private void b(JSONObject r7, boolean r8) {
        JSONObject r9 = r7.optJSONObject("custom_event_settings");
        if (r9 == null) goto L29;
        JSONObject r10 = r9.optJSONObject("allow_service_name");
        HashSet r0 = new HashSet();
        if (r10 == null) goto L10;
        Iterator<String> r11 = r10.keys();
    L8:
        if (r11.hasNext() == false) goto L10;
        r0.add(r11.next());
    L10:
        HashSet r12 = new HashSet();
        JSONObject r1 = r9.optJSONObject("allow_log_type");
        if (r1 == null) goto L18;
        Iterator<String> r2 = r1.keys();
    L14:
        if (r2.hasNext() == false) goto L18;
        String r3 = r2.next();
        if (r1.optInt(r3) != 1) goto L14;
        r12.add(r3);
    L18:
        this.f2156a = new d.b.b.d.b.a(r0, r12);
        if (d.b.b.o.a.c() == false) goto L21;
        d.b.b.o.m.b.a("APM-Config", "received customEventSettings=" + r9);
        d.b.b.o.m.b.a("APM-Config", "parsed CommonEventConfig=" + this.f2156a);
    L21:
        d.b.b.d.a.p(getConfig());
        return;
    }

    @Override // d.b.b.d.b.b
    public d.b.b.d.b.a getConfig() {
        return this.f2156a;
    }
}
