package adcpeJava.adcpe;

import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.util.Base64;

/* JADX INFO: loaded from: classes.dex */
public class Constants {
    static final int COIN1_BYTE_COUNT = 16;
    static final int COIN2_BYTE_COUNT = 16;
    static final int COIN_BYTE_COUNT = 32;
    public static final Base64.Decoder DECODER = null;
    static final double DEFAULT_APPROX_FACTOR = 0.1d;
    public static final String DEFAULT_TEST_SK_SEED = "y5adsgpfojktyg90gerwyhrbdsyh4ou2";
    public static final Base64.Encoder ENCODER = null;
    static final double GAMMA = 0.0d;
    static final int KEY_SEED_MIN_LEN = 32;
    static final int MAX_ITERATION_NUM = 10000;
    static final int NORM_HEX_CHAR_COUNT = 16;
    static final int N_B64_BYTE_COUNT = 44;
    static final int N_BYTE_COUNT = 32;
    static final int N_HEX_CHAR_COUNT = 64;
    static final int QR_ORTHOGONAL_MAT_MAX_DIM = 512;
    static final int SK_S_BYTE_SIZE = 2;

    static class AlgoVersion {
        static int ALGO_VERSION_1Dot0Dot011 = 1;
        static int ALGO_VERSION_1Dot0Dot012 = 2;
        static int ALGO_VERSION_1Dot0Dot016 = 3;
        static int ALGO_VERSION_1Dot0Dot017 = 3;
        static int NOT_SUPPORTED;

        static {
        }

        AlgoVersion() {
        }
    }

    static final enum KeyType extends Enum<KeyType> {
        private static final /* synthetic */ KeyType[] $VALUES = null;
        public static final KeyType KEY_VERSION_HOUSEHOLDER = null;
        public static final KeyType KEY_VERSION_NO_MAT = null;
        public static final KeyType KEY_VERSION_QR = null;
        public static final KeyType NOT_SUPPORTED = null;

        private KeyType(String r1, int r2) {
            super(r1, r2);
        }

        public static KeyType valueOf(String r1) {
            return (KeyType) Enum.valueOf(KeyType.class, r1);
        }

        public static KeyType[] values() {
            return (KeyType[]) $VALUES.clone();
        }

        static {
            KeyType r0 = new KeyType(NetworkStackConstant.ERR_NOT_SUPPORTED, 0);
            NOT_SUPPORTED = r0;
            KeyType r1 = new KeyType("KEY_VERSION_NO_MAT", 1);
            KEY_VERSION_NO_MAT = r1;
            KeyType r3 = new KeyType("KEY_VERSION_QR", 2);
            KEY_VERSION_QR = r3;
            KeyType r5 = new KeyType("KEY_VERSION_HOUSEHOLDER", 3);
            KEY_VERSION_HOUSEHOLDER = r5;
            $VALUES = new KeyType[]{r0, r1, r3, r5};
        }
    }

    public Constants() {
    }

    static {
        GAMMA = (Math.sqrt(20.0d) * 0.5d) - 2.0d;
        ENCODER = Base64.getEncoder();
        DECODER = Base64.getDecoder();
    }
}
