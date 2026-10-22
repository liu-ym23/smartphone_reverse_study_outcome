package os.teatracker;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
abstract class BaseHandler {

    private static class InstanceHolder {
        public static final TeaHandler sTeaHandler = null;

        private InstanceHolder() {
        }

        static {
            sTeaHandler = new TeaHandler();
        }
    }

    public abstract void addTeaListener(TeaAgent.TeaListener listener);

    public abstract String getAbSDKVersion();

    public abstract TeaAgent.AppStateListener getAppStateListener();

    abstract Context getContext();

    public abstract String getDeviceId();

    public abstract String getImei();

    public abstract String getInstallId();

    public abstract String getMeid();

    public abstract String getOaid();

    public abstract String getSerialNumber();

    abstract TeaConfig getTeaConfig();

    public abstract String getTeaTrackerDid();

    public abstract String getUDID();

    public abstract void init(Context context, TeaConfig config);

    public abstract Boolean isPrivacyPolicyConfirmed();

    public abstract void onEvent(TeaEvent event);

    public abstract void onQuit();

    public abstract void onSysEvent(TeaEvent event);

    public abstract void removeTeaListener(TeaAgent.TeaListener listener);

    public abstract void setAbSDKVersion(String abSDKVersion);

    public abstract void setAppStateListener(TeaAgent.AppStateListener listener);

    public abstract void setEnableET(String appId, boolean enable);

    public abstract void setPrivacyPolicyConfirmed(boolean confirmed);

    BaseHandler() {
    }

    public static BaseHandler getTeaHandler() {
        return InstanceHolder.sTeaHandler;
    }
}
