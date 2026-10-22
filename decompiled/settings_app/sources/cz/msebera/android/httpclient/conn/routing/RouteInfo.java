package cz.msebera.android.httpclient.conn.routing;

import cz.msebera.android.httpclient.HttpHost;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes5.dex */
public interface RouteInfo {

    public static final enum LayerType extends Enum<LayerType> {
        private static final /* synthetic */ LayerType[] $VALUES = null;
        public static final LayerType LAYERED = null;
        public static final LayerType PLAIN = null;

        static {
            LayerType r0 = new LayerType("PLAIN", 0);
            PLAIN = r0;
            LayerType r1 = new LayerType("LAYERED", 1);
            LAYERED = r1;
            $VALUES = new LayerType[]{r0, r1};
        }

        private LayerType(String r1, int r2) {
            super(r1, r2);
        }

        public static LayerType valueOf(String r1) {
            return (LayerType) Enum.valueOf(LayerType.class, r1);
        }

        public static LayerType[] values() {
            return (LayerType[]) $VALUES.clone();
        }
    }

    public static final enum TunnelType extends Enum<TunnelType> {
        private static final /* synthetic */ TunnelType[] $VALUES = null;
        public static final TunnelType PLAIN = null;
        public static final TunnelType TUNNELLED = null;

        static {
            TunnelType r0 = new TunnelType("PLAIN", 0);
            PLAIN = r0;
            TunnelType r1 = new TunnelType("TUNNELLED", 1);
            TUNNELLED = r1;
            $VALUES = new TunnelType[]{r0, r1};
        }

        private TunnelType(String r1, int r2) {
            super(r1, r2);
        }

        public static TunnelType valueOf(String r1) {
            return (TunnelType) Enum.valueOf(TunnelType.class, r1);
        }

        public static TunnelType[] values() {
            return (TunnelType[]) $VALUES.clone();
        }
    }

    int getHopCount();

    HttpHost getHopTarget(int r1);

    LayerType getLayerType();

    InetAddress getLocalAddress();

    HttpHost getProxyHost();

    HttpHost getTargetHost();

    TunnelType getTunnelType();

    boolean isLayered();

    boolean isSecure();

    boolean isTunnelled();
}
