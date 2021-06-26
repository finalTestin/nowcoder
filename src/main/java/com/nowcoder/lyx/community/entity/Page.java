package com.nowcoder.lyx.community.entity;

/**
 * 包含分页信息，用来得到前端页面的当前页，总页数信息
 */
public class Page {

    // 当前页
    private int current = 1;
    // 单页帖子数量
    private int limit = 10;
    // 总帖子数
    private int rows;
    // 查询路径（复用分页链接，方便获得“首页，下一页”等信息）
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current >= 1){
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit >= 1 && limit <= 100){
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows >= 0){
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获得当前页的其实数据的行数
     */
    public int getOffset(){
        return (current - 1) * limit;
    }

    /**
     * 获得总页数
     */
    public int getTotal(){
        if(rows % limit == 0){
            return rows / limit;
        }else {
            return rows / limit + 1;
        }
    }

    /**
     * 获得要在前端显示的起始页（比当前页前两页）
     */
    public int getFrom(){
        int from = current - 2;
        return from > 0 ? from : 1;
    }

    /**
     * 获得要在前端显示的终止页（比当前页后两页）
     */
    public int getTo(){
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }
}
