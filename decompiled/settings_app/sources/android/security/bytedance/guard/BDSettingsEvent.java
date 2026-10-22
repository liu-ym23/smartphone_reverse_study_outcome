package android.security.bytedance.guard;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final enum BDSettingsEvent extends Enum<BDSettingsEvent> {
    private static final /* synthetic */ BDSettingsEvent[] $VALUES = null;
    public static final BDSettingsEvent EVENT_TYPE_APP_DATA_CLEAR = null;
    public static final BDSettingsEvent EVENT_TYPE_CALENDAR_DELETE = null;
    public static final BDSettingsEvent EVENT_TYPE_CALL_LOGS_DELETE = null;
    public static final BDSettingsEvent EVENT_TYPE_CONTACT_DELETE = null;
    public static final BDSettingsEvent EVENT_TYPE_DELETE_FACE = null;
    public static final BDSettingsEvent EVENT_TYPE_DELETE_FINGERPRINT = null;
    public static final BDSettingsEvent EVENT_TYPE_DELETE_PASSWORD = null;
    public static final BDSettingsEvent EVENT_TYPE_FILE_DELETE = null;
    public static final BDSettingsEvent EVENT_TYPE_INSTALL_UNKNOWN_APP = null;
    public static final BDSettingsEvent EVENT_TYPE_JUNK_CLEAR = null;
    public static final BDSettingsEvent EVENT_TYPE_NOTES_DELETE = null;
    public static final BDSettingsEvent EVENT_TYPE_PHOTO_DELETE = null;
    public static final BDSettingsEvent EVENT_TYPE_REBOOT = null;
    public static final BDSettingsEvent EVENT_TYPE_RECORDING_DELETE = null;
    public static final BDSettingsEvent EVENT_TYPE_RESTORE_FACTORY = null;
    public static final BDSettingsEvent EVENT_TYPE_SHUTDOWN = null;
    public static final BDSettingsEvent EVENT_TYPE_SMS_DELETE = null;
    public static final BDSettingsEvent EVENT_TYPE_UNINSTALL_APP = null;
    public static final BDSettingsEvent EVENT_TYPE_VAULT_DELETE = null;
    public static final BDSettingsEvent EVENT_TYPE_VIDEO_DELETE = null;
    private static final Set<Integer> VALID_TYPES = null;
    private final int type;

    private static /* synthetic */ BDSettingsEvent[] $values() {
        return new BDSettingsEvent[]{EVENT_TYPE_SMS_DELETE, EVENT_TYPE_CONTACT_DELETE, EVENT_TYPE_CALL_LOGS_DELETE, EVENT_TYPE_FILE_DELETE, EVENT_TYPE_NOTES_DELETE, EVENT_TYPE_PHOTO_DELETE, EVENT_TYPE_VIDEO_DELETE, EVENT_TYPE_VAULT_DELETE, EVENT_TYPE_RECORDING_DELETE, EVENT_TYPE_CALENDAR_DELETE, EVENT_TYPE_APP_DATA_CLEAR, EVENT_TYPE_JUNK_CLEAR, EVENT_TYPE_DELETE_PASSWORD, EVENT_TYPE_DELETE_FINGERPRINT, EVENT_TYPE_DELETE_FACE, EVENT_TYPE_RESTORE_FACTORY, EVENT_TYPE_UNINSTALL_APP, EVENT_TYPE_REBOOT, EVENT_TYPE_SHUTDOWN, EVENT_TYPE_INSTALL_UNKNOWN_APP};
    }

    public static BDSettingsEvent valueOf(String r1) {
        return (BDSettingsEvent) Enum.valueOf(BDSettingsEvent.class, r1);
    }

    public static BDSettingsEvent[] values() {
        return (BDSettingsEvent[]) $VALUES.clone();
    }

    static {
        int r2 = 0;
        EVENT_TYPE_SMS_DELETE = new BDSettingsEvent("EVENT_TYPE_SMS_DELETE", 0, 1);
        EVENT_TYPE_CONTACT_DELETE = new BDSettingsEvent("EVENT_TYPE_CONTACT_DELETE", 1, 2);
        EVENT_TYPE_CALL_LOGS_DELETE = new BDSettingsEvent("EVENT_TYPE_CALL_LOGS_DELETE", 2, 3);
        EVENT_TYPE_FILE_DELETE = new BDSettingsEvent("EVENT_TYPE_FILE_DELETE", 3, 4);
        EVENT_TYPE_NOTES_DELETE = new BDSettingsEvent("EVENT_TYPE_NOTES_DELETE", 4, 5);
        EVENT_TYPE_PHOTO_DELETE = new BDSettingsEvent("EVENT_TYPE_PHOTO_DELETE", 5, 6);
        EVENT_TYPE_VIDEO_DELETE = new BDSettingsEvent("EVENT_TYPE_VIDEO_DELETE", 6, 7);
        EVENT_TYPE_VAULT_DELETE = new BDSettingsEvent("EVENT_TYPE_VAULT_DELETE", 7, 8);
        EVENT_TYPE_RECORDING_DELETE = new BDSettingsEvent("EVENT_TYPE_RECORDING_DELETE", 8, 9);
        EVENT_TYPE_CALENDAR_DELETE = new BDSettingsEvent("EVENT_TYPE_CALENDAR_DELETE", 9, 10);
        EVENT_TYPE_APP_DATA_CLEAR = new BDSettingsEvent("EVENT_TYPE_APP_DATA_CLEAR", 10, 101);
        EVENT_TYPE_JUNK_CLEAR = new BDSettingsEvent("EVENT_TYPE_JUNK_CLEAR", 11, 102);
        EVENT_TYPE_DELETE_PASSWORD = new BDSettingsEvent("EVENT_TYPE_DELETE_PASSWORD", 12, 103);
        EVENT_TYPE_DELETE_FINGERPRINT = new BDSettingsEvent("EVENT_TYPE_DELETE_FINGERPRINT", 13, 104);
        EVENT_TYPE_DELETE_FACE = new BDSettingsEvent("EVENT_TYPE_DELETE_FACE", 14, 105);
        EVENT_TYPE_RESTORE_FACTORY = new BDSettingsEvent("EVENT_TYPE_RESTORE_FACTORY", 15, 1001);
        EVENT_TYPE_UNINSTALL_APP = new BDSettingsEvent("EVENT_TYPE_UNINSTALL_APP", 16, 1002);
        EVENT_TYPE_REBOOT = new BDSettingsEvent("EVENT_TYPE_REBOOT", 17, 1003);
        EVENT_TYPE_SHUTDOWN = new BDSettingsEvent("EVENT_TYPE_SHUTDOWN", 18, 1004);
        EVENT_TYPE_INSTALL_UNKNOWN_APP = new BDSettingsEvent("EVENT_TYPE_INSTALL_UNKNOWN_APP", 19, 1005);
        $VALUES = $values();
        VALID_TYPES = new HashSet();
        BDSettingsEvent[] r0 = values();
        int r1 = r0.length;
    L3:
        if (r2 >= r1) goto L5;
        BDSettingsEvent r3 = r0[r2];
        VALID_TYPES.add(Integer.valueOf(r3.getType()));
        r2 = r2 + 1;
        goto L3
    }

    private BDSettingsEvent(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }

    public int getType() {
        return this.type;
    }

    public static boolean isValid(int r1) {
        return VALID_TYPES.contains(Integer.valueOf(r1));
    }
}
