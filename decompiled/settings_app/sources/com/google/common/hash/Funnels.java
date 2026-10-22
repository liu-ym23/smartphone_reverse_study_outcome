package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Funnels {

    private static final enum ByteArrayFunnel extends Enum<ByteArrayFunnel> implements Funnel<byte[]> {
        private static final /* synthetic */ ByteArrayFunnel[] $VALUES = null;
        public static final ByteArrayFunnel INSTANCE = null;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }

        private static /* synthetic */ ByteArrayFunnel[] $values() {
            return new ByteArrayFunnel[]{INSTANCE};
        }

        private ByteArrayFunnel(String r1, int r2) {
            super(r1, r2);
        }

        public static ByteArrayFunnel valueOf(String r1) {
            return (ByteArrayFunnel) Enum.valueOf(ByteArrayFunnel.class, r1);
        }

        public static ByteArrayFunnel[] values() {
            return (ByteArrayFunnel[]) $VALUES.clone();
        }

        @Override // com.google.common.hash.Funnel
        public /* bridge */ /* synthetic */ void funnel(byte[] r1, PrimitiveSink r2) {
            funnel2(r1, r2);
        }

        static {
            INSTANCE = new ByteArrayFunnel("INSTANCE", 0);
            $VALUES = $values();
        }

        /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
        public void funnel2(byte[] r1, PrimitiveSink r2) {
            r2.putBytes(r1);
        }
    }

    private static final enum IntegerFunnel extends Enum<IntegerFunnel> implements Funnel<Integer> {
        private static final /* synthetic */ IntegerFunnel[] $VALUES = null;
        public static final IntegerFunnel INSTANCE = null;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.integerFunnel()";
        }

        private static /* synthetic */ IntegerFunnel[] $values() {
            return new IntegerFunnel[]{INSTANCE};
        }

        private IntegerFunnel(String r1, int r2) {
            super(r1, r2);
        }

        public static IntegerFunnel valueOf(String r1) {
            return (IntegerFunnel) Enum.valueOf(IntegerFunnel.class, r1);
        }

        public static IntegerFunnel[] values() {
            return (IntegerFunnel[]) $VALUES.clone();
        }

        @Override // com.google.common.hash.Funnel
        public /* bridge */ /* synthetic */ void funnel(Integer r1, PrimitiveSink r2) {
            funnel2(r1, r2);
        }

        static {
            INSTANCE = new IntegerFunnel("INSTANCE", 0);
            $VALUES = $values();
        }

        /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
        public void funnel2(Integer r1, PrimitiveSink r2) {
            r2.putInt(r1.intValue());
        }
    }

    private static final enum LongFunnel extends Enum<LongFunnel> implements Funnel<Long> {
        private static final /* synthetic */ LongFunnel[] $VALUES = null;
        public static final LongFunnel INSTANCE = null;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.longFunnel()";
        }

        private static /* synthetic */ LongFunnel[] $values() {
            return new LongFunnel[]{INSTANCE};
        }

        private LongFunnel(String r1, int r2) {
            super(r1, r2);
        }

        public static LongFunnel valueOf(String r1) {
            return (LongFunnel) Enum.valueOf(LongFunnel.class, r1);
        }

        public static LongFunnel[] values() {
            return (LongFunnel[]) $VALUES.clone();
        }

        @Override // com.google.common.hash.Funnel
        public /* bridge */ /* synthetic */ void funnel(Long r1, PrimitiveSink r2) {
            funnel2(r1, r2);
        }

        static {
            INSTANCE = new LongFunnel("INSTANCE", 0);
            $VALUES = $values();
        }

        /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
        public void funnel2(Long r1, PrimitiveSink r2) {
            r2.putLong(r1.longValue());
        }
    }

    private static class SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
        private final Funnel<E> elementFunnel;

        @Override // com.google.common.hash.Funnel
        public /* bridge */ /* synthetic */ void funnel(Object r1, PrimitiveSink r2) {
            funnel((Iterable) r1, r2);
        }

        SequentialFunnel(Funnel<E> r1) {
            this.elementFunnel = (Funnel) Preconditions.checkNotNull(r1);
        }

        public void funnel(Iterable<? extends E> r3, PrimitiveSink r4) {
            Iterator<? extends E> r5 = r3.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            E r0 = r5.next();
            this.elementFunnel.funnel(r0, r4);
            goto L4
        }

        public String toString() {
            String r2 = String.valueOf(this.elementFunnel);
            return new StringBuilder(String.valueOf(r2).length() + 26).append("Funnels.sequentialFunnel(").append(r2).append(")").toString();
        }

        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof SequentialFunnel) == true) goto L5;
            return false;
        L5:
            return this.elementFunnel.equals(((SequentialFunnel) r2).elementFunnel);
        }

        public int hashCode() {
            int r0 = SequentialFunnel.class.hashCode();
            return this.elementFunnel.hashCode() ^ r0;
        }
    }

    private static class SinkAsStream extends OutputStream {
        final PrimitiveSink sink;

        SinkAsStream(PrimitiveSink r1) {
            this.sink = (PrimitiveSink) Preconditions.checkNotNull(r1);
        }

        @Override // java.io.OutputStream
        public void write(int r1) {
            this.sink.putByte((byte) r1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] r1) {
            this.sink.putBytes(r1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] r1, int r2, int r3) {
            this.sink.putBytes(r1, r2, r3);
        }

        public String toString() {
            String r2 = String.valueOf(this.sink);
            return new StringBuilder(String.valueOf(r2).length() + 24).append("Funnels.asOutputStream(").append(r2).append(")").toString();
        }
    }

    private static class StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
        private final Charset charset;

        private static class SerializedForm implements Serializable {
            private static final long serialVersionUID = 0;
            private final String charsetCanonicalName;

            SerializedForm(Charset r1) {
                this.charsetCanonicalName = r1.name();
            }

            private Object readResolve() {
                return Funnels.stringFunnel(Charset.forName(this.charsetCanonicalName));
            }
        }

        @Override // com.google.common.hash.Funnel
        public /* bridge */ /* synthetic */ void funnel(CharSequence r1, PrimitiveSink r2) {
            funnel2(r1, r2);
        }

        StringCharsetFunnel(Charset r1) {
            this.charset = (Charset) Preconditions.checkNotNull(r1);
        }

        /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
        public void funnel2(CharSequence r1, PrimitiveSink r2) {
            r2.putString(r1, this.charset);
        }

        public String toString() {
            String r2 = this.charset.name();
            return new StringBuilder(String.valueOf(r2).length() + 22).append("Funnels.stringFunnel(").append(r2).append(")").toString();
        }

        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof StringCharsetFunnel) == true) goto L5;
            return false;
        L5:
            return this.charset.equals(((StringCharsetFunnel) r2).charset);
        }

        public int hashCode() {
            int r0 = StringCharsetFunnel.class.hashCode();
            return this.charset.hashCode() ^ r0;
        }

        Object writeReplace() {
            return new SerializedForm(this.charset);
        }
    }

    private static final enum UnencodedCharsFunnel extends Enum<UnencodedCharsFunnel> implements Funnel<CharSequence> {
        private static final /* synthetic */ UnencodedCharsFunnel[] $VALUES = null;
        public static final UnencodedCharsFunnel INSTANCE = null;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }

        private static /* synthetic */ UnencodedCharsFunnel[] $values() {
            return new UnencodedCharsFunnel[]{INSTANCE};
        }

        private UnencodedCharsFunnel(String r1, int r2) {
            super(r1, r2);
        }

        public static UnencodedCharsFunnel valueOf(String r1) {
            return (UnencodedCharsFunnel) Enum.valueOf(UnencodedCharsFunnel.class, r1);
        }

        public static UnencodedCharsFunnel[] values() {
            return (UnencodedCharsFunnel[]) $VALUES.clone();
        }

        @Override // com.google.common.hash.Funnel
        public /* bridge */ /* synthetic */ void funnel(CharSequence r1, PrimitiveSink r2) {
            funnel2(r1, r2);
        }

        static {
            INSTANCE = new UnencodedCharsFunnel("INSTANCE", 0);
            $VALUES = $values();
        }

        /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
        public void funnel2(CharSequence r1, PrimitiveSink r2) {
            r2.putUnencodedChars(r1);
        }
    }

    private Funnels() {
    }

    public static Funnel<byte[]> byteArrayFunnel() {
        return ByteArrayFunnel.INSTANCE;
    }

    public static Funnel<CharSequence> unencodedCharsFunnel() {
        return UnencodedCharsFunnel.INSTANCE;
    }

    public static Funnel<CharSequence> stringFunnel(Charset r1) {
        return new StringCharsetFunnel(r1);
    }

    public static Funnel<Integer> integerFunnel() {
        return IntegerFunnel.INSTANCE;
    }

    public static <E> Funnel<Iterable<? extends E>> sequentialFunnel(Funnel<E> r1) {
        return new SequentialFunnel(r1);
    }

    public static Funnel<Long> longFunnel() {
        return LongFunnel.INSTANCE;
    }

    public static OutputStream asOutputStream(PrimitiveSink r1) {
        return new SinkAsStream(r1);
    }
}
