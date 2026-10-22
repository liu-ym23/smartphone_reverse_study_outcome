package com.bytedance.platform.godzilla.sysopt;

import android.app.Application;
import android.os.Build;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.BasePlugin;

/* JADX INFO: loaded from: classes.dex */
public class UbsanOptPlugin extends BasePlugin {
    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void destroy() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "UbsanOptPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r1) {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
    }

    public UbsanOptPlugin() {
    }

    public static String hexStringToString(String r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.equals("") == true) goto L28;
        String r6 = r5.replace(" ", "");
        int r0 = r6.length() / 2;
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L21;
        int r3 = r2 * 2;
        r1[r2] = (byte) (Integer.parseInt(r6.substring(r3, r3 + 2), 16) & 255);     // Catch: Exception -> L11
    L13:
        r2 = r2 + 1;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L21:
        return new String(r1, "UTF-8");
    L16:
        e = move-exception;
        e.printStackTrace();
        return r6;
    L28:
        return null;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        Logger.e(getName(), "start");
        String r2 = hexStringToString(Long.toHexString(79531005658441L));
        if (r2 == null) goto L6;
        Build.MANUFACTURER.toUpperCase().contains(r2);
        return;
    }
}
