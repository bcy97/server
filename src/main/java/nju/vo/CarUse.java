package nju.vo;

/**
 * @Author Arthur
 * @Date 2019/10/23 14:46
 */

//车辆使用
public class CarUse {

    private String id;              //id(MongoDB生成的ID)
    private String subsidiary;      //所属子公司
    private String carNo;           //车牌号
    private String date;            //用车时间
    private int startMileage;       //起始里程
    private int endMileage;         //终止里程
    private int useMileage;         //使用里程
    private String useReason;       //用车事由
    //    private boolean isPrivateUse;   //因私用车
    private boolean privateUse;
    private String user;            //使用人
    private String ratify;          //批准人

    public CarUse() {}

    public CarUse(String id, String subsidiary, String carNo, String date, int startMileage,
                  int endMileage, int useMileage, String useReason,
                  boolean privateUse, String user, String ratify) {
        this.id = id;
        this.subsidiary = subsidiary;
        this.carNo = carNo;
        this.date = date;
        this.startMileage = startMileage;
        this.endMileage = endMileage;
        this.useMileage = useMileage;
        this.useReason = useReason;
//        this.isPrivateUse = isPrivateUse;
        this.privateUse = privateUse;
        this.user = user;
        this.ratify = ratify;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubsidiary() {
        return subsidiary;
    }

    public void setSubsidiary(String subsidiary) {
        this.subsidiary = subsidiary;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStartMileage() {
        return startMileage;
    }

    public void setStartMileage(int startMileage) {
        this.startMileage = startMileage;
    }

    public int getEndMileage() {
        return endMileage;
    }

    public void setEndMileage(int endMileage) {
        this.endMileage = endMileage;
    }

    public int getUseMileage() {
        return useMileage;
    }

    public void setUseMileage(int useMileage) {
        this.useMileage = useMileage;
    }

    public String getUseReason() {
        return useReason;
    }

    public void setUseReason(String useReason) {
        this.useReason = useReason;
    }

//    public boolean isPrivateUse() {
//        return isPrivateUse;
//    }
//
//    public void setPrivateUse(boolean privateUse) {
//        isPrivateUse = privateUse;
//    }


    public boolean isPrivateUse() {
        return privateUse;
    }

    public void setPrivateUse(boolean privateUse) {
        this.privateUse = privateUse;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRatify() {
        return ratify;
    }

    public void setRatify(String ratify) {
        this.ratify = ratify;
    }
}
