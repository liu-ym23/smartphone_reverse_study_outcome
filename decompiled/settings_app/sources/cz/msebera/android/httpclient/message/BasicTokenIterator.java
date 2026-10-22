package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.TokenIterator;
import cz.msebera.android.httpclient.util.Args;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public class BasicTokenIterator implements TokenIterator {
    public static final String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
    protected String currentHeader;
    protected String currentToken;
    protected final HeaderIterator headerIt;
    protected int searchPos;

    protected boolean isTokenSeparator(char r1) {
        if (r1 != ',') goto L5;
        return true;
    L5:
        return false;
    }

    public BasicTokenIterator(HeaderIterator r2) {
        this.headerIt = (HeaderIterator) Args.notNull(r2, "Header iterator");
        this.searchPos = findNext(-1);
    }

    @Override // cz.msebera.android.httpclient.TokenIterator, java.util.Iterator
    public boolean hasNext() {
        if (this.currentToken == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // cz.msebera.android.httpclient.TokenIterator
    public String nextToken() throws NoSuchElementException, ParseException {
        String r0 = this.currentToken;
        if (r0 == null) goto L7;
        this.searchPos = findNext(this.searchPos);
        return r0;
    L7:
        throw new NoSuchElementException("Iteration already finished.");
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException, ParseException {
        return nextToken();
    }

    @Override // java.util.Iterator
    public final void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Removing tokens is not supported.");
    }

    protected int findNext(int r3) throws ParseException {
        if (r3 < 0) goto L5;
        int r4 = findTokenSeparator(r3);
    L9:
        int r5 = findTokenStart(r4);
        if (r5 >= 0) goto L13;
        this.currentToken = null;
        return -1;
    L13:
        int r0 = findTokenEnd(r5);
        this.currentToken = createToken(this.currentHeader, r5, r0);
        return r0;
    L5:
        if (this.headerIt.hasNext() == true) goto L7;
        return -1;
    L7:
        this.currentHeader = this.headerIt.nextHeader().getValue();
        r4 = 0;
        goto L9
    }

    protected String createToken(String r1, int r2, int r3) {
        return r1.substring(r2, r3);
    }

    protected int findTokenStart(int r6) {
        int r7 = Args.notNegative(r6, "Search position");
        boolean r1 = false;
    L3:
        if (r1 == true) goto L25;
        String r2 = this.currentHeader;
        if (r2 == null) goto L25;
        int r3 = r2.length();
    L7:
        if (r1 == true) goto L20;
        if (r7 >= r3) goto L20;
        char r4 = this.currentHeader.charAt(r7);
        if (isTokenSeparator(r4) == true) goto L19;
        if (isWhitespace(r4) == true) goto L19;
        if (isTokenChar(this.currentHeader.charAt(r7)) == false) goto L18;
        r1 = true;
        goto L7
    L18:
        throw new ParseException("Invalid character before token (pos " + r7 + "): " + this.currentHeader);
    L19:
        r7 = r7 + 1;
    L20:
        if (r1 == true) goto L3;
        if (this.headerIt.hasNext() == true) goto L23;
        this.currentHeader = null;
        goto L3
    L23:
        this.currentHeader = this.headerIt.nextHeader().getValue();
        r7 = 0;
    L25:
        if (r1 == true) goto L47;
        return -1;
    L47:
        return r7;
    }

    protected int findTokenSeparator(int r5) {
        int r6 = Args.notNegative(r5, "Search position");
        int r0 = this.currentHeader.length();
        boolean r1 = false;
    L3:
        if (r1 == true) goto L17;
        if (r6 >= r0) goto L17;
        char r2 = this.currentHeader.charAt(r6);
        if (isTokenSeparator(r2) == true) goto L7;
        if (isWhitespace(r2) == false) goto L12;
        r6 = r6 + 1;
        goto L3
    L12:
        if (isTokenChar(r2) == false) goto L16;
        throw new ParseException("Tokens without separator (pos " + r6 + "): " + this.currentHeader);
    L16:
        throw new ParseException("Invalid character after token (pos " + r6 + "): " + this.currentHeader);
    L7:
        r1 = true;
    L17:
        return r6;
    }

    protected int findTokenEnd(int r3) {
        Args.notNegative(r3, "Search position");
        int r0 = this.currentHeader.length();
    L3:
        r3 = r3 + 1;
        if (r3 >= r0) goto L8;
        if (isTokenChar(this.currentHeader.charAt(r3)) == true) goto L3;
    L8:
        return r3;
    }

    protected boolean isWhitespace(char r1) {
        if (r1 != '\t') goto L5;
    L8:
        return true;
    L5:
        if (Character.isSpaceChar(r1) == true) goto L8;
        return false;
    }

    protected boolean isTokenChar(char r4) {
        if (Character.isLetterOrDigit(r4) == false) goto L6;
        return true;
    L6:
        if (Character.isISOControl(r4) == false) goto L9;
        return false;
    L9:
        if (isHttpSeparator(r4) == false) goto L11;
        return false;
    L11:
        return true;
    }

    protected boolean isHttpSeparator(char r1) {
        if (HTTP_SEPARATORS.indexOf(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }
}
