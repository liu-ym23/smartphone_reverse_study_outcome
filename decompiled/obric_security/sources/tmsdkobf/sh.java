package tmsdkobf;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes5.dex */
public class sh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f513a;

    public sh(int r1) {
        this.f513a = r1;
    }

    public PendingIntent a(Context r6, String r7, long r8) {
        PendingIntent r2 = null;
        cj.a("TMSDK_SK", "setAlarm:[" + r7 + "][" + (r8 / 1000) + "s]");     // Catch: Exception -> L5
        Intent r0 = new Intent(r7);     // Catch: Exception -> L5
        r0.setPackage(r6.getPackageName());     // Catch: Exception -> L5
        r2 = PendingIntent.getBroadcast(r6, 0, r0, 67108864);     // Catch: Exception -> L5
        ((AlarmManager) r6.getSystemService("alarm")).set(this.f513a, System.currentTimeMillis() + r8, r2);     // Catch: Exception -> L5
        return r2;
    L5:
        e = move-exception;
        cj.a("TMSDK_SK", "setAlarm Exception:[" + e.getMessage() + "]");
        return r2;
    }

    public void a(Context r5, String r6) {
        Intent r2 = new Intent(r6);     // Catch: Exception -> L5
        r2.setPackage(r5.getPackageName());     // Catch: Exception -> L5
        cj.a("TMSDK_SK", "cancelAlarm:[" + r6 + "]");     // Catch: Exception -> L5
        ((AlarmManager) r5.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(r5, 0, r2, 67108864));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        cj.a("TMSDK_SK", "cancelAlarm Exception:[" + e.getMessage() + "]");
    }
}
