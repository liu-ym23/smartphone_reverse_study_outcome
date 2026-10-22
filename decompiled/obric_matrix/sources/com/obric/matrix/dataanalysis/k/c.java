package com.obric.matrix.dataanalysis.k;

import android.os.IBinder;
import androidx.core.os.EnvironmentCompat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.n0.d.i0;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0016J<\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001dJ\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/matrix/dataanalysis/binder/CallbackTracker;", "", "()V", "DUMP_STEP", "", "DUMP_THRESHOLD", "MAX_LOG_LENGTH", "MAX_TOTAL_CALLBACKS", "TAG", "", "mBinderToClient", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/os/IBinder;", "Lcom/obric/matrix/dataanalysis/binder/CallbackTracker$ClientInfo;", "mPidToBinders", "", "totalCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "checkAndReject", "", "pid", "dumpLeakReport", "", "trackCallback", "binder", "uid", "pkg", "methodName", "onBinderDie", "Lkotlin/Function0;", "untrackCallback", "ClientInfo", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9078a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<IBinder, a> f9079b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, Set<IBinder>> f9080c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicInteger f9081d = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011¨\u0006#"}, d2 = {"Lcom/obric/matrix/dataanalysis/binder/CallbackTracker$ClientInfo;", "", "uid", "", "pid", "packageName", "", "methodName", "registerTime", "", "recipient", "Landroid/os/IBinder$DeathRecipient;", "(IILjava/lang/String;Ljava/lang/String;JLandroid/os/IBinder$DeathRecipient;)V", "getMethodName", "()Ljava/lang/String;", "getPackageName", "getPid", "()I", "getRecipient", "()Landroid/os/IBinder$DeathRecipient;", "getRegisterTime", "()J", "getUid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9083b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f9084c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f9085d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f9086e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final IBinder.DeathRecipient f9087f;

        public a(int r2, int r3, String r4, String r5, long r6, IBinder.DeathRecipient r8) {
            o.f(r4, "packageName");
            o.f(r5, "methodName");
            o.f(r8, "recipient");
            this.f9082a = r2;
            this.f9083b = r3;
            this.f9084c = r4;
            this.f9085d = r5;
            this.f9086e = r6;
            this.f9087f = r8;
        }

        public final String a() {
            return this.f9084c;
        }

        public final int b() {
            return this.f9083b;
        }

        public final IBinder.DeathRecipient c() {
            return this.f9087f;
        }

        public final int d() {
            return this.f9082a;
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.f9082a == r9.f9082a) goto L12;
            return false;
        L12:
            if (this.f9083b == r9.f9083b) goto L15;
            return false;
        L15:
            if (o.a(this.f9084c, r9.f9084c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f9085d, r9.f9085d) == true) goto L21;
            return false;
        L21:
            if (this.f9086e == r9.f9086e) goto L24;
            return false;
        L24:
            if (o.a(this.f9087f, r9.f9087f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            return (((((((((Integer.hashCode(this.f9082a) * 31) + Integer.hashCode(this.f9083b)) * 31) + this.f9084c.hashCode()) * 31) + this.f9085d.hashCode()) * 31) + Long.hashCode(this.f9086e)) * 31) + this.f9087f.hashCode();
        }

        public String toString() {
            return "ClientInfo(uid=" + this.f9082a + ", pid=" + this.f9083b + ", packageName=" + this.f9084c + ", methodName=" + this.f9085d + ", registerTime=" + this.f9086e + ", recipient=" + this.f9087f + ')';
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return kotlin.j0.a.a(Integer.valueOf(((Set) ((Map.Entry) r2).getValue()).size()), Integer.valueOf(((Set) ((Map.Entry) r1).getValue()).size()));
        }
    }

    static {
        f9078a = new c();
        f9079b = new ConcurrentHashMap();
        f9080c = new ConcurrentHashMap();
        f9081d = new AtomicInteger(0);
    }

    private c() {
    }

    public static /* synthetic */ void c(int r0, int r1, String r2, IBinder r3, kotlin.n0.c.a r4) {
        f(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Set d(Integer r0) {
        return g(r0);
    }

    private static final void f(int r2, int r3, String r4, IBinder r5, kotlin.n0.c.a r6) {
        o.f(r4, "$pkg");
        o.f(r5, "$binder");
        o.f(r6, "$onBinderDie");
        com.obric.matrix.r.c.c.s("BinderLeakTracker", "Binder died for PID " + r2 + ", UID " + r3 + ", pkg " + r4);
        f9078a.h(r5);
        r6.invoke();
    }

    private static final Set g(Integer r1) {
        o.f(r1, "it");
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public final boolean a(int r8) {
        int r7 = f9081d.get();
        if (r7 <= 2000) goto L13;
        int r1 = -1;
        Iterator<Map.Entry<Integer, Set<IBinder>>> r2 = f9080c.entrySet().iterator();
        int r3 = 0;
    L6:
        if (r2.hasNext() == false) goto L10;
        Map.Entry<Integer, Set<IBinder>> r4 = r2.next();
        int r5 = r4.getKey().intValue();
        Set<IBinder> r6 = r4.getValue();
        if (r6.size() <= r3) goto L6;
        r3 = r6.size();
        r1 = r5;
        goto L6
    L10:
        if (r8 != r1) goto L13;
        com.obric.matrix.r.c.c.f("BinderLeakTracker", "REJECTED registration from PID " + r8 + " (current max holder with " + r3 + " callbacks). Total callbacks: " + r7);
        return true;
    L13:
        return false;
    }

    public final void b() {
        StringBuilder r14 = new StringBuilder();
        r14.append("\n================ Binder Leak Report ================\n");
        r14.append("Total Callbacks: " + f9081d.get() + '\n');
        r14.append("----------------------------------------------------\n");
        i0 r0 = i0.f18445a;
        String r1 = String.format("%-10s %-10s %-30s %-10s\n", Arrays.copyOf(new Object[]{"PID", "UID", "Package", "Count"}, 4));
        o.e(r1, "format(format, *args)");
        r14.append(r1);
        Set<Map.Entry<Integer, Set<IBinder>>> r2 = f9080c.entrySet();
        o.e(r2, "mPidToBinders.entries");
        Iterator r3 = r.s0(r2, new b()).iterator();
    L4:
        if (r3.hasNext() == false) goto L23;
        Map.Entry r7 = (Map.Entry) r3.next();
        o.e(r7, "sortedList");
        Integer r8 = (Integer) r7.getKey();
        Set r9 = (Set) r7.getValue();
        int r10 = r9.size();
        if (r10 == 0) goto L4;
        o.e(r9, "binders");
        IBinder r11 = (IBinder) r.Q(r9);
        if (r11 == null) goto L10;
        a r12 = f9079b.get(r11);
    L11:
        if (r12 == null) goto L13;
        int r13 = r12.d();
    L14:
        if (r12 == null) goto L17;
        String r15 = r12.a();
        if (r15 == null) goto L17;
    L19:
        if (r10 <= 100) goto L21;
        String r16 = "⚠️ LEAK";
    L22:
        i0 r17 = i0.f18445a;
        String r18 = String.format("%-10d %-10d %-30s %-10d %s\n", Arrays.copyOf(new Object[]{r8, Integer.valueOf(r13), r15, Integer.valueOf(r10), r16}, 5));
        o.e(r18, "format(format, *args)");
        r14.append(r18);
        goto L4
    L21:
        r16 = "";
    L17:
        r15 = EnvironmentCompat.MEDIA_UNKNOWN;
        goto L19
    L13:
        r13 = -1;
        goto L14
    L10:
        r12 = null;
        goto L11
    L23:
        r14.append("====================================================\n");
        String r19 = r14.toString();
        o.e(r19, "sb.toString()");
        if (r19.length() <= 4000) goto L29;
        Iterator<T> r110 = k.H0(r19, 4000).iterator();
    L27:
        if (r110.hasNext() == false) goto L37;
        com.obric.matrix.r.c.c.f("BinderLeakTracker", (String) r110.next());
        goto L27
    L37:
        return;
    L29:
        com.obric.matrix.r.c.c.f("BinderLeakTracker", r19);
    }

    public final void e(final IBinder r14, final int r15, final int r16, final String r17, String r18, final kotlin.n0.c.a<f0> r19) {
        o.f(r14, "binder");
        o.f(r17, "pkg");
        o.f(r18, "methodName");
        o.f(r19, "onBinderDie");
        ConcurrentHashMap<IBinder, a> r10 = f9079b;
        if (r10.containsKey(r14) == false) goto L5;
        return;
    L5:
        IBinder.DeathRecipient r9 = new com.obric.matrix.dataanalysis.k.a(r16, r15, r17, r14, r19);
        r14.linkToDeath(r9, 0);     // Catch: Exception -> L13
        r10.put(r14, new a(r15, r16, r17, r18, System.currentTimeMillis(), r9));
        f9080c.computeIfAbsent(Integer.valueOf(r16), com.obric.matrix.dataanalysis.k.b.f9077a).add(r14);
        int r0 = f9081d.incrementAndGet();
        if (r0 > 2000) goto L10;
        return;
    L10:
        if ((r0 % 50) != 0) goto L19;
        b();
        return;
    L19:
        return;
    L13:
        e = move-exception;
        com.obric.matrix.r.c.c.g("BinderLeakTracker", "Failed to linkToDeath for PID " + r16, e);
    }

    public final void h(IBinder r4) {
        o.f(r4, "binder");
        a r3 = f9079b.remove(r4);
        if (r3 != null) goto L5;
        return;
    L5:
        boolean r0 = false;
        r4.unlinkToDeath(r3.c(), 0);     // Catch: Exception -> L19
    L7:
        ConcurrentHashMap<Integer, Set<IBinder>> r1 = f9080c;
        Set<IBinder> r2 = r1.get(Integer.valueOf(r3.b()));
        if (r2 == null) goto L10;
        r2.remove(r4);
    L10:
        Set<IBinder> r5 = r1.get(Integer.valueOf(r3.b()));
        if (r5 != null) goto L13;
    L15:
        if (r0 == false) goto L17;
        r1.remove(Integer.valueOf(r3.b()));
    L17:
        f9081d.decrementAndGet();
        return;
    L13:
        if (r5.isEmpty() != true) goto L15;
        r0 = true;
        goto L15
    }
}
