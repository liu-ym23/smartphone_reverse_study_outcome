package com.obric.matrix;

import java.io.File;
import java.io.FileWriter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/obric/matrix/TestSafeLaunch;", "", "()V", "checkStartCrash", "", "mockCrashCondition", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f9232a = null;

    static {
        f9232a = new o();
    }

    private o() {
    }

    public final void a() {
        if (new File(com.bytedance.mpaas.app.a.f5245g.getFilesDir().getPath() + "/test44.txt").exists() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("start crash by test.txt");
    }

    public final void b() {
        File r2 = new File(com.bytedance.mpaas.app.a.f5245g.getFilesDir().getPath() + "/test5.txt");
        if (r2.exists() == false) goto L5;
        r2.createNewFile();
    L5:
        FileWriter r0 = new FileWriter(r2);
        r0.append("hello ");
        r0.flush();
        r0.close();
    }
}
