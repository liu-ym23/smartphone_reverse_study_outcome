package tmsdkobf;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class h0 {
    private static void a(ArrayList r3, String r4) {
        int r0 = r4.length();
    L4:
        if (r4.charAt(r0 - 1) != '>') goto L8;
        r0 = r0 - 1;
        if (r0 != 0) goto L4;
    L8:
        r3.add(0, e(r4.substring(0, r0)));
    }

    public static Object b(String r7) {
        Iterator r8 = c(r7).iterator();
        Object r1 = null;
        Object r2 = null;
    L3:
        Object r3 = r2;
    L5:
        if (r8.hasNext() == false) goto L6;
        r1 = a((String) r8.next());
        boolean r5 = false;
        if ((r1 instanceof String) == true) goto L9;
        if ((r1 instanceof List) == false) goto L27;
        if (r2 == null) goto L23;
        if ((r2 instanceof Byte) == false) goto L23;
        r1 = Array.newInstance(Byte.class, 1);
        Array.set(r1, 0, r2);
    L23:
        if (r2 == null) goto L25;
        ((List) r1).add(r2);
    L25:
        r2 = null;
        goto L5
    L27:
        if ((r1 instanceof Map) == true) goto L28;
        if (r2 != null) goto L39;
    L38:
        r2 = r1;
    L39:
        r3 = r2;
        goto L38
    L28:
        if (r2 == null) goto L30;
        boolean r4 = true;
    L31:
        if (r3 == null) goto L34;
        r5 = true;
    L34:
        if ((r4 & r5) == false) goto L36;
        ((Map) r1).put(r2, r3);
    L36:
        r2 = null;
        goto L3
    L30:
        r4 = false;
        goto L31
    L9:
        String r6 = (String) r1;
        if ("Array".equals(r6) == true) goto L11;
        if ("?".equals(r6) == true) goto L5;
        if (r2 != null) goto L39;
    L11:
        if (r2 != null) goto L5;
        r1 = Array.newInstance(Byte.class, 0);
        goto L5
    L6:
        return r1;
    }

    public static ArrayList c(String r6) {
        ArrayList r0 = new ArrayList();
        int r2 = r6.indexOf("<");
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L4;
        a(r0, r6.substring(r3, r2));
        r3 = r2 + 1;
        r2 = r6.indexOf("<", r3);
        int r4 = r6.indexOf(",", r3);
        if (r2 != (-1)) goto L9;
        r2 = r4;
    L9:
        if (r4 == (-1)) goto L3;
        if (r4 >= r2) goto L3;
        r2 = r4;
        goto L3
    L4:
        a(r0, r6.substring(r3, r6.length()));
        return r0;
    }

    public static String d(String r2) {
        if (r2.equals("java.lang.Integer") == false) goto L5;
        return "int32";
    L5:
        if (r2.equals("int") == false) goto L8;
        return "int32";
    L8:
        if (r2.equals("java.lang.Boolean") == false) goto L10;
        return "bool";
    L10:
        if (r2.equals("boolean") == false) goto L13;
        return "bool";
    L13:
        if (r2.equals("java.lang.Byte") == false) goto L15;
        return "char";
    L15:
        if (r2.equals("byte") == true) goto L65;
        String r1 = "double";
        if (r2.equals("java.lang.Double") == false) goto L20;
    L56:
        return r1;
    L20:
        if (r2.equals("double") == true) goto L56;
        r1 = "float";
        if (r2.equals("java.lang.Float") == true) goto L56;
        if (r2.equals("float") == true) goto L56;
        if (r2.equals("java.lang.Long") == false) goto L30;
        return "int64";
    L30:
        if (r2.equals("long") == false) goto L33;
        return "int64";
    L33:
        if (r2.equals("java.lang.Short") == false) goto L35;
    L53:
        return "short";
    L35:
        if (r2.equals("short") == true) goto L53;
        if (r2.equals("java.lang.Character") == true) goto L52;
        if (r2.equals("java.lang.String") == false) goto L44;
        return "string";
    L44:
        if (r2.equals("java.util.List") == false) goto L48;
        return "list";
    L48:
        if (r2.equals("java.util.Map") == false) goto L63;
        return "map";
    L63:
        return r2;
    L52:
        throw new IllegalArgumentException("can not support java.lang.Character");
    L65:
        return "char";
    }

    public static String e(String r1) {
        if (r1.equals("int32") == false) goto L7;
        return "java.lang.Integer";
    L7:
        if (r1.equals("bool") == false) goto L11;
        return "java.lang.Boolean";
    L11:
        if (r1.equals("char") == false) goto L15;
        return "java.lang.Byte";
    L15:
        if (r1.equals("double") == false) goto L19;
        return "java.lang.Double";
    L19:
        if (r1.equals("float") == false) goto L23;
        return "java.lang.Float";
    L23:
        if (r1.equals("int64") == false) goto L27;
        return "java.lang.Long";
    L27:
        if (r1.equals("short") == false) goto L31;
        return "java.lang.Short";
    L31:
        if (r1.equals("string") == false) goto L35;
        return "java.lang.String";
    L35:
        if (r1.equals("list") == false) goto L39;
        return "java.util.List";
    L39:
        if (r1.equals("map") == false) goto L42;
        return "java.util.Map";
    L42:
        return r1;
    }

    public static String a(ArrayList r7) {
        StringBuffer r0 = new StringBuffer();
        int r2 = 0;
    L4:
        if (r2 >= r7.size()) goto L5;
        r7.set(r2, d((String) r7.get(r2)));
        r2 = r2 + 1;
        goto L4
    L5:
        Collections.reverse(r7);
        int r3 = 0;
    L7:
        if (r3 >= r7.size()) goto L8;
        String r4 = (String) r7.get(r3);
        if (r4.equals("list") == false) goto L18;
        int r5 = r3 - 1;
        r7.set(r5, "<" + ((String) r7.get(r5)));
        r7.set(0, String.valueOf((String) r7.get(0)) + ">");
    L23:
        r3 = r3 + 1;
        goto L7
    L18:
        if (r4.equals("map") == false) goto L21;
        int r6 = r3 - 1;
        r7.set(r6, "<" + ((String) r7.get(r6)) + ",");
        r7.set(0, String.valueOf((String) r7.get(0)) + ">");
        goto L23
    L21:
        if (r4.equals("Array") == false) goto L23;
        int r8 = r3 - 1;
        r7.set(r8, "<" + ((String) r7.get(r8)));
        r7.set(0, String.valueOf((String) r7.get(0)) + ">");
        goto L23
    L8:
        Collections.reverse(r7);
        Iterator r9 = r7.iterator();
    L10:
        if (r9.hasNext() == false) goto L12;
        r0.append((String) r9.next());
        goto L10
    L12:
        return r0.toString();
    }

    public static Object a(String r3) {
        if (r3.equals("java.lang.Integer") == false) goto L7;
        return 0;
    L7:
        if (r3.equals("java.lang.Boolean") == false) goto L11;
        return Boolean.FALSE;
    L11:
        if (r3.equals("java.lang.Byte") == false) goto L15;
        return (byte) 0;
    L15:
        if (r3.equals("java.lang.Double") == false) goto L19;
        return Double.valueOf(0.0d);
    L19:
        if (r3.equals("java.lang.Float") == false) goto L23;
        return Float.valueOf(0.0f);
    L23:
        if (r3.equals("java.lang.Long") == false) goto L27;
        return 0L;
    L27:
        if (r3.equals("java.lang.Short") == false) goto L31;
        return (short) 0;
    L31:
        if (r3.equals("java.lang.Character") == true) goto L56;
        if (r3.equals("java.lang.String") == false) goto L37;
        return "";
    L37:
        if (r3.equals("java.util.List") == false) goto L41;
        return new ArrayList();
    L41:
        if (r3.equals("java.util.Map") == false) goto L45;
        return new HashMap();
    L45:
        if (r3.equals("Array") == false) goto L48;
        return "Array";
    L48:
        if (r3.equals("?") == false) goto L57;
        return r3;
    L57:
        return Class.forName(r3).getConstructor(new Class[0]).newInstance(new Object[0]);
    L52:
        e = move-exception;
        e.printStackTrace();
        throw new t9(e);
    L56:
        throw new IllegalArgumentException("can not support java.lang.Character");
    }
}
