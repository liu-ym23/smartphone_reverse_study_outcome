package javax.obex;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.ttnet.org.chromium.net.NetError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes5.dex */
public final class ObexHelper {
    public static final int A2DP_SCO_OBEX_MAX_CLIENT_PACKET_SIZE = 8192;
    public static final int BASE_PACKET_LENGTH = 3;
    public static final String LOG_TAG = "BluetoothObex";
    public static final int LOWER_LIMIT_MAX_PACKET_SIZE = 255;
    public static final int MAX_CLIENT_PACKET_SIZE = 64512;
    public static final int MAX_PACKET_SIZE_INT = 65534;
    public static final int OBEX_AUTH_REALM_CHARSET_ASCII = 0;
    public static final int OBEX_AUTH_REALM_CHARSET_ISO_8859_1 = 1;
    public static final int OBEX_AUTH_REALM_CHARSET_ISO_8859_2 = 2;
    public static final int OBEX_AUTH_REALM_CHARSET_ISO_8859_3 = 3;
    public static final int OBEX_AUTH_REALM_CHARSET_ISO_8859_4 = 4;
    public static final int OBEX_AUTH_REALM_CHARSET_ISO_8859_5 = 5;
    public static final int OBEX_AUTH_REALM_CHARSET_ISO_8859_6 = 6;
    public static final int OBEX_AUTH_REALM_CHARSET_ISO_8859_7 = 7;
    public static final int OBEX_AUTH_REALM_CHARSET_ISO_8859_8 = 8;
    public static final int OBEX_AUTH_REALM_CHARSET_ISO_8859_9 = 9;
    public static final int OBEX_AUTH_REALM_CHARSET_UNICODE = 255;
    public static final int OBEX_BYTE_SEQ_HEADER_LEN = 3;
    public static final int OBEX_OPCODE_ABORT = 255;
    public static final int OBEX_OPCODE_CONNECT = 128;
    public static final int OBEX_OPCODE_DISCONNECT = 129;
    public static final int OBEX_OPCODE_FINAL_BIT_MASK = 128;
    public static final int OBEX_OPCODE_GET = 3;
    public static final int OBEX_OPCODE_GET_FINAL = 131;
    public static final int OBEX_OPCODE_PUT = 2;
    public static final int OBEX_OPCODE_PUT_FINAL = 130;
    public static final int OBEX_OPCODE_RESERVED = 4;
    public static final int OBEX_OPCODE_RESERVED_FINAL = 132;
    public static final int OBEX_OPCODE_SETPATH = 133;
    public static final byte OBEX_SRMP_WAIT = 1;
    public static final byte OBEX_SRM_DISABLE = 0;
    public static final byte OBEX_SRM_ENABLE = 1;
    public static final byte OBEX_SRM_SUPPORT = 2;
    private static final String TAG = "ObexHelper";
    public static final boolean VDBG = false;

    public static byte[] convertToByteArray(long r5) {
        return new byte[]{(byte) ((r5 >> 24) & 255), (byte) ((r5 >> 16) & 255), (byte) ((r5 >> 8) & 255), (byte) (r5 & 255)};
    }

    static {
        VDBG = Log.isLoggable(LOG_TAG, 2);
    }

    private ObexHelper() {
    }

