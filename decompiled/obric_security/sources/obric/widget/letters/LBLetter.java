package obric.widget.letters;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes5.dex */
public class LBLetter {
    public static final int ICON_STATUS_HOLDER = 1;
    public static final int ICON_STATUS_NORMAL = 0;
    public static final int ICON_STATUS_TOUCHED = 2;
    public static LBLetter POUND = null;
    public static final int TYPE_LETTER = 0;
    public static final int TYPE_LOCALE_LETTER = 1;
    public static final int TYPE_SYMBOL = 2;
    private String letter;
    private Bitmap[] letterBitmaps;
    private int type;

    private LBLetter(int type, String letter, Bitmap[] letterBitmaps) {
        this.type = type;
        this.letter = letter;
        if (type != 2) goto L10;
        if (letterBitmaps == null) goto L9;
        if (letterBitmaps.length != 3) goto L9;
        this.letterBitmaps = letterBitmaps;
        return;
    L9:
        throw new IllegalStateException("symbol must have 3 bitmaps!");
    }

    public int getType() {
        return this.type;
    }

    public String getLetter() {
        return this.letter;
    }

    public Bitmap[] getLetterBitmaps() {
        return this.letterBitmaps;
    }

    static {
        POUND = fromLetter("#");
    }

    public static LBLetter fromLetter(String letter) {
        return new LBLetter(0, letter, null);
    }

    public static LBLetter fromLocaleLetter(String letter) {
        return new LBLetter(1, letter, null);
    }

    public static LBLetter fromSymbol(String symbol, Bitmap[] letterBitmaps) {
        return new LBLetter(2, symbol, letterBitmaps);
    }
}
