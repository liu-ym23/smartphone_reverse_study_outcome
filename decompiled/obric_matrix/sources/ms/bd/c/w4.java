package ms.bd.c;

import android.annotation.SuppressLint;
import android.hardware.display.DisplayManager;
import android.text.TextUtils;
import android.view.Display;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public class w4 implements DisplayManager.DisplayListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DisplayManager f22540a;

    public w4(DisplayManager r1) {
        this.f22540a = r1;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int r4) {
        Display[] r3 = this.f22540a.getDisplays();     // Catch: Exception -> L12
        int r5 = r3.length;     // Catch: Exception -> L12
        if (r5 <= 0) goto L15;
        x4 r0 = x4.c();     // Catch: Exception -> L12
        String r1 = r0.h(r3);     // Catch: Exception -> L12
        String r6 = r0.b(r3);     // Catch: Exception -> L12
        r0.d(r5);     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r1) == true) goto L8;
        r0.k(r1);     // Catch: Exception -> L12
    L8:
        if (TextUtils.isEmpty(r6) == true) goto L10;
        r0.f(r6);     // Catch: Exception -> L12
    L10:
        r0.e(System.currentTimeMillis() / 1000);     // Catch: Exception -> L12
        return;
    L15:
        return;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int r1) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int r4) {
        Display[] r3 = this.f22540a.getDisplays();     // Catch: Exception -> L12
        int r5 = r3.length;     // Catch: Exception -> L12
        if (r5 <= 0) goto L15;
        x4 r0 = x4.c();     // Catch: Exception -> L12
        String r1 = r0.h(r3);     // Catch: Exception -> L12
        String r6 = r0.b(r3);     // Catch: Exception -> L12
        r0.d(r5);     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r1) == true) goto L8;
        r0.k(r1);     // Catch: Exception -> L12
    L8:
        if (TextUtils.isEmpty(r6) == true) goto L10;
        r0.f(r6);     // Catch: Exception -> L12
    L10:
        r0.j(System.currentTimeMillis() / 1000);     // Catch: Exception -> L12
        return;
    L15:
        return;
    }
}
