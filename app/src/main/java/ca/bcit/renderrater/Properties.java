package ca.bcit.renderrater;

import java.io.Serializable;

public class Properties implements Serializable {


    private String BLDGNAM;
    private int BLDG_ID;
    private int MAPREF;
    private int NUM_RES;
    private String NgbrNam;
    private String Ngbrhood;
    private String STRNAM;
    private String STRNUM;
    private String X;
    private String Y;

    public String getBLDGNAM() {
        return BLDGNAM;
    }

    public void setBLDGNAM(String BLDGNAM) {
        this.BLDGNAM = BLDGNAM;
    }

    public int getBLDG_ID() {
        return BLDG_ID;
    }

    public void setBLDG_ID(int BLDG_ID) {
        this.BLDG_ID = BLDG_ID;
    }

    public int getMAPREF() {
        return MAPREF;
    }

    public void setMAPREF(int MAPREF) {
        this.MAPREF = MAPREF;
    }

    public int getNUM_RES() {
        return NUM_RES;
    }

    public void setNUM_RES(int NUM_RES) {
        this.NUM_RES = NUM_RES;
    }

    public String getNgbrNam() {
        return NgbrNam;
    }

    public void setNgbrNam(String ngbrNam) {
        NgbrNam = ngbrNam;
    }

    public String getNgbrhood() {
        return Ngbrhood;
    }

    public void setNgbrhood(String ngbrhood) {
        Ngbrhood = ngbrhood;
    }

    public String getSTRNAM() {
        return STRNAM;
    }

    public void setSTRNAM(String STRNAM) {
        this.STRNAM = STRNAM;
    }

    public String getSTRNUM() {
        return STRNUM;
    }

    public void setSTRNUM(String STRNUM) {
        this.STRNUM = STRNUM;
    }

    public String getX() {
        return X;
    }

    public void setX(String x) {
        X = x;
    }

    public String getY() {
        return Y;
    }

    public void setY(String y) {
        Y = y;
    }
}
