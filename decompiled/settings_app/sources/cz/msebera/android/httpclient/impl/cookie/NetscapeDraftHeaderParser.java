package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.message.BasicHeaderElement;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.message.TokenParser;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.BitSet;

/* JADX INFO: loaded from: classes5.dex */
public class NetscapeDraftHeaderParser {
    public static final NetscapeDraftHeaderParser DEFAULT = null;
    private static final char PARAM_DELIMITER = ';';
    private static final BitSet TOKEN_DELIMS = null;
    private static final BitSet VALUE_DELIMS = null;
    private final TokenParser tokenParser;

    static {
        DEFAULT = new NetscapeDraftHeaderParser();
        TOKEN_DELIMS = TokenParser.INIT_BITSET(new int[]{61, 59});
        VALUE_DELIMS = TokenParser.INIT_BITSET(new int[]{59});
    }

    public NetscapeDraftHeaderParser() {
        this.tokenParser = TokenParser.INSTANCE;
    }

    public HeaderElement parseHeader(CharArrayBuffer r4, ParserCursor r5) throws ParseException {
        Args.notNull(r4, "Char array buffer");
        Args.notNull(r5, "Parser cursor");
        NameValuePair r0 = parseNameValuePair(r4, r5);
        ArrayList r1 = new ArrayList();
    L4:
        if (r5.atEnd() == true) goto L7;
        r1.add(parseNameValuePair(r4, r5));
        goto L4
    L7:
        return new BasicHeaderElement(r0.getName(), r0.getValue(), (NameValuePair[]) r1.toArray(new NameValuePair[r1.size()]));
    }

    private NameValuePair parseNameValuePair(CharArrayBuffer r5, ParserCursor r6) {
        String r0 = this.tokenParser.parseToken(r5, r6, TOKEN_DELIMS);
        if (r6.atEnd() == true) goto L5;
        char r1 = r5.charAt(r6.getPos());
        r6.updatePos(r6.getPos() + 1);
        if (r1 != '=') goto L9;
        String r4 = this.tokenParser.parseToken(r5, r6, VALUE_DELIMS);
        if (r6.atEnd() == true) goto L14;
        r6.updatePos(r6.getPos() + 1);
    L14:
        return new BasicNameValuePair(r0, r4);
    L9:
        return new BasicNameValuePair(r0, null);
    L5:
        return new BasicNameValuePair(r0, null);
    }
}
