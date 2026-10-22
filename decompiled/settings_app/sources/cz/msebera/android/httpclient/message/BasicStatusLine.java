package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.util.Args;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class BasicStatusLine implements StatusLine, Cloneable, Serializable {
    private static final long serialVersionUID = -2443303766890459269L;
    private final ProtocolVersion protoVersion;
    private final String reasonPhrase;
    private final int statusCode;

    public BasicStatusLine(ProtocolVersion r2, int r3, String r4) {
        this.protoVersion = (ProtocolVersion) Args.notNull(r2, "Version");
        this.statusCode = Args.notNegative(r3, "Status code");
        this.reasonPhrase = r4;
    }

    @Override // cz.msebera.android.httpclient.StatusLine
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override // cz.msebera.android.httpclient.StatusLine
    public ProtocolVersion getProtocolVersion() {
        return this.protoVersion;
    }

    @Override // cz.msebera.android.httpclient.StatusLine
    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public String toString() {
        return BasicLineFormatter.INSTANCE.formatStatusLine(null, this).toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
