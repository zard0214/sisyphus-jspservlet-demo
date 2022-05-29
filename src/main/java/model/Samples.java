package model;


import java.util.Date;

/**
 * @author zard
 * @date Created in 27/05/2022 01:50
 */
public class Samples {

    private Integer id;
    private String tubeNumber;
    private String gmtCreatedStr;
    private String gmtModifiedStr;
    private Date gmtCreated;
    private Date gmtModified;
    private Integer result; //0 1 "阴性" 2 "阳性"
    private String resultStr; //0 1 2
    private String userIds;

    public Samples() {

    }

    public Samples(String tubeNumber, String gmtCreatedStr, String gmtModifiedStr, String resultStr) {
        this.tubeNumber = tubeNumber;
        this.gmtModifiedStr = gmtModifiedStr;
        this.gmtCreatedStr = gmtCreatedStr;
        this.resultStr = resultStr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTubeNumber() {
        return tubeNumber;
    }

    public void setTubeNumber(String tubeNumber) {
        this.tubeNumber = tubeNumber;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    public String getResultStr() {
        return resultStr;
    }

    public void setResultStr(String resultStr) {
        this.resultStr = resultStr;
    }

    public String getGmtCreatedStr() {
        return gmtCreatedStr;
    }

    public void setGmtCreatedStr(String gmtCreatedStr) {
        this.gmtCreatedStr = gmtCreatedStr;
    }

    public String getGmtModifiedStr() {
        return gmtModifiedStr;
    }

    public void setGmtModifiedStr(String gmtModifiedStr) {
        this.gmtModifiedStr = gmtModifiedStr;
    }

    @Override
    public String toString() {
        return "Samples{" +
                "id=" + id +
                ", tubeNumber='" + tubeNumber + '\'' +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                ", result=" + result +
                ", userIds='" + userIds + '\'' +
                '}';
    }
}
