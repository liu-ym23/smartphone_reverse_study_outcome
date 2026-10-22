package xc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\b\u0010\u0010\n¨\u0006\u0012"}, d2 = {"Lxc/g;", "", "<init>", "()V", "", "a", "Z", "getDisablePreload", "()Z", "setDisablePreload", "(Z)V", "disablePreload", "b", "setDisablePrefetch", "disablePrefetch", "c", "setDisableCodeCache", "disableCodeCache", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("pineapple_disable_preload")
    private boolean f23089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("pineapple_disable_prefetch")
    private boolean f23090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("pineapple_disable_code_cache")
    private boolean f23091c;

    public g() {
    }

    public final boolean a() {
        return this.f23091c;
    }

    public final boolean b() {
        return this.f23090b;
    }
}
