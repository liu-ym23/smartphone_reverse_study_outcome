package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import java.io.PrintStream;

/* JADX INFO: loaded from: classes.dex */
public class KeyParser {

    private interface DataType {
        int get(int r1);
    }

    private interface Ids {
        int get(String r1);
    }

    public KeyParser() {
    }

    public static void main(String[] r0) {
        parseAttributes("{frame:22,\ntarget:'widget1',\neasing:'easeIn',\ncurveFit:'spline',\nprogress:0.3,\nalpha:0.2,\nelevation:0.7,\nrotationZ:23,\nrotationX:25.0,\nrotationY:27.0,\npivotX:15,\npivotY:17,\npivotTarget:'32',\npathRotate:23,\nscaleX:0.5,\nscaleY:0.7,\ntranslationX:5,\ntranslationY:7,\ntranslationZ:11,\n}");
    }

    private static TypedBundle parse(String r9, Ids r10, DataType r11) {
        TypedBundle r0 = new TypedBundle();
        CLObject r12 = CLParser.parse(r9);     // Catch: CLParsingException -> L24
        int r1 = r12.size();     // Catch: CLParsingException -> L24
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L26;
        CLKey r3 = (CLKey) r12.get(r2);     // Catch: CLParsingException -> L24
        String r4 = r3.content();     // Catch: CLParsingException -> L24
        CLElement r5 = r3.getValue();     // Catch: CLParsingException -> L24
        int r6 = r10.get(r4);     // Catch: CLParsingException -> L24
        if (r6 != (-1)) goto L8;
        System.err.println("unknown type " + r4);     // Catch: CLParsingException -> L24
    L23:
        r2 = r2 + 1;
        goto L4
    L8:
        int r7 = r11.get(r6);     // Catch: CLParsingException -> L24
        if (r7 != 1) goto L12;
        r0.add(r6, r12.getBoolean(r2));     // Catch: CLParsingException -> L24
        goto L23
    L12:
        if (r7 != 2) goto L14;
        r0.add(r6, r5.getInt());     // Catch: CLParsingException -> L24
        PrintStream r8 = System.out;     // Catch: CLParsingException -> L24
        String r13 = "parse " + r4 + " INT_MASK > " + r5.getInt();     // Catch: CLParsingException -> L24
    L19:
        r8.println(r13);     // Catch: CLParsingException -> L24
        goto L23
    L14:
        if (r7 != 4) goto L16;
        r0.add(r6, r5.getFloat());     // Catch: CLParsingException -> L24
        r8 = System.out;     // Catch: CLParsingException -> L24
        r13 = "parse " + r4 + " FLOAT_MASK > " + r5.getFloat();     // Catch: CLParsingException -> L24
        goto L19
    L16:
        if (r7 != 8) goto L23;
        r0.add(r6, r5.content());     // Catch: CLParsingException -> L24
        r8 = System.out;     // Catch: CLParsingException -> L24
        r13 = "parse " + r4 + " STRING_MASK > " + r5.content();     // Catch: CLParsingException -> L24
    L26:
        return r0;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }

    public static TypedBundle parseAttributes(String r2) {
        return parse(r2, b.f247a, a.f246a);
    }
}
