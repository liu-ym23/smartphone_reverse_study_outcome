package com.android.settings.pinyin;

import android.text.TextUtils;
import cz.msebera.android.httpclient.message.TokenParser;
import java.text.Collator;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class PinyinUtils {
    private static final String FIRST_PINYIN_UNIHAN = "阿";
    private static final String LAST_PINYIN_UNIHAN = "鿿";
    private static final int MAX_CHAR = 256;
    public static final byte[][] PINYINS = null;
    public static final char[] UNIHANS = null;
    public static final String UNKNOWN_STRING = "<unknown>";

    public static boolean isMuiltPinyinChineseName(char r0) {
        switch(r0) {
            case 19975: goto L4;
            case 20048: goto L4;
            case 20102: goto L4;
            case 20146: goto L4;
            case 20160: goto L4;
            case 20167: goto L4;
            case 20250: goto L4;
            case 20256: goto L4;
            case 20271: goto L4;
            case 20284: goto L4;
            case 20315: goto L4;
            case 20415: goto L4;
            case 20447: goto L4;
            case 20457: goto L4;
            case 21032: goto L4;
            case 21049: goto L4;
            case 21066: goto L4;
            case 21093: goto L4;
            case 21170: goto L4;
            case 21202: goto L4;
            case 21273: goto L4;
            case 21306: goto L4;
            case 21333: goto L4;
            case 21340: goto L4;
            case 21345: goto L4;
            case 21442: goto L4;
            case 21505: goto L4;
            case 21523: goto L4;
            case 21602: goto L4;
            case 21644: goto L4;
            case 21654: goto L4;
            case 21679: goto L4;
            case 21683: goto L4;
            case 21693: goto L4;
            case 22204: goto L4;
            case 22280: goto L4;
            case 22475: goto L4;
            case 22622: goto L4;
            case 22771: goto L4;
            case 22823: goto L4;
            case 22855: goto L4;
            case 23487: goto L4;
            case 23561: goto L4;
            case 23615: goto L4;
            case 24046: goto L4;
            case 24230: goto L4;
            case 24377: goto L4;
            case 24378: goto L4;
            case 24471: goto L4;
            case 24694: goto L4;
            case 25166: goto L4;
            case 25170: goto L4;
            case 25273: goto L4;
            case 25299: goto L4;
            case 25303: goto L4;
            case 25321: goto L4;
            case 25552: goto L4;
            case 25874: goto L4;
            case 26366: goto L4;
            case 26397: goto L4;
            case 26415: goto L4;
            case 26420: goto L4;
            case 26441: goto L4;
            case 26597: goto L4;
            case 26657: goto L4;
            case 27103: goto L4;
            case 27169: goto L4;
            case 27575: goto L4;
            case 27667: goto L4;
            case 27795: goto L4;
            case 27809: goto L4;
            case 27850: goto L4;
            case 29087: goto L4;
            case 29226: goto L4;
            case 29279: goto L4;
            case 29575: goto L4;
            case 30044: goto L4;
            case 30111: goto L4;
            case 30340: goto L4;
            case 30422: goto L4;
            case 30427: goto L4;
            case 30465: goto L4;
            case 30528: goto L4;
            case 31109: goto L4;
            case 31216: goto L4;
            case 32473: goto L4;
            case 32554: goto L4;
            case 32735: goto L4;
            case 33071: goto L4;
            case 33152: goto L4;
            case 33261: goto L4;
            case 33394: goto L4;
            case 33564: goto L4;
            case 33853: goto L4;
            case 33879: goto L4;
            case 33882: goto L4;
            case 34067: goto L4;
            case 34255: goto L4;
            case 34532: goto L4;
            case 34880: goto L4;
            case 34892: goto L4;
            case 35273: goto L4;
            case 35282: goto L4;
            case 35299: goto L4;
            case 35828: goto L4;
            case 35835: goto L4;
            case 35841: goto L4;
            case 35843: goto L4;
            case 36711: goto L4;
            case 36767: goto L4;
            case 36824: goto L4;
            case 36843: goto L4;
            case 37027: goto L4;
            case 37117: goto L4;
            case 37325: goto L4;
            case 38271: goto L4;
            case 38463: goto L4;
            case 38477: goto L4;
            case 38551: goto L4;
            case 38592: goto L4;
            case 38706: goto L4;
            case 39534: goto L4;
            default: goto L3;
        };
    L3:
        return false;
    L4:
        return true;
    }

    public PinyinUtils() {
    }

    public static char getFirstChar(String r7) {
        char r0 = '#';
        if (r7 == null) goto L25;
        if (r7.length() <= 0) goto L25;
        char r8 = r7.charAt(0);
        if (r8 <= 256) goto L19;
        String r2 = convertStringtoPinyin(String.valueOf(r8));
        if (r2 == null) goto L25;
        if (r2.length() == 0) goto L13;
        r0 = r2.charAt(0);
    L14:
        if (r0 < 'A') goto L16;
        if (r0 <= 'Z') goto L25;
    L16:
        if (r0 < 'a') goto L23;
        if (r0 <= 'z') goto L25;
    L23:
        r0 = r8;
        goto L25
    L13:
        r0 = r8;
        goto L14
    L19:
        if (r8 < 'A') goto L21;
        if (r8 <= 'Z') goto L23;
    L21:
        if (r8 < 'a') goto L25;
        if (r8 <= 'z') goto L23;
    L25:
        return Character.toUpperCase(r0);
    }

    public static String convertStringtoSortedPinyin(String r7) {
        StringBuilder r0 = new StringBuilder();
        char r2 = r7.charAt(0);
        String r8 = convertStringtoPinyin(r7);
        if (r2 >= 256) goto L15;
        StringBuilder r3 = new StringBuilder();
        if (r2 < 'a') goto L9;
        if (r2 > 'z') goto L9;
        r3.append(r2 + 0);
    L14:
        r0.append(r3);
        r0.append(r8.substring(1, r8.length()));
    L17:
        return r0.toString().toUpperCase();
    L9:
        if (r2 <= 'Z') goto L11;
    L13:
        r3.append(Character.toString((char) (r2 + 'z')));
        goto L14
    L11:
        if (r2 < 'A') goto L13;
        r3.append(r2 + 1);
        goto L14
    L15:
        r0.append(r8);
        goto L17
    }

    public static String convertStringtoPinyin(String r1) {
        return convertStringToPinyin(r1, false);
    }

    public static String convertStringtoPinyinLowercase(String r1) {
        return convertStringToPinyin(r1, true);
    }

    public static String convertStringToPinyin(String r9, boolean r10) {
        int r0 = r9.length();
        StringBuilder r1 = new StringBuilder();
        Collator r2 = Collator.getInstance(Locale.CHINA);
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L31;
        char r5 = r9.charAt(r4);
        if (isSimpleCharacter(r2, r5) == false) goto L7;
        r1.append(r5);
    L29:
        r4 = r4 + 1;
        goto L3
    L7:
        String r6 = Character.toString(r5);
        if (r2.compare(r6, FIRST_PINYIN_UNIHAN) != 0) goto L11;
        int r7 = 0;
    L14:
        if (r7 >= 0) goto L16;
        r7 = binarySearch(r2, r6, UNIHANS);
    L16:
        int r8 = 0;
    L17:
        byte[] r11 = PINYINS[r7];
        if (r8 >= r11.length) goto L29;
        byte r12 = r11[r8];
        if (r12 == 0) goto L29;
        char r13 = (char) r12;
        if (r10 == false) goto L28;
        if (r13 < 'A') goto L28;
        if (r13 > 'Z') goto L28;
        r13 = (char) (r13 + TokenParser.SP);
    L28:
        r1.append(r13);
        r8 = r8 + 1;
        goto L17
    L11:
        if (r2.compare(r6, LAST_PINYIN_UNIHAN) != 0) goto L13;
        r7 = UNIHANS.length - 1;
        goto L14
    L13:
        r7 = -1;
        goto L14
    L31:
        return r1.toString();
    }

    private static boolean isSimpleCharacter(Collator r2, char r3) {
        if (r3 >= 256) goto L5;
        return true;
    L5:
        String r4 = Character.toString(r3);
        if (r2.compare(r4, FIRST_PINYIN_UNIHAN) >= 0) goto L8;
        return true;
    L8:
        if (r2.compare(r4, LAST_PINYIN_UNIHAN) > 0) goto L13;
        return false;
    L13:
        return true;
    }

    private static int binarySearch(Collator r4, String r5, char[] r6) {
        int r0 = r6.length - 1;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r1 > r0) goto L10;
        r2 = (r1 + r0) / 2;
        r3 = r4.compare(r5, Character.toString(r6[r2]));
        if (r3 == 0) goto L10;
        if (r3 > 0) goto L8;
        r0 = r2 - 1;
        goto L3
    L8:
        r1 = r2 + 1;
    L10:
        if (r3 < 0) goto L12;
        return r2;
    L12:
        return r2 - 1;
    }

    public static String[] getMuiltPinyinChineseName(char r22) {
        switch(r22) {
            case 19975: goto L123;
            case 20048: goto L241;
            case 20102: goto L240;
            case 20146: goto L239;
            case 20160: goto L238;
            case 20167: goto L237;
            case 20250: goto L236;
            case 20256: goto L235;
            case 20271: goto L234;
            case 20284: goto L233;
            case 20315: goto L232;
            case 20415: goto L231;
            case 20447: goto L230;
            case 20457: goto L229;
            case 21032: goto L228;
            case 21049: goto L227;
            case 21066: goto L226;
            case 21093: goto L225;
            case 21170: goto L224;
            case 21202: goto L223;
            case 21273: goto L222;
            case 21306: goto L221;
            case 21333: goto L220;
            case 21340: goto L219;
            case 21345: goto L218;
            case 21442: goto L217;
            case 21505: goto L216;
            case 21523: goto L215;
            case 21602: goto L214;
            case 21644: goto L213;
            case 21654: goto L212;
            case 21679: goto L212;
            case 21683: goto L211;
            case 21693: goto L210;
            case 22204: goto L209;
            case 22280: goto L208;
            case 22475: goto L207;
            case 22622: goto L206;
            case 22771: goto L205;
            case 22823: goto L204;
            case 22855: goto L203;
            case 23487: goto L202;
            case 23561: goto L201;
            case 23615: goto L200;
            case 24046: goto L199;
            case 24230: goto L198;
            case 24377: goto L197;
            case 24378: goto L196;
            case 24471: goto L195;
            case 24694: goto L194;
            case 25166: goto L193;
            case 25170: goto L192;
            case 25273: goto L191;
            case 25299: goto L190;
            case 25303: goto L189;
            case 25321: goto L188;
            case 25552: goto L187;
            case 25874: goto L186;
            case 26366: goto L185;
            case 26397: goto L184;
            case 26415: goto L183;
            case 26420: goto L182;
            case 26441: goto L181;
            case 26597: goto L180;
            case 26657: goto L179;
            case 27103: goto L178;
            case 27169: goto L177;
            case 27575: goto L176;
            case 27667: goto L175;
            case 27795: goto L174;
            case 27809: goto L173;
            case 27850: goto L172;
            case 29087: goto L171;
            case 29226: goto L170;
            case 29279: goto L169;
            case 29575: goto L168;
            case 30044: goto L167;
            case 30111: goto L166;
            case 30340: goto L165;
            case 30422: goto L164;
            case 30427: goto L163;
            case 30465: goto L162;
            case 30528: goto L161;
            case 31109: goto L160;
            case 31216: goto L159;
            case 32473: goto L158;
            case 32554: goto L157;
            case 32735: goto L156;
            case 33071: goto L155;
            case 33152: goto L154;
            case 33261: goto L153;
            case 33394: goto L152;
            case 33564: goto L151;
            case 33853: goto L150;
            case 33879: goto L149;
            case 33882: goto L148;
            case 34067: goto L147;
            case 34255: goto L146;
            case 34532: goto L145;
            case 34880: goto L144;
            case 34892: goto L143;
            case 35273: goto L209;
            case 35282: goto L209;
            case 35299: goto L142;
            case 35828: goto L141;
            case 35835: goto L140;
            case 35841: goto L139;
            case 35843: goto L138;
            case 36711: goto L137;
            case 36767: goto L136;
            case 36824: goto L135;
            case 36843: goto L134;
            case 37027: goto L133;
            case 37117: goto L140;
            case 37325: goto L132;
            case 38271: goto L131;
            case 38463: goto L130;
            case 38477: goto L129;
            case 38551: goto L128;
            case 38592: goto L127;
            case 38706: goto L126;
            case 39534: goto L125;
            default: goto L4;
        };
    L4:
        return null;
    L125:
        return new String[]{"duo", "tuo"};
    L126:
        return new String[]{"lu", "lou"};
    L127:
        return new String[]{"que", "qiao"};
    L128:
        return new String[]{"wei", "kui"};
    L129:
        return new String[]{"jiang", "xiang"};
    L130:
        return new String[]{"a", "e"};
    L131:
        return new String[]{"chang", "zhang"};
    L132:
        return new String[]{"chong", "zhong"};
    L133:
        return new String[]{"na", "nei"};
    L134:
        return new String[]{"pai", "po"};
    L135:
        return new String[]{"hai", "huan"};
    L136:
        return new String[]{"bi", "pi"};
    L137:
        return new String[]{"ya", "zha"};
    L138:
        return new String[]{"diao", "tiao"};
    L139:
        return new String[]{"shui", "shei"};
    L140:
        return new String[]{"dou", "du"};
    L141:
        return new String[]{"shuo", "shui"};
    L142:
        return new String[]{"jie", "xie"};
    L143:
        return new String[]{"hang", "xing"};
    L144:
        return new String[]{"xie", "xue"};
    L145:
        return new String[]{"ge", "ha"};
    L146:
        return new String[]{"cang", "zang"};
    L147:
        return new String[]{"man", "wan"};
    L148:
        return new String[]{"ren", "shen"};
    L149:
        return new String[]{"zhu", "zhuo"};
    L150:
        return new String[]{"la", "luo"};
    L151:
        return new String[]{"xi", "qian"};
    L152:
        return new String[]{"se", "shai"};
    L153:
        return new String[]{"chou", "xiu"};
    L154:
        return new String[]{"bang", "pang"};
    L155:
        return new String[]{"pu", "fu"};
    L156:
        return new String[]{"di", "zhai"};
    L157:
        return new String[]{"miu", "miao"};
    L158:
        return new String[]{"gei", "ji"};
    L159:
        return new String[]{"chen", "cheng"};
    L160:
        return new String[]{"chan", "shan"};
    L161:
        return new String[]{"zhao", "zhuo", "zhe"};
    L162:
        return new String[]{"sheng", "xing"};
    L163:
        return new String[]{"cheng", "sheng"};
    L164:
        return new String[]{"gai", "ge"};
    L165:
        return new String[]{"de", "di"};
    L166:
        return new String[]{"nue", "yao"};
    L167:
        return new String[]{"chu", "xu"};
    L168:
        return new String[]{"lv", "shuai"};
    L169:
        return new String[]{"mu", "mou"};
    L170:
        return new String[]{"zhao", "zhua"};
    L171:
        return new String[]{"shu", "shou"};
    L172:
        return new String[]{"bo", "po"};
    L173:
        return new String[]{"mei", "mo"};
    L174:
        return new String[]{"da", "ta"};
    L175:
        return new String[]{"mang", "meng"};
    L176:
        return new String[]{"yan", "yin"};
    L177:
        return new String[]{"mo", "mu"};
    L178:
        return new String[]{"bing", "bin"};
    L179:
        return new String[]{"xiao", "jiao"};
    L180:
        return new String[]{"cha", "zha"};
    L181:
        return new String[]{"sha", "shan"};
    L182:
        return new String[]{"pu", "piao"};
    L183:
        return new String[]{"shu", "zhu"};
    L184:
        return new String[]{"chao", "zhao"};
    L185:
        return new String[]{"ceng", "zeng"};
    L186:
        return new String[]{"chuan", "zan"};
    L187:
        return new String[]{"ti", "di"};
    L188:
        return new String[]{"ze", "zhai"};
    L189:
        return new String[]{"ao", "niu"};
    L190:
        return new String[]{"ta", "tuo"};
    L191:
        return new String[]{"ma", "mo"};
    L192:
        return new String[]{"ba", "pa"};
    L193:
        return new String[]{"zha", "za"};
    L194:
        return new String[]{"wu", "e"};
    L195:
        return new String[]{"de", "dei"};
    L196:
        return new String[]{"jiang", "qiang"};
    L197:
        return new String[]{"dan", "tan"};
    L198:
        return new String[]{"du", "duo"};
    L199:
        return new String[]{"cha", "chai"};
    L200:
        return new String[]{"niao", "sui"};
    L201:
        return new String[]{"wei", "yu"};
    L202:
        return new String[]{"su", "xiu"};
    L203:
        return new String[]{"ji", "qi"};
    L204:
        return new String[]{"da", "dai"};
    L205:
        return new String[]{"ke", "qiao"};
    L206:
        return new String[]{"sai", "se"};
    L207:
        return new String[]{"mai", "man"};
    L208:
        return new String[]{"quan", "juan"};
    L209:
        return new String[]{"jiao", "jue"};
    L210:
        return new String[]{"yan", "ye"};
    L211:
        return new String[]{"hai", "ke"};
    L212:
        return new String[]{"ge", "ka"};
    L213:
        return new String[]{"he", "huo"};
    L214:
        return new String[]{"ne", "ni"};
    L215:
        return new String[]{"xia", "he"};
    L216:
        return new String[]{"yu", "xu"};
    L217:
        return new String[]{"can", "shen"};
    L218:
        return new String[]{"ka", "qia"};
    L219:
        return new String[]{"bo", "bu"};
    L220:
        return new String[]{"dan", "shan"};
    L221:
        return new String[]{"qu", "ou"};
    L222:
        return new String[]{"chi", "shi"};
    L223:
        return new String[]{"le", "lei"};
    L224:
        return new String[]{"jin", "jing"};
    L225:
        return new String[]{"bo", "bao"};
    L226:
        return new String[]{"xiao", "xue"};
    L227:
        return new String[]{"cha", "sha"};
    L228:
        return new String[]{"bao", "pao"};
    L229:
        return new String[]{"lia", "liang"};
    L230:
        return new String[]{"qi", "si"};
    L231:
        return new String[]{"bian", "pian"};
    L232:
        return new String[]{"fo", "fu"};
    L233:
        return new String[]{"si", "shi"};
    L234:
        return new String[]{"bo", "bai"};
    L235:
        return new String[]{"chuan", "zhuan"};
    L236:
        return new String[]{"hui", "kuai"};
    L237:
        return new String[]{"chou", "qiu"};
    L238:
        return new String[]{"shen", "shi"};
    L239:
        return new String[]{"qin", "qing"};
    L240:
        return new String[]{"liao", "le"};
    L241:
        return new String[]{"le", "yue"};
    L123:
        return new String[]{"wan", "mo"};
    }

    public static boolean isChinese(String r5) {
        if (TextUtils.isEmpty(r5) == true) goto L22;
        int r0 = r5.length();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L22;
        Character.UnicodeBlock r3 = Character.UnicodeBlock.of(r5.charAt(r2));
        if (r3 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) goto L20;
        if (r3 == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) goto L30;
        if (r3 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) goto L31;
        if (r3 == Character.UnicodeBlock.GENERAL_PUNCTUATION) goto L32;
        if (r3 == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) goto L33;
        if (r3 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) goto L34;
        r2 = r2 + 1;
        goto L5
    L34:
        return true;
    L33:
        return true;
    L32:
        return true;
    L31:
        return true;
    L30:
        return true;
    L20:
        return true;
    L22:
        return false;
    }

    static {
        UNIHANS = new char[]{38463, 21710, 23433, 32942, 20985, 20843, 25344, 25203, 37030, 21241, 38466, 22868, 20283, 23620, 36793, 28780, 24971, 27715, 20907, 30326, 23788, 22163, 20594, 21442, 20179, 25761, 20874, 23934, 26365, 26366, 23652, 21449, 33414, 36799, 20261, 25220, 36710, 25275, 27784, 27785, 38455, 21507, 20805, 25277, 20986, 27451, 25571, 24027, 20997, 21561, 26110, 36916, 21618, 21254, 20945, 31895, 27718, 23828, 37032, 25619, 21649, 21574, 20025, 24403, 20992, 22042, 25189, 28783, 27664, 30008, 20993, 29241, 22002, 19969, 19999, 19996, 21562, 21438, 32785, 35176, 21544, 22810, 22968, 35830, 22848, 38821, 20799, 21457, 24070, 21274, 39134, 20998, 20016, 35205, 20175, 32017, 20245, 26094, 20357, 29976, 20872, 30347, 25096, 32473, 26681, 21039, 24037, 21246, 20272, 29916, 20054, 20851, 20809, 24402, 20008, 21593, 21704, 21645, 20292, 22831, 33568, 35779, 40658, 25323, 20136, 22135, 21503, 40769, 20079, 33457, 24576, 29375, 24031, 28784, 26127, 21529, 19980, 21152, 25099, 27743, 33405, 38454, 24062, 22357, 20866, 20009, 20965, 23010, 22104, 20891, 21652, 24320, 21002, 24572, 23611, 21308, 32910, 21157, 31354, 25248, 25181, 22840, 33967, 23485, 21281, 20111, 22372, 25193, 22403, 26469, 20848, 21879, 25438, 32907, 21202, 23834, 21013, 20457, 22849, 33391, 25769, 21015, 25294, 21026, 28316, 22230, 40857, 30620, 22108, 23048, 30055, 25249, 32599, 21603, 22920, 22475, 23258, 29284, 29483, 20040, 21573, 38376, 30015, 21674, 23424, 21941, 20060, 27665, 21517, 35884, 25720, 21726, 27626, 21999, 25295, 33097, 22241, 22228, 23404, 30098, 23070, 24641, 33021, 22958, 25288, 23330, 40479, 25423, 22236, 23425, 22942, 20892, 32698, 22900, 22907, 30111, 40641, 37069, 21908, 35764, 22929, 25293, 30469, 20051, 25243, 21624, 21943, 21257, 19989, 22248, 21117, 27669, 23000, 20050, 38027, 21078, 20166, 19971, 25488, 21315, 21595, 24708, 30335, 20146, 38738, 33422, 19992, 21306, 23761, 32570, 22795, 21605, 31331, 23046, 24825, 20154, 25172, 26085, 33592, 21433, 37018, 25404, 22567, 23121, 30628, 25468, 20200, 27618, 19977, 26706, 25531, 38314, 26862, 20711, 26432, 31579, 23665, 20260, 24368, 22882, 30003, 33688, 25938, 21319, 23608, 21454, 20070, 21047, 34928, 38377, 21452, 35841, 21550, 35828, 21430, 24554, 25436, 33487, 29435, 22794, 23385, 21766, 20182, 22268, 22349, 27748, 22834, 24529, 29093, 21076, 22825, 26091, 24086, 21381, 22258, 20599, 20984, 28237, 25512, 21534, 20039, 31349, 27498, 24367, 23587, 21361, 26167, 32705, 25373, 20044, 22805, 34418, 20186, 20065, 28785, 20123, 24515, 26143, 20982, 20241, 21505, 21509, 21066, 22339, 20011, 24697, 22830, 24186, 20539, 19968, 22233, 24212, 21727, 20323, 20248, 25180, 22246, 26352, 26197, 31584, 31612, 24064, 28797, 20802, 21288, 20654, 21017, 36156, 24590, 22679, 25166, 25434, 27838, 24352, 38271, 38263, 20299, 34567, 36126, 20105, 20043, 23769, 24226, 20013, 24030, 26417, 25235, 25341, 19987, 22918, 38585, 23442, 21331, 20082, 23447, 37049, 31199, 38075, 21404, 23562, 26152, 20825, 40899, 40900};
        PINYINS = new byte[][]{new byte[]{65, 0, 0, 0, 0, 0}, new byte[]{65, 73, 0, 0, 0, 0}, new byte[]{65, 78, 0, 0, 0, 0}, new byte[]{65, 78, 71, 0, 0, 0}, new byte[]{65, 79, 0, 0, 0, 0}, new byte[]{66, 65, 0, 0, 0, 0}, new byte[]{66, 65, 73, 0, 0, 0}, new byte[]{66, 65, 78, 0, 0, 0}, new byte[]{66, 65, 78, 71, 0, 0}, new byte[]{66, 65, 79, 0, 0, 0}, new byte[]{66, 69, 73, 0, 0, 0}, new byte[]{66, 69, 78, 0, 0, 0}, new byte[]{66, 69, 78, 71, 0, 0}, new byte[]{66, 73, 0, 0, 0, 0}, new byte[]{66, 73, 65, 78, 0, 0}, new byte[]{66, 73, 65, 79, 0, 0}, new byte[]{66, 73, 69, 0, 0, 0}, new byte[]{66, 73, 78, 0, 0, 0}, new byte[]{66, 73, 78, 71, 0, 0}, new byte[]{66, 79, 0, 0, 0, 0}, new byte[]{66, 85, 0, 0, 0, 0}, new byte[]{67, 65, 0, 0, 0, 0}, new byte[]{67, 65, 73, 0, 0, 0}, new byte[]{67, 65, 78, 0, 0, 0}, new byte[]{67, 65, 78, 71, 0, 0}, new byte[]{67, 65, 79, 0, 0, 0}, new byte[]{67, 69, 0, 0, 0, 0}, new byte[]{67, 69, 78, 0, 0, 0}, new byte[]{67, 69, 78, 71, 0, 0}, new byte[]{90, 69, 78, 71, 0, 0}, new byte[]{67, 69, 78, 71, 0, 0}, new byte[]{67, 72, 65, 0, 0, 0}, new byte[]{67, 72, 65, 73, 0, 0}, new byte[]{67, 72, 65, 78, 0, 0}, new byte[]{67, 72, 65, 78, 71, 0}, new byte[]{67, 72, 65, 79, 0, 0}, new byte[]{67, 72, 69, 0, 0, 0}, new byte[]{67, 72, 69, 78, 0, 0}, new byte[]{83, 72, 69, 78, 0, 0}, new byte[]{67, 72, 69, 78, 0, 0}, new byte[]{67, 72, 69, 78, 71, 0}, new byte[]{67, 72, 73, 0, 0, 0}, new byte[]{67, 72, 79, 78, 71, 0}, new byte[]{67, 72, 79, 85, 0, 0}, new byte[]{67, 72, 85, 0, 0, 0}, new byte[]{67, 72, 85, 65, 0, 0}, new byte[]{67, 72, 85, 65, 73, 0}, new byte[]{67, 72, 85, 65, 78, 0}, new byte[]{67, 72, 85, 65, 78, 71}, new byte[]{67, 72, 85, 73, 0, 0}, new byte[]{67, 72, 85, 78, 0, 0}, new byte[]{67, 72, 85, 79, 0, 0}, new byte[]{67, 73, 0, 0, 0, 0}, new byte[]{67, 79, 78, 71, 0, 0}, new byte[]{67, 79, 85, 0, 0, 0}, new byte[]{67, 85, 0, 0, 0, 0}, new byte[]{67, 85, 65, 78, 0, 0}, new byte[]{67, 85, 73, 0, 0, 0}, new byte[]{67, 85, 78, 0, 0, 0}, new byte[]{67, 85, 79, 0, 0, 0}, new byte[]{68, 65, 0, 0, 0, 0}, new byte[]{68, 65, 73, 0, 0, 0}, new byte[]{68, 65, 78, 0, 0, 0}, new byte[]{68, 65, 78, 71, 0, 0}, new byte[]{68, 65, 79, 0, 0, 0}, new byte[]{68, 69, 0, 0, 0, 0}, new byte[]{68, 69, 78, 0, 0, 0}, new byte[]{68, 69, 78, 71, 0, 0}, new byte[]{68, 73, 0, 0, 0, 0}, new byte[]{68, 73, 65, 0, 0, 0}, new byte[]{68, 73, 65, 78, 0, 0}, new byte[]{68, 73, 65, 79, 0, 0}, new byte[]{68, 73, 69, 0, 0, 0}, new byte[]{68, 73, 78, 71, 0, 0}, new byte[]{68, 73, 85, 0, 0, 0}, new byte[]{68, 79, 78, 71, 0, 0}, new byte[]{68, 79, 85, 0, 0, 0}, new byte[]{68, 85, 0, 0, 0, 0}, new byte[]{68, 85, 65, 78, 0, 0}, new byte[]{68, 85, 73, 0, 0, 0}, new byte[]{68, 85, 78, 0, 0, 0}, new byte[]{68, 85, 79, 0, 0, 0}, new byte[]{69, 0, 0, 0, 0, 0}, new byte[]{69, 73, 0, 0, 0, 0}, new byte[]{69, 78, 0, 0, 0, 0}, new byte[]{69, 78, 71, 0, 0, 0}, new byte[]{69, 82, 0, 0, 0, 0}, new byte[]{70, 65, 0, 0, 0, 0}, new byte[]{70, 65, 78, 0, 0, 0}, new byte[]{70, 65, 78, 71, 0, 0}, new byte[]{70, 69, 73, 0, 0, 0}, new byte[]{70, 69, 78, 0, 0, 0}, new byte[]{70, 69, 78, 71, 0, 0}, new byte[]{70, 73, 65, 79, 0, 0}, new byte[]{70, 79, 0, 0, 0, 0}, new byte[]{70, 79, 85, 0, 0, 0}, new byte[]{70, 85, 0, 0, 0, 0}, new byte[]{71, 65, 0, 0, 0, 0}, new byte[]{71, 65, 73, 0, 0, 0}, new byte[]{71, 65, 78, 0, 0, 0}, new byte[]{71, 65, 78, 71, 0, 0}, new byte[]{71, 65, 79, 0, 0, 0}, new byte[]{71, 69, 0, 0, 0, 0}, new byte[]{71, 69, 73, 0, 0, 0}, new byte[]{71, 69, 78, 0, 0, 0}, new byte[]{71, 69, 78, 71, 0, 0}, new byte[]{71, 79, 78, 71, 0, 0}, new byte[]{71, 79, 85, 0, 0, 0}, new byte[]{71, 85, 0, 0, 0, 0}, new byte[]{71, 85, 65, 0, 0, 0}, new byte[]{71, 85, 65, 73, 0, 0}, new byte[]{71, 85, 65, 78, 0, 0}, new byte[]{71, 85, 65, 78, 71, 0}, new byte[]{71, 85, 73, 0, 0, 0}, new byte[]{71, 85, 78, 0, 0, 0}, new byte[]{71, 85, 79, 0, 0, 0}, new byte[]{72, 65, 0, 0, 0, 0}, new byte[]{72, 65, 73, 0, 0, 0}, new byte[]{72, 65, 78, 0, 0, 0}, new byte[]{72, 65, 78, 71, 0, 0}, new byte[]{72, 65, 79, 0, 0, 0}, new byte[]{72, 69, 0, 0, 0, 0}, new byte[]{72, 69, 73, 0, 0, 0}, new byte[]{72, 69, 78, 0, 0, 0}, new byte[]{72, 69, 78, 71, 0, 0}, new byte[]{72, 77, 0, 0, 0, 0}, new byte[]{72, 79, 78, 71, 0, 0}, new byte[]{72, 79, 85, 0, 0, 0}, new byte[]{72, 85, 0, 0, 0, 0}, new byte[]{72, 85, 65, 0, 0, 0}, new byte[]{72, 85, 65, 73, 0, 0}, new byte[]{72, 85, 65, 78, 0, 0}, new byte[]{72, 85, 65, 78, 71, 0}, new byte[]{72, 85, 73, 0, 0, 0}, new byte[]{72, 85, 78, 0, 0, 0}, new byte[]{72, 85, 79, 0, 0, 0}, new byte[]{74, 73, 0, 0, 0, 0}, new byte[]{74, 73, 65, 0, 0, 0}, new byte[]{74, 73, 65, 78, 0, 0}, new byte[]{74, 73, 65, 78, 71, 0}, new byte[]{74, 73, 65, 79, 0, 0}, new byte[]{74, 73, 69, 0, 0, 0}, new byte[]{74, 73, 78, 0, 0, 0}, new byte[]{74, 73, 78, 71, 0, 0}, new byte[]{74, 73, 79, 78, 71, 0}, new byte[]{74, 73, 85, 0, 0, 0}, new byte[]{74, 85, 0, 0, 0, 0}, new byte[]{74, 85, 65, 78, 0, 0}, new byte[]{74, 85, 69, 0, 0, 0}, new byte[]{74, 85, 78, 0, 0, 0}, new byte[]{75, 65, 0, 0, 0, 0}, new byte[]{75, 65, 73, 0, 0, 0}, new byte[]{75, 65, 78, 0, 0, 0}, new byte[]{75, 65, 78, 71, 0, 0}, new byte[]{75, 65, 79, 0, 0, 0}, new byte[]{75, 69, 0, 0, 0, 0}, new byte[]{75, 69, 78, 0, 0, 0}, new byte[]{75, 69, 78, 71, 0, 0}, new byte[]{75, 79, 78, 71, 0, 0}, new byte[]{75, 79, 85, 0, 0, 0}, new byte[]{75, 85, 0, 0, 0, 0}, new byte[]{75, 85, 65, 0, 0, 0}, new byte[]{75, 85, 65, 73, 0, 0}, new byte[]{75, 85, 65, 78, 0, 0}, new byte[]{75, 85, 65, 78, 71, 0}, new byte[]{75, 85, 73, 0, 0, 0}, new byte[]{75, 85, 78, 0, 0, 0}, new byte[]{75, 85, 79, 0, 0, 0}, new byte[]{76, 65, 0, 0, 0, 0}, new byte[]{76, 65, 73, 0, 0, 0}, new byte[]{76, 65, 78, 0, 0, 0}, new byte[]{76, 65, 78, 71, 0, 0}, new byte[]{76, 65, 79, 0, 0, 0}, new byte[]{76, 69, 0, 0, 0, 0}, new byte[]{76, 69, 73, 0, 0, 0}, new byte[]{76, 69, 78, 71, 0, 0}, new byte[]{76, 73, 0, 0, 0, 0}, new byte[]{76, 73, 65, 0, 0, 0}, new byte[]{76, 73, 65, 78, 0, 0}, new byte[]{76, 73, 65, 78, 71, 0}, new byte[]{76, 73, 65, 79, 0, 0}, new byte[]{76, 73, 69, 0, 0, 0}, new byte[]{76, 73, 78, 0, 0, 0}, new byte[]{76, 73, 78, 71, 0, 0}, new byte[]{76, 73, 85, 0, 0, 0}, new byte[]{76, 79, 0, 0, 0, 0}, new byte[]{76, 79, 78, 71, 0, 0}, new byte[]{76, 79, 85, 0, 0, 0}, new byte[]{76, 85, 0, 0, 0, 0}, new byte[]{76, 85, 65, 78, 0, 0}, new byte[]{76, 85, 69, 0, 0, 0}, new byte[]{76, 85, 78, 0, 0, 0}, new byte[]{76, 85, 79, 0, 0, 0}, new byte[]{77, 0, 0, 0, 0, 0}, new byte[]{77, 65, 0, 0, 0, 0}, new byte[]{77, 65, 73, 0, 0, 0}, new byte[]{77, 65, 78, 0, 0, 0}, new byte[]{77, 65, 78, 71, 0, 0}, new byte[]{77, 65, 79, 0, 0, 0}, new byte[]{77, 69, 0, 0, 0, 0}, new byte[]{77, 69, 73, 0, 0, 0}, new byte[]{77, 69, 78, 0, 0, 0}, new byte[]{77, 69, 78, 71, 0, 0}, new byte[]{77, 73, 0, 0, 0, 0}, new byte[]{77, 73, 65, 78, 0, 0}, new byte[]{77, 73, 65, 79, 0, 0}, new byte[]{77, 73, 69, 0, 0, 0}, new byte[]{77, 73, 78, 0, 0, 0}, new byte[]{77, 73, 78, 71, 0, 0}, new byte[]{77, 73, 85, 0, 0, 0}, new byte[]{77, 79, 0, 0, 0, 0}, new byte[]{77, 79, 85, 0, 0, 0}, new byte[]{77, 85, 0, 0, 0, 0}, new byte[]{78, 0, 0, 0, 0, 0}, new byte[]{78, 65, 0, 0, 0, 0}, new byte[]{78, 65, 73, 0, 0, 0}, new byte[]{78, 65, 78, 0, 0, 0}, new byte[]{78, 65, 78, 71, 0, 0}, new byte[]{78, 65, 79, 0, 0, 0}, new byte[]{78, 69, 0, 0, 0, 0}, new byte[]{78, 69, 73, 0, 0, 0}, new byte[]{78, 69, 78, 0, 0, 0}, new byte[]{78, 69, 78, 71, 0, 0}, new byte[]{78, 73, 0, 0, 0, 0}, new byte[]{78, 73, 65, 78, 0, 0}, new byte[]{78, 73, 65, 78, 71, 0}, new byte[]{78, 73, 65, 79, 0, 0}, new byte[]{78, 73, 69, 0, 0, 0}, new byte[]{78, 73, 78, 0, 0, 0}, new byte[]{78, 73, 78, 71, 0, 0}, new byte[]{78, 73, 85, 0, 0, 0}, new byte[]{78, 79, 78, 71, 0, 0}, new byte[]{78, 79, 85, 0, 0, 0}, new byte[]{78, 85, 0, 0, 0, 0}, new byte[]{78, 85, 65, 78, 0, 0}, new byte[]{78, 85, 69, 0, 0, 0}, new byte[]{78, 85, 78, 0, 0, 0}, new byte[]{78, 85, 79, 0, 0, 0}, new byte[]{79, 0, 0, 0, 0, 0}, new byte[]{79, 85, 0, 0, 0, 0}, new byte[]{80, 65, 0, 0, 0, 0}, new byte[]{80, 65, 73, 0, 0, 0}, new byte[]{80, 65, 78, 0, 0, 0}, new byte[]{80, 65, 78, 71, 0, 0}, new byte[]{80, 65, 79, 0, 0, 0}, new byte[]{80, 69, 73, 0, 0, 0}, new byte[]{80, 69, 78, 0, 0, 0}, new byte[]{80, 69, 78, 71, 0, 0}, new byte[]{80, 73, 0, 0, 0, 0}, new byte[]{80, 73, 65, 78, 0, 0}, new byte[]{80, 73, 65, 79, 0, 0}, new byte[]{80, 73, 69, 0, 0, 0}, new byte[]{80, 73, 78, 0, 0, 0}, new byte[]{80, 73, 78, 71, 0, 0}, new byte[]{80, 79, 0, 0, 0, 0}, new byte[]{80, 79, 85, 0, 0, 0}, new byte[]{80, 85, 0, 0, 0, 0}, new byte[]{81, 73, 0, 0, 0, 0}, new byte[]{81, 73, 65, 0, 0, 0}, new byte[]{81, 73, 65, 78, 0, 0}, new byte[]{81, 73, 65, 78, 71, 0}, new byte[]{81, 73, 65, 79, 0, 0}, new byte[]{81, 73, 69, 0, 0, 0}, new byte[]{81, 73, 78, 0, 0, 0}, new byte[]{81, 73, 78, 71, 0, 0}, new byte[]{81, 73, 79, 78, 71, 0}, new byte[]{81, 73, 85, 0, 0, 0}, new byte[]{81, 85, 0, 0, 0, 0}, new byte[]{81, 85, 65, 78, 0, 0}, new byte[]{81, 85, 69, 0, 0, 0}, new byte[]{81, 85, 78, 0, 0, 0}, new byte[]{82, 65, 78, 0, 0, 0}, new byte[]{82, 65, 78, 71, 0, 0}, new byte[]{82, 65, 79, 0, 0, 0}, new byte[]{82, 69, 0, 0, 0, 0}, new byte[]{82, 69, 78, 0, 0, 0}, new byte[]{82, 69, 78, 71, 0, 0}, new byte[]{82, 73, 0, 0, 0, 0}, new byte[]{82, 79, 78, 71, 0, 0}, new byte[]{82, 79, 85, 0, 0, 0}, new byte[]{82, 85, 0, 0, 0, 0}, new byte[]{82, 85, 65, 0, 0, 0}, new byte[]{82, 85, 65, 78, 0, 0}, new byte[]{82, 85, 73, 0, 0, 0}, new byte[]{82, 85, 78, 0, 0, 0}, new byte[]{82, 85, 79, 0, 0, 0}, new byte[]{83, 65, 0, 0, 0, 0}, new byte[]{83, 65, 73, 0, 0, 0}, new byte[]{83, 65, 78, 0, 0, 0}, new byte[]{83, 65, 78, 71, 0, 0}, new byte[]{83, 65, 79, 0, 0, 0}, new byte[]{83, 69, 0, 0, 0, 0}, new byte[]{83, 69, 78, 0, 0, 0}, new byte[]{83, 69, 78, 71, 0, 0}, new byte[]{83, 72, 65, 0, 0, 0}, new byte[]{83, 72, 65, 73, 0, 0}, new byte[]{83, 72, 65, 78, 0, 0}, new byte[]{83, 72, 65, 78, 71, 0}, new byte[]{83, 72, 65, 79, 0, 0}, new byte[]{83, 72, 69, 0, 0, 0}, new byte[]{83, 72, 69, 78, 0, 0}, new byte[]{88, 73, 78, 0, 0, 0}, new byte[]{83, 72, 69, 78, 0, 0}, new byte[]{83, 72, 69, 78, 71, 0}, new byte[]{83, 72, 73, 0, 0, 0}, new byte[]{83, 72, 79, 85, 0, 0}, new byte[]{83, 72, 85, 0, 0, 0}, new byte[]{83, 72, 85, 65, 0, 0}, new byte[]{83, 72, 85, 65, 73, 0}, new byte[]{83, 72, 85, 65, 78, 0}, new byte[]{83, 72, 85, 65, 78, 71}, new byte[]{83, 72, 85, 73, 0, 0}, new byte[]{83, 72, 85, 78, 0, 0}, new byte[]{83, 72, 85, 79, 0, 0}, new byte[]{83, 73, 0, 0, 0, 0}, new byte[]{83, 79, 78, 71, 0, 0}, new byte[]{83, 79, 85, 0, 0, 0}, new byte[]{83, 85, 0, 0, 0, 0}, new byte[]{83, 85, 65, 78, 0, 0}, new byte[]{83, 85, 73, 0, 0, 0}, new byte[]{83, 85, 78, 0, 0, 0}, new byte[]{83, 85, 79, 0, 0, 0}, new byte[]{84, 65, 0, 0, 0, 0}, new byte[]{84, 65, 73, 0, 0, 0}, new byte[]{84, 65, 78, 0, 0, 0}, new byte[]{84, 65, 78, 71, 0, 0}, new byte[]{84, 65, 79, 0, 0, 0}, new byte[]{84, 69, 0, 0, 0, 0}, new byte[]{84, 69, 78, 71, 0, 0}, new byte[]{84, 73, 0, 0, 0, 0}, new byte[]{84, 73, 65, 78, 0, 0}, new byte[]{84, 73, 65, 79, 0, 0}, new byte[]{84, 73, 69, 0, 0, 0}, new byte[]{84, 73, 78, 71, 0, 0}, new byte[]{84, 79, 78, 71, 0, 0}, new byte[]{84, 79, 85, 0, 0, 0}, new byte[]{84, 85, 0, 0, 0, 0}, new byte[]{84, 85, 65, 78, 0, 0}, new byte[]{84, 85, 73, 0, 0, 0}, new byte[]{84, 85, 78, 0, 0, 0}, new byte[]{84, 85, 79, 0, 0, 0}, new byte[]{87, 65, 0, 0, 0, 0}, new byte[]{87, 65, 73, 0, 0, 0}, new byte[]{87, 65, 78, 0, 0, 0}, new byte[]{87, 65, 78, 71, 0, 0}, new byte[]{87, 69, 73, 0, 0, 0}, new byte[]{87, 69, 78, 0, 0, 0}, new byte[]{87, 69, 78, 71, 0, 0}, new byte[]{87, 79, 0, 0, 0, 0}, new byte[]{87, 85, 0, 0, 0, 0}, new byte[]{88, 73, 0, 0, 0, 0}, new byte[]{88, 73, 65, 0, 0, 0}, new byte[]{88, 73, 65, 78, 0, 0}, new byte[]{88, 73, 65, 78, 71, 0}, new byte[]{88, 73, 65, 79, 0, 0}, new byte[]{88, 73, 69, 0, 0, 0}, new byte[]{88, 73, 78, 0, 0, 0}, new byte[]{88, 73, 78, 71, 0, 0}, new byte[]{88, 73, 79, 78, 71, 0}, new byte[]{88, 73, 85, 0, 0, 0}, new byte[]{88, 85, 0, 0, 0, 0}, new byte[]{88, 85, 65, 78, 0, 0}, new byte[]{88, 85, 69, 0, 0, 0}, new byte[]{88, 85, 78, 0, 0, 0}, new byte[]{89, 65, 0, 0, 0, 0}, new byte[]{89, 65, 78, 0, 0, 0}, new byte[]{89, 65, 78, 71, 0, 0}, new byte[]{89, 65, 79, 0, 0, 0}, new byte[]{89, 69, 0, 0, 0, 0}, new byte[]{89, 73, 0, 0, 0, 0}, new byte[]{89, 73, 78, 0, 0, 0}, new byte[]{89, 73, 78, 71, 0, 0}, new byte[]{89, 79, 0, 0, 0, 0}, new byte[]{89, 79, 78, 71, 0, 0}, new byte[]{89, 79, 85, 0, 0, 0}, new byte[]{89, 85, 0, 0, 0, 0}, new byte[]{89, 85, 65, 78, 0, 0}, new byte[]{89, 85, 69, 0, 0, 0}, new byte[]{89, 85, 78, 0, 0, 0}, new byte[]{74, 85, 78, 0, 0, 0}, new byte[]{89, 85, 78, 0, 0, 0}, new byte[]{90, 65, 0, 0, 0, 0}, new byte[]{90, 65, 73, 0, 0, 0}, new byte[]{90, 65, 78, 0, 0, 0}, new byte[]{90, 65, 78, 71, 0, 0}, new byte[]{90, 65, 79, 0, 0, 0}, new byte[]{90, 69, 0, 0, 0, 0}, new byte[]{90, 69, 73, 0, 0, 0}, new byte[]{90, 69, 78, 0, 0, 0}, new byte[]{90, 69, 78, 71, 0, 0}, new byte[]{90, 72, 65, 0, 0, 0}, new byte[]{90, 72, 65, 73, 0, 0}, new byte[]{90, 72, 65, 78, 0, 0}, new byte[]{90, 72, 65, 78, 71, 0}, new byte[]{67, 72, 65, 78, 71, 0}, new byte[]{90, 72, 65, 78, 71, 0}, new byte[]{90, 72, 65, 79, 0, 0}, new byte[]{90, 72, 69, 0, 0, 0}, new byte[]{90, 72, 69, 78, 0, 0}, new byte[]{90, 72, 69, 78, 71, 0}, new byte[]{90, 72, 73, 0, 0, 0}, new byte[]{83, 72, 73, 0, 0, 0}, new byte[]{90, 72, 73, 0, 0, 0}, new byte[]{90, 72, 79, 78, 71, 0}, new byte[]{90, 72, 79, 85, 0, 0}, new byte[]{90, 72, 85, 0, 0, 0}, new byte[]{90, 72, 85, 65, 0, 0}, new byte[]{90, 72, 85, 65, 73, 0}, new byte[]{90, 72, 85, 65, 78, 0}, new byte[]{90, 72, 85, 65, 78, 71}, new byte[]{90, 72, 85, 73, 0, 0}, new byte[]{90, 72, 85, 78, 0, 0}, new byte[]{90, 72, 85, 79, 0, 0}, new byte[]{90, 73, 0, 0, 0, 0}, new byte[]{90, 79, 78, 71, 0, 0}, new byte[]{90, 79, 85, 0, 0, 0}, new byte[]{90, 85, 0, 0, 0, 0}, new byte[]{90, 85, 65, 78, 0, 0}, new byte[]{90, 85, 73, 0, 0, 0}, new byte[]{90, 85, 78, 0, 0, 0}, new byte[]{90, 85, 79, 0, 0, 0}, new byte[]{0, 0, 0, 0, 0, 0}, new byte[]{83, 72, 65, 78, 0, 0}, new byte[]{0, 0, 0, 0, 0, 0}};
    }
}
