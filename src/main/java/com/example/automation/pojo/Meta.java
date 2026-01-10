package com.example.automation.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Meta {
    @JsonProperty("docs_url")
    private String docsUrl;
    private List<String> features;
    @JsonProperty("powered_by")
    private String poweredBy;
    @JsonProperty("template_gallery")
    private String templateGallery;
    private String message;
    @JsonProperty("upgrade_url")
    private String upgradeUrl;
    @JsonProperty("upgrade_cta")
    private String upgradeCta;

    public String getDocsUrl() {
        return docsUrl;
    }

    public void setDocsUrl(String docsUrl) {
        this.docsUrl = docsUrl;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public String getPoweredBy() {
        return poweredBy;
    }

    public void setPoweredBy(String poweredBy) {
        this.poweredBy = poweredBy;
    }

    public String getTemplateGallery() {
        return templateGallery;
    }

    public void setTemplateGallery(String templateGallery) {
        this.templateGallery = templateGallery;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUpgradeUrl() {
        return upgradeUrl;
    }

    public void setUpgradeUrl(String upgradeUrl) {
        this.upgradeUrl = upgradeUrl;
    }

    public String getUpgradeCta() {
        return upgradeCta;
    }

    public void setUpgradeCta(String upgradeCta) {
        this.upgradeCta = upgradeCta;
    }
}