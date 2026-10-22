package com.bytedance.apm.doctor;

import d.b.b.o.f;
import d.b.l.a.h.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DoctorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<ApmListener> f1492a;

    public interface ApmListener {
        void onDataEvent(int r1, String r2, JSONObject r3);

        void onEvent(String r1, String r2);
    }

    class a implements e {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f1493f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f1494g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f1495h;

        a(DoctorManager r1, List r2, String r3, String r4) {
            this.f1493f = r2;
            this.f1494g = r3;
            this.f1495h = r4;
        }

        @Override // d.b.l.a.h.e
        public d.b.l.a.h.b S() {
            return d.b.l.a.h.b.f14114h;
        }

        @Override // d.b.l.a.h.e
        public String X() {
            return "doctor";
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r0 = this.f1493f.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((ApmListener) r0.next()).onEvent(this.f1494g, this.f1495h);
            goto L4
        }
    }

    class b implements e {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSONObject f1496f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f1497g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f1498h;

        b(DoctorManager r1, JSONObject r2, String r3, List r4) {
            this.f1496f = r2;
            this.f1497g = r3;
            this.f1498h = r4;
        }

        @Override // d.b.l.a.h.e
        public d.b.l.a.h.b S() {
            return d.b.l.a.h.b.f14114h;
        }

        @Override // d.b.l.a.h.e
        public String X() {
            return "doctor";
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r0 = this.f1496f.getJSONObject("DATA_DOCTOR");     // Catch: Exception -> L8
            r0.put(this.f1497g, System.currentTimeMillis());     // Catch: Exception -> L8
            int r1 = r0.optInt("DATA_ID");     // Catch: Exception -> L8
            Iterator r2 = this.f1498h.iterator();     // Catch: Exception -> L8
        L4:
            if (r2.hasNext() == false) goto L13;
            ((ApmListener) r2.next()).onDataEvent(r1, this.f1497g, this.f1496f);     // Catch: Exception -> L8
        L13:
            return;
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final DoctorManager f1499a = null;

        static {
            f1499a = new DoctorManager(null);
        }

        static /* synthetic */ DoctorManager a() {
            return f1499a;
        }
    }

    private DoctorManager() {
        this.f1492a = new ArrayList();
    }

    /* synthetic */ DoctorManager(a r1) {
        this();
    }

    public static DoctorManager getInstance() {
        return c.a();
    }

    public void a(String r4, JSONObject r5) {
        if (f.b(this.f1492a) == true) goto L8;
        if (r5 == null) goto L9;
        ArrayList r0 = new ArrayList(this.f1492a);
        d.b.l.a.h.a.n().c(new b(this, r5, r4, r0));
        return;
    L9:
        return;
    }

    public void b(String r4, String r5) {
        if (f.b(this.f1492a) == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList(this.f1492a);
        d.b.l.a.h.a.n().c(new a(this, r0, r4, r5));
    }

    public void registerApmListener(ApmListener r1) {
        if (r1 == null) goto L5;
        this.f1492a.add(r1);
        return;
    }
}
