package com.fidelium.service;

import com.fidelium.dao.CoinInfoMapper;
import com.fidelium.domain.CoinInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class BlockCypherService {
	@Autowired
	private CoinInfoMapper coinInfoMapper;

	public int createWallet(CoinInfo record) {
		return this.coinInfoMapper.insert(record);
	}

}
