package com.bytedance.apm.util;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.math3.geometry.VectorFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class JsonUtils {

    /* JADX INFO: renamed from: com.bytedance.apm.util.JsonUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class JsonWriter {
        final Writer out;
        private final List<Scope> stack;

        static final enum Scope extends Enum<Scope> {
            private static final /* synthetic */ Scope[] $VALUES = null;
            public static final Scope DANGLING_KEY = null;
            public static final Scope EMPTY_ARRAY = null;
            public static final Scope EMPTY_OBJECT = null;
            public static final Scope NONEMPTY_ARRAY = null;
            public static final Scope NONEMPTY_OBJECT = null;
            public static final Scope NULL = null;

            private Scope(String r1, int r2) {
                super(r1, r2);
            }

            public static Scope valueOf(String r1) {
                return (Scope) Enum.valueOf(Scope.class, r1);
            }

            public static Scope[] values() {
                return (Scope[]) $VALUES.clone();
            }

            static {
                Scope r0 = new Scope("EMPTY_ARRAY", 0);
                EMPTY_ARRAY = r0;
                Scope r1 = new Scope("NONEMPTY_ARRAY", 1);
                NONEMPTY_ARRAY = r1;
                Scope r3 = new Scope("EMPTY_OBJECT", 2);
                EMPTY_OBJECT = r3;
                Scope r5 = new Scope("DANGLING_KEY", 3);
                DANGLING_KEY = r5;
                Scope r7 = new Scope("NONEMPTY_OBJECT", 4);
                NONEMPTY_OBJECT = r7;
                Scope r9 = new Scope("NULL", 5);
                NULL = r9;
                $VALUES = new Scope[]{r0, r1, r3, r5, r7, r9};
            }
        }

        public String toString() {
            return "";
        }

        public JsonWriter(Writer r2) {
            this.stack = new ArrayList();
            this.out = r2;
        }

        public JsonWriter array() throws JSONException, IOException {
            return open(Scope.EMPTY_ARRAY, "[");
        }

        public JsonWriter endArray() throws JSONException, IOException {
            return close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
        }

        public JsonWriter object() throws JSONException, IOException {
            return open(Scope.EMPTY_OBJECT, VectorFormat.DEFAULT_PREFIX);
        }

        public JsonWriter endObject() throws JSONException, IOException {
            return close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, VectorFormat.DEFAULT_SUFFIX);
        }

        JsonWriter open(Scope r2, String r3) throws JSONException, IOException {
            beforeValue();
            this.stack.add(r2);
            this.out.write(r3);
            return this;
        }

        JsonWriter close(Scope r1, Scope r2, String r3) throws JSONException, IOException {
            peek();
            List<Scope> r4 = this.stack;
            r4.remove(r4.size() - 1);
            this.out.write(r3);
            return this;
        }

        private Scope peek() throws JSONException {
            List<Scope> r1 = this.stack;
            return r1.get(r1.size() - 1);
        }

        private void replaceTop(Scope r2) {
            List<Scope> r1 = this.stack;
            r1.set(r1.size() - 1, r2);
        }

        public JsonWriter value(Object r2) throws JSONException, IOException {
            if ((r2 instanceof JSONArray) == false) goto L7;
            arrayWriteTo((JSONArray) r2);
            return this;
        L7:
            if ((r2 instanceof JSONObject) == false) goto L10;
            jsonWriteTo((JSONObject) r2);
            return this;
        L10:
            beforeValue();
            if (r2 != null) goto L13;
        L22:
            this.out.write("null");
        L23:
            return this;
        L13:
            if (r2 == JSONObject.NULL) goto L22;
            if ((r2 instanceof Boolean) == false) goto L19;
            this.out.write(String.valueOf(r2));
            goto L23
        L19:
            if ((r2 instanceof Number) == false) goto L21;
            this.out.write(JSONObject.numberToString((Number) r2));
            goto L23
        L21:
            string(r2.toString());
            goto L23
        }

        public JsonWriter value(boolean r2) throws JSONException, IOException {
            beforeValue();
            this.out.write(String.valueOf(r2));
            return this;
        }

        public JsonWriter value(double r2) throws JSONException, IOException {
            beforeValue();
            this.out.write(JSONObject.numberToString(Double.valueOf(r2)));
            return this;
        }

        public JsonWriter value(long r2) throws JSONException, IOException {
            beforeValue();
            this.out.write(String.valueOf(r2));
            return this;
        }

        private void string(String r8) throws IOException {
            this.out.write("\"");
            int r0 = r8.length();
            int r3 = 0;
        L3:
            if (r3 >= r0) goto L25;
            char r4 = r8.charAt(r3);
            if (r4 != '\f') goto L7;
            this.out.write("\\f");
        L24:
            r3 = r3 + 1;
            goto L3
        L7:
            if (r4 != '\r') goto L9;
            this.out.write("\\r");
            goto L24
        L9:
            if (r4 != '\"') goto L11;
        L21:
            this.out.write(92);
            this.out.write(r4);
            goto L24
        L11:
            if (r4 == '/') goto L21;
            if (r4 == '\\') goto L21;
            switch(r4) {
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L18;
                default: goto L15;
            };
        L18:
            this.out.write("\\n");
            goto L24
        L19:
            this.out.write("\\t");
            goto L24
        L20:
            this.out.write("\\b");
            goto L24
        L15:
            if (r4 > 31) goto L17;
            this.out.write(String.format("\\u%04x", new Object[]{Integer.valueOf(r4)}));
            goto L24
        L17:
            this.out.write(r4);
            goto L24
        L25:
            this.out.write("\"");
        }

        public JsonWriter key(String r1) throws JSONException, IOException {
            beforeKey();
            string(r1);
            return this;
        }

        private void beforeKey() throws JSONException, IOException {
            Scope r0 = peek();
            if (r0 != Scope.NONEMPTY_OBJECT) goto L6;
            this.out.write(44);
        L7:
            replaceTop(Scope.DANGLING_KEY);
            return;
        L6:
            if (r0 == Scope.EMPTY_OBJECT) goto L7;
            throw new JSONException("Nesting problem");
        }

        private void beforeValue() throws JSONException, IOException {
            if (this.stack.isEmpty() == false) goto L5;
            return;
        L5:
            Scope r0 = peek();
            if (r0 != Scope.EMPTY_ARRAY) goto L9;
            replaceTop(Scope.NONEMPTY_ARRAY);
            return;
        L9:
            if (r0 != Scope.NONEMPTY_ARRAY) goto L12;
            this.out.write(44);
            return;
        L12:
            if (r0 != Scope.DANGLING_KEY) goto L15;
            this.out.write(":");
            replaceTop(Scope.NONEMPTY_OBJECT);
            return;
        L15:
            if (r0 != Scope.NULL) goto L18;
            return;
        L18:
            throw new JSONException("Nesting problem");
        }

        public static void writeTo(JSONObject r1, Writer r2) throws Throwable {
            new JsonWriter(r2).jsonWriteTo(r1);
            r2.flush();
        }

        public static void writeTo(JSONArray r1, Writer r2) throws Throwable {
            new JsonWriter(r2).arrayWriteTo(r1);
            r2.flush();
        }

        private void jsonWriteTo(JSONObject r4) throws JSONException, IOException {
            object();
            Iterator<String> r0 = r4.keys();
        L4:
            if (r0.hasNext() == false) goto L6;
            String r1 = r0.next();
            Object r2 = r4.get(r1);
            key(r1).value(r2);
            goto L4
        L6:
            endObject();
        }

        private void arrayWriteTo(JSONArray r3) throws JSONException, IOException {
            array();
            int r0 = 0;
        L4:
            if (r0 >= r3.length()) goto L6;
            value(r3.get(r0));
            r0 = r0 + 1;
            goto L4
        L6:
            endArray();
        }
    }

    private static class StatsWriter extends Writer {
        public int length;

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
        }

        private StatsWriter() {
            this.length = 0;
        }

        /* synthetic */ StatsWriter(AnonymousClass1 r1) {
            this();
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(char r1) throws IOException {
            return append(r1);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r1) throws IOException {
            return append(r1);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r1, int r2, int r3) throws IOException {
            return append(r1, r2, r3);
        }

        @Override // java.io.Writer
        public void write(char[] r1, int r2, int r3) throws IOException {
            this.length += r3;
        }

        @Override // java.io.Writer
        public void write(int r1) throws IOException {
            this.length++;
        }

        @Override // java.io.Writer
        public void write(String r2) throws IOException {
            this.length += r2.length();
        }

        @Override // java.io.Writer
        public void write(char[] r2) throws IOException {
            this.length += r2.length;
        }

        @Override // java.io.Writer
        public void write(String r1, int r2, int r3) throws IOException {
            this.length += r3;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char r1) throws IOException {
            this.length++;
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r2) throws IOException {
            this.length += r2.length();
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r1, int r2, int r3) throws IOException {
            this.length += r3 - r2;
            return this;
        }
    }

    public JsonUtils() {
    }

    public static JSONObject copyJson(JSONObject r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        LinkedList r1 = new LinkedList();
        Iterator<String> r2 = r3.keys();
        if (r2 != null) goto L9;
        return null;
    L9:
        if (r2.hasNext() == false) goto L16;
        r1.add(r2.next());
        goto L9
    L16:
        return new JSONObject(r3, (String[]) r1.toArray(new String[0]));
    L13:
        e = move-exception;
        e.printStackTrace();
        return r3;
    }

    public static JSONObject copyJson2(JSONObject r4) throws JSONException {
        if (r4 != null) goto L5;
        return null;
    L5:
        Iterator<String> r1 = r4.keys();
        if (r1 != null) goto L8;
        return null;
    L8:
        JSONObject r0 = new JSONObject();
    L10:
        if (r1.hasNext() == false) goto L12;
        String r2 = r1.next();
        r0.put(r2, r4.opt(r2));
        goto L10
    L12:
        return r0;
    }

    public static JSONObject copyJson2(JSONObject r3, JSONObject r4) throws JSONException {
        if (r3 == null) goto L15;
        if (r4 == null) goto L15;
        Iterator<String> r1 = r4.keys();
        if (r1 != null) goto L10;
        return null;
    L10:
        if (r1.hasNext() == false) goto L14;
        String r0 = r1.next();
        if (r4.isNull(r0) == true) goto L10;
        r3.put(r0, r4.opt(r0));
        goto L10
    L14:
        return r3;
    L15:
        return null;
    }

    public static void combineJson(JSONObject r3, JSONObject r4) {
        if (r3 == null) goto L19;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.length() <= 0) goto L21;
        Iterator<String> r0 = r4.keys();     // Catch: JSONException -> L12
    L9:
        if (r0.hasNext() == false) goto L22;
        String r1 = r0.next();     // Catch: JSONException -> L12
        r3.put(r1, r4.get(r1));     // Catch: JSONException -> L12
        goto L9
    L22:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        return;
    }

    public static boolean isEmpty(JSONObject r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(JSONArray r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static boolean hasData(JSONObject r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.length() <= 0) goto L6;
        return true;
    }

    public static boolean hasData(JSONArray r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.length() <= 0) goto L6;
        return true;
    }

    public static int calc(JSONObject r2) {
        StatsWriter r0 = new StatsWriter(null);     // Catch: Throwable -> L4
        JsonWriter.writeTo(r2, r0);     // Catch: Throwable -> L4
        return r0.length;
    L4:
        return 0;
    }

    public static int calc(JSONArray r3) {
        if (r3 != null) goto L8;
        return 0;
    L8:
        StatsWriter r1 = new StatsWriter(null);     // Catch: Throwable -> L7
        JsonWriter.writeTo(r3, r1);     // Catch: Throwable -> L7
        return r1.length;
    L7:
        return 0;
    }

    public static JSONObject optJSONObject(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L5;
        return null;
    L5:
        JSONObject r4 = r1.optJSONObject(r2);
        if (r4 != null) goto L9;
        return null;
    L9:
        return r4.optJSONObject(r3);
    }

    public static JSONObject optJSONObject(JSONObject r0, String r1, String r2, String r3) {
        JSONObject r4 = optJSONObject(r0, r1, r2);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.optJSONObject(r3);
    }

    public static int optInt(JSONObject r0, String r1, String r2, String r3) {
        JSONObject r4 = optJSONObject(r0, r1, r2);
        if (r4 != null) goto L6;
        return 0;
    L6:
        return r4.optInt(r3, 0);
    }

    public static boolean optBoolean(JSONObject r0, String r1, String r2, boolean r3) {
        if (r0 != null) goto L4;
        return r3;
    L4:
        JSONObject r4 = r0.optJSONObject(r1);
        if (r4 != null) goto L8;
        return r3;
    L8:
        return r4.optBoolean(r2, r3);
    }

    public static JSONObject deepCopy(JSONObject r2) {
        if (r2 != null) goto L8;
        return null;
    L8:
        return new JSONObject(r2.toString());
    L7:
        return r2;
    }

    public static JSONObject safeCopyJson2(JSONObject r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        Iterator<String> r1 = r4.keys();
        if (r1 != null) goto L15;
        return null;
    L15:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L14
    L10:
        if (r1.hasNext() == false) goto L13;
        String r2 = r1.next();     // Catch: Exception -> L14
        r0.put(r2, r4.opt(r2));     // Catch: Exception -> L14
        goto L10
    L13:
        return r0;
    L14:
        return r4;
    }

    public static JSONObject safeJsonObject(JSONObject r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator<String> r0 = r5.keys();
        if (r0 != null) goto L21;
        return r5;
    L21:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L20
    L9:
        if (r0.hasNext() == false) goto L19;
        String r2 = r0.next();     // Catch: Throwable -> L20
        Object r3 = r5.opt(r2);     // Catch: Throwable -> L20
        if ((r3 instanceof JSONObject) == true) goto L13;
        if ((r3 instanceof JSONArray) == true) goto L16;
        r1.put(r2, r3);     // Catch: Throwable -> L20
        goto L9
    L16:
        r1.put(r2, safeJsonArray((JSONArray) r3));     // Catch: Throwable -> L20
        goto L9
    L13:
        r1.put(r2, safeJsonObject((JSONObject) r3));     // Catch: Throwable -> L20
        goto L9
    L19:
        return r1;
    L20:
        return r5;
    }

    public static JSONArray safeJsonArray(JSONArray r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r0 = r5.length();
        if (r0 != 0) goto L20;
        return r5;
    L20:
        JSONArray r1 = new JSONArray();     // Catch: Throwable -> L19
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L18;
        Object r3 = r5.get(r2);     // Catch: Throwable -> L19
        if ((r3 instanceof JSONObject) == false) goto L14;
        r1.put(safeJsonObject((JSONObject) r3));     // Catch: Throwable -> L19
    L17:
        r2 = r2 + 1;
        goto L9
    L14:
        if ((r3 instanceof JSONArray) == false) goto L16;
        r1.put(safeJsonArray((JSONArray) r3));     // Catch: Throwable -> L19
        goto L17
    L16:
        r1.put(r3);     // Catch: Throwable -> L19
    L18:
        return r5;
    }
}
