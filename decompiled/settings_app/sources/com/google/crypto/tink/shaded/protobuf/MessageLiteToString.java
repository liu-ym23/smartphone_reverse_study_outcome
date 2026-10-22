package com.google.crypto.tink.shaded.protobuf;

import cz.msebera.android.httpclient.message.TokenParser;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes4.dex */
final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final char[] INDENT_BUFFER = null;
    private static final String LIST_SUFFIX = "List";
    private static final String MAP_SUFFIX = "Map";

    static {
        char[] r0 = new char[80];
        INDENT_BUFFER = r0;
        Arrays.fill(r0, TokenParser.SP);
    }

    private MessageLiteToString() {
    }

    static String toString(MessageLite messageLite, String commentString) {
        StringBuilder r0 = new StringBuilder();
        r0.append("# ").append(commentString);
        reflectivePrintWithIndent(messageLite, r0, 0);
        return r0.toString();
    }

    private static void reflectivePrintWithIndent(MessageLite messageLite, StringBuilder buffer, int indent) {
        HashSet r3 = new HashSet();
        HashMap r4 = new HashMap();
        TreeMap r5 = new TreeMap();
        java.lang.reflect.Method[] r6 = messageLite.getClass().getDeclaredMethods();
        int r7 = r6.length;
        int r9 = 0;
    L3:
        int r13 = 3;
        if (r9 >= r7) goto L27;
        java.lang.reflect.Method r14 = r6[r9];
        if (Modifier.isStatic(r14.getModifiers()) == true) goto L26;
        if (r14.getName().length() < 3) goto L26;
        if (r14.getName().startsWith("set") == false) goto L15;
        r3.add(r14.getName());
        goto L26
    L15:
        if (Modifier.isPublic(r14.getModifiers()) == false) goto L26;
        if (r14.getParameterTypes().length != 0) goto L26;
        if (r14.getName().startsWith("has") == false) goto L24;
        r4.put(r14.getName(), r14);
        goto L26
    L24:
        if (r14.getName().startsWith("get") == false) goto L26;
        r5.put(r14.getName(), r14);
    L26:
        r9 = r9 + 1;
        goto L3
    L27:
        Iterator r8 = r5.entrySet().iterator();
    L29:
        if (r8.hasNext() == false) goto L74;
        Map.Entry r10 = (Map.Entry) r8.next();
        String r11 = ((String) r10.getKey()).substring(r13);
        if (r11.endsWith(LIST_SUFFIX) == false) goto L42;
        if (r11.endsWith(BUILDER_LIST_SUFFIX) == true) goto L42;
        if (r11.equals(LIST_SUFFIX) == true) goto L42;
        java.lang.reflect.Method r15 = (java.lang.reflect.Method) r10.getValue();
        if (r15 == null) goto L42;
        if (r15.getReturnType().equals(List.class) == false) goto L42;
        printField(buffer, indent, r11.substring(0, r11.length() - 4), GeneratedMessageLite.invokeOrDie(r15, messageLite, new Object[0]));
        r13 = 3;
    L42:
        if (r11.endsWith(MAP_SUFFIX) == true) goto L44;
    L54:
        int r16 = 3;
        if (r3.contains("set" + r11) == true) goto L58;
    L56:
        r13 = r16;
        goto L29
    L58:
        if (r11.endsWith(BYTES_SUFFIX) == true) goto L60;
    L62:
        java.lang.reflect.Method r12 = (java.lang.reflect.Method) r10.getValue();
        java.lang.reflect.Method r17 = (java.lang.reflect.Method) r4.get("has" + r11);
        if (r12 == null) goto L56;
        Object r18 = GeneratedMessageLite.invokeOrDie(r12, messageLite, new Object[0]);
        if (r17 == null) goto L67;
        boolean r19 = ((Boolean) GeneratedMessageLite.invokeOrDie(r17, messageLite, new Object[0])).booleanValue();
    L71:
        if (r19 == false) goto L56;
        printField(buffer, indent, r11, r18);
        goto L56
    L67:
        if (isDefaultValue(r18) == true) goto L69;
        r19 = true;
        goto L71
    L69:
        r19 = false;
        goto L71
    L60:
        if (r5.containsKey("get" + r11.substring(0, r11.length() - 5)) == false) goto L62;
    L44:
        if (r11.equals(MAP_SUFFIX) == true) goto L54;
        java.lang.reflect.Method r110 = (java.lang.reflect.Method) r10.getValue();
        if (r110 == null) goto L54;
        if (r110.getReturnType().equals(Map.class) == false) goto L54;
        if (r110.isAnnotationPresent(Deprecated.class) == true) goto L54;
        if (Modifier.isPublic(r110.getModifiers()) == false) goto L54;
        r16 = 3;
        printField(buffer, indent, r11.substring(0, r11.length() - 3), GeneratedMessageLite.invokeOrDie(r110, messageLite, new Object[0]));
        goto L56
    L74:
        if ((messageLite instanceof GeneratedMessageLite.ExtendableMessage) == false) goto L79;
        Iterator<Map.Entry<T, Object>> r20 = ((GeneratedMessageLite.ExtendableMessage) messageLite).extensions.iterator();
    L77:
        if (r20.hasNext() == false) goto L79;
        Map.Entry r21 = (Map.Entry) r20.next();
        printField(buffer, indent, "[" + ((GeneratedMessageLite.ExtensionDescriptor) r21.getKey()).getNumber() + "]", r21.getValue());
    L79:
        GeneratedMessageLite r0 = (GeneratedMessageLite) messageLite;
        if (r0.unknownFields == null) goto L103;
        r0.unknownFields.printWithIndent(buffer, indent);
        return;
    }

    private static boolean isDefaultValue(Object o) {
        if ((o instanceof Boolean) == false) goto L7;
        return !((Boolean) o).booleanValue();
    L7:
        if ((o instanceof Integer) == false) goto L14;
        if (((Integer) o).intValue() != 0) goto L12;
        return true;
    L12:
        return false;
    L14:
        if ((o instanceof Float) == false) goto L21;
        if (Float.floatToRawIntBits(((Float) o).floatValue()) != 0) goto L19;
        return true;
    L19:
        return false;
    L21:
        if ((o instanceof Double) == false) goto L28;
        if (Double.doubleToRawLongBits(((Double) o).doubleValue()) != 0) goto L26;
        return true;
    L26:
        return false;
    L28:
        if ((o instanceof String) == false) goto L32;
        return o.equals("");
    L32:
        if ((o instanceof ByteString) == false) goto L36;
        return o.equals(ByteString.EMPTY);
    L36:
        if ((o instanceof MessageLite) == false) goto L43;
        if (o != ((MessageLite) o).getDefaultInstanceForType()) goto L41;
        return true;
    L41:
        return false;
    L43:
        if ((o instanceof java.lang.Enum) == true) goto L45;
        return false;
    L45:
        if (((java.lang.Enum) o).ordinal() != 0) goto L48;
        return true;
    L48:
        return false;
    }

    static void printField(StringBuilder buffer, int indent, String name, Object object) {
        if ((object instanceof List) == false) goto L10;
        Iterator r7 = ((List) object).iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        printField(buffer, indent, name, r7.next());
        goto L6
    L8:
        return;
    L10:
        if ((object instanceof Map) == false) goto L16;
        Iterator r8 = ((Map) object).entrySet().iterator();
    L13:
        if (r8.hasNext() == false) goto L15;
        printField(buffer, indent, name, (Map.Entry) r8.next());
        goto L13
    L15:
        return;
    L16:
        buffer.append('\n');
        indent(indent, buffer);
        buffer.append(pascalCaseToSnakeCase(name));
        if ((object instanceof String) == false) goto L20;
        buffer.append(": \"").append(TextFormatEscaper.escapeText((String) object)).append('\"');
        return;
    L20:
        if ((object instanceof ByteString) == false) goto L23;
        buffer.append(": \"").append(TextFormatEscaper.escapeBytes((ByteString) object)).append('\"');
        return;
    L23:
        if ((object instanceof GeneratedMessageLite) == false) goto L26;
        buffer.append(" {");
        reflectivePrintWithIndent((GeneratedMessageLite) object, buffer, indent + 2);
        buffer.append("\n");
        indent(indent, buffer);
        buffer.append(VectorFormat.DEFAULT_SUFFIX);
        return;
    L26:
        if ((object instanceof Map.Entry) == false) goto L28;
        buffer.append(" {");
        Map.Entry r9 = (Map.Entry) object;
        int r6 = indent + 2;
        printField(buffer, r6, "key", r9.getKey());
        printField(buffer, r6, "value", r9.getValue());
        buffer.append("\n");
        indent(indent, buffer);
        buffer.append(VectorFormat.DEFAULT_SUFFIX);
        return;
    L28:
        buffer.append(": ").append(object);
    }

    private static void indent(int indent, StringBuilder buffer) {
    L2:
        if (indent <= 0) goto L8;
        char[] r0 = INDENT_BUFFER;
        if (indent <= r0.length) goto L6;
        int r1 = r0.length;
    L7:
        buffer.append(r0, 0, r1);
        indent = indent - r1;
        goto L2
    L6:
        r1 = indent;
        goto L7
    }

    private static String pascalCaseToSnakeCase(String pascalCase) {
        if (pascalCase.isEmpty() == false) goto L5;
        return pascalCase;
    L5:
        StringBuilder r0 = new StringBuilder();
        r0.append(Character.toLowerCase(pascalCase.charAt(0)));
        int r1 = 1;
    L7:
        if (r1 >= pascalCase.length()) goto L13;
        char r2 = pascalCase.charAt(r1);
        if (Character.isUpperCase(r2) == false) goto L11;
        r0.append("_");
    L11:
        r0.append(Character.toLowerCase(r2));
        r1 = r1 + 1;
        goto L7
    L13:
        return r0.toString();
    }
}
