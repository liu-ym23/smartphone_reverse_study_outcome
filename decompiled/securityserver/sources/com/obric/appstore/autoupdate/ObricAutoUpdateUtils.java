package com.obric.appstore.autoupdate;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.Pair;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.alert.OViewStyleController;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(3)
public class ObricAutoUpdateUtils {
    public static final Uri b = null;
    public static ObricAutoUpdateUtils c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AutoUpdateTask f94a;

    public class AutoUpdateTask extends AsyncTask<String, Void, Bundle> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f95a;
        public final /* synthetic */ ObricAutoUpdateUtils b;

        public AutoUpdateTask(ObricAutoUpdateUtils r1, Context r2) {
            this.b = r1;
            this.f95a = new WeakReference(r2);
        }

        @Override // android.os.AsyncTask
        public final Bundle doInBackground(String[] r6) {
            String[] r7 = r6;
            boolean r0 = false;
            if (TextUtils.isEmpty(r7[0]) == false) goto L5;
            Log.i("AutoUpdateUtils", "pkg is null");
            return null;
        L5:
            Bundle r1 = new Bundle();
            r1.putString("auto_update_pkg", r7[0]);
            Context r8 = (Context) this.f95a.get();
            if (r8 == null) goto L17;
            Context r4 = r8.getApplicationContext();
            this.b.getClass();
            ConnectivityManager r5 = (ConnectivityManager) r4.getSystemService("connectivity");
            if (r5 == null) goto L14;
            NetworkInfo r9 = r5.getActiveNetworkInfo();
            if (r9 == null) goto L14;
            r0 = r9.isConnected();
        L14:
            if (r0 == false) goto L17;
            Bundle r2 = ObricAutoUpdateUtils.a(r8, "checkAppUpdate", r1);
            Log.i("AutoUpdateUtils", "AutoUpdateTask: " + r2);
            return r2;
        L17:
            Log.i("AutoUpdateUtils", "network is not available.");
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v11, types: [com.obric.appstore.autoupdate.a] */
        @Override // android.os.AsyncTask
        public final void onPostExecute(Bundle r12) {
            Bundle r13 = r12;
            if (isCancelled() == true) goto L66;
            if (r13 == null) goto L66;
            if (r13.isEmpty() == true) goto L66;
            Context r11 = (Context) this.f95a.get();
            if (r11 != null) goto L12;
            Log.i("AutoUpdateUtils", "activity is null");
            return;
        L12:
            if ((r11 instanceof Activity) == false) goto L22;
            Activity r1 = (Activity) r11;
            if (r1.isFinishing() == false) goto L17;
            Log.i("AutoUpdateUtils", "context is null.");
            return;
        L17:
            if (r1.getWindow() != null) goto L20;
            Log.i("AutoUpdateUtils", "window is null.");
            return;
        L20:
            if (r1.isDestroyed() == false) goto L22;
            Log.i("AutoUpdateUtils", "activity is destroyed.");
            return;
        L22:
            final FindNewVersionDialog r2 = new FindNewVersionDialog();
            r2.b = null;
            r2.c = 0;
            r2.f93d = null;
            r2.e = false;
            r2.f = false;
            r2.f92a = r11;
            String r4 = r13.getString("auto_update_pkg");
            r2.b = r4;
            r2.c = r13.getInt("auto_update_model");
            r2.g = r13;
            r2.f = r13.getBoolean("auto_update_file_exist");
            PackageManager r14 = r11.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L26
            ApplicationInfo r5 = r14.getApplicationInfo(r4, 0);     // Catch: PackageManager.NameNotFoundException -> L26
            if (r5 != null) goto L28;
            Log.d("FindNewVersionDialog", "ApplicationInfo is null.");     // Catch: PackageManager.NameNotFoundException -> L26
            Pair r6 = null;
        L42:
            if (r6 == null) goto L57;
            F r15 = r6.first;
            if (r15 == 0) goto L57;
            if (r6.second == 0) goto L57;
            r2.f93d = (String) r15;
            String r16 = r11.getString(com.bytedance.securityserver.R.string.auto_update_title) + " " + r2.g.getString("auto_update_version_name");
            OAlertDialogBuilder r7 = new OAlertDialogBuilder(r11);
            Drawable r8 = (Drawable) r6.second;
            Intrinsics.f(r8, "drawable");
            r7.h = r8;
            int r9 = OUnitExtensionKt.a(56);
            int r10 = OUnitExtensionKt.a(56);
            r7.i = Integer.valueOf(r9);
            r7.j = Integer.valueOf(r10);
            r7.g = false;
            r7.e = r16;
            r7.v = new OViewStyleController(new a(r2));
            final int r17 = 0;
            DialogInterface.OnClickListener r18 = new b(r2, r17);
            String r19 = r11.getString(com.bytedance.securityserver.R.string.auto_update_ok);
            Intrinsics.e(r19, "context.getString(text)");
            r7.o = r19;
            r7.p = r18;
            r7.q = null;
            int r110 = r2.c;
            if (r110 != 2) goto L51;
            int r20 = android.R.string.cancel;
        L52:
            final int r111 = 1;
            DialogInterface.OnClickListener r21 = new b(r2, r111);
            String r22 = r11.getString(r20);
            Intrinsics.e(r22, "context.getString(text)");
            r7.r = r22;
            r7.s = r21;
            r7.t = null;
            r7.k = 1;
            if (r2.f == true) goto L56;
            if (r110 == 2) goto L56;
            final int r23 = 2;
            DialogInterface.OnClickListener r24 = new b(r2, r23);
            String r112 = r11.getString(com.bytedance.securityserver.R.string.obric_auto_update_ignore);
            Intrinsics.e(r112, "context.getString(text)");
            r7.l = r112;
            r7.m = r24;
            r7.n = null;
        L56:
            OAlertDialog r113 = r7.a();
            r2.h = r113;
            r113.setCanceledOnTouchOutside(true);
            r2.h.setCancelable(false);
            Log.d("FindNewVersionDialog", "onCreate:" + r4 + "|" + r110);
        L70:
        L61:
            e = move-exception;
            Log.e("FindNewVersionDialog", "show: ", e);
            return;
        L59:
            if ((r2.f92a instanceof Activity) == true) goto L63;
            r2.h.getWindow().setType(2038);     // Catch: Exception -> L61
        L63:
            r2.h.show();     // Catch: Exception -> L61
            return;
        L51:
            r20 = com.bytedance.securityserver.R.string.auto_update_cancel;
        L57:
            Log.e("FindNewVersionDialog", "loadLableAndIcon:pair is null. appPkgName = " + r4);
            goto L70
        L28:
            String r25 = r5.loadLabel(r14).toString();     // Catch: PackageManager.NameNotFoundException -> L26
            if (r25 != null) goto L68;
            Log.d("FindNewVersionDialog", "getLogoDrawable:name is null");     // Catch: PackageManager.NameNotFoundException -> L26
            r25 = null;
        L68:
            Drawable r114 = r5.loadIcon(r14);     // Catch: PackageManager.NameNotFoundException -> L38
            if (r114 != null) goto L41;
            Log.d("FindNewVersionDialog", "getLogoDrawable:drawable is null");     // Catch: PackageManager.NameNotFoundException -> L38
        L40:
            r114 = null;
        L41:
            r6 = new Pair(r25, r114);
        L38:
            e = e;
        L39:
            Log.d("FindNewVersionDialog", "getLogoDrawable:" + e.getMessage());
        L26:
            e = e;
            r25 = null;
        L66:
            Log.i("AutoUpdateUtils", "app update info is null.");
        }
    }

