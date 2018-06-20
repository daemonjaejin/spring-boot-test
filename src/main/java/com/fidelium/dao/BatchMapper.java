package com.fidelium.dao;

import com.fidelium.domain.TradeHistory;
import com.fidelium.domain.TradeHistoryBatch;
import com.fidelium.domain.UserTradeHistory;
import com.fidelium.model.WriterSO;

import java.util.List;

/**
 * Created by Administrator on 2017-11-09.
 */
public interface BatchMapper {

    public List<WriterSO> selectWriterList();

    public List<UserTradeHistory> selectUserTradeHistoryBatch();

    public List<TradeHistoryBatch> selectTradeHistoryBatch();

    public int updateUserTradeHistory(UserTradeHistory userTradeHistory);

    public int updateTradeHistory(TradeHistory tradeHistory);

    public int deleteUserTradeHistoryBatch(UserTradeHistory userTradeHistory);

    public int deleteTradeHistoryBatch(TradeHistory tradeHistory);

    public int insertUserTradeHistory(UserTradeHistory userTradeHistory);

    public int insertUserTradeHistoryBatch(UserTradeHistory userTradeHistory);

    public int insertTradeHistory(TradeHistory tradeHistory);

    public int insertTradeHistoryBatch(TradeHistory tradeHistory);

}
