package javax.obex;

import com.ttnet.org.chromium.net.NetError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Calendar;

/* JADX INFO: loaded from: classes5.dex */
public final class HeaderSet {
    public static final int APPLICATION_PARAMETER = 76;
    public static final int AUTH_CHALLENGE = 77;
    public static final int AUTH_RESPONSE = 78;
    public static final int BODY = 72;
    public static final int CONNECTION_ID = 203;
    public static final int COUNT = 192;
    public static final int DESCRIPTION = 5;
    public static final int END_OF_BODY = 73;
    public static final int HTTP = 71;
    public static final int LENGTH = 195;
    public static final int NAME = 1;
    public static final int OBJECT_CLASS = 79;
    public static final int SINGLE_RESPONSE_MODE = 151;
    public static final int SINGLE_RESPONSE_MODE_PARAMETER = 152;
    public static final int TARGET = 70;
    public static final int TIME_4_BYTE = 196;
    public static final int TIME_ISO_8601 = 68;
    public static final int TYPE = 66;
    public static final int WHO = 74;
    private byte[] mAppParam;
    public byte[] mAuthChall;
    public byte[] mAuthResp;
    private Calendar mByteTime;
    private Byte[] mByteUserDefined;
    public byte[] mConnectionID;
    private Long mCount;
    private String mDescription;
    private boolean mEmptyName;
    private byte[] mHttpHeader;
    private Long[] mIntegerUserDefined;
    private Calendar mIsoTime;
    private Long mLength;
    private String mName;
    private byte[] mObjectClass;
    private SecureRandom mRandom;
    private byte[][] mSequenceUserDefined;
    private Byte mSingleResponseMode;
    private Byte mSrmParam;
    private byte[] mTarget;
    private String mType;
    private String[] mUnicodeUserDefined;
    private byte[] mWho;
    byte[] nonce;
    public int responseCode;

    public HeaderSet() {
        this.mRandom = null;
        this.mUnicodeUserDefined = new String[16];
        this.mSequenceUserDefined = new byte[16][];
        this.mByteUserDefined = new Byte[16];
        this.mIntegerUserDefined = new Long[16];
        this.responseCode = -1;
    }

    public void setEmptyNameHeader() {
        this.mName = null;
        this.mEmptyName = true;
    }

    public boolean getEmptyNameHeader() {
        return this.mEmptyName;
    }

