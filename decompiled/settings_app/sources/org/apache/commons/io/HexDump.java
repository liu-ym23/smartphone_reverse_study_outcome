package org.apache.commons.io;

import cz.msebera.android.httpclient.message.TokenParser;
import java.io.IOException;
import java.io.OutputStream;
import obric.tablet.widget.BytedanceJustifyTextView;

/* JADX INFO: loaded from: classes6.dex */
public class HexDump {
    public static final String EOL = null;
    private static final StringBuffer _cbuffer = null;
    private static final char[] _hexcodes = null;
    private static final StringBuffer _lbuffer = null;
    private static final int[] _shifts = null;

    public HexDump() {
    }

    public static void dump(byte[] r7, long r8, OutputStream r10, int r11) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (r11 < 0) goto L32;
        if (r11 >= r7.length) goto L32;
        if (r10 == null) goto L30;
        long r9 = r8 + ((long) r11);
        StringBuffer r0 = new StringBuffer(74);
    L8:
        if (r11 >= r7.length) goto L28;
        int r1 = r7.length - r11;
        if (r1 <= 16) goto L12;
        r1 = 16;
    L12:
        r0.append(dump(r9)).append(TokenParser.SP);
        int r5 = 0;
    L13:
        if (r5 >= 16) goto L18;
        if (r5 >= r1) goto L16;
        r0.append(dump(r7[r5 + r11]));
    L17:
        r0.append(TokenParser.SP);
        r5 = r5 + 1;
        goto L13
    L16:
        r0.append(BytedanceJustifyTextView.TWO_BLANK);
        goto L17
    L18:
        int r2 = 0;
    L19:
        if (r2 >= r1) goto L27;
        byte r6 = r7[r2 + r11];
        if (r6 >= 32) goto L23;
    L25:
        r0.append('.');
    L26:
        r2 = r2 + 1;
        goto L19
    L23:
        if (r6 >= 127) goto L25;
        r0.append((char) r6);
        goto L26
    L27:
        r0.append(EOL);
        r10.write(r0.toString().getBytes());
        r10.flush();
        r0.setLength(0);
        r9 = r9 + ((long) r1);
        r11 = r11 + 16;
        goto L8
    L28:
        return;
    L30:
        throw new IllegalArgumentException("cannot write to nullstream");
    L32:
        throw new ArrayIndexOutOfBoundsException(new StringBuffer("illegal index: ").append(r11).append(" into array of length ").append(r7.length).toString());
    }

    static {
        EOL = System.getProperty("line.separator");
        _lbuffer = new StringBuffer(8);
        _cbuffer = new StringBuffer(2);
        _hexcodes = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        _shifts = new int[]{28, 24, 20, 16, 12, 8, 4, 0};
    }

    private static StringBuffer dump(long r5) {
        int r1 = 0;
        _lbuffer.setLength(0);
    L4:
        if (r1 >= 8) goto L7;
        _lbuffer.append(_hexcodes[((int) (r5 >> _shifts[r1])) & 15]);
        r1 = r1 + 1;
        goto L4
    L7:
        return _lbuffer;
    }

    private static StringBuffer dump(byte r5) {
        int r1 = 0;
        _cbuffer.setLength(0);
    L4:
        if (r1 >= 2) goto L7;
        _cbuffer.append(_hexcodes[(r5 >> _shifts[r1 + 6]) & 15]);
        r1 = r1 + 1;
        goto L4
    L7:
        return _cbuffer;
    }
}
