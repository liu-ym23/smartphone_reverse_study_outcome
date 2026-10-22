package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class BufferedHeader implements FormattedHeader, Cloneable, Serializable {
    private static final long serialVersionUID = -2768352615787625448L;
    private final CharArrayBuffer buffer;
    private final String name;
    private final int valuePos;

    public BufferedHeader(CharArrayBuffer r5) throws ParseException {
        Args.notNull(r5, "Char array buffer");
        int r0 = r5.indexOf(58);
        if (r0 == (-1)) goto L11;
        String r1 = r5.substringTrimmed(0, r0);
        if (r1.isEmpty() == true) goto L9;
        this.buffer = r5;
        this.name = r1;
        this.valuePos = r0 + 1;
        return;
    L9:
        throw new ParseException("Invalid header: " + r5.toString());
    L11:
        throw new ParseException("Invalid header: " + r5.toString());
    }

    @Override // cz.msebera.android.httpclient.NameValuePair
    public String getName() {
        return this.name;
    }

    @Override // cz.msebera.android.httpclient.NameValuePair
    public String getValue() {
        CharArrayBuffer r0 = this.buffer;
        return r0.substringTrimmed(this.valuePos, r0.length());
    }

    @Override // cz.msebera.android.httpclient.Header
    public HeaderElement[] getElements() throws ParseException {
        ParserCursor r0 = new ParserCursor(0, this.buffer.length());
        r0.updatePos(this.valuePos);
        return BasicHeaderValueParser.INSTANCE.parseElements(this.buffer, r0);
    }

    @Override // cz.msebera.android.httpclient.FormattedHeader
    public int getValuePos() {
        return this.valuePos;
    }

    @Override // cz.msebera.android.httpclient.FormattedHeader
    public CharArrayBuffer getBuffer() {
        return this.buffer;
    }

    public String toString() {
        return this.buffer.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