    static {
        b = Uri.parse("content://com.bytedanceos.appstore.auto_update");
        c = null;
    }

    public static Bundle a(Context r3, String r4, Bundle r5) {
        ContentProviderClient r0 = null;
        if (r3 != null) goto L33;
        return null;
    L33:
        ContentProviderClient r6 = r3.getContentResolver().acquireUnstableContentProviderClient(b);     // Catch: Throwable -> L19 RemoteException -> L21
        if (r6 != null) goto L10;
        if (r6 == null) goto L9;
        r6.close();
    L9:
        return null;
    L10:
        if (r5 == null) goto L30;
    L16:
        r5.putInt("client_ver", 1);     // Catch: Throwable -> L12 RemoteException -> L14
        Bundle r7 = r6.call(r4, null, r5);     // Catch: Throwable -> L12 RemoteException -> L14
        r6.close();
        return r7;
    L14:
        e = e;
    L23:
        e.printStackTrace();     // Catch: Throwable -> L12
        if (r6 == null) goto L26;
        r6.close();
    L26:
        return null;
    L12:
        th = th;
        r0 = r6;
    L27:
        if (r0 == null) goto L29;
        r0.close();
    L29:
        throw th;
    L30:
        r5 = new Bundle();     // Catch: Throwable -> L12 RemoteException -> L14
        goto L16
    L21:
        e = e;
        r6 = null;
    L19:
        th = th;
        goto L27
    }

    public static ObricAutoUpdateUtils b() {
        if (c != null) goto L6;
        c = new ObricAutoUpdateUtils();
    L6:
        return c;
    }

    public final void c(Activity r3, String r4) {
        AutoUpdateTask r0 = this.f94a;
        if (r0 == null) goto L5;
        r0.cancel(true);
    L5:
        AutoUpdateTask r1 = new AutoUpdateTask(this, r3);
        this.f94a = r1;
        r1.execute(new String[]{r4});
    }
}
