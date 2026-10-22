package tmsdkobf;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;

/* JADX INFO: loaded from: classes5.dex */
public class sk implements al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f516a;
    private SharedPreferences.Editor b;
    private boolean c;

    public sk(Context r2, String r3) {
        this.c = false;
        this.f516a = r2.getSharedPreferences(r3, 0);
    }

    private SharedPreferences.Editor a() {
        if (this.b != null) goto L6;
        this.b = this.f516a.edit();
    L6:
        return this.b;
    }

    @Override // tmsdkobf.al
    public String b(String r1, String r2) {
        return this.f516a.getString(r1, r2);
    }

    @Override // tmsdkobf.al
    public int b(String r1, int r2) {
        return this.f516a.getInt(r1, r2);
    }

    @Override // tmsdkobf.al
    public boolean b(String r1, boolean r2) {
        return this.f516a.getBoolean(r1, r2);
    }

    @Override // tmsdkobf.al
    public boolean a(String r2, String r3) {
        SharedPreferences.Editor r0 = a();
        r0.putString(r2, r3);
        if (this.c == false) goto L5;
        return true;
    L5:
        return a(r0);
    }

    @Override // tmsdkobf.al
    public boolean a(String r2, int r3) {
        SharedPreferences.Editor r0 = a();
        r0.putInt(r2, r3);
        if (this.c == false) goto L5;
        return true;
    L5:
        return a(r0);
    }

    @Override // tmsdkobf.al
    public boolean a(String r2) {
        return a(a().remove(r2));
    }

    @Override // tmsdkobf.al
    public boolean a(String r2, boolean r3) {
        SharedPreferences.Editor r0 = a();
        r0.putBoolean(r2, r3);
        if (this.c == false) goto L5;
        return true;
    L5:
        return a(r0);
    }

    private boolean a(SharedPreferences.Editor r5) {
        if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) goto L14;
        if (wc.a() < 9) goto L14;
        r5.getClass().getMethod("apply", new Class[0]).invoke(r5, new Object[0]);     // Catch: Throwable -> L11
        return true;
    L12:
        return r5.commit();
    L14:
        return r5.commit();
    }
}
