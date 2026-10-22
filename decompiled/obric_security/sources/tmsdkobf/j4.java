package tmsdkobf;

import com.bytedance.keva.KevaImpl;

/* JADX INFO: loaded from: classes5.dex */
public abstract class j4 {
    public static final int a(int r2) {
        return ((r2 % 1000000) - c(r2)) - b(r2);
    }

    public static final int b(int r0) {
        return r0 % 100;
    }

    public static final int c(int r1) {
        return (r1 % KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) - b(r1);
    }

    public static int d(int r3) {
        if (r3 != 0) goto L5;
        return r3;
    L5:
        if (b(r3) == 0) goto L8;
        return r3;
    L8:
        switch(a(r3)) {
            case -550000: goto L18;
            case -540000: goto L18;
            case -530000: goto L18;
            case -500000: goto L17;
            case -490000: goto L17;
            case -480000: goto L17;
            case -470000: goto L17;
            case -460000: goto L17;
            case -450000: goto L17;
            case -440000: goto L17;
            case -430000: goto L16;
            case -420000: goto L17;
            case -410000: goto L17;
            case -400000: goto L17;
            case -390000: goto L17;
            case -380000: goto L17;
            case -370000: goto L17;
            case -360000: goto L16;
            case -350000: goto L16;
            case -340000: goto L17;
            case -330000: goto L17;
            case -320000: goto L17;
            case -310000: goto L17;
            case -300000: goto L15;
            case -220000: goto L14;
            case -210000: goto L17;
            case -190000: goto L17;
            case -180000: goto L17;
            case -170000: goto L13;
            case -160000: goto L12;
            case -150000: goto L17;
            case -140000: goto L17;
            case -130000: goto L11;
            case -120000: goto L18;
            case -100000: goto L17;
            case -90000: goto L17;
            case -80000: goto L17;
            case -70000: goto L17;
            case -60000: goto L10;
            case -50000: goto L18;
            case -40000: goto L17;
            case -10000: goto L17;
            default: goto L9;
        };
    L9:
        int r0 = r3;
    L19:
        if (r0 != r3) goto L43;
        int r1 = c(r3);
        if (r1 != (-2600)) goto L24;
    L39:
        r0 = r3 - 5;
    L40:
        if (r0 != r3) goto L43;
        return r3 - 1;
    L24:
        if (r1 != (-1500)) goto L26;
        r0 = r3 - 23;
        goto L40
    L26:
        if (r1 != (-1400)) goto L28;
        r0 = r3 - 9;
        goto L40
    L28:
        if (r1 != (-1200)) goto L30;
        r0 = r3 - 14;
        goto L40
    L30:
        if (r1 == (-900)) goto L39;
        if (r1 == (-700)) goto L39;
        if (r1 == (-600)) goto L39;
    L43:
        return r0;
    L10:
        r0 = r3 - 25;
        goto L19
    L11:
        r0 = r3 - 24;
        goto L19
    L12:
        r0 = r3 - 6;
        goto L19
    L13:
        r0 = r3 - 15;
        goto L19
    L14:
        r0 = r3 - 2;
        goto L19
    L15:
        r0 = r3 - 16;
        goto L19
    L16:
        r0 = r3 - 26;
        goto L19
    L17:
        r0 = r3 - 3;
        goto L19
    L18:
        r0 = r3 - 4;
        goto L19
    }

    public static boolean e(int r1) {
        int r2 = a(r1);
        if (r2 != (-220000)) goto L5;
        return false;
    L5:
        if (r2 != (-160000)) goto L7;
        return false;
    L7:
        if (r2 != (-350000)) goto L9;
        return false;
    L9:
        if (r2 != (-360000)) goto L11;
        return false;
    L11:
        if (r2 == (-430000)) goto L20;
        return true;
    L20:
        return false;
    }

    public static final int a(String r1, int r2) {
        if (r1 != null) goto L5;
        return r2;
    L5:
        if (r1.contains("socket failed: EACCES (Permission denied)") == false) goto L9;
        return -350000;
    L9:
        if (r1.contains("Permission denied") == false) goto L13;
        return -360000;
    L13:
        if (r1.contains("isConnected failed: EHOSTUNREACH (No route to host)") == false) goto L17;
        return -370000;
    L17:
        if (r1.contains("No route to host") == false) goto L21;
        return -380000;
    L21:
        if (r1.contains("socket failed: ECONNRESET (Connection reset by peer)") == false) goto L25;
        return -390000;
    L25:
        if (r1.contains("setsockopt failed: ENOPROTOOPT (Protocol not available)") == false) goto L29;
        return -400000;
    L29:
        if (r1.contains("Protocol not available") == false) goto L33;
        return -410000;
    L33:
        if (r1.contains("Permission denied (missing INTERNET permission?)") == false) goto L37;
        return -430000;
    L37:
        if (r1.contains("failed: ENETUNREACH (Network is unreachable)") == false) goto L41;
        return -450000;
    L41:
        if (r1.contains("failed: ENOTSOCK (Socket operation on non-socket)") == false) goto L45;
        return -460000;
    L45:
        if (r1.contains("isConnected failed: ECONNREFUSED (Connection refused)") == false) goto L49;
        return -470000;
    L49:
        if (r1.contains("isConnected failed: ECONNRESET (Connection reset by peer)") == false) goto L53;
        return -480000;
    L53:
        if (r1.contains("connect failed: errno ") == false) goto L56;
        return -490000;
    L56:
        return r2;
    }
}
