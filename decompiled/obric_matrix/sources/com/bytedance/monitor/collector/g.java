package com.bytedance.monitor.collector;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.ttuploader.TTVideoUploader;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends com.bytedance.monitor.collector.b {
    private static volatile com.bytedance.monitor.collector.f A;
    private static int[] B;
    private static int[] C;
    private static int D;
    public static boolean E;
    public static boolean F;
    public static boolean G;
    private static int y;
    private static int z;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    InterfaceC0165g f5115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f5116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile int f5117h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f5118i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f5119j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private j f5120k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private f f5121l;
    private long m;
    private long n;
    private int o;
    private long p;
    private String q;
    private String r;
    private com.bytedance.monitor.collector.a s;
    private volatile boolean t;
    private boolean u;
    private final com.bytedance.apm.f0.e v;
    private volatile boolean w;
    private Runnable x;

    class a implements InterfaceC0165g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f5122a;

        a(g r1) {
            this.f5122a = r1;
        }

        @Override // com.bytedance.monitor.collector.g.InterfaceC0165g
        public void a(long[] r5) {
            if (g.g(this.f5122a) == true) goto L6;
            return;
        L6:
            if (g.h(this.f5122a) != null) goto L8;
            return;
        L8:
            i r4 = g.h(this.f5122a).c();
            if (r4 != null) goto L11;
            return;
        L11:
            if (r4.f5153d != 8) goto L19;
            h r0 = new h();
            if (r5 == null) goto L16;
            r0.f5145a = r5[1];
            r0.f5146b = r5[5];
            r0.f5147c = r5[6];
            r0.f5148d = r5[7];
            r0.f5149e = r5[8];
        L16:
            r4.o = r0;
            return;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f5123f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f5124g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f5125h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f5126i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f5127j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ g f5128k;

        b(g r3) {
            this.f5128k = r3;
            this.f5123f = 0;
            this.f5125h = -1;
            this.f5126i = 0;
            this.f5127j = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            long r0 = SystemClock.uptimeMillis();
            e r2 = g.p(this.f5128k).c();
            if (this.f5125h != g.q(this.f5128k)) goto L5;
            this.f5126i++;
        L6:
            this.f5125h = g.q(this.f5128k);
            int r3 = this.f5126i;
            if (r3 > 0) goto L9;
        L21:
            r2.f5138d = g.t(this.f5128k);
            r2.f5137c = (r0 - this.f5123f) - ((long) g.x());
            r2.f5135a = r0;
            long r4 = SystemClock.uptimeMillis();
            this.f5123f = r4;
            r2.f5136b = r4 - r0;
            r2.f5139e = g.q(this.f5128k);
            g.j(this.f5128k).g(g.i(this.f5128k), g.x());
            g.p(this.f5128k).a(r2);
            return;
        L9:
            if ((r3 - this.f5127j) < g.r()) goto L21;
            if (this.f5123f == 0) goto L21;
            if ((r0 - this.f5124g) < g.s()) goto L21;
            if (g.t(this.f5128k) == false) goto L21;
            if (g.v() == null) goto L19;
            String r5 = g.w(this.f5128k).a(Looper.getMainLooper().getThread());
        L20:
            r2.f5140f = r5;
            this.f5127j = this.f5126i;
            goto L21
        L19:
            r5 = o.c(Looper.getMainLooper().getThread().getStackTrace());
            goto L20
        L5:
            this.f5126i = 0;
            this.f5127j = 0;
            this.f5124g = r0;
            goto L6
        }
    }

    class c extends com.bytedance.monitor.collector.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f5129d;

        c(g r1) {
            this.f5129d = r1;
        }

        @Override // com.bytedance.monitor.collector.a
        public void b(String r3, Message r4) {
            super.b(r3, r4);
            g.n(this.f5129d);
            g.m(this.f5129d, false, com.bytedance.monitor.collector.a.f5105b);
            g r5 = this.f5129d;
            g.o(r5, g.k(r5));
            g.l(this.f5129d, "no message running");
            g.u(this.f5129d, false);
        }

        @Override // com.bytedance.monitor.collector.a
        public void c(String r5) {
            g.u(this.f5129d, true);
            g.l(this.f5129d, r5);
            super.c(r5);
            g.m(this.f5129d, true, com.bytedance.monitor.collector.a.f5105b);
        }

        @Override // com.bytedance.monitor.collector.a
        public boolean d() {
            return true;
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f5130f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f5131g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f5132h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f5133i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ g f5134j;

        d(g r1, boolean r2, long r3, long r5, String r7) {
            this.f5134j = r1;
            this.f5130f = r2;
            this.f5131g = r3;
            this.f5132h = r5;
            this.f5133i = r7;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.monitor.collector.d.a r0 = k.n().p();
            if (r0 != null) goto L6;
            return;
        L6:
            if (this.f5130f == false) goto L8;
            String r1 = this.f5134j.f5108a;
            StringBuilder r3 = new StringBuilder();
            r3.append(this.f5131g);
            r3.append(",");
            r3.append(this.f5132h);
            r3.append(",B|");
            String r6 = o.b(this.f5133i);
        L9:
            r3.append(r6);
            r0.b(r1, r3.toString());
            return;
        L8:
            r1 = this.f5134j.f5108a;
            r3 = new StringBuilder();
            r3.append(this.f5131g);
            r3.append(",");
            r3.append(this.f5132h);
            r6 = ",E";
            goto L9
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f5135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f5136b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f5137c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f5138d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f5139e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f5140f;

        private e() {
        }

        /* synthetic */ e(a r1) {
            this();
        }

        void a() {
            this.f5135a = -1;
            this.f5136b = -1;
            this.f5137c = -1;
            this.f5139e = -1;
            this.f5140f = null;
        }

        public JSONObject b() {
            JSONObject r0 = new JSONObject();
            r0.put("startTime", this.f5135a);     // Catch: JSONException -> L5
            r0.put("cost", this.f5136b);     // Catch: JSONException -> L5
            r0.put("delay", this.f5137c);     // Catch: JSONException -> L5
            r0.put("isMessage", String.valueOf(this.f5138d));     // Catch: JSONException -> L5
            r0.put("seqNum", this.f5139e);     // Catch: JSONException -> L5
            r0.put("stack", this.f5140f);     // Catch: JSONException -> L5
        L7:
            return r0;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f5141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e f5143c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final List<e> f5144d;

        public f(int r2) {
            this.f5142b = 0;
            this.f5141a = r2;
            this.f5144d = new ArrayList(r2);
        }

        void a(e r3) {
            int r0 = this.f5144d.size();
            int r1 = this.f5141a;
            if (r0 >= r1) goto L5;
            this.f5144d.add(r3);
            int r4 = this.f5144d.size();
        L6:
            this.f5142b = r4;
            return;
        L5:
            int r2 = this.f5142b % r1;
            this.f5142b = r2;
            e r5 = this.f5144d.set(r2, r3);
            r5.a();
            this.f5143c = r5;
            r4 = this.f5142b + 1;
            goto L6
        }

        JSONArray b() {
            JSONArray r0 = new JSONArray();
            int r3 = 0;
            if (this.f5144d.size() != this.f5141a) goto L12;
            int r1 = this.f5142b - 1;
        L6:
            if (r1 >= this.f5144d.size()) goto L9;
            r0.put(this.f5144d.get(r1).b());
            r1 = r1 + 1;
        L9:
            if (r3 >= (this.f5142b - 1)) goto L14;
            r0.put(this.f5144d.get(r3).b());
            r3 = r3 + 1;
        L14:
            return r0;
        L12:
            if (r3 >= this.f5144d.size()) goto L14;
            r0.put(this.f5144d.get(r3).b());
            r3 = r3 + 1;
            goto L12
        }

        e c() {
            e r0 = this.f5143c;
            a r1 = null;
            if (r0 == null) goto L6;
            this.f5143c = null;
            return r0;
        L6:
            return new e(r1);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.monitor.collector.g$g, reason: collision with other inner class name */
    public interface InterfaceC0165g {
        void a(long[] r1);
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f5145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f5146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f5147c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f5148d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f5149e;

        public h() {
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f5150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f5151b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f5152c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f5153d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f5154e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f5155f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f5156g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        com.bytedance.monitor.collector.p.c f5157h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        String f5158i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f5159j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        StackTraceElement[] f5160k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        StackTraceElement[] f5161l;
        String m;
        String n;
        h o;

        public i() {
        }

        private void a(JSONObject r8) {
            StackTraceElement[] r0 = this.f5160k;
            if (r0 == null) goto L5;
            r8.put("block_stack", o.c(r0));
        L5:
            r8.put("block_uuid", this.n);
            StackTraceElement[] r1 = this.f5161l;
            if (r1 == null) goto L8;
            r8.put("sblock_stack", o.c(r1));
        L8:
            r8.put("sblock_uuid", this.n);
            if (TextUtils.isEmpty(this.m) == false) goto L12;
            r8.put("evil_msg", this.m);
        L12:
            if (this.o == null) goto L14;
            boolean r2 = true;
        L15:
            r8.put("belong_frame", r2);
            h r3 = this.o;
            if (r3 == null) goto L18;
            r8.put("vsyncDelayTime", this.f5152c - (r3.f5145a / TimeUtils.NANOSECONDS_PER_MILLISECOND));
            r8.put("doFrameTime", (this.o.f5146b / TimeUtils.NANOSECONDS_PER_MILLISECOND) - this.f5152c);
            h r4 = this.o;
            r8.put("inputHandlingTime", (r4.f5147c / TimeUtils.NANOSECONDS_PER_MILLISECOND) - (r4.f5146b / TimeUtils.NANOSECONDS_PER_MILLISECOND));
            h r5 = this.o;
            r8.put("animationsTime", (r5.f5148d / TimeUtils.NANOSECONDS_PER_MILLISECOND) - (r5.f5147c / TimeUtils.NANOSECONDS_PER_MILLISECOND));
            h r6 = this.o;
            r8.put("performTraversalsTime", (r6.f5149e / TimeUtils.NANOSECONDS_PER_MILLISECOND) - (r6.f5148d / TimeUtils.NANOSECONDS_PER_MILLISECOND));
            r8.put("drawTime", this.f5151b - (this.o.f5149e / TimeUtils.NANOSECONDS_PER_MILLISECOND));
        L18:
            com.bytedance.monitor.collector.p.c r7 = this.f5157h;
            if (r7 == null) goto L22;
            r8.put("service_name", r7.f5232a);
            r8.put("service_what", this.f5157h.f5233b);
            r8.put("service_time", this.f5157h.f5234c);
            r8.put("service_thread", this.f5157h.f5236e);
            r8.put("service_token", this.f5157h.f5235d);
            return;
        L22:
            return;
        L14:
            r2 = false;
            goto L15
        }

        boolean b() {
            if ((this.f5151b - this.f5152c) <= 17) goto L5;
            return true;
        L5:
            if (this.f5155f > 400) goto L22;
            int r0 = this.f5154e;
            if (r0 <= 300) goto L10;
            return true;
        L10:
            if (r0 >= 20) goto L13;
            return true;
        L13:
            if (this.f5153d != 1) goto L16;
            return true;
        L16:
            if (this.f5156g < 20) goto L24;
            return false;
        L24:
            return true;
        L22:
            return true;
        }

        void c() {
            this.f5153d = -1;
            this.f5154e = -1;
            this.f5155f = -1;
            this.f5158i = null;
            this.f5160k = null;
            this.f5161l = null;
            this.m = null;
            this.n = null;
            this.o = null;
            this.f5157h = null;
        }

        public JSONObject d() {
            JSONObject r0 = new JSONObject();
            r0.put(NotificationCompat.CATEGORY_MESSAGE, o.b(this.f5158i));     // Catch: JSONException -> L5
            r0.put("cpuDuration", this.f5156g);     // Catch: JSONException -> L5
            r0.put(TypedValues.TransitionType.S_DURATION, this.f5155f);     // Catch: JSONException -> L5
            r0.put(WsConstants.KEY_CONNECTION_TYPE, this.f5153d);     // Catch: JSONException -> L5
            r0.put("messageCount", this.f5154e);     // Catch: JSONException -> L5
            r0.put("lastDuration", this.f5151b - this.f5152c);     // Catch: JSONException -> L5
            r0.put("start", this.f5150a);     // Catch: JSONException -> L5
            r0.put("end", this.f5151b);     // Catch: JSONException -> L5
            a(r0);     // Catch: JSONException -> L5
        L7:
            return r0;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        public String e() {
            return "msg:" + o.b(this.f5158i) + ",cpuDuration:" + this.f5156g + ",duration:" + this.f5155f + ",type:" + this.f5153d + ",messageCount:" + this.f5154e + ",lastDuration:" + (this.f5151b - this.f5152c) + ",start:" + this.f5150a + ",end:" + this.f5151b;
        }

        public void f(String r2, StackTraceElement[] r3, StackTraceElement[] r4, String r5) {
            if (TextUtils.isEmpty(r2) == true) goto L5;
            this.n = r2;
        L5:
            if (r3 == null) goto L7;
            this.f5160k = r3;
        L7:
            if (r4 == null) goto L10;
            this.f5161l = r4;
        L10:
            if (TextUtils.isEmpty(r5) == true) goto L13;
            this.m = r5;
            return;
        }
    }

    private static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f5163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        i f5164c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        List<i> f5165d;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f5166f;

            a(j r1, String r2) {
                this.f5166f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.apm.x.a.b("block_looper_info", this.f5166f);
            }
        }

        j(int r2) {
            this.f5165d = new ArrayList();
            this.f5162a = r2;
        }

        void a(i r3) {
            int r0 = this.f5165d.size();
            int r1 = this.f5162a;
            if (r0 >= r1) goto L5;
            this.f5165d.add(r3);
            int r2 = this.f5165d.size();
        L6:
            this.f5163b = r2;
            if (com.bytedance.apm.x.a.e() == true) goto L9;
            return;
        L9:
            if (r3.b() == false) goto L13;
            String r4 = r3.e();
            com.bytedance.apm.f0.b.f().i(new a(this, r4));
            return;
        L13:
            return;
        L5:
            int r5 = this.f5163b % r1;
            this.f5163b = r5;
            i r6 = this.f5165d.set(r5, r3);
            r6.c();
            this.f5164c = r6;
            r2 = this.f5163b + 1;
            goto L6
        }

        List<i> b() {
            ArrayList r0 = new ArrayList();
            int r3 = 0;
            if (this.f5165d.size() != this.f5162a) goto L12;
            int r1 = this.f5163b - 1;
        L6:
            if (r1 >= this.f5165d.size()) goto L9;
            r0.add(this.f5165d.get(r1));
            r1 = r1 + 1;
        L9:
            if (r3 >= (this.f5163b - 1)) goto L14;
            r0.add(this.f5165d.get(r3));
            r3 = r3 + 1;
        L14:
            return r0;
        L12:
            if (r3 >= this.f5165d.size()) goto L14;
            r0.add(this.f5165d.get(r3));
            r3 = r3 + 1;
            goto L12
        }

        i c() {
            int r0 = this.f5163b;
            if (r0 > 0) goto L7;
            return null;
        L7:
            return this.f5165d.get(r0 - 1);
        }

        i d(int r2) {
            i r0 = this.f5164c;
            if (r0 == null) goto L5;
            r0.f5153d = r2;
            this.f5164c = null;
            return r0;
        L5:
            i r1 = new i();
            r1.f5153d = r2;
            return r1;
        }
    }

    static {
        B = new int[]{600, TTVideoUploader.KeyIsGetTosKey};
        C = new int[]{200, 100};
        E = false;
        F = false;
        G = false;
    }

    public g(int r4, boolean r5) {
        super(r4, "block_looper_info");
        this.f5116g = 0;
        this.f5117h = 0;
        this.f5118i = 100;
        this.f5119j = 200;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.t = false;
        this.u = false;
        this.w = false;
        this.x = new b(this);
        com.bytedance.monitor.collector.p.d.c().e();
        this.f5115f = new a(this);
        if (r5 == false) goto L5;
    L8:
        com.bytedance.apm.f0.e r6 = new com.bytedance.apm.f0.e("looper_monitor__");
        this.v = r6;
        r6.k();
        y();
        this.f5121l = new f(TTVideoUploader.KeyIsGetTosKey);
        r6.g(this.x, y);
        return;
    L5:
        if (E == true) goto L8;
        this.v = null;
    }

    private JSONObject A(long r7) {
        JSONObject r0 = new JSONObject();
        r0.put("message", this.r);     // Catch: Throwable -> L5
        r0.put("currentMessageCost", r7 - this.n);     // Catch: Throwable -> L5
        r0.put("currentMessageCpu", l.h(this.o) - this.p);     // Catch: Throwable -> L5
        r0.put("messageCount", this.f5116g);     // Catch: Throwable -> L5
        r0.put("start", this.n);     // Catch: Throwable -> L5
        r0.put("end", r7);     // Catch: Throwable -> L5
    L4:
        return r0;
    }

    private JSONArray D(int r7, long r8) {
        MessageQueue r6 = com.bytedance.monitor.collector.i.a();
        JSONArray r0 = new JSONArray();
        if (r6 != null) goto L24;
        return r0;
    L24:
        monitor-enter(r6);     // Catch: Throwable -> L21
        Message r1 = com.bytedance.monitor.collector.i.b(r6);     // Catch: Throwable -> L18
        if (r1 != null) goto L10;
        monitor-exit(r6);     // Catch: Throwable -> L18
        return r0;
    L10:
        int r2 = 0;
        int r3 = 0;
    L11:
        if (r1 == null) goto L16;
        if (r2 >= r7) goto L16;
        r2 = r2 + 1;     // Catch: Throwable -> L18
        r3 = r3 + 1;     // Catch: Throwable -> L18
        JSONObject r4 = K(r1, r8);     // Catch: Throwable -> L18
        r4.put("id", r3);     // Catch: JSONException -> L22 Throwable -> L18
    L15:
        r0.put(r4);     // Catch: Throwable -> L18
        r1 = com.bytedance.monitor.collector.i.c(r1);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r6);     // Catch: Throwable -> L18
        return r0;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        return r0;
    }

    private com.bytedance.monitor.collector.f F() {
        return A;
    }

    private void G(boolean r14, long r15) {
        int r0 = this.f5117h + 1;
        this.f5117h = r0;
        this.f5117h = r0 & SupportMenu.USER_MASK;
        this.u = false;
        if (this.m >= 0) goto L6;
        this.m = r15;
    L6:
        if (this.n >= 0) goto L9;
        this.n = r15;
    L9:
        if (this.o >= 0) goto L11;
        this.o = Process.myTid();
        this.p = SystemClock.currentThreadTimeMillis();
    L11:
        com.bytedance.monitor.collector.p.c r10 = com.bytedance.monitor.collector.p.d.b();
        com.bytedance.monitor.collector.p.d.a();
        long r2 = r15 - this.m;
        int r1 = this.f5119j;
        if (r2 > r1) goto L14;
        if (r10 != null) goto L14;
    L29:
        this.n = r15;
        String r11 = this.r;
        if (this.f5111d == false) goto L33;
        k.n().n.f(new d(this, r14, r15, SystemClock.currentThreadTimeMillis(), r11));
        return;
    L33:
        return;
    L14:
        long r3 = this.n;
        if ((r15 - r3) > r1) goto L19;
        if (r10 != null) goto L19;
        H(9, r15, this.r);
    L19:
        int r4 = this.f5116g;
        if (r14 == false) goto L24;
        if (r4 != 0) goto L23;
        H(1, r15, "no message running");
        goto L29
    L23:
        H(9, r3, this.q);
        int r5 = 1;
        boolean r6 = false;
        com.bytedance.monitor.collector.p.c r7 = null;
        String r8 = "no message running";
        g r9 = this;
    L28:
        r9.I(r5, r15, r8, r6, r7);
        goto L29
    L24:
        if (r4 != 0) goto L26;
        r5 = 8;
        r8 = this.r;
        r6 = true;
        r9 = this;
    L27:
        r7 = r10;
        goto L28
    L26:
        r9 = this;
        r9.I(9, r3, this.q, false, null);
        r5 = 8;
        r8 = this.r;
        r6 = true;
        goto L27
    }

    private void H(int r8, long r9, String r11) {
        I(r8, r9, r11, true, null);
    }

    private void I(int r5, long r6, String r8, boolean r9, com.bytedance.monitor.collector.p.c r10) {
        this.u = true;
        i r7 = this.f5120k.d(r5);
        r7.f5155f = r6 - this.m;
        if (r9 == false) goto L5;
        long r0 = SystemClock.currentThreadTimeMillis();
        r7.f5156g = r0 - this.p;
        this.p = r0;
    L6:
        r7.f5154e = this.f5116g;
        r7.f5158i = r8;
        r7.f5159j = this.q;
        r7.f5150a = this.m;
        r7.f5151b = r6;
        r7.f5152c = this.n;
        if (r10 == null) goto L9;
        r7.f5157h = r10;
    L9:
        this.f5120k.a(r7);
        this.f5116g = 0;
        this.m = r6;
        return;
    L5:
        r7.f5156g = -1;
        goto L6
    }

    private static JSONObject K(Message r3, long r4) {
        JSONObject r0 = new JSONObject();
        if (r3 != null) goto L20;
        return r0;
    L20:
        r0.put("when", r3.getWhen() - r4);     // Catch: JSONException -> L17
        if (r3.getCallback() == null) goto L8;
        r0.put("callback", String.valueOf(r3.getCallback()));     // Catch: JSONException -> L17
    L8:
        r0.put("what", r3.what);     // Catch: JSONException -> L17
        if (r3.getTarget() == null) goto L11;
        r0.put(TypedValues.AttributesType.S_TARGET, String.valueOf(r3.getTarget()));     // Catch: JSONException -> L17
    L12:
        r0.put("arg1", r3.arg1);     // Catch: JSONException -> L17
        r0.put("arg2", r3.arg2);     // Catch: JSONException -> L17
        Object r5 = r3.obj;     // Catch: JSONException -> L17
        if (r5 == null) goto L15;
        r0.put("obj", String.valueOf(r5));     // Catch: JSONException -> L17
    L15:
        r0.put("start", r3.getWhen());     // Catch: JSONException -> L17
        r0.put("end", -1);     // Catch: JSONException -> L17
    L19:
        return r0;
    L11:
        r0.put("barrier", r3.arg1);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    private void L() {
        int r0 = this.f5110c;
        if (r0 != 0) goto L5;
    L12:
        this.f5118i = 100;
        this.f5119j = TTVideoUploader.KeyIsGetTosKey;
        return;
    L5:
        if (r0 == 1) goto L12;
        if (r0 != 2) goto L9;
    L11:
        this.f5118i = TTVideoUploader.KeyIsGetTosKey;
        this.f5119j = 200;
        return;
    L9:
        if (r0 == 3) goto L11;
    }

    static /* synthetic */ boolean g(g r0) {
        return r0.u;
    }

    static /* synthetic */ j h(g r0) {
        return r0.f5120k;
    }

    static /* synthetic */ Runnable i(g r0) {
        return r0.x;
    }

    static /* synthetic */ com.bytedance.apm.f0.e j(g r0) {
        return r0.v;
    }

    static /* synthetic */ String k(g r0) {
        return r0.r;
    }

    static /* synthetic */ String l(g r0, String r1) {
        r0.r = r1;
        return r1;
    }

    static /* synthetic */ void m(g r0, boolean r1, long r2) {
        r0.G(r1, r2);
    }

    static /* synthetic */ int n(g r2) {
        int r0 = r2.f5116g;
        r2.f5116g = r0 + 1;
        return r0;
    }

    static /* synthetic */ String o(g r0, String r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ f p(g r0) {
        return r0.f5121l;
    }

    static /* synthetic */ int q(g r0) {
        return r0.f5117h;
    }

    static /* synthetic */ int r() {
        return D;
    }

    static /* synthetic */ int s() {
        return z;
    }

    static /* synthetic */ boolean t(g r0) {
        return r0.w;
    }

    static /* synthetic */ boolean u(g r0, boolean r1) {
        r0.w = r1;
        return r1;
    }

    static /* synthetic */ com.bytedance.monitor.collector.f v() {
        return A;
    }

    static /* synthetic */ com.bytedance.monitor.collector.f w(g r0) {
        return r0.F();
    }

    static /* synthetic */ int x() {
        return y;
    }

    private void y() {
        boolean r3 = G;
        if (r3 == false) goto L5;
    L8:
        if (r3 == false) goto L10;
    L12:
        if (r3 == true) goto L14;
    L16:
        if (r3 == true) goto L18;
        return;
    L18:
        if (F == true) goto L22;
        int r4 = C[0];
        y = r4;
        int r0 = B[1];
    L7:
        z = r0;
        D = r0 / r4;
        return;
    L22:
        return;
    L14:
        if (F == false) goto L16;
        r4 = C[1];
        y = r4;
        r0 = B[1];
        goto L7
    L10:
        if (F == true) goto L12;
        r4 = C[0];
        y = r4;
        r0 = B[0];
        goto L7
    L5:
        if (F == false) goto L8;
        r4 = C[1];
        y = r4;
        r0 = B[0];
        goto L7
    }

    public JSONArray B() {
        JSONArray r0 = new JSONArray();
        List<i> r4 = this.f5120k.b();     // Catch: Throwable -> L15
        if (r4 != null) goto L6;
        return r0;
    L6:
        int r1 = 0;
        Iterator<i> r5 = r4.iterator();     // Catch: Throwable -> L15
    L8:
        if (r5.hasNext() == false) goto L14;
        i r2 = r5.next();     // Catch: Throwable -> L15
        if (r2 == null) goto L8;
        r1 = r1 + 1;     // Catch: Throwable -> L15
        r0.put(r2.d().put("id", r1));     // Catch: Throwable -> L15
    L14:
        return r0;
    }

    public JSONObject C() {
        long r0 = SystemClock.uptimeMillis();
        JSONObject r2 = new JSONObject();
        JSONArray r3 = B();
        JSONObject r4 = A(r0);
        JSONArray r1 = D(100, r0);
        r2.put("history_message", r3);     // Catch: JSONException -> L5
        r2.put("current_message", r4);     // Catch: JSONException -> L5
        r2.put("pending_messages", r1);     // Catch: JSONException -> L5
        r2.put("check_time_info", z());     // Catch: JSONException -> L5
    L4:
        return r2;
    }

    public i E() {
        j r0 = this.f5120k;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (this.u == true) goto L9;
        return null;
    L9:
        if (r0.c().f5153d == 8) goto L12;
        return null;
    L12:
        return this.f5120k.c();
    }

    public void J() {
        if (this.t == false) goto L5;
        return;
    L5:
        this.t = true;
        L();
        this.f5120k = new j(this.f5118i);
        c r0 = new c(this);
        this.s = r0;
        com.bytedance.monitor.collector.h.k(r0);
        com.bytedance.monitor.collector.i.b(com.bytedance.monitor.collector.i.a());
    }

    @Override // com.bytedance.monitor.collector.b
    Pair<String, ?> a() {
        return new Pair(this.f5108a, C());
    }

    @Override // com.bytedance.monitor.collector.b
    Pair<String, ?> b(long r1, long r3) {
        return new Pair(this.f5108a, C());
    L4:
        return null;
    }

    @Override // com.bytedance.monitor.collector.b
    void d() {
        super.d();
        J();
    }

    @Override // com.bytedance.monitor.collector.b
    protected void f(int r1) {
    }

    public JSONArray z() {
        f r0 = this.f5121l;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.b();
    }
}
