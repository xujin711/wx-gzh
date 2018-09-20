package msb.wxgzh.pojo;

import java.util.Date;

public class ProductInfo {
    private Long id;

    private Long userId;

    private Long productId;

    private String status;

    private String newVideoAddress;

    private String newVideoName;

    private String newVideoDetail;

    private String newVideoImage;

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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