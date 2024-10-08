package com.java.pill;

import com.java.model.PillResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PillResultRepository extends JpaRepository<PillResult, Long> {

    public List<PillResult> findByPiIndex(long index);
}
