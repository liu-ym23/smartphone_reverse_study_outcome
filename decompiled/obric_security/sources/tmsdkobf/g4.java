package tmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import tmsdk.fg.module.spacemanager.FileScanSizeRange;
import tmsdk.fg.module.spacemanager.impl.duplicatefile.DuplicateFileGroup;
import tmsdk.fg.module.spacemanager.impl.duplicatefile.DuplicateFileScanner;
import tmsdk.fg.module.spacemanager.impl.duplicatefile.IDuplicateFileScanListener;

/* JADX INFO: loaded from: classes5.dex */
public class g4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile IDuplicateFileScanListener f209a;
    private volatile DuplicateFileScanner b;
    private volatile List c;
    private volatile String d;
    private volatile FileScanSizeRange e;
    private volatile List f;
    private final Handler g;
    private final AtomicBoolean h;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g4 f210a;

        a(g4 r1) {
            this.f210a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g4.m2385$$Nest$fgeta(this.f210a) == null) goto L6;
            g4.m2385$$Nest$fgeta(this.f210a).onStart();
            return;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f211a;
        final /* synthetic */ DuplicateFileGroup[] b;
        final /* synthetic */ g4 c;

        b(g4 r1, int r2, DuplicateFileGroup[] r3) {
            this.c = r1;
            this.f211a = r2;
            this.b = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g4.m2385$$Nest$fgeta(this.c) == null) goto L6;
            g4.m2385$$Nest$fgeta(this.c).onFinish(this.f211a, this.b);
            g4.m2386$$Nest$fputa(this.c, null);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgeta, reason: not valid java name */
    static /* bridge */ /* synthetic */ IDuplicateFileScanListener m2385$$Nest$fgeta(g4 r0) {
        return r0.f209a;
    }

    /* JADX INFO: renamed from: -$$Nest$fputa, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2386$$Nest$fputa(g4 r0, IDuplicateFileScanListener r1) {
        r0.f209a = r1;
    }

    public g4() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = new Handler(Looper.getMainLooper());
        this.h = new AtomicBoolean(false);
    }

    private void b() {
        if (this.f209a == null) goto L6;
        this.g.post(new a(this));
        return;
    }

    private void c() {
        if (this.b == null) goto L5;
        this.b.release();
        this.b = null;
    L5:
        this.c = null;
        this.e = null;
        this.f = null;
        this.d = null;
        this.h.set(false);
    }

    public void a(List r1) {
        if (r1 == null) goto L5;
        this.f = r1;
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
    L28:
        e = move-exception;
        Log.e("DuplicateFileScannerTask", "扫描过程中发生异常", e);     // Catch: Throwable -> L26
        a(-1, null);     // Catch: Throwable -> L26
    L30:
        c();
        return;
    L4:
        if (this.d != null) goto L8;
        a(-1, null);     // Catch: Throwable -> L26 Exception -> L28
        c();
        return;
    L8:
        b();     // Catch: Throwable -> L26 Exception -> L28
        this.b = new DuplicateFileScanner();     // Catch: Throwable -> L26 Exception -> L28
        if (this.c == null) goto L12;
        this.b.addWhiteListDirectories(this.c);     // Catch: Throwable -> L26 Exception -> L28
    L12:
        if (this.e == null) goto L15;
        this.b.addFileSizeRange(this.e.toString());     // Catch: Throwable -> L26 Exception -> L28
    L15:
        if (this.f == null) goto L17;
        this.b.addFileTypes(this.f);     // Catch: Throwable -> L26 Exception -> L28
    L17:
        this.b.setLogEnabled(q8.a());     // Catch: Throwable -> L26 Exception -> L28
        if (this.h.get() == true) goto L20;
        DuplicateFileGroup[] r2 = this.b.scanDuplicateFiles(this.d, 4);     // Catch: Throwable -> L26 Exception -> L28
    L22:
        if (this.h.get() == false) goto L24;
        a(-2, r2);     // Catch: Throwable -> L26 Exception -> L28
        goto L30
    L24:
        a(0, r2);     // Catch: Throwable -> L26 Exception -> L28
        goto L30
    L20:
        r2 = null;
    L26:
        th = move-exception;
        c();
        throw th;
    }

    public void a(FileScanSizeRange r1) {
        if (r1 == null) goto L5;
        this.e = r1;
        return;
    }

    public void a() {
        this.h.set(true);
        if (this.b == null) goto L6;
        this.b.cancelScan();
        return;
    }

    private void a(int r3, DuplicateFileGroup[] r4) {
        this.g.post(new b(this, r3, r4));
    }

    public int a(String r2, Set r3, IDuplicateFileScanListener r4) {
        if (r3 != null) goto L4;
    L6:
        if (r2 != null) goto L9;
        return -1;
    L9:
        this.d = r2;
        if (this.f209a == null) goto L13;
        return -3;
    L13:
        this.f209a = r4;
        this.h.set(false);
        ve.f().a(this, "DuplicateFileScanner");
        return 0;
    L4:
        if (r3.isEmpty() == true) goto L6;
        this.c = new ArrayList(r3);
        goto L6
    }
}
