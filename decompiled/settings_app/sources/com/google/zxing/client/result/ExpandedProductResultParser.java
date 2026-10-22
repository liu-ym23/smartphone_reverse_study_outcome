package com.google.zxing.client.result;

import com.bytedance.apm.constant.CommonServiceName;
import com.google.common.base.Ascii;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class ExpandedProductResultParser extends ResultParser {
    public ExpandedProductResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public ExpandedProductParsedResult parse(Result r23) {
        ExpandedProductParsedResult r2 = null;
        if (r23.getBarcodeFormat() == BarcodeFormat.RSS_EXPANDED) goto L5;
        return null;
    L5:
        String r4 = getMassagedText(r23);
        HashMap r0 = new HashMap();
        String r5 = null;
        String r6 = null;
        String r7 = null;
        String r8 = null;
        String r9 = null;
        String r10 = null;
        String r11 = null;
        String r12 = null;
        String r13 = null;
        String r14 = null;
        String r15 = null;
        String r16 = null;
        String r17 = null;
        int r3 = 0;
    L7:
        if (r3 >= r4.length()) goto L173;
        String r1 = findAIvalue(r3, r4);
        if (r1 == null) goto L10;
        byte r19 = 2;
        int r18 = r3 + (r1.length() + 2);
        String r20 = findValue(r18, r4);
        int r21 = r18 + r20.length();
        r1.hashCode();
        r3 = r21;
        switch(r1.hashCode()) {
            case 1536: goto L150;
            case 1537: goto L146;
            case 1567: goto L143;
            case 1568: goto L139;
            case 1570: goto L135;
            case 1572: goto L131;
            case 1574: goto L127;
            case 1567966: goto L123;
            case 1567967: goto L119;
            case 1567968: goto L115;
            case 1567969: goto L111;
            case 1567970: goto L107;
            case 1567971: goto L103;
            case 1567972: goto L99;
            case 1567973: goto L95;
            case 1567974: goto L91;
            case 1567975: goto L87;
            case 1568927: goto L83;
            case 1568928: goto L79;
            case 1568929: goto L75;
            case 1568930: goto L71;
            case 1568931: goto L67;
            case 1568932: goto L63;
            case 1568933: goto L59;
            case 1568934: goto L55;
            case 1568935: goto L51;
            case 1568936: goto L47;
            case 1575716: goto L43;
            case 1575717: goto L39;
            case 1575718: goto L35;
            case 1575719: goto L31;
            case 1575747: goto L27;
            case 1575748: goto L23;
            case 1575749: goto L19;
            case 1575750: goto L15;
            default: goto L13;
        };
    L13:
        r19 = -1;
    L153:
        switch(r19) {
            case 0: goto L170;
            case 1: goto L169;
            case 2: goto L168;
            case 3: goto L167;
            case 4: goto L166;
            case 5: goto L165;
            case 6: goto L164;
            case 7: goto L162;
            case 8: goto L162;
            case 9: goto L162;
            case 10: goto L162;
            case 11: goto L162;
            case 12: goto L162;
            case 13: goto L162;
            case 14: goto L162;
            case 15: goto L162;
            case 16: goto L162;
            case 17: goto L161;
            case 18: goto L161;
            case 19: goto L161;
            case 20: goto L161;
            case 21: goto L161;
            case 22: goto L161;
            case 23: goto L161;
            case 24: goto L161;
            case 25: goto L161;
            case 26: goto L161;
            case 27: goto L160;
            case 28: goto L160;
            case 29: goto L160;
            case 30: goto L160;
            case 31: goto L156;
            case 32: goto L156;
            case 33: goto L156;
            case 34: goto L156;
            default: goto L154;
        };
    L156:
        if (r20.length() < 4) goto L157;
        String r110 = r20.substring(3);
        r17 = r20.substring(0, 3);
        r3 = r3;
        r15 = r110;
        r2 = null;
        r16 = r1.substring(3);
        goto L7
    L157:
        return null;
    L154:
        r0.put(r1, r20);
    L171:
        r2 = null;
        goto L7
    L160:
        r16 = r1.substring(3);
        r15 = r20;
        goto L171
    L161:
        r14 = r1.substring(3);
        r13 = ExpandedProductParsedResult.POUND;
    L163:
        r12 = r20;
        goto L171
    L162:
        r14 = r1.substring(3);
        r13 = ExpandedProductParsedResult.KILOGRAM;
        goto L163
    L164:
        r11 = r20;
        goto L171
    L165:
        r10 = r20;
        goto L171
    L166:
        r9 = r20;
        goto L171
    L167:
        r8 = r20;
        goto L171
    L168:
        r7 = r20;
        goto L171
    L169:
        r5 = r20;
        goto L171
    L170:
        r6 = r20;
        goto L171
    L15:
        if (r1.equals("3933") == false) goto L192;
        r19 = 34;
        goto L153
    L192:
        r19 = -1;
        goto L153
    L19:
        if (r1.equals("3932") == false) goto L193;
        r19 = 33;
        goto L153
    L193:
        r19 = -1;
        goto L153
    L23:
        if (r1.equals("3931") == false) goto L194;
        r19 = 32;
        goto L153
    L194:
        r19 = -1;
        goto L153
    L27:
        if (r1.equals("3930") == false) goto L195;
        r19 = Ascii.US;
        goto L153
    L195:
        r19 = -1;
        goto L153
    L31:
        if (r1.equals("3923") == false) goto L196;
        r19 = Ascii.RS;
        goto L153
    L196:
        r19 = -1;
        goto L153
    L35:
        if (r1.equals("3922") == false) goto L197;
        r19 = 29;
        goto L153
    L197:
        r19 = -1;
        goto L153
    L39:
        if (r1.equals("3921") == false) goto L198;
        r19 = 28;
        goto L153
    L198:
        r19 = -1;
        goto L153
    L43:
        if (r1.equals("3920") == false) goto L199;
        r19 = 27;
        goto L153
    L199:
        r19 = -1;
        goto L153
    L47:
        if (r1.equals("3209") == false) goto L200;
        r19 = 26;
        goto L153
    L200:
        r19 = -1;
        goto L153
    L51:
        if (r1.equals("3208") == false) goto L201;
        r19 = 25;
        goto L153
    L201:
        r19 = -1;
        goto L153
    L55:
        if (r1.equals("3207") == false) goto L202;
        r19 = 24;
        goto L153
    L202:
        r19 = -1;
        goto L153
    L59:
        if (r1.equals("3206") == false) goto L203;
        r19 = 23;
        goto L153
    L203:
        r19 = -1;
        goto L153
    L63:
        if (r1.equals("3205") == false) goto L204;
        r19 = 22;
        goto L153
    L204:
        r19 = -1;
        goto L153
    L67:
        if (r1.equals("3204") == false) goto L205;
        r19 = 21;
        goto L153
    L205:
        r19 = -1;
        goto L153
    L71:
        if (r1.equals("3203") == false) goto L206;
        r19 = 20;
        goto L153
    L206:
        r19 = -1;
        goto L153
    L75:
        if (r1.equals("3202") == false) goto L207;
        r19 = 19;
        goto L153
    L207:
        r19 = -1;
        goto L153
    L79:
        if (r1.equals("3201") == false) goto L208;
        r19 = 18;
        goto L153
    L208:
        r19 = -1;
        goto L153
    L83:
        if (r1.equals("3200") == false) goto L209;
        r19 = 17;
        goto L153
    L209:
        r19 = -1;
        goto L153
    L87:
        if (r1.equals("3109") == false) goto L210;
        r19 = 16;
        goto L153
    L210:
        r19 = -1;
        goto L153
    L91:
        if (r1.equals("3108") == false) goto L211;
        r19 = 15;
        goto L153
    L211:
        r19 = -1;
        goto L153
    L95:
        if (r1.equals("3107") == false) goto L212;
        r19 = 14;
        goto L153
    L212:
        r19 = -1;
        goto L153
    L99:
        if (r1.equals("3106") == false) goto L213;
        r19 = 13;
        goto L153
    L213:
        r19 = -1;
        goto L153
    L103:
        if (r1.equals("3105") == false) goto L214;
        r19 = 12;
        goto L153
    L214:
        r19 = -1;
        goto L153
    L107:
        if (r1.equals("3104") == false) goto L215;
        r19 = 11;
        goto L153
    L215:
        r19 = -1;
        goto L153
    L111:
        if (r1.equals("3103") == false) goto L216;
        r19 = 10;
        goto L153
    L216:
        r19 = -1;
        goto L153
    L115:
        if (r1.equals("3102") == false) goto L217;
        r19 = 9;
        goto L153
    L217:
        r19 = -1;
        goto L153
    L119:
        if (r1.equals("3101") == false) goto L218;
        r19 = 8;
        goto L153
    L218:
        r19 = -1;
        goto L153
    L123:
        if (r1.equals("3100") == false) goto L219;
        r19 = 7;
        goto L153
    L219:
        r19 = -1;
        goto L153
    L127:
        if (r1.equals("17") == false) goto L220;
        r19 = 6;
        goto L153
    L220:
        r19 = -1;
        goto L153
    L131:
        if (r1.equals("15") == false) goto L221;
        r19 = 5;
        goto L153
    L221:
        r19 = -1;
        goto L153
    L135:
        if (r1.equals("13") == false) goto L222;
        r19 = 4;
        goto L153
    L222:
        r19 = -1;
        goto L153
    L139:
        if (r1.equals(CommonServiceName.CRONET_ERROR_CODE_CANCEL) == false) goto L223;
        r19 = 3;
        goto L153
    L223:
        r19 = -1;
        goto L153
    L143:
        if (r1.equals("10") == true) goto L153;
        r19 = -1;
        goto L153
    L146:
        if (r1.equals("01") == false) goto L225;
        r19 = 1;
        goto L153
    L225:
        r19 = -1;
        goto L153
    L150:
        if (r1.equals("00") == false) goto L226;
        r19 = 0;
        goto L153
    L226:
        r19 = -1;
        goto L153
    L10:
        return r2;
    L173:
        return new ExpandedProductParsedResult(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r0);
    }

    private static String findAIvalue(int r4, String r5) {
        if (r5.charAt(r4) == '(') goto L5;
        return null;
    L5:
        String r6 = r5.substring(r4 + 1);
        StringBuilder r7 = new StringBuilder();
        int r0 = 0;
    L7:
        if (r0 >= r6.length()) goto L20;
        char r1 = r6.charAt(r0);
        if (r1 == ')') goto L11;
        if (r1 < '0') goto L18;
        if (r1 > '9') goto L18;
        r7.append(r1);
        r0 = r0 + 1;
    L18:
        return null;
    L11:
        return r7.toString();
    L20:
        return r7.toString();
    }

    private static String findValue(int r3, String r4) {
        StringBuilder r0 = new StringBuilder();
        String r5 = r4.substring(r3);
        int r6 = 0;
    L4:
        if (r6 >= r5.length()) goto L13;
        char r1 = r5.charAt(r6);
        if (r1 == '(') goto L8;
        r0.append(r1);
    L11:
        r6 = r6 + 1;
        goto L4
    L8:
        if (findAIvalue(r6, r5) != null) goto L13;
        r0.append('(');
    L13:
        return r0.toString();
    }
}
