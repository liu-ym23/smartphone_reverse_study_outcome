package android.graphics;

/* JADX INFO: loaded from: classes.dex */
public class ObricBaseRecordingCanvasImpl implements IObricBaseRecordingCanvas {
    private BaseRecordingCanvas mBase;
    private StringBuffer mBuffer;

    public ObricBaseRecordingCanvasImpl(BaseRecordingCanvas base) {
        this.mBuffer = null;
        this.mBase = base;
    }

    public void setDrawTextBuffer(StringBuffer buffer) {
        this.mBuffer = buffer;
    }

    public void recordDrawText(String text, int start, int end) {
        if (this.mBuffer != null) goto L5;
        return;
    L5:
        if (end >= text.length()) goto L9;
        if (text.charAt(end) != '\n') goto L9;
        end = end + 1;
    L9:
        this.mBuffer.append(text.subSequence(start, end));
    }
}
