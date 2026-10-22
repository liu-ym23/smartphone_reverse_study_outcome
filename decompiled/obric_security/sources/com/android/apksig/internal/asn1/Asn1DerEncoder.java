package com.android.apksig.internal.asn1;

import com.android.apksig.internal.asn1.ber.BerEncoding;
import com.bytedance.librarian.LibrarianImpl;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class Asn1DerEncoder {
    public static final Asn1OpaqueObject ASN1_DER_NULL = null;

    /* JADX INFO: renamed from: com.android.apksig.internal.asn1.Asn1DerEncoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$apksig$internal$asn1$Asn1Tagging = null;
        static final /* synthetic */ int[] $SwitchMap$com$android$apksig$internal$asn1$Asn1Type = null;

        static {
            int[] r0 = new int[Asn1Tagging.values().length];
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Tagging = r0;
            r0[Asn1Tagging.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L53:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Tagging[Asn1Tagging.EXPLICIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L41:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Tagging[Asn1Tagging.IMPLICIT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L8:
            int[] r3 = new int[Asn1Type.values().length];
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type = r3;
            r3[Asn1Type.CHOICE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L65:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.SEQUENCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L37:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.UNENCODED_CONTAINER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L55:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.OCTET_STRING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L63:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.BIT_STRING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L39:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.INTEGER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L57:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.BOOLEAN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L61:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.UTC_TIME.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L47:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.GENERALIZED_TIME.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
        L51:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.OBJECT_IDENTIFIER.ordinal()] = 10;     // Catch: NoSuchFieldError -> L34
        L43:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.SET_OF.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L45:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.SEQUENCE_OF.ordinal()] = 12;     // Catch: NoSuchFieldError -> L36
            return;
        }
    }

    private static final class AnnotatedField {
        private final Asn1Field mAnnotation;
        private final Asn1Type mDataType;
        private final int mDerTagClass;
        private final int mDerTagNumber;
        private final Asn1Type mElementDataType;
        private final Field mField;
        private final Object mObject;
        private final boolean mOptional;
        private final Asn1TagClass mTagClass;
        private final Asn1Tagging mTagging;

        public AnnotatedField(Object r3, Field r4, Asn1Field r5) throws Asn1EncodingException {
            this.mObject = r3;
            this.mField = r4;
            this.mAnnotation = r5;
            Asn1Type r6 = r5.type();
            this.mDataType = r6;
            this.mElementDataType = r5.elementType();
            Asn1TagClass r7 = r5.cls();
            if (r7 == Asn1TagClass.AUTOMATIC) goto L5;
        L8:
            this.mTagClass = r7;
            this.mDerTagClass = BerEncoding.getTagClass(r7);
            if (r5.tagNumber() == (-1)) goto L12;
            int r8 = r5.tagNumber();
        L18:
            this.mDerTagNumber = r8;
            Asn1Tagging r9 = r5.tagging();
            this.mTagging = r9;
            if (r9 == Asn1Tagging.EXPLICIT) goto L23;
            if (r9 == Asn1Tagging.IMPLICIT) goto L23;
        L24:
            this.mOptional = r5.optional();
            return;
        L23:
            if (r5.tagNumber() != (-1)) goto L24;
            throw new Asn1EncodingException("Tag number must be specified when tagging mode is " + r9);
        L12:
            if (r6 != Asn1Type.CHOICE) goto L14;
        L17:
            r8 = -1;
            goto L18
        L14:
            if (r6 == Asn1Type.ANY) goto L17;
            r8 = BerEncoding.getTagNumber(r6);
            goto L18
        L5:
            if (r5.tagNumber() == (-1)) goto L7;
            r7 = Asn1TagClass.CONTEXT_SPECIFIC;
            goto L8
        L7:
            r7 = Asn1TagClass.UNIVERSAL;
            goto L8
        }

        public Asn1Field getAnnotation() {
            return this.mAnnotation;
        }

        public Field getField() {
            return this.mField;
        }

        public byte[] toDer() throws Asn1EncodingException {
            Object r0 = Asn1DerEncoder.access$100(this.mObject, this.mField);
            if (r0 == null) goto L5;
            byte[] r1 = JavaToDerConverter.toDer(r0, this.mDataType, this.mElementDataType);
            int r2 = AnonymousClass1.$SwitchMap$com$android$apksig$internal$asn1$Asn1Tagging[this.mTagging.ordinal()];
            if (r2 != 1) goto L13;
            return r1;
        L13:
            if (r2 == 2) goto L29;
            if (r2 != 3) goto L27;
            if (BerEncoding.getTagNumber(r1[0]) == 31) goto L25;
            int r3 = this.mDerTagNumber;
            if (r3 >= 31) goto L23;
            byte r4 = BerEncoding.setTagNumber(r1[0], r3);
            r1[0] = r4;
            r1[0] = BerEncoding.setTagClass(r4, this.mDerTagClass);
            return r1;
        L23:
            throw new Asn1EncodingException("Unsupported high tag number: " + this.mDerTagNumber);
        L25:
            throw new Asn1EncodingException("High-tag-number form not supported");
        L27:
            throw new RuntimeException("Unknown tagging mode: " + this.mTagging);
        L29:
            return Asn1DerEncoder.access$200(this.mDerTagClass, true, this.mDerTagNumber, new byte[][]{r1});
        L5:
            if (this.mOptional == false) goto L9;
            return null;
        L9:
            throw new Asn1EncodingException("Required field not set");
        }
    }

    private static class ByteArrayLexicographicComparator implements Comparator<byte[]> {
        private static final ByteArrayLexicographicComparator INSTANCE = null;

        static {
            INSTANCE = new ByteArrayLexicographicComparator();
        }

        private ByteArrayLexicographicComparator() {
        }

        static /* synthetic */ ByteArrayLexicographicComparator access$000() {
            return INSTANCE;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(byte[] r1, byte[] r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(byte[] r4, byte[] r5) {
            int r3 = Math.min(r4.length, r5.length);
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L9;
            int r1 = (r4[r0] & UByte.MAX_VALUE) - (r5[r0] & UByte.MAX_VALUE);
            if (r1 != 0) goto L6;
            r0 = r0 + 1;
            goto L3
        L6:
            return r1;
        L9:
            return r4.length - r5.length;
        }
    }

    private static final class JavaToDerConverter {
        private JavaToDerConverter() {
        }

        public static byte[] toDer(Object r4, Asn1Type r5, Asn1Type r6) throws Asn1EncodingException {
            Class<?> r0 = r4.getClass();
            if (Asn1OpaqueObject.class.equals(r0) == false) goto L6;
            ByteBuffer r7 = ((Asn1OpaqueObject) r4).getEncoded();
            byte[] r8 = new byte[r7.remaining()];
            r7.get(r8);
            return r8;
        L6:
            if (r5 == null) goto L66;
            if (r5 == Asn1Type.ANY) goto L66;
            switch(AnonymousClass1.$SwitchMap$com$android$apksig$internal$asn1$Asn1Type[r5.ordinal()]) {
                case 1: goto L57;
                case 2: goto L51;
                case 3: goto L64;
                case 4: goto L42;
                case 5: goto L42;
                case 6: goto L30;
                case 7: goto L26;
                case 8: goto L22;
                case 9: goto L22;
                case 10: goto L18;
                case 11: goto L16;
                case 12: goto L14;
                default: goto L64;
            };
        L51:
            Asn1Class r9 = (Asn1Class) r0.getDeclaredAnnotation(Asn1Class.class);
            if (r9 == null) goto L64;
            if (r9.type() != Asn1Type.SEQUENCE) goto L64;
            return Asn1DerEncoder.access$800(r4);
        L57:
            Asn1Class r10 = (Asn1Class) r0.getDeclaredAnnotation(Asn1Class.class);
            if (r10 == null) goto L64;
            if (r10.type() != Asn1Type.CHOICE) goto L64;
            return Asn1DerEncoder.access$900(r4);
        L14:
            return Asn1DerEncoder.access$1100((Collection) r4, r6);
        L16:
            return Asn1DerEncoder.access$1000((Collection) r4, r6);
        L18:
            if ((r4 instanceof String) == false) goto L64;
            return Asn1DerEncoder.access$700((String) r4);
        L22:
            if ((r4 instanceof String) == false) goto L64;
            return Asn1DerEncoder.access$200(0, false, BerEncoding.getTagNumber(r5), new byte[][]{((String) r4).getBytes()});
        L26:
            if ((r4 instanceof Boolean) == false) goto L64;
            return Asn1DerEncoder.access$600(((Boolean) r4).booleanValue());
        L30:
            if ((r4 instanceof Integer) == false) goto L34;
            return Asn1DerEncoder.access$300(((Integer) r4).intValue());
        L34:
            if ((r4 instanceof Long) == false) goto L38;
            return Asn1DerEncoder.access$400(((Long) r4).longValue());
        L38:
            if ((r4 instanceof BigInteger) == false) goto L64;
            return Asn1DerEncoder.access$500((BigInteger) r4);
        L42:
            if ((r4 instanceof ByteBuffer) == false) goto L45;
            ByteBuffer r11 = (ByteBuffer) r4;
            byte[] r12 = new byte[r11.remaining()];
            r11.slice().get(r12);
        L48:
            if (r12 == null) goto L64;
            return Asn1DerEncoder.access$200(0, false, BerEncoding.getTagNumber(r5), new byte[][]{r12});
        L45:
            if ((r4 instanceof byte[]) == false) goto L47;
            r12 = (byte[]) r4;
            goto L48
        L47:
            r12 = null;
        L64:
            throw new Asn1EncodingException("Unsupported conversion: " + r0.getName() + " to ASN.1 " + r5);
        L66:
            return Asn1DerEncoder.encode(r4);
        }
    }

    static {
        ASN1_DER_NULL = new Asn1OpaqueObject(new byte[]{5, 0});
    }

    private Asn1DerEncoder() {
    }

    static /* synthetic */ Object access$100(Object r0, Field r1) throws Asn1EncodingException {
        return getMemberFieldValue(r0, r1);
    }

    static /* synthetic */ byte[] access$1000(Collection r0, Asn1Type r1) throws Asn1EncodingException {
        return toSetOf(r0, r1);
    }

    static /* synthetic */ byte[] access$1100(Collection r0, Asn1Type r1) throws Asn1EncodingException {
        return toSequenceOf(r0, r1);
    }

    static /* synthetic */ byte[] access$200(int r0, boolean r1, int r2, byte[][] r3) {
        return createTag(r0, r1, r2, r3);
    }

    static /* synthetic */ byte[] access$300(int r0) {
        return toInteger(r0);
    }

    static /* synthetic */ byte[] access$400(long r0) {
        return toInteger(r0);
    }

    static /* synthetic */ byte[] access$500(BigInteger r0) {
        return toInteger(r0);
    }

    static /* synthetic */ byte[] access$600(boolean r0) {
        return toBoolean(r0);
    }

    static /* synthetic */ byte[] access$700(String r0) throws Asn1EncodingException {
        return toOid(r0);
    }

    static /* synthetic */ byte[] access$800(Object r0) throws Asn1EncodingException {
        return toSequence(r0);
    }

    static /* synthetic */ byte[] access$900(Object r0) throws Asn1EncodingException {
        return toChoice(r0);
    }

    private static byte[] createTag(int r10, boolean r11, int r12, byte[]... r13) {
        if (r12 >= 31) goto L30;
        int r0 = 6;
        int r14 = r10 << 6;
        if (r11 == false) goto L7;
        int r15 = 32;
    L8:
        byte r16 = (byte) ((r14 | r15) | r12);
        int r17 = r13.length;
        int r18 = 0;
        int r2 = 0;
    L9:
        if (r18 >= r17) goto L11;
        r2 = r2 + r13[r18].length;
        r18 = r18 + 1;
        goto L9
    L11:
        int r19 = 2;
        if (r2 >= 128) goto L15;
        byte[] r110 = new byte[r2 + 2];
        r110[0] = r16;
        r110[1] = (byte) r2;
    L25:
        int r111 = r13.length;
        int r1 = 0;
    L26:
        if (r1 >= r111) goto L28;
        byte[] r3 = r13[r1];
        System.arraycopy(r3, 0, r110, r19, r3.length);
        r19 = r19 + r3.length;
        r1 = r1 + 1;
        goto L26
    L28:
        return r110;
    L15:
        if (r2 > 255) goto L18;
        byte[] r4 = new byte[r2 + 3];
        r4[1] = -127;
        r4[2] = (byte) r2;
        r0 = 3;
        r110 = r4;
    L24:
        r110[0] = r16;
        r19 = r0;
        goto L25
    L18:
        if (r2 > 65535) goto L21;
        byte[] r5 = new byte[r2 + 4];
        r5[1] = -126;
        r5[2] = (byte) (r2 >> 8);
        r5[3] = (byte) (r2 & 255);
        r110 = r5;
        r0 = 4;
        goto L24
    L21:
        if (r2 > 16777215) goto L23;
        byte[] r6 = new byte[r2 + 5];
        r6[1] = -125;
        r6[2] = (byte) (r2 >> 16);
        r6[3] = (byte) ((r2 >> 8) & 255);
        r6[4] = (byte) (r2 & 255);
        r110 = r6;
        r0 = 5;
        goto L24
    L23:
        byte[] r7 = new byte[r2 + 6];
        r7[1] = -124;
        r7[2] = (byte) (r2 >> 24);
        r7[3] = (byte) ((r2 >> 16) & 255);
        r7[4] = (byte) ((r2 >> 8) & 255);
        r7[5] = (byte) (r2 & 255);
        r110 = r7;
        goto L24
    L7:
        r15 = 0;
        goto L8
    L30:
        throw new IllegalArgumentException("High tag numbers not supported: " + r12);
    }

    public static byte[] encode(Object r4) throws Asn1EncodingException {
        Class<?> r0 = r4.getClass();
        Asn1Class r1 = (Asn1Class) r0.getDeclaredAnnotation(Asn1Class.class);
        if (r1 == null) goto L19;
        Asn1Type r2 = r1.type();
        int r3 = AnonymousClass1.$SwitchMap$com$android$apksig$internal$asn1$Asn1Type[r2.ordinal()];
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L15;
        if (r3 != 3) goto L13;
        return toSequence(r4, true);
    L13:
        throw new Asn1EncodingException("Unsupported container type: " + r2);
    L15:
        return toSequence(r4);
    L17:
        return toChoice(r4);
    L19:
        throw new Asn1EncodingException(r0.getName() + " not annotated with " + Asn1Class.class.getName());
    }

    private static List<AnnotatedField> getAnnotatedFields(Object r9) throws Asn1EncodingException {
        Class<?> r0 = r9.getClass();
        Field[] r1 = r0.getDeclaredFields();
        ArrayList r2 = new ArrayList(r1.length);
        int r3 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L17;
        Field r5 = r1[r4];
        Asn1Field r6 = (Asn1Field) r5.getDeclaredAnnotation(Asn1Field.class);
        if (r6 == null) goto L11;
        if (Modifier.isStatic(r5.getModifiers()) == true) goto L16;
        r2.add(new AnnotatedField(r9, r5, r6));
    L12:
        e = move-exception;
        throw new Asn1EncodingException("Invalid ASN.1 annotation on " + r0.getName() + LibrarianImpl.Constants.DOT + r5.getName(), e);
    L16:
        throw new Asn1EncodingException(Asn1Field.class.getName() + " used on a static field: " + r0.getName() + LibrarianImpl.Constants.DOT + r5.getName());
    L11:
        r4 = r4 + 1;
        goto L3
    L17:
        return r2;
    }

    private static Object getMemberFieldValue(Object r4, Field r5) throws Asn1EncodingException {
        return r5.get(r4);
    L4:
        e = move-exception;
        throw new Asn1EncodingException("Failed to read " + r4.getClass().getName() + LibrarianImpl.Constants.DOT + r5.getName(), e);
    }

    static /* synthetic */ int lambda$toSequence$0(AnnotatedField r0, AnnotatedField r1) {
        return r0.getAnnotation().index() - r1.getAnnotation().index();
    }

    private static byte[] toChoice(Object r5) throws Asn1EncodingException {
        Class<?> r0 = r5.getClass();
        List<AnnotatedField> r1 = getAnnotatedFields(r5);
        if (r1.isEmpty() == true) goto L19;
        Iterator<AnnotatedField> r2 = r1.iterator();
        AnnotatedField r3 = null;
    L6:
        if (r2.hasNext() == false) goto L13;
        AnnotatedField r4 = r2.next();
        if (getMemberFieldValue(r5, r4.getField()) == null) goto L6;
        if (r3 != null) goto L12;
        r3 = r4;
        goto L6
    L12:
        throw new Asn1EncodingException("Multiple non-null fields in CHOICE class " + r0.getName() + ": " + r3.getField().getName() + ", " + r4.getField().getName());
    L13:
        if (r3 == null) goto L17;
        return r3.toDer();
    L17:
        throw new Asn1EncodingException("No non-null fields in CHOICE class " + r0.getName());
    L19:
        throw new Asn1EncodingException("No fields annotated with " + Asn1Field.class.getName() + " in CHOICE class " + r0.getName());
    }

    private static byte[] toInteger(int r2) {
        return toInteger(r2);
    }

    private static byte[] toOid(String r10) throws Asn1EncodingException {
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        String[] r2 = r10.split("\\.");
        int r4 = 2;
        if (r2.length < 2) goto L51;
        int r3 = Integer.parseInt(r2[0]);     // Catch: NumberFormatException -> L48
        if (r3 > 6) goto L47;
        if (r3 < 0) goto L47;
        int r7 = Integer.parseInt(r2[1]);     // Catch: NumberFormatException -> L44
        if (r7 >= 40) goto L43;
        if (r7 < 0) goto L43;
        int r8 = (r3 * 40) + r7;
        if (r8 > 255) goto L41;
        r1.write(r8);
    L18:
        if (r4 >= r2.length) goto L39;
        String r5 = r2[r4];
        int r6 = Integer.parseInt(r5);     // Catch: NumberFormatException -> L36
        if (r6 < 0) goto L35;
        if (r6 > 127) goto L26;
        r1.write(r6);
    L31:
        r4 = r4 + 1;
        goto L18
    L26:
        if (r6 >= 16384) goto L29;
        r1.write((r6 >> 7) | 128);
        r1.write(r6 & 127);
        goto L31
    L29:
        if (r6 >= 2097152) goto L33;
        r1.write((r6 >> 14) | 128);
        r1.write((127 & (r6 >> 7)) | 128);
        r1.write(r6 & 127);
        goto L31
    L33:
        throw new Asn1EncodingException("Node #" + (r4 + 1) + " too large: " + r6);
    L35:
        throw new Asn1EncodingException("Invalid value for node #" + (r4 + 1) + ": " + r6);
    L37:
        throw new Asn1EncodingException("Node #" + (r4 + 1) + " not numeric: " + r5);
    L39:
        return createTag(0, false, 6, new byte[][]{r1.toByteArray()});
    L41:
        throw new Asn1EncodingException("First two nodes out of range: " + r3 + LibrarianImpl.Constants.DOT + r7);
    L43:
        throw new Asn1EncodingException("Invalid value for node #2: " + r7);
    L45:
        throw new Asn1EncodingException("Node #2 not numeric: " + r2[1]);
    L47:
        throw new Asn1EncodingException("Invalid value for node #1: " + r3);
    L49:
        throw new Asn1EncodingException("Node #1 not numeric: " + r2[0]);
    L51:
        throw new Asn1EncodingException("OBJECT IDENTIFIER must contain at least two nodes: " + r10);
    }

    private static byte[] toSequence(Object r1) throws Asn1EncodingException {
        return toSequence(r1, false);
    }

    private static byte[] toSequenceOf(Collection<?> r1, Asn1Type r2) throws Asn1EncodingException {
        return toSequenceOrSetOf(r1, r2, false);
    }

    private static byte[] toSequenceOrSetOf(Collection<?> r3, Asn1Type r4, boolean r5) throws Asn1EncodingException {
        ArrayList r0 = new ArrayList(r3.size());
        Iterator<?> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        r0.add(JavaToDerConverter.toDer(r6.next(), r4, null));
        goto L4
    L7:
        if (r5 == true) goto L9;
        int r7 = 16;
    L14:
        return createTag(0, true, r7, (byte[][]) r0.toArray(new byte[0][]));
    L9:
        if (r0.size() <= 1) goto L11;
        Collections.sort(r0, ByteArrayLexicographicComparator.access$000());
    L11:
        r7 = 17;
        goto L14
    }

    private static byte[] toSetOf(Collection<?> r1, Asn1Type r2) throws Asn1EncodingException {
        return toSequenceOrSetOf(r1, r2, true);
    }

    private static byte[] toInteger(long r0) {
        return toInteger(BigInteger.valueOf(r0));
    }

    private static byte[] toSequence(Object r8, boolean r9) throws Asn1EncodingException {
        Class<?> r0 = r8.getClass();
        List<AnnotatedField> r10 = getAnnotatedFields(r8);
        Collections.sort(r10, new Asn1DerEncoder$$ExternalSyntheticLambda0());
        if (r10.size() <= 1) goto L15;
        Iterator<AnnotatedField> r1 = r10.iterator();
        AnnotatedField r4 = null;
    L6:
        if (r1.hasNext() == false) goto L15;
        AnnotatedField r5 = r1.next();
        if (r4 == null) goto L14;
        if (r4.getAnnotation().index() != r5.getAnnotation().index()) goto L14;
        throw new Asn1EncodingException("Fields have the same index: " + r0.getName() + LibrarianImpl.Constants.DOT + r4.getField().getName() + " and ." + r5.getField().getName());
    L14:
        r4 = r5;
    L15:
        ArrayList r2 = new ArrayList(r10.size());
        Iterator<AnnotatedField> r11 = r10.iterator();
        int r6 = 0;
    L17:
        if (r11.hasNext() == false) goto L25;
        AnnotatedField r7 = r11.next();
        byte[] r12 = r7.toDer();     // Catch: Asn1EncodingException -> L22
        if (r12 == null) goto L17;
        r2.add(r12);
        r6 = r6 + r12.length;
    L22:
        e = move-exception;
        throw new Asn1EncodingException("Failed to encode " + r0.getName() + LibrarianImpl.Constants.DOT + r7.getField().getName(), e);
    L25:
        if (r9 == false) goto L32;
        byte[] r13 = new byte[r6];
        Iterator r14 = r2.iterator();
        int r3 = 0;
    L28:
        if (r14.hasNext() == false) goto L30;
        byte[] r15 = (byte[]) r14.next();
        System.arraycopy(r15, 0, r13, r3, r15.length);
        r3 = r3 + r15.length;
        goto L28
    L30:
        return r13;
    L32:
        return createTag(0, true, 16, (byte[][]) r2.toArray(new byte[0][]));
    }

    private static byte[] toInteger(BigInteger r2) {
        return createTag(0, false, 2, new byte[][]{r2.toByteArray()});
    }

    private static byte[] toBoolean(boolean r3) {
        byte[] r1 = new byte[1];
        if (r3 == true) goto L5;
        r1[0] = 0;
    L7:
        return createTag(0, false, 1, new byte[][]{r1});
    L5:
        r1[0] = 1;
        goto L7
    }
}
