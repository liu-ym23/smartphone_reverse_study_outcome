package cz.msebera.android.httpclient.config;

import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class SocketConfig implements Cloneable {
    public static final SocketConfig DEFAULT = null;
    private final int backlogSize;
    private final int rcvBufSize;
    private final int sndBufSize;
    private final boolean soKeepAlive;
    private final int soLinger;
    private final boolean soReuseAddress;
    private final int soTimeout;
    private final boolean tcpNoDelay;

    public static class Builder {
        private int backlogSize;
        private int rcvBufSize;
        private int sndBufSize;
        private boolean soKeepAlive;
        private int soLinger;
        private boolean soReuseAddress;
        private int soTimeout;
        private boolean tcpNoDelay;

        Builder() {
            this.soLinger = -1;
            this.tcpNoDelay = true;
        }

        public Builder setSoTimeout(int r1) {
            this.soTimeout = r1;
            return this;
        }

        public Builder setSoReuseAddress(boolean r1) {
            this.soReuseAddress = r1;
            return this;
        }

        public Builder setSoLinger(int r1) {
            this.soLinger = r1;
            return this;
        }

        public Builder setSoKeepAlive(boolean r1) {
            this.soKeepAlive = r1;
            return this;
        }

        public Builder setTcpNoDelay(boolean r1) {
            this.tcpNoDelay = r1;
            return this;
        }

        public Builder setSndBufSize(int r1) {
            this.sndBufSize = r1;
            return this;
        }

        public Builder setRcvBufSize(int r1) {
            this.rcvBufSize = r1;
            return this;
        }

        public Builder setBacklogSize(int r1) {
            this.backlogSize = r1;
            return this;
        }

        public SocketConfig build() {
            return new SocketConfig(this.soTimeout, this.soReuseAddress, this.soLinger, this.soKeepAlive, this.tcpNoDelay, this.sndBufSize, this.rcvBufSize, this.backlogSize);
        }
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    protected /* bridge */ /* synthetic */ Object m1502clone() throws CloneNotSupportedException {
        return clone();
    }

    static {
        DEFAULT = new Builder().build();
    }

    SocketConfig(int r1, boolean r2, int r3, boolean r4, boolean r5, int r6, int r7, int r8) {
        this.soTimeout = r1;
        this.soReuseAddress = r2;
        this.soLinger = r3;
        this.soKeepAlive = r4;
        this.tcpNoDelay = r5;
        this.sndBufSize = r6;
        this.rcvBufSize = r7;
        this.backlogSize = r8;
    }

    public int getSoTimeout() {
        return this.soTimeout;
    }

    public boolean isSoReuseAddress() {
        return this.soReuseAddress;
    }

    public int getSoLinger() {
        return this.soLinger;
    }

    public boolean isSoKeepAlive() {
        return this.soKeepAlive;
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    public int getSndBufSize() {
        return this.sndBufSize;
    }

    public int getRcvBufSize() {
        return this.rcvBufSize;
    }

    public int getBacklogSize() {
        return this.backlogSize;
    }

    protected SocketConfig clone() throws CloneNotSupportedException {
        return (SocketConfig) super.clone();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[soTimeout=");
        r0.append(this.soTimeout).append(", soReuseAddress=").append(this.soReuseAddress).append(", soLinger=").append(this.soLinger).append(", soKeepAlive=").append(this.soKeepAlive).append(", tcpNoDelay=").append(this.tcpNoDelay).append(", sndBufSize=").append(this.sndBufSize).append(", rcvBufSize=").append(this.rcvBufSize).append(", backlogSize=").append(this.backlogSize).append("]");
        return r0.toString();
    }

    public static Builder custom() {
        return new Builder();
    }

    public static Builder copy(SocketConfig r2) {
        Args.notNull(r2, "Socket config");
        return new Builder().setSoTimeout(r2.getSoTimeout()).setSoReuseAddress(r2.isSoReuseAddress()).setSoLinger(r2.getSoLinger()).setSoKeepAlive(r2.isSoKeepAlive()).setTcpNoDelay(r2.isTcpNoDelay()).setSndBufSize(r2.getSndBufSize()).setRcvBufSize(r2.getRcvBufSize()).setBacklogSize(r2.getBacklogSize());
    }
}
