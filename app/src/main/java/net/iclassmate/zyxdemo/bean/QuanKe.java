package net.iclassmate.zyxdemo.bean;

import java.util.List;

/**
 * Created by xydbj on 2017.1.12.
 */
public class QuanKe {
    @Override
    public String toString() {
        return "QuanKe{" +
                "casaInfo=" + casaInfo +
                ", courseAnaInfo=" + courseAnaInfo +
                ", gasaInfo=" + gasaInfo +
                ", payInfo=" + payInfo +
                ", resultCode=" + resultCode +
                ", resultDesc='" + resultDesc + '\'' +
                ", type='" + type + '\'' +
                ", unbalancedInfo=" + unbalancedInfo +
                '}';
    }

    private CasaInfoBean casaInfo;
    /**
     * courseScoreList : [{"classAvgScore":387.55,"classPercentRate":71,"courseId":0,"courseName":"总分","gradeAvgScore":311.26,"score":434,"scorePercentRate":76},{"classAvgScore":80.68,"classPercentRate":50,"courseId":201,"courseName":"语文","gradeAvgScore":73.98,"score":82,"scorePercentRate":68},{"classAvgScore":84.76,"classPercentRate":87,"courseId":202,"courseName":"数学","gradeAvgScore":69.45,"score":100,"scorePercentRate":83},{"classAvgScore":83.26,"classPercentRate":68,"courseId":203,"courseName":"英语","gradeAvgScore":66.34,"score":95,"scorePercentRate":79},{"classAvgScore":75.79,"classPercentRate":71,"courseId":204,"courseName":"物理","gradeAvgScore":56.63,"score":88,"scorePercentRate":92},{"classAvgScore":63.05,"classPercentRate":61,"courseId":205,"courseName":"生化","gradeAvgScore":44.62,"score":69,"scorePercentRate":82},{"classAvgScore":138.84,"classPercentRate":63,"courseId":222,"courseName":"科学","gradeAvgScore":101.25,"score":157,"scorePercentRate":87}]
     * markInfo : 张承昕同学，您在本次考试中，总分为[434]分，本次共有423人参与测评,您的成绩在班级排名前15名，年级排名前55名，属于[中等组],为了开一次花，铁树付出了比别的树种更长久的努力，坚持不懈地付出与努力，会助你踏上更高的阶梯。
     */

    private CourseAnaInfoBean courseAnaInfo;
    private GasaInfoBean gasaInfo;
    /**
     * payStatus : 1
     */

