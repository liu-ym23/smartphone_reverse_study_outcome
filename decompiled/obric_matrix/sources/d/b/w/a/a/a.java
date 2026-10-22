package d.b.w.a.a;

import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static a f15142i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private C0409a f15150h;

    /* JADX INFO: renamed from: d.b.w.a.a.a$a, reason: collision with other inner class name */
    public static class C0409a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f15151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f15152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f15153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f15154d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f15155e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f15156f;

        public C0409a() {
            this.f15151a = EnvironmentCompat.MEDIA_UNKNOWN;
            this.f15152b = "default";
            this.f15153c = 0.0f;
            this.f15154d = 0.0f;
            this.f15155e = 0.0f;
            this.f15156f = 0.0f;
        }

        public float a() {
            return this.f15156f;
        }

        public float b() {
            return this.f15153c;
        }

        public String toString() {
            return "CpuAbnormalConfig{cpuHardWare='" + this.f15151a + "', scene='" + this.f15152b + "', cpuSpeed=" + this.f15153c + ", smallCpuCoreTimePercent=" + this.f15154d + ", middleCpuCoreTimePercent=" + this.f15155e + ", BigCpuCoreTimePercent=" + this.f15156f + '}';
        }
    }

    static {
        f15142i = new a();
    }

    public a() {
        this.f15143a = false;
        this.f15144b = false;
        this.f15145c = false;
        this.f15146d = false;
        this.f15147e = false;
        this.f15148f = 37;
        this.f15149g = 30;
        this.f15150h = new C0409a();
    }

    public C0409a a() {
        return this.f15150h;
    }

    public int b() {
        return this.f15149g;
    }

    public int c() {
        return this.f15148f;
    }

    public boolean d() {
        return this.f15143a;
    }

    public boolean e() {
        return this.f15146d;
    }

    public boolean f() {
        return this.f15147e;
    }

    public boolean g() {
        return this.f15145c;
    }

    public boolean h() {
        return this.f15144b;
    }

    public String toString() {
        return "AssistConfig{enableProcessCpuUsageStat=" + this.f15143a + ", enableThreadCpuUsageStat=" + this.f15144b + ", enableSystemCpuUsageStat=" + this.f15145c + ", enableProcessTimeFreqPercent=" + this.f15146d + ", enableSystemCpuTimeFreqPercent=" + this.f15147e + ", cpuSampleBatteryTemp=" + this.f15148f + ", cpuSampleBatteryLevel=" + this.f15149g + ", cpuAbnormalConfig=" + this.f15150h + '}';
    }
}
