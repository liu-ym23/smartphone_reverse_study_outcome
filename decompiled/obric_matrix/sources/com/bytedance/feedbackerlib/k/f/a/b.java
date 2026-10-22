package com.bytedance.feedbackerlib.k.f.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.FileProvider;
import androidx.core.os.EnvironmentCompat;
import androidx.fragment.app.Fragment;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<Activity> f4247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference<Fragment> f4248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.feedbackerlib.matisse.internal.entity.a f4249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f4250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4251e;

    public b(Activity r2) {
        this.f4247a = new WeakReference(r2);
        this.f4248b = null;
    }

    private File a() {
        String r0 = String.format("JPEG_%s.jpg", new Object[]{new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date())});
        if (this.f4249c.f4339a == false) goto L7;
        File r1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (r1.exists() == true) goto L9;
        r1.mkdirs();
    L9:
        if (this.f4249c.f4341c == null) goto L14;
        File r2 = new File(r1, this.f4249c.f4341c);
        if (r2.exists() == true) goto L13;
        r2.mkdirs();
    L13:
        r1 = r2;
    L14:
        File r3 = new File(r1, r0);
        if ("mounted".equals(EnvironmentCompat.getStorageState(r3)) == true) goto L18;
        return null;
    L18:
        return r3;
    L7:
        r1 = this.f4247a.get().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        goto L9
    }

    public static boolean e(Context r1) {
        return r1.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.camera");
    }

    public void b(Context r6, int r7) {
        Intent r0 = new Intent("android.media.action.IMAGE_CAPTURE");
        if (r0.resolveActivity(r6.getPackageManager()) == null) goto L27;
        File r1 = null;
        r1 = a();     // Catch: IOException -> L7
    L9:
        if (r1 == null) goto L28;
        this.f4251e = r1.getAbsolutePath();
        Uri r2 = FileProvider.getUriForFile(this.f4247a.get(), this.f4249c.f4340b, r1);
        this.f4250d = r2;
        r0.putExtra("output", r2);
        r0.addFlags(2);
        if (Build.VERSION.SDK_INT >= 21) goto L23;
        Iterator<ResolveInfo> r3 = r6.getPackageManager().queryIntentActivities(r0, 65536).iterator();
    L14:
        if (r3.hasNext() == false) goto L23;
        r6.grantUriPermission(r3.next().activityInfo.packageName, this.f4250d, 3);
    L23:
        WeakReference<Fragment> r8 = this.f4248b;     // Catch: Throwable -> L21
        if (r8 == null) goto L19;
        r8.get().startActivityForResult(r0, r7);     // Catch: Throwable -> L21
    L22:
        return;
    L19:
        this.f4247a.get().startActivityForResult(r0, r7);     // Catch: Throwable -> L21
    L29:
        return;
    L28:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public String c() {
        return this.f4251e;
    }

    public Uri d() {
        return this.f4250d;
    }

    public void f(com.bytedance.feedbackerlib.matisse.internal.entity.a r1) {
    }
}
