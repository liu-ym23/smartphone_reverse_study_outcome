package com.bytedanceos.securitycenter.dynamicResolution;

/* JADX INFO: loaded from: classes2.dex */
public class ApplicationConfig {
    String packageName;
    String supportDevices;
    String supportVersion;

    ApplicationConfig(String packageName, String supportVersion, String supportDevices) {
        this.packageName = packageName;
        this.supportVersion = supportVersion;
        this.supportDevices = supportDevices;
    }

    public String toString() {
        return this.packageName + " " + this.supportVersion + " " + this.supportDevices;
    }
}
