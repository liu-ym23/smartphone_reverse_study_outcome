package ms.bd.c;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Set<String> f22565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final y.b f22566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final y.a f22567c;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f22568f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f22569g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f22570h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ y.c f22571i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ z f22572j;

        a(z r1, Context r2, String r3, String r4, y.c r5) {
            this.f22572j = r1;
            this.f22568f = r2;
            this.f22569g = r3;
            this.f22570h = r4;
            this.f22571i = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            z.d(this.f22572j, this.f22568f, this.f22569g, this.f22570h);     // Catch: Throwable -> L4
            this.f22571i.a();     // Catch: Throwable -> L4
            return;
        L4:
            e = move-exception;
            this.f22571i.a(e);
        }
    }

    protected z(y.b r2, y.a r3) {
        this.f22565a = new HashSet();
        this.f22566b = r2;
        this.f22567c = r3;
    }

    static /* synthetic */ void d(z r0, Context r1, String r2, String r3) {
        r0.e(r1, r2, r3);
    }

    private void e(Context r13, String r14, String r15) {
        if (this.f22565a.contains(r14) == false) goto L37;
        String.format(Locale.US, "%s already loaded previously!", new Object[]{r14});
        return;
    L37:
        ((b0) this.f22566b).getClass();     // Catch: UnsatisfiedLinkError -> L11
        System.loadLibrary(r14);     // Catch: UnsatisfiedLinkError -> L11
        this.f22565a.add(r14);     // Catch: UnsatisfiedLinkError -> L11
        String.format(Locale.US, "%s (%s) was loaded normally!", new Object[]{r14, r15});     // Catch: UnsatisfiedLinkError -> L11
        return;
    L11:
        e = move-exception;
        Object[] r4 = {Log.getStackTraceString(e)};
        Locale r3 = Locale.US;
        String.format(r3, "Loading the library normally failed: %s", r4);
        String.format(r3, "%s (%s) was not loaded normally, re-linking...", new Object[]{r14, r15});
        File r5 = b(r13, r14, r15);
        if (r5.exists() == true) goto L35;
        File r6 = a(r13);
        File r7 = b(r13, r14, r15);
        File[] r8 = r6.listFiles(new a0(this, ((b0) this.f22566b).a(r14)));
        if (r8 == null) goto L24;
        int r9 = r8.length;
        int r10 = 0;
    L19:
        if (r10 >= r9) goto L24;
        File r11 = r8[r10];
        if (r11.getAbsolutePath().equals(r7.getAbsolutePath()) == true) goto L23;
        r11.delete();
    L23:
        r10 = r10 + 1;
    L24:
        y.a r12 = this.f22567c;
        ((b0) this.f22566b).getClass();
        if (Build.VERSION.SDK_INT < 21) goto L29;
        String[] r16 = Build.SUPPORTED_ABIS;
        if (r16.length <= 0) goto L29;
    L33:
        String[] r17 = r16;
    L34:
        ((w) r12).b(r13, r17, ((b0) this.f22566b).a(r14), r5, this);
    L29:
        String r18 = Build.CPU_ABI2;
        if (y.b(r18) == true) goto L32;
        r17 = new String[]{Build.CPU_ABI, r18};
        goto L34
    L32:
        r16 = new String[]{Build.CPU_ABI};
    L35:
        y.b r19 = this.f22566b;
        String r20 = r5.getAbsolutePath();
        ((b0) r19).getClass();
        System.load(r20);
        this.f22565a.add(r14);
        String.format(Locale.US, "%s (%s) was re-linked!", new Object[]{r14, r15});
    }

    protected File a(Context r2) {
        return r2.getDir("lib", 0);
    }

    protected File b(Context r2, String r3, String r4) {
        String r5 = ((b0) this.f22566b).a(r3);
        if (y.b(r4) == false) goto L7;
        return new File(a(r2), r5);
    L7:
        return new File(a(r2), r5 + "." + r4);
    }

    public void c(Context r9, String r10, String r11, y.c r12) {
        if (r9 == null) goto L13;
        if (y.b(r10) == true) goto L11;
        String.format(Locale.US, "Beginning load of %s...", new Object[]{r10});
        if (r12 != null) goto L8;
        e(r9, r10, r11);
        return;
    L8:
        new Thread(new a(this, r9, r10, r11, r12)).start();
        return;
    L11:
        throw new IllegalArgumentException("Given library is either null or empty");
    L13:
        throw new IllegalArgumentException("Given context is null");
    }
}
