package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.util.Args;
import java.io.Serializable;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ProtocolVersion implements Serializable, Cloneable {
    private static final long serialVersionUID = 8950662842175091068L;
    protected final int major;
    protected final int minor;
    protected final String protocol;

    public ProtocolVersion(String r2, int r3, int r4) {
        this.protocol = (String) Args.notNull(r2, "Protocol name");
        this.major = Args.notNegative(r3, "Protocol minor version");
        this.minor = Args.notNegative(r4, "Protocol minor version");
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public ProtocolVersion forVersion(int r2, int r3) {
        if (r2 != this.major) goto L8;
        if (r3 != this.minor) goto L8;
        return this;
    L8:
        return new ProtocolVersion(this.protocol, r2, r3);
    }

    public final int hashCode() {
        int r0 = this.protocol.hashCode() ^ (this.major * 100000);
        return this.minor ^ r0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ProtocolVersion) == true) goto L8;
        return false;
    L8:
        ProtocolVersion r6 = (ProtocolVersion) r5;
        if (this.protocol.equals(r6.protocol) == false) goto L16;
        if (this.major != r6.major) goto L16;
        if (this.minor != r6.minor) goto L16;
        return true;
    L16:
        return false;
    }

    public boolean isComparable(ProtocolVersion r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.protocol.equals(r1.protocol) == false) goto L6;
        return true;
    }

    public int compareToVersion(ProtocolVersion r4) {
        Args.notNull(r4, "Protocol version");
        Args.check(this.protocol.equals(r4.protocol), "Versions for different protocols cannot be compared: %s %s", new Object[]{this, r4});
        int r0 = getMajor() - r4.getMajor();
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return getMinor() - r4.getMinor();
    }

    public final boolean greaterEquals(ProtocolVersion r2) {
        if (isComparable(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (compareToVersion(r2) < 0) goto L7;
        return true;
    }

    public final boolean lessEquals(ProtocolVersion r2) {
        if (isComparable(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (compareToVersion(r2) > 0) goto L7;
        return true;
    }

    public String toString() {
        return this.protocol + IOUtils.DIR_SEPARATOR_UNIX + Integer.toString(this.major) + '.' + Integer.toString(this.minor);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
