package os.teatracker;

import android.net.Uri;

/* JADX INFO: loaded from: classes6.dex */
public class TeaConst {
    public static final String APP_STATE_ACTION = "os.appstate.change.action";
    public static final String APP_STATE_PARAMS = "appstate_params";
    public static final String APP_STATE_PERMISSION = "os.permission.appstate.change";
    public static final String APP_STATE_TYPE = "appstate_type";
    public static final Uri AUTHORITY_URI = null;
    public static final String DATA_KEY_CONTENT = "content";
    public static final String DATA_KEY_DATA_ID = "data_id";
    public static final String DATA_KEY_ID = "_id";
    public static final String DATA_KEY_TIMESTAMP = "timestamp";
    public static final Uri EVENT_DATA_AUTHORITY_URI = null;
    public static final String KEY_CLIENT_ANDROID_ID = "key_client_androidId";
    public static final String KEY_CLIENT_IMEI = "key_client_imei";
    public static final String KEY_CLIENT_MEID = "key_client_meid";
    public static final String KEY_CLIENT_OAID = "oaid";
    public static final String KEY_CLIENT_SN = "key_client_sn";
    public static final String KEY_CLIENT_UDID = "key_client_udid";
    public static final String KEY_DEVICE_ID = "key_device_info";
    public static final int MESSAGE_ID_NEW_EVENTS = 101;
    public static final int MESSAGE_ID_PRIVACY_POLICY_CONFIRMED = 103;
    public static final int MESSAGE_ID_SET_AB_SDK_VERSION = 102;
    public static final String MESSAGE_KEY_AB_SDK_VERSION = "key_ab_sdk_version";
    public static final String MESSAGE_KEY_APP_ID = "key_app_id";
    public static final String MESSAGE_KEY_DATA = "key_data";
    public static final String MESSAGE_KEY_EVENT = "key_event";
    public static final String MESSAGE_KEY_INSTANT = "key_instant";
    public static final String MESSAGE_KEY_PARAMS = "key_params";
    public static final String MESSAGE_KEY_PRIVACY_POLICY_CONFIRMED = "key_privacy_confirmed";
    public static final String MESSAGE_KEY_TIMESTAMP = "key_timestamp";
    public static final String METHOD_GET_ANDROID_ID = "getAndroidId";
    public static final String METHOD_GET_DEVICE_ID = "getDeviceId";
    public static final String METHOD_GET_IMEI = "getImei";
    public static final String METHOD_GET_MEID = "getMeid";
    public static final String METHOD_GET_OAID = "request_oaid";
    public static final String METHOD_GET_SN = "getSn";
    public static final String METHOD_GET_UDID = "getUDID";
    public static final Uri OAID_AUTHORITY_URI = null;
    public static final String PUBLIC_KEY_APP_DISPLAY_NAME = "display_name";
    public static final String PUBLIC_KEY_APP_VERSION = "app_version";
    public static final String PUBLIC_KEY_APP_VERSION_CODE = "app_version_code";
    public static final String PUBLIC_KEY_PKG_NAME = "package_name";
    public static final String SYS_APP_ID = "568726";
    public static final Uri URI_DEVICE_ID = null;

    public static final enum DataId extends Enum<DataId> {
        private static final /* synthetic */ DataId[] $VALUES = null;
        public static final DataId ACTIVITY_SWITCH = null;

        private DataId(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static DataId valueOf(String name) {
            return (DataId) Enum.valueOf(DataId.class, name);
        }

        public static DataId[] values() {
            return (DataId[]) $VALUES.clone();
        }

        static {
            DataId r0 = new DataId("ACTIVITY_SWITCH", 0);
            ACTIVITY_SWITCH = r0;
            $VALUES = new DataId[]{r0};
        }
    }

    public TeaConst() {
    }

    static {
        Uri r0 = Uri.parse("content://os.teatracker");
        AUTHORITY_URI = r0;
        OAID_AUTHORITY_URI = Uri.parse("content://com.obric.idprovider");
        EVENT_DATA_AUTHORITY_URI = Uri.parse("content://os.teatracker/event_data");
        URI_DEVICE_ID = Uri.parse(r0 + "/getDeviceId");
    }
}
