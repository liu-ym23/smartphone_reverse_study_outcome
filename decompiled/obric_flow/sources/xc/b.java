package xc;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u000e\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\"\u0010\"\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lxc/b;", "", "<init>", "()V", "", "a", "I", "getSettingsVersion", "()I", "setSettingsVersion", "(I)V", "settingsVersion", "", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "setCloseAuthUrls", "(Ljava/util/List;)V", "closeAuthUrls", "", "c", "Z", "()Z", "setCloseAllAuth", "(Z)V", "isCloseAllAuth", "d", "getEnableConfigUpdate", "setEnableConfigUpdate", "enableConfigUpdate", "e", "getEnableAuthConfigRequest", "setEnableAuthConfigRequest", "enableAuthConfigRequest", "", "f", "J", "getAuthRequestInterval", "()J", "setAuthRequestInterval", "(J)V", "authRequestInterval", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("settings_version")
    private int f23015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("close_auth_urls")
    private List<String> f23016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("is_close_auth")
    private boolean f23017c;

    @SerializedName("open_config_update")
    private boolean d;

    @SerializedName("open_auto_config_request")
    private boolean e;

    @SerializedName("auto_request_internal")
    private long f;

    public b() {
        this.f23016b = CollectionsKt.listOf(new String[]{"^https://i.snssdk.com/magic/eco/runtime/release", "^https://i.snssdk.com/magic/eco/runtime/beta", "^https://aweme.snssdk.com/magic/eco/runtime/release", "^https://aweme.snssdk.com/magic/eco/runtime/beta", "^https://hotsoon.snssdk.com/magic/eco/runtime/release", "^https://hotsoon.snssdk.com/magic/eco/runtime/beta", "^https://reading.snssdk.com/magic/eco/runtime/release", "^https://reading.snssdk.com/magic/eco/runtime/beta", "^https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source", "^https://lf-dy-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source", "^https://test-aweme.snssdk.com/falcon/jsb_tester_web/dmt"});
        this.e = true;
        this.f = 3600;
    }

    public final List a() {
        return this.f23016b;
    }

    public final boolean b() {
        return this.f23017c;
    }
}
