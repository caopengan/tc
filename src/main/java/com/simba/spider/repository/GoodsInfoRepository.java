package com.simba.spider.repository;

import com.simba.spider.entity.GoodsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsInfoRepository extends JpaRepository<GoodsInfo,Long>{
    @Query(value = "insert into goods_info(goodsId,goodsName,imgUrl,goodsPrice)values(?1,?2,?3,?4)",nativeQuery = true)
    void insertJDGoods(@Param("goodsId") String goodsId,@Param("goodsName") String goodsName,@Param("imgUrl") String imgUrl,@Param("goodsPrice") Double goodsPrice);
}
