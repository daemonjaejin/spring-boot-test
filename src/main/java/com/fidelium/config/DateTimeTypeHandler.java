package com.fidelium.config;

import org.apache.ibatis.type.BaseTypeHandler;
import org.joda.time.DateTime;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2017-11-15.
 */
public class DateTimeTypeHandler extends BaseTypeHandler<DateTime> {

    public void setNonNullParameter(java.sql.PreparedStatement preparedStatement, int i, DateTime t, org.apache.ibatis.type.JdbcType jdbcType) throws java.sql.SQLException{
        preparedStatement.setTimestamp(i, new Timestamp(t.getMillis()));
    }

    public DateTime getNullableResult(java.sql.ResultSet resultSet, java.lang.String s) throws java.sql.SQLException{
        return toDateTime(resultSet.getTimestamp(s));
    }

    public DateTime getNullableResult(java.sql.ResultSet resultSet, int i) throws java.sql.SQLException{
        return toDateTime(resultSet.getTimestamp(i));
    }

    public DateTime getNullableResult(java.sql.CallableStatement callableStatement, int i) throws java.sql.SQLException{
        return toDateTime(callableStatement.getTimestamp(i));
    }

    private DateTime toDateTime(Timestamp timestamp){
        if(timestamp == null){
            return null;
        }else{
            return new DateTime(timestamp.getTime());
        }
    }

}
