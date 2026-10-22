package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public class VGuideline extends Guideline {
    public VGuideline(String r3) {
        super(r3);
        this.type = new Helper.HelperType(typeMap.get(Helper.Type.VERTICAL_GUIDELINE));
    }

    public VGuideline(String r2, String r3) {
        super(r2);
        this.config = r3;
        this.type = new Helper.HelperType(typeMap.get(Helper.Type.VERTICAL_GUIDELINE));
        this.configMap = convertConfigToMap();
    }
}
