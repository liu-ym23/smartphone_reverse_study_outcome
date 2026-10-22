package org.apache.commons.io;

import com.android.settings.ApnEditor;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: classes6.dex */
public class FilenameUtils {
    private static final char EXTENSION_SEPARATOR = '.';
    private static final char OTHER_SEPARATOR = 0;
    private static final char SYSTEM_SEPARATOR = 0;
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    private static boolean isSeparator(char r1) {
        if (r1 != '/') goto L5;
    L8:
        return true;
    L5:
        if (r1 == '\\') goto L8;
        return false;
    }

    static {
        SYSTEM_SEPARATOR = File.separatorChar;
        if (isSystemWindows() == false) goto L5;
        OTHER_SEPARATOR = '/';
        return;
    L5:
        OTHER_SEPARATOR = '\\';
    }

    public FilenameUtils() {
    }

    static boolean isSystemWindows() {
        if (SYSTEM_SEPARATOR != '\\') goto L5;
        return true;
    L5:
        return false;
    }

    public static String normalize(String r1) {
        return doNormalize(r1, true);
    }

    public static String normalizeNoEndSeparator(String r1) {
        return doNormalize(r1, false);
    }

    private static String doNormalize(String r14, boolean r15) {
        if (r14 != null) goto L5;
        return null;
    L5:
        int r1 = r14.length();
        if (r1 != 0) goto L8;
        return r14;
    L8:
        int r2 = getPrefixLength(r14);
        if (r2 >= 0) goto L11;
        return null;
    L11:
        int r3 = r1 + 2;
        char[] r4 = new char[r3];
        r14.getChars(0, r14.length(), r4, 0);
        int r16 = 0;
    L12:
        if (r16 >= r3) goto L17;
        if (r4[r16] != OTHER_SEPARATOR) goto L16;
        r4[r16] = SYSTEM_SEPARATOR;
    L16:
        r16 = r16 + 1;
        goto L12
    L17:
        char r17 = r4[r1 - 1];
        char r5 = SYSTEM_SEPARATOR;
        if (r17 == r5) goto L20;
        r4[r1] = r5;
        r1 = r1 + 1;
        boolean r18 = false;
    L21:
        int r6 = r2 + 1;
        int r7 = r6;
    L22:
        if (r7 >= r1) goto L29;
        char r8 = r4[r7];
        char r9 = SYSTEM_SEPARATOR;
        if (r8 != r9) goto L28;
        int r10 = r7 - 1;
        if (r4[r10] != r9) goto L28;
        System.arraycopy(r4, r7, r4, r10, r1 - r7);
        r1 = r1 - 1;
        r7 = r7 - 1;
    L28:
        r7 = r7 + 1;
        goto L22
    L29:
        int r11 = r6;
    L31:
        if (r11 >= r1) goto L44;
        char r12 = r4[r11];
        char r13 = SYSTEM_SEPARATOR;
        if (r12 != r13) goto L43;
        int r19 = r11 - 1;
        if (r4[r19] != '.') goto L43;
        if (r11 == r6) goto L40;
        if (r4[r11 - 2] != r13) goto L43;
    L40:
        if (r11 != (r1 - 1)) goto L42;
        r18 = true;
    L42:
        System.arraycopy(r4, r11 + 1, r4, r19, r1 - r11);
        r1 = r1 - 2;
        r11 = r11 - 1;
    L43:
        r11 = r11 + 1;
        goto L31
    L44:
        int r20 = r2 + 2;
        int r21 = r20;
    L45:
        if (r21 >= r1) goto L68;
        char r110 = r4[r21];
        char r111 = SYSTEM_SEPARATOR;
        if (r110 != r111) goto L67;
        if (r4[r21 - 1] != '.') goto L67;
        if (r4[r21 - 2] != '.') goto L67;
        if (r21 != r20) goto L54;
    L55:
        if (r21 == r20) goto L56;
        if (r21 != (r1 - 1)) goto L60;
        r18 = true;
    L60:
        int r112 = r21 - 4;
    L61:
        if (r112 < r2) goto L66;
        if (r4[r112] == SYSTEM_SEPARATOR) goto L64;
        r112 = r112 - 1;
        goto L61
    L64:
        int r113 = r112 + 1;
        System.arraycopy(r4, r21 + 1, r4, r113, r1 - r21);
        r1 = r1 - (r21 - r112);
        r21 = r113;
        goto L67
    L66:
        int r114 = r21 + 1;
        System.arraycopy(r4, r114, r4, r2, r1 - r21);
        r1 = r1 - (r114 - r2);
        r21 = r6;
        goto L67
    L56:
        return null;
    L54:
        if (r4[r21 - 3] == r111) goto L55;
    L67:
        r21 = r21 + 1;
        goto L45
    L68:
        if (r1 > 0) goto L71;
        return "";
    L71:
        if (r1 <= r2) goto L73;
        if (r18 == false) goto L79;
        if (r15 == false) goto L79;
        return new String(r4, 0, r1);
    L79:
        return new String(r4, 0, r1 - 1);
    L73:
        return new String(r4, 0, r1);
    L20:
        r18 = true;
        goto L21
    }

