package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothLeBroadcastReceiveState;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.provider.DeviceConfig;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.graphics.drawable.IconCompat;
import com.GlobalProxyLancet;
import com.android.settingslib.R;
import com.android.settingslib.flags.Flags;
import com.android.settingslib.widget.AdaptiveIcon;
import com.android.settingslib.widget.AdaptiveOutlineDrawable;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothUtils {
    public static final String BT_ADVANCED_HEADER_ENABLED = "bt_advanced_header_enabled";
    public static final boolean D = true;
    private static final String KEY_HEARABLE_CONTROL_SLICE = "HEARABLE_CONTROL_SLICE_WITH_WIDTH";
    private static final int METADATA_FAST_PAIR_CUSTOMIZED_FIELDS = 25;
    public static final int META_INT_ERROR = -1;
    private static final String TAG = "BluetoothUtils";
    public static final boolean V = false;
    private static ErrorListener sErrorListener;

    public interface ErrorListener {
        void onShowError(Context r1, String r2, int r3);
    }

    public BluetoothUtils() {
    }

    public static int getConnectionStateSummary(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return 0;
    L12:
        return R.string.bluetooth_disconnecting;
    L14:
        return R.string.bluetooth_connected;
    L16:
        return R.string.bluetooth_connecting;
    L18:
        return R.string.bluetooth_disconnected;
    }

    static void showError(Context r1, String r2, int r3) {
        ErrorListener r0 = sErrorListener;
        if (r0 == null) goto L6;
        r0.onShowError(r1, r2, r3);
        return;
    }

    public static void setErrorListener(ErrorListener r0) {
        sErrorListener = r0;
    }

    public static Pair<Drawable, String> getBtClassDrawableWithDescription(Context r6, CachedBluetoothDevice r7) {
        BluetoothClass r0 = r7.getBtClass();
        if (r0 == null) goto L22;
        int r1 = r0.getMajorDeviceClass();
        if (r1 == 256) goto L20;
        if (r1 == 512) goto L18;
        if (r1 == 1280) goto L16;
        if (r1 != 1536) goto L22;
        return new Pair(getBluetoothDrawable(r6, android.R.drawable.pointer_crosshair_vector_icon), r6.getString(R.string.bluetooth_talkback_imaging));
    L16:
        return new Pair(getBluetoothDrawable(r6, HidProfile.getHidClassDrawable(r0)), r6.getString(R.string.bluetooth_talkback_input_peripheral));
    L18:
        return new Pair(getBluetoothDrawable(r6, android.R.drawable.pointer_alias_large_icon), r6.getString(R.string.bluetooth_talkback_phone));
    L20:
        return new Pair(getBluetoothDrawable(r6, android.R.drawable.ic_menu_cc), r6.getString(R.string.bluetooth_talkback_computer));
    L22:
        if (r7.isHearingAidDevice() == true) goto L24;
        Iterator<LocalBluetoothProfile> r8 = r7.getProfiles().iterator();
        int r2 = 0;
    L27:
        if (r8.hasNext() == false) goto L39;
        LocalBluetoothProfile r3 = r8.next();
        int r4 = r3.getDrawableResource(r0);
        if (r4 == 0) goto L27;
        if ((r3 instanceof HearingAidProfile) == true) goto L38;
        if ((r3 instanceof HapClientProfile) == true) goto L38;
        if (r2 != 0) goto L27;
        r2 = r4;
    L38:
        return new Pair(getBluetoothDrawable(r6, r4), r6.getString(R.string.bluetooth_talkback_hearing_aids));
    L39:
        if (r2 != 0) goto L41;
        if (r0 == null) goto L52;
        if (doesClassMatch(r0, 0) == false) goto L48;
        return new Pair(getBluetoothDrawable(r6, android.R.drawable.ic_menu_blocked_user), r6.getString(R.string.bluetooth_talkback_headset));
    L48:
        if (doesClassMatch(r0, 1) == false) goto L52;
        return new Pair(getBluetoothDrawable(r6, android.R.drawable.ic_menu_block), r6.getString(R.string.bluetooth_talkback_headphone));
    L52:
        return new Pair(getBluetoothDrawable(r6, android.R.drawable.pointer_crosshair_large_icon).mutate(), r6.getString(R.string.bluetooth_talkback_bluetooth));
    L41:
        return new Pair(getBluetoothDrawable(r6, r2), null);
    L24:
        return new Pair(getBluetoothDrawable(r6, android.R.drawable.ic_menu_btn_add), r6.getString(R.string.bluetooth_talkback_hearing_aids));
    }

    public static Drawable getBluetoothDrawable(Context r0, int r1) {
        return r0.getDrawable(r1);
    }

    public static Pair<Drawable, String> getBtRainbowDrawableWithDescription(Context r3, CachedBluetoothDevice r4) {
        Resources r0 = r3.getResources();
        Pair<Drawable, String> r1 = getBtDrawableWithDescription(r3, r4);
        if ((r1.first instanceof BitmapDrawable) == false) goto L7;
        return new Pair(new AdaptiveOutlineDrawable(r0, ((BitmapDrawable) r1.first).getBitmap()), (String) r1.second);
    L7:
        if (r4.getGroupId() == (-1)) goto L9;
        int r5 = new Integer(r4.getGroupId()).hashCode();
    L11:
        return new Pair(buildBtRainbowDrawable(r3, (Drawable) r1.first, r5), (String) r1.second);
    L9:
        r5 = r4.getAddress().hashCode();
        goto L11
    }

    private static Drawable buildBtRainbowDrawable(Context r3, Drawable r4, int r5) {
        Resources r0 = r3.getResources();
        int[] r1 = r0.getIntArray(R.array.bt_icon_fg_colors);
        int[] r2 = r0.getIntArray(R.array.bt_icon_bg_colors);
        int r6 = Math.abs(r5 % r2.length);
        r4.setTint(r1[r6]);
        AdaptiveIcon r7 = new AdaptiveIcon(r3, r4);
        r7.setBackgroundColor(r2[r6]);
        return r7;
    }

    public static Pair<Drawable, String> getBtDrawableWithDescription(Context r7, CachedBluetoothDevice r8) {
        Pair<Drawable, String> r1 = getBtClassDrawableWithDescription(r7, r8);
        BluetoothDevice r9 = r8.getDevice();
        int r2 = r7.getResources().getDimensionPixelSize(R.dimen.bt_nearby_icon_size);
        Resources r3 = r7.getResources();
        if (isAdvancedDetailsHeader(r9) == false) goto L19;
        Uri r10 = getUriMetaData(r9, 5);
        if (r10 == null) goto L19;
        r7.getContentResolver().takePersistableUriPermission(r10, 1);     // Catch: SecurityException -> L8
    L22:
        Bitmap r11 = MediaStore.Images.Media.getBitmap(r7.getContentResolver(), r10);     // Catch: SecurityException -> L14 IOException -> L16
        if (r11 == null) goto L19;
        Bitmap r4 = Bitmap.createScaledBitmap(r11, r2, r2, false);     // Catch: SecurityException -> L14 IOException -> L16
        r11.recycle();     // Catch: SecurityException -> L14 IOException -> L16
        return new Pair(new BitmapDrawable(r3, r4), (String) r1.second);
    L16:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Failed to get drawable for: " + r10, e);
    L14:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Failed to get permission for: " + r10, e);
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Failed to take persistable permission for: " + r10, e);
    L19:
        return new Pair((Drawable) r1.first, (String) r1.second);
    }

    public static boolean isAdvancedDetailsHeader(BluetoothDevice r4) {
        if (isAdvancedHeaderEnabled() == true) goto L6;
        return false;
    L6:
        if (isUntetheredHeadset(r4) == false) goto L9;
        return true;
    L9:
        if (Flags.enableDeterminingAdvancedDetailsHeaderWithMetadata() == true) goto L11;
        String r5 = getStringMetaData(r4, 17);
        if (TextUtils.equals(r5, "Untethered Headset") == false) goto L18;
    L25:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "isAdvancedDetailsHeader: deviceType is " + r5);
        return true;
    L18:
        if (TextUtils.equals(r5, "Watch") == true) goto L25;
        if (TextUtils.equals(r5, "Default") == true) goto L25;
        if (TextUtils.equals(r5, "Stylus") == true) goto L25;
        return false;
    L11:
        if (getUriMetaData(r4, 5) == null) goto L14;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "isAdvancedDetailsHeader is true with main icon uri");
        return true;
    L14:
        return false;
    }

    public static boolean isAdvancedUntetheredDevice(BluetoothDevice r3) {
        if (isAdvancedHeaderEnabled() == true) goto L6;
        return false;
    L6:
        if (isUntetheredHeadset(r3) == false) goto L9;
        return true;
    L9:
        if (Flags.enableDeterminingAdvancedDetailsHeaderWithMetadata() == false) goto L11;
    L14:
        return false;
    L11:
        if (TextUtils.equals(getStringMetaData(r3, 17), "Untethered Headset") == false) goto L14;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "isAdvancedUntetheredDevice: is untethered device");
        return true;
    }

    public static boolean isDeviceClassMatched(BluetoothDevice r0, int r1) {
        BluetoothClass r2 = r0.getBluetoothClass();
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.getDeviceClass() != r1) goto L7;
        return true;
    }

    private static boolean isAdvancedHeaderEnabled() {
        if (DeviceConfig.getBoolean("settings_ui", BT_ADVANCED_HEADER_ENABLED, true) == true) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "isAdvancedDetailsHeader: advancedEnabled is false");
        return false;
    L6:
        return true;
    }

    private static boolean isUntetheredHeadset(BluetoothDevice r1) {
        if (getBooleanMetaData(r1, 6) == false) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "isAdvancedDetailsHeader: untetheredHeadset is true");
        return true;
    L6:
        return false;
    }

    public static IconCompat createIconWithDrawable(Drawable r3) {
        if ((r3 instanceof BitmapDrawable) == false) goto L5;
        Bitmap r4 = ((BitmapDrawable) r3).getBitmap();
    L14:
        return IconCompat.createWithBitmap(r4);
    L5:
        int r0 = r3.getIntrinsicWidth();
        int r1 = r3.getIntrinsicHeight();
        if (r0 > 0) goto L9;
        r0 = 1;
    L9:
        if (r1 > 0) goto L12;
        r1 = 1;
    L12:
        r4 = createBitmap(r3, r0, r1);
        goto L14
    }

    public static Drawable buildAdvancedDrawable(Context r4, Drawable r5) {
        int r0 = r4.getResources().getDimensionPixelSize(R.dimen.advanced_icon_size);
        Resources r6 = r4.getResources();
        if ((r5 instanceof BitmapDrawable) == false) goto L5;
        Bitmap r1 = ((BitmapDrawable) r5).getBitmap();
    L13:
        if (r1 == null) goto L16;
        Bitmap r7 = Bitmap.createScaledBitmap(r1, r0, r0, false);
        r1.recycle();
        return new AdaptiveOutlineDrawable(r6, r7, 1);
    L16:
        return r5;
    L5:
        int r2 = r5.getIntrinsicWidth();
        int r3 = r5.getIntrinsicHeight();
        if (r2 > 0) goto L9;
        r2 = 1;
    L9:
        if (r3 > 0) goto L12;
        r3 = 1;
    L12:
        r1 = createBitmap(r5, r2, r3);
        goto L13
    }

    public static Bitmap createBitmap(Drawable r3, int r4, int r5) {
        Bitmap r6 = Bitmap.createBitmap(r4, r5, Bitmap.Config.ARGB_8888);
        Canvas r7 = new Canvas(r6);
        r3.setBounds(0, 0, r7.getWidth(), r7.getHeight());
        r3.draw(r7);
        return r6;
    }

    public static boolean getBooleanMetaData(BluetoothDevice r1, int r2) {
        if (r1 != null) goto L5;
        return false;
    L5:
        byte[] r3 = r1.getMetadata(r2);
        if (r3 != null) goto L9;
        return false;
    L9:
        return Boolean.parseBoolean(new String(r3));
    }

    public static String getStringMetaData(BluetoothDevice r1, int r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        byte[] r3 = r1.getMetadata(r2);
        if (r3 != null) goto L9;
        return null;
    L9:
        return new String(r3);
    }

    public static int getIntMetaData(BluetoothDevice r1, int r2) {
        if (r1 != null) goto L5;
        return -1;
    L5:
        byte[] r3 = r1.getMetadata(r2);
        if (r3 != null) goto L11;
        return -1;
    L11:
        return Integer.parseInt(new String(r3));
    L10:
        return -1;
    }

    public static Uri getUriMetaData(BluetoothDevice r0, int r1) {
        String r2 = getStringMetaData(r0, r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return Uri.parse(r2);
    }

    public static String getControlUriMetaData(BluetoothDevice r1) {
        return extraTagValue(KEY_HEARABLE_CONTROL_SLICE, getStringMetaData(r1, 25));
    }

    public static boolean isAvailableMediaBluetoothDevice(CachedBluetoothDevice r3, AudioManager r4) {
        int r5 = r4.getMode();
        if (r5 == 1) goto L9;
        if (r5 == 2) goto L9;
        if (r5 == 3) goto L9;
        char r6 = 2;
    L11:
        if (isDeviceConnected(r3) == true) goto L13;
    L24:
        return false;
    L13:
        if (r3.isConnectedAshaHearingAidDevice() == false) goto L15;
    L22:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "isFilterMatched() device : " + r3.getName() + ", the profile is connected.");
        return true;
    L15:
        if (r3.isConnectedLeAudioDevice() == true) goto L22;
        if (r6 == 1) goto L27;
        if (r6 != 2) goto L24;
        return r3.isConnectedA2dpDevice();
    L27:
        return r3.isConnectedHfpDevice();
    L9:
        r6 = 1;
        goto L11
    }

    public static boolean isAudioSharingEnabled() {
        BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();
    L11:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "LE state is on, but there is no bluetooth service.", e);
        return false;
    L4:
        if (Flags.enableLeAudioSharing() == true) goto L6;
        return false;
    L6:
        if (r0.isLeAudioBroadcastSourceSupported() != 10) goto L17;
        if (r0.isLeAudioBroadcastAssistantSupported() != 10) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    public static boolean isBroadcasting(LocalBluetoothManager r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        LocalBluetoothLeBroadcast r3 = r2.getProfileManager().getLeAudioBroadcastProfile();
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r3.isEnabled(null) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean hasConnectedBroadcastSource(CachedBluetoothDevice r6, LocalBluetoothManager r7) {
        if (r7 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Skip check hasConnectedBroadcastSource due to bt manager is null");
        return false;
    L6:
        LocalBluetoothLeBroadcastAssistant r8 = r7.getProfileManager().getLeAudioBroadcastAssistantProfile();
        if (r8 != null) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Skip check hasConnectedBroadcastSource due to assistant profile is null");
        return false;
    L10:
        List<BluetoothLeBroadcastReceiveState> r2 = r8.getAllSources(r6.getDevice());
        if (r2.isEmpty() == false) goto L13;
    L16:
        Iterator<CachedBluetoothDevice> r9 = r6.getMemberDevice().iterator();
    L18:
        if (r9.hasNext() == false) goto L25;
        CachedBluetoothDevice r3 = r9.next();
        List<BluetoothLeBroadcastReceiveState> r4 = r8.getAllSources(r3.getDevice());
        if (r4.isEmpty() == true) goto L18;
        if (r4.stream().anyMatch(new BluetoothUtils$$ExternalSyntheticLambda1()) == false) goto L18;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Member device has connected broadcast source, device = " + r3.getDevice().getAnonymizedAddress());
        return true;
    L25:
        return false;
    L13:
        if (r2.stream().anyMatch(new BluetoothUtils$$ExternalSyntheticLambda1()) == false) goto L16;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Lead device has connected broadcast source, device = " + r6.getDevice().getAnonymizedAddress());
        return true;
    }

    public static boolean isConnected(BluetoothLeBroadcastReceiveState r1) {
        return r1.getBisSyncState().stream().anyMatch(new BluetoothUtils$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ boolean lambda$isConnected$0(Long r4) {
        if (r4.longValue() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAvailableHearingDevice(CachedBluetoothDevice r2) {
        if (isDeviceConnected(r2) == true) goto L5;
        return false;
    L5:
        if (r2.isConnectedHearingAidDevice() == false) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "isFilterMatched() device : " + r2.getName() + ", the profile is connected.");
        return true;
    L10:
        return false;
    }

    public static boolean isConnectedBluetoothDevice(CachedBluetoothDevice r4, AudioManager r5) {
        int r6 = r5.getMode();
        if (r6 == 1) goto L9;
        if (r6 == 2) goto L9;
        if (r6 == 3) goto L9;
        char r7 = 2;
    L11:
        if (isDeviceConnected(r4) == true) goto L13;
        return false;
    L13:
        if (r4.isConnectedAshaHearingAidDevice() == false) goto L15;
        return false;
    L15:
        if (r4.isConnectedLeAudioDevice() == true) goto L26;
        if (r7 == 1) goto L21;
        if (r7 != 2) goto L27;
        boolean r8 = r4.isConnectedA2dpDevice();
    L23:
        return !r8;
    L27:
        return false;
    L21:
        r8 = r4.isConnectedHfpDevice();
        goto L23
    L26:
        return false;
    L9:
        r7 = 1;
        goto L11
    }

    public static boolean isActiveMediaDevice(CachedBluetoothDevice r2) {
        if (r2.isActiveDevice(2) == false) goto L5;
        return true;
    L5:
        if (r2.isActiveDevice(1) == false) goto L7;
        return true;
    L7:
        if (r2.isActiveDevice(21) == false) goto L9;
        return true;
    L9:
        if (r2.isActiveDevice(22) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public static boolean isActiveLeAudioDevice(CachedBluetoothDevice r1) {
        return r1.isActiveDevice(22);
    }

    private static boolean isDeviceConnected(CachedBluetoothDevice r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        BluetoothDevice r4 = r3.getDevice();
        if (r4.getBondState() == 12) goto L8;
        return false;
    L8:
        if (r4.isConnected() == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean doesClassMatch(BluetoothClass r0, int r1) {
        return r0.doesClassMatch(r1);
    }

    private static String extraTagValue(String r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return null;
    L5:
        Matcher r4 = Pattern.compile(generateExpressionWithTag(r2, "(.*?)")).matcher(r3);
        if (r4.find() == true) goto L8;
        return null;
    L8:
        return r4.group(1);
    }

    private static String getTagStart(String r3) {
        return String.format(Locale.ENGLISH, "<%s>", new Object[]{r3});
    }

    private static String getTagEnd(String r3) {
        return String.format(Locale.ENGLISH, "</%s>", new Object[]{r3});
    }

    private static String generateExpressionWithTag(String r2, String r3) {
        return getTagStart(r2) + r3 + getTagEnd(r2);
    }

    private static String getExclusiveManager(BluetoothDevice r2) {
        byte[] r0 = r2.getMetadata(29);
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Bluetooth device " + r2.getName() + " doesn't have exclusive manager");
        return null;
    L7:
        return new String(r0);
    }

    private static boolean isPackageInstalledAndEnabled(Context r2, String r3) {
        return r2.getPackageManager().getApplicationInfo(r3, 0).enabled;
    L5:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Package " + r3 + " is not installed/enabled");
        return false;
    }

    public static boolean isExclusivelyManagedBluetoothDevice(Context r2, BluetoothDevice r3) {
        String r4 = getExclusiveManager(r3);
        if (r4 != null) goto L5;
        return false;
    L5:
        ComponentName r1 = ComponentName.unflattenFromString(r4);
        if (r1 == null) goto L9;
        r4 = r1.getPackageName();
    L9:
        if (isPackageInstalledAndEnabled(r2, r4) == true) goto L11;
        return false;
    L11:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Found exclusively managed app " + r4);
        return true;
    }

    public static int getGroupId(CachedBluetoothDevice r6) {
        int r0 = r6.getGroupId();
        String r1 = r6.getDevice().getAnonymizedAddress();
        if (r0 == (-1)) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "getGroupId by CSIP profile for device: " + r1);
        return r0;
    L6:
        Iterator<LocalBluetoothProfile> r2 = r6.getProfiles().iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        LocalBluetoothProfile r4 = r2.next();
        if ((r4 instanceof LeAudioProfile) == false) goto L8;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "getGroupId by LEA profile for device: " + r1);
        return ((LeAudioProfile) r4).getGroupId(r6.getDevice());
    L13:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "getGroupId return invalid id for device: " + r1);
        return -1;
    }
}