    public void setHeader(int r9, Object r10) {
        if (r9 != 1) goto L5;
        if (r10 != null) goto L187;
    L191:
        this.mEmptyName = false;
        this.mName = (String) r10;
        return;
    L187:
        if ((r10 instanceof String) == true) goto L191;
        throw new IllegalArgumentException("Name must be a String");
    L5:
        if (r9 != 5) goto L7;
        if (r10 != null) goto L180;
    L184:
        this.mDescription = (String) r10;
        return;
    L180:
        if ((r10 instanceof String) == true) goto L184;
        throw new IllegalArgumentException("Description must be a String");
    L7:
        if (r9 != 66) goto L9;
        if (r10 != null) goto L173;
    L177:
        this.mType = (String) r10;
        return;
    L173:
        if ((r10 instanceof String) == true) goto L177;
        throw new IllegalArgumentException("Type must be a String");
    L9:
        if (r9 != 68) goto L11;
        if (r10 != null) goto L166;
    L170:
        this.mIsoTime = (Calendar) r10;
        return;
    L166:
        if ((r10 instanceof Calendar) == true) goto L170;
        throw new IllegalArgumentException("Time ISO 8601 must be a Calendar");
    L11:
        if (r9 != 74) goto L13;
        if (r10 != null) goto L160;
        this.mWho = null;
        return;
    L160:
        if ((r10 instanceof byte[]) == false) goto L163;
        byte[] r11 = new byte[((byte[]) r10).length];
        this.mWho = r11;
        System.arraycopy(r10, 0, r11, 0, r11.length);
        return;
    L163:
        throw new IllegalArgumentException("WHO must be a byte array");
    L13:
        if (r9 != 76) goto L15;
        if (r10 != null) goto L153;
        this.mAppParam = null;
        return;
    L153:
        if ((r10 instanceof byte[]) == false) goto L156;
        byte[] r12 = new byte[((byte[]) r10).length];
        this.mAppParam = r12;
        System.arraycopy(r10, 0, r12, 0, r12.length);
        return;
    L156:
        throw new IllegalArgumentException("Application Parameter must be a byte array");
    L15:
        if (r9 != 79) goto L17;
        if (r10 != null) goto L146;
        this.mObjectClass = null;
        return;
    L146:
        if ((r10 instanceof byte[]) == false) goto L149;
        byte[] r13 = new byte[((byte[]) r10).length];
        this.mObjectClass = r13;
        System.arraycopy(r10, 0, r13, 0, r13.length);
        return;
    L149:
        throw new IllegalArgumentException("Object Class must be a byte array");
    L17:
        if (r9 == 192) goto L131;
        if (r9 != 70) goto L21;
        if (r10 != null) goto L126;
        this.mTarget = null;
        return;
    L126:
        if ((r10 instanceof byte[]) == false) goto L129;
        byte[] r14 = new byte[((byte[]) r10).length];
        this.mTarget = r14;
        System.arraycopy(r10, 0, r14, 0, r14.length);
        return;
    L129:
        throw new IllegalArgumentException("Target must be a byte array");
    L21:
        if (r9 != 71) goto L23;
        if (r10 != null) goto L119;
        this.mHttpHeader = null;
        return;
    L119:
        if ((r10 instanceof byte[]) == false) goto L122;
        byte[] r15 = new byte[((byte[]) r10).length];
        this.mHttpHeader = r15;
        System.arraycopy(r10, 0, r15, 0, r15.length);
        return;
    L122:
        throw new IllegalArgumentException("HTTP must be a byte array");
    L23:
        if (r9 != 151) goto L25;
        if (r10 != null) goto L112;
        this.mSingleResponseMode = null;
        return;
    L112:
        if ((r10 instanceof Byte) == false) goto L115;
        this.mSingleResponseMode = (Byte) r10;
        return;
    L115:
        throw new IllegalArgumentException("Single Response Mode must be a Byte");
    L25:
        if (r9 != 152) goto L27;
        if (r10 != null) goto L105;
        this.mSrmParam = null;
        return;
    L105:
        if ((r10 instanceof Byte) == false) goto L108;
        this.mSrmParam = (Byte) r10;
        return;
    L108:
        throw new IllegalArgumentException("Single Response Mode Parameter must be a Byte");
    L27:
        if (r9 == 195) goto L90;
        if (r9 != 196) goto L31;
        if (r10 != null) goto L84;
    L88:
        this.mByteTime = (Calendar) r10;
        return;
    L84:
        if ((r10 instanceof Calendar) == true) goto L88;
        throw new IllegalArgumentException("Time 4 Byte must be a Calendar");
    L31:
        if (r9 < 48) goto L42;
        if (r9 > 63) goto L42;
        if (r10 != null) goto L36;
    L40:
        this.mUnicodeUserDefined[r9 - 48] = (String) r10;
        return;
    L36:
        if ((r10 instanceof String) == true) goto L40;
        throw new IllegalArgumentException("Unicode String User Defined must be a String");
    L42:
        if (r9 < 112) goto L53;
        if (r9 > 127) goto L53;
        if (r10 != null) goto L48;
        this.mSequenceUserDefined[r9 - 112] = null;
        return;
    L48:
        if ((r10 instanceof byte[]) == false) goto L51;
        byte[] r0 = new byte[((byte[]) r10).length];
        this.mSequenceUserDefined[r9 - 112] = r0;
        System.arraycopy(r10, 0, r0, 0, r0.length);
        return;
    L51:
        throw new IllegalArgumentException("Byte Sequence User Defined must be a byte array");
    L53:
        if (r9 < 176) goto L64;
        if (r9 > 191) goto L64;
        if (r10 != null) goto L58;
    L62:
        this.mByteUserDefined[r9 - 176] = (Byte) r10;
        return;
    L58:
        if ((r10 instanceof Byte) == true) goto L62;
        throw new IllegalArgumentException("ByteUser Defined must be a Byte");
    L64:
        if (r9 < 240) goto L81;
        if (r9 > 255) goto L81;
        if ((r10 instanceof Long) == true) goto L73;
        if (r10 != null) goto L72;
        this.mIntegerUserDefined[r9 - 240] = null;
        return;
    L72:
        throw new IllegalArgumentException("Integer User Defined must be a Long");
    L73:
        Long r16 = (Long) r10;
        long r1 = r16.longValue();
        if (r1 < 0) goto L79;
        if (r1 > 4294967295L) goto L79;
        this.mIntegerUserDefined[r9 - 240] = r16;
        return;
    L79:
        throw new IllegalArgumentException("Integer User Defined must be between 0 and 0xFFFFFFFF");
    L81:
        throw new IllegalArgumentException("Invalid Header Identifier");
    L90:
        if ((r10 instanceof Long) == true) goto L95;
        if (r10 != null) goto L94;
        this.mLength = null;
        return;
    L94:
        throw new IllegalArgumentException("Length must be a Long");
    L95:
        Long r17 = (Long) r10;
        long r2 = r17.longValue();
        if (r2 < 0) goto L101;
        if (r2 > 4294967295L) goto L101;
        this.mLength = r17;
        return;
    L101:
        throw new IllegalArgumentException("Length must be between 0 and 0xFFFFFFFF");
    L131:
        if ((r10 instanceof Long) == true) goto L136;
        if (r10 != null) goto L135;
        this.mCount = null;
        return;
    L135:
        throw new IllegalArgumentException("Count must be a Long");
    L136:
        Long r18 = (Long) r10;
        long r3 = r18.longValue();
        if (r3 < 0) goto L142;
        if (r3 > 4294967295L) goto L142;
        this.mCount = r18;
        return;
    L142:
        throw new IllegalArgumentException("Count must be between 0 and 0xFFFFFFFF");
    }

