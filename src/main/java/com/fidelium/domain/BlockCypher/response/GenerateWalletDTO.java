package com.fidelium.domain.BlockCypher.response;

import com.fidelium.domain.BlockCypher.BlockCypherResponse;

public class GenerateWalletDTO extends BlockCypherResponse{
	private String token;
	private String name;
	private String[] address;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getAddress() {
		return address;
	}
	public void setAddress(String[] address) {
		this.address = address;
	}
	
}
