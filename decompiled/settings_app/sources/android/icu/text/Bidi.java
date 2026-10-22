package android.icu.text;

import java.text.AttributedCharacterIterator;

/* JADX INFO: loaded from: classes.dex */
public class Bidi {
    public static final int DIRECTION_DEFAULT_LEFT_TO_RIGHT = 126;
    public static final int DIRECTION_DEFAULT_RIGHT_TO_LEFT = 127;
    public static final int DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int DIRECTION_RIGHT_TO_LEFT = 1;
    public static final short DO_MIRRORING = 2;
    public static final short INSERT_LRM_FOR_NUMERIC = 4;
    public static final short KEEP_BASE_COMBINING = 1;
    public static final byte LEVEL_DEFAULT_LTR = 126;
    public static final byte LEVEL_DEFAULT_RTL = 127;
    public static final byte LEVEL_OVERRIDE = -128;
    public static final byte LTR = 0;
    public static final int MAP_NOWHERE = -1;
    public static final byte MAX_EXPLICIT_LEVEL = 125;
    public static final byte MIXED = 2;
    public static final byte NEUTRAL = 3;
    public static final int OPTION_DEFAULT = 0;
    public static final int OPTION_INSERT_MARKS = 1;
    public static final int OPTION_REMOVE_CONTROLS = 2;
    public static final int OPTION_STREAMING = 4;
    public static final short OUTPUT_REVERSE = 16;
    public static final short REMOVE_BIDI_CONTROLS = 8;
    public static final short REORDER_DEFAULT = 0;
    public static final short REORDER_GROUP_NUMBERS_WITH_R = 2;
    public static final short REORDER_INVERSE_FOR_NUMBERS_SPECIAL = 6;
    public static final short REORDER_INVERSE_LIKE_DIRECT = 5;
    public static final short REORDER_INVERSE_NUMBERS_AS_L = 4;
    public static final short REORDER_NUMBERS_SPECIAL = 1;
    public static final short REORDER_RUNS_ONLY = 3;
    public static final byte RTL = 1;

    public Bidi() {
        throw new RuntimeException("Stub!");
    }

    public Bidi(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public Bidi(String r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public Bidi(AttributedCharacterIterator r1) {
        throw new RuntimeException("Stub!");
    }

    public Bidi(char[] r1, int r2, byte[] r3, int r4, int r5, int r6) {
        throw new RuntimeException("Stub!");
    }

    public void setInverse(boolean r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean isInverse() {
        throw new RuntimeException("Stub!");
    }

    public void setReorderingMode(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int getReorderingMode() {
        throw new RuntimeException("Stub!");
    }

    public void setReorderingOptions(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int getReorderingOptions() {
        throw new RuntimeException("Stub!");
    }

    public static byte getBaseDirection(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public void setContext(String r1, String r2) {
        throw new RuntimeException("Stub!");
    }

    public void setPara(String r1, byte r2, byte[] r3) {
        throw new RuntimeException("Stub!");
    }

    public void setPara(char[] r1, byte r2, byte[] r3) {
        throw new RuntimeException("Stub!");
    }

    public void setPara(AttributedCharacterIterator r1) {
        throw new RuntimeException("Stub!");
    }

    public void orderParagraphsLTR(boolean r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean isOrderParagraphsLTR() {
        throw new RuntimeException("Stub!");
    }

    public byte getDirection() {
        throw new RuntimeException("Stub!");
    }

    public String getTextAsString() {
        throw new RuntimeException("Stub!");
    }

    public char[] getText() {
        throw new RuntimeException("Stub!");
    }

    public int getLength() {
        throw new RuntimeException("Stub!");
    }

    public int getProcessedLength() {
        throw new RuntimeException("Stub!");
    }

    public int getResultLength() {
        throw new RuntimeException("Stub!");
    }

    public byte getParaLevel() {
        throw new RuntimeException("Stub!");
    }

    public int countParagraphs() {
        throw new RuntimeException("Stub!");
    }

    public BidiRun getParagraphByIndex(int r1) {
        throw new RuntimeException("Stub!");
    }

    public BidiRun getParagraph(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int getParagraphIndex(int r1) {
        throw new RuntimeException("Stub!");
    }

    public void setCustomClassifier(BidiClassifier r1) {
        throw new RuntimeException("Stub!");
    }

    public BidiClassifier getCustomClassifier() {
        throw new RuntimeException("Stub!");
    }

    public int getCustomizedClass(int r1) {
        throw new RuntimeException("Stub!");
    }

    public Bidi setLine(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public byte getLevelAt(int r1) {
        throw new RuntimeException("Stub!");
    }

    public byte[] getLevels() {
        throw new RuntimeException("Stub!");
    }

    public BidiRun getLogicalRun(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int countRuns() {
        throw new RuntimeException("Stub!");
    }

    public BidiRun getVisualRun(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int getVisualIndex(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int getLogicalIndex(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int[] getLogicalMap() {
        throw new RuntimeException("Stub!");
    }

    public int[] getVisualMap() {
        throw new RuntimeException("Stub!");
    }

    public static int[] reorderLogical(byte[] r1) {
        throw new RuntimeException("Stub!");
    }

    public static int[] reorderVisual(byte[] r1) {
        throw new RuntimeException("Stub!");
    }

    public static int[] invertMap(int[] r1) {
        throw new RuntimeException("Stub!");
    }

    public Bidi createLineBidi(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public boolean isMixed() {
        throw new RuntimeException("Stub!");
    }

    public boolean isLeftToRight() {
        throw new RuntimeException("Stub!");
    }

    public boolean isRightToLeft() {
        throw new RuntimeException("Stub!");
    }

    public boolean baseIsLeftToRight() {
        throw new RuntimeException("Stub!");
    }

    public int getBaseLevel() {
        throw new RuntimeException("Stub!");
    }

    public int getRunCount() {
        throw new RuntimeException("Stub!");
    }

    public int getRunLevel(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int getRunStart(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int getRunLimit(int r1) {
        throw new RuntimeException("Stub!");
    }

    public static boolean requiresBidi(char[] r0, int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public static void reorderVisually(byte[] r0, int r1, Object[] r2, int r3, int r4) {
        throw new RuntimeException("Stub!");
    }

    public String writeReordered(int r1) {
        throw new RuntimeException("Stub!");
    }

    public static String writeReverse(String r0, int r1) {
        throw new RuntimeException("Stub!");
    }
}
