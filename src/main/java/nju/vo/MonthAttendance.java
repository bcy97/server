package nju.vo;

import java.util.List;

/**
 * @Author Arthur
 * @Date 2019/10/23 15:02
 */

//月考勤
public class MonthAttendance {

    private String subsidiary;      //子公司
    private String relevantPeople;  //相关人
    private String auditor;         //批准人
    private String principal;       //审核人
    private String year;            //年份月份
    private List<String> datas;     //当月的考勤记录

    public MonthAttendance() {}

    public MonthAttendance(String subsidiary, String relevantPeople, String auditor,
                           String principal, String year, List<String> datas) {
        this.subsidiary = subsidiary;
        this.relevantPeople = relevantPeople;
        this.auditor = auditor;
        this.principal = principal;
        this.year = year;
        this.datas = datas;
    }

    public String getSubsidiary() {
        return subsidiary;
    }

    public void setSubsidiary(String subsidiary) {
        this.subsidiary = subsidiary;
    }

    public String getRelevantPeople() {
        return relevantPeople;
    }

    public void setRelevantPeople(String relevantPeople) {
        this.relevantPeople = relevantPeople;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getDatas() {
        return datas;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
    }
}
