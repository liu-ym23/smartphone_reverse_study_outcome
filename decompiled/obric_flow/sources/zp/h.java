package zp;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f23577a;

    public h() {
        this.f23577a = new StringBuilder();
    }

    public final void b() {
        StringBuilder r5 = this.f23577a;
        if (r5.length() <= 0) goto L6;
        Log.v("GLTextureView", r5.toString());
        r5.delete(0, r5.length());
        return;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        b();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        b();
    }

    @Override // java.io.Writer
    public final void write(char[] r5, int r10, int r11) {
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        char r13 = r5[r10 + r12];
        if (r13 != '\n') goto L7;
        b();
    L8:
        r12 = r12 + 1;
        goto L3
    L7:
        this.f23577a.append(r13);
        goto L8
    }
}
