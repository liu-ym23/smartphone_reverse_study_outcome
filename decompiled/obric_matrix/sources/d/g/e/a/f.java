package d.g.e.a;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/sdk/osettings/SettingsType;", "", "(Ljava/lang/String;I)V", "LOCAL_SETTINGS", "TT_SETTINGS", "TCC_SETTINGS", "REMOTE_SETTINGS", "DEFAULT_SETTINGS", "MAIN_SETTINGS", "UNKNOWN", "osettings_sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f16967f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f16968g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f f16969h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f f16970i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final f f16971j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final f f16972k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final f f16973l = null;
    private static final /* synthetic */ f[] m = null;

    static {
        f16967f = new f("LOCAL_SETTINGS", 0);
        f16968g = new f("TT_SETTINGS", 1);
        f16969h = new f("TCC_SETTINGS", 2);
        f16970i = new f("REMOTE_SETTINGS", 3);
        f16971j = new f("DEFAULT_SETTINGS", 4);
        f16972k = new f("MAIN_SETTINGS", 5);
        f16973l = new f("UNKNOWN", 6);
        m = a();
    }

    private f(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ f[] a() {
        return new f[]{f16967f, f16968g, f16969h, f16970i, f16971j, f16972k, f16973l};
    }

    public static f valueOf(String r1) {
        return (f) Enum.valueOf(f.class, r1);
    }

    public static f[] values() {
        return (f[]) m.clone();
    }
}
