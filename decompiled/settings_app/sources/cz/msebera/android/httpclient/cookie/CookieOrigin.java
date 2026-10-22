package cz.msebera.android.httpclient.cookie;

import com.android.settingslib.accessibility.AccessibilityUtils;
import com.bytedance.librarian.LibrarianImpl;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class CookieOrigin {
    private final String host;
    private final String path;
    private final int port;
    private final boolean secure;

    public CookieOrigin(String r2, int r3, String r4, boolean r5) {
        Args.notBlank(r2, "Host");
        Args.notNegative(r3, "Port");
        Args.notNull(r4, "Path");
        this.host = r2.toLowerCase(Locale.ROOT);
        this.port = r3;
        if (TextUtils.isBlank(r4) == true) goto L5;
        this.path = r4;
    L6:
        this.secure = r5;
        return;
    L5:
        this.path = LibrarianImpl.Constants.SEPARATOR;
        goto L6
    }

    public String getHost() {
        return this.host;
    }

    public String getPath() {
        return this.path;
    }

    public int getPort() {
        return this.port;
    }

    public boolean isSecure() {
        return this.secure;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[");
        if (this.secure == false) goto L5;
        r0.append("(secure)");
    L5:
        r0.append(this.host);
        r0.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        r0.append(Integer.toString(this.port));
        r0.append(this.path);
        r0.append(']');
        return r0.toString();
    }
}
