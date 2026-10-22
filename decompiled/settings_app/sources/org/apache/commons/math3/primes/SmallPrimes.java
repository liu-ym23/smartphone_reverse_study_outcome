package org.apache.commons.math3.primes;

import android.icu.lang.UCharacter;
import androidx.core.view.PointerIconCompat;
import com.android.settings.fingerprint.FingerprintEnrollSidecar;
import com.google.zxing.pdf417.PDF417Common;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.entity.app.EntityType;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import obric.bluetooth.SmartBluetoothBinderClient;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
class SmallPrimes {
    public static final int[] PRIMES = null;
    public static final int PRIMES_LAST = 0;

    static {
        int[] r0 = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, UCharacter.UnicodeBlock.COPTIC_EPACT_NUMBERS_ID, UCharacter.UnicodeBlock.GEOMETRIC_SHAPES_EXTENDED_ID, UCharacter.UnicodeBlock.KHOJKI_ID, 233, UCharacter.UnicodeBlock.NABATAEAN_ID, UCharacter.UnicodeBlock.OLD_PERMIC_ID, UCharacter.UnicodeBlock.TIRHUTA_ID, 257, UCharacter.UnicodeBlock.ADLAM_ID, UCharacter.UnicodeBlock.MONGOLIAN_SUPPLEMENT_ID, UCharacter.UnicodeBlock.OSAGE_ID, UCharacter.UnicodeBlock.NUSHU_ID, UCharacter.UnicodeBlock.CHESS_SYMBOLS_ID, UCharacter.UnicodeBlock.GEORGIAN_EXTENDED_ID, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, SmartBluetoothBinderClient.PRODUCT_2, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, PDF417Common.NUMBER_OF_CODEWORDS, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, PointerIconCompat.TYPE_VERTICAL_TEXT, PointerIconCompat.TYPE_ALL_SCROLL, PointerIconCompat.TYPE_ZOOM_OUT, PointerIconCompat.TYPE_GRABBING, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093, 1097, FingerprintEnrollSidecar.EVENT_FINGER_UP, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181, 1187, 1193, EntityType.IM_CONTACT, 1213, 1217, 1223, 1229, 1231, 1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297, EntityType.DOUBAO_ACCOUNT, 1303, 1307, 1319, 1321, 1327, 1361, 1367, 1373, 1381, 1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481, 1483, 1487, 1489, 1493, 1499, 1511, 1523, 1531, 1543, 1549, 1553, 1559, 1567, 1571, 1579, 1583, 1597, EntityType.EVENT_TASK, 1607, 1609, 1613, 1619, 1621, 1627, 1637, 1657, 1663, 1667, 1669, 1693, 1697, 1699, 1709, 1721, 1723, 1733, 1741, 1747, 1753, 1759, 1777, 1783, 1787, 1789, 1801, 1811, 1823, 1831, 1847, 1861, 1867, 1871, 1873, 1877, 1879, 1889, 1901, 1907, 1913, 1931, 1933, 1949, 1951, 1973, 1979, 1987, 1993, 1997, 1999, ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_FOR_PAST_TIMES_ERROR, 2011, 2017, 2027, 2029, 2039, 2053, 2063, 2069, 2081, 2083, 2087, 2089, 2099, 2111, 2113, 2129, 2131, 2137, 2141, 2143, 2153, 2161, 2179, 2203, 2207, 2213, 2221, 2237, 2239, 2243, 2251, 2267, 2269, 2273, 2281, 2287, 2293, 2297, 2309, 2311, 2333, 2339, 2341, 2347, 2351, 2357, 2371, 2377, 2381, 2383, 2389, 2393, 2399, 2411, 2417, 2423, 2437, 2441, 2447, 2459, 2467, 2473, 2477, 2503, 2521, 2531, 2539, 2543, 2549, 2551, 2557, 2579, 2591, 2593, 2609, 2617, 2621, 2633, 2647, 2657, 2659, 2663, 2671, 2677, 2683, 2687, 2689, 2693, 2699, 2707, 2711, 2713, 2719, 2729, 2731, 2741, 2749, 2753, 2767, 2777, 2789, 2791, 2797, 2801, 2803, 2819, 2833, 2837, 2843, 2851, 2857, 2861, 2879, 2887, 2897, 2903, 2909, 2917, 2927, 2939, 2953, 2957, 2963, 2969, 2971, 2999, ErrorCode.AudioControl.NO_CONTROLLABLE_SESSION_ERROR, 3011, 3019, 3023, 3037, 3041, 3049, 3061, 3067, 3079, 3083, 3089, 3109, 3119, 3121, 3137, 3163, 3167, 3169, 3181, 3187, 3191, 3203, 3209, 3217, 3221, 3229, 3251, 3253, 3257, 3259, 3271, 3299, 3301, 3307, 3313, 3319, 3323, 3329, 3331, 3343, 3347, 3359, 3361, 3371, 3373, 3389, 3391, 3407, 3413, 3433, 3449, 3457, 3461, 3463, 3467, 3469, 3491, 3499, 3511, 3517, 3527, 3529, 3533, 3539, 3541, 3547, 3557, 3559, 3571, 3581, 3583, 3593, 3607, 3613, 3617, 3623, 3631, 3637, 3643, 3659, 3671};
        PRIMES = r0;
        PRIMES_LAST = r0[r0.length - 1];
    }

    private SmallPrimes() {
    }

    public static int smallTrialDivision(int r5, List<Integer> r6) {
        int[] r0 = PRIMES;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        int r3 = r0[r2];
    L6:
        if ((r5 % r3) != 0) goto L8;
        r5 = r5 / r3;
        r6.add(Integer.valueOf(r3));
        goto L6
    L8:
        r2 = r2 + 1;
        goto L3
    L9:
        return r5;
    }

    public static int boundedTrialDivision(int r2, int r3, List<Integer> r4) {
        int r0 = PRIMES_LAST;
    L3:
        int r1 = r0 + 2;
        if (r1 > r3) goto L12;
        if ((r2 % r1) == 0) goto L7;
        r0 = r1 + 4;
        if ((r2 % r0) != 0) goto L3;
        r2 = r2 / r0;
        r4.add(Integer.valueOf(r0));
        goto L12
    L7:
        r2 = r2 / r1;
        r4.add(Integer.valueOf(r1));
    L12:
        if (r2 == 1) goto L14;
        r4.add(Integer.valueOf(r2));
    L14:
        return r2;
    }

    public static List<Integer> trialDivision(int r3) {
        ArrayList r0 = new ArrayList(32);
        int r4 = smallTrialDivision(r3, r0);
        if (1 != r4) goto L5;
        return r0;
    L5:
        boundedTrialDivision(r4, (int) FastMath.sqrt(r4), r0);
        return r0;
    }

    public static boolean millerRabinPrimeTest(int r13) {
        int r0 = r13 - 1;
        int r1 = Integer.numberOfTrailingZeros(r0);
        int r2 = r0 >> r1;
        if (r13 < 2047) goto L5;
        int r3 = 2;
    L7:
        if (r13 < 1373653) goto L10;
        r3 = 3;
    L10:
        if (r13 < 25326001) goto L12;
        r3 = 4;
    L12:
        BigInteger r4 = BigInteger.valueOf(r2);
        long r5 = r13;
        BigInteger r14 = BigInteger.valueOf(r5);
        int r8 = 0;
    L13:
        if (r8 >= r3) goto L28;
        int r9 = BigInteger.valueOf(PRIMES[r8]).modPow(r4, r14).intValue();
        if (1 == r9) goto L27;
        if (r9 == r0) goto L27;
        int r10 = 1;
    L19:
        if (r10 > (r1 - 1)) goto L25;
        if (r0 == r9) goto L25;
        long r11 = r9;
        r9 = (int) ((r11 * r11) % r5);
        if (1 == r9) goto L23;
        r10 = r10 + 1;
        goto L19
    L23:
        return false;
    L25:
        if (r0 == r9) goto L27;
        return false;
    L27:
        r8 = r8 + 1;
        goto L13
    L28:
        return true;
    L5:
        r3 = 1;
        goto L7
    }
}
