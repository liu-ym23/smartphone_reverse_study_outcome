package settings;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.android.settings.ApnEditor;
import com.android.settings.Constants;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class PreferredActivityChooseUtils {
    private static final ComponentName BYTEDANCE_HOME_NAME = null;
    public static final String BYTEDANCE_LAUNCHER_ACTIVITY = "com.bytedanceos.launcher.Launcher";
    public static final String LAST_GRID_LAUNCHER_MODE = "last_grid_launcher_mode";
    private static final ComponentName ORIGINAL_HOME_NAME = null;
    public static final String ORIGINAL_LAUNCHER_ACTIVITY = "com.obric.feature.ObricLauncher";
    public static final String PKG_BYTEDANCE_LAUNCHER = "com.bytedanceos.launcher";
    public static final String PKG_ORIGINAL_LAUNCHER = "com.android.launcher3";
    public static final String PKG_SETTINGS = "com.android.settings";
    private static final String TAG = "PreferredActivityChooseUtils";
    private Context mContext;
    private List<ResolveInfo> mFullResolveInfoList;
    private IntentFilter mLauncherFilter;
    private PackageManager mPm;
    private List<ResolveInfo> mResolveInfoList;
    private List<String> mWhiteList;

    private void resetThumbMode() {
    }

    private void unlockAllPackages() {
    }

    static {
        ORIGINAL_HOME_NAME = new ComponentName("com.android.launcher3", ORIGINAL_LAUNCHER_ACTIVITY);
        BYTEDANCE_HOME_NAME = new ComponentName("com.bytedanceos.launcher", "com.bytedanceos.launcher.Launcher");
    }

    public PreferredActivityChooseUtils(Context r6) {
        this.mResolveInfoList = new ArrayList();
        this.mFullResolveInfoList = new ArrayList();
        this.mWhiteList = Arrays.asList(new String[]{"com.bytedanceos.launcher", "com.android.launcher3", Constants.PKG_BACKUP, "com.obric.settings", "com.android.settings"});
        this.mContext = r6;
        this.mPm = r6.getPackageManager();
        IntentFilter r7 = new IntentFilter("android.intent.action.MAIN");
        this.mLauncherFilter = r7;
        r7.addCategory("android.intent.category.HOME");
        this.mLauncherFilter.addCategory("android.intent.category.DEFAULT");
    }

    public List<ResolveInfo> getResolveInfoList() {
        return this.mResolveInfoList;
    }

    public List<ResolveInfo> getFullResolveInfoList() {
        return this.mFullResolveInfoList;
    }

    public void generateData(Intent r6, boolean r7) {
        this.mResolveInfoList.clear();
        this.mFullResolveInfoList.clear();
        List<ResolveInfo> r8 = this.mPm.queryIntentActivities(r6, 131072);
        this.mResolveInfoList = r8;
        if (r8 == null) goto L39;
        int r9 = r8.size();
        if (r9 <= 0) goto L40;
        this.mFullResolveInfoList.addAll(this.mResolveInfoList);
        ResolveInfo r0 = this.mResolveInfoList.get(0);
        if (r7 == true) goto L17;
        int r1 = 1;
    L9:
        if (r1 >= r9) goto L17;
        ResolveInfo r2 = this.mResolveInfoList.get(r1);
        if (r0.priority != r2.priority) goto L14;
        if (r0.isDefault != r2.isDefault) goto L14;
    L16:
        r1 = r1 + 1;
    L14:
        if (r1 >= r9) goto L16;
        r9 = r9 - 1;
        this.mResolveInfoList.remove(r1);
    L17:
        Iterator<ResolveInfo> r10 = this.mResolveInfoList.iterator();
        if (r7 == true) goto L20;
        return;
    L20:
        if (r10.hasNext() == false) goto L26;
        ResolveInfo r11 = r10.next();
        if (r11.activityInfo == null) goto L20;
        if (this.mWhiteList.contains(r11.activityInfo.packageName) == false) goto L20;
        r10.remove();
        goto L20
    L26:
        addResolveInfo(ORIGINAL_HOME_NAME);
        return;
    L40:
        return;
    }

    private void addResolveInfo(ComponentName r4) {
        ResolveInfo r0 = new ResolveInfo();     // Catch: PackageManager.NameNotFoundException -> L4
        r0.activityInfo = this.mPm.getActivityInfo(r4, 512);     // Catch: PackageManager.NameNotFoundException -> L4
        this.mResolveInfoList.add(0, r0);     // Catch: PackageManager.NameNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static Intent makeIntentByFilter(IntentFilter r8) {
        Intent r0 = new Intent();
        r0.setAction(r8.getAction(0));
        if (r8.countCategories() <= 0) goto L8;
        int r2 = 0;
    L6:
        if (r2 >= r8.countCategories()) goto L8;
        r0.addCategory(r8.getCategory(r2));
        r2 = r2 + 1;
    L8:
        String r3 = null;
        if (r8.countDataSchemes() <= 0) goto L27;
        String r4 = r8.getDataScheme(0);
        Uri.Builder r5 = new Uri.Builder();
        r5.scheme(r4);
        if (r8.countDataPaths() <= 0) goto L20;
        String r6 = r8.getDataPath(0).getPath();
        int r7 = r6.lastIndexOf(ApnEditor.APN_TYPE_ALL);
        if (r6.endsWith(ApnEditor.APN_TYPE_ALL) == false) goto L15;
        r7 = -1;
    L15:
        if (r7 == (-1)) goto L18;
        r6 = r6.substring(r7 + 1);
    L18:
        r5.path(r6);
    L20:
        if (r8.countDataAuthorities() <= 0) goto L26;
        IntentFilter.AuthorityEntry r9 = r8.getDataAuthority(0);
        StringBuilder r10 = new StringBuilder().append(r9.getHost());
        if (r9.getPort() == (-1)) goto L24;
        String r11 = ":" + r9.getPort();
    L25:
        r5.authority(r10.append(r11).toString());
        goto L26
    L24:
        r11 = "";
    L26:
        Uri r12 = r5.build();
    L29:
        if (r8.countDataTypes() <= 0) goto L40;
        String r1 = r8.getDataType(0);
        if (r1.contains(LibrarianImpl.Constants.SEPARATOR) == true) goto L33;
        r1 = r1 + "/*";
    L33:
        r3 = r1;
        if (r8.countDataSchemes() != 0) goto L40;
        String r13 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r3);
        if (r13 == null) goto L40;
        if (r13.isEmpty() == true) goto L40;
        r12 = Uri.parse("file:///fake_uri." + r13);
    L40:
        r0.setDataAndType(r12, r3);
        return r0;
    L27:
        r12 = null;
        goto L29
    }

    public void switchLauncher(ComponentName r1, ComponentName[] r2, ComponentName r3) {
        Intent r4 = new Intent();
        r4.setAction("com.android.switch.launcher");
        this.mContext.sendBroadcast(r4);
    }

    private void setLauncherEnabledState(ComponentName r2, int r3) {
        PackageManager r1 = this.mPm;
        String r4 = r2.getPackageName();
        int r0 = 1;
        if (1 == r3) goto L6;
        r0 = 0;
    L6:
        r1.setApplicationEnabledSetting(r4, r3, r0);
    }

    private void forceStopPackage(String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        OLog.d(TAG, "forceStopPackage " + r4);
        ((ActivityManager) this.mContext.getSystemService("activity")).forceStopPackage(r4);
    }

    private void saveOrRestoreLastLauncherMode(ComponentName r9, ComponentName r10) {
        if ("com.bytedanceos.launcher".equals(r10.getPackageName()) == false) goto L6;
        int r11 = android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "launcher_mode", 16);
        OLog.d(TAG, "saveOrRestoreLastLauncherMode: currentLauncherMode:" + r11);
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), "last_grid_launcher_mode", r11);
    L6:
        if ("com.bytedanceos.launcher".equals(r9.getPackageName()) == false) goto L20;
        int r12 = android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "last_grid_launcher_mode", getSystemDefaultLauncher());
        OLog.d(TAG, "saveOrRestoreLastLauncherMode: lastGridLauncherMode:" + r12);
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), "launcher_mode", r12);
        int r4 = 3;
        if (r12 == 9) goto L15;
        int r5 = 4;
        if (r12 == 12) goto L18;
        if (r12 != 16) goto L13;
        r4 = 4;
        goto L18
    L13:
        if (r12 == 20) goto L16;
        r4 = 0;
        goto L15
    L16:
        r5 = 5;
        r4 = 4;
    L18:
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), "launcher_grids_x", r4);
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), "launcher_grids_y", r5);
    L15:
        r5 = r4;
    L20:
        if ("com.android.launcher3".equals(r9.getPackageName()) == false) goto L23;
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), "launcher_mode", 0);
        return;
    }

    private int getSystemDefaultLauncher() {
        int r3 = getPackageIntegerRes(this.mContext, Constants.PKG_SETTINGS_PROVIDER, "def_launcher_mode");     // Catch: Resources.NotFoundException -> L4
    L6:
        OLog.d(TAG, "getSystemDefaultLauncher " + r3);
        return r3;
    L4:
        e = move-exception;
        e.printStackTrace();
        r3 = 9;
        goto L6
    }

    public static int getPackageIntegerRes(Context r2, String r3, String r4) throws Resources.NotFoundException {
        return getIntegerRes(r2.createPackageContext(r3, 2), r4);
    L5:
        e = move-exception;
        OLog.e(TAG, "Can not find " + r3 + " Context: ", e);
        throw new Resources.NotFoundException();
    }

    public static int getIntegerRes(Context r3, String r4) throws Resources.NotFoundException {
        int r5 = r3.getResources().getIdentifier(r4, "integer", r3.getPackageName());
        if (r5 <= 0) goto L7;
        return r3.getResources().getInteger(r5);
    L7:
        throw new Resources.NotFoundException();
    }
}