    public static byte[] updateHeaderSet(HeaderSet r14, byte[] r15) throws IOException {
        byte[] r2 = null;
        int r3 = 0;
    L90:
    L80:
        e = move-exception;
        throw new IOException("Header was not formatted properly", e);
    L4:
        if (r3 >= r15.length) goto L79;
        int r4 = r15[r3] & 255;     // Catch: IOException -> L80
        if (VDBG == false) goto L9;
        Log.v(TAG, "updateHeaderSet headerID = " + r4);     // Catch: IOException -> L80
    L9:
        int r5 = r4 & 192;     // Catch: IOException -> L80
        if (r5 == 0) goto L33;
        if (r5 == 64) goto L33;
        if (r5 != 128) goto L16;
        int r6 = r3 + 1;
        r14.setHeader(r4, Byte.valueOf(r15[r6]));     // Catch: Exception -> L83 IOException -> L80
    L32:
        r3 = r6 + 1;
        goto L90
    L16:
        if (r5 != 192) goto L90;
        int r7 = r3 + 1;     // Catch: IOException -> L80
        byte[] r8 = new byte[4];     // Catch: IOException -> L80
        System.arraycopy(r15, r7, r8, 0, 4);     // Catch: IOException -> L80
        if (r4 != 196) goto L22;
        Calendar r9 = Calendar.getInstance();     // Catch: Exception -> L27 IOException -> L80
        r9.setTime(new Date(convertToLong(r8) * 1000));     // Catch: Exception -> L27 IOException -> L80
        r14.setHeader(196, r9);     // Catch: Exception -> L27 IOException -> L80
    L26:
        r3 = r7 + 4;
        goto L90
    L22:
        if (r4 == 203) goto L88;
        r14.setHeader(r4, Long.valueOf(convertToLong(r8)));     // Catch: Exception -> L27 IOException -> L80
        goto L26
    L88:
        r14.mConnectionID = new byte[4];     // Catch: Exception -> L27 IOException -> L80
        System.arraycopy(r8, 0, r14.mConnectionID, 0, 4);     // Catch: Exception -> L27 IOException -> L80
    L27:
        e = move-exception;
        throw new IOException("Header was not formatted properly", e);     // Catch: IOException -> L80
    L33:
        int r10 = r3 + 1;
        int r11 = ((r15[r10] & 255) << 8) + (r15[r10 + 1] & 255);     // Catch: IOException -> L80
        r3 = r10 + 2;     // Catch: IOException -> L80
        if (r11 < 3) goto L36;
        int r12 = r11 - 3;     // Catch: IOException -> L80
        byte[] r13 = new byte[r12];     // Catch: IOException -> L80
        System.arraycopy(r15, r3, r13, 0, r12);     // Catch: IOException -> L80
        if (r12 == 0) goto L44;
        if (r12 > 0) goto L41;
    L43:
        boolean r16 = true;
    L46:
        if (r4 != 66) goto L48;
        if (r16 == false) goto L91;
        r14.setHeader(r4, new String(r13, 0, r12 - 1, "ISO8859_1"));     // Catch: UnsupportedEncodingException -> L77 IOException -> L80
    L76:
        r3 = r3 + r12;
        goto L90
    L91:
        r14.setHeader(r4, new String(r13, 0, r12, "ISO8859_1"));     // Catch: UnsupportedEncodingException -> L77 IOException -> L80
    L77:
        e = move-exception;
        throw e;     // Catch: IOException -> L80
    L48:
        if (r4 != 68) goto L50;
        String r17 = new String(r13, "ISO8859_1");     // Catch: UnsupportedEncodingException -> L71 IOException -> L80
        Calendar r18 = Calendar.getInstance();     // Catch: UnsupportedEncodingException -> L71 IOException -> L80
        if (r17.length() == 16) goto L67;
    L69:
        r18.set(1, Integer.parseInt(r17.substring(0, 4)));     // Catch: UnsupportedEncodingException -> L71 IOException -> L80
        r18.set(2, Integer.parseInt(r17.substring(4, 6)));     // Catch: UnsupportedEncodingException -> L71 IOException -> L80
        r18.set(5, Integer.parseInt(r17.substring(6, 8)));     // Catch: UnsupportedEncodingException -> L71 IOException -> L80
        r18.set(11, Integer.parseInt(r17.substring(9, 11)));     // Catch: UnsupportedEncodingException -> L71 IOException -> L80
        r18.set(12, Integer.parseInt(r17.substring(11, 13)));     // Catch: UnsupportedEncodingException -> L71 IOException -> L80
        r18.set(13, Integer.parseInt(r17.substring(13, 15)));     // Catch: UnsupportedEncodingException -> L71 IOException -> L80
        r14.setHeader(68, r18);     // Catch: UnsupportedEncodingException -> L71 IOException -> L80
        goto L76
    L67:
        if (r17.charAt(15) != 'Z') goto L69;
        r18.setTimeZone(TimeZone.getTimeZone("UTC"));     // Catch: UnsupportedEncodingException -> L71 IOException -> L80
        goto L69
    L71:
        e = move-exception;
        throw e;     // Catch: IOException -> L80
    L50:
        if (r4 != 72) goto L52;
    L62:
        r2 = new byte[r12 + 1];     // Catch: IOException -> L80
        r2[0] = (byte) r4;     // Catch: IOException -> L80
        System.arraycopy(r15, r3, r2, 1, r12);     // Catch: IOException -> L80
        goto L76
    L52:
        if (r4 == 73) goto L62;
        if (r4 != 77) goto L56;
        r14.mAuthChall = new byte[r12];     // Catch: IOException -> L80
        System.arraycopy(r15, r3, r14.mAuthChall, 0, r12);     // Catch: IOException -> L80
        goto L76
    L56:
        if (r4 == 78) goto L60;
        if (r5 != 0) goto L59;
        r14.setHeader(r4, convertToUnicode(r13, true));     // Catch: IOException -> L80
        goto L76
    L59:
        r14.setHeader(r4, r13);     // Catch: IOException -> L80
        goto L76
    L60:
        r14.mAuthResp = new byte[r12];     // Catch: IOException -> L80
        System.arraycopy(r15, r3, r14.mAuthResp, 0, r12);     // Catch: IOException -> L80
        goto L76
    L41:
        if (r13[r12 - 1] == 0) goto L43;
    L44:
        r16 = false;
        goto L46
    L36:
        Log.e(TAG, "Remote sent an OBEX packet with incorrect header length : " + r11);     // Catch: IOException -> L80
        goto L90
    L79:
        return r2;
    }

