package os.teatracker;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdinstall.d0;
import com.bytedance.bdinstall.i0;
import com.bytedance.bdinstall.k0;
import com.bytedance.bdinstall.m0;
import com.bytedance.bdinstall.n;
import com.bytedance.bdinstall.r;
import com.bytedance.bdinstall.s;
import com.bytedance.bdinstall.v;
import com.bytedance.bdinstall.x;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BdInstallImpl implements IBdInstall {
    private static final String KEY_ROM_VERSION = "os_rom_version";
    private static final String KEY_SYS_VERSION = "sys_version";
    private static final String META_DATA_KEY_UPDATE_VERSION = "teatracker_update_version_code";
    private static final String META_DATA_KEY_VERSION_CODE = "teatracker_version_code";
    private static final String SYS_PROP_KEY_ROM_VERSION = "ro.pvr.internal.version";
    private static final String SYS_PROP_KEY_SYS_VERSION = "ro.pui.build.version";
    private static final String TAG = "BdInstallImpl";
    private static v sAbContext;
    private static r sCustomEnv;
    private static boolean sDirectActive;
    private static d0 sNetworkClient;
    private static boolean sUseBoe;
    private IBdInstall.a mCallback;

    class a implements Executor {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Handler f22701f;

        a(BdInstallImpl r1, Handler r2) {
            this.f22701f = r2;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r3) {
            if (this.f22701f.getLooper() != Looper.myLooper()) goto L5;
            r3.run();
            return;
        L5:
            this.f22701f.post(r3);
        }
    }

    class b implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BdInstallImpl f22702a;

        b(BdInstallImpl r1) {
            this.f22702a = r1;
        }

        @Override // com.bytedance.bdinstall.x
        public void a(boolean r1, String r2, String r3, String r4, String r5, String r6, String r7) {
            if (TextUtils.isEmpty(r3) == false) goto L5;
            return;
        L5:
            if (BdInstallImpl.access$000(this.f22702a) == null) goto L9;
            BdInstallImpl.access$000(this.f22702a).a(r3, r5);
            return;
        }

        @Override // com.bytedance.bdinstall.x
        public void b(String r1, String r2, String r3) {
            if (TextUtils.isEmpty(r1) == false) goto L5;
            return;
        L5:
            if (BdInstallImpl.access$000(this.f22702a) == null) goto L9;
            BdInstallImpl.access$000(this.f22702a).a(r1, r2);
            return;
        }
    }

    public BdInstallImpl() {
    }

    static /* synthetic */ HashMap a(HashMap r0, m0 r1) {
        return r0;
    }

    static /* synthetic */ IBdInstall.a access$000(BdInstallImpl r0) {
        return r0.mCallback;
    }

    public static String addCommonParams(String r2, boolean r3) {
        return com.bytedance.bdinstall.i.d(d.h().d(), new StringBuilder(r2), r3, m0.f2843g);
    }

    static /* synthetic */ void b(String r0, JSONObject r1) {
        e.g(r0, r1);
    }

    private static boolean checkActivity(Context r3) {
        ActivityInfo[] r4 = r3.getPackageManager().getPackageInfo(r3.getPackageName(), 1).activities;     // Catch: PackageManager.NameNotFoundException -> L9
        if (r4 == null) goto L14;
        if (r4.length > 0) goto L8;
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

    private static String getProcessName(Context r3) {
        int r0 = Process.myPid();     // Catch: Exception -> L9
        Iterator<ActivityManager.RunningAppProcessInfo> r4 = ((ActivityManager) r3.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L9
    L4:
        if (r4.hasNext() == false) goto L12;
        ActivityManager.RunningAppProcessInfo r1 = r4.next();     // Catch: Exception -> L9
        if (r1.pid != r0) goto L4;
        String r5 = r1.processName;     // Catch: Exception -> L9
    L12:
        return getProcessNameFromProc();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private static String getProcessNameFromProc() {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L16
    L5:
        int r3 = r1.read();     // Catch: Throwable -> L16
        if (r3 <= 0) goto L8;
        r2.append((char) r3);     // Catch: Throwable -> L16
        goto L5
    L8:
        String r0 = r2.toString();     // Catch: Throwable -> L16
        r1.close();     // Catch: Exception -> L15
    L10:
        return r0;
    L12:
        if (r1 != null) goto L22;
    L14:
        return null;
    L22:
        r1.close();     // Catch: Exception -> L17
    L11:
        r1 = null;
        goto L12
    }

    private static boolean isMainProcess(Context r1) {
        String r2 = getProcessName(r1);
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return true;
    L5:
        if (r2.contains(":") == false) goto L10;
        return false;
    L10:
        return true;
    }

    public static void putCommonParams(Map<String, String> r1, boolean r2, int r3) {
        if (r3 != 0) goto L4;
        m0 r4 = m0.f2842f;
    L5:
        com.bytedance.bdinstall.i.p(d.h().d(), r1, r2, r4);
        return;
    L4:
        r4 = m0.f2843g;
        goto L5
    }

    public static void setAbContext(v r0) {
        sAbContext = r0;
    }

    public static void setDirectActive(boolean r0) {
        sDirectActive = r0;
    }

    public static void setEnv(r r0) {
        sCustomEnv = r0;
    }

    public static void setNetworkClient(d0 r0) {
        sNetworkClient = r0;
    }

    public static void setUseBoeEnv(boolean r0) {
        sUseBoe = r0;
    }

    @Override // os.teatracker.IBdInstall
    public void register(Context r11, Handler r12, Bundle r13, IBdInstall.a r14) {
        this.mCallback = r14;
        s r15 = new s();
        r15.f2864a = new a(this, r12);
        r15.f2866c = r12.getLooper();
        com.bytedance.bdinstall.i.w(r15);
        boolean r16 = checkActivity(r11);
        String r17 = r13.getString(IBdInstall.PARAM_APP_NAME, null);
        String r0 = r13.getString(IBdInstall.PARAM_APP_CHANNEL, null);
        Bundle r1 = r13.getBundle(IBdInstall.PARAM_META_DATA);
        if (r1 != null) goto L5;
        long r4 = 0;
        long r6 = 0;
    L17:
        final HashMap r2 = new HashMap();
        r2.put(KEY_ROM_VERSION, k.c(SYS_PROP_KEY_ROM_VERSION));
        r2.put(KEY_SYS_VERSION, k.c(SYS_PROP_KEY_SYS_VERSION));
        com.bytedance.bdinstall.i.v(new os.teatracker.a(r2));
        com.bytedance.bdinstall.k r3 = new com.bytedance.bdinstall.k();
        r3.p(r11);
        r3.t((!r16) | sDirectActive);
        r3.m(true);
        r3.f(Integer.parseInt(r13.getString(IBdInstall.PARAM_APP_ID)));
        if (TextUtils.isEmpty(r17) == false) goto L20;
        r17 = "os_teatracker";
    L20:
        r3.j(r17);
        r3.n(os.teatracker.b.f22704a);
        if (TextUtils.isEmpty(r0) == false) goto L23;
        r0 = "test_channel";
    L23:
        r3.o(r0);
        r3.s(true);
        r3.u(false);
        r3.y(new n());
        r3.D("teatracker_stats");
        r3.d(sAbContext);
        r3.c(isMainProcess(r11));
        if (r4 == 0) goto L27;
        r3.G(r4);
    L27:
        if (r6 == 0) goto L29;
        r3.I(r6);
    L29:
        d0 r18 = sNetworkClient;
        if (r18 == null) goto L32;
        r3.y(r18);
    L32:
        i0 r19 = r3.a();
        com.bytedance.bdinstall.i.e(new b(this));
        r r10 = new r(k0.a("https://os-mon.zijieapi.com"), false, false);
        r r110 = sCustomEnv;
        if (r110 == null) goto L35;
        com.bytedance.bdinstall.i.o(r19, r110);
    L39:
        com.bytedance.bdinstall.i.z();
        return;
    L35:
        if (sUseBoe == false) goto L37;
        r10 = r.f2862l;
    L37:
        com.bytedance.bdinstall.i.o(r19, r10);
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
}
