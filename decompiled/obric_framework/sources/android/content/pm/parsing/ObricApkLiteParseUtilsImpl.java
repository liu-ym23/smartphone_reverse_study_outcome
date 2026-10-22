package android.content.pm.parsing;

import android.content.res.XmlResourceParser;
import com.obric.internal.app.ObricAssistUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ObricApkLiteParseUtilsImpl implements IObricApkLiteParseUtils {
    private static final String ANDROID_ACTION = "action";
    private static final String ANDROID_INTENT_FILTER = "intent-filter";
    private static final String ANDROID_NAME = "name";
    private static final String ANDROID_RES_NAMESPACE = "http://schemas.android.com/apk/res/android";

    public ObricApkLiteParseUtilsImpl() {
    }

    public boolean isFilteredAssistantService(XmlResourceParser parser, String packageName, boolean currentHasFilteredService) {
        if (ObricAssistUtils.APP_FILTER.containsKey(packageName) == false) goto L8;
        if (currentHasFilteredService == true) goto L8;
        return isFilteredServiceInner(parser, (String) ObricAssistUtils.APP_FILTER.get(packageName));
    L8:
        return currentHasFilteredService;
    }

    private boolean isFilteredServiceInner(XmlResourceParser parser, String filter) throws XmlPullParserException, IOException {
        boolean hasFilteredService = false;
        int depth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L35;
        if (type == 3) goto L8;
    L9:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        if (parser.getDepth() != (depth + 1)) goto L3;
        if (ANDROID_INTENT_FILTER.equals(parser.getName()) == false) goto L3;
        int innerDepth = parser.getDepth();
    L19:
        int innerType = parser.next();
        if (innerType == 1) goto L3;
        if (innerType == 3) goto L23;
    L24:
        if (innerType == 3) goto L19;
        if (innerType == 4) goto L19;
        if (parser.getDepth() != (innerDepth + 1)) goto L19;
        if (hasFilteredService == true) goto L19;
        if (ANDROID_ACTION.equals(parser.getName()) == false) goto L19;
        String name = parser.getAttributeValue(ANDROID_RES_NAMESPACE, ANDROID_NAME);
        hasFilteredService = filter.equals(name);
        goto L19
    L23:
        if (parser.getDepth() <= innerDepth) goto L3;
    L8:
        if (parser.getDepth() > depth) goto L9;
    L35:
        return hasFilteredService;
    }
}
