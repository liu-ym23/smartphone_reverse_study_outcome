package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HeaderElementIterator;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHeaderElementIterator implements HeaderElementIterator {
    private CharArrayBuffer buffer;
    private HeaderElement currentElement;
    private ParserCursor cursor;
    private final HeaderIterator headerIt;
    private final HeaderValueParser parser;

    public BasicHeaderElementIterator(HeaderIterator r2, HeaderValueParser r3) {
        this.currentElement = null;
        this.buffer = null;
        this.cursor = null;
        this.headerIt = (HeaderIterator) Args.notNull(r2, "Header iterator");
        this.parser = (HeaderValueParser) Args.notNull(r3, "Parser");
    }

    public BasicHeaderElementIterator(HeaderIterator r2) {
        this(r2, BasicHeaderValueParser.INSTANCE);
    }

    private void bufferHeaderValue() {
        this.cursor = null;
        this.buffer = null;
    L4:
        if (this.headerIt.hasNext() == false) goto L17;
        Header r0 = this.headerIt.nextHeader();
        if ((r0 instanceof FormattedHeader) == true) goto L7;
        String r1 = r0.getValue();
        if (r1 == null) goto L4;
        CharArrayBuffer r2 = new CharArrayBuffer(r1.length());
        this.buffer = r2;
        r2.append(r1);
        this.cursor = new ParserCursor(0, this.buffer.length());
        return;
    L7:
        FormattedHeader r3 = (FormattedHeader) r0;
        this.buffer = r3.getBuffer();
        ParserCursor r4 = new ParserCursor(0, this.buffer.length());
        this.cursor = r4;
        r4.updatePos(r3.getValuePos());
        return;
    }

    private void parseNextElement() {
    L3:
        if (this.headerIt.hasNext() == false) goto L5;
    L8:
        ParserCursor r0 = this.cursor;
        if (r0 != null) goto L11;
    L12:
        bufferHeaderValue();
    L14:
        if (this.cursor == null) goto L3;
    L16:
        if (this.cursor.atEnd() == true) goto L24;
        HeaderElement r1 = this.parser.parseHeaderElement(this.buffer, this.cursor);
        if (r1.getName().isEmpty() == false) goto L21;
        if (r1.getValue() == null) goto L16;
    L21:
        this.currentElement = r1;
        return;
    L24:
        if (this.cursor.atEnd() == false) goto L3;
        this.cursor = null;
        this.buffer = null;
        goto L3
    L11:
        if (r0.atEnd() == false) goto L14;
    L5:
        if (this.cursor != null) goto L8;
    }

    @Override // cz.msebera.android.httpclient.HeaderElementIterator, java.util.Iterator
    public boolean hasNext() {
        if (this.currentElement != null) goto L6;
        parseNextElement();
    L6:
        if (this.currentElement == null) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // cz.msebera.android.httpclient.HeaderElementIterator
    public HeaderElement nextElement() throws NoSuchElementException {
        if (this.currentElement != null) goto L5;
        parseNextElement();
    L5:
        HeaderElement r0 = this.currentElement;
        if (r0 == null) goto L10;
        this.currentElement = null;
        return r0;
    L10:
        throw new NoSuchElementException("No more header elements available");
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException {
        return nextElement();
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
