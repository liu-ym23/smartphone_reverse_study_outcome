package com.obric.matrix.opush.d.h;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.common_api.IBadgeApi;
import com.obric.matrix.opush.d.f.d;
import com.obric.matrix.opush.d.g.f;
import com.obric.matrix.v.a.h;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.r0.e;
import kotlin.v;
import kotlin.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 >2\u00020\u0001:\u0001>B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J \u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J \u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J \u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0004H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0011H\u0016J\u0018\u0010,\u001a\u00020*2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u0011H\u0002J$\u0010-\u001a\u00020.2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u00112\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J\u0010\u00100\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001c\u00101\u001a\u00020.2\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0016J&\u00101\u001a\u00020.2\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\b\u00102\u001a\u0004\u0018\u000103H\u0002J0\u00101\u001a\u00020.2\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000103H\u0003Jx\u00105\u001a\u00020.2\u0006\u00106\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u00112\b\u00107\u001a\u0004\u0018\u00010\u00112\b\u00108\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00042\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u0010=\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001032\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/obric/matrix/opush/base/notification/NotificationService;", "Lcom/obric/matrix/opush/base/notification/INotificationService;", "()V", "LARGE_ICON_TARGET_SIZE_DP", "", "MAX_BIG_PICTURE_TARGET_PX", "MAX_LARGE_ICON_TARGET_PX", "MIN_LARGE_ICON_TARGET_PX", "PUSH_TYPE_BADGE_ICON_TYPE", "PUSH_TYPE_BIG_IMAGE_TYPE", "PUSH_TYPE_NONE", "PUSH_TYPE_SMALL_IMAGE_TYPE", "buildIconRequest", "Lcom/obric/matrix/opush/base/img/Request;", "context", "Landroid/content/Context;", WsConstants.KEY_CONNECTION_URL, "", "buildPostedCallbackExtras", "Landroid/os/Bundle;", "message", "Lcom/obric/matrix/o/push/Message;", "notification", "Lcom/obric/matrix/o/push/Notification;", "Lcom/obric/matrix/opush/ONotification;", "buildRequest", "uri", "Landroid/net/Uri;", "targetWidthPx", "targetHeightPx", "buildStyleImageRequest", "styleType", "clamp", "value", "min", "max", "dpToPx", "dp", "getBigPictureTargetSizePx", "getLargeIconTargetSizePx", "getStyleImageTargetSizePx", "isNotificationEnabled", "", "packageName", "isNotificationsEnabledForPackage", "maybeUpdateBadge", "", "pkgName", "screenWidthPx", "showNotification", "iconBitmap", "Landroid/graphics/Bitmap;", "bitmap", "showSmtNotification", "id", "title", "content", "notifyId", "pendingIntent", "Landroid/app/PendingIntent;", "deleteIntent", "iconbm", "Companion", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c implements com.obric.matrix.opush.d.h.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f9376i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f9381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f9383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f9384h;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/matrix/opush/base/notification/NotificationService$Companion;", "", "()V", "TAG", "", "convertNotifyId", "", "idStr", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        public static final /* synthetic */ int a(a r0, String r1) {
            return r0.b(r1);
        }

        private final int b(String r3) {
            return (int) (com.obric.matrix.opush.g.g.a(r3) % ((long) Integer.MAX_VALUE));
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/obric/matrix/opush/base/notification/NotificationService$showNotification$1", "Lcom/obric/matrix/opush/base/img/ImageDownloadCallback;", "onFailed", "", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f9385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.v.a.g f9386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ h f9387c;

        b(c r1, com.obric.matrix.v.a.g r2, h r3) {
            this.f9385a = r1;
            this.f9386b = r2;
            this.f9387c = r3;
        }

        @Override // com.obric.matrix.opush.d.f.d
        public void a(Bitmap r3) {
            c.c(this.f9385a, this.f9386b, this.f9387c, r3);
        }

        @Override // com.obric.matrix.opush.d.f.d
        public void onFailed() {
            c.c(this.f9385a, this.f9386b, this.f9387c, null);
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.opush.d.h.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/obric/matrix/opush/base/notification/NotificationService$showNotification$2", "Lcom/obric/matrix/opush/base/img/ImageDownloadCallback;", "onFailed", "", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0251c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f9389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f9390c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.v.a.g f9391d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ h f9392e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bitmap f9393f;

        C0251c(int r1, String r2, c r3, com.obric.matrix.v.a.g r4, h r5, Bitmap r6) {
            this.f9388a = r1;
            this.f9389b = r2;
            this.f9390c = r3;
            this.f9391d = r4;
            this.f9392e = r5;
            this.f9393f = r6;
        }

        @Override // com.obric.matrix.opush.d.f.d
        public void a(Bitmap r4) {
            com.obric.matrix.opush.c.f9247a.b("NotificationService", "showNotification onSuccess, style: " + this.f9388a + ", url: " + this.f9389b);
            c.d(this.f9390c, this.f9391d, this.f9392e, this.f9393f, r4);
        }

        @Override // com.obric.matrix.opush.d.f.d
        public void onFailed() {
            com.obric.matrix.opush.c.f9247a.b("NotificationService", "showNotification onFailed, style: " + this.f9388a + ", url: " + this.f9389b);
            c.d(this.f9390c, this.f9391d, this.f9392e, this.f9393f, null);
        }
    }

    static {
        f9376i = new a(null);
    }

    public c() {
        this.f9378b = 1;
        this.f9379c = 2;
        this.f9380d = 3;
        this.f9381e = 64;
        this.f9382f = 128;
        this.f9383g = 384;
        this.f9384h = 1024;
    }

    public static final /* synthetic */ void c(c r0, com.obric.matrix.v.a.g r1, h r2, Bitmap r3) {
        r0.q(r1, r2, r3);
    }

    public static final /* synthetic */ void d(c r0, com.obric.matrix.v.a.g r1, h r2, Bitmap r3, Bitmap r4) {
        r0.r(r1, r2, r3, r4);
    }

    private final com.obric.matrix.opush.d.f.g e(Context r2, String r3) {
        int r4 = l(r2);
        Uri r5 = Uri.parse(r3);
        o.e(r5, "parse(this)");
        return g(r5, r4, r4);
    }

    private final Bundle f(com.obric.matrix.v.a.g r3, h r4) {
        JSONObject r2 = new JSONObject();
        r2.put("msg_id", r3.m);
        r2.put("package_name", r3.o);
        String r5 = r4.f10110d.f10048c.f10053e.f10061e;
        if (r5 != null) goto L5;
        r5 = "";
    L6:
        r2.put("additional_data", r5);
        com.obric.matrix.opush.d.g.g r6 = com.obric.matrix.opush.d.g.g.f9359a;
        f r7 = r6.c(r3);
        if (r7 == null) goto L9;
        r6.f(r2, r7);
    L9:
        Bundle r8 = new Bundle();
        r8.putString("notification_extras", r2.toString());
        return r8;
    L5:
        o.e(r5, "notification.androidConf…ickAction.extraData ?: \"\"");
        goto L6
    }

    private final com.obric.matrix.opush.d.f.g g(Uri r2, int r3, int r4) {
        return new com.obric.matrix.opush.d.f.g(r2, e.c(r3, 1), e.c(r4, 1), Bitmap.Config.ARGB_8888);
    }

    private final com.obric.matrix.opush.d.f.g h(Context r1, String r2, int r3) {
        int r4 = m(r1, r3);
        Uri r5 = Uri.parse(r2);
        o.e(r5, "parse(this)");
        return g(r5, r4, r4);
    }

    private final int i(int r1, int r2, int r3) {
        return e.i(r1, r2, r3);
    }

    private final int j(Context r1, int r2) {
        return e.c((int) ((r2 * r1.getResources().getDisplayMetrics().density) + 0.5f), 1);
    }

    private final int k(Context r3) {
        return i(Math.min(p(r3), this.f9384h), 1, this.f9384h);
    }

    private final int l(Context r3) {
        return i(j(r3, this.f9381e), this.f9382f, this.f9383g);
    }

    private final int m(Context r2, int r3) {
        if (r3 != this.f9379c) goto L6;
        return k(r2);
    L6:
        return l(r2);
    }

    private final boolean n(Context r8, String r9) {
        boolean r0 = true;
        ApplicationInfo r10 = r8.getPackageManager().getApplicationInfo(r9, 0);     // Catch: Throwable -> L12
        o.e(r10, "context.getPackageManage…ationInfo(packageName, 0)");     // Catch: Throwable -> L12
        Object r11 = Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"notification"});     // Catch: Throwable -> L12
        if (r11 == null) goto L11;
        Object r12 = Class.forName("android.app.INotificationManager$Stub").getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{(IBinder) r11});     // Catch: Throwable -> L12
        Object r7 = r12.getClass().getMethod("areNotificationsEnabledForPackage", new Class[]{String.class, Integer.TYPE}).invoke(r12, new Object[]{r10.packageName, Integer.valueOf(r10.uid)});     // Catch: Throwable -> L12
        if (r7 == null) goto L9;
        r0 = ((Boolean) r7).booleanValue();     // Catch: Throwable -> L12
    L14:
        com.obric.matrix.opush.c.f9247a.b("NotificationService", "isNotificationsEnabledForPackage: " + r0);
        return r0;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.os.IBinder");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        com.obric.matrix.opush.c.e(com.obric.matrix.opush.c.f9247a, "NotificationService", "isNotificationsEnabledForPackage error: " + th, null, 4, null);
        goto L14
    }

    private final void o(Context r8, String r9, h r10) {
        com.obric.matrix.v.a.c r11 = r10.f10110d.f10048c.f10054f;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.f10055a >= 0) goto L11;
        if (r11.f10056b >= 0) goto L11;
        return;
    L11:
        if (n(r8, r9) == true) goto L25;
        com.obric.matrix.opush.c.f9247a.h("NotificationService", "skip badge update, notifications disabled for pkg=" + r9);
        return;
    L25:
        v.a r7 = v.f21457g;     // Catch: Throwable -> L19
        IBadgeApi r1 = (IBadgeApi) com.bytedance.news.common.service.manager.d.a(IBadgeApi.class);     // Catch: Throwable -> L19
        if (r1 == null) goto L17;
        r1.updateBadge(r8, r9, r11.f10056b, r11.f10055a, "Matrix_Push");     // Catch: Throwable -> L19
    L17:
        com.obric.matrix.opush.c.f9247a.h("NotificationService", "updateBadge success, pkg=" + r9 + " addNum=" + r11.f10055a + " setNum=" + r11.f10056b);     // Catch: Throwable -> L19
        Object r12 = f0.f18324a;     // Catch: Throwable -> L19
        v.b(r12);     // Catch: Throwable -> L19
    L21:
        Throwable r13 = v.d(r12);
        if (r13 == null) goto L27;
        com.obric.matrix.opush.c.f9247a.d("NotificationService", "updateBadge failed, pkg=" + r9, r13);
        return;
    L27:
        return;
    L19:
        th = move-exception;
        v.a r14 = v.f21457g;
        r12 = w.a(th);
        v.b(r12);
        goto L21
    }

    private final int p(Context r1) {
        return r1.getResources().getDisplayMetrics().widthPixels;
    }

    private final void q(com.obric.matrix.v.a.g r13, h r14, Bitmap r15) {
        com.obric.matrix.v.a.b r1 = r14.f10110d.f10048c;     // Catch: Throwable -> L10
        String r4 = r1.f10050b;     // Catch: Throwable -> L10
        int r3 = r1.f10051c;     // Catch: Throwable -> L10
        Application r2 = com.bytedance.mpaas.app.a.b();     // Catch: Throwable -> L10
        if (r3 != 0) goto L6;
    L8:
        r(r13, r14, r15, null);     // Catch: Throwable -> L10
    L12:
        return;
    L6:
        if (TextUtils.isEmpty(r4) == true) goto L8;
        com.obric.matrix.opush.d.f.b r9 = com.obric.matrix.opush.d.b.f9251a.a();     // Catch: Throwable -> L10
        o.e(r2, "context");     // Catch: Throwable -> L10
        o.e(r4, "imageUrl");     // Catch: Throwable -> L10
        r9.b(h(r2, r4, r3), true, new C0251c(r3, r4, this, r13, r14, r15));     // Catch: Throwable -> L10
    L10:
        r(r13, r14, r15, null);
    }

    @SuppressLint({"ServiceCast"})
    private final void r(com.obric.matrix.v.a.g r15, h r16, Bitmap r17, Bitmap r18) {
        Application r2 = com.bytedance.mpaas.app.a.b();     // Catch: Throwable -> L5
        a r3 = f9376i;     // Catch: Throwable -> L5
        String r4 = r15.m;     // Catch: Throwable -> L5
        o.e(r4, "message.msg_id");     // Catch: Throwable -> L5
        int r7 = a.a(r3, r4);     // Catch: Throwable -> L5
        com.obric.matrix.opush.c.f9247a.h("NotificationService", "showNotification notifyId: " + r7 + " msg_id: " + r15.m);     // Catch: Throwable -> L5
        com.obric.matrix.opush.d.h.b r5 = com.obric.matrix.opush.d.h.b.f9375a;     // Catch: Throwable -> L5
        o.e(r2, "context");     // Catch: Throwable -> L5
        PendingIntent r8 = r5.a(r2, r7, r15, r16);     // Catch: Throwable -> L5
        PendingIntent r9 = r5.b(r2, r7, r15, r16);     // Catch: Throwable -> L5
        String r6 = r15.m;     // Catch: Throwable -> L5
        o.e(r6, "message.msg_id");     // Catch: Throwable -> L5
        String r10 = r15.o;     // Catch: Throwable -> L5
        o.e(r10, "message.pkg_name");     // Catch: Throwable -> L5
        s(r6, r10, r16.f10107a, r16.f10108b, r16.f10110d.f10048c.f10051c, r7, r8, r9, r17, r18, r15, r16);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.d("", "show notification error", th);
    }

    private final void s(String r32, String r33, String r34, String r35, int r36, int r37, PendingIntent r38, PendingIntent r39, Bitmap r40, Bitmap r41, com.obric.matrix.v.a.g r42, h r43) {
        Application r8 = com.bytedance.mpaas.app.a.b();
        o.e(r8, "context");
        if (n(r8, r33) == false) goto L5;
        int r9 = 4;
    L6:
        if (r34 != null) goto L10;
        String r12 = com.obric.matrix.opush.g.f.f9430a.c(r8, r33);
        if (r12 != null) goto L11;
        r12 = "";
    L11:
        if (r35 != null) goto L13;
        String r13 = r33;
    L14:
        if (r40 != null) goto L16;
        Bitmap r14 = com.obric.matrix.opush.g.f.f9430a.b(r8, r33);
    L17:
        if (r41 != null) goto L19;
        Bitmap r15 = r14;
    L20:
        long r16 = System.currentTimeMillis();
        if (r36 != this.f9377a) goto L24;
    L25:
        boolean r0 = false;
    L26:
        r15 = null;
    L67:
        Class<?> r10 = Class.forName("android.app.SmtNotificationInfo");     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        Class<?> r20 = Integer.TYPE;     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        Class<?> r21 = Boolean.TYPE;     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        Constructor<?> r11 = r10.getConstructor(new Class[]{String.class, r20, r20, String.class, String.class, r21, PendingIntent.class, Bitmap.class, Bitmap.class, r21, Long.TYPE, r21, r21});     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        Boolean r17 = Boolean.TRUE;     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        Object r18 = r11.newInstance(new Object[]{r33, Integer.valueOf(r37), Integer.valueOf(r9), r12, r13, r17, r38, r14, r15, Boolean.valueOf(r0), Long.valueOf(r16), r17, r17});     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        v.a r1 = v.f21457g;     // Catch: Throwable -> L37
        Object r2 = r10.getMethod("setDeleteIntent", new Class[]{PendingIntent.class}).invoke(r18, new Object[]{r39});     // Catch: Throwable -> L37
        v.b(r2);     // Catch: Throwable -> L37
    L39:
        Throwable r3 = v.d(r2);     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        if (r3 == null) goto L63;
        com.obric.matrix.opush.c.f9247a.d("NotificationService", "setDeleteIntent failed", r3);     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
    L63:
        v.a r4 = v.f21457g;     // Catch: Throwable -> L44
        Object r5 = r10.getMethod("setExtras", new Class[]{Bundle.class}).invoke(r18, new Object[]{f(r42, r43)});     // Catch: Throwable -> L44
        v.b(r5);     // Catch: Throwable -> L44
    L46:
        Throwable r6 = v.d(r5);     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        if (r6 == null) goto L49;
        com.obric.matrix.opush.c.f9247a.d("NotificationService", "setExtras failed", r6);     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
    L49:
        Object r7 = Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"notification"});     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        Object r19 = Class.forName("android.app.INotificationManager").getMethod("getISmtEx", new Class[0]).invoke(Class.forName("android.app.INotificationManager$Stub").getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r7}), new Object[0]);     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        Class<?> r22 = Class.forName("android.app.INotificationManagerSmtEx");     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        Class.forName("android.os.UserHandle");     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        Integer r23 = r42.n;     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        if (r23 != null) goto L52;
        int r24 = 0;
    L53:
        r22.getMethod("notifySmtNotification", new Class[]{Class.forName("android.app.SmtNotificationInfo"), Integer.TYPE}).invoke(r19, new Object[]{r18, Integer.valueOf(r24)});     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        o(r8, r33, r43);     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
    L70:
        return;
    L52:
        r24 = r23.intValue();     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
    L44:
        th = move-exception;
        v.a r25 = v.f21457g;     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        r5 = w.a(th);     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        v.b(r5);     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
    L37:
        th = move-exception;
        v.a r26 = v.f21457g;     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        r2 = w.a(th);     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
        v.b(r2);     // Catch: Exception -> L55 NoSuchMethodException -> L57 ClassNotFoundException -> L59
    L59:
        e = e;
        com.obric.matrix.opush.c r27 = com.obric.matrix.opush.c.f9247a;
        String r28 = "Class can't find。";
    L61:
        r27.d("NotificationService", r28, e);
        return;
    L57:
        e = e;
        r27 = com.obric.matrix.opush.c.f9247a;
        r28 = "Method can't find。";
    L55:
        e = move-exception;
        e.printStackTrace();
        return;
    L24:
        if (r36 == this.f9378b) goto L25;
        if (r36 != this.f9379c) goto L31;
        r0 = false;
        r14 = null;
        goto L67
    L31:
        if (r36 != this.f9380d) goto L33;
        r14 = r15;
        r0 = true;
        goto L26
    L33:
        r0 = false;
        r14 = null;
        goto L26
    L19:
        r15 = r41;
        goto L20
    L16:
        r14 = r40;
        goto L17
    L13:
        r13 = r35;
        goto L14
    L10:
        r12 = r34;
        goto L11
    L5:
        r9 = 0;
        goto L6
    }

    @Override // com.obric.matrix.opush.d.h.a
    public boolean a(String r3) {
        o.f(r3, "packageName");
        Application r0 = com.bytedance.mpaas.app.a.b();
        o.e(r0, "getInstance()");
        return n(r0, r3);
    }

    @Override // com.obric.matrix.opush.d.h.a
    public void b(com.obric.matrix.v.a.g r6, h r7) {
        o.f(r6, "message");
        o.f(r7, "notification");
        if (TextUtils.isEmpty(r6.m) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r6.o) == true) goto L24;
        com.obric.matrix.v.a.b r0 = r7.f10110d.f10048c;
        if (r0.f10051c <= this.f9380d) goto L20;
        com.obric.matrix.opush.c.f9247a.c("style error, styleType: " + r7.f10110d.f10048c.f10051c);
        return;
    L20:
        String r1 = r0.f10049a;     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r1) == true) goto L15;
        Application r2 = com.bytedance.mpaas.app.a.b();     // Catch: Throwable -> L17
        com.obric.matrix.opush.d.f.b r3 = com.obric.matrix.opush.d.b.f9251a.a();     // Catch: Throwable -> L17
        o.e(r2, "context");     // Catch: Throwable -> L17
        o.e(r1, "imageUrl");     // Catch: Throwable -> L17
        r3.b(e(r2, r1), true, new b(this, r6, r7));     // Catch: Throwable -> L17
    L19:
        return;
    L15:
        q(r6, r7, null);     // Catch: Throwable -> L17
    L17:
        q(r6, r7, null);
        return;
    }
}
