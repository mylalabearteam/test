package com.java.pill;

import com.java.model.PillInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PillInfoRepository extends JpaRepository<PillInfo, Long>, PillInfoRepositoryCustom {

    public List<PillInfo> findByImagehashesLike(String hash);

}
