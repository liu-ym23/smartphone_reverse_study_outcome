package a.b.a.a.j;

import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f31g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f32h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f33i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f34j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f35k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f36l = null;
    public static final a m = null;
    public static final /* synthetic */ a[] n = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f37f;

    static {
        a r1 = new a("ON_PERIOD_EXCEPTION", 2, "on_period_exception");
        f31g = r1;
        a r2 = new a("TASK_COUNT_EXCEPTION", 5, "task_count_exception");
        f32h = r2;
        a r3 = new a("RUN_TAK_EXCEPTION", 6, "run_task_exception");
        f33i = r3;
        a r4 = new a("PERIOD_TIMEOUT_EXCEPTION", 7, "period_timeout_exception");
        f34j = r4;
        a r5 = new a("TASK_TIMEOUT_EXCEPTION", 8, "task_timeout_exception");
        f35k = r5;
        a r6 = new a("TASK_TIMEOUT_EXCEPTION_REAL", 9, "task_timeout_exception_real");
        f36l = r6;
        a r7 = new a("OTHER_EXCEPTION", 10, "other_exception");
        m = r7;
        n = new a[]{new a("CHECK_PERIOD_EXCEPTION", 0, "check_period_exception"), new a("ON_PERIOD_TIMEOUT", 1, "on_period_timeout"), r1, new a("INIT_TASK_IN_MAIN", 3, "init_tasks_in_main"), new a("INSTANCE_CLASS_EXCEPTION", 4, "instance_class_exception"), r2, r3, r4, r5, r6, r7};
    }

    public a(String r2, int r3, String r4) {
        o.g(r4, "value");
        super(r2, r3);
        this.f37f = r4;
    }

    public static a valueOf(String r1) {
        return (a) Enum.valueOf(a.class, r1);
    }

    public static a[] values() {
        return (a[]) n.clone();
    }
}
