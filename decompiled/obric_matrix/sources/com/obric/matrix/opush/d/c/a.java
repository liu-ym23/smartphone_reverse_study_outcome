package com.obric.matrix.opush.d.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.obric.matrix.opush.c;
import com.obric.matrix.opush.receiver.PushHandlerReceiver;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\u0005H\u0016J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/opush/base/device/DeviceRegisterService;", "Lcom/obric/matrix/opush/base/device/IDeviceService;", "Lcom/obric/matrix/opush/base/device/ITeaService;", "()V", "TAG", "", "did", "forceUpdateDid", "", "getDeviceId", "onEvent", NotificationCompat.CATEGORY_EVENT, "params", "Lorg/json/JSONObject;", "updateDeviceId", "updateDeviceInfo", "context", "Landroid/content/Context;", "force", "", "Companion", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile String f9275b;

    /* JADX INFO: renamed from: com.obric.matrix.opush.d.c.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/opush/base/device/DeviceRegisterService$updateDeviceInfo$1", "Lcom/obric/matrix/opush/base/network/IRequestCallback;", "onResult", "", "ec", "", NotificationCompat.CATEGORY_MESSAGE, "", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0245a implements com.obric.matrix.opush.base.network.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f9276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f9277b;

        C0245a(a r1, long r2) {
            this.f9276a = r1;
            this.f9277b = r2;
        }

        @Override // com.obric.matrix.opush.base.network.b
        public void onResult(int r4, String r5) {
            if (r4 != 0) goto L4;
            c.f9247a.b(a.c(this.f9276a), "[onDeviceInit] update device info success:" + r5);
            com.obric.matrix.opush.d.b.f9251a.u().a().b(this.f9277b);
            return;
        L4:
            c.f9247a.b(a.c(this.f9276a), "[onDeviceInit] update device info failed:errorCode is " + r4 + " errorMsg is " + r5);
        }
    }

    static {
    }

    public a() {
        this.f9274a = "DeviceRegisterService";
    }

    public static final /* synthetic */ String c(a r0) {
        return r0.f9274a;
    }

    private final synchronized void d() {
        monitor-enter(this);
        String r0 = com.obric.matrix.ostracker_api.b.c();     // Catch: Throwable -> L15
        if (r0 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
        c.f9247a.b(this.f9274a, "forceUpdateDid, deviceId from OSTracker is " + r0);     // Catch: Throwable -> L15
        this.f9275b = r0;     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L12:
        c.f9247a.b(this.f9274a, "forceUpdateDid, deviceId from OSTracker is empty");     // Catch: Throwable -> L15
        goto L13
    L6:
        if (r0.length() == 0) goto L9;
        r1 = false;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.opush.d.c.b
    public void a(String r8) {
        if (r8 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        c.j(c.f9247a, this.f9274a, "updateDeviceId, did is empty!", null, 4, null);
    L10:
        this.f9275b = r8;
        return;
    L4:
        if (r8.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @Override // com.obric.matrix.opush.d.c.b
    public void b(Context r23, boolean r24) {
        o.f(r23, "context");
        com.obric.matrix.r.c.c.j(this.f9274a, "updateDeviceInfo, force: " + r24);
        long r3 = System.currentTimeMillis();
        com.obric.matrix.opush.d.b r5 = com.obric.matrix.opush.d.b.f9251a;
        long r6 = r5.u().a().d();
        if ((r3 - r6) < 86400000) goto L5;
        boolean r8 = true;
    L6:
        if (r24 == true) goto L10;
        if (r8 == true) goto L10;
        c.f9247a.b(this.f9274a, "[onDeviceInit] currentTimeMillis(" + r3 + ") - getLastRequestUpdateDeviceTimestamp(" + r6 + ") < updateDeviceRequestIntervalInMs(86400000)");
        return;
    L10:
        Object r2 = r23.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager r4 = (AlarmManager) r2;
        Intent r7 = new Intent(r23, PushHandlerReceiver.class);
        com.obric.matrix.opush.f.b r9 = com.obric.matrix.opush.f.b.G;
        r7.setAction(r9.a());
        r7.putExtra(r9.r(), r9.s());
        PendingIntent r10 = PendingIntent.getBroadcast(r23, r9.s(), r7, 603979776);
        if (r10 == null) goto L13;
        r4.cancel(r10);
        r10.cancel();
        c.f9247a.b(this.f9274a, "[onDeviceInit] cancelled previous updateDeviceInfo alarm");
    L13:
        PendingIntent r11 = PendingIntent.getBroadcast(r23, r9.s(), r7, 201326592);
        long r12 = System.currentTimeMillis() + 86400000;
        c.f9247a.b(this.f9274a, "[onDeviceInit] set next updateDeviceInfo at " + r12);
        r4.set(0, r12, r11);
        com.obric.matrix.opush.d.i.a r14 = r5.t();
        String r15 = r23.getPackageName();
        o.e(r15, "context.packageName");
        com.obric.matrix.opush.d.i.a.C0252a.a(r14, r15, null, null, r9.B(), new C0245a(this, r3), 6, null);
        return;
    L5:
        r8 = false;
        goto L6
    }

    @Override // com.obric.matrix.opush.d.c.b
    public String getDeviceId() {
        String r0 = this.f9275b;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        d();
    L11:
        String r2 = this.f9275b;
        if (r2 != null) goto L15;
        return "";
    L15:
        return r2;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