    public Object getHeader(int r3) throws IOException {
        if (r3 == 1) goto L87;
        if (r3 == 5) goto L85;
        if (r3 == 66) goto L83;
        if (r3 == 68) goto L81;
        if (r3 == 74) goto L79;
        if (r3 == 76) goto L77;
        if (r3 == 79) goto L75;
        if (r3 == 192) goto L73;
        if (r3 == 203) goto L71;
        if (r3 == 70) goto L69;
        if (r3 == 71) goto L67;
        if (r3 == 151) goto L65;
        if (r3 == 152) goto L63;
        if (r3 == 195) goto L61;
        if (r3 == 196) goto L59;
        if (r3 < 48) goto L39;
        if (r3 > 63) goto L39;
        return this.mUnicodeUserDefined[r3 - 48];
    L39:
        if (r3 < 112) goto L45;
        if (r3 > 127) goto L45;
        return this.mSequenceUserDefined[r3 - 112];
    L45:
        if (r3 < 176) goto L51;
        if (r3 > 191) goto L51;
        return this.mByteUserDefined[r3 - 176];
    L51:
        if (r3 < 240) goto L57;
        if (r3 > 255) goto L57;
        return this.mIntegerUserDefined[r3 - 240];
    L57:
        throw new IllegalArgumentException("Invalid Header Identifier");
    L59:
        return this.mByteTime;
    L61:
        return this.mLength;
    L63:
        return this.mSrmParam;
    L65:
        return this.mSingleResponseMode;
    L67:
        return this.mHttpHeader;
    L69:
        return this.mTarget;
    L71:
        return this.mConnectionID;
    L73:
        return this.mCount;
    L75:
        return this.mObjectClass;
    L77:
        return this.mAppParam;
    L79:
        return this.mWho;
    L81:
        return this.mIsoTime;
    L83:
        return this.mType;
    L85:
        return this.mDescription;
    L87:
        return this.mName;
    }

