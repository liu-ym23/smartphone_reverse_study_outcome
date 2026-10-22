package cz.msebera.android.httpclient.config;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.util.Args;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: loaded from: classes5.dex */
public class ConnectionConfig implements Cloneable {
    public static final ConnectionConfig DEFAULT = null;
    private final int bufferSize;
    private final Charset charset;
    private final int fragmentSizeHint;
    private final CodingErrorAction malformedInputAction;
    private final MessageConstraints messageConstraints;
    private final CodingErrorAction unmappableInputAction;

    public static class Builder {
        private int bufferSize;
        private Charset charset;
        private int fragmentSizeHint;
        private CodingErrorAction malformedInputAction;
        private MessageConstraints messageConstraints;
        private CodingErrorAction unmappableInputAction;

        Builder() {
            this.fragmentSizeHint = -1;
        }

        public Builder setBufferSize(int r1) {
            this.bufferSize = r1;
            return this;
        }

        public Builder setFragmentSizeHint(int r1) {
            this.fragmentSizeHint = r1;
            return this;
        }

        public Builder setCharset(Charset r1) {
            this.charset = r1;
            return this;
        }

        public Builder setMalformedInputAction(CodingErrorAction r1) {
            this.malformedInputAction = r1;
            if (r1 != null) goto L5;
        L7:
            return this;
        L5:
            if (this.charset != null) goto L7;
            this.charset = Consts.ASCII;
            goto L7
        }

        public Builder setUnmappableInputAction(CodingErrorAction r1) {
            this.unmappableInputAction = r1;
            if (r1 != null) goto L5;
        L7:
            return this;
        L5:
            if (this.charset != null) goto L7;
            this.charset = Consts.ASCII;
            goto L7
        }

        public Builder setMessageConstraints(MessageConstraints r1) {
            this.messageConstraints = r1;
            return this;
        }

        public ConnectionConfig build() {
            Charset r0 = this.charset;
            if (r0 == null) goto L5;
        L9:
            Charset r4 = r0;
            int r1 = this.bufferSize;
            if (r1 > 0) goto L13;
            r1 = 8192;
        L13:
            int r2 = r1;
            int r3 = this.fragmentSizeHint;
            if (r3 < 0) goto L16;
            int r5 = r3;
        L18:
            return new ConnectionConfig(r2, r5, r4, this.malformedInputAction, this.unmappableInputAction, this.messageConstraints);
        L16:
            r5 = r2;
            goto L18
        L5:
            if (this.malformedInputAction == null) goto L7;
        L8:
            r0 = Consts.ASCII;
            goto L9
        L7:
            if (this.unmappableInputAction == null) goto L9;
            goto L8
        }
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    protected /* bridge */ /* synthetic */ Object m1500clone() throws CloneNotSupportedException {
        return clone();
    }

    static {
        DEFAULT = new Builder().build();
    }

    ConnectionConfig(int r1, int r2, Charset r3, CodingErrorAction r4, CodingErrorAction r5, MessageConstraints r6) {
        this.bufferSize = r1;
        this.fragmentSizeHint = r2;
        this.charset = r3;
        this.malformedInputAction = r4;
        this.unmappableInputAction = r5;
        this.messageConstraints = r6;
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public int getFragmentSizeHint() {
        return this.fragmentSizeHint;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public CodingErrorAction getMalformedInputAction() {
        return this.malformedInputAction;
    }

    public CodingErrorAction getUnmappableInputAction() {
        return this.unmappableInputAction;
    }

    public MessageConstraints getMessageConstraints() {
        return this.messageConstraints;
    }

    protected ConnectionConfig clone() throws CloneNotSupportedException {
        return (ConnectionConfig) super.clone();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[bufferSize=");
        r0.append(this.bufferSize).append(", fragmentSizeHint=").append(this.fragmentSizeHint).append(", charset=").append(this.charset).append(", malformedInputAction=").append(this.malformedInputAction).append(", unmappableInputAction=").append(this.unmappableInputAction).append(", messageConstraints=").append(this.messageConstraints).append("]");
        return r0.toString();
    }

    public static Builder custom() {
        return new Builder();
    }

    public static Builder copy(ConnectionConfig r2) {
        Args.notNull(r2, "Connection config");
        return new Builder().setBufferSize(r2.getBufferSize()).setCharset(r2.getCharset()).setFragmentSizeHint(r2.getFragmentSizeHint()).setMalformedInputAction(r2.getMalformedInputAction()).setUnmappableInputAction(r2.getUnmappableInputAction()).setMessageConstraints(r2.getMessageConstraints());
    }
}
