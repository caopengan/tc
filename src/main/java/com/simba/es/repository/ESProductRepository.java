package com.simba.es.repository;

import com.simba.es.entity.ESProductInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface ESProductRepository extends ElasticsearchCrudRepository<ESProductInfo,Long>{


}
