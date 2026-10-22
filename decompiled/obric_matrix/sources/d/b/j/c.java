package d.b.j;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public c() {
    }

    protected void a(String r1) {
        Log.d("librarian", r1);
    }

    protected void b(String r1) {
        Log.w("librarian", r1);
    }

    protected void c(String r1, Throwable r2) {
        Log.w("librarian", r1, r2);
    }

    protected void d(String r1) {
        System.load(r1);
    }

    protected void e(String r1) {
        System.loadLibrary(r1);
    }
}
