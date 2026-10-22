package com.google.common.net;

import com.google.common.base.Preconditions;
import java.net.InetAddress;
import java.text.ParseException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class HostSpecifier {
    private final String canonicalForm;

    private HostSpecifier(String r1) {
        this.canonicalForm = r1;
    }

    public static HostSpecifier fromValid(String r3) {
        HostAndPort r4 = HostAndPort.fromString(r3);
        Preconditions.checkArgument(!r4.hasPort());
        String r5 = r4.getHost();
        InetAddress r0 = InetAddresses.forString(r5);     // Catch: IllegalArgumentException -> L5
    L6:
        if (r0 != null) goto L8;
        InternetDomainName r1 = InternetDomainName.from(r5);
        if (r1.hasPublicSuffix() == true) goto L12;
        String r6 = String.valueOf(r5);
        if (r6.length() == 0) goto L16;
        String r7 = "Domain name does not have a recognized public suffix: ".concat(r6);
    L18:
        throw new IllegalArgumentException(r7);
    L16:
        r7 = new String("Domain name does not have a recognized public suffix: ");
        goto L18
    L12:
        return new HostSpecifier(r1.toString());
    L8:
        return new HostSpecifier(InetAddresses.toUriString(r0));
    L5:
        r0 = null;
        goto L6
    }

    public static HostSpecifier from(String r4) throws ParseException {
        return fromValid(r4);
    L4:
        e = move-exception;
        String r5 = String.valueOf(r4);
        if (r5.length() == 0) goto L8;
        String r6 = "Invalid host specifier: ".concat(r5);
    L9:
        ParseException r1 = new ParseException(r6, 0);
        r1.initCause(e);
        throw r1;
    L8:
        r6 = new String("Invalid host specifier: ");
        goto L9
    }

    public static boolean isValid(String r0) {
        fromValid(r0);     // Catch: IllegalArgumentException -> L5
        return true;
    L5:
        return false;
    }

    public boolean equals(@CheckForNull Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof HostSpecifier) == true) goto L8;
        return false;
    L8:
        return this.canonicalForm.equals(((HostSpecifier) r2).canonicalForm);
    }

    public int hashCode() {
        return this.canonicalForm.hashCode();
    }

    public String toString() {
        return this.canonicalForm;
    }
}
