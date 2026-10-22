package com.bytedance.bdinstall;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.OptionsForCommonParamProxy;
import com.bytedance.bdinstall.util.RomUtils;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import com.bytedance.bdinstall.util.UIUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.wschannel.WsConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
class ApiParamsUtil {
    private static IExtraParams sExtraParams = null;
    private static volatile int sParamCount = 36;
    private static volatile boolean sStarted = false;

    static {
    }

    ApiParamsUtil() {
    }

    static void setExtraParams(IExtraParams r1) {
        if (sExtraParams != null) goto L7;
        if (r1 == null) goto L8;
        sExtraParams = r1;
        return;
    L8:
        return;
    }

    static String appendNetParams(Context r4, StringBuilder r5, String r6, boolean r7, Level r8) {
        String r0 = r5.toString();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return r0;
    L5:
        Uri r1 = Uri.parse(r0);
        Set<String> r2 = r1.getQueryParameterNames();
        Uri.Builder r3 = r1.buildUpon();
        LinkedHashMap r9 = new LinkedHashMap(sParamCount);
        appendParamsToMap(r4, r7, r6, r9, r8);
        Iterator r10 = r9.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L13;
        Map.Entry r11 = (Map.Entry) r10.next();
        String r12 = (String) r11.getKey();
        String r13 = (String) r11.getValue();
        if (r2.contains(r12) == true) goto L7;
        if (TextUtils.isEmpty(r13) == true) goto L7;
        r3.appendQueryParameter(r12, (String) r11.getValue());
        goto L7
    L13:
        r5.delete(0, r5.length());
        r5.append(r3.build().toString());
        sParamCount = r9.size();
        return r5.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void appendParamsToMap(Context r6, boolean r7, String r8, Map<String, String> r9, Level r10) {
        if (r9 != null) goto L4;
        return;
    L4:
        r9.put("device_platform", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        addCommonParam(r9);
        if (r7 == false) goto L7;
        r9.put("ssmix", "a");
    L7:
        r9.put("_rticket", String.valueOf(System.currentTimeMillis()));
        String r11 = Cdid.get(r6);
        if (TextUtils.isEmpty(r11) == true) goto L10;
        r9.put(Cdid.KEY_CDID, r11);
    L10:
        AppContext r12 = BDInstall.getAppContext();
        InstallOptions r0 = BDInstall.getInstallOptions();
        HashMap<String, String> r1 = null;
        if (r0 == null) goto L13;
        OptionsForCommonParamProxy r2 = new OptionsForCommonParamProxy(r0);
    L14:
        if (r2 != null) goto L17;
        if (r12 == 0) goto L17;
        r2 = new OptionsForCommonParamProxy(r12);
    L17:
        if (r2 == null) goto L33;
        String r3 = r2.getChannel();
        if (TextUtils.isEmpty(r3) == true) goto L22;
        r9.put("channel", r3);
    L22:
        if (r8 == null) goto L24;
        r9.put("aid", r8);
    L25:
        String r13 = r2.getAppName();
        if (r13 == null) goto L28;
        r9.put("app_name", r13);
    L29:
        r9.put("version_code", String.valueOf(r2.getVersionCode()));
        String r14 = r2.getVersion();
        if (r14 == null) goto L32;
        r9.put("version_name", r14);
    L32:
        r9.put("manifest_version_code", String.valueOf(r2.getManifestVersionCode()));
        r9.put("update_version_code", String.valueOf(r2.getUpdateVersionCode()));
        goto L33
    L28:
        DrLog.ysnp(new IllegalArgumentException("app_name is null"));
        goto L29
    L24:
        r9.put("aid", String.valueOf(r2.getAid()));
    L33:
        if (r0 == null) goto L35;
        IAbContext r15 = r0.getAbContext();
    L36:
        if (r15 == null) goto L39;
        r12 = r15;
    L39:
        if (r12 == 0) goto L55;
        String r16 = r12.getAbVersion();
        if (TextUtils.isEmpty(r16) == true) goto L43;
        r9.put("ab_version", r16);
    L43:
        String r17 = r12.getAbClient();
        if (TextUtils.isEmpty(r17) == true) goto L46;
        r9.put("ab_client", r17);
    L46:
        String r18 = r12.getAbGroup();
        if (TextUtils.isEmpty(r18) == true) goto L49;
        r9.put("ab_group", r18);
    L49:
        String r19 = r12.getAbFeature();
        if (TextUtils.isEmpty(r19) == true) goto L52;
        r9.put("ab_feature", r19);
    L52:
        long r20 = r12.getAbFlag();
        if (r20 <= 0) goto L55;
        r9.put("abflag", String.valueOf(r20));
    L55:
        INewUserModeService r21 = (INewUserModeService) ServiceManager.getService(INewUserModeService.class);
        if (r21 == null) goto L58;
        r21.mapCustomParams(r9);
    L58:
        String r22 = UIUtils.getScreenResolution(r6);
        if (TextUtils.isEmpty(r22) == true) goto L61;
        r9.put(Api.KEY_RESOLUTION, r22);
    L61:
        int r23 = UIUtils.getDpi(r6);
        if (r23 <= 0) goto L65;
        r9.put("dpi", String.valueOf(r23));
    L65:
        if (Build.BRAND.equals("Pico") == false) goto L67;
        String r24 = RomUtils.getProductName();
    L68:
        r9.put("device_type", r24);
        r9.put("device_brand", Build.BRAND);
        r9.put(Api.KEY_LANGUAGE, Locale.getDefault().getLanguage());
        r9.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        String r25 = Build.VERSION.RELEASE;     // Catch: Exception -> L123
        if (r25 != null) goto L72;
    L74:
        r9.put("os_version", r25);     // Catch: Exception -> L123
        goto L75
    L72:
        if (r25.length() <= 10) goto L74;
        r25 = r25.substring(0, 10);     // Catch: Exception -> L123
    L75:
        String r26 = NetworkUtils.getNetworkAccessType(r6);
        if (TextUtils.isEmpty(r26) == true) goto L126;
        r9.put("ac", r26);
    L126:
        IExtraParams r27 = sExtraParams;     // Catch: Exception -> L100
        if (r27 == null) goto L82;
        r1 = r27.getExtraParams(r10);     // Catch: Exception -> L100
    L82:
        if (r1 != null) goto L84;
    L102:
        boolean r28 = Utils.isMainProcess(r6);
        InstallInfo r29 = BDInstall.getInstallInfo();
        if (started(r6, r28, r29) == false) goto L119;
        if (r29 == null) goto L117;
        if (TextUtils.isEmpty(r29.getIid()) == true) goto L109;
        r9.put(WsConstants.KEY_INSTALL_ID, r29.getIid());
    L109:
        if (TextUtils.isEmpty(r29.getDid()) == true) goto L112;
        r9.put("device_id", r29.getDid());
    L112:
        if (r10 != Level.L0) goto L117;
        String r30 = r29.getOpenUdid();
        if (TextUtils.isEmpty(r30) == true) goto L117;
        r9.put(Api.KEY_OPEN_UDID, r30);
    L117:
        if (r10 != Level.L0) goto L119;
        ApiParamsForFlavor.addSstParams(r6, r9, r28, r0);
    L119:
        ApiParamsForFlavor.addCommonParams(r28, r6);
        IParamFilter r31 = BDInstall.getParamsFilter();
        if (r31 == null) goto L141;
        r31.filterCommonParams(r9);
        return;
    L141:
        return;
    L84:
        if (r1.isEmpty() == true) goto L102;
        Iterator<Map.Entry<String, String>> r32 = r1.entrySet().iterator();     // Catch: Exception -> L100
    L86:
        if (r32.hasNext() == false) goto L102;
        Map.Entry<String, String> r33 = r32.next();     // Catch: Exception -> L100
        if (r33 == null) goto L86;
        String r4 = r33.getKey();     // Catch: Exception -> L100
        String r34 = r33.getValue();     // Catch: Exception -> L100
        if (TextUtils.isEmpty(r4) == true) goto L86;
        if (TextUtils.isEmpty(r34) == true) goto L86;
        if (r9.containsKey(r4) == true) goto L86;
        r9.put(r4, r34);     // Catch: Exception -> L100
    L100:
        e = move-exception;
        DrLog.ysnp(e);
        goto L102
    L67:
        r24 = Build.MODEL;
        goto L68
    L35:
        r15 = null;
        goto L36
    L13:
        r2 = null;
        goto L14
    }

    private static boolean started(Context r2, boolean r3, InstallInfo r4) {
        if (r3 == false) goto L10;
        boolean r5 = sStarted;
        if (r5 == true) goto L9;
        r5 = LocalConstants.getCommonSp(r2).getBoolean(Api.KEY_STARTED, false);
        if (r5 == false) goto L9;
        sStarted = true;
    L9:
        return r5;
    L10:
        if (r4 == null) goto L17;
        if (TextUtils.isEmpty(r4.getDid()) == true) goto L17;
        if (TextUtils.isEmpty(r4.getIid()) == true) goto L17;
        return true;
    L17:
        return false;
    }

    private static void addCommonParam(Map<String, String> r2) {
        if (RomUtils.isHarmonyUI() == false) goto L5;
        String r0 = "harmony";
    L6:
        r2.put("os", r0);
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (RomUtils.isHarmonyUI() == false) goto L16;
        r2.put("sub_os_api", String.valueOf(SystemPropertiesWithCache.get("hw_sc.build.os.apiversion")));     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L5:
        r0 = RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME;
        goto L6
    }
}
