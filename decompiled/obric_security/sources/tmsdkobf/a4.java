package tmsdkobf;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class a4 implements p6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f86a;
    private SharedPreferences.Editor b;
    private boolean c;

    public a4(Context r1, String r2, boolean r3) {
        this.c = false;
        this.f86a = r1.getSharedPreferences(r2, 0);
    }

    private SharedPreferences.Editor a() {
        if (this.b != null) goto L6;
        this.b = this.f86a.edit();
    L6:
        return this.b;
    }

    @Override // tmsdkobf.p6
    public void clear() {
        if (this.f86a != null) goto L5;
        return;
    L5:
        a().clear().commit();
    }

    @Override // tmsdkobf.p6
    public Map getAll() {
        SharedPreferences r0 = this.f86a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAll();
    }

    @Override // tmsdkobf.p6
    public boolean getBoolean(String r1, boolean r2) {
        SharedPreferences r0 = this.f86a;
        if (r0 != null) goto L6;
        return r2;
    L6:
        return r0.getBoolean(r1, r2);
    }

    @Override // tmsdkobf.p6
    public int getInt(String r1, int r2) {
        SharedPreferences r0 = this.f86a;
        if (r0 != null) goto L6;
        return r2;
    L6:
        return r0.getInt(r1, r2);
    }

    @Override // tmsdkobf.p6
    public long getLong(String r1, long r2) {
        SharedPreferences r0 = this.f86a;
        if (r0 != null) goto L6;
        return r2;
    L6:
        return r0.getLong(r1, r2);
    }

    @Override // tmsdkobf.p6
    public String getString(String r1, String r2) {
        SharedPreferences r0 = this.f86a;
        if (r0 != null) goto L6;
        return r2;
    L6:
        return r0.getString(r1, r2);
    }

    @Override // tmsdkobf.p6
    public void putBoolean(String r2, boolean r3) {
        if (this.f86a != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r0 = a();
        r0.putBoolean(r2, r3);
        if (this.c == true) goto L9;
        r0.commit();
        return;
    }

    @Override // tmsdkobf.p6
    public void putInt(String r2, int r3) {
        if (this.f86a != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r0 = a();
        r0.putInt(r2, r3);
        if (this.c == true) goto L9;
        r0.commit();
        return;
    }

    @Override // tmsdkobf.p6
    public void putLong(String r2, long r3) {
        if (this.f86a != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r0 = a();
        r0.putLong(r2, r3);
        if (this.c == true) goto L9;
        r0.commit();
        return;
    }

    @Override // tmsdkobf.p6
    public void putString(String r2, String r3) {
        if (this.f86a != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r0 = a();
        r0.putString(r2, r3);
        if (this.c == true) goto L9;
        r0.commit();
        return;
    }

    @Override // tmsdkobf.p6
    public void remove(String r2) {
        if (this.f86a != null) goto L5;
        return;
    L5:
        a().remove(r2).commit();
    }

    @Override // tmsdkobf.p6
    public String a(String r2) {
        SharedPreferences r1 = this.f86a;
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.getString(r2, null);
    }
}
