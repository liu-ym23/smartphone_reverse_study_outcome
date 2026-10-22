package tmsdkobf;

import android.net.NetworkInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public interface gf {
    NetworkInfo getActiveNetworkInfo();

    m getAppInfo(String r1, int r2);

    m getAppInfo(m r1, int r2);

    ArrayList getInstalledApp(int r1, int r2);

    boolean isPackageInstalled(String r1);
}
