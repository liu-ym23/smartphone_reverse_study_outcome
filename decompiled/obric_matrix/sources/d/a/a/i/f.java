package d.a.a.i;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static String a(int r0) {
        switch(r0) {
            case 1: goto L47;
            case 2: goto L45;
            case 3: goto L43;
            case 4: goto L41;
            case 5: goto L39;
            case 6: goto L37;
            case 7: goto L35;
            case 8: goto L33;
            case 9: goto L31;
            case 10: goto L29;
            case 11: goto L27;
            case 12: goto L25;
            case 13: goto L23;
            case 14: goto L21;
            case 15: goto L19;
            case 16: goto L17;
            case 17: goto L15;
            case 18: goto L13;
            case 19: goto L3;
            case 20: goto L11;
            case 21: goto L9;
            case 22: goto L7;
            case 23: goto L5;
            default: goto L3;
        };
    L3:
        return "Unknown";
    L5:
        return "undefined";
    L7:
        return "TreeSet";
    L9:
        return "Set";
    L11:
        return "EOF";
    L13:
        return "ident";
    L15:
        return ":";
    L17:
        return ",";
    L19:
        return "]";
    L21:
        return "[";
    L23:
        return "}";
    L25:
        return "{";
    L27:
        return ")";
    L29:
        return "(";
    L31:
        return "new";
    L33:
        return "null";
    L35:
        return "false";
    L37:
        return "true";
    L39:
        return "iso8601";
    L41:
        return TypedValues.Custom.S_STRING;
    L43:
        return TypedValues.Custom.S_FLOAT;
    L45:
        return "int";
    L47:
        return WsConstants.KEY_CONNECTION_ERROR;
    }
}
