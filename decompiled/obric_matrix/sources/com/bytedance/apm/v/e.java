package com.bytedance.apm.v;

import android.os.Build;
import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f2097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f2098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f2099c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f2100d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private double f2101e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f2102f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f2103g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private double f2104h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private double f2105i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private double f2106j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f2107k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f2108l;
        private long m;
        private long n;
        private long o;
        private List<String> p;

        public a() {
            this.f2097a = -1;
            this.f2098b = -1;
            this.f2099c = -1;
            this.f2100d = -1;
            this.f2101e = -1.0d;
            this.f2102f = -1;
            this.f2103g = -1;
            this.f2104h = -1.0d;
            this.f2105i = -1.0d;
            this.f2106j = -1.0d;
            this.f2107k = -1;
            this.f2108l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = null;
        }

        static /* synthetic */ double a(a r0, double r1) {
            r0.f2104h = r1;
            return r1;
        }

        static /* synthetic */ long b(a r0, long r1) {
            r0.f2099c = r1;
            return r1;
        }

        static /* synthetic */ double c(a r0, double r1) {
            r0.f2105i = r1;
            return r1;
        }

        static /* synthetic */ long d(a r0, long r1) {
            r0.f2100d = r1;
            return r1;
        }

        static /* synthetic */ long e(a r0, long r1) {
            r0.o = r1;
            return r1;
        }

        static /* synthetic */ List f(a r0, List r1) {
            r0.p = r1;
            return r1;
        }

        static /* synthetic */ double g(a r0, double r1) {
            r0.f2106j = r1;
            return r1;
        }

        static /* synthetic */ long h(a r0, long r1) {
            r0.f2102f = r1;
            return r1;
        }

        static /* synthetic */ long i(a r0, long r1) {
            r0.f2103g = r1;
            return r1;
        }

        static /* synthetic */ double j(a r0, double r1) {
            r0.f2101e = r1;
            return r1;
        }

        static /* synthetic */ long k(a r0, long r1) {
            r0.m = r1;
            return r1;
        }

        static /* synthetic */ long l(a r0, long r1) {
            r0.n = r1;
            return r1;
        }

        static /* synthetic */ long m(a r0, long r1) {
            r0.f2097a = r1;
            return r1;
        }

        static /* synthetic */ long n(a r0, long r1) {
            r0.f2098b = r1;
            return r1;
        }

        public long A() {
            return this.m;
        }

        public double B() {
            return this.f2105i;
        }

        public double C() {
            return this.f2106j;
        }

        public long D() {
            return this.f2102f;
        }

        public void E(long r1) {
            this.f2108l = r1;
        }

        public long o() {
            return this.o;
        }

        public long p() {
            return this.f2108l;
        }

        public long q() {
            return this.f2099c;
        }

        public long r() {
            return this.f2100d;
        }

        public double s() {
            return this.f2101e;
        }

        public long t() {
            return this.f2097a;
        }

        public String toString() {
            return "LaunchTraceData{gcCount=" + this.f2097a + ", gcTime=" + this.f2098b + ", blockGcCount=" + this.f2099c + ", blockGcTime=" + this.f2100d + ", cpuTime=" + this.f2101e + ", voluntarySwitches=" + this.f2102f + ", inVoluntarySwitches=" + this.f2103g + ", iowaitTime=" + this.f2104h + ", runnableTime=" + this.f2105i + ", sleepTime=" + this.f2106j + ", minorFault=" + this.m + ", majorFault=" + this.n + ", allThreadCount=" + this.o + ", javaThreadNameList=" + this.p + ", lockTime=" + this.f2107k + ", binderTime=" + this.f2108l + '}';
        }

        public long u() {
            return this.f2098b;
        }

        public long v() {
            return this.f2103g;
        }

        public double w() {
            return this.f2104h;
        }

        public List<String> x() {
            return this.p;
        }

        public long y() {
            return this.f2107k;
        }

        public long z() {
            return this.n;
        }
    }

    private static void a(a r7) {
        int r0 = 0;
        int r1 = new File("/proc/self/task/").listFiles().length;     // Catch: Throwable -> L5
    L6:
        if (r1 != 0) goto L8;
        return;
    L8:
        ThreadGroup r2 = Looper.getMainLooper().getThread().getThreadGroup();
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.getParent() == null) goto L14;
        r2 = r2.getParent();
        goto L12
    L14:
        int r3 = r2.activeCount();
        Thread[] r4 = new Thread[r3 + (r3 / 2)];
        int r5 = r2.enumerate(r4);
        LinkedList r6 = new LinkedList();
    L15:
        if (r0 >= r5) goto L20;
        String r8 = r4[r0].getName();
        if (TextUtils.isEmpty(r8) == true) goto L19;
        r6.add(r8);
    L19:
        r0 = r0 + 1;
        goto L15
    L20:
        a.e(r7, r1);
        a.f(r7, r6);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public static a b() {
        a r3 = new a();
        int r4 = Process.myPid();     // Catch: Throwable -> L41
        BufferedReader r6 = null;
        BufferedReader r7 = new BufferedReader(new FileReader("/proc/" + r4 + "/task/" + r4 + "/sched"), 100);     // Catch: Throwable -> L50
    L59:
        String r8 = r7.readLine();     // Catch: Throwable -> L27
        if (r8 != null) goto L9;
    L51:
        BufferedReader r9 = new BufferedReader(new FileReader("/proc/" + r4 + "/task/" + r4 + "/stat"), 100);     // Catch: Throwable -> L49
        String[] r0 = r9.readLine().split(" ");     // Catch: Throwable -> L32
        a.k(r3, Long.parseLong(r0[9]));     // Catch: Throwable -> L32
        a.l(r3, Long.parseLong(r0[11]));     // Catch: Throwable -> L32
    L61:
        if (Build.VERSION.SDK_INT < 23) goto L65;
        a.m(r3, Long.parseLong(Debug.getRuntimeStat("art.gc.gc-count")));     // Catch: Throwable -> L46
        a.n(r3, Long.parseLong(Debug.getRuntimeStat("art.gc.gc-time")));     // Catch: Throwable -> L46
        a.b(r3, Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-count")));     // Catch: Throwable -> L46
        a.d(r3, Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-time")));     // Catch: Throwable -> L46
    L65:
        a(r3);     // Catch: Throwable -> L47
    L38:
        if (r9 != null) goto L53;
    L43:
        return r3;
    L53:
        r9.close();     // Catch: Throwable -> L48
    L32:
        r7 = r9;
    L33:
        r9 = r7;
        goto L61
    L9:
        if (r8.contains("se.statistics.iowait_sum") == true) goto L10;
        if (r8.contains("se.statistics.wait_sum") == true) goto L13;
        if (r8.contains("se.statistics.sum_sleep_runtime") == true) goto L16;
        if (r8.contains("nr_voluntary_switches") == true) goto L19;
        if (r8.contains("nr_involuntary_switches") == true) goto L22;
        if (r8.contains("se.sum_exec_runtime") == false) goto L59;
        a.j(r3, Double.parseDouble(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
        goto L59
    L22:
        a.i(r3, Long.parseLong(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
        goto L59
    L19:
        a.h(r3, Long.parseLong(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
        goto L59
    L16:
        a.g(r3, Double.parseDouble(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
        goto L59
    L13:
        a.c(r3, Double.parseDouble(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
        goto L59
    L10:
        a.a(r3, Double.parseDouble(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
    L27:
        r6 = r7;
    L28:
        r7 = r6;
    L41:
        th = move-exception;
        com.bytedance.apm.v.a.b().e("error when fetch launch perf data: " + th.getLocalizedMessage());     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    }
}
