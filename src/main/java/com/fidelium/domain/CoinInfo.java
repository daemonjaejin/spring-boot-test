package com.fidelium.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-11-16.
 */
public class CoinInfo extends Result implements Serializable {

    private static final long serialVersionUID = -8227415535035645468L;

    public CoinInfo(){

    }

    public CoinInfo(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    private String id;

    private String type;
    
    private String walletName;

    private String publicKey;

    private String privateKey;

    private String address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWalletName() {
		return walletName;
	}

	public void setWalletName(String walletName) {
		this.walletName = walletName;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
