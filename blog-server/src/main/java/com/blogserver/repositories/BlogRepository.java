package com.blogserver.repositories;

import com.blogserver.model.BlogMetadata;
import com.blogserver.model.BlogRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<BlogRecord, Long> {

}
