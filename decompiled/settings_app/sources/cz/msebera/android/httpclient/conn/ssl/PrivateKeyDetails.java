package cz.msebera.android.httpclient.conn.ssl;

import com.android.settingslib.accessibility.AccessibilityUtils;
import cz.msebera.android.httpclient.util.Args;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class PrivateKeyDetails {
    private final X509Certificate[] certChain;
    private final String type;

    public PrivateKeyDetails(String r2, X509Certificate[] r3) {
        this.type = (String) Args.notNull(r2, "Private key type");
        this.certChain = r3;
    }

    public String getType() {
        return this.type;
    }

    public X509Certificate[] getCertChain() {
        return this.certChain;
    }

    public String toString() {
        return this.type + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + Arrays.toString(this.certChain);
    }
}
