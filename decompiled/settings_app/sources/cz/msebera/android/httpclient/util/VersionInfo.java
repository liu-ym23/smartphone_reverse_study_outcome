package cz.msebera.android.httpclient.util;

import com.android.settingslib.accessibility.AccessibilityUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes5.dex */
public class VersionInfo {
    public static final String PROPERTY_MODULE = "info.module";
    public static final String PROPERTY_RELEASE = "info.release";
    public static final String PROPERTY_TIMESTAMP = "info.timestamp";
    public static final String UNAVAILABLE = "UNAVAILABLE";
    public static final String VERSION_PROPERTY_FILE = "version.properties";
    private final String infoClassloader;
    private final String infoModule;
    private final String infoPackage;
    private final String infoRelease;
    private final String infoTimestamp;

    protected VersionInfo(String r2, String r3, String r4, String r5, String r6) {
        Args.notNull(r2, "Package identifier");
        this.infoPackage = r2;
        if (r3 != null) goto L6;
        r3 = UNAVAILABLE;
    L6:
        this.infoModule = r3;
        if (r4 != null) goto L10;
        r4 = UNAVAILABLE;
    L10:
        this.infoRelease = r4;
        if (r5 != null) goto L14;
        r5 = UNAVAILABLE;
    L14:
        this.infoTimestamp = r5;
        if (r6 != null) goto L18;
        r6 = UNAVAILABLE;
    L18:
        this.infoClassloader = r6;
    }

    public final String getPackage() {
        return this.infoPackage;
    }

    public final String getModule() {
        return this.infoModule;
    }

    public final String getRelease() {
        return this.infoRelease;
    }

    public final String getTimestamp() {
        return this.infoTimestamp;
    }

    public final String getClassloader() {
        return this.infoClassloader;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(((((this.infoPackage.length() + 20) + this.infoModule.length()) + this.infoRelease.length()) + this.infoTimestamp.length()) + this.infoClassloader.length());
        r0.append("VersionInfo(").append(this.infoPackage).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(this.infoModule);
        if (UNAVAILABLE.equals(this.infoRelease) == true) goto L6;
        r0.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(this.infoRelease);
    L6:
        if (UNAVAILABLE.equals(this.infoTimestamp) == true) goto L8;
        r0.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(this.infoTimestamp);
    L8:
        r0.append(')');
        if (UNAVAILABLE.equals(this.infoClassloader) == true) goto L12;
        r0.append('@').append(this.infoClassloader);
    L12:
        return r0.toString();
    }

    public static VersionInfo[] loadVersionInfo(String[] r4, ClassLoader r5) {
        Args.notNull(r4, "Package identifier array");
        ArrayList r0 = new ArrayList(r4.length);
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        VersionInfo r3 = loadVersionInfo(r4[r2], r5);
        if (r3 == null) goto L7;
        r0.add(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L9:
        return (VersionInfo[]) r0.toArray(new VersionInfo[r0.size()]);
    }

    public static VersionInfo loadVersionInfo(String r5, ClassLoader r6) {
        Args.notNull(r5, "Package identifier");
        if (r6 != null) goto L21;
        r6 = Thread.currentThread().getContextClassLoader();
    L21:
        InputStream r0 = r6.getResourceAsStream(r5.replace('.', IOUtils.DIR_SEPARATOR_UNIX) + "/version.properties");     // Catch: IOException -> L20
        if (r0 == null) goto L15;
        Properties r2 = new Properties();     // Catch: Throwable -> L12
        r2.load(r0);     // Catch: Throwable -> L12
        r0.close();     // Catch: IOException -> L19
    L16:
        if (r2 != null) goto L18;
        return null;
    L18:
        return fromMap(r5, r2, r6);
    L12:
        th = move-exception;
        r0.close();     // Catch: IOException -> L20
        throw th;     // Catch: IOException -> L20
    L15:
        r2 = null;
        goto L16
    }

    protected static VersionInfo fromMap(String r10, Map<?, ?> r11, ClassLoader r12) {
        Args.notNull(r10, "Package identifier");
        String r0 = null;
        if (r11 == null) goto L25;
        String r1 = (String) r11.get(PROPERTY_MODULE);
        if (r1 != null) goto L7;
    L9:
        String r3 = (String) r11.get(PROPERTY_RELEASE);
        if (r3 != null) goto L12;
    L16:
        String r13 = (String) r11.get(PROPERTY_TIMESTAMP);
        if (r13 != null) goto L19;
    L23:
        String r8 = r13;
    L24:
        String r6 = r1;
        String r7 = r3;
    L26:
        if (r12 == null) goto L29;
        r0 = r12.toString();
    L29:
        return new VersionInfo(r10, r6, r7, r8, r0);
    L19:
        if (r13.length() >= 1) goto L21;
    L22:
        r8 = null;
        goto L24
    L21:
        if (r13.equals("${mvn.timestamp}") == false) goto L23;
    L12:
        if (r3.length() >= 1) goto L14;
    L15:
        r3 = null;
        goto L16
    L14:
        if (r3.equals("${pom.version}") == false) goto L16;
    L7:
        if (r1.length() >= 1) goto L9;
        r1 = null;
        goto L9
    L25:
        r6 = null;
        r7 = null;
        r8 = null;
        goto L26
    }

    public static String getUserAgent(String r2, String r3, Class<?> r4) {
        VersionInfo r5 = loadVersionInfo(r3, r4.getClassLoader());
        if (r5 == null) goto L5;
        String r6 = r5.getRelease();
    L7:
        return String.format("%s/%s (Java/%s)", new Object[]{r2, r6, System.getProperty("java.version")});
    L5:
        r6 = UNAVAILABLE;
        goto L7
    }
}
