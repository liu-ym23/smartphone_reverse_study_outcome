package com.android.settings.about;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.UserInfo;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemProperties;
import android.os.UserManager;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.WindowManager;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.Utils;
import com.android.settings.permission.ReflectHelper;
import com.android.settings.pinyin.PinyinUtils;
import com.android.settings.serviceapi.IDeviceInfoService;
import com.android.settings.utils.ResourceUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.sremlib.LibUtil;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.olog.OLog;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeviceUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0007J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u0004J\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020!J\u0006\u0010'\u001a\u00020\u001bJ\u0006\u0010(\u001a\u00020\u001bJ\u0006\u0010)\u001a\u00020\u0004J\u0006\u0010*\u001a\u00020\u001bJ\u0006\u0010+\u001a\u00020\u0004J\u0012\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010-\u001a\u00020\u0004H\u0002J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020/J\u0006\u00103\u001a\u00020/J\u0010\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R#\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u00066"}, d2 = {"Lcom/android/settings/about/DeviceUtils;", "", "()V", "CPU_7450", "", "CPU_855PLUS", "CPU_865", "CPU_8750", "getCPU_8750", "()Ljava/lang/String;", "DEFAULT_DEVICE_NAME", "MODEL_SM7450", "MODEL_SM8750", "SP_KEY_DEVICE_NAME_EDIT", "TAG", CloudControlInf.SP, "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getSp", "()Landroid/content/SharedPreferences;", "sp$delegate", "Lkotlin/Lazy;", "changeDeviceName", "", "text", "getBasebandSummary", "getBatteryCapacityFromSystemFile", "", "getBuildDate", "getCpuString", "getDeviceName", "getFormattedKernelVersion", "getMemInfoKBSize", "", "getMsvSuffix", "getOSVersion", "getPhysicsScreenSize", "", "getSDAvailableSize", "getScreenHeight", "getScreenWidth", "getShortOSVersion", "getSimIndexWhenHasNoMultiSim", "getUsedStorageSize", "getValueSummary", "property", "hasManagedProfile", "", "context", "Landroid/content/Context;", "isDeviceNameEdit", "isZ80U", "readLine", "filename", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceUtils {
    private static final String CPU_7450 = "Qualcomm® Snapdragon™ 7 Gen 1";
    private static final String CPU_855PLUS = "Qualcomm® Snapdragon™ 855 Plus";
    private static final String CPU_865 = "Qualcomm® Snapdragon™ 865";
    private static final String DEFAULT_DEVICE_NAME = "Ocean Phone";
    public static final DeviceUtils INSTANCE = null;
    private static final String MODEL_SM7450 = "SM7450";
    private static final String MODEL_SM8750 = "SM8750";
    private static final String SP_KEY_DEVICE_NAME_EDIT = "device_name_edit2";
    private static final String TAG = "DeviceUtils";
    private static final Lazy sp$delegate = null;

    public final int getBatteryCapacityFromSystemFile() {
        return 7100;
    }

    private DeviceUtils() {
    }

    private final String getCPU_8750() {
        return ResourceUtils.getString(R.string.cpu_8750);
    }

    static {
        INSTANCE = new DeviceUtils();
        sp$delegate = LazyKt.lazy(DeviceUtils$sp$2.INSTANCE);
    }

    private final SharedPreferences getSp() {
        return (SharedPreferences) sp$delegate.getValue();
    }

    public final String getCpuString() {
        return ResourceUtils.getString(R.string.cpu_name);
    }

    public final String getDeviceName() {
        String r1 = Utils.getDeviceNameReal(SettingsApplication.getContext());
        Intrinsics.checkNotNullExpressionValue(r1, "getDeviceNameReal(...)");
        return r1;
    }

    public final boolean isDeviceNameEdit() {
        return getSp().getBoolean(SP_KEY_DEVICE_NAME_EDIT, false);
    }

    public final void changeDeviceName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "text");
        if (TextUtils.isEmpty(r5) == false) goto L19;
        return;
    L19:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        OLog.d(TAG, "changeDeviceName: " + r5);     // Catch: Throwable -> L13
        Context r0 = SettingsApplication.getContext();     // Catch: Throwable -> L13
        INSTANCE.getSp().edit().putBoolean(SP_KEY_DEVICE_NAME_EDIT, true).apply();     // Catch: Throwable -> L13
        Settings.Global.putString(r0.getContentResolver(), "device_name", r5);     // Catch: Throwable -> L13
        BluetoothAdapter r2 = BluetoothAdapter.getDefaultAdapter();     // Catch: Throwable -> L13
        if (r2 == null) goto L8;
        r2.setName(r5);     // Catch: Throwable -> L13
    L8:
        Settings.Secure.putString(r0.getContentResolver(), "bluetooth_name", r5);     // Catch: Throwable -> L13
        SystemProperties.set("net.devicename", r5);     // Catch: Throwable -> L13
        String r6 = PinyinUtils.convertStringtoPinyinLowercase(r5);     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r6, "convertStringtoPinyinLowercase(...)");     // Catch: Throwable -> L13
        String r7 = new Regex(" +").replace(r6, "-");     // Catch: Throwable -> L13
        if (r7.length() <= 32) goto L11;
        r7 = r7.substring(0, Utils.DEVICE_NAME_MAX_LENGTH);     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r7, "substring(...)");     // Catch: Throwable -> L13
    L11:
        SystemProperties.set("net.hostname", r7);     // Catch: Throwable -> L13
        Object r8 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r9 = Result.m1511exceptionOrNullimpl(r8);
        if (r9 == null) goto L21;
        OLog.e(TAG, "changeDeviceName failed", r9);
        return;
    L21:
        return;
    L13:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r8 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    private final String getValueSummary(String r1) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r2 = Result.m1508constructorimpl(SystemProperties.get(r1, ""));     // Catch: Throwable -> L4
    L7:
        if (Result.m1514isFailureimpl(r2) == false) goto L10;
        r2 = null;
    L10:
        return (String) r2;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final long getMemInfoKBSize() {
        List<String> r4 = new Regex("\\s+").split(readLine("/proc/meminfo"), 0);     // Catch: IOException -> L18
        if (r4.isEmpty() == true) goto L13;
        ListIterator<String> r0 = r4.listIterator(r4.size());     // Catch: IOException -> L18
    L6:
        if (r0.hasPrevious() == false) goto L13;
        if (r0.previous().length() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L6;
        List r5 = CollectionsKt.take(r4, r0.nextIndex() + 1);     // Catch: IOException -> L18
    L14:
        String[] r6 = (String[]) r5.toArray(new String[0]);     // Catch: IOException -> L18
        if (r6.length != 3) goto L20;
        return Long.parseLong(r6[1]);
    L20:
        return 0;
    L10:
        r3 = false;
    L13:
        r5 = CollectionsKt.emptyList();     // Catch: IOException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    private final String readLine(String r2) throws IOException {
        BufferedReader r1 = new BufferedReader(new FileReader(r2), 256);
        String r3 = r1.readLine();     // Catch: Throwable -> L6
        Intrinsics.checkNotNullExpressionValue(r3, "readLine(...)");     // Catch: Throwable -> L6
        r1.close();
        return r3;
    L6:
        th = move-exception;
        r1.close();
        throw th;
    }

    public final float getPhysicsScreenSize() {
        IDeviceInfoService r0 = (IDeviceInfoService) ServiceManager.getService(IDeviceInfoService.class);
        if (r0 != null) goto L7;
        return 6.78f;
    L7:
        return r0.getPhysicsScreenSize();
    }

    public final int getScreenHeight() {
        Object r1 = SettingsApplication.getContext().getSystemService("window");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.WindowManager");
        return ((WindowManager) r1).getCurrentWindowMetrics().getBounds().height();
    }

    public final int getScreenWidth() {
        Object r1 = SettingsApplication.getContext().getSystemService("window");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.WindowManager");
        return ((WindowManager) r1).getCurrentWindowMetrics().getBounds().width();
    }

    public final long getSDAvailableSize() {
        return new StatFs(Environment.getExternalStorageDirectory().getPath()).getAvailableBytes();
    }

    public final String getUsedStorageSize() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        DeviceUtils r1 = this;     // Catch: Throwable -> L19
        Object r2 = SettingsApplication.getContext().getSystemService(Class.forName("android.app.usage.StorageStatsManager"));     // Catch: Throwable -> L19
        StorageManager r3 = (StorageManager) SettingsApplication.getContext().getSystemService(StorageManager.class);     // Catch: Throwable -> L19
        Object r4 = null;
        if (r3 == null) goto L5;
        List r5 = r3.getVolumes();     // Catch: Throwable -> L19
    L6:
        if (r5 == null) goto L16;
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L19
    L9:
        if (r6.hasNext() == false) goto L13;
        Object r7 = r6.next();     // Catch: Throwable -> L19
        if (((VolumeInfo) r7).isPrimary() == false) goto L9;
        r4 = r7;
    L13:
        VolumeInfo r8 = (VolumeInfo) r4;     // Catch: Throwable -> L19
        if (r8 == null) goto L16;
        Object r9 = ReflectHelper.invokeMethod(r2, "getTotalBytes", new Class[]{String.class}, new String[]{r8.getFsUuid()});     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Long");     // Catch: Throwable -> L19
        long r10 = ((Long) r9).longValue();     // Catch: Throwable -> L19
    L17:
        Formatter.BytesResult r11 = Formatter.formatBytes(ResourceUtils.getResources(), r10 - getSDAvailableSize(), 4);     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r11, "formatBytes(...)");     // Catch: Throwable -> L19
        String r12 = r11.value;     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L19
        Object r13 = Result.m1508constructorimpl(((int) Math.rint(Float.parseFloat(r12))) + TokenParser.SP + r11.units);     // Catch: Throwable -> L19
    L22:
        if (Result.m1511exceptionOrNullimpl(r13) == null) goto L26;
        r13 = "";
    L26:
        return (String) r13;
    L16:
        r10 = 0;
        goto L17
    L5:
        r5 = null;
    L19:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    public final String getShortOSVersion() {
        String r6 = getValueSummary("ro.os.ota.version");
        String r0 = ResourceUtils.getString(R.string.device_info_default);
        String r1 = r6;     // Catch: Exception -> L22
        if (r1 != null) goto L6;
    L9:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        return r0;
    L12:
        String[] r7 = (String[]) new Regex("-").split(r6, 3).toArray(new String[0]);     // Catch: Exception -> L22
        if (r7.length < 2) goto L19;
        if (new Regex("\\d{8}").matches(r7[1]) == false) goto L25;
        return r7[0];
    L25:
        return r7[0] + '-' + r7[1];
    L19:
        if (r7.length == 1) goto L21;
        return r0;
    L21:
        return r7[0];
    L6:
        if (r1.length() == 0) goto L9;
        r2 = false;
        goto L10
    L27:
        return r0;
    }

    public final String getOSVersion() {
        String r1 = getValueSummary("ro.os.ota.version");
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1;
    }

    public final String getBasebandSummary() {
        TelephonyManager r1 = TelephonyManager.from(SettingsApplication.getContext());
        Intrinsics.checkNotNullExpressionValue(r1, "from(...)");
        String r2 = MultiSDKAdapter.getBasebandInfo(r1, LibUtil.SYS_PROPERTY_TAG_CP_VERSION);
        if (TextUtils.isEmpty(r2) == true) goto L5;
        return r2;
    L5:
        return ResourceUtils.getString(R.string.device_info_default);
    }

    public final String getFormattedKernelVersion() {
        String r7 = readLine("/proc/version");     // Catch: IOException -> L13
        Matcher r5 = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+@[^\\s@]+)\\)+\\s+\\(Android \\([^\\)]+\\) clang version [^\\s]+ \\(https://android\\.googlesource\\.com/toolchain/llvm-project [a-f0-9]+\\), LLD [^\\s]+(?: \\(/buildbot/src/android/llvm-toolchain/out/llvm-project/lld [a-f0-9]+\\))?\\) ([^\\s]+)\\s+SMP PREEMPT (.+)").matcher(r7);     // Catch: IOException -> L13
        if (r5.matches() == true) goto L8;
        OLog.e(TAG, "Regex did not match on /proc/version: " + r7);     // Catch: IOException -> L13
        return "Unavailable";
    L8:
        if (r5.groupCount() >= 4) goto L11;
        OLog.e(TAG, "Regex match on /proc/version only returned " + r5.groupCount() + " groups");     // Catch: IOException -> L13
        return "Unavailable";
    L11:
        String r8 = r5.group(1) + "" + r5.group(2) + "" + r5.group(3) + "\n" + r5.group(4);     // Catch: IOException -> L13
        Intrinsics.checkNotNullExpressionValue(r8, "toString(...)");     // Catch: IOException -> L13
        return r8;
    L13:
        e = move-exception;
        OLog.e(TAG, "IO Exception when getting kernel version for Device Info screen", e);
        return "Unavailable";
    }

    public final String getBuildDate() {
        String r1 = getValueSummary(LibUtil.SYS_PROPERTY_TAG_BUILD_VERSION);
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1;
    }

    public final int getSimIndexWhenHasNoMultiSim() {
        if (Utils.isMultiSimSupport() == false) goto L11;
        if (TelephonyManager.getDefault().hasIccCard(0) == false) goto L8;
        return 0;
    L8:
        if (TelephonyManager.getDefault().hasIccCard(1) == true) goto L16;
    L13:
        return -1;
    L16:
        return 1;
    L11:
        if (Utils.isSimExists() == false) goto L13;
        return 0;
    }

    public final String getMsvSuffix() {
        String r4 = readLine("/sys/board_properties/soc/msv");     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        Long r5 = StringsKt.toLongOrNull(r4, 16);     // Catch: Throwable -> L13
        if (r5 == null) goto L16;
        if (r5.longValue() != 0) goto L17;
        return " (ENGINEERING)";
    L17:
        return "";
    L16:
        return "";
    L11:
        return "";
    L18:
        return "";
    }

    public final boolean isZ80U() {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        DeviceUtils r4 = this;     // Catch: Throwable -> L9
        String r5 = getValueSummary("ro.product.model");     // Catch: Throwable -> L9
        String r6 = getValueSummary("ro.product.device");     // Catch: Throwable -> L9
        OLog.iSensitive(TAG, "isZ80U: model = " + r5 + ", device = " + r6 + ", ");     // Catch: Throwable -> L9
        if (Intrinsics.areEqual(r6, "PQ85A01") == false) goto L16;
        if (Intrinsics.areEqual(r5, "NX741J") == false) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Throwable r7 = Result.m1511exceptionOrNullimpl(Result.m1508constructorimpl(ResultKt.createFailure(th)));
        if (r7 == null) goto L13;
        OLog.eSensitive(TAG, "isZ80U: failed to get model or device", r7);
    L13:
        return false;
    }

    public final boolean hasManagedProfile(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        List r0 = ((UserManager) r1.getSystemService(UserManager.class)).getProfiles(r1.getUserId());
        Intrinsics.checkNotNullExpressionValue(r0, "getProfiles(...)");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (((UserInfo) r2.next()).isManagedProfile() == false) goto L4;
        return true;
    L9:
        return false;
    }
}
