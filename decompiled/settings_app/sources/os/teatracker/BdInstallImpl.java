package os.teatracker;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.Builder;
import com.bytedance.bdinstall.DefaultClient;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.ExecutorOptions;
import com.bytedance.bdinstall.IAbContext;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.InstallUrl;
import com.bytedance.bdinstall.Level;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class BdInstallImpl implements IBdInstall {
    private static final String KEY_ROM_VERSION = "os_rom_version";
    private static final String KEY_SYS_VERSION = "sys_version";
    private static final String META_DATA_KEY_UPDATE_VERSION = "teatracker_update_version_code";
    private static final String META_DATA_KEY_VERSION_CODE = "teatracker_version_code";
    private static final String SYS_PROP_KEY_ROM_VERSION = "ro.pvr.internal.version";
    private static final String SYS_PROP_KEY_SYS_VERSION = "ro.pui.build.version";
    private static final String TAG = "BdInstallImpl";
    private static IAbContext sAbContext;
    private static Env sCustomEnv;
    private static boolean sDirectActive;
    private static INetworkClient sNetworkClient;
    private static boolean sUseBoe;
    private IBdInstall.InstallCallBack mCallback;

    static /* synthetic */ HashMap lambda$register$0(HashMap r0, Level r1) {
        return r0;
    }

    public BdInstallImpl() {
    }

    static /* synthetic */ IBdInstall.InstallCallBack access$000(BdInstallImpl r0) {
        return r0.mCallback;
    }

    public static void setUseBoeEnv(boolean useBoe) {
        sUseBoe = useBoe;
    }

    public static void setDirectActive(boolean directActive) {
        sDirectActive = directActive;
    }

    public static String addCommonParams(String url, boolean isApi) {
        return BDInstall.addNetCommonParams(TeaHandler.getTeaHandler().getContext(), new StringBuilder(url), isApi, Level.L1);
    }

    public static void putCommonParams(Map<String, String> params, boolean isApi, int level) {
        if (level != 0) goto L4;
        Level r3 = Level.L0;
    L5:
        BDInstall.putCommonParams(TeaHandler.getTeaHandler().getContext(), params, isApi, r3);
        return;
    L4:
        r3 = Level.L1;
        goto L5
    }

    public static void setAbContext(IAbContext abContext) {
        sAbContext = abContext;
    }

    public static void setNetworkClient(INetworkClient client) {
        sNetworkClient = client;
    }

    public static void setEnv(Env env) {
        sCustomEnv = env;
    }

    @Override // os.teatracker.IBdInstall
    public void register(Context context, final Handler handler, Bundle params, IBdInstall.InstallCallBack callBack) {
        this.mCallback = callBack;
        ExecutorOptions r15 = new ExecutorOptions();
        r15.networkExecutor = new AnonymousClass1(this, handler);
        r15.workLooper = handler.getLooper();
        BDInstall.setExecutor(r15);
        boolean r13 = checkActivity(context);
        String r16 = params.getString("app_name", null);
        String r0 = params.getString(IBdInstall.PARAM_APP_CHANNEL, null);
        Bundle r1 = params.getBundle(IBdInstall.PARAM_META_DATA);
        if (r1 != null) goto L5;
        long r4 = 0;
        long r6 = 0;
    L17:
        final HashMap r2 = new HashMap();
        r2.put(KEY_ROM_VERSION, TeaUtil.getProperty(SYS_PROP_KEY_ROM_VERSION));
        r2.put(KEY_SYS_VERSION, TeaUtil.getProperty(SYS_PROP_KEY_SYS_VERSION));
        BDInstall.setCommonExtraParam(new BdInstallImpl$$ExternalSyntheticLambda0(r2));
        Builder r3 = new Builder();
        Builder r14 = r3.setContext(context).setDirectActive((!r13) | sDirectActive).setAutoActive(true).setAid(Integer.parseInt(params.getString("app_id")));
        if (TextUtils.isEmpty(r16) == false) goto L20;
        r16 = "os_teatracker";
    L20:
        Builder r17 = r14.setAppName(r16).setBDTrackerDepend(new BdInstallImpl$$ExternalSyntheticLambda1());
        if (TextUtils.isEmpty(r0) == false) goto L23;
        r0 = "test_channel";
    L23:
        r17.setChannel(r0).setDebug(true).setEncryptAndCompress(false).setNetworkClient(new DefaultClient()).setSpFileName("teatracker_stats").setAbContext(sAbContext).isMainProcess(isMainProcess(context));
        if (r4 == 0) goto L27;
        r3.setUpdateVersionCode(r4);
    L27:
        if (r6 == 0) goto L29;
        r3.setVersionCode(r6);
    L29:
        INetworkClient r12 = sNetworkClient;
        if (r12 == null) goto L32;
        r3.setNetworkClient(r12);
    L32:
        InstallOptions r18 = r3.build();
        BDInstall.addOnDataObserver(new AnonymousClass2(this));
        Env r11 = new Env(InstallUrl.createUriByDomain("https://os-mon.zijieapi.com"), false, false);
        Env r19 = sCustomEnv;
        if (r19 == null) goto L35;
        BDInstall.init(r18, r19);
    L39:
        BDInstall.start();
        return;
    L35:
        if (sUseBoe == false) goto L37;
        r11 = Env.CHINA_BOE;
    L37:
        BDInstall.init(r18, r11);
        goto L39
    L5:
        if (r1.containsKey(META_DATA_KEY_UPDATE_VERSION) == true) goto L43;
    L9:
        r4 = 0;
    L11:
        if (r1.containsKey(META_DATA_KEY_VERSION_CODE) == true) goto L41;
    L15:
        r6 = 0;
        goto L17
    L41:
        r6 = Long.parseLong(String.valueOf(r1.get(META_DATA_KEY_VERSION_CODE)));     // Catch: Throwable -> L14
    L14:
        Log.w(TAG, "parse manifest version code error!");
        goto L15
    L43:
        r4 = Long.parseLong(String.valueOf(r1.get(META_DATA_KEY_UPDATE_VERSION)));     // Catch: Throwable -> L8
    L8:
        Log.w(TAG, "parse update version code error!");
        goto L9
    }

    static /* synthetic */ void lambda$register$1(String r0, JSONObject r1) {
        TeaAgent.onEvent(r0, r1);
    }

    private static boolean checkActivity(Context context) {
        PackageInfo r3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r3.activities == null) goto L14;
        if (r3.activities.length > 0) goto L8;
        return false;
    L8:
        return true;
    L14:
        return false;
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static boolean isMainProcess(Context context) {
        String r1 = getProcessName(context);
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return true;
    L5:
        if (r1.contains(":") == false) goto L10;
        return false;
    L10:
        return true;
    }

    private static String getProcessName(Context context) {
        int r0 = Process.myPid();     // Catch: Exception -> L9
        Iterator<ActivityManager.RunningAppProcessInfo> r3 = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L9
    L4:
        if (r3.hasNext() == false) goto L12;
        ActivityManager.RunningAppProcessInfo r1 = r3.next();     // Catch: Exception -> L9
        if (r1.pid != r0) goto L4;
        String r4 = r1.processName;     // Catch: Exception -> L9
    L12:
        return getProcessNameFromProc();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private static String getProcessNameFromProc() {
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L16
    L5:
        int r3 = r2.read();     // Catch: Throwable -> L16
        if (r3 <= 0) goto L8;
        r0.append((char) r3);     // Catch: Throwable -> L16
        goto L5
    L8:
        String r1 = r0.toString();     // Catch: Throwable -> L16
        r2.close();     // Catch: Exception -> L15
    L10:
        return r1;
    L12:
        if (r2 != null) goto L22;
    L14:
        return null;
    L22:
        r2.close();     // Catch: Exception -> L17
    L11:
        r2 = null;
        goto L12
    }
}
