package com.bw.mothons.model.bean;

import java.util.List;

/**
 * DateTime:2020/4/13 0013
 * author:朱贵全(Administrator)
 * function:
 */
public class ShopBean {

    /**
     * code : 200
     * orderData : [{"shopId":1,"shopName":"八维超市","cartlist":[{"id":1,"shopId":1,"shopName":"八维超市","defaultPic":"https://img14.360buyimg.com/n0/jfs/t1/61309/20/5608/150880/5d3b0f8eE3f24f820/8a9d017535f38af4.jpg","productId":1,"productName":"安可希2019夏装女","color":"黄色","price":69,"count":1},{"id":2,"shopId":1,"shopName":"八维超市","defaultPic":"https://img14.360buyimg.com/n0/jfs/t1/56218/32/6578/141587/5d43c342Edbebd72f/7aa0554c2542fe96.jpg","productId":2,"productName":"欧惠悠纯棉短袖t恤女","color":"红色","price":69,"count":1}]},{"shopId":2,"shopName":"八维服装店","cartlist":[{"id":1,"shopId":2,"shopName":"八维服装店","defaultPic":"https://img12.360buyimg.com/n1/s350x449_jfs/t1/83403/25/4435/191065/5d2be9d8E507dfb4e/9ab5254595f3d428.jpg!cc_350x449.jpg","productId":1,"productName":"PHJ 韩版短袖t恤女","color":"蓝色","price":79,"count":1}]}]
     */

    private int code;
    private List<OrderDataBean> orderData;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<OrderDataBean> getOrderData() {
        return orderData;
    }

    public void setOrderData(List<OrderDataBean> orderData) {
        this.orderData = orderData;
    }

    public static class OrderDataBean {
        /**
         * shopId : 1
         * shopName : 八维超市
         * cartlist : [{"id":1,"shopId":1,"shopName":"八维超市","defaultPic":"https://img14.360buyimg.com/n0/jfs/t1/61309/20/5608/150880/5d3b0f8eE3f24f820/8a9d017535f38af4.jpg","productId":1,"productName":"安可希2019夏装女","color":"黄色","price":69,"count":1},{"id":2,"shopId":1,"shopName":"八维超市","defaultPic":"https://img14.360buyimg.com/n0/jfs/t1/56218/32/6578/141587/5d43c342Edbebd72f/7aa0554c2542fe96.jpg","productId":2,"productName":"欧惠悠纯棉短袖t恤女","color":"红色","price":69,"count":1}]
         */

        private int shopId;
        private String shopName;
        private List<CartlistBean> cartlist;

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public List<CartlistBean> getCartlist() {
            return cartlist;
        }

        public void setCartlist(List<CartlistBean> cartlist) {
            this.cartlist = cartlist;
        }

        public static class CartlistBean {
            /**
             * id : 1
             * shopId : 1
             * shopName : 八维超市
             * defaultPic : https://img14.360buyimg.com/n0/jfs/t1/61309/20/5608/150880/5d3b0f8eE3f24f820/8a9d017535f38af4.jpg
             * productId : 1
             * productName : 安可希2019夏装女
             * color : 黄色
             * price : 69
             * count : 1
             *
             */

            private int id;
            private int shopId;
            private String shopName;
            private String defaultPic;
            private int productId;
            private String productName;
            private String color;
            private int price;
            private int count;
            private boolean checked;

            public boolean isChecked() {
                return checked;
            }

            public void setChecked(boolean checked) {
                this.checked = checked;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getDefaultPic() {
                return defaultPic;
            }

            public void setDefaultPic(String defaultPic) {
                this.defaultPic = defaultPic;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }
    }
}
