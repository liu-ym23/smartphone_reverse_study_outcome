package com.bytedance.apm.util;

import android.content.Context;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm6.util.IOUtils;
import java.io.InputStream;
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
        Context r0 = ApmContext.getContext();
        if (mProperties != null) goto L11;
        mProperties = new Properties();
        InputStream r1 = null;
        r1 = r0.getApplicationContext().getAssets().open(PROPERTIES_PATH);     // Catch: Throwable -> L8
        mProperties.load(r1);     // Catch: Throwable -> L8
    L6:
        IOUtils.closeQuietly(r1);
        return;
    }
}
