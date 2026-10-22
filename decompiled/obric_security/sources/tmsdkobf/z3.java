package tmsdkobf;

import tmsdk.common.TMServiceFactory;

/* JADX INFO: loaded from: classes5.dex */
public class z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p6 f654a;

    public z3() {
        this.f654a = TMServiceFactory.getPreferenceService("DeepCleanConfigDao");
    }

    public long a() {
        return this.f654a.getLong("dir_last_get_data_sucess_time", 0);
    }

    public long b() {
        return this.f654a.getLong("profile_last_get_data_sucess_time", 0);
    }

    public boolean c() {
        return this.f654a.getBoolean("is_report_sdcard_dir_v2", false);
    }

    public boolean d() {
        return this.f654a.getBoolean("is_use_cloud_list_v2", false);
    }

    public boolean a(String r4) {
        if (this.f654a != null) goto L6;
        return false;
    L6:
        if (5 <= this.f654a.getInt("dat_ver_" + r4, 0)) goto L9;
        return true;
    L9:
        return false;
    }

    public void b(String r3) {
        if (this.f654a != null) goto L5;
        return;
    L5:
        String r4 = "dat_ver_" + r3;
        if (5 <= this.f654a.getInt(r4, 0)) goto L9;
        this.f654a.putInt(r4, 5);
        return;
    }

    public void a(long r2) {
        this.f654a.putLong("dir_last_get_data_sucess_time", r2);
    }

    public void b(long r2) {
        this.f654a.putLong("profile_last_get_data_sucess_time", r2);
    }

    public void a(boolean r2) {
        this.f654a.putBoolean("is_report_sdcard_dir_v2", r2);
    }

    public void b(boolean r2) {
        this.f654a.putBoolean("is_use_cloud_list_v2", r2);
    }
}
