package com.fidelium.domain.BlockCypher.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fidelium.domain.BlockCypher.BlockCypherResponse;

public class GenerateAddrDTO extends BlockCypherResponse{
	@JsonProperty(value = "private")
	private String privateKey;
	@JsonProperty(value = "public")
	private String publicKey;
	@JsonProperty(value = "address")
	private String address;
	@JsonProperty(value = "wifi")
	private String wifi;
	public String getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWifi() {
		return wifi;
	}
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	
	
}
