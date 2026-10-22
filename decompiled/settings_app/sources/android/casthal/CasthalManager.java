package android.casthal;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public class CasthalManager {
    public static final int AMLOGIC_BOOT_MODE_POWEROFF = 5;
    public static final int AMLOGIC_BOOT_MODE_REBOOT = 0;
    public static final int AMLOGIC_BOOT_MODE_RECOVERY = 2;
    public static final int AMLOGIC_BOOT_MODE_SHUTDOWN = 1;
    public static final int AMLOGIC_BOOT_MODE_SLEEP = 3;
    public static final int AMLOGIC_BOOT_MODE_STARTUP = 4;
    public static final int AMLOGIC_STATUS_ACTIVE = 2;
    public static final int AMLOGIC_STATUS_IDLE = 1;
    public static final int AMLOGIC_STATUS_READY = 3;
    private static final int BASE = 10000;
    public static final int BOSTON_AGING_TEST_FAIL = 0;
    public static final int BOSTON_AGING_TEST_PASS = 1;
    public static final int BOSTON_MIC_MODE_MULTI = 0;
    public static final int BOSTON_MIC_MODE_SINGLE = 1;
    public static final int BOSTON_SCREEN_MODE_WIRE = 0;
    public static final int BOSTON_SCREEN_MODE_WIRELESS = 1;
    public static final int BOSTON_SCREEN_MODE_WIREMIX = 2;
    public static final int BOSTON_SCREEN_MODE_WIRE_UNKNOWN = -1;
    public static final int BOSTON_SCREEN_STATE_SCREEN_OFF = 0;
    public static final int BOSTON_SCREEN_STATE_SCREEN_ON = 1;
    public static final int BOSTON_SLEEP_MODE_ACTIVE = 0;
    public static final int BOSTON_SLEEP_MODE_SLEEP = 1;
    public static final int BOSTON_SLEEP_MODE_UNKNOWN = -1;
    public static final int CMD_GET_AMLOGIC_BT_STATE = 10017;
    public static final int CMD_GET_AMLOGIC_WIFI_STATE = 10015;
    public static final int CMD_GET_BATTERY_INFO = 10002;
    public static final int CMD_GET_BOSTON_HALL_DATA = 10009;
    public static final int CMD_GET_BOSTON_MIC_MODE = 10025;
    public static final int CMD_GET_BOSTON_SENSOR_STATE = 10005;
    public static final int CMD_GET_BOSTON_SLEEP_STATE = 10006;
    public static final int CMD_GET_MMI1_TEST_RESULTS = 10022;
    public static final int CMD_GET_PT_TEST_RESULTS = 10023;
    public static final int CMD_NOTIFY_AMLOGIC_STATE = 10020;
    public static final int CMD_NOTIFY_BOSTON_BT_STATE = 10004;
    public static final int CMD_NOTIFY_BOSTON_WIFI_STATE = 10003;
    public static final int CMD_NOTIFY_CASTHAL_IP = 10010;
    public static final int CMD_REPLY_FAILED = 51;
    public static final int CMD_REPLY_SUCCESS = 50;
    public static final int CMD_SEND_PHONE_TIME = 10008;
    public static final int CMD_SET_AGING_TEST_RESULTS = 10021;
    public static final int CMD_SET_AMLOGIC_BT_STATE = 10016;
    public static final int CMD_SET_AMLOGIC_WIFI_STATE = 10014;
    public static final int CMD_SET_BACK_LIGHT = 10001;
    public static final int CMD_SET_BOOT_MODE = 10012;
    public static final int CMD_SET_BOSTON_MIC_MODE = 10013;
    public static final int CMD_SET_BOSTON_RESET = 10018;
    public static final int CMD_SET_BOSTON_TEST_MODE = 10007;
    public static final int CMD_SET_BOSTON_UPGRADE = 10011;
    public static final int CMD_SET_CAST_SCREEN_MODE = 10000;
    public static final int CMD_SET_PAIRED_BT_MAC = 10024;
    public static final int CMD_SET_SCALER_POWER_STATE = 10026;
    public static final int CMD_TRANSFER_STRING = 10019;
    public static final int CMD_TRIGGER_BOSTON_UPDATE_VERSION = 10027;
    public static final String EXTRA_CONNECTION_STATE = "";
    public static final String EXTRA_MMI1_RESULTS_VALUE = "mmi1_results";
    public static final String EXTRA_PT_RESULTS_VALUE = "pt_results";
    public static final String EXTRA_TRANSFER_VALUE = "cmd_string";
    public static final IntentFilter HALL_KEYBOARD_CONNECTION_CHANGED_ACTION = null;
    public static final int MIC_MODE_MULTI_MODE = 1;
    public static final int MIC_MODE_SINGLE_MODE = 0;
    public static final int SCALER_POWER_OFF = 0;
    public static final int SCALER_POWER_ON = 1;
    private static final String TAG = "CasthalManager";
    public static final int WIRELESS_CONNECTED = 1;
    public static final int WIRELESS_DISCONNECTED = 0;
    public static final int WIRELESS_UNKNOWN = -1;
    private static final Object sServiceHandlerDispatchLock = null;

    public interface ActionListener<T> {
        void onFailure(int r1);

        void onSuccess(T r1);
    }

    class BostonHallData {
        final /* synthetic */ CasthalManager this$0;

        BostonHallData(CasthalManager r1) {
            this.this$0 = r1;
        }
    }

    class BostonSensorState {
        final /* synthetic */ CasthalManager this$0;

        BostonSensorState(CasthalManager r1) {
            this.this$0 = r1;
        }
    }

    class IBacklightChangeListener {
        final /* synthetic */ CasthalManager this$0;

        IBacklightChangeListener(CasthalManager r1) {
            this.this$0 = r1;
        }
    }

    class IHallChangeListener {
        final /* synthetic */ CasthalManager this$0;

        IHallChangeListener(CasthalManager r1) {
            this.this$0 = r1;
        }
    }

    public static CasthalManager getInstance(Context r0) {
        return null;
    }

    public void getAmlogicBtState(ActionListener<Integer> r1) {
    }

    public void getAmlogicWifiState(ActionListener<Integer> r1) {
    }

    public int getBacklight() {
        return -1;
    }

    public void getBostonHallData(ActionListener<BostonHallData> r1) {
    }

    public void getBostonMicMode(ActionListener<Integer> r1) {
    }

    public String getBostonName() {
        return null;
    }

    public void getBostonSensorState(ActionListener<BostonSensorState> r1) {
    }

    public String getBostonSid() {
        return null;
    }

    public void getBostonSleepState(ActionListener<Integer> r1) {
    }

    public String getBostonSn() {
        return null;
    }

    public BostonVersionInfo getBostonVersionInfo() {
        return null;
    }

    public int getNetScore() {
        return -1;
    }

    public int getScreenMode() {
        return -1;
    }

    public int getScreenState() {
        return -1;
    }

    public boolean hasWirelessCapabilitie() {
        return false;
    }

    public boolean isAmlogicPowerOn() {
        return false;
    }

    public boolean isBostonChargerConnected() {
        return false;
    }

    public boolean isBostonConnected() {
        return false;
    }

    public boolean isKeyboardConnected() {
        return false;
    }

    public boolean isVuartConnected() {
        return false;
    }

    public void notifyAmlogicState(int r1, ActionListener<Integer> r2) {
    }

    public void notifyCasthalIp(String r1, ActionListener<Integer> r2) {
    }

    public void registerBacklightChangeListener(IBacklightChangeListener r1) {
    }

    public void registerHallChangeListener(IHallChangeListener r1) {
    }

    public void requestBootMode(int r1, ActionListener<Integer> r2) {
    }

    public void setAgingTestResult(int r1, ActionListener<Integer> r2) {
    }

    public void setAmlogicBtState(int r1, ActionListener<Integer> r2) {
    }

    public void setAmlogicWifiState(int r1, ActionListener<Integer> r2) {
    }

    public void setBacklight(int r1, ActionListener<Integer> r2) {
    }

    public void setBostonFwUpgrade(ActionListener<Integer> r1) {
    }

    public void setBostonMicMode(int r1, ActionListener<Integer> r2) {
    }

    public void setBostonReset(ActionListener<Integer> r1) {
    }

    public void setBostonTestMode(int r1, ActionListener<Integer> r2) {
    }

    public void setScalerPowerState(int r1, ActionListener<Integer> r2) {
    }

    public void setScreenMode(int r1, ActionListener<Integer> r2) {
    }

    public void syncPhoneTimeToBoston(long r1, ActionListener<Integer> r3) {
    }

    public void transmitCmdString(String r1, ActionListener<Integer> r2) {
    }

    public void triggerUpdateVersionInfo(ActionListener<Integer> r1) {
    }

    public void unregisterBacklightChangeListener(IBacklightChangeListener r1) {
    }

    public void unregisterHallChangeListener(IHallChangeListener r1) {
    }

    public CasthalManager() {
    }

    static {
        sServiceHandlerDispatchLock = new Object();
    }
}
