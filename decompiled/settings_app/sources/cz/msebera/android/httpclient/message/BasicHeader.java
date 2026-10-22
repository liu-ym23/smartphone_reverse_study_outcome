package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.util.Args;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHeader implements Header, Cloneable, Serializable {
    private static final HeaderElement[] EMPTY_HEADER_ELEMENTS = null;
    private static final long serialVersionUID = -5427236326487562174L;
    private final String name;
    private final String value;

    static {
        EMPTY_HEADER_ELEMENTS = new HeaderElement[0];
    }

    public BasicHeader(String r2, String r3) {
        this.name = (String) Args.notNull(r2, "Name");
        this.value = r3;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // cz.msebera.android.httpclient.Header
    public HeaderElement[] getElements() throws ParseException {
        if (getValue() == null) goto L7;
        return BasicHeaderValueParser.parseElements(getValue(), null);
    L7:
        return EMPTY_HEADER_ELEMENTS;
    }

    @Override // cz.msebera.android.httpclient.NameValuePair
    public String getName() {
        return this.name;
    }

    @Override // cz.msebera.android.httpclient.NameValuePair
    public String getValue() {
        return this.value;
    }

    public String toString() {
        return BasicLineFormatter.INSTANCE.formatHeader(null, this).toString();
    }
}
