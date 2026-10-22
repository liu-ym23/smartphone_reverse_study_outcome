package com.android.setupwizardlib.items;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class SimpleInflater<T> {
    private static final boolean DEBUG = false;
    private static final String TAG = "SimpleInflater";
    protected final Resources mResources;

    protected abstract void onAddChildItem(T r1, T r2);

    protected abstract T onCreateItem(String r1, AttributeSet r2);

    protected boolean onInterceptCreateItem(XmlPullParser r1, T r2, AttributeSet r3) throws XmlPullParserException {
        return false;
    }

    protected SimpleInflater(Resources r1) {
        this.mResources = r1;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public T inflate(int r2) {
        XmlResourceParser r3 = getResources().getXml(r2);
        T r1 = inflate(r3);     // Catch: Throwable -> L6
        r3.close();
        return r1;
    L6:
        th = move-exception;
        r3.close();
        throw th;
    }

    public T inflate(XmlPullParser r5) {
        AttributeSet r0 = Xml.asAttributeSet(r5);
    L19:
        int r1 = r5.next();     // Catch: IOException -> L13 XmlPullParserException -> L16
        if (r1 == 2) goto L8;
        if (r1 != 1) goto L19;
    L8:
        if (r1 != 2) goto L12;
        T r2 = createItemFromTag(r5.getName(), r0);     // Catch: IOException -> L13 XmlPullParserException -> L16
        rInflate(r5, r2, r0);     // Catch: IOException -> L13 XmlPullParserException -> L16
        return r2;
    L12:
        throw new InflateException(r5.getPositionDescription() + ": No start tag found!");     // Catch: IOException -> L13 XmlPullParserException -> L16
    L13:
        e = move-exception;
        throw new InflateException(r5.getPositionDescription() + ": " + e.getMessage(), e);
    L16:
        e = move-exception;
        throw new InflateException(e.getMessage(), e);
    }

    private T createItemFromTag(String r3, AttributeSet r4) {
        return onCreateItem(r3, r4);
    L7:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        throw new InflateException(r4.getPositionDescription() + ": Error inflating class " + r3, e);
    }

    private void rInflate(XmlPullParser r4, T r5, AttributeSet r6) throws XmlPullParserException, IOException {
        int r0 = r4.getDepth();
    L3:
        int r1 = r4.next();
        if (r1 != 3) goto L8;
        if (r4.getDepth() > r0) goto L8;
        return;
    L8:
        if (r1 == 1) goto L25;
        if (r1 != 2) goto L3;
        if (onInterceptCreateItem(r4, r5, r6) == true) goto L3;
        T r2 = createItemFromTag(r4.getName(), r6);
        onAddChildItem(r5, r2);
        rInflate(r4, r2, r6);
        goto L3
    }
}
