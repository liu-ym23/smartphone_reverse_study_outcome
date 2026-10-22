package com.android.apksig.internal.asn1;

import com.android.apksig.internal.asn1.ber.BerDataValue;
import com.android.apksig.internal.asn1.ber.BerDataValueFormatException;
import com.android.apksig.internal.asn1.ber.BerDataValueReader;
import com.android.apksig.internal.asn1.ber.BerEncoding;
import com.android.apksig.internal.asn1.ber.ByteBufferBerDataValueReader;
import com.android.apksig.internal.util.ByteBufferUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public final class Asn1BerParser {

    /* JADX INFO: renamed from: com.android.apksig.internal.asn1.Asn1BerParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$apksig$internal$asn1$Asn1Type = null;

        static {
            int[] r0 = new int[Asn1Type.values().length];
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type = r0;
            r0[Asn1Type.CHOICE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.SEQUENCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.UNENCODED_CONTAINER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.SET_OF.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.SEQUENCE_OF.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.INTEGER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.OBJECT_IDENTIFIER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.UTC_TIME.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.GENERALIZED_TIME.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[Asn1Type.BOOLEAN.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    private static final class AnnotatedField {
        private final Asn1Field mAnnotation;
        private final int mBerTagClass;
        private final int mBerTagNumber;
        private final Asn1Type mDataType;
        private final Field mField;
        private final boolean mOptional;
        private final Asn1TagClass mTagClass;
        private final Asn1Tagging mTagging;

        public AnnotatedField(Field r4, Asn1Field r5) throws Asn1DecodingException {
            this.mField = r4;
            this.mAnnotation = r5;
            Asn1Type r6 = r5.type();
            this.mDataType = r6;
            Asn1TagClass r0 = r5.cls();
            if (r0 == Asn1TagClass.AUTOMATIC) goto L5;
        L8:
            this.mTagClass = r0;
            this.mBerTagClass = BerEncoding.getTagClass(r0);
            if (r5.tagNumber() == (-1)) goto L12;
            int r7 = r5.tagNumber();
        L18:
            this.mBerTagNumber = r7;
            Asn1Tagging r8 = r5.tagging();
            this.mTagging = r8;
            if (r8 == Asn1Tagging.EXPLICIT) goto L23;
            if (r8 == Asn1Tagging.IMPLICIT) goto L23;
        L24:
            this.mOptional = r5.optional();
            return;
        L23:
            if (r5.tagNumber() != (-1)) goto L24;
            throw new Asn1DecodingException("Tag number must be specified when tagging mode is " + r8);
        L12:
            if (r6 != Asn1Type.CHOICE) goto L14;
        L17:
            r7 = -1;
            goto L18
        L14:
            if (r6 == Asn1Type.ANY) goto L17;
            r7 = BerEncoding.getTagNumber(r6);
            goto L18
        L5:
            if (r5.tagNumber() == (-1)) goto L7;
            r0 = Asn1TagClass.CONTEXT_SPECIFIC;
            goto L8
        L7:
            r0 = Asn1TagClass.UNIVERSAL;
            goto L8
        }

        public Asn1Field getAnnotation() {
            return this.mAnnotation;
        }

        public int getBerTagClass() {
            return this.mBerTagClass;
        }

        public int getBerTagNumber() {
            return this.mBerTagNumber;
        }

        public Field getField() {
            return this.mField;
        }

        public boolean isOptional() {
            return this.mOptional;
        }

        public void setValueFrom(BerDataValue r5, Object r6) throws Asn1DecodingException {
            int r0 = r5.getTagClass();
            if (this.mBerTagNumber == (-1)) goto L12;
            int r1 = r5.getTagNumber();
            if (r0 != this.mBerTagClass) goto L10;
            if (r1 != this.mBerTagNumber) goto L10;
        L14:
            if (this.mTagging == Asn1Tagging.EXPLICIT) goto L24;
        L20:
            BerToJavaConverter.setFieldValue(r6, this.mField, this.mDataType, r5);
            return;
        L24:
            r5 = r5.contentsReader().readDataValue();     // Catch: BerDataValueFormatException -> L17
        L17:
            e = move-exception;
            throw new Asn1DecodingException("Failed to read contents of EXPLICIT data value", e);
        L10:
            throw new Asn1UnexpectedTagException("Tag mismatch. Expected: " + BerEncoding.tagClassAndNumberToString(this.mBerTagClass, this.mBerTagNumber) + ", but found " + BerEncoding.tagClassAndNumberToString(r0, r1));
        L12:
            if (r0 == this.mBerTagClass) goto L14;
            throw new Asn1UnexpectedTagException("Tag mismatch. Expected class: " + BerEncoding.tagClassToString(this.mBerTagClass) + ", but found " + BerEncoding.tagClassToString(r0));
        }
    }

    private static class Asn1UnexpectedTagException extends Asn1DecodingException {
        private static final long serialVersionUID = 1;

        public Asn1UnexpectedTagException(String r1) {
            super(r1);
        }
    }

    private static final class BerToJavaConverter {
        private static final byte[] EMPTY_BYTE_ARRAY = null;

        static {
            EMPTY_BYTE_ARRAY = new byte[0];
        }

        private BerToJavaConverter() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v25, types: [T, byte[]] */
        public static <T> T convert(Asn1Type r4, BerDataValue r5, Class<T> r6) throws Asn1DecodingException {
            if (ByteBuffer.class.equals(r6) == false) goto L7;
            return (T) r5.getEncodedContents();
        L7:
            if (byte[].class.equals(r6) == false) goto L15;
            ByteBuffer r7 = r5.getEncodedContents();
            if (r7.hasRemaining() == false) goto L11;
            ?? r8 = (T) new byte[r7.remaining()];
            r7.get(r8);
            return r8;
        L11:
            return (T) EMPTY_BYTE_ARRAY;
        L15:
            if (Asn1OpaqueObject.class.equals(r6) == true) goto L17;
            ByteBuffer r0 = r5.getEncodedContents();
            int r1 = AnonymousClass1.$SwitchMap$com$android$apksig$internal$asn1$Asn1Type[r4.ordinal()];
            boolean r2 = true;
            if (r1 != 1) goto L21;
            Asn1Class r3 = (Asn1Class) r6.getDeclaredAnnotation(Asn1Class.class);
            if (r3 != null) goto L71;
        L75:
            throw new Asn1DecodingException("Unsupported conversion: ASN.1 " + r4 + " to " + r6.getName());
        L71:
            if (r3.type() != Asn1Type.CHOICE) goto L75;
            return (T) Asn1BerParser.access$700(r5, r6);
        L21:
            if (r1 == 2) goto L62;
            switch(r1) {
                case 6: goto L45;
                case 7: goto L41;
                case 8: goto L37;
                case 9: goto L37;
                case 10: goto L25;
                default: goto L75;
            };
        L25:
            if (Boolean.TYPE.equals(r6) == false) goto L75;
            if (r0.remaining() != 1) goto L35;
            if (r0.get() != 0) goto L33;
            r2 = false;
        L33:
            return (T) Boolean.valueOf(r2);
        L35:
            throw new Asn1DecodingException("Incorrect encoded size of boolean value: " + r0.remaining());
        L37:
            if (String.class.equals(r6) == false) goto L75;
            return (T) new String(ByteBufferUtils.toByteArray(r0));
        L41:
            if (String.class.equals(r6) == false) goto L75;
            return (T) Asn1BerParser.access$500(r0);
        L45:
            if (Integer.TYPE.equals(r6) == true) goto L61;
            if (Integer.class.equals(r6) == true) goto L61;
            if (Long.TYPE.equals(r6) == true) goto L59;
            if (Long.class.equals(r6) == true) goto L59;
            if (BigInteger.class.equals(r6) == false) goto L75;
            return (T) Asn1BerParser.access$400(r0);
        L59:
            return (T) Long.valueOf(Asn1BerParser.access$300(r0));
        L61:
            return (T) Integer.valueOf(Asn1BerParser.access$200(r0));
        L62:
            Asn1Class r9 = (Asn1Class) r6.getDeclaredAnnotation(Asn1Class.class);
            if (r9 == null) goto L75;
            if (r9.type() != Asn1Type.SEQUENCE) goto L75;
            return (T) Asn1BerParser.access$600(r5, r6);
        L17:
            return (T) new Asn1OpaqueObject(r5.getEncoded());
        }

        public static void setFieldValue(Object r2, Field r3, Asn1Type r4, BerDataValue r5) throws Asn1DecodingException {
            int r0 = AnonymousClass1.$SwitchMap$com$android$apksig$internal$asn1$Asn1Type[r4.ordinal()];     // Catch: ReflectiveOperationException -> L13
            if (r0 == 4) goto L9;
            if (r0 == 5) goto L9;
            r3.set(r2, convert(r4, r5, r3.getType()));     // Catch: ReflectiveOperationException -> L13
            return;
        L9:
            if (Asn1OpaqueObject.class.equals(r3.getType()) == false) goto L11;
            r3.set(r2, convert(r4, r5, r3.getType()));     // Catch: ReflectiveOperationException -> L13
            return;
        L11:
            r3.set(r2, Asn1BerParser.access$100(r5, Asn1BerParser.access$000(r3)));     // Catch: ReflectiveOperationException -> L13
            return;
        L13:
            e = move-exception;
            throw new Asn1DecodingException("Failed to set value of " + r2.getClass().getName() + LibrarianImpl.Constants.DOT + r3.getName(), e);
        }
    }

    private Asn1BerParser() {
    }

    static /* synthetic */ Class access$000(Field r0) throws Asn1DecodingException, ClassNotFoundException {
        return getElementType(r0);
    }

    static /* synthetic */ List access$100(BerDataValue r0, Class r1) throws Asn1DecodingException {
        return parseSetOf(r0, r1);
    }

    static /* synthetic */ int access$200(ByteBuffer r0) throws Asn1DecodingException {
        return integerToInt(r0);
    }

    static /* synthetic */ long access$300(ByteBuffer r2) throws Asn1DecodingException {
        return integerToLong(r2);
    }

    static /* synthetic */ BigInteger access$400(ByteBuffer r0) {
        return integerToBigInteger(r0);
    }

    static /* synthetic */ String access$500(ByteBuffer r0) throws Asn1DecodingException {
        return oidToString(r0);
    }

    static /* synthetic */ Object access$600(BerDataValue r0, Class r1) throws Asn1DecodingException {
        return parseSequence(r0, r1);
    }

    static /* synthetic */ Object access$700(BerDataValue r0, Class r1) throws Asn1DecodingException {
        return parseChoice(r0, r1);
    }

    private static long decodeBase128UnsignedLong(ByteBuffer r5) throws Asn1DecodingException {
        long r1 = 0;
        if (r5.hasRemaining() == true) goto L6;
        return 0;
    L6:
        if (r5.hasRemaining() == false) goto L15;
        if (r1 > 72057594037927935L) goto L13;
        byte r0 = r5.get();
        r1 = (r1 << 7) | ((long) (r0 & ByteCompanionObject.MAX_VALUE));
        if ((r0 & ByteCompanionObject.MIN_VALUE) != 0) goto L6;
        return r1;
    L13:
        throw new Asn1DecodingException("Base-128 number too large");
    L15:
        throw new Asn1DecodingException("Truncated base-128 encoded input: missing terminating byte, with highest bit not set");
    }

    private static List<AnnotatedField> getAnnotatedFields(Class<?> r8) throws Asn1DecodingException {
        Field[] r0 = r8.getDeclaredFields();
        ArrayList r1 = new ArrayList(r0.length);
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L17;
        Field r4 = r0[r3];
        Asn1Field r5 = (Asn1Field) r4.getDeclaredAnnotation(Asn1Field.class);
        if (r5 == null) goto L11;
        if (Modifier.isStatic(r4.getModifiers()) == true) goto L16;
        r1.add(new AnnotatedField(r4, r5));
    L12:
        e = move-exception;
        throw new Asn1DecodingException("Invalid ASN.1 annotation on " + r8.getName() + LibrarianImpl.Constants.DOT + r4.getName(), e);
    L16:
        throw new Asn1DecodingException(Asn1Field.class.getName() + " used on a static field: " + r8.getName() + LibrarianImpl.Constants.DOT + r4.getName());
    L11:
        r3 = r3 + 1;
        goto L3
    L17:
        return r1;
    }

    private static Asn1Type getContainerAsn1Type(Class<?> r3) throws Asn1DecodingException {
        Asn1Class r0 = (Asn1Class) r3.getDeclaredAnnotation(Asn1Class.class);
        if (r0 == null) goto L16;
        int r4 = AnonymousClass1.$SwitchMap$com$android$apksig$internal$asn1$Asn1Type[r0.type().ordinal()];
        if (r4 == 1) goto L14;
        if (r4 == 2) goto L14;
        if (r4 == 3) goto L14;
        throw new Asn1DecodingException("Unsupported ASN.1 container annotation type: " + r0.type());
    L14:
        return r0.type();
    L16:
        throw new Asn1DecodingException(r3.getName() + " is not annotated with " + Asn1Class.class.getName());
    }

    private static Class<?> getElementType(Field r5) throws Asn1DecodingException, ClassNotFoundException {
        String r0 = r5.getGenericType().getTypeName();
        int r1 = r0.indexOf(60);
        if (r1 == (-1)) goto L11;
        int r2 = r1 + 1;
        int r4 = r0.indexOf(62, r2);
        if (r4 == (-1)) goto L9;
        return Class.forName(r0.substring(r2, r4));
    L9:
        throw new Asn1DecodingException("Not a container type: " + r5.getGenericType());
    L11:
        throw new Asn1DecodingException("Not a container type: " + r5.getGenericType());
    }

    private static BigInteger integerToBigInteger(ByteBuffer r1) {
        if (r1.hasRemaining() == true) goto L7;
        return BigInteger.ZERO;
    L7:
        return new BigInteger(ByteBufferUtils.toByteArray(r1));
    }

    private static int integerToInt(ByteBuffer r3) throws Asn1DecodingException {
        BigInteger r4 = integerToBigInteger(r3);
        if (r4.compareTo(BigInteger.valueOf(-2147483648L)) < 0) goto L9;
        if (r4.compareTo(BigInteger.valueOf(2147483647L)) > 0) goto L9;
        return r4.intValue();
    L9:
        throw new Asn1DecodingException(String.format("INTEGER cannot be represented as int: %1$d (0x%1$x)", new Object[]{r4}));
    }

    private static long integerToLong(ByteBuffer r3) throws Asn1DecodingException {
        BigInteger r4 = integerToBigInteger(r3);
        if (r4.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0) goto L9;
        if (r4.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) goto L9;
        return r4.longValue();
    L9:
        throw new Asn1DecodingException(String.format("INTEGER cannot be represented as long: %1$d (0x%1$x)", new Object[]{r4}));
    }

    static /* synthetic */ int lambda$parseSequence$0(AnnotatedField r0, AnnotatedField r1) {
        return r0.getAnnotation().index() - r1.getAnnotation().index();
    }

    private static String oidToString(ByteBuffer r8) throws Asn1DecodingException {
        if (r8.hasRemaining() == false) goto L11;
        long r0 = decodeBase128UnsignedLong(r8);
        long r4 = (int) Math.min(r0 / 40, 2);
        StringBuilder r2 = new StringBuilder();
        r2.append(Long.toString(r4)).append('.').append(r0 - (40 * r4));
    L6:
        if (r8.hasRemaining() == false) goto L9;
        r2.append('.').append(decodeBase128UnsignedLong(r8));
        goto L6
    L9:
        return r2.toString();
    L11:
        throw new Asn1DecodingException("Empty OBJECT IDENTIFIER");
    }

    public static <T> T parse(ByteBuffer r1, Class<T> r2) throws Asn1DecodingException {
        BerDataValue r3 = new ByteBufferBerDataValueReader(r1).readDataValue();     // Catch: BerDataValueFormatException -> L8
        if (r3 == null) goto L7;
        return (T) parse(r3, r2);
    L7:
        throw new Asn1DecodingException("Empty input");
    L8:
        e = move-exception;
        throw new Asn1DecodingException("Failed to decode top-level data value", e);
    }

    private static <T> T parseChoice(BerDataValue r10, Class<T> r11) throws Asn1DecodingException {
        List<AnnotatedField> r0 = getAnnotatedFields(r11);
        if (r0.isEmpty() == true) goto L30;
        int r2 = 0;
    L6:
        if (r2 >= (r0.size() - 1)) goto L34;
        AnnotatedField r3 = r0.get(r2);
        int r4 = r3.getBerTagNumber();
        int r5 = r3.getBerTagClass();
        r2 = r2 + 1;
        int r6 = r2;
    L9:
        if (r6 >= r0.size()) goto L6;
        AnnotatedField r7 = r0.get(r6);
        int r8 = r7.getBerTagNumber();
        int r9 = r7.getBerTagClass();
        if (r4 != r8) goto L16;
        if (r5 != r9) goto L16;
        throw new Asn1DecodingException("CHOICE fields are indistinguishable because they have the same tag class and number: " + r11.getName() + LibrarianImpl.Constants.DOT + r3.getField().getName() + " and ." + r7.getField().getName());
    L16:
        r6 = r6 + 1;
        goto L9
    L34:
        T r1 = r11.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L26
        Iterator<AnnotatedField> r12 = r0.iterator();
    L20:
        if (r12.hasNext() == false) goto L25;
        r12.next().setValueFrom(r10, r1);     // Catch: Asn1UnexpectedTagException -> L31
        return r1;
    L25:
        throw new Asn1DecodingException("No options of CHOICE " + r11.getName() + " matched");
    L26:
        e = move-exception;
        throw new Asn1DecodingException("Failed to instantiate " + r11.getName(), e);
    L30:
        throw new Asn1DecodingException("No fields annotated with " + Asn1Field.class.getName() + " in CHOICE class " + r11.getName());
    }

    private static <T> T parseSequence(BerDataValue r1, Class<T> r2) throws Asn1DecodingException {
        return (T) parseSequence(r1, r2, false);
    }

    private static <T> List<T> parseSetOf(BerDataValue r3, Class<T> r4) throws Asn1DecodingException {
        ArrayList r0 = new ArrayList();
        BerDataValueReader r5 = r3.contentsReader();
    L17:
        BerDataValue r1 = r5.readDataValue();     // Catch: BerDataValueFormatException -> L14
        if (r1 == null) goto L5;
        if (ByteBuffer.class.equals(r4) == false) goto L10;
        Object r2 = r1.getEncodedContents();
    L13:
        r0.add(r2);
        goto L17
    L10:
        if (Asn1OpaqueObject.class.equals(r4) == false) goto L12;
        r2 = new Asn1OpaqueObject(r1.getEncoded());
        goto L13
    L12:
        r2 = parse(r1, r4);
        goto L13
    L5:
        return r0;
    L14:
        e = move-exception;
        throw new Asn1DecodingException("Malformed data value", e);
    }

    private static <T> T parseSequence(BerDataValue r9, Class<T> r10, boolean r11) throws Asn1DecodingException {
        List<AnnotatedField> r0 = getAnnotatedFields(r10);
        Collections.sort(r0, new Asn1BerParser$$ExternalSyntheticLambda0());
        if (r0.size() <= 1) goto L15;
        Iterator<AnnotatedField> r1 = r0.iterator();
        AnnotatedField r2 = null;
    L6:
        if (r1.hasNext() == false) goto L15;
        AnnotatedField r4 = r1.next();
        if (r2 == null) goto L14;
        if (r2.getAnnotation().index() != r4.getAnnotation().index()) goto L14;
        throw new Asn1DecodingException("Fields have the same index: " + r10.getName() + LibrarianImpl.Constants.DOT + r2.getField().getName() + " and ." + r4.getField().getName());
    L14:
        r2 = r4;
    L15:
        int r3 = 0;
        T r5 = r10.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L44
        BerDataValueReader r6 = r9.contentsReader();
    L19:
        if (r3 >= r0.size()) goto L43;
        if (r11 == false) goto L47;
        if (r3 != 0) goto L47;
        BerDataValue r7 = r9;
    L24:
        if (r7 == null) goto L43;
        int r8 = r3;
    L28:
        if (r8 >= r0.size()) goto L19;
        AnnotatedField r12 = r0.get(r8);
        if (r12.isOptional() == false) goto L35;
        r12.setValueFrom(r7, r5);     // Catch: Asn1UnexpectedTagException -> L34 Asn1DecodingException -> L37
    L36:
        r3 = r8 + 1;
    L34:
        r8 = r8 + 1;
        goto L28
    L35:
        r12.setValueFrom(r7, r5);     // Catch: Asn1DecodingException -> L37
    L37:
        e = move-exception;
        throw new Asn1DecodingException("Failed to parse " + r10.getName() + LibrarianImpl.Constants.DOT + r12.getField().getName(), e);
    L47:
        r7 = r6.readDataValue();     // Catch: BerDataValueFormatException -> L40
    L40:
        e = move-exception;
        throw new Asn1DecodingException("Malformed data value", e);
    L43:
        return r5;
    L44:
        e = move-exception;
        throw new Asn1DecodingException("Failed to instantiate " + r10.getName(), e);
    }

    private static <T> T parse(BerDataValue r4, Class<T> r5) throws Asn1DecodingException {
        if (r4 == null) goto L27;
        if (r5 == null) goto L25;
        Asn1Type r0 = getContainerAsn1Type(r5);
        int r1 = AnonymousClass1.$SwitchMap$com$android$apksig$internal$asn1$Asn1Type[r0.ordinal()];
        if (r1 == 1) goto L23;
        if (r1 != 2) goto L9;
        int r2 = BerEncoding.getTagNumber(r0);
        if (r4.getTagClass() != 0) goto L21;
        if (r4.getTagNumber() != r2) goto L21;
        return (T) parseSequence(r4, r5);
    L21:
        throw new Asn1UnexpectedTagException("Unexpected data value read as " + r5.getName() + ". Expected " + BerEncoding.tagClassAndNumberToString(0, r2) + ", but read: " + BerEncoding.tagClassAndNumberToString(r4.getTagClass(), r4.getTagNumber()));
    L9:
        if (r1 != 3) goto L13;
        return (T) parseSequence(r4, r5, true);
    L13:
        throw new Asn1DecodingException("Parsing container " + r0 + " not supported");
    L23:
        return (T) parseChoice(r4, r5);
    L25:
        throw new NullPointerException("containerClass == null");
    L27:
        throw new NullPointerException("container == null");
    }
}
