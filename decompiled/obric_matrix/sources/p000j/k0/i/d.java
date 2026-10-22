package p000j.k0.i;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k.e;
import k.g;
import k.h;
import k.q;
import k.z;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final c[] f17942a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Map<h, Integer> f17943b = null;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<c> f17944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f17945b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f17946c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f17947d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        c[] f17948e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f17949f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f17950g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f17951h;

        a(int r2, int r3, z r4) {
            this.f17944a = new ArrayList();
            c[] r0 = new c[8];
            this.f17948e = r0;
            this.f17949f = r0.length - 1;
            this.f17950g = 0;
            this.f17951h = 0;
            this.f17946c = r2;
            this.f17947d = r3;
            this.f17945b = q.b(r4);
        }

        a(int r1, z r2) {
            this(r1, r1, r2);
        }

        private void a() {
            int r0 = this.f17947d;
            int r1 = this.f17951h;
            if (r0 >= r1) goto L8;
            if (r0 != 0) goto L6;
            b();
            return;
        L6:
            d(r1 - r0);
            return;
        }

        private void b() {
            Arrays.fill(this.f17948e, null);
            this.f17949f = this.f17948e.length - 1;
            this.f17950g = 0;
            this.f17951h = 0;
        }

        private int c(int r1) {
            return (this.f17949f + 1) + r1;
        }

        private int d(int r5) {
            int r0 = 0;
            if (r5 <= 0) goto L10;
            int r1 = this.f17948e.length;
        L5:
            r1 = r1 - 1;
            int r2 = this.f17949f;
            if (r1 < r2) goto L9;
            if (r5 <= 0) goto L9;
            c[] r3 = this.f17948e;
            r5 = r5 - r3[r1].f17941c;
            this.f17951h -= r3[r1].f17941c;
            this.f17950g--;
            r0 = r0 + 1;
        L9:
            c[] r6 = this.f17948e;
            System.arraycopy(r6, r2 + 1, r6, (r2 + 1) + r0, this.f17950g);
            this.f17949f += r0;
        L10:
            return r0;
        }

        private h f(int r3) {
            if (h(r3) == false) goto L7;
            c r2 = d.f17942a[r3];
        L6:
            return r2.f17939a;
        L7:
            int r0 = c(r3 - d.f17942a.length);
            if (r0 < 0) goto L13;
            c[] r4 = this.f17948e;
            if (r0 >= r4.length) goto L13;
            r2 = r4[r0];
        L13:
            throw new IOException("Header index too large " + (r3 + 1));
        }

        private void g(int r6, c r7) {
            this.f17944a.add(r7);
            int r0 = r7.f17941c;
            if (r6 == (-1)) goto L5;
            r0 = r0 - this.f17948e[c(r6)].f17941c;
        L5:
            int r2 = this.f17947d;
            if (r0 <= r2) goto L9;
            b();
            return;
        L9:
            int r3 = d((this.f17951h + r0) - r2);
            if (r6 != (-1)) goto L15;
            int r8 = this.f17950g + 1;
            c[] r1 = this.f17948e;
            if (r8 <= r1.length) goto L14;
            c[] r9 = new c[r1.length * 2];
            System.arraycopy(r1, 0, r9, r1.length, r1.length);
            this.f17949f = this.f17948e.length - 1;
            this.f17948e = r9;
        L14:
            int r10 = this.f17949f;
            this.f17949f = r10 - 1;
            this.f17948e[r10] = r7;
            this.f17950g++;
        L16:
            this.f17951h += r0;
            return;
        L15:
            this.f17948e[r6 + (c(r6) + r3)] = r7;
            goto L16
        }

        private boolean h(int r2) {
            if (r2 >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r2 > (d.f17942a.length - 1)) goto L7;
            return true;
        }

        private int i() {
            return this.f17945b.readByte() & 255;
        }

        private void l(int r4) {
            if (h(r4) == false) goto L6;
            c r5 = d.f17942a[r4];
            List<c> r3 = this.f17944a;
        L5:
            r3.add(r5);
            return;
        L6:
            int r0 = c(r4 - d.f17942a.length);
            if (r0 < 0) goto L13;
            c[] r1 = this.f17948e;
            if (r0 >= r1.length) goto L13;
            r3 = this.f17944a;
            r5 = r1[r0];
        L13:
            throw new IOException("Header index too large " + (r4 + 1));
        }

        private void n(int r3) {
            g(-1, new c(f(r3), j()));
        }

        private void o() {
            h r0 = j();
            d.a(r0);
            g(-1, new c(r0, j()));
        }

        private void p(int r3) {
            h r4 = f(r3);
            h r0 = j();
            this.f17944a.add(new c(r4, r0));
        }

        private void q() {
            h r0 = j();
            d.a(r0);
            h r1 = j();
            this.f17944a.add(new c(r0, r1));
        }

        public List<c> e() {
            ArrayList r0 = new ArrayList(this.f17944a);
            this.f17944a.clear();
            return r0;
        }

        h j() {
            int r0 = i();
            if ((r0 & 128) != 128) goto L5;
            boolean r1 = true;
        L6:
            int r2 = m(r0, 127);
            if (r1 == false) goto L11;
            return h.u(k.f().c(this.f17945b.T(r2)));
        L11:
            return this.f17945b.n(r2);
        L5:
            r1 = false;
            goto L6
        }

        void k() {
        L3:
            if (this.f17945b.v() == true) goto L32;
            int r0 = this.f17945b.readByte() & 255;
            if (r0 == 128) goto L31;
            if ((r0 & 128) == 128) goto L8;
            if (r0 == 64) goto L11;
            if ((r0 & 64) == 64) goto L14;
            if ((r0 & 32) == 32) goto L17;
            if (r0 == 16) goto L29;
            if (r0 == 0) goto L29;
            p(m(r0, 15) - 1);
        L29:
            q();
            goto L3
        L17:
            int r1 = m(r0, 31);
            this.f17947d = r1;
            if (r1 < 0) goto L23;
            if (r1 > this.f17946c) goto L23;
            a();
        L23:
            throw new IOException("Invalid dynamic table size update " + this.f17947d);
        L14:
            n(m(r0, 63) - 1);
            goto L3
        L11:
            o();
            goto L3
        L8:
            l(m(r0, 127) - 1);
            goto L3
        L31:
            throw new IOException("index == 0");
        }

        int m(int r3, int r4) {
            int r5 = r3 & r4;
            if (r5 >= r4) goto L5;
            return r5;
        L5:
            int r6 = 0;
        L6:
            int r0 = i();
            if ((r0 & 128) == 0) goto L10;
            r4 = r4 + ((r0 & 127) << r6);
            r6 = r6 + 7;
            goto L6
        L10:
            return r4 + (r0 << r6);
        }
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f17952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f17953b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f17954c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f17955d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f17956e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        c[] f17957f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f17958g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f17959h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f17960i;

        b(int r2, boolean r3, e r4) {
            this.f17954c = Integer.MAX_VALUE;
            c[] r0 = new c[8];
            this.f17957f = r0;
            this.f17958g = r0.length - 1;
            this.f17959h = 0;
            this.f17960i = 0;
            this.f17956e = r2;
            this.f17953b = r3;
            this.f17952a = r4;
        }

        b(e r3) {
            this(4096, true, r3);
        }

        private void a() {
            int r0 = this.f17956e;
            int r1 = this.f17960i;
            if (r0 >= r1) goto L8;
            if (r0 != 0) goto L6;
            b();
            return;
        L6:
            c(r1 - r0);
            return;
        }

        private void b() {
            Arrays.fill(this.f17957f, null);
            this.f17958g = this.f17957f.length - 1;
            this.f17959h = 0;
            this.f17960i = 0;
        }

        private int c(int r5) {
            int r0 = 0;
            if (r5 <= 0) goto L10;
            int r1 = this.f17957f.length;
        L5:
            r1 = r1 - 1;
            int r2 = this.f17958g;
            if (r1 < r2) goto L9;
            if (r5 <= 0) goto L9;
            c[] r3 = this.f17957f;
            r5 = r5 - r3[r1].f17941c;
            this.f17960i -= r3[r1].f17941c;
            this.f17959h--;
            r0 = r0 + 1;
        L9:
            c[] r6 = this.f17957f;
            System.arraycopy(r6, r2 + 1, r6, (r2 + 1) + r0, this.f17959h);
            c[] r7 = this.f17957f;
            int r4 = this.f17958g;
            Arrays.fill(r7, r4 + 1, (r4 + 1) + r0, null);
            this.f17958g += r0;
        L10:
            return r0;
        }

        private void d(c r7) {
            int r0 = r7.f17941c;
            int r1 = this.f17956e;
            if (r0 <= r1) goto L6;
            b();
            return;
        L6:
            c((this.f17960i + r0) - r1);
            int r2 = this.f17959h + 1;
            c[] r3 = this.f17957f;
            if (r2 <= r3.length) goto L9;
            c[] r4 = new c[r3.length * 2];
            System.arraycopy(r3, 0, r4, r3.length, r3.length);
            this.f17958g = this.f17957f.length - 1;
            this.f17957f = r4;
        L9:
            int r5 = this.f17958g;
            this.f17958g = r5 - 1;
            this.f17957f[r5] = r7;
            this.f17959h++;
            this.f17960i += r0;
        }

        void e(int r2) {
            int r3 = Math.min(r2, 16384);
            int r0 = this.f17956e;
            if (r0 != r3) goto L5;
            return;
        L5:
            if (r3 >= r0) goto L7;
            this.f17954c = Math.min(this.f17954c, r3);
        L7:
            this.f17955d = true;
            this.f17956e = r3;
            a();
        }

        void f(h r4) {
            if (this.f17953b == true) goto L5;
        L7:
            int r0 = r4.size();
            int r2 = 0;
        L8:
            h(r0, 127, r2);
            this.f17952a.o0(r4);
            return;
        L5:
            if (k.f().e(r4) >= r4.size()) goto L7;
            e r1 = new e();
            k.f().d(r4, r1);
            r4 = r1.d0();
            r0 = r4.size();
            r2 = 128;
            goto L8
        }

        void g(List<c> r14) {
            if (this.f17955d == false) goto L8;
            int r0 = this.f17954c;
            if (r0 >= this.f17956e) goto L7;
            h(r0, 31, 32);
        L7:
            this.f17955d = false;
            this.f17954c = Integer.MAX_VALUE;
            h(this.f17956e, 31, 32);
        L8:
            int r1 = r14.size();
            int r2 = 0;
        L9:
            if (r2 >= r1) goto L49;
            c r3 = r14.get(r2);
            h r4 = r3.f17939a.D();
            h r5 = r3.f17940b;
            Integer r6 = d.f17943b.get(r4);
            if (r6 == null) goto L23;
            int r7 = r6.intValue() + 1;
            if (r7 > 1) goto L15;
        L22:
            int r9 = r7;
            r7 = -1;
        L25:
            if (r7 != (-1)) goto L36;
            int r10 = this.f17958g + 1;
            int r8 = this.f17957f.length;
        L27:
            if (r10 >= r8) goto L36;
            if (c.q(this.f17957f[r10].f17939a, r4) == false) goto L35;
            if (c.q(this.f17957f[r10].f17940b, r5) == true) goto L32;
            if (r9 != (-1)) goto L35;
            r9 = (r10 - this.f17958g) + d.f17942a.length;
            goto L35
        L32:
            r7 = d.f17942a.length + (r10 - this.f17958g);
        L35:
            r10 = r10 + 1;
        L36:
            if (r7 == (-1)) goto L39;
            h(r7, 127, 128);
        L48:
            r2 = r2 + 1;
            goto L9
        L39:
            if (r9 != (-1)) goto L43;
            this.f17952a.s0(64);
            f(r4);
        L41:
            f(r5);
            d(r3);
            goto L48
        L43:
            if (r4.C(c.f17933d) == true) goto L45;
        L47:
            h(r9, 63, 64);
            goto L41
        L45:
            if (c.f17938i.equals(r4) == true) goto L47;
            h(r9, 15, 0);
            f(r5);
            goto L48
        L15:
            if (r7 >= 8) goto L22;
            c[] r11 = d.f17942a;
            if (c.q(r11[r7 - 1].f17940b, r5) == false) goto L20;
        L24:
            r9 = r7;
            goto L25
        L20:
            if (c.q(r11[r7].f17940b, r5) == false) goto L22;
            r9 = r7;
            r7 = r7 + 1;
            goto L25
        L23:
            r7 = -1;
            goto L24
        }

        void h(int r2, int r3, int r4) {
            if (r2 >= r3) goto L6;
            e r1 = this.f17952a;
            int r5 = r2 | r4;
        L4:
            r1.s0(r5);
            return;
        L6:
            this.f17952a.s0(r4 | r3);
            r5 = r2 - r3;
        L8:
            if (r5 < 128) goto L10;
            this.f17952a.s0(128 | (r5 & 127));
            r5 = r5 >>> 7;
            goto L8
        L10:
            r1 = this.f17952a;
            goto L4
        }
    }

    static {
        h r2 = c.f17935f;
        h r3 = c.f17936g;
        h r4 = c.f17937h;
        h r5 = c.f17934e;
        f17942a = new c[]{new c(c.f17938i, ""), new c(r2, "GET"), new c(r2, "POST"), new c(r3, "/"), new c(r3, "/index.html"), new c(r4, "http"), new c(r4, LocationInfoConst.HTTPS), new c(r5, BDLocationException.SUCCESS), new c(r5, "204"), new c(r5, "206"), new c(r5, "304"), new c(r5, "400"), new c(r5, "404"), new c(r5, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c(URLDispatch.KEY_ETAG, ""), new c("expect", ""), new c("expires", ""), new c(TypedValues.TransitionType.S_FROM, ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c(LocationMonitorConst.LOCATION, ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        f17943b = b();
    }

    static h a(h r4) {
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        byte r2 = r4.l(r1);
        if (r2 < 65) goto L11;
        if (r2 > 90) goto L11;
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + r4.F());
    L11:
        r1 = r1 + 1;
        goto L3
    L12:
        return r4;
    }

    private static Map<h, Integer> b() {
        LinkedHashMap r0 = new LinkedHashMap(f17942a.length);
        int r1 = 0;
    L3:
        c[] r2 = f17942a;
        if (r1 >= r2.length) goto L10;
        if (r0.containsKey(r2[r1].f17939a) == true) goto L8;
        r0.put(r2[r1].f17939a, Integer.valueOf(r1));
    L8:
        r1 = r1 + 1;
        goto L3
    L10:
        return Collections.unmodifiableMap(r0);
    }
}
