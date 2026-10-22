package os.teatracker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class AppState {

    @SerializedName("display_name")
    @Expose
    String appName;

    @SerializedName("app_duration")
    @Expose
    int duration;

    @SerializedName("app_next_name")
    @Expose
    String nextAppName;

    @SerializedName("app_next_pkg")
    @Expose
    String nextPackage;

    @SerializedName("package_name")
    @Expose
    String packageName;
    String params;

    @SerializedName("app_start_time")
    @Expose
    long startTime;

    @SerializedName(TeaConst.APP_STATE_TYPE)
    @Expose
    String stateType;

    @SerializedName(TeaConst.PUBLIC_KEY_APP_VERSION_CODE)
    @Expose
    String versionCode;

    @SerializedName("app_version")
    @Expose
    String versionName;

    public AppState() {
    }

    public String getStateType() {
        return this.stateType;
    }

    public void setStateType(String stateType) {
        this.stateType = stateType;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getNextPackage() {
        return this.nextPackage;
    }

    public void setNextPackage(String nextPackage) {
        this.nextPackage = nextPackage;
    }

    public String getNextAppName() {
        return this.nextAppName;
    }

    public void setNextAppName(String nextAppName) {
        this.nextAppName = nextAppName;
    }

    public String getParams() {
        return this.params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String toString() {
        return "AppState{stateType='" + this.stateType + "', appName='" + this.appName + "', versionName='" + this.versionName + "', versionCode='" + this.versionCode + "', startTime=" + this.startTime + ", packageName='" + this.packageName + "', duration=" + this.duration + ", nextPackage='" + this.nextPackage + "', nextAppName='" + this.nextAppName + "', params='" + this.params + "'}";
    }
}
