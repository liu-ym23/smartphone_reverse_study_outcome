package android.icu.text;

import android.icu.util.ULocale;
import java.io.InvalidObjectException;
import java.text.AttributedCharacterIterator;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MessageFormat extends UFormat {

    public static class Field extends Format.Field {
        public static final Field ARGUMENT = null;

        static {
        }

        protected Field(String r1) {
            super(null);
            throw new RuntimeException("Stub!");
        }

        @Override // java.text.AttributedCharacterIterator.Attribute
        protected Object readResolve() throws InvalidObjectException {
            throw new RuntimeException("Stub!");
        }
    }

    public MessageFormat(String r1) {
        throw new RuntimeException("Stub!");
    }

    public MessageFormat(String r1, Locale r2) {
        throw new RuntimeException("Stub!");
    }

    public MessageFormat(String r1, ULocale r2) {
        throw new RuntimeException("Stub!");
    }

    public void setLocale(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public void setLocale(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public Locale getLocale() {
        throw new RuntimeException("Stub!");
    }

    public ULocale getULocale() {
        throw new RuntimeException("Stub!");
    }

    public void applyPattern(String r1) {
        throw new RuntimeException("Stub!");
    }

    public void applyPattern(String r1, MessagePattern.ApostropheMode r2) {
        throw new RuntimeException("Stub!");
    }

    public MessagePattern.ApostropheMode getApostropheMode() {
        throw new RuntimeException("Stub!");
    }

    public String toPattern() {
        throw new RuntimeException("Stub!");
    }

    public void setFormatsByArgumentIndex(Format[] r1) {
        throw new RuntimeException("Stub!");
    }

    public void setFormatsByArgumentName(Map<String, Format> r1) {
        throw new RuntimeException("Stub!");
    }

    public void setFormats(Format[] r1) {
        throw new RuntimeException("Stub!");
    }

    public void setFormatByArgumentIndex(int r1, Format r2) {
        throw new RuntimeException("Stub!");
    }

    public void setFormatByArgumentName(String r1, Format r2) {
        throw new RuntimeException("Stub!");
    }

    public void setFormat(int r1, Format r2) {
        throw new RuntimeException("Stub!");
    }

    public Format[] getFormatsByArgumentIndex() {
        throw new RuntimeException("Stub!");
    }

    public Format[] getFormats() {
        throw new RuntimeException("Stub!");
    }

    public Set<String> getArgumentNames() {
        throw new RuntimeException("Stub!");
    }

    public Format getFormatByArgumentName(String r1) {
        throw new RuntimeException("Stub!");
    }

    public final StringBuffer format(Object[] r1, StringBuffer r2, FieldPosition r3) {
        throw new RuntimeException("Stub!");
    }

    public final StringBuffer format(Map<String, Object> r1, StringBuffer r2, FieldPosition r3) {
        throw new RuntimeException("Stub!");
    }

    public static String format(String r0, Object... r1) {
        throw new RuntimeException("Stub!");
    }

    public static String format(String r0, Map<String, Object> r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean usesNamedArguments() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.text.Format
    public final StringBuffer format(Object r1, StringBuffer r2, FieldPosition r3) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object r1) {
        throw new RuntimeException("Stub!");
    }

    public Object[] parse(String r1, ParsePosition r2) {
        throw new RuntimeException("Stub!");
    }

    public Map<String, Object> parseToMap(String r1, ParsePosition r2) {
        throw new RuntimeException("Stub!");
    }

    public Object[] parse(String r1) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    public Map<String, Object> parseToMap(String r1) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.text.Format
    public Object parseObject(String r1, ParsePosition r2) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.text.Format
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public static String autoQuoteApostrophe(String r1) {
        throw new RuntimeException("Stub!");
    }
}
