package tmsdk.common;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import tmsdk.common.module.update.UpdateConfig;
import tmsdk.common.tcc.NumMarkerConsts;
import tmsdkobf.of;
import tmsdkobf.q8;
import tmsdkobf.z4;

/* JADX INFO: loaded from: classes5.dex */
public class NumMarker implements NumMarkerConsts {
    public static final int KEY_TAG_CALL_TIME_LENGTH = 1;
    public static final String Tag = "NumMarkerTag";
    private static NumMarker k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f38a;
    private long b;
    private boolean c;
    private boolean d;
    private List e;
    private List f;
    private List g;
    private List h;
    private String i;
    private Object j;

    public static class MarkFileInfo {
        public String md5;
        public int timeStampSecondLastDiff;
        public int timeStampSecondWhole;
        public int version;

        public MarkFileInfo() {
        }
    }

    public static class NumMark {
        public int count;
        public String num;
        public String tagName;
        public int tagValue;

        public NumMark() {
        }
    }

    static {
        TMSDKContext.registerNatives(4, NumMarker.class);
    }

    private NumMarker(Context r8) {
        this.b = 0;
        this.c = true;
        this.d = true;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = "";
        this.j = new Object();
        q8.c(Tag, "NumMarker()");
        this.f38a = r8;
        long r5 = nNewInstance(Build.VERSION.SDK_INT);
        this.b = r5;
        if (r5 == 0) goto L19;
        q8.c(Tag, "NumMarker() mPath: " + this.i);
        String r9 = this.i;
        if (r9 != null) goto L7;
    L8:
        this.i = this.f38a.getFilesDir().toString() + File.separator + "40458.sdb";
    L10:
        if (new File(this.i).exists() == true) goto L12;
        this.i = z4.a(this.f38a, "40458.sdb", null);
    L12:
        String r10 = this.i;
        if (r10 != null) goto L15;
    L16:
        this.i = this.f38a.getFilesDir().toString() + File.separator + "40458.sdb";
    L17:
        nSetPath(this.b, this.i);
        return;
    L15:
        if ("".equals(r10) == false) goto L17;
    L7:
        if ("".equals(r9) == false) goto L10;
    }

    public static synchronized NumMarker getDefault(Context r2) {
        monitor-enter(NumMarker.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (k != null) goto L7;
        k = new NumMarker(r2);     // Catch: Throwable -> L10
    L7:
        NumMarker r3 = k;     // Catch: Throwable -> L10
        monitor-exit(NumMarker.class);
        return r3;
    }

    private native void nDestroyInstance(long r1);

    private native String nGetDataMd5(long r1, String r3);

    private native boolean nGetHeaderInfo(long r1, AtomicInteger r3, AtomicInteger r4, AtomicInteger r5, AtomicReference<String> r6);

    private native boolean nGetMarkInfoByPhoneNumber(long r1, String r3, AtomicInteger r4, AtomicInteger r5);

    private native boolean nGetTagList(long r1, List<Integer> r3, List<Integer> r4);

    private native boolean nGetTypeNameMapping(long r1, List<Integer> r3, List<String> r4);

    private native long nNewInstance(int r1);

    private native boolean nRepack(long r1);

    private native boolean nSetPath(long r1, String r3);

    private native int nUpdate(long r1, String r3, String r4);

    public synchronized void destroy() {
        monitor-enter(this);
        this.e.clear();     // Catch: Throwable -> L9
        this.f.clear();     // Catch: Throwable -> L9
        this.g.clear();     // Catch: Throwable -> L9
        this.h.clear();     // Catch: Throwable -> L9
        long r0 = this.b;     // Catch: Throwable -> L9
        if (r0 == 0) goto L6;
        nDestroyInstance(r0);     // Catch: Throwable -> L9
    L6:
        this.b = 0;     // Catch: Throwable -> L9
        k = null;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void getConfigList(List<Integer> r6, List<Integer> r7) {
        if (this.d == false) goto L10;
        this.g.clear();
        this.h.clear();
        this.d = false;
        long r1 = this.b;
        if (r1 == 0) goto L8;
        nGetTagList(r1, this.g, this.h);
    L8:
        if (this.h.size() < 1) goto L10;
        q8.c(Tag, "getConfigList() value[0]: " + this.h.get(0));
    L10:
        r6.clear();
        r7.clear();
        r6.addAll(this.g);
        r7.addAll(this.h);
    }

    public String getDataMd5(String r5) {
        long r0 = this.b;
        if (r0 != 0) goto L5;
        return null;
    L5:
        return nGetDataMd5(r0, r5);
    }

    public NumMark getInfoOfNum(String r9) {
        AtomicInteger r6 = new AtomicInteger(0);
        AtomicInteger r7 = new AtomicInteger(0);
        long r1 = this.b;     // Catch: Throwable -> L9
        if (r1 != 0) goto L6;
        return null;
    L6:
        if (nGetMarkInfoByPhoneNumber(r1, r9, r6, r7) == false) goto L16;
        NumMark r8 = new NumMark();     // Catch: Throwable -> L9
        r8.num = r9;     // Catch: Throwable -> L9
        r8.tagValue = r6.get();     // Catch: Throwable -> L9
        r8.count = r7.get();     // Catch: Throwable -> L9
        return r8;
    L16:
        return null;
    L9:
        th = move-exception;
        q8.b(Tag, th);
        return null;
    }

    public NumMark getInfoOfNumForBigFile(String r17) {
        long r12 = nNewInstance(Build.VERSION.SDK_INT);     // Catch: Throwable -> L30
        if (r12 != 0) goto L56;
    L25:
        if (r12 != 0) goto L48;
    L37:
        return null;
    L48:
        nDestroyInstance(r12);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        q8.b(Tag, th);
        goto L37
    L56:
        String r1 = of.a(this.f38a, UpdateConfig.getLargeMarkFileName());     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r1) == false) goto L14;
        if (r12 != 0) goto L54;
    L13:
        return null;
    L54:
        nDestroyInstance(r12);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        q8.b(Tag, th);
        goto L13
    L14:
        nSetPath(r12, r1);     // Catch: Throwable -> L23
        AtomicInteger r14 = new AtomicInteger(0);     // Catch: Throwable -> L23
        AtomicInteger r15 = new AtomicInteger(0);     // Catch: Throwable -> L23
        if (nGetMarkInfoByPhoneNumber(r12, r17, r14, r15) == false) goto L25;
        NumMark r2 = new NumMark();     // Catch: Throwable -> L23
        r2.num = r17;     // Catch: Throwable -> L23
        r2.tagValue = r14.get();     // Catch: Throwable -> L23
        r2.count = r15.get();     // Catch: Throwable -> L23
        if (r12 != 0) goto L50;
    L22:
        return r2;
    L50:
        nDestroyInstance(r12);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        q8.b(Tag, th);
    L23:
        th = th;
    L46:
        q8.b(Tag, th);     // Catch: Throwable -> L38
        if (r12 == 0) goto L37;
    L38:
        th = move-exception;
        if (r12 == 0) goto L60;
        nDestroyInstance(r12);     // Catch: Throwable -> L43
        throw th;
    L43:
        th = move-exception;
        q8.b(Tag, th);
        throw th;
    L60:
        throw th;
    L30:
        th = th;
        r12 = 0;
        goto L46
    }

