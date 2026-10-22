package com.android.apksig.internal.asn1.ber;

import com.android.apksig.internal.asn1.Asn1TagClass;
import com.android.apksig.internal.asn1.Asn1Type;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public abstract class BerEncoding {
    public static final int ID_FLAG_CONSTRUCTED_ENCODING = 32;
    public static final int TAG_CLASS_APPLICATION = 1;
    public static final int TAG_CLASS_CONTEXT_SPECIFIC = 2;
    public static final int TAG_CLASS_PRIVATE = 3;
    public static final int TAG_CLASS_UNIVERSAL = 0;
    public static final int TAG_NUMBER_BIT_STRING = 3;
    public static final int TAG_NUMBER_BOOLEAN = 1;
    public static final int TAG_NUMBER_GENERALIZED_TIME = 24;
    public static final int TAG_NUMBER_INTEGER = 2;
    public static final int TAG_NUMBER_NULL = 5;
    public static final int TAG_NUMBER_OBJECT_IDENTIFIER = 6;
    public static final int TAG_NUMBER_OCTET_STRING = 4;
    public static final int TAG_NUMBER_SEQUENCE = 16;
    public static final int TAG_NUMBER_SET = 17;
    public static final int TAG_NUMBER_UTC_TIME = 23;

    /* JADX INFO: renamed from: com.android.apksig.internal.asn1.ber.BerEncoding$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$apksig$internal$asn1$Asn1TagClass = null;
        static final /* synthetic */ int[] $SwitchMap$com$android$apksig$internal$asn1$Asn1Type = null;

        static {
            int[] r0 = new int[Asn1TagClass.values().length];
            $SwitchMap$com$android$apksig$internal$asn1$Asn1TagClass = r0;
            r0[Asn1TagClass.APPLICATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L48:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1TagClass[Asn1TagClass.CONTEXT_SPECIFIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L42:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1TagClass[Asn1TagClass.PRIVATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L46:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1TagClass[Asn1TagClass.UNIVERSAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L10:
            int[] r4 = new int[Asn1Type.values().length];
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type = r4;
            r4[Asn1Type.INTEGER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L38:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.OBJECT_IDENTIFIER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.OCTET_STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L60:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.BIT_STRING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L36:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.SET_OF.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
        L50:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.SEQUENCE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L31
        L62:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.SEQUENCE_OF.ordinal()] = 7;     // Catch: NoSuchFieldError -> L32
        L40:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.UTC_TIME.ordinal()] = 8;     // Catch: NoSuchFieldError -> L33
        L54:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.GENERALIZED_TIME.ordinal()] = 9;     // Catch: NoSuchFieldError -> L34
        L58:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.BOOLEAN.ordinal()] = 10;     // Catch: NoSuchFieldError -> L35
            return;
        }
    }

    private BerEncoding() {
    }

    public static int getTagClass(byte r0) {
        return (r0 & UByte.MAX_VALUE) >> 6;
    }

    public static int getTagNumber(byte r0) {
        return r0 & 31;
    }

    public static boolean isConstructed(byte r0) {
        if ((r0 & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static byte setTagClass(byte r0, int r1) {
        return (byte) ((r0 & 63) | (r1 << 6));
    }

    public static byte setTagNumber(byte r0, int r1) {
        return (byte) ((r0 & (-32)) | r1);
    }

    public static String tagClassAndNumberToString(int r1, int r2) {
        String r3 = tagClassToString(r1);
        String r4 = tagNumberToString(r2);
        if (r3.isEmpty() == false) goto L6;
        return r4;
    L6:
        return r3 + " " + r4;
    }

    public static String tagClassToString(int r3) {
        if (r3 != 0) goto L4;
        return "UNIVERSAL";
    L4:
        if (r3 != 1) goto L6;
        return "APPLICATION";
    L6:
        if (r3 != 2) goto L8;
        return "";
    L8:
        if (r3 != 3) goto L12;
        return "PRIVATE";
    L12:
        throw new IllegalArgumentException("Unsupported type class: " + r3);
    }

    public static String tagNumberToString(int r2) {
        if (r2 != 16) goto L5;
        return "SEQUENCE";
    L5:
        if (r2 != 17) goto L7;
        return "SET";
    L7:
        if (r2 != 23) goto L9;
        return "UTC TIME";
    L9:
        if (r2 == 24) goto L25;
        switch(r2) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            default: goto L12;
        };
    L13:
        return "OBJECT IDENTIFIER";
    L15:
        return "NULL";
    L17:
        return "OCTET STRING";
    L19:
        return "BIT STRING";
    L21:
        return "INTEGER";
    L23:
        return "BOOLEAN";
    L12:
        return "0x" + Integer.toHexString(r2);
    L25:
        return "GENERALIZED TIME";
    }

    public static int getTagClass(Asn1TagClass r3) {
        int r0 = AnonymousClass1.$SwitchMap$com$android$apksig$internal$asn1$Asn1TagClass[r3.ordinal()];
        int r1 = 1;
        if (r0 == 1) goto L14;
        r1 = 2;
        if (r0 == 2) goto L14;
        r1 = 3;
        if (r0 == 3) goto L14;
        if (r0 != 4) goto L13;
        return 0;
    L13:
        throw new IllegalArgumentException("Unsupported tag class: " + r3);
    L14:
        return r1;
    }

    public static int getTagNumber(Asn1Type r3) {
        switch(AnonymousClass1.$SwitchMap$com$android$apksig$internal$asn1$Asn1Type[r3.ordinal()]) {
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L10;
            case 9: goto L8;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        return 1;
    L8:
        return 24;
    L10:
        return 23;
    L12:
        return 16;
    L14:
        return 17;
    L16:
        return 3;
    L18:
        return 4;
    L20:
        return 6;
    L22:
        return 2;
    L5:
        throw new IllegalArgumentException("Unsupported data type: " + r3);
    }
}
