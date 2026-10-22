package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
final class MessageSchema<T> implements Schema<T> {
    private static final int CHECK_INITIALIZED_BIT = 1024;
    private static final int[] EMPTY_INT_ARRAY = null;
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int HAS_HAS_BIT = 4096;
    private static final int INTS_PER_FIELD = 3;
    private static final int LEGACY_ENUM_IS_CLOSED_BIT = 2048;
    private static final int LEGACY_ENUM_IS_CLOSED_MASK = Integer.MIN_VALUE;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_BIT = 256;
    private static final int REQUIRED_MASK = 268435456;
    private static final Unsafe UNSAFE = null;
    private static final int UTF8_CHECK_BIT = 512;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final int repeatedFieldOffsetStart;
    private final ProtoSyntax syntax;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.MessageSchema$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            r0[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L60:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L56:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L62:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L70:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L64:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L66:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L52:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L58:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L48:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L68:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L38:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;     // Catch: NoSuchFieldError -> L37
            return;
        }
    }

    private static boolean isEnforceUtf8(int value) {
        if ((value & 536870912) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isLegacyEnumIsClosed(int value) {
        if ((value & Integer.MIN_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isRequired(int value) {
        if ((value & 268435456) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static long offset(int value) {
        return value & 1048575;
    }

    private static int type(int value) {
        return (value & FIELD_TYPE_MASK) >>> 20;
    }

    static {
        EMPTY_INT_ARRAY = new int[0];
        UNSAFE = UnsafeUtil.getUnsafe();
    }

    private MessageSchema(int[] buffer, Object[] objects, int minFieldNumber, int maxFieldNumber, MessageLite defaultInstance, ProtoSyntax syntax, boolean useCachedSizeField, int[] intArray, int checkInitialized, int mapFieldPositions, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = buffer;
        this.objects = objects;
        this.minFieldNumber = minFieldNumber;
        this.maxFieldNumber = maxFieldNumber;
        this.lite = defaultInstance instanceof GeneratedMessageLite;
        this.syntax = syntax;
        if (extensionSchema != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this.hasExtensions = r1;
        this.useCachedSizeField = useCachedSizeField;
        this.intArray = intArray;
        this.checkInitializedCount = checkInitialized;
        this.repeatedFieldOffsetStart = mapFieldPositions;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = defaultInstance;
        this.mapFieldSchema = mapFieldSchema;
        return;
    L5:
        if (extensionSchema.hasExtensions(defaultInstance) == false) goto L7;
        r1 = true;
        goto L8
    }

    static <T> MessageSchema<T> newSchema(Class<T> messageClass, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if ((messageInfo instanceof RawMessageInfo) == false) goto L7;
        return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    L7:
        return newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        String r0 = messageInfo.getStringInfo();
        int r1 = r0.length();
        char r5 = 55296;
        if (r0.charAt(0) < 55296) goto L8;
        int r3 = 1;
    L5:
        int r6 = r3 + 1;
        if (r0.charAt(r3) < 55296) goto L9;
        r3 = r6;
    L9:
        int r4 = r6 + 1;
        int r7 = r0.charAt(r6);
        if (r7 < 55296) goto L16;
        int r8 = r7 & 8191;
        int r9 = 13;
    L12:
        int r10 = r4 + 1;
        char r11 = r0.charAt(r4);
        if (r11 < 55296) goto L15;
        r8 = r8 | ((r11 & 8191) << r9);
        r9 = r9 + 13;
        r4 = r10;
        goto L12
    L15:
        r7 = r8 | (r11 << r9);
        r4 = r10;
    L16:
        if (r7 != 0) goto L18;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
        int[] r18 = EMPTY_INT_ARRAY;
        int r19 = 0;
    L75:
        Unsafe r20 = UNSAFE;
        Object[] r21 = messageInfo.getObjects();
        Class<?> r110 = messageInfo.getDefaultInstance().getClass();
        int[] r2 = new int[r12 * 3];
        Object[] r111 = new Object[r12 * 2];
        int r112 = r17 + r13;
        int r22 = r17;
        int r23 = r112;
        int r113 = 0;
        int r24 = 0;
    L76:
        if (r4 >= r1) goto L199;
        int r25 = r4 + 1;
        int r26 = r0.charAt(r4);
        if (r26 < r5) goto L84;
        int r27 = r26 & 8191;
        int r28 = r25;
        int r29 = 13;
    L80:
        int r210 = r28 + 1;
        char r30 = r0.charAt(r28);
        if (r30 < r5) goto L83;
        r27 = r27 | ((r30 & 8191) << r29);
        r29 = r29 + 13;
        r28 = r210;
        goto L80
    L83:
        r26 = r27 | (r30 << r29);
        int r31 = r210;
    L85:
        int r211 = r31 + 1;
        int r32 = r0.charAt(r31);
        if (r32 < r5) goto L92;
        int r33 = r32 & 8191;
        int r34 = r211;
        int r212 = 13;
    L88:
        int r213 = r34 + 1;
        char r35 = r0.charAt(r34);
        if (r35 < r5) goto L91;
        r33 = r33 | ((r35 & 8191) << r212);
        r212 = r212 + 13;
        r34 = r213;
        goto L88
    L91:
        r32 = r33 | (r35 << r212);
        int r36 = r213;
    L93:
        int r37 = r32 & 255;
        int r214 = r1;
        if ((r32 & 1024) == 0) goto L96;
        r18[r113] = r24;
        r113 = r113 + 1;
    L96:
        int r215 = r113;
        if (r37 < 51) goto L128;
        int r38 = r36 + 1;
        int r39 = r0.charAt(r36);
        char r114 = 55296;
        if (r39 < 55296) goto L105;
        int r40 = r39 & 8191;
        int r310 = 13;
    L101:
        int r311 = r38 + 1;
        char r41 = r0.charAt(r38);
        if (r41 < r114) goto L104;
        r40 = r40 | ((r41 & 8191) << r310);
        r310 = r310 + 13;
        r38 = r311;
        r114 = 55296;
        goto L101
    L104:
        r39 = r40 | (r41 << r310);
        r38 = r311;
    L105:
        int r115 = r37 - 51;
        int r312 = r38;
        if (r115 != 9) goto L108;
    L117:
        int r116 = r16 + 1;
        r111[((r24 / 3) * 2) + 1] = r21[r16];
    L118:
        r16 = r116;
    L119:
        int r42 = r39 * 2;
        Object r43 = r21[r42];
        if ((r43 instanceof java.lang.reflect.Field) == false) goto L122;
        java.lang.reflect.Field r44 = (java.lang.reflect.Field) r43;
    L123:
        int r45 = (int) r20.objectFieldOffset(r44);
        int r46 = r42 + 1;
        Object r117 = r21[r46];
        if ((r117 instanceof java.lang.reflect.Field) == false) goto L126;
        java.lang.reflect.Field r118 = (java.lang.reflect.Field) r117;
    L127:
        r0 = r0;
        int r47 = (int) r20.objectFieldOffset(r118);
        int r119 = r312;
        int r48 = 0;
    L185:
        int r120 = r24 + 1;
        r2[r24] = r26;
        int r49 = r120 + 1;
        int r216 = r19;
        if ((r32 & 512) == 0) goto L188;
        int r50 = 536870912;
    L189:
        Unsafe r217 = r20;
        if ((r32 & 256) == 0) goto L192;
        int r51 = 268435456;
    L193:
        int r52 = r50 | r51;
        if ((r32 & 2048) == 0) goto L196;
        int r53 = Integer.MIN_VALUE;
    L197:
        r2[r120] = r45 | ((r37 << 20) | (r52 | r53));
        int r54 = r49 + 1;
        r2[r49] = r47 | (r48 << 20);
        r4 = r119;
        r19 = r216;
        r20 = r217;
        r113 = r215;
        r0 = r0;
        r14 = r14;
        r5 = 55296;
        r24 = r54;
        r1 = r214;
        goto L76
    L196:
        r53 = 0;
        goto L197
    L192:
        r51 = 0;
        goto L193
    L188:
        r50 = 0;
        goto L189
    L126:
        r118 = reflectField(r110, (String) r117);
        r21[r46] = r118;
        goto L127
    L122:
        r44 = reflectField(r110, (String) r43);
        r21[r42] = r44;
        goto L123
    L108:
        if (r115 == 17) goto L117;
        if (r115 != 12) goto L119;
        if (messageInfo.getSyntax().equals(ProtoSyntax.PROTO2) == false) goto L115;
    L116:
        r116 = r16 + 1;
        r111[((r24 / 3) * 2) + 1] = r21[r16];
        goto L118
    L115:
        if ((r32 & 2048) == 0) goto L119;
    L128:
        int r55 = r16 + 1;
        java.lang.reflect.Field r121 = reflectField(r110, (String) r21[r16]);
        if (r37 != 9) goto L131;
    L158:
        boolean r122 = true;
        r111[((r24 / 3) * 2) + 1] = r121.getType();
    L159:
        int r123 = (int) r20.objectFieldOffset(r121);
        if ((r32 & 4096) == 0) goto L162;
        boolean r124 = r122;
    L163:
        if (r124 == true) goto L165;
    L178:
        r47 = 1048575;
        r119 = r36;
        r48 = 0;
    L180:
        if (r37 >= 18) goto L182;
    L184:
        r45 = r123;
        r16 = r55;
        goto L185
    L182:
        if (r37 > 49) goto L184;
        r18[r23] = r123;
        r23 = r23 + 1;
        goto L184
    L165:
        if (r37 > 17) goto L178;
        r119 = r36 + 1;
        int r56 = r0.charAt(r36);
        if (r56 < 55296) goto L173;
        int r57 = r56 & 8191;
        int r218 = 13;
    L169:
        int r219 = r119 + 1;
        char r125 = r0.charAt(r119);
        if (r125 < 55296) goto L172;
        r57 = r57 | ((r125 & 8191) << r218);
        r218 = r218 + 13;
        r119 = r219;
        goto L169
    L172:
        r56 = r57 | (r125 << r218);
        r119 = r219;
    L173:
        int r220 = (r19 * 2) + (r56 / 32);
        Object r126 = r21[r220];
        if ((r126 instanceof java.lang.reflect.Field) == false) goto L176;
        java.lang.reflect.Field r127 = (java.lang.reflect.Field) r126;
    L177:
        r47 = (int) r20.objectFieldOffset(r127);
        r48 = r56 % 32;
        goto L180
    L176:
        r127 = reflectField(r110, (String) r126);
        r21[r220] = r127;
        goto L177
    L162:
        r124 = false;
        goto L163
    L131:
        if (r37 == 17) goto L158;
        if (r37 == 27) goto L156;
        if (r37 == 49) goto L156;
        if (r37 == 12) goto L152;
        if (r37 == 30) goto L152;
        if (r37 == 44) goto L152;
        if (r37 != 50) goto L150;
        int r128 = r22 + 1;
        r18[r22] = r24;
        int r221 = (r24 / 3) * 2;
        int r222 = r55 + 1;
        r111[r221] = r21[r55];
        if ((r32 & 2048) == 0) goto L149;
        r55 = r222 + 1;
        r111[r221 + 1] = r21[r222];
        r22 = r128;
        goto L150
    L149:
        r22 = r128;
        r55 = r222;
    L150:
        r122 = true;
    L152:
        if (messageInfo.getSyntax() != ProtoSyntax.PROTO2) goto L154;
    L155:
        r122 = true;
        int r223 = r55 + 1;
        r111[((r24 / 3) * 2) + 1] = r21[r55];
    L157:
        r55 = r223;
        goto L159
    L154:
        if ((r32 & 2048) == 0) goto L150;
    L156:
        r122 = true;
        r223 = r55 + 1;
        r111[((r24 / 3) * 2) + 1] = r21[r55];
        goto L157
    L92:
        r36 = r211;
        goto L93
    L84:
        r31 = r25;
        goto L85
    L199:
        return new MessageSchema(r2, r111, r14, r15, messageInfo.getDefaultInstance(), messageInfo.getSyntax(), false, r18, r17, r112, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    L18:
        int r58 = r4 + 1;
        int r59 = r0.charAt(r4);
        if (r59 < 55296) goto L25;
        int r60 = r59 & 8191;
        int r61 = 13;
    L21:
        int r62 = r58 + 1;
        char r63 = r0.charAt(r58);
        if (r63 < 55296) goto L24;
        r60 = r60 | ((r63 & 8191) << r61);
        r61 = r61 + 13;
        r58 = r62;
        goto L21
    L24:
        r59 = r60 | (r63 << r61);
        r58 = r62;
    L25:
        int r64 = r58 + 1;
        int r65 = r0.charAt(r58);
        if (r65 < 55296) goto L32;
        int r66 = r65 & 8191;
        int r67 = 13;
    L28:
        int r129 = r64 + 1;
        char r68 = r0.charAt(r64);
        if (r68 < 55296) goto L31;
        r66 = r66 | ((r68 & 8191) << r67);
        r67 = r67 + 13;
        r64 = r129;
        goto L28
    L31:
        r65 = r66 | (r68 << r67);
        r64 = r129;
    L32:
        int r69 = r64 + 1;
        int r70 = r0.charAt(r64);
        if (r70 < 55296) goto L39;
        int r71 = r70 & 8191;
        int r130 = 13;
    L35:
        int r131 = r69 + 1;
        char r72 = r0.charAt(r69);
        if (r72 < 55296) goto L38;
        r71 = r71 | ((r72 & 8191) << r130);
        r130 = r130 + 13;
        r69 = r131;
        goto L35
    L38:
        r70 = r71 | (r72 << r130);
        r69 = r131;
    L39:
        int r132 = r69 + 1;
        int r73 = r0.charAt(r69);
        if (r73 < 55296) goto L46;
        int r74 = r73 & 8191;
        int r133 = 13;
    L42:
        int r134 = r132 + 1;
        char r135 = r0.charAt(r132);
        if (r135 < 55296) goto L45;
        r74 = r74 | ((r135 & 8191) << r133);
        r133 = r133 + 13;
        r132 = r134;
        goto L42
    L45:
        r73 = r74 | (r135 << r133);
        r132 = r134;
    L46:
        int r136 = r132 + 1;
        r12 = r0.charAt(r132);
        if (r12 < 55296) goto L53;
        int r137 = r12 & 8191;
        int r138 = 13;
    L49:
        int r139 = r136 + 1;
        char r140 = r0.charAt(r136);
        if (r140 < 55296) goto L52;
        r137 = r137 | ((r140 & 8191) << r138);
        r138 = r138 + 13;
        r136 = r139;
        goto L49
    L52:
        r12 = r137 | (r140 << r138);
        r136 = r139;
    L53:
        int r141 = r136 + 1;
        r13 = r0.charAt(r136);
        if (r13 < 55296) goto L60;
        int r142 = r13 & 8191;
        int r143 = 13;
    L56:
        int r144 = r141 + 1;
        char r145 = r0.charAt(r141);
        if (r145 < 55296) goto L59;
        r142 = r142 | ((r145 & 8191) << r143);
        r143 = r143 + 13;
        r141 = r144;
        goto L56
    L59:
        r13 = r142 | (r145 << r143);
        r141 = r144;
    L60:
        int r146 = r141 + 1;
        int r147 = r0.charAt(r141);
        if (r147 < 55296) goto L67;
        int r148 = r147 & 8191;
        int r149 = 13;
    L63:
        int r150 = r146 + 1;
        char r151 = r0.charAt(r146);
        if (r151 < 55296) goto L66;
        r148 = r148 | ((r151 & 8191) << r149);
        r149 = r149 + 13;
        r146 = r150;
        goto L63
    L66:
        r147 = r148 | (r151 << r149);
        r146 = r150;
    L67:
        int r152 = r146 + 1;
        int r153 = r0.charAt(r146);
        if (r153 < 55296) goto L74;
        int r154 = r153 & 8191;
        int r155 = 13;
    L70:
        int r156 = r152 + 1;
        char r157 = r0.charAt(r152);
        if (r157 < 55296) goto L73;
        r154 = r154 | ((r157 & 8191) << r155);
        r155 = r155 + 13;
        r152 = r156;
        goto L70
    L73:
        r153 = r154 | (r157 << r155);
        r152 = r156;
    L74:
        r16 = (r59 * 2) + r65;
        r19 = r59;
        r18 = new int[(r153 + r13) + r147];
        r17 = r153;
        r4 = r152;
        r14 = r70;
        r15 = r73;
        goto L75
    L8:
        r6 = 1;
        goto L9
    }

    private static java.lang.reflect.Field reflectField(Class<?> messageClass, String fieldName) {
        return messageClass.getDeclaredField(fieldName);
    L4:
        java.lang.reflect.Field[] r0 = messageClass.getDeclaredFields();
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L11;
        java.lang.reflect.Field r3 = r0[r2];
        if (fieldName.equals(r3.getName()) == true) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        return r3;
    L11:
        throw new RuntimeException("Field " + fieldName + " for " + messageClass.getName() + " not found. Known fields are " + Arrays.toString(r0));
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        FieldInfo[] r0 = messageInfo.getFields();
        if (r0.length != 0) goto L5;
        int r7 = 0;
        int r8 = 0;
    L6:
        int r1 = r0.length;
        int[] r5 = new int[r1 * 3];
        Object[] r6 = new Object[r1 * 2];
        int r2 = r0.length;
        int r3 = 0;
        int r4 = 0;
        int r9 = 0;
    L8:
        if (r3 >= r2) goto L18;
        FieldInfo r12 = r0[r3];
        if (r12.getType() != FieldType.MAP) goto L13;
        r4 = r4 + 1;
    L17:
        r3 = r3 + 1;
        goto L8
    L13:
        if (r12.getType().id() < 18) goto L17;
        if (r12.getType().id() > 49) goto L17;
        r9 = r9 + 1;
        goto L17
    L18:
        int[] r10 = null;
        if (r4 <= 0) goto L21;
        int[] r11 = new int[r4];
    L22:
        if (r9 <= 0) goto L24;
        r10 = new int[r9];
    L24:
        int[] r13 = messageInfo.getCheckInitialized();
        if (r13 != null) goto L27;
        r13 = EMPTY_INT_ARRAY;
    L27:
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
    L29:
        if (r14 >= r0.length) goto L45;
        FieldInfo r19 = r0[r14];
        int r110 = r19.getFieldNumber();
        storeFieldData(r19, r5, r15, r6);
        if (r16 >= r13.length) goto L36;
        if (r13[r16] != r110) goto L36;
        r13[r16] = r15;
        r16 = r16 + 1;
    L36:
        if (r19.getType() != FieldType.MAP) goto L40;
        r11[r17] = r15;
        r17 = r17 + 1;
    L44:
        r14 = r14 + 1;
        r15 = r15 + 3;
        goto L29
    L40:
        if (r19.getType().id() < 18) goto L44;
        if (r19.getType().id() > 49) goto L44;
        r10[r18] = (int) UnsafeUtil.objectFieldOffset(r19.getField());
        r18 = r18 + 1;
        goto L44
    L45:
        if (r11 != null) goto L47;
        r11 = EMPTY_INT_ARRAY;
    L47:
        if (r10 != null) goto L49;
        r10 = EMPTY_INT_ARRAY;
    L49:
        int[] r111 = new int[(r13.length + r11.length) + r10.length];
        System.arraycopy(r13, 0, r111, 0, r13.length);
        System.arraycopy(r11, 0, r111, r13.length, r11.length);
        System.arraycopy(r10, 0, r111, r13.length + r11.length, r10.length);
        return new MessageSchema(r5, r6, r7, r8, messageInfo.getDefaultInstance(), messageInfo.getSyntax(), true, r111, r13.length, r13.length + r11.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    L21:
        r11 = null;
        goto L22
    L5:
        r7 = r0[0].getFieldNumber();
        r8 = r0[r0.length - 1].getFieldNumber();
        goto L6
    }

    private static void storeFieldData(FieldInfo fi, int[] buffer, int bufferIndex, Object[] objects) {
        OneofInfo r0 = fi.getOneof();
        int r1 = 0;
        if (r0 == null) goto L6;
        int r2 = fi.getType().id() + 51;
        int r3 = (int) UnsafeUtil.objectFieldOffset(r0.getValueField());
        long r4 = UnsafeUtil.objectFieldOffset(r0.getCaseField());
    L5:
        int r5 = (int) r4;
        int r6 = 0;
    L19:
        buffer[bufferIndex] = fi.getFieldNumber();
        int r7 = bufferIndex + 1;
        if (fi.isEnforceUtf8() == false) goto L22;
        int r8 = 536870912;
    L24:
        if (fi.isRequired() == false) goto L26;
        r1 = 268435456;
    L26:
        buffer[r7] = ((r1 | r8) | (r2 << 20)) | r3;
        buffer[bufferIndex + 2] = r5 | (r6 << 20);
        Class<?> r9 = fi.getMessageFieldClass();
        if (fi.getMapDefaultEntry() == null) goto L34;
        int r10 = (bufferIndex / 3) * 2;
        objects[r10] = fi.getMapDefaultEntry();
        if (r9 == null) goto L32;
        objects[r10 + 1] = r9;
        return;
    L32:
        if (fi.getEnumVerifier() == null) goto L41;
        objects[r10 + 1] = fi.getEnumVerifier();
        return;
    L41:
        return;
    L34:
        if (r9 == null) goto L37;
        objects[((bufferIndex / 3) * 2) + 1] = r9;
        return;
    L37:
        if (fi.getEnumVerifier() == null) goto L44;
        objects[((bufferIndex / 3) * 2) + 1] = fi.getEnumVerifier();
        return;
    L44:
        return;
    L22:
        r8 = 0;
        goto L24
    L6:
        FieldType r11 = fi.getType();
        r3 = (int) UnsafeUtil.objectFieldOffset(fi.getField());
        r2 = r11.id();
        if (r11.isList() == true) goto L16;
        if (r11.isMap() == true) goto L16;
        java.lang.reflect.Field r12 = fi.getPresenceField();
        if (r12 != null) goto L13;
        r5 = 1048575;
    L14:
        r6 = Integer.numberOfTrailingZeros(fi.getPresenceMask());
        goto L19
    L13:
        r5 = (int) UnsafeUtil.objectFieldOffset(r12);
    L16:
        if (fi.getCachedSizeField() != null) goto L18;
        r5 = 0;
        r6 = 0;
        goto L19
    L18:
        r4 = UnsafeUtil.objectFieldOffset(fi.getCachedSizeField());
        goto L5
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public boolean equals(T message, T other) {
        int r0 = this.buffer.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (equals(message, other, r2) == false) goto L6;
        r2 = r2 + 3;
        goto L3
    L6:
        return false;
    L9:
        if (this.unknownFieldSchema.getFromMessage(message).equals(this.unknownFieldSchema.getFromMessage(other)) == true) goto L12;
        return false;
    L12:
        if (this.hasExtensions == true) goto L14;
        return true;
    L14:
        return this.extensionSchema.getExtensions(message).equals(this.extensionSchema.getExtensions(other));
    }

    private boolean equals(T message, T other, int pos) {
        int r0 = typeAndOffsetAt(pos);
        long r1 = offset(r0);
        switch(type(r0)) {
            case 0: goto L118;
            case 1: goto L112;
            case 2: goto L106;
            case 3: goto L100;
            case 4: goto L94;
            case 5: goto L88;
            case 6: goto L82;
            case 7: goto L76;
            case 8: goto L70;
            case 9: goto L64;
            case 10: goto L58;
            case 11: goto L52;
            case 12: goto L46;
            case 13: goto L40;
            case 14: goto L34;
            case 15: goto L28;
            case 16: goto L22;
            case 17: goto L16;
            case 18: goto L14;
            case 19: goto L14;
            case 20: goto L14;
            case 21: goto L14;
            case 22: goto L14;
            case 23: goto L14;
            case 24: goto L14;
            case 25: goto L14;
            case 26: goto L14;
            case 27: goto L14;
            case 28: goto L14;
            case 29: goto L14;
            case 30: goto L14;
            case 31: goto L14;
            case 32: goto L14;
            case 33: goto L14;
            case 34: goto L14;
            case 35: goto L14;
            case 36: goto L14;
            case 37: goto L14;
            case 38: goto L14;
            case 39: goto L14;
            case 40: goto L14;
            case 41: goto L14;
            case 42: goto L14;
            case 43: goto L14;
            case 44: goto L14;
            case 45: goto L14;
            case 46: goto L14;
            case 47: goto L14;
            case 48: goto L14;
            case 49: goto L14;
            case 50: goto L12;
            case 51: goto L6;
            case 52: goto L6;
            case 53: goto L6;
            case 54: goto L6;
            case 55: goto L6;
            case 56: goto L6;
            case 57: goto L6;
            case 58: goto L6;
            case 59: goto L6;
            case 60: goto L6;
            case 61: goto L6;
            case 62: goto L6;
            case 63: goto L6;
            case 64: goto L6;
            case 65: goto L6;
            case 66: goto L6;
            case 67: goto L6;
            case 68: goto L6;
            default: goto L4;
        };
    L4:
        return true;
    L6:
        if (isOneofCaseEqual(message, other, pos) == true) goto L8;
        return false;
    L8:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(message, r1), UnsafeUtil.getObject(other, r1)) == true) goto L10;
        return false;
    L10:
        return true;
    L12:
        return SchemaUtil.safeEquals(UnsafeUtil.getObject(message, r1), UnsafeUtil.getObject(other, r1));
    L14:
        return SchemaUtil.safeEquals(UnsafeUtil.getObject(message, r1), UnsafeUtil.getObject(other, r1));
    L16:
        if (arePresentForEquals(message, other, pos) == true) goto L18;
        return false;
    L18:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(message, r1), UnsafeUtil.getObject(other, r1)) == true) goto L20;
        return false;
    L20:
        return true;
    L22:
        if (arePresentForEquals(message, other, pos) == true) goto L24;
        return false;
    L24:
        if (UnsafeUtil.getLong(message, r1) == UnsafeUtil.getLong(other, r1)) goto L26;
        return false;
    L26:
        return true;
    L28:
        if (arePresentForEquals(message, other, pos) == true) goto L30;
        return false;
    L30:
        if (UnsafeUtil.getInt(message, r1) == UnsafeUtil.getInt(other, r1)) goto L32;
        return false;
    L32:
        return true;
    L34:
        if (arePresentForEquals(message, other, pos) == true) goto L36;
        return false;
    L36:
        if (UnsafeUtil.getLong(message, r1) == UnsafeUtil.getLong(other, r1)) goto L38;
        return false;
    L38:
        return true;
    L40:
        if (arePresentForEquals(message, other, pos) == true) goto L42;
        return false;
    L42:
        if (UnsafeUtil.getInt(message, r1) == UnsafeUtil.getInt(other, r1)) goto L44;
        return false;
    L44:
        return true;
    L46:
        if (arePresentForEquals(message, other, pos) == true) goto L48;
        return false;
    L48:
        if (UnsafeUtil.getInt(message, r1) == UnsafeUtil.getInt(other, r1)) goto L50;
        return false;
    L50:
        return true;
    L52:
        if (arePresentForEquals(message, other, pos) == true) goto L54;
        return false;
    L54:
        if (UnsafeUtil.getInt(message, r1) == UnsafeUtil.getInt(other, r1)) goto L56;
        return false;
    L56:
        return true;
    L58:
        if (arePresentForEquals(message, other, pos) == true) goto L60;
        return false;
    L60:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(message, r1), UnsafeUtil.getObject(other, r1)) == true) goto L62;
        return false;
    L62:
        return true;
    L64:
        if (arePresentForEquals(message, other, pos) == true) goto L66;
        return false;
    L66:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(message, r1), UnsafeUtil.getObject(other, r1)) == true) goto L68;
        return false;
    L68:
        return true;
    L70:
        if (arePresentForEquals(message, other, pos) == true) goto L72;
        return false;
    L72:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(message, r1), UnsafeUtil.getObject(other, r1)) == true) goto L74;
        return false;
    L74:
        return true;
    L76:
        if (arePresentForEquals(message, other, pos) == true) goto L78;
        return false;
    L78:
        if (UnsafeUtil.getBoolean(message, r1) == UnsafeUtil.getBoolean(other, r1)) goto L80;
        return false;
    L80:
        return true;
    L82:
        if (arePresentForEquals(message, other, pos) == true) goto L84;
        return false;
    L84:
        if (UnsafeUtil.getInt(message, r1) == UnsafeUtil.getInt(other, r1)) goto L86;
        return false;
    L86:
        return true;
    L88:
        if (arePresentForEquals(message, other, pos) == true) goto L90;
        return false;
    L90:
        if (UnsafeUtil.getLong(message, r1) == UnsafeUtil.getLong(other, r1)) goto L92;
        return false;
    L92:
        return true;
    L94:
        if (arePresentForEquals(message, other, pos) == true) goto L96;
        return false;
    L96:
        if (UnsafeUtil.getInt(message, r1) == UnsafeUtil.getInt(other, r1)) goto L98;
        return false;
    L98:
        return true;
    L100:
        if (arePresentForEquals(message, other, pos) == true) goto L102;
        return false;
    L102:
        if (UnsafeUtil.getLong(message, r1) == UnsafeUtil.getLong(other, r1)) goto L104;
        return false;
    L104:
        return true;
    L106:
        if (arePresentForEquals(message, other, pos) == true) goto L108;
        return false;
    L108:
        if (UnsafeUtil.getLong(message, r1) == UnsafeUtil.getLong(other, r1)) goto L110;
        return false;
    L110:
        return true;
    L112:
        if (arePresentForEquals(message, other, pos) == true) goto L114;
        return false;
    L114:
        if (Float.floatToIntBits(UnsafeUtil.getFloat(message, r1)) == Float.floatToIntBits(UnsafeUtil.getFloat(other, r1))) goto L116;
        return false;
    L116:
        return true;
    L118:
        if (arePresentForEquals(message, other, pos) == true) goto L120;
        return false;
    L120:
        if (Double.doubleToLongBits(UnsafeUtil.getDouble(message, r1)) == Double.doubleToLongBits(UnsafeUtil.getDouble(other, r1))) goto L122;
        return false;
    L122:
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public int hashCode(T message) {
        int r0 = this.buffer.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L88;
        int r3 = typeAndOffsetAt(r1);
        int r4 = numberAt(r1);
        long r5 = offset(r3);
        int r7 = 37;
        switch(type(r3)) {
            case 0: goto L85;
            case 1: goto L84;
            case 2: goto L83;
            case 3: goto L82;
            case 4: goto L81;
            case 5: goto L80;
            case 6: goto L79;
            case 7: goto L78;
            case 8: goto L77;
            case 9: goto L73;
            case 10: goto L72;
            case 11: goto L71;
            case 12: goto L70;
            case 13: goto L69;
            case 14: goto L68;
            case 15: goto L67;
            case 16: goto L66;
            case 17: goto L63;
            case 18: goto L62;
            case 19: goto L62;
            case 20: goto L62;
            case 21: goto L62;
            case 22: goto L62;
            case 23: goto L62;
            case 24: goto L62;
            case 25: goto L62;
            case 26: goto L62;
            case 27: goto L62;
            case 28: goto L62;
            case 29: goto L62;
            case 30: goto L62;
            case 31: goto L62;
            case 32: goto L62;
            case 33: goto L62;
            case 34: goto L62;
            case 35: goto L62;
            case 36: goto L62;
            case 37: goto L62;
            case 38: goto L62;
            case 39: goto L62;
            case 40: goto L62;
            case 41: goto L62;
            case 42: goto L62;
            case 43: goto L62;
            case 44: goto L62;
            case 45: goto L62;
            case 46: goto L62;
            case 47: goto L62;
            case 48: goto L62;
            case 49: goto L62;
            case 50: goto L61;
            case 51: goto L59;
            case 52: goto L56;
            case 53: goto L53;
            case 54: goto L50;
            case 55: goto L47;
            case 56: goto L44;
            case 57: goto L41;
            case 58: goto L38;
            case 59: goto L35;
            case 60: goto L32;
            case 61: goto L29;
            case 62: goto L26;
            case 63: goto L23;
            case 64: goto L20;
            case 65: goto L17;
            case 66: goto L14;
            case 67: goto L11;
            case 68: goto L8;
            default: goto L87;
        };
    L61:
        int r6 = r2 * 53;
        int r8 = UnsafeUtil.getObject(message, r5).hashCode();
    L86:
        r2 = r6 + r8;
        goto L87
    L62:
        r6 = r2 * 53;
        r8 = UnsafeUtil.getObject(message, r5).hashCode();
        goto L86
    L63:
        Object r9 = UnsafeUtil.getObject(message, r5);
        if (r9 == null) goto L76;
        r7 = r9.hashCode();
    L76:
        r2 = (r2 * 53) + r7;
        goto L87
    L66:
        r6 = r2 * 53;
        r8 = Internal.hashLong(UnsafeUtil.getLong(message, r5));
        goto L86
    L67:
        r6 = r2 * 53;
        r8 = UnsafeUtil.getInt(message, r5);
        goto L86
    L68:
        r6 = r2 * 53;
        r8 = Internal.hashLong(UnsafeUtil.getLong(message, r5));
        goto L86
    L69:
        r6 = r2 * 53;
        r8 = UnsafeUtil.getInt(message, r5);
        goto L86
    L70:
        r6 = r2 * 53;
        r8 = UnsafeUtil.getInt(message, r5);
        goto L86
    L71:
        r6 = r2 * 53;
        r8 = UnsafeUtil.getInt(message, r5);
        goto L86
    L72:
        r6 = r2 * 53;
        r8 = UnsafeUtil.getObject(message, r5).hashCode();
        goto L86
    L73:
        Object r10 = UnsafeUtil.getObject(message, r5);
        if (r10 == null) goto L76;
        r7 = r10.hashCode();
        goto L76
    L77:
        r6 = r2 * 53;
        r8 = ((String) UnsafeUtil.getObject(message, r5)).hashCode();
        goto L86
    L78:
        r6 = r2 * 53;
        r8 = Internal.hashBoolean(UnsafeUtil.getBoolean(message, r5));
        goto L86
    L79:
        r6 = r2 * 53;
        r8 = UnsafeUtil.getInt(message, r5);
        goto L86
    L80:
        r6 = r2 * 53;
        r8 = Internal.hashLong(UnsafeUtil.getLong(message, r5));
        goto L86
    L81:
        r6 = r2 * 53;
        r8 = UnsafeUtil.getInt(message, r5);
        goto L86
    L82:
        r6 = r2 * 53;
        r8 = Internal.hashLong(UnsafeUtil.getLong(message, r5));
        goto L86
    L83:
        r6 = r2 * 53;
        r8 = Internal.hashLong(UnsafeUtil.getLong(message, r5));
        goto L86
    L84:
        r6 = r2 * 53;
        r8 = Float.floatToIntBits(UnsafeUtil.getFloat(message, r5));
        goto L86
    L85:
        r6 = r2 * 53;
        r8 = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(message, r5)));
        goto L86
    L8:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = UnsafeUtil.getObject(message, r5).hashCode();
        goto L86
    L11:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = Internal.hashLong(oneofLongAt(message, r5));
        goto L86
    L14:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = oneofIntAt(message, r5);
        goto L86
    L17:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = Internal.hashLong(oneofLongAt(message, r5));
        goto L86
    L20:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = oneofIntAt(message, r5);
        goto L86
    L23:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = oneofIntAt(message, r5);
        goto L86
    L26:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = oneofIntAt(message, r5);
        goto L86
    L29:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = UnsafeUtil.getObject(message, r5).hashCode();
        goto L86
    L32:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = UnsafeUtil.getObject(message, r5).hashCode();
        goto L86
    L35:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = ((String) UnsafeUtil.getObject(message, r5)).hashCode();
        goto L86
    L38:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = Internal.hashBoolean(oneofBooleanAt(message, r5));
        goto L86
    L41:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = oneofIntAt(message, r5);
        goto L86
    L44:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = Internal.hashLong(oneofLongAt(message, r5));
        goto L86
    L47:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = oneofIntAt(message, r5);
        goto L86
    L50:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = Internal.hashLong(oneofLongAt(message, r5));
        goto L86
    L53:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = Internal.hashLong(oneofLongAt(message, r5));
        goto L86
    L56:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = Float.floatToIntBits(oneofFloatAt(message, r5));
        goto L86
    L59:
        if (isOneofPresent(message, r4, r1) == false) goto L87;
        r6 = r2 * 53;
        r8 = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(message, r5)));
    L87:
        r1 = r1 + 3;
        goto L3
    L88:
        int r11 = (r2 * 53) + this.unknownFieldSchema.getFromMessage(message).hashCode();
        if (this.hasExtensions == true) goto L91;
        return r11;
    L91:
        return (r11 * 53) + this.extensionSchema.getExtensions(message).hashCode();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T message, T other) {
        checkMutable(message);
        other.getClass();
        int r0 = 0;
    L4:
        if (r0 >= this.buffer.length) goto L6;
        mergeSingleField(message, other, r0);
        r0 = r0 + 3;
        goto L4
    L6:
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, message, other);
        if (this.hasExtensions == false) goto L11;
        SchemaUtil.mergeExtensions(this.extensionSchema, message, other);
        return;
    }

    private void mergeSingleField(T message, T other, int pos) {
        int r0 = typeAndOffsetAt(pos);
        long r1 = offset(r0);
        int r3 = numberAt(pos);
        switch(type(r0)) {
            case 0: goto L63;
            case 1: goto L60;
            case 2: goto L57;
            case 3: goto L54;
            case 4: goto L51;
            case 5: goto L48;
            case 6: goto L45;
            case 7: goto L42;
            case 8: goto L39;
            case 9: goto L37;
            case 10: goto L35;
            case 11: goto L32;
            case 12: goto L29;
            case 13: goto L26;
            case 14: goto L23;
            case 15: goto L20;
            case 16: goto L17;
            case 17: goto L15;
            case 18: goto L14;
            case 19: goto L14;
            case 20: goto L14;
            case 21: goto L14;
            case 22: goto L14;
            case 23: goto L14;
            case 24: goto L14;
            case 25: goto L14;
            case 26: goto L14;
            case 27: goto L14;
            case 28: goto L14;
            case 29: goto L14;
            case 30: goto L14;
            case 31: goto L14;
            case 32: goto L14;
            case 33: goto L14;
            case 34: goto L14;
            case 35: goto L14;
            case 36: goto L14;
            case 37: goto L14;
            case 38: goto L14;
            case 39: goto L14;
            case 40: goto L14;
            case 41: goto L14;
            case 42: goto L14;
            case 43: goto L14;
            case 44: goto L14;
            case 45: goto L14;
            case 46: goto L14;
            case 47: goto L14;
            case 48: goto L14;
            case 49: goto L14;
            case 50: goto L13;
            case 51: goto L11;
            case 52: goto L11;
            case 53: goto L11;
            case 54: goto L11;
            case 55: goto L11;
            case 56: goto L11;
            case 57: goto L11;
            case 58: goto L11;
            case 59: goto L11;
            case 60: goto L9;
            case 61: goto L7;
            case 62: goto L7;
            case 63: goto L7;
            case 64: goto L7;
            case 65: goto L7;
            case 66: goto L7;
            case 67: goto L7;
            case 68: goto L5;
            default: goto L107;
        };
    L5:
        mergeOneofMessage(message, other, pos);
        return;
    L9:
        mergeOneofMessage(message, other, pos);
        return;
    L13:
        SchemaUtil.mergeMap(this.mapFieldSchema, message, other, r1);
        return;
    L14:
        this.listFieldSchema.mergeListsAt(message, other, r1);
        return;
    L15:
        mergeMessage(message, other, pos);
        return;
    L37:
        mergeMessage(message, other, pos);
        return;
    L107:
        return;
    L7:
        if (isOneofPresent(other, r3, pos) == false) goto L67;
        UnsafeUtil.putObject(message, r1, UnsafeUtil.getObject(other, r1));
        setOneofPresent(message, r3, pos);
        return;
    L67:
        return;
    L11:
        if (isOneofPresent(other, r3, pos) == false) goto L70;
        UnsafeUtil.putObject(message, r1, UnsafeUtil.getObject(other, r1));
        setOneofPresent(message, r3, pos);
        return;
    L70:
        return;
    L17:
        if (isFieldPresent(other, pos) == false) goto L75;
        UnsafeUtil.putLong(message, r1, UnsafeUtil.getLong(other, r1));
        setFieldPresent(message, pos);
        return;
    L75:
        return;
    L20:
        if (isFieldPresent(other, pos) == false) goto L77;
        UnsafeUtil.putInt(message, r1, UnsafeUtil.getInt(other, r1));
        setFieldPresent(message, pos);
        return;
    L77:
        return;
    L23:
        if (isFieldPresent(other, pos) == false) goto L79;
        UnsafeUtil.putLong(message, r1, UnsafeUtil.getLong(other, r1));
        setFieldPresent(message, pos);
        return;
    L79:
        return;
    L26:
        if (isFieldPresent(other, pos) == false) goto L81;
        UnsafeUtil.putInt(message, r1, UnsafeUtil.getInt(other, r1));
        setFieldPresent(message, pos);
        return;
    L81:
        return;
    L29:
        if (isFieldPresent(other, pos) == false) goto L83;
        UnsafeUtil.putInt(message, r1, UnsafeUtil.getInt(other, r1));
        setFieldPresent(message, pos);
        return;
    L83:
        return;
    L32:
        if (isFieldPresent(other, pos) == false) goto L85;
        UnsafeUtil.putInt(message, r1, UnsafeUtil.getInt(other, r1));
        setFieldPresent(message, pos);
        return;
    L85:
        return;
    L35:
        if (isFieldPresent(other, pos) == false) goto L87;
        UnsafeUtil.putObject(message, r1, UnsafeUtil.getObject(other, r1));
        setFieldPresent(message, pos);
        return;
    L87:
        return;
    L39:
        if (isFieldPresent(other, pos) == false) goto L90;
        UnsafeUtil.putObject(message, r1, UnsafeUtil.getObject(other, r1));
        setFieldPresent(message, pos);
        return;
    L90:
        return;
    L42:
        if (isFieldPresent(other, pos) == false) goto L92;
        UnsafeUtil.putBoolean(message, r1, UnsafeUtil.getBoolean(other, r1));
        setFieldPresent(message, pos);
        return;
    L92:
        return;
    L45:
        if (isFieldPresent(other, pos) == false) goto L94;
        UnsafeUtil.putInt(message, r1, UnsafeUtil.getInt(other, r1));
        setFieldPresent(message, pos);
        return;
    L94:
        return;
    L48:
        if (isFieldPresent(other, pos) == false) goto L96;
        UnsafeUtil.putLong(message, r1, UnsafeUtil.getLong(other, r1));
        setFieldPresent(message, pos);
        return;
    L96:
        return;
    L51:
        if (isFieldPresent(other, pos) == false) goto L98;
        UnsafeUtil.putInt(message, r1, UnsafeUtil.getInt(other, r1));
        setFieldPresent(message, pos);
        return;
    L98:
        return;
    L54:
        if (isFieldPresent(other, pos) == false) goto L100;
        UnsafeUtil.putLong(message, r1, UnsafeUtil.getLong(other, r1));
        setFieldPresent(message, pos);
        return;
    L100:
        return;
    L57:
        if (isFieldPresent(other, pos) == false) goto L102;
        UnsafeUtil.putLong(message, r1, UnsafeUtil.getLong(other, r1));
        setFieldPresent(message, pos);
        return;
    L102:
        return;
    L60:
        if (isFieldPresent(other, pos) == false) goto L104;
        UnsafeUtil.putFloat(message, r1, UnsafeUtil.getFloat(other, r1));
        setFieldPresent(message, pos);
        return;
    L104:
        return;
    L63:
        if (isFieldPresent(other, pos) == false) goto L106;
        UnsafeUtil.putDouble(message, r1, UnsafeUtil.getDouble(other, r1));
        setFieldPresent(message, pos);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T targetParent, T sourceParent, int pos) {
        if (isFieldPresent(sourceParent, pos) == true) goto L5;
        return;
    L5:
        long r0 = offset(typeAndOffsetAt(pos));
        Unsafe r2 = UNSAFE;
        Object r3 = r2.getObject(sourceParent, r0);
        if (r3 == null) goto L21;
        Schema r7 = getMessageFieldSchema(pos);
        if (isFieldPresent(targetParent, pos) == false) goto L10;
        Object r5 = r2.getObject(targetParent, r0);
        if (isMutable(r5) == true) goto L18;
        Object r8 = r7.newInstance();
        r7.mergeFrom(r8, r5);
        r2.putObject(targetParent, r0, r8);
        r5 = r8;
    L18:
        r7.mergeFrom(r5, r3);
        return;
    L10:
        if (isMutable(r3) == true) goto L12;
        r2.putObject(targetParent, r0, r3);
    L13:
        setFieldPresent(targetParent, pos);
        return;
    L12:
        Object r4 = r7.newInstance();
        r7.mergeFrom(r4, r3);
        r2.putObject(targetParent, r0, r4);
        goto L13
    L21:
        throw new IllegalStateException("Source subfield " + numberAt(pos) + " is present but null: " + sourceParent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T targetParent, T sourceParent, int pos) {
        int r0 = numberAt(pos);
        if (isOneofPresent(sourceParent, r0, pos) == true) goto L5;
        return;
    L5:
        long r1 = offset(typeAndOffsetAt(pos));
        Unsafe r3 = UNSAFE;
        Object r4 = r3.getObject(sourceParent, r1);
        if (r4 == null) goto L21;
        Schema r8 = getMessageFieldSchema(pos);
        if (isOneofPresent(targetParent, r0, pos) == false) goto L10;
        Object r6 = r3.getObject(targetParent, r1);
        if (isMutable(r6) == true) goto L18;
        Object r9 = r8.newInstance();
        r8.mergeFrom(r9, r6);
        r3.putObject(targetParent, r1, r9);
        r6 = r9;
    L18:
        r8.mergeFrom(r6, r4);
        return;
    L10:
        if (isMutable(r4) == true) goto L12;
        r3.putObject(targetParent, r1, r4);
    L13:
        setOneofPresent(targetParent, r0, pos);
        return;
    L12:
        Object r5 = r8.newInstance();
        r8.mergeFrom(r5, r4);
        r3.putObject(targetParent, r1, r5);
        goto L13
    L21:
        throw new IllegalStateException("Source subfield " + numberAt(pos) + " is present but null: " + sourceParent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v215 */
    /* JADX WARN: Type inference failed for: r0v217 */
    /* JADX WARN: Type inference failed for: r0v219 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v75 */
    /* JADX WARN: Type inference failed for: r1v76 */
    /* JADX WARN: Type inference failed for: r1v78 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v16 */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public int getSerializedSize(T r19) {
        Unsafe r8 = UNSAFE;
        ?? r9 = 0;
        int r10 = 1048575;
        ?? r1 = 0;
        int r11 = 0;
        int r12 = 0;
        int r0 = 1048575;
    L4:
        if (r11 >= this.buffer.length) goto L247;
        int r2 = typeAndOffsetAt(r11);
        int r3 = type(r2);
        int r13 = numberAt(r11);
        int r4 = this.buffer[r11 + 2];
        int r5 = r4 & r10;
        int r6 = r0;
        ?? r7 = r1;
        if (r3 > 17) goto L13;
        if (r5 == r0) goto L12;
        if (r5 != r10) goto L10;
        ?? r14 = r9;
    L11:
        r7 = r14;
        r6 = r5 == true ? 1 : 0;
        goto L12
    L10:
        r14 = r8.getInt(r19, r5 == true ? 1 : 0);
    L12:
        int r15 = r6;
        ?? r16 = r7;
        ?? r17 = 1 << (r4 >>> 20);
    L14:
        long r18 = offset(r2);
        if (r3 < FieldType.DOUBLE_LIST_PACKED.id()) goto L19;
        ?? r20 = r5;
        if (r3 > FieldType.SINT64_LIST_PACKED.id()) goto L19;
    L20:
        ?? r21 = r20;
        switch(r3) {
            case 0: goto L242;
            case 1: goto L239;
            case 2: goto L236;
            case 3: goto L233;
            case 4: goto L230;
            case 5: goto L227;
            case 6: goto L225;
            case 7: goto L220;
            case 8: goto L214;
            case 9: goto L211;
            case 10: goto L208;
            case 11: goto L205;
            case 12: goto L202;
            case 13: goto L199;
            case 14: goto L196;
            case 15: goto L193;
            case 16: goto L190;
            case 17: goto L187;
            case 18: goto L183;
            case 19: goto L182;
            case 20: goto L181;
            case 21: goto L180;
            case 22: goto L179;
            case 23: goto L178;
            case 24: goto L177;
            case 25: goto L176;
            case 26: goto L175;
            case 27: goto L174;
            case 28: goto L173;
            case 29: goto L172;
            case 30: goto L171;
            case 31: goto L170;
            case 32: goto L169;
            case 33: goto L168;
            case 34: goto L167;
            case 35: goto L160;
            case 36: goto L154;
            case 37: goto L148;
            case 38: goto L142;
            case 39: goto L136;
            case 40: goto L130;
            case 41: goto L124;
            case 42: goto L118;
            case 43: goto L112;
            case 44: goto L106;
            case 45: goto L100;
            case 46: goto L94;
            case 47: goto L88;
            case 48: goto L82;
            case 49: goto L81;
            case 50: goto L80;
            case 51: goto L78;
            case 52: goto L75;
            case 53: goto L72;
            case 54: goto L69;
            case 55: goto L66;
            case 56: goto L63;
            case 57: goto L60;
            case 58: goto L57;
            case 59: goto L51;
            case 60: goto L48;
            case 61: goto L45;
            case 62: goto L42;
            case 63: goto L39;
            case 64: goto L36;
            case 65: goto L33;
            case 66: goto L30;
            case 67: goto L27;
            case 68: goto L24;
            default: goto L185;
        };
    L80:
        int r22 = this.mapFieldSchema.getSerializedSize(r13, r8.getObject(r19, r18), getMapFieldDefaultEntry(r11));
    L184:
        r12 = r12 + r22;
        goto L185
    L81:
        r22 = SchemaUtil.computeSizeGroupList(r13, (List) r8.getObject(r19, r18), getMessageFieldSchema(r11));
        goto L184
    L82:
        int r23 = SchemaUtil.computeSizeSInt64ListNoTag((List) r8.getObject(r19, r18));
        if (r23 <= 0) goto L185;
        if (this.useCachedSizeField == false) goto L87;
        r8.putInt(r19, r21 == true ? 1 : 0, r23);
    L87:
        int r24 = CodedOutputStream.computeTagSize(r13);
        int r25 = CodedOutputStream.computeUInt32SizeNoTag(r23);
    L166:
        r22 = (r24 + r25) + r23;
        goto L184
    L88:
        r23 = SchemaUtil.computeSizeSInt32ListNoTag((List) r8.getObject(r19, r18));
        if (r23 <= 0) goto L185;
        if (this.useCachedSizeField == false) goto L93;
        r8.putInt(r19, r21 == true ? 1 : 0, r23);
    L93:
        r24 = CodedOutputStream.computeTagSize(r13);
        r25 = CodedOutputStream.computeUInt32SizeNoTag(r23);
        goto L166
    L94:
        r23 = SchemaUtil.computeSizeFixed64ListNoTag((List) r8.getObject(r19, r18));
        if (r23 <= 0) goto L185;
        if (this.useCachedSizeField == false) goto L99;
        r8.putInt(r19, r21 == true ? 1 : 0, r23);
    L99:
        r24 = CodedOutputStream.computeTagSize(r13);
        r25 = CodedOutputStream.computeUInt32SizeNoTag(r23);
        goto L166
    L100:
        r23 = SchemaUtil.computeSizeFixed32ListNoTag((List) r8.getObject(r19, r18));
        if (r23 <= 0) goto L185;
        if (this.useCachedSizeField == false) goto L105;
        r8.putInt(r19, r21 == true ? 1 : 0, r23);
    L105:
        r24 = CodedOutputStream.computeTagSize(r13);
        r25 = CodedOutputStream.computeUInt32SizeNoTag(r23);
        goto L166
    L106:
        r23 = SchemaUtil.computeSizeEnumListNoTag((List) r8.getObject(r19, r18));
        if (r23 <= 0) goto L185;
        if (this.useCachedSizeField == false) goto L111;
        r8.putInt(r19, r21 == true ? 1 : 0, r23);
    L111:
        r24 = CodedOutputStream.computeTagSize(r13);
        r25 = CodedOutputStream.computeUInt32SizeNoTag(r23);
        goto L166
    L112:
        r23 = SchemaUtil.computeSizeUInt32ListNoTag((List) r8.getObject(r19, r18));
        if (r23 <= 0) goto L185;
        if (this.useCachedSizeField == false) goto L117;
        r8.putInt(r19, r21 == true ? 1 : 0, r23);
    L117:
        r24 = CodedOutputStream.computeTagSize(r13);
        r25 = CodedOutputStream.computeUInt32SizeNoTag(r23);
        goto L166
    L118:
        r23 = SchemaUtil.computeSizeBoolListNoTag((List) r8.getObject(r19, r18));
        if (r23 <= 0) goto L185;
        if (this.useCachedSizeField == false) goto L123;
        r8.putInt(r19, r21 == true ? 1 : 0, r23);
    L123:
        r24 = CodedOutputStream.computeTagSize(r13);
        r25 = CodedOutputStream.computeUInt32SizeNoTag(r23);
        goto L166
    L124:
        r23 = SchemaUtil.computeSizeFixed32ListNoTag((List) r8.getObject(r19, r18));
        if (r23 <= 0) goto L185;
        if (this.useCachedSizeField == false) goto L129;
        r8.putInt(r19, r21 == true ? 1 : 0, r23);
    L129:
        r24 = CodedOutputStream.computeTagSize(r13);
        r25 = CodedOutputStream.computeUInt32SizeNoTag(r23);
        goto L166
    L130:
        r23 = SchemaUtil.computeSizeFixed64ListNoTag((List) r8.getObject(r19, r18));
        if (r23 <= 0) goto L185;
        if (this.useCachedSizeField == false) goto L135;
        r8.putInt(r19, r21 == true ? 1 : 0, r23);
    L135:
        r24 = CodedOutputStream.computeTagSize(r13);
        r25 = CodedOutputStream.computeUInt32SizeNoTag(r23);
        goto L166
    L136:
        r23 = SchemaUtil.computeSizeInt32ListNoTag((List) r8.getObject(r19, r18));
        if (r23 <= 0) goto L185;
        if (this.useCachedSizeField == false) goto L141;
        r8.putInt(r19, r21 == true ? 1 : 0, r23);
    L141:
        r24 = CodedOutputStream.computeTagSize(r13);
        r25 = CodedOutputStream.computeUInt32SizeNoTag(r23);
        goto L166
    L142:
        r23 = SchemaUtil.computeSizeUInt64ListNoTag((List) r8.getObject(r19, r18));
        if (r23 <= 0) goto L185;
        if (this.useCachedSizeField == false) goto L147;
        r8.putInt(r19, r21 == true ? 1 : 0, r23);
    L147:
        r24 = CodedOutputStream.computeTagSize(r13);
        r25 = CodedOutputStream.computeUInt32SizeNoTag(r23);
        goto L166
    L148:
        r23 = SchemaUtil.computeSizeInt64ListNoTag((List) r8.getObject(r19, r18));
        if (r23 <= 0) goto L185;
        if (this.useCachedSizeField == false) goto L153;
        r8.putInt(r19, r21 == true ? 1 : 0, r23);
    L153:
        r24 = CodedOutputStream.computeTagSize(r13);
        r25 = CodedOutputStream.computeUInt32SizeNoTag(r23);
        goto L166
    L154:
        r23 = SchemaUtil.computeSizeFixed32ListNoTag((List) r8.getObject(r19, r18));
        if (r23 <= 0) goto L185;
        if (this.useCachedSizeField == false) goto L159;
        r8.putInt(r19, r21 == true ? 1 : 0, r23);
    L159:
        r24 = CodedOutputStream.computeTagSize(r13);
        r25 = CodedOutputStream.computeUInt32SizeNoTag(r23);
        goto L166
    L160:
        r23 = SchemaUtil.computeSizeFixed64ListNoTag((List) r8.getObject(r19, r18));
        if (r23 <= 0) goto L185;
        if (this.useCachedSizeField == false) goto L165;
        r8.putInt(r19, r21 == true ? 1 : 0, r23);
    L165:
        r24 = CodedOutputStream.computeTagSize(r13);
        r25 = CodedOutputStream.computeUInt32SizeNoTag(r23);
        goto L166
    L167:
        r22 = SchemaUtil.computeSizeSInt64List(r13, (List) r8.getObject(r19, r18), r9);
        goto L184
    L168:
        r22 = SchemaUtil.computeSizeSInt32List(r13, (List) r8.getObject(r19, r18), r9);
        goto L184
    L169:
        r22 = SchemaUtil.computeSizeFixed64List(r13, (List) r8.getObject(r19, r18), r9);
        goto L184
    L170:
        r22 = SchemaUtil.computeSizeFixed32List(r13, (List) r8.getObject(r19, r18), r9);
        goto L184
    L171:
        r22 = SchemaUtil.computeSizeEnumList(r13, (List) r8.getObject(r19, r18), r9);
        goto L184
    L172:
        r22 = SchemaUtil.computeSizeUInt32List(r13, (List) r8.getObject(r19, r18), r9);
        goto L184
    L173:
        r22 = SchemaUtil.computeSizeByteStringList(r13, (List) r8.getObject(r19, r18));
        goto L184
    L174:
        r22 = SchemaUtil.computeSizeMessageList(r13, (List) r8.getObject(r19, r18), getMessageFieldSchema(r11));
        goto L184
    L175:
        r22 = SchemaUtil.computeSizeStringList(r13, (List) r8.getObject(r19, r18));
        goto L184
    L176:
        r22 = SchemaUtil.computeSizeBoolList(r13, (List) r8.getObject(r19, r18), r9);
        goto L184
    L177:
        r22 = SchemaUtil.computeSizeFixed32List(r13, (List) r8.getObject(r19, r18), r9);
        goto L184
    L178:
        r22 = SchemaUtil.computeSizeFixed64List(r13, (List) r8.getObject(r19, r18), r9);
        goto L184
    L179:
        r22 = SchemaUtil.computeSizeInt32List(r13, (List) r8.getObject(r19, r18), r9);
        goto L184
    L180:
        r22 = SchemaUtil.computeSizeUInt64List(r13, (List) r8.getObject(r19, r18), r9);
        goto L184
    L181:
        r22 = SchemaUtil.computeSizeInt64List(r13, (List) r8.getObject(r19, r18), r9);
        goto L184
    L182:
        r22 = SchemaUtil.computeSizeFixed32List(r13, (List) r8.getObject(r19, r18), r9);
        goto L184
    L183:
        r22 = SchemaUtil.computeSizeFixed64List(r13, (List) r8.getObject(r19, r18), r9);
        goto L184
    L227:
        ?? r110 = r9;
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L246;
        int r26 = CodedOutputStream.computeFixed64Size(r13, 0);
        r110 = r110;
    L245:
        r12 = r12 + r26;
    L246:
        r11 = r11 + 3;
        r0 = r15;
        r9 = r110;
        r1 = r16;
        r10 = 1048575;
        goto L4
    L230:
        r110 = r9;
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L246;
        r26 = CodedOutputStream.computeInt32Size(r13, r8.getInt(r19, r18));
        r110 = r110;
        goto L245
    L233:
        r110 = r9;
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L246;
        r26 = CodedOutputStream.computeUInt64Size(r13, r8.getLong(r19, r18));
        r110 = r110;
        goto L245
    L236:
        r110 = r9;
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L246;
        r26 = CodedOutputStream.computeInt64Size(r13, r8.getLong(r19, r18));
        r110 = r110;
        goto L245
    L239:
        r110 = r9;
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L246;
        r26 = CodedOutputStream.computeFloatSize(r13, 0.0f);
        r110 = r110;
        goto L245
    L242:
        r110 = r9;
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L246;
        r26 = CodedOutputStream.computeDoubleSize(r13, 0.0d);
        r110 = r110;
    L185:
        r110 = r9;
        goto L246
    L24:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        r22 = CodedOutputStream.computeGroupSize(r13, (MessageLite) r8.getObject(r19, r18), getMessageFieldSchema(r11));
        goto L184
    L27:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        r22 = CodedOutputStream.computeSInt64Size(r13, oneofLongAt(r19, r18));
        goto L184
    L30:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        r22 = CodedOutputStream.computeSInt32Size(r13, oneofIntAt(r19, r18));
        goto L184
    L33:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        r22 = CodedOutputStream.computeSFixed64Size(r13, 0);
        goto L184
    L36:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        r22 = CodedOutputStream.computeSFixed32Size(r13, r9);
        goto L184
    L39:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        r22 = CodedOutputStream.computeEnumSize(r13, oneofIntAt(r19, r18));
        goto L184
    L42:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        r22 = CodedOutputStream.computeUInt32Size(r13, oneofIntAt(r19, r18));
        goto L184
    L45:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        r22 = CodedOutputStream.computeBytesSize(r13, (ByteString) r8.getObject(r19, r18));
        goto L184
    L48:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        r22 = SchemaUtil.computeSizeMessage(r13, r8.getObject(r19, r18), getMessageFieldSchema(r11));
        goto L184
    L51:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        Object r27 = r8.getObject(r19, r18);
        if ((r27 instanceof ByteString) == false) goto L55;
        r22 = CodedOutputStream.computeBytesSize(r13, (ByteString) r27);
        goto L184
    L55:
        r22 = CodedOutputStream.computeStringSize(r13, (String) r27);
        goto L184
    L57:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        r22 = CodedOutputStream.computeBoolSize(r13, true);
        goto L184
    L60:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        r22 = CodedOutputStream.computeFixed32Size(r13, r9);
        goto L184
    L63:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        r22 = CodedOutputStream.computeFixed64Size(r13, 0);
        goto L184
    L66:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        r22 = CodedOutputStream.computeInt32Size(r13, oneofIntAt(r19, r18));
        goto L184
    L69:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        r22 = CodedOutputStream.computeUInt64Size(r13, oneofLongAt(r19, r18));
        goto L184
    L72:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        r22 = CodedOutputStream.computeInt64Size(r13, oneofLongAt(r19, r18));
        goto L184
    L75:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        r22 = CodedOutputStream.computeFloatSize(r13, 0.0f);
        goto L184
    L78:
        if (isOneofPresent(r19, r13, r11) == false) goto L185;
        r22 = CodedOutputStream.computeDoubleSize(r13, 0.0d);
        goto L184
    L187:
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L223;
        int r28 = CodedOutputStream.computeGroupSize(r13, (MessageLite) r8.getObject(r19, r18), getMessageFieldSchema(r11));
    L222:
        r12 = r12 + r28;
    L223:
        r110 = 0;
        goto L246
    L190:
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L223;
        r28 = CodedOutputStream.computeSInt64Size(r13, r8.getLong(r19, r18));
        goto L222
    L193:
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L223;
        r28 = CodedOutputStream.computeSInt32Size(r13, r8.getInt(r19, r18));
        goto L222
    L196:
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L223;
        r28 = CodedOutputStream.computeSFixed64Size(r13, 0);
        goto L222
    L199:
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L223;
        r12 = r12 + CodedOutputStream.computeSFixed32Size(r13, 0);
        goto L223
    L202:
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L223;
        r28 = CodedOutputStream.computeEnumSize(r13, r8.getInt(r19, r18));
        goto L222
    L205:
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L223;
        r28 = CodedOutputStream.computeUInt32Size(r13, r8.getInt(r19, r18));
        goto L222
    L208:
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L223;
        r28 = CodedOutputStream.computeBytesSize(r13, (ByteString) r8.getObject(r19, r18));
        goto L222
    L211:
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L223;
        r28 = SchemaUtil.computeSizeMessage(r13, r8.getObject(r19, r18), getMessageFieldSchema(r11));
        goto L222
    L214:
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L223;
        Object r29 = r8.getObject(r19, r18);
        if ((r29 instanceof ByteString) == false) goto L218;
        r28 = CodedOutputStream.computeBytesSize(r13, (ByteString) r29);
        goto L222
    L218:
        r28 = CodedOutputStream.computeStringSize(r13, (String) r29);
        goto L222
    L220:
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L223;
        r28 = CodedOutputStream.computeBoolSize(r13, true);
        goto L222
    L225:
        if (isFieldPresent(r19, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L223;
        r110 = 0;
        r26 = CodedOutputStream.computeFixed32Size(r13, 0);
    L19:
        r20 = r9;
        goto L20
    L13:
        r15 = r0 == true ? 1 : 0;
        r16 = r1 == true ? 1 : 0;
        r17 = r9;
        goto L14
    L247:
        int r111 = r12 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, r19);
        if (this.hasExtensions == true) goto L250;
        return r111;
    L250:
        return r111 + this.extensionSchema.getExtensions(r19).getSerializedSize();
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> schema, T message) {
        return schema.getSerializedSize(schema.getFromMessage(message));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void writeTo(T message, Writer writer) throws IOException {
        if (writer.fieldOrder() != Writer.FieldOrder.DESCENDING) goto L5;
        writeFieldsInDescendingOrder(message, writer);
        return;
    L5:
        writeFieldsInAscendingOrder(message, writer);
    }

    private void writeFieldsInAscendingOrder(T message, Writer writer) throws IOException {
        if (this.hasExtensions == false) goto L7;
        FieldSet<T> r0 = this.extensionSchema.getExtensions(message);
        if (r0.isEmpty() == true) goto L7;
        Iterator r1 = r0.iterator();
        Map.Entry<?, ?> r2 = (Map.Entry) r1.next();
        Iterator r10 = r1;
    L8:
        int r11 = this.buffer.length;
        Unsafe r12 = UNSAFE;
        int r13 = 1048575;
        int r3 = 1048575;
        int r4 = 0;
        int r15 = 0;
    L9:
        if (r15 >= r11) goto L176;
        int r5 = typeAndOffsetAt(r15);
        int r6 = numberAt(r15);
        int r7 = type(r5);
        if (r7 > 17) goto L20;
        int r9 = this.buffer[r15 + 2];
        int r14 = r9 & r13;
        if (r14 == r3) goto L18;
        if (r14 != r13) goto L16;
        r4 = 0;
    L17:
        r3 = r14;
    L19:
        int r8 = 1 << (r9 >>> 20);
        int r16 = r3;
        int r18 = r8;
        Map.Entry<?, ?> r17 = r2;
    L21:
        int r19 = r4;
    L22:
        if (r17 == null) goto L29;
        if (this.extensionSchema.extensionNumber(r17) > r6) goto L29;
        this.extensionSchema.serializeExtension(writer, r17);
        if (r10.hasNext() == true) goto L27;
        r17 = null;
        goto L22
    L27:
        r17 = (Map.Entry) r10.next();
    L29:
        long r20 = offset(r5);
        switch(r7) {
            case 0: goto L171;
            case 1: goto L168;
            case 2: goto L165;
            case 3: goto L162;
            case 4: goto L159;
            case 5: goto L156;
            case 6: goto L153;
            case 7: goto L150;
            case 8: goto L147;
            case 9: goto L144;
            case 10: goto L141;
            case 11: goto L138;
            case 12: goto L135;
            case 13: goto L132;
            case 14: goto L129;
            case 15: goto L126;
            case 16: goto L123;
            case 17: goto L120;
            case 18: goto L118;
            case 19: goto L117;
            case 20: goto L116;
            case 21: goto L115;
            case 22: goto L114;
            case 23: goto L113;
            case 24: goto L112;
            case 25: goto L111;
            case 26: goto L110;
            case 27: goto L109;
            case 28: goto L108;
            case 29: goto L107;
            case 30: goto L106;
            case 31: goto L105;
            case 32: goto L104;
            case 33: goto L103;
            case 34: goto L102;
            case 35: goto L101;
            case 36: goto L100;
            case 37: goto L99;
            case 38: goto L98;
            case 39: goto L97;
            case 40: goto L96;
            case 41: goto L95;
            case 42: goto L94;
            case 43: goto L93;
            case 44: goto L92;
            case 45: goto L91;
            case 46: goto L90;
            case 47: goto L89;
            case 48: goto L88;
            case 49: goto L87;
            case 50: goto L86;
            case 51: goto L84;
            case 52: goto L81;
            case 53: goto L78;
            case 54: goto L75;
            case 55: goto L72;
            case 56: goto L69;
            case 57: goto L66;
            case 58: goto L63;
            case 59: goto L60;
            case 60: goto L57;
            case 61: goto L54;
            case 62: goto L51;
            case 63: goto L48;
            case 64: goto L45;
            case 65: goto L42;
            case 66: goto L39;
            case 67: goto L36;
            case 68: goto L33;
            default: goto L31;
        };
    L31:
        int r21 = r11;
        Map.Entry<?, ?> r110 = r17;
    L174:
        r15 = r15 + 3;
        r3 = r16;
        r2 = r110;
        r4 = r19;
        r11 = r21;
        r13 = 1048575;
        goto L9
    L86:
        writeMapHelper(writer, r6, r12.getObject(message, r20), r15);
        goto L31
    L87:
        SchemaUtil.writeGroupList(numberAt(r15), (List) r12.getObject(message, r20), writer, getMessageFieldSchema(r15));
        goto L31
    L88:
        SchemaUtil.writeSInt64List(numberAt(r15), (List) r12.getObject(message, r20), writer, true);
        goto L31
    L89:
        SchemaUtil.writeSInt32List(numberAt(r15), (List) r12.getObject(message, r20), writer, true);
        goto L31
    L90:
        SchemaUtil.writeSFixed64List(numberAt(r15), (List) r12.getObject(message, r20), writer, true);
        goto L31
    L91:
        SchemaUtil.writeSFixed32List(numberAt(r15), (List) r12.getObject(message, r20), writer, true);
        goto L31
    L92:
        SchemaUtil.writeEnumList(numberAt(r15), (List) r12.getObject(message, r20), writer, true);
        goto L31
    L93:
        SchemaUtil.writeUInt32List(numberAt(r15), (List) r12.getObject(message, r20), writer, true);
        goto L31
    L94:
        SchemaUtil.writeBoolList(numberAt(r15), (List) r12.getObject(message, r20), writer, true);
        goto L31
    L95:
        SchemaUtil.writeFixed32List(numberAt(r15), (List) r12.getObject(message, r20), writer, true);
        goto L31
    L96:
        SchemaUtil.writeFixed64List(numberAt(r15), (List) r12.getObject(message, r20), writer, true);
        goto L31
    L97:
        SchemaUtil.writeInt32List(numberAt(r15), (List) r12.getObject(message, r20), writer, true);
        goto L31
    L98:
        SchemaUtil.writeUInt64List(numberAt(r15), (List) r12.getObject(message, r20), writer, true);
        goto L31
    L99:
        SchemaUtil.writeInt64List(numberAt(r15), (List) r12.getObject(message, r20), writer, true);
        goto L31
    L100:
        SchemaUtil.writeFloatList(numberAt(r15), (List) r12.getObject(message, r20), writer, true);
        goto L31
    L101:
        SchemaUtil.writeDoubleList(numberAt(r15), (List) r12.getObject(message, r20), writer, true);
        goto L31
    L102:
        boolean r22 = false;
        SchemaUtil.writeSInt64List(numberAt(r15), (List) r12.getObject(message, r20), writer, false);
    L119:
        r21 = r11;
        r110 = r17;
        goto L174
    L103:
        r22 = false;
        SchemaUtil.writeSInt32List(numberAt(r15), (List) r12.getObject(message, r20), writer, false);
        goto L119
    L104:
        r22 = false;
        SchemaUtil.writeSFixed64List(numberAt(r15), (List) r12.getObject(message, r20), writer, false);
        goto L119
    L105:
        r22 = false;
        SchemaUtil.writeSFixed32List(numberAt(r15), (List) r12.getObject(message, r20), writer, false);
        goto L119
    L106:
        r22 = false;
        SchemaUtil.writeEnumList(numberAt(r15), (List) r12.getObject(message, r20), writer, false);
        goto L119
    L107:
        r22 = false;
        SchemaUtil.writeUInt32List(numberAt(r15), (List) r12.getObject(message, r20), writer, false);
        goto L119
    L108:
        SchemaUtil.writeBytesList(numberAt(r15), (List) r12.getObject(message, r20), writer);
        goto L31
    L109:
        SchemaUtil.writeMessageList(numberAt(r15), (List) r12.getObject(message, r20), writer, getMessageFieldSchema(r15));
        goto L31
    L110:
        SchemaUtil.writeStringList(numberAt(r15), (List) r12.getObject(message, r20), writer);
        goto L31
    L111:
        r22 = false;
        SchemaUtil.writeBoolList(numberAt(r15), (List) r12.getObject(message, r20), writer, false);
        goto L119
    L112:
        r22 = false;
        SchemaUtil.writeFixed32List(numberAt(r15), (List) r12.getObject(message, r20), writer, false);
        goto L119
    L113:
        r22 = false;
        SchemaUtil.writeFixed64List(numberAt(r15), (List) r12.getObject(message, r20), writer, false);
        goto L119
    L114:
        r22 = false;
        SchemaUtil.writeInt32List(numberAt(r15), (List) r12.getObject(message, r20), writer, false);
        goto L119
    L115:
        r22 = false;
        SchemaUtil.writeUInt64List(numberAt(r15), (List) r12.getObject(message, r20), writer, false);
        goto L119
    L116:
        r22 = false;
        SchemaUtil.writeInt64List(numberAt(r15), (List) r12.getObject(message, r20), writer, false);
        goto L119
    L117:
        r22 = false;
        SchemaUtil.writeFloatList(numberAt(r15), (List) r12.getObject(message, r20), writer, false);
        goto L119
    L118:
        r22 = false;
        SchemaUtil.writeDoubleList(numberAt(r15), (List) r12.getObject(message, r20), writer, false);
        goto L119
    L120:
        r110 = r17;
        r21 = r11;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writer.writeGroup(r6, r12.getObject(message, r20), getMessageFieldSchema(r15));
        goto L174
    L123:
        r21 = r11;
        r110 = r17;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writer.writeSInt64(r6, r12.getLong(message, r20));
        goto L174
    L126:
        r21 = r11;
        r110 = r17;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writer.writeSInt32(r6, r12.getInt(message, r20));
        goto L174
    L129:
        r21 = r11;
        r110 = r17;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writer.writeSFixed64(r6, r12.getLong(message, r20));
        goto L174
    L132:
        r21 = r11;
        r110 = r17;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writer.writeSFixed32(r6, r12.getInt(message, r20));
        goto L174
    L135:
        r21 = r11;
        r110 = r17;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writer.writeEnum(r6, r12.getInt(message, r20));
        goto L174
    L138:
        r21 = r11;
        r110 = r17;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writer.writeUInt32(r6, r12.getInt(message, r20));
        goto L174
    L141:
        r21 = r11;
        r110 = r17;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writer.writeBytes(r6, (ByteString) r12.getObject(message, r20));
        goto L174
    L144:
        r21 = r11;
        r110 = r17;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writer.writeMessage(r6, r12.getObject(message, r20), getMessageFieldSchema(r15));
        goto L174
    L147:
        r21 = r11;
        r110 = r17;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writeString(r6, r12.getObject(message, r20), writer);
        goto L174
    L150:
        r21 = r11;
        r110 = r17;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writer.writeBool(r6, booleanAt(message, r20));
        goto L174
    L153:
        r21 = r11;
        r110 = r17;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writer.writeFixed32(r6, r12.getInt(message, r20));
        goto L174
    L156:
        r21 = r11;
        r110 = r17;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writer.writeFixed64(r6, r12.getLong(message, r20));
        goto L174
    L159:
        r21 = r11;
        r110 = r17;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writer.writeInt32(r6, r12.getInt(message, r20));
        goto L174
    L162:
        r21 = r11;
        r110 = r17;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writer.writeUInt64(r6, r12.getLong(message, r20));
        goto L174
    L165:
        r21 = r11;
        r110 = r17;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writer.writeInt64(r6, r12.getLong(message, r20));
        goto L174
    L168:
        r21 = r11;
        r110 = r17;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writer.writeFloat(r6, floatAt(message, r20));
        goto L174
    L171:
        r21 = r11;
        r110 = r17;
        if (isFieldPresent(message, r15, r16, r19, r18) == false) goto L174;
        writer.writeDouble(r6, doubleAt(message, r20));
        goto L174
    L33:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writer.writeGroup(r6, r12.getObject(message, r20), getMessageFieldSchema(r15));
        goto L31
    L36:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writer.writeSInt64(r6, oneofLongAt(message, r20));
        goto L31
    L39:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writer.writeSInt32(r6, oneofIntAt(message, r20));
        goto L31
    L42:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writer.writeSFixed64(r6, oneofLongAt(message, r20));
        goto L31
    L45:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writer.writeSFixed32(r6, oneofIntAt(message, r20));
        goto L31
    L48:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writer.writeEnum(r6, oneofIntAt(message, r20));
        goto L31
    L51:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writer.writeUInt32(r6, oneofIntAt(message, r20));
        goto L31
    L54:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writer.writeBytes(r6, (ByteString) r12.getObject(message, r20));
        goto L31
    L57:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writer.writeMessage(r6, r12.getObject(message, r20), getMessageFieldSchema(r15));
        goto L31
    L60:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writeString(r6, r12.getObject(message, r20), writer);
        goto L31
    L63:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writer.writeBool(r6, oneofBooleanAt(message, r20));
        goto L31
    L66:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writer.writeFixed32(r6, oneofIntAt(message, r20));
        goto L31
    L69:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writer.writeFixed64(r6, oneofLongAt(message, r20));
        goto L31
    L72:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writer.writeInt32(r6, oneofIntAt(message, r20));
        goto L31
    L75:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writer.writeUInt64(r6, oneofLongAt(message, r20));
        goto L31
    L78:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writer.writeInt64(r6, oneofLongAt(message, r20));
        goto L31
    L81:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writer.writeFloat(r6, oneofFloatAt(message, r20));
        goto L31
    L84:
        if (isOneofPresent(message, r6, r15) == false) goto L31;
        writer.writeDouble(r6, oneofDoubleAt(message, r20));
        goto L31
    L16:
        r4 = r12.getInt(message, r14);
        goto L17
    L18:
        r2 = r2;
        goto L19
    L20:
        r16 = r3;
        r17 = r2;
        r18 = 0;
    L176:
        if (r2 == null) goto L181;
        this.extensionSchema.serializeExtension(writer, r2);
        if (r10.hasNext() == true) goto L179;
        r2 = null;
        goto L176
    L179:
        r2 = (Map.Entry) r10.next();
        goto L176
    L181:
        writeUnknownInMessageTo(this.unknownFieldSchema, message, writer);
        return;
    L7:
        r2 = null;
        r10 = null;
        goto L8
    }

    private void writeFieldsInDescendingOrder(T message, Writer writer) throws IOException {
        writeUnknownInMessageTo(this.unknownFieldSchema, message, writer);
        if (this.hasExtensions == false) goto L7;
        FieldSet<T> r0 = this.extensionSchema.getExtensions(message);
        if (r0.isEmpty() == true) goto L7;
        Iterator r1 = r0.descendingIterator();
        Map.Entry<?, ?> r2 = (Map.Entry) r1.next();
    L8:
        int r3 = this.buffer.length - 3;
    L9:
        if (r3 < 0) goto L163;
        int r4 = typeAndOffsetAt(r3);
        int r5 = numberAt(r3);
    L11:
        if (r2 == null) goto L19;
        if (this.extensionSchema.extensionNumber(r2) <= r5) goto L19;
        this.extensionSchema.serializeExtension(writer, r2);
        if (r1.hasNext() == true) goto L16;
        r2 = null;
        goto L11
    L16:
        r2 = (Map.Entry) r1.next();
    L19:
        switch(type(r4)) {
            case 0: goto L160;
            case 1: goto L157;
            case 2: goto L154;
            case 3: goto L151;
            case 4: goto L148;
            case 5: goto L145;
            case 6: goto L142;
            case 7: goto L139;
            case 8: goto L136;
            case 9: goto L133;
            case 10: goto L130;
            case 11: goto L127;
            case 12: goto L124;
            case 13: goto L121;
            case 14: goto L118;
            case 15: goto L115;
            case 16: goto L112;
            case 17: goto L109;
            case 18: goto L107;
            case 19: goto L106;
            case 20: goto L105;
            case 21: goto L104;
            case 22: goto L103;
            case 23: goto L102;
            case 24: goto L101;
            case 25: goto L100;
            case 26: goto L99;
            case 27: goto L98;
            case 28: goto L97;
            case 29: goto L96;
            case 30: goto L95;
            case 31: goto L94;
            case 32: goto L93;
            case 33: goto L92;
            case 34: goto L91;
            case 35: goto L90;
            case 36: goto L89;
            case 37: goto L88;
            case 38: goto L87;
            case 39: goto L86;
            case 40: goto L85;
            case 41: goto L84;
            case 42: goto L83;
            case 43: goto L82;
            case 44: goto L81;
            case 45: goto L80;
            case 46: goto L79;
            case 47: goto L78;
            case 48: goto L77;
            case 49: goto L76;
            case 50: goto L75;
            case 51: goto L73;
            case 52: goto L70;
            case 53: goto L67;
            case 54: goto L64;
            case 55: goto L61;
            case 56: goto L58;
            case 57: goto L55;
            case 58: goto L52;
            case 59: goto L49;
            case 60: goto L46;
            case 61: goto L43;
            case 62: goto L40;
            case 63: goto L37;
            case 64: goto L34;
            case 65: goto L31;
            case 66: goto L28;
            case 67: goto L25;
            case 68: goto L22;
            default: goto L162;
        };
    L75:
        writeMapHelper(writer, r5, UnsafeUtil.getObject(message, offset(r4)), r3);
        goto L162
    L76:
        SchemaUtil.writeGroupList(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, getMessageFieldSchema(r3));
        goto L162
    L77:
        SchemaUtil.writeSInt64List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, true);
        goto L162
    L78:
        SchemaUtil.writeSInt32List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, true);
        goto L162
    L79:
        SchemaUtil.writeSFixed64List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, true);
        goto L162
    L80:
        SchemaUtil.writeSFixed32List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, true);
        goto L162
    L81:
        SchemaUtil.writeEnumList(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, true);
        goto L162
    L82:
        SchemaUtil.writeUInt32List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, true);
        goto L162
    L83:
        SchemaUtil.writeBoolList(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, true);
        goto L162
    L84:
        SchemaUtil.writeFixed32List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, true);
        goto L162
    L85:
        SchemaUtil.writeFixed64List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, true);
        goto L162
    L86:
        SchemaUtil.writeInt32List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, true);
        goto L162
    L87:
        SchemaUtil.writeUInt64List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, true);
        goto L162
    L88:
        SchemaUtil.writeInt64List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, true);
        goto L162
    L89:
        SchemaUtil.writeFloatList(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, true);
        goto L162
    L90:
        SchemaUtil.writeDoubleList(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, true);
        goto L162
    L91:
        SchemaUtil.writeSInt64List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, false);
        goto L162
    L92:
        SchemaUtil.writeSInt32List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, false);
        goto L162
    L93:
        SchemaUtil.writeSFixed64List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, false);
        goto L162
    L94:
        SchemaUtil.writeSFixed32List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, false);
        goto L162
    L95:
        SchemaUtil.writeEnumList(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, false);
        goto L162
    L96:
        SchemaUtil.writeUInt32List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, false);
        goto L162
    L97:
        SchemaUtil.writeBytesList(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer);
        goto L162
    L98:
        SchemaUtil.writeMessageList(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, getMessageFieldSchema(r3));
        goto L162
    L99:
        SchemaUtil.writeStringList(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer);
        goto L162
    L100:
        SchemaUtil.writeBoolList(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, false);
        goto L162
    L101:
        SchemaUtil.writeFixed32List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, false);
        goto L162
    L102:
        SchemaUtil.writeFixed64List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, false);
        goto L162
    L103:
        SchemaUtil.writeInt32List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, false);
        goto L162
    L104:
        SchemaUtil.writeUInt64List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, false);
        goto L162
    L105:
        SchemaUtil.writeInt64List(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, false);
        goto L162
    L106:
        SchemaUtil.writeFloatList(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, false);
        goto L162
    L107:
        SchemaUtil.writeDoubleList(numberAt(r3), (List) UnsafeUtil.getObject(message, offset(r4)), writer, false);
        goto L162
    L22:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writer.writeGroup(r5, UnsafeUtil.getObject(message, offset(r4)), getMessageFieldSchema(r3));
        goto L162
    L25:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writer.writeSInt64(r5, oneofLongAt(message, offset(r4)));
        goto L162
    L28:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writer.writeSInt32(r5, oneofIntAt(message, offset(r4)));
        goto L162
    L31:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writer.writeSFixed64(r5, oneofLongAt(message, offset(r4)));
        goto L162
    L34:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writer.writeSFixed32(r5, oneofIntAt(message, offset(r4)));
        goto L162
    L37:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writer.writeEnum(r5, oneofIntAt(message, offset(r4)));
        goto L162
    L40:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writer.writeUInt32(r5, oneofIntAt(message, offset(r4)));
        goto L162
    L43:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writer.writeBytes(r5, (ByteString) UnsafeUtil.getObject(message, offset(r4)));
        goto L162
    L46:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writer.writeMessage(r5, UnsafeUtil.getObject(message, offset(r4)), getMessageFieldSchema(r3));
        goto L162
    L49:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writeString(r5, UnsafeUtil.getObject(message, offset(r4)), writer);
        goto L162
    L52:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writer.writeBool(r5, oneofBooleanAt(message, offset(r4)));
        goto L162
    L55:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writer.writeFixed32(r5, oneofIntAt(message, offset(r4)));
        goto L162
    L58:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writer.writeFixed64(r5, oneofLongAt(message, offset(r4)));
        goto L162
    L61:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writer.writeInt32(r5, oneofIntAt(message, offset(r4)));
        goto L162
    L64:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writer.writeUInt64(r5, oneofLongAt(message, offset(r4)));
        goto L162
    L67:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writer.writeInt64(r5, oneofLongAt(message, offset(r4)));
        goto L162
    L70:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writer.writeFloat(r5, oneofFloatAt(message, offset(r4)));
        goto L162
    L73:
        if (isOneofPresent(message, r5, r3) == false) goto L162;
        writer.writeDouble(r5, oneofDoubleAt(message, offset(r4)));
        goto L162
    L109:
        if (isFieldPresent(message, r3) == false) goto L162;
        writer.writeGroup(r5, UnsafeUtil.getObject(message, offset(r4)), getMessageFieldSchema(r3));
        goto L162
    L112:
        if (isFieldPresent(message, r3) == false) goto L162;
        writer.writeSInt64(r5, longAt(message, offset(r4)));
        goto L162
    L115:
        if (isFieldPresent(message, r3) == false) goto L162;
        writer.writeSInt32(r5, intAt(message, offset(r4)));
        goto L162
    L118:
        if (isFieldPresent(message, r3) == false) goto L162;
        writer.writeSFixed64(r5, longAt(message, offset(r4)));
        goto L162
    L121:
        if (isFieldPresent(message, r3) == false) goto L162;
        writer.writeSFixed32(r5, intAt(message, offset(r4)));
        goto L162
    L124:
        if (isFieldPresent(message, r3) == false) goto L162;
        writer.writeEnum(r5, intAt(message, offset(r4)));
        goto L162
    L127:
        if (isFieldPresent(message, r3) == false) goto L162;
        writer.writeUInt32(r5, intAt(message, offset(r4)));
        goto L162
    L130:
        if (isFieldPresent(message, r3) == false) goto L162;
        writer.writeBytes(r5, (ByteString) UnsafeUtil.getObject(message, offset(r4)));
        goto L162
    L133:
        if (isFieldPresent(message, r3) == false) goto L162;
        writer.writeMessage(r5, UnsafeUtil.getObject(message, offset(r4)), getMessageFieldSchema(r3));
        goto L162
    L136:
        if (isFieldPresent(message, r3) == false) goto L162;
        writeString(r5, UnsafeUtil.getObject(message, offset(r4)), writer);
        goto L162
    L139:
        if (isFieldPresent(message, r3) == false) goto L162;
        writer.writeBool(r5, booleanAt(message, offset(r4)));
        goto L162
    L142:
        if (isFieldPresent(message, r3) == false) goto L162;
        writer.writeFixed32(r5, intAt(message, offset(r4)));
        goto L162
    L145:
        if (isFieldPresent(message, r3) == false) goto L162;
        writer.writeFixed64(r5, longAt(message, offset(r4)));
        goto L162
    L148:
        if (isFieldPresent(message, r3) == false) goto L162;
        writer.writeInt32(r5, intAt(message, offset(r4)));
        goto L162
    L151:
        if (isFieldPresent(message, r3) == false) goto L162;
        writer.writeUInt64(r5, longAt(message, offset(r4)));
        goto L162
    L154:
        if (isFieldPresent(message, r3) == false) goto L162;
        writer.writeInt64(r5, longAt(message, offset(r4)));
        goto L162
    L157:
        if (isFieldPresent(message, r3) == false) goto L162;
        writer.writeFloat(r5, floatAt(message, offset(r4)));
        goto L162
    L160:
        if (isFieldPresent(message, r3) == false) goto L162;
        writer.writeDouble(r5, doubleAt(message, offset(r4)));
    L162:
        r3 = r3 - 3;
    L163:
        if (r2 == null) goto L168;
        this.extensionSchema.serializeExtension(writer, r2);
        if (r1.hasNext() == true) goto L166;
        r2 = null;
        goto L163
    L166:
        r2 = (Map.Entry) r1.next();
        goto L163
    L168:
        return;
    L7:
        r1 = null;
        r2 = null;
        goto L8
    }

    private <K, V> void writeMapHelper(Writer writer, int number, Object mapField, int pos) throws IOException {
        if (mapField == null) goto L5;
        writer.writeMap(number, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(pos)), this.mapFieldSchema.forMapData(mapField));
        return;
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> schema, T message, Writer writer) throws IOException {
        schema.writeTo(schema.getFromMessage(message), writer);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException {
        extensionRegistry.getClass();
        checkMutable(message);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, message, reader, extensionRegistry);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.google.crypto.tink.shaded.protobuf.Reader] */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> r19, ExtensionSchema<ET> r20, T r21, Reader r22, ExtensionRegistryLite r23) throws IOException {
        UnknownFieldSchema r7 = r19;
        T r15 = r21;
        ExtensionRegistryLite r6 = r23;
        Object r5 = null;
        FieldSet r9 = null;
    L212:
        int r2 = r22.getFieldNumber();     // Catch: Throwable -> L195
        int r3 = positionForFieldNumber(r2);     // Catch: Throwable -> L195
        if (r3 < 0) goto L6;
        T r10 = r15;
        int r11 = typeAndOffsetAt(r3);     // Catch: Throwable -> L192
        switch(type(r11)) {
            case 0: goto L150;
            case 1: goto L149;
            case 2: goto L148;
            case 3: goto L147;
            case 4: goto L146;
            case 5: goto L145;
            case 6: goto L144;
            case 7: goto L143;
            case 8: goto L142;
            case 9: goto L141;
            case 10: goto L140;
            case 11: goto L139;
            case 12: goto L132;
            case 13: goto L131;
            case 14: goto L130;
            case 15: goto L129;
            case 16: goto L128;
            case 17: goto L127;
            case 18: goto L126;
            case 19: goto L125;
            case 20: goto L124;
            case 21: goto L123;
            case 22: goto L122;
            case 23: goto L121;
            case 24: goto L120;
            case 25: goto L119;
            case 26: goto L118;
            case 27: goto L117;
            case 28: goto L116;
            case 29: goto L115;
            case 30: goto L114;
            case 31: goto L113;
            case 32: goto L112;
            case 33: goto L111;
            case 34: goto L110;
            case 35: goto L109;
            case 36: goto L108;
            case 37: goto L107;
            case 38: goto L106;
            case 39: goto L105;
            case 40: goto L104;
            case 41: goto L103;
            case 42: goto L102;
            case 43: goto L101;
            case 44: goto L100;
            case 45: goto L99;
            case 46: goto L98;
            case 47: goto L97;
            case 48: goto L96;
            case 49: goto L90;
            case 50: goto L86;
            case 51: goto L82;
            case 52: goto L81;
            case 53: goto L80;
            case 54: goto L79;
            case 55: goto L78;
            case 56: goto L77;
            case 57: goto L76;
            case 58: goto L75;
            case 59: goto L73;
            case 60: goto L72;
            case 61: goto L71;
            case 62: goto L70;
            case 63: goto L63;
            case 64: goto L62;
            case 65: goto L61;
            case 66: goto L60;
            case 67: goto L59;
            case 68: goto L223;
            default: goto L54;
        };
    L54:
        Object r12 = r5;
        ExtensionRegistryLite r13 = r6;
        UnknownFieldSchema r14 = r7;
        if (r12 == null) goto L225;
        r5 = r12;
    L208:
        if (r14.mergeOneFieldFrom(r5, r22) == false) goto L158;
    L189:
        r15 = r10;
        r6 = r13;
        r7 = r14;
        goto L212
    L158:
        int r0 = this.checkInitializedCount;
        Object r4 = r5;
    L160:
        if (r0 >= this.repeatedFieldOffsetStart) goto L162;
        r4 = filterMapUnknownEnumValues(r21, this.intArray[r0], r4, r19, r21);
        r0 = r0 + 1;
        goto L160
    L162:
        if (r4 == null) goto L246;
        r14.setBuilderToMessage(r10, r4);
        return;
    L246:
        return;
    L190:
        th = th;
    L198:
        int r8 = this.checkInitializedCount;
        Object r16 = r5;
    L200:
        if (r8 >= this.repeatedFieldOffsetStart) goto L202;
        r16 = filterMapUnknownEnumValues(r21, this.intArray[r8], r16, r19, r21);
        r8 = r8 + 1;
        goto L200
    L202:
        if (r16 == null) goto L204;
        r14.setBuilderToMessage(r10, r16);
    L204:
        throw th;
    L168:
        if (r14.shouldDiscardUnknownFields(r22) == true) goto L170;
        if (r5 != null) goto L181;
        r5 = r14.getBuilderFromMessage(r10);     // Catch: Throwable -> L190
    L181:
        if (r14.mergeOneFieldFrom(r5, r22) == true) goto L189;
        int r1 = this.checkInitializedCount;
        Object r17 = r5;
    L184:
        if (r1 >= this.repeatedFieldOffsetStart) goto L186;
        r17 = filterMapUnknownEnumValues(r21, this.intArray[r1], r17, r19, r21);
        r1 = r1 + 1;
        goto L184
    L186:
        if (r17 == null) goto L248;
        r14.setBuilderToMessage(r10, r17);
        return;
    L248:
        return;
    L170:
        if (r22.skipField() == true) goto L189;
        int r18 = this.checkInitializedCount;
        Object r24 = r5;
    L173:
        if (r18 >= this.repeatedFieldOffsetStart) goto L175;
        r24 = filterMapUnknownEnumValues(r21, this.intArray[r18], r24, r19, r21);
        r18 = r18 + 1;
        goto L173
    L175:
        if (r24 == null) goto L247;
        r14.setBuilderToMessage(r10, r24);
        return;
    L247:
        return;
    L225:
        r5 = r14.getBuilderFromMessage(r10);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
    L152:
        th = th;
    L153:
        r5 = r12;
    L154:
        r5 = r12;
        goto L168
    L59:
        UnsafeUtil.putObject(r10, offset(r11), Long.valueOf(r22.readSInt64()));     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        setOneofPresent(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
    L74:
        r12 = r5;
        r13 = r6;
    L89:
        r14 = r7;
    L151:
        r5 = r12;
        goto L189
    L60:
        UnsafeUtil.putObject(r10, offset(r11), Integer.valueOf(r22.readSInt32()));     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        setOneofPresent(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        goto L74
    L61:
        UnsafeUtil.putObject(r10, offset(r11), Long.valueOf(r22.readSFixed64()));     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        setOneofPresent(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        goto L74
    L62:
        UnsafeUtil.putObject(r10, offset(r11), Integer.valueOf(r22.readSFixed32()));     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        setOneofPresent(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        goto L74
    L63:
        int r25 = r22.readEnum();     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        Internal.EnumVerifier r110 = getEnumFieldVerifier(r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        if (r110 != null) goto L66;
    L69:
        UnsafeUtil.putObject(r10, offset(r11), Integer.valueOf(r25));     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        setOneofPresent(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        goto L74
    L66:
        if (r110.isInRange(r25) == true) goto L69;
        r5 = SchemaUtil.storeUnknownEnum(r10, r2, r25, r5, r7);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        r13 = r6;
        r14 = r7;
        goto L189
    L70:
        UnsafeUtil.putObject(r10, offset(r11), Integer.valueOf(r22.readUInt32()));     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        setOneofPresent(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        goto L74
    L71:
        UnsafeUtil.putObject(r10, offset(r11), r22.readBytes());     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        setOneofPresent(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        goto L74
    L72:
        MessageLite r26 = (MessageLite) mutableOneofMessageFieldForMerge(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        r22.mergeMessageField(r26, getMessageFieldSchema(r3), r6);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        storeOneofMessageField(r10, r2, r3, r26);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        goto L74
    L73:
        readString(r10, r11, r22);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        setOneofPresent(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        goto L74
    L75:
        UnsafeUtil.putObject(r10, offset(r11), Boolean.valueOf(r22.readBool()));     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        setOneofPresent(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        goto L74
    L76:
        UnsafeUtil.putObject(r10, offset(r11), Integer.valueOf(r22.readFixed32()));     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        setOneofPresent(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        goto L74
    L77:
        UnsafeUtil.putObject(r10, offset(r11), Long.valueOf(r22.readFixed64()));     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        setOneofPresent(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        goto L74
    L78:
        UnsafeUtil.putObject(r10, offset(r11), Integer.valueOf(r22.readInt32()));     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        setOneofPresent(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        goto L74
    L79:
        UnsafeUtil.putObject(r10, offset(r11), Long.valueOf(r22.readUInt64()));     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        setOneofPresent(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        goto L74
    L80:
        UnsafeUtil.putObject(r10, offset(r11), Long.valueOf(r22.readInt64()));     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        setOneofPresent(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        goto L74
    L81:
        UnsafeUtil.putObject(r10, offset(r11), Float.valueOf(r22.readFloat()));     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        setOneofPresent(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        goto L74
    L82:
        UnsafeUtil.putObject(r10, offset(r11), Double.valueOf(r22.readDouble()));     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        setOneofPresent(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        goto L74
    L86:
        r12 = r5;
        r13 = r6;
        mergeMap(r21, r3, getMapFieldDefaultEntry(r3), r23, r22);     // Catch: Throwable -> L93 InvalidProtocolBufferException.InvalidWireTypeException -> L95
    L95:
        r14 = r7;
    L93:
        th = th;
        r14 = r7;
        goto L153
        goto L166
    L90:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        readGroupList(r21, offset(r11), r22, getMessageFieldSchema(r3), r23);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L96:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readSInt64List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L97:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readSInt32List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L98:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readSFixed64List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L99:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readSFixed32List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L100:
        r13 = r6;
        r14 = r7;
        List r27 = this.listFieldSchema.mutableListAt(r10, offset(r11));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        r22.readEnumList(r27);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        r5 = SchemaUtil.filterUnknownEnumList(r21, r2, r27, getEnumFieldVerifier(r3), r5, r19);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L189
    L101:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readUInt32List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L102:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readBoolList(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L103:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readFixed32List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L104:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readFixed64List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L105:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readInt32List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L106:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readUInt64List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L107:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readInt64List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L108:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readFloatList(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L109:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readDoubleList(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L110:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readSInt64List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L111:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readSInt32List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L112:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readSFixed64List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L113:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readSFixed32List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L114:
        r13 = r6;
        r14 = r7;
        List r28 = this.listFieldSchema.mutableListAt(r10, offset(r11));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        r22.readEnumList(r28);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        r5 = SchemaUtil.filterUnknownEnumList(r21, r2, r28, getEnumFieldVerifier(r3), r5, r19);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L189
    L115:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readUInt32List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L116:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readBytesList(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L117:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        readMessageList(r21, r11, r22, getMessageFieldSchema(r3), r23);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L118:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        readStringList(r10, r11, r22);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L119:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readBoolList(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L120:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readFixed32List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L121:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readFixed64List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L122:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readInt32List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L123:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readUInt64List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L124:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readInt64List(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L125:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readFloatList(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L126:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        r22.readDoubleList(this.listFieldSchema.mutableListAt(r10, offset(r11)));     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L127:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        MessageLite r29 = (MessageLite) mutableMessageFieldForMerge(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        r22.mergeGroupField(r29, getMessageFieldSchema(r3), r13);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        storeMessageField(r10, r3, r29);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L128:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        UnsafeUtil.putLong(r10, offset(r11), r22.readSInt64());     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        setFieldPresent(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L129:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        UnsafeUtil.putInt(r10, offset(r11), r22.readSInt32());     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        setFieldPresent(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L130:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        UnsafeUtil.putLong(r10, offset(r11), r22.readSFixed64());     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        setFieldPresent(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L131:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        UnsafeUtil.putInt(r10, offset(r11), r22.readSFixed32());     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        setFieldPresent(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L132:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        int r30 = r22.readEnum();     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        Internal.EnumVerifier r31 = getEnumFieldVerifier(r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        if (r31 != null) goto L135;
    L138:
        UnsafeUtil.putInt(r10, offset(r11), r30);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        setFieldPresent(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L135:
        if (r31.isInRange(r30) == true) goto L138;
        r5 = SchemaUtil.storeUnknownEnum(r10, r2, r30, r12, r14);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L189
    L139:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        UnsafeUtil.putInt(r10, offset(r11), r22.readUInt32());     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        setFieldPresent(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L140:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        UnsafeUtil.putObject(r10, offset(r11), r22.readBytes());     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        setFieldPresent(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L141:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        MessageLite r32 = (MessageLite) mutableMessageFieldForMerge(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        r22.mergeMessageField(r32, getMessageFieldSchema(r3), r13);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        storeMessageField(r10, r3, r32);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L142:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        readString(r10, r11, r22);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        setFieldPresent(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L143:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        UnsafeUtil.putBoolean(r10, offset(r11), r22.readBool());     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        setFieldPresent(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L144:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        UnsafeUtil.putInt(r10, offset(r11), r22.readFixed32());     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        setFieldPresent(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L145:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        UnsafeUtil.putLong(r10, offset(r11), r22.readFixed64());     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        setFieldPresent(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L146:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        UnsafeUtil.putInt(r10, offset(r11), r22.readInt32());     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        setFieldPresent(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L147:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        UnsafeUtil.putLong(r10, offset(r11), r22.readUInt64());     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        setFieldPresent(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L148:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        UnsafeUtil.putLong(r10, offset(r11), r22.readInt64());     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        setFieldPresent(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L149:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        UnsafeUtil.putFloat(r10, offset(r11), r22.readFloat());     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        setFieldPresent(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L150:
        r12 = r5;
        r13 = r6;
        r14 = r7;
        UnsafeUtil.putDouble(r10, offset(r11), r22.readDouble());     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        setFieldPresent(r10, r3);     // Catch: Throwable -> L152 InvalidProtocolBufferException.InvalidWireTypeException -> L206
        goto L151
    L223:
        MessageLite r33 = (MessageLite) mutableOneofMessageFieldForMerge(r10, r2, r3);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        r22.mergeGroupField(r33, getMessageFieldSchema(r3), r6);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
        storeOneofMessageField(r10, r2, r3, r33);     // Catch: Throwable -> L84 InvalidProtocolBufferException.InvalidWireTypeException -> L207
    L84:
        th = th;
    L194:
        r14 = r7;
    L166:
        r13 = r6;
        r14 = r7;
    L192:
        th = th;
        goto L194
    L6:
        if (r2 == Integer.MAX_VALUE) goto L7;
    L48:
        th = th;
        r10 = r15;
        goto L194
    L15:
        if (this.hasExtensions == true) goto L17;
        Object r111 = null;
    L19:
        if (r111 == null) goto L28;
        if (r9 == null) goto L219;
    L25:
        FieldSet r34 = r9;
        T r35 = r15;
        r5 = r20.parseExtension(r21, r22, r111, r23, r34, r5, r19);     // Catch: Throwable -> L46
        r9 = r34;
    L27:
        r15 = r35;
    L46:
        th = th;
        r10 = r35;
        goto L194
    L219:
        r9 = r20.getMutableExtensions(r21);     // Catch: Throwable -> L23
    L23:
        th = th;
    L197:
        r14 = r7;
        r10 = r15;
        goto L198
    L28:
        r35 = r15;
        if (r7.shouldDiscardUnknownFields(r22) == true) goto L31;
        if (r5 != null) goto L36;
        r5 = r7.getBuilderFromMessage(r35);     // Catch: Throwable -> L46
    L36:
        if (r7.mergeOneFieldFrom(r5, r22) == false) goto L38;
    L32:
        r9 = r9;
    L38:
        int r36 = this.checkInitializedCount;
        Object r37 = r5;
    L40:
        if (r36 >= this.repeatedFieldOffsetStart) goto L42;
        r37 = filterMapUnknownEnumValues(r21, this.intArray[r36], r37, r19, r21);
        r36 = r36 + 1;
        r35 = r35;
        goto L40
    L42:
        T r112 = r35;
        if (r37 == null) goto L245;
        r7.setBuilderToMessage(r112, r37);
        return;
    L245:
        return;
    L31:
        if (r22.skipField() == false) goto L38;
    L17:
        r111 = r20.findExtensionByNumber(r6, this.defaultInstance, r2);     // Catch: Throwable -> L48
        goto L19
    L7:
        int r38 = this.checkInitializedCount;
        Object r39 = r5;
    L9:
        if (r38 >= this.repeatedFieldOffsetStart) goto L11;
        r39 = filterMapUnknownEnumValues(r21, this.intArray[r38], r39, r19, r21);
        r38 = r38 + 1;
        goto L9
    L11:
        if (r39 == null) goto L244;
        r7.setBuilderToMessage(r15, r39);
        return;
    L244:
        return;
    L195:
        th = th;
        goto L197
    }

    static UnknownFieldSetLite getMutableUnknownFields(Object message) {
        GeneratedMessageLite r2 = (GeneratedMessageLite) message;
        UnknownFieldSetLite r0 = r2.unknownFields;
        if (r0 != UnknownFieldSetLite.getDefaultInstance()) goto L6;
        UnknownFieldSetLite r1 = UnknownFieldSetLite.newInstance();
        r2.unknownFields = r1;
        return r1;
    L6:
        return r0;
    }

    private int decodeMapEntryValue(byte[] data, int position, int limit, WireFormat.FieldType fieldType, Class<?> messageType, ArrayDecoders.Registers registers) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1: goto L19;
            case 2: goto L33;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L11;
            case 11: goto L11;
            case 12: goto L10;
            case 13: goto L10;
            case 14: goto L28;
            case 15: goto L8;
            case 16: goto L7;
            case 17: goto L25;
            default: goto L5;
        };
    L7:
        int r0 = ArrayDecoders.decodeVarint64(data, position, registers);
        registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
        return r0;
    L8:
        int r1 = ArrayDecoders.decodeVarint32(data, position, registers);
        registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
        return r1;
    L10:
        int r2 = ArrayDecoders.decodeVarint64(data, position, registers);
        registers.object1 = Long.valueOf(registers.long1);
        return r2;
    L11:
        int r3 = ArrayDecoders.decodeVarint32(data, position, registers);
        registers.object1 = Integer.valueOf(registers.int1);
        return r3;
    L12:
        registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(data, position));
    L31:
        return position + 4;
    L13:
        registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(data, position));
    L32:
        return position + 8;
    L14:
        registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(data, position));
        goto L31
    L16:
        registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(data, position));
        goto L32
    L19:
        int r4 = ArrayDecoders.decodeVarint64(data, position, registers);
        if (registers.long1 == 0) goto L22;
        boolean r5 = true;
    L23:
        registers.object1 = Boolean.valueOf(r5);
        return r4;
    L22:
        r5 = false;
        goto L23
    L5:
        throw new RuntimeException("unsupported field type.");
    L25:
        return ArrayDecoders.decodeStringRequireUtf8(data, position, registers);
    L28:
        return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(messageType), data, position, limit, registers);
    L33:
        return ArrayDecoders.decodeBytes(data, position, registers);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] data, int position, int limit, MapEntryLite.Metadata<K, V> metadata, Map<K, V> target, ArrayDecoders.Registers registers) throws IOException {
        int r0 = ArrayDecoders.decodeVarint32(data, position, registers);
        int r1 = registers.int1;
        if (r1 < 0) goto L30;
        if (r1 > (limit - r0)) goto L30;
        int r11 = r0 + r1;
        K r2 = metadata.defaultKey;
        Object r12 = r2;
        Object r13 = metadata.defaultValue;
    L7:
        if (r0 >= r11) goto L24;
        int r3 = r0 + 1;
        int r4 = data[r0];
        if (r4 >= 0) goto L11;
        int r5 = ArrayDecoders.decodeVarint32(r4, data, r3, registers);
        int r6 = r5;
        r4 = registers.int1;
    L12:
        int r7 = r4 >>> 3;
        int r8 = r4 & 7;
        if (r7 != 1) goto L15;
        if (r8 != metadata.keyType.getWireType()) goto L23;
        r0 = decodeMapEntryValue(data, r6, limit, metadata.keyType, null, registers);
        r12 = registers.object1;
    L23:
        r0 = ArrayDecoders.skipField(r4, data, r6, limit, registers);
        goto L7
    L15:
        if (r7 != 2) goto L23;
        if (r8 != metadata.valueType.getWireType()) goto L23;
        r0 = decodeMapEntryValue(data, r6, limit, metadata.valueType, metadata.defaultValue.getClass(), registers);
        r13 = registers.object1;
        goto L7
    L11:
        r6 = r3;
        goto L12
    L24:
        if (r0 != r11) goto L28;
        target.put(r12, r13);
        return r11;
    L28:
        throw InvalidProtocolBufferException.parseFailure();
    L30:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private int parseRepeatedField(T message, byte[] data, int position, int limit, int tag, int number, int wireType, int bufferPosition, long typeAndOffset, int fieldType, long fieldOffset, ArrayDecoders.Registers registers) throws IOException {
        Unsafe r9 = UNSAFE;
        Internal.ProtobufList r10 = (Internal.ProtobufList) r9.getObject(message, fieldOffset);
        if (r10.isModifiable() == true) goto L10;
        int r11 = r10.size();
        if (r11 != 0) goto L7;
        int r12 = 10;
    L8:
        r10 = r10.mutableCopyWithCapacity(r12);
        r9.putObject(message, fieldOffset, r10);
        goto L10
    L7:
        r12 = r11 * 2;
    L10:
        switch(fieldType) {
            case 18: goto L61;
            case 19: goto L57;
            case 20: goto L53;
            case 21: goto L53;
            case 22: goto L49;
            case 23: goto L45;
            case 24: goto L41;
            case 25: goto L37;
            case 26: goto L32;
            case 27: goto L30;
            case 28: goto L28;
            case 29: goto L49;
            case 30: goto L23;
            case 31: goto L41;
            case 32: goto L45;
            case 33: goto L19;
            case 34: goto L15;
            case 35: goto L61;
            case 36: goto L57;
            case 37: goto L53;
            case 38: goto L53;
            case 39: goto L49;
            case 40: goto L45;
            case 41: goto L41;
            case 42: goto L37;
            case 43: goto L49;
            case 44: goto L23;
            case 45: goto L41;
            case 46: goto L45;
            case 47: goto L19;
            case 48: goto L15;
            case 49: goto L13;
            default: goto L118;
        };
    L15:
        if (wireType == 2) goto L82;
        if (wireType != 0) goto L105;
        return ArrayDecoders.decodeSInt64List(tag, data, position, limit, r10, registers);
    L105:
        return position;
    L82:
        return ArrayDecoders.decodePackedSInt64List(data, position, r10, registers);
    L19:
        if (wireType == 2) goto L84;
        if (wireType != 0) goto L106;
        return ArrayDecoders.decodeSInt32List(tag, data, position, limit, r10, registers);
    L106:
        return position;
    L84:
        return ArrayDecoders.decodePackedSInt32List(data, position, r10, registers);
    L23:
        if (wireType != 2) goto L25;
        int r2 = ArrayDecoders.decodePackedVarint32List(data, position, r10, registers);
    L27:
        Internal.ProtobufList r15 = r10;
        SchemaUtil.filterUnknownEnumList(message, number, r15, getEnumFieldVerifier(bufferPosition), null, this.unknownFieldSchema);
        return r2;
    L25:
        if (wireType != 0) goto L107;
        r2 = ArrayDecoders.decodeVarint32List(tag, data, position, limit, r10, registers);
        goto L27
    L107:
        return position;
    L28:
        if (wireType != 2) goto L108;
        return ArrayDecoders.decodeBytesList(tag, data, position, limit, r10, registers);
    L108:
        return position;
    L30:
        if (wireType != 2) goto L109;
        return ArrayDecoders.decodeMessageList(getMessageFieldSchema(bufferPosition), tag, data, position, limit, r10, registers);
    L109:
        return position;
    L32:
        if (wireType != 2) goto L110;
        if ((typeAndOffset & 536870912) != 0) goto L90;
        return ArrayDecoders.decodeStringList(tag, data, position, limit, r10, registers);
    L90:
        return ArrayDecoders.decodeStringListRequireUtf8(tag, data, position, limit, r10, registers);
    L110:
        return position;
    L37:
        if (wireType == 2) goto L91;
        if (wireType != 0) goto L111;
        return ArrayDecoders.decodeBoolList(tag, data, position, limit, r10, registers);
    L111:
        return position;
    L91:
        return ArrayDecoders.decodePackedBoolList(data, position, r10, registers);
    L41:
        if (wireType == 2) goto L93;
        if (wireType != 5) goto L112;
        return ArrayDecoders.decodeFixed32List(tag, data, position, limit, r10, registers);
    L112:
        return position;
    L93:
        return ArrayDecoders.decodePackedFixed32List(data, position, r10, registers);
    L45:
        if (wireType == 2) goto L95;
        if (wireType != 1) goto L113;
        return ArrayDecoders.decodeFixed64List(tag, data, position, limit, r10, registers);
    L113:
        return position;
    L95:
        return ArrayDecoders.decodePackedFixed64List(data, position, r10, registers);
    L49:
        if (wireType == 2) goto L97;
        if (wireType != 0) goto L114;
        return ArrayDecoders.decodeVarint32List(tag, data, position, limit, r10, registers);
    L114:
        return position;
    L97:
        return ArrayDecoders.decodePackedVarint32List(data, position, r10, registers);
    L53:
        if (wireType == 2) goto L99;
        if (wireType != 0) goto L115;
        return ArrayDecoders.decodeVarint64List(tag, data, position, limit, r10, registers);
    L115:
        return position;
    L99:
        return ArrayDecoders.decodePackedVarint64List(data, position, r10, registers);
    L57:
        if (wireType == 2) goto L101;
        if (wireType != 5) goto L116;
        return ArrayDecoders.decodeFloatList(tag, data, position, limit, r10, registers);
    L116:
        return position;
    L101:
        return ArrayDecoders.decodePackedFloatList(data, position, r10, registers);
    L61:
        if (wireType == 2) goto L103;
        if (wireType != 1) goto L117;
        return ArrayDecoders.decodeDoubleList(tag, data, position, limit, r10, registers);
    L117:
        return position;
    L103:
        return ArrayDecoders.decodePackedDoubleList(data, position, r10, registers);
    L13:
        if (wireType != 3) goto L66;
        return ArrayDecoders.decodeGroupList(getMessageFieldSchema(bufferPosition), tag, data, position, limit, r10, registers);
    L66:
        return position;
    L118:
        return position;
    }

    private <K, V> int parseMapField(T message, byte[] data, int position, int limit, int bufferPosition, long fieldOffset, ArrayDecoders.Registers registers) throws IOException {
        Unsafe r4 = UNSAFE;
        Object r5 = getMapFieldDefaultEntry(bufferPosition);
        Object r6 = r4.getObject(message, fieldOffset);
        if (this.mapFieldSchema.isImmutable(r6) == false) goto L6;
        Object r7 = this.mapFieldSchema.newMapField(r5);
        this.mapFieldSchema.mergeFrom(r7, r6);
        r4.putObject(message, fieldOffset, r7);
        r6 = r7;
    L6:
        return decodeMapEntry(data, position, limit, this.mapFieldSchema.forMapMetadata(r5), this.mapFieldSchema.forMutableMapData(r6), registers);
    }

    private int parseOneofField(T message, byte[] data, int position, int limit, int tag, int number, int wireType, int typeAndOffset, int fieldType, long fieldOffset, int bufferPosition, ArrayDecoders.Registers registers) throws IOException {
        Unsafe r11 = UNSAFE;
        long r12 = this.buffer[bufferPosition + 2] & 1048575;
        switch(fieldType) {
            case 51: goto L57;
            case 52: goto L54;
            case 53: goto L52;
            case 54: goto L52;
            case 55: goto L50;
            case 56: goto L48;
            case 57: goto L45;
            case 58: goto L39;
            case 59: goto L26;
            case 60: goto L23;
            case 61: goto L21;
            case 62: goto L50;
            case 63: goto L12;
            case 64: goto L45;
            case 65: goto L48;
            case 66: goto L10;
            case 67: goto L8;
            case 68: goto L6;
            default: goto L101;
        };
    L8:
        if (wireType != 0) goto L88;
        int r0 = ArrayDecoders.decodeVarint64(data, position, registers);
        r11.putObject(message, fieldOffset, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
        r11.putInt(message, r12, number);
        return r0;
    L88:
        return position;
    L10:
        if (wireType != 0) goto L89;
        int r1 = ArrayDecoders.decodeVarint32(data, position, registers);
        r11.putObject(message, fieldOffset, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
        r11.putInt(message, r12, number);
        return r1;
    L89:
        return position;
    L12:
        if (wireType != 0) goto L90;
        int r3 = ArrayDecoders.decodeVarint32(data, position, registers);
        int r4 = registers.int1;
        Internal.EnumVerifier r2 = getEnumFieldVerifier(bufferPosition);
        if (r2 != null) goto L16;
    L19:
        r11.putObject(message, fieldOffset, Integer.valueOf(r4));
        r11.putInt(message, r12, number);
    L77:
        return r3;
    L16:
        if (r2.isInRange(r4) == true) goto L19;
        getMutableUnknownFields(message).storeField(tag, Long.valueOf(r4));
        goto L77
    L90:
        return position;
    L21:
        if (wireType != 2) goto L91;
        int r5 = ArrayDecoders.decodeBytes(data, position, registers);
        r11.putObject(message, fieldOffset, registers.object1);
        r11.putInt(message, r12, number);
        return r5;
    L91:
        return position;
    L23:
        if (wireType != 2) goto L92;
        Object r13 = mutableOneofMessageFieldForMerge(message, number, bufferPosition);
        int r6 = ArrayDecoders.mergeMessageField(r13, getMessageFieldSchema(bufferPosition), data, position, limit, registers);
        storeOneofMessageField(message, number, bufferPosition, r13);
    L79:
        return r6;
    L92:
        return position;
    L26:
        if (wireType != 2) goto L93;
        int r7 = ArrayDecoders.decodeVarint32(data, position, registers);
        int r8 = registers.int1;
        if (r8 != 0) goto L31;
        r11.putObject(message, fieldOffset, "");
    L38:
        r11.putInt(message, r12, number);
        return r7;
    L31:
        if ((typeAndOffset & 536870912) != 0) goto L33;
    L37:
        r11.putObject(message, fieldOffset, new String(data, r7, r8, Internal.UTF_8));
        r7 = r7 + r8;
        goto L38
    L33:
        if (Utf8.isValidUtf8(data, r7, r7 + r8) == true) goto L37;
        throw InvalidProtocolBufferException.invalidUtf8();
    L93:
        return position;
    L39:
        if (wireType != 0) goto L94;
        int r9 = ArrayDecoders.decodeVarint64(data, position, registers);
        if (registers.long1 == 0) goto L43;
        boolean r15 = true;
    L44:
        r11.putObject(message, fieldOffset, Boolean.valueOf(r15));
        r11.putInt(message, r12, number);
        return r9;
    L43:
        r15 = false;
        goto L44
    L94:
        return position;
    L45:
        if (wireType != 5) goto L95;
        r11.putObject(message, fieldOffset, Integer.valueOf(ArrayDecoders.decodeFixed32(data, position)));
        int r10 = position + 4;
        r11.putInt(message, r12, number);
        return r10;
    L95:
        return position;
    L50:
        if (wireType != 0) goto L97;
        int r14 = ArrayDecoders.decodeVarint32(data, position, registers);
        r11.putObject(message, fieldOffset, Integer.valueOf(registers.int1));
        r11.putInt(message, r12, number);
        return r14;
    L97:
        return position;
    L52:
        if (wireType != 0) goto L98;
        int r16 = ArrayDecoders.decodeVarint64(data, position, registers);
        r11.putObject(message, fieldOffset, Long.valueOf(registers.long1));
        r11.putInt(message, r12, number);
        return r16;
    L98:
        return position;
    L54:
        if (wireType != 5) goto L99;
        r11.putObject(message, fieldOffset, Float.valueOf(ArrayDecoders.decodeFloat(data, position)));
        int r17 = position + 4;
        r11.putInt(message, r12, number);
        return r17;
    L99:
        return position;
    L6:
        if (wireType != 3) goto L60;
        Object r18 = mutableOneofMessageFieldForMerge(message, number, bufferPosition);
        r6 = ArrayDecoders.mergeGroupField(r18, getMessageFieldSchema(bufferPosition), data, position, limit, (tag & (-8)) | 4, registers);
        storeOneofMessageField(message, number, bufferPosition, r18);
        goto L79
    L60:
        return position;
    L48:
        if (wireType != 1) goto L96;
        r11.putObject(message, fieldOffset, Long.valueOf(ArrayDecoders.decodeFixed64(data, position)));
        int r19 = position + 8;
        r11.putInt(message, r12, number);
        return r19;
    L96:
        return position;
    L57:
        if (wireType != 1) goto L100;
        r11.putObject(message, fieldOffset, Double.valueOf(ArrayDecoders.decodeDouble(data, position)));
        int r20 = position + 8;
        r11.putInt(message, r12, number);
        return r20;
    L100:
        return position;
    L101:
        return position;
    }

    private Schema getMessageFieldSchema(int pos) {
        int r4 = (pos / 3) * 2;
        Schema r0 = (Schema) this.objects[r4];
        if (r0 == null) goto L5;
        return r0;
    L5:
        Schema<T> r1 = Protobuf.getInstance().schemaFor((Class) this.objects[r4 + 1]);
        this.objects[r4] = r1;
        return r1;
    }

    private Object getMapFieldDefaultEntry(int pos) {
        return this.objects[(pos / 3) * 2];
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int pos) {
        return (Internal.EnumVerifier) this.objects[((pos / 3) * 2) + 1];
    }

    int parseMessage(T message, byte[] data, int position, int limit, int endDelimited, ArrayDecoders.Registers registers) throws IOException {
        MessageSchema<T> r15 = this;
        T r14 = message;
        byte[] r12 = data;
        limit = limit;
        endDelimited = endDelimited;
        ArrayDecoders.Registers r9 = registers;
        checkMutable(message);
        Unsafe r10 = UNSAFE;
        int r0 = position;
        int r2 = 0;
        int r3 = 0;
        int r5 = 0;
        int r1 = -1;
        int r6 = 1048575;
    L3:
        if (r0 >= limit) goto L134;
        int r4 = r0 + 1;
        byte r7 = r12[r0];
        if (r7 >= 0) goto L7;
        int r8 = ArrayDecoders.decodeVarint32(r7, r12, r4, r9);
        int r11 = r9.int1;
        r4 = r8;
    L8:
        int r13 = r11 >>> 3;
        int r16 = r11 & 7;
        if (r13 <= r1) goto L11;
        int r17 = r15.positionForFieldNumber(r13, r2 / 3);
    L12:
        int r18 = r17;
        if (r18 == (-1)) goto L14;
        int r19 = r15.buffer[r18 + 1];
        int r20 = type(r19);
        long r110 = offset(r19);
        int r111 = r11;
        if (r20 <= 17) goto L17;
        int r23 = r13;
        int r112 = r6;
        int r113 = r5;
        if (r20 == 27) goto L95;
        int r22 = r112;
        if (r20 > 49) goto L111;
        int r21 = r4;
        Unsafe r26 = r10;
        int r24 = r18;
        int r114 = r111;
        r0 = parseRepeatedField(message, data, r4, limit, r111, r23, r16, r18, r19, r20, r110, registers);
        if (r0 == r21) goto L123;
    L110:
        r15 = this;
        r14 = message;
        r12 = data;
        endDelimited = endDelimited;
        r9 = registers;
        r3 = r114;
        r5 = r113;
        r2 = r24;
        r6 = r22;
        r1 = r23;
        r10 = r26;
    L123:
        int r25 = r0;
    L119:
        int r27 = r114;
    L124:
        if (r27 != endDelimited) goto L128;
        if (endDelimited == 0) goto L128;
        int r28 = 1048575;
        MessageSchema<T> r115 = this;
        int r29 = r25;
        r5 = r113;
        int r30 = r22;
    L135:
        if (r30 == r28) goto L137;
        T r31 = message;
        r26.putInt(r31, r30, r5);
    L138:
        int r116 = r115.checkInitializedCount;
        UnknownFieldSetLite r32 = null;
    L140:
        if (r116 >= r115.repeatedFieldOffsetStart) goto L142;
        r32 = (UnknownFieldSetLite) filterMapUnknownEnumValues(message, r115.intArray[r116], r32, r115.unknownFieldSchema, message);
        r116 = r116 + 1;
        goto L140
    L142:
        if (r32 == null) goto L144;
        r115.unknownFieldSchema.setBuilderToMessage(r31, r32);
    L144:
        if (endDelimited != 0) goto L151;
        if (r29 != limit) goto L149;
    L153:
        return r29;
    L149:
        throw InvalidProtocolBufferException.parseFailure();
    L151:
        if (r29 > limit) goto L155;
        if (r27 == endDelimited) goto L153;
    L155:
        throw InvalidProtocolBufferException.parseFailure();
    L137:
        r31 = message;
    L128:
        if (this.hasExtensions == true) goto L130;
    L132:
        r0 = ArrayDecoders.decodeUnknownField(r27, data, r25, limit, getMutableUnknownFields(message), registers);
    L133:
        r14 = message;
        r12 = data;
        r3 = r27;
        r15 = this;
        r9 = registers;
        r5 = r113;
        r2 = r24;
        r6 = r22;
        r1 = r23;
        r10 = r26;
        endDelimited = endDelimited;
        goto L3
    L130:
        if (registers.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) goto L132;
        r0 = ArrayDecoders.decodeExtensionOrUnknownField(r27, data, r25, limit, message, this.defaultInstance, this.unknownFieldSchema, registers);
        goto L133
    L111:
        int r117 = r4;
        r26 = r10;
        r24 = r18;
        r114 = r111;
        if (r20 == 50) goto L114;
        r0 = parseOneofField(message, data, r117, limit, r114, r23, r16, r19, r20, r110, r24, registers);
        if (r0 == r117) goto L123;
    L114:
        if (r16 != 2) goto L118;
        r0 = parseMapField(message, data, r117, limit, r24, r110, registers);
        if (r0 == r117) goto L123;
    L118:
        r25 = r117;
        goto L119
    L95:
        if (r16 != 2) goto L105;
        Internal.ProtobufList r33 = (Internal.ProtobufList) r10.getObject(r14, r110);
        if (r33.isModifiable() == true) goto L103;
        int r34 = r33.size();
        if (r34 != 0) goto L101;
        int r35 = 10;
    L102:
        r33 = r33.mutableCopyWithCapacity(r35);
        r10.putObject(r14, r110, r33);
        goto L103
    L101:
        r35 = r34 * 2;
    L103:
        r0 = ArrayDecoders.decodeMessageList(r15.getMessageFieldSchema(r18), r111, data, r4, limit, r33, registers);
        endDelimited = endDelimited;
        r2 = r18;
        r3 = r111;
        r5 = r113;
        r6 = r112;
        r1 = r23;
        r12 = data;
        goto L3
    L105:
        r22 = r112;
        r117 = r4;
        r26 = r10;
        r24 = r18;
        r114 = r111;
        goto L118
    L17:
        int r36 = r15.buffer[r18 + 2];
        int r118 = 1 << (r36 >>> 20);
        int r119 = 1048575;
        int r37 = r36 & 1048575;
        if (r37 == r6) goto L25;
        if (r6 == 1048575) goto L21;
        r10.putInt(r14, r6, r5);
        r119 = 1048575;
    L21:
        if (r37 != r119) goto L23;
        int r38 = 0;
    L24:
        r22 = r37;
        int r120 = r38;
    L27:
        switch(r20) {
            case 0: goto L86;
            case 1: goto L82;
            case 2: goto L78;
            case 3: goto L78;
            case 4: goto L75;
            case 5: goto L72;
            case 6: goto L69;
            case 7: goto L62;
            case 8: goto L55;
            case 9: goto L52;
            case 10: goto L49;
            case 11: goto L75;
            case 12: goto L39;
            case 13: goto L69;
            case 14: goto L72;
            case 15: goto L36;
            case 16: goto L33;
            case 17: goto L30;
            default: goto L28;
        };
    L39:
        byte[] r39 = data;
        r23 = r13;
        int r40 = r18;
        int r121 = r111;
        byte r122 = -1;
        if (r16 != 0) goto L91;
        r0 = ArrayDecoders.decodeVarint32(r39, r4, r9);
        int r41 = r9.int1;
        Internal.EnumVerifier r42 = r15.getEnumFieldVerifier(r40);
        if (isLegacyEnumIsClosed(r19) == false) goto L48;
        if (r42 == null) goto L48;
        if (r42.isInRange(r41) == true) goto L48;
        getMutableUnknownFields(message).storeField(r121, Long.valueOf(r41));
        endDelimited = endDelimited;
        r2 = r40;
        r5 = r120;
        r3 = r121;
        r6 = r22;
        r1 = r23;
        r12 = r39;
    L48:
        r10.putInt(r14, r110, r41);
    L89:
        r5 = r120 | r118;
        r2 = r40;
        r12 = r39;
    L90:
        r3 = r121;
        r6 = r22;
        r1 = r23;
    L91:
        endDelimited = endDelimited;
        r25 = r4;
        r24 = r40;
        r26 = r10;
        r113 = r120;
        r27 = r121;
        goto L124
    L28:
        r23 = r13;
        r40 = r18;
        r121 = r111;
        r122 = -1;
        goto L91
    L30:
        if (r16 != 3) goto L32;
        Object r43 = r15.mutableMessageFieldForMerge(r14, r18);
        r23 = r13;
        r121 = r111;
        r0 = ArrayDecoders.mergeGroupField(r43, r15.getMessageFieldSchema(r18), data, r4, limit, (r13 << 3) | 4, registers);
        r15.storeMessageField(r14, r18, r43);
        r5 = r120 | r118;
        r12 = data;
        r2 = r18;
        goto L90
    L32:
        r23 = r13;
        r121 = r111;
        r122 = -1;
        r40 = r18;
        goto L91
    L33:
        r23 = r13;
        r40 = r18;
        r121 = r111;
        r122 = -1;
        byte[] r44 = data;
        if (r16 != 0) goto L91;
        int r45 = ArrayDecoders.decodeVarint64(r44, r4, r9);
        r10.putLong(message, r110, CodedInputStream.decodeZigZag64(r9.long1));
    L81:
        r5 = r120 | r118;
        r2 = r40;
        r12 = r44;
        r0 = r45;
        goto L90
    L36:
        r39 = data;
        r23 = r13;
        r40 = r18;
        r121 = r111;
        r122 = -1;
        if (r16 != 0) goto L91;
        r0 = ArrayDecoders.decodeVarint32(r39, r4, r9);
        r10.putInt(r14, r110, CodedInputStream.decodeZigZag32(r9.int1));
        goto L89
    L49:
        r39 = data;
        r23 = r13;
        r40 = r18;
        r121 = r111;
        r122 = -1;
        if (r16 != 2) goto L91;
        r0 = ArrayDecoders.decodeBytes(r39, r4, r9);
        r10.putObject(r14, r110, r9.object1);
        goto L89
    L52:
        r39 = data;
        r23 = r13;
        r40 = r18;
        r121 = r111;
        r122 = -1;
        if (r16 != 2) goto L91;
        Object r46 = r15.mutableMessageFieldForMerge(r14, r40);
        r0 = ArrayDecoders.mergeMessageField(r46, r15.getMessageFieldSchema(r40), data, r4, limit, registers);
        r15.storeMessageField(r14, r40, r46);
        goto L89
    L55:
        r39 = data;
        r23 = r13;
        r40 = r18;
        r121 = r111;
        r122 = -1;
        if (r16 != 2) goto L91;
        if (isEnforceUtf8(r19) == false) goto L60;
        r0 = ArrayDecoders.decodeStringRequireUtf8(r39, r4, r9);
    L61:
        r10.putObject(r14, r110, r9.object1);
        goto L89
    L60:
        r0 = ArrayDecoders.decodeString(r39, r4, r9);
        goto L61
    L62:
        r39 = data;
        r23 = r13;
        r40 = r18;
        r121 = r111;
        r122 = -1;
        if (r16 != 0) goto L91;
        r0 = ArrayDecoders.decodeVarint64(r39, r4, r9);
        if (r9.long1 == 0) goto L67;
        boolean r47 = true;
    L68:
        UnsafeUtil.putBoolean(r14, r110, r47);
        goto L89
    L67:
        r47 = false;
        goto L68
    L69:
        r39 = data;
        r23 = r13;
        r40 = r18;
        r121 = r111;
        r122 = -1;
        if (r16 != 5) goto L91;
        r10.putInt(r14, r110, ArrayDecoders.decodeFixed32(r39, r4));
    L85:
        r0 = r4 + 4;
        goto L89
    L72:
        r39 = data;
        r23 = r13;
        r40 = r18;
        r121 = r111;
        r122 = -1;
        if (r16 != 1) goto L91;
        r10.putLong(message, r110, ArrayDecoders.decodeFixed64(r39, r4));
        r0 = r4 + 8;
        goto L89
    L75:
        r39 = data;
        r23 = r13;
        r40 = r18;
        r121 = r111;
        r122 = -1;
        if (r16 != 0) goto L91;
        r0 = ArrayDecoders.decodeVarint32(r39, r4, r9);
        r10.putInt(r14, r110, r9.int1);
        goto L89
    L78:
        r44 = data;
        r23 = r13;
        r40 = r18;
        r121 = r111;
        r122 = -1;
        if (r16 != 0) goto L91;
        r45 = ArrayDecoders.decodeVarint64(r44, r4, r9);
        r10.putLong(message, r110, r9.long1);
        goto L81
    L82:
        r39 = data;
        r23 = r13;
        r40 = r18;
        r121 = r111;
        r122 = -1;
        if (r16 != 5) goto L91;
        UnsafeUtil.putFloat(r14, r110, ArrayDecoders.decodeFloat(r39, r4));
        goto L85
    L86:
        r39 = data;
        r23 = r13;
        r40 = r18;
        r121 = r111;
        r122 = -1;
        if (r16 != 1) goto L91;
        UnsafeUtil.putDouble(r14, r110, ArrayDecoders.decodeDouble(r39, r4));
        r0 = r4 + 8;
        goto L89
    L23:
        r38 = r10.getInt(r14, r37);
        goto L24
    L25:
        r120 = r5;
        r22 = r6;
        goto L27
    L14:
        r23 = r13;
        r25 = r4;
        r27 = r11;
        r113 = r5;
        r22 = r6;
        r26 = r10;
        endDelimited = endDelimited;
        r24 = 0;
        goto L124
    L11:
        r17 = r15.positionForFieldNumber(r13);
        goto L12
    L7:
        r11 = r7;
        goto L8
    L134:
        int r210 = r6;
        r26 = r10;
        endDelimited = endDelimited;
        r115 = r15;
        r29 = r0;
        r27 = r3;
        r30 = r210;
        r28 = 1048575;
        goto L135
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T message, int pos) {
        Schema r0 = getMessageFieldSchema(pos);
        long r1 = offset(typeAndOffsetAt(pos));
        if (isFieldPresent(message, pos) == false) goto L5;
        Object r3 = UNSAFE.getObject(message, r1);
        if (isMutable(r3) == false) goto L9;
        return r3;
    L9:
        Object r4 = r0.newInstance();
        if (r3 == null) goto L12;
        r0.mergeFrom(r4, r3);
    L12:
        return r4;
    L5:
        return r0.newInstance();
    }

    private void storeMessageField(T message, int pos, Object field) {
        UNSAFE.putObject(message, offset(typeAndOffsetAt(pos)), field);
        setFieldPresent(message, pos);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T message, int fieldNumber, int pos) {
        Schema r0 = getMessageFieldSchema(pos);
        if (isOneofPresent(message, fieldNumber, pos) == false) goto L5;
        Object r3 = UNSAFE.getObject(message, offset(typeAndOffsetAt(pos)));
        if (isMutable(r3) == false) goto L9;
        return r3;
    L9:
        Object r4 = r0.newInstance();
        if (r3 == null) goto L12;
        r0.mergeFrom(r4, r3);
    L12:
        return r4;
    L5:
        return r0.newInstance();
    }

    private void storeOneofMessageField(T message, int fieldNumber, int pos, Object field) {
        UNSAFE.putObject(message, offset(typeAndOffsetAt(pos)), field);
        setOneofPresent(message, fieldNumber, pos);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T message, byte[] data, int position, int limit, ArrayDecoders.Registers registers) throws IOException {
        parseMessage(message, data, position, limit, 0, registers);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void makeImmutable(T message) {
        if (isMutable(message) == true) goto L6;
        return;
    L6:
        if ((message instanceof GeneratedMessageLite) == false) goto L8;
        GeneratedMessageLite r0 = (GeneratedMessageLite) message;
        r0.clearMemoizedSerializedSize();
        r0.clearMemoizedHashCode();
        r0.markImmutable();
    L8:
        int r1 = this.buffer.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L29;
        int r3 = typeAndOffsetAt(r2);
        long r4 = offset(r3);
        int r5 = type(r3);
        if (r5 == 9) goto L26;
        if (r5 == 60) goto L23;
        if (r5 == 68) goto L23;
        switch(r5) {
            case 17: goto L26;
            case 18: goto L21;
            case 19: goto L21;
            case 20: goto L21;
            case 21: goto L21;
            case 22: goto L21;
            case 23: goto L21;
            case 24: goto L21;
            case 25: goto L21;
            case 26: goto L21;
            case 27: goto L21;
            case 28: goto L21;
            case 29: goto L21;
            case 30: goto L21;
            case 31: goto L21;
            case 32: goto L21;
            case 33: goto L21;
            case 34: goto L21;
            case 35: goto L21;
            case 36: goto L21;
            case 37: goto L21;
            case 38: goto L21;
            case 39: goto L21;
            case 40: goto L21;
            case 41: goto L21;
            case 42: goto L21;
            case 43: goto L21;
            case 44: goto L21;
            case 45: goto L21;
            case 46: goto L21;
            case 47: goto L21;
            case 48: goto L21;
            case 49: goto L21;
            case 50: goto L18;
            default: goto L28;
        };
    L18:
        Unsafe r6 = UNSAFE;
        Object r7 = r6.getObject(message, r4);
        if (r7 == null) goto L28;
        r6.putObject(message, r4, this.mapFieldSchema.toImmutable(r7));
        goto L28
    L21:
        this.listFieldSchema.makeImmutableListAt(message, r4);
    L28:
        r2 = r2 + 3;
    L23:
        if (isOneofPresent(message, numberAt(r2), r2) == false) goto L28;
        getMessageFieldSchema(r2).makeImmutable(UNSAFE.getObject(message, r4));
    L26:
        if (isFieldPresent(message, r2) == false) goto L28;
        getMessageFieldSchema(r2).makeImmutable(UNSAFE.getObject(message, r4));
        goto L28
    L29:
        this.unknownFieldSchema.makeImmutable(message);
        if (this.hasExtensions == false) goto L42;
        this.extensionSchema.makeImmutable(message);
        return;
    }

    private final <K, V> void mergeMap(Object message, int pos, Object mapDefaultEntry, ExtensionRegistryLite extensionRegistry, Reader reader) throws IOException {
        long r0 = offset(typeAndOffsetAt(pos));
        Object r6 = UnsafeUtil.getObject(message, r0);
        if (r6 != null) goto L6;
        r6 = this.mapFieldSchema.newMapField(mapDefaultEntry);
        UnsafeUtil.putObject(message, r0, r6);
    L8:
        reader.readMap(this.mapFieldSchema.forMutableMapData(r6), this.mapFieldSchema.forMapMetadata(mapDefaultEntry), extensionRegistry);
        return;
    L6:
        if (this.mapFieldSchema.isImmutable(r6) == false) goto L8;
        Object r2 = this.mapFieldSchema.newMapField(mapDefaultEntry);
        this.mapFieldSchema.mergeFrom(r2, r6);
        UnsafeUtil.putObject(message, r0, r2);
        r6 = r2;
        goto L8
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object r9, int r10, UB r11, UnknownFieldSchema<UT, UB> r12, Object r13) {
        int r2 = numberAt(r10);
        Object r14 = UnsafeUtil.getObject(r9, offset(typeAndOffsetAt(r10)));
        if (r14 != null) goto L5;
        return r11;
    L5:
        Internal.EnumVerifier r4 = getEnumFieldVerifier(r10);
        if (r4 != null) goto L9;
        return r11;
    L9:
        return (UB) filterUnknownEnumMap(r10, r2, this.mapFieldSchema.forMutableMapData(r14), r4, r11, r12, r13);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int r4, int r5, Map<K, V> r6, Internal.EnumVerifier r7, UB r8, UnknownFieldSchema<UT, UB> r9, Object r10) {
        MapEntryLite.Metadata<?, ?> r3 = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(r4));
        Iterator<Map.Entry<K, V>> r11 = r6.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L15;
        Map.Entry<K, V> r12 = r11.next();
        if (r7.isInRange(((Integer) r12.getValue()).intValue()) == true) goto L4;
        if (r8 != null) goto L9;
        r8 = r9.getBuilderFromMessage(r10);
    L9:
        ByteString.CodedBuilder r0 = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(r3, r12.getKey(), r12.getValue()));
        CodedOutputStream r1 = r0.getCodedOutput();
        MapEntryLite.writeTo(r1, r3, r12.getKey(), r12.getValue());     // Catch: IOException -> L12
        UB r13 = r8;
        r9.addLengthDelimited(r13, r5, r0.build());
        r11.remove();
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    L15:
        return r8;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final boolean isInitialized(T message) {
        int r0 = 1048575;
        int r1 = 0;
        int r10 = 0;
    L4:
        if (r10 >= this.checkInitializedCount) goto L49;
        int r11 = this.intArray[r10];
        int r12 = numberAt(r11);
        int r13 = typeAndOffsetAt(r11);
        int r2 = this.buffer[r11 + 2];
        int r4 = r2 & 1048575;
        int r14 = 1 << (r2 >>> 20);
        if (r4 == r0) goto L10;
        if (r4 == 1048575) goto L9;
        r1 = UNSAFE.getInt(message, r4);
    L9:
        int r16 = r1;
        int r15 = r4;
    L12:
        if (isRequired(r13) == true) goto L14;
    L16:
        int r3 = type(r13);
        if (r3 == 9) goto L43;
        if (r3 == 17) goto L43;
        if (r3 == 27) goto L40;
        if (r3 == 60) goto L35;
        if (r3 == 68) goto L35;
        if (r3 == 49) goto L40;
        if (r3 != 50) goto L47;
        if (isMapInitialized(message, r13, r11) == true) goto L47;
        return false;
    L47:
        r10 = r10 + 1;
        r0 = r15;
        r1 = r16;
    L35:
        if (isOneofPresent(message, r12, r11) == false) goto L47;
        if (isInitialized(message, r13, getMessageFieldSchema(r11)) == true) goto L47;
        return false;
    L40:
        if (isListInitialized(message, r13, r11) == true) goto L47;
        return false;
    L43:
        if (isFieldPresent(message, r11, r15, r16, r14) == false) goto L47;
        if (isInitialized(message, r13, getMessageFieldSchema(r11)) == true) goto L47;
        return false;
    L14:
        if (isFieldPresent(message, r11, r15, r16, r14) == true) goto L16;
        return false;
    L10:
        r15 = r0;
        r16 = r1;
        goto L12
    L49:
        if (this.hasExtensions == true) goto L51;
    L53:
        return true;
    L51:
        if (this.extensionSchema.getExtensions(message).isInitialized() == true) goto L53;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object message, int typeAndOffset, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(message, offset(typeAndOffset)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object message, int typeAndOffset, int pos) {
        List r3 = (List) UnsafeUtil.getObject(message, offset(typeAndOffset));
        if (r3.isEmpty() == false) goto L5;
        return true;
    L5:
        Schema r2 = getMessageFieldSchema(pos);
        int r5 = 0;
    L7:
        if (r5 >= r3.size()) goto L12;
        if (r2.isInitialized(r3.get(r5)) == false) goto L10;
        r5 = r5 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.crypto.tink.shaded.protobuf.Schema] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    private boolean isMapInitialized(T r4, int r5, int r6) {
        Map<?, ?> r7 = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(r4, offset(r5)));
        if (r7.isEmpty() == false) goto L5;
        return true;
    L5:
        Object r8 = getMapFieldDefaultEntry(r6);
        if (this.mapFieldSchema.forMapMetadata(r8).valueType.getJavaType() == WireFormat.JavaType.MESSAGE) goto L8;
        return true;
    L8:
        Iterator<?> r3 = r7.values().iterator();
        ?? r9 = 0;
    L10:
        if (r3.hasNext() == false) goto L18;
        Object r10 = r3.next();
        r9 = r9;
        if (r9 != 0) goto L15;
        r9 = Protobuf.getInstance().schemaFor(r10.getClass());
    L15:
        if (r9.isInitialized(r10) == true) goto L10;
        return false;
    L18:
        return true;
    }

    private void writeString(int fieldNumber, Object value, Writer writer) throws IOException {
        if ((value instanceof String) == false) goto L5;
        writer.writeString(fieldNumber, (String) value);
        return;
    L5:
        writer.writeBytes(fieldNumber, (ByteString) value);
    }

    private void readString(Object message, int typeAndOffset, Reader reader) throws IOException {
        if (isEnforceUtf8(typeAndOffset) == false) goto L6;
        UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readStringRequireUtf8());
        return;
    L6:
        if (this.lite == false) goto L8;
        UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readString());
        return;
    L8:
        UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readBytes());
    }

    private void readStringList(Object message, int typeAndOffset, Reader reader) throws IOException {
        if (isEnforceUtf8(typeAndOffset) == false) goto L5;
        reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(message, offset(typeAndOffset)));
        return;
    L5:
        reader.readStringList(this.listFieldSchema.mutableListAt(message, offset(typeAndOffset)));
    }

    private <E> void readMessageList(Object message, int typeAndOffset, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        long r0 = offset(typeAndOffset);
        reader.readMessageList(this.listFieldSchema.mutableListAt(message, r0), schema, extensionRegistry);
    }

    private <E> void readGroupList(Object message, long offset, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(message, offset), schema, extensionRegistry);
    }

    private int numberAt(int pos) {
        return this.buffer[pos];
    }

    private int typeAndOffsetAt(int pos) {
        return this.buffer[pos + 1];
    }

    private int presenceMaskAndOffsetAt(int pos) {
        return this.buffer[pos + 2];
    }

    private static boolean isMutable(Object message) {
        if (message != null) goto L6;
        return false;
    L6:
        if ((message instanceof GeneratedMessageLite) == true) goto L8;
        return true;
    L8:
        return ((GeneratedMessageLite) message).isMutable();
    }

    private static void checkMutable(Object message) {
        if (isMutable(message) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Mutating immutable message: " + message);
    }

    private static <T> double doubleAt(T message, long offset) {
        return UnsafeUtil.getDouble(message, offset);
    }

    private static <T> float floatAt(T message, long offset) {
        return UnsafeUtil.getFloat(message, offset);
    }

    private static <T> int intAt(T message, long offset) {
        return UnsafeUtil.getInt(message, offset);
    }

    private static <T> long longAt(T message, long offset) {
        return UnsafeUtil.getLong(message, offset);
    }

    private static <T> boolean booleanAt(T message, long offset) {
        return UnsafeUtil.getBoolean(message, offset);
    }

    private static <T> double oneofDoubleAt(T message, long offset) {
        return ((Double) UnsafeUtil.getObject(message, offset)).doubleValue();
    }

    private static <T> float oneofFloatAt(T message, long offset) {
        return ((Float) UnsafeUtil.getObject(message, offset)).floatValue();
    }

    private static <T> int oneofIntAt(T message, long offset) {
        return ((Integer) UnsafeUtil.getObject(message, offset)).intValue();
    }

    private static <T> long oneofLongAt(T message, long offset) {
        return ((Long) UnsafeUtil.getObject(message, offset)).longValue();
    }

    private static <T> boolean oneofBooleanAt(T message, long offset) {
        return ((Boolean) UnsafeUtil.getObject(message, offset)).booleanValue();
    }

    private boolean arePresentForEquals(T message, T other, int pos) {
        if (isFieldPresent(message, pos) != isFieldPresent(other, pos)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isFieldPresent(T message, int pos, int presenceFieldOffset, int presenceField, int presenceMask) {
        if (presenceFieldOffset != 1048575) goto L7;
        return isFieldPresent(message, pos);
    L7:
        if ((presenceField & presenceMask) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean isFieldPresent(T message, int pos) {
        int r0 = presenceMaskAndOffsetAt(pos);
        long r1 = 1048575 & r0;
        if (r1 != 1048575) goto L83;
        int r6 = typeAndOffsetAt(pos);
        long r2 = offset(r6);
        switch(type(r6)) {
            case 0: goto L79;
            case 1: goto L75;
            case 2: goto L71;
            case 3: goto L67;
            case 4: goto L63;
            case 5: goto L59;
            case 6: goto L55;
            case 7: goto L53;
            case 8: goto L42;
            case 9: goto L39;
            case 10: goto L37;
            case 11: goto L33;
            case 12: goto L29;
            case 13: goto L25;
            case 14: goto L21;
            case 15: goto L17;
            case 16: goto L13;
            case 17: goto L9;
            default: goto L7;
        };
    L42:
        Object r7 = UnsafeUtil.getObject(message, r2);
        if ((r7 instanceof String) == false) goto L47;
        return !((String) r7).isEmpty();
    L47:
        if ((r7 instanceof ByteString) == false) goto L51;
        return !ByteString.EMPTY.equals(r7);
    L51:
        throw new IllegalArgumentException();
    L7:
        throw new IllegalArgumentException();
    L9:
        if (UnsafeUtil.getObject(message, r2) != null) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (UnsafeUtil.getLong(message, r2) != 0) goto L15;
        return false;
    L15:
        return true;
    L17:
        if (UnsafeUtil.getInt(message, r2) != 0) goto L19;
        return false;
    L19:
        return true;
    L21:
        if (UnsafeUtil.getLong(message, r2) != 0) goto L23;
        return false;
    L23:
        return true;
    L25:
        if (UnsafeUtil.getInt(message, r2) != 0) goto L27;
        return false;
    L27:
        return true;
    L29:
        if (UnsafeUtil.getInt(message, r2) != 0) goto L31;
        return false;
    L31:
        return true;
    L33:
        if (UnsafeUtil.getInt(message, r2) != 0) goto L35;
        return false;
    L35:
        return true;
    L37:
        return !ByteString.EMPTY.equals(UnsafeUtil.getObject(message, r2));
    L39:
        if (UnsafeUtil.getObject(message, r2) != null) goto L41;
        return false;
    L41:
        return true;
    L53:
        return UnsafeUtil.getBoolean(message, r2);
    L55:
        if (UnsafeUtil.getInt(message, r2) != 0) goto L57;
        return false;
    L57:
        return true;
    L59:
        if (UnsafeUtil.getLong(message, r2) != 0) goto L61;
        return false;
    L61:
        return true;
    L63:
        if (UnsafeUtil.getInt(message, r2) != 0) goto L65;
        return false;
    L65:
        return true;
    L67:
        if (UnsafeUtil.getLong(message, r2) != 0) goto L69;
        return false;
    L69:
        return true;
    L71:
        if (UnsafeUtil.getLong(message, r2) != 0) goto L73;
        return false;
    L73:
        return true;
    L75:
        if (Float.floatToRawIntBits(UnsafeUtil.getFloat(message, r2)) != 0) goto L77;
        return false;
    L77:
        return true;
    L79:
        if (Double.doubleToRawLongBits(UnsafeUtil.getDouble(message, r2)) != 0) goto L81;
        return false;
    L81:
        return true;
    L83:
        if (((1 << (r0 >>> 20)) & UnsafeUtil.getInt(message, r1)) != 0) goto L85;
        return false;
    L85:
        return true;
    }

    private void setFieldPresent(T message, int pos) {
        int r4 = presenceMaskAndOffsetAt(pos);
        long r0 = 1048575 & r4;
        if (r0 != 1048575) goto L5;
        return;
    L5:
        UnsafeUtil.putInt(message, r0, (1 << (r4 >>> 20)) | UnsafeUtil.getInt(message, r0));
    }

    private boolean isOneofPresent(T message, int fieldNumber, int pos) {
        if (UnsafeUtil.getInt(message, presenceMaskAndOffsetAt(pos) & 1048575) != fieldNumber) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isOneofCaseEqual(T message, T other, int pos) {
        long r0 = presenceMaskAndOffsetAt(pos) & 1048575;
        if (UnsafeUtil.getInt(message, r0) != UnsafeUtil.getInt(other, r0)) goto L5;
        return true;
    L5:
        return false;
    }

    private void setOneofPresent(T message, int fieldNumber, int pos) {
        UnsafeUtil.putInt(message, presenceMaskAndOffsetAt(pos) & 1048575, fieldNumber);
    }

    private int positionForFieldNumber(final int number) {
        if (number >= this.minFieldNumber) goto L5;
        return -1;
    L5:
        if (number <= this.maxFieldNumber) goto L7;
        return -1;
    L7:
        return slowPositionForFieldNumber(number, 0);
    }

    private int positionForFieldNumber(final int number, final int min) {
        if (number >= this.minFieldNumber) goto L5;
        return -1;
    L5:
        if (number <= this.maxFieldNumber) goto L7;
        return -1;
    L7:
        return slowPositionForFieldNumber(number, min);
    }

    private int slowPositionForFieldNumber(final int number, int min) {
        int r0 = (this.buffer.length / 3) - 1;
    L3:
        if (min > r0) goto L10;
        int r1 = (r0 + min) >>> 1;
        int r2 = r1 * 3;
        int r3 = numberAt(r2);
        if (number == r3) goto L6;
        if (number < r3) goto L8;
        min = r1 + 1;
        goto L3
    L8:
        r0 = r1 - 1;
        goto L3
    L6:
        return r2;
    L10:
        return -1;
    }

    int getSchemaSize() {
        return this.buffer.length * 3;
    }
}
