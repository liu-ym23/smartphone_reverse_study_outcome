package android.icu.text;

/* JADX INFO: loaded from: classes.dex */
public interface Replaceable {
    int char32At(int r1);

    char charAt(int r1);

    void copy(int r1, int r2, int r3);

    void getChars(int r1, int r2, char[] r3, int r4);

    boolean hasMetaData();

    int length();

    void replace(int r1, int r2, String r3);

    void replace(int r1, int r2, char[] r3, int r4, int r5);
}
