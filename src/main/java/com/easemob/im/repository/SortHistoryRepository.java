package com.easemob.im.repository;

import com.easemob.im.model.SortHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SortHistoryRepository extends JpaRepository<SortHistory, String> {

}
