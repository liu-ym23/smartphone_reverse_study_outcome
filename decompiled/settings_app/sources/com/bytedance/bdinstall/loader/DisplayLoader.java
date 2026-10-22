package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.obric.oui.material.MaterialConfigFormatNames;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class DisplayLoader extends BaseLoader {
    private final Context mApp;

    DisplayLoader(Context r3) {
        super(true, false);
        this.mApp = r3;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r2) throws JSONException {
        DisplayMetrics r0 = this.mApp.getResources().getDisplayMetrics();
        addOldDisplayInfo(r2, r0);
        addNewDisplayInfo(r2, r0);
        return true;
    }

    private void addNewDisplayInfo(JSONObject r5, DisplayMetrics r6) throws JSONException {
        int r7 = r6.densityDpi;
        if (r7 > 120) goto L6;
        String r8 = "ldpi";
    L21:
        r5.put("display_density_v2", r8);
        int[] r4 = getScreenPixels();
        r5.put("resolution_v2", r4[1] + MaterialConfigFormatNames.X + r4[0]);
        if (DrLog.debug() == false) goto L25;
        DrLog.d("resolution " + r4[1] + MaterialConfigFormatNames.X + r4[0]);
        return;
    L25:
        return;
    L6:
        if (r7 > 160) goto L9;
        r8 = "mdpi";
        goto L21
    L9:
        if (r7 > 240) goto L12;
        r8 = "hdpi";
        goto L21
    L12:
        if (r7 > 320) goto L15;
        r8 = "xhdpi";
        goto L21
    L15:
        if (r7 > 480) goto L18;
        r8 = "xxhdpi";
        goto L21
    L18:
        if (r7 > 640) goto L20;
        r8 = "xxxhdpi";
        goto L21
    L20:
        r8 = "xxxxhdpi";
        goto L21
    }

    private void addOldDisplayInfo(JSONObject r3, DisplayMetrics r4) {
        int r2 = r4.densityDpi;     // Catch: Exception -> L14
        if (r2 != 120) goto L5;
        String r0 = "ldpi";
    L12:
        r3.put(Api.KEY_DENSITY_DPI, r2);     // Catch: Exception -> L14
        r3.put(Api.KEY_DISPLAY_DENSITY, r0);     // Catch: Exception -> L14
        r3.put(Api.KEY_RESOLUTION, r4.heightPixels + MaterialConfigFormatNames.X + r4.widthPixels);     // Catch: Exception -> L14
        return;
    L5:
        if (r2 != 240) goto L7;
        r0 = "hdpi";
        goto L12
    L7:
        if (r2 == 320) goto L9;
        r0 = "mdpi";
        goto L12
    L9:
        r0 = "xhdpi";
    L14:
        e = move-exception;
        e.printStackTrace();
    }

    private int[] getScreenPixels() {
        WindowManager r3 = (WindowManager) this.mApp.getSystemService("window");     // Catch: Throwable -> L8
        DisplayMetrics r1 = new DisplayMetrics();     // Catch: Throwable -> L8
        r3.getDefaultDisplay().getRealMetrics(r1);     // Catch: Throwable -> L8
        int r4 = r1.widthPixels;     // Catch: Throwable -> L8
        int r2 = r1.heightPixels;     // Catch: Throwable -> L6
    L12:
        return new int[]{r4, r2};
    L6:
        th = th;
    L10:
        th.printStackTrace();
        r2 = 0;
    L8:
        th = th;
        r4 = 0;
        goto L10
    }
}