    private PayInfoBean payInfo;
    /**
     * casaInfo : {"offsetList":[{"classAvgScore":387.55,"courseName":"总分","offset":46.450012,"score":434},{"classAvgScore":80.68,"courseName":"语文","offset":1.3199997,"score":82},{"classAvgScore":84.76,"courseName":"数学","offset":15.239998,"score":100},{"classAvgScore":83.26,"courseName":"英语","offset":11.739998,"score":95},{"classAvgScore":75.79,"courseName":"物理","offset":12.209999,"score":88},{"classAvgScore":63.05,"courseName":"生化","offset":5.950001,"score":69},{"classAvgScore":138.84,"courseName":"科学","offset":18.160004,"score":157}]}
     * courseAnaInfo : {"courseScoreList":[{"classAvgScore":387.55,"classPercentRate":71,"courseId":0,"courseName":"总分","gradeAvgScore":311.26,"score":434,"scorePercentRate":76},{"classAvgScore":80.68,"classPercentRate":50,"courseId":201,"courseName":"语文","gradeAvgScore":73.98,"score":82,"scorePercentRate":68},{"classAvgScore":84.76,"classPercentRate":87,"courseId":202,"courseName":"数学","gradeAvgScore":69.45,"score":100,"scorePercentRate":83},{"classAvgScore":83.26,"classPercentRate":68,"courseId":203,"courseName":"英语","gradeAvgScore":66.34,"score":95,"scorePercentRate":79},{"classAvgScore":75.79,"classPercentRate":71,"courseId":204,"courseName":"物理","gradeAvgScore":56.63,"score":88,"scorePercentRate":92},{"classAvgScore":63.05,"classPercentRate":61,"courseId":205,"courseName":"生化","gradeAvgScore":44.62,"score":69,"scorePercentRate":82},{"classAvgScore":138.84,"classPercentRate":63,"courseId":222,"courseName":"科学","gradeAvgScore":101.25,"score":157,"scorePercentRate":87}],"markInfo":"张承昕同学，您在本次考试中，总分为[434]分，本次共有423人参与测评,您的成绩在班级排名前15名，年级排名前55名，属于[中等组],为了开一次花，铁树付出了比别的树种更长久的努力，坚持不懈地付出与努力，会助你踏上更高的阶梯。"}
     * gasaInfo : {"offsetList":[{"courseName":"总分","gradeAvgScore":311.26,"offset":122.73999,"score":434},{"courseName":"语文","gradeAvgScore":73.98,"offset":8.019997,"score":82},{"courseName":"数学","gradeAvgScore":69.45,"offset":30.550003,"score":100},{"courseName":"英语","gradeAvgScore":66.34,"offset":28.660004,"score":95},{"courseName":"物理","gradeAvgScore":56.63,"offset":31.369999,"score":88},{"courseName":"生化","gradeAvgScore":44.62,"offset":24.380001,"score":69},{"courseName":"科学","gradeAvgScore":101.25,"offset":55.75,"score":157}]}
     * payInfo : {"payStatus":1}
     * resultCode : 0
     * resultDesc : 成功
     * type : QueryMultiAnalyzingRespInfo
     * unbalancedInfo : {"avgDegreeRate":67,"detailList":[{"avgDegreeRate":67,"courseName":"语文","degreeRate":50,"degreeRateOffset":-17},{"avgDegreeRate":67,"courseName":"数学","degreeRate":87,"degreeRateOffset":20},{"avgDegreeRate":67,"courseName":"英语","degreeRate":68,"degreeRateOffset":1},{"avgDegreeRate":67,"courseName":"物理","degreeRate":71,"degreeRateOffset":4},{"avgDegreeRate":67,"courseName":"生化","degreeRate":61,"degreeRateOffset":-6},{"avgDegreeRate":67,"courseName":"科学","degreeRate":63,"degreeRateOffset":-4}],"markInfo":"张承昕同学，[科学、生化]是你较薄弱的科目，整体发挥也不太理想，行动是成功的阶梯，不要停止自己的脚步，查漏补缺，优势科目要保持，薄弱科目要加倍努力，相信自己，迈上更高的阶梯。[语文]是你较薄弱的科目，且优势科目也不明显，在加强薄弱科目的学习时，其他科目也不容忽视，水滴石穿，坚持+努力总会有收获的。"}
     */

    private int resultCode;
    private String resultDesc;
    private String type;
    /**
     * avgDegreeRate : 67
     * detailList : [{"avgDegreeRate":67,"courseName":"语文","degreeRate":50,"degreeRateOffset":-17},{"avgDegreeRate":67,"courseName":"数学","degreeRate":87,"degreeRateOffset":20},{"avgDegreeRate":67,"courseName":"英语","degreeRate":68,"degreeRateOffset":1},{"avgDegreeRate":67,"courseName":"物理","degreeRate":71,"degreeRateOffset":4},{"avgDegreeRate":67,"courseName":"生化","degreeRate":61,"degreeRateOffset":-6},{"avgDegreeRate":67,"courseName":"科学","degreeRate":63,"degreeRateOffset":-4}]
     * markInfo : 张承昕同学，[科学、生化]是你较薄弱的科目，整体发挥也不太理想，行动是成功的阶梯，不要停止自己的脚步，查漏补缺，优势科目要保持，薄弱科目要加倍努力，相信自己，迈上更高的阶梯。[语文]是你较薄弱的科目，且优势科目也不明显，在加强薄弱科目的学习时，其他科目也不容忽视，水滴石穿，坚持+努力总会有收获的。
     */

    private UnbalancedInfoBean unbalancedInfo;

    public CasaInfoBean getCasaInfo() {
        return casaInfo;
    }

    public void setCasaInfo(CasaInfoBean casaInfo) {
        this.casaInfo = casaInfo;
    }

    public CourseAnaInfoBean getCourseAnaInfo() {
        return courseAnaInfo;
    }

