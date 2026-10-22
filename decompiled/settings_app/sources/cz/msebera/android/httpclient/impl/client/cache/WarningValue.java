package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
class WarningValue {
    private static final String ASCTIME_DATE = "(Mon|Tue|Wed|Thu|Fri|Sat|Sun) ((Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d) (\\d{2}:\\d{2}:\\d{2}) \\d{4}";
    private static final String DATE1 = "\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}";
    private static final String DATE2 = "\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}";
    private static final String DATE3 = "(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d";
    private static final String DOMAINLABEL = "\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?";
    private static final String HOST = "((\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?\\.)*\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?\\.?)|(\\d+\\.\\d+\\.\\d+\\.\\d+)";
    private static final String HOSTNAME = "(\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?\\.)*\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?\\.?";
    private static final String HOSTPORT = "(((\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?\\.)*\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?\\.?)|(\\d+\\.\\d+\\.\\d+\\.\\d+))(\\:\\d*)?";
    private static final Pattern HOSTPORT_PATTERN = null;
    private static final String HTTP_DATE = "((Mon|Tue|Wed|Thu|Fri|Sat|Sun), (\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Mon|Tue|Wed|Thu|Fri|Sat|Sun) ((Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d) (\\d{2}:\\d{2}:\\d{2}) \\d{4})";
    private static final String IPV4ADDRESS = "\\d+\\.\\d+\\.\\d+\\.\\d+";
    private static final String MONTH = "Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec";
    private static final String PORT = "\\d*";
    private static final String RFC1123_DATE = "(Mon|Tue|Wed|Thu|Fri|Sat|Sun), (\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}) (\\d{2}:\\d{2}:\\d{2}) GMT";
    private static final String RFC850_DATE = "(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}) (\\d{2}:\\d{2}:\\d{2}) GMT";
    private static final String TIME = "\\d{2}:\\d{2}:\\d{2}";
    private static final String TOPLABEL = "\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?";
    private static final String WARN_DATE = "\"(((Mon|Tue|Wed|Thu|Fri|Sat|Sun), (\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Mon|Tue|Wed|Thu|Fri|Sat|Sun) ((Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d) (\\d{2}:\\d{2}:\\d{2}) \\d{4}))\"";
    private static final Pattern WARN_DATE_PATTERN = null;
    private static final String WEEKDAY = "Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday";
    private static final String WKDAY = "Mon|Tue|Wed|Thu|Fri|Sat|Sun";
    private int init_offs;
    private int offs;
    private final String src;
    private String warnAgent;
    private int warnCode;
    private Date warnDate;
    private String warnText;

    private boolean isChar(char r1) {
        if (r1 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 > 127) goto L6;
        return true;
    }

    private boolean isControl(char r1) {
        if (r1 == 127) goto L9;
        if (r1 >= 0) goto L6;
    L8:
        return false;
    L6:
        if (r1 > 31) goto L8;
    L9:
        return true;
    }

    private boolean isSeparator(char r1) {
        if (r1 != '(') goto L5;
    L42:
        return true;
    L5:
        if (r1 == ')') goto L42;
        if (r1 == '<') goto L42;
        if (r1 == '>') goto L42;
        if (r1 == '@') goto L42;
        if (r1 == ',') goto L42;
        if (r1 == ';') goto L42;
        if (r1 == ':') goto L42;
        if (r1 == '\\') goto L42;
        if (r1 == '\"') goto L42;
        if (r1 == '/') goto L42;
        if (r1 == '[') goto L42;
        if (r1 == ']') goto L42;
        if (r1 == '?') goto L42;
        if (r1 == '=') goto L42;
        if (r1 == '{') goto L42;
        if (r1 == '}') goto L42;
        if (r1 == ' ') goto L42;
        if (r1 == '\t') goto L42;
        return false;
    }

    WarningValue(String r2) {
        this(r2, 0);
    }

    WarningValue(String r1, int r2) {
        this.init_offs = r2;
        this.offs = r2;
        this.src = r1;
        consumeWarnValue();
    }

    public static WarningValue[] getWarningValues(Header r4) {
        ArrayList r0 = new ArrayList();
        String r5 = r4.getValue();
        int r2 = 0;
    L4:
        if (r2 >= r5.length()) goto L12;
        WarningValue r3 = new WarningValue(r5, r2);     // Catch: IllegalArgumentException -> L7
        r0.add(r3);     // Catch: IllegalArgumentException -> L7
        r2 = r3.offs;     // Catch: IllegalArgumentException -> L7
    L7:
        int r6 = r5.indexOf(44, r2);
        if (r6 == (-1)) goto L12;
        r2 = r6 + 1;
    L12:
        return (WarningValue[]) r0.toArray(new WarningValue[0]);
    }

    protected void consumeLinearWhitespace() {
    L3:
        if (this.offs >= this.src.length()) goto L22;
        char r0 = this.src.charAt(this.offs);
        if (r0 == '\t') goto L21;
        if (r0 == '\r') goto L11;
        if (r0 == ' ') goto L21;
        return;
    L11:
        if ((this.offs + 2) >= this.src.length()) goto L20;
        if (this.src.charAt(this.offs + 1) != '\n') goto L31;
        if (this.src.charAt(this.offs + 2) != ' ') goto L17;
    L19:
        this.offs += 2;
        goto L21
    L17:
        if (this.src.charAt(this.offs + 2) == '\t') goto L19;
        return;
    L31:
        return;
    L20:
        return;
    L21:
        this.offs++;
        goto L3
    }

