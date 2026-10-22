package vg;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.services.apm.api.IEnsure;
import qg.d;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f22578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences.Editor f22579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IEnsure f22580c;

    public b(Context r10, String r11) {
        if (og.a.a(SettingsConfigProvider.class) != null) goto L26;
    L9:
        e = move-exception;
        DevicePolicyManager r5 = (DevicePolicyManager) r10.getSystemService("device_policy");
        if (r5 != null) goto L27;
    L24:
        throw e;
    L27:
        int r12 = r5.getStorageEncryptionStatus();     // Catch: IllegalStateException -> L22
        if (r12 != 5) goto L16;
    L17:
        Context r13 = r10.createDeviceProtectedStorageContext();
        r13.moveSharedPreferencesFrom(r10, r11 + ".sp");
        if (this.f22578a != null) goto L20;
        this.f22578a = r13.getSharedPreferences(r11 + ".sp", 0);
    L20:
        this.f22579b = this.f22578a.edit();
        this.f22580c = (IEnsure) og.a.a(IEnsure.class);
        return;
    L16:
        if (r12 != 3) goto L24;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    L6:
        if (this.f22578a != null) goto L20;
        this.f22578a = r10.getSharedPreferences(r11 + ".sp", 0);     // Catch: IllegalStateException -> L9
        goto L20
    L26:
        throw new ClassCastException();
    }

    public final String a(String r5) {
        return this.f22578a.getString(r5, "");
    L5:
        e = move-exception;
        IEnsure r10 = this.f22580c;
        if (r10 == null) goto L12;
        r10.reportLogException(e);
        return "";
    L12:
        return "";
    }

    public final void b(String r5, String r10) {
        this.f22579b.putString(r5, r10);
    }
}
