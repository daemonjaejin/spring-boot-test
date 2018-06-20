package com.fidelium.proto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017-11-24.
 */

@Configuration
@ConfigurationProperties(prefix = "common.crypto")
public class CryptoProperties {

    private String [] coinList;

    public String[] getCoinList() {
        return coinList;
    }

    public void setCoinList(String[] coinList) {
        this.coinList = coinList;
    }
}
