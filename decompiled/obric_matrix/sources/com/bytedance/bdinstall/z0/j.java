package com.bytedance.bdinstall.z0;

import android.os.Environment;
import com.bytedance.bdinstall.i0;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class j implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i0 f2921f;

    public j(i0 r1) {
        this.f2921f = r1;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList r1 = new ArrayList();
        if (this.f2921f.M() == false) goto L6;
        String r2 = WsConstants.KEY_DEVICE_ID;
    L7:
        r1.add(this.f2921f.t().getExternalCacheDir().getParent() + "/" + r2);     // Catch: Throwable -> L19
        goto L9
    L6:
        r2 = com.bytedance.bdinstall.d1.o.d();     // Catch: Throwable -> L19
    L9:
        if (this.f2921f.M() == false) goto L23;
    L12:
        Iterator r5 = r1.iterator();
    L14:
        if (r5.hasNext() == false) goto L18;
        String r0 = (String) r5.next();
        com.bytedance.common.utility.n.b.c(r0);     // Catch: Throwable -> L21
        com.bytedance.bdinstall.q.g("dt " + r0);     // Catch: Throwable -> L21
        goto L14
    L18:
        return;
    L23:
        r1.add(Environment.getExternalStorageDirectory().getPath() + com.bytedance.bdinstall.d1.o.a("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U="));     // Catch: Throwable -> L22
    L25:
        r1.add(Environment.getExternalStorageDirectory().getPath() + "/" + com.bytedance.bdinstall.d1.o.d());     // Catch: Throwable -> L20
        goto L12
    }
}
