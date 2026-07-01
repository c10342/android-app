package com.example.myapp.entity;

public class LoginRespond extends BaseRespond {

    /**
     * code : 200
     * message : 登录成功
     * data : {"token":"d56d4cca168bf5d08c144a825496aaa9396da335b931a7d61e2561e41bfb2535","username":"admin"}
     */


    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * token : d56d4cca168bf5d08c144a825496aaa9396da335b931a7d61e2561e41bfb2535
         * username : admin
         */

        private String token;
        private String username;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
