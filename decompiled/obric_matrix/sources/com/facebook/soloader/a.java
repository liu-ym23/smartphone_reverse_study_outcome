package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.util.Log;
import java.io.File;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes2.dex */
public class a extends f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f6802h;

    /* JADX INFO: renamed from: com.facebook.soloader.a$a, reason: collision with other inner class name */
    protected class C0206a extends f.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private File f6803j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f6804k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ a f6805l;

        C0206a(a r2, f r3) {
            this.f6805l = r2;
            super(r2, r3);
            this.f6803j = new File(r2.f6827c.getApplicationInfo().nativeLibraryDir);
            this.f6804k = a.r(r2);
        }

        @Override // com.facebook.soloader.f.c
        protected boolean x(ZipEntry r8, String r9) {
            String r0 = r8.getName();
            boolean r2 = false;
            if (r9.equals(this.f6805l.f6828d) == false) goto L7;
            this.f6805l.f6828d = null;
            String r7 = String.format("allowing consideration of corrupted lib %s", new Object[]{r9});
        L5:
            r2 = true;
        L16:
            Log.d("ApkSoSource", r7);
            return r2;
        L7:
            if ((this.f6804k & 1) != 0) goto L9;
            r7 = "allowing consideration of " + r0 + ": self-extraction preferred";
            goto L5
        L9:
            File r1 = new File(this.f6803j, r9);
            if (r1.isFile() == true) goto L12;
            r7 = String.format("allowing considering of %s: %s not in system lib dir", new Object[]{r0, r9});
            goto L5
        L12:
            long r5 = r1.length();
            long r10 = r8.getSize();
            if (r5 == r10) goto L15;
            r7 = String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", new Object[]{r1, Long.valueOf(r5), Long.valueOf(r10)});
            goto L5
        L15:
            r7 = "not allowing consideration of " + r0 + ": deferring to libdir";
            goto L16
        }
    }

    public a(Context r2, File r3, String r4, int r5) {
        super(r2, r4, r3, "^lib/([^/]+)/([^/]+\\.so)$");
        this.f6802h = r5;
    }

    static /* synthetic */ int r(a r0) {
        return r0.f6802h;
    }

    @Override // com.facebook.soloader.m
    protected byte[] i() {
        File r0 = this.f6815f.getCanonicalFile();
        Parcel r1 = Parcel.obtain();
        r1.writeByte((byte) 2);     // Catch: Throwable -> L21
        r1.writeString(r0.getPath());     // Catch: Throwable -> L21
        r1.writeLong(r0.lastModified());     // Catch: Throwable -> L21
        r1.writeInt(SysUtil.f(this.f6827c));     // Catch: Throwable -> L21
        if ((this.f6802h & 1) != 0) goto L8;
        r1.writeByte((byte) 0);     // Catch: Throwable -> L21
        byte[] r5 = r1.marshall();     // Catch: Throwable -> L21
        r1.recycle();
        return r5;
    L8:
        String r6 = this.f6827c.getApplicationInfo().nativeLibraryDir;     // Catch: Throwable -> L21
        if (r6 != null) goto L13;
        r1.writeByte((byte) 1);     // Catch: Throwable -> L21
        byte[] r7 = r1.marshall();     // Catch: Throwable -> L21
        r1.recycle();
        return r7;
    L13:
        File r8 = new File(r6).getCanonicalFile();     // Catch: Throwable -> L21
        if (r8.exists() == true) goto L18;
        r1.writeByte((byte) 1);     // Catch: Throwable -> L21
        byte[] r9 = r1.marshall();     // Catch: Throwable -> L21
        r1.recycle();
        return r9;
    L18:
        r1.writeByte((byte) 2);     // Catch: Throwable -> L21
        r1.writeString(r8.getPath());     // Catch: Throwable -> L21
        r1.writeLong(r8.lastModified());     // Catch: Throwable -> L21
        byte[] r10 = r1.marshall();     // Catch: Throwable -> L21
        r1.recycle();
        return r10;
    L21:
        th = move-exception;
        r1.recycle();
        throw th;
    }

    @Override // com.facebook.soloader.m
    protected m.f l() {
        return new C0206a(this, this);
    }
}