    public void setCourseAnaInfo(CourseAnaInfoBean courseAnaInfo) {
        this.courseAnaInfo = courseAnaInfo;
    }

    public GasaInfoBean getGasaInfo() {
        return gasaInfo;
    }

    public void setGasaInfo(GasaInfoBean gasaInfo) {
        this.gasaInfo = gasaInfo;
    }

    public PayInfoBean getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(PayInfoBean payInfo) {
        this.payInfo = payInfo;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UnbalancedInfoBean getUnbalancedInfo() {
        return unbalancedInfo;
    }

    public void setUnbalancedInfo(UnbalancedInfoBean unbalancedInfo) {
        this.unbalancedInfo = unbalancedInfo;
    }

    public static class CasaInfoBean {

        @Override
        public String toString() {
            return "CasaInfoBean{" +
                    "offsetList=" + offsetList +
                    '}';
        }

        /**
         * classAvgScore : 387.55
         * courseName : 总分
         * offset : 46.450012
         * score : 434
         */

        private List<OffsetListBean> offsetList;

        public List<OffsetListBean> getOffsetList() {
            return offsetList;
        }

        public void setOffsetList(List<OffsetListBean> offsetList) {
            this.offsetList = offsetList;
        }

        public static class OffsetListBean {
            private double classAvgScore;
            private String courseName;
            private double offset;
            private int score;

            @Override
            public String toString() {
                return "OffsetListBean{" +
                        "classAvgScore=" + classAvgScore +
                        ", courseName='" + courseName + '\'' +
                        ", offset=" + offset +
                        ", score=" + score +
                        '}';
            }

            public double getClassAvgScore() {
                return classAvgScore;
            }

            public void setClassAvgScore(double classAvgScore) {
                this.classAvgScore = classAvgScore;
            }

            public String getCourseName() {
                return courseName;
            }

            public void setCourseName(String courseName) {
                this.courseName = courseName;
            }

            public double getOffset() {
                return offset;
            }

            public void setOffset(double offset) {
                this.offset = offset;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }
        }
    }

    public static class CourseAnaInfoBean {
        @Override
        public String toString() {
            return "CourseAnaInfoBean{" +
                    "markInfo='" + markInfo + '\'' +
                    ", courseScoreList=" + courseScoreList +
                    '}';
        }

        private String markInfo;
        /**
         * classAvgScore : 387.55
         * classPercentRate : 71
         * courseId : 0
         * courseName : 总分
         * gradeAvgScore : 311.26
         * score : 434
         * scorePercentRate : 76
         */

        private List<CourseScoreListBean> courseScoreList;

        public String getMarkInfo() {
            return markInfo;
        }

        public void setMarkInfo(String markInfo) {
            this.markInfo = markInfo;
        }

        public List<CourseScoreListBean> getCourseScoreList() {
            return courseScoreList;
        }

        public void setCourseScoreList(List<CourseScoreListBean> courseScoreList) {
            this.courseScoreList = courseScoreList;
        }

        public static class CourseScoreListBean {
            @Override
            public String toString() {
                return "CourseScoreListBean{" +
                        "classAvgScore=" + classAvgScore +
                        ", classPercentRate=" + classPercentRate +
                        ", courseId=" + courseId +
                        ", courseName='" + courseName + '\'' +
                        ", gradeAvgScore=" + gradeAvgScore +
                        ", score=" + score +
                        ", scorePercentRate=" + scorePercentRate +
                        '}';
            }

            private double classAvgScore;
            private int classPercentRate;
            private int courseId;
            private String courseName;
            private double gradeAvgScore;
            private int score;
            private int scorePercentRate;

            public double getClassAvgScore() {
                return classAvgScore;
            }

            public void setClassAvgScore(double classAvgScore) {
                this.classAvgScore = classAvgScore;
            }

            public int getClassPercentRate() {
                return classPercentRate;
            }

            public void setClassPercentRate(int classPercentRate) {
                this.classPercentRate = classPercentRate;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getCourseName() {
                return courseName;
            }

            public void setCourseName(String courseName) {
                this.courseName = courseName;
            }

            public double getGradeAvgScore() {
                return gradeAvgScore;
            }

            public void setGradeAvgScore(double gradeAvgScore) {
                this.gradeAvgScore = gradeAvgScore;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getScorePercentRate() {
                return scorePercentRate;
            }

            public void setScorePercentRate(int scorePercentRate) {
                this.scorePercentRate = scorePercentRate;
            }
        }
    }

    public static class GasaInfoBean {

        @Override
        public String toString() {
            return "GasaInfoBean{" +
                    "offsetList=" + offsetList +
                    '}';
        }

        /**
         * courseName : 总分
         * gradeAvgScore : 311.26
         * offset : 122.73999
         * score : 434
         */

        private List<OffsetListBean> offsetList;

        public List<OffsetListBean> getOffsetList() {
            return offsetList;
        }

        public void setOffsetList(List<OffsetListBean> offsetList) {
            this.offsetList = offsetList;
        }

        public static class OffsetListBean {
            @Override
            public String toString() {
                return "OffsetListBean{" +
                        "courseName='" + courseName + '\'' +
                        ", gradeAvgScore=" + gradeAvgScore +
                        ", offset=" + offset +
                        ", score=" + score +
                        '}';
            }

            private String courseName;
            private double gradeAvgScore;
            private double offset;
            private int score;

            public String getCourseName() {
                return courseName;
            }

            public void setCourseName(String courseName) {
                this.courseName = courseName;
            }

            public double getGradeAvgScore() {
                return gradeAvgScore;
            }

            public void setGradeAvgScore(double gradeAvgScore) {
                this.gradeAvgScore = gradeAvgScore;
            }

            public double getOffset() {
                return offset;
            }

            public void setOffset(double offset) {
                this.offset = offset;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }
        }
    }

    public static class PayInfoBean {

        @Override
        public String toString() {
            return "PayInfoBean{" +
                    "payStatus=" + payStatus +
                    '}';
        }

        private int payStatus;

        public int getPayStatus() {
            return payStatus;
        }

        public void setPayStatus(int payStatus) {
            this.payStatus = payStatus;
        }
    }

    public static class UnbalancedInfoBean {
        @Override
        public String toString() {
            return "UnbalancedInfoBean{" +
                    "avgDegreeRate=" + avgDegreeRate +
                    ", markInfo='" + markInfo + '\'' +
                    ", detailList=" + detailList +
                    '}';
        }

        private int avgDegreeRate;
        private String markInfo;
        /**
         * avgDegreeRate : 67
         * courseName : 语文
         * degreeRate : 50
         * degreeRateOffset : -17
         */

        private List<DetailListBean> detailList;

        public int getAvgDegreeRate() {
            return avgDegreeRate;
        }

        public void setAvgDegreeRate(int avgDegreeRate) {
            this.avgDegreeRate = avgDegreeRate;
        }

        public String getMarkInfo() {
            return markInfo;
        }

        public void setMarkInfo(String markInfo) {
            this.markInfo = markInfo;
        }

        public List<DetailListBean> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DetailListBean> detailList) {
            this.detailList = detailList;
        }

        public static class DetailListBean {
            @Override
            public String toString() {
                return "DetailListBean{" +
                        "avgDegreeRate=" + avgDegreeRate +
                        ", courseName='" + courseName + '\'' +
                        ", degreeRate=" + degreeRate +
                        ", degreeRateOffset=" + degreeRateOffset +
                        '}';
            }

            private int avgDegreeRate;
            private String courseName;
            private int degreeRate;
            private int degreeRateOffset;

            public int getAvgDegreeRate() {
                return avgDegreeRate;
            }

            public void setAvgDegreeRate(int avgDegreeRate) {
                this.avgDegreeRate = avgDegreeRate;
            }

            public String getCourseName() {
                return courseName;
            }

            public void setCourseName(String courseName) {
                this.courseName = courseName;
            }

            public int getDegreeRate() {
                return degreeRate;
            }

            public void setDegreeRate(int degreeRate) {
                this.degreeRate = degreeRate;
            }

            public int getDegreeRateOffset() {
                return degreeRateOffset;
            }

            public void setDegreeRateOffset(int degreeRateOffset) {
                this.degreeRateOffset = degreeRateOffset;
            }
        }
    }
}
