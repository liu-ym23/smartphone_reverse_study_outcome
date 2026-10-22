package tmsdkobf;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.librarian.LibrarianImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tmsdk.common.tcc.DeepCleanEngine;
import tmsdk.common.tcc.DeepCleanSAFEngine;
import tmsdk.common.tcc.QFile;
import tmsdk.common.tcc.SdcardScannerFactory;
import tmsdk.fg.module.spacemanager.FileInfo;
import tmsdk.fg.module.spacemanager.FileMedia;
import tmsdk.fg.module.spacemanager.FileScanResult;
import tmsdk.fg.module.spacemanager.FileScanSizeRange;

/* JADX INFO: loaded from: classes5.dex */
public class ld implements DeepCleanEngine.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f329a;
    private DeepCleanEngine b;
    private DeepCleanSAFEngine c;
    private int d;
    int e;
    int f;
    public volatile AtomicInteger g;
    ConcurrentHashMap h;
    ConcurrentHashMap i;
    ConcurrentHashMap j;
    List k;
    List l;
    FileScanResult m;
    Context n;
    c o;
    int p;

    class a implements Comparator {
        a() {
        }

        public int a(FileMedia r3, FileMedia r4) {
            long r2 = r3.mSize;
            long r0 = r4.mSize;
            if (r2 != r0) goto L6;
            return 0;
        L6:
            if (r2 >= r0) goto L8;
            return 1;
        L8:
            return -1;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r1, Object r2) {
            return a((FileMedia) r1, (FileMedia) r2);
        }
    }

    class b implements Comparator {
        b() {
        }

        public int a(ArrayList r2, ArrayList r3) {
            if (r2.size() != r3.size()) goto L7;
            return 0;
        L7:
            if (r2.size() <= r3.size()) goto L9;
            return -1;
        L9:
            return 1;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r1, Object r2) {
            return a((ArrayList) r1, (ArrayList) r2);
        }
    }

    public interface c {
        void a(long r1, Object r3);

        void onProgressChanged(int r1);
    }

    public ld(Context r3, c r4, int r5) {
        this.f329a = false;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = new AtomicInteger(0);
        this.h = new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
        this.j = new ConcurrentHashMap();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new FileScanResult();
        this.n = r3;
        this.o = r4;
        this.p = r5;
    }

    public void a() {
        this.f329a = true;
        DeepCleanEngine r0 = this.b;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        DeepCleanSAFEngine r1 = this.c;
        if (r1 == null) goto L9;
        r1.cancel();
        return;
    }

    public boolean b() {
        return this.f329a;
    }

    @Override // tmsdk.common.tcc.DeepCleanEngine.Callback
    public String getDetailRule(String r1) {
        return "";
    }

    @Override // tmsdk.common.tcc.DeepCleanEngine.Callback
    public void onDirectoryChange(String r1, int r2) {
    }

    @Override // tmsdk.common.tcc.DeepCleanEngine.Callback
    public void onFoundComRubbish(String r8, String r9, long r10) {
        monitor-enter(this);
        kd r0 = (kd) this.h.get(r8);     // Catch: Throwable -> L18
        if (r0 == null) goto L8;
        a(r8, r9, r10, (e9.a) r0);     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L8:
        kd r1 = (kd) this.i.get(r8);     // Catch: Throwable -> L18
        if (r1 == null) goto L14;
        b(r8, r9, r10, (e9.a) r1);     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L14:
        if (((kd) this.j.get(r8)) == null) goto L16;
        a(r8, r9, r10);     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // tmsdk.common.tcc.DeepCleanEngine.Callback
    public void onFoundEmptyDir(String r1, long r2) {
    }

    @Override // tmsdk.common.tcc.DeepCleanEngine.Callback
    public void onFoundKeySoftRubbish(String r1, String[] r2, long r3) {
    }

    @Override // tmsdk.common.tcc.DeepCleanEngine.Callback
    public void onFoundSoftRubbish(String r1, String r2, String r3, long r4) {
    }

    @Override // tmsdk.common.tcc.DeepCleanEngine.Callback
    public void onProcessChange(int r3) {
        int r0 = this.d;
        if (r0 != 0) goto L5;
        return;
    L5:
        this.f = r3;
        int r4 = (int) (((r3 + this.e) * 100.0f) / r0);
        if (r4 != 100) goto L8;
        r4 = r4 - 1;
    L8:
        c r2 = this.o;
        if (r2 == null) goto L12;
        r2.onProgressChanged(r4);
        return;
    }

    @Override // tmsdk.common.tcc.DeepCleanEngine.Callback
    public void onVisit(QFile r1) {
        int r0 = r1.type;
    }

    private void a(Set r7) {
        this.g.set(0);
        this.k.addAll(ac.d());
        String[] r0 = new String[this.k.size()];
        this.k.toArray(r0);
        this.b.setWhitePaths(r0);
        DeepCleanSAFEngine r2 = this.c;
        if (r2 == null) goto L5;
        r2.setWhitePaths(r0);
    L5:
        int r1 = this.l.size();
        String[] r3 = new String[r1];
        StringBuilder r4 = new StringBuilder();
        int r5 = 0;
    L6:
        if (r5 >= r1) goto L8;
        kd.a(r4, (kd) this.l.get(r5));
        r3[r5] = r4.toString();
        r4.setLength(0);
        r5 = r5 + 1;
        goto L6
    L8:
        this.b.setComRubRule(r3);
        DeepCleanSAFEngine r6 = this.c;
        if (r6 == null) goto L11;
        r6.setComRubRule(r3);
    L11:
        List r8 = ac.b();
        if (r8 != null) goto L14;
        return;
    L14:
        this.d = r8.size();
        if (r7 != null) goto L17;
    L19:
        List r9 = ac.c();
    L20:
        if (r9 == null) goto L30;
        Iterator r10 = r9.iterator();
    L23:
        if (r10.hasNext() == false) goto L37;
        String r11 = (String) r10.next();
        if (b() == true) goto L23;
        this.b.scanPath(r11, LibrarianImpl.Constants.SEPARATOR);
        DeepCleanSAFEngine r12 = this.c;
        if (r12 == null) goto L29;
        r12.scanPath(r11, "/android/data");
    L29:
        this.e += this.f;
        goto L23
    L37:
        return;
    L30:
        return;
    L17:
        if (r7.isEmpty() == true) goto L19;
        r9 = new ArrayList(r7);
        goto L20
    }

    public void b(String r1, String r2, long r3, e9.a r5) {
        FileMedia r4 = new FileMedia();
        r4.mPath = r2;
        r4.type = 2;
        r4.mSize = r3;
        r4.mPlayers = r5.m;
        this.m.mVideoFiles.add(r4);
        a(r3, r4);
    }

    private static void b(List r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        Collections.sort(r1, new a());
    }

    public FileScanResult a(Set r1, List r2, FileScanSizeRange r3, boolean r4) {
        if (a(r2, r3) == false) goto L15;
        if (this.l.size() == 0) goto L15;
        DeepCleanEngine r5 = SdcardScannerFactory.getDeepCleanEngine(this, 2);
        this.b = r5;
        boolean r6 = ve.f581a;
        if (r5 == null) goto L12;
        a(r1);
        this.b.release();
        this.b = null;
        DeepCleanSAFEngine r7 = this.c;
        if (r7 == null) goto L12;
        r7.release();
        this.c = null;
    L12:
        a(this.m, this.n, r4);
        return this.m;
    L15:
        return this.m;
    }

    private boolean a(List r6, FileScanSizeRange r7) {
        e9 r0 = new e9();
        if (r0.a(this.n) == true) goto L6;
        return false;
    L6:
        List r1 = r0.f175a;
        if (r1 == null) goto L9;
        this.k.addAll(r1);
    L9:
        if (r6 != null) goto L11;
    L13:
        List r8 = r0.d;
        if (r8 == null) goto L22;
        Iterator r9 = r8.iterator();
    L17:
        if (r9.hasNext() == false) goto L22;
        e9.a r2 = (e9.a) r9.next();
        if (qe.c(r2.b) == false) goto L17;
        this.k.add(r2.b);
    L22:
        if ((this.p & 1) == 0) goto L33;
        List r10 = r0.b;
        if (r10 == null) goto L33;
        Iterator r11 = r10.iterator();
    L27:
        if (r11.hasNext() == false) goto L33;
        kd r3 = (kd) r11.next();
        if (r7 == null) goto L31;
        r3.d = r7.toString();
    L31:
        this.l.add(r3);
        this.h.put(r3.f306a, r3);
    L33:
        if ((this.p & 2) == 0) goto L44;
        List r12 = r0.c;
        if (r12 == null) goto L44;
        Iterator r13 = r12.iterator();
    L38:
        if (r13.hasNext() == false) goto L44;
        kd r4 = (kd) r13.next();
        if (r7 == null) goto L42;
        r4.d = r7.toString();
    L42:
        this.l.add(r4);
        this.i.put(r4.f306a, r4);
    L44:
        if ((this.p & 4) == 0) goto L53;
        kd r14 = new kd();
        if (r7 == null) goto L48;
        String r15 = r7.toString();
    L49:
        r14.d = r15;
        r14.h = "0";
        if ((this.p & 256) == 0) goto L52;
        r14.c = "/\\.(zip|rar|pdf|doc|apk|ppt|txt|log|chm|docx|pptx|iso|7z|tar|gz|xlsx|xls|xlsm|csv|xlsb|docm|dotx|dotm|dot|pps|ppsx|pot|potx|thmx|wps|et|dpt)";
    L52:
        this.l.add(r14);
        this.j.put(r14.f306a, r14);
        goto L53
    L48:
        r15 = "10240,-";
    L53:
        return true;
    L11:
        if (r6.isEmpty() == true) goto L13;
        this.k.addAll(r6);
        goto L13
    }

    private void a(long r1, Object r3) {
        c r0 = this.o;
        if (r0 == null) goto L6;
        r0.a(r1, r3);
        return;
    }

    public void a(String r2, String r3, long r4) {
        FileInfo r5 = new FileInfo();
        r5.type = 3;
        r5.mPath = r3;
        r5.mSize = r4;
        this.m.mBigFiles.add(r5);
        a(r4, r5);
    }

    public void a(String r1, String r2, long r3, e9.a r5) {
        FileMedia r4 = new FileMedia();
        r4.mPath = r2;
        r4.type = 1;
        r4.mSize = r3;
        r4.mPlayers = r5.m;
        this.m.mRadioFiles.add(r4);
        a(r3, r4);
    }

    public static void a(FileScanResult r6, Context r7, boolean r8) {
        y4 r0 = new y4();
        r0.b();
        List<FileInfo> r1 = r6.mBigFiles;
        if (r1 == null) goto L8;
        Iterator<FileInfo> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        FileInfo r3 = r2.next();
        r3.mSrcName = r0.a(ac.a(r3.mPath, y4.m).toLowerCase(), new QFile(r3.mPath), r8);
    L8:
        List<FileMedia> r4 = r6.mRadioFiles;
        if (r4 == null) goto L18;
        Iterator<FileMedia> r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L17;
        FileMedia r9 = r5.next();
        String r10 = r9.mPath;
        List r11 = y4.m;
        String r12 = ac.a(r10, r11).toLowerCase();
        r9.pkg = r0.d(r12, r8);
        String r13 = r0.a(r12, r8);
        r9.mSrcName = r13;
        if (TextUtils.isEmpty(r13) == false) goto L16;
        r9.mSrcName = r0.a(ac.a(r9.mPath, r11).toLowerCase(), new QFile(r9.mPath), r8);
    L16:
        a(r9, r7);
        goto L12
    L17:
        a(r6.mRadioFiles);
    L18:
        List<FileMedia> r14 = r6.mVideoFiles;
        if (r14 == null) goto L37;
        Iterator<FileMedia> r15 = r14.iterator();
    L22:
        if (r15.hasNext() == false) goto L26;
        FileMedia r16 = r15.next();
        String r17 = r16.mPath;
        List r18 = y4.m;
        String r19 = ac.a(r17, r18).toLowerCase();
        r16.pkg = r0.d(r19, r8);
        String r20 = r0.a(r19, r8);
        r16.mSrcName = r20;
        if (TextUtils.isEmpty(r20) == false) goto L22;
        r16.mSrcName = r0.a(ac.a(r16.mPath, r18).toLowerCase(), new QFile(r16.mPath), r8);
        goto L22
    L26:
        a(r6.mVideoFiles);
        return;
    }

    private static void a(FileMedia r9, Context r10) {
        String[] r7 = {r9.mPath};
        Cursor r11 = r10.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"title", "artist", "album"}, "_data = ?", r7, "");
        if (r11 == null) goto L26;
    L18:
        th = move-exception;
        r11.close();
        throw th;
    L5:
        if (r11.moveToFirst() == false) goto L21;
        r9.title = r11.getString(r11.getColumnIndex("title"));     // Catch: Throwable -> L18 Exception -> L23
        r9.artist = r11.getString(r11.getColumnIndex("artist"));     // Catch: Throwable -> L18 Exception -> L23
        r9.album = r11.getString(r11.getColumnIndex("album"));     // Catch: Throwable -> L18 Exception -> L23
        String r0 = r9.artist;     // Catch: Throwable -> L18 Exception -> L23
        if (r0 != null) goto L10;
    L12:
        String r1 = r9.album;     // Catch: Throwable -> L18 Exception -> L23
        if (r1 == null) goto L21;
        if (r1.contains(EnvironmentCompat.MEDIA_UNKNOWN) == false) goto L21;
        r9.album = null;     // Catch: Throwable -> L18 Exception -> L23
        goto L21
    L10:
        if (r0.contains(EnvironmentCompat.MEDIA_UNKNOWN) == false) goto L12;
        r9.artist = null;     // Catch: Throwable -> L18 Exception -> L23
    L21:
        r11.close();
        return;
    }

    private static void a(List r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        b(r6);
        ArrayList r0 = new ArrayList();
        HashMap r1 = new HashMap();
        Iterator r2 = r6.iterator();
    L6:
        if (r2.hasNext() == false) goto L14;
        FileMedia r3 = (FileMedia) r2.next();
        if (qe.b(r3.pkg) == true) goto L9;
        ArrayList r4 = (ArrayList) r1.get(r3.pkg);
        if (r4 != null) goto L13;
        r4 = new ArrayList();
        r1.put(r3.pkg, r4);
    L13:
        r4.add(r3);
        goto L6
    L9:
        r0.add(r3);
        goto L6
    L14:
        ArrayList r5 = new ArrayList();
        r5.addAll(r1.values());
        Collections.sort(r5, new b());
        r6.clear();
        Iterator r7 = r5.iterator();
    L16:
        if (r7.hasNext() == false) goto L18;
        r6.addAll((ArrayList) r7.next());
        goto L16
    L18:
        r6.addAll(r0);
    }
}
