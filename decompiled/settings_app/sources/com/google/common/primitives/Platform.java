package com.google.common.primitives;

import com.google.common.base.Strings;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class Platform {
    private static final Logger logger = null;

    static {
        logger = Logger.getLogger(Platform.class.getName());
    }

    static void checkGwtRpcEnabled() {
        if (Boolean.parseBoolean(System.getProperty("guava.gwt.emergency_reenable_rpc", "false")) == false) goto L7;
        logger.log(Level.WARNING, "Later in 2020, we will remove GWT-RPC support for Guava types. You are seeing this warning because you are sending a Guava type over GWT-RPC, which will break. You can identify which type by looking at the class name in the attached stack trace.", new Throwable());
        return;
    L7:
        throw new UnsupportedOperationException(Strings.lenientFormat("We are removing GWT-RPC support for Guava types. You can temporarily reenable support by setting the system property %s to true. For more about system properties, see %s. For more about Guava's GWT-RPC support, see %s.", new Object[]{"guava.gwt.emergency_reenable_rpc", "https://stackoverflow.com/q/5189914/28465", "https://groups.google.com/d/msg/guava-announce/zHZTFg7YF3o/rQNnwdHeEwAJ"}));
    }

    private Platform() {
    }
}
