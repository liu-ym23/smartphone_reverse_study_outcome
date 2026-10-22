package tmsdk.common.tcc;

import java.util.concurrent.atomic.AtomicInteger;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public class TrafficSmsParser {

    public static class MatchRule {
        public String postfix;
        public String prefix;
        public int type;
        public int unit;

        public MatchRule(int r1, int r2, String r3, String r4) {
            this.unit = r1;
            this.type = r2;
            this.prefix = r3;
            this.postfix = r4;
        }
    }

    static {
        TMSDKContext.registerNatives(6, TrafficSmsParser.class);
    }

    public TrafficSmsParser() {
    }

    public static int getNumberEntrance(String r0, String r1, MatchRule r2, AtomicInteger r3) {
        return nativeGetNumberEntrance(r0, r1, r2, r3);
    }

    public static int getWrongSmsType(String r0, String r1) {
        return nativeGetWrongSmsType(r0, r1);
    }

    private static native int nativeGetNumberEntrance(String r0, String r1, MatchRule r2, AtomicInteger r3);

    private static native int nativeGetWrongSmsType(String r0, String r1);
}
