package com.obric.oui.constraintlayout.core.dsl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class Helper {
    protected static final Map<Constraint.Side, String> sideMap = null;
    protected static final Map<Type, String> typeMap = null;
    protected String config;
    protected Map<String, String> configMap;
    protected final String name;
    protected HelperType type;

    public static final class HelperType {
        final String mName;

        public HelperType(String r1) {
            this.mName = r1;
        }

        public String toString() {
            return this.mName;
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type BARRIER = null;
        public static final Type HORIZONTAL_CHAIN = null;
        public static final Type HORIZONTAL_GUIDELINE = null;
        public static final Type VERTICAL_CHAIN = null;
        public static final Type VERTICAL_GUIDELINE = null;

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r1) {
            return (Type) Enum.valueOf(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        static {
            Type r0 = new Type("VERTICAL_GUIDELINE", 0);
            VERTICAL_GUIDELINE = r0;
            Type r1 = new Type("HORIZONTAL_GUIDELINE", 1);
            HORIZONTAL_GUIDELINE = r1;
            Type r3 = new Type("VERTICAL_CHAIN", 2);
            VERTICAL_CHAIN = r3;
            Type r5 = new Type("HORIZONTAL_CHAIN", 3);
            HORIZONTAL_CHAIN = r5;
            Type r7 = new Type("BARRIER", 4);
            BARRIER = r7;
            $VALUES = new Type[]{r0, r1, r3, r5, r7};
        }
    }

    static {
        HashMap r0 = new HashMap();
        sideMap = r0;
        r0.put(Constraint.Side.LEFT, "'left'");
        r0.put(Constraint.Side.RIGHT, "'right'");
        r0.put(Constraint.Side.TOP, "'top'");
        r0.put(Constraint.Side.BOTTOM, "'bottom'");
        r0.put(Constraint.Side.START, "'start'");
        r0.put(Constraint.Side.END, "'end'");
        r0.put(Constraint.Side.BASELINE, "'baseline'");
        HashMap r1 = new HashMap();
        typeMap = r1;
        r1.put(Type.VERTICAL_GUIDELINE, "vGuideline");
        r1.put(Type.HORIZONTAL_GUIDELINE, "hGuideline");
        r1.put(Type.VERTICAL_CHAIN, "vChain");
        r1.put(Type.HORIZONTAL_CHAIN, "hChain");
        r1.put(Type.BARRIER, "barrier");
    }

    public Helper(String r2, HelperType r3) {
        this.type = null;
        this.configMap = new HashMap();
        this.name = r2;
        this.type = r3;
    }

    public Helper(String r2, HelperType r3, String r4) {
        this.type = null;
        this.configMap = new HashMap();
        this.name = r2;
        this.type = r3;
        this.config = r4;
        this.configMap = convertConfigToMap();
    }

    public String getId() {
        return this.name;
    }

    public HelperType getType() {
        return this.type;
    }

    public String getConfig() {
        return this.config;
    }

    public Map<String, String> convertConfigToMap() {
        String r0 = this.config;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.length() == 0) goto L44;
        HashMap r1 = new HashMap();
        StringBuilder r2 = new StringBuilder();
        String r5 = "";
        int r4 = 0;
        int r6 = 0;
        int r7 = 0;
    L9:
        if (r4 >= this.config.length()) goto L35;
        char r8 = this.config.charAt(r4);
        if (r8 != ':') goto L14;
        r5 = r2.toString();
        r2.setLength(0);
    L34:
        r4 = r4 + 1;
        goto L9
    L14:
        if (r8 != ',') goto L19;
        if (r6 != 0) goto L19;
        if (r7 != 0) goto L19;
        r1.put(r5, r2.toString());
        r2.setLength(0);
        r5 = "";
    L19:
        if (r8 == ' ') goto L34;
        if (r8 != '[') goto L23;
        r6 = r6 + 1;
    L33:
        r2.append(r8);
        goto L34
    L23:
        if (r8 != ']') goto L25;
        r6 = r6 - 1;
        goto L33
    L25:
        if (r8 != '{') goto L27;
        r7 = r7 + 1;
        goto L33
    L27:
        if (r8 != '}') goto L33;
        r7 = r7 - 1;
        goto L33
    L35:
        r1.put(r5, r2.toString());
        return r1;
    L44:
        return null;
    }

    public void append(Map<String, String> r4, StringBuilder r5) {
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<String> r3 = r4.keySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        String r0 = r3.next();
        r5.append(r0).append(":").append(r4.get(r0)).append(",\n");
        goto L7
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(this.name + ":{\n");
        if (this.type == null) goto L5;
        r0.append("type:'").append(this.type.toString()).append("',\n");
    L5:
        Map<String, String> r1 = this.configMap;
        if (r1 == null) goto L8;
        append(r1, r0);
    L8:
        r0.append("},\n");
        return r0.toString();
    }

    public static void main(String[] r2) {
        Barrier r3 = new Barrier("abc", "['a1', 'b2']");
        System.out.println(r3.toString());
    }
}
