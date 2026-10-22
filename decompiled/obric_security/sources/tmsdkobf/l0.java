package tmsdkobf;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tmsdk.common.OfflineVideo;
import tmsdk.common.TMSDKContext;
import tmsdk.common.creator.ManagerCreatorC;
import tmsdk.common.module.lang.MultiLangManager;
import tmsdk.fg.module.spacemanager.FileMedia;
import tmsdk.fg.module.spacemanager.FileScanResult;
import tmsdk.fg.module.spacemanager.FileScanSizeRange;
import tmsdk.fg.module.spacemanager.ISpaceScanListener;

/* JADX INFO: loaded from: classes5.dex */
public class l0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ld f314a;
    public ISpaceScanListener b;
    ld.c c;
    Handler d;
    Context e;
    boolean f;
    private List g;
    private Set h;
    private FileScanSizeRange i;
    le j;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l0 f315a;

        a(l0 r1) {
            this.f315a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f315a.b.onStart();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l0 f316a;

        b(l0 r1) {
            this.f316a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f316a.b.onCancelFinished();
            l0 r1 = this.f316a;
            r1.b = null;
            r1.f = false;
            r1.j.a(0);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileScanResult f317a;
        final /* synthetic */ l0 b;

        c(l0 r1, FileScanResult r2) {
            this.b = r1;
            this.f317a = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.b.onCancelFinished();
            this.b.b.onFinish(0, this.f317a);
            l0 r3 = this.b;
            r3.b = null;
            r3.f = false;
            r3.j.a(0);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileScanResult f318a;
        final /* synthetic */ l0 b;

        d(l0 r1, FileScanResult r2) {
            this.b = r1;
            this.f318a = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.b.onFinish(0, this.f318a);
            l0 r3 = this.b;
            r3.b = null;
            r3.j.a(0);
        }
    }

    class e implements ld.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l0 f319a;

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f320a;
            final /* synthetic */ e b;

            a(e r1, Object r2) {
                this.b = r1;
                this.f320a = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.b.f319a.b.onFound(this.f320a);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f321a;
            final /* synthetic */ e b;

            b(e r1, int r2) {
                this.b = r1;
                this.f321a = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.b.f319a.b.onProgressChanged(this.f321a);
            }
        }

        e(l0 r1) {
            this.f319a = r1;
        }

        @Override // tmsdkobf.ld.c
        public void a(long r1, Object r3) {
            l0 r2 = this.f319a;
            if (r2.b == null) goto L6;
            r2.d.post(new a(this, r3));
            return;
        }

        @Override // tmsdkobf.ld.c
        public void onProgressChanged(int r3) {
            l0 r0 = this.f319a;
            if (r0.b != null) goto L5;
            return;
        L5:
            if (r3 < 100) goto L7;
            r3 = 99;
        L7:
            r0.d.post(new b(this, r3));
        }
    }

    public l0(le r3) {
        this.d = new Handler(Looper.getMainLooper());
        this.f = false;
        this.g = null;
        this.h = null;
        this.i = null;
        this.e = TMSDKContext.getApplicaionContext();
        this.j = r3;
    }

    private void a(ld.c r9, FileScanResult r10, boolean r11) {
        y4 r0 = null;
        List r8 = new x9(null, r11).a();
        if (r8 != null) goto L5;
    L24:
        q8.c("BigFileScanTask", "videos.isEmpty()");
        return;
    L5:
        if (r8.isEmpty() == true) goto L24;
        q8.c("BigFileScanTask", "videos.size() = " + r8.size());
        ArrayList r1 = new ArrayList();
        Iterator r12 = r8.iterator();
        long r2 = 0;
    L9:
        if (r12.hasNext() == false) goto L19;
        OfflineVideo r4 = (OfflineVideo) r12.next();
        if (r0 != null) goto L13;
        r0 = new y4();
        r0.b();
    L13:
        q8.c("BigFileScanTask", "video.mAppName = " + r4.mAppName + ", mPath = " + r4.mPath);
        if (TextUtils.isEmpty(r4.mAppName) == false) goto L16;
        String r5 = ac.a(r4.mPath, y4.m).toLowerCase();
        q8.c("BigFileScanTask", "innerPath = " + r5);
        boolean r6 = ((MultiLangManager) ManagerCreatorC.getManager(MultiLangManager.class)).isENG();
        r4.mPackage = r0.d(r5, r6);
        r4.mAppName = r0.a(r5, r6);
    L16:
        FileMedia r7 = new FileMedia();
        r7.type = 2;
        r7.mPath = r4.mPath;
        r7.title = r4.mTitle;
        r7.pkg = r4.mPackage;
        r7.mSrcName = r4.mAppName;
        long r13 = r4.mSize;
        r7.mSize = r13;
        r7.mOfflineVideo = r4;
        r2 = r2 + r13;
        r1.add(r7);
        if (r9 == null) goto L9;
        r9.a(r2, r7);
        goto L9
    L19:
        List<FileMedia> r14 = r10.mVideoFiles;
        if (r14 == null) goto L22;
        r1.addAll(r14);
    L22:
        r10.mVideoFiles = r1;
    }

    public void b() {
        this.f = true;
        ld r1 = this.f314a;
        if (r1 == null) goto L6;
        r1.a();
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
        boolean r0 = ((MultiLangManager) ManagerCreatorC.getManager(MultiLangManager.class)).isENG();
        if (this.b != null) goto L5;
        return;
    L5:
        this.d.post(new a(this));
        if (this.f == false) goto L9;
        this.d.post(new b(this));
        return;
    L9:
        ld r1 = new ld(this.e, this.c, 263);
        this.f314a = r1;
        FileScanResult r2 = r1.a(this.h, this.g, this.i, r0);
        a(this.c, r2, r0);
        if (this.f == false) goto L12;
        Handler r3 = this.d;
        Runnable r4 = new c(this, r2);
    L13:
        r3.post(r4);
        this.f314a = null;
        return;
    L12:
        r3 = this.d;
        r4 = new d(this, r2);
        goto L13
    }

    private void a() {
        if (this.c != null) goto L6;
        this.c = new e(this);
        return;
    }

    public boolean a(ArrayList r2, Set r3, FileScanSizeRange r4, ISpaceScanListener r5) {
        if (r3 != null) goto L4;
    L6:
        if (r2 == null) goto L11;
        if (r2.isEmpty() == true) goto L11;
        this.h = new HashSet(r2);
    L11:
        if (this.b == null) goto L14;
        return false;
    L14:
        if (r4 == null) goto L16;
        this.i = r4;
    L16:
        this.b = r5;
        ve.f().a(this, "scanbigfile");
        return true;
    L4:
        if (r3.isEmpty() == true) goto L6;
        this.g = new ArrayList(r3);
        goto L6
    }
}
