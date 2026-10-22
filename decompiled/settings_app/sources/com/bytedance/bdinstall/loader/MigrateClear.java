package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Cdid;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.bdinstall.util.GaidGetter;
import com.bytedance.bdinstall.util.LocalConstants;

/* JADX INFO: loaded from: classes3.dex */
final class MigrateClear {
    MigrateClear() {
    }

    public static void clear(Context r8, InstallOptions r9, Env r10) {
        GaidGetter.clearSp(r8);
        Utils.removeSpValues(r9.getSp(), new String[]{"device_id", Api.KEY_BD_DID, Api.KEY_INSTALL_ID, Api.KEY_DEVICE_TOKEN});
        Utils.removeSpValues(r10.getEnvIsolateSp(r8), new String[]{"device_id", Api.KEY_BD_DID, Api.KEY_INSTALL_ID, Api.KEY_DEVICE_TOKEN});
        Utils.removeSpValues(r8.getSharedPreferences(Constants.SP_FILE_OPEN_UDID, 0), new String[]{Api.KEY_C_UDID, Api.KEY_OPEN_UDID, SstLoader.KEY_SERIAL_NUMBER});     // Catch: Exception -> L5
    L7:
        Utils.removeSpValues(LocalConstants.getCommonSp(r8), new String[]{Api.KEY_C_UDID, Api.KEY_OPEN_UDID, SstLoader.KEY_SERIAL_NUMBER});
        Cdid.clearCdid(r8);
        Oaid.instance(r8).clear();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