    public static String concat(String r2, String r3) {
        int r0 = getPrefixLength(r3);
        if (r0 >= 0) goto L5;
        return null;
    L5:
        if (r0 > 0) goto L7;
        if (r2 != null) goto L10;
        return null;
    L10:
        int r1 = r2.length();
        if (r1 != 0) goto L15;
        return normalize(r3);
    L15:
        if (isSeparator(r2.charAt(r1 - 1)) == false) goto L19;
        return normalize(new StringBuffer().append(r2).append(r3).toString());
    L19:
        return normalize(new StringBuffer().append(r2).append('/').append(r3).toString());
    L7:
        return normalize(r3);
    }

    public static String separatorsToUnix(String r3) {
        if (r3 != null) goto L4;
        return r3;
    L4:
        if (r3.indexOf(92) != (-1)) goto L7;
        return r3;
    L7:
        return r3.replace('\\', '/');
    }

    public static String separatorsToWindows(String r3) {
        if (r3 != null) goto L4;
        return r3;
    L4:
        if (r3.indexOf(47) != (-1)) goto L7;
        return r3;
    L7:
        return r3.replace('/', '\\');
    }

    public static String separatorsToSystem(String r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if (isSystemWindows() == false) goto L10;
        return separatorsToWindows(r1);
    L10:
        return separatorsToUnix(r1);
    }

    public static int getPrefixLength(String r9) {
        if (r9 != null) goto L5;
        return -1;
    L5:
        int r1 = r9.length();
        if (r1 != 0) goto L8;
        return 0;
    L8:
        char r2 = r9.charAt(0);
        if (r2 != ':') goto L12;
        return -1;
    L12:
        if (r1 != 1) goto L18;
        if (r2 != '~') goto L16;
        return 2;
    L16:
        return isSeparator(r2) ? 1 : 0;
    L18:
        if (r2 != '~') goto L31;
        int r3 = r9.indexOf(47, 1);
        int r10 = r9.indexOf(92, 1);
        if (r3 != (-1)) goto L24;
        if (r10 != (-1)) goto L24;
        return r1 + 1;
    L24:
        if (r3 != (-1)) goto L26;
        r3 = r10;
    L26:
        if (r10 != (-1)) goto L28;
        r10 = r3;
    L28:
        int r11 = Math.min(r3, r10);
    L30:
        return r11 + 1;
    L31:
        char r4 = r9.charAt(1);
        if (r4 != ':') goto L46;
        char r5 = Character.toUpperCase(r2);
        if (r5 >= 'A') goto L36;
    L44:
        return -1;
    L36:
        if (r5 > 'Z') goto L44;
        if (r1 != 2) goto L39;
    L43:
        return 2;
    L39:
        if (isSeparator(r9.charAt(2)) == false) goto L43;
        return 3;
    L46:
        if (isSeparator(r2) == false) goto L62;
        if (isSeparator(r4) == false) goto L62;
        int r6 = r9.indexOf(47, 2);
        int r12 = r9.indexOf(92, 2);
        if (r6 != (-1)) goto L52;
        if (r12 != (-1)) goto L52;
    L60:
        return -1;
    L52:
        if (r6 == 2) goto L60;
        if (r12 == 2) goto L60;
        if (r6 != (-1)) goto L57;
        r6 = r12;
    L57:
        if (r12 != (-1)) goto L59;
        r12 = r6;
    L59:
        r11 = Math.min(r6, r12);
    L62:
        return isSeparator(r2) ? 1 : 0;
    }

