package cn.edu.pku.yangwenming.bean;

/**
 * Created by ywm108 on 2016/10/13.
 */
public class TodayWeather {
    //当日天气
    private	String	city;
    private	String	updatetime;
    private	String	wendu;
    private	String	shidu;
    private	String	pm25;
    private	String	quality;
    //六日天气
    private	String	date;
    private	String	high;
    private	String	low;
    private	String	fengxiang;
    private	String	fengli;
    private	String	type;
    //昨天天气
    private String date_1;
    private String high_1;
    private String low_1;
    //白天
    private String dayType_1;
    private String dayFx_1;
    private String dayFl_1;
    //夜间
    private String nightType_1;
    private String nightFx_1;
    private String nightFl_1;

    public String getDate_1() {
        return date_1;
    }

    public String getHigh_1() {
        return high_1;
    }

    public String getLow_1() {
        return low_1;
    }

    public String getDayType_1() {
        return dayType_1;
    }

    public String getDayFx_1() {
        return dayFx_1;
    }

    public String getDayFl_1() {
        return dayFl_1;
    }

    public String getNightType_1() {
        return nightType_1;
    }

    public String getNightFx_1() {
        return nightFx_1;
    }

    public String getNightFl_1() {
        return nightFl_1;
    }

    public String getCity() {
        return city;
    }

    public String getWendu() {
        return wendu;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public String getShidu() {
        return shidu;
    }

    public String getPm25() {
        return pm25;
    }

    public String getQuality() {
        return quality;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public String getFengli() {
        return fengli;
    }

    public String getDate() {
        return date;
    }

    public String getHigh() {
        return high;
    }

    public String getLow() {
        return low;
    }

    public String getType() {
        return type;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public void setShidu(String shidu) {
        this.shidu = shidu;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate_1(String date_1) {
        this.date_1 = date_1;
    }

    public void setHigh_1(String high_1) {
        this.high_1 = high_1;
    }

    public void setLow_1(String low_1) {
        this.low_1 = low_1;
    }

    public void setDayType_1(String dayType_1) {
        this.dayType_1 = dayType_1;
    }

    public void setDayFx_1(String dayFx_1) {
        this.dayFx_1 = dayFx_1;
    }

    public void setDayFl_1(String dayFl_1) {
        this.dayFl_1 = dayFl_1;
    }

    public void setNightType_1(String nightType_1) {
        this.nightType_1 = nightType_1;
    }

    public void setNightFx_1(String nightFx_1) {
        this.nightFx_1 = nightFx_1;
    }

    public void setNightFl_1(String nightFl_1) {
        this.nightFl_1 = nightFl_1;
    }

    @Override
    public String toString() {
        return "TodayWeather{" +
                "city='" + city + '\'' +
                ", updatetime='" + updatetime + '\'' +
                ", wendu='" + wendu + '\'' +
                ", shidu='" + shidu + '\'' +
                ", pm25='" + pm25 + '\'' +
                ", quality='" + quality + '\'' +
                ", fengxiang='" + fengxiang + '\'' +
                ", fengli='" + fengli + '\'' +
                ", date='" + date + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
