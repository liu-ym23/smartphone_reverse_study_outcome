package cz.msebera.android.httpclient.config;

import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class MessageConstraints implements Cloneable {
    public static final MessageConstraints DEFAULT = null;
    private final int maxHeaderCount;
    private final int maxLineLength;

    public static class Builder {
        private int maxHeaderCount;
        private int maxLineLength;

        Builder() {
            this.maxLineLength = -1;
            this.maxHeaderCount = -1;
        }

        public Builder setMaxLineLength(int r1) {
            this.maxLineLength = r1;
            return this;
        }

        public Builder setMaxHeaderCount(int r1) {
            this.maxHeaderCount = r1;
            return this;
        }

        public MessageConstraints build() {
            return new MessageConstraints(this.maxLineLength, this.maxHeaderCount);
        }
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    protected /* bridge */ /* synthetic */ Object m1501clone() throws CloneNotSupportedException {
        return clone();
    }

    static {
        DEFAULT = new Builder().build();
    }

    MessageConstraints(int r1, int r2) {
        this.maxLineLength = r1;
        this.maxHeaderCount = r2;
    }

    public int getMaxLineLength() {
        return this.maxLineLength;
    }

    public int getMaxHeaderCount() {
        return this.maxHeaderCount;
    }

    protected MessageConstraints clone() throws CloneNotSupportedException {
        return (MessageConstraints) super.clone();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[maxLineLength=");
        r0.append(this.maxLineLength).append(", maxHeaderCount=").append(this.maxHeaderCount).append("]");
        return r0.toString();
    }

    public static MessageConstraints lineLen(int r2) {
        return new MessageConstraints(Args.notNegative(r2, "Max line length"), -1);
    }

    public static Builder custom() {
        return new Builder();
    }

    public static Builder copy(MessageConstraints r2) {
        Args.notNull(r2, "Message constraints");
        return new Builder().setMaxHeaderCount(r2.getMaxHeaderCount()).setMaxLineLength(r2.getMaxLineLength());
    }
}
