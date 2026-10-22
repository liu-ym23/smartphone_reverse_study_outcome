package com.obric.matrix.opush.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.obric.matrix.opush.d.g.f;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/matrix/opush/service/NotificationEventService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "Companion", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NotificationEventService extends Service {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f9442f = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/matrix/opush/service/NotificationEventService$Companion;", "", "()V", "TAG", "", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "dataJson", "Lorg/json/JSONObject;", NotificationCompat.CATEGORY_EVENT, "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        public final Intent a(Context r2, JSONObject r3, String r4) {
            o.f(r2, "context");
            o.f(r3, "dataJson");
            o.f(r4, NotificationCompat.CATEGORY_EVENT);
            Intent r1 = new Intent(r2, NotificationEventService.class);
            com.obric.matrix.opush.f.b r5 = com.obric.matrix.opush.f.b.G;
            r1.setAction(r5.d());
            r1.putExtra("data", r3.toString());
            r1.putExtra(r5.g(), r4);
            return r1;
        }
    }

    static {
        f9442f = new a(null);
    }

    public NotificationEventService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        if (r10 == null) goto L5;
        String r0 = r10.getAction();
    L6:
        com.obric.matrix.opush.f.b r1 = com.obric.matrix.opush.f.b.G;
        if (o.a(r0, r1.d()) == true) goto L47;
        return 2;
    L47:
        String r2 = r10.getStringExtra("data");     // Catch: Throwable -> L37
        if (r2 != null) goto L13;
        stopSelf(r12);
        return 2;
    L13:
        JSONObject r3 = new JSONObject(r2);     // Catch: Throwable -> L37
        String r4 = r3.optString("msg_id");     // Catch: Throwable -> L37
        String r5 = r3.optString("package_name");     // Catch: Throwable -> L37
        f r6 = com.obric.matrix.opush.d.g.g.f9359a.b(r3);     // Catch: Throwable -> L37
        String r13 = r10.getStringExtra(r1.g());     // Catch: Throwable -> L37
        if (o.a(r13, r1.E()) == false) goto L22;
        if (TextUtils.isEmpty(r4) == false) goto L19;
    L46:
    L39:
        stopSelf(r12);
        return 2;
    L19:
        if (TextUtils.isEmpty(r5) == true) goto L46;
        com.obric.matrix.opush.d.b r14 = com.obric.matrix.opush.d.b.f9251a;     // Catch: Throwable -> L37
        com.obric.matrix.opush.d.g.d r15 = r14.r();     // Catch: Throwable -> L37
        o.e(r4, "msgId");     // Catch: Throwable -> L37
        o.e(r5, "pkgName");     // Catch: Throwable -> L37
        r15.a(r4, r5);     // Catch: Throwable -> L37
        r14.r().g(r4, r5, r6);     // Catch: Throwable -> L37
        goto L46
    L22:
        if (o.a(r13, r1.C()) == false) goto L29;
        if (TextUtils.isEmpty(r4) == true) goto L46;
        if (TextUtils.isEmpty(r5) == true) goto L46;
        com.obric.matrix.opush.d.b r16 = com.obric.matrix.opush.d.b.f9251a;     // Catch: Throwable -> L37
        com.obric.matrix.opush.d.g.d r7 = r16.r();     // Catch: Throwable -> L37
        o.e(r4, "msgId");     // Catch: Throwable -> L37
        o.e(r5, "pkgName");     // Catch: Throwable -> L37
        r7.c(r4, r5, null);     // Catch: Throwable -> L37
        r16.r().e(r4, r5, r6);     // Catch: Throwable -> L37
        goto L46
    L29:
        if (o.a(r13, r1.D()) == true) goto L31;
        com.obric.matrix.opush.c.e(com.obric.matrix.opush.c.f9247a, "NotificationEventService", "unsupported notification event", null, 4, null);     // Catch: Throwable -> L37
        goto L46
    L31:
        if (TextUtils.isEmpty(r4) == true) goto L46;
        if (TextUtils.isEmpty(r5) == true) goto L46;
        com.obric.matrix.opush.d.g.d r17 = com.obric.matrix.opush.d.b.f9251a.r();     // Catch: Throwable -> L37
        o.e(r4, "msgId");     // Catch: Throwable -> L37
        o.e(r5, "pkgName");     // Catch: Throwable -> L37
        r17.f(r4, r5, r6);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.d("NotificationEventService", "handle notification event error", th);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        stopSelf(r12);
        throw th;
    L5:
        r0 = null;
        goto L6
    }
}
