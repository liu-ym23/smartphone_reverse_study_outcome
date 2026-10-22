package com.bytedance.memory.heap;

import com.bytedance.memory.b.g;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class HeapDump implements Serializable {
    public boolean computeRetainedHeapSize;
    public long currentTime;
    public final long gcDurationMs;
    public final long heapDumpDurationMs;
    public File heapDumpFile;
    public long heapDumpFileSize;
    public boolean isDebug;
    public String referenceClassName;
    public final String referenceKey;
    public final String referenceName;
    public String shrinkFilePath;
    public final long watchDurationMs;

    static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f5052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        File f5053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f5054c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f5055d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f5056e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f5057f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f5058g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f5059h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f5060i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        long f5061j;

        b() {
            this.f5053b = null;
            this.f5055d = null;
            this.f5052a = true;
            this.f5056e = "";
            this.f5057f = 0;
            this.f5058g = 0;
            this.f5059h = 0;
            this.f5060i = true;
        }

        public HeapDump a() {
            g.a(this.f5053b, "heapDumpFile");
            return new HeapDump(this, null);
        }

        public b b(boolean r1) {
            this.f5060i = r1;
            return this;
        }

        public b c(long r1) {
            this.f5061j = r1;
            return this;
        }

        public b d(boolean r1) {
            this.f5052a = r1;
            return this;
        }

        public b e(long r1) {
            this.f5058g = r1;
            return this;
        }

        public b f(long r1) {
            this.f5059h = r1;
            return this;
        }

        public b g(File r2) {
            g.a(r2, "heapDumpFile");
            this.f5053b = r2;
            return this;
        }

        public b h(long r1) {
            return this;
        }

        public b i(boolean r1) {
            this.f5052a = r1;
            return this;
        }

        public b j(String r2) {
            g.a(r2, "referenceKey");
            this.f5055d = r2;
            return this;
        }

        public b k(String r2) {
            g.a(r2, "referenceName");
            this.f5056e = r2;
            return this;
        }

        public b l(String r1) {
            this.f5054c = r1;
            return this;
        }

        public b m(long r1) {
            this.f5057f = r1;
            return this;
        }
    }

    private HeapDump(b r3) {
        this.isDebug = true;
        this.computeRetainedHeapSize = true;
        this.isDebug = r3.f5052a;
        this.currentTime = r3.f5061j;
        this.heapDumpFile = r3.f5053b;
        this.referenceKey = r3.f5055d;
        this.referenceName = r3.f5056e;
        this.computeRetainedHeapSize = r3.f5060i;
        this.watchDurationMs = r3.f5057f;
        this.shrinkFilePath = r3.f5054c;
        this.gcDurationMs = r3.f5058g;
        this.heapDumpDurationMs = r3.f5059h;
    }

    /* synthetic */ HeapDump(b r1, a r2) {
        this(r1);
    }

    @Deprecated
    public HeapDump(File r2, String r3, String r4, long r5, long r7, long r9, boolean r11) {
        b r0 = new b();
        r0.g(r2);
        r0.j(r3);
        r0.k(r4);
        r0.d(r11);
        r0.b(true);
        r0.m(r5);
        r0.e(r7);
        r0.f(r9);
        this(r0);
    }

    public static b newBuilder() {
        return new b();
    }

    public String toString() {
        return " heapDumpFilePath " + this.heapDumpFile.getPath() + "\n heapDumpFileSize " + this.heapDumpFile.length() + "\n referenceName " + this.referenceName + "\n isDebug " + this.isDebug + "\n currentTime " + this.currentTime + "\n watchDurationMs " + this.watchDurationMs + "ms\n gcDurationMs " + this.gcDurationMs + "ms\n shrinkFilePath " + this.shrinkFilePath + "\n heapDumpDurationMs " + this.heapDumpDurationMs + "ms\n";
    }
}