    public static int indexOfLastSeparator(String r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        return Math.max(r2.lastIndexOf(47), r2.lastIndexOf(92));
    }

    public static int indexOfExtension(String r2) {
        if (r2 != null) goto L5;
        return -1;
    L5:
        int r1 = r2.lastIndexOf(46);
        if (indexOfLastSeparator(r2) <= r1) goto L9;
        return -1;
    L9:
        return r1;
    }

    public static String getPrefix(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r1 = getPrefixLength(r2);
        if (r1 >= 0) goto L9;
        return null;
    L9:
        if (r1 <= r2.length()) goto L13;
        return new StringBuffer().append(r2).append('/').toString();
    L13:
        return r2.substring(0, r1);
    }

    public static String getPath(String r1) {
        return doGetPath(r1, 1);
    }

    public static String getPathNoEndSeparator(String r1) {
        return doGetPath(r1, 0);
    }

    private static String doGetPath(String r3, int r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        int r1 = getPrefixLength(r3);
        if (r1 >= 0) goto L8;
        return null;
    L8:
        int r0 = indexOfLastSeparator(r3);
        if (r1 >= r3.length()) goto L14;
        if (r0 >= 0) goto L13;
        return "";
    L13:
        return r3.substring(r1, r0 + r4);
    L14:
        return "";
    }

    public static String getFullPath(String r1) {
        return doGetFullPath(r1, true);
    }

    public static String getFullPathNoEndSeparator(String r1) {
        return doGetFullPath(r1, false);
    }

    private static String doGetFullPath(String r3, boolean r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        int r1 = getPrefixLength(r3);
        if (r1 >= 0) goto L9;
        return null;
    L9:
        if (r1 < r3.length()) goto L13;
        if (r4 == true) goto L12;
        return r3;
    L12:
        return getPrefix(r3);
    L13:
        int r0 = indexOfLastSeparator(r3);
        if (r0 >= 0) goto L18;
        return r3.substring(0, r1);
    L18:
        return r3.substring(0, r0 + (r4 ? 1 : 0));
    }

    public static String getName(String r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.substring(indexOfLastSeparator(r1) + 1);
    }

    public static String getBaseName(String r0) {
        return removeExtension(getName(r0));
    }

    public static String getExtension(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = indexOfExtension(r2);
        if (r0 != (-1)) goto L10;
        return "";
    L10:
        return r2.substring(r0 + 1);
    }

    public static String removeExtension(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = indexOfExtension(r2);
        if (r0 != (-1)) goto L9;
        return r2;
    L9:
        return r2.substring(0, r0);
    }

    public static boolean equals(String r2, String r3) {
        return equals(r2, r3, false, IOCase.SENSITIVE);
    }

    public static boolean equalsOnSystem(String r2, String r3) {
        return equals(r2, r3, false, IOCase.SYSTEM);
    }

    public static boolean equalsNormalized(String r2, String r3) {
        return equals(r2, r3, true, IOCase.SENSITIVE);
    }

    public static boolean equalsNormalizedOnSystem(String r2, String r3) {
        return equals(r2, r3, true, IOCase.SYSTEM);
    }

