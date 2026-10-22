package tmsdkobf;

import android.net.NetworkInfo;
import com.tencent.qqpimsecure.phoneinfo.SystemInfoServiceImpl;
import java.util.ArrayList;
import tmsdk.common.creator.ManagerCreatorC;

/* JADX INFO: loaded from: classes5.dex */
public class ue implements te {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f557a;
    private SystemInfoServiceImpl b;

    public ue(long r1) {
        this.f557a = r1;
        this.b = (SystemInfoServiceImpl) ManagerCreatorC.getManager(SystemInfoServiceImpl.class);
    }

    @Override // tmsdkobf.te
    public void addPackageChangeListener(o6 r4) {
        q8.c("PhoneSystemInfoServiceProxy", "Id = " + this.f557a + "|addPackageChangeListener");
        this.b.addPackageChangeListener(r4);
    }

    @Override // tmsdkobf.gf
    public NetworkInfo getActiveNetworkInfo() {
        q8.c("PhoneSystemInfoServiceProxy", "Id = " + this.f557a + "|getActiveNetworkInfo");
        return this.b.getActiveNetworkInfo();
    }

    @Override // tmsdkobf.gf
    public m getAppInfo(String r4, int r5) {
        q8.c("PhoneSystemInfoServiceProxy", "Id = " + this.f557a + "|getAppInfo pkg=" + r4 + " flag=" + r5);
        return this.b.getAppInfo(r4, r5);
    }

    @Override // tmsdkobf.gf
    public ArrayList getInstalledApp(int r4, int r5) {
        q8.c("PhoneSystemInfoServiceProxy", "Id = " + this.f557a + "|getInstalledApp");
        return this.b.getInstalledApp(r4, r5);
    }

    @Override // tmsdkobf.gf
    public boolean isPackageInstalled(String r4) {
        q8.c("PhoneSystemInfoServiceProxy", "Id = " + this.f557a + "|isPackageInstalled pkg=" + r4);
        return this.b.isPackageInstalled(r4);
    }

    @Override // tmsdkobf.te
    public void removePackageChangeListener(o6 r4) {
        q8.c("PhoneSystemInfoServiceProxy", "Id = " + this.f557a + "|removePackageChangeListener");
        this.b.removePackageChangeListener(r4);
    }

    @Override // tmsdkobf.gf
    public m getAppInfo(m r4, int r5) {
        q8.c("PhoneSystemInfoServiceProxy", "Id = " + this.f557a + "|getAppInfo2 flag=" + r5);
        return this.b.getAppInfo(r4, r5);
    }
}
