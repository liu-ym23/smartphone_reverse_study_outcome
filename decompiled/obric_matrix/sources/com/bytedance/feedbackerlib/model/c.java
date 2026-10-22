package com.bytedance.feedbackerlib.model;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.bytedance.feedbackerlib.m.s;
import com.ss.ttuploader.TTMediaDataReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c implements TTMediaDataReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Uri> f4600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a[] f4601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ContentResolver f4602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4603e;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream f4604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f4605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4606c;

        public a(@NonNull InputStream r3) {
            this.f4606c = 0;
            this.f4604a = r3;
            long r0 = r3.available();     // Catch: IOException -> L5
        L6:
            this.f4605b = r0;
            return;
        L5:
            r0 = -1;
            goto L6
        }
    }

    public c(@NonNull List<Uri> r2, @NonNull Context r3) {
        this.f4603e = 0;
        this.f4600b = r2;
        this.f4599a = r3;
        this.f4601c = new a[r2.size()];
        this.f4602d = r3.getContentResolver();
    }

    @Override // com.ss.ttuploader.TTMediaDataReader
    public int close(int r1) {
        s.a(this.f4601c[r1].f4604a);
        return 0;
    }

    @Override // com.ss.ttuploader.TTMediaDataReader
    public long getValue(int r3, int r4) {
        if (r4 != 0) goto L11;
        return this.f4601c[r3].f4605b;
    L12:
        return 0;
    L11:
        return 0;
    }

    @Override // com.ss.ttuploader.TTMediaDataReader
    public int open(int r4) {
        Uri r1 = this.f4600b.get(r4);     // Catch: Throwable -> L9
        InputStream r2 = this.f4602d.openInputStream(r1);     // Catch: Throwable -> L9
        if (r2 != null) goto L6;
        return -1;
    L6:
        a r3 = new a(r2);     // Catch: Throwable -> L9
        this.f4601c[r4] = r3;     // Catch: Throwable -> L9
        return 1;
    L9:
        return -1;
    }

    @Override // com.ss.ttuploader.TTMediaDataReader
    public int read(int r17, long r18, byte[] r20, int r21) {
        if (r17 < 0) goto L32;
        a[] r3 = this.f4601c;
        if (r17 >= r3.length) goto L32;
        a r4 = r3[r17];
        if (r18 < r4.f4605b) goto L10;
        return 0;
    L10:
        long r6 = r18 - ((long) r4.f4606c);
        if (r6 >= 0) goto L17;
        int r5 = this.f4603e;
        this.f4603e = r5 + 1;
        if (r5 >= 15) goto L16;
        close(r17);
        open(r17);
        return read(r17, r18, r20, r21);
    L16:
        return -1;
    L17:
        InputStream r0 = r4.f4604a;
    L19:
        if (r6 <= 0) goto L34;
        long r10 = r0.skip(r6);     // Catch: IOException -> L25
        int r1 = (int) (((long) r4.f4606c) + r10);     // Catch: IOException -> L25
        r4.f4606c = r1;     // Catch: IOException -> L25
        if (r1 >= r4.f4605b) goto L23;
        r6 = r6 - r10;
        goto L19
    L23:
        return 0;
    L25:
        return -1;
    L34:
        int r2 = r0.read(r20, 0, r21);     // Catch: IOException -> L33
        if (r2 > 0) goto L30;
        return -1;
    L30:
        r4.f4606c += r2;     // Catch: IOException -> L33
        return r2;
    L32:
        return -1;
    }
}
