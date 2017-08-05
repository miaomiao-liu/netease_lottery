package cn.edu.swpu.cins.netease_lottery.typehandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 对象中的数据类型和数据库中的表字段类型的转换
 * Created by miaomiao on 17-7-29.
 */

@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(List.class)
public class StringArrayTypeHandler extends BaseTypeHandler<List<Integer>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Integer> parameter, JdbcType jdbcType) throws SQLException {
        try {
            ps.setString(i, listToVarchar(parameter));
        } catch (IOException e) {
            throw new SQLException("Fail to convert Integer list to json.");
        }
    }

    @Override
    public List<Integer> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        try {
            return varcharToList(rs.getString(columnIndex), new TypeReference<List<Integer>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            throw new SQLException("Fail to convert json to Integer list.");
        }
    }

    @Override
    public List<Integer> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        try {
            return varcharToList(cs.getString(columnIndex), new TypeReference<List<Integer>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            throw new SQLException("Fail to convert json to Integer list.");
        }
    }

    @Override
    public List<Integer> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        try {
            return varcharToList(rs.getString(columnName), new TypeReference<List<Integer>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            throw new SQLException("Fail to convert json to Integer list.");
        }
    }

    public List<Integer> varcharToList(String rules, TypeReference<List<Integer>> typeReference) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(rules, typeReference);
    }

    public String listToVarchar(List<Integer> list) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(list);

        //避免插入规则过长引起的错误
        if (result.length() > 255) {
            throw new IOException();
        }

        return result;
    }
}
