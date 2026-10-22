package tmsdkobf;

import androidx.core.view.MotionEventCompat;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import kotlin.UByte;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes5.dex */
public class oj {
    public static final String[] j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yi f400a;
    public Map b;
    public byte[] c;
    public String[] d;
    public int[] e;
    public int f;
    public int g;
    public int h;
    public int i;

    static {
        j = new String[]{"px", "dp", CloudControlInf.SP, "pt", "in", "mm"};
    }

    public oj() {
        this.b = new HashMap();
    }

    public Document a(InputStream r17) {
        yi r1 = new yi();
        this.f400a = r1;
        byte[] r2 = new byte[r17.available()];
        this.c = r2;
        r17.read(r2);
        r17.close();
    L3:
        int r3 = this.i;
        if (r3 >= this.c.length) goto L99;
        int r4 = a(r3);
        int r5 = -1;
        if (r4 != (-1)) goto L8;
        this.f400a.getClass();
        goto L3
    L8:
        if (r4 != 524291) goto L10;
        yi r6 = this.f400a;
        Document r7 = r6.c.newDocument();
        r6.b = r7;
        r6.f645a.push(r7);
        this.i += 8;
        goto L3
    L10:
        if (r4 != 524672) goto L12;
        int r8 = a(this.i + 4);
        int r9 = (r8 / 4) - 2;
        this.h = r9;
        this.e = new int[r9];
        int r10 = 0;
    L94:
        if (r10 >= this.h) goto L96;
        this.e[r10] = a(((r10 + 2) * 4) + this.i);
        r10 = r10 + 1;
        goto L94
    L96:
        this.i += r8;
        goto L3
    L12:
        if (r4 != 1835009) goto L13;
        int r11 = a(this.i + 4);
        this.f = a(this.i + 8);
        this.g = a(this.i + 12);
        int r12 = this.i;
        int r13 = a(r12 + 20) + r12;
        int r14 = a(this.i + 24);
        this.d = new String[this.f];
        int r15 = 0;
    L76:
        if (r15 >= this.f) goto L86;
        int r16 = a(((r15 + 7) * 4) + this.i) + r13;
        String[] r18 = this.d;
        byte[] r19 = this.c;
        int r110 = r19[r16 + 1];
        int r111 = r19[r16];
        if (r110 != r111) goto L82;
        byte[] r112 = new byte[r111];
        int r113 = 0;
    L80:
        if (r113 >= r111) goto L85;
        r112[r113] = this.c[(r16 + 2) + r113];
        r113 = r113 + 1;
    L85:
        r18[r15] = new String(r112);
        r15 = r15 + 1;
        goto L76
    L82:
        int r114 = (r111 & 255) | ((r110 << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
        r112 = new byte[r114];
        int r115 = 0;
    L83:
        if (r115 >= r114) goto L85;
        r112[r115] = this.c[(r115 * 2) + (r16 + 2)];
        r115 = r115 + 1;
        goto L83
    L86:
        if (r14 <= 0) goto L91;
        int r20 = 0;
    L89:
        if (r20 >= this.g) goto L91;
        r20 = r20 + 1;
    L91:
        this.i += r11;
        goto L3
    L13:
        switch(r4) {
            case 1048832: goto L73;
            case 1048833: goto L72;
            case 1048834: goto L21;
            case 1048835: goto L16;
            case 1048836: goto L15;
            default: goto L14;
        };
    L15:
        String r21 = b(a(this.i + 16));
        yi r22 = this.f400a;
        ((Node) r22.f645a.peek()).appendChild(r22.b.createCDATASection(r21));
        this.i += 28;
        goto L3
    L16:
        int r23 = a(this.i + 16);
        b(a(this.i + 20));
        if (r23 == (-1)) goto L20;
        b(r23);
    L20:
        this.f400a.f645a.pop();
        this.i += 24;
        goto L3
    L21:
        int r24 = a(this.i + 16);
        int r25 = a(this.i + 20);
        int r26 = this.i;
        byte[] r116 = this.c;
        int r27 = (65280 & (r116[r26 + 29] << 8)) | (r116[r26 + 28] & 255);
        String r28 = b(r25);
        if (r24 != (-1)) goto L24;
        String r117 = r28;
        String r29 = "";
    L28:
        this.i += 36;
        ei[] r118 = new ei[r27];
        int r119 = 0;
    L29:
        if (r119 >= r27) goto L54;
        int r120 = a(this.i);
        int r121 = a(this.i + 4);
        int r30 = a(this.i + 8);
        int r31 = a(this.i + 12);
        int r32 = a(this.i + 16);
        ei r33 = new ei();
        r33.f185a = b(r121);
        if (r120 != r5) goto L33;
        r33.c = null;
        r33.b = null;
    L36:
        if (r30 != r5) goto L52;
        switch(r31) {
            case 16777224: goto L50;
            case 33554440: goto L49;
            case 50331656: goto L48;
            case 67108872: goto L47;
            case 83886088: goto L46;
            case 100663304: goto L45;
            case 268435464: goto L44;
            case 285212680: goto L44;
            case 301989896: goto L40;
            case 469762056: goto L39;
            case 486539272: goto L39;
            default: goto L38;
        };
    L38:
        String r34 = String.format("%08X/0x%08X", new Object[]{Integer.valueOf(r31), Integer.valueOf(r32)});
    L51:
        r33.d = r34;
    L53:
        r118[r119] = r33;
        this.i += 20;
        r119 = r119 + 1;
        r5 = -1;
        goto L29
    L39:
        r34 = String.format("#%08X", new Object[]{Integer.valueOf(r32)});
        goto L51
    L40:
        if (r32 == 0) goto L42;
        boolean r35 = true;
    L43:
        r34 = Boolean.toString(r35);
        goto L51
    L42:
        r35 = false;
        goto L43
    L44:
        r34 = Integer.toString(r32);
        goto L51
    L45:
        r34 = new DecimalFormat("#.##%").format(((double) r32) / 2.147483647E9d);
        goto L51
    L46:
        r34 = Integer.toString(r32 >> 8) + j[r32 & 255];
        goto L51
    L47:
        r34 = Float.toString(Float.intBitsToFloat(r32));
        goto L51
    L48:
        r34 = b(r32);
        goto L51
    L49:
        r34 = String.format("?id/0x%08X", new Object[]{Integer.valueOf(r32)});
        goto L51
    L50:
        r34 = String.format("@id/0x%08X", new Object[]{Integer.valueOf(r32)});
        goto L51
    L52:
        r33.d = b(r30);
        goto L53
    L33:
        String r122 = b(r120);
        if (this.b.containsKey(r122) == false) goto L36;
        r33.c = r122;
        r33.b = (String) this.b.get(r122);
        goto L36
    L54:
        yi r36 = this.f400a;
        r36.getClass();
        if (r29 != null) goto L57;
    L60:
        Element r37 = r36.b.createElement(r28);
    L61:
        int r38 = 0;
    L62:
        if (r38 >= r27) goto L71;
        ei r39 = r118[r38];
        String r40 = r39.c;
        if (r40 != null) goto L66;
    L69:
        r37.setAttribute(r39.f185a, r39.d);
    L70:
        r38 = r38 + 1;
        goto L62
    L66:
        if ("".equals(r40) == true) goto L69;
        r37.setAttributeNS(r39.c, r39.b + ':' + r39.f185a, r39.d);
        goto L70
    L71:
        ((Node) r36.f645a.peek()).appendChild(r37);
        r36.f645a.push(r37);
        goto L3
    L57:
        if ("".equals(r29) == true) goto L60;
        r37 = r36.b.createElementNS(r29, r117);
        goto L61
    L24:
        r29 = b(r24);
        if (this.b.containsKey(r29) == false) goto L27;
        r117 = ((String) this.b.get(r29)) + ':' + r28;
        goto L28
    L27:
        r117 = r28;
        goto L28
    L72:
        a(false);
        goto L3
    L73:
        a(true);
        goto L3
    L14:
        this.i += 4;
        goto L3
    L99:
        this.f400a.getClass();
        return r1.b;
    }

    public final String b(int r2) {
        if (r2 >= 0) goto L4;
    L6:
        return null;
    L4:
        if (r2 >= this.f) goto L6;
        return this.d[r2];
    }

    public final void a(boolean r3) {
        int r0 = a(this.i + 16);
        String r1 = b(a(this.i + 20));
        String r2 = b(r0);
        if (r3 == false) goto L5;
        this.f400a.getClass();
        this.b.put(r1, r2);
    L6:
        this.i += 24;
        return;
    L5:
        this.f400a.getClass();
        this.b.remove(r1);
        goto L6
    }

    public final int a(int r4) {
        byte[] r3 = this.c;
        int r0 = (((r3[r4 + 3] << 24) & (-16777216)) | ((r3[r4 + 2] << 16) & 16711680)) | ((r3[r4 + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
        return (r3[r4] & UByte.MAX_VALUE) | r0;
    }
}
