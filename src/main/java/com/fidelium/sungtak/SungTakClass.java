package com.fidelium.sungtak;

public class SungTakClass {
//	테스트 서버
//
//	curl -X POST https://api.blockcypher.com/v1/bcy/test/addrs?token=74834163424a4265838c91b5614ba2fb
//
//	//지갑조회 
//	 curl https://api.blockcypher.com/v1/bcy/test/wallets?token=74834163424a4265838c91b5614ba2fb
//
//	//지갑생성
//	1. curl-d'{"name":"hst1"}'  https://api.blockcypher.com/v1/bcy/test/wallets?token=74834163424a4265838c91b5614ba2fb
//	2. curl -X POST https://api.blockcypher.com/v1/bcy/test/wallets/{전에 만들었던 지갑명}/addresses/generate?token=74834163424a4265838c91b5614ba2fb
//	//테스트서버 코인생성
//	curl -d '{"address": "Bxoxn9ohzR8tCdiCfj31pacRs3h1521oHZ", "amount": 100000}' https://api.blockcypher.com/v1/bcy/test/faucet?token=74834163424a4265838c91b5614ba2fb
//
//	//잔액조회
//	curl hhttps://api.blockcypher.com/v1/bcy/test/addrs/1DEP8i3QJCsomS4BSMY2RpU1upv62aGvhD/balance
//
//	테스트 서버 이체
//	curl -d '{"inputs":[{"addresses": ["Bxoxn9ohzR8tCdiCfj31pacRs3h1521oHZ"]}],"outputs":[{"addresses": ["CB4XmbFj8fUUQVo1n8EcycjeM6EYPEmj3Z"], "value": 1000000}]}' https://api.blockcypher.com/v1/bcy/test/txs/new
//
//	트랜젝션확인
//
//
//	테스트서버 지갑정보
//
//	"token": "74834163424a4265838c91b5614ba2fb",
//	  "name": "hst_1",
//	  "addresses": [
//	    "Bxoxn9ohzR8tCdiCfj31pacRs3h1521oHZ"
//	  ],
//	  "private": "8b98102466f7a2e3e4b21b607b3100d84ed55b164a5d6e3e80bd409e5bbd7e79",
//	  "public": "03d133e0a6d463c41bdd5e8026cf45e42967ccd818c89d84fef749eab989ccac69",
//	  "address": "Bxoxn9ohzR8tCdiCfj31pacRs3h1521oHZ",
//
//
//
//	"token": "74834163424a4265838c91b5614ba2fb",
//	  "name": "hst_2",
//	  "addresses": [
//	    "CB4XmbFj8fUUQVo1n8EcycjeM6EYPEmj3Z"
//	  ],
//	  "private": "944b5fb950d73bbd01e579f9352e467f0aba6965235d012810c329f6cf0f0598",
//	  "public": "0354a1ff4f015b25f0a5dfc1e2abd12e1383066b5c4fa680c0026b851944b9b664",
//	  "address": "CB4XmbFj8fUUQVo1n8EcycjeM6EYPEmj3Z",
//	  "wif": "BtJJ7DWcqSuUoSLht67GgyMUFpCR51VAMAYWAr2MjRrb3gChn6Pv"
}
