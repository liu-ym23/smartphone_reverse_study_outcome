package com.bytedanceos.security.permission;

import android.os.Build;
import android.text.TextUtils;
import com.bytedanceos.security.multi.adpter.MultiSdkAdapter;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.bytedanceos.security.reflect.SpecialAppOpsManager;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NativePermissionManager {
    public static final String NATIVE_PERMISSION_ACCESS_BACKGROUND_LOCATION = "android.permission.ACCESS_BACKGROUND_LOCATION";
    public static final String NATIVE_PERMISSION_ACCESS_MEDIA_LOCATION = "android.permission.ACCESS_MEDIA_LOCATION";
    public static final String NATIVE_PERMISSION_ACTIVITY_RECOGNITION = "android.permission.ACTIVITY_RECOGNITION";
    public static final String NATIVE_PERMISSION_MANAGE_EXTERNAL_STORAGE = "android.permission.MANAGE_EXTERNAL_STORAGE";
    private static List<NativePermission> PERMISSIONS = null;
    public static final String PERMISSION_ACCESS_MOBILE = "PERMISSION_ACCESS_MOBILE";
    public static final String PERMISSION_ACCESS_WIFI = "PERMISSION_PERMISSION_ACCESS_WIFI";
    public static final String PERMISSION_AUDIO = "PERMISSION_AUDIO";
    public static final String PERMISSION_AUTOSTART = "PERMISSION_AUTOSTART";
    public static final String PERMISSION_BLUETOOTH = "PERMISSION_BLUETOOTH";
    public static final String PERMISSION_BODY = "PERMISSION_BODY";
    public static final String PERMISSION_BOOKMARK = "PERMISSION_PERMISSION_BOOKMARK";
    public static final String PERMISSION_CAMERA = "PERMISSION_CAMERA";
    public static final String PERMISSION_GET_ACCOUNTS = "PERMISSION_GET_ACCOUNTS";
    public static final String PERMISSION_INSTALL_UNKONW_RESOURCE = "PERMISSION_INSTALL_UNKONW_RESOURCE";
    public static final String PERMISSION_KILL_BACKGROUND_PROCESSES = "PERMISSION_KILL_BACKGROUND_PROCESSES";
    public static final String PERMISSION_LOCATION = "PERMISSION_LOCATION";
    public static final String PERMISSION_NFC = "PERMISSION_PERMISSION_NFC";
    public static final String PERMISSION_OPEN_MOBILE = "PERMISSION_OPEN_MOBILE";
    public static final String PERMISSION_OPEN_WIFI = "PERMISSION_PERMISSION_OPEN_WIFI";
    public static final String PERMISSION_PHONE = "PERMISSION_PHONE";
    public static final String PERMISSION_PROCESS_OUTGOING_CALLS = "PERMISSION_PROCESS_OUTGOING_CALLS";
    public static final String PERMISSION_READ_CALENDAR = "PERMISSION_READ_CALENDAR";
    public static final String PERMISSION_READ_CALLLOG = "PERMISSION_READ_CALLLOG";
    public static final String PERMISSION_READ_CONTACTS = "PERMISSION_READ_CONTACTS";
    public static final String PERMISSION_READ_MEDIA_AUDIO = "PERMISSION_READ_MEDIA_AUDIO";
    public static final String PERMISSION_READ_MEDIA_IMAGES = "PERMISSION_READ_MEDIA_IMAGES";
    public static final String PERMISSION_READ_MEDIA_VIDEO = "PERMISSION_READ_MEDIA_VIDEO";
    public static final String PERMISSION_READ_PHONE_STATE = "PERMISSION_READ_PHONE_STATE";
    public static final String PERMISSION_READ_SMS = "PERMISSION_READ_SMS";
    public static final String PERMISSION_RECIVE_BOOT_COMPLETE = "PERMISSION_RECIVE_BOOT_COMPLETE";
    public static final String PERMISSION_RECIVE_SMS = "PERMISSION_RECIVE_SMS";
    public static final String PERMISSION_SEND_SMS = "PERMISSION_SEND_SMS";
    public static final String PERMISSION_SENSORS = "PERMISSION_SENSORS";
    public static final String PERMISSION_SHOW_ON_KEYGUARD = "PERMISSION_SHOW_ON_KEYGUARD";
    public static final String PERMISSION_SIP = "PERMISSION_SIP";
    public static final String PERMISSION_START_ON_BACKGROUND = "PERMISSION_START_ON_BACKGROUND";
    public static final String PERMISSION_STORAGE = "PERMISSION_READ_STORAGE";
    public static final String PERMISSION_STORAGE_ALL = "PERMISSION_READ_STORAGE_ALL";
    public static final String PERMISSION_SYSTEM_WINDOW = "PERMISSION_SYSTEM_WINDOW";
    public static final String PERMISSION_VOICEMAIL = "PERMISSION_VOICEMAIL";
    public static final String PERMISSION_WRITE_CALENDAR = "PERMISSION_WRITE_CALENDAR";
    public static final String PERMISSION_WRITE_CALLLOG = "PERMISSION_WRITE_CALLLOG";
    public static final String PERMISSION_WRITE_CONTACTS = "PERMISSION_WRITE_CONTACTS";
    public static final String PERMISSION_WRITE_SETTINGS = "PERMISSION_WRITE_SETTINGS";

    public static final class DANGEROUS_GROUP {
        public static final String CALENDAR = "android.permission-group.CALENDAR";
        public static final String CALL_LOG = "android.permission-group.CALL_LOG";
        public static final String CAMERA = "android.permission-group.CAMERA";
        public static final String CONTACTS = "android.permission-group.CONTACTS";
        public static final String LOCATION = "android.permission-group.LOCATION";
        public static final String MICROPHONE = "android.permission-group.MICROPHONE";
        public static final String PHONE = "android.permission-group.PHONE";
        public static final String SENSORS = "android.permission-group.SENSORS";
        public static final String SMS = "android.permission-group.SMS";
        public static final String STORAGE = "android.permission-group.STORAGE";
        public static final String STORAGE_ALL = "android.permission-group.STORAGE_ALL";

        public DANGEROUS_GROUP() {
        }
    }

    public NativePermissionManager() {
    }

    static {
        PERMISSIONS = new ArrayList();
        NativePermission r0 = new NativePermission(2, 2, PERMISSION_LOCATION, R.string.permission_location, DANGEROUS_GROUP.LOCATION, OpsManagerHelper.get_OP_LOCATION(), 1, PERMISSIONS.size(), new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"});
        if (MultiSdkAdapter.isAfterQ() == false) goto L5;
        r0.setBackgroundPermission(NATIVE_PERMISSION_ACCESS_BACKGROUND_LOCATION);
        r0.setShowMode(2);
    L5:
        PERMISSIONS.add(r0);
        PERMISSIONS.add(new NativePermission(3, 2, PERMISSION_PHONE, R.string.call_phone, DANGEROUS_GROUP.PHONE, OpsManagerHelper.get_OP_CALL_PHONE(), 1, PERMISSIONS.size(), new String[]{"android.permission.CALL_PHONE"}));
        PERMISSIONS.add(new NativePermission(3, 2, PERMISSION_READ_PHONE_STATE, R.string.permission_read_phone_state, DANGEROUS_GROUP.PHONE, OpsManagerHelper.get_OP_READ_PHONE_STATE(), 1, PERMISSIONS.size(), new String[]{"android.permission.READ_PHONE_STATE"}));
        PERMISSIONS.add(new NativePermission(3, 2, PERMISSION_READ_CALLLOG, R.string.read_call_log, DANGEROUS_GROUP.CALL_LOG, OpsManagerHelper.get_OP_READ_CALL_LOG(), 1, PERMISSIONS.size(), new String[]{"android.permission.READ_CALL_LOG"}));
        PERMISSIONS.add(new NativePermission(3, 2, PERMISSION_WRITE_CALLLOG, R.string.write_call_log, DANGEROUS_GROUP.CALL_LOG, OpsManagerHelper.get_OP_WRITE_CALL_LOG(), 1, PERMISSIONS.size(), new String[]{"android.permission.WRITE_CALL_LOG"}));
        PERMISSIONS.add(new NativePermission(3, 2, PERMISSION_READ_CONTACTS, R.string.read_contacts, DANGEROUS_GROUP.CONTACTS, OpsManagerHelper.get_OP_READ_CONTACTS(), 1, PERMISSIONS.size(), new String[]{"android.permission.READ_CONTACTS"}));
        PERMISSIONS.add(new NativePermission(3, 2, PERMISSION_WRITE_CONTACTS, R.string.write_contacts, DANGEROUS_GROUP.CONTACTS, OpsManagerHelper.get_OP_WRITE_CONTACTS(), 1, PERMISSIONS.size(), new String[]{"android.permission.WRITE_CONTACTS"}));
        PERMISSIONS.add(new NativePermission(3, 2, PERMISSION_GET_ACCOUNTS, R.string.permission_getaccounts, DANGEROUS_GROUP.CONTACTS, -1, 1, PERMISSIONS.size(), new String[]{"android.permission.GET_ACCOUNTS"}));
        PERMISSIONS.add(new NativePermission(3, 2, PERMISSION_SIP, R.string.permission_sip, DANGEROUS_GROUP.PHONE, -1, 1, PERMISSIONS.size(), new String[]{"android.permission.USE_SIP"}));
        PERMISSIONS.add(new NativePermission(3, 2, PERMISSION_PROCESS_OUTGOING_CALLS, R.string.permission_outgoing_call, DANGEROUS_GROUP.PHONE, -1, 1, PERMISSIONS.size(), new String[]{"android.permission.PROCESS_OUTGOING_CALLS"}));
        PERMISSIONS.add(new NativePermission(4, 2, PERMISSION_READ_SMS, R.string.permission_read_sms_mms, DANGEROUS_GROUP.SMS, OpsManagerHelper.get_OP_READ_SMS(), 1, PERMISSIONS.size(), new String[]{"android.permission.READ_SMS"}));
        PERMISSIONS.add(new NativePermission(4, 2, PERMISSION_RECIVE_SMS, R.string.permission_recive_sms, DANGEROUS_GROUP.SMS, -1, 1, PERMISSIONS.size(), new String[]{"android.permission.RECEIVE_SMS", "android.permission.RECEIVE_MMS", "android.permission.RECEIVE_WAP_PUSH"}));
        PERMISSIONS.add(new NativePermission(4, 2, PERMISSION_SEND_SMS, R.string.send_sms, DANGEROUS_GROUP.SMS, OpsManagerHelper.get_OP_SEND_SMS(), 1, PERMISSIONS.size(), new String[]{"android.permission.SEND_SMS"}));
        PERMISSIONS.add(new NativePermission(5, 2, PERMISSION_READ_CALENDAR, R.string.permission_read_calendar, DANGEROUS_GROUP.CALENDAR, -1, 1, PERMISSIONS.size(), new String[]{"android.permission.READ_CALENDAR"}));
        PERMISSIONS.add(new NativePermission(5, 2, PERMISSION_WRITE_CALENDAR, R.string.permission_write_calendar, DANGEROUS_GROUP.CALENDAR, -1, 1, PERMISSIONS.size(), new String[]{"android.permission.WRITE_CALENDAR"}));
        PERMISSIONS.add(new NativePermission(6, 2, PERMISSION_CAMERA, R.string.permission_camera, DANGEROUS_GROUP.CAMERA, OpsManagerHelper.get_OP_CAMERA(), 1, PERMISSIONS.size(), new String[]{"android.permission.CAMERA"}));
        PERMISSIONS.add(new NativePermission(6, 2, PERMISSION_AUDIO, R.string.record_audio, DANGEROUS_GROUP.MICROPHONE, OpsManagerHelper.get_OP_RECORD_AUDIO(), 1, PERMISSIONS.size(), new String[]{"android.permission.RECORD_AUDIO"}));
        PERMISSIONS.add(new NativePermission(7, 2, PERMISSION_STORAGE, R.string.permission_storage, DANGEROUS_GROUP.STORAGE, -1, 1, PERMISSIONS.size(), new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", NATIVE_PERMISSION_ACCESS_MEDIA_LOCATION}));
        if (Build.VERSION.SDK_INT < 33) goto L8;
        PERMISSIONS.add(new NativePermission(7, 2, PERMISSION_READ_MEDIA_AUDIO, R.string.permission_read_audio, DANGEROUS_GROUP.STORAGE, -1, 1, PERMISSIONS.size(), new String[]{"android.permission.READ_MEDIA_AUDIO"}));
        PERMISSIONS.add(new NativePermission(7, 2, PERMISSION_READ_MEDIA_IMAGES, R.string.permission_read_images, DANGEROUS_GROUP.STORAGE, -1, 1, PERMISSIONS.size(), new String[]{"android.permission.READ_MEDIA_IMAGES"}));
        PERMISSIONS.add(new NativePermission(7, 2, PERMISSION_READ_MEDIA_VIDEO, R.string.permission_read_video, DANGEROUS_GROUP.STORAGE, -1, 1, PERMISSIONS.size(), new String[]{"android.permission.READ_MEDIA_VIDEO"}));
    L8:
        PERMISSIONS.add(new NativePermission(7, 3, PERMISSION_STORAGE_ALL, R.string.permission_storage_all, DANGEROUS_GROUP.STORAGE, -1, 1, PERMISSIONS.size(), new String[]{"android.permission.MANAGE_EXTERNAL_STORAGE"}));
        PERMISSIONS.add(new NativePermission(8, 1, PERMISSION_OPEN_WIFI, R.string.change_wifi_state, null, OpsManagerHelper.get_OP_WIFI_CHANGE(), 3, PERMISSIONS.size(), new String[]{"android.permission.CHANGE_WIFI_STATE"}));
        PERMISSIONS.add(new NativePermission(8, 1, PERMISSION_ACCESS_MOBILE, R.string.net_mobile, null, OpsManagerHelper.get_OP_NET_MOBILE(), 1, PERMISSIONS.size(), new String[]{"android.permission.INTERNET"}));
        PERMISSIONS.add(new NativePermission(8, 1, PERMISSION_ACCESS_WIFI, R.string.net_wlan, null, OpsManagerHelper.get_OP_NET_WIFI(), 1, PERMISSIONS.size(), new String[]{"android.permission.INTERNET"}));
        PERMISSIONS.add(new NativePermission(8, 1, PERMISSION_NFC, R.string.nfc, null, OpsManagerHelper.get_OP_NFC_CHANGE(), 3, PERMISSIONS.size(), new String[]{"android.permission.NFC"}));
        PERMISSIONS.add(new NativePermission(8, 1, PERMISSION_BLUETOOTH, R.string.bluetooth, null, OpsManagerHelper.get_OP_BLUETOOTH_CHANGE(), 3, PERMISSIONS.size(), new String[]{"android.permission.BLUETOOTH"}));
        PERMISSIONS.add(new NativePermission(9, 2, PERMISSION_VOICEMAIL, R.string.permission_voicemail, DANGEROUS_GROUP.PHONE, -1, 1, PERMISSIONS.size(), new String[]{"com.android.voicemail.permission.ADD_VOICEMAIL"}));
        PERMISSIONS.add(new NativePermission(9, 2, PERMISSION_SENSORS, R.string.permission_sensor, DANGEROUS_GROUP.SENSORS, -1, 1, PERMISSIONS.size(), new String[]{"android.permission.BODY_SENSORS"}));
        if (MultiSdkAdapter.isAfterQ() == false) goto L11;
        PERMISSIONS.add(new NativePermission(9, 2, PERMISSION_BODY, R.string.permission_body, DANGEROUS_GROUP.SENSORS, -1, 1, PERMISSIONS.size(), new String[]{NATIVE_PERMISSION_ACTIVITY_RECOGNITION}));
    L11:
        PERMISSIONS.add(new NativePermission(9, 1, PERMISSION_INSTALL_UNKONW_RESOURCE, R.string.install_unknown_app, null, OpsManagerHelper.get_OP_REQUEST_INSTALL_PACKAGES(), 1, PERMISSIONS.size(), new String[]{"android.permission.REQUEST_INSTALL_PACKAGES"}));
        PERMISSIONS.add(new NativePermission(9, 1, PERMISSION_WRITE_SETTINGS, R.string.permission_write_settings, null, SpecialAppOpsManager.getWriteSettingsVirtualCode(), 1, PERMISSIONS.size(), new String[]{"android.permission.WRITE_SETTINGS"}));
        PERMISSIONS.add(new NativePermission(9, 1, PERMISSION_START_ON_BACKGROUND, R.string.start_on_background, null, OpsManagerHelper.get_OP_START_ON_BACKGROUND(), 1, PERMISSIONS.size(), null));
        PERMISSIONS.add(new NativePermission(9, 1, PERMISSION_SYSTEM_WINDOW, R.string.system_alert_window, null, SpecialAppOpsManager.getSystemAlertWindowVirtualCode(), 1, PERMISSIONS.size(), new String[]{"android.permission.SYSTEM_ALERT_WINDOW"}));
        PERMISSIONS.add(new NativePermission(9, 1, PERMISSION_SHOW_ON_KEYGUARD, R.string.show_on_keyguard, null, OpsManagerHelper.get_OP_SHOW_ON_KEYGUARD(), 1, PERMISSIONS.size(), null));
        PERMISSIONS.add(new NativePermission(9, 1, PERMISSION_BOOKMARK, R.string.write_history_bookmarks, null, OpsManagerHelper.get_OP_WRITE_BOOKMARK(), 3, PERMISSIONS.size(), new String[]{"com.android.browser.permission.WRITE_HISTORY_BOOKMARKS"}));
    }

    public static List<NativePermission> getGroupPermissions(int groupType) {
        ArrayList r0 = new ArrayList();
        Iterator<NativePermission> r1 = PERMISSIONS.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        NativePermission r2 = r1.next();
        if (r2.getGroupType() != groupType) goto L4;
        r0.add(r2);
        goto L4
    L8:
        return r0;
    }

    public static List<NativePermission> getAllPermissions() {
        return PERMISSIONS;
    }

    public static List<NativePermissionGroup> getAllGroups() {
        ArrayList r0 = new ArrayList();
        r0.add(new NativePermissionGroup(1, R.string.bootable_group_title));
        r0.add(new NativePermissionGroup(2, R.string.permission_location));
        r0.add(new NativePermissionGroup(3, R.string.phone_contact_permission_title));
        r0.add(new NativePermissionGroup(4, R.string.mms_tab_title));
        r0.add(new NativePermissionGroup(5, R.string.permission_title_calendar));
        r0.add(new NativePermissionGroup(6, R.string.media_group_title));
        r0.add(new NativePermissionGroup(7, R.string.permission_title_storage));
        r0.add(new NativePermissionGroup(8, R.string.permission_title_net));
        r0.add(new NativePermissionGroup(9, R.string.other_group_title));
        return r0;
    }

    public static NativePermission getPermissionByName(String name) {
        if (TextUtils.isEmpty(name) == false) goto L5;
        return null;
    L5:
        Iterator<NativePermission> r0 = PERMISSIONS.iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        NativePermission r2 = r0.next();
        if (TextUtils.equals(r2.getPermissionName(), name) == false) goto L7;
        return r2;
    L11:
        return null;
    }
}
