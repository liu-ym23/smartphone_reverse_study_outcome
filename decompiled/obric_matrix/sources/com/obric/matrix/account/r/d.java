package com.obric.matrix.account.r;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.common.utility.i;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.h;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/account/util/NetworkViewModel;", "Landroid/net/ConnectivityManager$NetworkCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "networkAvailable", "Landroidx/lifecycle/MutableLiveData;", "", "getNetworkAvailable", "()Landroidx/lifecycle/MutableLiveData;", "networkAvailable$delegate", "Lkotlin/Lazy;", "goNetworkSettings", "", "onAvailable", "network", "Landroid/net/Network;", "onLost", "registerNetworkCallback", "unRegisterNetworkCallback", "Companion", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f8622c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f8624b;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/account/util/NetworkViewModel$Companion;", "", "()V", "TAG", "", "goNetworkSettings", "", "context", "Landroid/content/Context;", "isConnectInternet", "", "registerNetworkCallback", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "unRegisterNetworkCallback", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        public final void a(Context r2) {
            o.f(r2, "context");
            Intent r1 = new Intent();
            r1.setAction("android.net.wifi.PICK_WIFI_NETWORK");
            r2.startActivity(r1);
        }

        public final boolean b(Context r2) {
            o.f(r2, "context");
            boolean r1 = i.o(r2);
            com.obric.matrix.r.c.c.j("NetWorkViewModel", "isConnectInternet " + r1);
            return r1;
        }

        public final void c(Context r1, ConnectivityManager.NetworkCallback r2) {
            o.f(r1, "context");
            o.f(r2, "networkCallback");
            Object r0 = r1.getSystemService("connectivity");
            Objects.requireNonNull(r0, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ((ConnectivityManager) r0).registerDefaultNetworkCallback(r2);
        }

        public final void d(Context r1, ConnectivityManager.NetworkCallback r2) {
            o.f(r1, "context");
            o.f(r2, "networkCallback");
            Object r0 = r1.getSystemService("connectivity");
            Objects.requireNonNull(r0, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ((ConnectivityManager) r0).unregisterNetworkCallback(r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends q implements kotlin.n0.c.a<MutableLiveData<Boolean>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f8625f = null;

        static {
            f8625f = new b();
        }

        b() {
            super(0);
        }

        public final MutableLiveData<Boolean> a() {
            return new MutableLiveData();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ MutableLiveData<Boolean> invoke() {
            return a();
        }
    }

    static {
        f8622c = new a(null);
    }

    public d(Context r2) {
        o.f(r2, "context");
        this.f8623a = r2;
        this.f8624b = kotlin.i.b(b.f8625f);
        a().setValue(Boolean.valueOf(f8622c.b(r2)));
    }

    public final MutableLiveData<Boolean> a() {
        return (MutableLiveData) this.f8624b.getValue();
    }

    public final void b() {
        f8622c.a(this.f8623a);
    }

    public final void c() {
        f8622c.c(this.f8623a, this);
    }

    public final void d() {
        f8622c.d(this.f8623a, this);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network r2) {
        o.f(r2, "network");
        super.onAvailable(r2);
        a().postValue(Boolean.valueOf(f8622c.b(this.f8623a)));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network r2) {
        o.f(r2, "network");
        super.onLost(r2);
        a().postValue(Boolean.valueOf(f8622c.b(this.f8623a)));
    }
}
