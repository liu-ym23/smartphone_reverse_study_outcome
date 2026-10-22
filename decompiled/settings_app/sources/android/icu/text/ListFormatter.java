package android.icu.text;

import android.icu.util.ULocale;
import java.text.AttributedCharacterIterator;
import java.util.Collection;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ListFormatter {

    public static final class FormattedList implements FormattedValue {
        FormattedList() {
            throw new RuntimeException("Stub!");
        }

        @Override // android.icu.text.FormattedValue, java.lang.CharSequence
        public String toString() {
            throw new RuntimeException("Stub!");
        }

        @Override // java.lang.CharSequence
        public int length() {
            throw new RuntimeException("Stub!");
        }

        @Override // java.lang.CharSequence
        public char charAt(int r1) {
            throw new RuntimeException("Stub!");
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int r1, int r2) {
            throw new RuntimeException("Stub!");
        }

        @Override // android.icu.text.FormattedValue
        public <A extends Appendable> A appendTo(A r1) {
            throw new RuntimeException("Stub!");
        }

        @Override // android.icu.text.FormattedValue
        public boolean nextPosition(ConstrainedFieldPosition r1) {
            throw new RuntimeException("Stub!");
        }

        @Override // android.icu.text.FormattedValue
        public AttributedCharacterIterator toCharacterIterator() {
            throw new RuntimeException("Stub!");
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type AND = null;
        public static final Type OR = null;
        public static final Type UNITS = null;

        public static Type valueOf(String r1) {
            return (Type) Enum.valueOf(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Type r0 = new Type("AND", 0);
            AND = r0;
            Type r1 = new Type("OR", 1);
            OR = r1;
            Type r3 = new Type("UNITS", 2);
            UNITS = r3;
            $VALUES = new Type[]{r0, r1, r3};
        }
    }

    public static final enum Width extends Enum<Width> {
        private static final /* synthetic */ Width[] $VALUES = null;
        public static final Width NARROW = null;
        public static final Width SHORT = null;
        public static final Width WIDE = null;

        public static Width valueOf(String r1) {
            return (Width) Enum.valueOf(Width.class, r1);
        }

        public static Width[] values() {
            return (Width[]) $VALUES.clone();
        }

        private Width(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Width r0 = new Width("WIDE", 0);
            WIDE = r0;
            Width r1 = new Width("SHORT", 1);
            SHORT = r1;
            Width r3 = new Width("NARROW", 2);
            NARROW = r3;
            $VALUES = new Width[]{r0, r1, r3};
        }
    }

    ListFormatter() {
        throw new RuntimeException("Stub!");
    }

    public static ListFormatter getInstance(ULocale r0, Type r1, Width r2) {
        throw new RuntimeException("Stub!");
    }

    public static ListFormatter getInstance(Locale r0, Type r1, Width r2) {
        throw new RuntimeException("Stub!");
    }

    public static ListFormatter getInstance(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static ListFormatter getInstance(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static ListFormatter getInstance() {
        throw new RuntimeException("Stub!");
    }

    public String format(Object... r1) {
        throw new RuntimeException("Stub!");
    }

    public String format(Collection<?> r1) {
        throw new RuntimeException("Stub!");
    }

    public FormattedList formatToValue(Object... r1) {
        throw new RuntimeException("Stub!");
    }

    public FormattedList formatToValue(Collection<?> r1) {
        throw new RuntimeException("Stub!");
    }

    public String getPatternForNumItems(int r1) {
        throw new RuntimeException("Stub!");
    }
}
