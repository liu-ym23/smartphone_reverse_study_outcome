package android.icu.text;

import java.text.AttributedCharacterIterator;

/* JADX INFO: loaded from: classes.dex */
public interface FormattedValue extends CharSequence {
    <A extends Appendable> A appendTo(A r1);

    boolean nextPosition(ConstrainedFieldPosition r1);

    AttributedCharacterIterator toCharacterIterator();

    @Override // java.lang.CharSequence
    String toString();
}
