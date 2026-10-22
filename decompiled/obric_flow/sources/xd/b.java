package xd;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import com.bytedance.ies.bullet.core.e;
import com.bytedance.ies.bullet.ui.common.BulletCardView;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public class b extends ContentObserver {
    public static final String[] e = null;
    public static final String[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f23099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f23100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f23101c;
    public int d;

    static {
        e = new String[]{"tmp.png"};
        f = new String[]{"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "截屏", "截屏录屏"};
    }

    public b(Context r5, Uri r10) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r5, "appContext");
        super(null);
        this.f23099a = r10;
        this.f23100b = r5;
        this.f23101c = Long.MIN_VALUE;
        this.d = -1;
    }

    public void a() {
        this.f23101c = System.currentTimeMillis();
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;
        Cursor r10 = null;
        String r11 = "";
        com.bytedance.ies.bullet.service.base.b.h("onUserCaptureScreen ScreenCaptureObserver.onChange, timestamp=" + this.f23101c, null, null, "", 110);
        Context r12 = this.f23100b;
        ArrayList r13 = new ArrayList();
        Uri r14 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver r15 = r12.getContentResolver();     // Catch: Throwable -> L37
        String[] r16 = kb.a.f18627a;     // Catch: Throwable -> L37
        Bundle r17 = new Bundle();     // Catch: Throwable -> L37
        r17.putString("android:query-arg-sql-selection", null);     // Catch: Throwable -> L37
        r17.putStringArray("android:query-arg-sql-selection-args", null);     // Catch: Throwable -> L37
        r17.putString("android:query-arg-sql-sort-order", "_id DESC");     // Catch: Throwable -> L37
        Cursor r18 = r15.query(r14, r16, r17, null);     // Catch: Throwable -> L37
        if (r18 != null) goto L42;
        if (r18 == null) goto L7;
        r18.close();
    L7:
        String r19 = "";
        ArrayList r20 = r13;
    L26:
        com.bytedance.ies.bullet.service.base.b.h("onUserCaptureScreen ScreenCaptureObserver.onChange，imageCount=" + this.d + ", images.size=" + r20.size(), null, null, r19, 110);
        if (this.d < r20.size()) goto L30;
        this.d = r20.size();
        return;
    L30:
        this.d = r20.size();
        kb.b r21 = (kb.b) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(r20, new org.threeten.bp.format.c(5)));
        if (r21 == null) goto L50;
        String r22 = r21.f18633j;
        if (r22 == null) goto L49;
        b(r22, r21.d);
        return;
    L49:
        return;
    L50:
        return;
    L42:
        int r23 = r18.getColumnIndexOrThrow("_id");     // Catch: Throwable -> L17
        int r24 = r18.getColumnIndexOrThrow("_display_name");     // Catch: Throwable -> L17
        int r25 = r18.getColumnIndexOrThrow("date_modified");     // Catch: Throwable -> L17
        int r110 = r18.getColumnIndexOrThrow("date_added");     // Catch: Throwable -> L17
        int r111 = r18.getColumnIndexOrThrow("mime_type");     // Catch: Throwable -> L17
        int r112 = r18.getColumnIndexOrThrow("_size");     // Catch: Throwable -> L17
        int r113 = r18.getColumnIndexOrThrow("width");     // Catch: Throwable -> L17
        int r114 = r18.getColumnIndexOrThrow("height");     // Catch: Throwable -> L17
        int r115 = r18.getColumnIndexOrThrow("datetaken");     // Catch: Throwable -> L17
        int r26 = r18.getColumnIndexOrThrow("orientation");     // Catch: Throwable -> L17
        int r27 = r18.getColumnIndexOrThrow(LynxEventReporter.PROP_NAME_RELATIVE_PATH);     // Catch: Throwable -> L17
        int r28 = r18.getColumnIndexOrThrow("_data");     // Catch: Throwable -> L17
        ArrayList r116 = r13;
        StringBuilder r29 = new StringBuilder();     // Catch: Throwable -> L17
        Uri r117 = r14;
        r29.append(Environment.getExternalStorageDirectory().getPath());     // Catch: Throwable -> L17
        r29.append("/");     // Catch: Throwable -> L17
        int r30 = r29.toString().length();     // Catch: Throwable -> L17
    L9:
        if (r18.moveToNext() == false) goto L25;
        kb.b r31 = new kb.b();     // Catch: Throwable -> L17
        String r118 = r11;
        int r119 = r27;
        long r32 = r18.getLong(r23);     // Catch: Throwable -> L17
        r31.f18628a = r32;     // Catch: Throwable -> L17
        int r210 = r23;
        r31.f18629b = r18.getString(r24);     // Catch: Throwable -> L17
        int r211 = r24;
        r31.f18630c = r18.getLong(r25);     // Catch: Throwable -> L17
        r31.d = r18.getLong(r110);     // Catch: Throwable -> L17
        r31.e = r18.getString(r111);     // Catch: Throwable -> L17
        r31.f = r18.getLong(r112);     // Catch: Throwable -> L17
        r31.g = r18.getInt(r113);     // Catch: Throwable -> L17
        r31.f18631h = r18.getInt(r114);     // Catch: Throwable -> L17
        r31.f18634k = r18.getLong(r115);     // Catch: Throwable -> L17
        r31.f18635l = r18.getInt(r26);     // Catch: Throwable -> L17
        String r33 = r18.getString(r119);     // Catch: Throwable -> L17
        if (r33 != null) goto L21;
        int r120 = r26;
        String r34 = r18.getString(r28);     // Catch: Throwable -> L17
        int r212 = r28;
        String r35 = File.separator;     // Catch: Throwable -> L17
        int r213 = r119;
        String r36 = r34.substring(r30, r34.lastIndexOf(r35)) + r35;     // Catch: Throwable -> L17 IndexOutOfBoundsException -> L19
        String r37 = r118;
    L23:
        r31.f18633j = r36;     // Catch: Throwable -> L17
        Uri r38 = r117;
        r31.f18632i = ContentUris.withAppendedId(r38, r32);     // Catch: Throwable -> L17
        ArrayList r39 = r116;
        r39.add(r31);     // Catch: Throwable -> L17
        r117 = r38;
        r116 = r39;
        r26 = r120;
        r23 = r210;
        r24 = r211;
        r27 = r213;
        r11 = r37;
        r28 = r212;
        goto L9
    L19:
        r37 = r118;
        r31.f18633j = r37;     // Catch: Throwable -> L17
    L22:
        r36 = r33;
        goto L23
    L21:
        r212 = r28;
        r120 = r26;
        r213 = r119;
        r37 = r118;
        goto L22
    L25:
        r19 = r11;
        r20 = r116;
        r18.close();
    L17:
        th = th;
        r10 = r18;
    L39:
        if (r10 == null) goto L41;
        r10.close();
    L41:
        throw th;
    L37:
        th = th;
        goto L39
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "relativePath");
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;
        StringBuilder r12 = new StringBuilder("onUserCaptureScreen ScreenCaptureObserver.dispatchScreenCapture, timestamp=");
        long r13 = 1000;
        r12.append(this.f23101c / r13);
        r12.append(", dateAdded=");
        r12.append(r11);
        com.bytedance.ies.bullet.service.base.b.h(r12.toString(), null, null, "", 110);
        long r14 = this.f23101c - (r11 * r13);
        boolean r15 = false;
        if (r14 >= 5000) goto L5;
        boolean r16 = 1;
    L6:
        Locale r17 = Locale.ROOT;
        if (r10 == null) goto L41;
        String r18 = r10.toLowerCase(r17);
        String[] r19 = f;
        int r20 = 0;
    L10:
        if (r20 >= 14) goto L15;
        if (StringsKt.g(r18, r19[r20]) == true) goto L13;
        r20 = r20 + 1;
    L13:
        r15 = true;
    L24:
        com.bytedance.ies.bullet.service.base.b.h("onUserCaptureScreen ScreenCaptureObserver.dispatchScreenCapture, matchDateAdded=" + r16 + ", matchPath=" + r15, null, null, "", 110);
        int r21 = r16 ^ 1;
        if (r15 == true) goto L27;
        r21 = r21 | 2;
    L27:
        Iterator r22 = c.d.iterator();
    L29:
        if (r22.hasNext() == false) goto L39;
        com.bytedance.ies.bullet.ui.common.b r110 = (com.bytedance.ies.bullet.ui.common.b) ((WeakReference) r22.next()).get();
        if (r110 == null) goto L29;
        boolean r111 = com.bytedance.ies.bullet.service.base.b.f5956a;
        String r112 = com.lynx.jsbridge.a.d(r21, "onUserCaptureScreen onCapture, responseType=");
        BulletCardView r113 = r110.f6198a;
        e r23 = r113.d;
        if (r23 == null) goto L35;
        String r24 = r23.getSessionId();
    L36:
        com.bytedance.ies.bullet.service.base.b.h(r112, null, null, r24, 110);
        if (r21 != 0) goto L29;
        new Handler(Looper.getMainLooper()).post(new a6.a(r113, 22));
        goto L29
    L35:
        r24 = null;
        goto L36
    L39:
        return;
    L15:
        int r25 = com.bytedance.common.utility.a.f3952a;
        String r26 = Build.MANUFACTURER;
        if (r26 == null) goto L24;
        if (r26.toUpperCase(Locale.getDefault()).contains("HUAWEI") == false) goto L24;
        if (StringsKt.g(r10, "/dcim/camera/") == false) goto L24;
        if (StringsKt.g(r18, e[0]) == false) goto L24;
    L41:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L5:
        r16 = 0;
        goto L6
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r5, Uri r10, int r11) {
        if (c.e.get() == false) goto L5;
        return;
    L5:
        ConcurrentHashMap r12 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r13 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        boolean r14 = true;
        if (r13 == null) goto L12;
        xc.d r15 = (xc.d) r13.a(xc.d.class);
        if (r15 == null) goto L12;
        Boolean r16 = r15.l();
        if (r16 == null) goto L12;
        boolean r17 = r16.booleanValue();
    L13:
        if (r17 == true) goto L15;
    L21:
        a();
        return;
    L15:
        if ((r11 & 4) == 4) goto L18;
        r14 = false;
    L18:
        if (r14 == true) goto L21;
        boolean r18 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.h("onUserCaptureScreen ScreenCaptureObserver.onChange, uri=" + r10 + ", flags=" + r11, null, null, "", 110);
        return;
    L12:
        r17 = true;
        goto L13
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r5) {
        onChange(r5, null, 4);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r5, Uri r10) {
        onChange(r5, r10, 4);
    }
}
