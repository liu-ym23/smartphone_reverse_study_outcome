package d.b.w.a.d;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f15242a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f15243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static List<g> f15244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static List<Integer> f15245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static List<Integer> f15246e;

    /* JADX INFO: renamed from: d.b.w.a.d.a$a, reason: collision with other inner class name */
    static class C0410a implements FilenameFilter {
        C0410a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r1, String r2) {
            return Pattern.matches("cpu[0-9]", r2);
        }
    }

    static class b implements FilenameFilter {
        b() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r1, String r2) {
            return Pattern.matches("state[0-9]", r2);
        }
    }

    static class c implements FilenameFilter {
        c() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r1, String r2) {
            return Pattern.matches("policy[0-9]", r2);
        }
    }

    static class d implements Comparator<File> {
        d() {
        }

        public int a(File r1, File r2) {
            return r1.getName().compareTo(r2.getName());
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(File r1, File r2) {
            return a(r1, r2);
        }
    }

    static class e implements d.b.w.a.d.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f15247a;

        e(List r1) {
            this.f15247a = r1;
        }

        @Override // d.b.w.a.d.c.a
        public boolean a(String r8) {
            if (r8 != null) goto L5;
        L10:
            return true;
        L5:
            if (r8.isEmpty() == true) goto L10;
            String[] r9 = r8.split(" ");
            int r1 = r9.length;
            int r2 = 0;
        L8:
            if (r2 >= r1) goto L10;
            String r3 = r9[r2];
            this.f15247a.add(Long.valueOf(Long.parseLong(r3)));
            r2 = r2 + 1;
            goto L8
        }
    }

    static class f implements d.b.w.a.d.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f15248a;

        f(List r1) {
            this.f15248a = r1;
        }

        @Override // d.b.w.a.d.c.a
        public boolean a(String r6) {
            if (r6 != null) goto L5;
        L10:
            return true;
        L5:
            if (r6.isEmpty() == true) goto L10;
            String[] r7 = r6.split(" ");
            int r1 = r7.length;
            int r2 = 0;
        L8:
            if (r2 >= r1) goto L10;
            String r3 = r7[r2];
            this.f15248a.add(Integer.valueOf(Integer.parseInt(r3)));
            r2 = r2 + 1;
            goto L8
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f15249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<Integer> f15250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<Long> f15251c;

        public g(String r2) {
            this.f15250b = new ArrayList();
            this.f15251c = new ArrayList();
            this.f15249a = r2;
        }

        public List<Integer> a() {
            return this.f15250b;
        }

        public String b() {
            return this.f15249a;
        }

        public void c(List<Integer> r1) {
            this.f15250b = r1;
        }

        public void d(List<Long> r1) {
            this.f15251c = r1;
        }

        public String toString() {
            return "CpuClusterInfo{name='" + this.f15249a + "', affectedCpuList=" + this.f15250b + ", freqList=" + this.f15251c + '}';
        }
    }

    static {
    }

    public static synchronized List<Integer> a() {
        monitor-enter(a.class);
        List<Integer> r1 = f15245d;     // Catch: Throwable -> L15
        if (r1 == null) goto L8;
        monitor-exit(a.class);
        return r1;
    L8:
        List<g> r2 = b();     // Catch: Throwable -> L15
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L15
        Iterator<g> r4 = r2.iterator();     // Catch: Throwable -> L15
    L10:
        if (r4.hasNext() == false) goto L12;
        r3.add(Integer.valueOf(r4.next().a().size()));     // Catch: Throwable -> L15
        goto L10
    L12:
        f15245d = r3;     // Catch: Throwable -> L15
        monitor-exit(a.class);
        return r3;
    L15:
        th = move-exception;
        throw th;
    }

    public static synchronized List<g> b() {
        monitor-enter(a.class);
        List<g> r1 = f15244c;     // Catch: Throwable -> L18
        if (r1 == null) goto L8;
        monitor-exit(a.class);
        return r1;
    L8:
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L18
        File[] r3 = new File("/sys/devices/system/cpu/cpufreq").listFiles(new c());     // Catch: Throwable -> L18
        if (r3 != null) goto L11;
    L15:
        f15244c = r2;     // Catch: Throwable -> L18
        monitor-exit(a.class);
        return r2;
    L11:
        if (r3.length <= 0) goto L15;
        Arrays.sort(r3, new d());     // Catch: Throwable -> L18
        int r4 = r3.length;     // Catch: Throwable -> L18
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L15;
        File r6 = r3[r5];     // Catch: Throwable -> L18
        g r7 = new g(r6.getName());     // Catch: Throwable -> L18
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L18
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L18
        d.b.w.a.d.c.d(r6.getAbsolutePath() + "/scaling_available_frequencies", new e(r8));     // Catch: Throwable -> L18
        d.b.w.a.d.c.d(r6.getAbsolutePath() + "/affected_cpus", new f(r9));     // Catch: Throwable -> L18
        r7.d(r8);     // Catch: Throwable -> L18
        r7.c(r9);     // Catch: Throwable -> L18
        r2.add(r7);     // Catch: Throwable -> L18
        r5 = r5 + 1;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static int c() {
        if (f15242a != (-1)) goto L10;
        File[] r0 = new File("/sys/devices/system/cpu").listFiles(new C0410a());
        if (r0 != null) goto L7;
        int r1 = 1;
    L8:
        f15242a = r1;
        goto L10
    L7:
        r1 = r0.length;
    L10:
        return f15242a;
    }

    public static String d() {
        String r0 = f15243b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r1 = d.b.w.a.d.e.a("ro.board.platform", "");
        f15243b = r1;
        return r1;
    }

    public static synchronized List<Integer> e() {
        monitor-enter(a.class);
        List<Integer> r1 = f15246e;     // Catch: Throwable -> L24
        if (r1 == null) goto L8;
        monitor-exit(a.class);
        return r1;
    L8:
        int r2 = c();     // Catch: Throwable -> L24
        if (r2 == (-1)) goto L12;
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L24
        int r4 = 0;
    L15:
        if (r4 >= r2) goto L21;
        File[] r5 = new File("/sys/devices/system/cpu/cpu" + r4 + "/cpuidle").listFiles(new b());     // Catch: Throwable -> L24
        if (r5 != null) goto L19;
        int r6 = 0;
    L20:
        r3.add(Integer.valueOf(r6));     // Catch: Throwable -> L24
        r4 = r4 + 1;     // Catch: Throwable -> L24
        goto L15
    L19:
        r6 = r5.length;     // Catch: Throwable -> L24
        goto L20
    L21:
        f15246e = r3;     // Catch: Throwable -> L24
        monitor-exit(a.class);
        return r3;
    L12:
        monitor-exit(a.class);
        return null;
    L24:
        th = move-exception;
        throw th;
    }
}
