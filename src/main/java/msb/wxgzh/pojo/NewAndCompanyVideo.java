package msb.wxgzh.pojo;

import java.util.Date;

public class NewAndCompanyVideo {
    private Long id;

    private Long userId;

    private String status;

    private String newVideoAddress;

    private String newVideoName;

    private String newVideoDetail;

    private String newVideoImage;

    private String companyVideoAddress;

    private String companyVideoDetail;

    private String companyVideoName;

    private String companyImage;

    private Long createId;

    private String createName;

    private Date createTime;

    private Date updateTime;

    private Long updateId;

    private String updateName;

    private String delornot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getNewVideoAddress() {
        return newVideoAddress;
    }

    public void setNewVideoAddress(String newVideoAddress) {
        this.newVideoAddress = newVideoAddress == null ? null : newVideoAddress.trim();
    }

    public String getNewVideoName() {
        return newVideoName;
    }

    public void setNewVideoName(String newVideoName) {
        this.newVideoName = newVideoName == null ? null : newVideoName.trim();
    }

    public String getNewVideoDetail() {
        return newVideoDetail;
    }

    public void setNewVideoDetail(String newVideoDetail) {
        this.newVideoDetail = newVideoDetail == null ? null : newVideoDetail.trim();
    }

    public String getNewVideoImage() {
        return newVideoImage;
    }

    public void setNewVideoImage(String newVideoImage) {
        this.newVideoImage = newVideoImage == null ? null : newVideoImage.trim();
    }

    public String getCompanyVideoAddress() {
        return companyVideoAddress;
    }

    public void setCompanyVideoAddress(String companyVideoAddress) {
        this.companyVideoAddress = companyVideoAddress == null ? null : companyVideoAddress.trim();
    }

    public String getCompanyVideoDetail() {
        return companyVideoDetail;
    }

    public void setCompanyVideoDetail(String companyVideoDetail) {
        this.companyVideoDetail = companyVideoDetail == null ? null : companyVideoDetail.trim();
    }

    public String getCompanyVideoName() {
        return companyVideoName;
    }

    public void setCompanyVideoName(String companyVideoName) {
        this.companyVideoName = companyVideoName == null ? null : companyVideoName.trim();
    }

    public String getCompanyImage() {
        return companyImage;
    }

    public void setCompanyImage(String companyImage) {
        this.companyImage = companyImage == null ? null : companyImage.trim();
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    public String getDelornot() {
        return delornot;
    }

    public void setDelornot(String delornot) {
        this.delornot = delornot == null ? null : delornot.trim();
    }
}