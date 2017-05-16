package cn.mldn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import cn.mldn.vo.News;

public interface INewsDAO {
	@Insert("INSERT INTO news(title,note) VALUES (#{title},#{note})")
	@SelectKey(before = false, keyProperty = "nid", resultType = java.lang.Long.class, statement = "SELECT LAST_INSERT_ID()")
	public boolean doCreate(News vo);
	@Select("SELECT nid,title,note FROM news WHERE ${column} LIKE #{keyWord} LIMIT #{start},#{lineSize}")
	public List<News> findAllSplit(
			@Param("start") Long start, 
			@Param("lineSize") Integer lineSize,
			@Param("column") String column, 
			@Param("keyWord") String keyWord);
}