    public static byte[] createHeader(HeaderSet r16, boolean r17) {
        byte[] r3 = new byte[2];
        ByteArrayOutputStream r4 = new ByteArrayOutputStream();
        boolean r5 = VDBG;     // Catch: IOException -> L203 Throwable -> L198
        if (r5 == false) goto L8;
        Log.v(TAG, "createHeader = " + r16);     // Catch: IOException -> L203 Throwable -> L198
    L8:
        if (r16.mConnectionID != null) goto L10;
    L14:
        Long r8 = (Long) r16.getHeader(192);     // Catch: IOException -> L203 Throwable -> L198
        if (r8 == null) goto L21;
        if (r5 == false) goto L18;
        Log.v(TAG, " Add Header = 192");     // Catch: IOException -> L203 Throwable -> L198
    L18:
        r4.write(-64);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(convertToByteArray(r8.longValue()));     // Catch: IOException -> L203 Throwable -> L198
        if (r17 == false) goto L21;
        r16.setHeader(192, null);     // Catch: IOException -> L203 Throwable -> L198
    L21:
        String r9 = (String) r16.getHeader(1);     // Catch: IOException -> L203 Throwable -> L198
        if (r9 == null) goto L29;
        if (r5 == false) goto L25;
        Log.v(TAG, " Add Header = 1");     // Catch: IOException -> L203 Throwable -> L198
    L25:
        r4.write(1);     // Catch: IOException -> L203 Throwable -> L198
        byte[] r10 = convertToUnicodeByteArray(r9);     // Catch: IOException -> L203 Throwable -> L198
        int r12 = r10.length + 3;     // Catch: IOException -> L203 Throwable -> L198
        r3[0] = (byte) ((r12 >> 8) & 255);     // Catch: IOException -> L203 Throwable -> L198
        r3[1] = (byte) (r12 & 255);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r3);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r10);     // Catch: IOException -> L203 Throwable -> L198
        if (r17 == false) goto L31;
        r16.setHeader(1, null);     // Catch: IOException -> L203 Throwable -> L198
    L31:
        String r13 = (String) r16.getHeader(66);     // Catch: IOException -> L203 Throwable -> L198
        if (r13 == null) goto L44;
        if (r5 == false) goto L36;
        Log.v(TAG, " Add Header = 66");     // Catch: IOException -> L203 Throwable -> L198
    L36:
        r4.write(66);     // Catch: IOException -> L203 Throwable -> L198
        byte[] r14 = r13.getBytes("ISO8859_1");     // Catch: UnsupportedEncodingException -> L41 IOException -> L203 Throwable -> L198
        int r15 = r14.length + 4;     // Catch: IOException -> L203 Throwable -> L198
        r3[0] = (byte) ((r15 >> 8) & 255);     // Catch: IOException -> L203 Throwable -> L198
        r3[1] = (byte) (r15 & 255);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r3);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r14);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(0);     // Catch: IOException -> L203 Throwable -> L198
        if (r17 == false) goto L44;
        r16.setHeader(66, null);     // Catch: IOException -> L203 Throwable -> L198
        goto L44
    L41:
        e = move-exception;
        throw e;     // Catch: IOException -> L203 Throwable -> L198
    L44:
        Long r18 = (Long) r16.getHeader(195);     // Catch: IOException -> L203 Throwable -> L198
        if (r18 == null) goto L51;
        if (r5 == false) goto L48;
        Log.v(TAG, " Add Header = 195");     // Catch: IOException -> L203 Throwable -> L198
    L48:
        r4.write(-61);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(convertToByteArray(r18.longValue()));     // Catch: IOException -> L203 Throwable -> L198
        if (r17 == false) goto L51;
        r16.setHeader(195, null);     // Catch: IOException -> L203 Throwable -> L198
    L51:
        Calendar r19 = (Calendar) r16.getHeader(68);     // Catch: IOException -> L203 Throwable -> L198
        if (r19 == null) goto L84;
        if (r5 == false) goto L55;
        Log.v(TAG, " Add dateHeader = 68");     // Catch: IOException -> L203 Throwable -> L198
    L55:
        StringBuffer r6 = new StringBuffer();     // Catch: IOException -> L203 Throwable -> L198
        int r110 = r19.get(1);     // Catch: IOException -> L203 Throwable -> L198
        int r7 = r110;
    L58:
        if (r7 >= 1000) goto L60;
        r6.append("0");     // Catch: IOException -> L203 Throwable -> L198
        r7 = r7 * 10;     // Catch: IOException -> L203 Throwable -> L198
        goto L58
    L60:
        r6.append(r110);     // Catch: IOException -> L203 Throwable -> L198
        int r2 = r19.get(2);     // Catch: IOException -> L203 Throwable -> L198
        if (r2 >= 10) goto L63;
        r6.append("0");     // Catch: IOException -> L203 Throwable -> L198
    L63:
        r6.append(r2);     // Catch: IOException -> L203 Throwable -> L198
        int r11 = r19.get(5);     // Catch: IOException -> L203 Throwable -> L198
        if (r11 >= 10) goto L66;
        r6.append("0");     // Catch: IOException -> L203 Throwable -> L198
    L66:
        r6.append(r11);     // Catch: IOException -> L203 Throwable -> L198
        r6.append(ExifInterface.GPS_DIRECTION_TRUE);     // Catch: IOException -> L203 Throwable -> L198
        int r20 = r19.get(11);     // Catch: IOException -> L203 Throwable -> L198
        if (r20 >= 10) goto L69;
        r6.append("0");     // Catch: IOException -> L203 Throwable -> L198
    L69:
        r6.append(r20);     // Catch: IOException -> L203 Throwable -> L198
        int r21 = r19.get(12);     // Catch: IOException -> L203 Throwable -> L198
        if (r21 >= 10) goto L72;
        r6.append("0");     // Catch: IOException -> L203 Throwable -> L198
    L72:
        r6.append(r21);     // Catch: IOException -> L203 Throwable -> L198
        int r22 = r19.get(13);     // Catch: IOException -> L203 Throwable -> L198
        if (r22 >= 10) goto L75;
        r6.append("0");     // Catch: IOException -> L203 Throwable -> L198
    L75:
        r6.append(r22);     // Catch: IOException -> L203 Throwable -> L198
        if (r19.getTimeZone().getID().equals("UTC") == false) goto L212;
        r6.append("Z");     // Catch: IOException -> L203 Throwable -> L198
    L212:
        byte[] r23 = r6.toString().getBytes("ISO8859_1");     // Catch: UnsupportedEncodingException -> L82 IOException -> L203 Throwable -> L198
        int r24 = r23.length + 3;     // Catch: IOException -> L203 Throwable -> L198
        r3[0] = (byte) ((r24 >> 8) & 255);     // Catch: IOException -> L203 Throwable -> L198
        r3[1] = (byte) (r24 & 255);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(68);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r3);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r23);     // Catch: IOException -> L203 Throwable -> L198
        if (r17 == false) goto L84;
        r16.setHeader(68, null);     // Catch: IOException -> L203 Throwable -> L198
        goto L84
    L82:
        e = move-exception;
        throw e;     // Catch: IOException -> L203 Throwable -> L198
    L84:
        Calendar r25 = (Calendar) r16.getHeader(196);     // Catch: IOException -> L203 Throwable -> L198
        if (r25 != null) goto L87;
    L92:
        String r26 = (String) r16.getHeader(5);     // Catch: IOException -> L203 Throwable -> L198
        if (r26 == null) goto L97;
        r4.write(5);     // Catch: IOException -> L203 Throwable -> L198
        byte[] r27 = convertToUnicodeByteArray(r26);     // Catch: IOException -> L203 Throwable -> L198
        int r28 = r27.length + 3;     // Catch: IOException -> L203 Throwable -> L198
        r3[0] = (byte) ((r28 >> 8) & 255);     // Catch: IOException -> L203 Throwable -> L198
        r3[1] = (byte) (r28 & 255);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r3);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r27);     // Catch: IOException -> L203 Throwable -> L198
        if (r17 == false) goto L97;
        r16.setHeader(5, null);     // Catch: IOException -> L203 Throwable -> L198
    L97:
        byte[] r29 = (byte[]) r16.getHeader(70);     // Catch: IOException -> L203 Throwable -> L198
        if (r29 != null) goto L100;
    L105:
        byte[] r30 = (byte[]) r16.getHeader(71);     // Catch: IOException -> L203 Throwable -> L198
        if (r30 == null) goto L110;
        r4.write(71);     // Catch: IOException -> L203 Throwable -> L198
        int r31 = r30.length + 3;     // Catch: IOException -> L203 Throwable -> L198
        r3[0] = (byte) ((r31 >> 8) & 255);     // Catch: IOException -> L203 Throwable -> L198
        r3[1] = (byte) (r31 & 255);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r3);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r30);     // Catch: IOException -> L203 Throwable -> L198
        if (r17 == false) goto L110;
        r16.setHeader(71, null);     // Catch: IOException -> L203 Throwable -> L198
    L110:
        byte[] r32 = (byte[]) r16.getHeader(74);     // Catch: IOException -> L203 Throwable -> L198
        if (r32 != null) goto L113;
    L118:
        byte[] r33 = (byte[]) r16.getHeader(76);     // Catch: IOException -> L203 Throwable -> L198
        if (r33 != null) goto L121;
    L126:
        byte[] r34 = (byte[]) r16.getHeader(79);     // Catch: IOException -> L203 Throwable -> L198
        if (r34 == null) goto L131;
        r4.write(79);     // Catch: IOException -> L203 Throwable -> L198
        int r35 = r34.length + 3;     // Catch: IOException -> L203 Throwable -> L198
        r3[0] = (byte) ((r35 >> 8) & 255);     // Catch: IOException -> L203 Throwable -> L198
        r3[1] = (byte) (r35 & 255);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r3);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r34);     // Catch: IOException -> L203 Throwable -> L198
        if (r17 == false) goto L131;
        r16.setHeader(79, null);     // Catch: IOException -> L203 Throwable -> L198
    L131:
        int r36 = 0;
    L133:
        if (r36 >= 16) goto L164;
        int r37 = r36 + 48;     // Catch: IOException -> L203 Throwable -> L198
        String r38 = (String) r16.getHeader(r37);     // Catch: IOException -> L203 Throwable -> L198
        if (r38 == null) goto L141;
        r4.write(((byte) r36) + 48);     // Catch: IOException -> L203 Throwable -> L198
        byte[] r39 = convertToUnicodeByteArray(r38);     // Catch: IOException -> L203 Throwable -> L198
        int r40 = r39.length + 3;     // Catch: IOException -> L203 Throwable -> L198
        r3[0] = (byte) ((r40 >> 8) & 255);     // Catch: IOException -> L203 Throwable -> L198
        r3[1] = (byte) (r40 & 255);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r3);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r39);     // Catch: IOException -> L203 Throwable -> L198
        if (VDBG == false) goto L139;
        Log.v(TAG, " Add Unicode String value = " + r39);     // Catch: IOException -> L203 Throwable -> L198
    L139:
        if (r17 == false) goto L141;
        r16.setHeader(r37, null);     // Catch: IOException -> L203 Throwable -> L198
    L141:
        int r41 = r36 + 112;     // Catch: IOException -> L203 Throwable -> L198
        byte[] r42 = (byte[]) r16.getHeader(r41);     // Catch: IOException -> L203 Throwable -> L198
        if (r42 == null) goto L148;
        r4.write(((byte) r36) + 112);     // Catch: IOException -> L203 Throwable -> L198
        int r43 = r42.length + 3;     // Catch: IOException -> L203 Throwable -> L198
        r3[0] = (byte) ((r43 >> 8) & 255);     // Catch: IOException -> L203 Throwable -> L198
        r3[1] = (byte) (r43 & 255);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r3);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r42);     // Catch: IOException -> L203 Throwable -> L198
        if (VDBG == false) goto L146;
        Log.v(TAG, " Add ByteSeq value = " + r42);     // Catch: IOException -> L203 Throwable -> L198
    L146:
        if (r17 == false) goto L148;
        r16.setHeader(r41, null);     // Catch: IOException -> L203 Throwable -> L198
    L148:
        int r44 = r36 + 176;     // Catch: IOException -> L203 Throwable -> L198
        Byte r45 = (Byte) r16.getHeader(r44);     // Catch: IOException -> L203 Throwable -> L198
        if (r45 == null) goto L155;
        r4.write(((byte) r36) + 176);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r45.byteValue());     // Catch: IOException -> L203 Throwable -> L198
        if (VDBG == false) goto L153;
        Log.v(TAG, " Add ByteHeader value = " + r45.byteValue());     // Catch: IOException -> L203 Throwable -> L198
    L153:
        if (r17 == false) goto L155;
        r16.setHeader(r44, null);     // Catch: IOException -> L203 Throwable -> L198
    L155:
        int r46 = r36 + 240;     // Catch: IOException -> L203 Throwable -> L198
        Long r47 = (Long) r16.getHeader(r46);     // Catch: IOException -> L203 Throwable -> L198
        if (r47 == null) goto L162;
        r4.write(((byte) r36) + 240);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(convertToByteArray(r47.longValue()));     // Catch: IOException -> L203 Throwable -> L198
        if (VDBG == false) goto L160;
        Log.v(TAG, " Add Int value = " + r47.longValue());     // Catch: IOException -> L203 Throwable -> L198
    L160:
        if (r17 == false) goto L162;
        r16.setHeader(r46, null);     // Catch: IOException -> L203 Throwable -> L198
    L162:
        r36 = r36 + 1;     // Catch: IOException -> L203 Throwable -> L198
        goto L133
    L164:
        if (r16.mAuthChall == null) goto L171;
        r4.write(77);     // Catch: IOException -> L203 Throwable -> L198
        int r48 = r16.mAuthChall.length + 3;     // Catch: IOException -> L203 Throwable -> L198
        r3[0] = (byte) ((r48 >> 8) & 255);     // Catch: IOException -> L203 Throwable -> L198
        r3[1] = (byte) (r48 & 255);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r3);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r16.mAuthChall);     // Catch: IOException -> L203 Throwable -> L198
        if (VDBG == false) goto L168;
        Log.v(TAG, " Add mAuthChall value = " + r16.mAuthChall);     // Catch: IOException -> L203 Throwable -> L198
    L168:
        if (r17 == false) goto L171;
        r16.mAuthChall = null;     // Catch: IOException -> L203 Throwable -> L198
    L171:
        if (r16.mAuthResp == null) goto L177;
        r4.write(78);     // Catch: IOException -> L203 Throwable -> L198
        int r49 = r16.mAuthResp.length + 3;     // Catch: IOException -> L203 Throwable -> L198
        r3[0] = (byte) ((r49 >> 8) & 255);     // Catch: IOException -> L203 Throwable -> L198
        r3[1] = (byte) (r49 & 255);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r3);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r16.mAuthResp);     // Catch: IOException -> L203 Throwable -> L198
        if (VDBG == false) goto L175;
        Log.v(TAG, " Add mAuthChall value = " + r16.mAuthResp);     // Catch: IOException -> L203 Throwable -> L198
    L175:
        if (r17 == false) goto L177;
        r16.mAuthResp = null;     // Catch: IOException -> L203 Throwable -> L198
    L177:
        Byte r1 = (Byte) r16.getHeader(151);     // Catch: IOException -> L203 Throwable -> L198
        if (r1 == null) goto L187;
        boolean r50 = VDBG;     // Catch: IOException -> L203 Throwable -> L198
        if (r50 == false) goto L182;
        Log.v(TAG, " Add SRM Header = 151");     // Catch: IOException -> L203 Throwable -> L198
    L182:
        r4.write(NetError.ERR_NAME_NOT_RESOLVED);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r1.byteValue());     // Catch: IOException -> L203 Throwable -> L198
        if (r50 == false) goto L185;
        Log.v(TAG, " Add SRM value = " + r1.byteValue());     // Catch: IOException -> L203 Throwable -> L198
    L185:
        if (r17 == false) goto L187;
        r16.setHeader(151, null);     // Catch: IOException -> L203 Throwable -> L198
    L187:
        Byte r51 = (Byte) r16.getHeader(152);     // Catch: IOException -> L203 Throwable -> L198
        if (r51 == null) goto L195;
        if (VDBG == false) goto L192;
        Log.v(TAG, " Add Header = 152");     // Catch: IOException -> L203 Throwable -> L198
    L192:
        r4.write(NetError.ERR_CONNECTION_FAILED);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r51.byteValue());     // Catch: IOException -> L203 Throwable -> L198
        if (r17 == false) goto L195;
        r16.setHeader(152, null);     // Catch: IOException -> L203 Throwable -> L198
        goto L195
    L121:
        if (VDBG == false) goto L123;
        Log.v(TAG, " Add APP PARAM Header = 76");     // Catch: IOException -> L203 Throwable -> L198
    L123:
        r4.write(76);     // Catch: IOException -> L203 Throwable -> L198
        int r52 = r33.length + 3;     // Catch: IOException -> L203 Throwable -> L198
        r3[0] = (byte) ((r52 >> 8) & 255);     // Catch: IOException -> L203 Throwable -> L198
        r3[1] = (byte) (r52 & 255);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r3);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r33);     // Catch: IOException -> L203 Throwable -> L198
        if (r17 == false) goto L126;
        r16.setHeader(76, null);     // Catch: IOException -> L203 Throwable -> L198
        goto L126
    L113:
        if (VDBG == false) goto L115;
        Log.v(TAG, " Add Header = 74");     // Catch: IOException -> L203 Throwable -> L198
    L115:
        r4.write(74);     // Catch: IOException -> L203 Throwable -> L198
        int r53 = r32.length + 3;     // Catch: IOException -> L203 Throwable -> L198
        r3[0] = (byte) ((r53 >> 8) & 255);     // Catch: IOException -> L203 Throwable -> L198
        r3[1] = (byte) (r53 & 255);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r3);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r32);     // Catch: IOException -> L203 Throwable -> L198
        if (r17 == false) goto L118;
        r16.setHeader(74, null);     // Catch: IOException -> L203 Throwable -> L198
        goto L118
    L100:
        if (VDBG == false) goto L102;
        Log.v(TAG, " Add Header = 70");     // Catch: IOException -> L203 Throwable -> L198
    L102:
        r4.write(70);     // Catch: IOException -> L203 Throwable -> L198
        int r54 = r29.length + 3;     // Catch: IOException -> L203 Throwable -> L198
        r3[0] = (byte) ((r54 >> 8) & 255);     // Catch: IOException -> L203 Throwable -> L198
        r3[1] = (byte) (r54 & 255);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r3);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r29);     // Catch: IOException -> L203 Throwable -> L198
        if (r17 == false) goto L105;
        r16.setHeader(70, null);     // Catch: IOException -> L203 Throwable -> L198
        goto L105
    L87:
        if (VDBG == false) goto L89;
        Log.v(TAG, " Add dateHeader = 196");     // Catch: IOException -> L203 Throwable -> L198
    L89:
        r4.write(196);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(convertToByteArray(r25.getTime().getTime() / 1000));     // Catch: IOException -> L203 Throwable -> L198
        if (r17 == false) goto L92;
        r16.setHeader(196, null);     // Catch: IOException -> L203 Throwable -> L198
        goto L92
    L29:
        if (r16.getEmptyNameHeader() == false) goto L31;
        r4.write(1);     // Catch: IOException -> L203 Throwable -> L198
        r3[0] = 0;     // Catch: IOException -> L203 Throwable -> L198
        r3[1] = 3;     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r3);     // Catch: IOException -> L203 Throwable -> L198
        goto L31
    L10:
        if (r16.getHeader(70) != null) goto L14;
        if (r5 == false) goto L13;
        Log.v(TAG, " Add Header = 203");     // Catch: IOException -> L203 Throwable -> L198
    L13:
        r4.write(-53);     // Catch: IOException -> L203 Throwable -> L198
        r4.write(r16.mConnectionID);     // Catch: IOException -> L203 Throwable -> L198
    L198:
        th = move-exception;
        r4.toByteArray();
        r4.close();     // Catch: Exception -> L205
    L201:
        throw th;
    L195:
        byte[] r0 = r4.toByteArray();
        r4.close();     // Catch: Exception -> L204
    L202:
        return r0;
    }

    public static int findHeaderEnd(byte[] r7, int r8, int r9) {
        int r0 = 0;
        int r2 = r8;
        int r3 = -1;
    L3:
        if (r0 >= r9) goto L27;
        if (r2 >= r7.length) goto L27;
        int r4 = r7[r2];
        if (r4 >= 0) goto L9;
        r4 = r4 + 256;
    L9:
        int r5 = r4 & 192;
        if (r5 != 0) goto L12;
    L19:
        int r6 = r2 + 1;
        int r10 = r7[r6];
        if (r10 >= 0) goto L22;
        r10 = r10 + 256;
    L22:
        int r11 = r10 << 8;
        int r12 = r6 + 1;
        int r13 = r7[r12];
        if (r13 >= 0) goto L25;
        r13 = r13 + 256;
    L25:
        int r14 = (r11 + r13) - 3;
        r2 = (r12 + 1) + r14;
        int r15 = (r14 + 3) + r0;
    L26:
        int r16 = r15;
        r3 = r0;
        r0 = r16;
        goto L3
    L12:
        if (r5 == 64) goto L19;
        if (r5 == 128) goto L18;
        if (r5 == 192) goto L17;
        r15 = r0;
        goto L26
    L17:
        r2 = r2 + 5;
        r15 = r0 + 5;
        goto L26
    L18:
        r2 = (r2 + 1) + 1;
        r15 = r0 + 2;
    L27:
        if (r3 != 0) goto L33;
        if (r0 < r9) goto L30;
        return -1;
    L30:
        return r7.length;
    L33:
        return r3 + r8;
    }

    public static long convertToLong(byte[] r11) {
        int r0 = r11.length - 1;
        long r3 = 0;
        long r5 = 0;
    L3:
        if (r0 < 0) goto L8;
        long r7 = r11[r0];
        if (r7 >= 0) goto L7;
        r7 = r7 + 256;
    L7:
        r3 = r3 | (r7 << ((int) r5));
        r5 = r5 + 8;
        r0 = r0 - 1;
        goto L3
    L8:
        return r3;
    }

    public static byte[] convertToUnicodeByteArray(String r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        char[] r8 = r7.toCharArray();
        int r0 = (r8.length * 2) + 2;
        byte[] r1 = new byte[r0];
        int r3 = 0;
    L7:
        if (r3 >= r8.length) goto L9;
        int r4 = r3 * 2;
        char r5 = r8[r3];
        r1[r4] = (byte) (r5 >> '\b');
        r1[r4 + 1] = (byte) r5;
        r3 = r3 + 1;
        goto L7
    L9:
        r1[r0 - 2] = 0;
        r1[r0 - 1] = 0;
        return r1;
    }

    public static byte[] getTagValue(byte r3, byte[] r4) {
        int r5 = findTag(r3, r4);
        if (r5 != (-1)) goto L6;
        return null;
    L6:
        int r6 = r5 + 1;
        int r0 = r4[r6] & 255;
        byte[] r1 = new byte[r0];
        System.arraycopy(r4, r6 + 1, r1, 0, r0);
        return r1;
    }

    public static int findTag(byte r3, byte[] r4) {
        if (r4 != null) goto L5;
        return -1;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= r4.length) goto L12;
        if (r4[r1] == r3) goto L12;
        r1 = r1 + ((r4[r1 + 1] & 255) + 2);
    L12:
        if (r1 < r4.length) goto L14;
        return -1;
    L14:
        return r1;
    }

    public static String convertToUnicode(byte[] r5, boolean r6) {
        if (r5 != 0) goto L4;
        return null;
    L4:
        if (r5.length == 0) goto L33;
        int r0 = r5.length;
        if ((r0 % 2) != 0) goto L26;
        int r1 = r0 >> 1;
        if (r6 == false) goto L11;
        r1 = r1 - 1;
    L11:
        char[] r7 = new char[r1];
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L24;
        int r3 = r2 * 2;
        int r4 = r5[r3];
        int r8 = r5[r3 + 1];
        if (r4 >= 0) goto L16;
        r4 = r4 + 256;
    L16:
        if (r8 >= 0) goto L18;
        r8 = r8 + 256;
    L18:
        if (r4 != 0) goto L22;
        if (r8 != 0) goto L22;
        return new String(r7, 0, r2);
    L22:
        r7[r2] = (char) (r8 | (r4 << 8));
        r2 = r2 + 1;
        goto L12
    L24:
        return new String(r7);
    L26:
        throw new IllegalArgumentException("Byte array not of a valid form");
    L33:
        return null;
    }

    public static byte[] computeMd5Hash(byte[] r1) {
        return MessageDigest.getInstance("MD5").digest(r1);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static byte[] computeAuthenticationChallenge(byte[] r8, String r9, boolean r10, boolean r11) throws IOException {
        if (r8.length != 16) goto L19;
        if (r9 != null) goto L8;
        byte[] r12 = new byte[21];
    L10:
        r12[0] = 0;
        r12[1] = 16;
        System.arraycopy(r8, 0, r12, 2, 16);
        r12[18] = 1;
        r12[19] = 1;
        r12[20] = 0;
        if (r10 == true) goto L13;
        r12[20] = (byte) (0 | 2);
    L13:
        if (r11 == false) goto L15;
        r12[20] = (byte) (r12[20] | 1);
    L15:
        return r12;
    L8:
        if (r9.length() >= 255) goto L17;
        byte[] r5 = new byte[r9.length() + 24];
        r5[21] = 2;
        r5[22] = (byte) (r9.length() + 1);
        r5[23] = 1;
        System.arraycopy(r9.getBytes("ISO8859_1"), 0, r5, 24, r9.length());
        r12 = r5;
        goto L10
    L17:
        throw new IllegalArgumentException("Realm must be less then 255 bytes");
    L19:
        throw new IllegalArgumentException("Nonce must be 16 bytes long");
    }

    public static int getMaxTxPacketSize(ObexTransport r0) {
        return validateMaxPacketSize(r0.getMaxTransmitPacketSize());
    }

    public static int getMaxRxPacketSize(ObexTransport r0) {
        return validateMaxPacketSize(r0.getMaxReceivePacketSize());
    }

    private static int validateMaxPacketSize(int r3) {
        if (VDBG == false) goto L7;
        if (r3 <= 65534) goto L7;
        Log.w(TAG, "The packet size supported for the connection (" + r3 + ") is larger than the configured OBEX packet size: 65534");
    L7:
        if (r3 != (-1)) goto L9;
        return MAX_PACKET_SIZE_INT;
    L9:
        if (r3 < 255) goto L12;
        return r3;
    L12:
        throw new IllegalArgumentException(r3 + " is less that the lower limit: 255");
    }
}
