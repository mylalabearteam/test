package com.java.pill;

import com.java.model.PillInfo;

import java.util.List;

public interface PillInfoRepositoryCustom {

    public List<PillInfo> findMyPill();

//    public PillInfo findByPi_image_hash(String hash);
}
