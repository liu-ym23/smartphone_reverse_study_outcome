package os.teatracker;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class TeaAgent {

    public interface AppStateListener {
        void onGetAppState(AppState appState);
    }

    public interface TeaListener {
        void onDeviceIdLoaded(String did);

        void onInstallIdLoaded(String installId);
    }

    public static void onCustomIdEvent(String event, JSONObject jsonObject) {
    }

    public TeaAgent() {
    }

    public static void init(Context context, TeaConfig config) {
        TeaHandler.getTeaHandler().init(context, config);
    }

    public static void onEvent(String event, JSONObject params) {
        enforceAppId();
        TeaHandler.getTeaHandler().onEvent(new TeaEvent(event, TeaUtil.copy(params)));
    }

    public static void onSysEvent(String event, JSONObject params) {
        enforceAppId();
        TeaHandler.getTeaHandler().onSysEvent(new TeaEvent(event, TeaUtil.copy(params)));
    }

    public static void onInstantEvent(String event, JSONObject params) {
        enforceAppId();
        TeaHandler.getTeaHandler().onEvent(new TeaEvent(event, TeaUtil.copy(params), true));
    }

    private static void enforceAppId() {
        TeaConfig r0 = TeaHandler.getTeaHandler().getTeaConfig();
        if (r0 == null) goto L8;
        if (TextUtils.isEmpty(r0.getAppId()) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("You must first call method init to provide an appId via TeaConfig param.");
    }

    public static String getDeviceId() {
        return TeaHandler.getTeaHandler().getDeviceId();
    }

    public static String getTeaTrackerDid() {
        return TeaHandler.getTeaHandler().getTeaTrackerDid();
    }

    public static String getInstallId() {
        return TeaHandler.getTeaHandler().getInstallId();
    }

    public static String getUDID() {
        return TeaHandler.getTeaHandler().getUDID();
    }

    public static String getOaid() {
        return TeaHandler.getTeaHandler().getOaid();
    }

    public static String getSerialNumber() {
        return TeaHandler.getTeaHandler().getSerialNumber();
    }

    public static String getImei() {
        return TeaHandler.getTeaHandler().getImei();
    }

    public static String getMeid() {
        return TeaHandler.getTeaHandler().getMeid();
    }

    public static void addTeaListener(TeaListener listener) {
        TeaHandler.getTeaHandler().addTeaListener(listener);
    }

    public static void removeTeaListener(TeaListener listener) {
        TeaHandler.getTeaHandler().removeTeaListener(listener);
    }

    public static void setAppStateListener(AppStateListener listener) {
        TeaHandler.getTeaHandler().setAppStateListener(listener);
    }

    private static void enforceNonMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        return;
    L6:
        throw new RuntimeException("This method can not be called from the main application thread");
    }

    public static void setEnableET(String appId, boolean enable) {
        TeaHandler.getTeaHandler().setEnableET(appId, enable);
    }

    public static void setAbSDKVersion(String abSDKVersion) {
        TeaHandler.getTeaHandler().setAbSDKVersion(abSDKVersion);
    }

    public static void setPrivacyPolicyConfirmed(boolean confirmed) {
        TeaHandler.getTeaHandler().setPrivacyPolicyConfirmed(confirmed);
    }
}
