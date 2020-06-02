package com.lagou.vo;

/**
 * @Author: lihaonan
 * @Date: 2020/5/26
 */
public class IpCheckVo {

    private long creatTime;

    private int count;

    @Override
    public String toString() {
        return "IpCheckVo{" +
                "creatTime=" + creatTime +
                ", count=" + count +
                '}';
    }

    public long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(long creatTime) {
        this.creatTime = creatTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
