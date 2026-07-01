package com.example.myapp.entity;

import com.example.myapp.fragment.home.ListItemEntity;

import java.util.List;

public class HomeListRespond extends BaseRespond {

    /**
     * code : 200
     * message : 查询成功
     * data : {"list":[{"avatar":"https://i.pravatar.cc/150?img=1","title":"新闻标题 1","name":"创作者 1","cover":"https://picsum.photos/seed/news-1/600/400","commentCount":218,"likeCount":1953,"favoriteCount":310},{"avatar":"https://i.pravatar.cc/150?img=2","title":"新闻标题 2","name":"创作者 2","cover":"https://picsum.photos/seed/news-2/600/400","commentCount":191,"likeCount":1557,"favoriteCount":216},{"avatar":"https://i.pravatar.cc/150?img=3","title":"新闻标题 3","name":"创作者 3","cover":"https://picsum.photos/seed/news-3/600/400","commentCount":147,"likeCount":522,"favoriteCount":776},{"avatar":"https://i.pravatar.cc/150?img=4","title":"新闻标题 4","name":"创作者 4","cover":"https://picsum.photos/seed/news-4/600/400","commentCount":473,"likeCount":1823,"favoriteCount":281},{"avatar":"https://i.pravatar.cc/150?img=5","title":"新闻标题 5","name":"创作者 5","cover":"https://picsum.photos/seed/news-5/600/400","commentCount":189,"likeCount":1279,"favoriteCount":208},{"avatar":"https://i.pravatar.cc/150?img=6","title":"新闻标题 6","name":"创作者 6","cover":"https://picsum.photos/seed/news-6/600/400","commentCount":431,"likeCount":587,"favoriteCount":592},{"avatar":"https://i.pravatar.cc/150?img=7","title":"新闻标题 7","name":"创作者 7","cover":"https://picsum.photos/seed/news-7/600/400","commentCount":479,"likeCount":1871,"favoriteCount":32},{"avatar":"https://i.pravatar.cc/150?img=8","title":"新闻标题 8","name":"创作者 8","cover":"https://picsum.photos/seed/news-8/600/400","commentCount":372,"likeCount":1548,"favoriteCount":774},{"avatar":"https://i.pravatar.cc/150?img=9","title":"新闻标题 9","name":"创作者 9","cover":"https://picsum.photos/seed/news-9/600/400","commentCount":435,"likeCount":1257,"favoriteCount":354},{"avatar":"https://i.pravatar.cc/150?img=10","title":"新闻标题 10","name":"创作者 10","cover":"https://picsum.photos/seed/news-10/600/400","commentCount":378,"likeCount":703,"favoriteCount":365}],"total":36,"page":1,"pageSize":10,"totalPages":4}
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
         * list : [{"avatar":"https://i.pravatar.cc/150?img=1","title":"新闻标题 1","name":"创作者 1","cover":"https://picsum.photos/seed/news-1/600/400","commentCount":218,"likeCount":1953,"favoriteCount":310},{"avatar":"https://i.pravatar.cc/150?img=2","title":"新闻标题 2","name":"创作者 2","cover":"https://picsum.photos/seed/news-2/600/400","commentCount":191,"likeCount":1557,"favoriteCount":216},{"avatar":"https://i.pravatar.cc/150?img=3","title":"新闻标题 3","name":"创作者 3","cover":"https://picsum.photos/seed/news-3/600/400","commentCount":147,"likeCount":522,"favoriteCount":776},{"avatar":"https://i.pravatar.cc/150?img=4","title":"新闻标题 4","name":"创作者 4","cover":"https://picsum.photos/seed/news-4/600/400","commentCount":473,"likeCount":1823,"favoriteCount":281},{"avatar":"https://i.pravatar.cc/150?img=5","title":"新闻标题 5","name":"创作者 5","cover":"https://picsum.photos/seed/news-5/600/400","commentCount":189,"likeCount":1279,"favoriteCount":208},{"avatar":"https://i.pravatar.cc/150?img=6","title":"新闻标题 6","name":"创作者 6","cover":"https://picsum.photos/seed/news-6/600/400","commentCount":431,"likeCount":587,"favoriteCount":592},{"avatar":"https://i.pravatar.cc/150?img=7","title":"新闻标题 7","name":"创作者 7","cover":"https://picsum.photos/seed/news-7/600/400","commentCount":479,"likeCount":1871,"favoriteCount":32},{"avatar":"https://i.pravatar.cc/150?img=8","title":"新闻标题 8","name":"创作者 8","cover":"https://picsum.photos/seed/news-8/600/400","commentCount":372,"likeCount":1548,"favoriteCount":774},{"avatar":"https://i.pravatar.cc/150?img=9","title":"新闻标题 9","name":"创作者 9","cover":"https://picsum.photos/seed/news-9/600/400","commentCount":435,"likeCount":1257,"favoriteCount":354},{"avatar":"https://i.pravatar.cc/150?img=10","title":"新闻标题 10","name":"创作者 10","cover":"https://picsum.photos/seed/news-10/600/400","commentCount":378,"likeCount":703,"favoriteCount":365}]
         * total : 36
         * page : 1
         * pageSize : 10
         * totalPages : 4
         */

        private int total;
        private int page;
        private int pageSize;
        private int totalPages;
        private List<ListItemEntity> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public List<ListItemEntity> getList() {
            return list;
        }

        public void setList(List<ListItemEntity> list) {
            this.list = list;
        }

    }
}
