package android.app.sceneperception.parser;

import android.app.ObricActivityThreadImpl;
import android.app.sceneperception.rule.Const;
import android.app.sceneperception.rule.IntentRule;
import android.app.sceneperception.utils.CollectionUtils;
import android.app.sceneperception.utils.StringUtils;
import android.os.Bundle;
import android.util.Slog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BundlePathUtil {
    private static final String TAG = "BundlePathUtil";

    private static final enum OperationType extends Enum<OperationType> {
        private static final /* synthetic */ OperationType[] $VALUES = null;
        public static final OperationType BUNDLE = null;
        public static final OperationType BUNDLE_GET = null;
        public static final OperationType JSON_PARSE = null;
        public static final OperationType OBJECT_FIELD = null;
        public static final OperationType STRING_GET = null;

        private static /* synthetic */ OperationType[] $values() {
            return new OperationType[]{BUNDLE, BUNDLE_GET, OBJECT_FIELD, STRING_GET, JSON_PARSE};
        }

        private OperationType(String r1, int r2) {
            super(r1, r2);
        }

        public static OperationType valueOf(String name) {
            return (OperationType) Enum.valueOf(OperationType.class, name);
        }

        public static OperationType[] values() {
            return (OperationType[]) $VALUES.clone();
        }

        static {
            BUNDLE = new OperationType("BUNDLE", 0);
            BUNDLE_GET = new OperationType("BUNDLE_GET", 1);
            OBJECT_FIELD = new OperationType("OBJECT_FIELD", 2);
            STRING_GET = new OperationType("STRING_GET", 3);
            JSON_PARSE = new OperationType("JSON_PARSE", 4);
            $VALUES = $values();
        }
    }

    private static class ParseOperation {
        ReturnType expectedReturnType;
        String key;
        OperationType type;

        ParseOperation(OperationType type, String key) {
            this.type = type;
            this.key = key;
            this.expectedReturnType = ReturnType.AUTO;
        }

        ParseOperation(OperationType type, String key, ReturnType returnType) {
            this.type = type;
            this.key = key;
            this.expectedReturnType = returnType;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder().append(this.type).append(":").append(this.key);
            if (this.expectedReturnType == ReturnType.AUTO) goto L5;
            String r1 = "(" + this.expectedReturnType + ")";
        L7:
            return r0.append(r1).toString();
        L5:
            r1 = "";
            goto L7
        }
    }

    private static class ParseResult {
        ReturnType expectedReturnType;
        List<ParseOperation> operations;

        ParseResult(List<ParseOperation> operations, ReturnType expectedReturnType) {
            this.operations = operations;
            this.expectedReturnType = expectedReturnType;
        }
    }

    public static final enum ReturnType extends Enum<ReturnType> {
        private static final /* synthetic */ ReturnType[] $VALUES = null;
        public static final ReturnType AUTO = null;
        public static final ReturnType BOOLEAN = null;
        public static final ReturnType DOUBLE = null;
        public static final ReturnType INT = null;
        public static final ReturnType LONG = null;
        public static final ReturnType OBJECT = null;
        public static final ReturnType STRING = null;

        private static /* synthetic */ ReturnType[] $values() {
            return new ReturnType[]{STRING, OBJECT, INT, LONG, BOOLEAN, DOUBLE, AUTO};
        }

        private ReturnType(String r1, int r2) {
            super(r1, r2);
        }

        public static ReturnType valueOf(String name) {
            return (ReturnType) Enum.valueOf(ReturnType.class, name);
        }

        public static ReturnType[] values() {
            return (ReturnType[]) $VALUES.clone();
        }

        static {
            STRING = new ReturnType("STRING", 0);
            OBJECT = new ReturnType("OBJECT", 1);
            INT = new ReturnType("INT", 2);
            LONG = new ReturnType("LONG", 3);
            BOOLEAN = new ReturnType("BOOLEAN", 4);
            DOUBLE = new ReturnType("DOUBLE", 5);
            AUTO = new ReturnType("AUTO", 6);
            $VALUES = $values();
        }
    }

    public BundlePathUtil() {
    }

    public static String getStringFromPath(Bundle bundle, List<IntentRule.PathConfig> configs) {
        Object result = getValueFromPath(bundle, configs);
        if (result != null) goto L7;
        return null;
    L7:
        return result.toString();
    }

    public static Object getValueFromPath(Bundle bundle, List<IntentRule.PathConfig> configs) {
        if (bundle != null) goto L5;
    L27:
        return null;
    L5:
        if (CollectionUtils.isEmpty(configs) == true) goto L27;
        Iterator<IntentRule.PathConfig> r1 = configs.iterator();
    L9:
        if (r1.hasNext() == false) goto L26;
        IntentRule.PathConfig config = r1.next();
        if (config == null) goto L9;
        if (StringUtils.isBlank(config.type) == true) goto L9;
        if (StringUtils.isBlank(config.path) == true) goto L9;
        Object value = extractValue(bundle, config);     // Catch: Exception -> L21
        if (isValidValue(value) == false) goto L9;
        return value;
    L21:
        e = move-exception;
        if (ObricActivityThreadImpl.DEBUG == false) goto L9;
        Slog.e(TAG, "Error extracting value with config: " + config.type + ", path: " + config.path + ", error: " + e.getMessage());
        goto L9
    L26:
        return null;
    }

    private static boolean isValidValue(Object value) {
        if (ObricActivityThreadImpl.DEBUG == false) goto L9;
        StringBuilder r0 = new StringBuilder().append("Checking value validity: ").append(value).append(" (type: ");
        if (value == null) goto L7;
        String r1 = value.getClass().getSimpleName();
    L8:
        Slog.d(TAG, r0.append(r1).append(")").toString());
        goto L9
    L7:
        r1 = "null";
    L9:
        if (value != null) goto L13;
        return false;
    L13:
        if ((value instanceof String) == false) goto L16;
        boolean isValid = StringUtils.isNotBlank((String) value);
        return isValid;
    L16:
        return true;
    }

    private static Object extractValue(Bundle bundle, IntentRule.PathConfig config) throws Exception {
        String type = config.type.toLowerCase();
        String path = config.path;
        if (ObricActivityThreadImpl.DEBUG == false) goto L7;
        Slog.d(TAG, "=== Starting extraction ===");
        Slog.d(TAG, "Type: " + type + ", Path: " + path);
        if (StringUtils.isNotBlank(config.pattern) == false) goto L7;
        Slog.d(TAG, "Pattern: " + config.pattern);
    L7:
        ParseResult parseResult = parseTypeAndPath(type, path);
        if (parseResult.operations.isEmpty() == true) goto L47;
        Object rawValue = executeOperations(bundle, parseResult.operations, ReturnType.AUTO);
        String r6 = "null";
        if (ObricActivityThreadImpl.DEBUG == false) goto L17;
        StringBuilder r5 = new StringBuilder().append("Raw value before pattern/conversion: ").append(rawValue).append(" (type: ");
        if (rawValue == null) goto L14;
        String r8 = rawValue.getClass().getSimpleName();
    L15:
        Slog.d(TAG, r5.append(r8).append(")").toString());
        goto L17
    L14:
        r8 = "null";
    L17:
        if (isValidValue(rawValue) == false) goto L19;
        Object valueAfterPattern = rawValue;
        if (StringUtils.isNotBlank(config.pattern) == false) goto L33;
        String stringValue = rawValue.toString();
        String patternResult = applyPattern(stringValue, config.pattern);
        if (ObricActivityThreadImpl.DEBUG == false) goto L27;
        Slog.d(TAG, "Pattern applied: " + stringValue + " -> " + patternResult);
    L27:
        if (patternResult == null) goto L30;
        valueAfterPattern = patternResult;
        goto L33
    L30:
        if (ObricActivityThreadImpl.DEBUG == false) goto L32;
        Slog.e(TAG, "Pattern matching failed, returning null");
    L32:
        return null;
    L33:
        Object finalResult = convertToExpectedType(valueAfterPattern, parseResult.expectedReturnType);
        if (isValidValue(finalResult) == true) goto L40;
        if (ObricActivityThreadImpl.DEBUG == false) goto L38;
        Slog.d(TAG, "Final result is invalid, returning null");
    L38:
        return null;
    L40:
        if (ObricActivityThreadImpl.DEBUG == false) goto L45;
        StringBuilder r7 = new StringBuilder().append("=== Extraction result: ").append(finalResult).append(" (type: ");
        if (finalResult == null) goto L44;
        r6 = finalResult.getClass().getSimpleName();
    L44:
        Slog.d(TAG, r7.append(r6).append(") ===").toString());
    L45:
        return finalResult;
    L19:
        if (ObricActivityThreadImpl.DEBUG == false) goto L21;
        Slog.d(TAG, "Raw value is invalid (null or empty), returning null");
    L21:
        return null;
    L47:
        throw new IllegalArgumentException("Invalid type or path: " + type + ", " + path);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v29 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v32 */
    /* JADX WARN: Type inference failed for: r15v33 */
    /* JADX WARN: Type inference failed for: r15v38 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v9 */
    private static ParseResult parseTypeAndPath(String type, String path) {
        List<ParseOperation> operations = new ArrayList();
        if (StringUtils.isBlank(type) == true) goto L103;
        if (StringUtils.isBlank(path) == true) goto L103;
        String[] typeParts = type.split("#");
        String[] pathParts = path.split("#");
        if (pathParts.length == 0) goto L10;
        String lastTypePart = typeParts[typeParts.length - 1].toLowerCase();
        ReturnType expectedReturnType = getReturnTypeFromString(lastTypePart);
        char r9 = 2;
        boolean r11 = false;
        if (typeParts.length == 1) goto L14;
    L23:
        int pathIndex = 0;
        boolean hasNonBundleObject = false;
        int i = 0;
    L25:
        if (i >= typeParts.length) goto L97;
        String typePart = typeParts[i].toLowerCase();
        switch(typePart.hashCode()) {
            case -1377881982: goto L63;
            case -1325958191: goto L60;
            case -1023368385: goto L57;
            case -891985903: goto L54;
            case 104431: goto L51;
            case 109815: goto L48;
            case 3029738: goto L45;
            case 3271912: goto L42;
            case 3327612: goto L39;
            case 64711720: goto L36;
            case 97526364: goto L33;
            case 1958052158: goto L30;
            default: goto L65;
        };
    L65:
        ?? r15 = -1;
    L66:
        switch(r15) {
            case 0: goto L91;
            case 1: goto L85;
            case 2: goto L85;
            case 3: goto L80;
            case 4: goto L72;
            case 5: goto L72;
            case 6: goto L72;
            case 7: goto L72;
            case 8: goto L72;
            case 9: goto L72;
            case 10: goto L72;
            case 11: goto L72;
            default: goto L68;
        };
    L80:
        if (hasNonBundleObject == true) goto L95;
        if (pathIndex >= pathParts.length) goto L95;
        operations.add(new ParseOperation(OperationType.STRING_GET, pathParts[pathIndex]));
        pathIndex = pathIndex + 1;
        operations.add(new ParseOperation(OperationType.JSON_PARSE, ""));
        hasNonBundleObject = true;
    L95:
        i = i + 1;
        r9 = 2;
        r11 = false;
        goto L25
    L68:
        if (pathIndex >= pathParts.length) goto L95;
        if (hasNonBundleObject == false) goto L93;
        operations.add(new ParseOperation(OperationType.OBJECT_FIELD, pathParts[pathIndex]));
    L94:
        pathIndex = pathIndex + 1;
        goto L95
    L93:
        operations.add(new ParseOperation(OperationType.BUNDLE_GET, pathParts[pathIndex]));
        hasNonBundleObject = true;
        goto L94
    L72:
        if (pathIndex >= pathParts.length) goto L95;
        if (hasNonBundleObject == false) goto L76;
        ReturnType fieldReturnType = getReturnTypeFromString(typePart);
        operations.add(new ParseOperation(OperationType.OBJECT_FIELD, pathParts[pathIndex], fieldReturnType));
    L79:
        pathIndex = pathIndex + 1;
        goto L95
    L76:
        if (typePart.equals(Const.TYPE_STRING) == false) goto L78;
        operations.add(new ParseOperation(OperationType.STRING_GET, pathParts[pathIndex]));
        goto L79
    L78:
        operations.add(new ParseOperation(OperationType.BUNDLE_GET, pathParts[pathIndex]));
        goto L79
    L85:
        if (pathIndex >= pathParts.length) goto L95;
        if (hasNonBundleObject == true) goto L88;
        operations.add(new ParseOperation(OperationType.BUNDLE_GET, pathParts[pathIndex]));
        hasNonBundleObject = true;
    L89:
        pathIndex = pathIndex + 1;
        goto L95
    L88:
        operations.add(new ParseOperation(OperationType.OBJECT_FIELD, pathParts[pathIndex]));
        goto L89
    L91:
        if (pathIndex >= pathParts.length) goto L95;
        operations.add(new ParseOperation(OperationType.BUNDLE, pathParts[pathIndex]));
        pathIndex = pathIndex + 1;
        goto L95
    L30:
        if (typePart.equals("integer") == false) goto L65;
        r15 = 6;
        goto L66
    L33:
        if (typePart.equals("float") == false) goto L65;
        r15 = 11;
        goto L66
    L36:
        if (typePart.equals("boolean") == false) goto L65;
        r15 = 8;
        goto L66
    L39:
        if (typePart.equals("long") == false) goto L65;
        r15 = 7;
        goto L66
    L42:
        if (typePart.equals("json") == false) goto L65;
        r15 = 3;
        goto L66
    L45:
        if (typePart.equals("bool") == false) goto L65;
        r15 = 9;
        goto L66
    L48:
        if (typePart.equals(Const.TYPE_OBJ) == false) goto L65;
        r15 = 1;
        goto L66
    L51:
        if (typePart.equals("int") == false) goto L65;
        r15 = 5;
        goto L66
    L54:
        if (typePart.equals(Const.TYPE_STRING) == false) goto L65;
        r15 = 4;
        goto L66
    L57:
        if (typePart.equals("object") == false) goto L65;
        r15 = r9;
        goto L66
    L60:
        if (typePart.equals("double") == false) goto L65;
        r15 = 10;
        goto L66
    L63:
        if (typePart.equals(Const.TYPE_BUNDLE) == false) goto L65;
        r15 = r11;
    L97:
        if (pathIndex >= pathParts.length) goto L100;
        operations.add(new ParseOperation(OperationType.OBJECT_FIELD, pathParts[pathIndex]));
        pathIndex = pathIndex + 1;
        goto L97
    L100:
        return new ParseResult(operations, expectedReturnType);
    L14:
        if (Const.TYPE_BUNDLE.equals(typeParts[0].toLowerCase()) == false) goto L23;
        if (pathParts.length < 2) goto L20;
        operations.add(new ParseOperation(OperationType.BUNDLE, pathParts[0]));
        operations.add(new ParseOperation(OperationType.BUNDLE_GET, pathParts[1]));
        return new ParseResult(operations, ReturnType.AUTO);
    L20:
        if (pathParts.length != 1) goto L23;
        operations.add(new ParseOperation(OperationType.BUNDLE_GET, pathParts[0]));
        return new ParseResult(operations, ReturnType.AUTO);
    L10:
        return new ParseResult(operations, ReturnType.AUTO);
    L103:
        return new ParseResult(operations, ReturnType.AUTO);
    }

    private static ReturnType getReturnTypeFromString(String typeStr) {
        if (StringUtils.isBlank(typeStr) == true) goto L5;
        String r0 = typeStr.toLowerCase();
        switch(r0.hashCode()) {
            case -1325958191: goto L37;
            case -1023368385: goto L34;
            case -891985903: goto L31;
            case 104431: goto L28;
            case 109815: goto L25;
            case 3029738: goto L22;
            case 3327612: goto L19;
            case 64711720: goto L16;
            case 97526364: goto L13;
            case 1958052158: goto L10;
            default: goto L39;
        };
    L39:
        byte r1 = -1;
    L40:
        switch(r1) {
            case 0: goto L54;
            case 1: goto L52;
            case 2: goto L52;
            case 3: goto L50;
            case 4: goto L48;
            case 5: goto L48;
            case 6: goto L46;
            case 7: goto L46;
            case 8: goto L44;
            case 9: goto L44;
            default: goto L42;
        };
    L42:
        return ReturnType.AUTO;
    L44:
        return ReturnType.OBJECT;
    L46:
        return ReturnType.DOUBLE;
    L48:
        return ReturnType.BOOLEAN;
    L50:
        return ReturnType.LONG;
    L52:
        return ReturnType.INT;
    L54:
        return ReturnType.STRING;
    L10:
        if (r0.equals("integer") == false) goto L39;
        r1 = 2;
        goto L40
    L13:
        if (r0.equals("float") == false) goto L39;
        r1 = 7;
        goto L40
    L16:
        if (r0.equals("boolean") == false) goto L39;
        r1 = 4;
        goto L40
    L19:
        if (r0.equals("long") == false) goto L39;
        r1 = 3;
        goto L40
    L22:
        if (r0.equals("bool") == false) goto L39;
        r1 = 5;
        goto L40
    L25:
        if (r0.equals(Const.TYPE_OBJ) == false) goto L39;
        r1 = 8;
        goto L40
    L28:
        if (r0.equals("int") == false) goto L39;
        r1 = 1;
        goto L40
    L31:
        if (r0.equals(Const.TYPE_STRING) == false) goto L39;
        r1 = 0;
        goto L40
    L34:
        if (r0.equals("object") == false) goto L39;
        r1 = 9;
        goto L40
    L37:
        if (r0.equals("double") == false) goto L39;
        r1 = 6;
        goto L40
    L5:
        return ReturnType.AUTO;
    }

    private static Object executeOperations(Bundle bundle, List<ParseOperation> operations, ReturnType expectedReturnType) throws Exception {
        Object currentObject = bundle;
        if (ObricActivityThreadImpl.DEBUG == false) goto L5;
        Slog.d(TAG, "Executing " + operations.size() + " operations");
    L5:
        int i = 0;
    L7:
        if (i >= operations.size()) goto L108;
        ParseOperation operation = operations.get(i);
        if (currentObject == null) goto L11;
        String key = operation.key;
        if (ObricActivityThreadImpl.DEBUG == false) goto L17;
        Slog.d(TAG, "Executing operation " + i + ": " + operation + ", current object type: " + currentObject.getClass().getSimpleName());
    L17:
        String r7 = "null";
        switch(operation.type.ordinal()) {
            case 0: goto L95;
            case 1: goto L83;
            case 2: goto L111;
            case 3: goto L43;
            case 4: goto L23;
            default: goto L20;
        };
    L111:
        currentObject = getFieldValue(currentObject, key);     // Catch: Exception -> L77
        if (ObricActivityThreadImpl.DEBUG == false) goto L106;
        StringBuilder r6 = new StringBuilder().append("OBJECT_FIELD operation result: ");     // Catch: Exception -> L77
        if (currentObject == null) goto L75;
        r7 = currentObject.toString();     // Catch: Exception -> L77
    L75:
        Slog.d(TAG, r6.append(r7).toString());     // Catch: Exception -> L77
    L106:
        i = i + 1;
    L77:
        e = move-exception;
        if (ObricActivityThreadImpl.DEBUG == false) goto L81;
        Slog.e(TAG, "OBJECT_FIELD operation failed: " + e.getMessage());
    L81:
        return null;
    L20:
        if (ObricActivityThreadImpl.DEBUG == false) goto L106;
        Slog.d(TAG, "Unknown operation type: " + operation.type);
        goto L106
    L23:
        if ((currentObject instanceof String) == false) goto L35;
        String jsonString = (String) currentObject;     // Catch: Exception -> L28
        currentObject = new JSONObject(jsonString);     // Catch: Exception -> L28
        if (ObricActivityThreadImpl.DEBUG == false) goto L106;
        Slog.d(TAG, "JSON_PARSE operation successful, created JSONObject");     // Catch: Exception -> L28
    L28:
        e = move-exception;
        if (ObricActivityThreadImpl.DEBUG == false) goto L33;
        Slog.e(TAG, "JSON_PARSE operation failed: " + e.getMessage());
    L33:
        throw new Exception("Failed to parse JSON: " + e.getMessage());
    L35:
        if (ObricActivityThreadImpl.DEBUG == false) goto L41;
        StringBuilder r4 = new StringBuilder().append("JSON_PARSE operation failed: current object is not String but ");
        if (currentObject == null) goto L39;
        r7 = currentObject.getClass().getSimpleName();
    L39:
        Slog.e(TAG, r4.append(r7).toString());
    L41:
        throw new Exception("Cannot parse non-string as JSON");
    L43:
        if ((currentObject instanceof Bundle) == false) goto L113;
        String stringValue = ((Bundle) currentObject).getString(key);
        if (ObricActivityThreadImpl.DEBUG == false) goto L48;
        Slog.d(TAG, "STRING_GET operation result: " + stringValue);
    L48:
        if (i >= (operations.size() - 1)) goto L52;
        currentObject = stringValue;
        if (ObricActivityThreadImpl.DEBUG == false) goto L106;
        Slog.d(TAG, "STRING_GET: continuing with more operations");
        goto L106
    L52:
        currentObject = stringValue;
        goto L106
    L113:
        Object value = getFieldValue(currentObject, key);     // Catch: Exception -> L65
        if (ObricActivityThreadImpl.DEBUG == false) goto L58;
        Slog.d(TAG, "STRING_GET (from object) operation result: " + value);     // Catch: Exception -> L65
    L58:
        if (i >= (operations.size() - 1)) goto L63;
        currentObject = value;
        if (ObricActivityThreadImpl.DEBUG == false) goto L106;
        Slog.d(TAG, "STRING_GET (from object): continuing with more operations");     // Catch: Exception -> L65
        goto L106
    L63:
        currentObject = value;
    L65:
        e = move-exception;
        if (ObricActivityThreadImpl.DEBUG == false) goto L69;
        Slog.e(TAG, "STRING_GET (from object) operation failed: " + e.getMessage());
    L69:
        return null;
    L83:
        if ((currentObject instanceof Bundle) == false) goto L91;
        currentObject = ((Bundle) currentObject).get(key);
        if (ObricActivityThreadImpl.DEBUG == false) goto L106;
        StringBuilder r5 = new StringBuilder().append("BUNDLE_GET operation result: ");
        if (currentObject == null) goto L89;
        r7 = currentObject.getClass().getSimpleName();
    L89:
        Slog.d(TAG, r5.append(r7).toString());
        goto L106
    L91:
        if (ObricActivityThreadImpl.DEBUG == false) goto L93;
        Slog.e(TAG, "BUNDLE_GET operation failed: current object is not Bundle");
    L93:
        return null;
    L95:
        if ((currentObject instanceof Bundle) == false) goto L103;
        currentObject = ((Bundle) currentObject).getBundle(key);
        if (ObricActivityThreadImpl.DEBUG == false) goto L106;
        StringBuilder r8 = new StringBuilder().append("BUNDLE operation result: ");
        if (currentObject == null) goto L101;
        r7 = "Bundle";
    L101:
        Slog.d(TAG, r8.append(r7).toString());
        goto L106
    L103:
        if (ObricActivityThreadImpl.DEBUG == false) goto L105;
        Slog.e(TAG, "BUNDLE operation failed: current object is not Bundle");
    L105:
        return null;
    L11:
        if (ObricActivityThreadImpl.DEBUG == false) goto L13;
        Slog.d(TAG, "Current object is null at operation " + i);
    L13:
        return null;
    L108:
        return convertToExpectedType(currentObject, expectedReturnType);
    }

    private static Object convertToExpectedType(Object value, ReturnType expectedReturnType) {
        if (value != null) goto L6;
        return null;
    L6:
        if (ObricActivityThreadImpl.DEBUG == false) goto L9;
        Slog.d(TAG, "Converting value: " + value + " to type: " + expectedReturnType);
    L9:
        switch(expectedReturnType.ordinal()) {
            case 0: goto L51;
            case 1: goto L49;
            case 2: goto L39;
            case 3: goto L28;
            case 4: goto L23;
            case 5: goto L12;
            default: goto L10;
        };
    L10:
        return value;
    L49:
        return value;
    L12:
        if ((value instanceof Number) == true) goto L14;
        return Double.valueOf(Double.parseDouble(value.toString()));
    L19:
        if (ObricActivityThreadImpl.DEBUG == false) goto L21;
        Slog.e(TAG, "Failed to convert to double: " + value);
    L21:
        return null;
    L14:
        return Double.valueOf(((Number) value).doubleValue());
    L23:
        if ((value instanceof Boolean) == false) goto L26;
        return value;
    L26:
        return Boolean.valueOf(Boolean.parseBoolean(value.toString()));
    L28:
        if ((value instanceof Number) == true) goto L30;
        return Long.valueOf(Long.parseLong(value.toString()));
    L35:
        if (ObricActivityThreadImpl.DEBUG == false) goto L37;
        Slog.e(TAG, "Failed to convert to long: " + value);
    L37:
        return null;
    L30:
        return Long.valueOf(((Number) value).longValue());
    L39:
        if ((value instanceof Number) == true) goto L41;
        return Integer.valueOf(Integer.parseInt(value.toString()));
    L46:
        if (ObricActivityThreadImpl.DEBUG == false) goto L48;
        Slog.e(TAG, "Failed to convert to int: " + value);
    L48:
        return null;
    L41:
        return Integer.valueOf(((Number) value).intValue());
    L51:
        return value.toString();
    }

    public static void printAllFieldsIncludingInherited(Object instance) {
        if (ObricActivityThreadImpl.DEBUG == true) goto L5;
        return;
    L5:
        Class<?> originalClass = instance.getClass();
        Slog.d(TAG, "实例 " + originalClass.getSimpleName() + " 的所有字段和值（包括继承）:");
        int totalFields = 0;
        int level = 0;
        Class<?> clazz = originalClass;
    L6:
        if (clazz == null) goto L45;
        if (clazz == Object.class) goto L45;
        String indent = "  " + "  ".repeat(level);
        boolean r6 = true;
        if (level != 0) goto L12;
        String classType = "【当前类】";
    L15:
        Slog.d(TAG, classType + " " + clazz.getSimpleName() + ":");
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length != 0) goto L18;
        Slog.d(TAG, indent + "[无字段]");
        Class<?> originalClass2 = originalClass;
    L44:
        Slog.d(TAG, "\r\n");
        clazz = clazz.getSuperclass();
        level = level + 1;
        originalClass = originalClass2;
        goto L6
    L18:
        int r9 = fields.length;
        int r11 = 0;
        int totalFields2 = totalFields;
    L19:
        if (r11 >= r9) goto L43;
        Field field = fields[r11];
        field.setAccessible(r6);     // Catch: IllegalAccessException -> L38
        Object value = field.get(instance);     // Catch: IllegalAccessException -> L36
        String modifiers = Modifier.toString(field.getModifiers());     // Catch: IllegalAccessException -> L36
        String r7 = indent + "%-18s = %-18s [%s %s]%n";     // Catch: IllegalAccessException -> L36
        String r15 = field.getName();     // Catch: IllegalAccessException -> L36
        if (value != null) goto L53;
        Object value2 = "null";
    L30:
        Class<?> originalClass3 = originalClass;
        Slog.d(TAG, String.format(r7, new Object[]{r15, value2, modifiers, field.getType().getSimpleName()}));     // Catch: IllegalAccessException -> L34
        totalFields2 = totalFields2 + 1;
    L42:
        r11 = r11 + 1;
        originalClass = originalClass3;
        r6 = true;
    L34:
        e = e;
    L41:
        Slog.d(TAG, indent + field.getName() + " = [无法访问: " + e.getMessage() + "]");
        goto L42
    L53:
        value2 = value.toString();     // Catch: IllegalAccessException -> L27
    L27:
        e = e;
        originalClass3 = originalClass;
    L36:
        e = e;
    L40:
        originalClass3 = originalClass;
    L38:
        e = e;
        goto L40
    L43:
        originalClass2 = originalClass;
        totalFields = totalFields2;
        goto L44
    L12:
        if (level != 1) goto L14;
        classType = "【直接父类】";
        goto L15
    L14:
        classType = "【祖先类 " + level + " 级】";
    L45:
        Slog.d(TAG, "继承层级: " + level + " 层，总字段数: " + totalFields);
    }

    private static Object getFieldValue(Object obj, String fieldName) throws Exception {
        if (obj != null) goto L5;
    L28:
        return null;
    L5:
        if (StringUtils.isBlank(fieldName) == true) goto L28;
        if ((obj instanceof JSONObject) == false) goto L26;
        JSONObject jsonObj = (JSONObject) obj;
    L21:
        e = move-exception;
        if (ObricActivityThreadImpl.DEBUG == false) goto L25;
        Slog.e(TAG, "JSONObject field access failed: " + e.getMessage());
    L25:
        return null;
    L12:
        if (jsonObj.has(fieldName) == false) goto L18;
        Object value = jsonObj.get(fieldName);     // Catch: Exception -> L21
        if (ObricActivityThreadImpl.DEBUG == false) goto L16;
        Slog.d(TAG, "JSONObject field '" + fieldName + "' found: " + value);     // Catch: Exception -> L21
    L16:
        return value;
    L18:
        if (ObricActivityThreadImpl.DEBUG == false) goto L20;
        Slog.d(TAG, "JSONObject field '" + fieldName + "' not found");     // Catch: Exception -> L21
    L20:
        return null;
    L26:
        Class<?> clazz = obj.getClass();
        return getFieldValueFromInheritanceChain(obj, fieldName, clazz);
    }

    private static String capitalizeFirstLetter(String str) {
        if (str != null) goto L4;
    L8:
        return str;
    L4:
        if (str.isEmpty() == true) goto L8;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static Object getFieldValueFromInheritanceChain(Object obj, String fieldName, Class<?> startClass) throws Exception {
        Class<?> currentClass = startClass;
    L3:
        if (currentClass == null) goto L18;
        if (currentClass == Object.class) goto L18;
        Field field = currentClass.getDeclaredField(fieldName);     // Catch: NoSuchFieldException -> L9
        field.setAccessible(true);     // Catch: NoSuchFieldException -> L9
        Object value = field.get(obj);     // Catch: NoSuchFieldException -> L9
        return value;
    L23:
        String getterName = "get" + capitalizeFirstLetter(fieldName);     // Catch: NoSuchMethodException -> L13
        Method getter = currentClass.getDeclaredMethod(getterName, new Class[0]);     // Catch: NoSuchMethodException -> L13
        getter.setAccessible(true);     // Catch: NoSuchMethodException -> L13
        Object value2 = getter.invoke(obj, new Object[0]);     // Catch: NoSuchMethodException -> L13
        return value2;
    L25:
        String isName = "is" + capitalizeFirstLetter(fieldName);     // Catch: NoSuchMethodException -> L16
        Method isMethod = currentClass.getDeclaredMethod(isName, new Class[0]);     // Catch: NoSuchMethodException -> L16
        isMethod.setAccessible(true);     // Catch: NoSuchMethodException -> L16
        Object value3 = isMethod.invoke(obj, new Object[0]);     // Catch: NoSuchMethodException -> L16
        return value3;
    L17:
        currentClass = currentClass.getSuperclass();
    L18:
        String errorMsg = "Field/Method '" + fieldName + "' not found in class hierarchy of " + startClass.getName();
        if (ObricActivityThreadImpl.DEBUG == false) goto L34;
        Slog.e(TAG, errorMsg);
        return null;
    L34:
        return null;
    }

    public static String applyPattern(String value, String patternStr) {
        if (StringUtils.isBlank(value) == false) goto L5;
    L22:
        return value;
    L5:
        if (StringUtils.isBlank(patternStr) == true) goto L22;
        Pattern pattern = Pattern.compile(patternStr);     // Catch: Exception -> L16
        Matcher matcher = pattern.matcher(value);     // Catch: Exception -> L16
        if (matcher.find() == true) goto L10;
        return null;
    L10:
        if (matcher.groupCount() <= 0) goto L14;
        return matcher.group(1);
    L14:
        return matcher.group(0);
    L16:
        e = move-exception;
        if (ObricActivityThreadImpl.DEBUG == false) goto L24;
        Slog.e(TAG, "Error applying pattern '" + patternStr + "' to value '" + value + "': " + e.getMessage());
        return null;
    L24:
        return null;
    }
}
