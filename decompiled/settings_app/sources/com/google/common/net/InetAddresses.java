package com.google.common.net;

import com.android.settings.activate.ActivateService;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.google.common.base.CharMatcher;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class InetAddresses {
    private static final Inet4Address ANY4 = null;
    private static final char IPV4_DELIMITER = '.';
    private static final CharMatcher IPV4_DELIMITER_MATCHER = null;
    private static final int IPV4_PART_COUNT = 4;
    private static final char IPV6_DELIMITER = ':';
    private static final CharMatcher IPV6_DELIMITER_MATCHER = null;
    private static final int IPV6_PART_COUNT = 8;
    private static final Inet4Address LOOPBACK4 = null;

    public static final class TeredoInfo {
        private final Inet4Address client;
        private final int flags;
        private final int port;
        private final Inet4Address server;

        public TeredoInfo(@CheckForNull Inet4Address r6, @CheckForNull Inet4Address r7, int r8, int r9) {
            boolean r0 = true;
            if (r8 < 0) goto L6;
            if (r8 > 65535) goto L6;
            boolean r3 = true;
        L7:
            Preconditions.checkArgument(r3, "port '%s' is out of range (0 <= port <= 0xffff)", r8);
            if (r9 < 0) goto L11;
            if (r9 > 65535) goto L11;
        L12:
            Preconditions.checkArgument(r0, "flags '%s' is out of range (0 <= flags <= 0xffff)", r9);
            this.server = (Inet4Address) MoreObjects.firstNonNull(r6, InetAddresses.access$000());
            this.client = (Inet4Address) MoreObjects.firstNonNull(r7, InetAddresses.access$000());
            this.port = r8;
            this.flags = r9;
            return;
        L11:
            r0 = false;
        L6:
            r3 = false;
            goto L7
        }

        public Inet4Address getServer() {
            return this.server;
        }

        public Inet4Address getClient() {
            return this.client;
        }

        public int getPort() {
            return this.port;
        }

        public int getFlags() {
            return this.flags;
        }
    }

    static /* synthetic */ Inet4Address access$000() {
        return ANY4;
    }

    static {
        IPV4_DELIMITER_MATCHER = CharMatcher.is(IPV4_DELIMITER);
        IPV6_DELIMITER_MATCHER = CharMatcher.is(':');
        LOOPBACK4 = (Inet4Address) forString(ActivateService.HOST);
        ANY4 = (Inet4Address) forString("0.0.0.0");
    }

    private InetAddresses() {
    }

    private static Inet4Address getInet4Address(byte[] r3) {
        if (r3.length != 4) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Byte array has invalid length for an IPv4 address: %s != 4.", r3.length);
        return (Inet4Address) bytesToInetAddress(r3);
    L5:
        r0 = false;
        goto L6
    }

    public static InetAddress forString(String r2) {
        byte[] r0 = ipStringToBytes(r2);
        if (r0 == null) goto L7;
        return bytesToInetAddress(r0);
    L7:
        throw formatIllegalArgumentException("'%s' is not an IP string literal.", new Object[]{r2});
    }

    public static boolean isInetAddress(String r0) {
        if (ipStringToBytes(r0) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @CheckForNull
    private static byte[] ipStringToBytes(String r9) {
        int r1 = 0;
        boolean r2 = false;
        boolean r3 = false;
    L4:
        if (r1 >= r9.length()) goto L20;
        char r4 = r9.charAt(r1);
        if (r4 != '.') goto L9;
        r2 = true;
    L19:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r4 != ':') goto L14;
        if (r2 == true) goto L11;
        r3 = true;
        goto L19
    L11:
        return null;
    L14:
        if (r4 == '%') goto L21;
        if (Character.digit(r4, 16) != (-1)) goto L19;
        return null;
    L21:
        if (r3 == false) goto L30;
        if (r2 == false) goto L26;
        r9 = convertDottedQuadToHex(r9);
        if (r9 != null) goto L26;
        return null;
    L26:
        if (r1 == (-1)) goto L29;
        r9 = r9.substring(0, r1);
    L29:
        return textToNumericFormatV6(r9);
    L30:
        if (r2 == false) goto L35;
        if (r1 == (-1)) goto L34;
        return null;
    L34:
        return textToNumericFormatV4(r9);
    L35:
        return null;
    L20:
        r1 = -1;
        goto L21
    }

    @CheckForNull
    private static byte[] textToNumericFormatV4(String r7) {
        if ((IPV4_DELIMITER_MATCHER.countIn(r7) + 1) == 4) goto L5;
        return null;
    L5:
        byte[] r0 = new byte[4];
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r3 >= 4) goto L13;
        int r5 = r7.indexOf(46, r4);
        if (r5 != (-1)) goto L14;
        r5 = r7.length();
    L14:
        r0[r3] = parseOctet(r7, r4, r5);     // Catch: NumberFormatException -> L12
        r4 = r5 + 1;
        r3 = r3 + 1;
    L12:
        return null;
    L13:
        return r0;
    }

    @CheckForNull
    private static byte[] textToNumericFormatV6(String r11) {
        int r0 = IPV6_DELIMITER_MATCHER.countIn(r11);
        if (r0 >= 2) goto L5;
    L59:
        return null;
    L5:
        if (r0 > 8) goto L59;
        int r4 = 1;
        int r1 = r0 + 1;
        int r5 = 8 - r1;
        int r7 = 0;
        boolean r8 = false;
    L9:
        if (r7 >= (r11.length() - 1)) goto L25;
        if (r11.charAt(r7) != ':') goto L23;
        if (r11.charAt(r7 + 1) != ':') goto L23;
        if (r8 == true) goto L15;
        r5 = r5 + 1;
        if (r7 != 0) goto L20;
        r5 = r5 + 1;
    L20:
        if (r7 != (r11.length() - 2)) goto L22;
        r5 = r5 + 1;
    L22:
        r8 = true;
        goto L23
    L15:
        return null;
    L23:
        r7 = r7 + 1;
        goto L9
    L25:
        if (r11.charAt(0) != ':') goto L30;
        if (r11.charAt(1) == ':') goto L30;
        return null;
    L30:
        if (r11.charAt(r11.length() - 1) == ':') goto L32;
    L34:
        if (r8 == false) goto L37;
        if (r5 > 0) goto L37;
        return null;
    L37:
        if (r8 == true) goto L40;
        if (r1 == 8) goto L40;
        return null;
    L40:
        ByteBuffer r2 = ByteBuffer.allocate(16);
        if (r11.charAt(0) == ':') goto L45;
        r4 = 0;
    L45:
        if (r4 >= r11.length()) goto L58;
        int r3 = r11.indexOf(58, r4);     // Catch: NumberFormatException -> L60
        if (r3 != (-1)) goto L51;
        r3 = r11.length();     // Catch: NumberFormatException -> L60
    L51:
        if (r11.charAt(r4) != ':') goto L55;
        int r6 = 0;
    L53:
        if (r6 >= r5) goto L56;
        r2.putShort(0);     // Catch: NumberFormatException -> L60
        r6 = r6 + 1;     // Catch: NumberFormatException -> L60
    L56:
        r4 = r3 + 1;
        goto L45
    L55:
        r2.putShort(parseHextet(r11, r4, r3));     // Catch: NumberFormatException -> L60
        goto L56
    L58:
        return r2.array();
    L32:
        if (r11.charAt(r11.length() - 2) == ':') goto L34;
        return null;
    }

    @CheckForNull
    private static String convertDottedQuadToHex(String r5) {
        int r0 = r5.lastIndexOf(58) + 1;
        String r3 = r5.substring(0, r0);
        byte[] r6 = textToNumericFormatV4(r5.substring(r0));
        if (r6 != null) goto L6;
        return null;
    L6:
        String r1 = Integer.toHexString(((r6[0] & 255) << 8) | (r6[1] & 255));
        int r2 = (r6[2] & 255) << 8;
        String r7 = Integer.toHexString((r6[3] & 255) | r2);
        return new StringBuilder(((String.valueOf(r3).length() + 1) + String.valueOf(r1).length()) + String.valueOf(r7).length()).append(r3).append(r1).append(":").append(r7).toString();
    }

    private static byte parseOctet(String r3, int r4, int r5) {
        int r0 = r5 - r4;
        if (r0 <= 0) goto L27;
        if (r0 > 3) goto L27;
        if (r0 > 1) goto L9;
    L13:
        int r1 = 0;
    L14:
        if (r4 >= r5) goto L21;
        int r2 = r1 * 10;
        int r6 = Character.digit(r3.charAt(r4), 10);
        if (r6 < 0) goto L19;
        r1 = r2 + r6;
        r4 = r4 + 1;
        goto L14
    L19:
        throw new NumberFormatException();
    L21:
        if (r1 > 255) goto L25;
        return (byte) r1;
    L25:
        throw new NumberFormatException();
    L9:
        if (r3.charAt(r4) != '0') goto L13;
        throw new NumberFormatException();
    L27:
        throw new NumberFormatException();
    }

    private static short parseHextet(String r3, int r4, int r5) {
        int r0 = r5 - r4;
        if (r0 <= 0) goto L12;
        if (r0 > 4) goto L12;
        int r1 = 0;
    L7:
        if (r4 >= r5) goto L10;
        r1 = (r1 << 4) | Character.digit(r3.charAt(r4), 16);
        r4 = r4 + 1;
        goto L7
    L10:
        return (short) r1;
    L12:
        throw new NumberFormatException();
    }

    private static InetAddress bytesToInetAddress(byte[] r1) {
        return InetAddress.getByAddress(r1);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static String toAddrString(InetAddress r6) {
        Preconditions.checkNotNull(r6);
        if ((r6 instanceof Inet4Address) == true) goto L5;
        Preconditions.checkArgument(r6 instanceof Inet6Address);
        byte[] r7 = r6.getAddress();
        int[] r1 = new int[8];
        int r3 = 0;
    L7:
        if (r3 >= 8) goto L9;
        int r4 = r3 * 2;
        r1[r3] = Ints.fromBytes((byte) 0, (byte) 0, r7[r4], r7[r4 + 1]);
        r3 = r3 + 1;
        goto L7
    L9:
        compressLongestRunOfZeroes(r1);
        return hextetsToIPv6String(r1);
    L5:
        return r6.getHostAddress();
    }

    private static void compressLongestRunOfZeroes(int[] r6) {
        int r1 = 0;
        int r2 = -1;
        int r3 = -1;
        int r4 = -1;
    L4:
        if (r1 >= (r6.length + 1)) goto L18;
        if (r1 < r6.length) goto L8;
    L11:
        if (r4 < 0) goto L16;
        int r5 = r1 - r4;
        if (r5 <= r2) goto L15;
        r3 = r4;
        r2 = r5;
    L15:
        r4 = -1;
    L16:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r6[r1] != 0) goto L11;
        if (r4 >= 0) goto L16;
        r4 = r1;
        goto L16
    L18:
        if (r2 < 2) goto L26;
        Arrays.fill(r6, r3, r2 + r3, -1);
        return;
    }

    private static String hextetsToIPv6String(int[] r5) {
        StringBuilder r0 = new StringBuilder(39);
        int r2 = 0;
        boolean r3 = false;
    L4:
        if (r2 >= r5.length) goto L18;
        if (r5[r2] < 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L13;
        if (r3 == false) goto L12;
        r0.append(':');
    L12:
        r0.append(Integer.toHexString(r5[r2]));
    L16:
        r2 = r2 + 1;
        r3 = r4;
        goto L4
    L13:
        if (r2 == 0) goto L15;
        if (r3 == false) goto L16;
    L15:
        r0.append("::");
        goto L16
    L8:
        r4 = false;
        goto L9
    L18:
        return r0.toString();
    }

    public static String toUriString(InetAddress r2) {
        if ((r2 instanceof Inet6Address) == false) goto L7;
        String r3 = toAddrString(r2);
        return new StringBuilder(String.valueOf(r3).length() + 2).append("[").append(r3).append("]").toString();
    L7:
        return toAddrString(r2);
    }

    public static InetAddress forUriString(String r2) {
        InetAddress r0 = forUriStringNoThrow(r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw formatIllegalArgumentException("Not a valid URI IP literal: '%s'", new Object[]{r2});
    }

    @CheckForNull
    private static InetAddress forUriStringNoThrow(String r2) {
        Preconditions.checkNotNull(r2);
        if (r2.startsWith("[") == true) goto L5;
    L7:
        int r0 = 4;
    L8:
        byte[] r3 = ipStringToBytes(r2);
        if (r3 != null) goto L11;
        return null;
    L11:
        if (r3.length == r0) goto L14;
        return null;
    L14:
        return bytesToInetAddress(r3);
    L5:
        if (r2.endsWith("]") == false) goto L7;
        r2 = r2.substring(1, r2.length() - 1);
        r0 = 16;
        goto L8
    }

    public static boolean isUriInetAddress(String r0) {
        if (forUriStringNoThrow(r0) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isCompatIPv4Address(Inet6Address r3) {
        if (r3.isIPv4CompatibleAddress() == true) goto L5;
        return false;
    L5:
        byte[] r4 = r3.getAddress();
        if (r4[12] == 0) goto L8;
    L15:
        return true;
    L8:
        if (r4[13] != 0) goto L15;
        if (r4[14] != 0) goto L15;
        byte r5 = r4[15];
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L15;
    L14:
        return false;
    }

    public static Inet4Address getCompatIPv4Address(Inet6Address r3) {
        Preconditions.checkArgument(isCompatIPv4Address(r3), "Address '%s' is not IPv4-compatible.", toAddrString(r3));
        return getInet4Address(Arrays.copyOfRange(r3.getAddress(), 12, 16));
    }

    public static boolean is6to4Address(Inet6Address r3) {
        byte[] r4 = r3.getAddress();
        if (r4[0] == 32) goto L5;
        return false;
    L5:
        if (r4[1] == 2) goto L7;
        return false;
    L7:
        return true;
    }

    public static Inet4Address get6to4IPv4Address(Inet6Address r3) {
        Preconditions.checkArgument(is6to4Address(r3), "Address '%s' is not a 6to4 address.", toAddrString(r3));
        return getInet4Address(Arrays.copyOfRange(r3.getAddress(), 2, 6));
    }

    public static boolean isTeredoAddress(Inet6Address r3) {
        byte[] r4 = r3.getAddress();
        if (r4[0] == 32) goto L5;
        return false;
    L5:
        if (r4[1] == 1) goto L7;
        return false;
    L7:
        if (r4[2] == 0) goto L9;
        return false;
    L9:
        if (r4[3] == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public static TeredoInfo getTeredoInfo(Inet6Address r5) {
        Preconditions.checkArgument(isTeredoAddress(r5), "Address '%s' is not a Teredo address.", toAddrString(r5));
        byte[] r6 = r5.getAddress();
        Inet4Address r0 = getInet4Address(Arrays.copyOfRange(r6, 4, 8));
        int r1 = ByteStreams.newDataInput(r6, 8).readShort() & 65535;
        int r2 = 65535 & (~ByteStreams.newDataInput(r6, 10).readShort());
        byte[] r7 = Arrays.copyOfRange(r6, 12, 16);
        int r3 = 0;
    L4:
        if (r3 >= r7.length) goto L7;
        r7[r3] = (byte) (~r7[r3]);
        r3 = r3 + 1;
        goto L4
    L7:
        return new TeredoInfo(r0, getInet4Address(r7), r2, r1);
    }

    public static boolean isIsatapAddress(Inet6Address r3) {
        if (isTeredoAddress(r3) == false) goto L5;
        return false;
    L5:
        byte[] r4 = r3.getAddress();
        if ((r4[8] | 3) == 3) goto L9;
        return false;
    L9:
        if (r4[9] == 0) goto L11;
        return false;
    L11:
        if (r4[10] == 94) goto L13;
        return false;
    L13:
        if (r4[11] != (-2)) goto L18;
        return true;
    L18:
        return false;
    }

    public static Inet4Address getIsatapIPv4Address(Inet6Address r3) {
        Preconditions.checkArgument(isIsatapAddress(r3), "Address '%s' is not an ISATAP address.", toAddrString(r3));
        return getInet4Address(Arrays.copyOfRange(r3.getAddress(), 12, 16));
    }

    public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address r1) {
        if (isCompatIPv4Address(r1) == false) goto L5;
    L10:
        return true;
    L5:
        if (is6to4Address(r1) == true) goto L10;
        if (isTeredoAddress(r1) == true) goto L10;
        return false;
    }

    public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address r2) {
        if (isCompatIPv4Address(r2) == false) goto L7;
        return getCompatIPv4Address(r2);
    L7:
        if (is6to4Address(r2) == false) goto L11;
        return get6to4IPv4Address(r2);
    L11:
        if (isTeredoAddress(r2) == false) goto L15;
        return getTeredoInfo(r2).getClient();
    L15:
        throw formatIllegalArgumentException("'%s' has no embedded IPv4 address.", new Object[]{toAddrString(r2)});
    }

    public static boolean isMappedIPv4Address(String r4) {
        byte[] r5 = ipStringToBytes(r4);
        if (r5 != null) goto L5;
    L21:
        return false;
    L5:
        if (r5.length != 16) goto L21;
        int r1 = 0;
    L7:
        int r2 = 10;
        if (r1 >= 10) goto L14;
        if (r5[r1] != 0) goto L11;
        r1 = r1 + 1;
        goto L7
    L11:
        return false;
    L14:
        if (r2 >= 12) goto L19;
        if (r5[r2] != (-1)) goto L17;
        r2 = r2 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    }

    public static Inet4Address getCoercedIPv4Address(InetAddress r6) {
        if ((r6 instanceof Inet4Address) == true) goto L5;
        byte[] r0 = r6.getAddress();
        int r2 = 0;
    L8:
        if (r2 >= 15) goto L13;
        if (r0[r2] != 0) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        boolean r3 = false;
    L14:
        if (r3 == true) goto L16;
    L19:
        if (r3 == true) goto L21;
    L24:
        Inet6Address r7 = (Inet6Address) r6;
        if (hasEmbeddedIPv4ClientAddress(r7) == false) goto L27;
        long r1 = getEmbeddedIPv4ClientAddress(r7).hashCode();
    L28:
        int r8 = Hashing.murmur3_32_fixed().hashLong(r1).asInt() | SlardarConfigConsts.MONITOR_RUN_MODE_MASK;
        if (r8 != (-1)) goto L32;
        r8 = -2;
    L32:
        return getInet4Address(Ints.toByteArray(r8));
    L27:
        r1 = ByteBuffer.wrap(r7.getAddress(), 0, 8).getLong();
        goto L28
    L21:
        if (r0[15] != 0) goto L24;
        return ANY4;
    L16:
        if (r0[15] != 1) goto L19;
        return LOOPBACK4;
    L13:
        r3 = true;
        goto L14
    L5:
        return (Inet4Address) r6;
    }

    public static int coerceToInteger(InetAddress r0) {
        return ByteStreams.newDataInput(getCoercedIPv4Address(r0).getAddress()).readInt();
    }

    public static BigInteger toBigInteger(InetAddress r2) {
        return new BigInteger(1, r2.getAddress());
    }

    public static Inet4Address fromInteger(int r0) {
        return getInet4Address(Ints.toByteArray(r0));
    }

    public static Inet4Address fromIPv4BigInteger(BigInteger r1) {
        return (Inet4Address) fromBigInteger(r1, false);
    }

    public static Inet6Address fromIPv6BigInteger(BigInteger r1) {
        return (Inet6Address) fromBigInteger(r1, true);
    }

    private static InetAddress fromBigInteger(BigInteger r9, boolean r10) {
        if (r9.signum() < 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "BigInteger must be greater than or equal to 0");
        if (r10 == false) goto L9;
        int r11 = 16;
    L10:
        byte[] r1 = r9.toByteArray();
        byte[] r3 = new byte[r11];
        int r4 = Math.max(0, r1.length - r11);
        int r5 = r1.length - r4;
        int r6 = r11 - r5;
        int r7 = 0;
    L11:
        if (r7 >= r4) goto L17;
        if (r1[r7] != 0) goto L16;
        r7 = r7 + 1;
        goto L11
    L16:
        throw formatIllegalArgumentException("BigInteger cannot be converted to InetAddress because it has more than %d bytes: %s", new Object[]{Integer.valueOf(r11), r9});
    L17:
        System.arraycopy(r1, r4, r3, r6, r5);
        return InetAddress.getByAddress(r3);
    L20:
        e = move-exception;
        throw new AssertionError(e);
    L9:
        r11 = 4;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public static InetAddress fromLittleEndianByteArray(byte[] r3) throws UnknownHostException {
        byte[] r0 = new byte[r3.length];
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L7;
        r0[r1] = r3[(r3.length - r1) - 1];
        r1 = r1 + 1;
        goto L4
    L7:
        return InetAddress.getByAddress(r0);
    }

    public static InetAddress decrement(InetAddress r5) {
        byte[] r0 = r5.getAddress();
        int r1 = r0.length - 1;
    L3:
        if (r1 < 0) goto L7;
        if (r0[r1] != 0) goto L7;
        r0[r1] = -1;
        r1 = r1 - 1;
    L7:
        if (r1 < 0) goto L9;
        boolean r3 = true;
    L10:
        Preconditions.checkArgument(r3, "Decrementing %s would wrap.", r5);
        r0[r1] = (byte) (r0[r1] - 1);
        return bytesToInetAddress(r0);
    L9:
        r3 = false;
        goto L10
    }

    public static InetAddress increment(InetAddress r6) {
        byte[] r0 = r6.getAddress();
        int r1 = r0.length - 1;
    L3:
        boolean r3 = false;
        if (r1 < 0) goto L8;
        if (r0[r1] != (-1)) goto L8;
        r0[r1] = 0;
        r1 = r1 - 1;
    L8:
        if (r1 < 0) goto L10;
        r3 = true;
    L10:
        Preconditions.checkArgument(r3, "Incrementing %s would wrap.", r6);
        r0[r1] = (byte) (r0[r1] + 1);
        return bytesToInetAddress(r0);
    }

    public static boolean isMaximum(InetAddress r5) {
        byte[] r6 = r5.getAddress();
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (r6[r2] != (-1)) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private static IllegalArgumentException formatIllegalArgumentException(String r2, Object... r3) {
        return new IllegalArgumentException(String.format(Locale.ROOT, r2, r3));
    }
}
