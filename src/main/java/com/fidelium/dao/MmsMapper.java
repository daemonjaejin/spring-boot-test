package com.fidelium.dao;

import com.fidelium.domain.Message.MmsAuthToken;
import com.fidelium.domain.Message.MmsSendVO;
import com.fidelium.domain.TradeHistory;
import com.fidelium.domain.TradeHistoryBatch;
import com.fidelium.domain.UserTradeHistory;
import com.fidelium.model.WriterSO;

import java.util.List;

/**
 * Created by Administrator on 2017-11-09.
 */
public interface MmsMapper {

    public MmsAuthToken mmsAuthTokenInfo();

    public int updateInsertAuth(MmsAuthToken mmsAuthToken);

    public int insertMmsSendResult(MmsSendVO mmsSendVO);

    public MmsSendVO selectMmsSendInfo(MmsSendVO mmsSendVO);

}
