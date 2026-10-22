package os.teatracker;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: loaded from: classes6.dex */
public interface IBdInstall {
    public static final String PARAM_APP_CHANNEL = "app_channel";
    public static final String PARAM_APP_ID = "app_id";
    public static final String PARAM_APP_NAME = "app_name";
    public static final String PARAM_META_DATA = "meta_data";

    public interface InstallCallBack {
        void onGetDeviceId(String did, String iid);
    }

    void register(Context context, Handler handler, Bundle params, InstallCallBack callBack);
}
