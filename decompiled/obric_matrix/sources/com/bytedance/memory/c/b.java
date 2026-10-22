package com.bytedance.memory.c;

import android.content.Context;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.apm.d;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile b f5002h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f5003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f5004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f5005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f5006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f5007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final File f5008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f5009g;

    private b(@NonNull Context r7) {
        String r0 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + r7.getPackageName();
        this.f5009g = r0;
        String r1 = d.i();
        if (r1 == null) goto L5;
        this.f5007e = new File(r0 + "/memorywidgets", r1);
        this.f5008f = new File(r0 + "/memory", r1);
    L7:
        if (this.f5007e.exists() == true) goto L10;
        this.f5007e.mkdirs();
    L10:
        if (this.f5008f.exists() == true) goto L12;
        this.f5008f.mkdirs();
    L12:
        File r8 = new File(this.f5007e, LocationMonitorConst.CACHE);
        this.f5005c = r8;
        if (r8.exists() == true) goto L15;
        r8.mkdirs();
    L15:
        this.f5003a = new File(this.f5007e, "festival.jpg");
        this.f5004b = new File(this.f5007e, "festival.jpg.heap");
        File r9 = new File(this.f5007e, "shrink");
        this.f5006d = r9;
        if (r9.exists() == true) goto L18;
        r9.mkdirs();
    L18:
        a();
        return;
    L5:
        this.f5007e = new File(r0 + "/memorywidgets", r7.getPackageName());
        this.f5008f = new File(r0 + "/memory", r7.getPackageName());
        goto L7
    }

    private void a() {
        com.bytedance.memory.b.d.a(new File(this.f5009g, "memorywidget"));     // Catch: Exception -> L4
        return;
    }

    public static b d() {
        if (f5002h != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5002h != null) goto L9;
        f5002h = new b(com.bytedance.memory.a.a.l().j());     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f5002h;
    }

    public void b() {
        if (this.f5003a.exists() == false) goto L6;
        this.f5003a.delete();
        return;
    }

    public File c() {
        return this.f5005c;
    }

    public File e() {
        return this.f5008f;
    }

    public File f() {
        return this.f5003a;
    }

    public File g() {
        return this.f5004b;
    }

    public File h() {
        return this.f5006d;
    }

    public File i() {
        return this.f5007e;
    }

    @Nullable
    public File j() {
        return this.f5003a;
    }

    public boolean k() {
        return new File(this.f5007e, "festival.jpg.heap").exists();
    }
}
