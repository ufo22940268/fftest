package me.biubiubiu.libraryff;

import android.content.Context;

/**
 * Created by ccheng on 7/15/14.
 */
public class ChapterResult {

    private String cmcc;
    private String cmccContent;
    private String cmccRm;
    private String smsTo;
    private String dxSmsto;
    private String ltSmsto;
    private String noCmccSmsto;
    private String noCmccContent;
    private String noCmccRm;

    public String getCmcc() {
        return cmcc;
    }

    public void setCmcc(String cmcc) {
        this.cmcc = cmcc;
    }

    public String getDxSmsto() {
        return dxSmsto;
    }

    public void setDxSmsto(String dxSmsto) {
        this.dxSmsto = dxSmsto;
    }

    public String getLtSmsto() {
        return ltSmsto;
    }

    public void setLtSmsto(String ltSmsto) {
        this.ltSmsto = ltSmsto;
    }

    public String getNoCmccSmsto() {
        return noCmccSmsto;
    }

    public void setNoCmccSmsto(String noCmccSmsto) {
        this.noCmccSmsto = noCmccSmsto;
    }

    public String getNoCmccContent() {
        return noCmccContent;
    }

    public void setNoCmccContent(String noCmccContent) {
        this.noCmccContent = noCmccContent;
    }

    public String getNoCmccRm() {
        return noCmccRm;
    }

    public void setNoCmccRm(String noCmccRm) {
        this.noCmccRm = noCmccRm;
    }

    //TODO
    public String selectRm(Context context) {
        return getNoCmccRm();
    }

    public String getSmsTo() {
        return smsTo;
    }

    public void setSmsTo(String smsTo) {
        this.smsTo = smsTo;
    }

    public String getCmccContent() {
        return cmccContent;
    }

    public void setCmccContent(String cmccContent) {
        this.cmccContent = cmccContent;
    }
}
