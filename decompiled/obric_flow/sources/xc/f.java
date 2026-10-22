package xc;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0005\u0010\u0011\"\u0004\b\u001b\u0010\u0013R0\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R0\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b\u000e\u0010 \"\u0004\b%\u0010\"R\"\u0010)\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087D¢\u0006\f\n\u0004\b'\u0010\u000f\u001a\u0004\b(\u0010\u0011R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0006\u001a\u0004\b$\u0010\b\"\u0004\b+\u0010\n¨\u0006-"}, d2 = {"Lxc/f;", "", "<init>", "()V", "", "a", "Z", "e", "()Z", "setLogSwitch", "(Z)V", "logSwitch", "", "", "b", "[Ljava/lang/String;", "c", "()[Ljava/lang/String;", "setEventBlackList", "([Ljava/lang/String;)V", "eventBlackList", "d", "setEventWhiteList", "eventWhiteList", "f", "setUrlWhiteList", "urlWhiteList", "setChannelWhiteList", "channelWhiteList", "", "Ljava/util/Map;", "getMatchRules", "()Ljava/util/Map;", "setMatchRules", "(Ljava/util/Map;)V", "matchRules", "g", "setContainerABConfig", "containerABConfig", "h", "getJsSdkDisallowList", "jsSdkDisallowList", "i", "setWebSSPReport", "webSSPReport", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final f f23083j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("log_switch")
    private boolean f23084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("event_blacklist")
    private String[] f23085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("event_whitelist")
    private String[] f23086c;

    @SerializedName("url_whitelist")
    private String[] d;

    @SerializedName("channel_whitelist")
    private String[] e;

    @SerializedName("match_rules")
    private Map<String, String> f;

    @SerializedName("container_ab_config")
    private Map<String, String> g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SerializedName("jssdk_disallow_list")
    private final String[] f23087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SerializedName("web_ssp_report")
    private boolean f23088i;

    static {
        f23083j = new f();
    }

    public f() {
        this.f23084a = true;
        this.f23085b = new String[0];
        this.f23086c = new String[0];
        this.d = new String[0];
        this.e = new String[0];
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
        this.f23087h = new String[0];
        this.f23088i = true;
    }

    public final String[] a() {
        return this.e;
    }

    public final Map b() {
        return this.g;
    }

    public final String[] c() {
        return this.f23085b;
    }

    public final String[] d() {
        return this.f23086c;
    }

    public final boolean e() {
        return this.f23084a;
    }

    public final String[] f() {
        return this.d;
    }

    public final boolean g() {
        return this.f23088i;
    }
}
