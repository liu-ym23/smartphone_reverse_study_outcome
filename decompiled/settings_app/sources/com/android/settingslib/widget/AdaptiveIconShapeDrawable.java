package com.android.settingslib.widget;

import android.R;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.util.AttributeSet;
import android.util.PathParser;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class AdaptiveIconShapeDrawable extends ShapeDrawable {
    public AdaptiveIconShapeDrawable() {
    }

    public AdaptiveIconShapeDrawable(Resources r1) {
        init(r1);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void inflate(Resources r1, XmlPullParser r2, AttributeSet r3, Resources.Theme r4) throws XmlPullParserException, IOException {
        super.inflate(r1, r2, r3, r4);
        init(r1);
    }

    private void init(Resources r3) {
        setShape(new PathShape(new Path(PathParser.createPathFromPathData(r3.getString(R.string.config_mobile_hotspot_provision_app_no_ui))), 100.0f, 100.0f));
    }
}
