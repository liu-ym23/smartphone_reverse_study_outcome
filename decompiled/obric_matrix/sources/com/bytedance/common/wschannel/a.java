package com.bytedance.common.wschannel;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f3337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f3338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f3339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Map<String, String> f3340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Map<String, String> f3341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    List<String> f3342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f3343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f3344h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f3345i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f3346j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f3347k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    List<Integer> f3348l;
    String m;
    i n;
    boolean o;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.a$a, reason: collision with other inner class name */
    public static class C0093a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f3349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map<String, String> f3350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Map<String, String> f3351c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        List<String> f3352d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f3353e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f3354f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f3355g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f3356h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f3357i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f3358j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f3359k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        List<Integer> f3360l;
        String m;
        i n;
        boolean o;

        C0093a(int r2) {
            this.f3350b = new HashMap();
            this.f3351c = new HashMap();
            this.f3352d = new ArrayList();
            this.f3360l = new ArrayList();
            this.n = i.f3529g;
            this.f3349a = r2;
        }

        public static C0093a b(int r1) {
            return new C0093a(r1);
        }

        public a a() {
            return new a(this.f3354f, this.f3353e, this.f3355g, this.f3356h, this.f3349a, this.f3357i, this.f3358j, this.f3352d, this.f3350b, this.f3359k, this.f3360l, this.m, this.n, this.o, this);
        }

        public C0093a c(Map<String, String> r2) {
            if (r2 == null) goto L4;
            this.f3350b.putAll(r2);
        L4:
            return this;
        }

        public C0093a d(Map<String, String> r2) {
            if (r2 == null) goto L4;
            this.f3351c.putAll(r2);
        L4:
            return this;
        }

        public C0093a e(int r1) {
            this.f3353e = r1;
            return this;
        }

        public C0093a f(String r1) {
            this.f3356h = r1;
            return this;
        }

        public C0093a g(int r1) {
            this.f3355g = r1;
            return this;
        }

        public C0093a h(String r1) {
            this.f3357i = r1;
            return this;
        }

        public C0093a i(int r1) {
            this.f3354f = r1;
            return this;
        }

        public C0093a j(String r1) {
            this.f3358j = r1;
            return this;
        }

        public C0093a k(List<String> r2) {
            if (r2 == null) goto L4;
            this.f3352d.addAll(r2);
        L4:
            return this;
        }
    }

    public a(int r5, int r6, int r7, String r8, int r9, String r10, String r11, List<String> r12, Map<String, String> r13, boolean r14, List<Integer> r15, String r16, i r17, boolean r18, C0093a r19) {
        this.f3340d = new HashMap();
        this.f3341e = new HashMap();
        this.f3342f = new ArrayList();
        this.f3348l = new ArrayList();
        this.f3337a = r9;
        this.f3338b = r10;
        this.f3339c = r11;
        this.f3346j = r7;
        if (r12 == null) goto L5;
        this.f3342f.addAll(r12);
    L5:
        if (r13 == null) goto L7;
        this.f3340d.putAll(r13);
    L7:
        Map<String, String> r1 = r19.f3351c;
        if (r1 == null) goto L11;
        this.f3341e.putAll(r1);
    L11:
        if (com.bytedance.common.wschannel.server.d.h() == false) goto L13;
        this.f3341e.put("x-support-qos2", LocationInfoConst.ALLOW_USE_LOCATION);
    L13:
        this.f3343g = r5;
        this.f3344h = r6;
        this.f3345i = r8;
        this.f3348l = r15;
        this.f3347k = r14;
        this.m = r16;
        this.n = r17;
        if (TextUtils.isEmpty(r16) == false) goto L16;
        this.f3347k = false;
    L16:
        this.o = r18;
    }

    public String toString() {
        return "ChannelInfo{channelId = " + this.f3337a + ", deviceId = " + this.f3338b + ", installId = " + this.f3339c + ", fpid = " + this.f3343g + ", aid = " + this.f3344h + ", updateVersionCode = " + this.f3346j + ", appKey = " + this.f3345i + ", header = " + this.f3341e + ", extra = " + this.f3340d + ", urls = " + this.f3342f + "}";
    }
}
