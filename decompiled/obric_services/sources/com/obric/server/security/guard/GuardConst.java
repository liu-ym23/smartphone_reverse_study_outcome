package com.obric.server.security.guard;

import com.android.server.voiceinteraction.ObricVoiceInteractionSessionConnectionImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class GuardConst {
    public static final String COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";
    public static final Map<String, String> DEFAULT_PER_POLICY = null;
    public static final String FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    public static final Map<String, String> PERMISSION_TO_GROUP = null;
    public static final Set<String> VALID_ACCESS_APPS = null;

    public GuardConst() {
    }

    static {
        VALID_ACCESS_APPS = new HashSet(Arrays.asList(new String[]{"com.bytedance.securityserver", "com.android.permissioncontroller", ObricVoiceInteractionSessionConnectionImpl.COM_LARUS_NOVA}));
        DEFAULT_PER_POLICY = new HashMap();
        DEFAULT_PER_POLICY.put("android.permission-group.SENSORS", "duringUse");
        DEFAULT_PER_POLICY.put("android.permission-group.READ_MEDIA_VISUAL", "duringUse");
        DEFAULT_PER_POLICY.put("android.permission-group.READ_MEDIA_AURAL", "duringUse");
        DEFAULT_PER_POLICY.put("android.permission-group.CAMERA", "duringUse");
        DEFAULT_PER_POLICY.put("android.permission-group.MICROPHONE", "duringUse");
        DEFAULT_PER_POLICY.put("android.permission-group.CONTACTS", "duringUse");
        DEFAULT_PER_POLICY.put("android.permission-group.CALENDAR", "duringUse");
        DEFAULT_PER_POLICY.put("android.permission-group.CALL_LOG", "duringUse");
        DEFAULT_PER_POLICY.put(FINE_LOCATION, "duringUse");
        DEFAULT_PER_POLICY.put(COARSE_LOCATION, "duringUse");
        PERMISSION_TO_GROUP = new HashMap();
        PERMISSION_TO_GROUP.put("android.permission.ACCEPT_HANDOVER", "android.permission-group.PHONE");
        PERMISSION_TO_GROUP.put("android.permission.ADD_VOICEMAIL", "android.permission-group.PHONE");
        PERMISSION_TO_GROUP.put("android.permission.CALL_PHONE", "android.permission-group.PHONE");
        PERMISSION_TO_GROUP.put("android.permission.ANSWER_PHONE_CALLS", "android.permission-group.PHONE");
        PERMISSION_TO_GROUP.put("android.permission.READ_PHONE_STATE", "android.permission-group.PHONE");
        PERMISSION_TO_GROUP.put("android.permission.READ_PHONE_NUMBERS", "android.permission-group.PHONE");
        PERMISSION_TO_GROUP.put("android.permission.USE_SIP", "android.permission-group.PHONE");
        PERMISSION_TO_GROUP.put("android.permission.READ_SMS", "android.permission-group.SMS");
        PERMISSION_TO_GROUP.put("android.permission.RECEIVE_MMS", "android.permission-group.SMS");
        PERMISSION_TO_GROUP.put("android.permission.RECEIVE_SMS", "android.permission-group.SMS");
        PERMISSION_TO_GROUP.put("android.permission.RECEIVE_WAP_PUSH", "android.permission-group.SMS");
        PERMISSION_TO_GROUP.put("android.permission.SEND_SMS", "android.permission-group.SMS");
        PERMISSION_TO_GROUP.put("android.permission.BD_SEND_MMS", "android.permission-group.SMS");
        PERMISSION_TO_GROUP.put("android.permission.BODY_SENSORS", "android.permission-group.SENSORS");
        PERMISSION_TO_GROUP.put("android.permission.BODY_SENSORS_BACKGROUND", "android.permission-group.SENSORS");
        PERMISSION_TO_GROUP.put("android.permission.READ_MEDIA_VISUAL_USER_SELECTED", "android.permission-group.READ_MEDIA_VISUAL");
        PERMISSION_TO_GROUP.put("android.permission.READ_MEDIA_IMAGES", "android.permission-group.READ_MEDIA_VISUAL");
        PERMISSION_TO_GROUP.put("android.permission.WRITE_MEDIA_IMAGES", "android.permission-group.READ_MEDIA_VISUAL");
        PERMISSION_TO_GROUP.put("android.permission.READ_MEDIA_VIDEO", "android.permission-group.READ_MEDIA_VISUAL");
        PERMISSION_TO_GROUP.put("android.permission.WRITE_MEDIA_VIDEO", "android.permission-group.READ_MEDIA_VISUAL");
        PERMISSION_TO_GROUP.put("android.permission.MANAGE_EXTERNAL_STORAGE", "android.permission-group.READ_MEDIA_VISUAL");
        PERMISSION_TO_GROUP.put("android.permission.READ_EXTERNAL_STORAGE", "android.permission-group.READ_MEDIA_VISUAL");
        PERMISSION_TO_GROUP.put("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission-group.READ_MEDIA_VISUAL");
        PERMISSION_TO_GROUP.put("android.permission.ACCESS_MEDIA_LOCATION", "android.permission-group.READ_MEDIA_VISUAL");
        PERMISSION_TO_GROUP.put("android.permission.READ_MEDIA_AUDIO", "android.permission-group.READ_MEDIA_AURAL");
        PERMISSION_TO_GROUP.put("android.permission.WRITE_MEDIA_AUDIO", "android.permission-group.READ_MEDIA_AURAL");
        PERMISSION_TO_GROUP.put(FINE_LOCATION, FINE_LOCATION);
        PERMISSION_TO_GROUP.put(COARSE_LOCATION, COARSE_LOCATION);
        PERMISSION_TO_GROUP.put("android.permission.ACCESS_BACKGROUND_LOCATION", COARSE_LOCATION);
        PERMISSION_TO_GROUP.put("android.permission.CAMERA", "android.permission-group.CAMERA");
        PERMISSION_TO_GROUP.put("android.permission.RECORD_AUDIO", "android.permission-group.MICROPHONE");
        PERMISSION_TO_GROUP.put("android.permission.ACTIVITY_RECOGNITION", "android.permission-group.ACTIVITY_RECOGNITION");
        PERMISSION_TO_GROUP.put("android.permission.READ_CONTACTS", "android.permission-group.CONTACTS");
        PERMISSION_TO_GROUP.put("android.permission.WRITE_CONTACTS", "android.permission-group.CONTACTS");
        PERMISSION_TO_GROUP.put("android.permission.GET_ACCOUNTS", "android.permission-group.CONTACTS");
        PERMISSION_TO_GROUP.put("android.permission.READ_CALENDAR", "android.permission-group.CALENDAR");
        PERMISSION_TO_GROUP.put("android.permission.WRITE_CALENDAR", "android.permission-group.CALENDAR");
        PERMISSION_TO_GROUP.put("android.permission.READ_CALL_LOG", "android.permission-group.CALL_LOG");
        PERMISSION_TO_GROUP.put("android.permission.WRITE_CALL_LOG", "android.permission-group.CALL_LOG");
        PERMISSION_TO_GROUP.put("android.permission.PROCESS_OUTGOING_CALLS", "android.permission-group.CALL_LOG");
        PERMISSION_TO_GROUP.put("android.permission.BLUETOOTH_SCAN", "android.permission-group.NEARBY_DEVICES");
        PERMISSION_TO_GROUP.put("android.permission.BLUETOOTH_ADVERTISE", "android.permission-group.NEARBY_DEVICES");
        PERMISSION_TO_GROUP.put("android.permission.BLUETOOTH_CONNECT", "android.permission-group.NEARBY_DEVICES");
        PERMISSION_TO_GROUP.put("android.permission.NEARBY_WIFI_DEVICES", "android.permission-group.NEARBY_DEVICES");
        PERMISSION_TO_GROUP.put("android.permission.UWB_RANGING", "android.permission-group.NEARBY_DEVICES");
        PERMISSION_TO_GROUP.put("android.permission.QUERY_ALL_PACKAGES", "android.permission-group.INSTALLED_APPS");
        PERMISSION_TO_GROUP.put("com.android.permission.GET_INSTALLED_APPS", "android.permission-group.INSTALLED_APPS");
        PERMISSION_TO_GROUP.put("android.permission.POST_NOTIFICATIONS", "android.permission-group.NOTIFICATIONS");
    }
}
