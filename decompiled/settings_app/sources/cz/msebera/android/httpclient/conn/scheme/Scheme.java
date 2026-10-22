package cz.msebera.android.httpclient.conn.scheme;

import com.android.settingslib.accessibility.AccessibilityUtils;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class Scheme {
    private final int defaultPort;
    private final boolean layered;
    private final String name;
    private final SchemeSocketFactory socketFactory;
    private String stringRep;

    public Scheme(String r5, int r6, SchemeSocketFactory r7) {
        Args.notNull(r5, "Scheme name");
        if (r6 > 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        Args.check(r2, "Port is invalid");
        Args.notNull(r7, "Socket factory");
        this.name = r5.toLowerCase(Locale.ENGLISH);
        this.defaultPort = r6;
        if ((r7 instanceof SchemeLayeredSocketFactory) == false) goto L12;
        this.layered = true;
        this.socketFactory = r7;
        return;
    L12:
        if ((r7 instanceof LayeredSchemeSocketFactory) == false) goto L14;
        this.layered = true;
        this.socketFactory = new SchemeLayeredSocketFactoryAdaptor2((LayeredSchemeSocketFactory) r7);
        return;
    L14:
        this.layered = false;
        this.socketFactory = r7;
        return;
    L5:
        if (r6 > 65535) goto L7;
        r2 = true;
        goto L8
    }

    @Deprecated
    public Scheme(String r5, SocketFactory r6, int r7) {
        Args.notNull(r5, "Scheme name");
        Args.notNull(r6, "Socket factory");
        if (r7 > 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        Args.check(r2, "Port is invalid");
        this.name = r5.toLowerCase(Locale.ENGLISH);
        if ((r6 instanceof LayeredSocketFactory) == false) goto L11;
        this.socketFactory = new SchemeLayeredSocketFactoryAdaptor((LayeredSocketFactory) r6);
        this.layered = true;
    L12:
        this.defaultPort = r7;
        return;
    L11:
        this.socketFactory = new SchemeSocketFactoryAdaptor(r6);
        this.layered = false;
        goto L12
    L5:
        if (r7 > 65535) goto L7;
        r2 = true;
        goto L8
    }

    public final int getDefaultPort() {
        return this.defaultPort;
    }

    @Deprecated
    public final SocketFactory getSocketFactory() {
        SchemeSocketFactory r0 = this.socketFactory;
        if ((r0 instanceof SchemeSocketFactoryAdaptor) == false) goto L7;
        return ((SchemeSocketFactoryAdaptor) r0).getFactory();
    L7:
        if (this.layered == false) goto L10;
        return new LayeredSocketFactoryAdaptor((LayeredSchemeSocketFactory) this.socketFactory);
    L10:
        return new SocketFactoryAdaptor(this.socketFactory);
    }

    public final SchemeSocketFactory getSchemeSocketFactory() {
        return this.socketFactory;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isLayered() {
        return this.layered;
    }

    public final int resolvePort(int r1) {
        if (r1 <= 0) goto L4;
        return r1;
    L4:
        return this.defaultPort;
    }

    public final String toString() {
        if (this.stringRep != null) goto L6;
        this.stringRep = this.name + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + Integer.toString(this.defaultPort);
    L6:
        return this.stringRep;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Scheme) == false) goto L16;
        Scheme r6 = (Scheme) r5;
        if (this.name.equals(r6.name) == false) goto L15;
        if (this.defaultPort != r6.defaultPort) goto L15;
        if (this.layered != r6.layered) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.defaultPort), this.name), this.layered);
    }
}
