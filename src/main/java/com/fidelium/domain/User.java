package com.fidelium.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-23.
 */

public class User extends Result implements UserDetails {

    public User(){

    }

    public User(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    private String id;

    private String password;

    private String oriPassword;

    private String authPassword;

    private String otpQrKey;

    private String otpQrUrl;

    private String authOriPassword;

    private String phone;

    private String sex;

    private String birthday;

    private String delYn;

    private String walletYn;

    private String username;

    private String name;

    private String instDatetime;

    private String updtDatetime;

    private String deltDatetime;

    private String modUser;

    private String delUser;

    private boolean isAccountNonExpired;

    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;

    private boolean isEnabled;

    private String etc;

    private String region;

    private String regionYn;

    private String address;

    private String addressYn;

    private String idCard;

    private String typeYn;

    private String type;

    private String currency;

    private String fideliumWallet;

    private String otpPassword;

    private String nation;

    private String role;

    private double oneLimit;

    private double dayLimit;

    private String fileName;

    private String filePath;

    private String originFileName;

    private String webFilePath;

    private MultipartFile[] files;

    private Collection<? extends GrantedAuthority> authorities;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean isAccountNonExpired) {
        this.isAccountNonExpired = isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean isAccountNonLocked) {
        this.isAccountNonLocked = isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
        this.isCredentialsNonExpired = isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriPassword() {
        return oriPassword;
    }

    public void setOriPassword(String oriPassword) {
        this.oriPassword = oriPassword;
    }

    public String getAuthPassword() {
        return authPassword;
    }

    public void setAuthPassword(String authPassword) {
        this.authPassword = authPassword;
    }

    public String getAuthOriPassword() {
        return authOriPassword;
    }

    public void setAuthOriPassword(String authOriPassword) {
        this.authOriPassword = authOriPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    public String getInstDatetime() {
        return instDatetime;
    }

    public void setInstDatetime(String instDatetime) {
        this.instDatetime = instDatetime;
    }

    public String getUpdtDatetime() {
        return updtDatetime;
    }

    public void setUpdtDatetime(String updtDatetime) {
        this.updtDatetime = updtDatetime;
    }

    public String getDeltDatetime() {
        return deltDatetime;
    }

    public void setDeltDatetime(String deltDatetime) {
        this.deltDatetime = deltDatetime;
    }

    public String getModUser() {
        return modUser;
    }

    public void setModUser(String modUser) {
        this.modUser = modUser;
    }

    public String getDelUser() {
        return delUser;
    }

    public void setDelUser(String delUser) {
        this.delUser = delUser;
    }

    public String getWalletYn() {
        return walletYn;
    }

    public void setWalletYn(String walletYn) {
        this.walletYn = walletYn;
    }

    public String getOtpQrUrl() {
        return otpQrUrl;
    }

    public void setOtpQrUrl(String otpQrUrl) {
        this.otpQrUrl = otpQrUrl;
    }

    public String getOtpQrKey() {
        return otpQrKey;
    }

    public void setOtpQrKey(String otpQrKey) {
        this.otpQrKey = otpQrKey;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public String getRegionYn() {
        return regionYn;
    }

    public void setRegionYn(String regionYn) {
        this.regionYn = regionYn;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTypeYn() {
        return typeYn;
    }

    public void setTypeYn(String typeYn) {
        this.typeYn = typeYn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFideliumWallet() {
        return fideliumWallet;
    }

    public void setFideliumWallet(String fideliumWallet) {
        this.fideliumWallet = fideliumWallet;
    }

    public String getAddressYn() {
        return addressYn;
    }

    public void setAddressYn(String addressYn) {
        this.addressYn = addressYn;
    }

    public String getOtpPassword() {
        return otpPassword;
    }

    public void setOtpPassword(String otpPassword) {
        this.otpPassword = otpPassword;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
    }

    public String getWebFilePath() {
        return webFilePath;
    }

    public void setWebFilePath(String webFilePath) {
        this.webFilePath = webFilePath;
    }

    public double getOneLimit() {
        return oneLimit;
    }

    public void setOneLimit(double oneLimit) {
        this.oneLimit = oneLimit;
    }

    public double getDayLimit() {
        return dayLimit;
    }

    public void setDayLimit(double dayLimit) {
        this.dayLimit = dayLimit;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", oriPassword='" + oriPassword + '\'' +
                ", authPassword='" + authPassword + '\'' +
                ", otpQrKey='" + otpQrKey + '\'' +
                ", otpQrUrl='" + otpQrUrl + '\'' +
                ", authOriPassword='" + authOriPassword + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", delYn='" + delYn + '\'' +
                ", walletYn='" + walletYn + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", instDatetime='" + instDatetime + '\'' +
                ", updtDatetime='" + updtDatetime + '\'' +
                ", deltDatetime='" + deltDatetime + '\'' +
                ", modUser='" + modUser + '\'' +
                ", delUser='" + delUser + '\'' +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isCredentialsNonExpired=" + isCredentialsNonExpired +
                ", isEnabled=" + isEnabled +
                ", etc='" + etc + '\'' +
                ", region='" + region + '\'' +
                ", regionYn='" + regionYn + '\'' +
                ", address='" + address + '\'' +
                ", addressYn='" + addressYn + '\'' +
                ", idCard='" + idCard + '\'' +
                ", typeYn='" + typeYn + '\'' +
                ", type='" + type + '\'' +
                ", currency='" + currency + '\'' +
                ", fideliumWallet='" + fideliumWallet + '\'' +
                ", otpPassword='" + otpPassword + '\'' +
                ", nation='" + nation + '\'' +
                ", role='" + role + '\'' +
                ", oneLimit=" + oneLimit +
                ", dayLimit=" + dayLimit +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", originFileName='" + originFileName + '\'' +
                ", webFilePath='" + webFilePath + '\'' +
                ", files=" + Arrays.toString(files) +
                ", authorities=" + authorities +
                '}';
    }
}
