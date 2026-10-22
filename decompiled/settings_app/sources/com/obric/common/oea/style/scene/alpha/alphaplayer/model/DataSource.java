package com.obric.common.oea.style.scene.alpha.alphaplayer.model;

import android.text.TextUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\nJ\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0012J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016¨\u0006("}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/DataSource;", "", "()V", "baseDir", "", "getBaseDir", "()Ljava/lang/String;", "setBaseDir", "(Ljava/lang/String;)V", "isLooping", "", "()Z", "setLooping", "(Z)V", "landPath", "getLandPath", "setLandPath", "landScaleType", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "getLandScaleType", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "setLandScaleType", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;)V", "portPath", "getPortPath", "setPortPath", "portScaleType", "getPortScaleType", "setPortScaleType", "getPath", "orientation", "", "getScaleType", "isValid", "setLandscapePath", "landscapePath", "landscapeScaleType", "setPortraitPath", "portraitPath", "portraitScaleType", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class DataSource {
    public String baseDir;
    private boolean isLooping;
    public String landPath;
    private ScaleType landScaleType;
    public String portPath;
    private ScaleType portScaleType;

    public DataSource() {
    }

    public final String getBaseDir() {
        String r1 = this.baseDir;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("baseDir");
    L5:
        return r1;
    }

    /* JADX INFO: renamed from: setBaseDir, reason: collision with other method in class */
    public final void m1006setBaseDir(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.baseDir = r2;
    }

    public final String getPortPath() {
        String r1 = this.portPath;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("portPath");
    L5:
        return r1;
    }

    public final void setPortPath(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.portPath = r2;
    }

    public final String getLandPath() {
        String r1 = this.landPath;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("landPath");
    L5:
        return r1;
    }

    public final void setLandPath(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.landPath = r2;
    }

    public final ScaleType getPortScaleType() {
        return this.portScaleType;
    }

    public final void setPortScaleType(ScaleType r1) {
        this.portScaleType = r1;
    }

    public final ScaleType getLandScaleType() {
        return this.landScaleType;
    }

    public final void setLandScaleType(ScaleType r1) {
        this.landScaleType = r1;
    }

    public final boolean isLooping() {
        return this.isLooping;
    }

    /* JADX INFO: renamed from: setLooping, reason: collision with other method in class */
    public final void m1007setLooping(boolean r1) {
        this.isLooping = r1;
    }

    public final DataSource setBaseDir(String r5) {
        Intrinsics.checkNotNullParameter(r5, "baseDir");
        String r0 = File.separator;
        Intrinsics.checkNotNullExpressionValue(r0, "File.separator");
        if (StringsKt.endsWith$default(r5, r0, false, 2, null) == true) goto L6;
        r5 = r5 + File.separator;
    L6:
        this.baseDir = r5;
        return this;
    }

    public final DataSource setPortraitPath(String r2, ScaleType r3) {
        Intrinsics.checkNotNullParameter(r2, "portraitPath");
        Intrinsics.checkNotNullParameter(r3, "portraitScaleType");
        this.portPath = r2;
        this.portScaleType = r3;
        return this;
    }

    public final DataSource setLandscapePath(String r2, ScaleType r3) {
        Intrinsics.checkNotNullParameter(r2, "landscapePath");
        Intrinsics.checkNotNullParameter(r3, "landscapeScaleType");
        this.landPath = r2;
        this.landScaleType = r3;
        return this;
    }

    public final DataSource setLooping(boolean r1) {
        this.isLooping = r1;
        return this;
    }

    public final String getPath(int r4) {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.baseDir;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("baseDir");
    L5:
        StringBuilder r2 = r0.append(r1);
        if (1 != r4) goto L11;
        String r3 = this.portPath;
        if (r3 != null) goto L15;
        String r5 = "portPath";
    L10:
        Intrinsics.throwUninitializedPropertyAccessException(r5);
    L15:
        return r2.append(r3).toString();
    L11:
        r3 = this.landPath;
        if (r3 != null) goto L15;
        r5 = "landPath";
        goto L10
    }

    public final ScaleType getScaleType(int r2) {
        if (1 != r2) goto L6;
        return this.portScaleType;
    L6:
        return this.landScaleType;
    }

    public final boolean isValid() {
        String r0 = this.portPath;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("portPath");
    L6:
        if (TextUtils.isEmpty(r0) == true) goto L17;
        String r1 = this.landPath;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("landPath");
    L11:
        if (TextUtils.isEmpty(r1) == true) goto L17;
        if (this.portScaleType == null) goto L17;
        if (this.landScaleType == null) goto L17;
        return true;
    L17:
        return false;
    }
}
