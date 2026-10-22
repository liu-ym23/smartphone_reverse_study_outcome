package com.bytedance.apm6.consumer.slardar;

import android.app.Application;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.IOUtils;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: classes3.dex */
public class SlardarProperties {
    private static final String KEY_RELEASE_BUILD = "release_build";
    private static final String PROPERTIES_PATH = "slardar.properties";
    private static Properties mProperties;

    public SlardarProperties() {
    }

    private static void tryLoadPropertiesFromApk() {
        Application r0 = ApmContext.getContext();
        if (mProperties != null) goto L15;
        mProperties = new Properties();
        InputStream r1 = r0.getApplicationContext().getAssets().open(PROPERTIES_PATH);     // Catch: Throwable -> L8
        mProperties.load(r1);     // Catch: Throwable -> L16
    L10:
        IOUtils.closeQuietly(r1);
        return;
    L21:
        mProperties = null;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        IOUtils.closeQuietly(r1);
        throw th;
    L8:
        r1 = null;
        goto L21
    }

    private static Object readKey(String r2) {
        tryLoadPropertiesFromApk();
        Properties r1 = mProperties;     // Catch: Exception -> L9
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.containsKey(r2) == false) goto L13;
        return mProperties.get(r2);
    L13:
        return null;
    L14:
        return null;
    }

    public static String getReleaseBuild() {
        return String.valueOf(readKey("release_build"));
    }
}
