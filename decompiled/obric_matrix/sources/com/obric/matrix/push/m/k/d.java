package com.obric.matrix.push.m.k;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.push.k;
import com.obric.matrix.push.r.h;
import com.obric.matrix.push_api.e;
import com.obric.matrix.r.e.f;
import java.lang.reflect.Constructor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0004\b\u0000\u0018\u0000 L2\u00020\u0001:\u0001LB\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J \u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0002JD\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'H\u0002J \u0010(\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0007H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0014\u0010-\u001a\u0004\u0018\u00010!2\b\u0010.\u001a\u0004\u0018\u00010!H\u0002J \u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0002J\u0018\u00103\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u0007H\u0002J\u0010\u00105\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u00106\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u00107\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0007H\u0002J\u0018\u00108\u001a\u0002092\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u0004H\u0002J\u0010\u0010;\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020>H\u0016J\u001a\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020>2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J$\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020>2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010.\u001a\u0004\u0018\u00010!H\u0003J\u0018\u0010<\u001a\u00020*2\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\"\u0010<\u001a\u00020*2\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010.\u001a\u0004\u0018\u00010!H\u0002J\u008e\u0001\u0010<\u001a\u00020*2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010C\u001a\u0004\u0018\u00010\u00042\b\u0010D\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010E\u001a\u0004\u0018\u00010\u00042\u0006\u0010F\u001a\u00020\u00072\b\u0010G\u001a\u0004\u0018\u00010\u00102\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010!2\b\u0010.\u001a\u0004\u0018\u00010!H\u0002J\u009a\u0001\u0010K\u001a\u00020*2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010C\u001a\u0004\u0018\u00010\u00042\b\u0010D\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010E\u001a\u0004\u0018\u00010\u00042\u0006\u0010F\u001a\u00020\u00072\b\u0010G\u001a\u0004\u0018\u00010\u00102\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010!2\b\u0010.\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/obric/matrix/push/base/notification/NotificationService;", "Lcom/obric/matrix/push/base/notification/INotificationService;", "()V", "DEFAULT_CHANNEL", "", "DEFAULT_TAG", "LARGE_ICON_TARGET_SIZE_DP", "", "MAX_BIG_PICTURE_TARGET_PX", "MAX_LARGE_ICON_TARGET_PX", "MIN_LARGE_ICON_TARGET_PX", "PUSH_TYPE_BADGE_ICON_TYPE", "PUSH_TYPE_BIG_IMAGE_TYPE", "PUSH_TYPE_NONE", "PUSH_TYPE_SMALL_IMAGE_TYPE", "buildContentIntent", "Landroid/app/PendingIntent;", "context", "Landroid/content/Context;", "requestCode", "intent", "Landroid/content/Intent;", "buildIconRequest", "Lcom/obric/matrix/push/base/img/Request;", WsConstants.KEY_CONNECTION_URL, "buildRequest", "uri", "Landroid/net/Uri;", "targetWidthPx", "targetHeightPx", "buildStyle", "Landroid/app/Notification;", "iconBitmap", "Landroid/graphics/Bitmap;", "imageBitmap", "styleType", "title", "text", "builder", "Landroid/app/Notification$Builder;", "buildStyleImageRequest", "cancelNotification", "", "revoke", "Lcom/obric/matrix/push/Revoke;", "checkBitmap", "bitmap", "clamp", "value", "min", "max", "dpToPx", "dp", "getBigPictureTargetSizePx", "getLargeIconTargetSizePx", "getStyleImageTargetSizePx", "isNotificationsEnabledForPackage", "", "packageName", "screenWidthPx", "showNotification", "push", "Lcom/obric/matrix/push/Push;", "notification", "Lcom/obric/matrix/push_api/Notification;", "id", "pkgName", "content", "channelId", "groupId", "notifyId", "pendingIntent", "notificationExtra", "", "iconbm", "showSmtNotification", "Companion", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d implements com.obric.matrix.push.m.k.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f9717j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f9722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f9724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f9725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f9726i;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\f\u0010\b\u001a\u00020\u0006*\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/matrix/push/base/notification/NotificationService$Companion;", "", "()V", "TAG", "", "convertNotifyId", "", "idStr", "genNotifyId", "Lcom/obric/matrix/push/Push;", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        public static final /* synthetic */ int a(a r0, String r1) {
            return r0.c(r1);
        }

        public static final /* synthetic */ int b(a r0, com.obric.matrix.push.g r1) {
            return r0.d(r1);
        }

        private final int c(String r3) {
            return (int) (h.a(r3) % ((long) Integer.MAX_VALUE));
        }

        private final int d(com.obric.matrix.push.g r3) {
            String r0 = r3.w;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L11;
            String r2 = r3.f9564f;
            String r4 = "id";
        L12:
            o.e(r2, r4);
            int r5 = c(r2);
            com.obric.matrix.push.n.c.c.b("NotificationService", "genNotifyId, [" + r5 + "], push: " + r3.f9564f);
            return r5;
        L11:
            r2 = r3.w;
            r4 = "revoke_id";
            goto L12
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/obric/matrix/push/base/notification/NotificationService$showNotification$1", "Lcom/obric/matrix/push/base/img/ImageDownloadCallback;", "onFailed", "", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements com.obric.matrix.push.m.g.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f9727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.push.g f9728b;

        b(d r1, com.obric.matrix.push.g r2) {
            this.f9727a = r1;
            this.f9728b = r2;
        }

        @Override // com.obric.matrix.push.m.g.d
        public void a(Bitmap r2) {
            d.c(this.f9727a, this.f9728b, r2);
        }

        @Override // com.obric.matrix.push.m.g.d
        public void onFailed() {
            d.c(this.f9727a, this.f9728b, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/obric/matrix/push/base/notification/NotificationService$showNotification$2", "Lcom/obric/matrix/push/base/img/ImageDownloadCallback;", "onFailed", "", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements com.obric.matrix.push.m.g.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f9729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f9730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f9731c;

        c(d r1, e r2, Intent r3) {
            this.f9729a = r1;
            this.f9730b = r2;
            this.f9731c = r3;
        }

        @Override // com.obric.matrix.push.m.g.d
        public void a(Bitmap r3) {
            d.e(this.f9729a, this.f9730b, this.f9731c, r3);
        }

        @Override // com.obric.matrix.push.m.g.d
        public void onFailed() {
            d.e(this.f9729a, this.f9730b, this.f9731c, null);
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.push.m.k.d$d, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/obric/matrix/push/base/notification/NotificationService$showNotification$3", "Lcom/obric/matrix/push/base/img/ImageDownloadCallback;", "onFailed", "", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0272d implements com.obric.matrix.push.m.g.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.push.g f9732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f9733b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bitmap f9734c;

        C0272d(com.obric.matrix.push.g r1, d r2, Bitmap r3) {
            this.f9732a = r1;
            this.f9733b = r2;
            this.f9734c = r3;
        }

        @Override // com.obric.matrix.push.m.g.d
        public void a(Bitmap r3) {
            com.obric.matrix.push.n.c.c.b("NotificationService", "showNotification onSuccess, style_type: " + this.f9732a.r + ", url: " + this.f9732a.o);
            d.d(this.f9733b, this.f9732a, this.f9734c, r3);
        }

        @Override // com.obric.matrix.push.m.g.d
        public void onFailed() {
            com.obric.matrix.push.n.c.c.b("NotificationService", "showNotification onFailed, style_type: " + this.f9732a.r + ", url: " + this.f9732a.o);
            d.d(this.f9733b, this.f9732a, this.f9734c, null);
        }
    }

    static {
        f9717j = new a(null);
    }

    public d() {
        this.f9718a = "push_tag";
        this.f9720c = 1;
        this.f9721d = 2;
        this.f9722e = 3;
        this.f9723f = 64;
        this.f9724g = 128;
        this.f9725h = 384;
        this.f9726i = 1024;
    }

    public static final /* synthetic */ void c(d r0, com.obric.matrix.push.g r1, Bitmap r2) {
        r0.r(r1, r2);
    }

    public static final /* synthetic */ void d(d r0, com.obric.matrix.push.g r1, Bitmap r2, Bitmap r3) {
        r0.s(r1, r2, r3);
    }

    public static final /* synthetic */ void e(d r0, e r1, Intent r2, Bitmap r3) {
        r0.t(r1, r2, r3);
    }

    private final PendingIntent f(Context r2, int r3, Intent r4) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r1 = 67108864;
    L11:
        return PendingIntent.getActivity(r2, r3, r4, r1);
    L8:
        th = move-exception;
        com.obric.matrix.push.n.c.c.d("NotificationService", "buildContentIntent failed", th);
        return null;
    L5:
        r1 = 134217728;
        goto L11
    }

    private final com.obric.matrix.push.m.g.g g(Context r2, String r3) {
        int r4 = n(r2);
        Uri r5 = Uri.parse(r3);
        o.e(r5, "parse(url)");
        return h(r5, r4, r4);
    }

    private final com.obric.matrix.push.m.g.g h(Uri r2, int r3, int r4) {
        return new com.obric.matrix.push.m.g.g(r2, kotlin.r0.e.c(r3, 1), kotlin.r0.e.c(r4, 1), Bitmap.Config.ARGB_8888);
    }

    private final com.obric.matrix.push.m.g.g i(Context r1, String r2, int r3) {
        int r4 = o(r1, r3);
        Uri r5 = Uri.parse(r2);
        o.e(r5, "parse(url)");
        return h(r5, r4, r4);
    }

    private final Bitmap j(Bitmap r1) {
        return r1;
    }

    private final int k(int r1, int r2, int r3) {
        return kotlin.r0.e.i(r1, r2, r3);
    }

    private final int l(Context r1, int r2) {
        return kotlin.r0.e.c((int) ((r2 * r1.getResources().getDisplayMetrics().density) + 0.5f), 1);
    }

    private final int m(Context r3) {
        return k(Math.min(q(r3), this.f9726i), 1, this.f9726i);
    }

    private final int n(Context r3) {
        return k(l(r3, this.f9723f), this.f9724g, this.f9725h);
    }

    private final int o(Context r2, int r3) {
        if (r3 != this.f9721d) goto L6;
        return m(r2);
    L6:
        return n(r2);
    }

    private final boolean p(Context r9, String r10) {
        boolean r2 = true;
        ApplicationInfo r11 = r9.getPackageManager().getApplicationInfo(r10, 0);     // Catch: Throwable -> L12
        o.e(r11, "context.getPackageManage…ationInfo(packageName, 0)");     // Catch: Throwable -> L12
        Object r12 = Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"notification"});     // Catch: Throwable -> L12
        if (r12 == null) goto L11;
        Object r13 = Class.forName("android.app.INotificationManager$Stub").getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{(IBinder) r12});     // Catch: Throwable -> L12
        Object r8 = r13.getClass().getMethod("areNotificationsEnabledForPackage", new Class[]{String.class, Integer.TYPE}).invoke(r13, new Object[]{r11.packageName, Integer.valueOf(r11.uid)});     // Catch: Throwable -> L12
        if (r8 == null) goto L9;
        r2 = ((Boolean) r8).booleanValue();     // Catch: Throwable -> L12
    L14:
        com.obric.matrix.push.n.c.c.b("NotificationService", "isNotificationsEnabledForPackage: " + r2);
        return r2;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.os.IBinder");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        com.obric.matrix.push.n.c.c.e("NotificationService", "isNotificationsEnabledForPackage error: " + th, null, 4, null);
        goto L14
    }

    private final int q(Context r1) {
        return r1.getResources().getDisplayMetrics().widthPixels;
    }

    private final void r(com.obric.matrix.push.g r7, Bitmap r8) {
        Integer r1 = r7.r;     // Catch: Throwable -> L17
        if (r1 != null) goto L7;
    L9:
        if (TextUtils.isEmpty(r7.o) == true) goto L15;
        Application r2 = com.bytedance.mpaas.app.a.b();     // Catch: Throwable -> L17
        Integer r3 = r7.r;     // Catch: Throwable -> L17
        if (r3 != null) goto L13;
        int r4 = this.f9719b;     // Catch: Throwable -> L17
    L14:
        com.obric.matrix.push.m.g.b r5 = com.obric.matrix.push.m.b.f9633a.a();     // Catch: Throwable -> L17
        o.e(r2, "context");     // Catch: Throwable -> L17
        String r6 = r7.o;     // Catch: Throwable -> L17
        o.e(r6, "push.url");     // Catch: Throwable -> L17
        r5.a(i(r2, r6, r4), true, new C0272d(r7, this, r8));     // Catch: Throwable -> L17
        return;
    L13:
        r4 = r3.intValue();     // Catch: Throwable -> L17
    L15:
        s(r7, r8, null);     // Catch: Throwable -> L17
        return;
    L7:
        if (r1.intValue() == 0) goto L15;
    L17:
        s(r7, r8, null);
    }

    @SuppressLint({"ServiceCast"})
    private final void s(com.obric.matrix.push.g r17, Bitmap r18, Bitmap r19) {
        Application r1 = com.bytedance.mpaas.app.a.b();     // Catch: Throwable -> L12
        int r10 = a.b(f9717j, r17);     // Catch: Throwable -> L12
        com.obric.matrix.push.m.k.c r2 = com.obric.matrix.push.m.k.c.f9716a;     // Catch: Throwable -> L12
        o.e(r1, "context");     // Catch: Throwable -> L12
        PendingIntent r11 = r2.a(r1, r10, r17);     // Catch: Throwable -> L12
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        return;
    L6:
        String r3 = r17.f9564f;     // Catch: Throwable -> L12
        o.e(r3, "push.id");     // Catch: Throwable -> L12
        String r4 = r17.f9565g;     // Catch: Throwable -> L12
        o.e(r4, "push.package_name");     // Catch: Throwable -> L12
        String r5 = r17.f9567i;     // Catch: Throwable -> L12
        String r6 = r17.f9566h;     // Catch: Throwable -> L12
        String r7 = r17.m;     // Catch: Throwable -> L12
        Integer r8 = r17.r;     // Catch: Throwable -> L12
        if (r8 != null) goto L9;
        int r9 = this.f9719b;     // Catch: Throwable -> L12
    L10:
        u(r3, r4, r5, r6, r7, r9, r17.o, r17.f9570l, r10, r11, r17.B, r18, r19, r17);     // Catch: Throwable -> L12
        return;
    L9:
        r9 = r8.intValue();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        com.obric.matrix.push.n.c.c.d("", "show notification error", th);
    }

    private final void t(e r23, Intent r24, Bitmap r25) {
        Application r2 = com.bytedance.mpaas.app.a.b();     // Catch: Throwable -> L8
        a r3 = f9717j;     // Catch: Throwable -> L8
        String r4 = r23.f9819a;     // Catch: Throwable -> L8
        o.e(r4, "notification.id");     // Catch: Throwable -> L8
        int r14 = a.a(r3, r4);     // Catch: Throwable -> L8
        o.e(r2, "context");     // Catch: Throwable -> L8
        PendingIntent r15 = f(r2, r14, r24);     // Catch: Throwable -> L8
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        return;
    L6:
        String r6 = r23.f9819a;     // Catch: Throwable -> L8
        o.e(r6, "notification.id");     // Catch: Throwable -> L8
        String r7 = r23.f9820b;     // Catch: Throwable -> L8
        o.e(r7, "notification.pkgName");     // Catch: Throwable -> L8
        v(this, r6, r7, r23.f9821c, r23.f9822d, r23.f9823e, r23.f9824f, r23.f9825g, r23.f9826h, r14, r15, null, null, r25, null, 8192, null);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        com.obric.matrix.push.n.c.c.d("", "show notification error", th);
    }

    private final void u(String r28, String r29, String r30, String r31, String r32, int r33, String r34, String r35, int r36, PendingIntent r37, Map<String, String> r38, Bitmap r39, Bitmap r40, com.obric.matrix.push.g r41) {
        Application r7 = com.bytedance.mpaas.app.a.b();
        o.e(r7, "context");
        if (p(r7, r29) == false) goto L5;
        int r8 = 4;
    L6:
        if (r30 != null) goto L10;
        String r11 = com.obric.matrix.push.r.g.f9796a.c(r7, r29);
        if (r11 != null) goto L11;
        r11 = "";
    L11:
        if (r31 != null) goto L13;
        String r12 = r29;
    L14:
        if (r39 != null) goto L16;
        Bitmap r9 = com.obric.matrix.push.r.g.f9796a.b(r7, r29);
    L17:
        j(r9);
        if (r40 != null) goto L20;
        Bitmap r13 = r9;
    L21:
        long r14 = System.currentTimeMillis();
        if (r33 != this.f9719b) goto L25;
    L26:
        boolean r0 = false;
    L27:
        r13 = null;
    L50:
        Class<?> r2 = Class.forName("android.app.SmtNotificationInfo");     // Catch: Exception -> L42 NoSuchMethodException -> L44 ClassNotFoundException -> L46
        Class<?> r16 = Integer.TYPE;     // Catch: Exception -> L42 NoSuchMethodException -> L44 ClassNotFoundException -> L46
        Class<?> r18 = Boolean.TYPE;     // Catch: Exception -> L42 NoSuchMethodException -> L44 ClassNotFoundException -> L46
        Constructor<?> r3 = r2.getConstructor(new Class[]{String.class, r16, r16, String.class, String.class, r18, PendingIntent.class, Bitmap.class, Bitmap.class, r18, Long.TYPE, r18, r18});     // Catch: Exception -> L42 NoSuchMethodException -> L44 ClassNotFoundException -> L46
        Boolean r1 = Boolean.TRUE;     // Catch: Exception -> L42 NoSuchMethodException -> L44 ClassNotFoundException -> L46
        Object r4 = r3.newInstance(new Object[]{r29, Integer.valueOf(r36), Integer.valueOf(r8), r11, r12, r1, r37, r9, r13, Boolean.valueOf(r0), Long.valueOf(r14), r1, Boolean.FALSE});     // Catch: Exception -> L42 NoSuchMethodException -> L44 ClassNotFoundException -> L46
        Object r5 = Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"notification"});     // Catch: Exception -> L42 NoSuchMethodException -> L44 ClassNotFoundException -> L46
        Object r6 = Class.forName("android.app.INotificationManager").getMethod("getISmtEx", new Class[0]).invoke(Class.forName("android.app.INotificationManager$Stub").getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r5}), new Object[0]);     // Catch: Exception -> L42 NoSuchMethodException -> L44 ClassNotFoundException -> L46
        Class<?> r10 = Class.forName("android.app.INotificationManagerSmtEx");     // Catch: Exception -> L42 NoSuchMethodException -> L44 ClassNotFoundException -> L46
        Object r15 = Class.forName("android.os.UserHandle").getMethod("getCallingUserId", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L42 NoSuchMethodException -> L44 ClassNotFoundException -> L46
        if (r15 == null) goto L41;
        int r17 = ((Integer) r15).intValue();     // Catch: Exception -> L42 NoSuchMethodException -> L44 ClassNotFoundException -> L46
        r10.getMethod("notifySmtNotification", new Class[]{Class.forName("android.app.SmtNotificationInfo"), r16}).invoke(r6, new Object[]{r4, Integer.valueOf(r17)});     // Catch: Exception -> L42 NoSuchMethodException -> L44 ClassNotFoundException -> L46
        if (r41 == null) goto L51;
        com.obric.matrix.push.m.k.c.f9716a.c(r41);     // Catch: Exception -> L42 NoSuchMethodException -> L44 ClassNotFoundException -> L46
        return;
    L51:
        return;
    L41:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L42 NoSuchMethodException -> L44 ClassNotFoundException -> L46
    L46:
        e = e;
        String r19 = "Class can't find。";
    L48:
        com.obric.matrix.push.n.c.c.d("NotificationService", r19, e);
        return;
    L44:
        e = e;
        r19 = "Method can't find。";
    L42:
        e = move-exception;
        e.printStackTrace();
        return;
    L25:
        if (r33 == this.f9720c) goto L26;
        if (r33 != this.f9721d) goto L32;
        r0 = false;
        r9 = null;
        goto L50
    L32:
        if (r33 != this.f9722e) goto L34;
        r9 = r13;
        r0 = true;
        goto L27
    L34:
        r0 = false;
        r9 = null;
        goto L27
    L20:
        r13 = r40;
        goto L21
    L16:
        r9 = r39;
        goto L17
    L13:
        r12 = r31;
        goto L14
    L10:
        r11 = r30;
        goto L11
    L5:
        r8 = 0;
        goto L6
    }

    static /* synthetic */ void v(d r16, String r17, String r18, String r19, String r20, String r21, int r22, String r23, String r24, int r25, PendingIntent r26, Map r27, Bitmap r28, Bitmap r29, com.obric.matrix.push.g r30, int r31, Object r32) {
        if ((r31 & 8192) == 0) goto L5;
        com.obric.matrix.push.g r15 = null;
    L6:
        r16.u(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r15);
        return;
    L5:
        r15 = r30;
        goto L6
    }

    @Override // com.obric.matrix.push.m.k.a
    public void a(com.obric.matrix.push.g r6) {
        o.f(r6, "push");
        if (TextUtils.isEmpty(r6.f9564f) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r6.f9565g) == false) goto L16;
        return;
    L16:
    L13:
        r(r6, null);
        return;
    L9:
        if (TextUtils.isEmpty(r6.F) == true) goto L11;
        Application r1 = com.bytedance.mpaas.app.a.b();     // Catch: Throwable -> L13
        com.obric.matrix.push.m.g.b r2 = com.obric.matrix.push.m.b.f9633a.a();     // Catch: Throwable -> L13
        o.e(r1, "context");     // Catch: Throwable -> L13
        String r3 = r6.F;     // Catch: Throwable -> L13
        o.e(r3, "push.icon_url");     // Catch: Throwable -> L13
        r2.a(g(r1, r3), true, new b(this, r6));     // Catch: Throwable -> L13
    L15:
        return;
    L11:
        r(r6, null);     // Catch: Throwable -> L13
        goto L15
    }

    @Override // com.obric.matrix.push.m.k.a
    public void b(k r5) {
        o.f(r5, "revoke");
        a r0 = f9717j;
        String r1 = r5.f9615i;
        o.e(r1, "revoke.revoke_id");
        int r2 = a.a(r0, r1);
        com.obric.matrix.push.n.c.c.b("NotificationService", "cancelNotification: notificationId: " + r2 + ", revoke: " + r5);
        f r6 = f.f9940a;     // Catch: Exception -> L12
        Object r7 = com.bytedance.mpaas.app.a.b().getSystemService("notification");     // Catch: Exception -> L12
        if (r7 != null) goto L7;
    L5:
        r7 = null;
    L8:
        NotificationManager r8 = (NotificationManager) r7;     // Catch: Exception -> L12
        if (r8 == null) goto L17;
        r8.cancel(this.f9718a, r2);     // Catch: Exception -> L12
        return;
    L17:
        return;
    L7:
        if ((r7 instanceof NotificationManager) == false) goto L5;
    L12:
        e = move-exception;
        com.obric.matrix.push.n.c.c.d("NotificationService", "cancelNotification, failed", e);
    }

    @Override // com.obric.matrix.push.m.k.a
    public void showNotification(e r5, Intent r6) {
        o.f(r5, "notification");
        o.f(r6, "intent");
        if (TextUtils.isEmpty(r5.f9819a) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5.f9820b) == false) goto L8;
        return;
    L8:
        if (r5.f9824f != 0) goto L10;
    L12:
        t(r5, r6, null);
        return;
    L10:
        if (TextUtils.isEmpty(r5.f9825g) == true) goto L12;
        Application r0 = com.bytedance.mpaas.app.a.b();
        com.obric.matrix.push.m.g.b r1 = com.obric.matrix.push.m.b.f9633a.a();
        o.e(r0, "context");
        String r2 = r5.f9825g;
        o.e(r2, "notification.url");
        r1.a(i(r0, r2, r5.f9824f), true, new c(this, r5, r6));
    }
}
