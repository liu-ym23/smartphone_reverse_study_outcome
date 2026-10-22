package com.obric.security.cleaner;

import java.util.List;
import tmsdk.fg.module.cleanV2.RubbishEntity;

/* JADX INFO: loaded from: classes4.dex */
public class CustomRubbishEntity extends RubbishEntity {
    private String appName;
    private String description;
    private boolean isSuggest;
    private int rubbishType;
    private long size;

    @Override // tmsdk.fg.module.cleanV2.RubbishEntity
    public String getDescription() {
        return this.description;
    }

    @Override // tmsdk.fg.module.cleanV2.RubbishEntity
    public String getAppName() {
        return this.appName;
    }

    @Override // tmsdk.fg.module.cleanV2.RubbishEntity
    public long getSize() {
        return this.size;
    }

    @Override // tmsdk.fg.module.cleanV2.RubbishEntity
    public boolean isSuggest() {
        return super.isSuggest();
    }

    @Override // tmsdk.fg.module.cleanV2.RubbishEntity
    public int getRubbishType() {
        return this.rubbishType;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRubbishType(int rubbishType) {
        this.rubbishType = rubbishType;
    }

    public void setSuggest(boolean suggest) {
        this.isSuggest = suggest;
    }

    public CustomRubbishEntity() {
        super(0, "", true, 0, "", "", "");
        this.size = 0;
        this.appName = "";
        this.description = "";
        this.rubbishType = -1;
        this.isSuggest = false;
    }

    public CustomRubbishEntity(int rubbishType, List<String> var2, boolean isSuggest, long size, String appName, String packageName, String description) {
        super(rubbishType, var2, isSuggest, size, appName, packageName, "");
        this.size = 0;
        this.appName = "";
        this.description = "";
        this.rubbishType = -1;
        this.isSuggest = false;
    }
}