    protected void consumeToken() {
        if (isTokenChar(this.src.charAt(this.offs)) == true) goto L6;
        parseError();
    L6:
        if (this.offs >= this.src.length()) goto L11;
        if (isTokenChar(this.src.charAt(this.offs)) == false) goto L15;
        this.offs++;
        goto L6
    L15:
        return;
    }

    private boolean isTokenChar(char r2) {
        if (isChar(r2) == true) goto L5;
    L9:
        return false;
    L5:
        if (isControl(r2) == true) goto L9;
        if (isSeparator(r2) == true) goto L9;
        return true;
    }

    static {
        HOSTPORT_PATTERN = Pattern.compile(HOSTPORT);
        WARN_DATE_PATTERN = Pattern.compile(WARN_DATE);
    }

    protected void consumeHostPort() {
        Matcher r0 = HOSTPORT_PATTERN.matcher(this.src.substring(this.offs));
        if (r0.find() == true) goto L6;
        parseError();
    L6:
        if (r0.start() == 0) goto L8;
        parseError();
    L8:
        this.offs += r0.end();
    }

    protected void consumeWarnAgent() {
        int r0 = this.offs;
        consumeHostPort();     // Catch: IllegalArgumentException -> L5
        this.warnAgent = this.src.substring(r0, this.offs);     // Catch: IllegalArgumentException -> L5
        consumeCharacter(TokenParser.SP);     // Catch: IllegalArgumentException -> L5
        return;
    L5:
        this.offs = r0;
        consumeToken();
        this.warnAgent = this.src.substring(r0, this.offs);
        consumeCharacter(TokenParser.SP);
    }

    protected void consumeQuotedString() {
        if (this.src.charAt(this.offs) == '\"') goto L5;
        parseError();
    L5:
        this.offs++;
        boolean r0 = false;
    L7:
        if (this.offs >= this.src.length()) goto L23;
        if (r0 == true) goto L23;
        char r3 = this.src.charAt(this.offs);
        if ((this.offs + 1) >= this.src.length()) goto L16;
        if (r3 != '\\') goto L16;
        if (isChar(this.src.charAt(this.offs + 1)) == false) goto L16;
        this.offs += 2;
    L16:
        if (r3 == '\"') goto L17;
        if (r3 == '\"') goto L22;
        if (isControl(r3) == true) goto L22;
        this.offs++;
    L22:
        parseError();
        goto L7
    L17:
        this.offs++;
        r0 = true;
    L23:
        if (r0 == true) goto L42;
        parseError();
        return;
    }

    protected void consumeWarnText() {
        int r0 = this.offs;
        consumeQuotedString();
        this.warnText = this.src.substring(r0, this.offs);
    }

    protected void consumeWarnDate() {
        int r0 = this.offs;
        Matcher r1 = WARN_DATE_PATTERN.matcher(this.src.substring(r0));
        if (r1.lookingAt() == true) goto L5;
        parseError();
    L5:
        int r2 = this.offs + r1.end();
        this.offs = r2;
        this.warnDate = DateUtils.parseDate(this.src.substring(r0 + 1, r2 - 1));
    }

    protected void consumeWarnValue() {
        consumeLinearWhitespace();
        consumeWarnCode();
        consumeWarnAgent();
        consumeWarnText();
        if ((this.offs + 1) < this.src.length()) goto L5;
    L9:
        consumeLinearWhitespace();
        if (this.offs == this.src.length()) goto L13;
        consumeCharacter(',');
        return;
    L13:
        return;
    L5:
        if (this.src.charAt(this.offs) != ' ') goto L9;
        if (this.src.charAt(this.offs + 1) != '\"') goto L9;
        consumeCharacter(TokenParser.SP);
        consumeWarnDate();
        goto L9
    }

    protected void consumeCharacter(char r3) {
        if ((this.offs + 1) <= this.src.length()) goto L5;
    L6:
        parseError();
    L7:
        this.offs++;
        return;
    L5:
        if (r3 == this.src.charAt(this.offs)) goto L7;
        goto L6
    }

    protected void consumeWarnCode() {
        if ((this.offs + 4) <= this.src.length()) goto L5;
    L12:
        parseError();
    L13:
        String r0 = this.src;
        int r1 = this.offs;
        this.warnCode = Integer.parseInt(r0.substring(r1, r1 + 3));
        this.offs += 4;
        return;
    L5:
        if (Character.isDigit(this.src.charAt(this.offs)) == false) goto L12;
        if (Character.isDigit(this.src.charAt(this.offs + 1)) == false) goto L12;
        if (Character.isDigit(this.src.charAt(this.offs + 2)) == false) goto L12;
        if (this.src.charAt(this.offs + 3) == ' ') goto L13;
        goto L12
    }

    private void parseError() {
        throw new IllegalArgumentException("Bad warn code \"" + this.src.substring(this.init_offs) + "\"");
    }

    public int getWarnCode() {
        return this.warnCode;
    }

    public String getWarnAgent() {
        return this.warnAgent;
    }

    public String getWarnText() {
        return this.warnText;
    }

    public Date getWarnDate() {
        return this.warnDate;
    }

    public String toString() {
        if (this.warnDate == null) goto L7;
        return String.format("%d %s %s \"%s\"", new Object[]{Integer.valueOf(this.warnCode), this.warnAgent, this.warnText, DateUtils.formatDate(this.warnDate)});
    L7:
        return String.format("%d %s %s", new Object[]{Integer.valueOf(this.warnCode), this.warnAgent, this.warnText});
    }
}
