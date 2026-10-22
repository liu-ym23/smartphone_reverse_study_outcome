package android.icu.text;

import java.text.CharacterIterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class UCharacterIterator implements Cloneable {
    public static final int DONE = -1;

    public abstract int current();

    public abstract int getIndex();

    public abstract int getLength();

    public abstract int getText(char[] r1, int r2);

    public abstract int next();

    public abstract int previous();

    public abstract void setIndex(int r1);

    protected UCharacterIterator() {
        throw new RuntimeException("Stub!");
    }

    public static final UCharacterIterator getInstance(Replaceable r1) {
        throw new RuntimeException("Stub!");
    }

    public static final UCharacterIterator getInstance(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static final UCharacterIterator getInstance(char[] r1) {
        throw new RuntimeException("Stub!");
    }

    public static final UCharacterIterator getInstance(char[] r0, int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public static final UCharacterIterator getInstance(StringBuffer r1) {
        throw new RuntimeException("Stub!");
    }

    public static final UCharacterIterator getInstance(CharacterIterator r1) {
        throw new RuntimeException("Stub!");
    }

    public CharacterIterator getCharacterIterator() {
        throw new RuntimeException("Stub!");
    }

    public int currentCodePoint() {
        throw new RuntimeException("Stub!");
    }

    public int nextCodePoint() {
        throw new RuntimeException("Stub!");
    }

    public int previousCodePoint() {
        throw new RuntimeException("Stub!");
    }

    public void setToLimit() {
        throw new RuntimeException("Stub!");
    }

    public void setToStart() {
        throw new RuntimeException("Stub!");
    }

    public final int getText(char[] r1) {
        throw new RuntimeException("Stub!");
    }

    public String getText() {
        throw new RuntimeException("Stub!");
    }

    public int moveIndex(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int moveCodePointIndex(int r1) {
        throw new RuntimeException("Stub!");
    }

    public Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }
}
