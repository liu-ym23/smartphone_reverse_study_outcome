package com.bytedance.apm6.consumer.slardar;

import android.app.Application;
import com.bytedance.apm6.util.ApmBaseContext;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class SlardarProperties {
    private static final String KEY_RELEASE_BUILD = "release_build";
    private static final String PROPERTIES_PATH = "slardar.properties";
    private static Properties mProperties;

    public SlardarProperties() {
    }

    public static String getReleaseBuild() {
        return String.valueOf(readKey("release_build"));
    }

    private static Object readKey(String r2) {
        tryLoadPropertiesFromApk();
        if (mProperties.containsKey(r2) == false) goto L10;
        return mProperties.get(r2);
    L10:
        return null;
    L11:
        return null;
    }

    private static void tryLoadPropertiesFromApk() {
        Application r0 = ApmBaseContext.getContext();
        if (mProperties != null) goto L10;
        Properties r1 = new Properties();
        mProperties = r1;
        r1.load(r0.getApplicationContext().getAssets().open(PROPERTIES_PATH));     // Catch: Throwable -> L7
        return;
    L11:
        return;
    }
}
