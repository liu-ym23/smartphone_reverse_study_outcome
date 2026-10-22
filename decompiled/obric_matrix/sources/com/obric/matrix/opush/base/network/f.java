package com.obric.matrix.opush.base.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.matrix.r.e.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(24)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J+\u0010\u000e\u001a\u00020\n2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\bH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/matrix/opush/base/network/TaskAfterNetworkAvailableService;", "Landroid/net/ConnectivityManager$NetworkCallback;", "Lcom/obric/matrix/opush/base/network/ITaskAfterNetworkAvailableService;", "()V", "TAG", "", "mNetworkAvailableListener", "", "Lkotlin/Function1;", "", "", "mNetworkIsAvailable", "mTaskSetAfterNetworkAvailable", "Ljava/lang/Runnable;", "addNetworkAvailableListener", "listener", "Lkotlin/ParameterName;", "name", TypedValues.Custom.S_BOOLEAN, "addTaskAfterNetworkAvailable", "runnable", "handleNetworkAvailable", "init", "context", "Landroid/content/Context;", "onAvailable", "network", "Landroid/net/Network;", "onCapabilitiesChanged", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "onLost", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f extends ConnectivityManager.NetworkCallback implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<Runnable> f9239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<l<Boolean, f0>> f9240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9242d;

    public f() {
        this.f9239a = new LinkedHashSet();
        this.f9240b = new LinkedHashSet();
        this.f9242d = "TaskAfterNetworkAvailableService";
    }

    private final void b() {
        if (this.f9241c == true) goto L13;
        com.obric.matrix.opush.c.f9247a.b(this.f9242d, "on network available actually!");
        this.f9241c = true;
        int r2 = 0;
        Object[] r1 = this.f9239a.toArray(new Runnable[0]);
        o.d(r1, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Runnable[] r3 = (Runnable[]) r1;
        int r4 = r3.length;
    L5:
        if (r2 >= r4) goto L8;
        Runnable r5 = r3[r2];
        this.f9239a.remove(r5);
        a(r5);
        r2 = r2 + 1;
        goto L5
    L8:
        if ((true ^ this.f9240b.isEmpty()) == false) goto L16;
        Iterator<T> r0 = this.f9240b.iterator();
    L11:
        if (r0.hasNext() == false) goto L17;
        ((l) r0.next()).invoke(Boolean.valueOf(this.f9241c));
        goto L11
    L17:
        return;
    L16:
        return;
    }

    @Override // com.obric.matrix.opush.base.network.c
    public void a(Runnable r2) {
        o.f(r2, "runnable");
        if (this.f9241c == true) goto L9;
        if (h.b() == true) goto L9;
        this.f9239a.add(r2);
        return;
    L9:
        if (this.f9241c == true) goto L11;
        b();
    L11:
        r2.run();
    }

    @Override // com.obric.matrix.opush.base.network.c
    public void init(Context r4) {
        o.f(r4, "context");
        com.obric.matrix.opush.c.f9247a.b(this.f9242d, "on init");
        ((ConnectivityManager) r4.getSystemService(ConnectivityManager.class)).registerDefaultNetworkCallback(this);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network r2) {
        o.f(r2, "network");
        super.onAvailable(r2);
        com.obric.matrix.opush.c.f9247a.b(this.f9242d, "on network available (physical link connected)!");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network r2, NetworkCapabilities r3) {
        o.f(r2, "network");
        o.f(r3, "networkCapabilities");
        super.onCapabilitiesChanged(r2, r3);
        if (r3.hasCapability(16) == false) goto L9;
        if (this.f9241c == true) goto L7;
        com.obric.matrix.opush.c.f9247a.b(this.f9242d, "on network capabilities changed: VALIDATED!");
    L7:
        b();
        return;
    L9:
        if (this.f9241c == false) goto L13;
        com.obric.matrix.opush.c.f9247a.b(this.f9242d, "on network capabilities changed: NOT VALIDATED yet.");
        return;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network r3) {
        o.f(r3, "network");
        super.onLost(r3);
        com.obric.matrix.opush.c.f9247a.b(this.f9242d, "on network unAvailable!");
        this.f9241c = false;
    }
}
