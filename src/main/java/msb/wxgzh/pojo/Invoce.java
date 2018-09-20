package msb.wxgzh.pojo;

import java.math.BigDecimal;

public class Invoce {
    private Long id;

    private String invoiceType;

    private String invoiceTitletype;

    private String invoiceTitle;

    private String invoiceCode;

    private String invoiceContext;

    private BigDecimal invoiceBalance;

    private String invoiceEmail;

    private String invoiceAddressee;

    private Long invoceTelephone;

    private String invoceAddress;

    private Long invoceId;

    private String invoceCashNDelivery;

    private String isDel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType == null ? null : invoiceType.trim();
    }

    public String getInvoiceTitletype() {
        return invoiceTitletype;
    }

    public void setInvoiceTitletype(String invoiceTitletype) {
        this.invoiceTitletype = invoiceTitletype == null ? null : invoiceTitletype.trim();
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode == null ? null : invoiceCode.trim();
    }

    public String getInvoiceContext() {
        return invoiceContext;
    }

    public void setInvoiceContext(String invoiceContext) {
        this.invoiceContext = invoiceContext == null ? null : invoiceContext.trim();
    }

    public BigDecimal getInvoiceBalance() {
        return invoiceBalance;
    }

    public void setInvoiceBalance(BigDecimal invoiceBalance) {
        this.invoiceBalance = invoiceBalance;
    }

    public String getInvoiceEmail() {
        return invoiceEmail;
    }

    public void setInvoiceEmail(String invoiceEmail) {
        this.invoiceEmail = invoiceEmail == null ? null : invoiceEmail.trim();
    }

    public String getInvoiceAddressee() {
        return invoiceAddressee;
    }

    public void setInvoiceAddressee(String invoiceAddressee) {
        this.invoiceAddressee = invoiceAddressee == null ? null : invoiceAddressee.trim();
    }

    public Long getInvoceTelephone() {
        return invoceTelephone;
    }

    public void setInvoceTelephone(Long invoceTelephone) {
        this.invoceTelephone = invoceTelephone;
    }

    public String getInvoceAddress() {
        return invoceAddress;
    }

    public void setInvoceAddress(String invoceAddress) {
        this.invoceAddress = invoceAddress == null ? null : invoceAddress.trim();
    }

    public Long getInvoceId() {
        return invoceId;
    }

    public void setInvoceId(Long invoceId) {
        this.invoceId = invoceId;
    }

    public String getInvoceCashNDelivery() {
        return invoceCashNDelivery;
    }

    public void setInvoceCashNDelivery(String invoceCashNDelivery) {
        this.invoceCashNDelivery = invoceCashNDelivery == null ? null : invoceCashNDelivery.trim();
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }
}