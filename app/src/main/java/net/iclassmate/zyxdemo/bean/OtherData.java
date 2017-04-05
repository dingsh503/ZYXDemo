package net.iclassmate.zyxdemo.bean;

import java.util.List;

/**
 * Created by xydbj on 2016.10.29.
 */
public class OtherData {

    /**
     * feedbacks : {"feedbacklist":[{"comment":"5分","createtime":"2014.07.08 13:38","score":5,"username":"l***2"}],"totalcount":1,"totalscore":5}
     * liketeamlist : [{"limage":"http://img.pztuan.com/upfile/team/2013/0712/201307120257551465.jpg","lmarketprice":3999,"lteamId":65886,"lteamprice":518,"ltitle":"爱丽尔婚纱摄影/2本相册/6套服装造型/拍摄不限最低拍摄150张。"},{"limage":"http://img.pztuan.com/upfile/team/2013/0628/201306281115249737.jpg","lmarketprice":3380,"lteamId":57133,"lteamprice":580,"ltitle":"陶冶摄影/婚纱闺蜜/6组服装造型/拍摄不低于120张！"}]
     * partnerteamlist : [{"pteamId":72825,"pteamprice":288,"ptitle":"随摄影/共6套服装/准爸准妈共拍/免费肚画/底片全送。"},{"pteamId":72598,"pteamprice":2888,"ptitle":"随摄影/拍摄200张/4本相册/品质拍摄/送全新婚纱。"},{"pteamId":72613,"pteamprice":3699,"ptitle":"随摄影/送全新婚纱/多外景拍摄/服装不限数量/绝无二次消费！"},{"pteamId":72638,"pteamprice":4299,"ptitle":"随摄影/服装不限数量/高品质拍摄260张/送全新婚纱。"},{"pteamId":72716,"pteamprice":388,"ptitle":"随摄影/3组服装造型/内外景拍摄/完全透明消费！"}]
     */

    private DataBean data;
    /**
     * data : {"feedbacks":{"feedbacklist":[{"comment":"5分","createtime":"2014.07.08 13:38","score":5,"username":"l***2"}],"totalcount":1,"totalscore":5},"liketeamlist":[{"limage":"http://img.pztuan.com/upfile/team/2013/0712/201307120257551465.jpg","lmarketprice":3999,"lteamId":65886,"lteamprice":518,"ltitle":"爱丽尔婚纱摄影/2本相册/6套服装造型/拍摄不限最低拍摄150张。"},{"limage":"http://img.pztuan.com/upfile/team/2013/0628/201306281115249737.jpg","lmarketprice":3380,"lteamId":57133,"lteamprice":580,"ltitle":"陶冶摄影/婚纱闺蜜/6组服装造型/拍摄不低于120张！"}],"partnerteamlist":[{"pteamId":72825,"pteamprice":288,"ptitle":"随摄影/共6套服装/准爸准妈共拍/免费肚画/底片全送。"},{"pteamId":72598,"pteamprice":2888,"ptitle":"随摄影/拍摄200张/4本相册/品质拍摄/送全新婚纱。"},{"pteamId":72613,"pteamprice":3699,"ptitle":"随摄影/送全新婚纱/多外景拍摄/服装不限数量/绝无二次消费！"},{"pteamId":72638,"pteamprice":4299,"ptitle":"随摄影/服装不限数量/高品质拍摄260张/送全新婚纱。"},{"pteamId":72716,"pteamprice":388,"ptitle":"随摄影/3组服装造型/内外景拍摄/完全透明消费！"}]}
     * state : 1
     */

