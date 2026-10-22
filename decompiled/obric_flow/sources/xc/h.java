package xc;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR0\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\f\u0010\u0007\"\u0004\b \u0010\tR\"\u0010%\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\r\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011R\"\u0010(\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\r\u001a\u0004\b&\u0010\u000f\"\u0004\b'\u0010\u0011R\"\u0010/\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0006\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b0\u0010\tR\"\u00103\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0006\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b2\u0010\tR\"\u00106\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\r\u001a\u0004\b\"\u0010\u000f\"\u0004\b5\u0010\u0011¨\u00067"}, d2 = {"Lxc/h;", "", "<init>", "()V", "", "a", "Z", "()Z", "setEnableMemCache", "(Z)V", "enableMemCache", "", "b", "I", "g", "()I", "setMemorySize", "(I)V", "memorySize", "c", "e", "setEnableRemoteConfig", "enableRemoteConfig", "", "", "d", "Ljava/util/Map;", "h", "()Ljava/util/Map;", "setPrefix2ak", "(Ljava/util/Map;)V", "prefix2ak", "setEnablePreload", "enablePreload", "f", "j", "setPreloadTemplateSize", "preloadTemplateSize", "i", "setPreloadSubResMemSize", "preloadSubResMemSize", "", "D", "getPreloadMemWarningProportion", "()D", "setPreloadMemWarningProportion", "(D)V", "preloadMemWarningProportion", "setEnableRedirectCache", "enableRedirectCache", "setEnableRedirectDefaultCache", "enableRedirectDefaultCache", "k", "setGlobalRedirectCacheSize", "globalRedirectCacheSize", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("enable_mem")
    private boolean f23092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("mem_size")
    private int f23093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("enable_remote_config")
    private boolean f23094c;

    @SerializedName("prefix2ak")
    private Map<String, String> d;

    @SerializedName("enable_preload")
    private boolean e;

    @SerializedName("preload_template_size")
    private int f;

    @SerializedName("preload_sub_res_mem_size")
    private int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SerializedName("preload_memory_warning_proportion")
    private double f23095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SerializedName("enable_redirect_cache")
    private boolean f23096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SerializedName("enable_redirect_default_cache")
    private boolean f23097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SerializedName("global_redirect_cache_size")
    private int f23098k;

    public h() {
        this.f23092a = true;
        this.f23093b = 3000000;
        this.f23094c = true;
        this.d = new LinkedHashMap();
        this.e = true;
        this.f = 10;
        this.g = 10;
        this.f23095h = 0.1d;
        this.f23096i = true;
        this.f23098k = 1000;
    }

    public final boolean a() {
        return this.f23092a;
    }

    public final boolean b() {
        return this.e;
    }

    public final boolean c() {
        return this.f23096i;
    }

    public final boolean d() {
        return this.f23097j;
    }

    public final boolean e() {
        return this.f23094c;
    }

    public final int f() {
        return this.f23098k;
    }

    public final int g() {
        return this.f23093b;
    }

    public final Map h() {
        return this.d;
    }

    public final int i() {
        return this.g;
    }

    public final int j() {
        return this.f;
    }
}
