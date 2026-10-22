package com.bytedance.bdinstall.loader;

import com.bytedance.bdinstall.InstallOptions;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class CustomLoader extends BaseLoader {
    private final InstallOptions mOptions;

    CustomLoader(InstallOptions r3) {
        super(false, true);
        this.mOptions = r3;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r3) throws SecurityException {
        Map<String, Object> r2 = this.mOptions.getCommonHeader();
        if (r2 == null) goto L26;
    L14:
        e = move-exception;
        e.printStackTrace();
        return true;
    L5:
        if (r2.isEmpty() == true) goto L27;
        Iterator<Map.Entry<String, Object>> r4 = r2.entrySet().iterator();     // Catch: Exception -> L14
    L8:
        if (r4.hasNext() == false) goto L28;
        Map.Entry<String, Object> r0 = r4.next();     // Catch: Exception -> L14
        if (r0 == null) goto L8;
        r3.put(r0.getKey(), r0.getValue());     // Catch: Exception -> L14
        goto L8
    L28:
        return true;
    L27:
        return true;
    L26:
        return true;
    }
}
