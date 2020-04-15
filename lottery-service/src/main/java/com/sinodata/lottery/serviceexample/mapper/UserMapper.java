package com.sinodata.lottery.serviceexample.mapper;



import com.sinodata.lottery.serviceexample.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;


public interface UserMapper  extends BaseMapper<User>{

    @Select("SELECT * FROM user WHERE name = #{name}")
    User queryByName(@Param("name") String name);

}