    public MarkFileInfo getMarkFileInfo(int r13, String r14) {
        MarkFileInfo r15 = new MarkFileInfo();
        AtomicInteger r7 = new AtomicInteger(0);
        AtomicInteger r8 = new AtomicInteger(0);
        AtomicInteger r9 = new AtomicInteger(0);
        String r11 = "";
        AtomicReference<String> r10 = new AtomicReference("");
        long r1 = nNewInstance(Build.VERSION.SDK_INT);
        if (r1 == 0) goto L5;
        nSetPath(r1, r14);
    L5:
        if (r1 != 0) goto L7;
    L12:
        return r15;
    L7:
        if (nGetHeaderInfo(r1, r7, r8, r9, r10) == false) goto L12;
        r15.version = r7.get();
        r15.timeStampSecondWhole = r8.get();
        r15.timeStampSecondLastDiff = r9.get();
        if (r10.get() == null) goto L11;
        r11 = r10.get();
    L11:
        r15.md5 = r11;
        goto L12
    }

    public void getMarkList(List<Integer> r5, List<String> r6) {
        if (this.c == false) goto L7;
        this.e.clear();
        this.f.clear();
        this.c = false;
        long r0 = this.b;
        if (r0 == 0) goto L7;
        nGetTypeNameMapping(r0, this.e, this.f);
    L7:
        r5.clear();
        r6.clear();
        r5.addAll(this.e);
        r6.addAll(this.f);
    }

    public boolean refreshMarkFile() {
        long r0 = this.b;
        if (r0 != 0) goto L5;
        return false;
    L5:
        return nRepack(r0);
    }

    public int updateMarkBigFile(String r10, String r11) {
        int r0 = -3;
        long r3 = nNewInstance(Build.VERSION.SDK_INT);     // Catch: Throwable -> L25
        if (r3 != 0) goto L51;
    L20:
        if (r3 != 0) goto L43;
    L32:
        return r0;
    L43:
        nDestroyInstance(r3);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        q8.b(Tag, th);
        goto L32
    L51:
        String r6 = of.a(this.f38a, UpdateConfig.getLargeMarkFileId(), ".sdb");     // Catch: Throwable -> L18
        this.i = r6;     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r6) == false) goto L9;
        this.i = this.f38a.getFilesDir().toString() + File.separator + UpdateConfig.getLargeMarkFileName();     // Catch: Throwable -> L18
    L9:
        nSetPath(r3, this.i);     // Catch: Throwable -> L18
        Object r7 = this.j;     // Catch: Throwable -> L18
        monitor-enter(r7);     // Catch: Throwable -> L18
        if (r3 != 0) goto L49;
    L13:
        monitor-exit(r7);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L49:
        r0 = nUpdate(r3, r10, r11);     // Catch: Throwable -> L15
    L18:
        th = th;
    L47:
        q8.b(Tag, th);     // Catch: Throwable -> L33
        if (r3 == 0) goto L32;
    L33:
        th = move-exception;
        if (r3 != 0) goto L41;
    L40:
        throw th;
    L41:
        nDestroyInstance(r3);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        q8.b(Tag, th);
    L25:
        th = th;
        r3 = 0;
        goto L47
    }

    public int updateMarkFile(String r6, String r7) {
        Object r0 = this.j;
        monitor-enter(r0);
        long r1 = this.b;     // Catch: Throwable -> L12
        if (r1 == 0) goto L7;
        int r8 = nUpdate(r1, r6, r7);     // Catch: Throwable -> L12
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (r8 != 0) goto L11;
        this.c = true;
        this.d = true;
    L11:
        return r8;
    L7:
        r8 = -3;
    L12:
        th = move-exception;
        throw th;
    }
}