    public int[] getHeaderList() throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        if (this.mCount == null) goto L6;
        r0.write(192);
    L6:
        if (this.mName == null) goto L9;
        r0.write(1);
    L9:
        if (this.mType == null) goto L12;
        r0.write(66);
    L12:
        if (this.mLength == null) goto L15;
        r0.write(195);
    L15:
        if (this.mIsoTime == null) goto L18;
        r0.write(68);
    L18:
        if (this.mByteTime == null) goto L21;
        r0.write(196);
    L21:
        if (this.mDescription == null) goto L24;
        r0.write(5);
    L24:
        if (this.mTarget == null) goto L27;
        r0.write(70);
    L27:
        if (this.mHttpHeader == null) goto L30;
        r0.write(71);
    L30:
        if (this.mWho == null) goto L33;
        r0.write(74);
    L33:
        if (this.mAppParam == null) goto L36;
        r0.write(76);
    L36:
        if (this.mObjectClass == null) goto L39;
        r0.write(79);
    L39:
        if (this.mSingleResponseMode == null) goto L42;
        r0.write(151);
    L42:
        if (this.mSrmParam == null) goto L44;
        r0.write(152);
    L44:
        int r1 = 48;
    L46:
        if (r1 >= 64) goto L51;
        if (this.mUnicodeUserDefined[r1 - 48] == null) goto L50;
        r0.write(r1);
    L50:
        r1 = r1 + 1;
        goto L46
    L51:
        int r2 = 112;
    L53:
        if (r2 >= 128) goto L58;
        if (this.mSequenceUserDefined[r2 + NetError.ERR_NO_SSL_VERSIONS_ENABLED] == null) goto L57;
        r0.write(r2);
    L57:
        r2 = r2 + 1;
        goto L53
    L58:
        int r3 = 176;
    L59:
        if (r3 >= 192) goto L64;
        if (this.mByteUserDefined[r3 + NetError.ERR_NO_BUFFER_SPACE] == null) goto L63;
        r0.write(r3);
    L63:
        r3 = r3 + 1;
        goto L59
    L64:
        int r4 = 240;
    L66:
        if (r4 >= 256) goto L71;
        if (this.mIntegerUserDefined[r4 - 240] == null) goto L70;
        r0.write(r4);
    L70:
        r4 = r4 + 1;
        goto L66
    L71:
        byte[] r5 = r0.toByteArray();
        r0.close();
        if (r5 != null) goto L74;
        return null;
    L74:
        if (r5.length == 0) goto L96;
        int[] r6 = new int[r5.length];
        int r7 = 0;
    L78:
        if (r7 >= r5.length) goto L80;
        r6[r7] = r5[r7] & 255;
        r7 = r7 + 1;
        goto L78
    L80:
        return r6;
    L96:
        return null;
    }

    public void createAuthenticationChallenge(String r5, boolean r6, boolean r7) throws IOException {
        this.nonce = new byte[16];
        if (this.mRandom != null) goto L5;
        this.mRandom = new SecureRandom();
    L5:
        int r1 = 0;
    L6:
        if (r1 >= 16) goto L8;
        this.nonce[r1] = (byte) this.mRandom.nextInt();
        r1 = r1 + 1;
        goto L6
    L8:
        this.mAuthChall = ObexHelper.computeAuthenticationChallenge(this.nonce, r5, r7, r6);
    }

    public int getResponseCode() throws IOException {
        int r1 = this.responseCode;
        if (r1 == (-1)) goto L6;
        return r1;
    L6:
        throw new IOException("May not be called on a server");
    }
}