    public static boolean equals(String r0, String r1, boolean r2, IOCase r3) {
        if (r0 == null) goto L11;
        if (r1 == null) goto L11;
        if (r2 == false) goto L7;
        r0 = normalize(r0);
        r1 = normalize(r1);
    L7:
        if (r3 != null) goto L10;
        r3 = IOCase.SENSITIVE;
    L10:
        return r3.checkEquals(r0, r1);
    L11:
        if (r0 != r1) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean isExtension(String r2, String r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r3 == null) goto L12;
        if (r3.length() == 0) goto L12;
        return getExtension(r2).equals(r3);
    L12:
        if (indexOfExtension(r2) != (-1)) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean isExtension(String r4, String[] r5) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r5 == null) goto L19;
        if (r5.length == 0) goto L19;
        String r6 = getExtension(r4);
        int r2 = 0;
    L12:
        if (r2 >= r5.length) goto L17;
        if (r6.equals(r5[r2]) == true) goto L15;
        r2 = r2 + 1;
        goto L12
    L15:
        return true;
    L17:
        return false;
    L19:
        if (indexOfExtension(r4) == (-1)) goto L21;
        return false;
    L21:
        return true;
    }

    public static boolean isExtension(String r3, Collection r4) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r4 == null) goto L18;
        if (r4.isEmpty() == true) goto L18;
        String r5 = getExtension(r3);
        Iterator r6 = r4.iterator();
    L12:
        if (r6.hasNext() == false) goto L16;
        if (r5.equals(r6.next()) == false) goto L12;
        return true;
    L16:
        return false;
    L18:
        if (indexOfExtension(r3) == (-1)) goto L20;
        return false;
    L20:
        return true;
    }

    public static boolean wildcardMatch(String r1, String r2) {
        return wildcardMatch(r1, r2, IOCase.SENSITIVE);
    }

    public static boolean wildcardMatchOnSystem(String r1, String r2) {
        return wildcardMatch(r1, r2, IOCase.SYSTEM);
    }

    public static boolean wildcardMatch(String r7, String r8, IOCase r9) {
        if (r7 != null) goto L7;
        if (r8 != null) goto L7;
        return true;
    L7:
        if (r7 == null) goto L47;
        if (r8 == null) goto L47;
        if (r9 != null) goto L12;
        r9 = IOCase.SENSITIVE;
    L12:
        String r10 = r9.convertCase(r7);
        String[] r11 = splitOnTokens(r9.convertCase(r8));
        Stack r12 = new Stack();
        boolean r2 = false;
        int r3 = 0;
        int r4 = 0;
    L14:
        if (r12.size() <= 0) goto L17;
        int[] r5 = (int[]) r12.pop();
        r4 = r5[0];
        r3 = r5[1];
        r2 = true;
    L17:
        if (r4 >= r11.length) goto L41;
        if (r11[r4].equals("?") == false) goto L23;
        r3 = r3 + 1;
    L21:
        r2 = false;
    L39:
        r4 = r4 + 1;
        goto L17
    L23:
        if (r11[r4].equals(ApnEditor.APN_TYPE_ALL) == true) goto L25;
        if (r2 == false) goto L36;
        r3 = r10.indexOf(r11[r4], r3);
        if (r3 == (-1)) goto L41;
        int r6 = r10.indexOf(r11[r4], r3 + 1);
        if (r6 < 0) goto L38;
        r12.push(new int[]{r4, r6});
    L38:
        r3 = r3 + r11[r4].length();
        goto L21
    L36:
        if (r10.startsWith(r11[r4], r3) == true) goto L38;
    L25:
        if (r4 != (r11.length - 1)) goto L27;
        r3 = r10.length();
    L27:
        r2 = true;
    L41:
        if (r4 != r11.length) goto L46;
        if (r3 != r10.length()) goto L46;
        return true;
    L46:
        if (r12.size() > 0) goto L14;
    L47:
        return false;
    }

    static String[] splitOnTokens(String r10) {
        if (r10.indexOf("?") == (-1)) goto L5;
    L8:
        char[] r11 = r10.toCharArray();
        ArrayList r1 = new ArrayList();
        StringBuffer r5 = new StringBuffer();
        int r6 = 0;
    L10:
        if (r6 >= r11.length) goto L31;
        char r7 = r11[r6];
        if (r7 == '?') goto L18;
        if (r7 == '*') goto L18;
        r5.append(r7);
    L29:
        r6 = r6 + 1;
    L18:
        if (r5.length() == 0) goto L21;
        r1.add(r5.toString());
        r5.setLength(0);
    L21:
        if (r11[r6] != '?') goto L24;
        r1.add("?");
        goto L29
    L24:
        if (r1.size() == 0) goto L28;
        if (r6 <= 0) goto L29;
        if (r1.get(r1.size() - 1).equals(ApnEditor.APN_TYPE_ALL) == true) goto L29;
    L28:
        r1.add(ApnEditor.APN_TYPE_ALL);
        goto L29
    L31:
        if (r5.length() == 0) goto L34;
        r1.add(r5.toString());
    L34:
        return (String[]) r1.toArray(new String[r1.size()]);
    L5:
        if (r10.indexOf(ApnEditor.APN_TYPE_ALL) != (-1)) goto L8;
        return new String[]{r10};
    }
}
