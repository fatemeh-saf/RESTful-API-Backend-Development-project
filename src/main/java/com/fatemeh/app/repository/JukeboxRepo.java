package com.fatemeh.app.repository;

import com.fatemeh.app.entity.JukeboxEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface JukeboxRepo extends PagingAndSortingRepository<JukeboxEntity, Long> {

    Page<JukeboxEntity> findByModel(String model, Pageable pageable);


}
