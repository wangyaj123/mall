package com.office.mall.entiy;

public class Shop {

    private Integer id;

    private String account;


    private String password;


    private String shopName;


    private String companyName;


    private String companyAddress;


    private String linkmanName;


    private String linkmanPhone;


    private String licenseNumber;


    private String legalman;


    private String legalmanId;


    private String bankName;

    private String bankCount;


    private String description;

    private Long registerTime;
    private Integer status;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }


    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }


    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }


    public String getLinkmanName() {
        return linkmanName;
    }


    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName == null ? null : linkmanName.trim();
    }

    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone == null ? null : linkmanPhone.trim();
    }


    public String getLicenseNumber() {
        return licenseNumber;
    }


    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber == null ? null : licenseNumber.trim();
    }

    public String getLegalman() {
        return legalman;
    }


    public void setLegalman(String legalman) {
        this.legalman = legalman == null ? null : legalman.trim();
    }

    public String getLegalmanId() {
        return legalmanId;
    }

    public void setLegalmanId(String legalmanId) {
        this.legalmanId = legalmanId == null ? null : legalmanId.trim();
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }


    public String getBankCount() {
        return bankCount;
    }

    public void setBankCount(String bankCount) {
        this.bankCount = bankCount == null ? null : bankCount.trim();
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}