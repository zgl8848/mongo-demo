package com.cmd.mongodemo.controller;

import lombok.Data;

@Data
public class aa {

    /**
     * _id : 1190080800712822786
     * dept_id : 1105305059958198274
     * school_name : 九江100初中
     * school_code : 00000026
     * school_type : {"$numberInt":"3"}
     * student_total : {"$numberInt":"600"}
     * boarder_total : {"$numberInt":"543"}
     * teacher_total : {"$numberInt":"189"}
     * workers_total : {"$numberInt":"123"}
     * temporary_worker_total : {"$numberInt":"45"}
     * is_canteen : {"$numberInt":"1"}
     * province : {"$numberInt":"210000"}
     * city : {"$numberInt":"210300"}
     * county : {"$numberInt":"210304"}
     * address : 九龙镇江湾路
     * del_flag : {"$numberInt":"0"}
     * lock_flag : {"$numberInt":"0"}
     * police_office :
     * police_name :
     * police_contact_phone :
     * remark : {"$numberInt":"132434"}
     * create_time : 2019/11/1 9:39:08
     * school_nature : {"$numberInt":"1"}
     * platform_url :
     * third_party_username :
     * third_party_password :
     * alarm_platform_ip :
     * alarm_picture_port :
     * broadcast_room :
     * broadcast_user :
     * broadcast_url :
     * broadcast_room_server_url :
     * broadcast_areacode : {"$numberInt":"9"}
     * broadcast_id :
     */

    private String _id;
    private String dept_id;
    private String school_name;
    private String school_code;
    private SchoolTypeBean school_type;
    private StudentTotalBean student_total;
    private BoarderTotalBean boarder_total;
    private TeacherTotalBean teacher_total;
    private WorkersTotalBean workers_total;
    private TemporaryWorkerTotalBean temporary_worker_total;
    private IsCanteenBean is_canteen;
    private ProvinceBean province;
    private CityBean city;
    private CountyBean county;
    private String address;
    private DelFlagBean del_flag;
    private LockFlagBean lock_flag;
    private String police_office;
    private String police_name;
    private String police_contact_phone;
    private RemarkBean remark;
    private String create_time;
    private SchoolNatureBean school_nature;
    private String platform_url;
    private String third_party_username;
    private String third_party_password;
    private String alarm_platform_ip;
    private String alarm_picture_port;
    private String broadcast_room;
    private String broadcast_user;
    private String broadcast_url;
    private String broadcast_room_server_url;
    private BroadcastAreacodeBean broadcast_areacode;
    private String broadcast_id;



    public static class SchoolTypeBean {
        /**
         * $numberInt : 3
         */

        private String $numberInt;

        public String get$numberInt() {
            return $numberInt;
        }

        public void set$numberInt(String $numberInt) {
            this.$numberInt = $numberInt;
        }
    }

    public static class StudentTotalBean {
        /**
         * $numberInt : 600
         */

        private String $numberInt;

        public String get$numberInt() {
            return $numberInt;
        }

        public void set$numberInt(String $numberInt) {
            this.$numberInt = $numberInt;
        }
    }

    public static class BoarderTotalBean {
        /**
         * $numberInt : 543
         */

        private String $numberInt;

        public String get$numberInt() {
            return $numberInt;
        }

        public void set$numberInt(String $numberInt) {
            this.$numberInt = $numberInt;
        }
    }

    public static class TeacherTotalBean {
        /**
         * $numberInt : 189
         */

        private String $numberInt;

        public String get$numberInt() {
            return $numberInt;
        }

        public void set$numberInt(String $numberInt) {
            this.$numberInt = $numberInt;
        }
    }

    public static class WorkersTotalBean {
        /**
         * $numberInt : 123
         */

        private String $numberInt;

        public String get$numberInt() {
            return $numberInt;
        }

        public void set$numberInt(String $numberInt) {
            this.$numberInt = $numberInt;
        }
    }

    public static class TemporaryWorkerTotalBean {
        /**
         * $numberInt : 45
         */

        private String $numberInt;

        public String get$numberInt() {
            return $numberInt;
        }

        public void set$numberInt(String $numberInt) {
            this.$numberInt = $numberInt;
        }
    }

    public static class IsCanteenBean {
        /**
         * $numberInt : 1
         */

        private String $numberInt;

        public String get$numberInt() {
            return $numberInt;
        }

        public void set$numberInt(String $numberInt) {
            this.$numberInt = $numberInt;
        }
    }

    public static class ProvinceBean {
        /**
         * $numberInt : 210000
         */

        private String $numberInt;

        public String get$numberInt() {
            return $numberInt;
        }

        public void set$numberInt(String $numberInt) {
            this.$numberInt = $numberInt;
        }
    }

    public static class CityBean {
        /**
         * $numberInt : 210300
         */

        private String $numberInt;

        public String get$numberInt() {
            return $numberInt;
        }

        public void set$numberInt(String $numberInt) {
            this.$numberInt = $numberInt;
        }
    }

    public static class CountyBean {
        /**
         * $numberInt : 210304
         */

        private String $numberInt;

        public String get$numberInt() {
            return $numberInt;
        }

        public void set$numberInt(String $numberInt) {
            this.$numberInt = $numberInt;
        }
    }

    public static class DelFlagBean {
        /**
         * $numberInt : 0
         */

        private String $numberInt;

        public String get$numberInt() {
            return $numberInt;
        }

        public void set$numberInt(String $numberInt) {
            this.$numberInt = $numberInt;
        }
    }

    public static class LockFlagBean {
        /**
         * $numberInt : 0
         */

        private String $numberInt;

        public String get$numberInt() {
            return $numberInt;
        }

        public void set$numberInt(String $numberInt) {
            this.$numberInt = $numberInt;
        }
    }

    public static class RemarkBean {
        /**
         * $numberInt : 132434
         */

        private String $numberInt;

        public String get$numberInt() {
            return $numberInt;
        }

        public void set$numberInt(String $numberInt) {
            this.$numberInt = $numberInt;
        }
    }

    public static class SchoolNatureBean {
        /**
         * $numberInt : 1
         */

        private String $numberInt;

        public String get$numberInt() {
            return $numberInt;
        }

        public void set$numberInt(String $numberInt) {
            this.$numberInt = $numberInt;
        }
    }

    public static class BroadcastAreacodeBean {
        /**
         * $numberInt : 9
         */

        private String $numberInt;

        public String get$numberInt() {
            return $numberInt;
        }

        public void set$numberInt(String $numberInt) {
            this.$numberInt = $numberInt;
        }
    }
}