    private int state;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public static class DataBean {
        /**
         * feedbacklist : [{"comment":"5分","createtime":"2014.07.08 13:38","score":5,"username":"l***2"}]
         * totalcount : 1
         * totalscore : 5
         */

        private FeedbacksBean feedbacks;
        /**
         * limage : http://img.pztuan.com/upfile/team/2013/0712/201307120257551465.jpg
         * lmarketprice : 3999
         * lteamId : 65886
         * lteamprice : 518
         * ltitle : 爱丽尔婚纱摄影/2本相册/6套服装造型/拍摄不限最低拍摄150张。
         */

        private List<LiketeamlistBean> liketeamlist;
        /**
         * pteamId : 72825
         * pteamprice : 288
         * ptitle : 随摄影/共6套服装/准爸准妈共拍/免费肚画/底片全送。
         */

        private List<PartnerteamlistBean> partnerteamlist;

        public FeedbacksBean getFeedbacks() {
            return feedbacks;
        }

        public void setFeedbacks(FeedbacksBean feedbacks) {
            this.feedbacks = feedbacks;
        }

        public List<LiketeamlistBean> getLiketeamlist() {
            return liketeamlist;
        }

        public void setLiketeamlist(List<LiketeamlistBean> liketeamlist) {
            this.liketeamlist = liketeamlist;
        }

        public List<PartnerteamlistBean> getPartnerteamlist() {
            return partnerteamlist;
        }

        public void setPartnerteamlist(List<PartnerteamlistBean> partnerteamlist) {
            this.partnerteamlist = partnerteamlist;
        }

        public static class FeedbacksBean {
            private int totalcount;
            private int totalscore;
            /**
             * comment : 5分
             * createtime : 2014.07.08 13:38
             * score : 5
             * username : l***2
             */

            private List<FeedbacklistBean> feedbacklist;

            public int getTotalcount() {
                return totalcount;
            }

            public void setTotalcount(int totalcount) {
                this.totalcount = totalcount;
            }

            public int getTotalscore() {
                return totalscore;
            }

            public void setTotalscore(int totalscore) {
                this.totalscore = totalscore;
            }

            public List<FeedbacklistBean> getFeedbacklist() {
                return feedbacklist;
            }

            public void setFeedbacklist(List<FeedbacklistBean> feedbacklist) {
                this.feedbacklist = feedbacklist;
            }

            public static class FeedbacklistBean {
                private String comment;
                private String createtime;
                private int score;
                private String username;

                public String getComment() {
                    return comment;
                }

                public void setComment(String comment) {
                    this.comment = comment;
                }

                public String getCreatetime() {
                    return createtime;
                }

                public void setCreatetime(String createtime) {
                    this.createtime = createtime;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }
            }
        }

        public static class LiketeamlistBean {
            private String limage;
            private int lmarketprice;
            private int lteamId;
            private int lteamprice;
            private String ltitle;

            public String getLimage() {
                return limage;
            }

            public void setLimage(String limage) {
                this.limage = limage;
            }

            public int getLmarketprice() {
                return lmarketprice;
            }

            public void setLmarketprice(int lmarketprice) {
                this.lmarketprice = lmarketprice;
            }

            public int getLteamId() {
                return lteamId;
            }

            public void setLteamId(int lteamId) {
                this.lteamId = lteamId;
            }

            public int getLteamprice() {
                return lteamprice;
            }

            public void setLteamprice(int lteamprice) {
                this.lteamprice = lteamprice;
            }

            public String getLtitle() {
                return ltitle;
            }

            public void setLtitle(String ltitle) {
                this.ltitle = ltitle;
            }
        }

        public static class PartnerteamlistBean {
            private int pteamId;
            private int pteamprice;
            private String ptitle;

            public int getPteamId() {
                return pteamId;
            }

            public void setPteamId(int pteamId) {
                this.pteamId = pteamId;
            }

            public int getPteamprice() {
                return pteamprice;
            }

            public void setPteamprice(int pteamprice) {
                this.pteamprice = pteamprice;
            }

            public String getPtitle() {
                return ptitle;
            }

            public void setPtitle(String ptitle) {
                this.ptitle = ptitle;
            }
        }
    }
}
