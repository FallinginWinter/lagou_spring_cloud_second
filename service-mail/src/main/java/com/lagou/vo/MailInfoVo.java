package com.lagou.vo;



import java.util.List;
import java.util.Map;

/**
 * @Author: lihaonan
 * @Date: 2020/5/21
 */
public class MailInfoVo {

    /**
     * 邮件标题
     */
    private String title;
    /**
     * 发送的用户列表
     */
    private String[] toUsers;
    /**
     * 抄送的用户列表
     */
    private String[] carbonCopyUsers;
    /**
     * 密送的用户列表
     */
    private String[] blindCarbonCopyUsers;
    /**
     * 模板名称
     */
    private String templateName;
    /**
     * 自定义html内容
     */
    private String htmlContent;
    /**
     * 模板变量替换
     */
    private Map<String, Object> contentMap;
    /**
     * 附件的绝对路径(带后缀)
     */
    private List<String> filePathList;
    /**
     * 产品ID
     */
    private int productId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public Map<String, Object> getContentMap() {
        return contentMap;
    }

    public void setContentMap(Map<String, Object> contentMap) {
        this.contentMap = contentMap;
    }

    public String[] getToUsers() {
        return toUsers;
    }

    public void setToUsers(String[] toUsers) {
        this.toUsers = toUsers;
    }

    public String[] getCarbonCopyUsers() {
        return carbonCopyUsers;
    }

    public void setCarbonCopyUsers(String[] carbonCopyUsers) {
        this.carbonCopyUsers = carbonCopyUsers;
    }

    public String[] getBlindCarbonCopyUsers() {
        return blindCarbonCopyUsers;
    }

    public void setBlindCarbonCopyUsers(String[] blindCarbonCopyUsers) {
        this.blindCarbonCopyUsers = blindCarbonCopyUsers;
    }

    public List<String> getFilePathList() {
        return filePathList;
    }

    public void setFilePathList(List<String> filePathList) {
        this.filePathList = filePathList;
    }
}

