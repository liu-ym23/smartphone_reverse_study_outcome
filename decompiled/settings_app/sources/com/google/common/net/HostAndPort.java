package com.google.common.net;

import com.android.settings.CustomKeyUtils;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.google.common.base.CharMatcher;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
@ElementTypesAreNonnullByDefault
public final class HostAndPort implements Serializable {
    private static final int NO_PORT = -1;
    private static final long serialVersionUID = 0;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;

    private static boolean isValidPort(int r1) {
        if (r1 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 > 65535) goto L6;
        return true;
    }

    private HostAndPort(String r1, int r2, boolean r3) {
        this.host = r1;
        this.port = r2;
        this.hasBracketlessColons = r3;
    }

    public String getHost() {
        return this.host;
    }

    public boolean hasPort() {
        if (this.port < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getPort() {
        Preconditions.checkState(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int r2) {
        if (hasPort() == true) goto L5;
        return r2;
    L5:
        return this.port;
    }

    public static HostAndPort fromParts(String r3, int r4) {
        Preconditions.checkArgument(isValidPort(r4), "Port out of range: %s", r4);
        HostAndPort r0 = fromString(r3);
        Preconditions.checkArgument(!r0.hasPort(), "Host has a port: %s", r3);
        return new HostAndPort(r0.host, r4, r0.hasBracketlessColons);
    }

    public static HostAndPort fromHost(String r3) {
        HostAndPort r0 = fromString(r3);
        Preconditions.checkArgument(!r0.hasPort(), "Host has a port: %s", r3);
        return r0;
    }

    public static HostAndPort fromString(String r8) {
        Preconditions.checkNotNull(r8);
        int r1 = -1;
        boolean r2 = true;
        if (r8.startsWith("[") == false) goto L6;
        String[] r0 = getHostAndPortFromBracketedHost(r8);
        String r4 = r0[0];
        String r3 = r0[1];
    L5:
        String r5 = r4;
        boolean r6 = false;
    L16:
        if (Strings.isNullOrEmpty(r3) == true) goto L33;
        if (r3.startsWith(CustomKeyUtils.KEY_SEPARATE_FOR_SHOW) == false) goto L20;
    L22:
        r2 = false;
    L23:
        Preconditions.checkArgument(r2, "Unparseable port number: %s", r8);
        r1 = Integer.parseInt(r3);     // Catch: NumberFormatException -> L26
        Preconditions.checkArgument(isValidPort(r1), "Port number out of range: %s", r8);
    L26:
        String r9 = String.valueOf(r8);
        if (r9.length() == 0) goto L29;
        String r10 = "Unparseable port number: ".concat(r9);
    L31:
        throw new IllegalArgumentException(r10);
    L29:
        r10 = new String("Unparseable port number: ");
        goto L31
    L20:
        if (CharMatcher.ascii().matchesAllOf(r3) == false) goto L22;
    L33:
        return new HostAndPort(r5, r1, r6);
    L6:
        int r7 = r8.indexOf(58);
        if (r7 < 0) goto L11;
        int r11 = r7 + 1;
        if (r8.indexOf(58, r11) != (-1)) goto L11;
        r4 = r8.substring(0, r7);
        r3 = r8.substring(r11);
    L11:
        if (r7 < 0) goto L13;
        boolean r12 = true;
    L14:
        r5 = r8;
        r6 = r12;
        r3 = null;
        goto L16
    L13:
        r12 = false;
        goto L14
    }

    private static String[] getHostAndPortFromBracketedHost(String r8) {
        if (r8.charAt(0) != '[') goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "Bracketed host-port string must start with a bracket: %s", r8);
        int r2 = r8.indexOf(58);
        int r4 = r8.lastIndexOf(93);
        if (r2 <= (-1)) goto L10;
        if (r4 <= r2) goto L10;
        boolean r3 = true;
    L11:
        Preconditions.checkArgument(r3, "Invalid bracketed host/port: %s", r8);
        String r5 = r8.substring(1, r4);
        int r6 = r4 + 1;
        if (r6 != r8.length()) goto L16;
        return new String[]{r5, ""};
    L16:
        if (r8.charAt(r6) != ':') goto L18;
        boolean r7 = true;
    L19:
        Preconditions.checkArgument(r7, "Only a colon may follow a close bracket: %s", r8);
        int r9 = r4 + 2;
        int r10 = r9;
    L21:
        if (r10 >= r8.length()) goto L24;
        Preconditions.checkArgument(Character.isDigit(r8.charAt(r10)), "Port must be numeric: %s", r8);
        r10 = r10 + 1;
        goto L21
    L24:
        return new String[]{r5, r8.substring(r9)};
    L18:
        r7 = false;
    L10:
        r3 = false;
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    public HostAndPort withDefaultPort(int r3) {
        Preconditions.checkArgument(isValidPort(r3));
        if (hasPort() == false) goto L6;
        return this;
    L6:
        return new HostAndPort(this.host, r3, this.hasBracketlessColons);
    }

    public HostAndPort requireBracketsForIPv6() {
        Preconditions.checkArgument(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }

    public boolean equals(@CheckForNull Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof HostAndPort) == false) goto L14;
        HostAndPort r6 = (HostAndPort) r5;
        if (Objects.equal(this.host, r6.host) == false) goto L13;
        if (this.port != r6.port) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.host, Integer.valueOf(this.port)});
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) < 0) goto L5;
        r0.append('[').append(this.host).append(']');
    L7:
        if (hasPort() == false) goto L10;
        r0.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(this.port);
    L10:
        return r0.toString();
    L5:
        r0.append(this.host);
        goto L7
    }
}
