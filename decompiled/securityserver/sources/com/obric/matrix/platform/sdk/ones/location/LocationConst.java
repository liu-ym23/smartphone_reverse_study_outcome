package com.obric.matrix.platform.sdk.ones.location;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class LocationConst {

    @NotNull
    public static final LocationConst INSTANCE = null;

    @NotNull
    public static final String PATH_LOCATION_STATUS = "/location/status";

    static {
        INSTANCE = new LocationConst();
    }

    private LocationConst() {
    }
}
