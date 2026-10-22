package os.teatracker;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class TeaConfig {
    public static boolean DEBUG;
    static String TAG;
    private String appId;
    private String appName;
    private String channel;
    private Map<String, Object> globalParams;
    private boolean keepTeaServiceConnected;

    public static final class Builder {
        private final TeaConfig mTeaConfig;

        public Builder() {
            this.mTeaConfig = new TeaConfig();
        }

        public Builder setTeaTrackerDebugEnabled(boolean enabled) {
            this.mTeaConfig.setTeaTrackerDebugEnabled(enabled);
            return this;
        }

        public Builder setTeaTrackerDebugTag(String tag) {
            this.mTeaConfig.setTeaTrackerDebugTag(tag);
            return this;
        }

        public Builder setAppId(String appId) {
            this.mTeaConfig.setAppId(appId);
            return this;
        }

        public Builder setKeepTeaServiceConnected(boolean keepTeaServiceConnected) {
            this.mTeaConfig.setKeepTeaServiceConnected(keepTeaServiceConnected);
            return this;
        }

        public Builder setGlobalParams(Map<String, Object> params) {
            this.mTeaConfig.setGlobalParams(params);
            return this;
        }

        public Builder setAppName(String appName) {
            this.mTeaConfig.setAppName(appName);
            return this;
        }

        public Builder setChannel(String channel) {
            this.mTeaConfig.setChannel(channel);
            return this;
        }

        public TeaConfig build() {
            return this.mTeaConfig;
        }
    }

    static {
        DEBUG = TeaUtil.isSystemDebuggable();
        TAG = "CommonLog";
    }

    public TeaConfig() {
    }

    public void setTeaTrackerDebugEnabled(boolean enabled) {
        DEBUG = enabled;
    }

    public void setTeaTrackerDebugTag(String tag) {
        if (TextUtils.isEmpty(tag) == true) goto L6;
        TAG = tag;
        return;
    }

    void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannel() {
        return this.channel;
    }

    public boolean isKeepTeaServiceConnected() {
        return this.keepTeaServiceConnected;
    }

    public void setKeepTeaServiceConnected(boolean keepTeaServiceConnected) {
        this.keepTeaServiceConnected = keepTeaServiceConnected;
    }

    public void setGlobalParams(Map<String, Object> params) {
        this.globalParams = params;
    }

    public Map<String, Object> getGlobalParams() {
        return this.globalParams;
    }

    public String toString() {
        return "TeaConfig{keepTeaServiceConnected=" + this.keepTeaServiceConnected + '}';
    }
}
